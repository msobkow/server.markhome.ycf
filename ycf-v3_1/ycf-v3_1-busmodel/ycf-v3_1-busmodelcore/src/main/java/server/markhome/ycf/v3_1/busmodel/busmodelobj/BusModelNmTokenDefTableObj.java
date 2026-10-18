// Description: Java 25 Table Object implementation for NmTokenDef.

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

public class BusModelNmTokenDefTableObj
	implements IBusModelNmTokenDefTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelNmTokenDef.CLASS_CODE;
	protected static final int backingClassCode = IBusModelNmTokenDef.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> allNmTokenDef;
	private Map< IBusModelValueByUNameIdxKey,
		IBusModelNmTokenDefObj > indexByUNameIdx;
	private Map< IBusModelValueByScopeIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > > indexByScopeIdx;
	private Map< IBusModelValueByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > > indexByDefSchemaIdx;
	private Map< IBusModelValueByPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > > indexByPrevIdx;
	private Map< IBusModelValueByNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > > indexByNextIdx;
	private Map< IBusModelValueByContPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > > indexByContPrevIdx;
	private Map< IBusModelValueByContNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > > indexByContNextIdx;
	public static String TABLE_NAME = "NmTokenDef";
	public static String TABLE_DBNAME = "nmtkndef";

	public BusModelNmTokenDefTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj>();
		allNmTokenDef = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
	}

	public BusModelNmTokenDefTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj>();
		allNmTokenDef = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelNmTokenDefTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelNmTokenDefTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allNmTokenDef = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		List<IBusModelNmTokenDefObj> toForget = new LinkedList<IBusModelNmTokenDefObj>();
		IBusModelNmTokenDefObj cur = null;
		Iterator<IBusModelNmTokenDefObj> iter = members.values().iterator();
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
	 *	BusModelNmTokenDefObj.
	 */
	@Override
	public IBusModelNmTokenDefObj newInstance() {
		IBusModelNmTokenDefObj inst = new BusModelNmTokenDefObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelNmTokenDefObj.
	 */
	@Override
	public IBusModelNmTokenDefEditObj newEditInstance( IBusModelNmTokenDefObj orig ) {
		IBusModelNmTokenDefEditObj edit = new BusModelNmTokenDefEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelNmTokenDefObj realiseNmTokenDef( IBusModelNmTokenDefObj Obj ) {
		IBusModelNmTokenDefObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelNmTokenDefObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelNmTokenDefObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					indexByNextIdx.remove( keyNextIdx );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					indexByContPrevIdx.remove( keyContPrevIdx );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelNmTokenDefObj)schema.getAtomTableObj().realiseAtom( Obj );

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
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allNmTokenDef != null ) {
				allNmTokenDef.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelNmTokenDefObj)schema.getAtomTableObj().realiseAtom( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allNmTokenDef != null ) {
				allNmTokenDef.put( keepObj.getPKey(), keepObj );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelNmTokenDefObj createNmTokenDef( IBusModelNmTokenDefObj Obj ) {
		IBusModelNmTokenDefObj obj = Obj;
		IBusModelNmTokenDef rec = obj.getNmTokenDefRec();
		schema.getBusModelBackingStore().getTableNmTokenDef().createNmTokenDef(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelNmTokenDefObj)(obj.realise());
		}
		IBusModelValueObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelNmTokenDefObj readNmTokenDef( $implCommaIJavaOptAtomType$ pkey ) {
		return( readNmTokenDef( pkey, false ) );
	}

	@Override
	public IBusModelNmTokenDefObj readNmTokenDef( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelNmTokenDefObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelNmTokenDef readRec = schema.getBusModelBackingStore().getTableNmTokenDef().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelNmTokenDefObj)schema.getValueTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelNmTokenDefObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelNmTokenDefObj readCachedNmTokenDef( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelNmTokenDefObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeNmTokenDef( IBusModelNmTokenDefObj obj )
	{
		final String S_ProcName = "BusModelNmTokenDefTableObj.reallyDeepDisposeNmTokenDef() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelNmTokenDefObj existing = readCachedNmTokenDef( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );

		schema.getTableColTableObj().deepDisposeTableColByDataIdx( existing.getRequiredId() );
		schema.getIndexColTableObj().deepDisposeIndexColByColIdx( existing.getRequiredId() );


		schema.getAtomTableObj().reallyDeepDisposeAtom( obj );
	}
	@Override
	public void deepDisposeNmTokenDef( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelNmTokenDefObj obj = readCachedNmTokenDef( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelNmTokenDefObj lockNmTokenDef( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelNmTokenDefObj locked = null;
		IBusModelNmTokenDef lockRec = schema.getBusModelBackingStore().getTableNmTokenDef().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelNmTokenDefObj)schema.getValueTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelNmTokenDefObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockNmTokenDef", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelNmTokenDefObj> readAllNmTokenDef() {
		return( readAllNmTokenDef( false ) );
	}

	@Override
	public List<IBusModelNmTokenDefObj> readAllNmTokenDef( boolean forceRead ) {
		final String S_ProcName = "readAllNmTokenDef";
		if( ( allNmTokenDef == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelNmTokenDefObj>();
			allNmTokenDef = map;
			IBusModelNmTokenDef[] recList = schema.getBusModelBackingStore().getTableNmTokenDef().readAllDerived( null );
			IBusModelNmTokenDef rec;
			IBusModelNmTokenDefObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelNmTokenDefObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelNmTokenDefObj realised = (IBusModelNmTokenDefObj)obj.realise();
			}
		}
		int len = allNmTokenDef.size();
		IBusModelNmTokenDefObj arr[] = new IBusModelNmTokenDefObj[len];
		Iterator<IBusModelNmTokenDefObj> valIter = allNmTokenDef.values().iterator();
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
		ArrayList<IBusModelNmTokenDefObj> arrayList = new ArrayList<IBusModelNmTokenDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelNmTokenDefObj> cmp = new Comparator<IBusModelNmTokenDefObj>() {
			@Override
			public int compare( IBusModelNmTokenDefObj lhs, IBusModelNmTokenDefObj rhs ) {
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
		List<IBusModelNmTokenDefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelNmTokenDefObj> readCachedAllNmTokenDef() {
		final String S_ProcName = "readCachedAllNmTokenDef";
		ArrayList<IBusModelNmTokenDefObj> arrayList = new ArrayList<IBusModelNmTokenDefObj>();
		if( allNmTokenDef != null ) {
			int len = allNmTokenDef.size();
			IBusModelNmTokenDefObj arr[] = new IBusModelNmTokenDefObj[len];
			Iterator<IBusModelNmTokenDefObj> valIter = allNmTokenDef.values().iterator();
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
		Comparator<IBusModelNmTokenDefObj> cmp = new Comparator<IBusModelNmTokenDefObj>() {
			public int compare( IBusModelNmTokenDefObj lhs, IBusModelNmTokenDefObj rhs ) {
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
	public IBusModelNmTokenDefObj readNmTokenDefByIdIdx( IYCFKeyHash256 Id )
	{
		return( readNmTokenDefByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelNmTokenDefObj readNmTokenDefByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelNmTokenDefObj obj = readNmTokenDef( Id, forceRead );
		return( obj );
	}

	@Override
	public IBusModelNmTokenDefObj readNmTokenDefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		return( readNmTokenDefByUNameIdx( ScopeId,
			Name,
			false ) );
	}

	@Override
	public IBusModelNmTokenDefObj readNmTokenDefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelValueByUNameIdxKey,
				IBusModelNmTokenDefObj >();
		}
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelNmTokenDefObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelValue rec = schema.getBusModelBackingStore().getTableValue().readDerivedByUNameIdx( null,
				ScopeId,
				Name );
			if( rec != null ) {
				obj = (IBusModelNmTokenDefObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelNmTokenDefObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelNmTokenDefObj> readNmTokenDefByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		return( readNmTokenDefByScopeIdx( ScopeId,
			false ) );
	}

	@Override
	public List<IBusModelNmTokenDefObj> readNmTokenDefByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readNmTokenDefByScopeIdx";
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelValueByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByScopeIdx( null,
				ScopeId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelNmTokenDefObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelNmTokenDefObj realised = (IBusModelNmTokenDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelNmTokenDefObj arr[] = new IBusModelNmTokenDefObj[len];
		Iterator<IBusModelNmTokenDefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelNmTokenDefObj> arrayList = new ArrayList<IBusModelNmTokenDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelNmTokenDefObj> cmp = new Comparator<IBusModelNmTokenDefObj>() {
			@Override
			public int compare( IBusModelNmTokenDefObj lhs, IBusModelNmTokenDefObj rhs ) {
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
		List<IBusModelNmTokenDefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelNmTokenDefObj> readNmTokenDefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readNmTokenDefByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelNmTokenDefObj> readNmTokenDefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readNmTokenDefByDefSchemaIdx";
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelValueByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelNmTokenDefObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelNmTokenDefObj realised = (IBusModelNmTokenDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelNmTokenDefObj arr[] = new IBusModelNmTokenDefObj[len];
		Iterator<IBusModelNmTokenDefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelNmTokenDefObj> arrayList = new ArrayList<IBusModelNmTokenDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelNmTokenDefObj> cmp = new Comparator<IBusModelNmTokenDefObj>() {
			@Override
			public int compare( IBusModelNmTokenDefObj lhs, IBusModelNmTokenDefObj rhs ) {
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
		List<IBusModelNmTokenDefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelNmTokenDefObj> readNmTokenDefByPrevIdx( IYCFKeyHash256 PrevId )
	{
		return( readNmTokenDefByPrevIdx( PrevId,
			false ) );
	}

	@Override
	public List<IBusModelNmTokenDefObj> readNmTokenDefByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readNmTokenDefByPrevIdx";
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelValueByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByPrevIdx( null,
				PrevId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelNmTokenDefObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelNmTokenDefObj realised = (IBusModelNmTokenDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelNmTokenDefObj arr[] = new IBusModelNmTokenDefObj[len];
		Iterator<IBusModelNmTokenDefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelNmTokenDefObj> arrayList = new ArrayList<IBusModelNmTokenDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelNmTokenDefObj> cmp = new Comparator<IBusModelNmTokenDefObj>() {
			@Override
			public int compare( IBusModelNmTokenDefObj lhs, IBusModelNmTokenDefObj rhs ) {
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
		List<IBusModelNmTokenDefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelNmTokenDefObj> readNmTokenDefByNextIdx( IYCFKeyHash256 NextId )
	{
		return( readNmTokenDefByNextIdx( NextId,
			false ) );
	}

	@Override
	public List<IBusModelNmTokenDefObj> readNmTokenDefByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readNmTokenDefByNextIdx";
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelValueByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByNextIdx( null,
				NextId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelNmTokenDefObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelNmTokenDefObj realised = (IBusModelNmTokenDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelNmTokenDefObj arr[] = new IBusModelNmTokenDefObj[len];
		Iterator<IBusModelNmTokenDefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelNmTokenDefObj> arrayList = new ArrayList<IBusModelNmTokenDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelNmTokenDefObj> cmp = new Comparator<IBusModelNmTokenDefObj>() {
			@Override
			public int compare( IBusModelNmTokenDefObj lhs, IBusModelNmTokenDefObj rhs ) {
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
		List<IBusModelNmTokenDefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelNmTokenDefObj> readNmTokenDefByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		return( readNmTokenDefByContPrevIdx( ScopeId,
			PrevId,
			false ) );
	}

	@Override
	public List<IBusModelNmTokenDefObj> readNmTokenDefByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readNmTokenDefByContPrevIdx";
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< IBusModelValueByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByContPrevIdx( null,
				ScopeId,
				PrevId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelNmTokenDefObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelNmTokenDefObj realised = (IBusModelNmTokenDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelNmTokenDefObj arr[] = new IBusModelNmTokenDefObj[len];
		Iterator<IBusModelNmTokenDefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelNmTokenDefObj> arrayList = new ArrayList<IBusModelNmTokenDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelNmTokenDefObj> cmp = new Comparator<IBusModelNmTokenDefObj>() {
			@Override
			public int compare( IBusModelNmTokenDefObj lhs, IBusModelNmTokenDefObj rhs ) {
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
		List<IBusModelNmTokenDefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelNmTokenDefObj> readNmTokenDefByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		return( readNmTokenDefByContNextIdx( ScopeId,
			NextId,
			false ) );
	}

	@Override
	public List<IBusModelNmTokenDefObj> readNmTokenDefByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readNmTokenDefByContNextIdx";
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< IBusModelValueByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByContNextIdx( null,
				ScopeId,
				NextId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelNmTokenDefObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelNmTokenDefObj realised = (IBusModelNmTokenDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelNmTokenDefObj arr[] = new IBusModelNmTokenDefObj[len];
		Iterator<IBusModelNmTokenDefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelNmTokenDefObj> arrayList = new ArrayList<IBusModelNmTokenDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelNmTokenDefObj> cmp = new Comparator<IBusModelNmTokenDefObj>() {
			@Override
			public int compare( IBusModelNmTokenDefObj lhs, IBusModelNmTokenDefObj rhs ) {
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
		List<IBusModelNmTokenDefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelNmTokenDefObj readCachedNmTokenDefByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelNmTokenDefObj obj = null;
		obj = readCachedNmTokenDef( Id );
		return( obj );
	}

	@Override
	public IBusModelNmTokenDefObj readCachedNmTokenDefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelNmTokenDefObj obj = null;
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelNmTokenDefObj> valIter = members.values().iterator();
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
			Iterator<IBusModelNmTokenDefObj> valIter = members.values().iterator();
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
	public List<IBusModelNmTokenDefObj> readCachedNmTokenDefByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "readCachedNmTokenDefByScopeIdx";
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		ArrayList<IBusModelNmTokenDefObj> arrayList = new ArrayList<IBusModelNmTokenDefObj>();
		if( indexByScopeIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict;
			if( indexByScopeIdx.containsKey( key ) ) {
				dict = indexByScopeIdx.get( key );
				int len = dict.size();
				IBusModelNmTokenDefObj arr[] = new IBusModelNmTokenDefObj[len];
				Iterator<IBusModelNmTokenDefObj> valIter = dict.values().iterator();
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
			IBusModelNmTokenDefObj obj;
			Iterator<IBusModelNmTokenDefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelNmTokenDefObj> cmp = new Comparator<IBusModelNmTokenDefObj>() {
			@Override
			public int compare( IBusModelNmTokenDefObj lhs, IBusModelNmTokenDefObj rhs ) {
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
	public List<IBusModelNmTokenDefObj> readCachedNmTokenDefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedNmTokenDefByDefSchemaIdx";
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelNmTokenDefObj> arrayList = new ArrayList<IBusModelNmTokenDefObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelNmTokenDefObj arr[] = new IBusModelNmTokenDefObj[len];
				Iterator<IBusModelNmTokenDefObj> valIter = dict.values().iterator();
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
			IBusModelNmTokenDefObj obj;
			Iterator<IBusModelNmTokenDefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelNmTokenDefObj> cmp = new Comparator<IBusModelNmTokenDefObj>() {
			@Override
			public int compare( IBusModelNmTokenDefObj lhs, IBusModelNmTokenDefObj rhs ) {
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
	public List<IBusModelNmTokenDefObj> readCachedNmTokenDefByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedNmTokenDefByPrevIdx";
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelNmTokenDefObj> arrayList = new ArrayList<IBusModelNmTokenDefObj>();
		if( indexByPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict;
			if( indexByPrevIdx.containsKey( key ) ) {
				dict = indexByPrevIdx.get( key );
				int len = dict.size();
				IBusModelNmTokenDefObj arr[] = new IBusModelNmTokenDefObj[len];
				Iterator<IBusModelNmTokenDefObj> valIter = dict.values().iterator();
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
			IBusModelNmTokenDefObj obj;
			Iterator<IBusModelNmTokenDefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelNmTokenDefObj> cmp = new Comparator<IBusModelNmTokenDefObj>() {
			@Override
			public int compare( IBusModelNmTokenDefObj lhs, IBusModelNmTokenDefObj rhs ) {
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
	public List<IBusModelNmTokenDefObj> readCachedNmTokenDefByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedNmTokenDefByNextIdx";
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelNmTokenDefObj> arrayList = new ArrayList<IBusModelNmTokenDefObj>();
		if( indexByNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict;
			if( indexByNextIdx.containsKey( key ) ) {
				dict = indexByNextIdx.get( key );
				int len = dict.size();
				IBusModelNmTokenDefObj arr[] = new IBusModelNmTokenDefObj[len];
				Iterator<IBusModelNmTokenDefObj> valIter = dict.values().iterator();
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
			IBusModelNmTokenDefObj obj;
			Iterator<IBusModelNmTokenDefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelNmTokenDefObj> cmp = new Comparator<IBusModelNmTokenDefObj>() {
			@Override
			public int compare( IBusModelNmTokenDefObj lhs, IBusModelNmTokenDefObj rhs ) {
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
	public List<IBusModelNmTokenDefObj> readCachedNmTokenDefByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedNmTokenDefByContPrevIdx";
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelNmTokenDefObj> arrayList = new ArrayList<IBusModelNmTokenDefObj>();
		if( indexByContPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict;
			if( indexByContPrevIdx.containsKey( key ) ) {
				dict = indexByContPrevIdx.get( key );
				int len = dict.size();
				IBusModelNmTokenDefObj arr[] = new IBusModelNmTokenDefObj[len];
				Iterator<IBusModelNmTokenDefObj> valIter = dict.values().iterator();
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
			IBusModelNmTokenDefObj obj;
			Iterator<IBusModelNmTokenDefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelNmTokenDefObj> cmp = new Comparator<IBusModelNmTokenDefObj>() {
			@Override
			public int compare( IBusModelNmTokenDefObj lhs, IBusModelNmTokenDefObj rhs ) {
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
	public List<IBusModelNmTokenDefObj> readCachedNmTokenDefByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedNmTokenDefByContNextIdx";
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelNmTokenDefObj> arrayList = new ArrayList<IBusModelNmTokenDefObj>();
		if( indexByContNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict;
			if( indexByContNextIdx.containsKey( key ) ) {
				dict = indexByContNextIdx.get( key );
				int len = dict.size();
				IBusModelNmTokenDefObj arr[] = new IBusModelNmTokenDefObj[len];
				Iterator<IBusModelNmTokenDefObj> valIter = dict.values().iterator();
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
			IBusModelNmTokenDefObj obj;
			Iterator<IBusModelNmTokenDefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelNmTokenDefObj> cmp = new Comparator<IBusModelNmTokenDefObj>() {
			@Override
			public int compare( IBusModelNmTokenDefObj lhs, IBusModelNmTokenDefObj rhs ) {
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
	public void deepDisposeNmTokenDefByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelNmTokenDefObj obj = readCachedNmTokenDefByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeNmTokenDefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelNmTokenDefObj obj = readCachedNmTokenDefByUNameIdx( ScopeId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeNmTokenDefByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "deepDisposeNmTokenDefByScopeIdx";
		IBusModelNmTokenDefObj obj;
		List<IBusModelNmTokenDefObj> arrayList = readCachedNmTokenDefByScopeIdx( ScopeId );
		if( arrayList != null )  {
			Iterator<IBusModelNmTokenDefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeNmTokenDefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeNmTokenDefByDefSchemaIdx";
		IBusModelNmTokenDefObj obj;
		List<IBusModelNmTokenDefObj> arrayList = readCachedNmTokenDefByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelNmTokenDefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeNmTokenDefByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeNmTokenDefByPrevIdx";
		IBusModelNmTokenDefObj obj;
		List<IBusModelNmTokenDefObj> arrayList = readCachedNmTokenDefByPrevIdx( PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelNmTokenDefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeNmTokenDefByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeNmTokenDefByNextIdx";
		IBusModelNmTokenDefObj obj;
		List<IBusModelNmTokenDefObj> arrayList = readCachedNmTokenDefByNextIdx( NextId );
		if( arrayList != null )  {
			Iterator<IBusModelNmTokenDefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeNmTokenDefByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeNmTokenDefByContPrevIdx";
		IBusModelNmTokenDefObj obj;
		List<IBusModelNmTokenDefObj> arrayList = readCachedNmTokenDefByContPrevIdx( ScopeId,
				PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelNmTokenDefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeNmTokenDefByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeNmTokenDefByContNextIdx";
		IBusModelNmTokenDefObj obj;
		List<IBusModelNmTokenDefObj> arrayList = readCachedNmTokenDefByContNextIdx( ScopeId,
				NextId );
		if( arrayList != null )  {
			Iterator<IBusModelNmTokenDefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelNmTokenDefObj updateNmTokenDef( IBusModelNmTokenDefObj Obj ) {
		IBusModelNmTokenDefObj obj = Obj;
		schema.getBusModelBackingStore().getTableNmTokenDef().updateNmTokenDef( null,
			Obj.getNmTokenDefRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getNmTokenDefTableObj().getClassCode() ) {
			obj = (IBusModelNmTokenDefObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteNmTokenDef( IBusModelNmTokenDefObj Obj ) {
		IBusModelNmTokenDefObj obj = Obj;
		IBusModelValueObj prev = obj.getOptionalLookupPrev();
		IBusModelValueObj next = obj.getOptionalLookupNext();
		schema.getBusModelBackingStore().getTableNmTokenDef().deleteNmTokenDef( null,
			obj.getNmTokenDefRec() );
		Obj.forget();
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	@Override
	public void deleteNmTokenDefByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelNmTokenDefObj obj = readNmTokenDef(Id);
		if( obj != null ) {
			IBusModelNmTokenDefEditObj editObj = (IBusModelNmTokenDefEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelNmTokenDefEditObj)obj.beginEdit();
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
		deepDisposeNmTokenDefByIdIdx( Id );
	}

	@Override
	public void deleteNmTokenDefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelValueByUNameIdxKey,
				IBusModelNmTokenDefObj >();
		}
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelNmTokenDefObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableNmTokenDef().deleteNmTokenDefByUNameIdx( null,
				ScopeId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableNmTokenDef().deleteNmTokenDefByUNameIdx( null,
				ScopeId,
				Name );
		}
		deepDisposeNmTokenDefByUNameIdx( ScopeId,
				Name );
	}

	@Override
	public void deleteNmTokenDefByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelValueByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict = indexByScopeIdx.get( key );
			schema.getBusModelBackingStore().getTableNmTokenDef().deleteNmTokenDefByScopeIdx( null,
				ScopeId );
			Iterator<IBusModelNmTokenDefObj> iter = dict.values().iterator();
			IBusModelNmTokenDefObj obj;
			List<IBusModelNmTokenDefObj> toForget = new LinkedList<IBusModelNmTokenDefObj>();
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
			schema.getBusModelBackingStore().getTableNmTokenDef().deleteNmTokenDefByScopeIdx( null,
				ScopeId );
		}
		deepDisposeNmTokenDefByScopeIdx( ScopeId );
	}

	@Override
	public void deleteNmTokenDefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelValueByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableNmTokenDef().deleteNmTokenDefByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelNmTokenDefObj> iter = dict.values().iterator();
			IBusModelNmTokenDefObj obj;
			List<IBusModelNmTokenDefObj> toForget = new LinkedList<IBusModelNmTokenDefObj>();
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
			schema.getBusModelBackingStore().getTableNmTokenDef().deleteNmTokenDefByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeNmTokenDefByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteNmTokenDefByPrevIdx( IYCFKeyHash256 PrevId )
	{
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelValueByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict = indexByPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableNmTokenDef().deleteNmTokenDefByPrevIdx( null,
				PrevId );
			Iterator<IBusModelNmTokenDefObj> iter = dict.values().iterator();
			IBusModelNmTokenDefObj obj;
			List<IBusModelNmTokenDefObj> toForget = new LinkedList<IBusModelNmTokenDefObj>();
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
			schema.getBusModelBackingStore().getTableNmTokenDef().deleteNmTokenDefByPrevIdx( null,
				PrevId );
		}
		deepDisposeNmTokenDefByPrevIdx( PrevId );
	}

	@Override
	public void deleteNmTokenDefByNextIdx( IYCFKeyHash256 NextId )
	{
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelValueByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict = indexByNextIdx.get( key );
			schema.getBusModelBackingStore().getTableNmTokenDef().deleteNmTokenDefByNextIdx( null,
				NextId );
			Iterator<IBusModelNmTokenDefObj> iter = dict.values().iterator();
			IBusModelNmTokenDefObj obj;
			List<IBusModelNmTokenDefObj> toForget = new LinkedList<IBusModelNmTokenDefObj>();
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
			schema.getBusModelBackingStore().getTableNmTokenDef().deleteNmTokenDefByNextIdx( null,
				NextId );
		}
		deepDisposeNmTokenDefByNextIdx( NextId );
	}

	@Override
	public void deleteNmTokenDefByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< IBusModelValueByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict = indexByContPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableNmTokenDef().deleteNmTokenDefByContPrevIdx( null,
				ScopeId,
				PrevId );
			Iterator<IBusModelNmTokenDefObj> iter = dict.values().iterator();
			IBusModelNmTokenDefObj obj;
			List<IBusModelNmTokenDefObj> toForget = new LinkedList<IBusModelNmTokenDefObj>();
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
			schema.getBusModelBackingStore().getTableNmTokenDef().deleteNmTokenDefByContPrevIdx( null,
				ScopeId,
				PrevId );
		}
		deepDisposeNmTokenDefByContPrevIdx( ScopeId,
				PrevId );
	}

	@Override
	public void deleteNmTokenDefByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< IBusModelValueByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelNmTokenDefObj> dict = indexByContNextIdx.get( key );
			schema.getBusModelBackingStore().getTableNmTokenDef().deleteNmTokenDefByContNextIdx( null,
				ScopeId,
				NextId );
			Iterator<IBusModelNmTokenDefObj> iter = dict.values().iterator();
			IBusModelNmTokenDefObj obj;
			List<IBusModelNmTokenDefObj> toForget = new LinkedList<IBusModelNmTokenDefObj>();
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
			schema.getBusModelBackingStore().getTableNmTokenDef().deleteNmTokenDefByContNextIdx( null,
				ScopeId,
				NextId );
		}
		deepDisposeNmTokenDefByContNextIdx( ScopeId,
				NextId );
	}

	/**
	 *	Move the BusModelNmTokenDefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelNmTokenDefObj refreshed cache instance.
	 */
	@Override
	public IBusModelNmTokenDefObj moveUpNmTokenDef( IBusModelNmTokenDefObj Obj ) {
		IBusModelNmTokenDefObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUpNmTokenDef" );
		}
		IBusModelNmTokenDef rec = schema.getBusModelBackingStore().getTableNmTokenDef().moveRecUp( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getNmTokenDefTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelNmTokenDefObj)obj.realise();
			IBusModelValueObj prev = obj.getOptionalLookupPrev( true );
			IBusModelValueObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				IBusModelValueObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the BusModelNmTokenDefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelNmTokenDefObj refreshed cache instance.
	 */
	@Override
	public IBusModelNmTokenDefObj moveDownNmTokenDef( IBusModelNmTokenDefObj Obj ) {
		IBusModelNmTokenDefObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDownNmTokenDef" );
		}
		IBusModelNmTokenDef rec = schema.getBusModelBackingStore().getTableNmTokenDef().moveRecDown( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getNmTokenDefTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelNmTokenDefObj)obj.realise();
			IBusModelValueObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				IBusModelValueObj gprev = prev.getOptionalLookupPrev( true );
			}
			IBusModelValueObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}