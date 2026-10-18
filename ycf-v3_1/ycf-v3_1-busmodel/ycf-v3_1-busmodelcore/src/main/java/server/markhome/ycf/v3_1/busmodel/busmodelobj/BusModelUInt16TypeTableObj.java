// Description: Java 25 Table Object implementation for UInt16Type.

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

public class BusModelUInt16TypeTableObj
	implements IBusModelUInt16TypeTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelUInt16Type.CLASS_CODE;
	protected static final int backingClassCode = IBusModelUInt16Type.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> allUInt16Type;
	private Map< IBusModelValueByUNameIdxKey,
		IBusModelUInt16TypeObj > indexByUNameIdx;
	private Map< IBusModelValueByScopeIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > > indexByScopeIdx;
	private Map< IBusModelValueByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > > indexByDefSchemaIdx;
	private Map< IBusModelValueByPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > > indexByPrevIdx;
	private Map< IBusModelValueByNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > > indexByNextIdx;
	private Map< IBusModelValueByContPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > > indexByContPrevIdx;
	private Map< IBusModelValueByContNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > > indexByContNextIdx;
	private Map< IBusModelUInt16TypeBySchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > > indexBySchemaIdx;
	public static String TABLE_NAME = "UInt16Type";
	public static String TABLE_DBNAME = "uint16typ";

	public BusModelUInt16TypeTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj>();
		allUInt16Type = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexBySchemaIdx = null;
	}

	public BusModelUInt16TypeTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj>();
		allUInt16Type = null;
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
		return BusModelUInt16TypeTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelUInt16TypeTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allUInt16Type = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexBySchemaIdx = null;
		List<IBusModelUInt16TypeObj> toForget = new LinkedList<IBusModelUInt16TypeObj>();
		IBusModelUInt16TypeObj cur = null;
		Iterator<IBusModelUInt16TypeObj> iter = members.values().iterator();
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
	 *	BusModelUInt16TypeObj.
	 */
	@Override
	public IBusModelUInt16TypeObj newInstance() {
		IBusModelUInt16TypeObj inst = new BusModelUInt16TypeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelUInt16TypeObj.
	 */
	@Override
	public IBusModelUInt16TypeEditObj newEditInstance( IBusModelUInt16TypeObj orig ) {
		IBusModelUInt16TypeEditObj edit = new BusModelUInt16TypeEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelUInt16TypeObj realiseUInt16Type( IBusModelUInt16TypeObj Obj ) {
		IBusModelUInt16TypeObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelUInt16TypeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelUInt16TypeObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					indexByNextIdx.remove( keyNextIdx );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					indexByContPrevIdx.remove( keyContPrevIdx );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( indexBySchemaIdx != null ) {
				IBusModelUInt16TypeBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryUInt16Type().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
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
			keepObj = (IBusModelUInt16TypeObj)schema.getUInt16DefTableObj().realiseUInt16Def( Obj );

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
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				IBusModelUInt16TypeBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryUInt16Type().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allUInt16Type != null ) {
				allUInt16Type.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelUInt16TypeObj)schema.getUInt16DefTableObj().realiseUInt16Def( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allUInt16Type != null ) {
				allUInt16Type.put( keepObj.getPKey(), keepObj );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				IBusModelUInt16TypeBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryUInt16Type().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelUInt16TypeObj createUInt16Type( IBusModelUInt16TypeObj Obj ) {
		IBusModelUInt16TypeObj obj = Obj;
		IBusModelUInt16Type rec = obj.getUInt16TypeRec();
		schema.getBusModelBackingStore().getTableUInt16Type().createUInt16Type(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelUInt16TypeObj)(obj.realise());
		}
		IBusModelValueObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelUInt16TypeObj readUInt16Type( $implCommaIJavaOptAtomType$ pkey ) {
		return( readUInt16Type( pkey, false ) );
	}

	@Override
	public IBusModelUInt16TypeObj readUInt16Type( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelUInt16TypeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelUInt16Type readRec = schema.getBusModelBackingStore().getTableUInt16Type().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelUInt16TypeObj)schema.getValueTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelUInt16TypeObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelUInt16TypeObj readCachedUInt16Type( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelUInt16TypeObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeUInt16Type( IBusModelUInt16TypeObj obj )
	{
		final String S_ProcName = "BusModelUInt16TypeTableObj.reallyDeepDisposeUInt16Type() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelUInt16TypeObj existing = readCachedUInt16Type( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelUInt16TypeBySchemaIdxKey keySchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryUInt16Type().newBySchemaIdxKey();
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


		schema.getUInt16DefTableObj().reallyDeepDisposeUInt16Def( obj );
	}
	@Override
	public void deepDisposeUInt16Type( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelUInt16TypeObj obj = readCachedUInt16Type( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelUInt16TypeObj lockUInt16Type( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelUInt16TypeObj locked = null;
		IBusModelUInt16Type lockRec = schema.getBusModelBackingStore().getTableUInt16Type().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelUInt16TypeObj)schema.getValueTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelUInt16TypeObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockUInt16Type", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelUInt16TypeObj> readAllUInt16Type() {
		return( readAllUInt16Type( false ) );
	}

	@Override
	public List<IBusModelUInt16TypeObj> readAllUInt16Type( boolean forceRead ) {
		final String S_ProcName = "readAllUInt16Type";
		if( ( allUInt16Type == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelUInt16TypeObj>();
			allUInt16Type = map;
			IBusModelUInt16Type[] recList = schema.getBusModelBackingStore().getTableUInt16Type().readAllDerived( null );
			IBusModelUInt16Type rec;
			IBusModelUInt16TypeObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelUInt16TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelUInt16TypeObj realised = (IBusModelUInt16TypeObj)obj.realise();
			}
		}
		int len = allUInt16Type.size();
		IBusModelUInt16TypeObj arr[] = new IBusModelUInt16TypeObj[len];
		Iterator<IBusModelUInt16TypeObj> valIter = allUInt16Type.values().iterator();
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
		ArrayList<IBusModelUInt16TypeObj> arrayList = new ArrayList<IBusModelUInt16TypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelUInt16TypeObj> cmp = new Comparator<IBusModelUInt16TypeObj>() {
			@Override
			public int compare( IBusModelUInt16TypeObj lhs, IBusModelUInt16TypeObj rhs ) {
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
		List<IBusModelUInt16TypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelUInt16TypeObj> readCachedAllUInt16Type() {
		final String S_ProcName = "readCachedAllUInt16Type";
		ArrayList<IBusModelUInt16TypeObj> arrayList = new ArrayList<IBusModelUInt16TypeObj>();
		if( allUInt16Type != null ) {
			int len = allUInt16Type.size();
			IBusModelUInt16TypeObj arr[] = new IBusModelUInt16TypeObj[len];
			Iterator<IBusModelUInt16TypeObj> valIter = allUInt16Type.values().iterator();
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
		Comparator<IBusModelUInt16TypeObj> cmp = new Comparator<IBusModelUInt16TypeObj>() {
			public int compare( IBusModelUInt16TypeObj lhs, IBusModelUInt16TypeObj rhs ) {
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
	public IBusModelUInt16TypeObj readUInt16TypeByIdIdx( IYCFKeyHash256 Id )
	{
		return( readUInt16TypeByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelUInt16TypeObj readUInt16TypeByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelUInt16TypeObj obj = readUInt16Type( Id, forceRead );
		return( obj );
	}

	@Override
	public IBusModelUInt16TypeObj readUInt16TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		return( readUInt16TypeByUNameIdx( ScopeId,
			Name,
			false ) );
	}

	@Override
	public IBusModelUInt16TypeObj readUInt16TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelValueByUNameIdxKey,
				IBusModelUInt16TypeObj >();
		}
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelUInt16TypeObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelValue rec = schema.getBusModelBackingStore().getTableValue().readDerivedByUNameIdx( null,
				ScopeId,
				Name );
			if( rec != null ) {
				obj = (IBusModelUInt16TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelUInt16TypeObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelUInt16TypeObj> readUInt16TypeByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		return( readUInt16TypeByScopeIdx( ScopeId,
			false ) );
	}

	@Override
	public List<IBusModelUInt16TypeObj> readUInt16TypeByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readUInt16TypeByScopeIdx";
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelValueByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByScopeIdx( null,
				ScopeId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelUInt16TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelUInt16TypeObj realised = (IBusModelUInt16TypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelUInt16TypeObj arr[] = new IBusModelUInt16TypeObj[len];
		Iterator<IBusModelUInt16TypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelUInt16TypeObj> arrayList = new ArrayList<IBusModelUInt16TypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelUInt16TypeObj> cmp = new Comparator<IBusModelUInt16TypeObj>() {
			@Override
			public int compare( IBusModelUInt16TypeObj lhs, IBusModelUInt16TypeObj rhs ) {
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
		List<IBusModelUInt16TypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelUInt16TypeObj> readUInt16TypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readUInt16TypeByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelUInt16TypeObj> readUInt16TypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readUInt16TypeByDefSchemaIdx";
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelValueByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelUInt16TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelUInt16TypeObj realised = (IBusModelUInt16TypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelUInt16TypeObj arr[] = new IBusModelUInt16TypeObj[len];
		Iterator<IBusModelUInt16TypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelUInt16TypeObj> arrayList = new ArrayList<IBusModelUInt16TypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelUInt16TypeObj> cmp = new Comparator<IBusModelUInt16TypeObj>() {
			@Override
			public int compare( IBusModelUInt16TypeObj lhs, IBusModelUInt16TypeObj rhs ) {
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
		List<IBusModelUInt16TypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelUInt16TypeObj> readUInt16TypeByPrevIdx( IYCFKeyHash256 PrevId )
	{
		return( readUInt16TypeByPrevIdx( PrevId,
			false ) );
	}

	@Override
	public List<IBusModelUInt16TypeObj> readUInt16TypeByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readUInt16TypeByPrevIdx";
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelValueByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByPrevIdx( null,
				PrevId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelUInt16TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelUInt16TypeObj realised = (IBusModelUInt16TypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelUInt16TypeObj arr[] = new IBusModelUInt16TypeObj[len];
		Iterator<IBusModelUInt16TypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelUInt16TypeObj> arrayList = new ArrayList<IBusModelUInt16TypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelUInt16TypeObj> cmp = new Comparator<IBusModelUInt16TypeObj>() {
			@Override
			public int compare( IBusModelUInt16TypeObj lhs, IBusModelUInt16TypeObj rhs ) {
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
		List<IBusModelUInt16TypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelUInt16TypeObj> readUInt16TypeByNextIdx( IYCFKeyHash256 NextId )
	{
		return( readUInt16TypeByNextIdx( NextId,
			false ) );
	}

	@Override
	public List<IBusModelUInt16TypeObj> readUInt16TypeByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readUInt16TypeByNextIdx";
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelValueByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByNextIdx( null,
				NextId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelUInt16TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelUInt16TypeObj realised = (IBusModelUInt16TypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelUInt16TypeObj arr[] = new IBusModelUInt16TypeObj[len];
		Iterator<IBusModelUInt16TypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelUInt16TypeObj> arrayList = new ArrayList<IBusModelUInt16TypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelUInt16TypeObj> cmp = new Comparator<IBusModelUInt16TypeObj>() {
			@Override
			public int compare( IBusModelUInt16TypeObj lhs, IBusModelUInt16TypeObj rhs ) {
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
		List<IBusModelUInt16TypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelUInt16TypeObj> readUInt16TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		return( readUInt16TypeByContPrevIdx( ScopeId,
			PrevId,
			false ) );
	}

	@Override
	public List<IBusModelUInt16TypeObj> readUInt16TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readUInt16TypeByContPrevIdx";
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< IBusModelValueByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByContPrevIdx( null,
				ScopeId,
				PrevId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelUInt16TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelUInt16TypeObj realised = (IBusModelUInt16TypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelUInt16TypeObj arr[] = new IBusModelUInt16TypeObj[len];
		Iterator<IBusModelUInt16TypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelUInt16TypeObj> arrayList = new ArrayList<IBusModelUInt16TypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelUInt16TypeObj> cmp = new Comparator<IBusModelUInt16TypeObj>() {
			@Override
			public int compare( IBusModelUInt16TypeObj lhs, IBusModelUInt16TypeObj rhs ) {
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
		List<IBusModelUInt16TypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelUInt16TypeObj> readUInt16TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		return( readUInt16TypeByContNextIdx( ScopeId,
			NextId,
			false ) );
	}

	@Override
	public List<IBusModelUInt16TypeObj> readUInt16TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readUInt16TypeByContNextIdx";
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< IBusModelValueByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByContNextIdx( null,
				ScopeId,
				NextId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelUInt16TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelUInt16TypeObj realised = (IBusModelUInt16TypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelUInt16TypeObj arr[] = new IBusModelUInt16TypeObj[len];
		Iterator<IBusModelUInt16TypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelUInt16TypeObj> arrayList = new ArrayList<IBusModelUInt16TypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelUInt16TypeObj> cmp = new Comparator<IBusModelUInt16TypeObj>() {
			@Override
			public int compare( IBusModelUInt16TypeObj lhs, IBusModelUInt16TypeObj rhs ) {
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
		List<IBusModelUInt16TypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelUInt16TypeObj> readUInt16TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		return( readUInt16TypeBySchemaIdx( SchemaDefId,
			false ) );
	}

	@Override
	public List<IBusModelUInt16TypeObj> readUInt16TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId,
		boolean forceRead )
	{
		final String S_ProcName = "readUInt16TypeBySchemaIdx";
		IBusModelUInt16TypeBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryUInt16Type().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict;
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< IBusModelUInt16TypeBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > >();
		}
		if( ( ! forceRead ) && indexBySchemaIdx.containsKey( key ) ) {
			dict = indexBySchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj>();
			IBusModelUInt16TypeObj obj;
			IBusModelUInt16Type[] recList = schema.getBusModelBackingStore().getTableUInt16Type().readDerivedBySchemaIdx( null,
				SchemaDefId );
			IBusModelUInt16Type rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelUInt16TypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelUInt16TypeObj realised = (IBusModelUInt16TypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelUInt16TypeObj arr[] = new IBusModelUInt16TypeObj[len];
		Iterator<IBusModelUInt16TypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelUInt16TypeObj> arrayList = new ArrayList<IBusModelUInt16TypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelUInt16TypeObj> cmp = new Comparator<IBusModelUInt16TypeObj>() {
			@Override
			public int compare( IBusModelUInt16TypeObj lhs, IBusModelUInt16TypeObj rhs ) {
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
		List<IBusModelUInt16TypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelUInt16TypeObj readCachedUInt16TypeByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelUInt16TypeObj obj = null;
		obj = readCachedUInt16Type( Id );
		return( obj );
	}

	@Override
	public IBusModelUInt16TypeObj readCachedUInt16TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelUInt16TypeObj obj = null;
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelUInt16TypeObj> valIter = members.values().iterator();
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
			Iterator<IBusModelUInt16TypeObj> valIter = members.values().iterator();
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
	public List<IBusModelUInt16TypeObj> readCachedUInt16TypeByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "readCachedUInt16TypeByScopeIdx";
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		ArrayList<IBusModelUInt16TypeObj> arrayList = new ArrayList<IBusModelUInt16TypeObj>();
		if( indexByScopeIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict;
			if( indexByScopeIdx.containsKey( key ) ) {
				dict = indexByScopeIdx.get( key );
				int len = dict.size();
				IBusModelUInt16TypeObj arr[] = new IBusModelUInt16TypeObj[len];
				Iterator<IBusModelUInt16TypeObj> valIter = dict.values().iterator();
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
			IBusModelUInt16TypeObj obj;
			Iterator<IBusModelUInt16TypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelUInt16TypeObj> cmp = new Comparator<IBusModelUInt16TypeObj>() {
			@Override
			public int compare( IBusModelUInt16TypeObj lhs, IBusModelUInt16TypeObj rhs ) {
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
	public List<IBusModelUInt16TypeObj> readCachedUInt16TypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedUInt16TypeByDefSchemaIdx";
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelUInt16TypeObj> arrayList = new ArrayList<IBusModelUInt16TypeObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelUInt16TypeObj arr[] = new IBusModelUInt16TypeObj[len];
				Iterator<IBusModelUInt16TypeObj> valIter = dict.values().iterator();
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
			IBusModelUInt16TypeObj obj;
			Iterator<IBusModelUInt16TypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelUInt16TypeObj> cmp = new Comparator<IBusModelUInt16TypeObj>() {
			@Override
			public int compare( IBusModelUInt16TypeObj lhs, IBusModelUInt16TypeObj rhs ) {
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
	public List<IBusModelUInt16TypeObj> readCachedUInt16TypeByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedUInt16TypeByPrevIdx";
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelUInt16TypeObj> arrayList = new ArrayList<IBusModelUInt16TypeObj>();
		if( indexByPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict;
			if( indexByPrevIdx.containsKey( key ) ) {
				dict = indexByPrevIdx.get( key );
				int len = dict.size();
				IBusModelUInt16TypeObj arr[] = new IBusModelUInt16TypeObj[len];
				Iterator<IBusModelUInt16TypeObj> valIter = dict.values().iterator();
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
			IBusModelUInt16TypeObj obj;
			Iterator<IBusModelUInt16TypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelUInt16TypeObj> cmp = new Comparator<IBusModelUInt16TypeObj>() {
			@Override
			public int compare( IBusModelUInt16TypeObj lhs, IBusModelUInt16TypeObj rhs ) {
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
	public List<IBusModelUInt16TypeObj> readCachedUInt16TypeByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedUInt16TypeByNextIdx";
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelUInt16TypeObj> arrayList = new ArrayList<IBusModelUInt16TypeObj>();
		if( indexByNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict;
			if( indexByNextIdx.containsKey( key ) ) {
				dict = indexByNextIdx.get( key );
				int len = dict.size();
				IBusModelUInt16TypeObj arr[] = new IBusModelUInt16TypeObj[len];
				Iterator<IBusModelUInt16TypeObj> valIter = dict.values().iterator();
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
			IBusModelUInt16TypeObj obj;
			Iterator<IBusModelUInt16TypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelUInt16TypeObj> cmp = new Comparator<IBusModelUInt16TypeObj>() {
			@Override
			public int compare( IBusModelUInt16TypeObj lhs, IBusModelUInt16TypeObj rhs ) {
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
	public List<IBusModelUInt16TypeObj> readCachedUInt16TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedUInt16TypeByContPrevIdx";
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelUInt16TypeObj> arrayList = new ArrayList<IBusModelUInt16TypeObj>();
		if( indexByContPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict;
			if( indexByContPrevIdx.containsKey( key ) ) {
				dict = indexByContPrevIdx.get( key );
				int len = dict.size();
				IBusModelUInt16TypeObj arr[] = new IBusModelUInt16TypeObj[len];
				Iterator<IBusModelUInt16TypeObj> valIter = dict.values().iterator();
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
			IBusModelUInt16TypeObj obj;
			Iterator<IBusModelUInt16TypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelUInt16TypeObj> cmp = new Comparator<IBusModelUInt16TypeObj>() {
			@Override
			public int compare( IBusModelUInt16TypeObj lhs, IBusModelUInt16TypeObj rhs ) {
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
	public List<IBusModelUInt16TypeObj> readCachedUInt16TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedUInt16TypeByContNextIdx";
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelUInt16TypeObj> arrayList = new ArrayList<IBusModelUInt16TypeObj>();
		if( indexByContNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict;
			if( indexByContNextIdx.containsKey( key ) ) {
				dict = indexByContNextIdx.get( key );
				int len = dict.size();
				IBusModelUInt16TypeObj arr[] = new IBusModelUInt16TypeObj[len];
				Iterator<IBusModelUInt16TypeObj> valIter = dict.values().iterator();
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
			IBusModelUInt16TypeObj obj;
			Iterator<IBusModelUInt16TypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelUInt16TypeObj> cmp = new Comparator<IBusModelUInt16TypeObj>() {
			@Override
			public int compare( IBusModelUInt16TypeObj lhs, IBusModelUInt16TypeObj rhs ) {
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
	public List<IBusModelUInt16TypeObj> readCachedUInt16TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "readCachedUInt16TypeBySchemaIdx";
		IBusModelUInt16TypeBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryUInt16Type().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		ArrayList<IBusModelUInt16TypeObj> arrayList = new ArrayList<IBusModelUInt16TypeObj>();
		if( indexBySchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict;
			if( indexBySchemaIdx.containsKey( key ) ) {
				dict = indexBySchemaIdx.get( key );
				int len = dict.size();
				IBusModelUInt16TypeObj arr[] = new IBusModelUInt16TypeObj[len];
				Iterator<IBusModelUInt16TypeObj> valIter = dict.values().iterator();
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
			IBusModelUInt16TypeObj obj;
			Iterator<IBusModelUInt16TypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelUInt16TypeObj> cmp = new Comparator<IBusModelUInt16TypeObj>() {
			@Override
			public int compare( IBusModelUInt16TypeObj lhs, IBusModelUInt16TypeObj rhs ) {
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
	public void deepDisposeUInt16TypeByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelUInt16TypeObj obj = readCachedUInt16TypeByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeUInt16TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelUInt16TypeObj obj = readCachedUInt16TypeByUNameIdx( ScopeId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeUInt16TypeByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "deepDisposeUInt16TypeByScopeIdx";
		IBusModelUInt16TypeObj obj;
		List<IBusModelUInt16TypeObj> arrayList = readCachedUInt16TypeByScopeIdx( ScopeId );
		if( arrayList != null )  {
			Iterator<IBusModelUInt16TypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeUInt16TypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeUInt16TypeByDefSchemaIdx";
		IBusModelUInt16TypeObj obj;
		List<IBusModelUInt16TypeObj> arrayList = readCachedUInt16TypeByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelUInt16TypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeUInt16TypeByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeUInt16TypeByPrevIdx";
		IBusModelUInt16TypeObj obj;
		List<IBusModelUInt16TypeObj> arrayList = readCachedUInt16TypeByPrevIdx( PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelUInt16TypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeUInt16TypeByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeUInt16TypeByNextIdx";
		IBusModelUInt16TypeObj obj;
		List<IBusModelUInt16TypeObj> arrayList = readCachedUInt16TypeByNextIdx( NextId );
		if( arrayList != null )  {
			Iterator<IBusModelUInt16TypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeUInt16TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeUInt16TypeByContPrevIdx";
		IBusModelUInt16TypeObj obj;
		List<IBusModelUInt16TypeObj> arrayList = readCachedUInt16TypeByContPrevIdx( ScopeId,
				PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelUInt16TypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeUInt16TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeUInt16TypeByContNextIdx";
		IBusModelUInt16TypeObj obj;
		List<IBusModelUInt16TypeObj> arrayList = readCachedUInt16TypeByContNextIdx( ScopeId,
				NextId );
		if( arrayList != null )  {
			Iterator<IBusModelUInt16TypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeUInt16TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "deepDisposeUInt16TypeBySchemaIdx";
		IBusModelUInt16TypeObj obj;
		List<IBusModelUInt16TypeObj> arrayList = readCachedUInt16TypeBySchemaIdx( SchemaDefId );
		if( arrayList != null )  {
			Iterator<IBusModelUInt16TypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelUInt16TypeObj updateUInt16Type( IBusModelUInt16TypeObj Obj ) {
		IBusModelUInt16TypeObj obj = Obj;
		schema.getBusModelBackingStore().getTableUInt16Type().updateUInt16Type( null,
			Obj.getUInt16TypeRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getUInt16TypeTableObj().getClassCode() ) {
			obj = (IBusModelUInt16TypeObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteUInt16Type( IBusModelUInt16TypeObj Obj ) {
		IBusModelUInt16TypeObj obj = Obj;
		IBusModelValueObj prev = obj.getOptionalLookupPrev();
		IBusModelValueObj next = obj.getOptionalLookupNext();
		schema.getBusModelBackingStore().getTableUInt16Type().deleteUInt16Type( null,
			obj.getUInt16TypeRec() );
		Obj.forget();
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	@Override
	public void deleteUInt16TypeByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelUInt16TypeObj obj = readUInt16Type(Id);
		if( obj != null ) {
			IBusModelUInt16TypeEditObj editObj = (IBusModelUInt16TypeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelUInt16TypeEditObj)obj.beginEdit();
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
		deepDisposeUInt16TypeByIdIdx( Id );
	}

	@Override
	public void deleteUInt16TypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelValueByUNameIdxKey,
				IBusModelUInt16TypeObj >();
		}
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelUInt16TypeObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableUInt16Type().deleteUInt16TypeByUNameIdx( null,
				ScopeId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableUInt16Type().deleteUInt16TypeByUNameIdx( null,
				ScopeId,
				Name );
		}
		deepDisposeUInt16TypeByUNameIdx( ScopeId,
				Name );
	}

	@Override
	public void deleteUInt16TypeByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelValueByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict = indexByScopeIdx.get( key );
			schema.getBusModelBackingStore().getTableUInt16Type().deleteUInt16TypeByScopeIdx( null,
				ScopeId );
			Iterator<IBusModelUInt16TypeObj> iter = dict.values().iterator();
			IBusModelUInt16TypeObj obj;
			List<IBusModelUInt16TypeObj> toForget = new LinkedList<IBusModelUInt16TypeObj>();
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
			schema.getBusModelBackingStore().getTableUInt16Type().deleteUInt16TypeByScopeIdx( null,
				ScopeId );
		}
		deepDisposeUInt16TypeByScopeIdx( ScopeId );
	}

	@Override
	public void deleteUInt16TypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelValueByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableUInt16Type().deleteUInt16TypeByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelUInt16TypeObj> iter = dict.values().iterator();
			IBusModelUInt16TypeObj obj;
			List<IBusModelUInt16TypeObj> toForget = new LinkedList<IBusModelUInt16TypeObj>();
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
			schema.getBusModelBackingStore().getTableUInt16Type().deleteUInt16TypeByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeUInt16TypeByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteUInt16TypeByPrevIdx( IYCFKeyHash256 PrevId )
	{
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelValueByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict = indexByPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableUInt16Type().deleteUInt16TypeByPrevIdx( null,
				PrevId );
			Iterator<IBusModelUInt16TypeObj> iter = dict.values().iterator();
			IBusModelUInt16TypeObj obj;
			List<IBusModelUInt16TypeObj> toForget = new LinkedList<IBusModelUInt16TypeObj>();
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
			schema.getBusModelBackingStore().getTableUInt16Type().deleteUInt16TypeByPrevIdx( null,
				PrevId );
		}
		deepDisposeUInt16TypeByPrevIdx( PrevId );
	}

	@Override
	public void deleteUInt16TypeByNextIdx( IYCFKeyHash256 NextId )
	{
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelValueByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict = indexByNextIdx.get( key );
			schema.getBusModelBackingStore().getTableUInt16Type().deleteUInt16TypeByNextIdx( null,
				NextId );
			Iterator<IBusModelUInt16TypeObj> iter = dict.values().iterator();
			IBusModelUInt16TypeObj obj;
			List<IBusModelUInt16TypeObj> toForget = new LinkedList<IBusModelUInt16TypeObj>();
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
			schema.getBusModelBackingStore().getTableUInt16Type().deleteUInt16TypeByNextIdx( null,
				NextId );
		}
		deepDisposeUInt16TypeByNextIdx( NextId );
	}

	@Override
	public void deleteUInt16TypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< IBusModelValueByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict = indexByContPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableUInt16Type().deleteUInt16TypeByContPrevIdx( null,
				ScopeId,
				PrevId );
			Iterator<IBusModelUInt16TypeObj> iter = dict.values().iterator();
			IBusModelUInt16TypeObj obj;
			List<IBusModelUInt16TypeObj> toForget = new LinkedList<IBusModelUInt16TypeObj>();
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
			schema.getBusModelBackingStore().getTableUInt16Type().deleteUInt16TypeByContPrevIdx( null,
				ScopeId,
				PrevId );
		}
		deepDisposeUInt16TypeByContPrevIdx( ScopeId,
				PrevId );
	}

	@Override
	public void deleteUInt16TypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< IBusModelValueByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict = indexByContNextIdx.get( key );
			schema.getBusModelBackingStore().getTableUInt16Type().deleteUInt16TypeByContNextIdx( null,
				ScopeId,
				NextId );
			Iterator<IBusModelUInt16TypeObj> iter = dict.values().iterator();
			IBusModelUInt16TypeObj obj;
			List<IBusModelUInt16TypeObj> toForget = new LinkedList<IBusModelUInt16TypeObj>();
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
			schema.getBusModelBackingStore().getTableUInt16Type().deleteUInt16TypeByContNextIdx( null,
				ScopeId,
				NextId );
		}
		deepDisposeUInt16TypeByContNextIdx( ScopeId,
				NextId );
	}

	@Override
	public void deleteUInt16TypeBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		IBusModelUInt16TypeBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryUInt16Type().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< IBusModelUInt16TypeBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj > >();
		}
		if( indexBySchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelUInt16TypeObj> dict = indexBySchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableUInt16Type().deleteUInt16TypeBySchemaIdx( null,
				SchemaDefId );
			Iterator<IBusModelUInt16TypeObj> iter = dict.values().iterator();
			IBusModelUInt16TypeObj obj;
			List<IBusModelUInt16TypeObj> toForget = new LinkedList<IBusModelUInt16TypeObj>();
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
			schema.getBusModelBackingStore().getTableUInt16Type().deleteUInt16TypeBySchemaIdx( null,
				SchemaDefId );
		}
		deepDisposeUInt16TypeBySchemaIdx( SchemaDefId );
	}

	/**
	 *	Move the BusModelUInt16TypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelUInt16TypeObj refreshed cache instance.
	 */
	@Override
	public IBusModelUInt16TypeObj moveUpUInt16Type( IBusModelUInt16TypeObj Obj ) {
		IBusModelUInt16TypeObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUpUInt16Type" );
		}
		IBusModelUInt16Type rec = schema.getBusModelBackingStore().getTableUInt16Type().moveRecUp( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getUInt16TypeTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelUInt16TypeObj)obj.realise();
			IBusModelValueObj prev = obj.getOptionalLookupPrev( true );
			IBusModelValueObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				IBusModelValueObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the BusModelUInt16TypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelUInt16TypeObj refreshed cache instance.
	 */
	@Override
	public IBusModelUInt16TypeObj moveDownUInt16Type( IBusModelUInt16TypeObj Obj ) {
		IBusModelUInt16TypeObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDownUInt16Type" );
		}
		IBusModelUInt16Type rec = schema.getBusModelBackingStore().getTableUInt16Type().moveRecDown( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getUInt16TypeTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelUInt16TypeObj)obj.realise();
			IBusModelValueObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				IBusModelValueObj gprev = prev.getOptionalLookupPrev( true );
			}
			IBusModelValueObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}