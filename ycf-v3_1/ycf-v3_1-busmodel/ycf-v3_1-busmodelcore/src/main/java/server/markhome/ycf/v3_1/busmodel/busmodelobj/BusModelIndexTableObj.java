// Description: Java 25 Table Object implementation for Index.

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

public class BusModelIndexTableObj
	implements IBusModelIndexTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelIndex.CLASS_CODE;
	protected static final int backingClassCode = IBusModelIndex.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> allIndex;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > > indexByTenantIdx;
	private Map< IBusModelIndexByUNameIdxKey,
		IBusModelIndexObj > indexByUNameIdx;
	private Map< IBusModelIndexByIdxTableIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > > indexByIdxTableIdx;
	private Map< IBusModelIndexByIdxCodeVisIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > > indexByIdxCodeVisIdx;
	private Map< IBusModelIndexByIdxTblCdVisXKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > > indexByIdxTblCdVisX;
	private Map< IBusModelIndexByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > > indexByDefSchemaIdx;
	public static String TABLE_NAME = "Index";
	public static String TABLE_DBNAME = "idxdef";

	public BusModelIndexTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexObj>();
		allIndex = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByIdxTableIdx = null;
		indexByIdxCodeVisIdx = null;
		indexByIdxTblCdVisX = null;
		indexByDefSchemaIdx = null;
	}

	public BusModelIndexTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexObj>();
		allIndex = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByIdxTableIdx = null;
		indexByIdxCodeVisIdx = null;
		indexByIdxTblCdVisX = null;
		indexByDefSchemaIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelIndexTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelIndexTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allIndex = null;
		indexByTenantIdx = null;
		indexByUNameIdx = null;
		indexByIdxTableIdx = null;
		indexByIdxCodeVisIdx = null;
		indexByIdxTblCdVisX = null;
		indexByDefSchemaIdx = null;
		List<IBusModelIndexObj> toForget = new LinkedList<IBusModelIndexObj>();
		IBusModelIndexObj cur = null;
		Iterator<IBusModelIndexObj> iter = members.values().iterator();
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
	 *	BusModelIndexObj.
	 */
	@Override
	public IBusModelIndexObj newInstance() {
		IBusModelIndexObj inst = new BusModelIndexObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelIndexObj.
	 */
	@Override
	public IBusModelIndexEditObj newEditInstance( IBusModelIndexObj orig ) {
		IBusModelIndexEditObj edit = new BusModelIndexEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelIndexObj realiseIndex( IBusModelIndexObj Obj ) {
		IBusModelIndexObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelIndexObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelIndexObj existingObj = members.get( pkey );
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
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelIndexByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByIdxTableIdx != null ) {
				IBusModelIndexByIdxTableIdxKey keyIdxTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxTableIdxKey();
				keyIdxTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > mapIdxTableIdx = indexByIdxTableIdx.get( keyIdxTableIdx );
				if( mapIdxTableIdx != null ) {
					mapIdxTableIdx.remove( keepObj.getPKey() );
					if( mapIdxTableIdx.size() <= 0 ) {
						indexByIdxTableIdx.remove( keyIdxTableIdx );
					}
				}
			}

			if( indexByIdxCodeVisIdx != null ) {
				IBusModelIndexByIdxCodeVisIdxKey keyIdxCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxCodeVisIdxKey();
				keyIdxCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > mapIdxCodeVisIdx = indexByIdxCodeVisIdx.get( keyIdxCodeVisIdx );
				if( mapIdxCodeVisIdx != null ) {
					mapIdxCodeVisIdx.remove( keepObj.getPKey() );
					if( mapIdxCodeVisIdx.size() <= 0 ) {
						indexByIdxCodeVisIdx.remove( keyIdxCodeVisIdx );
					}
				}
			}

			if( indexByIdxTblCdVisX != null ) {
				IBusModelIndexByIdxTblCdVisXKey keyIdxTblCdVisX =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxTblCdVisXKey();
				keyIdxTblCdVisX.setRequiredTableId( keepObj.getRequiredTableId() );
				keyIdxTblCdVisX.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > mapIdxTblCdVisX = indexByIdxTblCdVisX.get( keyIdxTblCdVisX );
				if( mapIdxTblCdVisX != null ) {
					mapIdxTblCdVisX.remove( keepObj.getPKey() );
					if( mapIdxTblCdVisX.size() <= 0 ) {
						indexByIdxTblCdVisX.remove( keyIdxTblCdVisX );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelIndexByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelIndexObj)schema.getScopeTableObj().realiseScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelIndexByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByIdxTableIdx != null ) {
				IBusModelIndexByIdxTableIdxKey keyIdxTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxTableIdxKey();
				keyIdxTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > mapIdxTableIdx = indexByIdxTableIdx.get( keyIdxTableIdx );
				if( mapIdxTableIdx != null ) {
					mapIdxTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIdxCodeVisIdx != null ) {
				IBusModelIndexByIdxCodeVisIdxKey keyIdxCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxCodeVisIdxKey();
				keyIdxCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > mapIdxCodeVisIdx = indexByIdxCodeVisIdx.get( keyIdxCodeVisIdx );
				if( mapIdxCodeVisIdx != null ) {
					mapIdxCodeVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIdxTblCdVisX != null ) {
				IBusModelIndexByIdxTblCdVisXKey keyIdxTblCdVisX =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxTblCdVisXKey();
				keyIdxTblCdVisX.setRequiredTableId( keepObj.getRequiredTableId() );
				keyIdxTblCdVisX.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > mapIdxTblCdVisX = indexByIdxTblCdVisX.get( keyIdxTblCdVisX );
				if( mapIdxTblCdVisX != null ) {
					mapIdxTblCdVisX.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelIndexByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allIndex != null ) {
				allIndex.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelIndexObj)schema.getScopeTableObj().realiseScope( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allIndex != null ) {
				allIndex.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelIndexByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByIdxTableIdx != null ) {
				IBusModelIndexByIdxTableIdxKey keyIdxTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxTableIdxKey();
				keyIdxTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > mapIdxTableIdx = indexByIdxTableIdx.get( keyIdxTableIdx );
				if( mapIdxTableIdx != null ) {
					mapIdxTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIdxCodeVisIdx != null ) {
				IBusModelIndexByIdxCodeVisIdxKey keyIdxCodeVisIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxCodeVisIdxKey();
				keyIdxCodeVisIdx.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > mapIdxCodeVisIdx = indexByIdxCodeVisIdx.get( keyIdxCodeVisIdx );
				if( mapIdxCodeVisIdx != null ) {
					mapIdxCodeVisIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByIdxTblCdVisX != null ) {
				IBusModelIndexByIdxTblCdVisXKey keyIdxTblCdVisX =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxTblCdVisXKey();
				keyIdxTblCdVisX.setRequiredTableId( keepObj.getRequiredTableId() );
				keyIdxTblCdVisX.setRequiredCodeVis( keepObj.getRequiredCodeVis() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > mapIdxTblCdVisX = indexByIdxTblCdVisX.get( keyIdxTblCdVisX );
				if( mapIdxTblCdVisX != null ) {
					mapIdxTblCdVisX.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelIndexByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelIndexObj createIndex( IBusModelIndexObj Obj ) {
		IBusModelIndexObj obj = Obj;
		IBusModelIndex rec = obj.getIndexRec();
		schema.getBusModelBackingStore().getTableIndex().createIndex(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelIndexObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelIndexObj readIndex( $implCommaIJavaOptAtomType$ pkey ) {
		return( readIndex( pkey, false ) );
	}

	@Override
	public IBusModelIndexObj readIndex( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelIndexObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelIndex readRec = schema.getBusModelBackingStore().getTableIndex().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelIndexObj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelIndexObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelIndexObj readCachedIndex( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelIndexObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeIndex( IBusModelIndexObj obj )
	{
		final String S_ProcName = "BusModelIndexTableObj.reallyDeepDisposeIndex() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelIndexObj existing = readCachedIndex( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelIndexByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		IBusModelIndexByIdxTableIdxKey keyIdxTableIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxTableIdxKey();
		keyIdxTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		IBusModelIndexByIdxCodeVisIdxKey keyIdxCodeVisIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxCodeVisIdxKey();
		keyIdxCodeVisIdx.setRequiredCodeVis( existing.getRequiredCodeVis() );

		IBusModelIndexByIdxTblCdVisXKey keyIdxTblCdVisX = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxTblCdVisXKey();
		keyIdxTblCdVisX.setRequiredTableId( existing.getRequiredTableId() );
		keyIdxTblCdVisX.setRequiredCodeVis( existing.getRequiredCodeVis() );

		IBusModelIndexByDefSchemaIdxKey keyDefSchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );


		IBusModelIndexColObj objDelIndexRefRelFromCols;
		List<IBusModelIndexColObj> arrDelIndexRefRelFromCols = schema.getIndexColTableObj().readCachedIndexColByIndexIdx( existing.getRequiredId() );
		Iterator<IBusModelIndexColObj> iterDelIndexRefRelFromCols = arrDelIndexRefRelFromCols.iterator();
		while( iterDelIndexRefRelFromCols.hasNext() ) {
			objDelIndexRefRelFromCols = iterDelIndexRefRelFromCols.next();
			if( objDelIndexRefRelFromCols != null ) {
						schema.getRelationColTableObj().deepDisposeRelationColByFromColIdx( objDelIndexRefRelFromCols.getRequiredId() );
			}
		}
		IBusModelIndexColObj objDelIndexRefRelToCols;
		List<IBusModelIndexColObj> arrDelIndexRefRelToCols = schema.getIndexColTableObj().readCachedIndexColByIndexIdx( existing.getRequiredId() );
		Iterator<IBusModelIndexColObj> iterDelIndexRefRelToCols = arrDelIndexRefRelToCols.iterator();
		while( iterDelIndexRefRelToCols.hasNext() ) {
			objDelIndexRefRelToCols = iterDelIndexRefRelToCols.next();
			if( objDelIndexRefRelToCols != null ) {
						schema.getRelationColTableObj().deepDisposeRelationColByToColIdx( objDelIndexRefRelToCols.getRequiredId() );
			}
		}
					schema.getIndexColTableObj().deepDisposeIndexColByIndexIdx( existing.getRequiredId() );

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}

		if( indexByIdxTableIdx != null ) {
			if( indexByIdxTableIdx.containsKey( keyIdxTableIdx ) ) {
				indexByIdxTableIdx.get( keyIdxTableIdx ).remove( pkey );
				if( indexByIdxTableIdx.get( keyIdxTableIdx ).size() <= 0 ) {
					indexByIdxTableIdx.remove( keyIdxTableIdx );
				}
			}
		}

		if( indexByIdxCodeVisIdx != null ) {
			if( indexByIdxCodeVisIdx.containsKey( keyIdxCodeVisIdx ) ) {
				indexByIdxCodeVisIdx.get( keyIdxCodeVisIdx ).remove( pkey );
				if( indexByIdxCodeVisIdx.get( keyIdxCodeVisIdx ).size() <= 0 ) {
					indexByIdxCodeVisIdx.remove( keyIdxCodeVisIdx );
				}
			}
		}

		if( indexByIdxTblCdVisX != null ) {
			if( indexByIdxTblCdVisX.containsKey( keyIdxTblCdVisX ) ) {
				indexByIdxTblCdVisX.get( keyIdxTblCdVisX ).remove( pkey );
				if( indexByIdxTblCdVisX.get( keyIdxTblCdVisX ).size() <= 0 ) {
					indexByIdxTblCdVisX.remove( keyIdxTblCdVisX );
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


		schema.getScopeTableObj().reallyDeepDisposeScope( obj );
	}
	@Override
	public void deepDisposeIndex( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelIndexObj obj = readCachedIndex( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelIndexObj lockIndex( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelIndexObj locked = null;
		IBusModelIndex lockRec = schema.getBusModelBackingStore().getTableIndex().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelIndexObj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelIndexObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockIndex", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelIndexObj> readAllIndex() {
		return( readAllIndex( false ) );
	}

	@Override
	public List<IBusModelIndexObj> readAllIndex( boolean forceRead ) {
		final String S_ProcName = "readAllIndex";
		if( ( allIndex == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelIndexObj>();
			allIndex = map;
			IBusModelIndex[] recList = schema.getBusModelBackingStore().getTableIndex().readAllDerived( null );
			IBusModelIndex rec;
			IBusModelIndexObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelIndexObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexObj realised = (IBusModelIndexObj)obj.realise();
			}
		}
		int len = allIndex.size();
		IBusModelIndexObj arr[] = new IBusModelIndexObj[len];
		Iterator<IBusModelIndexObj> valIter = allIndex.values().iterator();
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
		ArrayList<IBusModelIndexObj> arrayList = new ArrayList<IBusModelIndexObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexObj> cmp = new Comparator<IBusModelIndexObj>() {
			@Override
			public int compare( IBusModelIndexObj lhs, IBusModelIndexObj rhs ) {
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
		List<IBusModelIndexObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelIndexObj> readCachedAllIndex() {
		final String S_ProcName = "readCachedAllIndex";
		ArrayList<IBusModelIndexObj> arrayList = new ArrayList<IBusModelIndexObj>();
		if( allIndex != null ) {
			int len = allIndex.size();
			IBusModelIndexObj arr[] = new IBusModelIndexObj[len];
			Iterator<IBusModelIndexObj> valIter = allIndex.values().iterator();
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
		Comparator<IBusModelIndexObj> cmp = new Comparator<IBusModelIndexObj>() {
			public int compare( IBusModelIndexObj lhs, IBusModelIndexObj rhs ) {
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
	public IBusModelIndexObj readIndexByIdIdx( IYCFKeyHash256 Id )
	{
		return( readIndexByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelIndexObj readIndexByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelIndexObj obj = readIndex( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelIndexObj> readIndexByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readIndexByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelIndexObj> readIndexByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexObj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelIndexObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexObj realised = (IBusModelIndexObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelIndexObj arr[] = new IBusModelIndexObj[len];
		Iterator<IBusModelIndexObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelIndexObj> arrayList = new ArrayList<IBusModelIndexObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexObj> cmp = new Comparator<IBusModelIndexObj>() {
			@Override
			public int compare( IBusModelIndexObj lhs, IBusModelIndexObj rhs ) {
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
		List<IBusModelIndexObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelIndexObj readIndexByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		return( readIndexByUNameIdx( TableId,
			Name,
			false ) );
	}

	@Override
	public IBusModelIndexObj readIndexByUNameIdx( IYCFKeyHash256 TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelIndexByUNameIdxKey,
				IBusModelIndexObj >();
		}
		IBusModelIndexByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelIndexObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelIndex rec = schema.getBusModelBackingStore().getTableIndex().readDerivedByUNameIdx( null,
				TableId,
				Name );
			if( rec != null ) {
				obj = (IBusModelIndexObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelIndexObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelIndexObj> readIndexByIdxTableIdx( IYCFKeyHash256 TableId )
	{
		return( readIndexByIdxTableIdx( TableId,
			false ) );
	}

	@Override
	public List<IBusModelIndexObj> readIndexByIdxTableIdx( IYCFKeyHash256 TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexByIdxTableIdx";
		IBusModelIndexByIdxTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxTableIdxKey();
		key.setRequiredTableId( TableId );
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> dict;
		if( indexByIdxTableIdx == null ) {
			indexByIdxTableIdx = new HashMap< IBusModelIndexByIdxTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexObj > >();
		}
		if( ( ! forceRead ) && indexByIdxTableIdx.containsKey( key ) ) {
			dict = indexByIdxTableIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexObj>();
			IBusModelIndexObj obj;
			IBusModelIndex[] recList = schema.getBusModelBackingStore().getTableIndex().readDerivedByIdxTableIdx( null,
				TableId );
			IBusModelIndex rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelIndexObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexObj realised = (IBusModelIndexObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByIdxTableIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelIndexObj arr[] = new IBusModelIndexObj[len];
		Iterator<IBusModelIndexObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelIndexObj> arrayList = new ArrayList<IBusModelIndexObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexObj> cmp = new Comparator<IBusModelIndexObj>() {
			@Override
			public int compare( IBusModelIndexObj lhs, IBusModelIndexObj rhs ) {
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
		List<IBusModelIndexObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelIndexObj> readIndexByIdxCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		return( readIndexByIdxCodeVisIdx( CodeVis,
			false ) );
	}

	@Override
	public List<IBusModelIndexObj> readIndexByIdxCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexByIdxCodeVisIdx";
		IBusModelIndexByIdxCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> dict;
		if( indexByIdxCodeVisIdx == null ) {
			indexByIdxCodeVisIdx = new HashMap< IBusModelIndexByIdxCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexObj > >();
		}
		if( ( ! forceRead ) && indexByIdxCodeVisIdx.containsKey( key ) ) {
			dict = indexByIdxCodeVisIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexObj>();
			IBusModelIndexObj obj;
			IBusModelIndex[] recList = schema.getBusModelBackingStore().getTableIndex().readDerivedByIdxCodeVisIdx( null,
				CodeVis );
			IBusModelIndex rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelIndexObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexObj realised = (IBusModelIndexObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByIdxCodeVisIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelIndexObj arr[] = new IBusModelIndexObj[len];
		Iterator<IBusModelIndexObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelIndexObj> arrayList = new ArrayList<IBusModelIndexObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexObj> cmp = new Comparator<IBusModelIndexObj>() {
			@Override
			public int compare( IBusModelIndexObj lhs, IBusModelIndexObj rhs ) {
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
		List<IBusModelIndexObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelIndexObj> readIndexByIdxTblCdVisX( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		return( readIndexByIdxTblCdVisX( TableId,
			CodeVis,
			false ) );
	}

	@Override
	public List<IBusModelIndexObj> readIndexByIdxTblCdVisX( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexByIdxTblCdVisX";
		IBusModelIndexByIdxTblCdVisXKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxTblCdVisXKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> dict;
		if( indexByIdxTblCdVisX == null ) {
			indexByIdxTblCdVisX = new HashMap< IBusModelIndexByIdxTblCdVisXKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexObj > >();
		}
		if( ( ! forceRead ) && indexByIdxTblCdVisX.containsKey( key ) ) {
			dict = indexByIdxTblCdVisX.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexObj>();
			IBusModelIndexObj obj;
			IBusModelIndex[] recList = schema.getBusModelBackingStore().getTableIndex().readDerivedByIdxTblCdVisX( null,
				TableId,
				CodeVis );
			IBusModelIndex rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelIndexObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexObj realised = (IBusModelIndexObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByIdxTblCdVisX.put( key, dict );
		}
		int len = dict.size();
		IBusModelIndexObj arr[] = new IBusModelIndexObj[len];
		Iterator<IBusModelIndexObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelIndexObj> arrayList = new ArrayList<IBusModelIndexObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexObj> cmp = new Comparator<IBusModelIndexObj>() {
			@Override
			public int compare( IBusModelIndexObj lhs, IBusModelIndexObj rhs ) {
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
		List<IBusModelIndexObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelIndexObj> readIndexByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readIndexByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelIndexObj> readIndexByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readIndexByDefSchemaIdx";
		IBusModelIndexByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelIndexByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelIndexObj>();
			IBusModelIndexObj obj;
			IBusModelIndex[] recList = schema.getBusModelBackingStore().getTableIndex().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelIndex rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelIndexObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelIndexObj realised = (IBusModelIndexObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelIndexObj arr[] = new IBusModelIndexObj[len];
		Iterator<IBusModelIndexObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelIndexObj> arrayList = new ArrayList<IBusModelIndexObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelIndexObj> cmp = new Comparator<IBusModelIndexObj>() {
			@Override
			public int compare( IBusModelIndexObj lhs, IBusModelIndexObj rhs ) {
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
		List<IBusModelIndexObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelIndexObj readCachedIndexByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelIndexObj obj = null;
		obj = readCachedIndex( Id );
		return( obj );
	}

	@Override
	public List<IBusModelIndexObj> readCachedIndexByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedIndexByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelIndexObj> arrayList = new ArrayList<IBusModelIndexObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelIndexObj arr[] = new IBusModelIndexObj[len];
				Iterator<IBusModelIndexObj> valIter = dict.values().iterator();
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
			IBusModelIndexObj obj;
			Iterator<IBusModelIndexObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelIndexObj> cmp = new Comparator<IBusModelIndexObj>() {
			@Override
			public int compare( IBusModelIndexObj lhs, IBusModelIndexObj rhs ) {
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
	public IBusModelIndexObj readCachedIndexByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelIndexObj obj = null;
		IBusModelIndexByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelIndexObj> valIter = members.values().iterator();
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
			Iterator<IBusModelIndexObj> valIter = members.values().iterator();
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
	public List<IBusModelIndexObj> readCachedIndexByIdxTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "readCachedIndexByIdxTableIdx";
		IBusModelIndexByIdxTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxTableIdxKey();
		key.setRequiredTableId( TableId );
		ArrayList<IBusModelIndexObj> arrayList = new ArrayList<IBusModelIndexObj>();
		if( indexByIdxTableIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> dict;
			if( indexByIdxTableIdx.containsKey( key ) ) {
				dict = indexByIdxTableIdx.get( key );
				int len = dict.size();
				IBusModelIndexObj arr[] = new IBusModelIndexObj[len];
				Iterator<IBusModelIndexObj> valIter = dict.values().iterator();
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
			IBusModelIndexObj obj;
			Iterator<IBusModelIndexObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelIndexObj> cmp = new Comparator<IBusModelIndexObj>() {
			@Override
			public int compare( IBusModelIndexObj lhs, IBusModelIndexObj rhs ) {
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
	public List<IBusModelIndexObj> readCachedIndexByIdxCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "readCachedIndexByIdxCodeVisIdx";
		IBusModelIndexByIdxCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		ArrayList<IBusModelIndexObj> arrayList = new ArrayList<IBusModelIndexObj>();
		if( indexByIdxCodeVisIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> dict;
			if( indexByIdxCodeVisIdx.containsKey( key ) ) {
				dict = indexByIdxCodeVisIdx.get( key );
				int len = dict.size();
				IBusModelIndexObj arr[] = new IBusModelIndexObj[len];
				Iterator<IBusModelIndexObj> valIter = dict.values().iterator();
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
			IBusModelIndexObj obj;
			Iterator<IBusModelIndexObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelIndexObj> cmp = new Comparator<IBusModelIndexObj>() {
			@Override
			public int compare( IBusModelIndexObj lhs, IBusModelIndexObj rhs ) {
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
	public List<IBusModelIndexObj> readCachedIndexByIdxTblCdVisX( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "readCachedIndexByIdxTblCdVisX";
		IBusModelIndexByIdxTblCdVisXKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxTblCdVisXKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		ArrayList<IBusModelIndexObj> arrayList = new ArrayList<IBusModelIndexObj>();
		if( indexByIdxTblCdVisX != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> dict;
			if( indexByIdxTblCdVisX.containsKey( key ) ) {
				dict = indexByIdxTblCdVisX.get( key );
				int len = dict.size();
				IBusModelIndexObj arr[] = new IBusModelIndexObj[len];
				Iterator<IBusModelIndexObj> valIter = dict.values().iterator();
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
			IBusModelIndexObj obj;
			Iterator<IBusModelIndexObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelIndexObj> cmp = new Comparator<IBusModelIndexObj>() {
			@Override
			public int compare( IBusModelIndexObj lhs, IBusModelIndexObj rhs ) {
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
	public List<IBusModelIndexObj> readCachedIndexByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedIndexByDefSchemaIdx";
		IBusModelIndexByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelIndexObj> arrayList = new ArrayList<IBusModelIndexObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelIndexObj arr[] = new IBusModelIndexObj[len];
				Iterator<IBusModelIndexObj> valIter = dict.values().iterator();
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
			IBusModelIndexObj obj;
			Iterator<IBusModelIndexObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelIndexObj> cmp = new Comparator<IBusModelIndexObj>() {
			@Override
			public int compare( IBusModelIndexObj lhs, IBusModelIndexObj rhs ) {
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
	public void deepDisposeIndexByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelIndexObj obj = readCachedIndexByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeIndexByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeIndexByTenantIdx";
		IBusModelIndexObj obj;
		List<IBusModelIndexObj> arrayList = readCachedIndexByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelIndexObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeIndexByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelIndexObj obj = readCachedIndexByUNameIdx( TableId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeIndexByIdxTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "deepDisposeIndexByIdxTableIdx";
		IBusModelIndexObj obj;
		List<IBusModelIndexObj> arrayList = readCachedIndexByIdxTableIdx( TableId );
		if( arrayList != null )  {
			Iterator<IBusModelIndexObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeIndexByIdxCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "deepDisposeIndexByIdxCodeVisIdx";
		IBusModelIndexObj obj;
		List<IBusModelIndexObj> arrayList = readCachedIndexByIdxCodeVisIdx( CodeVis );
		if( arrayList != null )  {
			Iterator<IBusModelIndexObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeIndexByIdxTblCdVisX( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		final String S_ProcName = "deepDisposeIndexByIdxTblCdVisX";
		IBusModelIndexObj obj;
		List<IBusModelIndexObj> arrayList = readCachedIndexByIdxTblCdVisX( TableId,
				CodeVis );
		if( arrayList != null )  {
			Iterator<IBusModelIndexObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeIndexByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeIndexByDefSchemaIdx";
		IBusModelIndexObj obj;
		List<IBusModelIndexObj> arrayList = readCachedIndexByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelIndexObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelIndexObj updateIndex( IBusModelIndexObj Obj ) {
		IBusModelIndexObj obj = Obj;
		schema.getBusModelBackingStore().getTableIndex().updateIndex( null,
			Obj.getIndexRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getIndexTableObj().getClassCode() ) {
			obj = (IBusModelIndexObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteIndex( IBusModelIndexObj Obj ) {
		IBusModelIndexObj obj = Obj;
		schema.getBusModelBackingStore().getTableIndex().deleteIndex( null,
			obj.getIndexRec() );
		Obj.forget();
	}

	@Override
	public void deleteIndexByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelIndexObj obj = readIndex(Id);
		if( obj != null ) {
			IBusModelIndexEditObj editObj = (IBusModelIndexEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelIndexEditObj)obj.beginEdit();
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
		deepDisposeIndexByIdIdx( Id );
	}

	@Override
	public void deleteIndexByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableIndex().deleteIndexByTenantIdx( null,
				TenantId );
			Iterator<IBusModelIndexObj> iter = dict.values().iterator();
			IBusModelIndexObj obj;
			List<IBusModelIndexObj> toForget = new LinkedList<IBusModelIndexObj>();
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
			schema.getBusModelBackingStore().getTableIndex().deleteIndexByTenantIdx( null,
				TenantId );
		}
		deepDisposeIndexByTenantIdx( TenantId );
	}

	@Override
	public void deleteIndexByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelIndexByUNameIdxKey,
				IBusModelIndexObj >();
		}
		IBusModelIndexByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelIndexObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableIndex().deleteIndexByUNameIdx( null,
				TableId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableIndex().deleteIndexByUNameIdx( null,
				TableId,
				Name );
		}
		deepDisposeIndexByUNameIdx( TableId,
				Name );
	}

	@Override
	public void deleteIndexByIdxTableIdx( IYCFKeyHash256 TableId )
	{
		IBusModelIndexByIdxTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxTableIdxKey();
		key.setRequiredTableId( TableId );
		if( indexByIdxTableIdx == null ) {
			indexByIdxTableIdx = new HashMap< IBusModelIndexByIdxTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexObj > >();
		}
		if( indexByIdxTableIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> dict = indexByIdxTableIdx.get( key );
			schema.getBusModelBackingStore().getTableIndex().deleteIndexByIdxTableIdx( null,
				TableId );
			Iterator<IBusModelIndexObj> iter = dict.values().iterator();
			IBusModelIndexObj obj;
			List<IBusModelIndexObj> toForget = new LinkedList<IBusModelIndexObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByIdxTableIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableIndex().deleteIndexByIdxTableIdx( null,
				TableId );
		}
		deepDisposeIndexByIdxTableIdx( TableId );
	}

	@Override
	public void deleteIndexByIdxCodeVisIdx( IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		IBusModelIndexByIdxCodeVisIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxCodeVisIdxKey();
		key.setRequiredCodeVis( CodeVis );
		if( indexByIdxCodeVisIdx == null ) {
			indexByIdxCodeVisIdx = new HashMap< IBusModelIndexByIdxCodeVisIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexObj > >();
		}
		if( indexByIdxCodeVisIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> dict = indexByIdxCodeVisIdx.get( key );
			schema.getBusModelBackingStore().getTableIndex().deleteIndexByIdxCodeVisIdx( null,
				CodeVis );
			Iterator<IBusModelIndexObj> iter = dict.values().iterator();
			IBusModelIndexObj obj;
			List<IBusModelIndexObj> toForget = new LinkedList<IBusModelIndexObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByIdxCodeVisIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableIndex().deleteIndexByIdxCodeVisIdx( null,
				CodeVis );
		}
		deepDisposeIndexByIdxCodeVisIdx( CodeVis );
	}

	@Override
	public void deleteIndexByIdxTblCdVisX( IYCFKeyHash256 TableId,
		IBusModelPubSchema.CodeVisibilityEnum CodeVis )
	{
		IBusModelIndexByIdxTblCdVisXKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByIdxTblCdVisXKey();
		key.setRequiredTableId( TableId );
		key.setRequiredCodeVis( CodeVis );
		if( indexByIdxTblCdVisX == null ) {
			indexByIdxTblCdVisX = new HashMap< IBusModelIndexByIdxTblCdVisXKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexObj > >();
		}
		if( indexByIdxTblCdVisX.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> dict = indexByIdxTblCdVisX.get( key );
			schema.getBusModelBackingStore().getTableIndex().deleteIndexByIdxTblCdVisX( null,
				TableId,
				CodeVis );
			Iterator<IBusModelIndexObj> iter = dict.values().iterator();
			IBusModelIndexObj obj;
			List<IBusModelIndexObj> toForget = new LinkedList<IBusModelIndexObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByIdxTblCdVisX.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableIndex().deleteIndexByIdxTblCdVisX( null,
				TableId,
				CodeVis );
		}
		deepDisposeIndexByIdxTblCdVisX( TableId,
				CodeVis );
	}

	@Override
	public void deleteIndexByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelIndexByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelIndexByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelIndexObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelIndexObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableIndex().deleteIndexByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelIndexObj> iter = dict.values().iterator();
			IBusModelIndexObj obj;
			List<IBusModelIndexObj> toForget = new LinkedList<IBusModelIndexObj>();
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
			schema.getBusModelBackingStore().getTableIndex().deleteIndexByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeIndexByDefSchemaIdx( DefSchemaId );
	}
}