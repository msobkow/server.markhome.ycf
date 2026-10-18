// Description: Java 25 Table Object implementation for IndexTweak.

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

public class BusModelIndexTweakTableObj
	implements IBusModelIndexTweakTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelIndexTweak.CLASS_CODE;
	protected static final int backingClassCode = IBusModelIndexTweak.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj> allIndexTweak;
	private Map< IBusModelTweakByUNameIdxKey,
		IBusModelIndexTweakObj > indexByUNameIdx;
	private Map< IBusModelTweakByValTentIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > > indexByValTentIdx;
	private Map< IBusModelTweakByScopeIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > > indexByScopeIdx;
	private Map< IBusModelTweakByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > > indexByDefSchemaIdx;
	private Map< IBusModelTweakByUDefIdxKey,
		IBusModelIndexTweakObj > indexByUDefIdx;
	private Map< IBusModelIndexTweakByIndexIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > > indexByIndexIdx;
	public static String TABLE_NAME = "IndexTweak";
	public static String TABLE_DBNAME = "idxtwk";

	public BusModelIndexTweakTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj>();
		allIndexTweak = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByUDefIdx = null;
		indexByIndexIdx = null;
	}

	public BusModelIndexTweakTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj>();
		allIndexTweak = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByUDefIdx = null;
		indexByIndexIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelIndexTweakTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelIndexTweakTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allIndexTweak = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByUDefIdx = null;
		indexByIndexIdx = null;
		List<IBusModelIndexTweakObj> toForget = new LinkedList<IBusModelIndexTweakObj>();
		IBusModelIndexTweakObj cur = null;
		Iterator<IBusModelIndexTweakObj> iter = members.values().iterator();
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
	 *	BusModelIndexTweakObj.
	 */
	@Override
	public IBusModelIndexTweakObj newInstance() {
		IBusModelIndexTweakObj inst = new BusModelIndexTweakObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelIndexTweakObj.
	 */
	@Override
	public IBusModelIndexTweakEditObj newEditInstance( IBusModelIndexTweakObj orig ) {
		IBusModelIndexTweakEditObj edit = new BusModelIndexTweakEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelIndexTweakObj realiseIndexTweak( IBusModelIndexTweakObj Obj ) {
		IBusModelIndexTweakObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelIndexTweakObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelIndexTweakObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}

			if( indexByScopeIdx != null ) {
				IBusModelTweakByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelTweakByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
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

			if( indexByIndexIdx != null ) {
				IBusModelIndexTweakByIndexIdxKey keyIndexIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexTweak().newByIndexIdxKey();
				keyIndexIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > mapIndexIdx = indexByIndexIdx.get( keyIndexIdx );
				if( mapIndexIdx != null ) {
					mapIndexIdx.remove( keepObj.getPKey() );
					if( mapIndexIdx.size() <= 0 ) {
						indexByIndexIdx.remove( keyIndexIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelIndexTweakObj)schema.getTweakTableObj().realiseTweak( Obj );

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
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				IBusModelTweakByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelTweakByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
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

			if( indexByIndexIdx != null ) {
				IBusModelIndexTweakByIndexIdxKey keyIndexIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexTweak().newByIndexIdxKey();
				keyIndexIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > mapIndexIdx = indexByIndexIdx.get( keyIndexIdx );
				if( mapIndexIdx != null ) {
					mapIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allIndexTweak != null ) {
				allIndexTweak.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelIndexTweakObj)schema.getTweakTableObj().realiseTweak( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allIndexTweak != null ) {
				allIndexTweak.put( keepObj.getPKey(), keepObj );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				IBusModelTweakByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelTweakByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
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

			if( indexByIndexIdx != null ) {
				IBusModelIndexTweakByIndexIdxKey keyIndexIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexTweak().newByIndexIdxKey();
				keyIndexIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > mapIndexIdx = indexByIndexIdx.get( keyIndexIdx );
				if( mapIndexIdx != null ) {
					mapIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelIndexTweakObj createIndexTweak( IBusModelIndexTweakObj Obj ) {
		IBusModelIndexTweakObj obj = Obj;
		IBusModelIndexTweak rec = obj.getIndexTweakRec();
		schema.getBusModelBackingStore().getTableIndexTweak().createIndexTweak(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelIndexTweakObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelIndexTweakObj readIndexTweak( $implCommaIJavaOptAtomType$ pkey ) {
		return( readIndexTweak( pkey, false ) );
	}

	@Override
	public IBusModelIndexTweakObj readIndexTweak( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelIndexTweakObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelIndexTweak readRec = schema.getBusModelBackingStore().getTableIndexTweak().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelIndexTweakObj)schema.getTweakTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelIndexTweakObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelIndexTweakObj readCachedIndexTweak( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelIndexTweakObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeIndexTweak( IBusModelIndexTweakObj obj )
	{
		final String S_ProcName = "BusModelIndexTweakTableObj.reallyDeepDisposeIndexTweak() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelIndexTweakObj existing = readCachedIndexTweak( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelIndexTweakByIndexIdxKey keyIndexIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexTweak().newByIndexIdxKey();
		keyIndexIdx.setRequiredIndexId( existing.getRequiredIndexId() );



		if( indexByIndexIdx != null ) {
			if( indexByIndexIdx.containsKey( keyIndexIdx ) ) {
				indexByIndexIdx.get( keyIndexIdx ).remove( pkey );
				if( indexByIndexIdx.get( keyIndexIdx ).size() <= 0 ) {
					indexByIndexIdx.remove( keyIndexIdx );
				}
			}
		}


		schema.getTweakTableObj().reallyDeepDisposeTweak( obj );
	}
	@Override
	public void deepDisposeIndexTweak( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelIndexTweakObj obj = readCachedIndexTweak( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelIndexTweakObj lockIndexTweak( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelIndexTweakObj locked = null;
		IBusModelIndexTweak lockRec = schema.getBusModelBackingStore().getTableIndexTweak().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelIndexTweakObj)schema.getTweakTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelIndexTweakObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockIndexTweak", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelIndexTweakObj> readAllIndexTweak() {
		return( readAllIndexTweak( false ) );
	}

	@Override
	public List<IBusModelIndexTweakObj> readAllIndexTweak( boolean forceRead ) {
		final String S_ProcName = "readAllIndexTweak";
		if( ( allIndexTweak == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelIndexTweakObj>();
			allIndexTweak = map;
			IBusModelIndexTweak[] recList = schema.getBusModelBackingStore().getTableIndexTweak().readAllDerived( null );
			IBusModelIndexTweak rec;
			IBusModelIndexTweakObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelIndexTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexTweakObj realised = (IBusModelIndexTweakObj)obj.realise();
			}
		}
		int len = allIndexTweak.size();
		IBusModelIndexTweakObj arr[] = new IBusModelIndexTweakObj[len];
		Iterator<IBusModelIndexTweakObj> valIter = allIndexTweak.values().iterator();
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
		ArrayList<IBusModelIndexTweakObj> arrayList = new ArrayList<IBusModelIndexTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexTweakObj> cmp = new Comparator<IBusModelIndexTweakObj>() {
			@Override
			public int compare( IBusModelIndexTweakObj lhs, IBusModelIndexTweakObj rhs ) {
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
		List<IBusModelIndexTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelIndexTweakObj> readCachedAllIndexTweak() {
		final String S_ProcName = "readCachedAllIndexTweak";
		ArrayList<IBusModelIndexTweakObj> arrayList = new ArrayList<IBusModelIndexTweakObj>();
		if( allIndexTweak != null ) {
			int len = allIndexTweak.size();
			IBusModelIndexTweakObj arr[] = new IBusModelIndexTweakObj[len];
			Iterator<IBusModelIndexTweakObj> valIter = allIndexTweak.values().iterator();
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
		Comparator<IBusModelIndexTweakObj> cmp = new Comparator<IBusModelIndexTweakObj>() {
			public int compare( IBusModelIndexTweakObj lhs, IBusModelIndexTweakObj rhs ) {
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
	public IBusModelIndexTweakObj readIndexTweakByIdIdx( IYCFKeyHash256 Id )
	{
		return( readIndexTweakByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelIndexTweakObj readIndexTweakByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelIndexTweakObj obj = readIndexTweak( Id, forceRead );
		return( obj );
	}

	@Override
	public IBusModelIndexTweakObj readIndexTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		return( readIndexTweakByUNameIdx( ScopeId,
			Name,
			false ) );
	}

	@Override
	public IBusModelIndexTweakObj readIndexTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelTweakByUNameIdxKey,
				IBusModelIndexTweakObj >();
		}
		IBusModelTweakByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelIndexTweakObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelTweak rec = schema.getBusModelBackingStore().getTableTweak().readDerivedByUNameIdx( null,
				ScopeId,
				Name );
			if( rec != null ) {
				obj = (IBusModelIndexTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelIndexTweakObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelIndexTweakObj> readIndexTweakByValTentIdx( IYCFKeyHash256 TenantId )
	{
		return( readIndexTweakByValTentIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelIndexTweakObj> readIndexTweakByValTentIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexTweakByValTentIdx";
		IBusModelTweakByValTentIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj> dict;
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< IBusModelTweakByValTentIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > >();
		}
		if( ( ! forceRead ) && indexByValTentIdx.containsKey( key ) ) {
			dict = indexByValTentIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj>();
			IBusModelTweakObj obj;
			IBusModelTweak[] recList = schema.getBusModelBackingStore().getTableTweak().readDerivedByValTentIdx( null,
				TenantId );
			IBusModelTweak rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelIndexTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexTweakObj realised = (IBusModelIndexTweakObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByValTentIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelIndexTweakObj arr[] = new IBusModelIndexTweakObj[len];
		Iterator<IBusModelIndexTweakObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelIndexTweakObj> arrayList = new ArrayList<IBusModelIndexTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexTweakObj> cmp = new Comparator<IBusModelIndexTweakObj>() {
			@Override
			public int compare( IBusModelIndexTweakObj lhs, IBusModelIndexTweakObj rhs ) {
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
		List<IBusModelIndexTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelIndexTweakObj> readIndexTweakByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		return( readIndexTweakByScopeIdx( ScopeId,
			false ) );
	}

	@Override
	public List<IBusModelIndexTweakObj> readIndexTweakByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexTweakByScopeIdx";
		IBusModelTweakByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelTweakByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj>();
			IBusModelTweakObj obj;
			IBusModelTweak[] recList = schema.getBusModelBackingStore().getTableTweak().readDerivedByScopeIdx( null,
				ScopeId );
			IBusModelTweak rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelIndexTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexTweakObj realised = (IBusModelIndexTweakObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelIndexTweakObj arr[] = new IBusModelIndexTweakObj[len];
		Iterator<IBusModelIndexTweakObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelIndexTweakObj> arrayList = new ArrayList<IBusModelIndexTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexTweakObj> cmp = new Comparator<IBusModelIndexTweakObj>() {
			@Override
			public int compare( IBusModelIndexTweakObj lhs, IBusModelIndexTweakObj rhs ) {
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
		List<IBusModelIndexTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelIndexTweakObj> readIndexTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readIndexTweakByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelIndexTweakObj> readIndexTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexTweakByDefSchemaIdx";
		IBusModelTweakByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelTweakByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj>();
			IBusModelTweakObj obj;
			IBusModelTweak[] recList = schema.getBusModelBackingStore().getTableTweak().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelTweak rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelIndexTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexTweakObj realised = (IBusModelIndexTweakObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelIndexTweakObj arr[] = new IBusModelIndexTweakObj[len];
		Iterator<IBusModelIndexTweakObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelIndexTweakObj> arrayList = new ArrayList<IBusModelIndexTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexTweakObj> cmp = new Comparator<IBusModelIndexTweakObj>() {
			@Override
			public int compare( IBusModelIndexTweakObj lhs, IBusModelIndexTweakObj rhs ) {
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
		List<IBusModelIndexTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelIndexTweakObj readIndexTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		return( readIndexTweakByUDefIdx( TenantId,
			ScopeId,
			DefSchemaTenantId,
			DefSchemaId,
			Name,
			false ) );
	}

	@Override
	public IBusModelIndexTweakObj readIndexTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name, boolean forceRead )
	{
		if( indexByUDefIdx == null ) {
			indexByUDefIdx = new HashMap< IBusModelTweakByUDefIdxKey,
				IBusModelIndexTweakObj >();
		}
		IBusModelTweakByUDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUDefIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		key.setRequiredName( Name );
		IBusModelIndexTweakObj obj = null;
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
				obj = (IBusModelIndexTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelIndexTweakObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelIndexTweakObj> readIndexTweakByIndexIdx( IYCFKeyHash256 IndexId )
	{
		return( readIndexTweakByIndexIdx( IndexId,
			false ) );
	}

	@Override
	public List<IBusModelIndexTweakObj> readIndexTweakByIndexIdx( IYCFKeyHash256 IndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexTweakByIndexIdx";
		IBusModelIndexTweakByIndexIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexTweak().newByIndexIdxKey();
		key.setRequiredIndexId( IndexId );
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj> dict;
		if( indexByIndexIdx == null ) {
			indexByIndexIdx = new HashMap< IBusModelIndexTweakByIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > >();
		}
		if( ( ! forceRead ) && indexByIndexIdx.containsKey( key ) ) {
			dict = indexByIndexIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj>();
			IBusModelIndexTweakObj obj;
			IBusModelIndexTweak[] recList = schema.getBusModelBackingStore().getTableIndexTweak().readDerivedByIndexIdx( null,
				IndexId );
			IBusModelIndexTweak rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelIndexTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexTweakObj realised = (IBusModelIndexTweakObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByIndexIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelIndexTweakObj arr[] = new IBusModelIndexTweakObj[len];
		Iterator<IBusModelIndexTweakObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelIndexTweakObj> arrayList = new ArrayList<IBusModelIndexTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexTweakObj> cmp = new Comparator<IBusModelIndexTweakObj>() {
			@Override
			public int compare( IBusModelIndexTweakObj lhs, IBusModelIndexTweakObj rhs ) {
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
		List<IBusModelIndexTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelIndexTweakObj readCachedIndexTweakByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelIndexTweakObj obj = null;
		obj = readCachedIndexTweak( Id );
		return( obj );
	}

	@Override
	public IBusModelIndexTweakObj readCachedIndexTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelIndexTweakObj obj = null;
		IBusModelTweakByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelIndexTweakObj> valIter = members.values().iterator();
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
			Iterator<IBusModelIndexTweakObj> valIter = members.values().iterator();
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
	public List<IBusModelIndexTweakObj> readCachedIndexTweakByValTentIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedIndexTweakByValTentIdx";
		IBusModelTweakByValTentIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelIndexTweakObj> arrayList = new ArrayList<IBusModelIndexTweakObj>();
		if( indexByValTentIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj> dict;
			if( indexByValTentIdx.containsKey( key ) ) {
				dict = indexByValTentIdx.get( key );
				int len = dict.size();
				IBusModelIndexTweakObj arr[] = new IBusModelIndexTweakObj[len];
				Iterator<IBusModelIndexTweakObj> valIter = dict.values().iterator();
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
			IBusModelIndexTweakObj obj;
			Iterator<IBusModelIndexTweakObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelIndexTweakObj> cmp = new Comparator<IBusModelIndexTweakObj>() {
			@Override
			public int compare( IBusModelIndexTweakObj lhs, IBusModelIndexTweakObj rhs ) {
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
	public List<IBusModelIndexTweakObj> readCachedIndexTweakByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "readCachedIndexTweakByScopeIdx";
		IBusModelTweakByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		ArrayList<IBusModelIndexTweakObj> arrayList = new ArrayList<IBusModelIndexTweakObj>();
		if( indexByScopeIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj> dict;
			if( indexByScopeIdx.containsKey( key ) ) {
				dict = indexByScopeIdx.get( key );
				int len = dict.size();
				IBusModelIndexTweakObj arr[] = new IBusModelIndexTweakObj[len];
				Iterator<IBusModelIndexTweakObj> valIter = dict.values().iterator();
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
			IBusModelIndexTweakObj obj;
			Iterator<IBusModelIndexTweakObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelIndexTweakObj> cmp = new Comparator<IBusModelIndexTweakObj>() {
			@Override
			public int compare( IBusModelIndexTweakObj lhs, IBusModelIndexTweakObj rhs ) {
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
	public List<IBusModelIndexTweakObj> readCachedIndexTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedIndexTweakByDefSchemaIdx";
		IBusModelTweakByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelIndexTweakObj> arrayList = new ArrayList<IBusModelIndexTweakObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelIndexTweakObj arr[] = new IBusModelIndexTweakObj[len];
				Iterator<IBusModelIndexTweakObj> valIter = dict.values().iterator();
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
			IBusModelIndexTweakObj obj;
			Iterator<IBusModelIndexTweakObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelIndexTweakObj> cmp = new Comparator<IBusModelIndexTweakObj>() {
			@Override
			public int compare( IBusModelIndexTweakObj lhs, IBusModelIndexTweakObj rhs ) {
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
	public IBusModelIndexTweakObj readCachedIndexTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		IBusModelIndexTweakObj obj = null;
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
				Iterator<IBusModelIndexTweakObj> valIter = members.values().iterator();
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
			Iterator<IBusModelIndexTweakObj> valIter = members.values().iterator();
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
	public List<IBusModelIndexTweakObj> readCachedIndexTweakByIndexIdx( IYCFKeyHash256 IndexId )
	{
		final String S_ProcName = "readCachedIndexTweakByIndexIdx";
		IBusModelIndexTweakByIndexIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexTweak().newByIndexIdxKey();
		key.setRequiredIndexId( IndexId );
		ArrayList<IBusModelIndexTweakObj> arrayList = new ArrayList<IBusModelIndexTweakObj>();
		if( indexByIndexIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj> dict;
			if( indexByIndexIdx.containsKey( key ) ) {
				dict = indexByIndexIdx.get( key );
				int len = dict.size();
				IBusModelIndexTweakObj arr[] = new IBusModelIndexTweakObj[len];
				Iterator<IBusModelIndexTweakObj> valIter = dict.values().iterator();
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
			IBusModelIndexTweakObj obj;
			Iterator<IBusModelIndexTweakObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelIndexTweakObj> cmp = new Comparator<IBusModelIndexTweakObj>() {
			@Override
			public int compare( IBusModelIndexTweakObj lhs, IBusModelIndexTweakObj rhs ) {
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
	public void deepDisposeIndexTweakByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelIndexTweakObj obj = readCachedIndexTweakByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeIndexTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelIndexTweakObj obj = readCachedIndexTweakByUNameIdx( ScopeId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeIndexTweakByValTentIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeIndexTweakByValTentIdx";
		IBusModelIndexTweakObj obj;
		List<IBusModelIndexTweakObj> arrayList = readCachedIndexTweakByValTentIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelIndexTweakObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeIndexTweakByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "deepDisposeIndexTweakByScopeIdx";
		IBusModelIndexTweakObj obj;
		List<IBusModelIndexTweakObj> arrayList = readCachedIndexTweakByScopeIdx( ScopeId );
		if( arrayList != null )  {
			Iterator<IBusModelIndexTweakObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeIndexTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeIndexTweakByDefSchemaIdx";
		IBusModelIndexTweakObj obj;
		List<IBusModelIndexTweakObj> arrayList = readCachedIndexTweakByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelIndexTweakObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeIndexTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		IBusModelIndexTweakObj obj = readCachedIndexTweakByUDefIdx( TenantId,
				ScopeId,
				DefSchemaTenantId,
				DefSchemaId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeIndexTweakByIndexIdx( IYCFKeyHash256 IndexId )
	{
		final String S_ProcName = "deepDisposeIndexTweakByIndexIdx";
		IBusModelIndexTweakObj obj;
		List<IBusModelIndexTweakObj> arrayList = readCachedIndexTweakByIndexIdx( IndexId );
		if( arrayList != null )  {
			Iterator<IBusModelIndexTweakObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelIndexTweakObj updateIndexTweak( IBusModelIndexTweakObj Obj ) {
		IBusModelIndexTweakObj obj = Obj;
		schema.getBusModelBackingStore().getTableIndexTweak().updateIndexTweak( null,
			Obj.getIndexTweakRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getIndexTweakTableObj().getClassCode() ) {
			obj = (IBusModelIndexTweakObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteIndexTweak( IBusModelIndexTweakObj Obj ) {
		IBusModelIndexTweakObj obj = Obj;
		schema.getBusModelBackingStore().getTableIndexTweak().deleteIndexTweak( null,
			obj.getIndexTweakRec() );
		Obj.forget();
	}

	@Override
	public void deleteIndexTweakByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelIndexTweakObj obj = readIndexTweak(Id);
		if( obj != null ) {
			IBusModelIndexTweakEditObj editObj = (IBusModelIndexTweakEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelIndexTweakEditObj)obj.beginEdit();
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
		deepDisposeIndexTweakByIdIdx( Id );
	}

	@Override
	public void deleteIndexTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelTweakByUNameIdxKey,
				IBusModelIndexTweakObj >();
		}
		IBusModelTweakByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelIndexTweakObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableIndexTweak().deleteIndexTweakByUNameIdx( null,
				ScopeId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableIndexTweak().deleteIndexTweakByUNameIdx( null,
				ScopeId,
				Name );
		}
		deepDisposeIndexTweakByUNameIdx( ScopeId,
				Name );
	}

	@Override
	public void deleteIndexTweakByValTentIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelTweakByValTentIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< IBusModelTweakByValTentIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > >();
		}
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj> dict = indexByValTentIdx.get( key );
			schema.getBusModelBackingStore().getTableIndexTweak().deleteIndexTweakByValTentIdx( null,
				TenantId );
			Iterator<IBusModelIndexTweakObj> iter = dict.values().iterator();
			IBusModelIndexTweakObj obj;
			List<IBusModelIndexTweakObj> toForget = new LinkedList<IBusModelIndexTweakObj>();
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
			schema.getBusModelBackingStore().getTableIndexTweak().deleteIndexTweakByValTentIdx( null,
				TenantId );
		}
		deepDisposeIndexTweakByValTentIdx( TenantId );
	}

	@Override
	public void deleteIndexTweakByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		IBusModelTweakByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelTweakByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj> dict = indexByScopeIdx.get( key );
			schema.getBusModelBackingStore().getTableIndexTweak().deleteIndexTweakByScopeIdx( null,
				ScopeId );
			Iterator<IBusModelIndexTweakObj> iter = dict.values().iterator();
			IBusModelIndexTweakObj obj;
			List<IBusModelIndexTweakObj> toForget = new LinkedList<IBusModelIndexTweakObj>();
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
			schema.getBusModelBackingStore().getTableIndexTweak().deleteIndexTweakByScopeIdx( null,
				ScopeId );
		}
		deepDisposeIndexTweakByScopeIdx( ScopeId );
	}

	@Override
	public void deleteIndexTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelTweakByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelTweakByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableIndexTweak().deleteIndexTweakByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelIndexTweakObj> iter = dict.values().iterator();
			IBusModelIndexTweakObj obj;
			List<IBusModelIndexTweakObj> toForget = new LinkedList<IBusModelIndexTweakObj>();
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
			schema.getBusModelBackingStore().getTableIndexTweak().deleteIndexTweakByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeIndexTweakByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteIndexTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		if( indexByUDefIdx == null ) {
			indexByUDefIdx = new HashMap< IBusModelTweakByUDefIdxKey,
				IBusModelIndexTweakObj >();
		}
		IBusModelTweakByUDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUDefIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		key.setRequiredName( Name );
		IBusModelIndexTweakObj obj = null;
		if( indexByUDefIdx.containsKey( key ) ) {
			obj = indexByUDefIdx.get( key );
			schema.getBusModelBackingStore().getTableIndexTweak().deleteIndexTweakByUDefIdx( null,
				TenantId,
				ScopeId,
				DefSchemaTenantId,
				DefSchemaId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableIndexTweak().deleteIndexTweakByUDefIdx( null,
				TenantId,
				ScopeId,
				DefSchemaTenantId,
				DefSchemaId,
				Name );
		}
		deepDisposeIndexTweakByUDefIdx( TenantId,
				ScopeId,
				DefSchemaTenantId,
				DefSchemaId,
				Name );
	}

	@Override
	public void deleteIndexTweakByIndexIdx( IYCFKeyHash256 IndexId )
	{
		IBusModelIndexTweakByIndexIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexTweak().newByIndexIdxKey();
		key.setRequiredIndexId( IndexId );
		if( indexByIndexIdx == null ) {
			indexByIndexIdx = new HashMap< IBusModelIndexTweakByIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexTweakObj > >();
		}
		if( indexByIndexIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexTweakObj> dict = indexByIndexIdx.get( key );
			schema.getBusModelBackingStore().getTableIndexTweak().deleteIndexTweakByIndexIdx( null,
				IndexId );
			Iterator<IBusModelIndexTweakObj> iter = dict.values().iterator();
			IBusModelIndexTweakObj obj;
			List<IBusModelIndexTweakObj> toForget = new LinkedList<IBusModelIndexTweakObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByIndexIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableIndexTweak().deleteIndexTweakByIndexIdx( null,
				IndexId );
		}
		deepDisposeIndexTweakByIndexIdx( IndexId );
	}
}