// Description: Java 25 Table Object implementation for SchemaRef.

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

public class BusModelSchemaRefTableObj
	implements IBusModelSchemaRefTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelSchemaRef.CLASS_CODE;
	protected static final int backingClassCode = IBusModelSchemaRef.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> allSchemaRef;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > > indexByTenantIdx;
	private Map< IBusModelSchemaRefBySchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > > indexBySchemaIdx;
	private Map< IBusModelSchemaRefByUNameIdxKey,
		IBusModelSchemaRefObj > indexByUNameIdx;
	private Map< IBusModelSchemaRefByRefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > > indexByRefSchemaIdx;
	private Map< IBusModelSchemaRefByPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > > indexByPrevIdx;
	private Map< IBusModelSchemaRefByNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > > indexByNextIdx;
	public static String TABLE_NAME = "SchemaRef";
	public static String TABLE_DBNAME = "schema_ref";

	public BusModelSchemaRefTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj>();
		allSchemaRef = null;
		indexByTenantIdx = null;
		indexBySchemaIdx = null;
		indexByUNameIdx = null;
		indexByRefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
	}

	public BusModelSchemaRefTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj>();
		allSchemaRef = null;
		indexByTenantIdx = null;
		indexBySchemaIdx = null;
		indexByUNameIdx = null;
		indexByRefSchemaIdx = null;
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
		return BusModelSchemaRefTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelSchemaRefTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		return( null );
	}


	@Override
	public void minimizeMemory() {
		allSchemaRef = null;
		indexByTenantIdx = null;
		indexBySchemaIdx = null;
		indexByUNameIdx = null;
		indexByRefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		List<IBusModelSchemaRefObj> toForget = new LinkedList<IBusModelSchemaRefObj>();
		IBusModelSchemaRefObj cur = null;
		Iterator<IBusModelSchemaRefObj> iter = members.values().iterator();
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
	 *	BusModelSchemaRefObj.
	 */
	@Override
	public IBusModelSchemaRefObj newInstance() {
		IBusModelSchemaRefObj inst = new BusModelSchemaRefObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSchemaRefObj.
	 */
	@Override
	public IBusModelSchemaRefEditObj newEditInstance( IBusModelSchemaRefObj orig ) {
		IBusModelSchemaRefEditObj edit = new BusModelSchemaRefEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelSchemaRefObj realiseSchemaRef( IBusModelSchemaRefObj Obj ) {
		IBusModelSchemaRefObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelSchemaRefObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelSchemaRefObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexBySchemaIdx != null ) {
				IBusModelSchemaRefBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.remove( keepObj.getPKey() );
					if( mapSchemaIdx.size() <= 0 ) {
						indexBySchemaIdx.remove( keySchemaIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelSchemaRefByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByUNameIdxKey();
				keyUNameIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByRefSchemaIdx != null ) {
				IBusModelSchemaRefByRefSchemaIdxKey keyRefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByRefSchemaIdxKey();
				keyRefSchemaIdx.setOptionalRefSchemaId( keepObj.getOptionalRefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > mapRefSchemaIdx = indexByRefSchemaIdx.get( keyRefSchemaIdx );
				if( mapRefSchemaIdx != null ) {
					mapRefSchemaIdx.remove( keepObj.getPKey() );
					if( mapRefSchemaIdx.size() <= 0 ) {
						indexByRefSchemaIdx.remove( keyRefSchemaIdx );
					}
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelSchemaRefByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelSchemaRefByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
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
			keepObj = (IBusModelSchemaRefObj)schema.getScopeTableObj().realiseScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				IBusModelSchemaRefBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelSchemaRefByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByUNameIdxKey();
				keyUNameIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByRefSchemaIdx != null ) {
				IBusModelSchemaRefByRefSchemaIdxKey keyRefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByRefSchemaIdxKey();
				keyRefSchemaIdx.setOptionalRefSchemaId( keepObj.getOptionalRefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > mapRefSchemaIdx = indexByRefSchemaIdx.get( keyRefSchemaIdx );
				if( mapRefSchemaIdx != null ) {
					mapRefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelSchemaRefByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelSchemaRefByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSchemaRef != null ) {
				allSchemaRef.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelSchemaRefObj)schema.getScopeTableObj().realiseScope( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSchemaRef != null ) {
				allSchemaRef.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySchemaIdx != null ) {
				IBusModelSchemaRefBySchemaIdxKey keySchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newBySchemaIdxKey();
				keySchemaIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > mapSchemaIdx = indexBySchemaIdx.get( keySchemaIdx );
				if( mapSchemaIdx != null ) {
					mapSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelSchemaRefByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByUNameIdxKey();
				keyUNameIdx.setRequiredSchemaId( keepObj.getRequiredSchemaId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByRefSchemaIdx != null ) {
				IBusModelSchemaRefByRefSchemaIdxKey keyRefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByRefSchemaIdxKey();
				keyRefSchemaIdx.setOptionalRefSchemaId( keepObj.getOptionalRefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > mapRefSchemaIdx = indexByRefSchemaIdx.get( keyRefSchemaIdx );
				if( mapRefSchemaIdx != null ) {
					mapRefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelSchemaRefByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelSchemaRefByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelSchemaRefObj createSchemaRef( IBusModelSchemaRefObj Obj ) {
		IBusModelSchemaRefObj obj = Obj;
		IBusModelSchemaRef rec = obj.getSchemaRefRec();
		schema.getBusModelBackingStore().getTableSchemaRef().createSchemaRef(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelSchemaRefObj)(obj.realise());
		}
		IBusModelSchemaRefObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelSchemaRefObj readSchemaRef( $implCommaIJavaOptAtomType$ pkey ) {
		return( readSchemaRef( pkey, false ) );
	}

	@Override
	public IBusModelSchemaRefObj readSchemaRef( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelSchemaRefObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelSchemaRef readRec = schema.getBusModelBackingStore().getTableSchemaRef().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelSchemaRefObj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelSchemaRefObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelSchemaRefObj readCachedSchemaRef( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelSchemaRefObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSchemaRef( IBusModelSchemaRefObj obj )
	{
		final String S_ProcName = "BusModelSchemaRefTableObj.reallyDeepDisposeSchemaRef() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelSchemaRefObj existing = readCachedSchemaRef( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelSchemaRefBySchemaIdxKey keySchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newBySchemaIdxKey();
		keySchemaIdx.setRequiredSchemaId( existing.getRequiredSchemaId() );

		IBusModelSchemaRefByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByUNameIdxKey();
		keyUNameIdx.setRequiredSchemaId( existing.getRequiredSchemaId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		IBusModelSchemaRefByRefSchemaIdxKey keyRefSchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByRefSchemaIdxKey();
		keyRefSchemaIdx.setOptionalRefSchemaId( existing.getOptionalRefSchemaId() );

		IBusModelSchemaRefByPrevIdxKey keyPrevIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		IBusModelSchemaRefByNextIdxKey keyNextIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );



		if( indexBySchemaIdx != null ) {
			if( indexBySchemaIdx.containsKey( keySchemaIdx ) ) {
				indexBySchemaIdx.get( keySchemaIdx ).remove( pkey );
				if( indexBySchemaIdx.get( keySchemaIdx ).size() <= 0 ) {
					indexBySchemaIdx.remove( keySchemaIdx );
				}
			}
		}

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}

		if( indexByRefSchemaIdx != null ) {
			if( indexByRefSchemaIdx.containsKey( keyRefSchemaIdx ) ) {
				indexByRefSchemaIdx.get( keyRefSchemaIdx ).remove( pkey );
				if( indexByRefSchemaIdx.get( keyRefSchemaIdx ).size() <= 0 ) {
					indexByRefSchemaIdx.remove( keyRefSchemaIdx );
				}
			}
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


		schema.getScopeTableObj().reallyDeepDisposeScope( obj );
	}
	@Override
	public void deepDisposeSchemaRef( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelSchemaRefObj obj = readCachedSchemaRef( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelSchemaRefObj lockSchemaRef( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelSchemaRefObj locked = null;
		IBusModelSchemaRef lockRec = schema.getBusModelBackingStore().getTableSchemaRef().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelSchemaRefObj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelSchemaRefObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSchemaRef", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelSchemaRefObj> readAllSchemaRef() {
		return( readAllSchemaRef( false ) );
	}

	@Override
	public List<IBusModelSchemaRefObj> readAllSchemaRef( boolean forceRead ) {
		final String S_ProcName = "readAllSchemaRef";
		if( ( allSchemaRef == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelSchemaRefObj>();
			allSchemaRef = map;
			IBusModelSchemaRef[] recList = schema.getBusModelBackingStore().getTableSchemaRef().readAllDerived( null );
			IBusModelSchemaRef rec;
			IBusModelSchemaRefObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaRefObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaRefObj realised = (IBusModelSchemaRefObj)obj.realise();
			}
		}
		int len = allSchemaRef.size();
		IBusModelSchemaRefObj arr[] = new IBusModelSchemaRefObj[len];
		Iterator<IBusModelSchemaRefObj> valIter = allSchemaRef.values().iterator();
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
		ArrayList<IBusModelSchemaRefObj> arrayList = new ArrayList<IBusModelSchemaRefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaRefObj> cmp = new Comparator<IBusModelSchemaRefObj>() {
			@Override
			public int compare( IBusModelSchemaRefObj lhs, IBusModelSchemaRefObj rhs ) {
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
		List<IBusModelSchemaRefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelSchemaRefObj> readCachedAllSchemaRef() {
		final String S_ProcName = "readCachedAllSchemaRef";
		ArrayList<IBusModelSchemaRefObj> arrayList = new ArrayList<IBusModelSchemaRefObj>();
		if( allSchemaRef != null ) {
			int len = allSchemaRef.size();
			IBusModelSchemaRefObj arr[] = new IBusModelSchemaRefObj[len];
			Iterator<IBusModelSchemaRefObj> valIter = allSchemaRef.values().iterator();
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
		Comparator<IBusModelSchemaRefObj> cmp = new Comparator<IBusModelSchemaRefObj>() {
			public int compare( IBusModelSchemaRefObj lhs, IBusModelSchemaRefObj rhs ) {
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
	public IBusModelSchemaRefObj readSchemaRefByIdIdx( IYCFKeyHash256 Id )
	{
		return( readSchemaRefByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelSchemaRefObj readSchemaRefByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelSchemaRefObj obj = readSchemaRef( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelSchemaRefObj> readSchemaRefByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readSchemaRefByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelSchemaRefObj> readSchemaRefByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRefByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaRefObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaRefObj realised = (IBusModelSchemaRefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaRefObj arr[] = new IBusModelSchemaRefObj[len];
		Iterator<IBusModelSchemaRefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaRefObj> arrayList = new ArrayList<IBusModelSchemaRefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaRefObj> cmp = new Comparator<IBusModelSchemaRefObj>() {
			@Override
			public int compare( IBusModelSchemaRefObj lhs, IBusModelSchemaRefObj rhs ) {
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
		List<IBusModelSchemaRefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelSchemaRefObj> readSchemaRefBySchemaIdx( IYCFKeyHash256 SchemaId )
	{
		return( readSchemaRefBySchemaIdx( SchemaId,
			false ) );
	}

	@Override
	public List<IBusModelSchemaRefObj> readSchemaRefBySchemaIdx( IYCFKeyHash256 SchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRefBySchemaIdx";
		IBusModelSchemaRefBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newBySchemaIdxKey();
		key.setRequiredSchemaId( SchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> dict;
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< IBusModelSchemaRefBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > >();
		}
		if( ( ! forceRead ) && indexBySchemaIdx.containsKey( key ) ) {
			dict = indexBySchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj>();
			IBusModelSchemaRefObj obj;
			IBusModelSchemaRef[] recList = schema.getBusModelBackingStore().getTableSchemaRef().readDerivedBySchemaIdx( null,
				SchemaId );
			IBusModelSchemaRef rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaRefObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaRefObj realised = (IBusModelSchemaRefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaRefObj arr[] = new IBusModelSchemaRefObj[len];
		Iterator<IBusModelSchemaRefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaRefObj> arrayList = new ArrayList<IBusModelSchemaRefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaRefObj> cmp = new Comparator<IBusModelSchemaRefObj>() {
			@Override
			public int compare( IBusModelSchemaRefObj lhs, IBusModelSchemaRefObj rhs ) {
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
		List<IBusModelSchemaRefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelSchemaRefObj readSchemaRefByUNameIdx( IYCFKeyHash256 SchemaId,
		String Name )
	{
		return( readSchemaRefByUNameIdx( SchemaId,
			Name,
			false ) );
	}

	@Override
	public IBusModelSchemaRefObj readSchemaRefByUNameIdx( IYCFKeyHash256 SchemaId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelSchemaRefByUNameIdxKey,
				IBusModelSchemaRefObj >();
		}
		IBusModelSchemaRefByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByUNameIdxKey();
		key.setRequiredSchemaId( SchemaId );
		key.setRequiredName( Name );
		IBusModelSchemaRefObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelSchemaRef rec = schema.getBusModelBackingStore().getTableSchemaRef().readDerivedByUNameIdx( null,
				SchemaId,
				Name );
			if( rec != null ) {
				obj = (IBusModelSchemaRefObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelSchemaRefObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelSchemaRefObj> readSchemaRefByRefSchemaIdx( IYCFKeyHash256 RefSchemaId )
	{
		return( readSchemaRefByRefSchemaIdx( RefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelSchemaRefObj> readSchemaRefByRefSchemaIdx( IYCFKeyHash256 RefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRefByRefSchemaIdx";
		IBusModelSchemaRefByRefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByRefSchemaIdxKey();
		key.setOptionalRefSchemaId( RefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> dict;
		if( indexByRefSchemaIdx == null ) {
			indexByRefSchemaIdx = new HashMap< IBusModelSchemaRefByRefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > >();
		}
		if( ( ! forceRead ) && indexByRefSchemaIdx.containsKey( key ) ) {
			dict = indexByRefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj>();
			IBusModelSchemaRefObj obj;
			IBusModelSchemaRef[] recList = schema.getBusModelBackingStore().getTableSchemaRef().readDerivedByRefSchemaIdx( null,
				RefSchemaId );
			IBusModelSchemaRef rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaRefObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaRefObj realised = (IBusModelSchemaRefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByRefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaRefObj arr[] = new IBusModelSchemaRefObj[len];
		Iterator<IBusModelSchemaRefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaRefObj> arrayList = new ArrayList<IBusModelSchemaRefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaRefObj> cmp = new Comparator<IBusModelSchemaRefObj>() {
			@Override
			public int compare( IBusModelSchemaRefObj lhs, IBusModelSchemaRefObj rhs ) {
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
		List<IBusModelSchemaRefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelSchemaRefObj> readSchemaRefByPrevIdx( IYCFKeyHash256 PrevId )
	{
		return( readSchemaRefByPrevIdx( PrevId,
			false ) );
	}

	@Override
	public List<IBusModelSchemaRefObj> readSchemaRefByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRefByPrevIdx";
		IBusModelSchemaRefByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelSchemaRefByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj>();
			IBusModelSchemaRefObj obj;
			IBusModelSchemaRef[] recList = schema.getBusModelBackingStore().getTableSchemaRef().readDerivedByPrevIdx( null,
				PrevId );
			IBusModelSchemaRef rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaRefObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaRefObj realised = (IBusModelSchemaRefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaRefObj arr[] = new IBusModelSchemaRefObj[len];
		Iterator<IBusModelSchemaRefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaRefObj> arrayList = new ArrayList<IBusModelSchemaRefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaRefObj> cmp = new Comparator<IBusModelSchemaRefObj>() {
			@Override
			public int compare( IBusModelSchemaRefObj lhs, IBusModelSchemaRefObj rhs ) {
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
		List<IBusModelSchemaRefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelSchemaRefObj> readSchemaRefByNextIdx( IYCFKeyHash256 NextId )
	{
		return( readSchemaRefByNextIdx( NextId,
			false ) );
	}

	@Override
	public List<IBusModelSchemaRefObj> readSchemaRefByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaRefByNextIdx";
		IBusModelSchemaRefByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelSchemaRefByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj>();
			IBusModelSchemaRefObj obj;
			IBusModelSchemaRef[] recList = schema.getBusModelBackingStore().getTableSchemaRef().readDerivedByNextIdx( null,
				NextId );
			IBusModelSchemaRef rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaRefObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaRefObj realised = (IBusModelSchemaRefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaRefObj arr[] = new IBusModelSchemaRefObj[len];
		Iterator<IBusModelSchemaRefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaRefObj> arrayList = new ArrayList<IBusModelSchemaRefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaRefObj> cmp = new Comparator<IBusModelSchemaRefObj>() {
			@Override
			public int compare( IBusModelSchemaRefObj lhs, IBusModelSchemaRefObj rhs ) {
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
		List<IBusModelSchemaRefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelSchemaRefObj readCachedSchemaRefByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelSchemaRefObj obj = null;
		obj = readCachedSchemaRef( Id );
		return( obj );
	}

	@Override
	public List<IBusModelSchemaRefObj> readCachedSchemaRefByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedSchemaRefByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelSchemaRefObj> arrayList = new ArrayList<IBusModelSchemaRefObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelSchemaRefObj arr[] = new IBusModelSchemaRefObj[len];
				Iterator<IBusModelSchemaRefObj> valIter = dict.values().iterator();
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
			IBusModelSchemaRefObj obj;
			Iterator<IBusModelSchemaRefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaRefObj> cmp = new Comparator<IBusModelSchemaRefObj>() {
			@Override
			public int compare( IBusModelSchemaRefObj lhs, IBusModelSchemaRefObj rhs ) {
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
	public List<IBusModelSchemaRefObj> readCachedSchemaRefBySchemaIdx( IYCFKeyHash256 SchemaId )
	{
		final String S_ProcName = "readCachedSchemaRefBySchemaIdx";
		IBusModelSchemaRefBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newBySchemaIdxKey();
		key.setRequiredSchemaId( SchemaId );
		ArrayList<IBusModelSchemaRefObj> arrayList = new ArrayList<IBusModelSchemaRefObj>();
		if( indexBySchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> dict;
			if( indexBySchemaIdx.containsKey( key ) ) {
				dict = indexBySchemaIdx.get( key );
				int len = dict.size();
				IBusModelSchemaRefObj arr[] = new IBusModelSchemaRefObj[len];
				Iterator<IBusModelSchemaRefObj> valIter = dict.values().iterator();
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
			IBusModelSchemaRefObj obj;
			Iterator<IBusModelSchemaRefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaRefObj> cmp = new Comparator<IBusModelSchemaRefObj>() {
			@Override
			public int compare( IBusModelSchemaRefObj lhs, IBusModelSchemaRefObj rhs ) {
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
	public IBusModelSchemaRefObj readCachedSchemaRefByUNameIdx( IYCFKeyHash256 SchemaId,
		String Name )
	{
		IBusModelSchemaRefObj obj = null;
		IBusModelSchemaRefByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByUNameIdxKey();
		key.setRequiredSchemaId( SchemaId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelSchemaRefObj> valIter = members.values().iterator();
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
			Iterator<IBusModelSchemaRefObj> valIter = members.values().iterator();
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
	public List<IBusModelSchemaRefObj> readCachedSchemaRefByRefSchemaIdx( IYCFKeyHash256 RefSchemaId )
	{
		final String S_ProcName = "readCachedSchemaRefByRefSchemaIdx";
		IBusModelSchemaRefByRefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByRefSchemaIdxKey();
		key.setOptionalRefSchemaId( RefSchemaId );
		ArrayList<IBusModelSchemaRefObj> arrayList = new ArrayList<IBusModelSchemaRefObj>();
		if( indexByRefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> dict;
			if( indexByRefSchemaIdx.containsKey( key ) ) {
				dict = indexByRefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelSchemaRefObj arr[] = new IBusModelSchemaRefObj[len];
				Iterator<IBusModelSchemaRefObj> valIter = dict.values().iterator();
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
			IBusModelSchemaRefObj obj;
			Iterator<IBusModelSchemaRefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaRefObj> cmp = new Comparator<IBusModelSchemaRefObj>() {
			@Override
			public int compare( IBusModelSchemaRefObj lhs, IBusModelSchemaRefObj rhs ) {
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
	public List<IBusModelSchemaRefObj> readCachedSchemaRefByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedSchemaRefByPrevIdx";
		IBusModelSchemaRefByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelSchemaRefObj> arrayList = new ArrayList<IBusModelSchemaRefObj>();
		if( indexByPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> dict;
			if( indexByPrevIdx.containsKey( key ) ) {
				dict = indexByPrevIdx.get( key );
				int len = dict.size();
				IBusModelSchemaRefObj arr[] = new IBusModelSchemaRefObj[len];
				Iterator<IBusModelSchemaRefObj> valIter = dict.values().iterator();
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
			IBusModelSchemaRefObj obj;
			Iterator<IBusModelSchemaRefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaRefObj> cmp = new Comparator<IBusModelSchemaRefObj>() {
			@Override
			public int compare( IBusModelSchemaRefObj lhs, IBusModelSchemaRefObj rhs ) {
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
	public List<IBusModelSchemaRefObj> readCachedSchemaRefByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedSchemaRefByNextIdx";
		IBusModelSchemaRefByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelSchemaRefObj> arrayList = new ArrayList<IBusModelSchemaRefObj>();
		if( indexByNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> dict;
			if( indexByNextIdx.containsKey( key ) ) {
				dict = indexByNextIdx.get( key );
				int len = dict.size();
				IBusModelSchemaRefObj arr[] = new IBusModelSchemaRefObj[len];
				Iterator<IBusModelSchemaRefObj> valIter = dict.values().iterator();
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
			IBusModelSchemaRefObj obj;
			Iterator<IBusModelSchemaRefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaRefObj> cmp = new Comparator<IBusModelSchemaRefObj>() {
			@Override
			public int compare( IBusModelSchemaRefObj lhs, IBusModelSchemaRefObj rhs ) {
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
	public void deepDisposeSchemaRefByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelSchemaRefObj obj = readCachedSchemaRefByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSchemaRefByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeSchemaRefByTenantIdx";
		IBusModelSchemaRefObj obj;
		List<IBusModelSchemaRefObj> arrayList = readCachedSchemaRefByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaRefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSchemaRefBySchemaIdx( IYCFKeyHash256 SchemaId )
	{
		final String S_ProcName = "deepDisposeSchemaRefBySchemaIdx";
		IBusModelSchemaRefObj obj;
		List<IBusModelSchemaRefObj> arrayList = readCachedSchemaRefBySchemaIdx( SchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaRefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSchemaRefByUNameIdx( IYCFKeyHash256 SchemaId,
		String Name )
	{
		IBusModelSchemaRefObj obj = readCachedSchemaRefByUNameIdx( SchemaId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSchemaRefByRefSchemaIdx( IYCFKeyHash256 RefSchemaId )
	{
		final String S_ProcName = "deepDisposeSchemaRefByRefSchemaIdx";
		IBusModelSchemaRefObj obj;
		List<IBusModelSchemaRefObj> arrayList = readCachedSchemaRefByRefSchemaIdx( RefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaRefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSchemaRefByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeSchemaRefByPrevIdx";
		IBusModelSchemaRefObj obj;
		List<IBusModelSchemaRefObj> arrayList = readCachedSchemaRefByPrevIdx( PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaRefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSchemaRefByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeSchemaRefByNextIdx";
		IBusModelSchemaRefObj obj;
		List<IBusModelSchemaRefObj> arrayList = readCachedSchemaRefByNextIdx( NextId );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaRefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelSchemaRefObj updateSchemaRef( IBusModelSchemaRefObj Obj ) {
		IBusModelSchemaRefObj obj = Obj;
		schema.getBusModelBackingStore().getTableSchemaRef().updateSchemaRef( null,
			Obj.getSchemaRefRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getSchemaRefTableObj().getClassCode() ) {
			obj = (IBusModelSchemaRefObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSchemaRef( IBusModelSchemaRefObj Obj ) {
		IBusModelSchemaRefObj obj = Obj;
		IBusModelSchemaRefObj prev = obj.getOptionalLookupPrev();
		IBusModelSchemaRefObj next = obj.getOptionalLookupNext();
		schema.getBusModelBackingStore().getTableSchemaRef().deleteSchemaRef( null,
			obj.getSchemaRefRec() );
		Obj.forget();
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	@Override
	public void deleteSchemaRefByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelSchemaRefObj obj = readSchemaRef(Id);
		if( obj != null ) {
			IBusModelSchemaRefEditObj editObj = (IBusModelSchemaRefEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelSchemaRefEditObj)obj.beginEdit();
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
		deepDisposeSchemaRefByIdIdx( Id );
	}

	@Override
	public void deleteSchemaRefByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaRef().deleteSchemaRefByTenantIdx( null,
				TenantId );
			Iterator<IBusModelSchemaRefObj> iter = dict.values().iterator();
			IBusModelSchemaRefObj obj;
			List<IBusModelSchemaRefObj> toForget = new LinkedList<IBusModelSchemaRefObj>();
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
			schema.getBusModelBackingStore().getTableSchemaRef().deleteSchemaRefByTenantIdx( null,
				TenantId );
		}
		deepDisposeSchemaRefByTenantIdx( TenantId );
	}

	@Override
	public void deleteSchemaRefBySchemaIdx( IYCFKeyHash256 SchemaId )
	{
		IBusModelSchemaRefBySchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newBySchemaIdxKey();
		key.setRequiredSchemaId( SchemaId );
		if( indexBySchemaIdx == null ) {
			indexBySchemaIdx = new HashMap< IBusModelSchemaRefBySchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > >();
		}
		if( indexBySchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> dict = indexBySchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaRef().deleteSchemaRefBySchemaIdx( null,
				SchemaId );
			Iterator<IBusModelSchemaRefObj> iter = dict.values().iterator();
			IBusModelSchemaRefObj obj;
			List<IBusModelSchemaRefObj> toForget = new LinkedList<IBusModelSchemaRefObj>();
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
			schema.getBusModelBackingStore().getTableSchemaRef().deleteSchemaRefBySchemaIdx( null,
				SchemaId );
		}
		deepDisposeSchemaRefBySchemaIdx( SchemaId );
	}

	@Override
	public void deleteSchemaRefByUNameIdx( IYCFKeyHash256 SchemaId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelSchemaRefByUNameIdxKey,
				IBusModelSchemaRefObj >();
		}
		IBusModelSchemaRefByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByUNameIdxKey();
		key.setRequiredSchemaId( SchemaId );
		key.setRequiredName( Name );
		IBusModelSchemaRefObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaRef().deleteSchemaRefByUNameIdx( null,
				SchemaId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableSchemaRef().deleteSchemaRefByUNameIdx( null,
				SchemaId,
				Name );
		}
		deepDisposeSchemaRefByUNameIdx( SchemaId,
				Name );
	}

	@Override
	public void deleteSchemaRefByRefSchemaIdx( IYCFKeyHash256 RefSchemaId )
	{
		IBusModelSchemaRefByRefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByRefSchemaIdxKey();
		key.setOptionalRefSchemaId( RefSchemaId );
		if( indexByRefSchemaIdx == null ) {
			indexByRefSchemaIdx = new HashMap< IBusModelSchemaRefByRefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > >();
		}
		if( indexByRefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> dict = indexByRefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaRef().deleteSchemaRefByRefSchemaIdx( null,
				RefSchemaId );
			Iterator<IBusModelSchemaRefObj> iter = dict.values().iterator();
			IBusModelSchemaRefObj obj;
			List<IBusModelSchemaRefObj> toForget = new LinkedList<IBusModelSchemaRefObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByRefSchemaIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableSchemaRef().deleteSchemaRefByRefSchemaIdx( null,
				RefSchemaId );
		}
		deepDisposeSchemaRefByRefSchemaIdx( RefSchemaId );
	}

	@Override
	public void deleteSchemaRefByPrevIdx( IYCFKeyHash256 PrevId )
	{
		IBusModelSchemaRefByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelSchemaRefByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> dict = indexByPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaRef().deleteSchemaRefByPrevIdx( null,
				PrevId );
			Iterator<IBusModelSchemaRefObj> iter = dict.values().iterator();
			IBusModelSchemaRefObj obj;
			List<IBusModelSchemaRefObj> toForget = new LinkedList<IBusModelSchemaRefObj>();
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
			schema.getBusModelBackingStore().getTableSchemaRef().deleteSchemaRefByPrevIdx( null,
				PrevId );
		}
		deepDisposeSchemaRefByPrevIdx( PrevId );
	}

	@Override
	public void deleteSchemaRefByNextIdx( IYCFKeyHash256 NextId )
	{
		IBusModelSchemaRefByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelSchemaRefByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaRefObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaRefObj> dict = indexByNextIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaRef().deleteSchemaRefByNextIdx( null,
				NextId );
			Iterator<IBusModelSchemaRefObj> iter = dict.values().iterator();
			IBusModelSchemaRefObj obj;
			List<IBusModelSchemaRefObj> toForget = new LinkedList<IBusModelSchemaRefObj>();
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
			schema.getBusModelBackingStore().getTableSchemaRef().deleteSchemaRefByNextIdx( null,
				NextId );
		}
		deepDisposeSchemaRefByNextIdx( NextId );
	}

	/**
	 *	Move the BusModelSchemaRefObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelSchemaRefObj refreshed cache instance.
	 */
	@Override
	public IBusModelSchemaRefObj moveUpSchemaRef( IBusModelSchemaRefObj Obj ) {
		IBusModelSchemaRefObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUpSchemaRef" );
		}
		IBusModelSchemaRef rec = schema.getBusModelBackingStore().getTableSchemaRef().moveRecUp( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getSchemaRefTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelSchemaRefObj)obj.realise();
			IBusModelSchemaRefObj prev = obj.getOptionalLookupPrev( true );
			IBusModelSchemaRefObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				IBusModelSchemaRefObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the BusModelSchemaRefObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelSchemaRefObj refreshed cache instance.
	 */
	@Override
	public IBusModelSchemaRefObj moveDownSchemaRef( IBusModelSchemaRefObj Obj ) {
		IBusModelSchemaRefObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDownSchemaRef" );
		}
		IBusModelSchemaRef rec = schema.getBusModelBackingStore().getTableSchemaRef().moveRecDown( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getSchemaRefTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelSchemaRefObj)obj.realise();
			IBusModelSchemaRefObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				IBusModelSchemaRefObj gprev = prev.getOptionalLookupPrev( true );
			}
			IBusModelSchemaRefObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}