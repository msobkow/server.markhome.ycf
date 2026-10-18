// Description: Java 25 Table Object implementation for Cluster.

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

public class BusModelClusterTableObj
	implements IBusModelClusterTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureClusterObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureClusterObj> allCluster;
	private Map< ISecureClusterByUDomNameIdxKey,
		ISecureClusterObj > indexByUDomNameIdx;
	private Map< ISecureClusterByUDescrIdxKey,
		ISecureClusterObj > indexByUDescrIdx;
	public static String TABLE_NAME = "Cluster";
	public static String TABLE_DBNAME = "clus";

	public BusModelClusterTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureClusterObj>();
		allCluster = null;
		indexByUDomNameIdx = null;
		indexByUDescrIdx = null;
	}

	public BusModelClusterTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureClusterObj>();
		allCluster = null;
		indexByUDomNameIdx = null;
		indexByUDescrIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureClusterTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureClusterTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureClusterTableObj.getRuntimeClassCode() );
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
		allCluster = null;
		indexByUDomNameIdx = null;
		indexByUDescrIdx = null;
		List<ISecureClusterObj> toForget = new LinkedList<ISecureClusterObj>();
		ISecureClusterObj cur = null;
		Iterator<ISecureClusterObj> iter = members.values().iterator();
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
	 *	BusModelClusterObj.
	 */
	@Override
	public ISecureClusterObj newInstance() {
		ISecureClusterObj inst = new BusModelClusterObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelClusterObj.
	 */
	@Override
	public ISecureClusterEditObj newEditInstance( ISecureClusterObj orig ) {
		ISecureClusterEditObj edit = new BusModelClusterEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureClusterObj constructByClassCode( int backingClassCode ) {
		ISecureClusterObj obj = null;
		if( backingClassCode == ISecureCluster.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getClusterTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureClusterObj realiseCluster( ISecureClusterObj Obj ) {
		ISecureClusterObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureClusterObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureClusterObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUDomNameIdx != null ) {
				ISecureClusterByUDomNameIdxKey keyUDomNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryCluster().newByUDomNameIdxKey();
				keyUDomNameIdx.setRequiredFullDomName( keepObj.getRequiredFullDomName() );
				indexByUDomNameIdx.remove( keyUDomNameIdx );
			}

			if( indexByUDescrIdx != null ) {
				ISecureClusterByUDescrIdxKey keyUDescrIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryCluster().newByUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.remove( keyUDescrIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUDomNameIdx != null ) {
				ISecureClusterByUDomNameIdxKey keyUDomNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryCluster().newByUDomNameIdxKey();
				keyUDomNameIdx.setRequiredFullDomName( keepObj.getRequiredFullDomName() );
				indexByUDomNameIdx.put( keyUDomNameIdx, keepObj );
			}

			if( indexByUDescrIdx != null ) {
				ISecureClusterByUDescrIdxKey keyUDescrIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryCluster().newByUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.put( keyUDescrIdx, keepObj );
			}

			if( allCluster != null ) {
				allCluster.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allCluster != null ) {
				allCluster.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUDomNameIdx != null ) {
				ISecureClusterByUDomNameIdxKey keyUDomNameIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryCluster().newByUDomNameIdxKey();
				keyUDomNameIdx.setRequiredFullDomName( keepObj.getRequiredFullDomName() );
				indexByUDomNameIdx.put( keyUDomNameIdx, keepObj );
			}

			if( indexByUDescrIdx != null ) {
				ISecureClusterByUDescrIdxKey keyUDescrIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactoryCluster().newByUDescrIdxKey();
				keyUDescrIdx.setRequiredDescription( keepObj.getRequiredDescription() );
				indexByUDescrIdx.put( keyUDescrIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureClusterObj createCluster( ISecureClusterObj Obj ) {
		ISecureClusterObj obj = Obj;
		ISecureCluster rec = obj.getClusterRec();
		schema.getSecureBackingStore().getTableCluster().createCluster(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureClusterObj readCluster( $implCommaIJavaOptAtomType$ pkey ) {
		return( readCluster( pkey, false ) );
	}

	@Override
	public ISecureClusterObj readCluster( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureClusterObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureCluster readRec = schema.getSecureBackingStore().getTableCluster().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getClusterTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureClusterObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureClusterObj readCachedCluster( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureClusterObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeCluster( ISecureClusterObj obj )
	{
		final String S_ProcName = "BusModelClusterTableObj.reallyDeepDisposeCluster() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureClusterObj existing = readCachedCluster( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureClusterByUDomNameIdxKey keyUDomNameIdx = schema.getSecureBackingStore().getSecureFactory().getFactoryCluster().newByUDomNameIdxKey();
		keyUDomNameIdx.setRequiredFullDomName( existing.getRequiredFullDomName() );

		ISecureClusterByUDescrIdxKey keyUDescrIdx = schema.getSecureBackingStore().getSecureFactory().getFactoryCluster().newByUDescrIdxKey();
		keyUDescrIdx.setRequiredDescription( existing.getRequiredDescription() );


					schema.getSecClusRoleTableObj().deepDisposeSecClusRoleByClusterIdx( existing.getRequiredId() );
					schema.getSecClusGrpTableObj().deepDisposeSecClusGrpByClusterIdx( existing.getRequiredId() );
					schema.getTenantTableObj().deepDisposeTenantByClusterIdx( existing.getRequiredId() );

		if( indexByUDomNameIdx != null ) {
			indexByUDomNameIdx.remove( keyUDomNameIdx );
		}

		if( indexByUDescrIdx != null ) {
			indexByUDescrIdx.remove( keyUDescrIdx );
		}


	}
	@Override
	public void deepDisposeCluster( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureClusterObj obj = readCachedCluster( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureClusterObj lockCluster( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureClusterObj locked = null;
		ISecureCluster lockRec = schema.getSecureBackingStore().getTableCluster().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getClusterTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureClusterObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockCluster", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureClusterObj> readAllCluster() {
		return( readAllCluster( false ) );
	}

	@Override
	public List<ISecureClusterObj> readAllCluster( boolean forceRead ) {
		final String S_ProcName = "readAllCluster";
		if( ( allCluster == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureClusterObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureClusterObj>();
			allCluster = map;
			ISecureCluster[] recList = schema.getSecureBackingStore().getTableCluster().readAllDerived( null );
			ISecureCluster rec;
			ISecureClusterObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureClusterObj realised = (ISecureClusterObj)obj.realise();
			}
		}
		int len = allCluster.size();
		ISecureClusterObj arr[] = new ISecureClusterObj[len];
		Iterator<ISecureClusterObj> valIter = allCluster.values().iterator();
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
		ArrayList<ISecureClusterObj> arrayList = new ArrayList<ISecureClusterObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureClusterObj> cmp = new Comparator<ISecureClusterObj>() {
			@Override
			public int compare( ISecureClusterObj lhs, ISecureClusterObj rhs ) {
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
		List<ISecureClusterObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureClusterObj> readCachedAllCluster() {
		final String S_ProcName = "readCachedAllCluster";
		ArrayList<ISecureClusterObj> arrayList = new ArrayList<ISecureClusterObj>();
		if( allCluster != null ) {
			int len = allCluster.size();
			ISecureClusterObj arr[] = new ISecureClusterObj[len];
			Iterator<ISecureClusterObj> valIter = allCluster.values().iterator();
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
		Comparator<ISecureClusterObj> cmp = new Comparator<ISecureClusterObj>() {
			public int compare( ISecureClusterObj lhs, ISecureClusterObj rhs ) {
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
	 *	Return a sorted map of a page of the Cluster-derived instances in the database.
	 *
	 *	@return	List of ISecureClusterObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	@Override
	public List<ISecureClusterObj> pageAllCluster(IYCFKeyHash256 priorId )
	{
		final String S_ProcName = "pageAllCluster";
		Map<$implCommaIJavaOptAtomType$, ISecureClusterObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureClusterObj>();
		ISecureCluster[] recList = schema.getSecureBackingStore().getTableCluster().pageAllRec( null,
			priorId );
		ISecureCluster rec;
		ISecureClusterObj obj;
		ISecureClusterObj realised;
		ArrayList<ISecureClusterObj> arrayList = new ArrayList<ISecureClusterObj>( recList.length );
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			realised = (ISecureClusterObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	@Override
	public ISecureClusterObj readClusterByIdIdx( IYCFKeyHash256 Id )
	{
		return( readClusterByIdIdx( Id,
			false ) );
	}

	@Override
	public ISecureClusterObj readClusterByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		ISecureClusterObj obj = readCluster( Id, forceRead );
		return( obj );
	}

	@Override
	public ISecureClusterObj readClusterByUDomNameIdx( String FullDomName )
	{
		return( readClusterByUDomNameIdx( FullDomName,
			false ) );
	}

	@Override
	public ISecureClusterObj readClusterByUDomNameIdx( String FullDomName, boolean forceRead )
	{
		if( indexByUDomNameIdx == null ) {
			indexByUDomNameIdx = new HashMap< ISecureClusterByUDomNameIdxKey,
				ISecureClusterObj >();
		}
		ISecureClusterByUDomNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryCluster().newByUDomNameIdxKey();
		key.setRequiredFullDomName( FullDomName );
		ISecureClusterObj obj = null;
		if( ( ! forceRead ) && indexByUDomNameIdx.containsKey( key ) ) {
			obj = indexByUDomNameIdx.get( key );
		}
		else {
			ISecureCluster rec = schema.getSecureBackingStore().getTableCluster().readDerivedByUDomNameIdx( null,
				FullDomName );
			if( rec != null ) {
				obj = schema.getClusterTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureClusterObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureClusterObj readClusterByUDescrIdx( String Description )
	{
		return( readClusterByUDescrIdx( Description,
			false ) );
	}

	@Override
	public ISecureClusterObj readClusterByUDescrIdx( String Description, boolean forceRead )
	{
		if( indexByUDescrIdx == null ) {
			indexByUDescrIdx = new HashMap< ISecureClusterByUDescrIdxKey,
				ISecureClusterObj >();
		}
		ISecureClusterByUDescrIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryCluster().newByUDescrIdxKey();
		key.setRequiredDescription( Description );
		ISecureClusterObj obj = null;
		if( ( ! forceRead ) && indexByUDescrIdx.containsKey( key ) ) {
			obj = indexByUDescrIdx.get( key );
		}
		else {
			ISecureCluster rec = schema.getSecureBackingStore().getTableCluster().readDerivedByUDescrIdx( null,
				Description );
			if( rec != null ) {
				obj = schema.getClusterTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureClusterObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureClusterObj readCachedClusterByIdIdx( IYCFKeyHash256 Id )
	{
		ISecureClusterObj obj = null;
		obj = readCachedCluster( Id );
		return( obj );
	}

	@Override
	public ISecureClusterObj readCachedClusterByUDomNameIdx( String FullDomName )
	{
		ISecureClusterObj obj = null;
		ISecureClusterByUDomNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryCluster().newByUDomNameIdxKey();
		key.setRequiredFullDomName( FullDomName );
		if( indexByUDomNameIdx != null ) {
			if( indexByUDomNameIdx.containsKey( key ) ) {
				obj = indexByUDomNameIdx.get( key );
			}
			else {
				Iterator<ISecureClusterObj> valIter = members.values().iterator();
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
			Iterator<ISecureClusterObj> valIter = members.values().iterator();
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
	public ISecureClusterObj readCachedClusterByUDescrIdx( String Description )
	{
		ISecureClusterObj obj = null;
		ISecureClusterByUDescrIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryCluster().newByUDescrIdxKey();
		key.setRequiredDescription( Description );
		if( indexByUDescrIdx != null ) {
			if( indexByUDescrIdx.containsKey( key ) ) {
				obj = indexByUDescrIdx.get( key );
			}
			else {
				Iterator<ISecureClusterObj> valIter = members.values().iterator();
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
			Iterator<ISecureClusterObj> valIter = members.values().iterator();
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
	public void deepDisposeClusterByIdIdx( IYCFKeyHash256 Id )
	{
		ISecureClusterObj obj = readCachedClusterByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeClusterByUDomNameIdx( String FullDomName )
	{
		ISecureClusterObj obj = readCachedClusterByUDomNameIdx( FullDomName );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeClusterByUDescrIdx( String Description )
	{
		ISecureClusterObj obj = readCachedClusterByUDescrIdx( Description );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureClusterObj updateCluster( ISecureClusterObj Obj ) {
		ISecureClusterObj obj = Obj;
		schema.getSecureBackingStore().getTableCluster().updateCluster( null,
			Obj.getClusterRec() );
		obj = (ISecureClusterObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteCluster( ISecureClusterObj Obj ) {
		ISecureClusterObj obj = Obj;
		schema.getSecureBackingStore().getTableCluster().deleteCluster( null,
			obj.getClusterRec() );
		Obj.forget();
	}

	@Override
	public void deleteClusterByIdIdx( IYCFKeyHash256 Id )
	{
		ISecureClusterObj obj = readCluster(Id);
		if( obj != null ) {
			ISecureClusterEditObj editObj = (ISecureClusterEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureClusterEditObj)obj.beginEdit();
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
		deepDisposeClusterByIdIdx( Id );
	}

	@Override
	public void deleteClusterByUDomNameIdx( String FullDomName )
	{
		if( indexByUDomNameIdx == null ) {
			indexByUDomNameIdx = new HashMap< ISecureClusterByUDomNameIdxKey,
				ISecureClusterObj >();
		}
		ISecureClusterByUDomNameIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryCluster().newByUDomNameIdxKey();
		key.setRequiredFullDomName( FullDomName );
		ISecureClusterObj obj = null;
		if( indexByUDomNameIdx.containsKey( key ) ) {
			obj = indexByUDomNameIdx.get( key );
			schema.getSecureBackingStore().getTableCluster().deleteClusterByUDomNameIdx( null,
				FullDomName );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableCluster().deleteClusterByUDomNameIdx( null,
				FullDomName );
		}
		deepDisposeClusterByUDomNameIdx( FullDomName );
	}

	@Override
	public void deleteClusterByUDescrIdx( String Description )
	{
		if( indexByUDescrIdx == null ) {
			indexByUDescrIdx = new HashMap< ISecureClusterByUDescrIdxKey,
				ISecureClusterObj >();
		}
		ISecureClusterByUDescrIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactoryCluster().newByUDescrIdxKey();
		key.setRequiredDescription( Description );
		ISecureClusterObj obj = null;
		if( indexByUDescrIdx.containsKey( key ) ) {
			obj = indexByUDescrIdx.get( key );
			schema.getSecureBackingStore().getTableCluster().deleteClusterByUDescrIdx( null,
				Description );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableCluster().deleteClusterByUDescrIdx( null,
				Description );
		}
		deepDisposeClusterByUDescrIdx( Description );
	}
}