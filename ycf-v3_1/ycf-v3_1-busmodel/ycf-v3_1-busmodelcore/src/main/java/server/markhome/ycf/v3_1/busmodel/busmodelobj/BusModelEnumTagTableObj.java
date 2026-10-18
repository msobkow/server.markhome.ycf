// Description: Java 25 Table Object implementation for EnumTag.

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

public class BusModelEnumTagTableObj
	implements IBusModelEnumTagTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelEnumTag.CLASS_CODE;
	protected static final int backingClassCode = IBusModelEnumTag.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj> allEnumTag;
	private Map< IBusModelEnumTagByEnumIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj > > indexByEnumIdx;
	private Map< IBusModelEnumTagByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj > > indexByDefSchemaIdx;
	private Map< IBusModelEnumTagByEnumNameIdxKey,
		IBusModelEnumTagObj > indexByEnumNameIdx;
	private Map< IBusModelEnumTagByPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj > > indexByPrevIdx;
	private Map< IBusModelEnumTagByNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj > > indexByNextIdx;
	public static String TABLE_NAME = "EnumTag";
	public static String TABLE_DBNAME = "enum_tag";

	public BusModelEnumTagTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj>();
		allEnumTag = null;
		indexByEnumIdx = null;
		indexByDefSchemaIdx = null;
		indexByEnumNameIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
	}

	public BusModelEnumTagTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj>();
		allEnumTag = null;
		indexByEnumIdx = null;
		indexByDefSchemaIdx = null;
		indexByEnumNameIdx = null;
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
		return BusModelEnumTagTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelEnumTagTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allEnumTag = null;
		indexByEnumIdx = null;
		indexByDefSchemaIdx = null;
		indexByEnumNameIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		List<IBusModelEnumTagObj> toForget = new LinkedList<IBusModelEnumTagObj>();
		IBusModelEnumTagObj cur = null;
		Iterator<IBusModelEnumTagObj> iter = members.values().iterator();
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
	 *	BusModelEnumTagObj.
	 */
	@Override
	public IBusModelEnumTagObj newInstance() {
		IBusModelEnumTagObj inst = new BusModelEnumTagObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelEnumTagObj.
	 */
	@Override
	public IBusModelEnumTagEditObj newEditInstance( IBusModelEnumTagObj orig ) {
		IBusModelEnumTagEditObj edit = new BusModelEnumTagEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelEnumTagObj constructByClassCode( int backingClassCode ) {
		IBusModelEnumTagObj obj = null;
		if( backingClassCode == IBusModelEnumTag.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getEnumTagTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public IBusModelEnumTagObj realiseEnumTag( IBusModelEnumTagObj Obj ) {
		IBusModelEnumTagObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelEnumTagObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelEnumTagObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByEnumIdx != null ) {
				IBusModelEnumTagByEnumIdxKey keyEnumIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByEnumIdxKey();
				keyEnumIdx.setRequiredEnumId( keepObj.getRequiredEnumId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj > mapEnumIdx = indexByEnumIdx.get( keyEnumIdx );
				if( mapEnumIdx != null ) {
					mapEnumIdx.remove( keepObj.getPKey() );
					if( mapEnumIdx.size() <= 0 ) {
						indexByEnumIdx.remove( keyEnumIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelEnumTagByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByEnumNameIdx != null ) {
				IBusModelEnumTagByEnumNameIdxKey keyEnumNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByEnumNameIdxKey();
				keyEnumNameIdx.setRequiredEnumId( keepObj.getRequiredEnumId() );
				keyEnumNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByEnumNameIdx.remove( keyEnumNameIdx );
			}

			if( indexByPrevIdx != null ) {
				IBusModelEnumTagByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelEnumTagByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
					if( mapNextIdx.size() <= 0 ) {
						indexByNextIdx.remove( keyNextIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByEnumIdx != null ) {
				IBusModelEnumTagByEnumIdxKey keyEnumIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByEnumIdxKey();
				keyEnumIdx.setRequiredEnumId( keepObj.getRequiredEnumId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj > mapEnumIdx = indexByEnumIdx.get( keyEnumIdx );
				if( mapEnumIdx != null ) {
					mapEnumIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelEnumTagByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEnumNameIdx != null ) {
				IBusModelEnumTagByEnumNameIdxKey keyEnumNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByEnumNameIdxKey();
				keyEnumNameIdx.setRequiredEnumId( keepObj.getRequiredEnumId() );
				keyEnumNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByEnumNameIdx.put( keyEnumNameIdx, keepObj );
			}

			if( indexByPrevIdx != null ) {
				IBusModelEnumTagByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelEnumTagByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allEnumTag != null ) {
				allEnumTag.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allEnumTag != null ) {
				allEnumTag.put( keepObj.getPKey(), keepObj );
			}

			if( indexByEnumIdx != null ) {
				IBusModelEnumTagByEnumIdxKey keyEnumIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByEnumIdxKey();
				keyEnumIdx.setRequiredEnumId( keepObj.getRequiredEnumId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj > mapEnumIdx = indexByEnumIdx.get( keyEnumIdx );
				if( mapEnumIdx != null ) {
					mapEnumIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelEnumTagByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByEnumNameIdx != null ) {
				IBusModelEnumTagByEnumNameIdxKey keyEnumNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByEnumNameIdxKey();
				keyEnumNameIdx.setRequiredEnumId( keepObj.getRequiredEnumId() );
				keyEnumNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByEnumNameIdx.put( keyEnumNameIdx, keepObj );
			}

			if( indexByPrevIdx != null ) {
				IBusModelEnumTagByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelEnumTagByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelEnumTagObj createEnumTag( IBusModelEnumTagObj Obj ) {
		IBusModelEnumTagObj obj = Obj;
		IBusModelEnumTag rec = obj.getEnumTagRec();
		schema.getBusModelBackingStore().getTableEnumTag().createEnumTag(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		IBusModelEnumTagObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelEnumTagObj readEnumTag( $implCommaIJavaOptAtomType$ pkey ) {
		return( readEnumTag( pkey, false ) );
	}

	@Override
	public IBusModelEnumTagObj readEnumTag( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelEnumTagObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelEnumTag readRec = schema.getBusModelBackingStore().getTableEnumTag().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getEnumTagTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelEnumTagObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelEnumTagObj readCachedEnumTag( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelEnumTagObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeEnumTag( IBusModelEnumTagObj obj )
	{
		final String S_ProcName = "BusModelEnumTagTableObj.reallyDeepDisposeEnumTag() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelEnumTagObj existing = readCachedEnumTag( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelEnumTagByEnumIdxKey keyEnumIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByEnumIdxKey();
		keyEnumIdx.setRequiredEnumId( existing.getRequiredEnumId() );

		IBusModelEnumTagByDefSchemaIdxKey keyDefSchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		IBusModelEnumTagByEnumNameIdxKey keyEnumNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByEnumNameIdxKey();
		keyEnumNameIdx.setRequiredEnumId( existing.getRequiredEnumId() );
		keyEnumNameIdx.setRequiredName( existing.getRequiredName() );

		IBusModelEnumTagByPrevIdxKey keyPrevIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		IBusModelEnumTagByNextIdxKey keyNextIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );



		if( indexByEnumIdx != null ) {
			if( indexByEnumIdx.containsKey( keyEnumIdx ) ) {
				indexByEnumIdx.get( keyEnumIdx ).remove( pkey );
				if( indexByEnumIdx.get( keyEnumIdx ).size() <= 0 ) {
					indexByEnumIdx.remove( keyEnumIdx );
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

		if( indexByEnumNameIdx != null ) {
			indexByEnumNameIdx.remove( keyEnumNameIdx );
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


	}
	@Override
	public void deepDisposeEnumTag( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelEnumTagObj obj = readCachedEnumTag( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelEnumTagObj lockEnumTag( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelEnumTagObj locked = null;
		IBusModelEnumTag lockRec = schema.getBusModelBackingStore().getTableEnumTag().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getEnumTagTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelEnumTagObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockEnumTag", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelEnumTagObj> readAllEnumTag() {
		return( readAllEnumTag( false ) );
	}

	@Override
	public List<IBusModelEnumTagObj> readAllEnumTag( boolean forceRead ) {
		final String S_ProcName = "readAllEnumTag";
		if( ( allEnumTag == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelEnumTagObj>();
			allEnumTag = map;
			IBusModelEnumTag[] recList = schema.getBusModelBackingStore().getTableEnumTag().readAllDerived( null );
			IBusModelEnumTag rec;
			IBusModelEnumTagObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelEnumTagObj realised = (IBusModelEnumTagObj)obj.realise();
			}
		}
		int len = allEnumTag.size();
		IBusModelEnumTagObj arr[] = new IBusModelEnumTagObj[len];
		Iterator<IBusModelEnumTagObj> valIter = allEnumTag.values().iterator();
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
		ArrayList<IBusModelEnumTagObj> arrayList = new ArrayList<IBusModelEnumTagObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelEnumTagObj> cmp = new Comparator<IBusModelEnumTagObj>() {
			@Override
			public int compare( IBusModelEnumTagObj lhs, IBusModelEnumTagObj rhs ) {
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
		List<IBusModelEnumTagObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelEnumTagObj> readCachedAllEnumTag() {
		final String S_ProcName = "readCachedAllEnumTag";
		ArrayList<IBusModelEnumTagObj> arrayList = new ArrayList<IBusModelEnumTagObj>();
		if( allEnumTag != null ) {
			int len = allEnumTag.size();
			IBusModelEnumTagObj arr[] = new IBusModelEnumTagObj[len];
			Iterator<IBusModelEnumTagObj> valIter = allEnumTag.values().iterator();
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
		Comparator<IBusModelEnumTagObj> cmp = new Comparator<IBusModelEnumTagObj>() {
			public int compare( IBusModelEnumTagObj lhs, IBusModelEnumTagObj rhs ) {
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
	public IBusModelEnumTagObj readEnumTagByIdIdx( IYCFKeyHash256 Id )
	{
		return( readEnumTagByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelEnumTagObj readEnumTagByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelEnumTagObj obj = readEnumTag( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelEnumTagObj> readEnumTagByEnumIdx( IYCFKeyHash256 EnumId )
	{
		return( readEnumTagByEnumIdx( EnumId,
			false ) );
	}

	@Override
	public List<IBusModelEnumTagObj> readEnumTagByEnumIdx( IYCFKeyHash256 EnumId,
		boolean forceRead )
	{
		final String S_ProcName = "readEnumTagByEnumIdx";
		IBusModelEnumTagByEnumIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByEnumIdxKey();
		key.setRequiredEnumId( EnumId );
		Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj> dict;
		if( indexByEnumIdx == null ) {
			indexByEnumIdx = new HashMap< IBusModelEnumTagByEnumIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelEnumTagObj > >();
		}
		if( ( ! forceRead ) && indexByEnumIdx.containsKey( key ) ) {
			dict = indexByEnumIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj>();
			IBusModelEnumTagObj obj;
			IBusModelEnumTag[] recList = schema.getBusModelBackingStore().getTableEnumTag().readDerivedByEnumIdx( null,
				EnumId );
			IBusModelEnumTag rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getEnumTagTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelEnumTagObj realised = (IBusModelEnumTagObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByEnumIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelEnumTagObj arr[] = new IBusModelEnumTagObj[len];
		Iterator<IBusModelEnumTagObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelEnumTagObj> arrayList = new ArrayList<IBusModelEnumTagObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelEnumTagObj> cmp = new Comparator<IBusModelEnumTagObj>() {
			@Override
			public int compare( IBusModelEnumTagObj lhs, IBusModelEnumTagObj rhs ) {
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
		List<IBusModelEnumTagObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelEnumTagObj> readEnumTagByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readEnumTagByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelEnumTagObj> readEnumTagByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readEnumTagByDefSchemaIdx";
		IBusModelEnumTagByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelEnumTagByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelEnumTagObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj>();
			IBusModelEnumTagObj obj;
			IBusModelEnumTag[] recList = schema.getBusModelBackingStore().getTableEnumTag().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelEnumTag rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getEnumTagTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelEnumTagObj realised = (IBusModelEnumTagObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelEnumTagObj arr[] = new IBusModelEnumTagObj[len];
		Iterator<IBusModelEnumTagObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelEnumTagObj> arrayList = new ArrayList<IBusModelEnumTagObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelEnumTagObj> cmp = new Comparator<IBusModelEnumTagObj>() {
			@Override
			public int compare( IBusModelEnumTagObj lhs, IBusModelEnumTagObj rhs ) {
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
		List<IBusModelEnumTagObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelEnumTagObj readEnumTagByEnumNameIdx( IYCFKeyHash256 EnumId,
		String Name )
	{
		return( readEnumTagByEnumNameIdx( EnumId,
			Name,
			false ) );
	}

	@Override
	public IBusModelEnumTagObj readEnumTagByEnumNameIdx( IYCFKeyHash256 EnumId,
		String Name, boolean forceRead )
	{
		if( indexByEnumNameIdx == null ) {
			indexByEnumNameIdx = new HashMap< IBusModelEnumTagByEnumNameIdxKey,
				IBusModelEnumTagObj >();
		}
		IBusModelEnumTagByEnumNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByEnumNameIdxKey();
		key.setRequiredEnumId( EnumId );
		key.setRequiredName( Name );
		IBusModelEnumTagObj obj = null;
		if( ( ! forceRead ) && indexByEnumNameIdx.containsKey( key ) ) {
			obj = indexByEnumNameIdx.get( key );
		}
		else {
			IBusModelEnumTag rec = schema.getBusModelBackingStore().getTableEnumTag().readDerivedByEnumNameIdx( null,
				EnumId,
				Name );
			if( rec != null ) {
				obj = schema.getEnumTagTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelEnumTagObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelEnumTagObj> readEnumTagByPrevIdx( IYCFKeyHash256 PrevId )
	{
		return( readEnumTagByPrevIdx( PrevId,
			false ) );
	}

	@Override
	public List<IBusModelEnumTagObj> readEnumTagByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readEnumTagByPrevIdx";
		IBusModelEnumTagByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelEnumTagByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelEnumTagObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj>();
			IBusModelEnumTagObj obj;
			IBusModelEnumTag[] recList = schema.getBusModelBackingStore().getTableEnumTag().readDerivedByPrevIdx( null,
				PrevId );
			IBusModelEnumTag rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getEnumTagTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelEnumTagObj realised = (IBusModelEnumTagObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelEnumTagObj arr[] = new IBusModelEnumTagObj[len];
		Iterator<IBusModelEnumTagObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelEnumTagObj> arrayList = new ArrayList<IBusModelEnumTagObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelEnumTagObj> cmp = new Comparator<IBusModelEnumTagObj>() {
			@Override
			public int compare( IBusModelEnumTagObj lhs, IBusModelEnumTagObj rhs ) {
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
		List<IBusModelEnumTagObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelEnumTagObj> readEnumTagByNextIdx( IYCFKeyHash256 NextId )
	{
		return( readEnumTagByNextIdx( NextId,
			false ) );
	}

	@Override
	public List<IBusModelEnumTagObj> readEnumTagByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readEnumTagByNextIdx";
		IBusModelEnumTagByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelEnumTagByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelEnumTagObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj>();
			IBusModelEnumTagObj obj;
			IBusModelEnumTag[] recList = schema.getBusModelBackingStore().getTableEnumTag().readDerivedByNextIdx( null,
				NextId );
			IBusModelEnumTag rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getEnumTagTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelEnumTagObj realised = (IBusModelEnumTagObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelEnumTagObj arr[] = new IBusModelEnumTagObj[len];
		Iterator<IBusModelEnumTagObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelEnumTagObj> arrayList = new ArrayList<IBusModelEnumTagObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelEnumTagObj> cmp = new Comparator<IBusModelEnumTagObj>() {
			@Override
			public int compare( IBusModelEnumTagObj lhs, IBusModelEnumTagObj rhs ) {
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
		List<IBusModelEnumTagObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelEnumTagObj readCachedEnumTagByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelEnumTagObj obj = null;
		obj = readCachedEnumTag( Id );
		return( obj );
	}

	@Override
	public List<IBusModelEnumTagObj> readCachedEnumTagByEnumIdx( IYCFKeyHash256 EnumId )
	{
		final String S_ProcName = "readCachedEnumTagByEnumIdx";
		IBusModelEnumTagByEnumIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByEnumIdxKey();
		key.setRequiredEnumId( EnumId );
		ArrayList<IBusModelEnumTagObj> arrayList = new ArrayList<IBusModelEnumTagObj>();
		if( indexByEnumIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj> dict;
			if( indexByEnumIdx.containsKey( key ) ) {
				dict = indexByEnumIdx.get( key );
				int len = dict.size();
				IBusModelEnumTagObj arr[] = new IBusModelEnumTagObj[len];
				Iterator<IBusModelEnumTagObj> valIter = dict.values().iterator();
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
			IBusModelEnumTagObj obj;
			Iterator<IBusModelEnumTagObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelEnumTagObj> cmp = new Comparator<IBusModelEnumTagObj>() {
			@Override
			public int compare( IBusModelEnumTagObj lhs, IBusModelEnumTagObj rhs ) {
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
	public List<IBusModelEnumTagObj> readCachedEnumTagByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedEnumTagByDefSchemaIdx";
		IBusModelEnumTagByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelEnumTagObj> arrayList = new ArrayList<IBusModelEnumTagObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelEnumTagObj arr[] = new IBusModelEnumTagObj[len];
				Iterator<IBusModelEnumTagObj> valIter = dict.values().iterator();
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
			IBusModelEnumTagObj obj;
			Iterator<IBusModelEnumTagObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelEnumTagObj> cmp = new Comparator<IBusModelEnumTagObj>() {
			@Override
			public int compare( IBusModelEnumTagObj lhs, IBusModelEnumTagObj rhs ) {
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
	public IBusModelEnumTagObj readCachedEnumTagByEnumNameIdx( IYCFKeyHash256 EnumId,
		String Name )
	{
		IBusModelEnumTagObj obj = null;
		IBusModelEnumTagByEnumNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByEnumNameIdxKey();
		key.setRequiredEnumId( EnumId );
		key.setRequiredName( Name );
		if( indexByEnumNameIdx != null ) {
			if( indexByEnumNameIdx.containsKey( key ) ) {
				obj = indexByEnumNameIdx.get( key );
			}
			else {
				Iterator<IBusModelEnumTagObj> valIter = members.values().iterator();
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
			Iterator<IBusModelEnumTagObj> valIter = members.values().iterator();
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
	public List<IBusModelEnumTagObj> readCachedEnumTagByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedEnumTagByPrevIdx";
		IBusModelEnumTagByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelEnumTagObj> arrayList = new ArrayList<IBusModelEnumTagObj>();
		if( indexByPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj> dict;
			if( indexByPrevIdx.containsKey( key ) ) {
				dict = indexByPrevIdx.get( key );
				int len = dict.size();
				IBusModelEnumTagObj arr[] = new IBusModelEnumTagObj[len];
				Iterator<IBusModelEnumTagObj> valIter = dict.values().iterator();
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
			IBusModelEnumTagObj obj;
			Iterator<IBusModelEnumTagObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelEnumTagObj> cmp = new Comparator<IBusModelEnumTagObj>() {
			@Override
			public int compare( IBusModelEnumTagObj lhs, IBusModelEnumTagObj rhs ) {
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
	public List<IBusModelEnumTagObj> readCachedEnumTagByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedEnumTagByNextIdx";
		IBusModelEnumTagByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelEnumTagObj> arrayList = new ArrayList<IBusModelEnumTagObj>();
		if( indexByNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj> dict;
			if( indexByNextIdx.containsKey( key ) ) {
				dict = indexByNextIdx.get( key );
				int len = dict.size();
				IBusModelEnumTagObj arr[] = new IBusModelEnumTagObj[len];
				Iterator<IBusModelEnumTagObj> valIter = dict.values().iterator();
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
			IBusModelEnumTagObj obj;
			Iterator<IBusModelEnumTagObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelEnumTagObj> cmp = new Comparator<IBusModelEnumTagObj>() {
			@Override
			public int compare( IBusModelEnumTagObj lhs, IBusModelEnumTagObj rhs ) {
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
	public void deepDisposeEnumTagByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelEnumTagObj obj = readCachedEnumTagByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeEnumTagByEnumIdx( IYCFKeyHash256 EnumId )
	{
		final String S_ProcName = "deepDisposeEnumTagByEnumIdx";
		IBusModelEnumTagObj obj;
		List<IBusModelEnumTagObj> arrayList = readCachedEnumTagByEnumIdx( EnumId );
		if( arrayList != null )  {
			Iterator<IBusModelEnumTagObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeEnumTagByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeEnumTagByDefSchemaIdx";
		IBusModelEnumTagObj obj;
		List<IBusModelEnumTagObj> arrayList = readCachedEnumTagByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelEnumTagObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeEnumTagByEnumNameIdx( IYCFKeyHash256 EnumId,
		String Name )
	{
		IBusModelEnumTagObj obj = readCachedEnumTagByEnumNameIdx( EnumId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeEnumTagByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeEnumTagByPrevIdx";
		IBusModelEnumTagObj obj;
		List<IBusModelEnumTagObj> arrayList = readCachedEnumTagByPrevIdx( PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelEnumTagObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeEnumTagByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeEnumTagByNextIdx";
		IBusModelEnumTagObj obj;
		List<IBusModelEnumTagObj> arrayList = readCachedEnumTagByNextIdx( NextId );
		if( arrayList != null )  {
			Iterator<IBusModelEnumTagObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelEnumTagObj updateEnumTag( IBusModelEnumTagObj Obj ) {
		IBusModelEnumTagObj obj = Obj;
		schema.getBusModelBackingStore().getTableEnumTag().updateEnumTag( null,
			Obj.getEnumTagRec() );
		obj = (IBusModelEnumTagObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteEnumTag( IBusModelEnumTagObj Obj ) {
		IBusModelEnumTagObj obj = Obj;
		IBusModelEnumTagObj prev = obj.getOptionalLookupPrev();
		IBusModelEnumTagObj next = obj.getOptionalLookupNext();
		schema.getBusModelBackingStore().getTableEnumTag().deleteEnumTag( null,
			obj.getEnumTagRec() );
		Obj.forget();
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	@Override
	public void deleteEnumTagByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelEnumTagObj obj = readEnumTag(Id);
		if( obj != null ) {
			IBusModelEnumTagEditObj editObj = (IBusModelEnumTagEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelEnumTagEditObj)obj.beginEdit();
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
		deepDisposeEnumTagByIdIdx( Id );
	}

	@Override
	public void deleteEnumTagByEnumIdx( IYCFKeyHash256 EnumId )
	{
		IBusModelEnumTagByEnumIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByEnumIdxKey();
		key.setRequiredEnumId( EnumId );
		if( indexByEnumIdx == null ) {
			indexByEnumIdx = new HashMap< IBusModelEnumTagByEnumIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelEnumTagObj > >();
		}
		if( indexByEnumIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj> dict = indexByEnumIdx.get( key );
			schema.getBusModelBackingStore().getTableEnumTag().deleteEnumTagByEnumIdx( null,
				EnumId );
			Iterator<IBusModelEnumTagObj> iter = dict.values().iterator();
			IBusModelEnumTagObj obj;
			List<IBusModelEnumTagObj> toForget = new LinkedList<IBusModelEnumTagObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByEnumIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableEnumTag().deleteEnumTagByEnumIdx( null,
				EnumId );
		}
		deepDisposeEnumTagByEnumIdx( EnumId );
	}

	@Override
	public void deleteEnumTagByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelEnumTagByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelEnumTagByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelEnumTagObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableEnumTag().deleteEnumTagByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelEnumTagObj> iter = dict.values().iterator();
			IBusModelEnumTagObj obj;
			List<IBusModelEnumTagObj> toForget = new LinkedList<IBusModelEnumTagObj>();
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
			schema.getBusModelBackingStore().getTableEnumTag().deleteEnumTagByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeEnumTagByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteEnumTagByEnumNameIdx( IYCFKeyHash256 EnumId,
		String Name )
	{
		if( indexByEnumNameIdx == null ) {
			indexByEnumNameIdx = new HashMap< IBusModelEnumTagByEnumNameIdxKey,
				IBusModelEnumTagObj >();
		}
		IBusModelEnumTagByEnumNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByEnumNameIdxKey();
		key.setRequiredEnumId( EnumId );
		key.setRequiredName( Name );
		IBusModelEnumTagObj obj = null;
		if( indexByEnumNameIdx.containsKey( key ) ) {
			obj = indexByEnumNameIdx.get( key );
			schema.getBusModelBackingStore().getTableEnumTag().deleteEnumTagByEnumNameIdx( null,
				EnumId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableEnumTag().deleteEnumTagByEnumNameIdx( null,
				EnumId,
				Name );
		}
		deepDisposeEnumTagByEnumNameIdx( EnumId,
				Name );
	}

	@Override
	public void deleteEnumTagByPrevIdx( IYCFKeyHash256 PrevId )
	{
		IBusModelEnumTagByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelEnumTagByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelEnumTagObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj> dict = indexByPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableEnumTag().deleteEnumTagByPrevIdx( null,
				PrevId );
			Iterator<IBusModelEnumTagObj> iter = dict.values().iterator();
			IBusModelEnumTagObj obj;
			List<IBusModelEnumTagObj> toForget = new LinkedList<IBusModelEnumTagObj>();
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
			schema.getBusModelBackingStore().getTableEnumTag().deleteEnumTagByPrevIdx( null,
				PrevId );
		}
		deepDisposeEnumTagByPrevIdx( PrevId );
	}

	@Override
	public void deleteEnumTagByNextIdx( IYCFKeyHash256 NextId )
	{
		IBusModelEnumTagByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelEnumTagByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelEnumTagObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelEnumTagObj> dict = indexByNextIdx.get( key );
			schema.getBusModelBackingStore().getTableEnumTag().deleteEnumTagByNextIdx( null,
				NextId );
			Iterator<IBusModelEnumTagObj> iter = dict.values().iterator();
			IBusModelEnumTagObj obj;
			List<IBusModelEnumTagObj> toForget = new LinkedList<IBusModelEnumTagObj>();
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
			schema.getBusModelBackingStore().getTableEnumTag().deleteEnumTagByNextIdx( null,
				NextId );
		}
		deepDisposeEnumTagByNextIdx( NextId );
	}

	/**
	 *	Move the BusModelEnumTagObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelEnumTagObj refreshed cache instance.
	 */
	@Override
	public IBusModelEnumTagObj moveUpEnumTag( IBusModelEnumTagObj Obj ) {
		IBusModelEnumTagObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUpEnumTag" );
		}
		IBusModelEnumTag rec = schema.getBusModelBackingStore().getTableEnumTag().moveRecUp( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getEnumTagTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelEnumTagObj)obj.realise();
			IBusModelEnumTagObj prev = obj.getOptionalLookupPrev( true );
			IBusModelEnumTagObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				IBusModelEnumTagObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the BusModelEnumTagObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelEnumTagObj refreshed cache instance.
	 */
	@Override
	public IBusModelEnumTagObj moveDownEnumTag( IBusModelEnumTagObj Obj ) {
		IBusModelEnumTagObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDownEnumTag" );
		}
		IBusModelEnumTag rec = schema.getBusModelBackingStore().getTableEnumTag().moveRecDown( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getEnumTagTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelEnumTagObj)obj.realise();
			IBusModelEnumTagObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				IBusModelEnumTagObj gprev = prev.getOptionalLookupPrev( true );
			}
			IBusModelEnumTagObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}