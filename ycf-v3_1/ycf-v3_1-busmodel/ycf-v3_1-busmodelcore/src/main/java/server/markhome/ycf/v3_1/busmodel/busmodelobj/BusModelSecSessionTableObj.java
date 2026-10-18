// Description: Java 25 Table Object implementation for SecSession.

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public class BusModelSecSessionTableObj
	implements IBusModelSecSessionTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj> allSecSession;
	private Map< ISecureSecSessionBySecUserIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj > > indexBySecUserIdx;
	private Map< ISecureSecSessionByStartIdxKey,
		ISecureSecSessionObj > indexByStartIdx;
	private Map< ISecureSecSessionByFinishIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj > > indexByFinishIdx;
	private Map< ISecureSecSessionBySecProxyIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj > > indexBySecProxyIdx;
	public static String TABLE_NAME = "SecSession";
	public static String TABLE_DBNAME = "secsess";

	public BusModelSecSessionTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecSessionObj>();
		allSecSession = null;
		indexBySecUserIdx = null;
		indexByStartIdx = null;
		indexByFinishIdx = null;
		indexBySecProxyIdx = null;
	}

	public BusModelSecSessionTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecSessionObj>();
		allSecSession = null;
		indexBySecUserIdx = null;
		indexByStartIdx = null;
		indexByFinishIdx = null;
		indexBySecProxyIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSecSessionTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecSessionTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecSessionTableObj.getRuntimeClassCode() );
	}

	@Override
	public ISecureSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( ISecureSchemaObj value ) {
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
		allSecSession = null;
		indexBySecUserIdx = null;
		indexByStartIdx = null;
		indexByFinishIdx = null;
		indexBySecProxyIdx = null;
		List<ISecureSecSessionObj> toForget = new LinkedList<ISecureSecSessionObj>();
		ISecureSecSessionObj cur = null;
		Iterator<ISecureSecSessionObj> iter = members.values().iterator();
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
	 *	BusModelSecSessionObj.
	 */
	@Override
	public ISecureSecSessionObj newInstance() {
		ISecureSecSessionObj inst = new BusModelSecSessionObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecSessionObj.
	 */
	@Override
	public ISecureSecSessionEditObj newEditInstance( ISecureSecSessionObj orig ) {
		ISecureSecSessionEditObj edit = new BusModelSecSessionEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecSessionObj constructByClassCode( int backingClassCode ) {
		ISecureSecSessionObj obj = null;
		if( backingClassCode == ISecureSecSession.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecSessionTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecSessionObj realiseSecSession( ISecureSecSessionObj Obj ) {
		ISecureSecSessionObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecSessionObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecSessionObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexBySecUserIdx != null ) {
				ISecureSecSessionBySecUserIdxKey keySecUserIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newBySecUserIdxKey();
				keySecUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj > mapSecUserIdx = indexBySecUserIdx.get( keySecUserIdx );
				if( mapSecUserIdx != null ) {
					mapSecUserIdx.remove( keepObj.getPKey() );
					if( mapSecUserIdx.size() <= 0 ) {
						indexBySecUserIdx.remove( keySecUserIdx );
					}
				}
			}

			if( indexByStartIdx != null ) {
				ISecureSecSessionByStartIdxKey keyStartIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newByStartIdxKey();
				keyStartIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyStartIdx.setRequiredStart( keepObj.getRequiredStart() );
				indexByStartIdx.remove( keyStartIdx );
			}

			if( indexByFinishIdx != null ) {
				ISecureSecSessionByFinishIdxKey keyFinishIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newByFinishIdxKey();
				keyFinishIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyFinishIdx.setOptionalFinish( keepObj.getOptionalFinish() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj > mapFinishIdx = indexByFinishIdx.get( keyFinishIdx );
				if( mapFinishIdx != null ) {
					mapFinishIdx.remove( keepObj.getPKey() );
					if( mapFinishIdx.size() <= 0 ) {
						indexByFinishIdx.remove( keyFinishIdx );
					}
				}
			}

			if( indexBySecProxyIdx != null ) {
				ISecureSecSessionBySecProxyIdxKey keySecProxyIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newBySecProxyIdxKey();
				keySecProxyIdx.setOptionalSecProxyId( keepObj.getOptionalSecProxyId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj > mapSecProxyIdx = indexBySecProxyIdx.get( keySecProxyIdx );
				if( mapSecProxyIdx != null ) {
					mapSecProxyIdx.remove( keepObj.getPKey() );
					if( mapSecProxyIdx.size() <= 0 ) {
						indexBySecProxyIdx.remove( keySecProxyIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexBySecUserIdx != null ) {
				ISecureSecSessionBySecUserIdxKey keySecUserIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newBySecUserIdxKey();
				keySecUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj > mapSecUserIdx = indexBySecUserIdx.get( keySecUserIdx );
				if( mapSecUserIdx != null ) {
					mapSecUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByStartIdx != null ) {
				ISecureSecSessionByStartIdxKey keyStartIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newByStartIdxKey();
				keyStartIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyStartIdx.setRequiredStart( keepObj.getRequiredStart() );
				indexByStartIdx.put( keyStartIdx, keepObj );
			}

			if( indexByFinishIdx != null ) {
				ISecureSecSessionByFinishIdxKey keyFinishIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newByFinishIdxKey();
				keyFinishIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyFinishIdx.setOptionalFinish( keepObj.getOptionalFinish() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj > mapFinishIdx = indexByFinishIdx.get( keyFinishIdx );
				if( mapFinishIdx != null ) {
					mapFinishIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySecProxyIdx != null ) {
				ISecureSecSessionBySecProxyIdxKey keySecProxyIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newBySecProxyIdxKey();
				keySecProxyIdx.setOptionalSecProxyId( keepObj.getOptionalSecProxyId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj > mapSecProxyIdx = indexBySecProxyIdx.get( keySecProxyIdx );
				if( mapSecProxyIdx != null ) {
					mapSecProxyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSecSession != null ) {
				allSecSession.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecSession != null ) {
				allSecSession.put( keepObj.getPKey(), keepObj );
			}

			if( indexBySecUserIdx != null ) {
				ISecureSecSessionBySecUserIdxKey keySecUserIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newBySecUserIdxKey();
				keySecUserIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj > mapSecUserIdx = indexBySecUserIdx.get( keySecUserIdx );
				if( mapSecUserIdx != null ) {
					mapSecUserIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByStartIdx != null ) {
				ISecureSecSessionByStartIdxKey keyStartIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newByStartIdxKey();
				keyStartIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyStartIdx.setRequiredStart( keepObj.getRequiredStart() );
				indexByStartIdx.put( keyStartIdx, keepObj );
			}

			if( indexByFinishIdx != null ) {
				ISecureSecSessionByFinishIdxKey keyFinishIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newByFinishIdxKey();
				keyFinishIdx.setRequiredSecUserId( keepObj.getRequiredSecUserId() );
				keyFinishIdx.setOptionalFinish( keepObj.getOptionalFinish() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj > mapFinishIdx = indexByFinishIdx.get( keyFinishIdx );
				if( mapFinishIdx != null ) {
					mapFinishIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySecProxyIdx != null ) {
				ISecureSecSessionBySecProxyIdxKey keySecProxyIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newBySecProxyIdxKey();
				keySecProxyIdx.setOptionalSecProxyId( keepObj.getOptionalSecProxyId() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj > mapSecProxyIdx = indexBySecProxyIdx.get( keySecProxyIdx );
				if( mapSecProxyIdx != null ) {
					mapSecProxyIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecSessionObj createSecSession( ISecureSecSessionObj Obj ) {
		ISecureSecSessionObj obj = Obj;
		ISecureSecSession rec = obj.getSecSessionRec();
		schema.getSecureBackingStore().getTableSecSession().createSecSession(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecSessionObj readSecSession( $implCommaIJavaOptAtomType$ pkey ) {
		return( readSecSession( pkey, false ) );
	}

	@Override
	public ISecureSecSessionObj readSecSession( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureSecSessionObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecSession readRec = schema.getSecureBackingStore().getTableSecSession().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getSecSessionTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecSessionObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecSessionObj readCachedSecSession( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecSessionObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecSession( ISecureSecSessionObj obj )
	{
		final String S_ProcName = "BusModelSecSessionTableObj.reallyDeepDisposeSecSession() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecSessionObj existing = readCachedSecSession( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecSessionBySecUserIdxKey keySecUserIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newBySecUserIdxKey();
		keySecUserIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );

		ISecureSecSessionByStartIdxKey keyStartIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newByStartIdxKey();
		keyStartIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		keyStartIdx.setRequiredStart( existing.getRequiredStart() );

		ISecureSecSessionByFinishIdxKey keyFinishIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newByFinishIdxKey();
		keyFinishIdx.setRequiredSecUserId( existing.getRequiredSecUserId() );
		keyFinishIdx.setOptionalFinish( existing.getOptionalFinish() );

		ISecureSecSessionBySecProxyIdxKey keySecProxyIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newBySecProxyIdxKey();
		keySecProxyIdx.setOptionalSecProxyId( existing.getOptionalSecProxyId() );



		if( indexBySecUserIdx != null ) {
			if( indexBySecUserIdx.containsKey( keySecUserIdx ) ) {
				indexBySecUserIdx.get( keySecUserIdx ).remove( pkey );
				if( indexBySecUserIdx.get( keySecUserIdx ).size() <= 0 ) {
					indexBySecUserIdx.remove( keySecUserIdx );
				}
			}
		}

		if( indexByStartIdx != null ) {
			indexByStartIdx.remove( keyStartIdx );
		}

		if( indexByFinishIdx != null ) {
			if( indexByFinishIdx.containsKey( keyFinishIdx ) ) {
				indexByFinishIdx.get( keyFinishIdx ).remove( pkey );
				if( indexByFinishIdx.get( keyFinishIdx ).size() <= 0 ) {
					indexByFinishIdx.remove( keyFinishIdx );
				}
			}
		}

		if( indexBySecProxyIdx != null ) {
			if( indexBySecProxyIdx.containsKey( keySecProxyIdx ) ) {
				indexBySecProxyIdx.get( keySecProxyIdx ).remove( pkey );
				if( indexBySecProxyIdx.get( keySecProxyIdx ).size() <= 0 ) {
					indexBySecProxyIdx.remove( keySecProxyIdx );
				}
			}
		}


	}
	@Override
	public void deepDisposeSecSession( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecSessionObj obj = readCachedSecSession( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecSessionObj lockSecSession( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecSessionObj locked = null;
		ISecureSecSession lockRec = schema.getSecureBackingStore().getTableSecSession().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecSessionTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecSessionObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecSession", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecSessionObj> readAllSecSession() {
		return( readAllSecSession( false ) );
	}

	@Override
	public List<ISecureSecSessionObj> readAllSecSession( boolean forceRead ) {
		final String S_ProcName = "readAllSecSession";
		if( ( allSecSession == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureSecSessionObj>();
			allSecSession = map;
			ISecureSecSession[] recList = schema.getSecureBackingStore().getTableSecSession().readAllDerived( null );
			ISecureSecSession rec;
			ISecureSecSessionObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecSessionObj realised = (ISecureSecSessionObj)obj.realise();
			}
		}
		int len = allSecSession.size();
		ISecureSecSessionObj arr[] = new ISecureSecSessionObj[len];
		Iterator<ISecureSecSessionObj> valIter = allSecSession.values().iterator();
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
		ArrayList<ISecureSecSessionObj> arrayList = new ArrayList<ISecureSecSessionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecSessionObj> cmp = new Comparator<ISecureSecSessionObj>() {
			@Override
			public int compare( ISecureSecSessionObj lhs, ISecureSecSessionObj rhs ) {
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
		List<ISecureSecSessionObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecSessionObj> readCachedAllSecSession() {
		final String S_ProcName = "readCachedAllSecSession";
		ArrayList<ISecureSecSessionObj> arrayList = new ArrayList<ISecureSecSessionObj>();
		if( allSecSession != null ) {
			int len = allSecSession.size();
			ISecureSecSessionObj arr[] = new ISecureSecSessionObj[len];
			Iterator<ISecureSecSessionObj> valIter = allSecSession.values().iterator();
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
		Comparator<ISecureSecSessionObj> cmp = new Comparator<ISecureSecSessionObj>() {
			public int compare( ISecureSecSessionObj lhs, ISecureSecSessionObj rhs ) {
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

	/**
	 *	Return a sorted map of a page of the SecSession-derived instances in the database.
	 *
	 *	@return	List of ISecureSecSessionObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	@Override
	public List<ISecureSecSessionObj> pageAllSecSession(IYCFKeyHash256 priorSecSessionId )
	{
		final String S_ProcName = "pageAllSecSession";
		Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureSecSessionObj>();
		ISecureSecSession[] recList = schema.getSecureBackingStore().getTableSecSession().pageAllRec( null,
			priorSecSessionId );
		ISecureSecSession rec;
		ISecureSecSessionObj obj;
		ISecureSecSessionObj realised;
		ArrayList<ISecureSecSessionObj> arrayList = new ArrayList<ISecureSecSessionObj>( recList.length );
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			realised = (ISecureSecSessionObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	@Override
	public ISecureSecSessionObj readSecSessionByIdIdx( IYCFKeyHash256 SecSessionId )
	{
		return( readSecSessionByIdIdx( SecSessionId,
			false ) );
	}

	@Override
	public ISecureSecSessionObj readSecSessionByIdIdx( IYCFKeyHash256 SecSessionId, boolean forceRead )
	{
		ISecureSecSessionObj obj = readSecSession( SecSessionId, forceRead );
		return( obj );
	}

	@Override
	public List<ISecureSecSessionObj> readSecSessionBySecUserIdx( IYCFKeyHash256 SecUserId )
	{
		return( readSecSessionBySecUserIdx( SecUserId,
			false ) );
	}

	@Override
	public List<ISecureSecSessionObj> readSecSessionBySecUserIdx( IYCFKeyHash256 SecUserId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSessionBySecUserIdx";
		ISecureSecSessionBySecUserIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newBySecUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj> dict;
		if( indexBySecUserIdx == null ) {
			indexBySecUserIdx = new HashMap< ISecureSecSessionBySecUserIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecSessionObj > >();
		}
		if( ( ! forceRead ) && indexBySecUserIdx.containsKey( key ) ) {
			dict = indexBySecUserIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecSessionObj>();
			ISecureSecSessionObj obj;
			ISecureSecSession[] recList = schema.getSecureBackingStore().getTableSecSession().readDerivedBySecUserIdx( null,
				SecUserId );
			ISecureSecSession rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecSessionObj realised = (ISecureSecSessionObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySecUserIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecSessionObj arr[] = new ISecureSecSessionObj[len];
		Iterator<ISecureSecSessionObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecSessionObj> arrayList = new ArrayList<ISecureSecSessionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecSessionObj> cmp = new Comparator<ISecureSecSessionObj>() {
			@Override
			public int compare( ISecureSecSessionObj lhs, ISecureSecSessionObj rhs ) {
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
		List<ISecureSecSessionObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecSessionObj readSecSessionByStartIdx( IYCFKeyHash256 SecUserId,
		LocalDateTime Start )
	{
		return( readSecSessionByStartIdx( SecUserId,
			Start,
			false ) );
	}

	@Override
	public ISecureSecSessionObj readSecSessionByStartIdx( IYCFKeyHash256 SecUserId,
		LocalDateTime Start, boolean forceRead )
	{
		if( indexByStartIdx == null ) {
			indexByStartIdx = new HashMap< ISecureSecSessionByStartIdxKey,
				ISecureSecSessionObj >();
		}
		ISecureSecSessionByStartIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newByStartIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredStart( Start );
		ISecureSecSessionObj obj = null;
		if( ( ! forceRead ) && indexByStartIdx.containsKey( key ) ) {
			obj = indexByStartIdx.get( key );
		}
		else {
			ISecureSecSession rec = schema.getSecureBackingStore().getTableSecSession().readDerivedByStartIdx( null,
				SecUserId,
				Start );
			if( rec != null ) {
				obj = schema.getSecSessionTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureSecSessionObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<ISecureSecSessionObj> readSecSessionByFinishIdx( IYCFKeyHash256 SecUserId,
		LocalDateTime Finish )
	{
		return( readSecSessionByFinishIdx( SecUserId,
			Finish,
			false ) );
	}

	@Override
	public List<ISecureSecSessionObj> readSecSessionByFinishIdx( IYCFKeyHash256 SecUserId,
		LocalDateTime Finish,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSessionByFinishIdx";
		ISecureSecSessionByFinishIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newByFinishIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalFinish( Finish );
		Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj> dict;
		if( indexByFinishIdx == null ) {
			indexByFinishIdx = new HashMap< ISecureSecSessionByFinishIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecSessionObj > >();
		}
		if( ( ! forceRead ) && indexByFinishIdx.containsKey( key ) ) {
			dict = indexByFinishIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecSessionObj>();
			ISecureSecSessionObj obj;
			ISecureSecSession[] recList = schema.getSecureBackingStore().getTableSecSession().readDerivedByFinishIdx( null,
				SecUserId,
				Finish );
			ISecureSecSession rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecSessionObj realised = (ISecureSecSessionObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByFinishIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecSessionObj arr[] = new ISecureSecSessionObj[len];
		Iterator<ISecureSecSessionObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecSessionObj> arrayList = new ArrayList<ISecureSecSessionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecSessionObj> cmp = new Comparator<ISecureSecSessionObj>() {
			@Override
			public int compare( ISecureSecSessionObj lhs, ISecureSecSessionObj rhs ) {
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
		List<ISecureSecSessionObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecSessionObj> readSecSessionBySecProxyIdx( IYCFKeyHash256 SecProxyId )
	{
		return( readSecSessionBySecProxyIdx( SecProxyId,
			false ) );
	}

	@Override
	public List<ISecureSecSessionObj> readSecSessionBySecProxyIdx( IYCFKeyHash256 SecProxyId,
		boolean forceRead )
	{
		final String S_ProcName = "readSecSessionBySecProxyIdx";
		ISecureSecSessionBySecProxyIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newBySecProxyIdxKey();
		key.setOptionalSecProxyId( SecProxyId );
		Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj> dict;
		if( indexBySecProxyIdx == null ) {
			indexBySecProxyIdx = new HashMap< ISecureSecSessionBySecProxyIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecSessionObj > >();
		}
		if( ( ! forceRead ) && indexBySecProxyIdx.containsKey( key ) ) {
			dict = indexBySecProxyIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecSessionObj>();
			ISecureSecSessionObj obj;
			ISecureSecSession[] recList = schema.getSecureBackingStore().getTableSecSession().readDerivedBySecProxyIdx( null,
				SecProxyId );
			ISecureSecSession rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecSessionObj realised = (ISecureSecSessionObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySecProxyIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecSessionObj arr[] = new ISecureSecSessionObj[len];
		Iterator<ISecureSecSessionObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecSessionObj> arrayList = new ArrayList<ISecureSecSessionObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecSessionObj> cmp = new Comparator<ISecureSecSessionObj>() {
			@Override
			public int compare( ISecureSecSessionObj lhs, ISecureSecSessionObj rhs ) {
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
		List<ISecureSecSessionObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecSessionObj readCachedSecSessionByIdIdx( IYCFKeyHash256 SecSessionId )
	{
		ISecureSecSessionObj obj = null;
		obj = readCachedSecSession( SecSessionId );
		return( obj );
	}

	@Override
	public List<ISecureSecSessionObj> readCachedSecSessionBySecUserIdx( IYCFKeyHash256 SecUserId )
	{
		final String S_ProcName = "readCachedSecSessionBySecUserIdx";
		ISecureSecSessionBySecUserIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newBySecUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		ArrayList<ISecureSecSessionObj> arrayList = new ArrayList<ISecureSecSessionObj>();
		if( indexBySecUserIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj> dict;
			if( indexBySecUserIdx.containsKey( key ) ) {
				dict = indexBySecUserIdx.get( key );
				int len = dict.size();
				ISecureSecSessionObj arr[] = new ISecureSecSessionObj[len];
				Iterator<ISecureSecSessionObj> valIter = dict.values().iterator();
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
			ISecureSecSessionObj obj;
			Iterator<ISecureSecSessionObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecSessionObj> cmp = new Comparator<ISecureSecSessionObj>() {
			@Override
			public int compare( ISecureSecSessionObj lhs, ISecureSecSessionObj rhs ) {
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
	public ISecureSecSessionObj readCachedSecSessionByStartIdx( IYCFKeyHash256 SecUserId,
		LocalDateTime Start )
	{
		ISecureSecSessionObj obj = null;
		ISecureSecSessionByStartIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newByStartIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredStart( Start );
		if( indexByStartIdx != null ) {
			if( indexByStartIdx.containsKey( key ) ) {
				obj = indexByStartIdx.get( key );
			}
			else {
				Iterator<ISecureSecSessionObj> valIter = members.values().iterator();
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
			Iterator<ISecureSecSessionObj> valIter = members.values().iterator();
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
	public List<ISecureSecSessionObj> readCachedSecSessionByFinishIdx( IYCFKeyHash256 SecUserId,
		LocalDateTime Finish )
	{
		final String S_ProcName = "readCachedSecSessionByFinishIdx";
		ISecureSecSessionByFinishIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newByFinishIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalFinish( Finish );
		ArrayList<ISecureSecSessionObj> arrayList = new ArrayList<ISecureSecSessionObj>();
		if( indexByFinishIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj> dict;
			if( indexByFinishIdx.containsKey( key ) ) {
				dict = indexByFinishIdx.get( key );
				int len = dict.size();
				ISecureSecSessionObj arr[] = new ISecureSecSessionObj[len];
				Iterator<ISecureSecSessionObj> valIter = dict.values().iterator();
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
			ISecureSecSessionObj obj;
			Iterator<ISecureSecSessionObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecSessionObj> cmp = new Comparator<ISecureSecSessionObj>() {
			@Override
			public int compare( ISecureSecSessionObj lhs, ISecureSecSessionObj rhs ) {
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
	public List<ISecureSecSessionObj> readCachedSecSessionBySecProxyIdx( IYCFKeyHash256 SecProxyId )
	{
		final String S_ProcName = "readCachedSecSessionBySecProxyIdx";
		ISecureSecSessionBySecProxyIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newBySecProxyIdxKey();
		key.setOptionalSecProxyId( SecProxyId );
		ArrayList<ISecureSecSessionObj> arrayList = new ArrayList<ISecureSecSessionObj>();
		if( indexBySecProxyIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj> dict;
			if( indexBySecProxyIdx.containsKey( key ) ) {
				dict = indexBySecProxyIdx.get( key );
				int len = dict.size();
				ISecureSecSessionObj arr[] = new ISecureSecSessionObj[len];
				Iterator<ISecureSecSessionObj> valIter = dict.values().iterator();
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
			ISecureSecSessionObj obj;
			Iterator<ISecureSecSessionObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecSessionObj> cmp = new Comparator<ISecureSecSessionObj>() {
			@Override
			public int compare( ISecureSecSessionObj lhs, ISecureSecSessionObj rhs ) {
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
	public void deepDisposeSecSessionByIdIdx( IYCFKeyHash256 SecSessionId )
	{
		ISecureSecSessionObj obj = readCachedSecSessionByIdIdx( SecSessionId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecSessionBySecUserIdx( IYCFKeyHash256 SecUserId )
	{
		final String S_ProcName = "deepDisposeSecSessionBySecUserIdx";
		ISecureSecSessionObj obj;
		List<ISecureSecSessionObj> arrayList = readCachedSecSessionBySecUserIdx( SecUserId );
		if( arrayList != null )  {
			Iterator<ISecureSecSessionObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecSessionByStartIdx( IYCFKeyHash256 SecUserId,
		LocalDateTime Start )
	{
		ISecureSecSessionObj obj = readCachedSecSessionByStartIdx( SecUserId,
				Start );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecSessionByFinishIdx( IYCFKeyHash256 SecUserId,
		LocalDateTime Finish )
	{
		final String S_ProcName = "deepDisposeSecSessionByFinishIdx";
		ISecureSecSessionObj obj;
		List<ISecureSecSessionObj> arrayList = readCachedSecSessionByFinishIdx( SecUserId,
				Finish );
		if( arrayList != null )  {
			Iterator<ISecureSecSessionObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecSessionBySecProxyIdx( IYCFKeyHash256 SecProxyId )
	{
		final String S_ProcName = "deepDisposeSecSessionBySecProxyIdx";
		ISecureSecSessionObj obj;
		List<ISecureSecSessionObj> arrayList = readCachedSecSessionBySecProxyIdx( SecProxyId );
		if( arrayList != null )  {
			Iterator<ISecureSecSessionObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	/**
	 *	Read a page of data as a List of SecSession-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SecUserIdx key attributes.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSession-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecSessionObj> pageSecSessionBySecUserIdx( IYCFKeyHash256 SecUserId,
		IYCFKeyHash256 priorSecSessionId )
	{
		final String S_ProcName = "pageSecSessionBySecUserIdx";
		ISecureSecSessionBySecUserIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newBySecUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		List<ISecureSecSessionObj> retList = new LinkedList<ISecureSecSessionObj>();
		ISecureSecSessionObj obj;
		ISecureSecSession[] recList = schema.getSecureBackingStore().getTableSecSession().pageRecBySecUserIdx( null,
				SecUserId,
			priorSecSessionId );
		ISecureSecSession rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecSessionObj realised = (ISecureSecSessionObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecSession-derived instances sorted by their primary keys,
	 *	as identified by the duplicate FinishIdx key attributes.
	 *
	 *	@param	SecUserId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@param	Finish	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSession-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecSessionObj> pageSecSessionByFinishIdx( IYCFKeyHash256 SecUserId,
		LocalDateTime Finish,
		IYCFKeyHash256 priorSecSessionId )
	{
		final String S_ProcName = "pageSecSessionByFinishIdx";
		ISecureSecSessionByFinishIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newByFinishIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalFinish( Finish );
		List<ISecureSecSessionObj> retList = new LinkedList<ISecureSecSessionObj>();
		ISecureSecSessionObj obj;
		ISecureSecSession[] recList = schema.getSecureBackingStore().getTableSecSession().pageRecByFinishIdx( null,
				SecUserId,
				Finish,
			priorSecSessionId );
		ISecureSecSession rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecSessionObj realised = (ISecureSecSessionObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecSession-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SecProxyIdx key attributes.
	 *
	 *	@param	SecProxyId	The SecSession key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecSession-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecSessionObj> pageSecSessionBySecProxyIdx( IYCFKeyHash256 SecProxyId,
		IYCFKeyHash256 priorSecSessionId )
	{
		final String S_ProcName = "pageSecSessionBySecProxyIdx";
		ISecureSecSessionBySecProxyIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newBySecProxyIdxKey();
		key.setOptionalSecProxyId( SecProxyId );
		List<ISecureSecSessionObj> retList = new LinkedList<ISecureSecSessionObj>();
		ISecureSecSessionObj obj;
		ISecureSecSession[] recList = schema.getSecureBackingStore().getTableSecSession().pageRecBySecProxyIdx( null,
				SecProxyId,
			priorSecSessionId );
		ISecureSecSession rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecSessionTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecSessionObj realised = (ISecureSecSessionObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	@Override
	public ISecureSecSessionObj updateSecSession( ISecureSecSessionObj Obj ) {
		ISecureSecSessionObj obj = Obj;
		schema.getSecureBackingStore().getTableSecSession().updateSecSession( null,
			Obj.getSecSessionRec() );
		obj = (ISecureSecSessionObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecSession( ISecureSecSessionObj Obj ) {
		ISecureSecSessionObj obj = Obj;
		schema.getSecureBackingStore().getTableSecSession().deleteSecSession( null,
			obj.getSecSessionRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecSessionByIdIdx( IYCFKeyHash256 SecSessionId )
	{
		ISecureSecSessionObj obj = readSecSession(SecSessionId);
		if( obj != null ) {
			ISecureSecSessionEditObj editObj = (ISecureSecSessionEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecSessionEditObj)obj.beginEdit();
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
		deepDisposeSecSessionByIdIdx( SecSessionId );
	}

	@Override
	public void deleteSecSessionBySecUserIdx( IYCFKeyHash256 SecUserId )
	{
		ISecureSecSessionBySecUserIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newBySecUserIdxKey();
		key.setRequiredSecUserId( SecUserId );
		if( indexBySecUserIdx == null ) {
			indexBySecUserIdx = new HashMap< ISecureSecSessionBySecUserIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecSessionObj > >();
		}
		if( indexBySecUserIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj> dict = indexBySecUserIdx.get( key );
			schema.getSecureBackingStore().getTableSecSession().deleteSecSessionBySecUserIdx( null,
				SecUserId );
			Iterator<ISecureSecSessionObj> iter = dict.values().iterator();
			ISecureSecSessionObj obj;
			List<ISecureSecSessionObj> toForget = new LinkedList<ISecureSecSessionObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexBySecUserIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecSession().deleteSecSessionBySecUserIdx( null,
				SecUserId );
		}
		deepDisposeSecSessionBySecUserIdx( SecUserId );
	}

	@Override
	public void deleteSecSessionByStartIdx( IYCFKeyHash256 SecUserId,
		LocalDateTime Start )
	{
		if( indexByStartIdx == null ) {
			indexByStartIdx = new HashMap< ISecureSecSessionByStartIdxKey,
				ISecureSecSessionObj >();
		}
		ISecureSecSessionByStartIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newByStartIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setRequiredStart( Start );
		ISecureSecSessionObj obj = null;
		if( indexByStartIdx.containsKey( key ) ) {
			obj = indexByStartIdx.get( key );
			schema.getSecureBackingStore().getTableSecSession().deleteSecSessionByStartIdx( null,
				SecUserId,
				Start );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableSecSession().deleteSecSessionByStartIdx( null,
				SecUserId,
				Start );
		}
		deepDisposeSecSessionByStartIdx( SecUserId,
				Start );
	}

	@Override
	public void deleteSecSessionByFinishIdx( IYCFKeyHash256 SecUserId,
		LocalDateTime Finish )
	{
		ISecureSecSessionByFinishIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newByFinishIdxKey();
		key.setRequiredSecUserId( SecUserId );
		key.setOptionalFinish( Finish );
		if( indexByFinishIdx == null ) {
			indexByFinishIdx = new HashMap< ISecureSecSessionByFinishIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecSessionObj > >();
		}
		if( indexByFinishIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj> dict = indexByFinishIdx.get( key );
			schema.getSecureBackingStore().getTableSecSession().deleteSecSessionByFinishIdx( null,
				SecUserId,
				Finish );
			Iterator<ISecureSecSessionObj> iter = dict.values().iterator();
			ISecureSecSessionObj obj;
			List<ISecureSecSessionObj> toForget = new LinkedList<ISecureSecSessionObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByFinishIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecSession().deleteSecSessionByFinishIdx( null,
				SecUserId,
				Finish );
		}
		deepDisposeSecSessionByFinishIdx( SecUserId,
				Finish );
	}

	@Override
	public void deleteSecSessionBySecProxyIdx( IYCFKeyHash256 SecProxyId )
	{
		ISecureSecSessionBySecProxyIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecSession().newBySecProxyIdxKey();
		key.setOptionalSecProxyId( SecProxyId );
		if( indexBySecProxyIdx == null ) {
			indexBySecProxyIdx = new HashMap< ISecureSecSessionBySecProxyIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecSessionObj > >();
		}
		if( indexBySecProxyIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecSessionObj> dict = indexBySecProxyIdx.get( key );
			schema.getSecureBackingStore().getTableSecSession().deleteSecSessionBySecProxyIdx( null,
				SecProxyId );
			Iterator<ISecureSecSessionObj> iter = dict.values().iterator();
			ISecureSecSessionObj obj;
			List<ISecureSecSessionObj> toForget = new LinkedList<ISecureSecSessionObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexBySecProxyIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecSession().deleteSecSessionBySecProxyIdx( null,
				SecProxyId );
		}
		deepDisposeSecSessionBySecProxyIdx( SecProxyId );
	}
}