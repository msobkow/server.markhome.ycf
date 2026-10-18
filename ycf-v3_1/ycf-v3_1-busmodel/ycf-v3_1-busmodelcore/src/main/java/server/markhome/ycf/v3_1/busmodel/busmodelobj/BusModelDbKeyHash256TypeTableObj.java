// Description: Java 25 Table Object implementation for DbKeyHash256Type.

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

public class BusModelDbKeyHash256TypeTableObj
	implements IBusModelDbKeyHash256TypeTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelDbKeyHash256Type.CLASS_CODE;
	protected static final int backingClassCode = IBusModelDbKeyHash256Type.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> allDbKeyHash256Type;
	private Map< IBusModelValueByUNameIdxKey,
		IBusModelDbKeyHash256TypeObj > indexByUNameIdx;
	private Map< IBusModelValueByScopeIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > > indexByScopeIdx;
	private Map< IBusModelValueByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > > indexByDefSchemaIdx;
	private Map< IBusModelValueByPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > > indexByPrevIdx;
	private Map< IBusModelValueByNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > > indexByNextIdx;
	private Map< IBusModelValueByContPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > > indexByContPrevIdx;
	private Map< IBusModelValueByContNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > > indexByContNextIdx;
	private Map< IBusModelDbKeyHash256TypeBySchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > > indexBySchemaIdx;
	public static String TABLE_NAME = "DbKeyHash256Type";
	public static String TABLE_DBNAME = "dbk256typ";

	public BusModelDbKeyHash256TypeTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj>();
		allDbKeyHash256Type = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexBySchemaIdx = null;
	}

	public BusModelDbKeyHash256TypeTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj>();
		allDbKeyHash256Type = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexBySchemaIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelDbKeyHash256TypeTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelDbKeyHash256TypeTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allDbKeyHash256Type = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexBySchemaIdx = null;
		List<IBusModelDbKeyHash256TypeObj> toForget = new LinkedList<IBusModelDbKeyHash256TypeObj>();
		IBusModelDbKeyHash256TypeObj cur = null;
		Iterator<IBusModelDbKeyHash256TypeObj> iter = members.values().iterator();
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
	 *	BusModelDbKeyHash256TypeObj.
	 */
	@Override
	public IBusModelDbKeyHash256TypeObj newInstance() {
		IBusModelDbKeyHash256TypeObj inst = new BusModelDbKeyHash256TypeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelDbKeyHash256TypeObj.
	 */
	@Override
	public IBusModelDbKeyHash256TypeEditObj newEditInstance( IBusModelDbKeyHash256TypeObj orig ) {
		IBusModelDbKeyHash256TypeEditObj edit = new BusModelDbKeyHash256TypeEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelDbKeyHash256TypeObj realiseDbKeyHash256Type( IBusModelDbKeyHash256TypeObj Obj ) {
		IBusModelDbKeyHash256TypeObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelDbKeyHash256TypeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelDbKeyHash256TypeObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				IBusModelValueByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByScopeIdx != null ) {
				IBusModelValueByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					indexByNextIdx.remove( keyNextIdx );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					indexByContPrevIdx.remove( keyContPrevIdx );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( indexBySchemaIdx != null ) {
				IBusModelDbKeyHash256TypeBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDbKeyHash256Type().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.remove( keepObj.getPKey() );
					if( mapSchemaIdx.size() <= 0 ) {
						indexBySchemaIdx.remove( keySchemaIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelDbKeyHash256TypeObj)schema.getDbKeyHash256DefTableObj().realiseDbKeyHash256Def( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				IBusModelValueByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByScopeIdx != null ) {
				IBusModelValueByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				IBusModelDbKeyHash256TypeBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDbKeyHash256Type().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allDbKeyHash256Type != null ) {
				allDbKeyHash256Type.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelDbKeyHash256TypeObj)schema.getDbKeyHash256DefTableObj().realiseDbKeyHash256Def( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allDbKeyHash256Type != null ) {
				allDbKeyHash256Type.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				IBusModelValueByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByScopeIdx != null ) {
				IBusModelValueByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				IBusModelDbKeyHash256TypeBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDbKeyHash256Type().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelDbKeyHash256TypeObj createDbKeyHash256Type( IBusModelDbKeyHash256TypeObj Obj ) {
		IBusModelDbKeyHash256TypeObj obj = Obj;
		IBusModelDbKeyHash256Type rec = obj.getDbKeyHash256TypeRec();
		schema.getBusModelBackingStore().getTableDbKeyHash256Type().createDbKeyHash256Type(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelDbKeyHash256TypeObj)(obj.realise());
		}
		IBusModelValueObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelDbKeyHash256TypeObj readDbKeyHash256Type( $implCommaIJavaOptAtomType$ pkey ) {
		return( readDbKeyHash256Type( pkey, false ) );
	}

	@Override
	public IBusModelDbKeyHash256TypeObj readDbKeyHash256Type( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelDbKeyHash256TypeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelDbKeyHash256Type readRec = schema.getBusModelBackingStore().getTableDbKeyHash256Type().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelDbKeyHash256TypeObj)schema.getValueTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelDbKeyHash256TypeObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelDbKeyHash256TypeObj readCachedDbKeyHash256Type( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelDbKeyHash256TypeObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeDbKeyHash256Type( IBusModelDbKeyHash256TypeObj obj )
	{
		final String S_ProcName = "BusModelDbKeyHash256TypeTableObj.reallyDeepDisposeDbKeyHash256Type() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelDbKeyHash256TypeObj existing = readCachedDbKeyHash256Type( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelDbKeyHash256TypeBySchemaIdxKey keySchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDbKeyHash256Type().newBySchemaIdxKey();
		keySchemaIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );


		schema.getTableColTableObj().deepDisposeTableColByDataIdx( existing.getRequiredId() );
		schema.getIndexColTableObj().deepDisposeIndexColByColIdx( existing.getRequiredId() );

		if( indexBySchemaIdx != null ) {
			if( indexBySchemaIdx.containsKey( keySchemaIdx ) ) {
				indexBySchemaIdx.get( keySchemaIdx ).remove( pkey );
				if( indexBySchemaIdx.get( keySchemaIdx ).size() <= 0 ) {
					indexBySchemaIdx.remove( keySchemaIdx );
				}
			}
		}


		schema.getDbKeyHash256DefTableObj().reallyDeepDisposeDbKeyHash256Def( obj );
	}
	@Override
	public void deepDisposeDbKeyHash256Type( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelDbKeyHash256TypeObj obj = readCachedDbKeyHash256Type( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelDbKeyHash256TypeObj lockDbKeyHash256Type( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelDbKeyHash256TypeObj locked = null;
		IBusModelDbKeyHash256Type lockRec = schema.getBusModelBackingStore().getTableDbKeyHash256Type().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelDbKeyHash256TypeObj)schema.getValueTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelDbKeyHash256TypeObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockDbKeyHash256Type", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelDbKeyHash256TypeObj> readAllDbKeyHash256Type() {
		return( readAllDbKeyHash256Type( false ) );
	}

	@Override
	public List<IBusModelDbKeyHash256TypeObj> readAllDbKeyHash256Type( boolean forceRead ) {
		final String S_ProcName = "readAllDbKeyHash256Type";
		if( ( allDbKeyHash256Type == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelDbKeyHash256TypeObj>();
			allDbKeyHash256Type = map;
			IBusModelDbKeyHash256Type[] recList = schema.getBusModelBackingStore().getTableDbKeyHash256Type().readAllDerived( null );
			IBusModelDbKeyHash256Type rec;
			IBusModelDbKeyHash256TypeObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDbKeyHash256TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDbKeyHash256TypeObj realised = (IBusModelDbKeyHash256TypeObj)obj.realise();
			}
		}
		int len = allDbKeyHash256Type.size();
		IBusModelDbKeyHash256TypeObj arr[] = new IBusModelDbKeyHash256TypeObj[len];
		Iterator<IBusModelDbKeyHash256TypeObj> valIter = allDbKeyHash256Type.values().iterator();
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
		ArrayList<IBusModelDbKeyHash256TypeObj> arrayList = new ArrayList<IBusModelDbKeyHash256TypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDbKeyHash256TypeObj> cmp = new Comparator<IBusModelDbKeyHash256TypeObj>() {
			@Override
			public int compare( IBusModelDbKeyHash256TypeObj lhs, IBusModelDbKeyHash256TypeObj rhs ) {
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
		List<IBusModelDbKeyHash256TypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDbKeyHash256TypeObj> readCachedAllDbKeyHash256Type() {
		final String S_ProcName = "readCachedAllDbKeyHash256Type";
		ArrayList<IBusModelDbKeyHash256TypeObj> arrayList = new ArrayList<IBusModelDbKeyHash256TypeObj>();
		if( allDbKeyHash256Type != null ) {
			int len = allDbKeyHash256Type.size();
			IBusModelDbKeyHash256TypeObj arr[] = new IBusModelDbKeyHash256TypeObj[len];
			Iterator<IBusModelDbKeyHash256TypeObj> valIter = allDbKeyHash256Type.values().iterator();
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
		Comparator<IBusModelDbKeyHash256TypeObj> cmp = new Comparator<IBusModelDbKeyHash256TypeObj>() {
			public int compare( IBusModelDbKeyHash256TypeObj lhs, IBusModelDbKeyHash256TypeObj rhs ) {
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
	public IBusModelDbKeyHash256TypeObj readDbKeyHash256TypeByIdIdx( IYCFKeyHash256 Id )
	{
		return( readDbKeyHash256TypeByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelDbKeyHash256TypeObj readDbKeyHash256TypeByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelDbKeyHash256TypeObj obj = readDbKeyHash256Type( Id, forceRead );
		return( obj );
	}

	@Override
	public IBusModelDbKeyHash256TypeObj readDbKeyHash256TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		return( readDbKeyHash256TypeByUNameIdx( ScopeId,
			Name,
			false ) );
	}

	@Override
	public IBusModelDbKeyHash256TypeObj readDbKeyHash256TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelValueByUNameIdxKey,
				IBusModelDbKeyHash256TypeObj >();
		}
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelDbKeyHash256TypeObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelValue rec = schema.getBusModelBackingStore().getTableValue().readDerivedByUNameIdx( null,
				ScopeId,
				Name );
			if( rec != null ) {
				obj = (IBusModelDbKeyHash256TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelDbKeyHash256TypeObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelDbKeyHash256TypeObj> readDbKeyHash256TypeByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		return( readDbKeyHash256TypeByScopeIdx( ScopeId,
			false ) );
	}

	@Override
	public List<IBusModelDbKeyHash256TypeObj> readDbKeyHash256TypeByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readDbKeyHash256TypeByScopeIdx";
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelValueByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByScopeIdx( null,
				ScopeId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDbKeyHash256TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDbKeyHash256TypeObj realised = (IBusModelDbKeyHash256TypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDbKeyHash256TypeObj arr[] = new IBusModelDbKeyHash256TypeObj[len];
		Iterator<IBusModelDbKeyHash256TypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDbKeyHash256TypeObj> arrayList = new ArrayList<IBusModelDbKeyHash256TypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDbKeyHash256TypeObj> cmp = new Comparator<IBusModelDbKeyHash256TypeObj>() {
			@Override
			public int compare( IBusModelDbKeyHash256TypeObj lhs, IBusModelDbKeyHash256TypeObj rhs ) {
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
		List<IBusModelDbKeyHash256TypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDbKeyHash256TypeObj> readDbKeyHash256TypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readDbKeyHash256TypeByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelDbKeyHash256TypeObj> readDbKeyHash256TypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readDbKeyHash256TypeByDefSchemaIdx";
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelValueByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDbKeyHash256TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDbKeyHash256TypeObj realised = (IBusModelDbKeyHash256TypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDbKeyHash256TypeObj arr[] = new IBusModelDbKeyHash256TypeObj[len];
		Iterator<IBusModelDbKeyHash256TypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDbKeyHash256TypeObj> arrayList = new ArrayList<IBusModelDbKeyHash256TypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDbKeyHash256TypeObj> cmp = new Comparator<IBusModelDbKeyHash256TypeObj>() {
			@Override
			public int compare( IBusModelDbKeyHash256TypeObj lhs, IBusModelDbKeyHash256TypeObj rhs ) {
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
		List<IBusModelDbKeyHash256TypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDbKeyHash256TypeObj> readDbKeyHash256TypeByPrevIdx( IYCFKeyHash256 PrevId )
	{
		return( readDbKeyHash256TypeByPrevIdx( PrevId,
			false ) );
	}

	@Override
	public List<IBusModelDbKeyHash256TypeObj> readDbKeyHash256TypeByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readDbKeyHash256TypeByPrevIdx";
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelValueByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByPrevIdx( null,
				PrevId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDbKeyHash256TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDbKeyHash256TypeObj realised = (IBusModelDbKeyHash256TypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDbKeyHash256TypeObj arr[] = new IBusModelDbKeyHash256TypeObj[len];
		Iterator<IBusModelDbKeyHash256TypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDbKeyHash256TypeObj> arrayList = new ArrayList<IBusModelDbKeyHash256TypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDbKeyHash256TypeObj> cmp = new Comparator<IBusModelDbKeyHash256TypeObj>() {
			@Override
			public int compare( IBusModelDbKeyHash256TypeObj lhs, IBusModelDbKeyHash256TypeObj rhs ) {
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
		List<IBusModelDbKeyHash256TypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDbKeyHash256TypeObj> readDbKeyHash256TypeByNextIdx( IYCFKeyHash256 NextId )
	{
		return( readDbKeyHash256TypeByNextIdx( NextId,
			false ) );
	}

	@Override
	public List<IBusModelDbKeyHash256TypeObj> readDbKeyHash256TypeByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readDbKeyHash256TypeByNextIdx";
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelValueByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByNextIdx( null,
				NextId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDbKeyHash256TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDbKeyHash256TypeObj realised = (IBusModelDbKeyHash256TypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDbKeyHash256TypeObj arr[] = new IBusModelDbKeyHash256TypeObj[len];
		Iterator<IBusModelDbKeyHash256TypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDbKeyHash256TypeObj> arrayList = new ArrayList<IBusModelDbKeyHash256TypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDbKeyHash256TypeObj> cmp = new Comparator<IBusModelDbKeyHash256TypeObj>() {
			@Override
			public int compare( IBusModelDbKeyHash256TypeObj lhs, IBusModelDbKeyHash256TypeObj rhs ) {
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
		List<IBusModelDbKeyHash256TypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDbKeyHash256TypeObj> readDbKeyHash256TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		return( readDbKeyHash256TypeByContPrevIdx( ScopeId,
			PrevId,
			false ) );
	}

	@Override
	public List<IBusModelDbKeyHash256TypeObj> readDbKeyHash256TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readDbKeyHash256TypeByContPrevIdx";
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< IBusModelValueByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByContPrevIdx( null,
				ScopeId,
				PrevId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDbKeyHash256TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDbKeyHash256TypeObj realised = (IBusModelDbKeyHash256TypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDbKeyHash256TypeObj arr[] = new IBusModelDbKeyHash256TypeObj[len];
		Iterator<IBusModelDbKeyHash256TypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDbKeyHash256TypeObj> arrayList = new ArrayList<IBusModelDbKeyHash256TypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDbKeyHash256TypeObj> cmp = new Comparator<IBusModelDbKeyHash256TypeObj>() {
			@Override
			public int compare( IBusModelDbKeyHash256TypeObj lhs, IBusModelDbKeyHash256TypeObj rhs ) {
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
		List<IBusModelDbKeyHash256TypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDbKeyHash256TypeObj> readDbKeyHash256TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		return( readDbKeyHash256TypeByContNextIdx( ScopeId,
			NextId,
			false ) );
	}

	@Override
	public List<IBusModelDbKeyHash256TypeObj> readDbKeyHash256TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readDbKeyHash256TypeByContNextIdx";
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< IBusModelValueByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByContNextIdx( null,
				ScopeId,
				NextId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDbKeyHash256TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDbKeyHash256TypeObj realised = (IBusModelDbKeyHash256TypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDbKeyHash256TypeObj arr[] = new IBusModelDbKeyHash256TypeObj[len];
		Iterator<IBusModelDbKeyHash256TypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDbKeyHash256TypeObj> arrayList = new ArrayList<IBusModelDbKeyHash256TypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDbKeyHash256TypeObj> cmp = new Comparator<IBusModelDbKeyHash256TypeObj>() {
			@Override
			public int compare( IBusModelDbKeyHash256TypeObj lhs, IBusModelDbKeyHash256TypeObj rhs ) {
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
		List<IBusModelDbKeyHash256TypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDbKeyHash256TypeObj> readDbKeyHash256TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		return( readDbKeyHash256TypeBySchemaIdx( SchemaDefId,
			false ) );
	}

	@Override
	public List<IBusModelDbKeyHash256TypeObj> readDbKeyHash256TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId,
		boolean forceRead )
	{
		final String S_ProcName = "readDbKeyHash256TypeBySchemaIdx";
		IBusModelDbKeyHash256TypeBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDbKeyHash256Type().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict;
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< IBusModelDbKeyHash256TypeBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > >();
		}
		if( ( ! forceRead ) && indexBySchemaIdx.containsKey( key ) ) {
			dict = indexBySchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj>();
			IBusModelDbKeyHash256TypeObj obj;
			IBusModelDbKeyHash256Type[] recList = schema.getBusModelBackingStore().getTableDbKeyHash256Type().readDerivedBySchemaIdx( null,
				SchemaDefId );
			IBusModelDbKeyHash256Type rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDbKeyHash256TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDbKeyHash256TypeObj realised = (IBusModelDbKeyHash256TypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDbKeyHash256TypeObj arr[] = new IBusModelDbKeyHash256TypeObj[len];
		Iterator<IBusModelDbKeyHash256TypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDbKeyHash256TypeObj> arrayList = new ArrayList<IBusModelDbKeyHash256TypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDbKeyHash256TypeObj> cmp = new Comparator<IBusModelDbKeyHash256TypeObj>() {
			@Override
			public int compare( IBusModelDbKeyHash256TypeObj lhs, IBusModelDbKeyHash256TypeObj rhs ) {
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
		List<IBusModelDbKeyHash256TypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelDbKeyHash256TypeObj readCachedDbKeyHash256TypeByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelDbKeyHash256TypeObj obj = null;
		obj = readCachedDbKeyHash256Type( Id );
		return( obj );
	}

	@Override
	public IBusModelDbKeyHash256TypeObj readCachedDbKeyHash256TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelDbKeyHash256TypeObj obj = null;
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelDbKeyHash256TypeObj> valIter = members.values().iterator();
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
			Iterator<IBusModelDbKeyHash256TypeObj> valIter = members.values().iterator();
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
	public List<IBusModelDbKeyHash256TypeObj> readCachedDbKeyHash256TypeByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "readCachedDbKeyHash256TypeByScopeIdx";
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		ArrayList<IBusModelDbKeyHash256TypeObj> arrayList = new ArrayList<IBusModelDbKeyHash256TypeObj>();
		if( indexByScopeIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict;
			if( indexByScopeIdx.containsKey( key ) ) {
				dict = indexByScopeIdx.get( key );
				int len = dict.size();
				IBusModelDbKeyHash256TypeObj arr[] = new IBusModelDbKeyHash256TypeObj[len];
				Iterator<IBusModelDbKeyHash256TypeObj> valIter = dict.values().iterator();
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
			IBusModelDbKeyHash256TypeObj obj;
			Iterator<IBusModelDbKeyHash256TypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDbKeyHash256TypeObj> cmp = new Comparator<IBusModelDbKeyHash256TypeObj>() {
			@Override
			public int compare( IBusModelDbKeyHash256TypeObj lhs, IBusModelDbKeyHash256TypeObj rhs ) {
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
	public List<IBusModelDbKeyHash256TypeObj> readCachedDbKeyHash256TypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedDbKeyHash256TypeByDefSchemaIdx";
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelDbKeyHash256TypeObj> arrayList = new ArrayList<IBusModelDbKeyHash256TypeObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelDbKeyHash256TypeObj arr[] = new IBusModelDbKeyHash256TypeObj[len];
				Iterator<IBusModelDbKeyHash256TypeObj> valIter = dict.values().iterator();
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
			IBusModelDbKeyHash256TypeObj obj;
			Iterator<IBusModelDbKeyHash256TypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDbKeyHash256TypeObj> cmp = new Comparator<IBusModelDbKeyHash256TypeObj>() {
			@Override
			public int compare( IBusModelDbKeyHash256TypeObj lhs, IBusModelDbKeyHash256TypeObj rhs ) {
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
	public List<IBusModelDbKeyHash256TypeObj> readCachedDbKeyHash256TypeByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedDbKeyHash256TypeByPrevIdx";
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelDbKeyHash256TypeObj> arrayList = new ArrayList<IBusModelDbKeyHash256TypeObj>();
		if( indexByPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict;
			if( indexByPrevIdx.containsKey( key ) ) {
				dict = indexByPrevIdx.get( key );
				int len = dict.size();
				IBusModelDbKeyHash256TypeObj arr[] = new IBusModelDbKeyHash256TypeObj[len];
				Iterator<IBusModelDbKeyHash256TypeObj> valIter = dict.values().iterator();
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
			IBusModelDbKeyHash256TypeObj obj;
			Iterator<IBusModelDbKeyHash256TypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDbKeyHash256TypeObj> cmp = new Comparator<IBusModelDbKeyHash256TypeObj>() {
			@Override
			public int compare( IBusModelDbKeyHash256TypeObj lhs, IBusModelDbKeyHash256TypeObj rhs ) {
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
	public List<IBusModelDbKeyHash256TypeObj> readCachedDbKeyHash256TypeByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedDbKeyHash256TypeByNextIdx";
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelDbKeyHash256TypeObj> arrayList = new ArrayList<IBusModelDbKeyHash256TypeObj>();
		if( indexByNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict;
			if( indexByNextIdx.containsKey( key ) ) {
				dict = indexByNextIdx.get( key );
				int len = dict.size();
				IBusModelDbKeyHash256TypeObj arr[] = new IBusModelDbKeyHash256TypeObj[len];
				Iterator<IBusModelDbKeyHash256TypeObj> valIter = dict.values().iterator();
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
			IBusModelDbKeyHash256TypeObj obj;
			Iterator<IBusModelDbKeyHash256TypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDbKeyHash256TypeObj> cmp = new Comparator<IBusModelDbKeyHash256TypeObj>() {
			@Override
			public int compare( IBusModelDbKeyHash256TypeObj lhs, IBusModelDbKeyHash256TypeObj rhs ) {
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
	public List<IBusModelDbKeyHash256TypeObj> readCachedDbKeyHash256TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedDbKeyHash256TypeByContPrevIdx";
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelDbKeyHash256TypeObj> arrayList = new ArrayList<IBusModelDbKeyHash256TypeObj>();
		if( indexByContPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict;
			if( indexByContPrevIdx.containsKey( key ) ) {
				dict = indexByContPrevIdx.get( key );
				int len = dict.size();
				IBusModelDbKeyHash256TypeObj arr[] = new IBusModelDbKeyHash256TypeObj[len];
				Iterator<IBusModelDbKeyHash256TypeObj> valIter = dict.values().iterator();
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
			IBusModelDbKeyHash256TypeObj obj;
			Iterator<IBusModelDbKeyHash256TypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDbKeyHash256TypeObj> cmp = new Comparator<IBusModelDbKeyHash256TypeObj>() {
			@Override
			public int compare( IBusModelDbKeyHash256TypeObj lhs, IBusModelDbKeyHash256TypeObj rhs ) {
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
	public List<IBusModelDbKeyHash256TypeObj> readCachedDbKeyHash256TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedDbKeyHash256TypeByContNextIdx";
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelDbKeyHash256TypeObj> arrayList = new ArrayList<IBusModelDbKeyHash256TypeObj>();
		if( indexByContNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict;
			if( indexByContNextIdx.containsKey( key ) ) {
				dict = indexByContNextIdx.get( key );
				int len = dict.size();
				IBusModelDbKeyHash256TypeObj arr[] = new IBusModelDbKeyHash256TypeObj[len];
				Iterator<IBusModelDbKeyHash256TypeObj> valIter = dict.values().iterator();
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
			IBusModelDbKeyHash256TypeObj obj;
			Iterator<IBusModelDbKeyHash256TypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDbKeyHash256TypeObj> cmp = new Comparator<IBusModelDbKeyHash256TypeObj>() {
			@Override
			public int compare( IBusModelDbKeyHash256TypeObj lhs, IBusModelDbKeyHash256TypeObj rhs ) {
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
	public List<IBusModelDbKeyHash256TypeObj> readCachedDbKeyHash256TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "readCachedDbKeyHash256TypeBySchemaIdx";
		IBusModelDbKeyHash256TypeBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDbKeyHash256Type().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		ArrayList<IBusModelDbKeyHash256TypeObj> arrayList = new ArrayList<IBusModelDbKeyHash256TypeObj>();
		if( indexBySchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict;
			if( indexBySchemaIdx.containsKey( key ) ) {
				dict = indexBySchemaIdx.get( key );
				int len = dict.size();
				IBusModelDbKeyHash256TypeObj arr[] = new IBusModelDbKeyHash256TypeObj[len];
				Iterator<IBusModelDbKeyHash256TypeObj> valIter = dict.values().iterator();
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
			IBusModelDbKeyHash256TypeObj obj;
			Iterator<IBusModelDbKeyHash256TypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDbKeyHash256TypeObj> cmp = new Comparator<IBusModelDbKeyHash256TypeObj>() {
			@Override
			public int compare( IBusModelDbKeyHash256TypeObj lhs, IBusModelDbKeyHash256TypeObj rhs ) {
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
	public void deepDisposeDbKeyHash256TypeByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelDbKeyHash256TypeObj obj = readCachedDbKeyHash256TypeByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeDbKeyHash256TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelDbKeyHash256TypeObj obj = readCachedDbKeyHash256TypeByUNameIdx( ScopeId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeDbKeyHash256TypeByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "deepDisposeDbKeyHash256TypeByScopeIdx";
		IBusModelDbKeyHash256TypeObj obj;
		List<IBusModelDbKeyHash256TypeObj> arrayList = readCachedDbKeyHash256TypeByScopeIdx( ScopeId );
		if( arrayList != null )  {
			Iterator<IBusModelDbKeyHash256TypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDbKeyHash256TypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeDbKeyHash256TypeByDefSchemaIdx";
		IBusModelDbKeyHash256TypeObj obj;
		List<IBusModelDbKeyHash256TypeObj> arrayList = readCachedDbKeyHash256TypeByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelDbKeyHash256TypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDbKeyHash256TypeByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeDbKeyHash256TypeByPrevIdx";
		IBusModelDbKeyHash256TypeObj obj;
		List<IBusModelDbKeyHash256TypeObj> arrayList = readCachedDbKeyHash256TypeByPrevIdx( PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelDbKeyHash256TypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDbKeyHash256TypeByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeDbKeyHash256TypeByNextIdx";
		IBusModelDbKeyHash256TypeObj obj;
		List<IBusModelDbKeyHash256TypeObj> arrayList = readCachedDbKeyHash256TypeByNextIdx( NextId );
		if( arrayList != null )  {
			Iterator<IBusModelDbKeyHash256TypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDbKeyHash256TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeDbKeyHash256TypeByContPrevIdx";
		IBusModelDbKeyHash256TypeObj obj;
		List<IBusModelDbKeyHash256TypeObj> arrayList = readCachedDbKeyHash256TypeByContPrevIdx( ScopeId,
				PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelDbKeyHash256TypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDbKeyHash256TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeDbKeyHash256TypeByContNextIdx";
		IBusModelDbKeyHash256TypeObj obj;
		List<IBusModelDbKeyHash256TypeObj> arrayList = readCachedDbKeyHash256TypeByContNextIdx( ScopeId,
				NextId );
		if( arrayList != null )  {
			Iterator<IBusModelDbKeyHash256TypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDbKeyHash256TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "deepDisposeDbKeyHash256TypeBySchemaIdx";
		IBusModelDbKeyHash256TypeObj obj;
		List<IBusModelDbKeyHash256TypeObj> arrayList = readCachedDbKeyHash256TypeBySchemaIdx( SchemaDefId );
		if( arrayList != null )  {
			Iterator<IBusModelDbKeyHash256TypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelDbKeyHash256TypeObj updateDbKeyHash256Type( IBusModelDbKeyHash256TypeObj Obj ) {
		IBusModelDbKeyHash256TypeObj obj = Obj;
		schema.getBusModelBackingStore().getTableDbKeyHash256Type().updateDbKeyHash256Type( null,
			Obj.getDbKeyHash256TypeRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getDbKeyHash256TypeTableObj().getClassCode() ) {
			obj = (IBusModelDbKeyHash256TypeObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteDbKeyHash256Type( IBusModelDbKeyHash256TypeObj Obj ) {
		IBusModelDbKeyHash256TypeObj obj = Obj;
		IBusModelValueObj prev = obj.getOptionalLookupPrev();
		IBusModelValueObj next = obj.getOptionalLookupNext();
		schema.getBusModelBackingStore().getTableDbKeyHash256Type().deleteDbKeyHash256Type( null,
			obj.getDbKeyHash256TypeRec() );
		Obj.forget();
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	@Override
	public void deleteDbKeyHash256TypeByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelDbKeyHash256TypeObj obj = readDbKeyHash256Type(Id);
		if( obj != null ) {
			IBusModelDbKeyHash256TypeEditObj editObj = (IBusModelDbKeyHash256TypeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelDbKeyHash256TypeEditObj)obj.beginEdit();
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
		deepDisposeDbKeyHash256TypeByIdIdx( Id );
	}

	@Override
	public void deleteDbKeyHash256TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelValueByUNameIdxKey,
				IBusModelDbKeyHash256TypeObj >();
		}
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelDbKeyHash256TypeObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableDbKeyHash256Type().deleteDbKeyHash256TypeByUNameIdx( null,
				ScopeId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableDbKeyHash256Type().deleteDbKeyHash256TypeByUNameIdx( null,
				ScopeId,
				Name );
		}
		deepDisposeDbKeyHash256TypeByUNameIdx( ScopeId,
				Name );
	}

	@Override
	public void deleteDbKeyHash256TypeByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelValueByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict = indexByScopeIdx.get( key );
			schema.getBusModelBackingStore().getTableDbKeyHash256Type().deleteDbKeyHash256TypeByScopeIdx( null,
				ScopeId );
			Iterator<IBusModelDbKeyHash256TypeObj> iter = dict.values().iterator();
			IBusModelDbKeyHash256TypeObj obj;
			List<IBusModelDbKeyHash256TypeObj> toForget = new LinkedList<IBusModelDbKeyHash256TypeObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByScopeIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableDbKeyHash256Type().deleteDbKeyHash256TypeByScopeIdx( null,
				ScopeId );
		}
		deepDisposeDbKeyHash256TypeByScopeIdx( ScopeId );
	}

	@Override
	public void deleteDbKeyHash256TypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelValueByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableDbKeyHash256Type().deleteDbKeyHash256TypeByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelDbKeyHash256TypeObj> iter = dict.values().iterator();
			IBusModelDbKeyHash256TypeObj obj;
			List<IBusModelDbKeyHash256TypeObj> toForget = new LinkedList<IBusModelDbKeyHash256TypeObj>();
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
			schema.getBusModelBackingStore().getTableDbKeyHash256Type().deleteDbKeyHash256TypeByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeDbKeyHash256TypeByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteDbKeyHash256TypeByPrevIdx( IYCFKeyHash256 PrevId )
	{
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelValueByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict = indexByPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableDbKeyHash256Type().deleteDbKeyHash256TypeByPrevIdx( null,
				PrevId );
			Iterator<IBusModelDbKeyHash256TypeObj> iter = dict.values().iterator();
			IBusModelDbKeyHash256TypeObj obj;
			List<IBusModelDbKeyHash256TypeObj> toForget = new LinkedList<IBusModelDbKeyHash256TypeObj>();
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
			schema.getBusModelBackingStore().getTableDbKeyHash256Type().deleteDbKeyHash256TypeByPrevIdx( null,
				PrevId );
		}
		deepDisposeDbKeyHash256TypeByPrevIdx( PrevId );
	}

	@Override
	public void deleteDbKeyHash256TypeByNextIdx( IYCFKeyHash256 NextId )
	{
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelValueByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict = indexByNextIdx.get( key );
			schema.getBusModelBackingStore().getTableDbKeyHash256Type().deleteDbKeyHash256TypeByNextIdx( null,
				NextId );
			Iterator<IBusModelDbKeyHash256TypeObj> iter = dict.values().iterator();
			IBusModelDbKeyHash256TypeObj obj;
			List<IBusModelDbKeyHash256TypeObj> toForget = new LinkedList<IBusModelDbKeyHash256TypeObj>();
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
			schema.getBusModelBackingStore().getTableDbKeyHash256Type().deleteDbKeyHash256TypeByNextIdx( null,
				NextId );
		}
		deepDisposeDbKeyHash256TypeByNextIdx( NextId );
	}

	@Override
	public void deleteDbKeyHash256TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< IBusModelValueByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict = indexByContPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableDbKeyHash256Type().deleteDbKeyHash256TypeByContPrevIdx( null,
				ScopeId,
				PrevId );
			Iterator<IBusModelDbKeyHash256TypeObj> iter = dict.values().iterator();
			IBusModelDbKeyHash256TypeObj obj;
			List<IBusModelDbKeyHash256TypeObj> toForget = new LinkedList<IBusModelDbKeyHash256TypeObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByContPrevIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableDbKeyHash256Type().deleteDbKeyHash256TypeByContPrevIdx( null,
				ScopeId,
				PrevId );
		}
		deepDisposeDbKeyHash256TypeByContPrevIdx( ScopeId,
				PrevId );
	}

	@Override
	public void deleteDbKeyHash256TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< IBusModelValueByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict = indexByContNextIdx.get( key );
			schema.getBusModelBackingStore().getTableDbKeyHash256Type().deleteDbKeyHash256TypeByContNextIdx( null,
				ScopeId,
				NextId );
			Iterator<IBusModelDbKeyHash256TypeObj> iter = dict.values().iterator();
			IBusModelDbKeyHash256TypeObj obj;
			List<IBusModelDbKeyHash256TypeObj> toForget = new LinkedList<IBusModelDbKeyHash256TypeObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByContNextIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableDbKeyHash256Type().deleteDbKeyHash256TypeByContNextIdx( null,
				ScopeId,
				NextId );
		}
		deepDisposeDbKeyHash256TypeByContNextIdx( ScopeId,
				NextId );
	}

	@Override
	public void deleteDbKeyHash256TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		IBusModelDbKeyHash256TypeBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDbKeyHash256Type().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< IBusModelDbKeyHash256TypeBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj > >();
		}
		if( indexBySchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDbKeyHash256TypeObj> dict = indexBySchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableDbKeyHash256Type().deleteDbKeyHash256TypeBySchemaIdx( null,
				SchemaDefId );
			Iterator<IBusModelDbKeyHash256TypeObj> iter = dict.values().iterator();
			IBusModelDbKeyHash256TypeObj obj;
			List<IBusModelDbKeyHash256TypeObj> toForget = new LinkedList<IBusModelDbKeyHash256TypeObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexBySchemaIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableDbKeyHash256Type().deleteDbKeyHash256TypeBySchemaIdx( null,
				SchemaDefId );
		}
		deepDisposeDbKeyHash256TypeBySchemaIdx( SchemaDefId );
	}

	/**
	 *	Move the BusModelDbKeyHash256TypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelDbKeyHash256TypeObj refreshed cache instance.
	 */
	@Override
	public IBusModelDbKeyHash256TypeObj moveUpDbKeyHash256Type( IBusModelDbKeyHash256TypeObj Obj ) {
		IBusModelDbKeyHash256TypeObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUpDbKeyHash256Type" );
		}
		IBusModelDbKeyHash256Type rec = schema.getBusModelBackingStore().getTableDbKeyHash256Type().moveRecUp( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getDbKeyHash256TypeTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelDbKeyHash256TypeObj)obj.realise();
			IBusModelValueObj prev = obj.getOptionalLookupPrev( true );
			IBusModelValueObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				IBusModelValueObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the BusModelDbKeyHash256TypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelDbKeyHash256TypeObj refreshed cache instance.
	 */
	@Override
	public IBusModelDbKeyHash256TypeObj moveDownDbKeyHash256Type( IBusModelDbKeyHash256TypeObj Obj ) {
		IBusModelDbKeyHash256TypeObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDownDbKeyHash256Type" );
		}
		IBusModelDbKeyHash256Type rec = schema.getBusModelBackingStore().getTableDbKeyHash256Type().moveRecDown( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getDbKeyHash256TypeTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelDbKeyHash256TypeObj)obj.realise();
			IBusModelValueObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				IBusModelValueObj gprev = prev.getOptionalLookupPrev( true );
			}
			IBusModelValueObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}