// Description: Java 25 Table Object implementation for URLProtocol.

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
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;

public class BusModelURLProtocolTableObj
	implements IBusModelURLProtocolTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, IIntNetURLProtocolObj> members;
	private Map<$implCommaIJavaOptAtomType$, IIntNetURLProtocolObj> allURLProtocol;
	private Map< IIntNetURLProtocolByUNameIdxKey,
		IIntNetURLProtocolObj > indexByUNameIdx;
	private Map< IIntNetURLProtocolByIsSecureIdxKey,
		Map<$implCommaIJavaOptAtomType$, IIntNetURLProtocolObj > > indexByIsSecureIdx;
	public static String TABLE_NAME = "URLProtocol";
	public static String TABLE_DBNAME = "urlproto";

	public BusModelURLProtocolTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetURLProtocolObj>();
		allURLProtocol = null;
		indexByUNameIdx = null;
		indexByIsSecureIdx = null;
	}

	public BusModelURLProtocolTableObj( IIntNetSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetURLProtocolObj>();
		allURLProtocol = null;
		indexByUNameIdx = null;
		indexByIsSecureIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return IntNetURLProtocolTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( IntNetURLProtocolTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( IntNetURLProtocolTableObj.getRuntimeClassCode() );
	}

	@Override
	public IIntNetSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( IIntNetSchemaObj value ) {
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
		allURLProtocol = null;
		indexByUNameIdx = null;
		indexByIsSecureIdx = null;
		List<IIntNetURLProtocolObj> toForget = new LinkedList<IIntNetURLProtocolObj>();
		IIntNetURLProtocolObj cur = null;
		Iterator<IIntNetURLProtocolObj> iter = members.values().iterator();
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
	 *	BusModelURLProtocolObj.
	 */
	@Override
	public IIntNetURLProtocolObj newInstance() {
		IIntNetURLProtocolObj inst = new BusModelURLProtocolObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelURLProtocolObj.
	 */
	@Override
	public IIntNetURLProtocolEditObj newEditInstance( IIntNetURLProtocolObj orig ) {
		IIntNetURLProtocolEditObj edit = new BusModelURLProtocolEditObj( orig );
		return( edit );
	}

	@Override
	public IIntNetURLProtocolObj constructByClassCode( int backingClassCode ) {
		IIntNetURLProtocolObj obj = null;
		if( backingClassCode == IIntNetURLProtocol.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getURLProtocolTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public IIntNetURLProtocolObj realiseURLProtocol( IIntNetURLProtocolObj Obj ) {
		IIntNetURLProtocolObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetURLProtocolObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IIntNetURLProtocolObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUNameIdx != null ) {
				IIntNetURLProtocolByUNameIdxKey keyUNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryURLProtocol().newByUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByIsSecureIdx != null ) {
				IIntNetURLProtocolByIsSecureIdxKey keyIsSecureIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryURLProtocol().newByIsSecureIdxKey();
				keyIsSecureIdx.setRequiredIsSecure( keepObj.getRequiredIsSecure() );
				Map<$implCommaIJavaOptAtomType$, IIntNetURLProtocolObj > mapIsSecureIdx = indexByIsSecureIdx.get( keyIsSecureIdx );
				if( mapIsSecureIdx != null ) {
					mapIsSecureIdx.remove( keepObj.getPKey() );
					if( mapIsSecureIdx.size() <= 0 ) {
						indexByIsSecureIdx.remove( keyIsSecureIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUNameIdx != null ) {
				IIntNetURLProtocolByUNameIdxKey keyUNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryURLProtocol().newByUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByIsSecureIdx != null ) {
				IIntNetURLProtocolByIsSecureIdxKey keyIsSecureIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryURLProtocol().newByIsSecureIdxKey();
				keyIsSecureIdx.setRequiredIsSecure( keepObj.getRequiredIsSecure() );
				Map<$implCommaIJavaOptAtomType$, IIntNetURLProtocolObj > mapIsSecureIdx = indexByIsSecureIdx.get( keyIsSecureIdx );
				if( mapIsSecureIdx != null ) {
					mapIsSecureIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allURLProtocol != null ) {
				allURLProtocol.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allURLProtocol != null ) {
				allURLProtocol.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUNameIdx != null ) {
				IIntNetURLProtocolByUNameIdxKey keyUNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryURLProtocol().newByUNameIdxKey();
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByIsSecureIdx != null ) {
				IIntNetURLProtocolByIsSecureIdxKey keyIsSecureIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryURLProtocol().newByIsSecureIdxKey();
				keyIsSecureIdx.setRequiredIsSecure( keepObj.getRequiredIsSecure() );
				Map<$implCommaIJavaOptAtomType$, IIntNetURLProtocolObj > mapIsSecureIdx = indexByIsSecureIdx.get( keyIsSecureIdx );
				if( mapIsSecureIdx != null ) {
					mapIsSecureIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public IIntNetURLProtocolObj createURLProtocol( IIntNetURLProtocolObj Obj ) {
		IIntNetURLProtocolObj obj = Obj;
		IIntNetURLProtocol rec = obj.getURLProtocolRec();
		schema.getIntNetBackingStore().getTableURLProtocol().createURLProtocol(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public IIntNetURLProtocolObj readURLProtocol( $implCommaIJavaOptAtomType$ pkey ) {
		return( readURLProtocol( pkey, false ) );
	}

	@Override
	public IIntNetURLProtocolObj readURLProtocol( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IIntNetURLProtocolObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IIntNetURLProtocol readRec = schema.getIntNetBackingStore().getTableURLProtocol().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getURLProtocolTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IIntNetURLProtocolObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IIntNetURLProtocolObj readCachedURLProtocol( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetURLProtocolObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeURLProtocol( IIntNetURLProtocolObj obj )
	{
		final String S_ProcName = "BusModelURLProtocolTableObj.reallyDeepDisposeURLProtocol() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetURLProtocolObj existing = readCachedURLProtocol( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IIntNetURLProtocolByUNameIdxKey keyUNameIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryURLProtocol().newByUNameIdxKey();
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		IIntNetURLProtocolByIsSecureIdxKey keyIsSecureIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryURLProtocol().newByIsSecureIdxKey();
		keyIsSecureIdx.setRequiredIsSecure( existing.getRequiredIsSecure() );



		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}

		if( indexByIsSecureIdx != null ) {
			if( indexByIsSecureIdx.containsKey( keyIsSecureIdx ) ) {
				indexByIsSecureIdx.get( keyIsSecureIdx ).remove( pkey );
				if( indexByIsSecureIdx.get( keyIsSecureIdx ).size() <= 0 ) {
					indexByIsSecureIdx.remove( keyIsSecureIdx );
				}
			}
		}


	}
	@Override
	public void deepDisposeURLProtocol( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetURLProtocolObj obj = readCachedURLProtocol( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IIntNetURLProtocolObj lockURLProtocol( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetURLProtocolObj locked = null;
		IIntNetURLProtocol lockRec = schema.getIntNetBackingStore().getTableURLProtocol().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getURLProtocolTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IIntNetURLProtocolObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockURLProtocol", pkey );
		}
		return( locked );
	}

	@Override
	public List<IIntNetURLProtocolObj> readAllURLProtocol() {
		return( readAllURLProtocol( false ) );
	}

	@Override
	public List<IIntNetURLProtocolObj> readAllURLProtocol( boolean forceRead ) {
		final String S_ProcName = "readAllURLProtocol";
		if( ( allURLProtocol == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetURLProtocolObj> map = new HashMap<$implCommaIJavaOptAtomType$,IIntNetURLProtocolObj>();
			allURLProtocol = map;
			IIntNetURLProtocol[] recList = schema.getIntNetBackingStore().getTableURLProtocol().readAllDerived( null );
			IIntNetURLProtocol rec;
			IIntNetURLProtocolObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetURLProtocolObj realised = (IIntNetURLProtocolObj)obj.realise();
			}
		}
		int len = allURLProtocol.size();
		IIntNetURLProtocolObj arr[] = new IIntNetURLProtocolObj[len];
		Iterator<IIntNetURLProtocolObj> valIter = allURLProtocol.values().iterator();
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
		ArrayList<IIntNetURLProtocolObj> arrayList = new ArrayList<IIntNetURLProtocolObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetURLProtocolObj> cmp = new Comparator<IIntNetURLProtocolObj>() {
			@Override
			public int compare( IIntNetURLProtocolObj lhs, IIntNetURLProtocolObj rhs ) {
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
		List<IIntNetURLProtocolObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IIntNetURLProtocolObj> readCachedAllURLProtocol() {
		final String S_ProcName = "readCachedAllURLProtocol";
		ArrayList<IIntNetURLProtocolObj> arrayList = new ArrayList<IIntNetURLProtocolObj>();
		if( allURLProtocol != null ) {
			int len = allURLProtocol.size();
			IIntNetURLProtocolObj arr[] = new IIntNetURLProtocolObj[len];
			Iterator<IIntNetURLProtocolObj> valIter = allURLProtocol.values().iterator();
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
		Comparator<IIntNetURLProtocolObj> cmp = new Comparator<IIntNetURLProtocolObj>() {
			public int compare( IIntNetURLProtocolObj lhs, IIntNetURLProtocolObj rhs ) {
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
	public IIntNetURLProtocolObj readURLProtocolByIdIdx( int URLProtocolId )
	{
		return( readURLProtocolByIdIdx( URLProtocolId,
			false ) );
	}

	@Override
	public IIntNetURLProtocolObj readURLProtocolByIdIdx( int URLProtocolId, boolean forceRead )
	{
		IIntNetURLProtocolObj obj = readURLProtocol( URLProtocolId, forceRead );
		return( obj );
	}

	@Override
	public IIntNetURLProtocolObj readURLProtocolByUNameIdx( String Name )
	{
		return( readURLProtocolByUNameIdx( Name,
			false ) );
	}

	@Override
	public IIntNetURLProtocolObj readURLProtocolByUNameIdx( String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IIntNetURLProtocolByUNameIdxKey,
				IIntNetURLProtocolObj >();
		}
		IIntNetURLProtocolByUNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryURLProtocol().newByUNameIdxKey();
		key.setRequiredName( Name );
		IIntNetURLProtocolObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IIntNetURLProtocol rec = schema.getIntNetBackingStore().getTableURLProtocol().readDerivedByUNameIdx( null,
				Name );
			if( rec != null ) {
				obj = schema.getURLProtocolTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IIntNetURLProtocolObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IIntNetURLProtocolObj> readURLProtocolByIsSecureIdx( boolean IsSecure )
	{
		return( readURLProtocolByIsSecureIdx( IsSecure,
			false ) );
	}

	@Override
	public List<IIntNetURLProtocolObj> readURLProtocolByIsSecureIdx( boolean IsSecure,
		boolean forceRead )
	{
		final String S_ProcName = "readURLProtocolByIsSecureIdx";
		IIntNetURLProtocolByIsSecureIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryURLProtocol().newByIsSecureIdxKey();
		key.setRequiredIsSecure( IsSecure );
		Map<$implCommaIJavaOptAtomType$, IIntNetURLProtocolObj> dict;
		if( indexByIsSecureIdx == null ) {
			indexByIsSecureIdx = new HashMap< IIntNetURLProtocolByIsSecureIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetURLProtocolObj > >();
		}
		if( ( ! forceRead ) && indexByIsSecureIdx.containsKey( key ) ) {
			dict = indexByIsSecureIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IIntNetURLProtocolObj>();
			IIntNetURLProtocolObj obj;
			IIntNetURLProtocol[] recList = schema.getIntNetBackingStore().getTableURLProtocol().readDerivedByIsSecureIdx( null,
				IsSecure );
			IIntNetURLProtocol rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getURLProtocolTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetURLProtocolObj realised = (IIntNetURLProtocolObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByIsSecureIdx.put( key, dict );
		}
		int len = dict.size();
		IIntNetURLProtocolObj arr[] = new IIntNetURLProtocolObj[len];
		Iterator<IIntNetURLProtocolObj> valIter = dict.values().iterator();
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
		ArrayList<IIntNetURLProtocolObj> arrayList = new ArrayList<IIntNetURLProtocolObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetURLProtocolObj> cmp = new Comparator<IIntNetURLProtocolObj>() {
			@Override
			public int compare( IIntNetURLProtocolObj lhs, IIntNetURLProtocolObj rhs ) {
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
		List<IIntNetURLProtocolObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IIntNetURLProtocolObj readCachedURLProtocolByIdIdx( int URLProtocolId )
	{
		IIntNetURLProtocolObj obj = null;
		obj = readCachedURLProtocol( URLProtocolId );
		return( obj );
	}

	@Override
	public IIntNetURLProtocolObj readCachedURLProtocolByUNameIdx( String Name )
	{
		IIntNetURLProtocolObj obj = null;
		IIntNetURLProtocolByUNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryURLProtocol().newByUNameIdxKey();
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IIntNetURLProtocolObj> valIter = members.values().iterator();
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
			Iterator<IIntNetURLProtocolObj> valIter = members.values().iterator();
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
	public List<IIntNetURLProtocolObj> readCachedURLProtocolByIsSecureIdx( boolean IsSecure )
	{
		final String S_ProcName = "readCachedURLProtocolByIsSecureIdx";
		IIntNetURLProtocolByIsSecureIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryURLProtocol().newByIsSecureIdxKey();
		key.setRequiredIsSecure( IsSecure );
		ArrayList<IIntNetURLProtocolObj> arrayList = new ArrayList<IIntNetURLProtocolObj>();
		if( indexByIsSecureIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetURLProtocolObj> dict;
			if( indexByIsSecureIdx.containsKey( key ) ) {
				dict = indexByIsSecureIdx.get( key );
				int len = dict.size();
				IIntNetURLProtocolObj arr[] = new IIntNetURLProtocolObj[len];
				Iterator<IIntNetURLProtocolObj> valIter = dict.values().iterator();
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
			IIntNetURLProtocolObj obj;
			Iterator<IIntNetURLProtocolObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IIntNetURLProtocolObj> cmp = new Comparator<IIntNetURLProtocolObj>() {
			@Override
			public int compare( IIntNetURLProtocolObj lhs, IIntNetURLProtocolObj rhs ) {
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
	public void deepDisposeURLProtocolByIdIdx( int URLProtocolId )
	{
		IIntNetURLProtocolObj obj = readCachedURLProtocolByIdIdx( URLProtocolId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeURLProtocolByUNameIdx( String Name )
	{
		IIntNetURLProtocolObj obj = readCachedURLProtocolByUNameIdx( Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeURLProtocolByIsSecureIdx( boolean IsSecure )
	{
		final String S_ProcName = "deepDisposeURLProtocolByIsSecureIdx";
		IIntNetURLProtocolObj obj;
		List<IIntNetURLProtocolObj> arrayList = readCachedURLProtocolByIsSecureIdx( IsSecure );
		if( arrayList != null )  {
			Iterator<IIntNetURLProtocolObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public IIntNetURLProtocolObj updateURLProtocol( IIntNetURLProtocolObj Obj ) {
		IIntNetURLProtocolObj obj = Obj;
		schema.getIntNetBackingStore().getTableURLProtocol().updateURLProtocol( null,
			Obj.getURLProtocolRec() );
		obj = (IIntNetURLProtocolObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteURLProtocol( IIntNetURLProtocolObj Obj ) {
		IIntNetURLProtocolObj obj = Obj;
		schema.getIntNetBackingStore().getTableURLProtocol().deleteURLProtocol( null,
			obj.getURLProtocolRec() );
		Obj.forget();
	}

	@Override
	public void deleteURLProtocolByIdIdx( int URLProtocolId )
	{
		IIntNetURLProtocolObj obj = readURLProtocol(URLProtocolId);
		if( obj != null ) {
			IIntNetURLProtocolEditObj editObj = (IIntNetURLProtocolEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IIntNetURLProtocolEditObj)obj.beginEdit();
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
		deepDisposeURLProtocolByIdIdx( URLProtocolId );
	}

	@Override
	public void deleteURLProtocolByUNameIdx( String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IIntNetURLProtocolByUNameIdxKey,
				IIntNetURLProtocolObj >();
		}
		IIntNetURLProtocolByUNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryURLProtocol().newByUNameIdxKey();
		key.setRequiredName( Name );
		IIntNetURLProtocolObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getIntNetBackingStore().getTableURLProtocol().deleteURLProtocolByUNameIdx( null,
				Name );
			obj.forget();
		}
		else {
			schema.getIntNetBackingStore().getTableURLProtocol().deleteURLProtocolByUNameIdx( null,
				Name );
		}
		deepDisposeURLProtocolByUNameIdx( Name );
	}

	@Override
	public void deleteURLProtocolByIsSecureIdx( boolean IsSecure )
	{
		IIntNetURLProtocolByIsSecureIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryURLProtocol().newByIsSecureIdxKey();
		key.setRequiredIsSecure( IsSecure );
		if( indexByIsSecureIdx == null ) {
			indexByIsSecureIdx = new HashMap< IIntNetURLProtocolByIsSecureIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetURLProtocolObj > >();
		}
		if( indexByIsSecureIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetURLProtocolObj> dict = indexByIsSecureIdx.get( key );
			schema.getIntNetBackingStore().getTableURLProtocol().deleteURLProtocolByIsSecureIdx( null,
				IsSecure );
			Iterator<IIntNetURLProtocolObj> iter = dict.values().iterator();
			IIntNetURLProtocolObj obj;
			List<IIntNetURLProtocolObj> toForget = new LinkedList<IIntNetURLProtocolObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByIsSecureIdx.remove( key );
		}
		else {
			schema.getIntNetBackingStore().getTableURLProtocol().deleteURLProtocolByIsSecureIdx( null,
				IsSecure );
		}
		deepDisposeURLProtocolByIsSecureIdx( IsSecure );
	}
}