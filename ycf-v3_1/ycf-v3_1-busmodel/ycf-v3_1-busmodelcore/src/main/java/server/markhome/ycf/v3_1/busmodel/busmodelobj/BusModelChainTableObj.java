// Description: Java 25 Table Object implementation for Chain.

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

public class BusModelChainTableObj
	implements IBusModelChainTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelChain.CLASS_CODE;
	protected static final int backingClassCode = IBusModelChain.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelChainObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelChainObj> allChain;
	private Map< IBusModelChainByChainTableIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelChainObj > > indexByChainTableIdx;
	private Map< IBusModelChainByDefSchemaIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelChainObj > > indexByDefSchemaIdx;
	private Map< IBusModelChainByUNameIdxKey,
		IBusModelChainObj > indexByUNameIdx;
	private Map< IBusModelChainByPrevRelIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelChainObj > > indexByPrevRelIdx;
	private Map< IBusModelChainByNextRelIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelChainObj > > indexByNextRelIdx;
	public static String TABLE_NAME = "Chain";
	public static String TABLE_DBNAME = "chain_def";

	public BusModelChainTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelChainObj>();
		allChain = null;
		indexByChainTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexByPrevRelIdx = null;
		indexByNextRelIdx = null;
	}

	public BusModelChainTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelChainObj>();
		allChain = null;
		indexByChainTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexByPrevRelIdx = null;
		indexByNextRelIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelChainTableObj.getRuntimeClassCode();
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
			throw new YCFArgumentUnderflowException(BusModelChainTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
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
		allChain = null;
		indexByChainTableIdx = null;
		indexByDefSchemaIdx = null;
		indexByUNameIdx = null;
		indexByPrevRelIdx = null;
		indexByNextRelIdx = null;
		List<IBusModelChainObj> toForget = new LinkedList<IBusModelChainObj>();
		IBusModelChainObj cur = null;
		Iterator<IBusModelChainObj> iter = members.values().iterator();
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
	 *	BusModelChainObj.
	 */
	@Override
	public IBusModelChainObj newInstance() {
		IBusModelChainObj inst = new BusModelChainObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelChainObj.
	 */
	@Override
	public IBusModelChainEditObj newEditInstance( IBusModelChainObj orig ) {
		IBusModelChainEditObj edit = new BusModelChainEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelChainObj constructByClassCode( int backingClassCode ) {
		IBusModelChainObj obj = null;
		if( backingClassCode == IBusModelChain.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getChainTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public IBusModelChainObj realiseChain( IBusModelChainObj Obj ) {
		IBusModelChainObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelChainObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelChainObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByChainTableIdx != null ) {
				IBusModelChainByChainTableIdxKey keyChainTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByChainTableIdxKey();
				keyChainTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelChainObj > mapChainTableIdx = indexByChainTableIdx.get( keyChainTableIdx );
				if( mapChainTableIdx != null ) {
					mapChainTableIdx.remove( keepObj.getPKey() );
					if( mapChainTableIdx.size() <= 0 ) {
						indexByChainTableIdx.remove( keyChainTableIdx );
					}
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelChainByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelChainObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.remove( keepObj.getPKey() );
					if( mapDefSchemaIdx.size() <= 0 ) {
						indexByDefSchemaIdx.remove( keyDefSchemaIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelChainByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByPrevRelIdx != null ) {
				IBusModelChainByPrevRelIdxKey keyPrevRelIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByPrevRelIdxKey();
				keyPrevRelIdx.setRequiredPrevRelationId( keepObj.getRequiredPrevRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelChainObj > mapPrevRelIdx = indexByPrevRelIdx.get( keyPrevRelIdx );
				if( mapPrevRelIdx != null ) {
					mapPrevRelIdx.remove( keepObj.getPKey() );
					if( mapPrevRelIdx.size() <= 0 ) {
						indexByPrevRelIdx.remove( keyPrevRelIdx );
					}
				}
			}

			if( indexByNextRelIdx != null ) {
				IBusModelChainByNextRelIdxKey keyNextRelIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByNextRelIdxKey();
				keyNextRelIdx.setRequiredNextRelationId( keepObj.getRequiredNextRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelChainObj > mapNextRelIdx = indexByNextRelIdx.get( keyNextRelIdx );
				if( mapNextRelIdx != null ) {
					mapNextRelIdx.remove( keepObj.getPKey() );
					if( mapNextRelIdx.size() <= 0 ) {
						indexByNextRelIdx.remove( keyNextRelIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByChainTableIdx != null ) {
				IBusModelChainByChainTableIdxKey keyChainTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByChainTableIdxKey();
				keyChainTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelChainObj > mapChainTableIdx = indexByChainTableIdx.get( keyChainTableIdx );
				if( mapChainTableIdx != null ) {
					mapChainTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelChainByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelChainObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelChainByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByPrevRelIdx != null ) {
				IBusModelChainByPrevRelIdxKey keyPrevRelIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByPrevRelIdxKey();
				keyPrevRelIdx.setRequiredPrevRelationId( keepObj.getRequiredPrevRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelChainObj > mapPrevRelIdx = indexByPrevRelIdx.get( keyPrevRelIdx );
				if( mapPrevRelIdx != null ) {
					mapPrevRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextRelIdx != null ) {
				IBusModelChainByNextRelIdxKey keyNextRelIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByNextRelIdxKey();
				keyNextRelIdx.setRequiredNextRelationId( keepObj.getRequiredNextRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelChainObj > mapNextRelIdx = indexByNextRelIdx.get( keyNextRelIdx );
				if( mapNextRelIdx != null ) {
					mapNextRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allChain != null ) {
				allChain.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allChain != null ) {
				allChain.put( keepObj.getPKey(), keepObj );
			}

			if( indexByChainTableIdx != null ) {
				IBusModelChainByChainTableIdxKey keyChainTableIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByChainTableIdxKey();
				keyChainTableIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelChainObj > mapChainTableIdx = indexByChainTableIdx.get( keyChainTableIdx );
				if( mapChainTableIdx != null ) {
					mapChainTableIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDefSchemaIdx != null ) {
				IBusModelChainByDefSchemaIdxKey keyDefSchemaIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByDefSchemaIdxKey();
				keyDefSchemaIdx.setOptionalDefSchemaId( keepObj.getOptionalDefSchemaId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelChainObj > mapDefSchemaIdx = indexByDefSchemaIdx.get( keyDefSchemaIdx );
				if( mapDefSchemaIdx != null ) {
					mapDefSchemaIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelChainByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByUNameIdxKey();
				keyUNameIdx.setRequiredTableId( keepObj.getRequiredTableId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByPrevRelIdx != null ) {
				IBusModelChainByPrevRelIdxKey keyPrevRelIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByPrevRelIdxKey();
				keyPrevRelIdx.setRequiredPrevRelationId( keepObj.getRequiredPrevRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelChainObj > mapPrevRelIdx = indexByPrevRelIdx.get( keyPrevRelIdx );
				if( mapPrevRelIdx != null ) {
					mapPrevRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNextRelIdx != null ) {
				IBusModelChainByNextRelIdxKey keyNextRelIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByNextRelIdxKey();
				keyNextRelIdx.setRequiredNextRelationId( keepObj.getRequiredNextRelationId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelChainObj > mapNextRelIdx = indexByNextRelIdx.get( keyNextRelIdx );
				if( mapNextRelIdx != null ) {
					mapNextRelIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelChainObj createChain( IBusModelChainObj Obj ) {
		IBusModelChainObj obj = Obj;
		IBusModelChain rec = obj.getChainRec();
		schema.getBusModelBackingStore().getTableChain().createChain(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelChainObj readChain( $implCommaIJavaOptAtomType$ pkey ) {
		return( readChain( pkey, false ) );
	}

	@Override
	public IBusModelChainObj readChain( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelChainObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelChain readRec = schema.getBusModelBackingStore().getTableChain().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelChainObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelChainObj readCachedChain( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelChainObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeChain( IBusModelChainObj obj )
	{
		final String S_ProcName = "BusModelChainTableObj.reallyDeepDisposeChain() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelChainObj existing = readCachedChain( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelChainByChainTableIdxKey keyChainTableIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByChainTableIdxKey();
		keyChainTableIdx.setRequiredTableId( existing.getRequiredTableId() );

		IBusModelChainByDefSchemaIdxKey keyDefSchemaIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByDefSchemaIdxKey();
		keyDefSchemaIdx.setOptionalDefSchemaId( existing.getOptionalDefSchemaId() );

		IBusModelChainByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByUNameIdxKey();
		keyUNameIdx.setRequiredTableId( existing.getRequiredTableId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		IBusModelChainByPrevRelIdxKey keyPrevRelIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByPrevRelIdxKey();
		keyPrevRelIdx.setRequiredPrevRelationId( existing.getRequiredPrevRelationId() );

		IBusModelChainByNextRelIdxKey keyNextRelIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByNextRelIdxKey();
		keyNextRelIdx.setRequiredNextRelationId( existing.getRequiredNextRelationId() );



		if( indexByChainTableIdx != null ) {
			if( indexByChainTableIdx.containsKey( keyChainTableIdx ) ) {
				indexByChainTableIdx.get( keyChainTableIdx ).remove( pkey );
				if( indexByChainTableIdx.get( keyChainTableIdx ).size() <= 0 ) {
					indexByChainTableIdx.remove( keyChainTableIdx );
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

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}

		if( indexByPrevRelIdx != null ) {
			if( indexByPrevRelIdx.containsKey( keyPrevRelIdx ) ) {
				indexByPrevRelIdx.get( keyPrevRelIdx ).remove( pkey );
				if( indexByPrevRelIdx.get( keyPrevRelIdx ).size() <= 0 ) {
					indexByPrevRelIdx.remove( keyPrevRelIdx );
				}
			}
		}

		if( indexByNextRelIdx != null ) {
			if( indexByNextRelIdx.containsKey( keyNextRelIdx ) ) {
				indexByNextRelIdx.get( keyNextRelIdx ).remove( pkey );
				if( indexByNextRelIdx.get( keyNextRelIdx ).size() <= 0 ) {
					indexByNextRelIdx.remove( keyNextRelIdx );
				}
			}
		}


	}
	@Override
	public void deepDisposeChain( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelChainObj obj = readCachedChain( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelChainObj lockChain( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelChainObj locked = null;
		IBusModelChain lockRec = schema.getBusModelBackingStore().getTableChain().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getChainTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelChainObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockChain", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelChainObj> readAllChain() {
		return( readAllChain( false ) );
	}

	@Override
	public List<IBusModelChainObj> readAllChain( boolean forceRead ) {
		final String S_ProcName = "readAllChain";
		if( ( allChain == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelChainObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelChainObj>();
			allChain = map;
			IBusModelChain[] recList = schema.getBusModelBackingStore().getTableChain().readAllDerived( null );
			IBusModelChain rec;
			IBusModelChainObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelChainObj realised = (IBusModelChainObj)obj.realise();
			}
		}
		int len = allChain.size();
		IBusModelChainObj arr[] = new IBusModelChainObj[len];
		Iterator<IBusModelChainObj> valIter = allChain.values().iterator();
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
		ArrayList<IBusModelChainObj> arrayList = new ArrayList<IBusModelChainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelChainObj> cmp = new Comparator<IBusModelChainObj>() {
			@Override
			public int compare( IBusModelChainObj lhs, IBusModelChainObj rhs ) {
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
		List<IBusModelChainObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelChainObj> readCachedAllChain() {
		final String S_ProcName = "readCachedAllChain";
		ArrayList<IBusModelChainObj> arrayList = new ArrayList<IBusModelChainObj>();
		if( allChain != null ) {
			int len = allChain.size();
			IBusModelChainObj arr[] = new IBusModelChainObj[len];
			Iterator<IBusModelChainObj> valIter = allChain.values().iterator();
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
		Comparator<IBusModelChainObj> cmp = new Comparator<IBusModelChainObj>() {
			public int compare( IBusModelChainObj lhs, IBusModelChainObj rhs ) {
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
	public IBusModelChainObj readChainByIdIdx( IYCFKeyHash256 Id )
	{
		return( readChainByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelChainObj readChainByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelChainObj obj = readChain( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelChainObj> readChainByChainTableIdx( IYCFKeyHash256 TableId )
	{
		return( readChainByChainTableIdx( TableId,
			false ) );
	}

	@Override
	public List<IBusModelChainObj> readChainByChainTableIdx( IYCFKeyHash256 TableId,
		boolean forceRead )
	{
		final String S_ProcName = "readChainByChainTableIdx";
		IBusModelChainByChainTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByChainTableIdxKey();
		key.setRequiredTableId( TableId );
		Map<$implCommaIJavaOptAtomType$, IBusModelChainObj> dict;
		if( indexByChainTableIdx == null ) {
			indexByChainTableIdx = new HashMap< IBusModelChainByChainTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelChainObj > >();
		}
		if( ( ! forceRead ) && indexByChainTableIdx.containsKey( key ) ) {
			dict = indexByChainTableIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelChainObj>();
			IBusModelChainObj obj;
			IBusModelChain[] recList = schema.getBusModelBackingStore().getTableChain().readDerivedByChainTableIdx( null,
				TableId );
			IBusModelChain rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelChainObj realised = (IBusModelChainObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByChainTableIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelChainObj arr[] = new IBusModelChainObj[len];
		Iterator<IBusModelChainObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelChainObj> arrayList = new ArrayList<IBusModelChainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelChainObj> cmp = new Comparator<IBusModelChainObj>() {
			@Override
			public int compare( IBusModelChainObj lhs, IBusModelChainObj rhs ) {
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
		List<IBusModelChainObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelChainObj> readChainByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		return( readChainByDefSchemaIdx( DefSchemaId,
			false ) );
	}

	@Override
	public List<IBusModelChainObj> readChainByDefSchemaIdx( IYCFKeyHash256 DefSchemaId,
		boolean forceRead )
	{
		final String S_ProcName = "readChainByDefSchemaIdx";
		IBusModelChainByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		Map<$implCommaIJavaOptAtomType$, IBusModelChainObj> dict;
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelChainByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelChainObj > >();
		}
		if( ( ! forceRead ) && indexByDefSchemaIdx.containsKey( key ) ) {
			dict = indexByDefSchemaIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelChainObj>();
			IBusModelChainObj obj;
			IBusModelChain[] recList = schema.getBusModelBackingStore().getTableChain().readDerivedByDefSchemaIdx( null,
				DefSchemaId );
			IBusModelChain rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelChainObj realised = (IBusModelChainObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDefSchemaIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelChainObj arr[] = new IBusModelChainObj[len];
		Iterator<IBusModelChainObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelChainObj> arrayList = new ArrayList<IBusModelChainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelChainObj> cmp = new Comparator<IBusModelChainObj>() {
			@Override
			public int compare( IBusModelChainObj lhs, IBusModelChainObj rhs ) {
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
		List<IBusModelChainObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelChainObj readChainByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		return( readChainByUNameIdx( TableId,
			Name,
			false ) );
	}

	@Override
	public IBusModelChainObj readChainByUNameIdx( IYCFKeyHash256 TableId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelChainByUNameIdxKey,
				IBusModelChainObj >();
		}
		IBusModelChainByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelChainObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelChain rec = schema.getBusModelBackingStore().getTableChain().readDerivedByUNameIdx( null,
				TableId,
				Name );
			if( rec != null ) {
				obj = schema.getChainTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelChainObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelChainObj> readChainByPrevRelIdx( IYCFKeyHash256 PrevRelationId )
	{
		return( readChainByPrevRelIdx( PrevRelationId,
			false ) );
	}

	@Override
	public List<IBusModelChainObj> readChainByPrevRelIdx( IYCFKeyHash256 PrevRelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readChainByPrevRelIdx";
		IBusModelChainByPrevRelIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByPrevRelIdxKey();
		key.setRequiredPrevRelationId( PrevRelationId );
		Map<$implCommaIJavaOptAtomType$, IBusModelChainObj> dict;
		if( indexByPrevRelIdx == null ) {
			indexByPrevRelIdx = new HashMap< IBusModelChainByPrevRelIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelChainObj > >();
		}
		if( ( ! forceRead ) && indexByPrevRelIdx.containsKey( key ) ) {
			dict = indexByPrevRelIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelChainObj>();
			IBusModelChainObj obj;
			IBusModelChain[] recList = schema.getBusModelBackingStore().getTableChain().readDerivedByPrevRelIdx( null,
				PrevRelationId );
			IBusModelChain rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelChainObj realised = (IBusModelChainObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByPrevRelIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelChainObj arr[] = new IBusModelChainObj[len];
		Iterator<IBusModelChainObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelChainObj> arrayList = new ArrayList<IBusModelChainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelChainObj> cmp = new Comparator<IBusModelChainObj>() {
			@Override
			public int compare( IBusModelChainObj lhs, IBusModelChainObj rhs ) {
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
		List<IBusModelChainObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelChainObj> readChainByNextRelIdx( IYCFKeyHash256 NextRelationId )
	{
		return( readChainByNextRelIdx( NextRelationId,
			false ) );
	}

	@Override
	public List<IBusModelChainObj> readChainByNextRelIdx( IYCFKeyHash256 NextRelationId,
		boolean forceRead )
	{
		final String S_ProcName = "readChainByNextRelIdx";
		IBusModelChainByNextRelIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByNextRelIdxKey();
		key.setRequiredNextRelationId( NextRelationId );
		Map<$implCommaIJavaOptAtomType$, IBusModelChainObj> dict;
		if( indexByNextRelIdx == null ) {
			indexByNextRelIdx = new HashMap< IBusModelChainByNextRelIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelChainObj > >();
		}
		if( ( ! forceRead ) && indexByNextRelIdx.containsKey( key ) ) {
			dict = indexByNextRelIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelChainObj>();
			IBusModelChainObj obj;
			IBusModelChain[] recList = schema.getBusModelBackingStore().getTableChain().readDerivedByNextRelIdx( null,
				NextRelationId );
			IBusModelChain rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getChainTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelChainObj realised = (IBusModelChainObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNextRelIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelChainObj arr[] = new IBusModelChainObj[len];
		Iterator<IBusModelChainObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelChainObj> arrayList = new ArrayList<IBusModelChainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelChainObj> cmp = new Comparator<IBusModelChainObj>() {
			@Override
			public int compare( IBusModelChainObj lhs, IBusModelChainObj rhs ) {
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
		List<IBusModelChainObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelChainObj readCachedChainByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelChainObj obj = null;
		obj = readCachedChain( Id );
		return( obj );
	}

	@Override
	public List<IBusModelChainObj> readCachedChainByChainTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "readCachedChainByChainTableIdx";
		IBusModelChainByChainTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByChainTableIdxKey();
		key.setRequiredTableId( TableId );
		ArrayList<IBusModelChainObj> arrayList = new ArrayList<IBusModelChainObj>();
		if( indexByChainTableIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelChainObj> dict;
			if( indexByChainTableIdx.containsKey( key ) ) {
				dict = indexByChainTableIdx.get( key );
				int len = dict.size();
				IBusModelChainObj arr[] = new IBusModelChainObj[len];
				Iterator<IBusModelChainObj> valIter = dict.values().iterator();
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
			IBusModelChainObj obj;
			Iterator<IBusModelChainObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelChainObj> cmp = new Comparator<IBusModelChainObj>() {
			@Override
			public int compare( IBusModelChainObj lhs, IBusModelChainObj rhs ) {
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
	public List<IBusModelChainObj> readCachedChainByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "readCachedChainByDefSchemaIdx";
		IBusModelChainByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		ArrayList<IBusModelChainObj> arrayList = new ArrayList<IBusModelChainObj>();
		if( indexByDefSchemaIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelChainObj> dict;
			if( indexByDefSchemaIdx.containsKey( key ) ) {
				dict = indexByDefSchemaIdx.get( key );
				int len = dict.size();
				IBusModelChainObj arr[] = new IBusModelChainObj[len];
				Iterator<IBusModelChainObj> valIter = dict.values().iterator();
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
			IBusModelChainObj obj;
			Iterator<IBusModelChainObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelChainObj> cmp = new Comparator<IBusModelChainObj>() {
			@Override
			public int compare( IBusModelChainObj lhs, IBusModelChainObj rhs ) {
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
	public IBusModelChainObj readCachedChainByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelChainObj obj = null;
		IBusModelChainByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelChainObj> valIter = members.values().iterator();
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
			Iterator<IBusModelChainObj> valIter = members.values().iterator();
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
	public List<IBusModelChainObj> readCachedChainByPrevRelIdx( IYCFKeyHash256 PrevRelationId )
	{
		final String S_ProcName = "readCachedChainByPrevRelIdx";
		IBusModelChainByPrevRelIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByPrevRelIdxKey();
		key.setRequiredPrevRelationId( PrevRelationId );
		ArrayList<IBusModelChainObj> arrayList = new ArrayList<IBusModelChainObj>();
		if( indexByPrevRelIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelChainObj> dict;
			if( indexByPrevRelIdx.containsKey( key ) ) {
				dict = indexByPrevRelIdx.get( key );
				int len = dict.size();
				IBusModelChainObj arr[] = new IBusModelChainObj[len];
				Iterator<IBusModelChainObj> valIter = dict.values().iterator();
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
			IBusModelChainObj obj;
			Iterator<IBusModelChainObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelChainObj> cmp = new Comparator<IBusModelChainObj>() {
			@Override
			public int compare( IBusModelChainObj lhs, IBusModelChainObj rhs ) {
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
	public List<IBusModelChainObj> readCachedChainByNextRelIdx( IYCFKeyHash256 NextRelationId )
	{
		final String S_ProcName = "readCachedChainByNextRelIdx";
		IBusModelChainByNextRelIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByNextRelIdxKey();
		key.setRequiredNextRelationId( NextRelationId );
		ArrayList<IBusModelChainObj> arrayList = new ArrayList<IBusModelChainObj>();
		if( indexByNextRelIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelChainObj> dict;
			if( indexByNextRelIdx.containsKey( key ) ) {
				dict = indexByNextRelIdx.get( key );
				int len = dict.size();
				IBusModelChainObj arr[] = new IBusModelChainObj[len];
				Iterator<IBusModelChainObj> valIter = dict.values().iterator();
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
			IBusModelChainObj obj;
			Iterator<IBusModelChainObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelChainObj> cmp = new Comparator<IBusModelChainObj>() {
			@Override
			public int compare( IBusModelChainObj lhs, IBusModelChainObj rhs ) {
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
	public void deepDisposeChainByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelChainObj obj = readCachedChainByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeChainByChainTableIdx( IYCFKeyHash256 TableId )
	{
		final String S_ProcName = "deepDisposeChainByChainTableIdx";
		IBusModelChainObj obj;
		List<IBusModelChainObj> arrayList = readCachedChainByChainTableIdx( TableId );
		if( arrayList != null )  {
			Iterator<IBusModelChainObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeChainByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		final String S_ProcName = "deepDisposeChainByDefSchemaIdx";
		IBusModelChainObj obj;
		List<IBusModelChainObj> arrayList = readCachedChainByDefSchemaIdx( DefSchemaId );
		if( arrayList != null )  {
			Iterator<IBusModelChainObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeChainByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		IBusModelChainObj obj = readCachedChainByUNameIdx( TableId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeChainByPrevRelIdx( IYCFKeyHash256 PrevRelationId )
	{
		final String S_ProcName = "deepDisposeChainByPrevRelIdx";
		IBusModelChainObj obj;
		List<IBusModelChainObj> arrayList = readCachedChainByPrevRelIdx( PrevRelationId );
		if( arrayList != null )  {
			Iterator<IBusModelChainObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeChainByNextRelIdx( IYCFKeyHash256 NextRelationId )
	{
		final String S_ProcName = "deepDisposeChainByNextRelIdx";
		IBusModelChainObj obj;
		List<IBusModelChainObj> arrayList = readCachedChainByNextRelIdx( NextRelationId );
		if( arrayList != null )  {
			Iterator<IBusModelChainObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IBusModelChainObj updateChain( IBusModelChainObj Obj ) {
		IBusModelChainObj obj = Obj;
		schema.getBusModelBackingStore().getTableChain().updateChain( null,
			Obj.getChainRec() );
		obj = (IBusModelChainObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteChain( IBusModelChainObj Obj ) {
		IBusModelChainObj obj = Obj;
		schema.getBusModelBackingStore().getTableChain().deleteChain( null,
			obj.getChainRec() );
		Obj.forget();
	}

	@Override
	public void deleteChainByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelChainObj obj = readChain(Id);
		if( obj != null ) {
			IBusModelChainEditObj editObj = (IBusModelChainEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelChainEditObj)obj.beginEdit();
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
		deepDisposeChainByIdIdx( Id );
	}

	@Override
	public void deleteChainByChainTableIdx( IYCFKeyHash256 TableId )
	{
		IBusModelChainByChainTableIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByChainTableIdxKey();
		key.setRequiredTableId( TableId );
		if( indexByChainTableIdx == null ) {
			indexByChainTableIdx = new HashMap< IBusModelChainByChainTableIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelChainObj > >();
		}
		if( indexByChainTableIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelChainObj> dict = indexByChainTableIdx.get( key );
			schema.getBusModelBackingStore().getTableChain().deleteChainByChainTableIdx( null,
				TableId );
			Iterator<IBusModelChainObj> iter = dict.values().iterator();
			IBusModelChainObj obj;
			List<IBusModelChainObj> toForget = new LinkedList<IBusModelChainObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByChainTableIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableChain().deleteChainByChainTableIdx( null,
				TableId );
		}
		deepDisposeChainByChainTableIdx( TableId );
	}

	@Override
	public void deleteChainByDefSchemaIdx( IYCFKeyHash256 DefSchemaId )
	{
		IBusModelChainByDefSchemaIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByDefSchemaIdxKey();
		key.setOptionalDefSchemaId( DefSchemaId );
		if( indexByDefSchemaIdx == null ) {
			indexByDefSchemaIdx = new HashMap< IBusModelChainByDefSchemaIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelChainObj > >();
		}
		if( indexByDefSchemaIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelChainObj> dict = indexByDefSchemaIdx.get( key );
			schema.getBusModelBackingStore().getTableChain().deleteChainByDefSchemaIdx( null,
				DefSchemaId );
			Iterator<IBusModelChainObj> iter = dict.values().iterator();
			IBusModelChainObj obj;
			List<IBusModelChainObj> toForget = new LinkedList<IBusModelChainObj>();
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
			schema.getBusModelBackingStore().getTableChain().deleteChainByDefSchemaIdx( null,
				DefSchemaId );
		}
		deepDisposeChainByDefSchemaIdx( DefSchemaId );
	}

	@Override
	public void deleteChainByUNameIdx( IYCFKeyHash256 TableId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelChainByUNameIdxKey,
				IBusModelChainObj >();
		}
		IBusModelChainByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByUNameIdxKey();
		key.setRequiredTableId( TableId );
		key.setRequiredName( Name );
		IBusModelChainObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableChain().deleteChainByUNameIdx( null,
				TableId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableChain().deleteChainByUNameIdx( null,
				TableId,
				Name );
		}
		deepDisposeChainByUNameIdx( TableId,
				Name );
	}

	@Override
	public void deleteChainByPrevRelIdx( IYCFKeyHash256 PrevRelationId )
	{
		IBusModelChainByPrevRelIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByPrevRelIdxKey();
		key.setRequiredPrevRelationId( PrevRelationId );
		if( indexByPrevRelIdx == null ) {
			indexByPrevRelIdx = new HashMap< IBusModelChainByPrevRelIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelChainObj > >();
		}
		if( indexByPrevRelIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelChainObj> dict = indexByPrevRelIdx.get( key );
			schema.getBusModelBackingStore().getTableChain().deleteChainByPrevRelIdx( null,
				PrevRelationId );
			Iterator<IBusModelChainObj> iter = dict.values().iterator();
			IBusModelChainObj obj;
			List<IBusModelChainObj> toForget = new LinkedList<IBusModelChainObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByPrevRelIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableChain().deleteChainByPrevRelIdx( null,
				PrevRelationId );
		}
		deepDisposeChainByPrevRelIdx( PrevRelationId );
	}

	@Override
	public void deleteChainByNextRelIdx( IYCFKeyHash256 NextRelationId )
	{
		IBusModelChainByNextRelIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryChain().newByNextRelIdxKey();
		key.setRequiredNextRelationId( NextRelationId );
		if( indexByNextRelIdx == null ) {
			indexByNextRelIdx = new HashMap< IBusModelChainByNextRelIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelChainObj > >();
		}
		if( indexByNextRelIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelChainObj> dict = indexByNextRelIdx.get( key );
			schema.getBusModelBackingStore().getTableChain().deleteChainByNextRelIdx( null,
				NextRelationId );
			Iterator<IBusModelChainObj> iter = dict.values().iterator();
			IBusModelChainObj obj;
			List<IBusModelChainObj> toForget = new LinkedList<IBusModelChainObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByNextRelIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableChain().deleteChainByNextRelIdx( null,
				NextRelationId );
		}
		deepDisposeChainByNextRelIdx( NextRelationId );
	}
}