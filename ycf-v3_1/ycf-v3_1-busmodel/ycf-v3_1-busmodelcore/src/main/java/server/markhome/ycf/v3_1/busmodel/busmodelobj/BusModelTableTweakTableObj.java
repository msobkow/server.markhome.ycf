// Description: Java 25 Table Object implementation for TableTweak.

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

public class BusModelTableTweakTableObj
	implements IBusModelTableTweakTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelTableTweak.CLASS_CODE;
	protected static final int backingClassCode = IBusModelTableTweak.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj> allTableTweak;
	private Map< IBusModelTweakByUNameIdxKey,
		IBusModelTableTweakObj > indexByUNameIdx;
	private Map< IBusModelTweakByValTentIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj > > indexByValTentIdx;
	private Map< IBusModelTweakByScopeIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj > > indexByScopeIdx;
	private Map< IBusModelTweakByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj > > indexByDefSchemaIdx;
	private Map< IBusModelTweakByUDefIdxKey,
		IBusModelTableTweakObj > indexByUDefIdx;
	private Map< IBusModelTableTweakByTableIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj > > indexByTableIdx;
	public static String TABLE_NAME = "TableTweak";
	public static String TABLE_DBNAME = "tbltwk";

	public BusModelTableTweakTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj>();
		allTableTweak = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByUDefIdx = null;
		indexByTableIdx = null;
	}

	public BusModelTableTweakTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj>();
		allTableTweak = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByUDefIdx = null;
		indexByTableIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelTableTweakTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelTableTweakTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allTableTweak = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByUDefIdx = null;
		indexByTableIdx = null;
		List<IBusModelTableTweakObj> toForget = new LinkedList<IBusModelTableTweakObj>();
		IBusModelTableTweakObj cur = null;
		Iterator<IBusModelTableTweakObj> iter = members.values().iterator();
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
	 *	BusModelTableTweakObj.
	 */
	@Override
	public IBusModelTableTweakObj newInstance() {
		IBusModelTableTweakObj inst = new BusModelTableTweakObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelTableTweakObj.
	 */
	@Override
	public IBusModelTableTweakEditObj newEditInstance( IBusModelTableTweakObj orig ) {
		IBusModelTableTweakEditObj edit = new BusModelTableTweakEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelTableTweakObj realiseTableTweak( IBusModelTableTweakObj Obj ) {
		IBusModelTableTweakObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelTableTweakObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelTableTweakObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				IBusModelTweakByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelTweakByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
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

			if( indexByTableIdx != null ) {
				IBusModelTableTweakByTableIdxKey keyTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTableTweak().newByTableIdxKey();
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
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
			keepObj = (IBusModelTableTweakObj)schema.getTweakTableObj().realiseTweak( Obj );

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
				Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				IBusModelTweakByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelTweakByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
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

			if( indexByTableIdx != null ) {
				IBusModelTableTweakByTableIdxKey keyTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTableTweak().newByTableIdxKey();
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allTableTweak != null ) {
				allTableTweak.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelTableTweakObj)schema.getTweakTableObj().realiseTweak( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTableTweak != null ) {
				allTableTweak.put( keepObj.getPKey(), keepObj );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				IBusModelTweakByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelTweakByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
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

			if( indexByTableIdx != null ) {
				IBusModelTableTweakByTableIdxKey keyTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTableTweak().newByTableIdxKey();
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelTableTweakObj createTableTweak( IBusModelTableTweakObj Obj ) {
		IBusModelTableTweakObj obj = Obj;
		IBusModelTableTweak rec = obj.getTableTweakRec();
		schema.getBusModelBackingStore().getTableTableTweak().createTableTweak(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelTableTweakObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelTableTweakObj readTableTweak( $implCommaIJavaOptAtomType$ pkey ) {
		return( readTableTweak( pkey, false ) );
	}

	@Override
	public IBusModelTableTweakObj readTableTweak( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelTableTweakObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelTableTweak readRec = schema.getBusModelBackingStore().getTableTableTweak().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelTableTweakObj)schema.getTweakTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelTableTweakObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelTableTweakObj readCachedTableTweak( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelTableTweakObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeTableTweak( IBusModelTableTweakObj obj )
	{
		final String S_ProcName = "BusModelTableTweakTableObj.reallyDeepDisposeTableTweak() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelTableTweakObj existing = readCachedTableTweak( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelTableTweakByTableIdxKey keyTableIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTableTweak().newByTableIdxKey();
		keyTableIdx.setRequiredTableId( existing.getRequiredTableId() );



		if( indexByTableIdx != null ) {
			if( indexByTableIdx.containsKey( keyTableIdx ) ) {
				indexByTableIdx.get( keyTableIdx ).remove( pkey );
				if( indexByTableIdx.get( keyTableIdx ).size() <= 0 ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}
		}


		schema.getTweakTableObj().reallyDeepDisposeTweak( obj );
	}
	@Override
	public void deepDisposeTableTweak( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelTableTweakObj obj = readCachedTableTweak( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelTableTweakObj lockTableTweak( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelTableTweakObj locked = null;
		IBusModelTableTweak lockRec = schema.getBusModelBackingStore().getTableTableTweak().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelTableTweakObj)schema.getTweakTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelTableTweakObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockTableTweak", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelTableTweakObj> readAllTableTweak() {
		return( readAllTableTweak( false ) );
	}

	@Override
	public List<IBusModelTableTweakObj> readAllTableTweak( boolean forceRead ) {
		final String S_ProcName = "readAllTableTweak";
		if( ( allTableTweak == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelTableTweakObj>();
			allTableTweak = map;
			IBusModelTableTweak[] recList = schema.getBusModelBackingStore().getTableTableTweak().readAllDerived( null );
			IBusModelTableTweak rec;
			IBusModelTableTweakObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTableTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTableTweakObj realised = (IBusModelTableTweakObj)obj.realise();
			}
		}
		int len = allTableTweak.size();
		IBusModelTableTweakObj arr[] = new IBusModelTableTweakObj[len];
		Iterator<IBusModelTableTweakObj> valIter = allTableTweak.values().iterator();
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
		ArrayList<IBusModelTableTweakObj> arrayList = new ArrayList<IBusModelTableTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTableTweakObj> cmp = new Comparator<IBusModelTableTweakObj>() {
			@Override
			public int compare( IBusModelTableTweakObj lhs, IBusModelTableTweakObj rhs ) {
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
		List<IBusModelTableTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTableTweakObj> readCachedAllTableTweak() {
		final String S_ProcName = "readCachedAllTableTweak";
		ArrayList<IBusModelTableTweakObj> arrayList = new ArrayList<IBusModelTableTweakObj>();
		if( allTableTweak != null ) {
			int len = allTableTweak.size();
			IBusModelTableTweakObj arr[] = new IBusModelTableTweakObj[len];
			Iterator<IBusModelTableTweakObj> valIter = allTableTweak.values().iterator();
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
		Comparator<IBusModelTableTweakObj> cmp = new Comparator<IBusModelTableTweakObj>() {
			public int compare( IBusModelTableTweakObj lhs, IBusModelTableTweakObj rhs ) {
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
	public IBusModelTableTweakObj readTableTweakByIdIdx( IYCFKeyHash256 Id )
	{
		return( readTableTweakByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelTableTweakObj readTableTweakByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelTableTweakObj obj = readTableTweak( Id, forceRead );
		return( obj );
	}

	@Override
	public IBusModelTableTweakObj readTableTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		return( readTableTweakByUNameIdx( ScopeId,
			Name,
			false ) );
	}

	@Override
	public IBusModelTableTweakObj readTableTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelTweakByUNameIdxKey,
				IBusModelTableTweakObj >();
		}
		IBusModelTweakByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelTableTweakObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelTweak rec = schema.getBusModelBackingStore().getTableTweak().readDerivedByUNameIdx( null,
				ScopeId,
				Name );
			if( rec != null ) {
				obj = (IBusModelTableTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelTableTweakObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelTableTweakObj> readTableTweakByValTentIdx( IYCFKeyHash256 TenantId )
	{
		return( readTableTweakByValTentIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelTableTweakObj> readTableTweakByValTentIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableTweakByValTentIdx";
		IBusModelTweakByValTentIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj> dict;
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< IBusModelTweakByValTentIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableTweakObj > >();
		}
		if( ( ! forceRead ) && indexByValTentIdx.containsKey( key ) ) {
			dict = indexByValTentIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj>();
			IBusModelTweakObj obj;
			IBusModelTweak[] recList = schema.getBusModelBackingStore().getTableTweak().readDerivedByValTentIdx( null,
				TenantId );
			IBusModelTweak rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTableTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTableTweakObj realised = (IBusModelTableTweakObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByValTentIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTableTweakObj arr[] = new IBusModelTableTweakObj[len];
		Iterator<IBusModelTableTweakObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTableTweakObj> arrayList = new ArrayList<IBusModelTableTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTableTweakObj> cmp = new Comparator<IBusModelTableTweakObj>() {
			@Override
			public int compare( IBusModelTableTweakObj lhs, IBusModelTableTweakObj rhs ) {
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
		List<IBusModelTableTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTableTweakObj> readTableTweakByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		return( readTableTweakByScopeIdx( ScopeId,
			false ) );
	}

	@Override
	public List<IBusModelTableTweakObj> readTableTweakByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableTweakByScopeIdx";
		IBusModelTweakByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelTweakByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableTweakObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj>();
			IBusModelTweakObj obj;
			IBusModelTweak[] recList = schema.getBusModelBackingStore().getTableTweak().readDerivedByScopeIdx( null,
				ScopeId );
			IBusModelTweak rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTableTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTableTweakObj realised = (IBusModelTableTweakObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTableTweakObj arr[] = new IBusModelTableTweakObj[len];
		Iterator<IBusModelTableTweakObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTableTweakObj> arrayList = new ArrayList<IBusModelTableTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTableTweakObj> cmp = new Comparator<IBusModelTableTweakObj>() {
			@Override
			public int compare( IBusModelTableTweakObj lhs, IBusModelTableTweakObj rhs ) {
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
		List<IBusModelTableTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTableTweakObj> readTableTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readTableTweakByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelTableTweakObj> readTableTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableTweakByDefSchemaIdx";
		IBusModelTweakByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelTweakByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableTweakObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj>();
			IBusModelTweakObj obj;
			IBusModelTweak[] recList = schema.getBusModelBackingStore().getTableTweak().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelTweak rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTableTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTableTweakObj realised = (IBusModelTableTweakObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTableTweakObj arr[] = new IBusModelTableTweakObj[len];
		Iterator<IBusModelTableTweakObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTableTweakObj> arrayList = new ArrayList<IBusModelTableTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTableTweakObj> cmp = new Comparator<IBusModelTableTweakObj>() {
			@Override
			public int compare( IBusModelTableTweakObj lhs, IBusModelTableTweakObj rhs ) {
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
		List<IBusModelTableTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelTableTweakObj readTableTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		return( readTableTweakByUDefIdx( TenantId,
			ScopeId,
			DefSchemaTenantId,
			DefSchemaId,
			Name,
			false ) );
	}

	@Override
	public IBusModelTableTweakObj readTableTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name, boolean forceRead )
	{
		if( indexByUDefIdx == null ) {
			indexByUDefIdx = new HashMap< IBusModelTweakByUDefIdxKey,
				IBusModelTableTweakObj >();
		}
		IBusModelTweakByUDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUDefIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		key.setRequiredName( Name );
		IBusModelTableTweakObj obj = null;
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
				obj = (IBusModelTableTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelTableTweakObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelTableTweakObj> readTableTweakByTableIdx( IYCFKeyHash256 TableId )
	{
		return( readTableTweakByTableIdx( TableId,
			false ) );
	}

	@Override
	public List<IBusModelTableTweakObj> readTableTweakByTableIdx( IYCFKeyHash256 TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readTableTweakByTableIdx";
		IBusModelTableTweakByTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTableTweak().newByTableIdxKey();
		key.setRequiredTableId( TableId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< IBusModelTableTweakByTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableTweakObj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj>();
			IBusModelTableTweakObj obj;
			IBusModelTableTweak[] recList = schema.getBusModelBackingStore().getTableTableTweak().readDerivedByTableIdx( null,
				TableId );
			IBusModelTableTweak rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTableTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTableTweakObj realised = (IBusModelTableTweakObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTableIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTableTweakObj arr[] = new IBusModelTableTweakObj[len];
		Iterator<IBusModelTableTweakObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTableTweakObj> arrayList = new ArrayList<IBusModelTableTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTableTweakObj> cmp = new Comparator<IBusModelTableTweakObj>() {
			@Override
			public int compare( IBusModelTableTweakObj lhs, IBusModelTableTweakObj rhs ) {
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
		List<IBusModelTableTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelTableTweakObj readCachedTableTweakByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelTableTweakObj obj = null;
		obj = readCachedTableTweak( Id );
		return( obj );
	}

	@Override
	public IBusModelTableTweakObj readCachedTableTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelTableTweakObj obj = null;
		IBusModelTweakByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelTableTweakObj> valIter = members.values().iterator();
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
			Iterator<IBusModelTableTweakObj> valIter = members.values().iterator();
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
	public List<IBusModelTableTweakObj> readCachedTableTweakByValTentIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedTableTweakByValTentIdx";
		IBusModelTweakByValTentIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelTableTweakObj> arrayList = new ArrayList<IBusModelTableTweakObj>();
		if( indexByValTentIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj> dict;
			if( indexByValTentIdx.containsKey( key ) ) {
				dict = indexByValTentIdx.get( key );
				int len = dict.size();
				IBusModelTableTweakObj arr[] = new IBusModelTableTweakObj[len];
				Iterator<IBusModelTableTweakObj> valIter = dict.values().iterator();
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
			IBusModelTableTweakObj obj;
			Iterator<IBusModelTableTweakObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTableTweakObj> cmp = new Comparator<IBusModelTableTweakObj>() {
			@Override
			public int compare( IBusModelTableTweakObj lhs, IBusModelTableTweakObj rhs ) {
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
	public List<IBusModelTableTweakObj> readCachedTableTweakByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "readCachedTableTweakByScopeIdx";
		IBusModelTweakByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		ArrayList<IBusModelTableTweakObj> arrayList = new ArrayList<IBusModelTableTweakObj>();
		if( indexByScopeIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj> dict;
			if( indexByScopeIdx.containsKey( key ) ) {
				dict = indexByScopeIdx.get( key );
				int len = dict.size();
				IBusModelTableTweakObj arr[] = new IBusModelTableTweakObj[len];
				Iterator<IBusModelTableTweakObj> valIter = dict.values().iterator();
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
			IBusModelTableTweakObj obj;
			Iterator<IBusModelTableTweakObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTableTweakObj> cmp = new Comparator<IBusModelTableTweakObj>() {
			@Override
			public int compare( IBusModelTableTweakObj lhs, IBusModelTableTweakObj rhs ) {
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
	public List<IBusModelTableTweakObj> readCachedTableTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedTableTweakByDefSchemaIdx";
		IBusModelTweakByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelTableTweakObj> arrayList = new ArrayList<IBusModelTableTweakObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelTableTweakObj arr[] = new IBusModelTableTweakObj[len];
				Iterator<IBusModelTableTweakObj> valIter = dict.values().iterator();
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
			IBusModelTableTweakObj obj;
			Iterator<IBusModelTableTweakObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTableTweakObj> cmp = new Comparator<IBusModelTableTweakObj>() {
			@Override
			public int compare( IBusModelTableTweakObj lhs, IBusModelTableTweakObj rhs ) {
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
	public IBusModelTableTweakObj readCachedTableTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		IBusModelTableTweakObj obj = null;
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
				Iterator<IBusModelTableTweakObj> valIter = members.values().iterator();
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
			Iterator<IBusModelTableTweakObj> valIter = members.values().iterator();
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
	public List<IBusModelTableTweakObj> readCachedTableTweakByTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "readCachedTableTweakByTableIdx";
		IBusModelTableTweakByTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTableTweak().newByTableIdxKey();
		key.setRequiredTableId( TableId );
		ArrayList<IBusModelTableTweakObj> arrayList = new ArrayList<IBusModelTableTweakObj>();
		if( indexByTableIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj> dict;
			if( indexByTableIdx.containsKey( key ) ) {
				dict = indexByTableIdx.get( key );
				int len = dict.size();
				IBusModelTableTweakObj arr[] = new IBusModelTableTweakObj[len];
				Iterator<IBusModelTableTweakObj> valIter = dict.values().iterator();
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
			IBusModelTableTweakObj obj;
			Iterator<IBusModelTableTweakObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTableTweakObj> cmp = new Comparator<IBusModelTableTweakObj>() {
			@Override
			public int compare( IBusModelTableTweakObj lhs, IBusModelTableTweakObj rhs ) {
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
	public void deepDisposeTableTweakByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelTableTweakObj obj = readCachedTableTweakByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTableTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelTableTweakObj obj = readCachedTableTweakByUNameIdx( ScopeId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTableTweakByValTentIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeTableTweakByValTentIdx";
		IBusModelTableTweakObj obj;
		List<IBusModelTableTweakObj> arrayList = readCachedTableTweakByValTentIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelTableTweakObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTableTweakByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "deepDisposeTableTweakByScopeIdx";
		IBusModelTableTweakObj obj;
		List<IBusModelTableTweakObj> arrayList = readCachedTableTweakByScopeIdx( ScopeId );
		if( arrayList != null )  {
			Iterator<IBusModelTableTweakObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTableTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeTableTweakByDefSchemaIdx";
		IBusModelTableTweakObj obj;
		List<IBusModelTableTweakObj> arrayList = readCachedTableTweakByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelTableTweakObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTableTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		IBusModelTableTweakObj obj = readCachedTableTweakByUDefIdx( TenantId,
				ScopeId,
				DefSchemaTenantId,
				DefSchemaId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTableTweakByTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "deepDisposeTableTweakByTableIdx";
		IBusModelTableTweakObj obj;
		List<IBusModelTableTweakObj> arrayList = readCachedTableTweakByTableIdx( TableId );
		if( arrayList != null )  {
			Iterator<IBusModelTableTweakObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelTableTweakObj updateTableTweak( IBusModelTableTweakObj Obj ) {
		IBusModelTableTweakObj obj = Obj;
		schema.getBusModelBackingStore().getTableTableTweak().updateTableTweak( null,
			Obj.getTableTweakRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getTableTweakTableObj().getClassCode() ) {
			obj = (IBusModelTableTweakObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteTableTweak( IBusModelTableTweakObj Obj ) {
		IBusModelTableTweakObj obj = Obj;
		schema.getBusModelBackingStore().getTableTableTweak().deleteTableTweak( null,
			obj.getTableTweakRec() );
		Obj.forget();
	}

	@Override
	public void deleteTableTweakByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelTableTweakObj obj = readTableTweak(Id);
		if( obj != null ) {
			IBusModelTableTweakEditObj editObj = (IBusModelTableTweakEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelTableTweakEditObj)obj.beginEdit();
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
		deepDisposeTableTweakByIdIdx( Id );
	}

	@Override
	public void deleteTableTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelTweakByUNameIdxKey,
				IBusModelTableTweakObj >();
		}
		IBusModelTweakByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelTableTweakObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableTableTweak().deleteTableTweakByUNameIdx( null,
				ScopeId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableTableTweak().deleteTableTweakByUNameIdx( null,
				ScopeId,
				Name );
		}
		deepDisposeTableTweakByUNameIdx( ScopeId,
				Name );
	}

	@Override
	public void deleteTableTweakByValTentIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelTweakByValTentIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< IBusModelTweakByValTentIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableTweakObj > >();
		}
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj> dict = indexByValTentIdx.get( key );
			schema.getBusModelBackingStore().getTableTableTweak().deleteTableTweakByValTentIdx( null,
				TenantId );
			Iterator<IBusModelTableTweakObj> iter = dict.values().iterator();
			IBusModelTableTweakObj obj;
			List<IBusModelTableTweakObj> toForget = new LinkedList<IBusModelTableTweakObj>();
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
			schema.getBusModelBackingStore().getTableTableTweak().deleteTableTweakByValTentIdx( null,
				TenantId );
		}
		deepDisposeTableTweakByValTentIdx( TenantId );
	}

	@Override
	public void deleteTableTweakByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		IBusModelTweakByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelTweakByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableTweakObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj> dict = indexByScopeIdx.get( key );
			schema.getBusModelBackingStore().getTableTableTweak().deleteTableTweakByScopeIdx( null,
				ScopeId );
			Iterator<IBusModelTableTweakObj> iter = dict.values().iterator();
			IBusModelTableTweakObj obj;
			List<IBusModelTableTweakObj> toForget = new LinkedList<IBusModelTableTweakObj>();
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
			schema.getBusModelBackingStore().getTableTableTweak().deleteTableTweakByScopeIdx( null,
				ScopeId );
		}
		deepDisposeTableTweakByScopeIdx( ScopeId );
	}

	@Override
	public void deleteTableTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelTweakByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelTweakByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableTweakObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableTableTweak().deleteTableTweakByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelTableTweakObj> iter = dict.values().iterator();
			IBusModelTableTweakObj obj;
			List<IBusModelTableTweakObj> toForget = new LinkedList<IBusModelTableTweakObj>();
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
			schema.getBusModelBackingStore().getTableTableTweak().deleteTableTweakByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeTableTweakByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteTableTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		if( indexByUDefIdx == null ) {
			indexByUDefIdx = new HashMap< IBusModelTweakByUDefIdxKey,
				IBusModelTableTweakObj >();
		}
		IBusModelTweakByUDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUDefIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		key.setRequiredName( Name );
		IBusModelTableTweakObj obj = null;
		if( indexByUDefIdx.containsKey( key ) ) {
			obj = indexByUDefIdx.get( key );
			schema.getBusModelBackingStore().getTableTableTweak().deleteTableTweakByUDefIdx( null,
				TenantId,
				ScopeId,
				DefSchemaTenantId,
				DefSchemaId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableTableTweak().deleteTableTweakByUDefIdx( null,
				TenantId,
				ScopeId,
				DefSchemaTenantId,
				DefSchemaId,
				Name );
		}
		deepDisposeTableTweakByUDefIdx( TenantId,
				ScopeId,
				DefSchemaTenantId,
				DefSchemaId,
				Name );
	}

	@Override
	public void deleteTableTweakByTableIdx( IYCFKeyHash256 TableId )
	{
		IBusModelTableTweakByTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTableTweak().newByTableIdxKey();
		key.setRequiredTableId( TableId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< IBusModelTableTweakByTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTableTweakObj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTableTweakObj> dict = indexByTableIdx.get( key );
			schema.getBusModelBackingStore().getTableTableTweak().deleteTableTweakByTableIdx( null,
				TableId );
			Iterator<IBusModelTableTweakObj> iter = dict.values().iterator();
			IBusModelTableTweakObj obj;
			List<IBusModelTableTweakObj> toForget = new LinkedList<IBusModelTableTweakObj>();
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
			schema.getBusModelBackingStore().getTableTableTweak().deleteTableTweakByTableIdx( null,
				TableId );
		}
		deepDisposeTableTweakByTableIdx( TableId );
	}
}