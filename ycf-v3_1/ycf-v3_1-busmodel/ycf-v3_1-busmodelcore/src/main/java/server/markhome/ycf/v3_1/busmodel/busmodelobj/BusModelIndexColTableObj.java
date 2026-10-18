// Description: Java 25 Table Object implementation for IndexCol.

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

public class BusModelIndexColTableObj
	implements IBusModelIndexColTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelIndexCol.CLASS_CODE;
	protected static final int backingClassCode = IBusModelIndexCol.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> allIndexCol;
	private Map< IBusModelIndexColByUNameIdxKey,
		IBusModelIndexColObj > indexByUNameIdx;
	private Map< IBusModelIndexColByIndexIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > > indexByIndexIdx;
	private Map< IBusModelIndexColByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > > indexByDefSchemaIdx;
	private Map< IBusModelIndexColByColIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > > indexByColIdx;
	private Map< IBusModelIndexColByPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > > indexByPrevIdx;
	private Map< IBusModelIndexColByNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > > indexByNextIdx;
	private Map< IBusModelIndexColByIdxPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > > indexByIdxPrevIdx;
	private Map< IBusModelIndexColByIdxNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > > indexByIdxNextIdx;
	public static String TABLE_NAME = "IndexCol";
	public static String TABLE_DBNAME = "idxcol";

	public BusModelIndexColTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexColObj>();
		allIndexCol = null;
		indexByUNameIdx = null;
		indexByIndexIdx = null;
		indexByDefSchemaIdx = null;
		indexByColIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByIdxPrevIdx = null;
		indexByIdxNextIdx = null;
	}

	public BusModelIndexColTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexColObj>();
		allIndexCol = null;
		indexByUNameIdx = null;
		indexByIndexIdx = null;
		indexByDefSchemaIdx = null;
		indexByColIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByIdxPrevIdx = null;
		indexByIdxNextIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelIndexColTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelIndexColTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allIndexCol = null;
		indexByUNameIdx = null;
		indexByIndexIdx = null;
		indexByDefSchemaIdx = null;
		indexByColIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByIdxPrevIdx = null;
		indexByIdxNextIdx = null;
		List<IBusModelIndexColObj> toForget = new LinkedList<IBusModelIndexColObj>();
		IBusModelIndexColObj cur = null;
		Iterator<IBusModelIndexColObj> iter = members.values().iterator();
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
	 *	BusModelIndexColObj.
	 */
	@Override
	public IBusModelIndexColObj newInstance() {
		IBusModelIndexColObj inst = new BusModelIndexColObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelIndexColObj.
	 */
	@Override
	public IBusModelIndexColEditObj newEditInstance( IBusModelIndexColObj orig ) {
		IBusModelIndexColEditObj edit = new BusModelIndexColEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelIndexColObj constructByClassCode( int backingClassCode ) {
		IBusModelIndexColObj obj = null;
		if( backingClassCode == IBusModelIndexCol.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getIndexColTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public IBusModelIndexColObj realiseIndexCol( IBusModelIndexColObj Obj ) {
		IBusModelIndexColObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelIndexColObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelIndexColObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				IBusModelIndexColByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByUNameIdxKey();
				keyUNameIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByIndexIdx != null ) {
				IBusModelIndexColByIndexIdxKey keyIndexIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIndexIdxKey();
				keyIndexIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapIndexIdx = indexByIndexIdx.get( keyIndexIdx );
				if( mapIndexIdx != null ) {
					mapIndexIdx.remove( keepObj.getPKey() );
					if( mapIndexIdx.size() <= 0 ) {
						indexByIndexIdx.remove( keyIndexIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelIndexColByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByColIdx != null ) {
				IBusModelIndexColByColIdxKey keyColIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByColIdxKey();
				keyColIdx.setRequiredColumnId( keepObj.getRequiredColumnId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapColIdx = indexByColIdx.get( keyColIdx );
				if( mapColIdx != null ) {
					mapColIdx.remove( keepObj.getPKey() );
					if( mapColIdx.size() <= 0 ) {
						indexByColIdx.remove( keyColIdx );
					}
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelIndexColByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelIndexColByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
					if( mapNextIdx.size() <= 0 ) {
						indexByNextIdx.remove( keyNextIdx );
					}
				}
			}

			if( indexByIdxPrevIdx != null ) {
				IBusModelIndexColByIdxPrevIdxKey keyIdxPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIdxPrevIdxKey();
				keyIdxPrevIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyIdxPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapIdxPrevIdx = indexByIdxPrevIdx.get( keyIdxPrevIdx );
				if( mapIdxPrevIdx != null ) {
					mapIdxPrevIdx.remove( keepObj.getPKey() );
					if( mapIdxPrevIdx.size() <= 0 ) {
						indexByIdxPrevIdx.remove( keyIdxPrevIdx );
					}
				}
			}

			if( indexByIdxNextIdx != null ) {
				IBusModelIndexColByIdxNextIdxKey keyIdxNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIdxNextIdxKey();
				keyIdxNextIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyIdxNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapIdxNextIdx = indexByIdxNextIdx.get( keyIdxNextIdx );
				if( mapIdxNextIdx != null ) {
					mapIdxNextIdx.remove( keepObj.getPKey() );
					if( mapIdxNextIdx.size() <= 0 ) {
						indexByIdxNextIdx.remove( keyIdxNextIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				IBusModelIndexColByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByUNameIdxKey();
				keyUNameIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByIndexIdx != null ) {
				IBusModelIndexColByIndexIdxKey keyIndexIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIndexIdxKey();
				keyIndexIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapIndexIdx = indexByIndexIdx.get( keyIndexIdx );
				if( mapIndexIdx != null ) {
					mapIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelIndexColByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByColIdx != null ) {
				IBusModelIndexColByColIdxKey keyColIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByColIdxKey();
				keyColIdx.setRequiredColumnId( keepObj.getRequiredColumnId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapColIdx = indexByColIdx.get( keyColIdx );
				if( mapColIdx != null ) {
					mapColIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelIndexColByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelIndexColByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIdxPrevIdx != null ) {
				IBusModelIndexColByIdxPrevIdxKey keyIdxPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIdxPrevIdxKey();
				keyIdxPrevIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyIdxPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapIdxPrevIdx = indexByIdxPrevIdx.get( keyIdxPrevIdx );
				if( mapIdxPrevIdx != null ) {
					mapIdxPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIdxNextIdx != null ) {
				IBusModelIndexColByIdxNextIdxKey keyIdxNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIdxNextIdxKey();
				keyIdxNextIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyIdxNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapIdxNextIdx = indexByIdxNextIdx.get( keyIdxNextIdx );
				if( mapIdxNextIdx != null ) {
					mapIdxNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allIndexCol != null ) {
				allIndexCol.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allIndexCol != null ) {
				allIndexCol.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				IBusModelIndexColByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByUNameIdxKey();
				keyUNameIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByIndexIdx != null ) {
				IBusModelIndexColByIndexIdxKey keyIndexIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIndexIdxKey();
				keyIndexIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapIndexIdx = indexByIndexIdx.get( keyIndexIdx );
				if( mapIndexIdx != null ) {
					mapIndexIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelIndexColByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByColIdx != null ) {
				IBusModelIndexColByColIdxKey keyColIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByColIdxKey();
				keyColIdx.setRequiredColumnId( keepObj.getRequiredColumnId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapColIdx = indexByColIdx.get( keyColIdx );
				if( mapColIdx != null ) {
					mapColIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelIndexColByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelIndexColByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIdxPrevIdx != null ) {
				IBusModelIndexColByIdxPrevIdxKey keyIdxPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIdxPrevIdxKey();
				keyIdxPrevIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyIdxPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapIdxPrevIdx = indexByIdxPrevIdx.get( keyIdxPrevIdx );
				if( mapIdxPrevIdx != null ) {
					mapIdxPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIdxNextIdx != null ) {
				IBusModelIndexColByIdxNextIdxKey keyIdxNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIdxNextIdxKey();
				keyIdxNextIdx.setRequiredIndexId( keepObj.getRequiredIndexId() );
				keyIdxNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj > mapIdxNextIdx = indexByIdxNextIdx.get( keyIdxNextIdx );
				if( mapIdxNextIdx != null ) {
					mapIdxNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelIndexColObj createIndexCol( IBusModelIndexColObj Obj ) {
		IBusModelIndexColObj obj = Obj;
		IBusModelIndexCol rec = obj.getIndexColRec();
		schema.getBusModelBackingStore().getTableIndexCol().createIndexCol(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		IBusModelIndexColObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelIndexColObj readIndexCol( $implCommaIJavaOptAtomType$ pkey ) {
		return( readIndexCol( pkey, false ) );
	}

	@Override
	public IBusModelIndexColObj readIndexCol( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelIndexColObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelIndexCol readRec = schema.getBusModelBackingStore().getTableIndexCol().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelIndexColObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelIndexColObj readCachedIndexCol( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelIndexColObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeIndexCol( IBusModelIndexColObj obj )
	{
		final String S_ProcName = "BusModelIndexColTableObj.reallyDeepDisposeIndexCol() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelIndexColObj existing = readCachedIndexCol( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelIndexColByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByUNameIdxKey();
		keyUNameIdx.setRequiredIndexId( existing.getRequiredIndexId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		IBusModelIndexColByIndexIdxKey keyIndexIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIndexIdxKey();
		keyIndexIdx.setRequiredIndexId( existing.getRequiredIndexId() );

		IBusModelIndexColByDefSchemaIdxKey keyDefSchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		IBusModelIndexColByColIdxKey keyColIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByColIdxKey();
		keyColIdx.setRequiredColumnId( existing.getRequiredColumnId() );

		IBusModelIndexColByPrevIdxKey keyPrevIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		IBusModelIndexColByNextIdxKey keyNextIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		IBusModelIndexColByIdxPrevIdxKey keyIdxPrevIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIdxPrevIdxKey();
		keyIdxPrevIdx.setRequiredIndexId( existing.getRequiredIndexId() );
		keyIdxPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		IBusModelIndexColByIdxNextIdxKey keyIdxNextIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIdxNextIdxKey();
		keyIdxNextIdx.setRequiredIndexId( existing.getRequiredIndexId() );
		keyIdxNextIdx.setOptionalNextId( existing.getOptionalNextId() );


					schema.getRelationColTableObj().deepDisposeRelationColByFromColIdx( existing.getRequiredId() );
					schema.getRelationColTableObj().deepDisposeRelationColByToColIdx( existing.getRequiredId() );

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}

		if( indexByIndexIdx != null ) {
			if( indexByIndexIdx.containsKey( keyIndexIdx ) ) {
				indexByIndexIdx.get( keyIndexIdx ).remove( pkey );
				if( indexByIndexIdx.get( keyIndexIdx ).size() <= 0 ) {
					indexByIndexIdx.remove( keyIndexIdx );
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

		if( indexByColIdx != null ) {
			if( indexByColIdx.containsKey( keyColIdx ) ) {
				indexByColIdx.get( keyColIdx ).remove( pkey );
				if( indexByColIdx.get( keyColIdx ).size() <= 0 ) {
					indexByColIdx.remove( keyColIdx );
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

		if( indexByIdxPrevIdx != null ) {
			if( indexByIdxPrevIdx.containsKey( keyIdxPrevIdx ) ) {
				indexByIdxPrevIdx.get( keyIdxPrevIdx ).remove( pkey );
				if( indexByIdxPrevIdx.get( keyIdxPrevIdx ).size() <= 0 ) {
					indexByIdxPrevIdx.remove( keyIdxPrevIdx );
				}
			}
		}

		if( indexByIdxNextIdx != null ) {
			if( indexByIdxNextIdx.containsKey( keyIdxNextIdx ) ) {
				indexByIdxNextIdx.get( keyIdxNextIdx ).remove( pkey );
				if( indexByIdxNextIdx.get( keyIdxNextIdx ).size() <= 0 ) {
					indexByIdxNextIdx.remove( keyIdxNextIdx );
				}
			}
		}


	}
	@Override
	public void deepDisposeIndexCol( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelIndexColObj obj = readCachedIndexCol( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelIndexColObj lockIndexCol( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelIndexColObj locked = null;
		IBusModelIndexCol lockRec = schema.getBusModelBackingStore().getTableIndexCol().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getIndexColTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelIndexColObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockIndexCol", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelIndexColObj> readAllIndexCol() {
		return( readAllIndexCol( false ) );
	}

	@Override
	public List<IBusModelIndexColObj> readAllIndexCol( boolean forceRead ) {
		final String S_ProcName = "readAllIndexCol";
		if( ( allIndexCol == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelIndexColObj>();
			allIndexCol = map;
			IBusModelIndexCol[] recList = schema.getBusModelBackingStore().getTableIndexCol().readAllDerived( null );
			IBusModelIndexCol rec;
			IBusModelIndexColObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexColObj realised = (IBusModelIndexColObj)obj.realise();
			}
		}
		int len = allIndexCol.size();
		IBusModelIndexColObj arr[] = new IBusModelIndexColObj[len];
		Iterator<IBusModelIndexColObj> valIter = allIndexCol.values().iterator();
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
		ArrayList<IBusModelIndexColObj> arrayList = new ArrayList<IBusModelIndexColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexColObj> cmp = new Comparator<IBusModelIndexColObj>() {
			@Override
			public int compare( IBusModelIndexColObj lhs, IBusModelIndexColObj rhs ) {
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
		List<IBusModelIndexColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelIndexColObj> readCachedAllIndexCol() {
		final String S_ProcName = "readCachedAllIndexCol";
		ArrayList<IBusModelIndexColObj> arrayList = new ArrayList<IBusModelIndexColObj>();
		if( allIndexCol != null ) {
			int len = allIndexCol.size();
			IBusModelIndexColObj arr[] = new IBusModelIndexColObj[len];
			Iterator<IBusModelIndexColObj> valIter = allIndexCol.values().iterator();
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
		Comparator<IBusModelIndexColObj> cmp = new Comparator<IBusModelIndexColObj>() {
			public int compare( IBusModelIndexColObj lhs, IBusModelIndexColObj rhs ) {
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
	public IBusModelIndexColObj readIndexColByIdIdx( IYCFKeyHash256 Id )
	{
		return( readIndexColByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelIndexColObj readIndexColByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelIndexColObj obj = readIndexCol( Id, forceRead );
		return( obj );
	}

	@Override
	public IBusModelIndexColObj readIndexColByUNameIdx( IYCFKeyHash256 IndexId,
		String Name )
	{
		return( readIndexColByUNameIdx( IndexId,
			Name,
			false ) );
	}

	@Override
	public IBusModelIndexColObj readIndexColByUNameIdx( IYCFKeyHash256 IndexId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelIndexColByUNameIdxKey,
				IBusModelIndexColObj >();
		}
		IBusModelIndexColByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByUNameIdxKey();
		key.setRequiredIndexId( IndexId );
		key.setRequiredName( Name );
		IBusModelIndexColObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelIndexCol rec = schema.getBusModelBackingStore().getTableIndexCol().readDerivedByUNameIdx( null,
				IndexId,
				Name );
			if( rec != null ) {
				obj = schema.getIndexColTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelIndexColObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelIndexColObj> readIndexColByIndexIdx( IYCFKeyHash256 IndexId )
	{
		return( readIndexColByIndexIdx( IndexId,
			false ) );
	}

	@Override
	public List<IBusModelIndexColObj> readIndexColByIndexIdx( IYCFKeyHash256 IndexId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexColByIndexIdx";
		IBusModelIndexColByIndexIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIndexIdxKey();
		key.setRequiredIndexId( IndexId );
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict;
		if( indexByIndexIdx == null ) {
			indexByIndexIdx = new HashMap< IBusModelIndexColByIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexColObj > >();
		}
		if( ( ! forceRead ) && indexByIndexIdx.containsKey( key ) ) {
			dict = indexByIndexIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexColObj>();
			IBusModelIndexColObj obj;
			IBusModelIndexCol[] recList = schema.getBusModelBackingStore().getTableIndexCol().readDerivedByIndexIdx( null,
				IndexId );
			IBusModelIndexCol rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexColObj realised = (IBusModelIndexColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByIndexIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelIndexColObj arr[] = new IBusModelIndexColObj[len];
		Iterator<IBusModelIndexColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelIndexColObj> arrayList = new ArrayList<IBusModelIndexColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexColObj> cmp = new Comparator<IBusModelIndexColObj>() {
			@Override
			public int compare( IBusModelIndexColObj lhs, IBusModelIndexColObj rhs ) {
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
		List<IBusModelIndexColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelIndexColObj> readIndexColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readIndexColByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelIndexColObj> readIndexColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexColByDefSchemaIdx";
		IBusModelIndexColByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelIndexColByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexColObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexColObj>();
			IBusModelIndexColObj obj;
			IBusModelIndexCol[] recList = schema.getBusModelBackingStore().getTableIndexCol().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelIndexCol rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexColObj realised = (IBusModelIndexColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelIndexColObj arr[] = new IBusModelIndexColObj[len];
		Iterator<IBusModelIndexColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelIndexColObj> arrayList = new ArrayList<IBusModelIndexColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexColObj> cmp = new Comparator<IBusModelIndexColObj>() {
			@Override
			public int compare( IBusModelIndexColObj lhs, IBusModelIndexColObj rhs ) {
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
		List<IBusModelIndexColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelIndexColObj> readIndexColByColIdx( IYCFKeyHash256 ColumnId )
	{
		return( readIndexColByColIdx( ColumnId,
			false ) );
	}

	@Override
	public List<IBusModelIndexColObj> readIndexColByColIdx( IYCFKeyHash256 ColumnId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexColByColIdx";
		IBusModelIndexColByColIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByColIdxKey();
		key.setRequiredColumnId( ColumnId );
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict;
		if( indexByColIdx == null ) {
			indexByColIdx = new HashMap< IBusModelIndexColByColIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexColObj > >();
		}
		if( ( ! forceRead ) && indexByColIdx.containsKey( key ) ) {
			dict = indexByColIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexColObj>();
			IBusModelIndexColObj obj;
			IBusModelIndexCol[] recList = schema.getBusModelBackingStore().getTableIndexCol().readDerivedByColIdx( null,
				ColumnId );
			IBusModelIndexCol rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexColObj realised = (IBusModelIndexColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByColIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelIndexColObj arr[] = new IBusModelIndexColObj[len];
		Iterator<IBusModelIndexColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelIndexColObj> arrayList = new ArrayList<IBusModelIndexColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexColObj> cmp = new Comparator<IBusModelIndexColObj>() {
			@Override
			public int compare( IBusModelIndexColObj lhs, IBusModelIndexColObj rhs ) {
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
		List<IBusModelIndexColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelIndexColObj> readIndexColByPrevIdx( IYCFKeyHash256 PrevId )
	{
		return( readIndexColByPrevIdx( PrevId,
			false ) );
	}

	@Override
	public List<IBusModelIndexColObj> readIndexColByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexColByPrevIdx";
		IBusModelIndexColByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelIndexColByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexColObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexColObj>();
			IBusModelIndexColObj obj;
			IBusModelIndexCol[] recList = schema.getBusModelBackingStore().getTableIndexCol().readDerivedByPrevIdx( null,
				PrevId );
			IBusModelIndexCol rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexColObj realised = (IBusModelIndexColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelIndexColObj arr[] = new IBusModelIndexColObj[len];
		Iterator<IBusModelIndexColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelIndexColObj> arrayList = new ArrayList<IBusModelIndexColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexColObj> cmp = new Comparator<IBusModelIndexColObj>() {
			@Override
			public int compare( IBusModelIndexColObj lhs, IBusModelIndexColObj rhs ) {
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
		List<IBusModelIndexColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelIndexColObj> readIndexColByNextIdx( IYCFKeyHash256 NextId )
	{
		return( readIndexColByNextIdx( NextId,
			false ) );
	}

	@Override
	public List<IBusModelIndexColObj> readIndexColByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexColByNextIdx";
		IBusModelIndexColByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelIndexColByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexColObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexColObj>();
			IBusModelIndexColObj obj;
			IBusModelIndexCol[] recList = schema.getBusModelBackingStore().getTableIndexCol().readDerivedByNextIdx( null,
				NextId );
			IBusModelIndexCol rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexColObj realised = (IBusModelIndexColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelIndexColObj arr[] = new IBusModelIndexColObj[len];
		Iterator<IBusModelIndexColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelIndexColObj> arrayList = new ArrayList<IBusModelIndexColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexColObj> cmp = new Comparator<IBusModelIndexColObj>() {
			@Override
			public int compare( IBusModelIndexColObj lhs, IBusModelIndexColObj rhs ) {
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
		List<IBusModelIndexColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelIndexColObj> readIndexColByIdxPrevIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 PrevId )
	{
		return( readIndexColByIdxPrevIdx( IndexId,
			PrevId,
			false ) );
	}

	@Override
	public List<IBusModelIndexColObj> readIndexColByIdxPrevIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexColByIdxPrevIdx";
		IBusModelIndexColByIdxPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIdxPrevIdxKey();
		key.setRequiredIndexId( IndexId );
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict;
		if( indexByIdxPrevIdx == null ) {
			indexByIdxPrevIdx = new HashMap< IBusModelIndexColByIdxPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexColObj > >();
		}
		if( ( ! forceRead ) && indexByIdxPrevIdx.containsKey( key ) ) {
			dict = indexByIdxPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexColObj>();
			IBusModelIndexColObj obj;
			IBusModelIndexCol[] recList = schema.getBusModelBackingStore().getTableIndexCol().readDerivedByIdxPrevIdx( null,
				IndexId,
				PrevId );
			IBusModelIndexCol rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexColObj realised = (IBusModelIndexColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByIdxPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelIndexColObj arr[] = new IBusModelIndexColObj[len];
		Iterator<IBusModelIndexColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelIndexColObj> arrayList = new ArrayList<IBusModelIndexColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexColObj> cmp = new Comparator<IBusModelIndexColObj>() {
			@Override
			public int compare( IBusModelIndexColObj lhs, IBusModelIndexColObj rhs ) {
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
		List<IBusModelIndexColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelIndexColObj> readIndexColByIdxNextIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 NextId )
	{
		return( readIndexColByIdxNextIdx( IndexId,
			NextId,
			false ) );
	}

	@Override
	public List<IBusModelIndexColObj> readIndexColByIdxNextIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexColByIdxNextIdx";
		IBusModelIndexColByIdxNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIdxNextIdxKey();
		key.setRequiredIndexId( IndexId );
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict;
		if( indexByIdxNextIdx == null ) {
			indexByIdxNextIdx = new HashMap< IBusModelIndexColByIdxNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexColObj > >();
		}
		if( ( ! forceRead ) && indexByIdxNextIdx.containsKey( key ) ) {
			dict = indexByIdxNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexColObj>();
			IBusModelIndexColObj obj;
			IBusModelIndexCol[] recList = schema.getBusModelBackingStore().getTableIndexCol().readDerivedByIdxNextIdx( null,
				IndexId,
				NextId );
			IBusModelIndexCol rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getIndexColTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexColObj realised = (IBusModelIndexColObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByIdxNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelIndexColObj arr[] = new IBusModelIndexColObj[len];
		Iterator<IBusModelIndexColObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelIndexColObj> arrayList = new ArrayList<IBusModelIndexColObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexColObj> cmp = new Comparator<IBusModelIndexColObj>() {
			@Override
			public int compare( IBusModelIndexColObj lhs, IBusModelIndexColObj rhs ) {
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
		List<IBusModelIndexColObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelIndexColObj readCachedIndexColByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelIndexColObj obj = null;
		obj = readCachedIndexCol( Id );
		return( obj );
	}

	@Override
	public IBusModelIndexColObj readCachedIndexColByUNameIdx( IYCFKeyHash256 IndexId,
		String Name )
	{
		IBusModelIndexColObj obj = null;
		IBusModelIndexColByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByUNameIdxKey();
		key.setRequiredIndexId( IndexId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelIndexColObj> valIter = members.values().iterator();
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
			Iterator<IBusModelIndexColObj> valIter = members.values().iterator();
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
	public List<IBusModelIndexColObj> readCachedIndexColByIndexIdx( IYCFKeyHash256 IndexId )
	{
		final String S_ProcName = "readCachedIndexColByIndexIdx";
		IBusModelIndexColByIndexIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIndexIdxKey();
		key.setRequiredIndexId( IndexId );
		ArrayList<IBusModelIndexColObj> arrayList = new ArrayList<IBusModelIndexColObj>();
		if( indexByIndexIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict;
			if( indexByIndexIdx.containsKey( key ) ) {
				dict = indexByIndexIdx.get( key );
				int len = dict.size();
				IBusModelIndexColObj arr[] = new IBusModelIndexColObj[len];
				Iterator<IBusModelIndexColObj> valIter = dict.values().iterator();
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
			IBusModelIndexColObj obj;
			Iterator<IBusModelIndexColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelIndexColObj> cmp = new Comparator<IBusModelIndexColObj>() {
			@Override
			public int compare( IBusModelIndexColObj lhs, IBusModelIndexColObj rhs ) {
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
	public List<IBusModelIndexColObj> readCachedIndexColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedIndexColByDefSchemaIdx";
		IBusModelIndexColByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelIndexColObj> arrayList = new ArrayList<IBusModelIndexColObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelIndexColObj arr[] = new IBusModelIndexColObj[len];
				Iterator<IBusModelIndexColObj> valIter = dict.values().iterator();
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
			IBusModelIndexColObj obj;
			Iterator<IBusModelIndexColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelIndexColObj> cmp = new Comparator<IBusModelIndexColObj>() {
			@Override
			public int compare( IBusModelIndexColObj lhs, IBusModelIndexColObj rhs ) {
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
	public List<IBusModelIndexColObj> readCachedIndexColByColIdx( IYCFKeyHash256 ColumnId )
	{
		final String S_ProcName = "readCachedIndexColByColIdx";
		IBusModelIndexColByColIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByColIdxKey();
		key.setRequiredColumnId( ColumnId );
		ArrayList<IBusModelIndexColObj> arrayList = new ArrayList<IBusModelIndexColObj>();
		if( indexByColIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict;
			if( indexByColIdx.containsKey( key ) ) {
				dict = indexByColIdx.get( key );
				int len = dict.size();
				IBusModelIndexColObj arr[] = new IBusModelIndexColObj[len];
				Iterator<IBusModelIndexColObj> valIter = dict.values().iterator();
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
			IBusModelIndexColObj obj;
			Iterator<IBusModelIndexColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelIndexColObj> cmp = new Comparator<IBusModelIndexColObj>() {
			@Override
			public int compare( IBusModelIndexColObj lhs, IBusModelIndexColObj rhs ) {
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
	public List<IBusModelIndexColObj> readCachedIndexColByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedIndexColByPrevIdx";
		IBusModelIndexColByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelIndexColObj> arrayList = new ArrayList<IBusModelIndexColObj>();
		if( indexByPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict;
			if( indexByPrevIdx.containsKey( key ) ) {
				dict = indexByPrevIdx.get( key );
				int len = dict.size();
				IBusModelIndexColObj arr[] = new IBusModelIndexColObj[len];
				Iterator<IBusModelIndexColObj> valIter = dict.values().iterator();
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
			IBusModelIndexColObj obj;
			Iterator<IBusModelIndexColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelIndexColObj> cmp = new Comparator<IBusModelIndexColObj>() {
			@Override
			public int compare( IBusModelIndexColObj lhs, IBusModelIndexColObj rhs ) {
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
	public List<IBusModelIndexColObj> readCachedIndexColByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedIndexColByNextIdx";
		IBusModelIndexColByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelIndexColObj> arrayList = new ArrayList<IBusModelIndexColObj>();
		if( indexByNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict;
			if( indexByNextIdx.containsKey( key ) ) {
				dict = indexByNextIdx.get( key );
				int len = dict.size();
				IBusModelIndexColObj arr[] = new IBusModelIndexColObj[len];
				Iterator<IBusModelIndexColObj> valIter = dict.values().iterator();
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
			IBusModelIndexColObj obj;
			Iterator<IBusModelIndexColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelIndexColObj> cmp = new Comparator<IBusModelIndexColObj>() {
			@Override
			public int compare( IBusModelIndexColObj lhs, IBusModelIndexColObj rhs ) {
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
	public List<IBusModelIndexColObj> readCachedIndexColByIdxPrevIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedIndexColByIdxPrevIdx";
		IBusModelIndexColByIdxPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIdxPrevIdxKey();
		key.setRequiredIndexId( IndexId );
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelIndexColObj> arrayList = new ArrayList<IBusModelIndexColObj>();
		if( indexByIdxPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict;
			if( indexByIdxPrevIdx.containsKey( key ) ) {
				dict = indexByIdxPrevIdx.get( key );
				int len = dict.size();
				IBusModelIndexColObj arr[] = new IBusModelIndexColObj[len];
				Iterator<IBusModelIndexColObj> valIter = dict.values().iterator();
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
			IBusModelIndexColObj obj;
			Iterator<IBusModelIndexColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelIndexColObj> cmp = new Comparator<IBusModelIndexColObj>() {
			@Override
			public int compare( IBusModelIndexColObj lhs, IBusModelIndexColObj rhs ) {
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
	public List<IBusModelIndexColObj> readCachedIndexColByIdxNextIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedIndexColByIdxNextIdx";
		IBusModelIndexColByIdxNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIdxNextIdxKey();
		key.setRequiredIndexId( IndexId );
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelIndexColObj> arrayList = new ArrayList<IBusModelIndexColObj>();
		if( indexByIdxNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict;
			if( indexByIdxNextIdx.containsKey( key ) ) {
				dict = indexByIdxNextIdx.get( key );
				int len = dict.size();
				IBusModelIndexColObj arr[] = new IBusModelIndexColObj[len];
				Iterator<IBusModelIndexColObj> valIter = dict.values().iterator();
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
			IBusModelIndexColObj obj;
			Iterator<IBusModelIndexColObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelIndexColObj> cmp = new Comparator<IBusModelIndexColObj>() {
			@Override
			public int compare( IBusModelIndexColObj lhs, IBusModelIndexColObj rhs ) {
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
	public void deepDisposeIndexColByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelIndexColObj obj = readCachedIndexColByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeIndexColByUNameIdx( IYCFKeyHash256 IndexId,
		String Name )
	{
		IBusModelIndexColObj obj = readCachedIndexColByUNameIdx( IndexId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeIndexColByIndexIdx( IYCFKeyHash256 IndexId )
	{
		final String S_ProcName = "deepDisposeIndexColByIndexIdx";
		IBusModelIndexColObj obj;
		List<IBusModelIndexColObj> arrayList = readCachedIndexColByIndexIdx( IndexId );
		if( arrayList != null )  {
			Iterator<IBusModelIndexColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeIndexColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeIndexColByDefSchemaIdx";
		IBusModelIndexColObj obj;
		List<IBusModelIndexColObj> arrayList = readCachedIndexColByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelIndexColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeIndexColByColIdx( IYCFKeyHash256 ColumnId )
	{
		final String S_ProcName = "deepDisposeIndexColByColIdx";
		IBusModelIndexColObj obj;
		List<IBusModelIndexColObj> arrayList = readCachedIndexColByColIdx( ColumnId );
		if( arrayList != null )  {
			Iterator<IBusModelIndexColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeIndexColByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeIndexColByPrevIdx";
		IBusModelIndexColObj obj;
		List<IBusModelIndexColObj> arrayList = readCachedIndexColByPrevIdx( PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelIndexColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeIndexColByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeIndexColByNextIdx";
		IBusModelIndexColObj obj;
		List<IBusModelIndexColObj> arrayList = readCachedIndexColByNextIdx( NextId );
		if( arrayList != null )  {
			Iterator<IBusModelIndexColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeIndexColByIdxPrevIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeIndexColByIdxPrevIdx";
		IBusModelIndexColObj obj;
		List<IBusModelIndexColObj> arrayList = readCachedIndexColByIdxPrevIdx( IndexId,
				PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelIndexColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeIndexColByIdxNextIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeIndexColByIdxNextIdx";
		IBusModelIndexColObj obj;
		List<IBusModelIndexColObj> arrayList = readCachedIndexColByIdxNextIdx( IndexId,
				NextId );
		if( arrayList != null )  {
			Iterator<IBusModelIndexColObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelIndexColObj updateIndexCol( IBusModelIndexColObj Obj ) {
		IBusModelIndexColObj obj = Obj;
		schema.getBusModelBackingStore().getTableIndexCol().updateIndexCol( null,
			Obj.getIndexColRec() );
		obj = (IBusModelIndexColObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteIndexCol( IBusModelIndexColObj Obj ) {
		IBusModelIndexColObj obj = Obj;
		IBusModelIndexColObj prev = obj.getOptionalLookupPrev();
		IBusModelIndexColObj next = obj.getOptionalLookupNext();
		schema.getBusModelBackingStore().getTableIndexCol().deleteIndexCol( null,
			obj.getIndexColRec() );
		Obj.forget();
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	@Override
	public void deleteIndexColByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelIndexColObj obj = readIndexCol(Id);
		if( obj != null ) {
			IBusModelIndexColEditObj editObj = (IBusModelIndexColEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelIndexColEditObj)obj.beginEdit();
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
		deepDisposeIndexColByIdIdx( Id );
	}

	@Override
	public void deleteIndexColByUNameIdx( IYCFKeyHash256 IndexId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelIndexColByUNameIdxKey,
				IBusModelIndexColObj >();
		}
		IBusModelIndexColByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByUNameIdxKey();
		key.setRequiredIndexId( IndexId );
		key.setRequiredName( Name );
		IBusModelIndexColObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableIndexCol().deleteIndexColByUNameIdx( null,
				IndexId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableIndexCol().deleteIndexColByUNameIdx( null,
				IndexId,
				Name );
		}
		deepDisposeIndexColByUNameIdx( IndexId,
				Name );
	}

	@Override
	public void deleteIndexColByIndexIdx( IYCFKeyHash256 IndexId )
	{
		IBusModelIndexColByIndexIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIndexIdxKey();
		key.setRequiredIndexId( IndexId );
		if( indexByIndexIdx == null ) {
			indexByIndexIdx = new HashMap< IBusModelIndexColByIndexIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexColObj > >();
		}
		if( indexByIndexIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict = indexByIndexIdx.get( key );
			schema.getBusModelBackingStore().getTableIndexCol().deleteIndexColByIndexIdx( null,
				IndexId );
			Iterator<IBusModelIndexColObj> iter = dict.values().iterator();
			IBusModelIndexColObj obj;
			List<IBusModelIndexColObj> toForget = new LinkedList<IBusModelIndexColObj>();
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
			schema.getBusModelBackingStore().getTableIndexCol().deleteIndexColByIndexIdx( null,
				IndexId );
		}
		deepDisposeIndexColByIndexIdx( IndexId );
	}

	@Override
	public void deleteIndexColByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelIndexColByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelIndexColByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexColObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableIndexCol().deleteIndexColByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelIndexColObj> iter = dict.values().iterator();
			IBusModelIndexColObj obj;
			List<IBusModelIndexColObj> toForget = new LinkedList<IBusModelIndexColObj>();
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
			schema.getBusModelBackingStore().getTableIndexCol().deleteIndexColByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeIndexColByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteIndexColByColIdx( IYCFKeyHash256 ColumnId )
	{
		IBusModelIndexColByColIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByColIdxKey();
		key.setRequiredColumnId( ColumnId );
		if( indexByColIdx == null ) {
			indexByColIdx = new HashMap< IBusModelIndexColByColIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexColObj > >();
		}
		if( indexByColIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict = indexByColIdx.get( key );
			schema.getBusModelBackingStore().getTableIndexCol().deleteIndexColByColIdx( null,
				ColumnId );
			Iterator<IBusModelIndexColObj> iter = dict.values().iterator();
			IBusModelIndexColObj obj;
			List<IBusModelIndexColObj> toForget = new LinkedList<IBusModelIndexColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByColIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableIndexCol().deleteIndexColByColIdx( null,
				ColumnId );
		}
		deepDisposeIndexColByColIdx( ColumnId );
	}

	@Override
	public void deleteIndexColByPrevIdx( IYCFKeyHash256 PrevId )
	{
		IBusModelIndexColByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelIndexColByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexColObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict = indexByPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableIndexCol().deleteIndexColByPrevIdx( null,
				PrevId );
			Iterator<IBusModelIndexColObj> iter = dict.values().iterator();
			IBusModelIndexColObj obj;
			List<IBusModelIndexColObj> toForget = new LinkedList<IBusModelIndexColObj>();
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
			schema.getBusModelBackingStore().getTableIndexCol().deleteIndexColByPrevIdx( null,
				PrevId );
		}
		deepDisposeIndexColByPrevIdx( PrevId );
	}

	@Override
	public void deleteIndexColByNextIdx( IYCFKeyHash256 NextId )
	{
		IBusModelIndexColByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelIndexColByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexColObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict = indexByNextIdx.get( key );
			schema.getBusModelBackingStore().getTableIndexCol().deleteIndexColByNextIdx( null,
				NextId );
			Iterator<IBusModelIndexColObj> iter = dict.values().iterator();
			IBusModelIndexColObj obj;
			List<IBusModelIndexColObj> toForget = new LinkedList<IBusModelIndexColObj>();
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
			schema.getBusModelBackingStore().getTableIndexCol().deleteIndexColByNextIdx( null,
				NextId );
		}
		deepDisposeIndexColByNextIdx( NextId );
	}

	@Override
	public void deleteIndexColByIdxPrevIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 PrevId )
	{
		IBusModelIndexColByIdxPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIdxPrevIdxKey();
		key.setRequiredIndexId( IndexId );
		key.setOptionalPrevId( PrevId );
		if( indexByIdxPrevIdx == null ) {
			indexByIdxPrevIdx = new HashMap< IBusModelIndexColByIdxPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexColObj > >();
		}
		if( indexByIdxPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict = indexByIdxPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableIndexCol().deleteIndexColByIdxPrevIdx( null,
				IndexId,
				PrevId );
			Iterator<IBusModelIndexColObj> iter = dict.values().iterator();
			IBusModelIndexColObj obj;
			List<IBusModelIndexColObj> toForget = new LinkedList<IBusModelIndexColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByIdxPrevIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableIndexCol().deleteIndexColByIdxPrevIdx( null,
				IndexId,
				PrevId );
		}
		deepDisposeIndexColByIdxPrevIdx( IndexId,
				PrevId );
	}

	@Override
	public void deleteIndexColByIdxNextIdx( IYCFKeyHash256 IndexId,
		IYCFKeyHash256 NextId )
	{
		IBusModelIndexColByIdxNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newByIdxNextIdxKey();
		key.setRequiredIndexId( IndexId );
		key.setOptionalNextId( NextId );
		if( indexByIdxNextIdx == null ) {
			indexByIdxNextIdx = new HashMap< IBusModelIndexColByIdxNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexColObj > >();
		}
		if( indexByIdxNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexColObj> dict = indexByIdxNextIdx.get( key );
			schema.getBusModelBackingStore().getTableIndexCol().deleteIndexColByIdxNextIdx( null,
				IndexId,
				NextId );
			Iterator<IBusModelIndexColObj> iter = dict.values().iterator();
			IBusModelIndexColObj obj;
			List<IBusModelIndexColObj> toForget = new LinkedList<IBusModelIndexColObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByIdxNextIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableIndexCol().deleteIndexColByIdxNextIdx( null,
				IndexId,
				NextId );
		}
		deepDisposeIndexColByIdxNextIdx( IndexId,
				NextId );
	}

	/**
	 *	Move the BusModelIndexColObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelIndexColObj refreshed cache instance.
	 */
	@Override
	public IBusModelIndexColObj moveUpIndexCol( IBusModelIndexColObj Obj ) {
		IBusModelIndexColObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUpIndexCol" );
		}
		IBusModelIndexCol rec = schema.getBusModelBackingStore().getTableIndexCol().moveRecUp( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getIndexColTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelIndexColObj)obj.realise();
			IBusModelIndexColObj prev = obj.getOptionalLookupPrev( true );
			IBusModelIndexColObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				IBusModelIndexColObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the BusModelIndexColObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelIndexColObj refreshed cache instance.
	 */
	@Override
	public IBusModelIndexColObj moveDownIndexCol( IBusModelIndexColObj Obj ) {
		IBusModelIndexColObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDownIndexCol" );
		}
		IBusModelIndexCol rec = schema.getBusModelBackingStore().getTableIndexCol().moveRecDown( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getIndexColTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelIndexColObj)obj.realise();
			IBusModelIndexColObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				IBusModelIndexColObj gprev = prev.getOptionalLookupPrev( true );
			}
			IBusModelIndexColObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}