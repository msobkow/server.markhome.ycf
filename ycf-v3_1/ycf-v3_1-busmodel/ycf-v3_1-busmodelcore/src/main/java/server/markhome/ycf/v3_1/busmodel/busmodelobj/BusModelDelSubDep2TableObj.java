// Description: Java 25 Table Object implementation for DelSubDep2.

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

public class BusModelDelSubDep2TableObj
	implements IBusModelDelSubDep2TableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelDelSubDep2.CLASS_CODE;
	protected static final int backingClassCode = IBusModelDelSubDep2.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj> allDelSubDep2;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > > indexByTenantIdx;
	private Map< IBusModelDelDepByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > > indexByDefSchemaIdx;
	private Map< IBusModelDelDepByDelDepIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > > indexByDelDepIdx;
	private Map< IBusModelDelSubDep2ByContDelDep1IdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > > indexByContDelDep1Idx;
	private Map< IBusModelDelSubDep2ByUNameIdxKey,
		IBusModelDelSubDep2Obj > indexByUNameIdx;
	public static String TABLE_NAME = "DelSubDep2";
	public static String TABLE_DBNAME = "delsubdep2";

	public BusModelDelSubDep2TableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj>();
		allDelSubDep2 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
		indexByContDelDep1Idx = null;
		indexByUNameIdx = null;
	}

	public BusModelDelSubDep2TableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj>();
		allDelSubDep2 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
		indexByContDelDep1Idx = null;
		indexByUNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelDelSubDep2TableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelDelSubDep2TableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allDelSubDep2 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
		indexByContDelDep1Idx = null;
		indexByUNameIdx = null;
		List<IBusModelDelSubDep2Obj> toForget = new LinkedList<IBusModelDelSubDep2Obj>();
		IBusModelDelSubDep2Obj cur = null;
		Iterator<IBusModelDelSubDep2Obj> iter = members.values().iterator();
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
	 *	BusModelDelSubDep2Obj.
	 */
	@Override
	public IBusModelDelSubDep2Obj newInstance() {
		IBusModelDelSubDep2Obj inst = new BusModelDelSubDep2Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelDelSubDep2Obj.
	 */
	@Override
	public IBusModelDelSubDep2EditObj newEditInstance( IBusModelDelSubDep2Obj orig ) {
		IBusModelDelSubDep2EditObj edit = new BusModelDelSubDep2EditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelDelSubDep2Obj realiseDelSubDep2( IBusModelDelSubDep2Obj Obj ) {
		IBusModelDelSubDep2Obj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelDelSubDep2Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelDelSubDep2Obj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByDelDepIdx != null ) {
				IBusModelDelDepByDelDepIdxKey keyDelDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					indexByDelDepIdx.remove( keyDelDepIdx );
				}
			}

			if( indexByContDelDep1Idx != null ) {
				IBusModelDelSubDep2ByContDelDep1IdxKey keyContDelDep1Idx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep2().newByContDelDep1IdxKey();
				keyContDelDep1Idx.setRequiredDelSubDep1Id( keepObj.getRequiredDelSubDep1Id() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > mapContDelDep1Idx = indexByContDelDep1Idx.get( keyContDelDep1Idx );
				if( mapContDelDep1Idx != null ) {
					mapContDelDep1Idx.remove( keepObj.getPKey() );
					if( mapContDelDep1Idx.size() <= 0 ) {
						indexByContDelDep1Idx.remove( keyContDelDep1Idx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelDelSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep2().newByUNameIdxKey();
				keyUNameIdx.setRequiredDelSubDep1Id( keepObj.getRequiredDelSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelDelSubDep2Obj)schema.getDelDepTableObj().realiseDelDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelDepIdx != null ) {
				IBusModelDelDepByDelDepIdxKey keyDelDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					mapDelDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContDelDep1Idx != null ) {
				IBusModelDelSubDep2ByContDelDep1IdxKey keyContDelDep1Idx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep2().newByContDelDep1IdxKey();
				keyContDelDep1Idx.setRequiredDelSubDep1Id( keepObj.getRequiredDelSubDep1Id() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > mapContDelDep1Idx = indexByContDelDep1Idx.get( keyContDelDep1Idx );
				if( mapContDelDep1Idx != null ) {
					mapContDelDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelDelSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep2().newByUNameIdxKey();
				keyUNameIdx.setRequiredDelSubDep1Id( keepObj.getRequiredDelSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allDelSubDep2 != null ) {
				allDelSubDep2.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelDelSubDep2Obj)schema.getDelDepTableObj().realiseDelDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allDelSubDep2 != null ) {
				allDelSubDep2.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelDepIdx != null ) {
				IBusModelDelDepByDelDepIdxKey keyDelDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					mapDelDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContDelDep1Idx != null ) {
				IBusModelDelSubDep2ByContDelDep1IdxKey keyContDelDep1Idx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep2().newByContDelDep1IdxKey();
				keyContDelDep1Idx.setRequiredDelSubDep1Id( keepObj.getRequiredDelSubDep1Id() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > mapContDelDep1Idx = indexByContDelDep1Idx.get( keyContDelDep1Idx );
				if( mapContDelDep1Idx != null ) {
					mapContDelDep1Idx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelDelSubDep2ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep2().newByUNameIdxKey();
				keyUNameIdx.setRequiredDelSubDep1Id( keepObj.getRequiredDelSubDep1Id() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelDelSubDep2Obj createDelSubDep2( IBusModelDelSubDep2Obj Obj ) {
		IBusModelDelSubDep2Obj obj = Obj;
		IBusModelDelSubDep2 rec = obj.getDelSubDep2Rec();
		schema.getBusModelBackingStore().getTableDelSubDep2().createDelSubDep2(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelDelSubDep2Obj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelDelSubDep2Obj readDelSubDep2( $implCommaIJavaOptAtomType$ pkey ) {
		return( readDelSubDep2( pkey, false ) );
	}

	@Override
	public IBusModelDelSubDep2Obj readDelSubDep2( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelDelSubDep2Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelDelSubDep2 readRec = schema.getBusModelBackingStore().getTableDelSubDep2().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelDelSubDep2Obj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelDelSubDep2Obj readCachedDelSubDep2( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelDelSubDep2Obj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeDelSubDep2( IBusModelDelSubDep2Obj obj )
	{
		final String S_ProcName = "BusModelDelSubDep2TableObj.reallyDeepDisposeDelSubDep2() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelDelSubDep2Obj existing = readCachedDelSubDep2( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelDelSubDep2ByContDelDep1IdxKey keyContDelDep1Idx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep2().newByContDelDep1IdxKey();
		keyContDelDep1Idx.setRequiredDelSubDep1Id( existing.getRequiredDelSubDep1Id() );

		IBusModelDelSubDep2ByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep2().newByUNameIdxKey();
		keyUNameIdx.setRequiredDelSubDep1Id( existing.getRequiredDelSubDep1Id() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		schema.getDelSubDep3TableObj().deepDisposeDelSubDep3ByDelSubDep2Idx( existing.getRequiredId() );

		if( indexByContDelDep1Idx != null ) {
			if( indexByContDelDep1Idx.containsKey( keyContDelDep1Idx ) ) {
				indexByContDelDep1Idx.get( keyContDelDep1Idx ).remove( pkey );
				if( indexByContDelDep1Idx.get( keyContDelDep1Idx ).size() <= 0 ) {
					indexByContDelDep1Idx.remove( keyContDelDep1Idx );
				}
			}
		}

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}


		schema.getDelDepTableObj().reallyDeepDisposeDelDep( obj );
	}
	@Override
	public void deepDisposeDelSubDep2( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelDelSubDep2Obj obj = readCachedDelSubDep2( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelDelSubDep2Obj lockDelSubDep2( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelDelSubDep2Obj locked = null;
		IBusModelDelSubDep2 lockRec = schema.getBusModelBackingStore().getTableDelSubDep2().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelDelSubDep2Obj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockDelSubDep2", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelDelSubDep2Obj> readAllDelSubDep2() {
		return( readAllDelSubDep2( false ) );
	}

	@Override
	public List<IBusModelDelSubDep2Obj> readAllDelSubDep2( boolean forceRead ) {
		final String S_ProcName = "readAllDelSubDep2";
		if( ( allDelSubDep2 == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelDelSubDep2Obj>();
			allDelSubDep2 = map;
			IBusModelDelSubDep2[] recList = schema.getBusModelBackingStore().getTableDelSubDep2().readAllDerived( null );
			IBusModelDelSubDep2 rec;
			IBusModelDelSubDep2Obj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelSubDep2Obj realised = (IBusModelDelSubDep2Obj)obj.realise();
			}
		}
		int len = allDelSubDep2.size();
		IBusModelDelSubDep2Obj arr[] = new IBusModelDelSubDep2Obj[len];
		Iterator<IBusModelDelSubDep2Obj> valIter = allDelSubDep2.values().iterator();
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
		ArrayList<IBusModelDelSubDep2Obj> arrayList = new ArrayList<IBusModelDelSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelSubDep2Obj> cmp = new Comparator<IBusModelDelSubDep2Obj>() {
			@Override
			public int compare( IBusModelDelSubDep2Obj lhs, IBusModelDelSubDep2Obj rhs ) {
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
		List<IBusModelDelSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDelSubDep2Obj> readCachedAllDelSubDep2() {
		final String S_ProcName = "readCachedAllDelSubDep2";
		ArrayList<IBusModelDelSubDep2Obj> arrayList = new ArrayList<IBusModelDelSubDep2Obj>();
		if( allDelSubDep2 != null ) {
			int len = allDelSubDep2.size();
			IBusModelDelSubDep2Obj arr[] = new IBusModelDelSubDep2Obj[len];
			Iterator<IBusModelDelSubDep2Obj> valIter = allDelSubDep2.values().iterator();
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
		Comparator<IBusModelDelSubDep2Obj> cmp = new Comparator<IBusModelDelSubDep2Obj>() {
			public int compare( IBusModelDelSubDep2Obj lhs, IBusModelDelSubDep2Obj rhs ) {
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
	public IBusModelDelSubDep2Obj readDelSubDep2ByIdIdx( IYCFKeyHash256 Id )
	{
		return( readDelSubDep2ByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelDelSubDep2Obj readDelSubDep2ByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelDelSubDep2Obj obj = readDelSubDep2( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelDelSubDep2Obj> readDelSubDep2ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readDelSubDep2ByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelDelSubDep2Obj> readDelSubDep2ByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep2ByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelSubDep2Obj realised = (IBusModelDelSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDelSubDep2Obj arr[] = new IBusModelDelSubDep2Obj[len];
		Iterator<IBusModelDelSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDelSubDep2Obj> arrayList = new ArrayList<IBusModelDelSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelSubDep2Obj> cmp = new Comparator<IBusModelDelSubDep2Obj>() {
			@Override
			public int compare( IBusModelDelSubDep2Obj lhs, IBusModelDelSubDep2Obj rhs ) {
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
		List<IBusModelDelSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDelSubDep2Obj> readDelSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readDelSubDep2ByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelDelSubDep2Obj> readDelSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep2ByDefSchemaIdx";
		IBusModelDelDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelDelDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj>();
			IBusModelDelDepObj obj;
			IBusModelDelDep[] recList = schema.getBusModelBackingStore().getTableDelDep().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelDelDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelSubDep2Obj realised = (IBusModelDelSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDelSubDep2Obj arr[] = new IBusModelDelSubDep2Obj[len];
		Iterator<IBusModelDelSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDelSubDep2Obj> arrayList = new ArrayList<IBusModelDelSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelSubDep2Obj> cmp = new Comparator<IBusModelDelSubDep2Obj>() {
			@Override
			public int compare( IBusModelDelSubDep2Obj lhs, IBusModelDelSubDep2Obj rhs ) {
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
		List<IBusModelDelSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDelSubDep2Obj> readDelSubDep2ByDelDepIdx( IYCFKeyHash256 RelationId )
	{
		return( readDelSubDep2ByDelDepIdx( RelationId,
			false ) );
	}

	@Override
	public List<IBusModelDelSubDep2Obj> readDelSubDep2ByDelDepIdx( IYCFKeyHash256 RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep2ByDelDepIdx";
		IBusModelDelDepByDelDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
		key.setRequiredRelationId( RelationId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj> dict;
		if( indexByDelDepIdx == null ) {
			indexByDelDepIdx = new HashMap< IBusModelDelDepByDelDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByDelDepIdx.containsKey( key ) ) {
			dict = indexByDelDepIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj>();
			IBusModelDelDepObj obj;
			IBusModelDelDep[] recList = schema.getBusModelBackingStore().getTableDelDep().readDerivedByDelDepIdx( null,
				RelationId );
			IBusModelDelDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelSubDep2Obj realised = (IBusModelDelSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDelDepIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDelSubDep2Obj arr[] = new IBusModelDelSubDep2Obj[len];
		Iterator<IBusModelDelSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDelSubDep2Obj> arrayList = new ArrayList<IBusModelDelSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelSubDep2Obj> cmp = new Comparator<IBusModelDelSubDep2Obj>() {
			@Override
			public int compare( IBusModelDelSubDep2Obj lhs, IBusModelDelSubDep2Obj rhs ) {
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
		List<IBusModelDelSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDelSubDep2Obj> readDelSubDep2ByContDelDep1Idx( IYCFKeyHash256 DelSubDep1Id )
	{
		return( readDelSubDep2ByContDelDep1Idx( DelSubDep1Id,
			false ) );
	}

	@Override
	public List<IBusModelDelSubDep2Obj> readDelSubDep2ByContDelDep1Idx( IYCFKeyHash256 DelSubDep1Id,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep2ByContDelDep1Idx";
		IBusModelDelSubDep2ByContDelDep1IdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep2().newByContDelDep1IdxKey();
		key.setRequiredDelSubDep1Id( DelSubDep1Id );
		Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj> dict;
		if( indexByContDelDep1Idx == null ) {
			indexByContDelDep1Idx = new HashMap< IBusModelDelSubDep2ByContDelDep1IdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > >();
		}
		if( ( ! forceRead ) && indexByContDelDep1Idx.containsKey( key ) ) {
			dict = indexByContDelDep1Idx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj>();
			IBusModelDelSubDep2Obj obj;
			IBusModelDelSubDep2[] recList = schema.getBusModelBackingStore().getTableDelSubDep2().readDerivedByContDelDep1Idx( null,
				DelSubDep1Id );
			IBusModelDelSubDep2 rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelSubDep2Obj realised = (IBusModelDelSubDep2Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContDelDep1Idx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDelSubDep2Obj arr[] = new IBusModelDelSubDep2Obj[len];
		Iterator<IBusModelDelSubDep2Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDelSubDep2Obj> arrayList = new ArrayList<IBusModelDelSubDep2Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelSubDep2Obj> cmp = new Comparator<IBusModelDelSubDep2Obj>() {
			@Override
			public int compare( IBusModelDelSubDep2Obj lhs, IBusModelDelSubDep2Obj rhs ) {
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
		List<IBusModelDelSubDep2Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelDelSubDep2Obj readDelSubDep2ByUNameIdx( IYCFKeyHash256 DelSubDep1Id,
		String Name )
	{
		return( readDelSubDep2ByUNameIdx( DelSubDep1Id,
			Name,
			false ) );
	}

	@Override
	public IBusModelDelSubDep2Obj readDelSubDep2ByUNameIdx( IYCFKeyHash256 DelSubDep1Id,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelDelSubDep2ByUNameIdxKey,
				IBusModelDelSubDep2Obj >();
		}
		IBusModelDelSubDep2ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep2().newByUNameIdxKey();
		key.setRequiredDelSubDep1Id( DelSubDep1Id );
		key.setRequiredName( Name );
		IBusModelDelSubDep2Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelDelSubDep2 rec = schema.getBusModelBackingStore().getTableDelSubDep2().readDerivedByUNameIdx( null,
				DelSubDep1Id,
				Name );
			if( rec != null ) {
				obj = (IBusModelDelSubDep2Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelDelSubDep2Obj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelDelSubDep2Obj readCachedDelSubDep2ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelDelSubDep2Obj obj = null;
		obj = readCachedDelSubDep2( Id );
		return( obj );
	}

	@Override
	public List<IBusModelDelSubDep2Obj> readCachedDelSubDep2ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedDelSubDep2ByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelDelSubDep2Obj> arrayList = new ArrayList<IBusModelDelSubDep2Obj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelDelSubDep2Obj arr[] = new IBusModelDelSubDep2Obj[len];
				Iterator<IBusModelDelSubDep2Obj> valIter = dict.values().iterator();
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
			IBusModelDelSubDep2Obj obj;
			Iterator<IBusModelDelSubDep2Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDelSubDep2Obj> cmp = new Comparator<IBusModelDelSubDep2Obj>() {
			@Override
			public int compare( IBusModelDelSubDep2Obj lhs, IBusModelDelSubDep2Obj rhs ) {
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
	public List<IBusModelDelSubDep2Obj> readCachedDelSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedDelSubDep2ByDefSchemaIdx";
		IBusModelDelDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelDelSubDep2Obj> arrayList = new ArrayList<IBusModelDelSubDep2Obj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelDelSubDep2Obj arr[] = new IBusModelDelSubDep2Obj[len];
				Iterator<IBusModelDelSubDep2Obj> valIter = dict.values().iterator();
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
			IBusModelDelSubDep2Obj obj;
			Iterator<IBusModelDelSubDep2Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDelSubDep2Obj> cmp = new Comparator<IBusModelDelSubDep2Obj>() {
			@Override
			public int compare( IBusModelDelSubDep2Obj lhs, IBusModelDelSubDep2Obj rhs ) {
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
	public List<IBusModelDelSubDep2Obj> readCachedDelSubDep2ByDelDepIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "readCachedDelSubDep2ByDelDepIdx";
		IBusModelDelDepByDelDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
		key.setRequiredRelationId( RelationId );
		ArrayList<IBusModelDelSubDep2Obj> arrayList = new ArrayList<IBusModelDelSubDep2Obj>();
		if( indexByDelDepIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj> dict;
			if( indexByDelDepIdx.containsKey( key ) ) {
				dict = indexByDelDepIdx.get( key );
				int len = dict.size();
				IBusModelDelSubDep2Obj arr[] = new IBusModelDelSubDep2Obj[len];
				Iterator<IBusModelDelSubDep2Obj> valIter = dict.values().iterator();
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
			IBusModelDelSubDep2Obj obj;
			Iterator<IBusModelDelSubDep2Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDelSubDep2Obj> cmp = new Comparator<IBusModelDelSubDep2Obj>() {
			@Override
			public int compare( IBusModelDelSubDep2Obj lhs, IBusModelDelSubDep2Obj rhs ) {
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
	public List<IBusModelDelSubDep2Obj> readCachedDelSubDep2ByContDelDep1Idx( IYCFKeyHash256 DelSubDep1Id )
	{
		final String S_ProcName = "readCachedDelSubDep2ByContDelDep1Idx";
		IBusModelDelSubDep2ByContDelDep1IdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep2().newByContDelDep1IdxKey();
		key.setRequiredDelSubDep1Id( DelSubDep1Id );
		ArrayList<IBusModelDelSubDep2Obj> arrayList = new ArrayList<IBusModelDelSubDep2Obj>();
		if( indexByContDelDep1Idx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj> dict;
			if( indexByContDelDep1Idx.containsKey( key ) ) {
				dict = indexByContDelDep1Idx.get( key );
				int len = dict.size();
				IBusModelDelSubDep2Obj arr[] = new IBusModelDelSubDep2Obj[len];
				Iterator<IBusModelDelSubDep2Obj> valIter = dict.values().iterator();
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
			IBusModelDelSubDep2Obj obj;
			Iterator<IBusModelDelSubDep2Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDelSubDep2Obj> cmp = new Comparator<IBusModelDelSubDep2Obj>() {
			@Override
			public int compare( IBusModelDelSubDep2Obj lhs, IBusModelDelSubDep2Obj rhs ) {
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
	public IBusModelDelSubDep2Obj readCachedDelSubDep2ByUNameIdx( IYCFKeyHash256 DelSubDep1Id,
		String Name )
	{
		IBusModelDelSubDep2Obj obj = null;
		IBusModelDelSubDep2ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep2().newByUNameIdxKey();
		key.setRequiredDelSubDep1Id( DelSubDep1Id );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelDelSubDep2Obj> valIter = members.values().iterator();
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
			Iterator<IBusModelDelSubDep2Obj> valIter = members.values().iterator();
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
	public void deepDisposeDelSubDep2ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelDelSubDep2Obj obj = readCachedDelSubDep2ByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeDelSubDep2ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeDelSubDep2ByTenantIdx";
		IBusModelDelSubDep2Obj obj;
		List<IBusModelDelSubDep2Obj> arrayList = readCachedDelSubDep2ByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelDelSubDep2Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDelSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeDelSubDep2ByDefSchemaIdx";
		IBusModelDelSubDep2Obj obj;
		List<IBusModelDelSubDep2Obj> arrayList = readCachedDelSubDep2ByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelDelSubDep2Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDelSubDep2ByDelDepIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "deepDisposeDelSubDep2ByDelDepIdx";
		IBusModelDelSubDep2Obj obj;
		List<IBusModelDelSubDep2Obj> arrayList = readCachedDelSubDep2ByDelDepIdx( RelationId );
		if( arrayList != null )  {
			Iterator<IBusModelDelSubDep2Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDelSubDep2ByContDelDep1Idx( IYCFKeyHash256 DelSubDep1Id )
	{
		final String S_ProcName = "deepDisposeDelSubDep2ByContDelDep1Idx";
		IBusModelDelSubDep2Obj obj;
		List<IBusModelDelSubDep2Obj> arrayList = readCachedDelSubDep2ByContDelDep1Idx( DelSubDep1Id );
		if( arrayList != null )  {
			Iterator<IBusModelDelSubDep2Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDelSubDep2ByUNameIdx( IYCFKeyHash256 DelSubDep1Id,
		String Name )
	{
		IBusModelDelSubDep2Obj obj = readCachedDelSubDep2ByUNameIdx( DelSubDep1Id,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelDelSubDep2Obj updateDelSubDep2( IBusModelDelSubDep2Obj Obj ) {
		IBusModelDelSubDep2Obj obj = Obj;
		schema.getBusModelBackingStore().getTableDelSubDep2().updateDelSubDep2( null,
			Obj.getDelSubDep2Rec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getDelSubDep2TableObj().getClassCode() ) {
			obj = (IBusModelDelSubDep2Obj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteDelSubDep2( IBusModelDelSubDep2Obj Obj ) {
		IBusModelDelSubDep2Obj obj = Obj;
		schema.getBusModelBackingStore().getTableDelSubDep2().deleteDelSubDep2( null,
			obj.getDelSubDep2Rec() );
		Obj.forget();
	}

	@Override
	public void deleteDelSubDep2ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelDelSubDep2Obj obj = readDelSubDep2(Id);
		if( obj != null ) {
			IBusModelDelSubDep2EditObj editObj = (IBusModelDelSubDep2EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelDelSubDep2EditObj)obj.beginEdit();
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
		deepDisposeDelSubDep2ByIdIdx( Id );
	}

	@Override
	public void deleteDelSubDep2ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableDelSubDep2().deleteDelSubDep2ByTenantIdx( null,
				TenantId );
			Iterator<IBusModelDelSubDep2Obj> iter = dict.values().iterator();
			IBusModelDelSubDep2Obj obj;
			List<IBusModelDelSubDep2Obj> toForget = new LinkedList<IBusModelDelSubDep2Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByTenantIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableDelSubDep2().deleteDelSubDep2ByTenantIdx( null,
				TenantId );
		}
		deepDisposeDelSubDep2ByTenantIdx( TenantId );
	}

	@Override
	public void deleteDelSubDep2ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelDelDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelDelDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableDelSubDep2().deleteDelSubDep2ByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelDelSubDep2Obj> iter = dict.values().iterator();
			IBusModelDelSubDep2Obj obj;
			List<IBusModelDelSubDep2Obj> toForget = new LinkedList<IBusModelDelSubDep2Obj>();
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
			schema.getBusModelBackingStore().getTableDelSubDep2().deleteDelSubDep2ByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeDelSubDep2ByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteDelSubDep2ByDelDepIdx( IYCFKeyHash256 RelationId )
	{
		IBusModelDelDepByDelDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
		key.setRequiredRelationId( RelationId );
		if( indexByDelDepIdx == null ) {
			indexByDelDepIdx = new HashMap< IBusModelDelDepByDelDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > >();
		}
		if( indexByDelDepIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj> dict = indexByDelDepIdx.get( key );
			schema.getBusModelBackingStore().getTableDelSubDep2().deleteDelSubDep2ByDelDepIdx( null,
				RelationId );
			Iterator<IBusModelDelSubDep2Obj> iter = dict.values().iterator();
			IBusModelDelSubDep2Obj obj;
			List<IBusModelDelSubDep2Obj> toForget = new LinkedList<IBusModelDelSubDep2Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByDelDepIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableDelSubDep2().deleteDelSubDep2ByDelDepIdx( null,
				RelationId );
		}
		deepDisposeDelSubDep2ByDelDepIdx( RelationId );
	}

	@Override
	public void deleteDelSubDep2ByContDelDep1Idx( IYCFKeyHash256 DelSubDep1Id )
	{
		IBusModelDelSubDep2ByContDelDep1IdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep2().newByContDelDep1IdxKey();
		key.setRequiredDelSubDep1Id( DelSubDep1Id );
		if( indexByContDelDep1Idx == null ) {
			indexByContDelDep1Idx = new HashMap< IBusModelDelSubDep2ByContDelDep1IdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj > >();
		}
		if( indexByContDelDep1Idx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep2Obj> dict = indexByContDelDep1Idx.get( key );
			schema.getBusModelBackingStore().getTableDelSubDep2().deleteDelSubDep2ByContDelDep1Idx( null,
				DelSubDep1Id );
			Iterator<IBusModelDelSubDep2Obj> iter = dict.values().iterator();
			IBusModelDelSubDep2Obj obj;
			List<IBusModelDelSubDep2Obj> toForget = new LinkedList<IBusModelDelSubDep2Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByContDelDep1Idx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableDelSubDep2().deleteDelSubDep2ByContDelDep1Idx( null,
				DelSubDep1Id );
		}
		deepDisposeDelSubDep2ByContDelDep1Idx( DelSubDep1Id );
	}

	@Override
	public void deleteDelSubDep2ByUNameIdx( IYCFKeyHash256 DelSubDep1Id,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelDelSubDep2ByUNameIdxKey,
				IBusModelDelSubDep2Obj >();
		}
		IBusModelDelSubDep2ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep2().newByUNameIdxKey();
		key.setRequiredDelSubDep1Id( DelSubDep1Id );
		key.setRequiredName( Name );
		IBusModelDelSubDep2Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableDelSubDep2().deleteDelSubDep2ByUNameIdx( null,
				DelSubDep1Id,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableDelSubDep2().deleteDelSubDep2ByUNameIdx( null,
				DelSubDep1Id,
				Name );
		}
		deepDisposeDelSubDep2ByUNameIdx( DelSubDep1Id,
				Name );
	}
}