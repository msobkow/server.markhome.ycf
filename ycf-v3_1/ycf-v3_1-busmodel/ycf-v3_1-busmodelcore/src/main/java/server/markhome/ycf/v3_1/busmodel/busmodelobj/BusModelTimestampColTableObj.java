// Description: Java 25 Table Object implementation for TimestampCol.

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

public class BusModelTimestampColTableObj
	implements IBusModelTimestampColTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelTimestampCol.CLASS_CODE;
	protected static final int backingClassCode = IBusModelTimestampCol.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> allTimestampCol;
	private Map< IBusModelValueByUNameIdxKey,
		IBusModelTimestampColObj > indexByUNameIdx;
	private Map< IBusModelValueByScopeIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > > indexByScopeIdx;
	private Map< IBusModelValueByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > > indexByDefSchemaIdx;
	private Map< IBusModelValueByPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > > indexByPrevIdx;
	private Map< IBusModelValueByNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > > indexByNextIdx;
	private Map< IBusModelValueByContPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > > indexByContPrevIdx;
	private Map< IBusModelValueByContNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > > indexByContNextIdx;
	private Map< IBusModelTimestampColByTableIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > > indexByTableIdx;
	public static String TABLE_NAME = "TimestampCol";
	public static String TABLE_DBNAME = "tscol";

	public BusModelTimestampColTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj>();
		allTimestampCol = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexByTableIdx = null;
	}

	public BusModelTimestampColTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj>();
		allTimestampCol = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexByTableIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelTimestampColTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelTimestampColTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allTimestampCol = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexByTableIdx = null;
		List<IBusModelTimestampColObj> toForget = new LinkedList<IBusModelTimestampColObj>();
		IBusModelTimestampColObj cur = null;
		Iterator<IBusModelTimestampColObj> iter = members.values().iterator();
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
	 *	BusModelTimestampColObj.
	 */
	@Override
	public IBusModelTimestampColObj newInstance() {
		IBusModelTimestampColObj inst = new BusModelTimestampColObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelTimestampColObj.
	 */
	@Override
	public IBusModelTimestampColEditObj newEditInstance( IBusModelTimestampColObj orig ) {
		IBusModelTimestampColEditObj edit = new BusModelTimestampColEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelTimestampColObj realiseTimestampCol( IBusModelTimestampColObj Obj ) {
		IBusModelTimestampColObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelTimestampColObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelTimestampColObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					indexByNextIdx.remove( keyNextIdx );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					indexByContPrevIdx.remove( keyContPrevIdx );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( indexByTableIdx != null ) {
				IBusModelTimestampColByTableIdxKey keyTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTimestampCol().newByTableIdxKey();
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.remove( keepObj.getPKey() );
					if( mapTableIdx.size() <= 0 ) {
						indexByTableIdx.remove( keyTableIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelTimestampColObj)schema.getTimestampDefTableObj().realiseTimestampDef( Obj );

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
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				IBusModelTimestampColByTableIdxKey keyTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTimestampCol().newByTableIdxKey();
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allTimestampCol != null ) {
				allTimestampCol.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelTimestampColObj)schema.getTimestampDefTableObj().realiseTimestampDef( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTimestampCol != null ) {
				allTimestampCol.put( keepObj.getPKey(), keepObj );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				IBusModelTimestampColByTableIdxKey keyTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTimestampCol().newByTableIdxKey();
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelTimestampColObj createTimestampCol( IBusModelTimestampColObj Obj ) {
		IBusModelTimestampColObj obj = Obj;
		IBusModelTimestampCol rec = obj.getTimestampColRec();
		schema.getBusModelBackingStore().getTableTimestampCol().createTimestampCol(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelTimestampColObj)(obj.realise());
		}
		IBusModelValueObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelTimestampColObj readTimestampCol( $implCommaIJavaOptAtomType$ pkey ) {
		return( readTimestampCol( pkey, false ) );
	}

	@Override
	public IBusModelTimestampColObj readTimestampCol( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelTimestampColObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelTimestampCol readRec = schema.getBusModelBackingStore().getTableTimestampCol().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelTimestampColObj)schema.getValueTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelTimestampColObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelTimestampColObj readCachedTimestampCol( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelTimestampColObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeTimestampCol( IBusModelTimestampColObj obj )
	{
		final String S_ProcName = "BusModelTimestampColTableObj.reallyDeepDisposeTimestampCol() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelTimestampColObj existing = readCachedTimestampCol( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelTimestampColByTableIdxKey keyTableIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTimestampCol().newByTableIdxKey();
		keyTableIdx.setRequiredTableId( existing.getRequiredTableId() );


		schema.getTableColTableObj().deepDisposeTableColByDataIdx( existing.getRequiredId() );
		schema.getIndexColTableObj().deepDisposeIndexColByColIdx( existing.getRequiredId() );

		if( indexByTableIdx != null ) {
			if( indexByTableIdx.containsKey( keyTableIdx ) ) {
				indexByTableIdx.get( keyTableIdx ).remove( pkey );
				if( indexByTableIdx.get( keyTableIdx ).size() <= 0 ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}
		}


		schema.getTimestampDefTableObj().reallyDeepDisposeTimestampDef( obj );
	}
	@Override
	public void deepDisposeTimestampCol( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelTimestampColObj obj = readCachedTimestampCol( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelTimestampColObj lockTimestampCol( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelTimestampColObj locked = null;
		IBusModelTimestampCol lockRec = schema.getBusModelBackingStore().getTableTimestampCol().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelTimestampColObj)schema.getValueTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelTimestampColObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockTimestampCol", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelTimestampColObj> readAllTimestampCol() {
		return( readAllTimestampCol( false ) );
	}

	@Override
	public List<IBusModelTimestampColObj> readAllTimestampCol( boolean forceRead ) {
		final String S_ProcName = "readAllTimestampCol";
		if( ( allTimestampCol == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelTimestampColObj>();
			allTimestampCol = map;
			IBusModelTimestampCol[] recList = schema.getBusModelBackingStore().getTableTimestampCol().readAllDerived( null );
			IBusModelTimestampCol rec;
			IBusModelTimestampColObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTimestampColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTimestampColObj realised = (IBusModelTimestampColObj)obj.realise();
			}
		}
		int len = allTimestampCol.size();
		IBusModelTimestampColObj arr[] = new IBusModelTimestampColObj[len];
		Iterator<IBusModelTimestampColObj> valIter = allTimestampCol.values().iterator();
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
		ArrayList<IBusModelTimestampColObj> arrayList = new ArrayList<IBusModelTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTimestampColObj> cmp = new Comparator<IBusModelTimestampColObj>() {
			@Override
			public int compare( IBusModelTimestampColObj lhs, IBusModelTimestampColObj rhs ) {
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
		List<IBusModelTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTimestampColObj> readCachedAllTimestampCol() {
		final String S_ProcName = "readCachedAllTimestampCol";
		ArrayList<IBusModelTimestampColObj> arrayList = new ArrayList<IBusModelTimestampColObj>();
		if( allTimestampCol != null ) {
			int len = allTimestampCol.size();
			IBusModelTimestampColObj arr[] = new IBusModelTimestampColObj[len];
			Iterator<IBusModelTimestampColObj> valIter = allTimestampCol.values().iterator();
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
		Comparator<IBusModelTimestampColObj> cmp = new Comparator<IBusModelTimestampColObj>() {
			public int compare( IBusModelTimestampColObj lhs, IBusModelTimestampColObj rhs ) {
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
	public IBusModelTimestampColObj readTimestampColByIdIdx( IYCFKeyHash256 Id )
	{
		return( readTimestampColByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelTimestampColObj readTimestampColByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelTimestampColObj obj = readTimestampCol( Id, forceRead );
		return( obj );
	}

	@Override
	public IBusModelTimestampColObj readTimestampColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		return( readTimestampColByUNameIdx( ScopeId,
			Name,
			false ) );
	}

	@Override
	public IBusModelTimestampColObj readTimestampColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelValueByUNameIdxKey,
				IBusModelTimestampColObj >();
		}
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelTimestampColObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelValue rec = schema.getBusModelBackingStore().getTableValue().readDerivedByUNameIdx( null,
				ScopeId,
				Name );
			if( rec != null ) {
				obj = (IBusModelTimestampColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelTimestampColObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelTimestampColObj> readTimestampColByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		return( readTimestampColByScopeIdx( ScopeId,
			false ) );
	}

	@Override
	public List<IBusModelTimestampColObj> readTimestampColByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readTimestampColByScopeIdx";
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelValueByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByScopeIdx( null,
				ScopeId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTimestampColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTimestampColObj realised = (IBusModelTimestampColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTimestampColObj arr[] = new IBusModelTimestampColObj[len];
		Iterator<IBusModelTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTimestampColObj> arrayList = new ArrayList<IBusModelTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTimestampColObj> cmp = new Comparator<IBusModelTimestampColObj>() {
			@Override
			public int compare( IBusModelTimestampColObj lhs, IBusModelTimestampColObj rhs ) {
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
		List<IBusModelTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTimestampColObj> readTimestampColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readTimestampColByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelTimestampColObj> readTimestampColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readTimestampColByDefSchemaIdx";
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelValueByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTimestampColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTimestampColObj realised = (IBusModelTimestampColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTimestampColObj arr[] = new IBusModelTimestampColObj[len];
		Iterator<IBusModelTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTimestampColObj> arrayList = new ArrayList<IBusModelTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTimestampColObj> cmp = new Comparator<IBusModelTimestampColObj>() {
			@Override
			public int compare( IBusModelTimestampColObj lhs, IBusModelTimestampColObj rhs ) {
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
		List<IBusModelTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTimestampColObj> readTimestampColByPrevIdx( IYCFKeyHash256 PrevId )
	{
		return( readTimestampColByPrevIdx( PrevId,
			false ) );
	}

	@Override
	public List<IBusModelTimestampColObj> readTimestampColByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readTimestampColByPrevIdx";
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelValueByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByPrevIdx( null,
				PrevId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTimestampColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTimestampColObj realised = (IBusModelTimestampColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTimestampColObj arr[] = new IBusModelTimestampColObj[len];
		Iterator<IBusModelTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTimestampColObj> arrayList = new ArrayList<IBusModelTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTimestampColObj> cmp = new Comparator<IBusModelTimestampColObj>() {
			@Override
			public int compare( IBusModelTimestampColObj lhs, IBusModelTimestampColObj rhs ) {
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
		List<IBusModelTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTimestampColObj> readTimestampColByNextIdx( IYCFKeyHash256 NextId )
	{
		return( readTimestampColByNextIdx( NextId,
			false ) );
	}

	@Override
	public List<IBusModelTimestampColObj> readTimestampColByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readTimestampColByNextIdx";
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelValueByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByNextIdx( null,
				NextId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTimestampColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTimestampColObj realised = (IBusModelTimestampColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTimestampColObj arr[] = new IBusModelTimestampColObj[len];
		Iterator<IBusModelTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTimestampColObj> arrayList = new ArrayList<IBusModelTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTimestampColObj> cmp = new Comparator<IBusModelTimestampColObj>() {
			@Override
			public int compare( IBusModelTimestampColObj lhs, IBusModelTimestampColObj rhs ) {
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
		List<IBusModelTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTimestampColObj> readTimestampColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		return( readTimestampColByContPrevIdx( ScopeId,
			PrevId,
			false ) );
	}

	@Override
	public List<IBusModelTimestampColObj> readTimestampColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readTimestampColByContPrevIdx";
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< IBusModelValueByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByContPrevIdx( null,
				ScopeId,
				PrevId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTimestampColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTimestampColObj realised = (IBusModelTimestampColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTimestampColObj arr[] = new IBusModelTimestampColObj[len];
		Iterator<IBusModelTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTimestampColObj> arrayList = new ArrayList<IBusModelTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTimestampColObj> cmp = new Comparator<IBusModelTimestampColObj>() {
			@Override
			public int compare( IBusModelTimestampColObj lhs, IBusModelTimestampColObj rhs ) {
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
		List<IBusModelTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTimestampColObj> readTimestampColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		return( readTimestampColByContNextIdx( ScopeId,
			NextId,
			false ) );
	}

	@Override
	public List<IBusModelTimestampColObj> readTimestampColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readTimestampColByContNextIdx";
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< IBusModelValueByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByContNextIdx( null,
				ScopeId,
				NextId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTimestampColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTimestampColObj realised = (IBusModelTimestampColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTimestampColObj arr[] = new IBusModelTimestampColObj[len];
		Iterator<IBusModelTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTimestampColObj> arrayList = new ArrayList<IBusModelTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTimestampColObj> cmp = new Comparator<IBusModelTimestampColObj>() {
			@Override
			public int compare( IBusModelTimestampColObj lhs, IBusModelTimestampColObj rhs ) {
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
		List<IBusModelTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTimestampColObj> readTimestampColByTableIdx( IYCFKeyHash256 TableId )
	{
		return( readTimestampColByTableIdx( TableId,
			false ) );
	}

	@Override
	public List<IBusModelTimestampColObj> readTimestampColByTableIdx( IYCFKeyHash256 TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readTimestampColByTableIdx";
		IBusModelTimestampColByTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTimestampCol().newByTableIdxKey();
		key.setRequiredTableId( TableId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< IBusModelTimestampColByTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTimestampColObj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj>();
			IBusModelTimestampColObj obj;
			IBusModelTimestampCol[] recList = schema.getBusModelBackingStore().getTableTimestampCol().readDerivedByTableIdx( null,
				TableId );
			IBusModelTimestampCol rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTimestampColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTimestampColObj realised = (IBusModelTimestampColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTableIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTimestampColObj arr[] = new IBusModelTimestampColObj[len];
		Iterator<IBusModelTimestampColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTimestampColObj> arrayList = new ArrayList<IBusModelTimestampColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTimestampColObj> cmp = new Comparator<IBusModelTimestampColObj>() {
			@Override
			public int compare( IBusModelTimestampColObj lhs, IBusModelTimestampColObj rhs ) {
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
		List<IBusModelTimestampColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelTimestampColObj readCachedTimestampColByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelTimestampColObj obj = null;
		obj = readCachedTimestampCol( Id );
		return( obj );
	}

	@Override
	public IBusModelTimestampColObj readCachedTimestampColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelTimestampColObj obj = null;
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelTimestampColObj> valIter = members.values().iterator();
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
			Iterator<IBusModelTimestampColObj> valIter = members.values().iterator();
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
	public List<IBusModelTimestampColObj> readCachedTimestampColByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "readCachedTimestampColByScopeIdx";
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		ArrayList<IBusModelTimestampColObj> arrayList = new ArrayList<IBusModelTimestampColObj>();
		if( indexByScopeIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict;
			if( indexByScopeIdx.containsKey( key ) ) {
				dict = indexByScopeIdx.get( key );
				int len = dict.size();
				IBusModelTimestampColObj arr[] = new IBusModelTimestampColObj[len];
				Iterator<IBusModelTimestampColObj> valIter = dict.values().iterator();
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
			IBusModelTimestampColObj obj;
			Iterator<IBusModelTimestampColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTimestampColObj> cmp = new Comparator<IBusModelTimestampColObj>() {
			@Override
			public int compare( IBusModelTimestampColObj lhs, IBusModelTimestampColObj rhs ) {
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
	public List<IBusModelTimestampColObj> readCachedTimestampColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedTimestampColByDefSchemaIdx";
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelTimestampColObj> arrayList = new ArrayList<IBusModelTimestampColObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelTimestampColObj arr[] = new IBusModelTimestampColObj[len];
				Iterator<IBusModelTimestampColObj> valIter = dict.values().iterator();
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
			IBusModelTimestampColObj obj;
			Iterator<IBusModelTimestampColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTimestampColObj> cmp = new Comparator<IBusModelTimestampColObj>() {
			@Override
			public int compare( IBusModelTimestampColObj lhs, IBusModelTimestampColObj rhs ) {
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
	public List<IBusModelTimestampColObj> readCachedTimestampColByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedTimestampColByPrevIdx";
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelTimestampColObj> arrayList = new ArrayList<IBusModelTimestampColObj>();
		if( indexByPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict;
			if( indexByPrevIdx.containsKey( key ) ) {
				dict = indexByPrevIdx.get( key );
				int len = dict.size();
				IBusModelTimestampColObj arr[] = new IBusModelTimestampColObj[len];
				Iterator<IBusModelTimestampColObj> valIter = dict.values().iterator();
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
			IBusModelTimestampColObj obj;
			Iterator<IBusModelTimestampColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTimestampColObj> cmp = new Comparator<IBusModelTimestampColObj>() {
			@Override
			public int compare( IBusModelTimestampColObj lhs, IBusModelTimestampColObj rhs ) {
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
	public List<IBusModelTimestampColObj> readCachedTimestampColByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedTimestampColByNextIdx";
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelTimestampColObj> arrayList = new ArrayList<IBusModelTimestampColObj>();
		if( indexByNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict;
			if( indexByNextIdx.containsKey( key ) ) {
				dict = indexByNextIdx.get( key );
				int len = dict.size();
				IBusModelTimestampColObj arr[] = new IBusModelTimestampColObj[len];
				Iterator<IBusModelTimestampColObj> valIter = dict.values().iterator();
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
			IBusModelTimestampColObj obj;
			Iterator<IBusModelTimestampColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTimestampColObj> cmp = new Comparator<IBusModelTimestampColObj>() {
			@Override
			public int compare( IBusModelTimestampColObj lhs, IBusModelTimestampColObj rhs ) {
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
	public List<IBusModelTimestampColObj> readCachedTimestampColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedTimestampColByContPrevIdx";
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelTimestampColObj> arrayList = new ArrayList<IBusModelTimestampColObj>();
		if( indexByContPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict;
			if( indexByContPrevIdx.containsKey( key ) ) {
				dict = indexByContPrevIdx.get( key );
				int len = dict.size();
				IBusModelTimestampColObj arr[] = new IBusModelTimestampColObj[len];
				Iterator<IBusModelTimestampColObj> valIter = dict.values().iterator();
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
			IBusModelTimestampColObj obj;
			Iterator<IBusModelTimestampColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTimestampColObj> cmp = new Comparator<IBusModelTimestampColObj>() {
			@Override
			public int compare( IBusModelTimestampColObj lhs, IBusModelTimestampColObj rhs ) {
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
	public List<IBusModelTimestampColObj> readCachedTimestampColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedTimestampColByContNextIdx";
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelTimestampColObj> arrayList = new ArrayList<IBusModelTimestampColObj>();
		if( indexByContNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict;
			if( indexByContNextIdx.containsKey( key ) ) {
				dict = indexByContNextIdx.get( key );
				int len = dict.size();
				IBusModelTimestampColObj arr[] = new IBusModelTimestampColObj[len];
				Iterator<IBusModelTimestampColObj> valIter = dict.values().iterator();
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
			IBusModelTimestampColObj obj;
			Iterator<IBusModelTimestampColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTimestampColObj> cmp = new Comparator<IBusModelTimestampColObj>() {
			@Override
			public int compare( IBusModelTimestampColObj lhs, IBusModelTimestampColObj rhs ) {
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
	public List<IBusModelTimestampColObj> readCachedTimestampColByTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "readCachedTimestampColByTableIdx";
		IBusModelTimestampColByTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTimestampCol().newByTableIdxKey();
		key.setRequiredTableId( TableId );
		ArrayList<IBusModelTimestampColObj> arrayList = new ArrayList<IBusModelTimestampColObj>();
		if( indexByTableIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict;
			if( indexByTableIdx.containsKey( key ) ) {
				dict = indexByTableIdx.get( key );
				int len = dict.size();
				IBusModelTimestampColObj arr[] = new IBusModelTimestampColObj[len];
				Iterator<IBusModelTimestampColObj> valIter = dict.values().iterator();
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
			IBusModelTimestampColObj obj;
			Iterator<IBusModelTimestampColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTimestampColObj> cmp = new Comparator<IBusModelTimestampColObj>() {
			@Override
			public int compare( IBusModelTimestampColObj lhs, IBusModelTimestampColObj rhs ) {
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
	public void deepDisposeTimestampColByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelTimestampColObj obj = readCachedTimestampColByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTimestampColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelTimestampColObj obj = readCachedTimestampColByUNameIdx( ScopeId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTimestampColByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "deepDisposeTimestampColByScopeIdx";
		IBusModelTimestampColObj obj;
		List<IBusModelTimestampColObj> arrayList = readCachedTimestampColByScopeIdx( ScopeId );
		if( arrayList != null )  {
			Iterator<IBusModelTimestampColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTimestampColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeTimestampColByDefSchemaIdx";
		IBusModelTimestampColObj obj;
		List<IBusModelTimestampColObj> arrayList = readCachedTimestampColByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelTimestampColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTimestampColByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeTimestampColByPrevIdx";
		IBusModelTimestampColObj obj;
		List<IBusModelTimestampColObj> arrayList = readCachedTimestampColByPrevIdx( PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelTimestampColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTimestampColByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeTimestampColByNextIdx";
		IBusModelTimestampColObj obj;
		List<IBusModelTimestampColObj> arrayList = readCachedTimestampColByNextIdx( NextId );
		if( arrayList != null )  {
			Iterator<IBusModelTimestampColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTimestampColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeTimestampColByContPrevIdx";
		IBusModelTimestampColObj obj;
		List<IBusModelTimestampColObj> arrayList = readCachedTimestampColByContPrevIdx( ScopeId,
				PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelTimestampColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTimestampColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeTimestampColByContNextIdx";
		IBusModelTimestampColObj obj;
		List<IBusModelTimestampColObj> arrayList = readCachedTimestampColByContNextIdx( ScopeId,
				NextId );
		if( arrayList != null )  {
			Iterator<IBusModelTimestampColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTimestampColByTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "deepDisposeTimestampColByTableIdx";
		IBusModelTimestampColObj obj;
		List<IBusModelTimestampColObj> arrayList = readCachedTimestampColByTableIdx( TableId );
		if( arrayList != null )  {
			Iterator<IBusModelTimestampColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelTimestampColObj updateTimestampCol( IBusModelTimestampColObj Obj ) {
		IBusModelTimestampColObj obj = Obj;
		schema.getBusModelBackingStore().getTableTimestampCol().updateTimestampCol( null,
			Obj.getTimestampColRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getTimestampColTableObj().getClassCode() ) {
			obj = (IBusModelTimestampColObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteTimestampCol( IBusModelTimestampColObj Obj ) {
		IBusModelTimestampColObj obj = Obj;
		IBusModelValueObj prev = obj.getOptionalLookupPrev();
		IBusModelValueObj next = obj.getOptionalLookupNext();
		schema.getBusModelBackingStore().getTableTimestampCol().deleteTimestampCol( null,
			obj.getTimestampColRec() );
		Obj.forget();
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	@Override
	public void deleteTimestampColByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelTimestampColObj obj = readTimestampCol(Id);
		if( obj != null ) {
			IBusModelTimestampColEditObj editObj = (IBusModelTimestampColEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelTimestampColEditObj)obj.beginEdit();
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
		deepDisposeTimestampColByIdIdx( Id );
	}

	@Override
	public void deleteTimestampColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelValueByUNameIdxKey,
				IBusModelTimestampColObj >();
		}
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelTimestampColObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableTimestampCol().deleteTimestampColByUNameIdx( null,
				ScopeId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableTimestampCol().deleteTimestampColByUNameIdx( null,
				ScopeId,
				Name );
		}
		deepDisposeTimestampColByUNameIdx( ScopeId,
				Name );
	}

	@Override
	public void deleteTimestampColByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelValueByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTimestampColObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict = indexByScopeIdx.get( key );
			schema.getBusModelBackingStore().getTableTimestampCol().deleteTimestampColByScopeIdx( null,
				ScopeId );
			Iterator<IBusModelTimestampColObj> iter = dict.values().iterator();
			IBusModelTimestampColObj obj;
			List<IBusModelTimestampColObj> toForget = new LinkedList<IBusModelTimestampColObj>();
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
			schema.getBusModelBackingStore().getTableTimestampCol().deleteTimestampColByScopeIdx( null,
				ScopeId );
		}
		deepDisposeTimestampColByScopeIdx( ScopeId );
	}

	@Override
	public void deleteTimestampColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelValueByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTimestampColObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableTimestampCol().deleteTimestampColByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelTimestampColObj> iter = dict.values().iterator();
			IBusModelTimestampColObj obj;
			List<IBusModelTimestampColObj> toForget = new LinkedList<IBusModelTimestampColObj>();
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
			schema.getBusModelBackingStore().getTableTimestampCol().deleteTimestampColByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeTimestampColByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteTimestampColByPrevIdx( IYCFKeyHash256 PrevId )
	{
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelValueByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTimestampColObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict = indexByPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableTimestampCol().deleteTimestampColByPrevIdx( null,
				PrevId );
			Iterator<IBusModelTimestampColObj> iter = dict.values().iterator();
			IBusModelTimestampColObj obj;
			List<IBusModelTimestampColObj> toForget = new LinkedList<IBusModelTimestampColObj>();
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
			schema.getBusModelBackingStore().getTableTimestampCol().deleteTimestampColByPrevIdx( null,
				PrevId );
		}
		deepDisposeTimestampColByPrevIdx( PrevId );
	}

	@Override
	public void deleteTimestampColByNextIdx( IYCFKeyHash256 NextId )
	{
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelValueByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTimestampColObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict = indexByNextIdx.get( key );
			schema.getBusModelBackingStore().getTableTimestampCol().deleteTimestampColByNextIdx( null,
				NextId );
			Iterator<IBusModelTimestampColObj> iter = dict.values().iterator();
			IBusModelTimestampColObj obj;
			List<IBusModelTimestampColObj> toForget = new LinkedList<IBusModelTimestampColObj>();
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
			schema.getBusModelBackingStore().getTableTimestampCol().deleteTimestampColByNextIdx( null,
				NextId );
		}
		deepDisposeTimestampColByNextIdx( NextId );
	}

	@Override
	public void deleteTimestampColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< IBusModelValueByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTimestampColObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict = indexByContPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableTimestampCol().deleteTimestampColByContPrevIdx( null,
				ScopeId,
				PrevId );
			Iterator<IBusModelTimestampColObj> iter = dict.values().iterator();
			IBusModelTimestampColObj obj;
			List<IBusModelTimestampColObj> toForget = new LinkedList<IBusModelTimestampColObj>();
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
			schema.getBusModelBackingStore().getTableTimestampCol().deleteTimestampColByContPrevIdx( null,
				ScopeId,
				PrevId );
		}
		deepDisposeTimestampColByContPrevIdx( ScopeId,
				PrevId );
	}

	@Override
	public void deleteTimestampColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< IBusModelValueByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTimestampColObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict = indexByContNextIdx.get( key );
			schema.getBusModelBackingStore().getTableTimestampCol().deleteTimestampColByContNextIdx( null,
				ScopeId,
				NextId );
			Iterator<IBusModelTimestampColObj> iter = dict.values().iterator();
			IBusModelTimestampColObj obj;
			List<IBusModelTimestampColObj> toForget = new LinkedList<IBusModelTimestampColObj>();
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
			schema.getBusModelBackingStore().getTableTimestampCol().deleteTimestampColByContNextIdx( null,
				ScopeId,
				NextId );
		}
		deepDisposeTimestampColByContNextIdx( ScopeId,
				NextId );
	}

	@Override
	public void deleteTimestampColByTableIdx( IYCFKeyHash256 TableId )
	{
		IBusModelTimestampColByTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTimestampCol().newByTableIdxKey();
		key.setRequiredTableId( TableId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< IBusModelTimestampColByTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTimestampColObj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTimestampColObj> dict = indexByTableIdx.get( key );
			schema.getBusModelBackingStore().getTableTimestampCol().deleteTimestampColByTableIdx( null,
				TableId );
			Iterator<IBusModelTimestampColObj> iter = dict.values().iterator();
			IBusModelTimestampColObj obj;
			List<IBusModelTimestampColObj> toForget = new LinkedList<IBusModelTimestampColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByTableIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableTimestampCol().deleteTimestampColByTableIdx( null,
				TableId );
		}
		deepDisposeTimestampColByTableIdx( TableId );
	}

	/**
	 *	Move the BusModelTimestampColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelTimestampColObj refreshed cache instance.
	 */
	@Override
	public IBusModelTimestampColObj moveUpTimestampCol( IBusModelTimestampColObj Obj ) {
		IBusModelTimestampColObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUpTimestampCol" );
		}
		IBusModelTimestampCol rec = schema.getBusModelBackingStore().getTableTimestampCol().moveRecUp( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getTimestampColTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelTimestampColObj)obj.realise();
			IBusModelValueObj prev = obj.getOptionalLookupPrev( true );
			IBusModelValueObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				IBusModelValueObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the BusModelTimestampColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelTimestampColObj refreshed cache instance.
	 */
	@Override
	public IBusModelTimestampColObj moveDownTimestampCol( IBusModelTimestampColObj Obj ) {
		IBusModelTimestampColObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDownTimestampCol" );
		}
		IBusModelTimestampCol rec = schema.getBusModelBackingStore().getTableTimestampCol().moveRecDown( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getTimestampColTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelTimestampColObj)obj.realise();
			IBusModelValueObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				IBusModelValueObj gprev = prev.getOptionalLookupPrev( true );
			}
			IBusModelValueObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}