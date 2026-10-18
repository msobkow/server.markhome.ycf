// Description: Java 25 Table Object implementation for Tweak.

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

public class BusModelTweakTableObj
	implements IBusModelTweakTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelTweak.CLASS_CODE;
	protected static final int backingClassCode = IBusModelTweak.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj> allTweak;
	private Map< IBusModelTweakByUNameIdxKey,
		IBusModelTweakObj > indexByUNameIdx;
	private Map< IBusModelTweakByValTentIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj > > indexByValTentIdx;
	private Map< IBusModelTweakByScopeIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj > > indexByScopeIdx;
	private Map< IBusModelTweakByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj > > indexByDefSchemaIdx;
	private Map< IBusModelTweakByUDefIdxKey,
		IBusModelTweakObj > indexByUDefIdx;
	public static String TABLE_NAME = "Tweak";
	public static String TABLE_DBNAME = "tweakdef";

	public BusModelTweakTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTweakObj>();
		allTweak = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByUDefIdx = null;
	}

	public BusModelTweakTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTweakObj>();
		allTweak = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByUDefIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelTweakTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelTweakTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allTweak = null;
		indexByUNameIdx = null;
		indexByValTentIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByUDefIdx = null;
		List<IBusModelTweakObj> toForget = new LinkedList<IBusModelTweakObj>();
		IBusModelTweakObj cur = null;
		Iterator<IBusModelTweakObj> iter = members.values().iterator();
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
	 *	BusModelTweakObj.
	 */
	@Override
	public IBusModelTweakObj newInstance() {
		IBusModelTweakObj inst = new BusModelTweakObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelTweakObj.
	 */
	@Override
	public IBusModelTweakEditObj newEditInstance( IBusModelTweakObj orig ) {
		IBusModelTweakEditObj edit = new BusModelTweakEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelTweakObj constructByClassCode( int backingClassCode ) {
		IBusModelTweakObj obj = null;
		if( backingClassCode == IBusModelTweak.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getTweakTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelTableTweak.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getTableTweakTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelSchemaTweak.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getSchemaTweakTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelIndexTweak.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getIndexTweakTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public IBusModelTweakObj realiseTweak( IBusModelTweakObj Obj ) {
		IBusModelTweakObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelTweakObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelTweakObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.remove( keepObj.getPKey() );
					if( mapValTentIdx.size() <= 0 ) {
						indexByValTentIdx.remove( keyValTentIdx );
					}
				}
			}

			if( indexByScopeIdx != null ) {
				IBusModelTweakByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.remove( keepObj.getPKey() );
					if( mapScopeIdx.size() <= 0 ) {
						indexByScopeIdx.remove( keyScopeIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelTweakByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
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

			keepObj.setRec( Obj.getRec() );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				IBusModelTweakByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelTweakByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
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

			if( allTweak != null ) {
				allTweak.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTweak != null ) {
				allTweak.put( keepObj.getPKey(), keepObj );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj > mapValTentIdx = indexByValTentIdx.get( keyValTentIdx );
				if( mapValTentIdx != null ) {
					mapValTentIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByScopeIdx != null ) {
				IBusModelTweakByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelTweakByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
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

		}
		return( keepObj );
	}

	@Override
	public IBusModelTweakObj createTweak( IBusModelTweakObj Obj ) {
		IBusModelTweakObj obj = Obj;
		IBusModelTweak rec = obj.getTweakRec();
		schema.getBusModelBackingStore().getTableTweak().createTweak(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelTweakObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelTweakObj readTweak( $implCommaIJavaOptAtomType$ pkey ) {
		return( readTweak( pkey, false ) );
	}

	@Override
	public IBusModelTweakObj readTweak( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelTweakObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelTweak readRec = schema.getBusModelBackingStore().getTableTweak().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelTweakObj)schema.getTweakTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelTweakObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelTweakObj readCachedTweak( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelTweakObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeTweak( IBusModelTweakObj obj )
	{
		final String S_ProcName = "BusModelTweakTableObj.reallyDeepDisposeTweak() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelTweakObj existing = readCachedTweak( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelTweakByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUNameIdxKey();
		keyUNameIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		IBusModelTweakByValTentIdxKey keyValTentIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByValTentIdxKey();
		keyValTentIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IBusModelTweakByScopeIdxKey keyScopeIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
		keyScopeIdx.setRequiredScopeId( existing.getRequiredScopeId() );

		IBusModelTweakByDefSchemaIdxKey keyDefSchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		IBusModelTweakByUDefIdxKey keyUDefIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUDefIdxKey();
		keyUDefIdx.setRequiredTenantId( existing.getRequiredTenantId() );
		keyUDefIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		keyUDefIdx.setOptionalDefSchemaTenantId( existing.getOptionalDefSchemaTenantId() );
		keyUDefIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );
		keyUDefIdx.setRequiredName( existing.getRequiredName() );



		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}

		if( indexByValTentIdx != null ) {
			if( indexByValTentIdx.containsKey( keyValTentIdx ) ) {
				indexByValTentIdx.get( keyValTentIdx ).remove( pkey );
				if( indexByValTentIdx.get( keyValTentIdx ).size() <= 0 ) {
					indexByValTentIdx.remove( keyValTentIdx );
				}
			}
		}

		if( indexByScopeIdx != null ) {
			if( indexByScopeIdx.containsKey( keyScopeIdx ) ) {
				indexByScopeIdx.get( keyScopeIdx ).remove( pkey );
				if( indexByScopeIdx.get( keyScopeIdx ).size() <= 0 ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}
		}

		if( indexByDefSchemaIdx != null ) {
			if( indexByDefSchemaIdx.containsKey( keyDefSchemaIdx ) ) {
				indexByDefSchemaIdx.get( keyDefSchemaIdx ).remove( pkey );
				if( indexByDefSchemaIdx.get( keyDefSchemaIdx ).size() <= 0 ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}
		}

		if( indexByUDefIdx != null ) {
			indexByUDefIdx.remove( keyUDefIdx );
		}


	}
	@Override
	public void deepDisposeTweak( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelTweakObj obj = readCachedTweak( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelTweakObj lockTweak( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelTweakObj locked = null;
		IBusModelTweak lockRec = schema.getBusModelBackingStore().getTableTweak().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelTweakObj)schema.getTweakTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelTweakObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockTweak", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelTweakObj> readAllTweak() {
		return( readAllTweak( false ) );
	}

	@Override
	public List<IBusModelTweakObj> readAllTweak( boolean forceRead ) {
		final String S_ProcName = "readAllTweak";
		if( ( allTweak == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelTweakObj>();
			allTweak = map;
			IBusModelTweak[] recList = schema.getBusModelBackingStore().getTableTweak().readAllDerived( null );
			IBusModelTweak rec;
			IBusModelTweakObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTweakObj realised = (IBusModelTweakObj)obj.realise();
			}
		}
		int len = allTweak.size();
		IBusModelTweakObj arr[] = new IBusModelTweakObj[len];
		Iterator<IBusModelTweakObj> valIter = allTweak.values().iterator();
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
		ArrayList<IBusModelTweakObj> arrayList = new ArrayList<IBusModelTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTweakObj> cmp = new Comparator<IBusModelTweakObj>() {
			@Override
			public int compare( IBusModelTweakObj lhs, IBusModelTweakObj rhs ) {
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
		List<IBusModelTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTweakObj> readCachedAllTweak() {
		final String S_ProcName = "readCachedAllTweak";
		ArrayList<IBusModelTweakObj> arrayList = new ArrayList<IBusModelTweakObj>();
		if( allTweak != null ) {
			int len = allTweak.size();
			IBusModelTweakObj arr[] = new IBusModelTweakObj[len];
			Iterator<IBusModelTweakObj> valIter = allTweak.values().iterator();
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
		Comparator<IBusModelTweakObj> cmp = new Comparator<IBusModelTweakObj>() {
			public int compare( IBusModelTweakObj lhs, IBusModelTweakObj rhs ) {
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
	public IBusModelTweakObj readTweakByIdIdx( IYCFKeyHash256 Id )
	{
		return( readTweakByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelTweakObj readTweakByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelTweakObj obj = readTweak( Id, forceRead );
		return( obj );
	}

	@Override
	public IBusModelTweakObj readTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		return( readTweakByUNameIdx( ScopeId,
			Name,
			false ) );
	}

	@Override
	public IBusModelTweakObj readTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelTweakByUNameIdxKey,
				IBusModelTweakObj >();
		}
		IBusModelTweakByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelTweakObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelTweak rec = schema.getBusModelBackingStore().getTableTweak().readDerivedByUNameIdx( null,
				ScopeId,
				Name );
			if( rec != null ) {
				obj = (IBusModelTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelTweakObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelTweakObj> readTweakByValTentIdx( IYCFKeyHash256 TenantId )
	{
		return( readTweakByValTentIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelTweakObj> readTweakByValTentIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTweakByValTentIdx";
		IBusModelTweakByValTentIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj> dict;
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< IBusModelTweakByValTentIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTweakObj > >();
		}
		if( ( ! forceRead ) && indexByValTentIdx.containsKey( key ) ) {
			dict = indexByValTentIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTweakObj>();
			IBusModelTweakObj obj;
			IBusModelTweak[] recList = schema.getBusModelBackingStore().getTableTweak().readDerivedByValTentIdx( null,
				TenantId );
			IBusModelTweak rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTweakObj realised = (IBusModelTweakObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByValTentIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTweakObj arr[] = new IBusModelTweakObj[len];
		Iterator<IBusModelTweakObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTweakObj> arrayList = new ArrayList<IBusModelTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTweakObj> cmp = new Comparator<IBusModelTweakObj>() {
			@Override
			public int compare( IBusModelTweakObj lhs, IBusModelTweakObj rhs ) {
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
		List<IBusModelTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTweakObj> readTweakByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		return( readTweakByScopeIdx( ScopeId,
			false ) );
	}

	@Override
	public List<IBusModelTweakObj> readTweakByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readTweakByScopeIdx";
		IBusModelTweakByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelTweakByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTweakObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTweakObj>();
			IBusModelTweakObj obj;
			IBusModelTweak[] recList = schema.getBusModelBackingStore().getTableTweak().readDerivedByScopeIdx( null,
				ScopeId );
			IBusModelTweak rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTweakObj realised = (IBusModelTweakObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTweakObj arr[] = new IBusModelTweakObj[len];
		Iterator<IBusModelTweakObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTweakObj> arrayList = new ArrayList<IBusModelTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTweakObj> cmp = new Comparator<IBusModelTweakObj>() {
			@Override
			public int compare( IBusModelTweakObj lhs, IBusModelTweakObj rhs ) {
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
		List<IBusModelTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTweakObj> readTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readTweakByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelTweakObj> readTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readTweakByDefSchemaIdx";
		IBusModelTweakByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelTweakByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTweakObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTweakObj>();
			IBusModelTweakObj obj;
			IBusModelTweak[] recList = schema.getBusModelBackingStore().getTableTweak().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelTweak rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTweakObj realised = (IBusModelTweakObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTweakObj arr[] = new IBusModelTweakObj[len];
		Iterator<IBusModelTweakObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTweakObj> arrayList = new ArrayList<IBusModelTweakObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTweakObj> cmp = new Comparator<IBusModelTweakObj>() {
			@Override
			public int compare( IBusModelTweakObj lhs, IBusModelTweakObj rhs ) {
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
		List<IBusModelTweakObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelTweakObj readTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		return( readTweakByUDefIdx( TenantId,
			ScopeId,
			DefSchemaTenantId,
			DefSchemaId,
			Name,
			false ) );
	}

	@Override
	public IBusModelTweakObj readTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name, boolean forceRead )
	{
		if( indexByUDefIdx == null ) {
			indexByUDefIdx = new HashMap< IBusModelTweakByUDefIdxKey,
				IBusModelTweakObj >();
		}
		IBusModelTweakByUDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUDefIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		key.setRequiredName( Name );
		IBusModelTweakObj obj = null;
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
				obj = (IBusModelTweakObj)schema.getTweakTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelTweakObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelTweakObj readCachedTweakByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelTweakObj obj = null;
		obj = readCachedTweak( Id );
		return( obj );
	}

	@Override
	public IBusModelTweakObj readCachedTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelTweakObj obj = null;
		IBusModelTweakByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelTweakObj> valIter = members.values().iterator();
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
			Iterator<IBusModelTweakObj> valIter = members.values().iterator();
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
	public List<IBusModelTweakObj> readCachedTweakByValTentIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedTweakByValTentIdx";
		IBusModelTweakByValTentIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelTweakObj> arrayList = new ArrayList<IBusModelTweakObj>();
		if( indexByValTentIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj> dict;
			if( indexByValTentIdx.containsKey( key ) ) {
				dict = indexByValTentIdx.get( key );
				int len = dict.size();
				IBusModelTweakObj arr[] = new IBusModelTweakObj[len];
				Iterator<IBusModelTweakObj> valIter = dict.values().iterator();
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
			IBusModelTweakObj obj;
			Iterator<IBusModelTweakObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTweakObj> cmp = new Comparator<IBusModelTweakObj>() {
			@Override
			public int compare( IBusModelTweakObj lhs, IBusModelTweakObj rhs ) {
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
	public List<IBusModelTweakObj> readCachedTweakByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "readCachedTweakByScopeIdx";
		IBusModelTweakByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		ArrayList<IBusModelTweakObj> arrayList = new ArrayList<IBusModelTweakObj>();
		if( indexByScopeIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj> dict;
			if( indexByScopeIdx.containsKey( key ) ) {
				dict = indexByScopeIdx.get( key );
				int len = dict.size();
				IBusModelTweakObj arr[] = new IBusModelTweakObj[len];
				Iterator<IBusModelTweakObj> valIter = dict.values().iterator();
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
			IBusModelTweakObj obj;
			Iterator<IBusModelTweakObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTweakObj> cmp = new Comparator<IBusModelTweakObj>() {
			@Override
			public int compare( IBusModelTweakObj lhs, IBusModelTweakObj rhs ) {
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
	public List<IBusModelTweakObj> readCachedTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedTweakByDefSchemaIdx";
		IBusModelTweakByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelTweakObj> arrayList = new ArrayList<IBusModelTweakObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelTweakObj arr[] = new IBusModelTweakObj[len];
				Iterator<IBusModelTweakObj> valIter = dict.values().iterator();
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
			IBusModelTweakObj obj;
			Iterator<IBusModelTweakObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTweakObj> cmp = new Comparator<IBusModelTweakObj>() {
			@Override
			public int compare( IBusModelTweakObj lhs, IBusModelTweakObj rhs ) {
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
	public IBusModelTweakObj readCachedTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		IBusModelTweakObj obj = null;
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
				Iterator<IBusModelTweakObj> valIter = members.values().iterator();
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
			Iterator<IBusModelTweakObj> valIter = members.values().iterator();
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
	public void deepDisposeTweakByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelTweakObj obj = readCachedTweakByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelTweakObj obj = readCachedTweakByUNameIdx( ScopeId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTweakByValTentIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeTweakByValTentIdx";
		IBusModelTweakObj obj;
		List<IBusModelTweakObj> arrayList = readCachedTweakByValTentIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelTweakObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTweakByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "deepDisposeTweakByScopeIdx";
		IBusModelTweakObj obj;
		List<IBusModelTweakObj> arrayList = readCachedTweakByScopeIdx( ScopeId );
		if( arrayList != null )  {
			Iterator<IBusModelTweakObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeTweakByDefSchemaIdx";
		IBusModelTweakObj obj;
		List<IBusModelTweakObj> arrayList = readCachedTweakByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelTweakObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		IBusModelTweakObj obj = readCachedTweakByUDefIdx( TenantId,
				ScopeId,
				DefSchemaTenantId,
				DefSchemaId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelTweakObj updateTweak( IBusModelTweakObj Obj ) {
		IBusModelTweakObj obj = Obj;
		schema.getBusModelBackingStore().getTableTweak().updateTweak( null,
			Obj.getTweakRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getTweakTableObj().getClassCode() ) {
			obj = (IBusModelTweakObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteTweak( IBusModelTweakObj Obj ) {
		IBusModelTweakObj obj = Obj;
		schema.getBusModelBackingStore().getTableTweak().deleteTweak( null,
			obj.getTweakRec() );
		Obj.forget();
	}

	@Override
	public void deleteTweakByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelTweakObj obj = readTweak(Id);
		if( obj != null ) {
			IBusModelTweakEditObj editObj = (IBusModelTweakEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelTweakEditObj)obj.beginEdit();
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
		deepDisposeTweakByIdIdx( Id );
	}

	@Override
	public void deleteTweakByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelTweakByUNameIdxKey,
				IBusModelTweakObj >();
		}
		IBusModelTweakByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelTweakObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableTweak().deleteTweakByUNameIdx( null,
				ScopeId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableTweak().deleteTweakByUNameIdx( null,
				ScopeId,
				Name );
		}
		deepDisposeTweakByUNameIdx( ScopeId,
				Name );
	}

	@Override
	public void deleteTweakByValTentIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelTweakByValTentIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByValTentIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByValTentIdx == null ) {
			indexByValTentIdx = new HashMap< IBusModelTweakByValTentIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTweakObj > >();
		}
		if( indexByValTentIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj> dict = indexByValTentIdx.get( key );
			schema.getBusModelBackingStore().getTableTweak().deleteTweakByValTentIdx( null,
				TenantId );
			Iterator<IBusModelTweakObj> iter = dict.values().iterator();
			IBusModelTweakObj obj;
			List<IBusModelTweakObj> toForget = new LinkedList<IBusModelTweakObj>();
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
			schema.getBusModelBackingStore().getTableTweak().deleteTweakByValTentIdx( null,
				TenantId );
		}
		deepDisposeTweakByValTentIdx( TenantId );
	}

	@Override
	public void deleteTweakByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		IBusModelTweakByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelTweakByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTweakObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj> dict = indexByScopeIdx.get( key );
			schema.getBusModelBackingStore().getTableTweak().deleteTweakByScopeIdx( null,
				ScopeId );
			Iterator<IBusModelTweakObj> iter = dict.values().iterator();
			IBusModelTweakObj obj;
			List<IBusModelTweakObj> toForget = new LinkedList<IBusModelTweakObj>();
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
			schema.getBusModelBackingStore().getTableTweak().deleteTweakByScopeIdx( null,
				ScopeId );
		}
		deepDisposeTweakByScopeIdx( ScopeId );
	}

	@Override
	public void deleteTweakByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelTweakByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelTweakByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTweakObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTweakObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableTweak().deleteTweakByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelTweakObj> iter = dict.values().iterator();
			IBusModelTweakObj obj;
			List<IBusModelTweakObj> toForget = new LinkedList<IBusModelTweakObj>();
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
			schema.getBusModelBackingStore().getTableTweak().deleteTweakByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeTweakByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteTweakByUDefIdx( IYCFKeyHash256 TenantId,
		IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaTenantId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		if( indexByUDefIdx == null ) {
			indexByUDefIdx = new HashMap< IBusModelTweakByUDefIdxKey,
				IBusModelTweakObj >();
		}
		IBusModelTweakByUDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newByUDefIdxKey();
		key.setRequiredTenantId( TenantId );
		key.setRequiredScopeId( ScopeId );
		key.setOptionalDefSchemaTenantId( DefSchemaTenantId );
		key.setOptionalDefSchemaId( DefSchemaId );
		key.setRequiredName( Name );
		IBusModelTweakObj obj = null;
		if( indexByUDefIdx.containsKey( key ) ) {
			obj = indexByUDefIdx.get( key );
			schema.getBusModelBackingStore().getTableTweak().deleteTweakByUDefIdx( null,
				TenantId,
				ScopeId,
				DefSchemaTenantId,
				DefSchemaId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableTweak().deleteTweakByUDefIdx( null,
				TenantId,
				ScopeId,
				DefSchemaTenantId,
				DefSchemaId,
				Name );
		}
		deepDisposeTweakByUDefIdx( TenantId,
				ScopeId,
				DefSchemaTenantId,
				DefSchemaId,
				Name );
	}
}