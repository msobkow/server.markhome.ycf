// Description: Java 25 Table Object implementation for DelSubDep1.

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

public class BusModelDelSubDep1TableObj
	implements IBusModelDelSubDep1TableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelDelSubDep1.CLASS_CODE;
	protected static final int backingClassCode = IBusModelDelSubDep1.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj> allDelSubDep1;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > > indexByTenantIdx;
	private Map< IBusModelDelDepByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > > indexByDefSchemaIdx;
	private Map< IBusModelDelDepByDelDepIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > > indexByDelDepIdx;
	private Map< IBusModelDelSubDep1ByDelTopDepIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > > indexByDelTopDepIdx;
	private Map< IBusModelDelSubDep1ByUNameIdxKey,
		IBusModelDelSubDep1Obj > indexByUNameIdx;
	public static String TABLE_NAME = "DelSubDep1";
	public static String TABLE_DBNAME = "delsubdep1";

	public BusModelDelSubDep1TableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj>();
		allDelSubDep1 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
		indexByDelTopDepIdx = null;
		indexByUNameIdx = null;
	}

	public BusModelDelSubDep1TableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj>();
		allDelSubDep1 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
		indexByDelTopDepIdx = null;
		indexByUNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelDelSubDep1TableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelDelSubDep1TableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allDelSubDep1 = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
		indexByDelTopDepIdx = null;
		indexByUNameIdx = null;
		List<IBusModelDelSubDep1Obj> toForget = new LinkedList<IBusModelDelSubDep1Obj>();
		IBusModelDelSubDep1Obj cur = null;
		Iterator<IBusModelDelSubDep1Obj> iter = members.values().iterator();
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
	 *	BusModelDelSubDep1Obj.
	 */
	@Override
	public IBusModelDelSubDep1Obj newInstance() {
		IBusModelDelSubDep1Obj inst = new BusModelDelSubDep1Obj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelDelSubDep1Obj.
	 */
	@Override
	public IBusModelDelSubDep1EditObj newEditInstance( IBusModelDelSubDep1Obj orig ) {
		IBusModelDelSubDep1EditObj edit = new BusModelDelSubDep1EditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelDelSubDep1Obj realiseDelSubDep1( IBusModelDelSubDep1Obj Obj ) {
		IBusModelDelSubDep1Obj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelDelSubDep1Obj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelDelSubDep1Obj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByDelDepIdx != null ) {
				IBusModelDelDepByDelDepIdxKey keyDelDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					indexByDelDepIdx.remove( keyDelDepIdx );
				}
			}

			if( indexByDelTopDepIdx != null ) {
				IBusModelDelSubDep1ByDelTopDepIdxKey keyDelTopDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep1().newByDelTopDepIdxKey();
				keyDelTopDepIdx.setRequiredDelTopDepId( keepObj.getRequiredDelTopDepId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > mapDelTopDepIdx = indexByDelTopDepIdx.get( keyDelTopDepIdx );
				if( mapDelTopDepIdx != null ) {
					mapDelTopDepIdx.remove( keepObj.getPKey() );
					if( mapDelTopDepIdx.size() <= 0 ) {
						indexByDelTopDepIdx.remove( keyDelTopDepIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelDelSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep1().newByUNameIdxKey();
				keyUNameIdx.setRequiredDelTopDepId( keepObj.getRequiredDelTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelDelSubDep1Obj)schema.getDelDepTableObj().realiseDelDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelDepIdx != null ) {
				IBusModelDelDepByDelDepIdxKey keyDelDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					mapDelDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelTopDepIdx != null ) {
				IBusModelDelSubDep1ByDelTopDepIdxKey keyDelTopDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep1().newByDelTopDepIdxKey();
				keyDelTopDepIdx.setRequiredDelTopDepId( keepObj.getRequiredDelTopDepId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > mapDelTopDepIdx = indexByDelTopDepIdx.get( keyDelTopDepIdx );
				if( mapDelTopDepIdx != null ) {
					mapDelTopDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelDelSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep1().newByUNameIdxKey();
				keyUNameIdx.setRequiredDelTopDepId( keepObj.getRequiredDelTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allDelSubDep1 != null ) {
				allDelSubDep1.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelDelSubDep1Obj)schema.getDelDepTableObj().realiseDelDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allDelSubDep1 != null ) {
				allDelSubDep1.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelDepIdx != null ) {
				IBusModelDelDepByDelDepIdxKey keyDelDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					mapDelDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelTopDepIdx != null ) {
				IBusModelDelSubDep1ByDelTopDepIdxKey keyDelTopDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep1().newByDelTopDepIdxKey();
				keyDelTopDepIdx.setRequiredDelTopDepId( keepObj.getRequiredDelTopDepId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > mapDelTopDepIdx = indexByDelTopDepIdx.get( keyDelTopDepIdx );
				if( mapDelTopDepIdx != null ) {
					mapDelTopDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelDelSubDep1ByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep1().newByUNameIdxKey();
				keyUNameIdx.setRequiredDelTopDepId( keepObj.getRequiredDelTopDepId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelDelSubDep1Obj createDelSubDep1( IBusModelDelSubDep1Obj Obj ) {
		IBusModelDelSubDep1Obj obj = Obj;
		IBusModelDelSubDep1 rec = obj.getDelSubDep1Rec();
		schema.getBusModelBackingStore().getTableDelSubDep1().createDelSubDep1(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelDelSubDep1Obj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelDelSubDep1Obj readDelSubDep1( $implCommaIJavaOptAtomType$ pkey ) {
		return( readDelSubDep1( pkey, false ) );
	}

	@Override
	public IBusModelDelSubDep1Obj readDelSubDep1( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelDelSubDep1Obj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelDelSubDep1 readRec = schema.getBusModelBackingStore().getTableDelSubDep1().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelDelSubDep1Obj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelDelSubDep1Obj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelDelSubDep1Obj readCachedDelSubDep1( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelDelSubDep1Obj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeDelSubDep1( IBusModelDelSubDep1Obj obj )
	{
		final String S_ProcName = "BusModelDelSubDep1TableObj.reallyDeepDisposeDelSubDep1() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelDelSubDep1Obj existing = readCachedDelSubDep1( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelDelSubDep1ByDelTopDepIdxKey keyDelTopDepIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep1().newByDelTopDepIdxKey();
		keyDelTopDepIdx.setRequiredDelTopDepId( existing.getRequiredDelTopDepId() );

		IBusModelDelSubDep1ByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep1().newByUNameIdxKey();
		keyUNameIdx.setRequiredDelTopDepId( existing.getRequiredDelTopDepId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );


		schema.getDelSubDep2TableObj().deepDisposeDelSubDep2ByContDelDep1Idx( existing.getRequiredId() );

		if( indexByDelTopDepIdx != null ) {
			if( indexByDelTopDepIdx.containsKey( keyDelTopDepIdx ) ) {
				indexByDelTopDepIdx.get( keyDelTopDepIdx ).remove( pkey );
				if( indexByDelTopDepIdx.get( keyDelTopDepIdx ).size() <= 0 ) {
					indexByDelTopDepIdx.remove( keyDelTopDepIdx );
				}
			}
		}

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}


		schema.getDelDepTableObj().reallyDeepDisposeDelDep( obj );
	}
	@Override
	public void deepDisposeDelSubDep1( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelDelSubDep1Obj obj = readCachedDelSubDep1( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelDelSubDep1Obj lockDelSubDep1( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelDelSubDep1Obj locked = null;
		IBusModelDelSubDep1 lockRec = schema.getBusModelBackingStore().getTableDelSubDep1().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelDelSubDep1Obj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelDelSubDep1Obj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockDelSubDep1", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelDelSubDep1Obj> readAllDelSubDep1() {
		return( readAllDelSubDep1( false ) );
	}

	@Override
	public List<IBusModelDelSubDep1Obj> readAllDelSubDep1( boolean forceRead ) {
		final String S_ProcName = "readAllDelSubDep1";
		if( ( allDelSubDep1 == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelDelSubDep1Obj>();
			allDelSubDep1 = map;
			IBusModelDelSubDep1[] recList = schema.getBusModelBackingStore().getTableDelSubDep1().readAllDerived( null );
			IBusModelDelSubDep1 rec;
			IBusModelDelSubDep1Obj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelSubDep1Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelSubDep1Obj realised = (IBusModelDelSubDep1Obj)obj.realise();
			}
		}
		int len = allDelSubDep1.size();
		IBusModelDelSubDep1Obj arr[] = new IBusModelDelSubDep1Obj[len];
		Iterator<IBusModelDelSubDep1Obj> valIter = allDelSubDep1.values().iterator();
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
		ArrayList<IBusModelDelSubDep1Obj> arrayList = new ArrayList<IBusModelDelSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelSubDep1Obj> cmp = new Comparator<IBusModelDelSubDep1Obj>() {
			@Override
			public int compare( IBusModelDelSubDep1Obj lhs, IBusModelDelSubDep1Obj rhs ) {
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
		List<IBusModelDelSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDelSubDep1Obj> readCachedAllDelSubDep1() {
		final String S_ProcName = "readCachedAllDelSubDep1";
		ArrayList<IBusModelDelSubDep1Obj> arrayList = new ArrayList<IBusModelDelSubDep1Obj>();
		if( allDelSubDep1 != null ) {
			int len = allDelSubDep1.size();
			IBusModelDelSubDep1Obj arr[] = new IBusModelDelSubDep1Obj[len];
			Iterator<IBusModelDelSubDep1Obj> valIter = allDelSubDep1.values().iterator();
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
		Comparator<IBusModelDelSubDep1Obj> cmp = new Comparator<IBusModelDelSubDep1Obj>() {
			public int compare( IBusModelDelSubDep1Obj lhs, IBusModelDelSubDep1Obj rhs ) {
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
	public IBusModelDelSubDep1Obj readDelSubDep1ByIdIdx( IYCFKeyHash256 Id )
	{
		return( readDelSubDep1ByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelDelSubDep1Obj readDelSubDep1ByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelDelSubDep1Obj obj = readDelSubDep1( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelDelSubDep1Obj> readDelSubDep1ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readDelSubDep1ByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelDelSubDep1Obj> readDelSubDep1ByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep1ByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelSubDep1Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelSubDep1Obj realised = (IBusModelDelSubDep1Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDelSubDep1Obj arr[] = new IBusModelDelSubDep1Obj[len];
		Iterator<IBusModelDelSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDelSubDep1Obj> arrayList = new ArrayList<IBusModelDelSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelSubDep1Obj> cmp = new Comparator<IBusModelDelSubDep1Obj>() {
			@Override
			public int compare( IBusModelDelSubDep1Obj lhs, IBusModelDelSubDep1Obj rhs ) {
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
		List<IBusModelDelSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDelSubDep1Obj> readDelSubDep1ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readDelSubDep1ByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelDelSubDep1Obj> readDelSubDep1ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep1ByDefSchemaIdx";
		IBusModelDelDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelDelDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj>();
			IBusModelDelDepObj obj;
			IBusModelDelDep[] recList = schema.getBusModelBackingStore().getTableDelDep().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelDelDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelSubDep1Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelSubDep1Obj realised = (IBusModelDelSubDep1Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDelSubDep1Obj arr[] = new IBusModelDelSubDep1Obj[len];
		Iterator<IBusModelDelSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDelSubDep1Obj> arrayList = new ArrayList<IBusModelDelSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelSubDep1Obj> cmp = new Comparator<IBusModelDelSubDep1Obj>() {
			@Override
			public int compare( IBusModelDelSubDep1Obj lhs, IBusModelDelSubDep1Obj rhs ) {
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
		List<IBusModelDelSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDelSubDep1Obj> readDelSubDep1ByDelDepIdx( IYCFKeyHash256 RelationId )
	{
		return( readDelSubDep1ByDelDepIdx( RelationId,
			false ) );
	}

	@Override
	public List<IBusModelDelSubDep1Obj> readDelSubDep1ByDelDepIdx( IYCFKeyHash256 RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep1ByDelDepIdx";
		IBusModelDelDepByDelDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
		key.setRequiredRelationId( RelationId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj> dict;
		if( indexByDelDepIdx == null ) {
			indexByDelDepIdx = new HashMap< IBusModelDelDepByDelDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByDelDepIdx.containsKey( key ) ) {
			dict = indexByDelDepIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj>();
			IBusModelDelDepObj obj;
			IBusModelDelDep[] recList = schema.getBusModelBackingStore().getTableDelDep().readDerivedByDelDepIdx( null,
				RelationId );
			IBusModelDelDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelSubDep1Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelSubDep1Obj realised = (IBusModelDelSubDep1Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDelDepIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDelSubDep1Obj arr[] = new IBusModelDelSubDep1Obj[len];
		Iterator<IBusModelDelSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDelSubDep1Obj> arrayList = new ArrayList<IBusModelDelSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelSubDep1Obj> cmp = new Comparator<IBusModelDelSubDep1Obj>() {
			@Override
			public int compare( IBusModelDelSubDep1Obj lhs, IBusModelDelSubDep1Obj rhs ) {
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
		List<IBusModelDelSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDelSubDep1Obj> readDelSubDep1ByDelTopDepIdx( IYCFKeyHash256 DelTopDepId )
	{
		return( readDelSubDep1ByDelTopDepIdx( DelTopDepId,
			false ) );
	}

	@Override
	public List<IBusModelDelSubDep1Obj> readDelSubDep1ByDelTopDepIdx( IYCFKeyHash256 DelTopDepId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelSubDep1ByDelTopDepIdx";
		IBusModelDelSubDep1ByDelTopDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep1().newByDelTopDepIdxKey();
		key.setRequiredDelTopDepId( DelTopDepId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj> dict;
		if( indexByDelTopDepIdx == null ) {
			indexByDelTopDepIdx = new HashMap< IBusModelDelSubDep1ByDelTopDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > >();
		}
		if( ( ! forceRead ) && indexByDelTopDepIdx.containsKey( key ) ) {
			dict = indexByDelTopDepIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj>();
			IBusModelDelSubDep1Obj obj;
			IBusModelDelSubDep1[] recList = schema.getBusModelBackingStore().getTableDelSubDep1().readDerivedByDelTopDepIdx( null,
				DelTopDepId );
			IBusModelDelSubDep1 rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelSubDep1Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelSubDep1Obj realised = (IBusModelDelSubDep1Obj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDelTopDepIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDelSubDep1Obj arr[] = new IBusModelDelSubDep1Obj[len];
		Iterator<IBusModelDelSubDep1Obj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDelSubDep1Obj> arrayList = new ArrayList<IBusModelDelSubDep1Obj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelSubDep1Obj> cmp = new Comparator<IBusModelDelSubDep1Obj>() {
			@Override
			public int compare( IBusModelDelSubDep1Obj lhs, IBusModelDelSubDep1Obj rhs ) {
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
		List<IBusModelDelSubDep1Obj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelDelSubDep1Obj readDelSubDep1ByUNameIdx( IYCFKeyHash256 DelTopDepId,
		String Name )
	{
		return( readDelSubDep1ByUNameIdx( DelTopDepId,
			Name,
			false ) );
	}

	@Override
	public IBusModelDelSubDep1Obj readDelSubDep1ByUNameIdx( IYCFKeyHash256 DelTopDepId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelDelSubDep1ByUNameIdxKey,
				IBusModelDelSubDep1Obj >();
		}
		IBusModelDelSubDep1ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep1().newByUNameIdxKey();
		key.setRequiredDelTopDepId( DelTopDepId );
		key.setRequiredName( Name );
		IBusModelDelSubDep1Obj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelDelSubDep1 rec = schema.getBusModelBackingStore().getTableDelSubDep1().readDerivedByUNameIdx( null,
				DelTopDepId,
				Name );
			if( rec != null ) {
				obj = (IBusModelDelSubDep1Obj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelDelSubDep1Obj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelDelSubDep1Obj readCachedDelSubDep1ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelDelSubDep1Obj obj = null;
		obj = readCachedDelSubDep1( Id );
		return( obj );
	}

	@Override
	public List<IBusModelDelSubDep1Obj> readCachedDelSubDep1ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedDelSubDep1ByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelDelSubDep1Obj> arrayList = new ArrayList<IBusModelDelSubDep1Obj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelDelSubDep1Obj arr[] = new IBusModelDelSubDep1Obj[len];
				Iterator<IBusModelDelSubDep1Obj> valIter = dict.values().iterator();
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
			IBusModelDelSubDep1Obj obj;
			Iterator<IBusModelDelSubDep1Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDelSubDep1Obj> cmp = new Comparator<IBusModelDelSubDep1Obj>() {
			@Override
			public int compare( IBusModelDelSubDep1Obj lhs, IBusModelDelSubDep1Obj rhs ) {
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
	public List<IBusModelDelSubDep1Obj> readCachedDelSubDep1ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedDelSubDep1ByDefSchemaIdx";
		IBusModelDelDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelDelSubDep1Obj> arrayList = new ArrayList<IBusModelDelSubDep1Obj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelDelSubDep1Obj arr[] = new IBusModelDelSubDep1Obj[len];
				Iterator<IBusModelDelSubDep1Obj> valIter = dict.values().iterator();
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
			IBusModelDelSubDep1Obj obj;
			Iterator<IBusModelDelSubDep1Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDelSubDep1Obj> cmp = new Comparator<IBusModelDelSubDep1Obj>() {
			@Override
			public int compare( IBusModelDelSubDep1Obj lhs, IBusModelDelSubDep1Obj rhs ) {
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
	public List<IBusModelDelSubDep1Obj> readCachedDelSubDep1ByDelDepIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "readCachedDelSubDep1ByDelDepIdx";
		IBusModelDelDepByDelDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
		key.setRequiredRelationId( RelationId );
		ArrayList<IBusModelDelSubDep1Obj> arrayList = new ArrayList<IBusModelDelSubDep1Obj>();
		if( indexByDelDepIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj> dict;
			if( indexByDelDepIdx.containsKey( key ) ) {
				dict = indexByDelDepIdx.get( key );
				int len = dict.size();
				IBusModelDelSubDep1Obj arr[] = new IBusModelDelSubDep1Obj[len];
				Iterator<IBusModelDelSubDep1Obj> valIter = dict.values().iterator();
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
			IBusModelDelSubDep1Obj obj;
			Iterator<IBusModelDelSubDep1Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDelSubDep1Obj> cmp = new Comparator<IBusModelDelSubDep1Obj>() {
			@Override
			public int compare( IBusModelDelSubDep1Obj lhs, IBusModelDelSubDep1Obj rhs ) {
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
	public List<IBusModelDelSubDep1Obj> readCachedDelSubDep1ByDelTopDepIdx( IYCFKeyHash256 DelTopDepId )
	{
		final String S_ProcName = "readCachedDelSubDep1ByDelTopDepIdx";
		IBusModelDelSubDep1ByDelTopDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep1().newByDelTopDepIdxKey();
		key.setRequiredDelTopDepId( DelTopDepId );
		ArrayList<IBusModelDelSubDep1Obj> arrayList = new ArrayList<IBusModelDelSubDep1Obj>();
		if( indexByDelTopDepIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj> dict;
			if( indexByDelTopDepIdx.containsKey( key ) ) {
				dict = indexByDelTopDepIdx.get( key );
				int len = dict.size();
				IBusModelDelSubDep1Obj arr[] = new IBusModelDelSubDep1Obj[len];
				Iterator<IBusModelDelSubDep1Obj> valIter = dict.values().iterator();
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
			IBusModelDelSubDep1Obj obj;
			Iterator<IBusModelDelSubDep1Obj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDelSubDep1Obj> cmp = new Comparator<IBusModelDelSubDep1Obj>() {
			@Override
			public int compare( IBusModelDelSubDep1Obj lhs, IBusModelDelSubDep1Obj rhs ) {
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
	public IBusModelDelSubDep1Obj readCachedDelSubDep1ByUNameIdx( IYCFKeyHash256 DelTopDepId,
		String Name )
	{
		IBusModelDelSubDep1Obj obj = null;
		IBusModelDelSubDep1ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep1().newByUNameIdxKey();
		key.setRequiredDelTopDepId( DelTopDepId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelDelSubDep1Obj> valIter = members.values().iterator();
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
			Iterator<IBusModelDelSubDep1Obj> valIter = members.values().iterator();
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
	public void deepDisposeDelSubDep1ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelDelSubDep1Obj obj = readCachedDelSubDep1ByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeDelSubDep1ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeDelSubDep1ByTenantIdx";
		IBusModelDelSubDep1Obj obj;
		List<IBusModelDelSubDep1Obj> arrayList = readCachedDelSubDep1ByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelDelSubDep1Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDelSubDep1ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeDelSubDep1ByDefSchemaIdx";
		IBusModelDelSubDep1Obj obj;
		List<IBusModelDelSubDep1Obj> arrayList = readCachedDelSubDep1ByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelDelSubDep1Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDelSubDep1ByDelDepIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "deepDisposeDelSubDep1ByDelDepIdx";
		IBusModelDelSubDep1Obj obj;
		List<IBusModelDelSubDep1Obj> arrayList = readCachedDelSubDep1ByDelDepIdx( RelationId );
		if( arrayList != null )  {
			Iterator<IBusModelDelSubDep1Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDelSubDep1ByDelTopDepIdx( IYCFKeyHash256 DelTopDepId )
	{
		final String S_ProcName = "deepDisposeDelSubDep1ByDelTopDepIdx";
		IBusModelDelSubDep1Obj obj;
		List<IBusModelDelSubDep1Obj> arrayList = readCachedDelSubDep1ByDelTopDepIdx( DelTopDepId );
		if( arrayList != null )  {
			Iterator<IBusModelDelSubDep1Obj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDelSubDep1ByUNameIdx( IYCFKeyHash256 DelTopDepId,
		String Name )
	{
		IBusModelDelSubDep1Obj obj = readCachedDelSubDep1ByUNameIdx( DelTopDepId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelDelSubDep1Obj updateDelSubDep1( IBusModelDelSubDep1Obj Obj ) {
		IBusModelDelSubDep1Obj obj = Obj;
		schema.getBusModelBackingStore().getTableDelSubDep1().updateDelSubDep1( null,
			Obj.getDelSubDep1Rec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getDelSubDep1TableObj().getClassCode() ) {
			obj = (IBusModelDelSubDep1Obj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteDelSubDep1( IBusModelDelSubDep1Obj Obj ) {
		IBusModelDelSubDep1Obj obj = Obj;
		schema.getBusModelBackingStore().getTableDelSubDep1().deleteDelSubDep1( null,
			obj.getDelSubDep1Rec() );
		Obj.forget();
	}

	@Override
	public void deleteDelSubDep1ByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelDelSubDep1Obj obj = readDelSubDep1(Id);
		if( obj != null ) {
			IBusModelDelSubDep1EditObj editObj = (IBusModelDelSubDep1EditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelDelSubDep1EditObj)obj.beginEdit();
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
		deepDisposeDelSubDep1ByIdIdx( Id );
	}

	@Override
	public void deleteDelSubDep1ByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableDelSubDep1().deleteDelSubDep1ByTenantIdx( null,
				TenantId );
			Iterator<IBusModelDelSubDep1Obj> iter = dict.values().iterator();
			IBusModelDelSubDep1Obj obj;
			List<IBusModelDelSubDep1Obj> toForget = new LinkedList<IBusModelDelSubDep1Obj>();
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
			schema.getBusModelBackingStore().getTableDelSubDep1().deleteDelSubDep1ByTenantIdx( null,
				TenantId );
		}
		deepDisposeDelSubDep1ByTenantIdx( TenantId );
	}

	@Override
	public void deleteDelSubDep1ByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelDelDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelDelDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableDelSubDep1().deleteDelSubDep1ByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelDelSubDep1Obj> iter = dict.values().iterator();
			IBusModelDelSubDep1Obj obj;
			List<IBusModelDelSubDep1Obj> toForget = new LinkedList<IBusModelDelSubDep1Obj>();
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
			schema.getBusModelBackingStore().getTableDelSubDep1().deleteDelSubDep1ByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeDelSubDep1ByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteDelSubDep1ByDelDepIdx( IYCFKeyHash256 RelationId )
	{
		IBusModelDelDepByDelDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
		key.setRequiredRelationId( RelationId );
		if( indexByDelDepIdx == null ) {
			indexByDelDepIdx = new HashMap< IBusModelDelDepByDelDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > >();
		}
		if( indexByDelDepIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj> dict = indexByDelDepIdx.get( key );
			schema.getBusModelBackingStore().getTableDelSubDep1().deleteDelSubDep1ByDelDepIdx( null,
				RelationId );
			Iterator<IBusModelDelSubDep1Obj> iter = dict.values().iterator();
			IBusModelDelSubDep1Obj obj;
			List<IBusModelDelSubDep1Obj> toForget = new LinkedList<IBusModelDelSubDep1Obj>();
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
			schema.getBusModelBackingStore().getTableDelSubDep1().deleteDelSubDep1ByDelDepIdx( null,
				RelationId );
		}
		deepDisposeDelSubDep1ByDelDepIdx( RelationId );
	}

	@Override
	public void deleteDelSubDep1ByDelTopDepIdx( IYCFKeyHash256 DelTopDepId )
	{
		IBusModelDelSubDep1ByDelTopDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep1().newByDelTopDepIdxKey();
		key.setRequiredDelTopDepId( DelTopDepId );
		if( indexByDelTopDepIdx == null ) {
			indexByDelTopDepIdx = new HashMap< IBusModelDelSubDep1ByDelTopDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj > >();
		}
		if( indexByDelTopDepIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelSubDep1Obj> dict = indexByDelTopDepIdx.get( key );
			schema.getBusModelBackingStore().getTableDelSubDep1().deleteDelSubDep1ByDelTopDepIdx( null,
				DelTopDepId );
			Iterator<IBusModelDelSubDep1Obj> iter = dict.values().iterator();
			IBusModelDelSubDep1Obj obj;
			List<IBusModelDelSubDep1Obj> toForget = new LinkedList<IBusModelDelSubDep1Obj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByDelTopDepIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableDelSubDep1().deleteDelSubDep1ByDelTopDepIdx( null,
				DelTopDepId );
		}
		deepDisposeDelSubDep1ByDelTopDepIdx( DelTopDepId );
	}

	@Override
	public void deleteDelSubDep1ByUNameIdx( IYCFKeyHash256 DelTopDepId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelDelSubDep1ByUNameIdxKey,
				IBusModelDelSubDep1Obj >();
		}
		IBusModelDelSubDep1ByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep1().newByUNameIdxKey();
		key.setRequiredDelTopDepId( DelTopDepId );
		key.setRequiredName( Name );
		IBusModelDelSubDep1Obj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableDelSubDep1().deleteDelSubDep1ByUNameIdx( null,
				DelTopDepId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableDelSubDep1().deleteDelSubDep1ByUNameIdx( null,
				DelTopDepId,
				Name );
		}
		deepDisposeDelSubDep1ByUNameIdx( DelTopDepId,
				Name );
	}
}