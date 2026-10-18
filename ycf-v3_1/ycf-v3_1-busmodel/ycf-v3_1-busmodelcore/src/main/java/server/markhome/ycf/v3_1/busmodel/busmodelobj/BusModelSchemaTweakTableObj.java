// Description: Java 25 Table Object implementation for SchemaTweak.

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

public class BusModelSchemaTweakTableObj
	implements IBusModelSchemaTweakTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelSchemaTweak.CLASS_CODE;
	protected static final int backingClassCode = IBusModelSchemaTweak.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj> allSchemaTweak;
	private Map< IBusModelTweakByUNameIdxKey,
		IBusModelSchemaTweakObj > indexByUNameIdx;
	private Map< IBusModelTweakByValTentIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > > indexByValTentIdx;
	private Map< IBusModelTweakByScopeIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > > indexByScopeIdx;
	private Map< IBusModelTweakByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > > indexByDefSchemaIdx;
	private Map< IBusModelTweakByUDefIdxKey,
		IBusModelSchemaTweakObj > indexByUDefIdx;
	private Map< IBusModelSchemaTweakBySchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > > indexBySchemaIdx;
	public static String TABLE_NAME = "SchemaTweak";
	public static String TABLE_DBNAME = "schtwk";

	public BusModelSchemaTweakTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj>();
		allSchemaTweak = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByUDefIdx = null;
		indexBySchemaIdx = null;
	}

	public BusModelSchemaTweakTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj>();
		allSchemaTweak = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByUDefIdx = null;
		indexBySchemaIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelSchemaTweakTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelSchemaTweakTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allSchemaTweak = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByUDefIdx = null;
		indexBySchemaIdx = null;
		List<IBusModelSchemaTweakObj> toForget = new LinkedList<IBusModelSchemaTweakObj>();
		IBusModelSchemaTweakObj cur = null;
		Iterator<IBusModelSchemaTweakObj> iter = members.values().iterator();
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
	 *	BusModelSchemaTweakObj.
	 */
	@Override
	public IBusModelSchemaTweakObj newInstance() {
		IBusModelSchemaTweakObj inst = new BusModelSchemaTweakObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSchemaTweakObj.
	 */
	@Override
	public IBusModelSchemaTweakEditObj newEditInstance( IBusModelSchemaTweakObj orig ) {
		IBusModelSchemaTweakEditObj edit = new BusModelSchemaTweakEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelSchemaTweakObj realiseSchemaTweak( IBusModelSchemaTweakObj Obj ) {
		IBusModelSchemaTweakObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelSchemaTweakObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelSchemaTweakObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				IBusModelTweakByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByValTentIdx != null ) {
				IBusModelTweakByValTentIdxKey keyValTentIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				IBusModelTweakByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelTweakByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByUDefIdx != null ) {
				IBusModelTweakByUDefIdxKey keyUDefIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUDefIdxKey();
				keyUDefIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUDefIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUDefIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyUDefIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				keyUDefIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUDefIdx.remove( keyUDefIdx );
			}

			if( indexBySchemaIdx != null ) {
				IBusModelSchemaTweakBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaTweak().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
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
			keepObj = (IBusModelSchemaTweakObj)schema.getTweakTableObj().realiseTweak( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				IBusModelTweakByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByValTentIdx != null ) {
				IBusModelTweakByValTentIdxKey keyValTentIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				IBusModelTweakByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelTweakByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUDefIdx != null ) {
				IBusModelTweakByUDefIdxKey keyUDefIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUDefIdxKey();
				keyUDefIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUDefIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUDefIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyUDefIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				keyUDefIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUDefIdx.put( keyUDefIdx, keepObj );
			}

			if( indexBySchemaIdx != null ) {
				IBusModelSchemaTweakBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaTweak().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSchemaTweak != null ) {
				allSchemaTweak.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelSchemaTweakObj)schema.getTweakTableObj().realiseTweak( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSchemaTweak != null ) {
				allSchemaTweak.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				IBusModelTweakByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByValTentIdx != null ) {
				IBusModelTweakByValTentIdxKey keyValTentIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByValTentIdxKey();
				keyValTentIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				IBusModelTweakByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelTweakByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUDefIdx != null ) {
				IBusModelTweakByUDefIdxKey keyUDefIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUDefIdxKey();
				keyUDefIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				keyUDefIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUDefIdx.setOptionalDefSchemaTenantId( keepObj.getOptionalDefSchemaTenantId() );
				keyUDefIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				keyUDefIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUDefIdx.put( keyUDefIdx, keepObj );
			}

			if( indexBySchemaIdx != null ) {
				IBusModelSchemaTweakBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaTweak().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaDefId( keepObj.getRequiredSchemaDefId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelSchemaTweakObj createSchemaTweak( IBusModelSchemaTweakObj Obj ) {
		IBusModelSchemaTweakObj obj = Obj;
		IBusModelSchemaTweak rec = obj.getSchemaTweakRec();
		schema.getBusModelBackingStore().getTableSchemaTweak().createSchemaTweak(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelSchemaTweakObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelSchemaTweakObj readSchemaTweak( $implCommaIJavaOptAtomType$ pkey ) {
		return( readSchemaTweak( pkey, false ) );
	}

	@Override
	public IBusModelSchemaTweakObj readSchemaTweak( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelSchemaTweakObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelSchemaTweak readRec = schema.getBusModelBackingStore().getTableSchemaTweak().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelSchemaTweakObj)schema.getTweakTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelSchemaTweakObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelSchemaTweakObj readCachedSchemaTweak( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelSchemaTweakObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSchemaTweak( IBusModelSchemaTweakObj obj )
	{
		final String S_ProcName = "BusModelSchemaTweakTableObj.reallyDeepDisposeSchemaTweak() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelSchemaTweakObj existing = readCachedSchemaTweak( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelSchemaTweakBySchemaIdxKey keySchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaTweak().newBySchemaIdxKey();
		keySchemaIdx.setRequiredSchemaDefId( existing.getRequiredSchemaDefId() );



		if( indexBySchemaIdx != null ) {
			if( indexBySchemaIdx.containsKey( keySchemaIdx ) ) {
				indexBySchemaIdx.get( keySchemaIdx ).remove( pkey );
				if( indexBySchemaIdx.get( keySchemaIdx ).size() <= 0 ) {
					indexBySchemaIdx.remove( keySchemaIdx );
				}
			}
		}


		schema.getTweakTableObj().reallyDeepDisposeTweak( obj );
	}
	@Override
	public void deepDisposeSchemaTweak( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelSchemaTweakObj obj = readCachedSchemaTweak( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelSchemaTweakObj lockSchemaTweak( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelSchemaTweakObj locked = null;
		IBusModelSchemaTweak lockRec = schema.getBusModelBackingStore().getTableSchemaTweak().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelSchemaTweakObj)schema.getTweakTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelSchemaTweakObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSchemaTweak", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelSchemaTweakObj> readAllSchemaTweak() {
		return( readAllSchemaTweak( false ) );
	}

	@Override
	public List<IBusModelSchemaTweakObj> readAllSchemaTweak( boolean forceRead ) {
		final String S_ProcName = "readAllSchemaTweak";
		if( ( allSchemaTweak == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelSchemaTweakObj>();
			allSchemaTweak = map;
			IBusModelSchemaTweak[] recList = schema.getBusModelBackingStore().getTableSchemaTweak().readAllDerived( null );
			IBusModelSchemaTweak rec;
			IBusModelSchemaTweakObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaTweakObj realised = (IBusModelSchemaTweakObj)obj.realise();
			}
		}
		int len = allSchemaTweak.size();
		IBusModelSchemaTweakObj arr[] = new IBusModelSchemaTweakObj[len];
		Iterator<IBusModelSchemaTweakObj> valIter = allSchemaTweak.values().iterator();
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
		ArrayList<IBusModelSchemaTweakObj> arrayList = new ArrayList<IBusModelSchemaTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaTweakObj> cmp = new Comparator<IBusModelSchemaTweakObj>() {
			@Override
			public int compare( IBusModelSchemaTweakObj lhs, IBusModelSchemaTweakObj rhs ) {
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
		List<IBusModelSchemaTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelSchemaTweakObj> readCachedAllSchemaTweak() {
		final String S_ProcName = "readCachedAllSchemaTweak";
		ArrayList<IBusModelSchemaTweakObj> arrayList = new ArrayList<IBusModelSchemaTweakObj>();
		if( allSchemaTweak != null ) {
			int len = allSchemaTweak.size();
			IBusModelSchemaTweakObj arr[] = new IBusModelSchemaTweakObj[len];
			Iterator<IBusModelSchemaTweakObj> valIter = allSchemaTweak.values().iterator();
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
		Comparator<IBusModelSchemaTweakObj> cmp = new Comparator<IBusModelSchemaTweakObj>() {
			public int compare( IBusModelSchemaTweakObj lhs, IBusModelSchemaTweakObj rhs ) {
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
	public IBusModelSchemaTweakObj readSchemaTweakByIdIdx( IYCFKeyHash256 Id )
	{
		return( readSchemaTweakByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelSchemaTweakObj readSchemaTweakByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelSchemaTweakObj obj = readSchemaTweak( Id, forceRead );
		return( obj );
	}

	@Override
	public IBusModelSchemaTweakObj readSchemaTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		return( readSchemaTweakByUNameIdx( ScopeId,
			Name,
			false ) );
	}

	@Override
	public IBusModelSchemaTweakObj readSchemaTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelTweakByUNameIdxKey,
				IBusModelSchemaTweakObj >();
		}
		IBusModelTweakByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelSchemaTweakObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelTweak rec = schema.getBusModelBackingStore().getTableTweak().readDerivedByUNameIdx( null,
				ScopeId,
				Name );
			if( rec != null ) {
				obj = (IBusModelSchemaTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelSchemaTweakObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelSchemaTweakObj> readSchemaTweakByValTentIdx( IYCFKeyHash256 TenantId )
	{
		return( readSchemaTweakByValTentIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelSchemaTweakObj> readSchemaTweakByValTentIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaTweakByValTentIdx";
		IBusModelTweakByValTentIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj> dict;
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< IBusModelTweakByValTentIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > >();
		}
		if( ( ! forceRead ) && indexByValTentIdx.containsKey( key ) ) {
			dict = indexByValTentIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj>();
			IBusModelTweakObj obj;
			IBusModelTweak[] recList = schema.getBusModelBackingStore().getTableTweak().readDerivedByValTentIdx( null,
				TenantId );
			IBusModelTweak rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaTweakObj realised = (IBusModelSchemaTweakObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByValTentIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaTweakObj arr[] = new IBusModelSchemaTweakObj[len];
		Iterator<IBusModelSchemaTweakObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaTweakObj> arrayList = new ArrayList<IBusModelSchemaTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaTweakObj> cmp = new Comparator<IBusModelSchemaTweakObj>() {
			@Override
			public int compare( IBusModelSchemaTweakObj lhs, IBusModelSchemaTweakObj rhs ) {
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
		List<IBusModelSchemaTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelSchemaTweakObj> readSchemaTweakByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		return( readSchemaTweakByScopeIdx( ScopeId,
			false ) );
	}

	@Override
	public List<IBusModelSchemaTweakObj> readSchemaTweakByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaTweakByScopeIdx";
		IBusModelTweakByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelTweakByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj>();
			IBusModelTweakObj obj;
			IBusModelTweak[] recList = schema.getBusModelBackingStore().getTableTweak().readDerivedByScopeIdx( null,
				ScopeId );
			IBusModelTweak rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaTweakObj realised = (IBusModelSchemaTweakObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaTweakObj arr[] = new IBusModelSchemaTweakObj[len];
		Iterator<IBusModelSchemaTweakObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaTweakObj> arrayList = new ArrayList<IBusModelSchemaTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaTweakObj> cmp = new Comparator<IBusModelSchemaTweakObj>() {
			@Override
			public int compare( IBusModelSchemaTweakObj lhs, IBusModelSchemaTweakObj rhs ) {
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
		List<IBusModelSchemaTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelSchemaTweakObj> readSchemaTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readSchemaTweakByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelSchemaTweakObj> readSchemaTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaTweakByDefSchemaIdx";
		IBusModelTweakByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelTweakByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj>();
			IBusModelTweakObj obj;
			IBusModelTweak[] recList = schema.getBusModelBackingStore().getTableTweak().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelTweak rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaTweakObj realised = (IBusModelSchemaTweakObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaTweakObj arr[] = new IBusModelSchemaTweakObj[len];
		Iterator<IBusModelSchemaTweakObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaTweakObj> arrayList = new ArrayList<IBusModelSchemaTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaTweakObj> cmp = new Comparator<IBusModelSchemaTweakObj>() {
			@Override
			public int compare( IBusModelSchemaTweakObj lhs, IBusModelSchemaTweakObj rhs ) {
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
		List<IBusModelSchemaTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelSchemaTweakObj readSchemaTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		return( readSchemaTweakByUDefIdx( TenantId,
			ScopeId,
			DefSchemaTenantId,
			DefSchemaId,
			Name,
			false ) );
	}

	@Override
	public IBusModelSchemaTweakObj readSchemaTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name, boolean forceRead )
	{
		if( indexByUDefIdx == null ) {
			indexByUDefIdx = new HashMap< IBusModelTweakByUDefIdxKey,
				IBusModelSchemaTweakObj >();
		}
		IBusModelTweakByUDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUDefIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		key.setRequiredName( Name );
		IBusModelSchemaTweakObj obj = null;
		if( ( ! forceRead ) && indexByUDefIdx.containsKey( key ) ) {
			obj = indexByUDefIdx.get( key );
		}
		else {
			IBusModelTweak rec = schema.getBusModelBackingStore().getTableTweak().readDerivedByUDefIdx( null,
				TenantId,
				ScopeId,
				DefSchemaTenantId,
				DefSchemaId,
				Name );
			if( rec != null ) {
				obj = (IBusModelSchemaTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelSchemaTweakObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelSchemaTweakObj> readSchemaTweakBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		return( readSchemaTweakBySchemaIdx( SchemaDefId,
			false ) );
	}

	@Override
	public List<IBusModelSchemaTweakObj> readSchemaTweakBySchemaIdx( IYCFKeyHash256 SchemaDefId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaTweakBySchemaIdx";
		IBusModelSchemaTweakBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaTweak().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj> dict;
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< IBusModelSchemaTweakBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > >();
		}
		if( ( ! forceRead ) && indexBySchemaIdx.containsKey( key ) ) {
			dict = indexBySchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj>();
			IBusModelSchemaTweakObj obj;
			IBusModelSchemaTweak[] recList = schema.getBusModelBackingStore().getTableSchemaTweak().readDerivedBySchemaIdx( null,
				SchemaDefId );
			IBusModelSchemaTweak rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaTweakObj realised = (IBusModelSchemaTweakObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaTweakObj arr[] = new IBusModelSchemaTweakObj[len];
		Iterator<IBusModelSchemaTweakObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaTweakObj> arrayList = new ArrayList<IBusModelSchemaTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaTweakObj> cmp = new Comparator<IBusModelSchemaTweakObj>() {
			@Override
			public int compare( IBusModelSchemaTweakObj lhs, IBusModelSchemaTweakObj rhs ) {
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
		List<IBusModelSchemaTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelSchemaTweakObj readCachedSchemaTweakByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelSchemaTweakObj obj = null;
		obj = readCachedSchemaTweak( Id );
		return( obj );
	}

	@Override
	public IBusModelSchemaTweakObj readCachedSchemaTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelSchemaTweakObj obj = null;
		IBusModelTweakByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelSchemaTweakObj> valIter = members.values().iterator();
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
			Iterator<IBusModelSchemaTweakObj> valIter = members.values().iterator();
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
	public List<IBusModelSchemaTweakObj> readCachedSchemaTweakByValTentIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedSchemaTweakByValTentIdx";
		IBusModelTweakByValTentIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelSchemaTweakObj> arrayList = new ArrayList<IBusModelSchemaTweakObj>();
		if( indexByValTentIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj> dict;
			if( indexByValTentIdx.containsKey( key ) ) {
				dict = indexByValTentIdx.get( key );
				int len = dict.size();
				IBusModelSchemaTweakObj arr[] = new IBusModelSchemaTweakObj[len];
				Iterator<IBusModelSchemaTweakObj> valIter = dict.values().iterator();
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
			IBusModelSchemaTweakObj obj;
			Iterator<IBusModelSchemaTweakObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaTweakObj> cmp = new Comparator<IBusModelSchemaTweakObj>() {
			@Override
			public int compare( IBusModelSchemaTweakObj lhs, IBusModelSchemaTweakObj rhs ) {
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
	public List<IBusModelSchemaTweakObj> readCachedSchemaTweakByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "readCachedSchemaTweakByScopeIdx";
		IBusModelTweakByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		ArrayList<IBusModelSchemaTweakObj> arrayList = new ArrayList<IBusModelSchemaTweakObj>();
		if( indexByScopeIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj> dict;
			if( indexByScopeIdx.containsKey( key ) ) {
				dict = indexByScopeIdx.get( key );
				int len = dict.size();
				IBusModelSchemaTweakObj arr[] = new IBusModelSchemaTweakObj[len];
				Iterator<IBusModelSchemaTweakObj> valIter = dict.values().iterator();
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
			IBusModelSchemaTweakObj obj;
			Iterator<IBusModelSchemaTweakObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaTweakObj> cmp = new Comparator<IBusModelSchemaTweakObj>() {
			@Override
			public int compare( IBusModelSchemaTweakObj lhs, IBusModelSchemaTweakObj rhs ) {
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
	public List<IBusModelSchemaTweakObj> readCachedSchemaTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedSchemaTweakByDefSchemaIdx";
		IBusModelTweakByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelSchemaTweakObj> arrayList = new ArrayList<IBusModelSchemaTweakObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelSchemaTweakObj arr[] = new IBusModelSchemaTweakObj[len];
				Iterator<IBusModelSchemaTweakObj> valIter = dict.values().iterator();
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
			IBusModelSchemaTweakObj obj;
			Iterator<IBusModelSchemaTweakObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaTweakObj> cmp = new Comparator<IBusModelSchemaTweakObj>() {
			@Override
			public int compare( IBusModelSchemaTweakObj lhs, IBusModelSchemaTweakObj rhs ) {
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
	public IBusModelSchemaTweakObj readCachedSchemaTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		IBusModelSchemaTweakObj obj = null;
		IBusModelTweakByUDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUDefIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		key.setRequiredName( Name );
		if( indexByUDefIdx != null ) {
			if( indexByUDefIdx.containsKey( key ) ) {
				obj = indexByUDefIdx.get( key );
			}
			else {
				Iterator<IBusModelSchemaTweakObj> valIter = members.values().iterator();
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
			Iterator<IBusModelSchemaTweakObj> valIter = members.values().iterator();
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
	public List<IBusModelSchemaTweakObj> readCachedSchemaTweakBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "readCachedSchemaTweakBySchemaIdx";
		IBusModelSchemaTweakBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaTweak().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		ArrayList<IBusModelSchemaTweakObj> arrayList = new ArrayList<IBusModelSchemaTweakObj>();
		if( indexBySchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj> dict;
			if( indexBySchemaIdx.containsKey( key ) ) {
				dict = indexBySchemaIdx.get( key );
				int len = dict.size();
				IBusModelSchemaTweakObj arr[] = new IBusModelSchemaTweakObj[len];
				Iterator<IBusModelSchemaTweakObj> valIter = dict.values().iterator();
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
			IBusModelSchemaTweakObj obj;
			Iterator<IBusModelSchemaTweakObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaTweakObj> cmp = new Comparator<IBusModelSchemaTweakObj>() {
			@Override
			public int compare( IBusModelSchemaTweakObj lhs, IBusModelSchemaTweakObj rhs ) {
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
	public void deepDisposeSchemaTweakByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelSchemaTweakObj obj = readCachedSchemaTweakByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSchemaTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelSchemaTweakObj obj = readCachedSchemaTweakByUNameIdx( ScopeId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSchemaTweakByValTentIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeSchemaTweakByValTentIdx";
		IBusModelSchemaTweakObj obj;
		List<IBusModelSchemaTweakObj> arrayList = readCachedSchemaTweakByValTentIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaTweakObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSchemaTweakByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "deepDisposeSchemaTweakByScopeIdx";
		IBusModelSchemaTweakObj obj;
		List<IBusModelSchemaTweakObj> arrayList = readCachedSchemaTweakByScopeIdx( ScopeId );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaTweakObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSchemaTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeSchemaTweakByDefSchemaIdx";
		IBusModelSchemaTweakObj obj;
		List<IBusModelSchemaTweakObj> arrayList = readCachedSchemaTweakByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaTweakObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSchemaTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		IBusModelSchemaTweakObj obj = readCachedSchemaTweakByUDefIdx( TenantId,
				ScopeId,
				DefSchemaTenantId,
				DefSchemaId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSchemaTweakBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		final String S_ProcName = "deepDisposeSchemaTweakBySchemaIdx";
		IBusModelSchemaTweakObj obj;
		List<IBusModelSchemaTweakObj> arrayList = readCachedSchemaTweakBySchemaIdx( SchemaDefId );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaTweakObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelSchemaTweakObj updateSchemaTweak( IBusModelSchemaTweakObj Obj ) {
		IBusModelSchemaTweakObj obj = Obj;
		schema.getBusModelBackingStore().getTableSchemaTweak().updateSchemaTweak( null,
			Obj.getSchemaTweakRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getSchemaTweakTableObj().getClassCode() ) {
			obj = (IBusModelSchemaTweakObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSchemaTweak( IBusModelSchemaTweakObj Obj ) {
		IBusModelSchemaTweakObj obj = Obj;
		schema.getBusModelBackingStore().getTableSchemaTweak().deleteSchemaTweak( null,
			obj.getSchemaTweakRec() );
		Obj.forget();
	}

	@Override
	public void deleteSchemaTweakByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelSchemaTweakObj obj = readSchemaTweak(Id);
		if( obj != null ) {
			IBusModelSchemaTweakEditObj editObj = (IBusModelSchemaTweakEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelSchemaTweakEditObj)obj.beginEdit();
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
		deepDisposeSchemaTweakByIdIdx( Id );
	}

	@Override
	public void deleteSchemaTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelTweakByUNameIdxKey,
				IBusModelSchemaTweakObj >();
		}
		IBusModelTweakByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelSchemaTweakObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaTweak().deleteSchemaTweakByUNameIdx( null,
				ScopeId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableSchemaTweak().deleteSchemaTweakByUNameIdx( null,
				ScopeId,
				Name );
		}
		deepDisposeSchemaTweakByUNameIdx( ScopeId,
				Name );
	}

	@Override
	public void deleteSchemaTweakByValTentIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelTweakByValTentIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< IBusModelTweakByValTentIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > >();
		}
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj> dict = indexByValTentIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaTweak().deleteSchemaTweakByValTentIdx( null,
				TenantId );
			Iterator<IBusModelSchemaTweakObj> iter = dict.values().iterator();
			IBusModelSchemaTweakObj obj;
			List<IBusModelSchemaTweakObj> toForget = new LinkedList<IBusModelSchemaTweakObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByValTentIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableSchemaTweak().deleteSchemaTweakByValTentIdx( null,
				TenantId );
		}
		deepDisposeSchemaTweakByValTentIdx( TenantId );
	}

	@Override
	public void deleteSchemaTweakByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		IBusModelTweakByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelTweakByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj> dict = indexByScopeIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaTweak().deleteSchemaTweakByScopeIdx( null,
				ScopeId );
			Iterator<IBusModelSchemaTweakObj> iter = dict.values().iterator();
			IBusModelSchemaTweakObj obj;
			List<IBusModelSchemaTweakObj> toForget = new LinkedList<IBusModelSchemaTweakObj>();
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
			schema.getBusModelBackingStore().getTableSchemaTweak().deleteSchemaTweakByScopeIdx( null,
				ScopeId );
		}
		deepDisposeSchemaTweakByScopeIdx( ScopeId );
	}

	@Override
	public void deleteSchemaTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelTweakByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelTweakByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaTweak().deleteSchemaTweakByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelSchemaTweakObj> iter = dict.values().iterator();
			IBusModelSchemaTweakObj obj;
			List<IBusModelSchemaTweakObj> toForget = new LinkedList<IBusModelSchemaTweakObj>();
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
			schema.getBusModelBackingStore().getTableSchemaTweak().deleteSchemaTweakByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeSchemaTweakByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteSchemaTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		if( indexByUDefIdx == null ) {
			indexByUDefIdx = new HashMap< IBusModelTweakByUDefIdxKey,
				IBusModelSchemaTweakObj >();
		}
		IBusModelTweakByUDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUDefIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		key.setRequiredName( Name );
		IBusModelSchemaTweakObj obj = null;
		if( indexByUDefIdx.containsKey( key ) ) {
			obj = indexByUDefIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaTweak().deleteSchemaTweakByUDefIdx( null,
				TenantId,
				ScopeId,
				DefSchemaTenantId,
				DefSchemaId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableSchemaTweak().deleteSchemaTweakByUDefIdx( null,
				TenantId,
				ScopeId,
				DefSchemaTenantId,
				DefSchemaId,
				Name );
		}
		deepDisposeSchemaTweakByUDefIdx( TenantId,
				ScopeId,
				DefSchemaTenantId,
				DefSchemaId,
				Name );
	}

	@Override
	public void deleteSchemaTweakBySchemaIdx( IYCFKeyHash256 SchemaDefId )
	{
		IBusModelSchemaTweakBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaTweak().newBySchemaIdxKey();
		key.setRequiredSchemaDefId( SchemaDefId );
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< IBusModelSchemaTweakBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj > >();
		}
		if( indexBySchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaTweakObj> dict = indexBySchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaTweak().deleteSchemaTweakBySchemaIdx( null,
				SchemaDefId );
			Iterator<IBusModelSchemaTweakObj> iter = dict.values().iterator();
			IBusModelSchemaTweakObj obj;
			List<IBusModelSchemaTweakObj> toForget = new LinkedList<IBusModelSchemaTweakObj>();
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
			schema.getBusModelBackingStore().getTableSchemaTweak().deleteSchemaTweakBySchemaIdx( null,
				SchemaDefId );
		}
		deepDisposeSchemaTweakBySchemaIdx( SchemaDefId );
	}
}