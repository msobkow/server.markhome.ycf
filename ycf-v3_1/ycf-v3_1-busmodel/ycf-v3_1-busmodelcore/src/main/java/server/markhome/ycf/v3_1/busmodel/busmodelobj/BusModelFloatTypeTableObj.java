// Description: Java 25 Table Object implementation for FloatType.

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

public class BusModelFloatTypeTableObj
	implements IBusModelFloatTypeTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelFloatType.CLASS_CODE;
	protected static final int backingClassCode = IBusModelFloatType.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> allFloatType;
	private Map< IBusModelValueByUNameIdxKey,
		IBusModelFloatTypeObj > indexByUNameIdx;
	private Map< IBusModelValueByScopeIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > > indexByScopeIdx;
	private Map< IBusModelValueByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > > indexByDefSchemaIdx;
	private Map< IBusModelValueByPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > > indexByPrevIdx;
	private Map< IBusModelValueByNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > > indexByNextIdx;
	private Map< IBusModelValueByContPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > > indexByContPrevIdx;
	private Map< IBusModelValueByContNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > > indexByContNextIdx;
	private Map< IBusModelFloatTypeBySchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > > indexBySchemaIdx;
	public static String TABLE_NAME = "FloatType";
	public static String TABLE_DBNAME = "flttyp";

	public BusModelFloatTypeTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj>();
		allFloatType = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexBySchemaIdx = null;
	}

	public BusModelFloatTypeTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj>();
		allFloatType = null;
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
		return BusModelFloatTypeTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelFloatTypeTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allFloatType = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexBySchemaIdx = null;
		List<IBusModelFloatTypeObj> toForget = new LinkedList<IBusModelFloatTypeObj>();
		IBusModelFloatTypeObj cur = null;
		Iterator<IBusModelFloatTypeObj> iter = members.values().iterator();
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
	 *	BusModelFloatTypeObj.
	 */
	@Override
	public IBusModelFloatTypeObj newInstance() {
		IBusModelFloatTypeObj inst = new BusModelFloatTypeObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelFloatTypeObj.
	 */
	@Override
	public IBusModelFloatTypeEditObj newEditInstance( IBusModelFloatTypeObj orig ) {
		IBusModelFloatTypeEditObj edit = new BusModelFloatTypeEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelFloatTypeObj realiseFloatType( IBusModelFloatTypeObj Obj ) {
		IBusModelFloatTypeObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelFloatTypeObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelFloatTypeObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					indexByNextIdx.remove( keyNextIdx );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					indexByContPrevIdx.remove( keyContPrevIdx );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( indexBySchemaIdx != null ) {
				IBusModelFloatTypeBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryFloatType().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
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
			keepObj = (IBusModelFloatTypeObj)schema.getFloatDefTableObj().realiseFloatDef( Obj );

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
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				IBusModelFloatTypeBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryFloatType().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allFloatType != null ) {
				allFloatType.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelFloatTypeObj)schema.getFloatDefTableObj().realiseFloatDef( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allFloatType != null ) {
				allFloatType.put( keepObj.getPKey(), keepObj );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				IBusModelFloatTypeBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryFloatType().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelFloatTypeObj createFloatType( IBusModelFloatTypeObj Obj ) {
		IBusModelFloatTypeObj obj = Obj;
		IBusModelFloatType rec = obj.getFloatTypeRec();
		schema.getBusModelBackingStore().getTableFloatType().createFloatType(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelFloatTypeObj)(obj.realise());
		}
		IBusModelValueObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelFloatTypeObj readFloatType( $implCommaIJavaOptAtomType$ pkey ) {
		return( readFloatType( pkey, false ) );
	}

	@Override
	public IBusModelFloatTypeObj readFloatType( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelFloatTypeObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelFloatType readRec = schema.getBusModelBackingStore().getTableFloatType().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelFloatTypeObj)schema.getValueTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelFloatTypeObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelFloatTypeObj readCachedFloatType( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelFloatTypeObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeFloatType( IBusModelFloatTypeObj obj )
	{
		final String S_ProcName = "BusModelFloatTypeTableObj.reallyDeepDisposeFloatType() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelFloatTypeObj existing = readCachedFloatType( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelFloatTypeBySchemaIdxKey keySchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryFloatType().newBySchemaIdxKey();
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


		schema.getFloatDefTableObj().reallyDeepDisposeFloatDef( obj );
	}
	@Override
	public void deepDisposeFloatType( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelFloatTypeObj obj = readCachedFloatType( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelFloatTypeObj lockFloatType( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelFloatTypeObj locked = null;
		IBusModelFloatType lockRec = schema.getBusModelBackingStore().getTableFloatType().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelFloatTypeObj)schema.getValueTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelFloatTypeObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockFloatType", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelFloatTypeObj> readAllFloatType() {
		return( readAllFloatType( false ) );
	}

	@Override
	public List<IBusModelFloatTypeObj> readAllFloatType( boolean forceRead ) {
		final String S_ProcName = "readAllFloatType";
		if( ( allFloatType == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelFloatTypeObj>();
			allFloatType = map;
			IBusModelFloatType[] recList = schema.getBusModelBackingStore().getTableFloatType().readAllDerived( null );
			IBusModelFloatType rec;
			IBusModelFloatTypeObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelFloatTypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelFloatTypeObj realised = (IBusModelFloatTypeObj)obj.realise();
			}
		}
		int len = allFloatType.size();
		IBusModelFloatTypeObj arr[] = new IBusModelFloatTypeObj[len];
		Iterator<IBusModelFloatTypeObj> valIter = allFloatType.values().iterator();
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
		ArrayList<IBusModelFloatTypeObj> arrayList = new ArrayList<IBusModelFloatTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelFloatTypeObj> cmp = new Comparator<IBusModelFloatTypeObj>() {
			@Override
			public int compare( IBusModelFloatTypeObj lhs, IBusModelFloatTypeObj rhs ) {
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
		List<IBusModelFloatTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelFloatTypeObj> readCachedAllFloatType() {
		final String S_ProcName = "readCachedAllFloatType";
		ArrayList<IBusModelFloatTypeObj> arrayList = new ArrayList<IBusModelFloatTypeObj>();
		if( allFloatType != null ) {
			int len = allFloatType.size();
			IBusModelFloatTypeObj arr[] = new IBusModelFloatTypeObj[len];
			Iterator<IBusModelFloatTypeObj> valIter = allFloatType.values().iterator();
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
		Comparator<IBusModelFloatTypeObj> cmp = new Comparator<IBusModelFloatTypeObj>() {
			public int compare( IBusModelFloatTypeObj lhs, IBusModelFloatTypeObj rhs ) {
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
	public IBusModelFloatTypeObj readFloatTypeByIdIdx( IYCFKeyHash256 Id )
	{
		return( readFloatTypeByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelFloatTypeObj readFloatTypeByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelFloatTypeObj obj = readFloatType( Id, forceRead );
		return( obj );
	}

	@Override
	public IBusModelFloatTypeObj readFloatTypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		return( readFloatTypeByUNameIdx( ScopeId,
			Name,
			false ) );
	}

	@Override
	public IBusModelFloatTypeObj readFloatTypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelValueByUNameIdxKey,
				IBusModelFloatTypeObj >();
		}
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelFloatTypeObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelValue rec = schema.getBusModelBackingStore().getTableValue().readDerivedByUNameIdx( null,
				ScopeId,
				Name );
			if( rec != null ) {
				obj = (IBusModelFloatTypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelFloatTypeObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelFloatTypeObj> readFloatTypeByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		return( readFloatTypeByScopeIdx( ScopeId,
			false ) );
	}

	@Override
	public List<IBusModelFloatTypeObj> readFloatTypeByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readFloatTypeByScopeIdx";
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelValueByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByScopeIdx( null,
				ScopeId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelFloatTypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelFloatTypeObj realised = (IBusModelFloatTypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelFloatTypeObj arr[] = new IBusModelFloatTypeObj[len];
		Iterator<IBusModelFloatTypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelFloatTypeObj> arrayList = new ArrayList<IBusModelFloatTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelFloatTypeObj> cmp = new Comparator<IBusModelFloatTypeObj>() {
			@Override
			public int compare( IBusModelFloatTypeObj lhs, IBusModelFloatTypeObj rhs ) {
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
		List<IBusModelFloatTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelFloatTypeObj> readFloatTypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readFloatTypeByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelFloatTypeObj> readFloatTypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readFloatTypeByDefSchemaIdx";
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelValueByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelFloatTypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelFloatTypeObj realised = (IBusModelFloatTypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelFloatTypeObj arr[] = new IBusModelFloatTypeObj[len];
		Iterator<IBusModelFloatTypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelFloatTypeObj> arrayList = new ArrayList<IBusModelFloatTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelFloatTypeObj> cmp = new Comparator<IBusModelFloatTypeObj>() {
			@Override
			public int compare( IBusModelFloatTypeObj lhs, IBusModelFloatTypeObj rhs ) {
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
		List<IBusModelFloatTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelFloatTypeObj> readFloatTypeByPrevIdx( IYCFKeyHash256 PrevId )
	{
		return( readFloatTypeByPrevIdx( PrevId,
			false ) );
	}

	@Override
	public List<IBusModelFloatTypeObj> readFloatTypeByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readFloatTypeByPrevIdx";
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelValueByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByPrevIdx( null,
				PrevId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelFloatTypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelFloatTypeObj realised = (IBusModelFloatTypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelFloatTypeObj arr[] = new IBusModelFloatTypeObj[len];
		Iterator<IBusModelFloatTypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelFloatTypeObj> arrayList = new ArrayList<IBusModelFloatTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelFloatTypeObj> cmp = new Comparator<IBusModelFloatTypeObj>() {
			@Override
			public int compare( IBusModelFloatTypeObj lhs, IBusModelFloatTypeObj rhs ) {
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
		List<IBusModelFloatTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelFloatTypeObj> readFloatTypeByNextIdx( IYCFKeyHash256 NextId )
	{
		return( readFloatTypeByNextIdx( NextId,
			false ) );
	}

	@Override
	public List<IBusModelFloatTypeObj> readFloatTypeByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readFloatTypeByNextIdx";
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelValueByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByNextIdx( null,
				NextId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelFloatTypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelFloatTypeObj realised = (IBusModelFloatTypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelFloatTypeObj arr[] = new IBusModelFloatTypeObj[len];
		Iterator<IBusModelFloatTypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelFloatTypeObj> arrayList = new ArrayList<IBusModelFloatTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelFloatTypeObj> cmp = new Comparator<IBusModelFloatTypeObj>() {
			@Override
			public int compare( IBusModelFloatTypeObj lhs, IBusModelFloatTypeObj rhs ) {
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
		List<IBusModelFloatTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelFloatTypeObj> readFloatTypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		return( readFloatTypeByContPrevIdx( ScopeId,
			PrevId,
			false ) );
	}

	@Override
	public List<IBusModelFloatTypeObj> readFloatTypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readFloatTypeByContPrevIdx";
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< IBusModelValueByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByContPrevIdx( null,
				ScopeId,
				PrevId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelFloatTypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelFloatTypeObj realised = (IBusModelFloatTypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelFloatTypeObj arr[] = new IBusModelFloatTypeObj[len];
		Iterator<IBusModelFloatTypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelFloatTypeObj> arrayList = new ArrayList<IBusModelFloatTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelFloatTypeObj> cmp = new Comparator<IBusModelFloatTypeObj>() {
			@Override
			public int compare( IBusModelFloatTypeObj lhs, IBusModelFloatTypeObj rhs ) {
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
		List<IBusModelFloatTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelFloatTypeObj> readFloatTypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		return( readFloatTypeByContNextIdx( ScopeId,
			NextId,
			false ) );
	}

	@Override
	public List<IBusModelFloatTypeObj> readFloatTypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readFloatTypeByContNextIdx";
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< IBusModelValueByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByContNextIdx( null,
				ScopeId,
				NextId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelFloatTypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelFloatTypeObj realised = (IBusModelFloatTypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelFloatTypeObj arr[] = new IBusModelFloatTypeObj[len];
		Iterator<IBusModelFloatTypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelFloatTypeObj> arrayList = new ArrayList<IBusModelFloatTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelFloatTypeObj> cmp = new Comparator<IBusModelFloatTypeObj>() {
			@Override
			public int compare( IBusModelFloatTypeObj lhs, IBusModelFloatTypeObj rhs ) {
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
		List<IBusModelFloatTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelFloatTypeObj> readFloatTypeBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		return( readFloatTypeBySchemaIdx( SchemaDefId,
			false ) );
	}

	@Override
	public List<IBusModelFloatTypeObj> readFloatTypeBySchemaIdx( IYCFKeyHash256 SchemaDefId,
		boolean forceRead )
	{
		final String S_ProcName = "readFloatTypeBySchemaIdx";
		IBusModelFloatTypeBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryFloatType().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict;
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< IBusModelFloatTypeBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > >();
		}
		if( ( ! forceRead ) && indexBySchemaIdx.containsKey( key ) ) {
			dict = indexBySchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj>();
			IBusModelFloatTypeObj obj;
			IBusModelFloatType[] recList = schema.getBusModelBackingStore().getTableFloatType().readDerivedBySchemaIdx( null,
				SchemaDefId );
			IBusModelFloatType rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelFloatTypeObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelFloatTypeObj realised = (IBusModelFloatTypeObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelFloatTypeObj arr[] = new IBusModelFloatTypeObj[len];
		Iterator<IBusModelFloatTypeObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelFloatTypeObj> arrayList = new ArrayList<IBusModelFloatTypeObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelFloatTypeObj> cmp = new Comparator<IBusModelFloatTypeObj>() {
			@Override
			public int compare( IBusModelFloatTypeObj lhs, IBusModelFloatTypeObj rhs ) {
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
		List<IBusModelFloatTypeObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelFloatTypeObj readCachedFloatTypeByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelFloatTypeObj obj = null;
		obj = readCachedFloatType( Id );
		return( obj );
	}

	@Override
	public IBusModelFloatTypeObj readCachedFloatTypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelFloatTypeObj obj = null;
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelFloatTypeObj> valIter = members.values().iterator();
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
			Iterator<IBusModelFloatTypeObj> valIter = members.values().iterator();
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
	public List<IBusModelFloatTypeObj> readCachedFloatTypeByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "readCachedFloatTypeByScopeIdx";
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		ArrayList<IBusModelFloatTypeObj> arrayList = new ArrayList<IBusModelFloatTypeObj>();
		if( indexByScopeIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict;
			if( indexByScopeIdx.containsKey( key ) ) {
				dict = indexByScopeIdx.get( key );
				int len = dict.size();
				IBusModelFloatTypeObj arr[] = new IBusModelFloatTypeObj[len];
				Iterator<IBusModelFloatTypeObj> valIter = dict.values().iterator();
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
			IBusModelFloatTypeObj obj;
			Iterator<IBusModelFloatTypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelFloatTypeObj> cmp = new Comparator<IBusModelFloatTypeObj>() {
			@Override
			public int compare( IBusModelFloatTypeObj lhs, IBusModelFloatTypeObj rhs ) {
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
	public List<IBusModelFloatTypeObj> readCachedFloatTypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedFloatTypeByDefSchemaIdx";
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelFloatTypeObj> arrayList = new ArrayList<IBusModelFloatTypeObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelFloatTypeObj arr[] = new IBusModelFloatTypeObj[len];
				Iterator<IBusModelFloatTypeObj> valIter = dict.values().iterator();
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
			IBusModelFloatTypeObj obj;
			Iterator<IBusModelFloatTypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelFloatTypeObj> cmp = new Comparator<IBusModelFloatTypeObj>() {
			@Override
			public int compare( IBusModelFloatTypeObj lhs, IBusModelFloatTypeObj rhs ) {
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
	public List<IBusModelFloatTypeObj> readCachedFloatTypeByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedFloatTypeByPrevIdx";
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelFloatTypeObj> arrayList = new ArrayList<IBusModelFloatTypeObj>();
		if( indexByPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict;
			if( indexByPrevIdx.containsKey( key ) ) {
				dict = indexByPrevIdx.get( key );
				int len = dict.size();
				IBusModelFloatTypeObj arr[] = new IBusModelFloatTypeObj[len];
				Iterator<IBusModelFloatTypeObj> valIter = dict.values().iterator();
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
			IBusModelFloatTypeObj obj;
			Iterator<IBusModelFloatTypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelFloatTypeObj> cmp = new Comparator<IBusModelFloatTypeObj>() {
			@Override
			public int compare( IBusModelFloatTypeObj lhs, IBusModelFloatTypeObj rhs ) {
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
	public List<IBusModelFloatTypeObj> readCachedFloatTypeByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedFloatTypeByNextIdx";
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelFloatTypeObj> arrayList = new ArrayList<IBusModelFloatTypeObj>();
		if( indexByNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict;
			if( indexByNextIdx.containsKey( key ) ) {
				dict = indexByNextIdx.get( key );
				int len = dict.size();
				IBusModelFloatTypeObj arr[] = new IBusModelFloatTypeObj[len];
				Iterator<IBusModelFloatTypeObj> valIter = dict.values().iterator();
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
			IBusModelFloatTypeObj obj;
			Iterator<IBusModelFloatTypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelFloatTypeObj> cmp = new Comparator<IBusModelFloatTypeObj>() {
			@Override
			public int compare( IBusModelFloatTypeObj lhs, IBusModelFloatTypeObj rhs ) {
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
	public List<IBusModelFloatTypeObj> readCachedFloatTypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedFloatTypeByContPrevIdx";
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelFloatTypeObj> arrayList = new ArrayList<IBusModelFloatTypeObj>();
		if( indexByContPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict;
			if( indexByContPrevIdx.containsKey( key ) ) {
				dict = indexByContPrevIdx.get( key );
				int len = dict.size();
				IBusModelFloatTypeObj arr[] = new IBusModelFloatTypeObj[len];
				Iterator<IBusModelFloatTypeObj> valIter = dict.values().iterator();
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
			IBusModelFloatTypeObj obj;
			Iterator<IBusModelFloatTypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelFloatTypeObj> cmp = new Comparator<IBusModelFloatTypeObj>() {
			@Override
			public int compare( IBusModelFloatTypeObj lhs, IBusModelFloatTypeObj rhs ) {
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
	public List<IBusModelFloatTypeObj> readCachedFloatTypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedFloatTypeByContNextIdx";
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelFloatTypeObj> arrayList = new ArrayList<IBusModelFloatTypeObj>();
		if( indexByContNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict;
			if( indexByContNextIdx.containsKey( key ) ) {
				dict = indexByContNextIdx.get( key );
				int len = dict.size();
				IBusModelFloatTypeObj arr[] = new IBusModelFloatTypeObj[len];
				Iterator<IBusModelFloatTypeObj> valIter = dict.values().iterator();
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
			IBusModelFloatTypeObj obj;
			Iterator<IBusModelFloatTypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelFloatTypeObj> cmp = new Comparator<IBusModelFloatTypeObj>() {
			@Override
			public int compare( IBusModelFloatTypeObj lhs, IBusModelFloatTypeObj rhs ) {
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
	public List<IBusModelFloatTypeObj> readCachedFloatTypeBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "readCachedFloatTypeBySchemaIdx";
		IBusModelFloatTypeBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryFloatType().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		ArrayList<IBusModelFloatTypeObj> arrayList = new ArrayList<IBusModelFloatTypeObj>();
		if( indexBySchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict;
			if( indexBySchemaIdx.containsKey( key ) ) {
				dict = indexBySchemaIdx.get( key );
				int len = dict.size();
				IBusModelFloatTypeObj arr[] = new IBusModelFloatTypeObj[len];
				Iterator<IBusModelFloatTypeObj> valIter = dict.values().iterator();
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
			IBusModelFloatTypeObj obj;
			Iterator<IBusModelFloatTypeObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelFloatTypeObj> cmp = new Comparator<IBusModelFloatTypeObj>() {
			@Override
			public int compare( IBusModelFloatTypeObj lhs, IBusModelFloatTypeObj rhs ) {
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
	public void deepDisposeFloatTypeByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelFloatTypeObj obj = readCachedFloatTypeByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeFloatTypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelFloatTypeObj obj = readCachedFloatTypeByUNameIdx( ScopeId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeFloatTypeByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "deepDisposeFloatTypeByScopeIdx";
		IBusModelFloatTypeObj obj;
		List<IBusModelFloatTypeObj> arrayList = readCachedFloatTypeByScopeIdx( ScopeId );
		if( arrayList != null )  {
			Iterator<IBusModelFloatTypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeFloatTypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeFloatTypeByDefSchemaIdx";
		IBusModelFloatTypeObj obj;
		List<IBusModelFloatTypeObj> arrayList = readCachedFloatTypeByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelFloatTypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeFloatTypeByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeFloatTypeByPrevIdx";
		IBusModelFloatTypeObj obj;
		List<IBusModelFloatTypeObj> arrayList = readCachedFloatTypeByPrevIdx( PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelFloatTypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeFloatTypeByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeFloatTypeByNextIdx";
		IBusModelFloatTypeObj obj;
		List<IBusModelFloatTypeObj> arrayList = readCachedFloatTypeByNextIdx( NextId );
		if( arrayList != null )  {
			Iterator<IBusModelFloatTypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeFloatTypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeFloatTypeByContPrevIdx";
		IBusModelFloatTypeObj obj;
		List<IBusModelFloatTypeObj> arrayList = readCachedFloatTypeByContPrevIdx( ScopeId,
				PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelFloatTypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeFloatTypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeFloatTypeByContNextIdx";
		IBusModelFloatTypeObj obj;
		List<IBusModelFloatTypeObj> arrayList = readCachedFloatTypeByContNextIdx( ScopeId,
				NextId );
		if( arrayList != null )  {
			Iterator<IBusModelFloatTypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeFloatTypeBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "deepDisposeFloatTypeBySchemaIdx";
		IBusModelFloatTypeObj obj;
		List<IBusModelFloatTypeObj> arrayList = readCachedFloatTypeBySchemaIdx( SchemaDefId );
		if( arrayList != null )  {
			Iterator<IBusModelFloatTypeObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelFloatTypeObj updateFloatType( IBusModelFloatTypeObj Obj ) {
		IBusModelFloatTypeObj obj = Obj;
		schema.getBusModelBackingStore().getTableFloatType().updateFloatType( null,
			Obj.getFloatTypeRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getFloatTypeTableObj().getClassCode() ) {
			obj = (IBusModelFloatTypeObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteFloatType( IBusModelFloatTypeObj Obj ) {
		IBusModelFloatTypeObj obj = Obj;
		IBusModelValueObj prev = obj.getOptionalLookupPrev();
		IBusModelValueObj next = obj.getOptionalLookupNext();
		schema.getBusModelBackingStore().getTableFloatType().deleteFloatType( null,
			obj.getFloatTypeRec() );
		Obj.forget();
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	@Override
	public void deleteFloatTypeByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelFloatTypeObj obj = readFloatType(Id);
		if( obj != null ) {
			IBusModelFloatTypeEditObj editObj = (IBusModelFloatTypeEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelFloatTypeEditObj)obj.beginEdit();
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
		deepDisposeFloatTypeByIdIdx( Id );
	}

	@Override
	public void deleteFloatTypeByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelValueByUNameIdxKey,
				IBusModelFloatTypeObj >();
		}
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelFloatTypeObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableFloatType().deleteFloatTypeByUNameIdx( null,
				ScopeId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableFloatType().deleteFloatTypeByUNameIdx( null,
				ScopeId,
				Name );
		}
		deepDisposeFloatTypeByUNameIdx( ScopeId,
				Name );
	}

	@Override
	public void deleteFloatTypeByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelValueByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict = indexByScopeIdx.get( key );
			schema.getBusModelBackingStore().getTableFloatType().deleteFloatTypeByScopeIdx( null,
				ScopeId );
			Iterator<IBusModelFloatTypeObj> iter = dict.values().iterator();
			IBusModelFloatTypeObj obj;
			List<IBusModelFloatTypeObj> toForget = new LinkedList<IBusModelFloatTypeObj>();
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
			schema.getBusModelBackingStore().getTableFloatType().deleteFloatTypeByScopeIdx( null,
				ScopeId );
		}
		deepDisposeFloatTypeByScopeIdx( ScopeId );
	}

	@Override
	public void deleteFloatTypeByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelValueByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableFloatType().deleteFloatTypeByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelFloatTypeObj> iter = dict.values().iterator();
			IBusModelFloatTypeObj obj;
			List<IBusModelFloatTypeObj> toForget = new LinkedList<IBusModelFloatTypeObj>();
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
			schema.getBusModelBackingStore().getTableFloatType().deleteFloatTypeByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeFloatTypeByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteFloatTypeByPrevIdx( IYCFKeyHash256 PrevId )
	{
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelValueByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict = indexByPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableFloatType().deleteFloatTypeByPrevIdx( null,
				PrevId );
			Iterator<IBusModelFloatTypeObj> iter = dict.values().iterator();
			IBusModelFloatTypeObj obj;
			List<IBusModelFloatTypeObj> toForget = new LinkedList<IBusModelFloatTypeObj>();
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
			schema.getBusModelBackingStore().getTableFloatType().deleteFloatTypeByPrevIdx( null,
				PrevId );
		}
		deepDisposeFloatTypeByPrevIdx( PrevId );
	}

	@Override
	public void deleteFloatTypeByNextIdx( IYCFKeyHash256 NextId )
	{
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelValueByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict = indexByNextIdx.get( key );
			schema.getBusModelBackingStore().getTableFloatType().deleteFloatTypeByNextIdx( null,
				NextId );
			Iterator<IBusModelFloatTypeObj> iter = dict.values().iterator();
			IBusModelFloatTypeObj obj;
			List<IBusModelFloatTypeObj> toForget = new LinkedList<IBusModelFloatTypeObj>();
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
			schema.getBusModelBackingStore().getTableFloatType().deleteFloatTypeByNextIdx( null,
				NextId );
		}
		deepDisposeFloatTypeByNextIdx( NextId );
	}

	@Override
	public void deleteFloatTypeByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< IBusModelValueByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict = indexByContPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableFloatType().deleteFloatTypeByContPrevIdx( null,
				ScopeId,
				PrevId );
			Iterator<IBusModelFloatTypeObj> iter = dict.values().iterator();
			IBusModelFloatTypeObj obj;
			List<IBusModelFloatTypeObj> toForget = new LinkedList<IBusModelFloatTypeObj>();
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
			schema.getBusModelBackingStore().getTableFloatType().deleteFloatTypeByContPrevIdx( null,
				ScopeId,
				PrevId );
		}
		deepDisposeFloatTypeByContPrevIdx( ScopeId,
				PrevId );
	}

	@Override
	public void deleteFloatTypeByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< IBusModelValueByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict = indexByContNextIdx.get( key );
			schema.getBusModelBackingStore().getTableFloatType().deleteFloatTypeByContNextIdx( null,
				ScopeId,
				NextId );
			Iterator<IBusModelFloatTypeObj> iter = dict.values().iterator();
			IBusModelFloatTypeObj obj;
			List<IBusModelFloatTypeObj> toForget = new LinkedList<IBusModelFloatTypeObj>();
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
			schema.getBusModelBackingStore().getTableFloatType().deleteFloatTypeByContNextIdx( null,
				ScopeId,
				NextId );
		}
		deepDisposeFloatTypeByContNextIdx( ScopeId,
				NextId );
	}

	@Override
	public void deleteFloatTypeBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		IBusModelFloatTypeBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryFloatType().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< IBusModelFloatTypeBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelFloatTypeObj > >();
		}
		if( indexBySchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelFloatTypeObj> dict = indexBySchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableFloatType().deleteFloatTypeBySchemaIdx( null,
				SchemaDefId );
			Iterator<IBusModelFloatTypeObj> iter = dict.values().iterator();
			IBusModelFloatTypeObj obj;
			List<IBusModelFloatTypeObj> toForget = new LinkedList<IBusModelFloatTypeObj>();
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
			schema.getBusModelBackingStore().getTableFloatType().deleteFloatTypeBySchemaIdx( null,
				SchemaDefId );
		}
		deepDisposeFloatTypeBySchemaIdx( SchemaDefId );
	}

	/**
	 *	Move the BusModelFloatTypeObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelFloatTypeObj refreshed cache instance.
	 */
	@Override
	public IBusModelFloatTypeObj moveUpFloatType( IBusModelFloatTypeObj Obj ) {
		IBusModelFloatTypeObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUpFloatType" );
		}
		IBusModelFloatType rec = schema.getBusModelBackingStore().getTableFloatType().moveRecUp( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getFloatTypeTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelFloatTypeObj)obj.realise();
			IBusModelValueObj prev = obj.getOptionalLookupPrev( true );
			IBusModelValueObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				IBusModelValueObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the BusModelFloatTypeObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelFloatTypeObj refreshed cache instance.
	 */
	@Override
	public IBusModelFloatTypeObj moveDownFloatType( IBusModelFloatTypeObj Obj ) {
		IBusModelFloatTypeObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDownFloatType" );
		}
		IBusModelFloatType rec = schema.getBusModelBackingStore().getTableFloatType().moveRecDown( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getFloatTypeTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelFloatTypeObj)obj.realise();
			IBusModelValueObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				IBusModelValueObj gprev = prev.getOptionalLookupPrev( true );
			}
			IBusModelValueObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}