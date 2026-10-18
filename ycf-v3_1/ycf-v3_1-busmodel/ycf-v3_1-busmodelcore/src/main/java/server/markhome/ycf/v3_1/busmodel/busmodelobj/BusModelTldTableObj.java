// Description: Java 25 Table Object implementation for Tld.

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

public class BusModelTldTableObj
	implements IBusModelTldTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, IIntNetTldObj> members;
	private Map<$implCommaIJavaOptAtomType$, IIntNetTldObj> allTld;
	private Map< IIntNetTldByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IIntNetTldObj > > indexByTenantIdx;
	private Map< IIntNetTldByNameIdxKey,
		IIntNetTldObj > indexByNameIdx;
	public static String TABLE_NAME = "Tld";
	public static String TABLE_DBNAME = "tlddef";

	public BusModelTldTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetTldObj>();
		allTld = null;
		indexByTenantIdx = null;
		indexByNameIdx = null;
	}

	public BusModelTldTableObj( IIntNetSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetTldObj>();
		allTld = null;
		indexByTenantIdx = null;
		indexByNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return IntNetTldTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( IntNetTldTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( IntNetTldTableObj.getRuntimeClassCode() );
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
		return( IBusModelTenantObj.class );
	}


	@Override
	public void minimizeMemory() {
		allTld = null;
		indexByTenantIdx = null;
		indexByNameIdx = null;
		List<IIntNetTldObj> toForget = new LinkedList<IIntNetTldObj>();
		IIntNetTldObj cur = null;
		Iterator<IIntNetTldObj> iter = members.values().iterator();
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
	 *	BusModelTldObj.
	 */
	@Override
	public IIntNetTldObj newInstance() {
		IIntNetTldObj inst = new BusModelTldObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelTldObj.
	 */
	@Override
	public IIntNetTldEditObj newEditInstance( IIntNetTldObj orig ) {
		IIntNetTldEditObj edit = new BusModelTldEditObj( orig );
		return( edit );
	}

	@Override
	public IIntNetTldObj constructByClassCode( int backingClassCode ) {
		IIntNetTldObj obj = null;
		if( backingClassCode == IIntNetTld.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getTldTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public IIntNetTldObj realiseTld( IIntNetTldObj Obj ) {
		IIntNetTldObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetTldObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IIntNetTldObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				IIntNetTldByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTld().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetTldObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetTldByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTld().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IIntNetTldByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTld().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetTldObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetTldByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTld().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( allTld != null ) {
				allTld.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTld != null ) {
				allTld.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IIntNetTldByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTld().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetTldObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetTldByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTld().newByNameIdxKey();
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public IIntNetTldObj createTld( IIntNetTldObj Obj ) {
		IIntNetTldObj obj = Obj;
		IIntNetTld rec = obj.getTldRec();
		schema.getIntNetBackingStore().getTableTld().createTld(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public IIntNetTldObj readTld( $implCommaIJavaOptAtomType$ pkey ) {
		return( readTld( pkey, false ) );
	}

	@Override
	public IIntNetTldObj readTld( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IIntNetTldObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IIntNetTld readRec = schema.getIntNetBackingStore().getTableTld().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getTldTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IIntNetTldObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IIntNetTldObj readCachedTld( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetTldObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeTld( IIntNetTldObj obj )
	{
		final String S_ProcName = "BusModelTldTableObj.reallyDeepDisposeTld() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetTldObj existing = readCachedTld( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IIntNetTldByTenantIdxKey keyTenantIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTld().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IIntNetTldByNameIdxKey keyNameIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTld().newByNameIdxKey();
		keyNameIdx.setRequiredName( existing.getRequiredName() );


					schema.getTopDomainTableObj().deepDisposeTopDomainByTldIdx( existing.getRequiredId() );

		if( indexByTenantIdx != null ) {
			if( indexByTenantIdx.containsKey( keyTenantIdx ) ) {
				indexByTenantIdx.get( keyTenantIdx ).remove( pkey );
				if( indexByTenantIdx.get( keyTenantIdx ).size() <= 0 ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}
		}

		if( indexByNameIdx != null ) {
			indexByNameIdx.remove( keyNameIdx );
		}


	}
	@Override
	public void deepDisposeTld( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetTldObj obj = readCachedTld( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IIntNetTldObj lockTld( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetTldObj locked = null;
		IIntNetTld lockRec = schema.getIntNetBackingStore().getTableTld().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getTldTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IIntNetTldObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockTld", pkey );
		}
		return( locked );
	}

	@Override
	public List<IIntNetTldObj> readAllTld() {
		return( readAllTld( false ) );
	}

	@Override
	public List<IIntNetTldObj> readAllTld( boolean forceRead ) {
		final String S_ProcName = "readAllTld";
		if( ( allTld == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetTldObj> map = new HashMap<$implCommaIJavaOptAtomType$,IIntNetTldObj>();
			allTld = map;
			IIntNetTld[] recList = schema.getIntNetBackingStore().getTableTld().readAllDerived( null );
			IIntNetTld rec;
			IIntNetTldObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetTldObj realised = (IIntNetTldObj)obj.realise();
			}
		}
		int len = allTld.size();
		IIntNetTldObj arr[] = new IIntNetTldObj[len];
		Iterator<IIntNetTldObj> valIter = allTld.values().iterator();
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
		ArrayList<IIntNetTldObj> arrayList = new ArrayList<IIntNetTldObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetTldObj> cmp = new Comparator<IIntNetTldObj>() {
			@Override
			public int compare( IIntNetTldObj lhs, IIntNetTldObj rhs ) {
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
		List<IIntNetTldObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IIntNetTldObj> readCachedAllTld() {
		final String S_ProcName = "readCachedAllTld";
		ArrayList<IIntNetTldObj> arrayList = new ArrayList<IIntNetTldObj>();
		if( allTld != null ) {
			int len = allTld.size();
			IIntNetTldObj arr[] = new IIntNetTldObj[len];
			Iterator<IIntNetTldObj> valIter = allTld.values().iterator();
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
		Comparator<IIntNetTldObj> cmp = new Comparator<IIntNetTldObj>() {
			public int compare( IIntNetTldObj lhs, IIntNetTldObj rhs ) {
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
	public IIntNetTldObj readTldByIdIdx( IYCFKeyHash256 Id )
	{
		return( readTldByIdIdx( Id,
			false ) );
	}

	@Override
	public IIntNetTldObj readTldByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IIntNetTldObj obj = readTld( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IIntNetTldObj> readTldByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readTldByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IIntNetTldObj> readTldByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTldByTenantIdx";
		IIntNetTldByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTld().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IIntNetTldObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IIntNetTldByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetTldObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IIntNetTldObj>();
			IIntNetTldObj obj;
			IIntNetTld[] recList = schema.getIntNetBackingStore().getTableTld().readDerivedByTenantIdx( null,
				TenantId );
			IIntNetTld rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getTldTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetTldObj realised = (IIntNetTldObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IIntNetTldObj arr[] = new IIntNetTldObj[len];
		Iterator<IIntNetTldObj> valIter = dict.values().iterator();
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
		ArrayList<IIntNetTldObj> arrayList = new ArrayList<IIntNetTldObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetTldObj> cmp = new Comparator<IIntNetTldObj>() {
			@Override
			public int compare( IIntNetTldObj lhs, IIntNetTldObj rhs ) {
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
		List<IIntNetTldObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IIntNetTldObj readTldByNameIdx( String Name )
	{
		return( readTldByNameIdx( Name,
			false ) );
	}

	@Override
	public IIntNetTldObj readTldByNameIdx( String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< IIntNetTldByNameIdxKey,
				IIntNetTldObj >();
		}
		IIntNetTldByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTld().newByNameIdxKey();
		key.setRequiredName( Name );
		IIntNetTldObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			IIntNetTld rec = schema.getIntNetBackingStore().getTableTld().readDerivedByNameIdx( null,
				Name );
			if( rec != null ) {
				obj = schema.getTldTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IIntNetTldObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IIntNetTldObj readCachedTldByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetTldObj obj = null;
		obj = readCachedTld( Id );
		return( obj );
	}

	@Override
	public List<IIntNetTldObj> readCachedTldByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedTldByTenantIdx";
		IIntNetTldByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTld().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IIntNetTldObj> arrayList = new ArrayList<IIntNetTldObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetTldObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IIntNetTldObj arr[] = new IIntNetTldObj[len];
				Iterator<IIntNetTldObj> valIter = dict.values().iterator();
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
			IIntNetTldObj obj;
			Iterator<IIntNetTldObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IIntNetTldObj> cmp = new Comparator<IIntNetTldObj>() {
			@Override
			public int compare( IIntNetTldObj lhs, IIntNetTldObj rhs ) {
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
	public IIntNetTldObj readCachedTldByNameIdx( String Name )
	{
		IIntNetTldObj obj = null;
		IIntNetTldByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTld().newByNameIdxKey();
		key.setRequiredName( Name );
		if( indexByNameIdx != null ) {
			if( indexByNameIdx.containsKey( key ) ) {
				obj = indexByNameIdx.get( key );
			}
			else {
				Iterator<IIntNetTldObj> valIter = members.values().iterator();
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
			Iterator<IIntNetTldObj> valIter = members.values().iterator();
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
	public void deepDisposeTldByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetTldObj obj = readCachedTldByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTldByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeTldByTenantIdx";
		IIntNetTldObj obj;
		List<IIntNetTldObj> arrayList = readCachedTldByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IIntNetTldObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTldByNameIdx( String Name )
	{
		IIntNetTldObj obj = readCachedTldByNameIdx( Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IIntNetTldObj updateTld( IIntNetTldObj Obj ) {
		IIntNetTldObj obj = Obj;
		schema.getIntNetBackingStore().getTableTld().updateTld( null,
			Obj.getTldRec() );
		obj = (IIntNetTldObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteTld( IIntNetTldObj Obj ) {
		IIntNetTldObj obj = Obj;
		schema.getIntNetBackingStore().getTableTld().deleteTld( null,
			obj.getTldRec() );
		Obj.forget();
	}

	@Override
	public void deleteTldByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetTldObj obj = readTld(Id);
		if( obj != null ) {
			IIntNetTldEditObj editObj = (IIntNetTldEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IIntNetTldEditObj)obj.beginEdit();
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
		deepDisposeTldByIdIdx( Id );
	}

	@Override
	public void deleteTldByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IIntNetTldByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTld().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IIntNetTldByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetTldObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetTldObj> dict = indexByTenantIdx.get( key );
			schema.getIntNetBackingStore().getTableTld().deleteTldByTenantIdx( null,
				TenantId );
			Iterator<IIntNetTldObj> iter = dict.values().iterator();
			IIntNetTldObj obj;
			List<IIntNetTldObj> toForget = new LinkedList<IIntNetTldObj>();
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
			schema.getIntNetBackingStore().getTableTld().deleteTldByTenantIdx( null,
				TenantId );
		}
		deepDisposeTldByTenantIdx( TenantId );
	}

	@Override
	public void deleteTldByNameIdx( String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< IIntNetTldByNameIdxKey,
				IIntNetTldObj >();
		}
		IIntNetTldByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTld().newByNameIdxKey();
		key.setRequiredName( Name );
		IIntNetTldObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			schema.getIntNetBackingStore().getTableTld().deleteTldByNameIdx( null,
				Name );
			obj.forget();
		}
		else {
			schema.getIntNetBackingStore().getTableTld().deleteTldByNameIdx( null,
				Name );
		}
		deepDisposeTldByNameIdx( Name );
	}
}