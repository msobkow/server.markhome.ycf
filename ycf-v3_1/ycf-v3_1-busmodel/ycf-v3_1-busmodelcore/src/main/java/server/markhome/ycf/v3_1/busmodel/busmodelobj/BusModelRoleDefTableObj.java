// Description: Java 25 Table Object implementation for RoleDef.

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

public class BusModelRoleDefTableObj
	implements IBusModelRoleDefTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelRoleDef.CLASS_CODE;
	protected static final int backingClassCode = IBusModelRoleDef.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj> allRoleDef;
	private Map< IBusModelRoleDefByUNameIdxKey,
		IBusModelRoleDefObj > indexByUNameIdx;
	private Map< IBusModelRoleDefByScopeIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj > > indexByScopeIdx;
	private Map< IBusModelRoleDefByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj > > indexByDefSchemaIdx;
	private Map< IBusModelRoleDefByUDefIdxKey,
		IBusModelRoleDefObj > indexByUDefIdx;
	public static String TABLE_NAME = "RoleDef";
	public static String TABLE_DBNAME = "roledef";

	public BusModelRoleDefTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj>();
		allRoleDef = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByUDefIdx = null;
	}

	public BusModelRoleDefTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj>();
		allRoleDef = null;
		indexByUNameIdx = null;
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
		return BusModelRoleDefTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelRoleDefTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allRoleDef = null;
		indexByUNameIdx = null;
		indexByScopeIdx = null;
		indexByDefSchemaIdx = null;
		indexByUDefIdx = null;
		List<IBusModelRoleDefObj> toForget = new LinkedList<IBusModelRoleDefObj>();
		IBusModelRoleDefObj cur = null;
		Iterator<IBusModelRoleDefObj> iter = members.values().iterator();
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
	 *	BusModelRoleDefObj.
	 */
	@Override
	public IBusModelRoleDefObj newInstance() {
		IBusModelRoleDefObj inst = new BusModelRoleDefObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelRoleDefObj.
	 */
	@Override
	public IBusModelRoleDefEditObj newEditInstance( IBusModelRoleDefObj orig ) {
		IBusModelRoleDefEditObj edit = new BusModelRoleDefEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelRoleDefObj constructByClassCode( int backingClassCode ) {
		IBusModelRoleDefObj obj = null;
		if( backingClassCode == IBusModelRoleDef.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getRoleDefTableObj().newInstance();
		}
		else if( backingClassCode == IBusModelSchemaRole.CLASS_CODE ) {
			obj = ((IBusModelSchemaObj)schema).getSchemaRoleTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public IBusModelRoleDefObj realiseRoleDef( IBusModelRoleDefObj Obj ) {
		IBusModelRoleDefObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelRoleDefObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelRoleDefObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				IBusModelRoleDefByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByScopeIdx != null ) {
				IBusModelRoleDefByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.remove( keepObj.getPKey() );
					if( mapScopeIdx.size() <= 0 ) {
						indexByScopeIdx.remove( keyScopeIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelRoleDefByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByUDefIdx != null ) {
				IBusModelRoleDefByUDefIdxKey keyUDefIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUDefIdxKey();
				keyUDefIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUDefIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				keyUDefIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUDefIdx.remove( keyUDefIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				IBusModelRoleDefByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByScopeIdx != null ) {
				IBusModelRoleDefByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelRoleDefByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUDefIdx != null ) {
				IBusModelRoleDefByUDefIdxKey keyUDefIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUDefIdxKey();
				keyUDefIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUDefIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				keyUDefIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUDefIdx.put( keyUDefIdx, keepObj );
			}

			if( allRoleDef != null ) {
				allRoleDef.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allRoleDef != null ) {
				allRoleDef.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				IBusModelRoleDefByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUNameIdxKey();
				keyUNameIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByScopeIdx != null ) {
				IBusModelRoleDefByScopeIdxKey keyScopeIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByScopeIdxKey();
				keyScopeIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj > mapScopeIdx = indexByScopeIdx.get( keyScopeIdx );
				if( mapScopeIdx != null ) {
					mapScopeIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelRoleDefByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUDefIdx != null ) {
				IBusModelRoleDefByUDefIdxKey keyUDefIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUDefIdxKey();
				keyUDefIdx.setRequiredScopeId( keepObj.getRequiredScopeId() );
				keyUDefIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				keyUDefIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUDefIdx.put( keyUDefIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelRoleDefObj createRoleDef( IBusModelRoleDefObj Obj ) {
		IBusModelRoleDefObj obj = Obj;
		IBusModelRoleDef rec = obj.getRoleDefRec();
		schema.getBusModelBackingStore().getTableRoleDef().createRoleDef(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelRoleDefObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelRoleDefObj readRoleDef( $implCommaIJavaOptAtomType$ pkey ) {
		return( readRoleDef( pkey, false ) );
	}

	@Override
	public IBusModelRoleDefObj readRoleDef( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelRoleDefObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelRoleDef readRec = schema.getBusModelBackingStore().getTableRoleDef().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelRoleDefObj)schema.getRoleDefTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelRoleDefObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelRoleDefObj readCachedRoleDef( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelRoleDefObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeRoleDef( IBusModelRoleDefObj obj )
	{
		final String S_ProcName = "BusModelRoleDefTableObj.reallyDeepDisposeRoleDef() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelRoleDefObj existing = readCachedRoleDef( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelRoleDefByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUNameIdxKey();
		keyUNameIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		IBusModelRoleDefByScopeIdxKey keyScopeIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByScopeIdxKey();
		keyScopeIdx.setRequiredScopeId( existing.getRequiredScopeId() );

		IBusModelRoleDefByDefSchemaIdxKey keyDefSchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		IBusModelRoleDefByUDefIdxKey keyUDefIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUDefIdxKey();
		keyUDefIdx.setRequiredScopeId( existing.getRequiredScopeId() );
		keyUDefIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );
		keyUDefIdx.setRequiredName( existing.getRequiredName() );



		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
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
	public void deepDisposeRoleDef( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelRoleDefObj obj = readCachedRoleDef( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelRoleDefObj lockRoleDef( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelRoleDefObj locked = null;
		IBusModelRoleDef lockRec = schema.getBusModelBackingStore().getTableRoleDef().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelRoleDefObj)schema.getRoleDefTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelRoleDefObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockRoleDef", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelRoleDefObj> readAllRoleDef() {
		return( readAllRoleDef( false ) );
	}

	@Override
	public List<IBusModelRoleDefObj> readAllRoleDef( boolean forceRead ) {
		final String S_ProcName = "readAllRoleDef";
		if( ( allRoleDef == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelRoleDefObj>();
			allRoleDef = map;
			IBusModelRoleDef[] recList = schema.getBusModelBackingStore().getTableRoleDef().readAllDerived( null );
			IBusModelRoleDef rec;
			IBusModelRoleDefObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelRoleDefObj)schema.getRoleDefTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelRoleDefObj realised = (IBusModelRoleDefObj)obj.realise();
			}
		}
		int len = allRoleDef.size();
		IBusModelRoleDefObj arr[] = new IBusModelRoleDefObj[len];
		Iterator<IBusModelRoleDefObj> valIter = allRoleDef.values().iterator();
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
		ArrayList<IBusModelRoleDefObj> arrayList = new ArrayList<IBusModelRoleDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelRoleDefObj> cmp = new Comparator<IBusModelRoleDefObj>() {
			@Override
			public int compare( IBusModelRoleDefObj lhs, IBusModelRoleDefObj rhs ) {
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
		List<IBusModelRoleDefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelRoleDefObj> readCachedAllRoleDef() {
		final String S_ProcName = "readCachedAllRoleDef";
		ArrayList<IBusModelRoleDefObj> arrayList = new ArrayList<IBusModelRoleDefObj>();
		if( allRoleDef != null ) {
			int len = allRoleDef.size();
			IBusModelRoleDefObj arr[] = new IBusModelRoleDefObj[len];
			Iterator<IBusModelRoleDefObj> valIter = allRoleDef.values().iterator();
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
		Comparator<IBusModelRoleDefObj> cmp = new Comparator<IBusModelRoleDefObj>() {
			public int compare( IBusModelRoleDefObj lhs, IBusModelRoleDefObj rhs ) {
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
	public IBusModelRoleDefObj readRoleDefByIdIdx( IYCFKeyHash256 Id )
	{
		return( readRoleDefByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelRoleDefObj readRoleDefByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelRoleDefObj obj = readRoleDef( Id, forceRead );
		return( obj );
	}

	@Override
	public IBusModelRoleDefObj readRoleDefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		return( readRoleDefByUNameIdx( ScopeId,
			Name,
			false ) );
	}

	@Override
	public IBusModelRoleDefObj readRoleDefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelRoleDefByUNameIdxKey,
				IBusModelRoleDefObj >();
		}
		IBusModelRoleDefByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelRoleDefObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelRoleDef rec = schema.getBusModelBackingStore().getTableRoleDef().readDerivedByUNameIdx( null,
				ScopeId,
				Name );
			if( rec != null ) {
				obj = (IBusModelRoleDefObj)schema.getRoleDefTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelRoleDefObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelRoleDefObj> readRoleDefByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		return( readRoleDefByScopeIdx( ScopeId,
			false ) );
	}

	@Override
	public List<IBusModelRoleDefObj> readRoleDefByScopeIdx( IYCFKeyHash256 ScopeId,
		boolean forceRead )
	{
		final String S_ProcName = "readRoleDefByScopeIdx";
		IBusModelRoleDefByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		Map<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj> dict;
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelRoleDefByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRoleDefObj > >();
		}
		if( ( ! forceRead ) && indexByScopeIdx.containsKey( key ) ) {
			dict = indexByScopeIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj>();
			IBusModelRoleDefObj obj;
			IBusModelRoleDef[] recList = schema.getBusModelBackingStore().getTableRoleDef().readDerivedByScopeIdx( null,
				ScopeId );
			IBusModelRoleDef rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelRoleDefObj)schema.getRoleDefTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelRoleDefObj realised = (IBusModelRoleDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByScopeIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelRoleDefObj arr[] = new IBusModelRoleDefObj[len];
		Iterator<IBusModelRoleDefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelRoleDefObj> arrayList = new ArrayList<IBusModelRoleDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelRoleDefObj> cmp = new Comparator<IBusModelRoleDefObj>() {
			@Override
			public int compare( IBusModelRoleDefObj lhs, IBusModelRoleDefObj rhs ) {
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
		List<IBusModelRoleDefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelRoleDefObj> readRoleDefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readRoleDefByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelRoleDefObj> readRoleDefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readRoleDefByDefSchemaIdx";
		IBusModelRoleDefByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelRoleDefByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRoleDefObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj>();
			IBusModelRoleDefObj obj;
			IBusModelRoleDef[] recList = schema.getBusModelBackingStore().getTableRoleDef().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelRoleDef rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelRoleDefObj)schema.getRoleDefTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelRoleDefObj realised = (IBusModelRoleDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelRoleDefObj arr[] = new IBusModelRoleDefObj[len];
		Iterator<IBusModelRoleDefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelRoleDefObj> arrayList = new ArrayList<IBusModelRoleDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelRoleDefObj> cmp = new Comparator<IBusModelRoleDefObj>() {
			@Override
			public int compare( IBusModelRoleDefObj lhs, IBusModelRoleDefObj rhs ) {
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
		List<IBusModelRoleDefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelRoleDefObj readRoleDefByUDefIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		return( readRoleDefByUDefIdx( ScopeId,
			DefSchemaId,
			Name,
			false ) );
	}

	@Override
	public IBusModelRoleDefObj readRoleDefByUDefIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaId,
		String Name, boolean forceRead )
	{
		if( indexByUDefIdx == null ) {
			indexByUDefIdx = new HashMap< IBusModelRoleDefByUDefIdxKey,
				IBusModelRoleDefObj >();
		}
		IBusModelRoleDefByUDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUDefIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalDefSchemaId( DefSchemaId );
		key.setRequiredName( Name );
		IBusModelRoleDefObj obj = null;
		if( ( ! forceRead ) && indexByUDefIdx.containsKey( key ) ) {
			obj = indexByUDefIdx.get( key );
		}
		else {
			IBusModelRoleDef rec = schema.getBusModelBackingStore().getTableRoleDef().readDerivedByUDefIdx( null,
				ScopeId,
				DefSchemaId,
				Name );
			if( rec != null ) {
				obj = (IBusModelRoleDefObj)schema.getRoleDefTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelRoleDefObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelRoleDefObj readCachedRoleDefByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelRoleDefObj obj = null;
		obj = readCachedRoleDef( Id );
		return( obj );
	}

	@Override
	public IBusModelRoleDefObj readCachedRoleDefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelRoleDefObj obj = null;
		IBusModelRoleDefByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelRoleDefObj> valIter = members.values().iterator();
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
			Iterator<IBusModelRoleDefObj> valIter = members.values().iterator();
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
	public List<IBusModelRoleDefObj> readCachedRoleDefByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "readCachedRoleDefByScopeIdx";
		IBusModelRoleDefByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		ArrayList<IBusModelRoleDefObj> arrayList = new ArrayList<IBusModelRoleDefObj>();
		if( indexByScopeIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj> dict;
			if( indexByScopeIdx.containsKey( key ) ) {
				dict = indexByScopeIdx.get( key );
				int len = dict.size();
				IBusModelRoleDefObj arr[] = new IBusModelRoleDefObj[len];
				Iterator<IBusModelRoleDefObj> valIter = dict.values().iterator();
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
			IBusModelRoleDefObj obj;
			Iterator<IBusModelRoleDefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelRoleDefObj> cmp = new Comparator<IBusModelRoleDefObj>() {
			@Override
			public int compare( IBusModelRoleDefObj lhs, IBusModelRoleDefObj rhs ) {
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
	public List<IBusModelRoleDefObj> readCachedRoleDefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedRoleDefByDefSchemaIdx";
		IBusModelRoleDefByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelRoleDefObj> arrayList = new ArrayList<IBusModelRoleDefObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelRoleDefObj arr[] = new IBusModelRoleDefObj[len];
				Iterator<IBusModelRoleDefObj> valIter = dict.values().iterator();
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
			IBusModelRoleDefObj obj;
			Iterator<IBusModelRoleDefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelRoleDefObj> cmp = new Comparator<IBusModelRoleDefObj>() {
			@Override
			public int compare( IBusModelRoleDefObj lhs, IBusModelRoleDefObj rhs ) {
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
	public IBusModelRoleDefObj readCachedRoleDefByUDefIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		IBusModelRoleDefObj obj = null;
		IBusModelRoleDefByUDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUDefIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalDefSchemaId( DefSchemaId );
		key.setRequiredName( Name );
		if( indexByUDefIdx != null ) {
			if( indexByUDefIdx.containsKey( key ) ) {
				obj = indexByUDefIdx.get( key );
			}
			else {
				Iterator<IBusModelRoleDefObj> valIter = members.values().iterator();
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
			Iterator<IBusModelRoleDefObj> valIter = members.values().iterator();
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
	public void deepDisposeRoleDefByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelRoleDefObj obj = readCachedRoleDefByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeRoleDefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		IBusModelRoleDefObj obj = readCachedRoleDefByUNameIdx( ScopeId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeRoleDefByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		final String S_ProcName = "deepDisposeRoleDefByScopeIdx";
		IBusModelRoleDefObj obj;
		List<IBusModelRoleDefObj> arrayList = readCachedRoleDefByScopeIdx( ScopeId );
		if( arrayList != null )  {
			Iterator<IBusModelRoleDefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeRoleDefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeRoleDefByDefSchemaIdx";
		IBusModelRoleDefObj obj;
		List<IBusModelRoleDefObj> arrayList = readCachedRoleDefByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelRoleDefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeRoleDefByUDefIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		IBusModelRoleDefObj obj = readCachedRoleDefByUDefIdx( ScopeId,
				DefSchemaId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelRoleDefObj updateRoleDef( IBusModelRoleDefObj Obj ) {
		IBusModelRoleDefObj obj = Obj;
		schema.getBusModelBackingStore().getTableRoleDef().updateRoleDef( null,
			Obj.getRoleDefRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getRoleDefTableObj().getClassCode() ) {
			obj = (IBusModelRoleDefObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteRoleDef( IBusModelRoleDefObj Obj ) {
		IBusModelRoleDefObj obj = Obj;
		schema.getBusModelBackingStore().getTableRoleDef().deleteRoleDef( null,
			obj.getRoleDefRec() );
		Obj.forget();
	}

	@Override
	public void deleteRoleDefByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelRoleDefObj obj = readRoleDef(Id);
		if( obj != null ) {
			IBusModelRoleDefEditObj editObj = (IBusModelRoleDefEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelRoleDefEditObj)obj.beginEdit();
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
		deepDisposeRoleDefByIdIdx( Id );
	}

	@Override
	public void deleteRoleDefByUNameIdx( IYCFKeyHash256 ScopeId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelRoleDefByUNameIdxKey,
				IBusModelRoleDefObj >();
		}
		IBusModelRoleDefByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUNameIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setRequiredName( Name );
		IBusModelRoleDefObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableRoleDef().deleteRoleDefByUNameIdx( null,
				ScopeId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableRoleDef().deleteRoleDefByUNameIdx( null,
				ScopeId,
				Name );
		}
		deepDisposeRoleDefByUNameIdx( ScopeId,
				Name );
	}

	@Override
	public void deleteRoleDefByScopeIdx( IYCFKeyHash256 ScopeId )
	{
		IBusModelRoleDefByScopeIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByScopeIdxKey();
		key.setRequiredScopeId( ScopeId );
		if( indexByScopeIdx == null ) {
			indexByScopeIdx = new HashMap< IBusModelRoleDefByScopeIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRoleDefObj > >();
		}
		if( indexByScopeIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj> dict = indexByScopeIdx.get( key );
			schema.getBusModelBackingStore().getTableRoleDef().deleteRoleDefByScopeIdx( null,
				ScopeId );
			Iterator<IBusModelRoleDefObj> iter = dict.values().iterator();
			IBusModelRoleDefObj obj;
			List<IBusModelRoleDefObj> toForget = new LinkedList<IBusModelRoleDefObj>();
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
			schema.getBusModelBackingStore().getTableRoleDef().deleteRoleDefByScopeIdx( null,
				ScopeId );
		}
		deepDisposeRoleDefByScopeIdx( ScopeId );
	}

	@Override
	public void deleteRoleDefByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelRoleDefByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelRoleDefByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelRoleDefObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelRoleDefObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableRoleDef().deleteRoleDefByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelRoleDefObj> iter = dict.values().iterator();
			IBusModelRoleDefObj obj;
			List<IBusModelRoleDefObj> toForget = new LinkedList<IBusModelRoleDefObj>();
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
			schema.getBusModelBackingStore().getTableRoleDef().deleteRoleDefByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeRoleDefByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteRoleDefByUDefIdx( IYCFKeyHash256 ScopeId,
		IYCFKeyHash256 DefSchemaId,
		String Name )
	{
		if( indexByUDefIdx == null ) {
			indexByUDefIdx = new HashMap< IBusModelRoleDefByUDefIdxKey,
				IBusModelRoleDefObj >();
		}
		IBusModelRoleDefByUDefIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryRoleDef().newByUDefIdxKey();
		key.setRequiredScopeId( ScopeId );
		key.setOptionalDefSchemaId( DefSchemaId );
		key.setRequiredName( Name );
		IBusModelRoleDefObj obj = null;
		if( indexByUDefIdx.containsKey( key ) ) {
			obj = indexByUDefIdx.get( key );
			schema.getBusModelBackingStore().getTableRoleDef().deleteRoleDefByUDefIdx( null,
				ScopeId,
				DefSchemaId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableRoleDef().deleteRoleDefByUDefIdx( null,
				ScopeId,
				DefSchemaId,
				Name );
		}
		deepDisposeRoleDefByUDefIdx( ScopeId,
				DefSchemaId,
				Name );
	}
}