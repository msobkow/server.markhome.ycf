// Description: Java 25 Table Object implementation for TokenCol.

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

public class BusModelTokenColTableObj
	implements IBusModelTokenColTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelTokenCol.CLASS_CODE;
	protected static final int backingClassCode = IBusModelTokenCol.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> allTokenCol;
	private Map< IBusModelValueByUNameIdxKey,
		IBusModelTokenColObj > indexByUNameIdx;
	private Map< IBusModelValueByScopeIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > > indexByScopeIdx;
	private Map< IBusModelValueByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > > indexByDefSchemaIdx;
	private Map< IBusModelValueByPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > > indexByPrevIdx;
	private Map< IBusModelValueByNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > > indexByNextIdx;
	private Map< IBusModelValueByContPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > > indexByContPrevIdx;
	private Map< IBusModelValueByContNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > > indexByContNextIdx;
	private Map< IBusModelTokenColByTableIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > > indexByTableIdx;
	public static String TABLE_NAME = "TokenCol";
	public static String TABLE_DBNAME = "tkncol";

	public BusModelTokenColTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTokenColObj>();
		allTokenCol = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexByTableIdx = null;
	}

	public BusModelTokenColTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTokenColObj>();
		allTokenCol = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexByTableIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelTokenColTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelTokenColTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allTokenCol = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		indexByTableIdx = null;
		List<IBusModelTokenColObj> toForget = new LinkedList<IBusModelTokenColObj>();
		IBusModelTokenColObj cur = null;
		Iterator<IBusModelTokenColObj> iter = members.values().iterator();
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
	 *	BusModelTokenColObj.
	 */
	@Override
	public IBusModelTokenColObj newInstance() {
		IBusModelTokenColObj inst = new BusModelTokenColObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelTokenColObj.
	 */
	@Override
	public IBusModelTokenColEditObj newEditInstance( IBusModelTokenColObj orig ) {
		IBusModelTokenColEditObj edit = new BusModelTokenColEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelTokenColObj realiseTokenCol( IBusModelTokenColObj Obj ) {
		IBusModelTokenColObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelTokenColObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelTokenColObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				IBusModelValueByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByScopeIdx != null ) {
				IBusModelValueByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					indexByScopeIdx.remove( keyScopeIdx );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					indexByDefSchemaIdx.remove( keyDefSchemaIdx );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					indexByPrevIdx.remove( keyPrevIdx );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					indexByNextIdx.remove( keyNextIdx );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					indexByContPrevIdx.remove( keyContPrevIdx );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}

			if( indexByTableIdx != null ) {
				IBusModelTokenColByTableIdxKey keyTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTokenCol().newByTableIdxKey();
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
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
			keepObj = (IBusModelTokenColObj)schema.getTokenDefTableObj().realiseTokenDef( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				IBusModelValueByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByScopeIdx != null ) {
				IBusModelValueByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				IBusModelTokenColByTableIdxKey keyTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTokenCol().newByTableIdxKey();
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allTokenCol != null ) {
				allTokenCol.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelTokenColObj)schema.getTokenDefTableObj().realiseTokenDef( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTokenCol != null ) {
				allTokenCol.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				IBusModelValueByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByScopeIdx != null ) {
				IBusModelValueByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelValueByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelValueByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelValueByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelValueByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelValueByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
				keyContNextIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTableIdx != null ) {
				IBusModelTokenColByTableIdxKey keyTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryTokenCol().newByTableIdxKey();
				keyTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj > mapTableIdx = indexByTableIdx.get( keyTableIdx );
				if( mapTableIdx != null ) {
					mapTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelTokenColObj createTokenCol( IBusModelTokenColObj Obj ) {
		IBusModelTokenColObj obj = Obj;
		IBusModelTokenCol rec = obj.getTokenColRec();
		schema.getBusModelBackingStore().getTableTokenCol().createTokenCol(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelTokenColObj)(obj.realise());
		}
		IBusModelValueObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelTokenColObj readTokenCol( $implCommaIJavaOptAtomType$ pkey ) {
		return( readTokenCol( pkey, false ) );
	}

	@Override
	public IBusModelTokenColObj readTokenCol( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelTokenColObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelTokenCol readRec = schema.getBusModelBackingStore().getTableTokenCol().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelTokenColObj)schema.getValueTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelTokenColObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelTokenColObj readCachedTokenCol( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelTokenColObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeTokenCol( IBusModelTokenColObj obj )
	{
		final String S_ProcName = "BusModelTokenColTableObj.reallyDeepDisposeTokenCol() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelTokenColObj existing = readCachedTokenCol( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelTokenColByTableIdxKey keyTableIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTokenCol().newByTableIdxKey();
		keyTableIdx.setRequiredTableId( existing.getRequiredTableId() );


		schema.getTableColTableObj().deepDisposeTableColByDataIdx( existing.getRequiredId() );
		schema.getIndexColTableObj().deepDisposeIndexColByColIdx( existing.getRequiredId() );

		if( indexByTableIdx != null ) {
			if( indexByTableIdx.containsKey( keyTableIdx ) ) {
				indexByTableIdx.get( keyTableIdx ).remove( pkey );
				if( indexByTableIdx.get( keyTableIdx ).size() <= 0 ) {
					indexByTableIdx.remove( keyTableIdx );
				}
			}
		}


		schema.getTokenDefTableObj().reallyDeepDisposeTokenDef( obj );
	}
	@Override
	public void deepDisposeTokenCol( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelTokenColObj obj = readCachedTokenCol( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelTokenColObj lockTokenCol( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelTokenColObj locked = null;
		IBusModelTokenCol lockRec = schema.getBusModelBackingStore().getTableTokenCol().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelTokenColObj)schema.getValueTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelTokenColObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockTokenCol", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelTokenColObj> readAllTokenCol() {
		return( readAllTokenCol( false ) );
	}

	@Override
	public List<IBusModelTokenColObj> readAllTokenCol( boolean forceRead ) {
		final String S_ProcName = "readAllTokenCol";
		if( ( allTokenCol == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelTokenColObj>();
			allTokenCol = map;
			IBusModelTokenCol[] recList = schema.getBusModelBackingStore().getTableTokenCol().readAllDerived( null );
			IBusModelTokenCol rec;
			IBusModelTokenColObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTokenColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTokenColObj realised = (IBusModelTokenColObj)obj.realise();
			}
		}
		int len = allTokenCol.size();
		IBusModelTokenColObj arr[] = new IBusModelTokenColObj[len];
		Iterator<IBusModelTokenColObj> valIter = allTokenCol.values().iterator();
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
		ArrayList<IBusModelTokenColObj> arrayList = new ArrayList<IBusModelTokenColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTokenColObj> cmp = new Comparator<IBusModelTokenColObj>() {
			@Override
			public int compare( IBusModelTokenColObj lhs, IBusModelTokenColObj rhs ) {
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
		List<IBusModelTokenColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTokenColObj> readCachedAllTokenCol() {
		final String S_ProcName = "readCachedAllTokenCol";
		ArrayList<IBusModelTokenColObj> arrayList = new ArrayList<IBusModelTokenColObj>();
		if( allTokenCol != null ) {
			int len = allTokenCol.size();
			IBusModelTokenColObj arr[] = new IBusModelTokenColObj[len];
			Iterator<IBusModelTokenColObj> valIter = allTokenCol.values().iterator();
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
		Comparator<IBusModelTokenColObj> cmp = new Comparator<IBusModelTokenColObj>() {
			public int compare( IBusModelTokenColObj lhs, IBusModelTokenColObj rhs ) {
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
	public IBusModelTokenColObj readTokenColByIdIdx( IYCFKeyHash256 Id )
	{
		return( readTokenColByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelTokenColObj readTokenColByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelTokenColObj obj = readTokenCol( Id, forceRead );
		return( obj );
	}

	@Override
	public IBusModelTokenColObj readTokenColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		return( readTokenColByUNameIdx( ScopeId,
			Name,
			false ) );
	}

	@Override
	public IBusModelTokenColObj readTokenColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelValueByUNameIdxKey,
				IBusModelTokenColObj >();
		}
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelTokenColObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelValue rec = schema.getBusModelBackingStore().getTableValue().readDerivedByUNameIdx( null,
				ScopeId,
				Name );
			if( rec != null ) {
				obj = (IBusModelTokenColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelTokenColObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelTokenColObj> readTokenColByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		return( readTokenColByScopeIdx( ScopeId,
			false ) );
	}

	@Override
	public List<IBusModelTokenColObj> readTokenColByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readTokenColByScopeIdx";
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelValueByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTokenColObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTokenColObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByScopeIdx( null,
				ScopeId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTokenColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTokenColObj realised = (IBusModelTokenColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTokenColObj arr[] = new IBusModelTokenColObj[len];
		Iterator<IBusModelTokenColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTokenColObj> arrayList = new ArrayList<IBusModelTokenColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTokenColObj> cmp = new Comparator<IBusModelTokenColObj>() {
			@Override
			public int compare( IBusModelTokenColObj lhs, IBusModelTokenColObj rhs ) {
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
		List<IBusModelTokenColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTokenColObj> readTokenColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readTokenColByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelTokenColObj> readTokenColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readTokenColByDefSchemaIdx";
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelValueByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTokenColObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTokenColObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTokenColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTokenColObj realised = (IBusModelTokenColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTokenColObj arr[] = new IBusModelTokenColObj[len];
		Iterator<IBusModelTokenColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTokenColObj> arrayList = new ArrayList<IBusModelTokenColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTokenColObj> cmp = new Comparator<IBusModelTokenColObj>() {
			@Override
			public int compare( IBusModelTokenColObj lhs, IBusModelTokenColObj rhs ) {
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
		List<IBusModelTokenColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTokenColObj> readTokenColByPrevIdx( IYCFKeyHash256 PrevId )
	{
		return( readTokenColByPrevIdx( PrevId,
			false ) );
	}

	@Override
	public List<IBusModelTokenColObj> readTokenColByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readTokenColByPrevIdx";
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelValueByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTokenColObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTokenColObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByPrevIdx( null,
				PrevId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTokenColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTokenColObj realised = (IBusModelTokenColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTokenColObj arr[] = new IBusModelTokenColObj[len];
		Iterator<IBusModelTokenColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTokenColObj> arrayList = new ArrayList<IBusModelTokenColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTokenColObj> cmp = new Comparator<IBusModelTokenColObj>() {
			@Override
			public int compare( IBusModelTokenColObj lhs, IBusModelTokenColObj rhs ) {
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
		List<IBusModelTokenColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTokenColObj> readTokenColByNextIdx( IYCFKeyHash256 NextId )
	{
		return( readTokenColByNextIdx( NextId,
			false ) );
	}

	@Override
	public List<IBusModelTokenColObj> readTokenColByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readTokenColByNextIdx";
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelValueByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTokenColObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTokenColObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByNextIdx( null,
				NextId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTokenColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTokenColObj realised = (IBusModelTokenColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTokenColObj arr[] = new IBusModelTokenColObj[len];
		Iterator<IBusModelTokenColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTokenColObj> arrayList = new ArrayList<IBusModelTokenColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTokenColObj> cmp = new Comparator<IBusModelTokenColObj>() {
			@Override
			public int compare( IBusModelTokenColObj lhs, IBusModelTokenColObj rhs ) {
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
		List<IBusModelTokenColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTokenColObj> readTokenColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		return( readTokenColByContPrevIdx( ScopeId,
			PrevId,
			false ) );
	}

	@Override
	public List<IBusModelTokenColObj> readTokenColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readTokenColByContPrevIdx";
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< IBusModelValueByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTokenColObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTokenColObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByContPrevIdx( null,
				ScopeId,
				PrevId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTokenColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTokenColObj realised = (IBusModelTokenColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTokenColObj arr[] = new IBusModelTokenColObj[len];
		Iterator<IBusModelTokenColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTokenColObj> arrayList = new ArrayList<IBusModelTokenColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTokenColObj> cmp = new Comparator<IBusModelTokenColObj>() {
			@Override
			public int compare( IBusModelTokenColObj lhs, IBusModelTokenColObj rhs ) {
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
		List<IBusModelTokenColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTokenColObj> readTokenColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		return( readTokenColByContNextIdx( ScopeId,
			NextId,
			false ) );
	}

	@Override
	public List<IBusModelTokenColObj> readTokenColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readTokenColByContNextIdx";
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< IBusModelValueByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTokenColObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTokenColObj>();
			IBusModelValueObj obj;
			IBusModelValue[] recList = schema.getBusModelBackingStore().getTableValue().readDerivedByContNextIdx( null,
				ScopeId,
				NextId );
			IBusModelValue rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTokenColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTokenColObj realised = (IBusModelTokenColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTokenColObj arr[] = new IBusModelTokenColObj[len];
		Iterator<IBusModelTokenColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTokenColObj> arrayList = new ArrayList<IBusModelTokenColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTokenColObj> cmp = new Comparator<IBusModelTokenColObj>() {
			@Override
			public int compare( IBusModelTokenColObj lhs, IBusModelTokenColObj rhs ) {
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
		List<IBusModelTokenColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelTokenColObj> readTokenColByTableIdx( IYCFKeyHash256 TableId )
	{
		return( readTokenColByTableIdx( TableId,
			false ) );
	}

	@Override
	public List<IBusModelTokenColObj> readTokenColByTableIdx( IYCFKeyHash256 TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readTokenColByTableIdx";
		IBusModelTokenColByTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTokenCol().newByTableIdxKey();
		key.setRequiredTableId( TableId );
		Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict;
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< IBusModelTokenColByTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTokenColObj > >();
		}
		if( ( ! forceRead ) && indexByTableIdx.containsKey( key ) ) {
			dict = indexByTableIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelTokenColObj>();
			IBusModelTokenColObj obj;
			IBusModelTokenCol[] recList = schema.getBusModelBackingStore().getTableTokenCol().readDerivedByTableIdx( null,
				TableId );
			IBusModelTokenCol rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelTokenColObj)schema.getValueTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelTokenColObj realised = (IBusModelTokenColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTableIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelTokenColObj arr[] = new IBusModelTokenColObj[len];
		Iterator<IBusModelTokenColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelTokenColObj> arrayList = new ArrayList<IBusModelTokenColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelTokenColObj> cmp = new Comparator<IBusModelTokenColObj>() {
			@Override
			public int compare( IBusModelTokenColObj lhs, IBusModelTokenColObj rhs ) {
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
		List<IBusModelTokenColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelTokenColObj readCachedTokenColByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelTokenColObj obj = null;
		obj = readCachedTokenCol( Id );
		return( obj );
	}

	@Override
	public IBusModelTokenColObj readCachedTokenColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelTokenColObj obj = null;
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelTokenColObj> valIter = members.values().iterator();
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
			Iterator<IBusModelTokenColObj> valIter = members.values().iterator();
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
	public List<IBusModelTokenColObj> readCachedTokenColByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "readCachedTokenColByScopeIdx";
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		ArrayList<IBusModelTokenColObj> arrayList = new ArrayList<IBusModelTokenColObj>();
		if( indexByScopeIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict;
			if( indexByScopeIdx.containsKey( key ) ) {
				dict = indexByScopeIdx.get( key );
				int len = dict.size();
				IBusModelTokenColObj arr[] = new IBusModelTokenColObj[len];
				Iterator<IBusModelTokenColObj> valIter = dict.values().iterator();
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
			IBusModelTokenColObj obj;
			Iterator<IBusModelTokenColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTokenColObj> cmp = new Comparator<IBusModelTokenColObj>() {
			@Override
			public int compare( IBusModelTokenColObj lhs, IBusModelTokenColObj rhs ) {
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
	public List<IBusModelTokenColObj> readCachedTokenColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedTokenColByDefSchemaIdx";
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelTokenColObj> arrayList = new ArrayList<IBusModelTokenColObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelTokenColObj arr[] = new IBusModelTokenColObj[len];
				Iterator<IBusModelTokenColObj> valIter = dict.values().iterator();
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
			IBusModelTokenColObj obj;
			Iterator<IBusModelTokenColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTokenColObj> cmp = new Comparator<IBusModelTokenColObj>() {
			@Override
			public int compare( IBusModelTokenColObj lhs, IBusModelTokenColObj rhs ) {
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
	public List<IBusModelTokenColObj> readCachedTokenColByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedTokenColByPrevIdx";
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelTokenColObj> arrayList = new ArrayList<IBusModelTokenColObj>();
		if( indexByPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict;
			if( indexByPrevIdx.containsKey( key ) ) {
				dict = indexByPrevIdx.get( key );
				int len = dict.size();
				IBusModelTokenColObj arr[] = new IBusModelTokenColObj[len];
				Iterator<IBusModelTokenColObj> valIter = dict.values().iterator();
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
			IBusModelTokenColObj obj;
			Iterator<IBusModelTokenColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTokenColObj> cmp = new Comparator<IBusModelTokenColObj>() {
			@Override
			public int compare( IBusModelTokenColObj lhs, IBusModelTokenColObj rhs ) {
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
	public List<IBusModelTokenColObj> readCachedTokenColByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedTokenColByNextIdx";
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelTokenColObj> arrayList = new ArrayList<IBusModelTokenColObj>();
		if( indexByNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict;
			if( indexByNextIdx.containsKey( key ) ) {
				dict = indexByNextIdx.get( key );
				int len = dict.size();
				IBusModelTokenColObj arr[] = new IBusModelTokenColObj[len];
				Iterator<IBusModelTokenColObj> valIter = dict.values().iterator();
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
			IBusModelTokenColObj obj;
			Iterator<IBusModelTokenColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTokenColObj> cmp = new Comparator<IBusModelTokenColObj>() {
			@Override
			public int compare( IBusModelTokenColObj lhs, IBusModelTokenColObj rhs ) {
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
	public List<IBusModelTokenColObj> readCachedTokenColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedTokenColByContPrevIdx";
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelTokenColObj> arrayList = new ArrayList<IBusModelTokenColObj>();
		if( indexByContPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict;
			if( indexByContPrevIdx.containsKey( key ) ) {
				dict = indexByContPrevIdx.get( key );
				int len = dict.size();
				IBusModelTokenColObj arr[] = new IBusModelTokenColObj[len];
				Iterator<IBusModelTokenColObj> valIter = dict.values().iterator();
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
			IBusModelTokenColObj obj;
			Iterator<IBusModelTokenColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTokenColObj> cmp = new Comparator<IBusModelTokenColObj>() {
			@Override
			public int compare( IBusModelTokenColObj lhs, IBusModelTokenColObj rhs ) {
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
	public List<IBusModelTokenColObj> readCachedTokenColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedTokenColByContNextIdx";
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelTokenColObj> arrayList = new ArrayList<IBusModelTokenColObj>();
		if( indexByContNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict;
			if( indexByContNextIdx.containsKey( key ) ) {
				dict = indexByContNextIdx.get( key );
				int len = dict.size();
				IBusModelTokenColObj arr[] = new IBusModelTokenColObj[len];
				Iterator<IBusModelTokenColObj> valIter = dict.values().iterator();
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
			IBusModelTokenColObj obj;
			Iterator<IBusModelTokenColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTokenColObj> cmp = new Comparator<IBusModelTokenColObj>() {
			@Override
			public int compare( IBusModelTokenColObj lhs, IBusModelTokenColObj rhs ) {
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
	public List<IBusModelTokenColObj> readCachedTokenColByTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "readCachedTokenColByTableIdx";
		IBusModelTokenColByTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTokenCol().newByTableIdxKey();
		key.setRequiredTableId( TableId );
		ArrayList<IBusModelTokenColObj> arrayList = new ArrayList<IBusModelTokenColObj>();
		if( indexByTableIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict;
			if( indexByTableIdx.containsKey( key ) ) {
				dict = indexByTableIdx.get( key );
				int len = dict.size();
				IBusModelTokenColObj arr[] = new IBusModelTokenColObj[len];
				Iterator<IBusModelTokenColObj> valIter = dict.values().iterator();
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
			IBusModelTokenColObj obj;
			Iterator<IBusModelTokenColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelTokenColObj> cmp = new Comparator<IBusModelTokenColObj>() {
			@Override
			public int compare( IBusModelTokenColObj lhs, IBusModelTokenColObj rhs ) {
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
	public void deepDisposeTokenColByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelTokenColObj obj = readCachedTokenColByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTokenColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelTokenColObj obj = readCachedTokenColByUNameIdx( ScopeId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTokenColByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "deepDisposeTokenColByScopeIdx";
		IBusModelTokenColObj obj;
		List<IBusModelTokenColObj> arrayList = readCachedTokenColByScopeIdx( ScopeId );
		if( arrayList != null )  {
			Iterator<IBusModelTokenColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTokenColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeTokenColByDefSchemaIdx";
		IBusModelTokenColObj obj;
		List<IBusModelTokenColObj> arrayList = readCachedTokenColByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelTokenColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTokenColByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeTokenColByPrevIdx";
		IBusModelTokenColObj obj;
		List<IBusModelTokenColObj> arrayList = readCachedTokenColByPrevIdx( PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelTokenColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTokenColByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeTokenColByNextIdx";
		IBusModelTokenColObj obj;
		List<IBusModelTokenColObj> arrayList = readCachedTokenColByNextIdx( NextId );
		if( arrayList != null )  {
			Iterator<IBusModelTokenColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTokenColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeTokenColByContPrevIdx";
		IBusModelTokenColObj obj;
		List<IBusModelTokenColObj> arrayList = readCachedTokenColByContPrevIdx( ScopeId,
				PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelTokenColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTokenColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeTokenColByContNextIdx";
		IBusModelTokenColObj obj;
		List<IBusModelTokenColObj> arrayList = readCachedTokenColByContNextIdx( ScopeId,
				NextId );
		if( arrayList != null )  {
			Iterator<IBusModelTokenColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTokenColByTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "deepDisposeTokenColByTableIdx";
		IBusModelTokenColObj obj;
		List<IBusModelTokenColObj> arrayList = readCachedTokenColByTableIdx( TableId );
		if( arrayList != null )  {
			Iterator<IBusModelTokenColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelTokenColObj updateTokenCol( IBusModelTokenColObj Obj ) {
		IBusModelTokenColObj obj = Obj;
		schema.getBusModelBackingStore().getTableTokenCol().updateTokenCol( null,
			Obj.getTokenColRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getTokenColTableObj().getClassCode() ) {
			obj = (IBusModelTokenColObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteTokenCol( IBusModelTokenColObj Obj ) {
		IBusModelTokenColObj obj = Obj;
		IBusModelValueObj prev = obj.getOptionalLookupPrev();
		IBusModelValueObj next = obj.getOptionalLookupNext();
		schema.getBusModelBackingStore().getTableTokenCol().deleteTokenCol( null,
			obj.getTokenColRec() );
		Obj.forget();
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	@Override
	public void deleteTokenColByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelTokenColObj obj = readTokenCol(Id);
		if( obj != null ) {
			IBusModelTokenColEditObj editObj = (IBusModelTokenColEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelTokenColEditObj)obj.beginEdit();
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
		deepDisposeTokenColByIdIdx( Id );
	}

	@Override
	public void deleteTokenColByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelValueByUNameIdxKey,
				IBusModelTokenColObj >();
		}
		IBusModelValueByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelTokenColObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableTokenCol().deleteTokenColByUNameIdx( null,
				ScopeId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableTokenCol().deleteTokenColByUNameIdx( null,
				ScopeId,
				Name );
		}
		deepDisposeTokenColByUNameIdx( ScopeId,
				Name );
	}

	@Override
	public void deleteTokenColByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		IBusModelValueByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelValueByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTokenColObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict = indexByScopeIdx.get( key );
			schema.getBusModelBackingStore().getTableTokenCol().deleteTokenColByScopeIdx( null,
				ScopeId );
			Iterator<IBusModelTokenColObj> iter = dict.values().iterator();
			IBusModelTokenColObj obj;
			List<IBusModelTokenColObj> toForget = new LinkedList<IBusModelTokenColObj>();
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
			schema.getBusModelBackingStore().getTableTokenCol().deleteTokenColByScopeIdx( null,
				ScopeId );
		}
		deepDisposeTokenColByScopeIdx( ScopeId );
	}

	@Override
	public void deleteTokenColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelValueByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelValueByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTokenColObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableTokenCol().deleteTokenColByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelTokenColObj> iter = dict.values().iterator();
			IBusModelTokenColObj obj;
			List<IBusModelTokenColObj> toForget = new LinkedList<IBusModelTokenColObj>();
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
			schema.getBusModelBackingStore().getTableTokenCol().deleteTokenColByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeTokenColByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteTokenColByPrevIdx( IYCFKeyHash256 PrevId )
	{
		IBusModelValueByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelValueByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTokenColObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict = indexByPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableTokenCol().deleteTokenColByPrevIdx( null,
				PrevId );
			Iterator<IBusModelTokenColObj> iter = dict.values().iterator();
			IBusModelTokenColObj obj;
			List<IBusModelTokenColObj> toForget = new LinkedList<IBusModelTokenColObj>();
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
			schema.getBusModelBackingStore().getTableTokenCol().deleteTokenColByPrevIdx( null,
				PrevId );
		}
		deepDisposeTokenColByPrevIdx( PrevId );
	}

	@Override
	public void deleteTokenColByNextIdx( IYCFKeyHash256 NextId )
	{
		IBusModelValueByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelValueByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTokenColObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict = indexByNextIdx.get( key );
			schema.getBusModelBackingStore().getTableTokenCol().deleteTokenColByNextIdx( null,
				NextId );
			Iterator<IBusModelTokenColObj> iter = dict.values().iterator();
			IBusModelTokenColObj obj;
			List<IBusModelTokenColObj> toForget = new LinkedList<IBusModelTokenColObj>();
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
			schema.getBusModelBackingStore().getTableTokenCol().deleteTokenColByNextIdx( null,
				NextId );
		}
		deepDisposeTokenColByNextIdx( NextId );
	}

	@Override
	public void deleteTokenColByContPrevIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 PrevId )
	{
		IBusModelValueByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContPrevIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< IBusModelValueByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTokenColObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict = indexByContPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableTokenCol().deleteTokenColByContPrevIdx( null,
				ScopeId,
				PrevId );
			Iterator<IBusModelTokenColObj> iter = dict.values().iterator();
			IBusModelTokenColObj obj;
			List<IBusModelTokenColObj> toForget = new LinkedList<IBusModelTokenColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByContPrevIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableTokenCol().deleteTokenColByContPrevIdx( null,
				ScopeId,
				PrevId );
		}
		deepDisposeTokenColByContPrevIdx( ScopeId,
				PrevId );
	}

	@Override
	public void deleteTokenColByContNextIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 NextId )
	{
		IBusModelValueByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryValue().newByContNextIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< IBusModelValueByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTokenColObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict = indexByContNextIdx.get( key );
			schema.getBusModelBackingStore().getTableTokenCol().deleteTokenColByContNextIdx( null,
				ScopeId,
				NextId );
			Iterator<IBusModelTokenColObj> iter = dict.values().iterator();
			IBusModelTokenColObj obj;
			List<IBusModelTokenColObj> toForget = new LinkedList<IBusModelTokenColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByContNextIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableTokenCol().deleteTokenColByContNextIdx( null,
				ScopeId,
				NextId );
		}
		deepDisposeTokenColByContNextIdx( ScopeId,
				NextId );
	}

	@Override
	public void deleteTokenColByTableIdx( IYCFKeyHash256 TableId )
	{
		IBusModelTokenColByTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryTokenCol().newByTableIdxKey();
		key.setRequiredTableId( TableId );
		if( indexByTableIdx == null ) {
			indexByTableIdx = new HashMap< IBusModelTokenColByTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelTokenColObj > >();
		}
		if( indexByTableIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelTokenColObj> dict = indexByTableIdx.get( key );
			schema.getBusModelBackingStore().getTableTokenCol().deleteTokenColByTableIdx( null,
				TableId );
			Iterator<IBusModelTokenColObj> iter = dict.values().iterator();
			IBusModelTokenColObj obj;
			List<IBusModelTokenColObj> toForget = new LinkedList<IBusModelTokenColObj>();
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
			schema.getBusModelBackingStore().getTableTokenCol().deleteTokenColByTableIdx( null,
				TableId );
		}
		deepDisposeTokenColByTableIdx( TableId );
	}

	/**
	 *	Move the BusModelTokenColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelTokenColObj refreshed cache instance.
	 */
	@Override
	public IBusModelTokenColObj moveUpTokenCol( IBusModelTokenColObj Obj ) {
		IBusModelTokenColObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUpTokenCol" );
		}
		IBusModelTokenCol rec = schema.getBusModelBackingStore().getTableTokenCol().moveRecUp( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getTokenColTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelTokenColObj)obj.realise();
			IBusModelValueObj prev = obj.getOptionalLookupPrev( true );
			IBusModelValueObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				IBusModelValueObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the BusModelTokenColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelTokenColObj refreshed cache instance.
	 */
	@Override
	public IBusModelTokenColObj moveDownTokenCol( IBusModelTokenColObj Obj ) {
		IBusModelTokenColObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDownTokenCol" );
		}
		IBusModelTokenCol rec = schema.getBusModelBackingStore().getTableTokenCol().moveRecDown( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getTokenColTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelTokenColObj)obj.realise();
			IBusModelValueObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				IBusModelValueObj gprev = prev.getOptionalLookupPrev( true );
			}
			IBusModelValueObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}