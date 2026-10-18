// Description: Java 25 Table Object implementation for PopSubDep1.

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

public class BusModelPopSubDep1TableObj
	implements IBusModelPopSubDep1TableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelPopSubDep1.CLASS_CODE;
	protected static final int backingClassCode = IBusModelPopSubDep1.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj> allPopSubDep1;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > > indexByTenantIdx;
	private Map< IBusModelPopDepByRelationIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > > indexByRelationIdx;
	private Map< IBusModelPopDepByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > > indexByDefSchemaIdx;
	private Map< IBusModelPopSubDep1ByPopTopDepIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > > indexByPopTopDepIdx;
	private Map< IBusModelPopSubDep1ByUNameIdxKey,
		IBusModelPopSubDep1Obj > indexByUNameIdx;
	public static String TABLE_NAME = "PopSubDep1";
	public static String TABLE_DBNAME = "popsubdep1";

	public BusModelPopSubDep1TableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj>();
		allPopSubDep1 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByPopTopDepIdx = null;
		indexByUNameIdx = null;
	}

	public BusModelPopSubDep1TableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj>();
		allPopSubDep1 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByPopTopDepIdx = null;
		indexByUNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelPopSubDep1TableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelPopSubDep1TableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allPopSubDep1 = null;
		indexByTenantIdx = null;
		indexByRelationIdx = null;
		indexByDefSchemaIdx = null;
		indexByPopTopDepIdx = null;
		indexByUNameIdx = null;
		List<IBusModelPopSubDep1Obj> toForget = new LinkedList<IBusModelPopSubDep1Obj>();
		IBusModelPopSubDep1Obj cur = null;
		Iterator<IBusModelPopSubDep1Obj> iter = members.values().iterator();
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
	 *	BusModelPopSubDep1Obj.
	 */
	@Override
	public IBusModelPopSubDep1Obj newInstance() {
		IBusModelPopSubDep1Obj inst = new BusModelPopSubDep1Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelPopSubDep1Obj.
	 */
	@Override
	public IBusModelPopSubDep1EditObj newEditInstance( IBusModelPopSubDep1Obj orig ) {
		IBusModelPopSubDep1EditObj edit = new BusModelPopSubDep1EditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelPopSubDep1Obj realisePopSubDep1( IBusModelPopSubDep1Obj Obj ) {
		IBusModelPopSubDep1Obj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelPopSubDep1Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelPopSubDep1Obj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByRelationIdx != null ) {
				IBusModelPopDepByRelationIdxKey keyRelationIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					indexByRelationIdx.remove( keyRelationIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPopTopDepIdx != null ) {
				IBusModelPopSubDep1ByPopTopDepIdxKey keyPopTopDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep1().newByPopTopDepIdxKey();
				keyPopTopDepIdx.setRequiredPopTopDepId( keepObj.getRequiredPopTopDepId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > mapPopTopDepIdx = indexByPopTopDepIdx.get( keyPopTopDepIdx );
				if( mapPopTopDepIdx != null ) {
					mapPopTopDepIdx.remove( keepObj.getPKey() );
					if( mapPopTopDepIdx.size() <= 0 ) {
						indexByPopTopDepIdx.remove( keyPopTopDepIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelPopSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep1().newByUNameIdxKey();
				keyUNameIdx.setRequiredPopTopDepId( keepObj.getRequiredPopTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelPopSubDep1Obj)schema.getPopDepTableObj().realisePopDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				IBusModelPopDepByRelationIdxKey keyRelationIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPopTopDepIdx != null ) {
				IBusModelPopSubDep1ByPopTopDepIdxKey keyPopTopDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep1().newByPopTopDepIdxKey();
				keyPopTopDepIdx.setRequiredPopTopDepId( keepObj.getRequiredPopTopDepId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > mapPopTopDepIdx = indexByPopTopDepIdx.get( keyPopTopDepIdx );
				if( mapPopTopDepIdx != null ) {
					mapPopTopDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelPopSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep1().newByUNameIdxKey();
				keyUNameIdx.setRequiredPopTopDepId( keepObj.getRequiredPopTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allPopSubDep1 != null ) {
				allPopSubDep1.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelPopSubDep1Obj)schema.getPopDepTableObj().realisePopDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allPopSubDep1 != null ) {
				allPopSubDep1.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByRelationIdx != null ) {
				IBusModelPopDepByRelationIdxKey keyRelationIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
				keyRelationIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > mapRelationIdx = indexByRelationIdx.get( keyRelationIdx );
				if( mapRelationIdx != null ) {
					mapRelationIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelPopDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPopTopDepIdx != null ) {
				IBusModelPopSubDep1ByPopTopDepIdxKey keyPopTopDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep1().newByPopTopDepIdxKey();
				keyPopTopDepIdx.setRequiredPopTopDepId( keepObj.getRequiredPopTopDepId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > mapPopTopDepIdx = indexByPopTopDepIdx.get( keyPopTopDepIdx );
				if( mapPopTopDepIdx != null ) {
					mapPopTopDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelPopSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep1().newByUNameIdxKey();
				keyUNameIdx.setRequiredPopTopDepId( keepObj.getRequiredPopTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelPopSubDep1Obj createPopSubDep1( IBusModelPopSubDep1Obj Obj ) {
		IBusModelPopSubDep1Obj obj = Obj;
		IBusModelPopSubDep1 rec = obj.getPopSubDep1Rec();
		schema.getBusModelBackingStore().getTablePopSubDep1().createPopSubDep1(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelPopSubDep1Obj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelPopSubDep1Obj readPopSubDep1( $implCommaIJavaOptAtomType$ pkey ) {
		return( readPopSubDep1( pkey, false ) );
	}

	@Override
	public IBusModelPopSubDep1Obj readPopSubDep1( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelPopSubDep1Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelPopSubDep1 readRec = schema.getBusModelBackingStore().getTablePopSubDep1().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelPopSubDep1Obj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelPopSubDep1Obj readCachedPopSubDep1( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelPopSubDep1Obj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposePopSubDep1( IBusModelPopSubDep1Obj obj )
	{
		final String S_ProcName = "BusModelPopSubDep1TableObj.reallyDeepDisposePopSubDep1() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelPopSubDep1Obj existing = readCachedPopSubDep1( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelPopSubDep1ByPopTopDepIdxKey keyPopTopDepIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep1().newByPopTopDepIdxKey();
		keyPopTopDepIdx.setRequiredPopTopDepId( existing.getRequiredPopTopDepId() );

		IBusModelPopSubDep1ByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep1().newByUNameIdxKey();
		keyUNameIdx.setRequiredPopTopDepId( existing.getRequiredPopTopDepId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		schema.getPopSubDep2TableObj().deepDisposePopSubDep2ByPopSubDep1Idx( existing.getRequiredId() );

		if( indexByPopTopDepIdx != null ) {
			if( indexByPopTopDepIdx.containsKey( keyPopTopDepIdx ) ) {
				indexByPopTopDepIdx.get( keyPopTopDepIdx ).remove( pkey );
				if( indexByPopTopDepIdx.get( keyPopTopDepIdx ).size() <= 0 ) {
					indexByPopTopDepIdx.remove( keyPopTopDepIdx );
				}
			}
		}

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}


		schema.getPopDepTableObj().reallyDeepDisposePopDep( obj );
	}
	@Override
	public void deepDisposePopSubDep1( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelPopSubDep1Obj obj = readCachedPopSubDep1( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelPopSubDep1Obj lockPopSubDep1( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelPopSubDep1Obj locked = null;
		IBusModelPopSubDep1 lockRec = schema.getBusModelBackingStore().getTablePopSubDep1().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelPopSubDep1Obj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockPopSubDep1", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelPopSubDep1Obj> readAllPopSubDep1() {
		return( readAllPopSubDep1( false ) );
	}

	@Override
	public List<IBusModelPopSubDep1Obj> readAllPopSubDep1( boolean forceRead ) {
		final String S_ProcName = "readAllPopSubDep1";
		if( ( allPopSubDep1 == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelPopSubDep1Obj>();
			allPopSubDep1 = map;
			IBusModelPopSubDep1[] recList = schema.getBusModelBackingStore().getTablePopSubDep1().readAllDerived( null );
			IBusModelPopSubDep1 rec;
			IBusModelPopSubDep1Obj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopSubDep1Obj realised = (IBusModelPopSubDep1Obj)obj.realise();
			}
		}
		int len = allPopSubDep1.size();
		IBusModelPopSubDep1Obj arr[] = new IBusModelPopSubDep1Obj[len];
		Iterator<IBusModelPopSubDep1Obj> valIter = allPopSubDep1.values().iterator();
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
		ArrayList<IBusModelPopSubDep1Obj> arrayList = new ArrayList<IBusModelPopSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopSubDep1Obj> cmp = new Comparator<IBusModelPopSubDep1Obj>() {
			@Override
			public int compare( IBusModelPopSubDep1Obj lhs, IBusModelPopSubDep1Obj rhs ) {
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
		List<IBusModelPopSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelPopSubDep1Obj> readCachedAllPopSubDep1() {
		final String S_ProcName = "readCachedAllPopSubDep1";
		ArrayList<IBusModelPopSubDep1Obj> arrayList = new ArrayList<IBusModelPopSubDep1Obj>();
		if( allPopSubDep1 != null ) {
			int len = allPopSubDep1.size();
			IBusModelPopSubDep1Obj arr[] = new IBusModelPopSubDep1Obj[len];
			Iterator<IBusModelPopSubDep1Obj> valIter = allPopSubDep1.values().iterator();
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
		Comparator<IBusModelPopSubDep1Obj> cmp = new Comparator<IBusModelPopSubDep1Obj>() {
			public int compare( IBusModelPopSubDep1Obj lhs, IBusModelPopSubDep1Obj rhs ) {
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
	public IBusModelPopSubDep1Obj readPopSubDep1ByIdIdx( IYCFKeyHash256 Id )
	{
		return( readPopSubDep1ByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelPopSubDep1Obj readPopSubDep1ByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelPopSubDep1Obj obj = readPopSubDep1( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelPopSubDep1Obj> readPopSubDep1ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readPopSubDep1ByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelPopSubDep1Obj> readPopSubDep1ByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep1ByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopSubDep1Obj realised = (IBusModelPopSubDep1Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelPopSubDep1Obj arr[] = new IBusModelPopSubDep1Obj[len];
		Iterator<IBusModelPopSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelPopSubDep1Obj> arrayList = new ArrayList<IBusModelPopSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopSubDep1Obj> cmp = new Comparator<IBusModelPopSubDep1Obj>() {
			@Override
			public int compare( IBusModelPopSubDep1Obj lhs, IBusModelPopSubDep1Obj rhs ) {
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
		List<IBusModelPopSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelPopSubDep1Obj> readPopSubDep1ByRelationIdx( IYCFKeyHash256 RelationId )
	{
		return( readPopSubDep1ByRelationIdx( RelationId,
			false ) );
	}

	@Override
	public List<IBusModelPopSubDep1Obj> readPopSubDep1ByRelationIdx( IYCFKeyHash256 RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep1ByRelationIdx";
		IBusModelPopDepByRelationIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
		key.setRequiredRelationId( RelationId );
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj> dict;
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< IBusModelPopDepByRelationIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByRelationIdx.containsKey( key ) ) {
			dict = indexByRelationIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj>();
			IBusModelPopDepObj obj;
			IBusModelPopDep[] recList = schema.getBusModelBackingStore().getTablePopDep().readDerivedByRelationIdx( null,
				RelationId );
			IBusModelPopDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopSubDep1Obj realised = (IBusModelPopSubDep1Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRelationIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelPopSubDep1Obj arr[] = new IBusModelPopSubDep1Obj[len];
		Iterator<IBusModelPopSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelPopSubDep1Obj> arrayList = new ArrayList<IBusModelPopSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopSubDep1Obj> cmp = new Comparator<IBusModelPopSubDep1Obj>() {
			@Override
			public int compare( IBusModelPopSubDep1Obj lhs, IBusModelPopSubDep1Obj rhs ) {
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
		List<IBusModelPopSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelPopSubDep1Obj> readPopSubDep1ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readPopSubDep1ByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelPopSubDep1Obj> readPopSubDep1ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep1ByDefSchemaIdx";
		IBusModelPopDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelPopDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj>();
			IBusModelPopDepObj obj;
			IBusModelPopDep[] recList = schema.getBusModelBackingStore().getTablePopDep().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelPopDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopSubDep1Obj realised = (IBusModelPopSubDep1Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelPopSubDep1Obj arr[] = new IBusModelPopSubDep1Obj[len];
		Iterator<IBusModelPopSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelPopSubDep1Obj> arrayList = new ArrayList<IBusModelPopSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopSubDep1Obj> cmp = new Comparator<IBusModelPopSubDep1Obj>() {
			@Override
			public int compare( IBusModelPopSubDep1Obj lhs, IBusModelPopSubDep1Obj rhs ) {
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
		List<IBusModelPopSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelPopSubDep1Obj> readPopSubDep1ByPopTopDepIdx( IYCFKeyHash256 PopTopDepId )
	{
		return( readPopSubDep1ByPopTopDepIdx( PopTopDepId,
			false ) );
	}

	@Override
	public List<IBusModelPopSubDep1Obj> readPopSubDep1ByPopTopDepIdx( IYCFKeyHash256 PopTopDepId,
		boolean forceRead )
	{
		final String S_ProcName = "readPopSubDep1ByPopTopDepIdx";
		IBusModelPopSubDep1ByPopTopDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep1().newByPopTopDepIdxKey();
		key.setRequiredPopTopDepId( PopTopDepId );
		Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj> dict;
		if( indexByPopTopDepIdx == null ) {
			indexByPopTopDepIdx = new HashMap< IBusModelPopSubDep1ByPopTopDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByPopTopDepIdx.containsKey( key ) ) {
			dict = indexByPopTopDepIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj>();
			IBusModelPopSubDep1Obj obj;
			IBusModelPopSubDep1[] recList = schema.getBusModelBackingStore().getTablePopSubDep1().readDerivedByPopTopDepIdx( null,
				PopTopDepId );
			IBusModelPopSubDep1 rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelPopSubDep1Obj realised = (IBusModelPopSubDep1Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPopTopDepIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelPopSubDep1Obj arr[] = new IBusModelPopSubDep1Obj[len];
		Iterator<IBusModelPopSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelPopSubDep1Obj> arrayList = new ArrayList<IBusModelPopSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelPopSubDep1Obj> cmp = new Comparator<IBusModelPopSubDep1Obj>() {
			@Override
			public int compare( IBusModelPopSubDep1Obj lhs, IBusModelPopSubDep1Obj rhs ) {
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
		List<IBusModelPopSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelPopSubDep1Obj readPopSubDep1ByUNameIdx( IYCFKeyHash256 PopTopDepId,
		String Name )
	{
		return( readPopSubDep1ByUNameIdx( PopTopDepId,
			Name,
			false ) );
	}

	@Override
	public IBusModelPopSubDep1Obj readPopSubDep1ByUNameIdx( IYCFKeyHash256 PopTopDepId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelPopSubDep1ByUNameIdxKey,
				IBusModelPopSubDep1Obj >();
		}
		IBusModelPopSubDep1ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep1().newByUNameIdxKey();
		key.setRequiredPopTopDepId( PopTopDepId );
		key.setRequiredName( Name );
		IBusModelPopSubDep1Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelPopSubDep1 rec = schema.getBusModelBackingStore().getTablePopSubDep1().readDerivedByUNameIdx( null,
				PopTopDepId,
				Name );
			if( rec != null ) {
				obj = (IBusModelPopSubDep1Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelPopSubDep1Obj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelPopSubDep1Obj readCachedPopSubDep1ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelPopSubDep1Obj obj = null;
		obj = readCachedPopSubDep1( Id );
		return( obj );
	}

	@Override
	public List<IBusModelPopSubDep1Obj> readCachedPopSubDep1ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedPopSubDep1ByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelPopSubDep1Obj> arrayList = new ArrayList<IBusModelPopSubDep1Obj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelPopSubDep1Obj arr[] = new IBusModelPopSubDep1Obj[len];
				Iterator<IBusModelPopSubDep1Obj> valIter = dict.values().iterator();
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
			IBusModelPopSubDep1Obj obj;
			Iterator<IBusModelPopSubDep1Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelPopSubDep1Obj> cmp = new Comparator<IBusModelPopSubDep1Obj>() {
			@Override
			public int compare( IBusModelPopSubDep1Obj lhs, IBusModelPopSubDep1Obj rhs ) {
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
	public List<IBusModelPopSubDep1Obj> readCachedPopSubDep1ByRelationIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "readCachedPopSubDep1ByRelationIdx";
		IBusModelPopDepByRelationIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
		key.setRequiredRelationId( RelationId );
		ArrayList<IBusModelPopSubDep1Obj> arrayList = new ArrayList<IBusModelPopSubDep1Obj>();
		if( indexByRelationIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj> dict;
			if( indexByRelationIdx.containsKey( key ) ) {
				dict = indexByRelationIdx.get( key );
				int len = dict.size();
				IBusModelPopSubDep1Obj arr[] = new IBusModelPopSubDep1Obj[len];
				Iterator<IBusModelPopSubDep1Obj> valIter = dict.values().iterator();
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
			IBusModelPopSubDep1Obj obj;
			Iterator<IBusModelPopSubDep1Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelPopSubDep1Obj> cmp = new Comparator<IBusModelPopSubDep1Obj>() {
			@Override
			public int compare( IBusModelPopSubDep1Obj lhs, IBusModelPopSubDep1Obj rhs ) {
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
	public List<IBusModelPopSubDep1Obj> readCachedPopSubDep1ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedPopSubDep1ByDefSchemaIdx";
		IBusModelPopDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelPopSubDep1Obj> arrayList = new ArrayList<IBusModelPopSubDep1Obj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelPopSubDep1Obj arr[] = new IBusModelPopSubDep1Obj[len];
				Iterator<IBusModelPopSubDep1Obj> valIter = dict.values().iterator();
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
			IBusModelPopSubDep1Obj obj;
			Iterator<IBusModelPopSubDep1Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelPopSubDep1Obj> cmp = new Comparator<IBusModelPopSubDep1Obj>() {
			@Override
			public int compare( IBusModelPopSubDep1Obj lhs, IBusModelPopSubDep1Obj rhs ) {
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
	public List<IBusModelPopSubDep1Obj> readCachedPopSubDep1ByPopTopDepIdx( IYCFKeyHash256 PopTopDepId )
	{
		final String S_ProcName = "readCachedPopSubDep1ByPopTopDepIdx";
		IBusModelPopSubDep1ByPopTopDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep1().newByPopTopDepIdxKey();
		key.setRequiredPopTopDepId( PopTopDepId );
		ArrayList<IBusModelPopSubDep1Obj> arrayList = new ArrayList<IBusModelPopSubDep1Obj>();
		if( indexByPopTopDepIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj> dict;
			if( indexByPopTopDepIdx.containsKey( key ) ) {
				dict = indexByPopTopDepIdx.get( key );
				int len = dict.size();
				IBusModelPopSubDep1Obj arr[] = new IBusModelPopSubDep1Obj[len];
				Iterator<IBusModelPopSubDep1Obj> valIter = dict.values().iterator();
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
			IBusModelPopSubDep1Obj obj;
			Iterator<IBusModelPopSubDep1Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelPopSubDep1Obj> cmp = new Comparator<IBusModelPopSubDep1Obj>() {
			@Override
			public int compare( IBusModelPopSubDep1Obj lhs, IBusModelPopSubDep1Obj rhs ) {
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
	public IBusModelPopSubDep1Obj readCachedPopSubDep1ByUNameIdx( IYCFKeyHash256 PopTopDepId,
		String Name )
	{
		IBusModelPopSubDep1Obj obj = null;
		IBusModelPopSubDep1ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep1().newByUNameIdxKey();
		key.setRequiredPopTopDepId( PopTopDepId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelPopSubDep1Obj> valIter = members.values().iterator();
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
			Iterator<IBusModelPopSubDep1Obj> valIter = members.values().iterator();
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
	public void deepDisposePopSubDep1ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelPopSubDep1Obj obj = readCachedPopSubDep1ByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposePopSubDep1ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposePopSubDep1ByTenantIdx";
		IBusModelPopSubDep1Obj obj;
		List<IBusModelPopSubDep1Obj> arrayList = readCachedPopSubDep1ByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelPopSubDep1Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposePopSubDep1ByRelationIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "deepDisposePopSubDep1ByRelationIdx";
		IBusModelPopSubDep1Obj obj;
		List<IBusModelPopSubDep1Obj> arrayList = readCachedPopSubDep1ByRelationIdx( RelationId );
		if( arrayList != null )  {
			Iterator<IBusModelPopSubDep1Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposePopSubDep1ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposePopSubDep1ByDefSchemaIdx";
		IBusModelPopSubDep1Obj obj;
		List<IBusModelPopSubDep1Obj> arrayList = readCachedPopSubDep1ByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelPopSubDep1Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposePopSubDep1ByPopTopDepIdx( IYCFKeyHash256 PopTopDepId )
	{
		final String S_ProcName = "deepDisposePopSubDep1ByPopTopDepIdx";
		IBusModelPopSubDep1Obj obj;
		List<IBusModelPopSubDep1Obj> arrayList = readCachedPopSubDep1ByPopTopDepIdx( PopTopDepId );
		if( arrayList != null )  {
			Iterator<IBusModelPopSubDep1Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposePopSubDep1ByUNameIdx( IYCFKeyHash256 PopTopDepId,
		String Name )
	{
		IBusModelPopSubDep1Obj obj = readCachedPopSubDep1ByUNameIdx( PopTopDepId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelPopSubDep1Obj updatePopSubDep1( IBusModelPopSubDep1Obj Obj ) {
		IBusModelPopSubDep1Obj obj = Obj;
		schema.getBusModelBackingStore().getTablePopSubDep1().updatePopSubDep1( null,
			Obj.getPopSubDep1Rec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getPopSubDep1TableObj().getClassCode() ) {
			obj = (IBusModelPopSubDep1Obj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deletePopSubDep1( IBusModelPopSubDep1Obj Obj ) {
		IBusModelPopSubDep1Obj obj = Obj;
		schema.getBusModelBackingStore().getTablePopSubDep1().deletePopSubDep1( null,
			obj.getPopSubDep1Rec() );
		Obj.forget();
	}

	@Override
	public void deletePopSubDep1ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelPopSubDep1Obj obj = readPopSubDep1(Id);
		if( obj != null ) {
			IBusModelPopSubDep1EditObj editObj = (IBusModelPopSubDep1EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelPopSubDep1EditObj)obj.beginEdit();
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
		deepDisposePopSubDep1ByIdIdx( Id );
	}

	@Override
	public void deletePopSubDep1ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTablePopSubDep1().deletePopSubDep1ByTenantIdx( null,
				TenantId );
			Iterator<IBusModelPopSubDep1Obj> iter = dict.values().iterator();
			IBusModelPopSubDep1Obj obj;
			List<IBusModelPopSubDep1Obj> toForget = new LinkedList<IBusModelPopSubDep1Obj>();
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
			schema.getBusModelBackingStore().getTablePopSubDep1().deletePopSubDep1ByTenantIdx( null,
				TenantId );
		}
		deepDisposePopSubDep1ByTenantIdx( TenantId );
	}

	@Override
	public void deletePopSubDep1ByRelationIdx( IYCFKeyHash256 RelationId )
	{
		IBusModelPopDepByRelationIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByRelationIdxKey();
		key.setRequiredRelationId( RelationId );
		if( indexByRelationIdx == null ) {
			indexByRelationIdx = new HashMap< IBusModelPopDepByRelationIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > >();
		}
		if( indexByRelationIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj> dict = indexByRelationIdx.get( key );
			schema.getBusModelBackingStore().getTablePopSubDep1().deletePopSubDep1ByRelationIdx( null,
				RelationId );
			Iterator<IBusModelPopSubDep1Obj> iter = dict.values().iterator();
			IBusModelPopSubDep1Obj obj;
			List<IBusModelPopSubDep1Obj> toForget = new LinkedList<IBusModelPopSubDep1Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByRelationIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTablePopSubDep1().deletePopSubDep1ByRelationIdx( null,
				RelationId );
		}
		deepDisposePopSubDep1ByRelationIdx( RelationId );
	}

	@Override
	public void deletePopSubDep1ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelPopDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelPopDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTablePopSubDep1().deletePopSubDep1ByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelPopSubDep1Obj> iter = dict.values().iterator();
			IBusModelPopSubDep1Obj obj;
			List<IBusModelPopSubDep1Obj> toForget = new LinkedList<IBusModelPopSubDep1Obj>();
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
			schema.getBusModelBackingStore().getTablePopSubDep1().deletePopSubDep1ByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposePopSubDep1ByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deletePopSubDep1ByPopTopDepIdx( IYCFKeyHash256 PopTopDepId )
	{
		IBusModelPopSubDep1ByPopTopDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep1().newByPopTopDepIdxKey();
		key.setRequiredPopTopDepId( PopTopDepId );
		if( indexByPopTopDepIdx == null ) {
			indexByPopTopDepIdx = new HashMap< IBusModelPopSubDep1ByPopTopDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj > >();
		}
		if( indexByPopTopDepIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelPopSubDep1Obj> dict = indexByPopTopDepIdx.get( key );
			schema.getBusModelBackingStore().getTablePopSubDep1().deletePopSubDep1ByPopTopDepIdx( null,
				PopTopDepId );
			Iterator<IBusModelPopSubDep1Obj> iter = dict.values().iterator();
			IBusModelPopSubDep1Obj obj;
			List<IBusModelPopSubDep1Obj> toForget = new LinkedList<IBusModelPopSubDep1Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByPopTopDepIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTablePopSubDep1().deletePopSubDep1ByPopTopDepIdx( null,
				PopTopDepId );
		}
		deepDisposePopSubDep1ByPopTopDepIdx( PopTopDepId );
	}

	@Override
	public void deletePopSubDep1ByUNameIdx( IYCFKeyHash256 PopTopDepId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelPopSubDep1ByUNameIdxKey,
				IBusModelPopSubDep1Obj >();
		}
		IBusModelPopSubDep1ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep1().newByUNameIdxKey();
		key.setRequiredPopTopDepId( PopTopDepId );
		key.setRequiredName( Name );
		IBusModelPopSubDep1Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTablePopSubDep1().deletePopSubDep1ByUNameIdx( null,
				PopTopDepId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTablePopSubDep1().deletePopSubDep1ByUNameIdx( null,
				PopTopDepId,
				Name );
		}
		deepDisposePopSubDep1ByUNameIdx( PopTopDepId,
				Name );
	}
}