// Description: Java 25 Table Object implementation for DelTopDep.

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

public class BusModelDelTopDepTableObj
	implements IBusModelDelTopDepTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelDelTopDep.CLASS_CODE;
	protected static final int backingClassCode = IBusModelDelTopDep.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> allDelTopDep;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > > indexByTenantIdx;
	private Map< IBusModelDelDepByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > > indexByDefSchemaIdx;
	private Map< IBusModelDelDepByDelDepIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > > indexByDelDepIdx;
	private Map< IBusModelDelTopDepByDelTopDepTblIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > > indexByDelTopDepTblIdx;
	private Map< IBusModelDelTopDepByUNameIdxKey,
		IBusModelDelTopDepObj > indexByUNameIdx;
	private Map< IBusModelDelTopDepByPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > > indexByPrevIdx;
	private Map< IBusModelDelTopDepByNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > > indexByNextIdx;
	public static String TABLE_NAME = "DelTopDep";
	public static String TABLE_DBNAME = "del_topdep";

	public BusModelDelTopDepTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj>();
		allDelTopDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
		indexByDelTopDepTblIdx = null;
		indexByUNameIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
	}

	public BusModelDelTopDepTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj>();
		allDelTopDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
		indexByDelTopDepTblIdx = null;
		indexByUNameIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelDelTopDepTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelDelTopDepTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allDelTopDep = null;
		indexByTenantIdx = null;
		indexByDefSchemaIdx = null;
		indexByDelDepIdx = null;
		indexByDelTopDepTblIdx = null;
		indexByUNameIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		List<IBusModelDelTopDepObj> toForget = new LinkedList<IBusModelDelTopDepObj>();
		IBusModelDelTopDepObj cur = null;
		Iterator<IBusModelDelTopDepObj> iter = members.values().iterator();
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
	 *	BusModelDelTopDepObj.
	 */
	@Override
	public IBusModelDelTopDepObj newInstance() {
		IBusModelDelTopDepObj inst = new BusModelDelTopDepObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelDelTopDepObj.
	 */
	@Override
	public IBusModelDelTopDepEditObj newEditInstance( IBusModelDelTopDepObj orig ) {
		IBusModelDelTopDepEditObj edit = new BusModelDelTopDepEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelDelTopDepObj realiseDelTopDep( IBusModelDelTopDepObj Obj ) {
		IBusModelDelTopDepObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelDelTopDepObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelDelTopDepObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByDelDepIdx != null ) {
				IBusModelDelDepByDelDepIdxKey keyDelDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					indexByDelDepIdx.remove( keyDelDepIdx );
				}
			}

			if( indexByDelTopDepTblIdx != null ) {
				IBusModelDelTopDepByDelTopDepTblIdxKey keyDelTopDepTblIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByDelTopDepTblIdxKey();
				keyDelTopDepTblIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapDelTopDepTblIdx = indexByDelTopDepTblIdx.get( keyDelTopDepTblIdx );
				if( mapDelTopDepTblIdx != null ) {
					mapDelTopDepTblIdx.remove( keepObj.getPKey() );
					if( mapDelTopDepTblIdx.size() <= 0 ) {
						indexByDelTopDepTblIdx.remove( keyDelTopDepTblIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelDelTopDepByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByPrevIdx != null ) {
				IBusModelDelTopDepByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelDelTopDepByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
					if( mapNextIdx.size() <= 0 ) {
						indexByNextIdx.remove( keyNextIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelDelTopDepObj)schema.getDelDepTableObj().realiseDelDep( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelDepIdx != null ) {
				IBusModelDelDepByDelDepIdxKey keyDelDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					mapDelDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelTopDepTblIdx != null ) {
				IBusModelDelTopDepByDelTopDepTblIdxKey keyDelTopDepTblIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByDelTopDepTblIdxKey();
				keyDelTopDepTblIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapDelTopDepTblIdx = indexByDelTopDepTblIdx.get( keyDelTopDepTblIdx );
				if( mapDelTopDepTblIdx != null ) {
					mapDelTopDepTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelDelTopDepByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByPrevIdx != null ) {
				IBusModelDelTopDepByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelDelTopDepByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allDelTopDep != null ) {
				allDelTopDep.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelDelTopDepObj)schema.getDelDepTableObj().realiseDelDep( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allDelTopDep != null ) {
				allDelTopDep.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelDelDepByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelDepIdx != null ) {
				IBusModelDelDepByDelDepIdxKey keyDelDepIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
				keyDelDepIdx.setRequiredRelationId( keepObj.getRequiredRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapDelDepIdx = indexByDelDepIdx.get( keyDelDepIdx );
				if( mapDelDepIdx != null ) {
					mapDelDepIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDelTopDepTblIdx != null ) {
				IBusModelDelTopDepByDelTopDepTblIdxKey keyDelTopDepTblIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByDelTopDepTblIdxKey();
				keyDelTopDepTblIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapDelTopDepTblIdx = indexByDelTopDepTblIdx.get( keyDelTopDepTblIdx );
				if( mapDelTopDepTblIdx != null ) {
					mapDelTopDepTblIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelDelTopDepByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByPrevIdx != null ) {
				IBusModelDelTopDepByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelDelTopDepByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelDelTopDepObj createDelTopDep( IBusModelDelTopDepObj Obj ) {
		IBusModelDelTopDepObj obj = Obj;
		IBusModelDelTopDep rec = obj.getDelTopDepRec();
		schema.getBusModelBackingStore().getTableDelTopDep().createDelTopDep(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelDelTopDepObj)(obj.realise());
		}
		IBusModelDelTopDepObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelDelTopDepObj readDelTopDep( $implCommaIJavaOptAtomType$ pkey ) {
		return( readDelTopDep( pkey, false ) );
	}

	@Override
	public IBusModelDelTopDepObj readDelTopDep( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelDelTopDepObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelDelTopDep readRec = schema.getBusModelBackingStore().getTableDelTopDep().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelDelTopDepObj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelDelTopDepObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelDelTopDepObj readCachedDelTopDep( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelDelTopDepObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeDelTopDep( IBusModelDelTopDepObj obj )
	{
		final String S_ProcName = "BusModelDelTopDepTableObj.reallyDeepDisposeDelTopDep() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelDelTopDepObj existing = readCachedDelTopDep( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelDelTopDepByDelTopDepTblIdxKey keyDelTopDepTblIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByDelTopDepTblIdxKey();
		keyDelTopDepTblIdx.setRequiredTableId( existing.getRequiredTableId() );

		IBusModelDelTopDepByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		IBusModelDelTopDepByPrevIdxKey keyPrevIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		IBusModelDelTopDepByNextIdxKey keyNextIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );


		schema.getDelSubDep1TableObj().deepDisposeDelSubDep1ByDelTopDepIdx( existing.getRequiredId() );

		if( indexByDelTopDepTblIdx != null ) {
			if( indexByDelTopDepTblIdx.containsKey( keyDelTopDepTblIdx ) ) {
				indexByDelTopDepTblIdx.get( keyDelTopDepTblIdx ).remove( pkey );
				if( indexByDelTopDepTblIdx.get( keyDelTopDepTblIdx ).size() <= 0 ) {
					indexByDelTopDepTblIdx.remove( keyDelTopDepTblIdx );
				}
			}
		}

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}

		if( indexByPrevIdx != null ) {
			if( indexByPrevIdx.containsKey( keyPrevIdx ) ) {
				indexByPrevIdx.get( keyPrevIdx ).remove( pkey );
				if( indexByPrevIdx.get( keyPrevIdx ).size() <= 0 ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}
		}

		if( indexByNextIdx != null ) {
			if( indexByNextIdx.containsKey( keyNextIdx ) ) {
				indexByNextIdx.get( keyNextIdx ).remove( pkey );
				if( indexByNextIdx.get( keyNextIdx ).size() <= 0 ) {
					indexByNextIdx.remove( keyNextIdx );
				}
			}
		}


		schema.getDelDepTableObj().reallyDeepDisposeDelDep( obj );
	}
	@Override
	public void deepDisposeDelTopDep( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelDelTopDepObj obj = readCachedDelTopDep( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelDelTopDepObj lockDelTopDep( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelDelTopDepObj locked = null;
		IBusModelDelTopDep lockRec = schema.getBusModelBackingStore().getTableDelTopDep().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelDelTopDepObj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelDelTopDepObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockDelTopDep", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelDelTopDepObj> readAllDelTopDep() {
		return( readAllDelTopDep( false ) );
	}

	@Override
	public List<IBusModelDelTopDepObj> readAllDelTopDep( boolean forceRead ) {
		final String S_ProcName = "readAllDelTopDep";
		if( ( allDelTopDep == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelDelTopDepObj>();
			allDelTopDep = map;
			IBusModelDelTopDep[] recList = schema.getBusModelBackingStore().getTableDelTopDep().readAllDerived( null );
			IBusModelDelTopDep rec;
			IBusModelDelTopDepObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelTopDepObj realised = (IBusModelDelTopDepObj)obj.realise();
			}
		}
		int len = allDelTopDep.size();
		IBusModelDelTopDepObj arr[] = new IBusModelDelTopDepObj[len];
		Iterator<IBusModelDelTopDepObj> valIter = allDelTopDep.values().iterator();
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
		ArrayList<IBusModelDelTopDepObj> arrayList = new ArrayList<IBusModelDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelTopDepObj> cmp = new Comparator<IBusModelDelTopDepObj>() {
			@Override
			public int compare( IBusModelDelTopDepObj lhs, IBusModelDelTopDepObj rhs ) {
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
		List<IBusModelDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDelTopDepObj> readCachedAllDelTopDep() {
		final String S_ProcName = "readCachedAllDelTopDep";
		ArrayList<IBusModelDelTopDepObj> arrayList = new ArrayList<IBusModelDelTopDepObj>();
		if( allDelTopDep != null ) {
			int len = allDelTopDep.size();
			IBusModelDelTopDepObj arr[] = new IBusModelDelTopDepObj[len];
			Iterator<IBusModelDelTopDepObj> valIter = allDelTopDep.values().iterator();
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
		Comparator<IBusModelDelTopDepObj> cmp = new Comparator<IBusModelDelTopDepObj>() {
			public int compare( IBusModelDelTopDepObj lhs, IBusModelDelTopDepObj rhs ) {
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
	public IBusModelDelTopDepObj readDelTopDepByIdIdx( IYCFKeyHash256 Id )
	{
		return( readDelTopDepByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelDelTopDepObj readDelTopDepByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelDelTopDepObj obj = readDelTopDep( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelDelTopDepObj> readDelTopDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readDelTopDepByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelDelTopDepObj> readDelTopDepByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelTopDepByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelTopDepObj realised = (IBusModelDelTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDelTopDepObj arr[] = new IBusModelDelTopDepObj[len];
		Iterator<IBusModelDelTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDelTopDepObj> arrayList = new ArrayList<IBusModelDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelTopDepObj> cmp = new Comparator<IBusModelDelTopDepObj>() {
			@Override
			public int compare( IBusModelDelTopDepObj lhs, IBusModelDelTopDepObj rhs ) {
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
		List<IBusModelDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDelTopDepObj> readDelTopDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readDelTopDepByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelDelTopDepObj> readDelTopDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelTopDepByDefSchemaIdx";
		IBusModelDelDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelDelDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj>();
			IBusModelDelDepObj obj;
			IBusModelDelDep[] recList = schema.getBusModelBackingStore().getTableDelDep().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelDelDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelTopDepObj realised = (IBusModelDelTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDelTopDepObj arr[] = new IBusModelDelTopDepObj[len];
		Iterator<IBusModelDelTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDelTopDepObj> arrayList = new ArrayList<IBusModelDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelTopDepObj> cmp = new Comparator<IBusModelDelTopDepObj>() {
			@Override
			public int compare( IBusModelDelTopDepObj lhs, IBusModelDelTopDepObj rhs ) {
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
		List<IBusModelDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDelTopDepObj> readDelTopDepByDelDepIdx( IYCFKeyHash256 RelationId )
	{
		return( readDelTopDepByDelDepIdx( RelationId,
			false ) );
	}

	@Override
	public List<IBusModelDelTopDepObj> readDelTopDepByDelDepIdx( IYCFKeyHash256 RelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelTopDepByDelDepIdx";
		IBusModelDelDepByDelDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
		key.setRequiredRelationId( RelationId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict;
		if( indexByDelDepIdx == null ) {
			indexByDelDepIdx = new HashMap< IBusModelDelDepByDelDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByDelDepIdx.containsKey( key ) ) {
			dict = indexByDelDepIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj>();
			IBusModelDelDepObj obj;
			IBusModelDelDep[] recList = schema.getBusModelBackingStore().getTableDelDep().readDerivedByDelDepIdx( null,
				RelationId );
			IBusModelDelDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelTopDepObj realised = (IBusModelDelTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDelDepIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDelTopDepObj arr[] = new IBusModelDelTopDepObj[len];
		Iterator<IBusModelDelTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDelTopDepObj> arrayList = new ArrayList<IBusModelDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelTopDepObj> cmp = new Comparator<IBusModelDelTopDepObj>() {
			@Override
			public int compare( IBusModelDelTopDepObj lhs, IBusModelDelTopDepObj rhs ) {
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
		List<IBusModelDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDelTopDepObj> readDelTopDepByDelTopDepTblIdx( IYCFKeyHash256 TableId )
	{
		return( readDelTopDepByDelTopDepTblIdx( TableId,
			false ) );
	}

	@Override
	public List<IBusModelDelTopDepObj> readDelTopDepByDelTopDepTblIdx( IYCFKeyHash256 TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelTopDepByDelTopDepTblIdx";
		IBusModelDelTopDepByDelTopDepTblIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByDelTopDepTblIdxKey();
		key.setRequiredTableId( TableId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict;
		if( indexByDelTopDepTblIdx == null ) {
			indexByDelTopDepTblIdx = new HashMap< IBusModelDelTopDepByDelTopDepTblIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByDelTopDepTblIdx.containsKey( key ) ) {
			dict = indexByDelTopDepTblIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj>();
			IBusModelDelTopDepObj obj;
			IBusModelDelTopDep[] recList = schema.getBusModelBackingStore().getTableDelTopDep().readDerivedByDelTopDepTblIdx( null,
				TableId );
			IBusModelDelTopDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelTopDepObj realised = (IBusModelDelTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDelTopDepTblIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDelTopDepObj arr[] = new IBusModelDelTopDepObj[len];
		Iterator<IBusModelDelTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDelTopDepObj> arrayList = new ArrayList<IBusModelDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelTopDepObj> cmp = new Comparator<IBusModelDelTopDepObj>() {
			@Override
			public int compare( IBusModelDelTopDepObj lhs, IBusModelDelTopDepObj rhs ) {
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
		List<IBusModelDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelDelTopDepObj readDelTopDepByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		return( readDelTopDepByUNameIdx( TableId,
			Name,
			false ) );
	}

	@Override
	public IBusModelDelTopDepObj readDelTopDepByUNameIdx( IYCFKeyHash256 TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelDelTopDepByUNameIdxKey,
				IBusModelDelTopDepObj >();
		}
		IBusModelDelTopDepByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelDelTopDepObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelDelTopDep rec = schema.getBusModelBackingStore().getTableDelTopDep().readDerivedByUNameIdx( null,
				TableId,
				Name );
			if( rec != null ) {
				obj = (IBusModelDelTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelDelTopDepObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelDelTopDepObj> readDelTopDepByPrevIdx( IYCFKeyHash256 PrevId )
	{
		return( readDelTopDepByPrevIdx( PrevId,
			false ) );
	}

	@Override
	public List<IBusModelDelTopDepObj> readDelTopDepByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelTopDepByPrevIdx";
		IBusModelDelTopDepByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelDelTopDepByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj>();
			IBusModelDelTopDepObj obj;
			IBusModelDelTopDep[] recList = schema.getBusModelBackingStore().getTableDelTopDep().readDerivedByPrevIdx( null,
				PrevId );
			IBusModelDelTopDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelTopDepObj realised = (IBusModelDelTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDelTopDepObj arr[] = new IBusModelDelTopDepObj[len];
		Iterator<IBusModelDelTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDelTopDepObj> arrayList = new ArrayList<IBusModelDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelTopDepObj> cmp = new Comparator<IBusModelDelTopDepObj>() {
			@Override
			public int compare( IBusModelDelTopDepObj lhs, IBusModelDelTopDepObj rhs ) {
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
		List<IBusModelDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelDelTopDepObj> readDelTopDepByNextIdx( IYCFKeyHash256 NextId )
	{
		return( readDelTopDepByNextIdx( NextId,
			false ) );
	}

	@Override
	public List<IBusModelDelTopDepObj> readDelTopDepByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readDelTopDepByNextIdx";
		IBusModelDelTopDepByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelDelTopDepByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj>();
			IBusModelDelTopDepObj obj;
			IBusModelDelTopDep[] recList = schema.getBusModelBackingStore().getTableDelTopDep().readDerivedByNextIdx( null,
				NextId );
			IBusModelDelTopDep rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelDelTopDepObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelDelTopDepObj realised = (IBusModelDelTopDepObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelDelTopDepObj arr[] = new IBusModelDelTopDepObj[len];
		Iterator<IBusModelDelTopDepObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelDelTopDepObj> arrayList = new ArrayList<IBusModelDelTopDepObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelDelTopDepObj> cmp = new Comparator<IBusModelDelTopDepObj>() {
			@Override
			public int compare( IBusModelDelTopDepObj lhs, IBusModelDelTopDepObj rhs ) {
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
		List<IBusModelDelTopDepObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelDelTopDepObj readCachedDelTopDepByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelDelTopDepObj obj = null;
		obj = readCachedDelTopDep( Id );
		return( obj );
	}

	@Override
	public List<IBusModelDelTopDepObj> readCachedDelTopDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedDelTopDepByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelDelTopDepObj> arrayList = new ArrayList<IBusModelDelTopDepObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelDelTopDepObj arr[] = new IBusModelDelTopDepObj[len];
				Iterator<IBusModelDelTopDepObj> valIter = dict.values().iterator();
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
			IBusModelDelTopDepObj obj;
			Iterator<IBusModelDelTopDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDelTopDepObj> cmp = new Comparator<IBusModelDelTopDepObj>() {
			@Override
			public int compare( IBusModelDelTopDepObj lhs, IBusModelDelTopDepObj rhs ) {
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
	public List<IBusModelDelTopDepObj> readCachedDelTopDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedDelTopDepByDefSchemaIdx";
		IBusModelDelDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelDelTopDepObj> arrayList = new ArrayList<IBusModelDelTopDepObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelDelTopDepObj arr[] = new IBusModelDelTopDepObj[len];
				Iterator<IBusModelDelTopDepObj> valIter = dict.values().iterator();
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
			IBusModelDelTopDepObj obj;
			Iterator<IBusModelDelTopDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDelTopDepObj> cmp = new Comparator<IBusModelDelTopDepObj>() {
			@Override
			public int compare( IBusModelDelTopDepObj lhs, IBusModelDelTopDepObj rhs ) {
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
	public List<IBusModelDelTopDepObj> readCachedDelTopDepByDelDepIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "readCachedDelTopDepByDelDepIdx";
		IBusModelDelDepByDelDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
		key.setRequiredRelationId( RelationId );
		ArrayList<IBusModelDelTopDepObj> arrayList = new ArrayList<IBusModelDelTopDepObj>();
		if( indexByDelDepIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict;
			if( indexByDelDepIdx.containsKey( key ) ) {
				dict = indexByDelDepIdx.get( key );
				int len = dict.size();
				IBusModelDelTopDepObj arr[] = new IBusModelDelTopDepObj[len];
				Iterator<IBusModelDelTopDepObj> valIter = dict.values().iterator();
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
			IBusModelDelTopDepObj obj;
			Iterator<IBusModelDelTopDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDelTopDepObj> cmp = new Comparator<IBusModelDelTopDepObj>() {
			@Override
			public int compare( IBusModelDelTopDepObj lhs, IBusModelDelTopDepObj rhs ) {
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
	public List<IBusModelDelTopDepObj> readCachedDelTopDepByDelTopDepTblIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "readCachedDelTopDepByDelTopDepTblIdx";
		IBusModelDelTopDepByDelTopDepTblIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByDelTopDepTblIdxKey();
		key.setRequiredTableId( TableId );
		ArrayList<IBusModelDelTopDepObj> arrayList = new ArrayList<IBusModelDelTopDepObj>();
		if( indexByDelTopDepTblIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict;
			if( indexByDelTopDepTblIdx.containsKey( key ) ) {
				dict = indexByDelTopDepTblIdx.get( key );
				int len = dict.size();
				IBusModelDelTopDepObj arr[] = new IBusModelDelTopDepObj[len];
				Iterator<IBusModelDelTopDepObj> valIter = dict.values().iterator();
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
			IBusModelDelTopDepObj obj;
			Iterator<IBusModelDelTopDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDelTopDepObj> cmp = new Comparator<IBusModelDelTopDepObj>() {
			@Override
			public int compare( IBusModelDelTopDepObj lhs, IBusModelDelTopDepObj rhs ) {
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
	public IBusModelDelTopDepObj readCachedDelTopDepByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelDelTopDepObj obj = null;
		IBusModelDelTopDepByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelDelTopDepObj> valIter = members.values().iterator();
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
			Iterator<IBusModelDelTopDepObj> valIter = members.values().iterator();
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
	public List<IBusModelDelTopDepObj> readCachedDelTopDepByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedDelTopDepByPrevIdx";
		IBusModelDelTopDepByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelDelTopDepObj> arrayList = new ArrayList<IBusModelDelTopDepObj>();
		if( indexByPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict;
			if( indexByPrevIdx.containsKey( key ) ) {
				dict = indexByPrevIdx.get( key );
				int len = dict.size();
				IBusModelDelTopDepObj arr[] = new IBusModelDelTopDepObj[len];
				Iterator<IBusModelDelTopDepObj> valIter = dict.values().iterator();
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
			IBusModelDelTopDepObj obj;
			Iterator<IBusModelDelTopDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDelTopDepObj> cmp = new Comparator<IBusModelDelTopDepObj>() {
			@Override
			public int compare( IBusModelDelTopDepObj lhs, IBusModelDelTopDepObj rhs ) {
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
	public List<IBusModelDelTopDepObj> readCachedDelTopDepByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedDelTopDepByNextIdx";
		IBusModelDelTopDepByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelDelTopDepObj> arrayList = new ArrayList<IBusModelDelTopDepObj>();
		if( indexByNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict;
			if( indexByNextIdx.containsKey( key ) ) {
				dict = indexByNextIdx.get( key );
				int len = dict.size();
				IBusModelDelTopDepObj arr[] = new IBusModelDelTopDepObj[len];
				Iterator<IBusModelDelTopDepObj> valIter = dict.values().iterator();
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
			IBusModelDelTopDepObj obj;
			Iterator<IBusModelDelTopDepObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelDelTopDepObj> cmp = new Comparator<IBusModelDelTopDepObj>() {
			@Override
			public int compare( IBusModelDelTopDepObj lhs, IBusModelDelTopDepObj rhs ) {
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
	public void deepDisposeDelTopDepByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelDelTopDepObj obj = readCachedDelTopDepByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeDelTopDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeDelTopDepByTenantIdx";
		IBusModelDelTopDepObj obj;
		List<IBusModelDelTopDepObj> arrayList = readCachedDelTopDepByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelDelTopDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDelTopDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeDelTopDepByDefSchemaIdx";
		IBusModelDelTopDepObj obj;
		List<IBusModelDelTopDepObj> arrayList = readCachedDelTopDepByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelDelTopDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDelTopDepByDelDepIdx( IYCFKeyHash256 RelationId )
	{
		final String S_ProcName = "deepDisposeDelTopDepByDelDepIdx";
		IBusModelDelTopDepObj obj;
		List<IBusModelDelTopDepObj> arrayList = readCachedDelTopDepByDelDepIdx( RelationId );
		if( arrayList != null )  {
			Iterator<IBusModelDelTopDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDelTopDepByDelTopDepTblIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "deepDisposeDelTopDepByDelTopDepTblIdx";
		IBusModelDelTopDepObj obj;
		List<IBusModelDelTopDepObj> arrayList = readCachedDelTopDepByDelTopDepTblIdx( TableId );
		if( arrayList != null )  {
			Iterator<IBusModelDelTopDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDelTopDepByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelDelTopDepObj obj = readCachedDelTopDepByUNameIdx( TableId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeDelTopDepByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeDelTopDepByPrevIdx";
		IBusModelDelTopDepObj obj;
		List<IBusModelDelTopDepObj> arrayList = readCachedDelTopDepByPrevIdx( PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelDelTopDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeDelTopDepByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeDelTopDepByNextIdx";
		IBusModelDelTopDepObj obj;
		List<IBusModelDelTopDepObj> arrayList = readCachedDelTopDepByNextIdx( NextId );
		if( arrayList != null )  {
			Iterator<IBusModelDelTopDepObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelDelTopDepObj updateDelTopDep( IBusModelDelTopDepObj Obj ) {
		IBusModelDelTopDepObj obj = Obj;
		schema.getBusModelBackingStore().getTableDelTopDep().updateDelTopDep( null,
			Obj.getDelTopDepRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getDelTopDepTableObj().getClassCode() ) {
			obj = (IBusModelDelTopDepObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteDelTopDep( IBusModelDelTopDepObj Obj ) {
		IBusModelDelTopDepObj obj = Obj;
		IBusModelDelTopDepObj prev = obj.getOptionalLookupPrev();
		IBusModelDelTopDepObj next = obj.getOptionalLookupNext();
		schema.getBusModelBackingStore().getTableDelTopDep().deleteDelTopDep( null,
			obj.getDelTopDepRec() );
		Obj.forget();
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	@Override
	public void deleteDelTopDepByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelDelTopDepObj obj = readDelTopDep(Id);
		if( obj != null ) {
			IBusModelDelTopDepEditObj editObj = (IBusModelDelTopDepEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelDelTopDepEditObj)obj.beginEdit();
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
		deepDisposeDelTopDepByIdIdx( Id );
	}

	@Override
	public void deleteDelTopDepByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableDelTopDep().deleteDelTopDepByTenantIdx( null,
				TenantId );
			Iterator<IBusModelDelTopDepObj> iter = dict.values().iterator();
			IBusModelDelTopDepObj obj;
			List<IBusModelDelTopDepObj> toForget = new LinkedList<IBusModelDelTopDepObj>();
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
			schema.getBusModelBackingStore().getTableDelTopDep().deleteDelTopDepByTenantIdx( null,
				TenantId );
		}
		deepDisposeDelTopDepByTenantIdx( TenantId );
	}

	@Override
	public void deleteDelTopDepByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelDelDepByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelDelDepByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableDelTopDep().deleteDelTopDepByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelDelTopDepObj> iter = dict.values().iterator();
			IBusModelDelTopDepObj obj;
			List<IBusModelDelTopDepObj> toForget = new LinkedList<IBusModelDelTopDepObj>();
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
			schema.getBusModelBackingStore().getTableDelTopDep().deleteDelTopDepByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeDelTopDepByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteDelTopDepByDelDepIdx( IYCFKeyHash256 RelationId )
	{
		IBusModelDelDepByDelDepIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newByDelDepIdxKey();
		key.setRequiredRelationId( RelationId );
		if( indexByDelDepIdx == null ) {
			indexByDelDepIdx = new HashMap< IBusModelDelDepByDelDepIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > >();
		}
		if( indexByDelDepIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict = indexByDelDepIdx.get( key );
			schema.getBusModelBackingStore().getTableDelTopDep().deleteDelTopDepByDelDepIdx( null,
				RelationId );
			Iterator<IBusModelDelTopDepObj> iter = dict.values().iterator();
			IBusModelDelTopDepObj obj;
			List<IBusModelDelTopDepObj> toForget = new LinkedList<IBusModelDelTopDepObj>();
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
			schema.getBusModelBackingStore().getTableDelTopDep().deleteDelTopDepByDelDepIdx( null,
				RelationId );
		}
		deepDisposeDelTopDepByDelDepIdx( RelationId );
	}

	@Override
	public void deleteDelTopDepByDelTopDepTblIdx( IYCFKeyHash256 TableId )
	{
		IBusModelDelTopDepByDelTopDepTblIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByDelTopDepTblIdxKey();
		key.setRequiredTableId( TableId );
		if( indexByDelTopDepTblIdx == null ) {
			indexByDelTopDepTblIdx = new HashMap< IBusModelDelTopDepByDelTopDepTblIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > >();
		}
		if( indexByDelTopDepTblIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict = indexByDelTopDepTblIdx.get( key );
			schema.getBusModelBackingStore().getTableDelTopDep().deleteDelTopDepByDelTopDepTblIdx( null,
				TableId );
			Iterator<IBusModelDelTopDepObj> iter = dict.values().iterator();
			IBusModelDelTopDepObj obj;
			List<IBusModelDelTopDepObj> toForget = new LinkedList<IBusModelDelTopDepObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByDelTopDepTblIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableDelTopDep().deleteDelTopDepByDelTopDepTblIdx( null,
				TableId );
		}
		deepDisposeDelTopDepByDelTopDepTblIdx( TableId );
	}

	@Override
	public void deleteDelTopDepByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelDelTopDepByUNameIdxKey,
				IBusModelDelTopDepObj >();
		}
		IBusModelDelTopDepByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelDelTopDepObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableDelTopDep().deleteDelTopDepByUNameIdx( null,
				TableId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableDelTopDep().deleteDelTopDepByUNameIdx( null,
				TableId,
				Name );
		}
		deepDisposeDelTopDepByUNameIdx( TableId,
				Name );
	}

	@Override
	public void deleteDelTopDepByPrevIdx( IYCFKeyHash256 PrevId )
	{
		IBusModelDelTopDepByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelDelTopDepByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict = indexByPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableDelTopDep().deleteDelTopDepByPrevIdx( null,
				PrevId );
			Iterator<IBusModelDelTopDepObj> iter = dict.values().iterator();
			IBusModelDelTopDepObj obj;
			List<IBusModelDelTopDepObj> toForget = new LinkedList<IBusModelDelTopDepObj>();
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
			schema.getBusModelBackingStore().getTableDelTopDep().deleteDelTopDepByPrevIdx( null,
				PrevId );
		}
		deepDisposeDelTopDepByPrevIdx( PrevId );
	}

	@Override
	public void deleteDelTopDepByNextIdx( IYCFKeyHash256 NextId )
	{
		IBusModelDelTopDepByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryDelTopDep().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelDelTopDepByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelDelTopDepObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelDelTopDepObj> dict = indexByNextIdx.get( key );
			schema.getBusModelBackingStore().getTableDelTopDep().deleteDelTopDepByNextIdx( null,
				NextId );
			Iterator<IBusModelDelTopDepObj> iter = dict.values().iterator();
			IBusModelDelTopDepObj obj;
			List<IBusModelDelTopDepObj> toForget = new LinkedList<IBusModelDelTopDepObj>();
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
			schema.getBusModelBackingStore().getTableDelTopDep().deleteDelTopDepByNextIdx( null,
				NextId );
		}
		deepDisposeDelTopDepByNextIdx( NextId );
	}

	/**
	 *	Move the BusModelDelTopDepObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelDelTopDepObj refreshed cache instance.
	 */
	@Override
	public IBusModelDelTopDepObj moveUpDelTopDep( IBusModelDelTopDepObj Obj ) {
		IBusModelDelTopDepObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUpDelTopDep" );
		}
		IBusModelDelTopDep rec = schema.getBusModelBackingStore().getTableDelTopDep().moveRecUp( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getDelTopDepTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelDelTopDepObj)obj.realise();
			IBusModelDelTopDepObj prev = obj.getOptionalLookupPrev( true );
			IBusModelDelTopDepObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				IBusModelDelTopDepObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the BusModelDelTopDepObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelDelTopDepObj refreshed cache instance.
	 */
	@Override
	public IBusModelDelTopDepObj moveDownDelTopDep( IBusModelDelTopDepObj Obj ) {
		IBusModelDelTopDepObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDownDelTopDep" );
		}
		IBusModelDelTopDep rec = schema.getBusModelBackingStore().getTableDelTopDep().moveRecDown( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getDelTopDepTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelDelTopDepObj)obj.realise();
			IBusModelDelTopDepObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				IBusModelDelTopDepObj gprev = prev.getOptionalLookupPrev( true );
			}
			IBusModelDelTopDepObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}