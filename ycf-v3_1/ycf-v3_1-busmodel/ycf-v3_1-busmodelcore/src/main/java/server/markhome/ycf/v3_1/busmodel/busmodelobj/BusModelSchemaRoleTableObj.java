// Description: Java 25 Table Object implementation for SchemaRole.

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

public class BusModelSchemaRoleTableObj
	implements IBusModelSchemaRoleTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelSchemaRole.CLASS_CODE;
	protected static final int backingClassCode = IBusModelSchemaRole.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> allSchemaRole;
	private Map< IBusModelRoleDefByUNameIdxKey,
		IBusModelSchemaRoleObj > indexByUNameIdx;
	private Map< IBusModelRoleDefByScopeIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > > indexByScopeIdx;
	private Map< IBusModelRoleDefByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > > indexByDefSchemaIdx;
	private Map< IBusModelRoleDefByUDefIdxKey,
		IBusModelSchemaRoleObj > indexByUDefIdx;
	private Map< IBusModelSchemaRoleBySchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > > indexBySchemaIdx;
	private Map< IBusModelSchemaRoleByRoleScopeIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > > indexByRoleScopeIdx;
	private Map< IBusModelSchemaRoleBySchRoleScpIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > > indexBySchRoleScpIdx;
	public static String TABLE_NAME = "SchemaRole";
	public static String TABLE_DBNAME = "schrole";

	public BusModelSchemaRoleTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj>();
		allSchemaRole = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByUDefIdx = null;
		indexBySchemaIdx = null;
		indexByRoleScopeIdx = null;
		indexBySchRoleScpIdx = null;
	}

	public BusModelSchemaRoleTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj>();
		allSchemaRole = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByUDefIdx = null;
		indexBySchemaIdx = null;
		indexByRoleScopeIdx = null;
		indexBySchRoleScpIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelSchemaRoleTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelSchemaRoleTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allSchemaRole = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByUDefIdx = null;
		indexBySchemaIdx = null;
		indexByRoleScopeIdx = null;
		indexBySchRoleScpIdx = null;
		List<IBusModelSchemaRoleObj> toForget = new LinkedList<IBusModelSchemaRoleObj>();
		IBusModelSchemaRoleObj cur = null;
		Iterator<IBusModelSchemaRoleObj> iter = members.values().iterator();
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
	 *	BusModelSchemaRoleObj.
	 */
	@Override
	public IBusModelSchemaRoleObj newInstance() {
		IBusModelSchemaRoleObj inst = new BusModelSchemaRoleObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSchemaRoleObj.
	 */
	@Override
	public IBusModelSchemaRoleEditObj newEditInstance( IBusModelSchemaRoleObj orig ) {
		IBusModelSchemaRoleEditObj edit = new BusModelSchemaRoleEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelSchemaRoleObj realiseSchemaRole( IBusModelSchemaRoleObj Obj ) {
		IBusModelSchemaRoleObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelSchemaRoleObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelSchemaRoleObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				IBusModelRoleDefByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByScopeIdx != null ) {
				IBusModelRoleDefByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelRoleDefByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByUDefIdx != null ) {
				IBusModelRoleDefByUDefIdxKey keyUDefIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUDefIdxKey();
				keyUDefIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUDefIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				keyUDefIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUDefIdx.remove( keyUDefIdx );
			}

			if( indexBySchemaIdx != null ) {
				IBusModelSchemaRoleBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.remove( keepObj.getPKey() );
					if( mapSchemaIdx.size() <= 0 ) {
						indexBySchemaIdx.remove( keySchemaIdx );
					}
				}
			}

			if( indexByRoleScopeIdx != null ) {
				IBusModelSchemaRoleByRoleScopeIdxKey keyRoleScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newByRoleScopeIdxKey();
				keyRoleScopeIdx.setRequiredRoleScope( keepObj.getRequiredRoleScope() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > mapRoleScopeIdx = indexByRoleScopeIdx.get( keyRoleScopeIdx );
				if( mapRoleScopeIdx != null ) {
					mapRoleScopeIdx.remove( keepObj.getPKey() );
					if( mapRoleScopeIdx.size() <= 0 ) {
						indexByRoleScopeIdx.remove( keyRoleScopeIdx );
					}
				}
			}

			if( indexBySchRoleScpIdx != null ) {
				IBusModelSchemaRoleBySchRoleScpIdxKey keySchRoleScpIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newBySchRoleScpIdxKey();
				keySchRoleScpIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keySchRoleScpIdx.setRequiredRoleScope( keepObj.getRequiredRoleScope() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > mapSchRoleScpIdx = indexBySchRoleScpIdx.get( keySchRoleScpIdx );
				if( mapSchRoleScpIdx != null ) {
					mapSchRoleScpIdx.remove( keepObj.getPKey() );
					if( mapSchRoleScpIdx.size() <= 0 ) {
						indexBySchRoleScpIdx.remove( keySchRoleScpIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelSchemaRoleObj)schema.getRoleDefTableObj().realiseRoleDef( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				IBusModelRoleDefByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByScopeIdx != null ) {
				IBusModelRoleDefByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelRoleDefByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUDefIdx != null ) {
				IBusModelRoleDefByUDefIdxKey keyUDefIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUDefIdxKey();
				keyUDefIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUDefIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				keyUDefIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUDefIdx.put( keyUDefIdx, keepObj );
			}

			if( indexBySchemaIdx != null ) {
				IBusModelSchemaRoleBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRoleScopeIdx != null ) {
				IBusModelSchemaRoleByRoleScopeIdxKey keyRoleScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newByRoleScopeIdxKey();
				keyRoleScopeIdx.setRequiredRoleScope( keepObj.getRequiredRoleScope() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > mapRoleScopeIdx = indexByRoleScopeIdx.get( keyRoleScopeIdx );
				if( mapRoleScopeIdx != null ) {
					mapRoleScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchRoleScpIdx != null ) {
				IBusModelSchemaRoleBySchRoleScpIdxKey keySchRoleScpIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newBySchRoleScpIdxKey();
				keySchRoleScpIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keySchRoleScpIdx.setRequiredRoleScope( keepObj.getRequiredRoleScope() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > mapSchRoleScpIdx = indexBySchRoleScpIdx.get( keySchRoleScpIdx );
				if( mapSchRoleScpIdx != null ) {
					mapSchRoleScpIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSchemaRole != null ) {
				allSchemaRole.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelSchemaRoleObj)schema.getRoleDefTableObj().realiseRoleDef( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSchemaRole != null ) {
				allSchemaRole.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				IBusModelRoleDefByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByScopeIdx != null ) {
				IBusModelRoleDefByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelRoleDefByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUDefIdx != null ) {
				IBusModelRoleDefByUDefIdxKey keyUDefIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUDefIdxKey();
				keyUDefIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUDefIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				keyUDefIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUDefIdx.put( keyUDefIdx, keepObj );
			}

			if( indexBySchemaIdx != null ) {
				IBusModelSchemaRoleBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRoleScopeIdx != null ) {
				IBusModelSchemaRoleByRoleScopeIdxKey keyRoleScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newByRoleScopeIdxKey();
				keyRoleScopeIdx.setRequiredRoleScope( keepObj.getRequiredRoleScope() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > mapRoleScopeIdx = indexByRoleScopeIdx.get( keyRoleScopeIdx );
				if( mapRoleScopeIdx != null ) {
					mapRoleScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchRoleScpIdx != null ) {
				IBusModelSchemaRoleBySchRoleScpIdxKey keySchRoleScpIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newBySchRoleScpIdxKey();
				keySchRoleScpIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				keySchRoleScpIdx.setRequiredRoleScope( keepObj.getRequiredRoleScope() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > mapSchRoleScpIdx = indexBySchRoleScpIdx.get( keySchRoleScpIdx );
				if( mapSchRoleScpIdx != null ) {
					mapSchRoleScpIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelSchemaRoleObj createSchemaRole( IBusModelSchemaRoleObj Obj ) {
		IBusModelSchemaRoleObj obj = Obj;
		IBusModelSchemaRole rec = obj.getSchemaRoleRec();
		schema.getBusModelBackingStore().getTableSchemaRole().createSchemaRole(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelSchemaRoleObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelSchemaRoleObj readSchemaRole( $implCommaIJavaOptAtomType$ pkey ) {
		return( readSchemaRole( pkey, false ) );
	}

	@Override
	public IBusModelSchemaRoleObj readSchemaRole( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelSchemaRoleObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelSchemaRole readRec = schema.getBusModelBackingStore().getTableSchemaRole().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelSchemaRoleObj)schema.getRoleDefTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelSchemaRoleObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelSchemaRoleObj readCachedSchemaRole( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelSchemaRoleObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSchemaRole( IBusModelSchemaRoleObj obj )
	{
		final String S_ProcName = "BusModelSchemaRoleTableObj.reallyDeepDisposeSchemaRole() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelSchemaRoleObj existing = readCachedSchemaRole( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelSchemaRoleBySchemaIdxKey keySchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newBySchemaIdxKey();
		keySchemaIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );

		IBusModelSchemaRoleByRoleScopeIdxKey keyRoleScopeIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newByRoleScopeIdxKey();
		keyRoleScopeIdx.setRequiredRoleScope( existing.getRequiredRoleScope() );

		IBusModelSchemaRoleBySchRoleScpIdxKey keySchRoleScpIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newBySchRoleScpIdxKey();
		keySchRoleScpIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );
		keySchRoleScpIdx.setRequiredRoleScope( existing.getRequiredRoleScope() );



		if( indexBySchemaIdx != null ) {
			if( indexBySchemaIdx.containsKey( keySchemaIdx ) ) {
				indexBySchemaIdx.get( keySchemaIdx ).remove( pkey );
				if( indexBySchemaIdx.get( keySchemaIdx ).size() <= 0 ) {
					indexBySchemaIdx.remove( keySchemaIdx );
				}
			}
		}

		if( indexByRoleScopeIdx != null ) {
			if( indexByRoleScopeIdx.containsKey( keyRoleScopeIdx ) ) {
				indexByRoleScopeIdx.get( keyRoleScopeIdx ).remove( pkey );
				if( indexByRoleScopeIdx.get( keyRoleScopeIdx ).size() <= 0 ) {
					indexByRoleScopeIdx.remove( keyRoleScopeIdx );
				}
			}
		}

		if( indexBySchRoleScpIdx != null ) {
			if( indexBySchRoleScpIdx.containsKey( keySchRoleScpIdx ) ) {
				indexBySchRoleScpIdx.get( keySchRoleScpIdx ).remove( pkey );
				if( indexBySchRoleScpIdx.get( keySchRoleScpIdx ).size() <= 0 ) {
					indexBySchRoleScpIdx.remove( keySchRoleScpIdx );
				}
			}
		}


		schema.getRoleDefTableObj().reallyDeepDisposeRoleDef( obj );
	}
	@Override
	public void deepDisposeSchemaRole( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelSchemaRoleObj obj = readCachedSchemaRole( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelSchemaRoleObj lockSchemaRole( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelSchemaRoleObj locked = null;
		IBusModelSchemaRole lockRec = schema.getBusModelBackingStore().getTableSchemaRole().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelSchemaRoleObj)schema.getRoleDefTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelSchemaRoleObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSchemaRole", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelSchemaRoleObj> readAllSchemaRole() {
		return( readAllSchemaRole( false ) );
	}

	@Override
	public List<IBusModelSchemaRoleObj> readAllSchemaRole( boolean forceRead ) {
		final String S_ProcName = "readAllSchemaRole";
		if( ( allSchemaRole == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelSchemaRoleObj>();
			allSchemaRole = map;
			IBusModelSchemaRole[] recList = schema.getBusModelBackingStore().getTableSchemaRole().readAllDerived( null );
			IBusModelSchemaRole rec;
			IBusModelSchemaRoleObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaRoleObj)schema.getRoleDefTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaRoleObj realised = (IBusModelSchemaRoleObj)obj.realise();
			}
		}
		int len = allSchemaRole.size();
		IBusModelSchemaRoleObj arr[] = new IBusModelSchemaRoleObj[len];
		Iterator<IBusModelSchemaRoleObj> valIter = allSchemaRole.values().iterator();
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
		ArrayList<IBusModelSchemaRoleObj> arrayList = new ArrayList<IBusModelSchemaRoleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaRoleObj> cmp = new Comparator<IBusModelSchemaRoleObj>() {
			@Override
			public int compare( IBusModelSchemaRoleObj lhs, IBusModelSchemaRoleObj rhs ) {
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
		List<IBusModelSchemaRoleObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelSchemaRoleObj> readCachedAllSchemaRole() {
		final String S_ProcName = "readCachedAllSchemaRole";
		ArrayList<IBusModelSchemaRoleObj> arrayList = new ArrayList<IBusModelSchemaRoleObj>();
		if( allSchemaRole != null ) {
			int len = allSchemaRole.size();
			IBusModelSchemaRoleObj arr[] = new IBusModelSchemaRoleObj[len];
			Iterator<IBusModelSchemaRoleObj> valIter = allSchemaRole.values().iterator();
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
		Comparator<IBusModelSchemaRoleObj> cmp = new Comparator<IBusModelSchemaRoleObj>() {
			public int compare( IBusModelSchemaRoleObj lhs, IBusModelSchemaRoleObj rhs ) {
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
	public IBusModelSchemaRoleObj readSchemaRoleByIdIdx( IYCFKeyHash256 Id )
	{
		return( readSchemaRoleByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelSchemaRoleObj readSchemaRoleByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelSchemaRoleObj obj = readSchemaRole( Id, forceRead );
		return( obj );
	}

	@Override
	public IBusModelSchemaRoleObj readSchemaRoleByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		return( readSchemaRoleByUNameIdx( ScopeId,
			Name,
			false ) );
	}

	@Override
	public IBusModelSchemaRoleObj readSchemaRoleByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelRoleDefByUNameIdxKey,
				IBusModelSchemaRoleObj >();
		}
		IBusModelRoleDefByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelSchemaRoleObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelRoleDef rec = schema.getBusModelBackingStore().getTableRoleDef().readDerivedByUNameIdx( null,
				ScopeId,
				Name );
			if( rec != null ) {
				obj = (IBusModelSchemaRoleObj)schema.getRoleDefTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelSchemaRoleObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelSchemaRoleObj> readSchemaRoleByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		return( readSchemaRoleByScopeIdx( ScopeId,
			false ) );
	}

	@Override
	public List<IBusModelSchemaRoleObj> readSchemaRoleByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRoleByScopeIdx";
		IBusModelRoleDefByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelRoleDefByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj>();
			IBusModelRoleDefObj obj;
			IBusModelRoleDef[] recList = schema.getBusModelBackingStore().getTableRoleDef().readDerivedByScopeIdx( null,
				ScopeId );
			IBusModelRoleDef rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaRoleObj)schema.getRoleDefTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaRoleObj realised = (IBusModelSchemaRoleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaRoleObj arr[] = new IBusModelSchemaRoleObj[len];
		Iterator<IBusModelSchemaRoleObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaRoleObj> arrayList = new ArrayList<IBusModelSchemaRoleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaRoleObj> cmp = new Comparator<IBusModelSchemaRoleObj>() {
			@Override
			public int compare( IBusModelSchemaRoleObj lhs, IBusModelSchemaRoleObj rhs ) {
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
		List<IBusModelSchemaRoleObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelSchemaRoleObj> readSchemaRoleByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readSchemaRoleByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelSchemaRoleObj> readSchemaRoleByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRoleByDefSchemaIdx";
		IBusModelRoleDefByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelRoleDefByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj>();
			IBusModelRoleDefObj obj;
			IBusModelRoleDef[] recList = schema.getBusModelBackingStore().getTableRoleDef().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelRoleDef rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaRoleObj)schema.getRoleDefTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaRoleObj realised = (IBusModelSchemaRoleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaRoleObj arr[] = new IBusModelSchemaRoleObj[len];
		Iterator<IBusModelSchemaRoleObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaRoleObj> arrayList = new ArrayList<IBusModelSchemaRoleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaRoleObj> cmp = new Comparator<IBusModelSchemaRoleObj>() {
			@Override
			public int compare( IBusModelSchemaRoleObj lhs, IBusModelSchemaRoleObj rhs ) {
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
		List<IBusModelSchemaRoleObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelSchemaRoleObj readSchemaRoleByUDefIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		return( readSchemaRoleByUDefIdx( ScopeId,
			DefSchemaId,
			Name,
			false ) );
	}

	@Override
	public IBusModelSchemaRoleObj readSchemaRoleByUDefIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaId,
		String Name, boolean forceRead )
	{
		if( indexByUDefIdx == null ) {
			indexByUDefIdx = new HashMap< IBusModelRoleDefByUDefIdxKey,
				IBusModelSchemaRoleObj >();
		}
		IBusModelRoleDefByUDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUDefIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalDefSchemaId( DefSchemaId );
		key.setRequiredName( Name );
		IBusModelSchemaRoleObj obj = null;
		if( ( ! forceRead ) && indexByUDefIdx.containsKey( key ) ) {
			obj = indexByUDefIdx.get( key );
		}
		else {
			IBusModelRoleDef rec = schema.getBusModelBackingStore().getTableRoleDef().readDerivedByUDefIdx( null,
				ScopeId,
				DefSchemaId,
				Name );
			if( rec != null ) {
				obj = (IBusModelSchemaRoleObj)schema.getRoleDefTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelSchemaRoleObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelSchemaRoleObj> readSchemaRoleBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		return( readSchemaRoleBySchemaIdx( SchemaDefId,
			false ) );
	}

	@Override
	public List<IBusModelSchemaRoleObj> readSchemaRoleBySchemaIdx( IYCFKeyHash256 SchemaDefId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRoleBySchemaIdx";
		IBusModelSchemaRoleBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> dict;
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< IBusModelSchemaRoleBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > >();
		}
		if( ( ! forceRead ) && indexBySchemaIdx.containsKey( key ) ) {
			dict = indexBySchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj>();
			IBusModelSchemaRoleObj obj;
			IBusModelSchemaRole[] recList = schema.getBusModelBackingStore().getTableSchemaRole().readDerivedBySchemaIdx( null,
				SchemaDefId );
			IBusModelSchemaRole rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaRoleObj)schema.getRoleDefTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaRoleObj realised = (IBusModelSchemaRoleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaRoleObj arr[] = new IBusModelSchemaRoleObj[len];
		Iterator<IBusModelSchemaRoleObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaRoleObj> arrayList = new ArrayList<IBusModelSchemaRoleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaRoleObj> cmp = new Comparator<IBusModelSchemaRoleObj>() {
			@Override
			public int compare( IBusModelSchemaRoleObj lhs, IBusModelSchemaRoleObj rhs ) {
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
		List<IBusModelSchemaRoleObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelSchemaRoleObj> readSchemaRoleByRoleScopeIdx( IBusModelPubSchema.RoleScopeEnum RoleScope )
	{
		return( readSchemaRoleByRoleScopeIdx( RoleScope,
			false ) );
	}

	@Override
	public List<IBusModelSchemaRoleObj> readSchemaRoleByRoleScopeIdx( IBusModelPubSchema.RoleScopeEnum RoleScope,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRoleByRoleScopeIdx";
		IBusModelSchemaRoleByRoleScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newByRoleScopeIdxKey();
		key.setRequiredRoleScope( RoleScope );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> dict;
		if( indexByRoleScopeIdx == null ) {
			indexByRoleScopeIdx = new HashMap< IBusModelSchemaRoleByRoleScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > >();
		}
		if( ( ! forceRead ) && indexByRoleScopeIdx.containsKey( key ) ) {
			dict = indexByRoleScopeIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj>();
			IBusModelSchemaRoleObj obj;
			IBusModelSchemaRole[] recList = schema.getBusModelBackingStore().getTableSchemaRole().readDerivedByRoleScopeIdx( null,
				RoleScope );
			IBusModelSchemaRole rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaRoleObj)schema.getRoleDefTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaRoleObj realised = (IBusModelSchemaRoleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRoleScopeIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaRoleObj arr[] = new IBusModelSchemaRoleObj[len];
		Iterator<IBusModelSchemaRoleObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaRoleObj> arrayList = new ArrayList<IBusModelSchemaRoleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaRoleObj> cmp = new Comparator<IBusModelSchemaRoleObj>() {
			@Override
			public int compare( IBusModelSchemaRoleObj lhs, IBusModelSchemaRoleObj rhs ) {
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
		List<IBusModelSchemaRoleObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelSchemaRoleObj> readSchemaRoleBySchRoleScpIdx( IYCFKeyHash256 SchemaDefId,
		IBusModelPubSchema.RoleScopeEnum RoleScope )
	{
		return( readSchemaRoleBySchRoleScpIdx( SchemaDefId,
			RoleScope,
			false ) );
	}

	@Override
	public List<IBusModelSchemaRoleObj> readSchemaRoleBySchRoleScpIdx( IYCFKeyHash256 SchemaDefId,
		IBusModelPubSchema.RoleScopeEnum RoleScope,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRoleBySchRoleScpIdx";
		IBusModelSchemaRoleBySchRoleScpIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newBySchRoleScpIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredRoleScope( RoleScope );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> dict;
		if( indexBySchRoleScpIdx == null ) {
			indexBySchRoleScpIdx = new HashMap< IBusModelSchemaRoleBySchRoleScpIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > >();
		}
		if( ( ! forceRead ) && indexBySchRoleScpIdx.containsKey( key ) ) {
			dict = indexBySchRoleScpIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj>();
			IBusModelSchemaRoleObj obj;
			IBusModelSchemaRole[] recList = schema.getBusModelBackingStore().getTableSchemaRole().readDerivedBySchRoleScpIdx( null,
				SchemaDefId,
				RoleScope );
			IBusModelSchemaRole rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaRoleObj)schema.getRoleDefTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaRoleObj realised = (IBusModelSchemaRoleObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySchRoleScpIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaRoleObj arr[] = new IBusModelSchemaRoleObj[len];
		Iterator<IBusModelSchemaRoleObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaRoleObj> arrayList = new ArrayList<IBusModelSchemaRoleObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaRoleObj> cmp = new Comparator<IBusModelSchemaRoleObj>() {
			@Override
			public int compare( IBusModelSchemaRoleObj lhs, IBusModelSchemaRoleObj rhs ) {
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
		List<IBusModelSchemaRoleObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelSchemaRoleObj readCachedSchemaRoleByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelSchemaRoleObj obj = null;
		obj = readCachedSchemaRole( Id );
		return( obj );
	}

	@Override
	public IBusModelSchemaRoleObj readCachedSchemaRoleByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelSchemaRoleObj obj = null;
		IBusModelRoleDefByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelSchemaRoleObj> valIter = members.values().iterator();
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
			Iterator<IBusModelSchemaRoleObj> valIter = members.values().iterator();
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
	public List<IBusModelSchemaRoleObj> readCachedSchemaRoleByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "readCachedSchemaRoleByScopeIdx";
		IBusModelRoleDefByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		ArrayList<IBusModelSchemaRoleObj> arrayList = new ArrayList<IBusModelSchemaRoleObj>();
		if( indexByScopeIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> dict;
			if( indexByScopeIdx.containsKey( key ) ) {
				dict = indexByScopeIdx.get( key );
				int len = dict.size();
				IBusModelSchemaRoleObj arr[] = new IBusModelSchemaRoleObj[len];
				Iterator<IBusModelSchemaRoleObj> valIter = dict.values().iterator();
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
			IBusModelSchemaRoleObj obj;
			Iterator<IBusModelSchemaRoleObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaRoleObj> cmp = new Comparator<IBusModelSchemaRoleObj>() {
			@Override
			public int compare( IBusModelSchemaRoleObj lhs, IBusModelSchemaRoleObj rhs ) {
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
	public List<IBusModelSchemaRoleObj> readCachedSchemaRoleByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedSchemaRoleByDefSchemaIdx";
		IBusModelRoleDefByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelSchemaRoleObj> arrayList = new ArrayList<IBusModelSchemaRoleObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelSchemaRoleObj arr[] = new IBusModelSchemaRoleObj[len];
				Iterator<IBusModelSchemaRoleObj> valIter = dict.values().iterator();
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
			IBusModelSchemaRoleObj obj;
			Iterator<IBusModelSchemaRoleObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaRoleObj> cmp = new Comparator<IBusModelSchemaRoleObj>() {
			@Override
			public int compare( IBusModelSchemaRoleObj lhs, IBusModelSchemaRoleObj rhs ) {
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
	public IBusModelSchemaRoleObj readCachedSchemaRoleByUDefIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		IBusModelSchemaRoleObj obj = null;
		IBusModelRoleDefByUDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUDefIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalDefSchemaId( DefSchemaId );
		key.setRequiredName( Name );
		if( indexByUDefIdx != null ) {
			if( indexByUDefIdx.containsKey( key ) ) {
				obj = indexByUDefIdx.get( key );
			}
			else {
				Iterator<IBusModelSchemaRoleObj> valIter = members.values().iterator();
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
			Iterator<IBusModelSchemaRoleObj> valIter = members.values().iterator();
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
	public List<IBusModelSchemaRoleObj> readCachedSchemaRoleBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "readCachedSchemaRoleBySchemaIdx";
		IBusModelSchemaRoleBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		ArrayList<IBusModelSchemaRoleObj> arrayList = new ArrayList<IBusModelSchemaRoleObj>();
		if( indexBySchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> dict;
			if( indexBySchemaIdx.containsKey( key ) ) {
				dict = indexBySchemaIdx.get( key );
				int len = dict.size();
				IBusModelSchemaRoleObj arr[] = new IBusModelSchemaRoleObj[len];
				Iterator<IBusModelSchemaRoleObj> valIter = dict.values().iterator();
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
			IBusModelSchemaRoleObj obj;
			Iterator<IBusModelSchemaRoleObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaRoleObj> cmp = new Comparator<IBusModelSchemaRoleObj>() {
			@Override
			public int compare( IBusModelSchemaRoleObj lhs, IBusModelSchemaRoleObj rhs ) {
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
	public List<IBusModelSchemaRoleObj> readCachedSchemaRoleByRoleScopeIdx( IBusModelPubSchema.RoleScopeEnum RoleScope )
	{
		final String S_ProcName = "readCachedSchemaRoleByRoleScopeIdx";
		IBusModelSchemaRoleByRoleScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newByRoleScopeIdxKey();
		key.setRequiredRoleScope( RoleScope );
		ArrayList<IBusModelSchemaRoleObj> arrayList = new ArrayList<IBusModelSchemaRoleObj>();
		if( indexByRoleScopeIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> dict;
			if( indexByRoleScopeIdx.containsKey( key ) ) {
				dict = indexByRoleScopeIdx.get( key );
				int len = dict.size();
				IBusModelSchemaRoleObj arr[] = new IBusModelSchemaRoleObj[len];
				Iterator<IBusModelSchemaRoleObj> valIter = dict.values().iterator();
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
			IBusModelSchemaRoleObj obj;
			Iterator<IBusModelSchemaRoleObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaRoleObj> cmp = new Comparator<IBusModelSchemaRoleObj>() {
			@Override
			public int compare( IBusModelSchemaRoleObj lhs, IBusModelSchemaRoleObj rhs ) {
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
	public List<IBusModelSchemaRoleObj> readCachedSchemaRoleBySchRoleScpIdx( IYCFKeyHash256 SchemaDefId,
		IBusModelPubSchema.RoleScopeEnum RoleScope )
	{
		final String S_ProcName = "readCachedSchemaRoleBySchRoleScpIdx";
		IBusModelSchemaRoleBySchRoleScpIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newBySchRoleScpIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredRoleScope( RoleScope );
		ArrayList<IBusModelSchemaRoleObj> arrayList = new ArrayList<IBusModelSchemaRoleObj>();
		if( indexBySchRoleScpIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> dict;
			if( indexBySchRoleScpIdx.containsKey( key ) ) {
				dict = indexBySchRoleScpIdx.get( key );
				int len = dict.size();
				IBusModelSchemaRoleObj arr[] = new IBusModelSchemaRoleObj[len];
				Iterator<IBusModelSchemaRoleObj> valIter = dict.values().iterator();
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
			IBusModelSchemaRoleObj obj;
			Iterator<IBusModelSchemaRoleObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaRoleObj> cmp = new Comparator<IBusModelSchemaRoleObj>() {
			@Override
			public int compare( IBusModelSchemaRoleObj lhs, IBusModelSchemaRoleObj rhs ) {
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
	public void deepDisposeSchemaRoleByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelSchemaRoleObj obj = readCachedSchemaRoleByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSchemaRoleByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelSchemaRoleObj obj = readCachedSchemaRoleByUNameIdx( ScopeId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSchemaRoleByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "deepDisposeSchemaRoleByScopeIdx";
		IBusModelSchemaRoleObj obj;
		List<IBusModelSchemaRoleObj> arrayList = readCachedSchemaRoleByScopeIdx( ScopeId );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaRoleObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSchemaRoleByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeSchemaRoleByDefSchemaIdx";
		IBusModelSchemaRoleObj obj;
		List<IBusModelSchemaRoleObj> arrayList = readCachedSchemaRoleByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaRoleObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSchemaRoleByUDefIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		IBusModelSchemaRoleObj obj = readCachedSchemaRoleByUDefIdx( ScopeId,
				DefSchemaId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSchemaRoleBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "deepDisposeSchemaRoleBySchemaIdx";
		IBusModelSchemaRoleObj obj;
		List<IBusModelSchemaRoleObj> arrayList = readCachedSchemaRoleBySchemaIdx( SchemaDefId );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaRoleObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSchemaRoleByRoleScopeIdx( IBusModelPubSchema.RoleScopeEnum RoleScope )
	{
		final String S_ProcName = "deepDisposeSchemaRoleByRoleScopeIdx";
		IBusModelSchemaRoleObj obj;
		List<IBusModelSchemaRoleObj> arrayList = readCachedSchemaRoleByRoleScopeIdx( RoleScope );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaRoleObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSchemaRoleBySchRoleScpIdx( IYCFKeyHash256 SchemaDefId,
		IBusModelPubSchema.RoleScopeEnum RoleScope )
	{
		final String S_ProcName = "deepDisposeSchemaRoleBySchRoleScpIdx";
		IBusModelSchemaRoleObj obj;
		List<IBusModelSchemaRoleObj> arrayList = readCachedSchemaRoleBySchRoleScpIdx( SchemaDefId,
				RoleScope );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaRoleObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelSchemaRoleObj updateSchemaRole( IBusModelSchemaRoleObj Obj ) {
		IBusModelSchemaRoleObj obj = Obj;
		schema.getBusModelBackingStore().getTableSchemaRole().updateSchemaRole( null,
			Obj.getSchemaRoleRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getSchemaRoleTableObj().getClassCode() ) {
			obj = (IBusModelSchemaRoleObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSchemaRole( IBusModelSchemaRoleObj Obj ) {
		IBusModelSchemaRoleObj obj = Obj;
		schema.getBusModelBackingStore().getTableSchemaRole().deleteSchemaRole( null,
			obj.getSchemaRoleRec() );
		Obj.forget();
	}

	@Override
	public void deleteSchemaRoleByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelSchemaRoleObj obj = readSchemaRole(Id);
		if( obj != null ) {
			IBusModelSchemaRoleEditObj editObj = (IBusModelSchemaRoleEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelSchemaRoleEditObj)obj.beginEdit();
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
		deepDisposeSchemaRoleByIdIdx( Id );
	}

	@Override
	public void deleteSchemaRoleByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelRoleDefByUNameIdxKey,
				IBusModelSchemaRoleObj >();
		}
		IBusModelRoleDefByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelSchemaRoleObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaRole().deleteSchemaRoleByUNameIdx( null,
				ScopeId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableSchemaRole().deleteSchemaRoleByUNameIdx( null,
				ScopeId,
				Name );
		}
		deepDisposeSchemaRoleByUNameIdx( ScopeId,
				Name );
	}

	@Override
	public void deleteSchemaRoleByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		IBusModelRoleDefByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelRoleDefByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> dict = indexByScopeIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaRole().deleteSchemaRoleByScopeIdx( null,
				ScopeId );
			Iterator<IBusModelSchemaRoleObj> iter = dict.values().iterator();
			IBusModelSchemaRoleObj obj;
			List<IBusModelSchemaRoleObj> toForget = new LinkedList<IBusModelSchemaRoleObj>();
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
			schema.getBusModelBackingStore().getTableSchemaRole().deleteSchemaRoleByScopeIdx( null,
				ScopeId );
		}
		deepDisposeSchemaRoleByScopeIdx( ScopeId );
	}

	@Override
	public void deleteSchemaRoleByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelRoleDefByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelRoleDefByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaRole().deleteSchemaRoleByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelSchemaRoleObj> iter = dict.values().iterator();
			IBusModelSchemaRoleObj obj;
			List<IBusModelSchemaRoleObj> toForget = new LinkedList<IBusModelSchemaRoleObj>();
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
			schema.getBusModelBackingStore().getTableSchemaRole().deleteSchemaRoleByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeSchemaRoleByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteSchemaRoleByUDefIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		if( indexByUDefIdx == null ) {
			indexByUDefIdx = new HashMap< IBusModelRoleDefByUDefIdxKey,
				IBusModelSchemaRoleObj >();
		}
		IBusModelRoleDefByUDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUDefIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalDefSchemaId( DefSchemaId );
		key.setRequiredName( Name );
		IBusModelSchemaRoleObj obj = null;
		if( indexByUDefIdx.containsKey( key ) ) {
			obj = indexByUDefIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaRole().deleteSchemaRoleByUDefIdx( null,
				ScopeId,
				DefSchemaId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableSchemaRole().deleteSchemaRoleByUDefIdx( null,
				ScopeId,
				DefSchemaId,
				Name );
		}
		deepDisposeSchemaRoleByUDefIdx( ScopeId,
				DefSchemaId,
				Name );
	}

	@Override
	public void deleteSchemaRoleBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		IBusModelSchemaRoleBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< IBusModelSchemaRoleBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > >();
		}
		if( indexBySchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> dict = indexBySchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaRole().deleteSchemaRoleBySchemaIdx( null,
				SchemaDefId );
			Iterator<IBusModelSchemaRoleObj> iter = dict.values().iterator();
			IBusModelSchemaRoleObj obj;
			List<IBusModelSchemaRoleObj> toForget = new LinkedList<IBusModelSchemaRoleObj>();
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
			schema.getBusModelBackingStore().getTableSchemaRole().deleteSchemaRoleBySchemaIdx( null,
				SchemaDefId );
		}
		deepDisposeSchemaRoleBySchemaIdx( SchemaDefId );
	}

	@Override
	public void deleteSchemaRoleByRoleScopeIdx( IBusModelPubSchema.RoleScopeEnum RoleScope )
	{
		IBusModelSchemaRoleByRoleScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newByRoleScopeIdxKey();
		key.setRequiredRoleScope( RoleScope );
		if( indexByRoleScopeIdx == null ) {
			indexByRoleScopeIdx = new HashMap< IBusModelSchemaRoleByRoleScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > >();
		}
		if( indexByRoleScopeIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> dict = indexByRoleScopeIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaRole().deleteSchemaRoleByRoleScopeIdx( null,
				RoleScope );
			Iterator<IBusModelSchemaRoleObj> iter = dict.values().iterator();
			IBusModelSchemaRoleObj obj;
			List<IBusModelSchemaRoleObj> toForget = new LinkedList<IBusModelSchemaRoleObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByRoleScopeIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableSchemaRole().deleteSchemaRoleByRoleScopeIdx( null,
				RoleScope );
		}
		deepDisposeSchemaRoleByRoleScopeIdx( RoleScope );
	}

	@Override
	public void deleteSchemaRoleBySchRoleScpIdx( IYCFKeyHash256 SchemaDefId,
		IBusModelPubSchema.RoleScopeEnum RoleScope )
	{
		IBusModelSchemaRoleBySchRoleScpIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newBySchRoleScpIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		key.setRequiredRoleScope( RoleScope );
		if( indexBySchRoleScpIdx == null ) {
			indexBySchRoleScpIdx = new HashMap< IBusModelSchemaRoleBySchRoleScpIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj > >();
		}
		if( indexBySchRoleScpIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRoleObj> dict = indexBySchRoleScpIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaRole().deleteSchemaRoleBySchRoleScpIdx( null,
				SchemaDefId,
				RoleScope );
			Iterator<IBusModelSchemaRoleObj> iter = dict.values().iterator();
			IBusModelSchemaRoleObj obj;
			List<IBusModelSchemaRoleObj> toForget = new LinkedList<IBusModelSchemaRoleObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexBySchRoleScpIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableSchemaRole().deleteSchemaRoleBySchRoleScpIdx( null,
				SchemaDefId,
				RoleScope );
		}
		deepDisposeSchemaRoleBySchRoleScpIdx( SchemaDefId,
				RoleScope );
	}
}