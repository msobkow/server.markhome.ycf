// Description: Java 25 Table Object implementation for Param.

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

public class BusModelParamTableObj
	implements IBusModelParamTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelParam.CLASS_CODE;
	protected static final int backingClassCode = IBusModelParam.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> allParam;
	private Map< IBusModelParamByUNameIdxKey,
		IBusModelParamObj > indexByUNameIdx;
	private Map< IBusModelParamByServerMethodIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > > indexByServerMethodIdx;
	private Map< IBusModelParamByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > > indexByDefSchemaIdx;
	private Map< IBusModelParamByServerTypeIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > > indexByServerTypeIdx;
	private Map< IBusModelParamByPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > > indexByPrevIdx;
	private Map< IBusModelParamByNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > > indexByNextIdx;
	private Map< IBusModelParamByContPrevIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > > indexByContPrevIdx;
	private Map< IBusModelParamByContNextIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > > indexByContNextIdx;
	public static String TABLE_NAME = "Param";
	public static String TABLE_DBNAME = "srvprm";

	public BusModelParamTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelParamObj>();
		allParam = null;
		indexByUNameIdx = null;
		indexByServerMethodIdx = null;
		indexByDefSchemaIdx = null;
		indexByServerTypeIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
	}

	public BusModelParamTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelParamObj>();
		allParam = null;
		indexByUNameIdx = null;
		indexByServerMethodIdx = null;
		indexByDefSchemaIdx = null;
		indexByServerTypeIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelParamTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelParamTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allParam = null;
		indexByUNameIdx = null;
		indexByServerMethodIdx = null;
		indexByDefSchemaIdx = null;
		indexByServerTypeIdx = null;
		indexByPrevIdx = null;
		indexByNextIdx = null;
		indexByContPrevIdx = null;
		indexByContNextIdx = null;
		List<IBusModelParamObj> toForget = new LinkedList<IBusModelParamObj>();
		IBusModelParamObj cur = null;
		Iterator<IBusModelParamObj> iter = members.values().iterator();
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
	 *	BusModelParamObj.
	 */
	@Override
	public IBusModelParamObj newInstance() {
		IBusModelParamObj inst = new BusModelParamObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelParamObj.
	 */
	@Override
	public IBusModelParamEditObj newEditInstance( IBusModelParamObj orig ) {
		IBusModelParamEditObj edit = new BusModelParamEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelParamObj constructByClassCode( int backingClassCode ) {
		IBusModelParamObj obj = null;
		if( backingClassCode == IBusModelParam.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getParamTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public IBusModelParamObj realiseParam( IBusModelParamObj Obj ) {
		IBusModelParamObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelParamObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelParamObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				IBusModelParamByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByUNameIdxKey();
				keyUNameIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByServerMethodIdx != null ) {
				IBusModelParamByServerMethodIdxKey keyServerMethodIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByServerMethodIdxKey();
				keyServerMethodIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapServerMethodIdx = indexByServerMethodIdx.get( keyServerMethodIdx );
				if( mapServerMethodIdx != null ) {
					mapServerMethodIdx.remove( keepObj.getPKey() );
					if( mapServerMethodIdx.size() <= 0 ) {
						indexByServerMethodIdx.remove( keyServerMethodIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelParamByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByServerTypeIdx != null ) {
				IBusModelParamByServerTypeIdxKey keyServerTypeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByServerTypeIdxKey();
				keyServerTypeIdx.setOptionalTypeId( keepObj.getOptionalTypeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapServerTypeIdx = indexByServerTypeIdx.get( keyServerTypeIdx );
				if( mapServerTypeIdx != null ) {
					mapServerTypeIdx.remove( keepObj.getPKey() );
					if( mapServerTypeIdx.size() <= 0 ) {
						indexByServerTypeIdx.remove( keyServerTypeIdx );
					}
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelParamByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.remove( keepObj.getPKey() );
					if( mapPrevIdx.size() <= 0 ) {
						indexByPrevIdx.remove( keyPrevIdx );
					}
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelParamByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.remove( keepObj.getPKey() );
					if( mapNextIdx.size() <= 0 ) {
						indexByNextIdx.remove( keyNextIdx );
					}
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelParamByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.remove( keepObj.getPKey() );
					if( mapContPrevIdx.size() <= 0 ) {
						indexByContPrevIdx.remove( keyContPrevIdx );
					}
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelParamByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByContNextIdxKey();
				keyContNextIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.remove( keepObj.getPKey() );
					if( mapContNextIdx.size() <= 0 ) {
						indexByContNextIdx.remove( keyContNextIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				IBusModelParamByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByUNameIdxKey();
				keyUNameIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByServerMethodIdx != null ) {
				IBusModelParamByServerMethodIdxKey keyServerMethodIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByServerMethodIdxKey();
				keyServerMethodIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapServerMethodIdx = indexByServerMethodIdx.get( keyServerMethodIdx );
				if( mapServerMethodIdx != null ) {
					mapServerMethodIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelParamByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByServerTypeIdx != null ) {
				IBusModelParamByServerTypeIdxKey keyServerTypeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByServerTypeIdxKey();
				keyServerTypeIdx.setOptionalTypeId( keepObj.getOptionalTypeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapServerTypeIdx = indexByServerTypeIdx.get( keyServerTypeIdx );
				if( mapServerTypeIdx != null ) {
					mapServerTypeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelParamByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelParamByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelParamByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelParamByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByContNextIdxKey();
				keyContNextIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allParam != null ) {
				allParam.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allParam != null ) {
				allParam.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				IBusModelParamByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByUNameIdxKey();
				keyUNameIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByServerMethodIdx != null ) {
				IBusModelParamByServerMethodIdxKey keyServerMethodIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByServerMethodIdxKey();
				keyServerMethodIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapServerMethodIdx = indexByServerMethodIdx.get( keyServerMethodIdx );
				if( mapServerMethodIdx != null ) {
					mapServerMethodIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelParamByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByServerTypeIdx != null ) {
				IBusModelParamByServerTypeIdxKey keyServerTypeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByServerTypeIdxKey();
				keyServerTypeIdx.setOptionalTypeId( keepObj.getOptionalTypeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapServerTypeIdx = indexByServerTypeIdx.get( keyServerTypeIdx );
				if( mapServerTypeIdx != null ) {
					mapServerTypeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPrevIdx != null ) {
				IBusModelParamByPrevIdxKey keyPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByPrevIdxKey();
				keyPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapPrevIdx = indexByPrevIdx.get( keyPrevIdx );
				if( mapPrevIdx != null ) {
					mapPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextIdx != null ) {
				IBusModelParamByNextIdxKey keyNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByNextIdxKey();
				keyNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapNextIdx = indexByNextIdx.get( keyNextIdx );
				if( mapNextIdx != null ) {
					mapNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContPrevIdx != null ) {
				IBusModelParamByContPrevIdxKey keyContPrevIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByContPrevIdxKey();
				keyContPrevIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContPrevIdx.setOptionalPrevId( keepObj.getOptionalPrevId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapContPrevIdx = indexByContPrevIdx.get( keyContPrevIdx );
				if( mapContPrevIdx != null ) {
					mapContPrevIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByContNextIdx != null ) {
				IBusModelParamByContNextIdxKey keyContNextIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByContNextIdxKey();
				keyContNextIdx.setRequiredServerMethodId( keepObj.getRequiredServerMethodId() );
				keyContNextIdx.setOptionalNextId( keepObj.getOptionalNextId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelParamObj > mapContNextIdx = indexByContNextIdx.get( keyContNextIdx );
				if( mapContNextIdx != null ) {
					mapContNextIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelParamObj createParam( IBusModelParamObj Obj ) {
		IBusModelParamObj obj = Obj;
		IBusModelParam rec = obj.getParamRec();
		schema.getBusModelBackingStore().getTableParam().createParam(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		IBusModelParamObj prev = obj.getOptionalLookupPrev();
		if( prev != null ) {
			prev.read( true );
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelParamObj readParam( $implCommaIJavaOptAtomType$ pkey ) {
		return( readParam( pkey, false ) );
	}

	@Override
	public IBusModelParamObj readParam( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelParamObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelParam readRec = schema.getBusModelBackingStore().getTableParam().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelParamObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelParamObj readCachedParam( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelParamObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeParam( IBusModelParamObj obj )
	{
		final String S_ProcName = "BusModelParamTableObj.reallyDeepDisposeParam() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelParamObj existing = readCachedParam( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelParamByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByUNameIdxKey();
		keyUNameIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		IBusModelParamByServerMethodIdxKey keyServerMethodIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByServerMethodIdxKey();
		keyServerMethodIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );

		IBusModelParamByDefSchemaIdxKey keyDefSchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		IBusModelParamByServerTypeIdxKey keyServerTypeIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByServerTypeIdxKey();
		keyServerTypeIdx.setOptionalTypeId( existing.getOptionalTypeId() );

		IBusModelParamByPrevIdxKey keyPrevIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByPrevIdxKey();
		keyPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		IBusModelParamByNextIdxKey keyNextIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByNextIdxKey();
		keyNextIdx.setOptionalNextId( existing.getOptionalNextId() );

		IBusModelParamByContPrevIdxKey keyContPrevIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByContPrevIdxKey();
		keyContPrevIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );
		keyContPrevIdx.setOptionalPrevId( existing.getOptionalPrevId() );

		IBusModelParamByContNextIdxKey keyContNextIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByContNextIdxKey();
		keyContNextIdx.setRequiredServerMethodId( existing.getRequiredServerMethodId() );
		keyContNextIdx.setOptionalNextId( existing.getOptionalNextId() );



		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}

		if( indexByServerMethodIdx != null ) {
			if( indexByServerMethodIdx.containsKey( keyServerMethodIdx ) ) {
				indexByServerMethodIdx.get( keyServerMethodIdx ).remove( pkey );
				if( indexByServerMethodIdx.get( keyServerMethodIdx ).size() <= 0 ) {
					indexByServerMethodIdx.remove( keyServerMethodIdx );
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

		if( indexByServerTypeIdx != null ) {
			if( indexByServerTypeIdx.containsKey( keyServerTypeIdx ) ) {
				indexByServerTypeIdx.get( keyServerTypeIdx ).remove( pkey );
				if( indexByServerTypeIdx.get( keyServerTypeIdx ).size() <= 0 ) {
					indexByServerTypeIdx.remove( keyServerTypeIdx );
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

		if( indexByContPrevIdx != null ) {
			if( indexByContPrevIdx.containsKey( keyContPrevIdx ) ) {
				indexByContPrevIdx.get( keyContPrevIdx ).remove( pkey );
				if( indexByContPrevIdx.get( keyContPrevIdx ).size() <= 0 ) {
					indexByContPrevIdx.remove( keyContPrevIdx );
				}
			}
		}

		if( indexByContNextIdx != null ) {
			if( indexByContNextIdx.containsKey( keyContNextIdx ) ) {
				indexByContNextIdx.get( keyContNextIdx ).remove( pkey );
				if( indexByContNextIdx.get( keyContNextIdx ).size() <= 0 ) {
					indexByContNextIdx.remove( keyContNextIdx );
				}
			}
		}


	}
	@Override
	public void deepDisposeParam( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelParamObj obj = readCachedParam( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelParamObj lockParam( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelParamObj locked = null;
		IBusModelParam lockRec = schema.getBusModelBackingStore().getTableParam().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getParamTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelParamObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockParam", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelParamObj> readAllParam() {
		return( readAllParam( false ) );
	}

	@Override
	public List<IBusModelParamObj> readAllParam( boolean forceRead ) {
		final String S_ProcName = "readAllParam";
		if( ( allParam == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelParamObj>();
			allParam = map;
			IBusModelParam[] recList = schema.getBusModelBackingStore().getTableParam().readAllDerived( null );
			IBusModelParam rec;
			IBusModelParamObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelParamObj realised = (IBusModelParamObj)obj.realise();
			}
		}
		int len = allParam.size();
		IBusModelParamObj arr[] = new IBusModelParamObj[len];
		Iterator<IBusModelParamObj> valIter = allParam.values().iterator();
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
		ArrayList<IBusModelParamObj> arrayList = new ArrayList<IBusModelParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelParamObj> cmp = new Comparator<IBusModelParamObj>() {
			@Override
			public int compare( IBusModelParamObj lhs, IBusModelParamObj rhs ) {
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
		List<IBusModelParamObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelParamObj> readCachedAllParam() {
		final String S_ProcName = "readCachedAllParam";
		ArrayList<IBusModelParamObj> arrayList = new ArrayList<IBusModelParamObj>();
		if( allParam != null ) {
			int len = allParam.size();
			IBusModelParamObj arr[] = new IBusModelParamObj[len];
			Iterator<IBusModelParamObj> valIter = allParam.values().iterator();
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
		Comparator<IBusModelParamObj> cmp = new Comparator<IBusModelParamObj>() {
			public int compare( IBusModelParamObj lhs, IBusModelParamObj rhs ) {
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
	public IBusModelParamObj readParamByIdIdx( IYCFKeyHash256 Id )
	{
		return( readParamByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelParamObj readParamByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelParamObj obj = readParam( Id, forceRead );
		return( obj );
	}

	@Override
	public IBusModelParamObj readParamByUNameIdx( IYCFKeyHash256 ServerMethodId,
		String Name )
	{
		return( readParamByUNameIdx( ServerMethodId,
			Name,
			false ) );
	}

	@Override
	public IBusModelParamObj readParamByUNameIdx( IYCFKeyHash256 ServerMethodId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelParamByUNameIdxKey,
				IBusModelParamObj >();
		}
		IBusModelParamByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByUNameIdxKey();
		key.setRequiredServerMethodId( ServerMethodId );
		key.setRequiredName( Name );
		IBusModelParamObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelParam rec = schema.getBusModelBackingStore().getTableParam().readDerivedByUNameIdx( null,
				ServerMethodId,
				Name );
			if( rec != null ) {
				obj = schema.getParamTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelParamObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelParamObj> readParamByServerMethodIdx( IYCFKeyHash256 ServerMethodId )
	{
		return( readParamByServerMethodIdx( ServerMethodId,
			false ) );
	}

	@Override
	public List<IBusModelParamObj> readParamByServerMethodIdx( IYCFKeyHash256 ServerMethodId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByServerMethodIdx";
		IBusModelParamByServerMethodIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByServerMethodIdxKey();
		key.setRequiredServerMethodId( ServerMethodId );
		Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict;
		if( indexByServerMethodIdx == null ) {
			indexByServerMethodIdx = new HashMap< IBusModelParamByServerMethodIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelParamObj > >();
		}
		if( ( ! forceRead ) && indexByServerMethodIdx.containsKey( key ) ) {
			dict = indexByServerMethodIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelParamObj>();
			IBusModelParamObj obj;
			IBusModelParam[] recList = schema.getBusModelBackingStore().getTableParam().readDerivedByServerMethodIdx( null,
				ServerMethodId );
			IBusModelParam rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelParamObj realised = (IBusModelParamObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByServerMethodIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelParamObj arr[] = new IBusModelParamObj[len];
		Iterator<IBusModelParamObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelParamObj> arrayList = new ArrayList<IBusModelParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelParamObj> cmp = new Comparator<IBusModelParamObj>() {
			@Override
			public int compare( IBusModelParamObj lhs, IBusModelParamObj rhs ) {
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
		List<IBusModelParamObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelParamObj> readParamByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readParamByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelParamObj> readParamByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByDefSchemaIdx";
		IBusModelParamByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelParamByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelParamObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelParamObj>();
			IBusModelParamObj obj;
			IBusModelParam[] recList = schema.getBusModelBackingStore().getTableParam().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelParam rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelParamObj realised = (IBusModelParamObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelParamObj arr[] = new IBusModelParamObj[len];
		Iterator<IBusModelParamObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelParamObj> arrayList = new ArrayList<IBusModelParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelParamObj> cmp = new Comparator<IBusModelParamObj>() {
			@Override
			public int compare( IBusModelParamObj lhs, IBusModelParamObj rhs ) {
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
		List<IBusModelParamObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelParamObj> readParamByServerTypeIdx( IYCFKeyHash256 TypeId )
	{
		return( readParamByServerTypeIdx( TypeId,
			false ) );
	}

	@Override
	public List<IBusModelParamObj> readParamByServerTypeIdx( IYCFKeyHash256 TypeId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByServerTypeIdx";
		IBusModelParamByServerTypeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByServerTypeIdxKey();
		key.setOptionalTypeId( TypeId );
		Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict;
		if( indexByServerTypeIdx == null ) {
			indexByServerTypeIdx = new HashMap< IBusModelParamByServerTypeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelParamObj > >();
		}
		if( ( ! forceRead ) && indexByServerTypeIdx.containsKey( key ) ) {
			dict = indexByServerTypeIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelParamObj>();
			IBusModelParamObj obj;
			IBusModelParam[] recList = schema.getBusModelBackingStore().getTableParam().readDerivedByServerTypeIdx( null,
				TypeId );
			IBusModelParam rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelParamObj realised = (IBusModelParamObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByServerTypeIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelParamObj arr[] = new IBusModelParamObj[len];
		Iterator<IBusModelParamObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelParamObj> arrayList = new ArrayList<IBusModelParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelParamObj> cmp = new Comparator<IBusModelParamObj>() {
			@Override
			public int compare( IBusModelParamObj lhs, IBusModelParamObj rhs ) {
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
		List<IBusModelParamObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelParamObj> readParamByPrevIdx( IYCFKeyHash256 PrevId )
	{
		return( readParamByPrevIdx( PrevId,
			false ) );
	}

	@Override
	public List<IBusModelParamObj> readParamByPrevIdx( IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByPrevIdx";
		IBusModelParamByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict;
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelParamByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelParamObj > >();
		}
		if( ( ! forceRead ) && indexByPrevIdx.containsKey( key ) ) {
			dict = indexByPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelParamObj>();
			IBusModelParamObj obj;
			IBusModelParam[] recList = schema.getBusModelBackingStore().getTableParam().readDerivedByPrevIdx( null,
				PrevId );
			IBusModelParam rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelParamObj realised = (IBusModelParamObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelParamObj arr[] = new IBusModelParamObj[len];
		Iterator<IBusModelParamObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelParamObj> arrayList = new ArrayList<IBusModelParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelParamObj> cmp = new Comparator<IBusModelParamObj>() {
			@Override
			public int compare( IBusModelParamObj lhs, IBusModelParamObj rhs ) {
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
		List<IBusModelParamObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelParamObj> readParamByNextIdx( IYCFKeyHash256 NextId )
	{
		return( readParamByNextIdx( NextId,
			false ) );
	}

	@Override
	public List<IBusModelParamObj> readParamByNextIdx( IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByNextIdx";
		IBusModelParamByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict;
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelParamByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelParamObj > >();
		}
		if( ( ! forceRead ) && indexByNextIdx.containsKey( key ) ) {
			dict = indexByNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelParamObj>();
			IBusModelParamObj obj;
			IBusModelParam[] recList = schema.getBusModelBackingStore().getTableParam().readDerivedByNextIdx( null,
				NextId );
			IBusModelParam rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelParamObj realised = (IBusModelParamObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelParamObj arr[] = new IBusModelParamObj[len];
		Iterator<IBusModelParamObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelParamObj> arrayList = new ArrayList<IBusModelParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelParamObj> cmp = new Comparator<IBusModelParamObj>() {
			@Override
			public int compare( IBusModelParamObj lhs, IBusModelParamObj rhs ) {
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
		List<IBusModelParamObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelParamObj> readParamByContPrevIdx( IYCFKeyHash256 ServerMethodId,
		IYCFKeyHash256 PrevId )
	{
		return( readParamByContPrevIdx( ServerMethodId,
			PrevId,
			false ) );
	}

	@Override
	public List<IBusModelParamObj> readParamByContPrevIdx( IYCFKeyHash256 ServerMethodId,
		IYCFKeyHash256 PrevId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByContPrevIdx";
		IBusModelParamByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByContPrevIdxKey();
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalPrevId( PrevId );
		Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict;
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< IBusModelParamByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelParamObj > >();
		}
		if( ( ! forceRead ) && indexByContPrevIdx.containsKey( key ) ) {
			dict = indexByContPrevIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelParamObj>();
			IBusModelParamObj obj;
			IBusModelParam[] recList = schema.getBusModelBackingStore().getTableParam().readDerivedByContPrevIdx( null,
				ServerMethodId,
				PrevId );
			IBusModelParam rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelParamObj realised = (IBusModelParamObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContPrevIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelParamObj arr[] = new IBusModelParamObj[len];
		Iterator<IBusModelParamObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelParamObj> arrayList = new ArrayList<IBusModelParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelParamObj> cmp = new Comparator<IBusModelParamObj>() {
			@Override
			public int compare( IBusModelParamObj lhs, IBusModelParamObj rhs ) {
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
		List<IBusModelParamObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelParamObj> readParamByContNextIdx( IYCFKeyHash256 ServerMethodId,
		IYCFKeyHash256 NextId )
	{
		return( readParamByContNextIdx( ServerMethodId,
			NextId,
			false ) );
	}

	@Override
	public List<IBusModelParamObj> readParamByContNextIdx( IYCFKeyHash256 ServerMethodId,
		IYCFKeyHash256 NextId,
		boolean forceRead )
	{
		final String S_ProcName = "readParamByContNextIdx";
		IBusModelParamByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByContNextIdxKey();
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalNextId( NextId );
		Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict;
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< IBusModelParamByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelParamObj > >();
		}
		if( ( ! forceRead ) && indexByContNextIdx.containsKey( key ) ) {
			dict = indexByContNextIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelParamObj>();
			IBusModelParamObj obj;
			IBusModelParam[] recList = schema.getBusModelBackingStore().getTableParam().readDerivedByContNextIdx( null,
				ServerMethodId,
				NextId );
			IBusModelParam rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getParamTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelParamObj realised = (IBusModelParamObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByContNextIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelParamObj arr[] = new IBusModelParamObj[len];
		Iterator<IBusModelParamObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelParamObj> arrayList = new ArrayList<IBusModelParamObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelParamObj> cmp = new Comparator<IBusModelParamObj>() {
			@Override
			public int compare( IBusModelParamObj lhs, IBusModelParamObj rhs ) {
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
		List<IBusModelParamObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelParamObj readCachedParamByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelParamObj obj = null;
		obj = readCachedParam( Id );
		return( obj );
	}

	@Override
	public IBusModelParamObj readCachedParamByUNameIdx( IYCFKeyHash256 ServerMethodId,
		String Name )
	{
		IBusModelParamObj obj = null;
		IBusModelParamByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByUNameIdxKey();
		key.setRequiredServerMethodId( ServerMethodId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelParamObj> valIter = members.values().iterator();
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
			Iterator<IBusModelParamObj> valIter = members.values().iterator();
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
	public List<IBusModelParamObj> readCachedParamByServerMethodIdx( IYCFKeyHash256 ServerMethodId )
	{
		final String S_ProcName = "readCachedParamByServerMethodIdx";
		IBusModelParamByServerMethodIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByServerMethodIdxKey();
		key.setRequiredServerMethodId( ServerMethodId );
		ArrayList<IBusModelParamObj> arrayList = new ArrayList<IBusModelParamObj>();
		if( indexByServerMethodIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict;
			if( indexByServerMethodIdx.containsKey( key ) ) {
				dict = indexByServerMethodIdx.get( key );
				int len = dict.size();
				IBusModelParamObj arr[] = new IBusModelParamObj[len];
				Iterator<IBusModelParamObj> valIter = dict.values().iterator();
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
			IBusModelParamObj obj;
			Iterator<IBusModelParamObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelParamObj> cmp = new Comparator<IBusModelParamObj>() {
			@Override
			public int compare( IBusModelParamObj lhs, IBusModelParamObj rhs ) {
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
	public List<IBusModelParamObj> readCachedParamByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedParamByDefSchemaIdx";
		IBusModelParamByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelParamObj> arrayList = new ArrayList<IBusModelParamObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelParamObj arr[] = new IBusModelParamObj[len];
				Iterator<IBusModelParamObj> valIter = dict.values().iterator();
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
			IBusModelParamObj obj;
			Iterator<IBusModelParamObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelParamObj> cmp = new Comparator<IBusModelParamObj>() {
			@Override
			public int compare( IBusModelParamObj lhs, IBusModelParamObj rhs ) {
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
	public List<IBusModelParamObj> readCachedParamByServerTypeIdx( IYCFKeyHash256 TypeId )
	{
		final String S_ProcName = "readCachedParamByServerTypeIdx";
		IBusModelParamByServerTypeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByServerTypeIdxKey();
		key.setOptionalTypeId( TypeId );
		ArrayList<IBusModelParamObj> arrayList = new ArrayList<IBusModelParamObj>();
		if( indexByServerTypeIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict;
			if( indexByServerTypeIdx.containsKey( key ) ) {
				dict = indexByServerTypeIdx.get( key );
				int len = dict.size();
				IBusModelParamObj arr[] = new IBusModelParamObj[len];
				Iterator<IBusModelParamObj> valIter = dict.values().iterator();
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
			IBusModelParamObj obj;
			Iterator<IBusModelParamObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelParamObj> cmp = new Comparator<IBusModelParamObj>() {
			@Override
			public int compare( IBusModelParamObj lhs, IBusModelParamObj rhs ) {
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
	public List<IBusModelParamObj> readCachedParamByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedParamByPrevIdx";
		IBusModelParamByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelParamObj> arrayList = new ArrayList<IBusModelParamObj>();
		if( indexByPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict;
			if( indexByPrevIdx.containsKey( key ) ) {
				dict = indexByPrevIdx.get( key );
				int len = dict.size();
				IBusModelParamObj arr[] = new IBusModelParamObj[len];
				Iterator<IBusModelParamObj> valIter = dict.values().iterator();
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
			IBusModelParamObj obj;
			Iterator<IBusModelParamObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelParamObj> cmp = new Comparator<IBusModelParamObj>() {
			@Override
			public int compare( IBusModelParamObj lhs, IBusModelParamObj rhs ) {
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
	public List<IBusModelParamObj> readCachedParamByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedParamByNextIdx";
		IBusModelParamByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelParamObj> arrayList = new ArrayList<IBusModelParamObj>();
		if( indexByNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict;
			if( indexByNextIdx.containsKey( key ) ) {
				dict = indexByNextIdx.get( key );
				int len = dict.size();
				IBusModelParamObj arr[] = new IBusModelParamObj[len];
				Iterator<IBusModelParamObj> valIter = dict.values().iterator();
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
			IBusModelParamObj obj;
			Iterator<IBusModelParamObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelParamObj> cmp = new Comparator<IBusModelParamObj>() {
			@Override
			public int compare( IBusModelParamObj lhs, IBusModelParamObj rhs ) {
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
	public List<IBusModelParamObj> readCachedParamByContPrevIdx( IYCFKeyHash256 ServerMethodId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "readCachedParamByContPrevIdx";
		IBusModelParamByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByContPrevIdxKey();
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalPrevId( PrevId );
		ArrayList<IBusModelParamObj> arrayList = new ArrayList<IBusModelParamObj>();
		if( indexByContPrevIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict;
			if( indexByContPrevIdx.containsKey( key ) ) {
				dict = indexByContPrevIdx.get( key );
				int len = dict.size();
				IBusModelParamObj arr[] = new IBusModelParamObj[len];
				Iterator<IBusModelParamObj> valIter = dict.values().iterator();
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
			IBusModelParamObj obj;
			Iterator<IBusModelParamObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelParamObj> cmp = new Comparator<IBusModelParamObj>() {
			@Override
			public int compare( IBusModelParamObj lhs, IBusModelParamObj rhs ) {
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
	public List<IBusModelParamObj> readCachedParamByContNextIdx( IYCFKeyHash256 ServerMethodId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "readCachedParamByContNextIdx";
		IBusModelParamByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByContNextIdxKey();
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalNextId( NextId );
		ArrayList<IBusModelParamObj> arrayList = new ArrayList<IBusModelParamObj>();
		if( indexByContNextIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict;
			if( indexByContNextIdx.containsKey( key ) ) {
				dict = indexByContNextIdx.get( key );
				int len = dict.size();
				IBusModelParamObj arr[] = new IBusModelParamObj[len];
				Iterator<IBusModelParamObj> valIter = dict.values().iterator();
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
			IBusModelParamObj obj;
			Iterator<IBusModelParamObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelParamObj> cmp = new Comparator<IBusModelParamObj>() {
			@Override
			public int compare( IBusModelParamObj lhs, IBusModelParamObj rhs ) {
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
	public void deepDisposeParamByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelParamObj obj = readCachedParamByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeParamByUNameIdx( IYCFKeyHash256 ServerMethodId,
		String Name )
	{
		IBusModelParamObj obj = readCachedParamByUNameIdx( ServerMethodId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeParamByServerMethodIdx( IYCFKeyHash256 ServerMethodId )
	{
		final String S_ProcName = "deepDisposeParamByServerMethodIdx";
		IBusModelParamObj obj;
		List<IBusModelParamObj> arrayList = readCachedParamByServerMethodIdx( ServerMethodId );
		if( arrayList != null )  {
			Iterator<IBusModelParamObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeParamByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeParamByDefSchemaIdx";
		IBusModelParamObj obj;
		List<IBusModelParamObj> arrayList = readCachedParamByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelParamObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeParamByServerTypeIdx( IYCFKeyHash256 TypeId )
	{
		final String S_ProcName = "deepDisposeParamByServerTypeIdx";
		IBusModelParamObj obj;
		List<IBusModelParamObj> arrayList = readCachedParamByServerTypeIdx( TypeId );
		if( arrayList != null )  {
			Iterator<IBusModelParamObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeParamByPrevIdx( IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeParamByPrevIdx";
		IBusModelParamObj obj;
		List<IBusModelParamObj> arrayList = readCachedParamByPrevIdx( PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelParamObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeParamByNextIdx( IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeParamByNextIdx";
		IBusModelParamObj obj;
		List<IBusModelParamObj> arrayList = readCachedParamByNextIdx( NextId );
		if( arrayList != null )  {
			Iterator<IBusModelParamObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeParamByContPrevIdx( IYCFKeyHash256 ServerMethodId,
		IYCFKeyHash256 PrevId )
	{
		final String S_ProcName = "deepDisposeParamByContPrevIdx";
		IBusModelParamObj obj;
		List<IBusModelParamObj> arrayList = readCachedParamByContPrevIdx( ServerMethodId,
				PrevId );
		if( arrayList != null )  {
			Iterator<IBusModelParamObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeParamByContNextIdx( IYCFKeyHash256 ServerMethodId,
		IYCFKeyHash256 NextId )
	{
		final String S_ProcName = "deepDisposeParamByContNextIdx";
		IBusModelParamObj obj;
		List<IBusModelParamObj> arrayList = readCachedParamByContNextIdx( ServerMethodId,
				NextId );
		if( arrayList != null )  {
			Iterator<IBusModelParamObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelParamObj updateParam( IBusModelParamObj Obj ) {
		IBusModelParamObj obj = Obj;
		schema.getBusModelBackingStore().getTableParam().updateParam( null,
			Obj.getParamRec() );
		obj = (IBusModelParamObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteParam( IBusModelParamObj Obj ) {
		IBusModelParamObj obj = Obj;
		IBusModelParamObj prev = obj.getOptionalLookupPrev();
		IBusModelParamObj next = obj.getOptionalLookupNext();
		schema.getBusModelBackingStore().getTableParam().deleteParam( null,
			obj.getParamRec() );
		Obj.forget();
		if( prev != null ) {
			prev.read( true );
		}
		if( next != null ) {
			next.read( true );
		}
	}

	@Override
	public void deleteParamByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelParamObj obj = readParam(Id);
		if( obj != null ) {
			IBusModelParamEditObj editObj = (IBusModelParamEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelParamEditObj)obj.beginEdit();
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
		deepDisposeParamByIdIdx( Id );
	}

	@Override
	public void deleteParamByUNameIdx( IYCFKeyHash256 ServerMethodId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelParamByUNameIdxKey,
				IBusModelParamObj >();
		}
		IBusModelParamByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByUNameIdxKey();
		key.setRequiredServerMethodId( ServerMethodId );
		key.setRequiredName( Name );
		IBusModelParamObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableParam().deleteParamByUNameIdx( null,
				ServerMethodId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableParam().deleteParamByUNameIdx( null,
				ServerMethodId,
				Name );
		}
		deepDisposeParamByUNameIdx( ServerMethodId,
				Name );
	}

	@Override
	public void deleteParamByServerMethodIdx( IYCFKeyHash256 ServerMethodId )
	{
		IBusModelParamByServerMethodIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByServerMethodIdxKey();
		key.setRequiredServerMethodId( ServerMethodId );
		if( indexByServerMethodIdx == null ) {
			indexByServerMethodIdx = new HashMap< IBusModelParamByServerMethodIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelParamObj > >();
		}
		if( indexByServerMethodIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict = indexByServerMethodIdx.get( key );
			schema.getBusModelBackingStore().getTableParam().deleteParamByServerMethodIdx( null,
				ServerMethodId );
			Iterator<IBusModelParamObj> iter = dict.values().iterator();
			IBusModelParamObj obj;
			List<IBusModelParamObj> toForget = new LinkedList<IBusModelParamObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByServerMethodIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableParam().deleteParamByServerMethodIdx( null,
				ServerMethodId );
		}
		deepDisposeParamByServerMethodIdx( ServerMethodId );
	}

	@Override
	public void deleteParamByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelParamByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelParamByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelParamObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableParam().deleteParamByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelParamObj> iter = dict.values().iterator();
			IBusModelParamObj obj;
			List<IBusModelParamObj> toForget = new LinkedList<IBusModelParamObj>();
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
			schema.getBusModelBackingStore().getTableParam().deleteParamByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeParamByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteParamByServerTypeIdx( IYCFKeyHash256 TypeId )
	{
		IBusModelParamByServerTypeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByServerTypeIdxKey();
		key.setOptionalTypeId( TypeId );
		if( indexByServerTypeIdx == null ) {
			indexByServerTypeIdx = new HashMap< IBusModelParamByServerTypeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelParamObj > >();
		}
		if( indexByServerTypeIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict = indexByServerTypeIdx.get( key );
			schema.getBusModelBackingStore().getTableParam().deleteParamByServerTypeIdx( null,
				TypeId );
			Iterator<IBusModelParamObj> iter = dict.values().iterator();
			IBusModelParamObj obj;
			List<IBusModelParamObj> toForget = new LinkedList<IBusModelParamObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByServerTypeIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableParam().deleteParamByServerTypeIdx( null,
				TypeId );
		}
		deepDisposeParamByServerTypeIdx( TypeId );
	}

	@Override
	public void deleteParamByPrevIdx( IYCFKeyHash256 PrevId )
	{
		IBusModelParamByPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByPrevIdxKey();
		key.setOptionalPrevId( PrevId );
		if( indexByPrevIdx == null ) {
			indexByPrevIdx = new HashMap< IBusModelParamByPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelParamObj > >();
		}
		if( indexByPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict = indexByPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableParam().deleteParamByPrevIdx( null,
				PrevId );
			Iterator<IBusModelParamObj> iter = dict.values().iterator();
			IBusModelParamObj obj;
			List<IBusModelParamObj> toForget = new LinkedList<IBusModelParamObj>();
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
			schema.getBusModelBackingStore().getTableParam().deleteParamByPrevIdx( null,
				PrevId );
		}
		deepDisposeParamByPrevIdx( PrevId );
	}

	@Override
	public void deleteParamByNextIdx( IYCFKeyHash256 NextId )
	{
		IBusModelParamByNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByNextIdxKey();
		key.setOptionalNextId( NextId );
		if( indexByNextIdx == null ) {
			indexByNextIdx = new HashMap< IBusModelParamByNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelParamObj > >();
		}
		if( indexByNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict = indexByNextIdx.get( key );
			schema.getBusModelBackingStore().getTableParam().deleteParamByNextIdx( null,
				NextId );
			Iterator<IBusModelParamObj> iter = dict.values().iterator();
			IBusModelParamObj obj;
			List<IBusModelParamObj> toForget = new LinkedList<IBusModelParamObj>();
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
			schema.getBusModelBackingStore().getTableParam().deleteParamByNextIdx( null,
				NextId );
		}
		deepDisposeParamByNextIdx( NextId );
	}

	@Override
	public void deleteParamByContPrevIdx( IYCFKeyHash256 ServerMethodId,
		IYCFKeyHash256 PrevId )
	{
		IBusModelParamByContPrevIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByContPrevIdxKey();
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalPrevId( PrevId );
		if( indexByContPrevIdx == null ) {
			indexByContPrevIdx = new HashMap< IBusModelParamByContPrevIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelParamObj > >();
		}
		if( indexByContPrevIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict = indexByContPrevIdx.get( key );
			schema.getBusModelBackingStore().getTableParam().deleteParamByContPrevIdx( null,
				ServerMethodId,
				PrevId );
			Iterator<IBusModelParamObj> iter = dict.values().iterator();
			IBusModelParamObj obj;
			List<IBusModelParamObj> toForget = new LinkedList<IBusModelParamObj>();
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
			schema.getBusModelBackingStore().getTableParam().deleteParamByContPrevIdx( null,
				ServerMethodId,
				PrevId );
		}
		deepDisposeParamByContPrevIdx( ServerMethodId,
				PrevId );
	}

	@Override
	public void deleteParamByContNextIdx( IYCFKeyHash256 ServerMethodId,
		IYCFKeyHash256 NextId )
	{
		IBusModelParamByContNextIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryParam().newByContNextIdxKey();
		key.setRequiredServerMethodId( ServerMethodId );
		key.setOptionalNextId( NextId );
		if( indexByContNextIdx == null ) {
			indexByContNextIdx = new HashMap< IBusModelParamByContNextIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelParamObj > >();
		}
		if( indexByContNextIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelParamObj> dict = indexByContNextIdx.get( key );
			schema.getBusModelBackingStore().getTableParam().deleteParamByContNextIdx( null,
				ServerMethodId,
				NextId );
			Iterator<IBusModelParamObj> iter = dict.values().iterator();
			IBusModelParamObj obj;
			List<IBusModelParamObj> toForget = new LinkedList<IBusModelParamObj>();
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
			schema.getBusModelBackingStore().getTableParam().deleteParamByContNextIdx( null,
				ServerMethodId,
				NextId );
		}
		deepDisposeParamByContNextIdx( ServerMethodId,
				NextId );
	}

	/**
	 *	Move the BusModelParamObj instance up in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelParamObj refreshed cache instance.
	 */
	@Override
	public IBusModelParamObj moveUpParam( IBusModelParamObj Obj ) {
		IBusModelParamObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUpParam" );
		}
		IBusModelParam rec = schema.getBusModelBackingStore().getTableParam().moveRecUp( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getParamTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelParamObj)obj.realise();
			IBusModelParamObj prev = obj.getOptionalLookupPrev( true );
			IBusModelParamObj next = obj.getOptionalLookupNext( true );
			if( next != null ) {
				IBusModelParamObj gnext = next.getOptionalLookupNext( true );
			}
		}
		return( obj );
	}

	/**
	 *	Move the BusModelParamObj instance down in the chain.  The instance is always refreshed.
	 *
	 *	@return	BusModelParamObj refreshed cache instance.
	 */
	@Override
	public IBusModelParamObj moveDownParam( IBusModelParamObj Obj ) {
		IBusModelParamObj obj = null;
		if( null != Obj.getEdit() ) {
			throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDownParam" );
		}
		IBusModelParam rec = schema.getBusModelBackingStore().getTableParam().moveRecDown( null,
			Obj.getRequiredId(),
			Obj.getRec().getRequiredRevision() );
		if( rec != null ) {
			obj = schema.getParamTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			obj = (IBusModelParamObj)obj.realise();
			IBusModelParamObj prev = obj.getOptionalLookupPrev( true );
			if( prev != null ) {
				IBusModelParamObj gprev = prev.getOptionalLookupPrev( true );
			}
			IBusModelParamObj next = obj.getOptionalLookupNext( true );
		}
		return( obj );
	}
}