// Description: Java 25 Table Object implementation for SubProject.

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

public class BusModelSubProjectTableObj
	implements IBusModelSubProjectTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj> members;
	private Map<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj> allSubProject;
	private Map< IIntNetSubProjectByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj > > indexByTenantIdx;
	private Map< IIntNetSubProjectByTopProjectIdxKey,
		Map<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj > > indexByTopProjectIdx;
	private Map< IIntNetSubProjectByNameIdxKey,
		IIntNetSubProjectObj > indexByNameIdx;
	public static String TABLE_NAME = "SubProject";
	public static String TABLE_DBNAME = "sprjdef";

	public BusModelSubProjectTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj>();
		allSubProject = null;
		indexByTenantIdx = null;
		indexByTopProjectIdx = null;
		indexByNameIdx = null;
	}

	public BusModelSubProjectTableObj( IIntNetSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj>();
		allSubProject = null;
		indexByTenantIdx = null;
		indexByTopProjectIdx = null;
		indexByNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return IntNetSubProjectTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( IntNetSubProjectTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( IntNetSubProjectTableObj.getRuntimeClassCode() );
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
		allSubProject = null;
		indexByTenantIdx = null;
		indexByTopProjectIdx = null;
		indexByNameIdx = null;
		List<IIntNetSubProjectObj> toForget = new LinkedList<IIntNetSubProjectObj>();
		IIntNetSubProjectObj cur = null;
		Iterator<IIntNetSubProjectObj> iter = members.values().iterator();
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
	 *	BusModelSubProjectObj.
	 */
	@Override
	public IIntNetSubProjectObj newInstance() {
		IIntNetSubProjectObj inst = new BusModelSubProjectObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSubProjectObj.
	 */
	@Override
	public IIntNetSubProjectEditObj newEditInstance( IIntNetSubProjectObj orig ) {
		IIntNetSubProjectEditObj edit = new BusModelSubProjectEditObj( orig );
		return( edit );
	}

	@Override
	public IIntNetSubProjectObj constructByClassCode( int backingClassCode ) {
		IIntNetSubProjectObj obj = null;
		if( backingClassCode == IIntNetSubProject.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSubProjectTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public IIntNetSubProjectObj realiseSubProject( IIntNetSubProjectObj Obj ) {
		IIntNetSubProjectObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetSubProjectObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IIntNetSubProjectObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				IIntNetSubProjectByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByTopProjectIdx != null ) {
				IIntNetSubProjectByTopProjectIdxKey keyTopProjectIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByTopProjectIdxKey();
				keyTopProjectIdx.setRequiredTopProjectId( keepObj.getRequiredTopProjectId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj > mapTopProjectIdx = indexByTopProjectIdx.get( keyTopProjectIdx );
				if( mapTopProjectIdx != null ) {
					mapTopProjectIdx.remove( keepObj.getPKey() );
					if( mapTopProjectIdx.size() <= 0 ) {
						indexByTopProjectIdx.remove( keyTopProjectIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetSubProjectByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByNameIdxKey();
				keyNameIdx.setRequiredTopProjectId( keepObj.getRequiredTopProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IIntNetSubProjectByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTopProjectIdx != null ) {
				IIntNetSubProjectByTopProjectIdxKey keyTopProjectIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByTopProjectIdxKey();
				keyTopProjectIdx.setRequiredTopProjectId( keepObj.getRequiredTopProjectId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj > mapTopProjectIdx = indexByTopProjectIdx.get( keyTopProjectIdx );
				if( mapTopProjectIdx != null ) {
					mapTopProjectIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetSubProjectByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByNameIdxKey();
				keyNameIdx.setRequiredTopProjectId( keepObj.getRequiredTopProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( allSubProject != null ) {
				allSubProject.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSubProject != null ) {
				allSubProject.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IIntNetSubProjectByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTopProjectIdx != null ) {
				IIntNetSubProjectByTopProjectIdxKey keyTopProjectIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByTopProjectIdxKey();
				keyTopProjectIdx.setRequiredTopProjectId( keepObj.getRequiredTopProjectId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj > mapTopProjectIdx = indexByTopProjectIdx.get( keyTopProjectIdx );
				if( mapTopProjectIdx != null ) {
					mapTopProjectIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetSubProjectByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByNameIdxKey();
				keyNameIdx.setRequiredTopProjectId( keepObj.getRequiredTopProjectId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public IIntNetSubProjectObj createSubProject( IIntNetSubProjectObj Obj ) {
		IIntNetSubProjectObj obj = Obj;
		IIntNetSubProject rec = obj.getSubProjectRec();
		schema.getIntNetBackingStore().getTableSubProject().createSubProject(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public IIntNetSubProjectObj readSubProject( $implCommaIJavaOptAtomType$ pkey ) {
		return( readSubProject( pkey, false ) );
	}

	@Override
	public IIntNetSubProjectObj readSubProject( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IIntNetSubProjectObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IIntNetSubProject readRec = schema.getIntNetBackingStore().getTableSubProject().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getSubProjectTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IIntNetSubProjectObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IIntNetSubProjectObj readCachedSubProject( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetSubProjectObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSubProject( IIntNetSubProjectObj obj )
	{
		final String S_ProcName = "BusModelSubProjectTableObj.reallyDeepDisposeSubProject() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetSubProjectObj existing = readCachedSubProject( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IIntNetSubProjectByTenantIdxKey keyTenantIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IIntNetSubProjectByTopProjectIdxKey keyTopProjectIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByTopProjectIdxKey();
		keyTopProjectIdx.setRequiredTopProjectId( existing.getRequiredTopProjectId() );

		IIntNetSubProjectByNameIdxKey keyNameIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByNameIdxKey();
		keyNameIdx.setRequiredTopProjectId( existing.getRequiredTopProjectId() );
		keyNameIdx.setRequiredName( existing.getRequiredName() );


					schema.getMajorVersionTableObj().deepDisposeMajorVersionBySubProjectIdx( existing.getRequiredId() );

		if( indexByTenantIdx != null ) {
			if( indexByTenantIdx.containsKey( keyTenantIdx ) ) {
				indexByTenantIdx.get( keyTenantIdx ).remove( pkey );
				if( indexByTenantIdx.get( keyTenantIdx ).size() <= 0 ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}
		}

		if( indexByTopProjectIdx != null ) {
			if( indexByTopProjectIdx.containsKey( keyTopProjectIdx ) ) {
				indexByTopProjectIdx.get( keyTopProjectIdx ).remove( pkey );
				if( indexByTopProjectIdx.get( keyTopProjectIdx ).size() <= 0 ) {
					indexByTopProjectIdx.remove( keyTopProjectIdx );
				}
			}
		}

		if( indexByNameIdx != null ) {
			indexByNameIdx.remove( keyNameIdx );
		}


	}
	@Override
	public void deepDisposeSubProject( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetSubProjectObj obj = readCachedSubProject( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IIntNetSubProjectObj lockSubProject( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetSubProjectObj locked = null;
		IIntNetSubProject lockRec = schema.getIntNetBackingStore().getTableSubProject().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSubProjectTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IIntNetSubProjectObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSubProject", pkey );
		}
		return( locked );
	}

	@Override
	public List<IIntNetSubProjectObj> readAllSubProject() {
		return( readAllSubProject( false ) );
	}

	@Override
	public List<IIntNetSubProjectObj> readAllSubProject( boolean forceRead ) {
		final String S_ProcName = "readAllSubProject";
		if( ( allSubProject == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj> map = new HashMap<$implCommaIJavaOptAtomType$,IIntNetSubProjectObj>();
			allSubProject = map;
			IIntNetSubProject[] recList = schema.getIntNetBackingStore().getTableSubProject().readAllDerived( null );
			IIntNetSubProject rec;
			IIntNetSubProjectObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetSubProjectObj realised = (IIntNetSubProjectObj)obj.realise();
			}
		}
		int len = allSubProject.size();
		IIntNetSubProjectObj arr[] = new IIntNetSubProjectObj[len];
		Iterator<IIntNetSubProjectObj> valIter = allSubProject.values().iterator();
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
		ArrayList<IIntNetSubProjectObj> arrayList = new ArrayList<IIntNetSubProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetSubProjectObj> cmp = new Comparator<IIntNetSubProjectObj>() {
			@Override
			public int compare( IIntNetSubProjectObj lhs, IIntNetSubProjectObj rhs ) {
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
		List<IIntNetSubProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IIntNetSubProjectObj> readCachedAllSubProject() {
		final String S_ProcName = "readCachedAllSubProject";
		ArrayList<IIntNetSubProjectObj> arrayList = new ArrayList<IIntNetSubProjectObj>();
		if( allSubProject != null ) {
			int len = allSubProject.size();
			IIntNetSubProjectObj arr[] = new IIntNetSubProjectObj[len];
			Iterator<IIntNetSubProjectObj> valIter = allSubProject.values().iterator();
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
		Comparator<IIntNetSubProjectObj> cmp = new Comparator<IIntNetSubProjectObj>() {
			public int compare( IIntNetSubProjectObj lhs, IIntNetSubProjectObj rhs ) {
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
	public IIntNetSubProjectObj readSubProjectByIdIdx( IYCFKeyHash256 Id )
	{
		return( readSubProjectByIdIdx( Id,
			false ) );
	}

	@Override
	public IIntNetSubProjectObj readSubProjectByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IIntNetSubProjectObj obj = readSubProject( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IIntNetSubProjectObj> readSubProjectByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readSubProjectByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IIntNetSubProjectObj> readSubProjectByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readSubProjectByTenantIdx";
		IIntNetSubProjectByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IIntNetSubProjectByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetSubProjectObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj>();
			IIntNetSubProjectObj obj;
			IIntNetSubProject[] recList = schema.getIntNetBackingStore().getTableSubProject().readDerivedByTenantIdx( null,
				TenantId );
			IIntNetSubProject rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSubProjectTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetSubProjectObj realised = (IIntNetSubProjectObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IIntNetSubProjectObj arr[] = new IIntNetSubProjectObj[len];
		Iterator<IIntNetSubProjectObj> valIter = dict.values().iterator();
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
		ArrayList<IIntNetSubProjectObj> arrayList = new ArrayList<IIntNetSubProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetSubProjectObj> cmp = new Comparator<IIntNetSubProjectObj>() {
			@Override
			public int compare( IIntNetSubProjectObj lhs, IIntNetSubProjectObj rhs ) {
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
		List<IIntNetSubProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IIntNetSubProjectObj> readSubProjectByTopProjectIdx( IYCFKeyHash256 TopProjectId )
	{
		return( readSubProjectByTopProjectIdx( TopProjectId,
			false ) );
	}

	@Override
	public List<IIntNetSubProjectObj> readSubProjectByTopProjectIdx( IYCFKeyHash256 TopProjectId,
		boolean forceRead )
	{
		final String S_ProcName = "readSubProjectByTopProjectIdx";
		IIntNetSubProjectByTopProjectIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByTopProjectIdxKey();
		key.setRequiredTopProjectId( TopProjectId );
		Map<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj> dict;
		if( indexByTopProjectIdx == null ) {
			indexByTopProjectIdx = new HashMap< IIntNetSubProjectByTopProjectIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetSubProjectObj > >();
		}
		if( ( ! forceRead ) && indexByTopProjectIdx.containsKey( key ) ) {
			dict = indexByTopProjectIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj>();
			IIntNetSubProjectObj obj;
			IIntNetSubProject[] recList = schema.getIntNetBackingStore().getTableSubProject().readDerivedByTopProjectIdx( null,
				TopProjectId );
			IIntNetSubProject rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSubProjectTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetSubProjectObj realised = (IIntNetSubProjectObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTopProjectIdx.put( key, dict );
		}
		int len = dict.size();
		IIntNetSubProjectObj arr[] = new IIntNetSubProjectObj[len];
		Iterator<IIntNetSubProjectObj> valIter = dict.values().iterator();
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
		ArrayList<IIntNetSubProjectObj> arrayList = new ArrayList<IIntNetSubProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetSubProjectObj> cmp = new Comparator<IIntNetSubProjectObj>() {
			@Override
			public int compare( IIntNetSubProjectObj lhs, IIntNetSubProjectObj rhs ) {
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
		List<IIntNetSubProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IIntNetSubProjectObj readSubProjectByNameIdx( IYCFKeyHash256 TopProjectId,
		String Name )
	{
		return( readSubProjectByNameIdx( TopProjectId,
			Name,
			false ) );
	}

	@Override
	public IIntNetSubProjectObj readSubProjectByNameIdx( IYCFKeyHash256 TopProjectId,
		String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< IIntNetSubProjectByNameIdxKey,
				IIntNetSubProjectObj >();
		}
		IIntNetSubProjectByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByNameIdxKey();
		key.setRequiredTopProjectId( TopProjectId );
		key.setRequiredName( Name );
		IIntNetSubProjectObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			IIntNetSubProject rec = schema.getIntNetBackingStore().getTableSubProject().readDerivedByNameIdx( null,
				TopProjectId,
				Name );
			if( rec != null ) {
				obj = schema.getSubProjectTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IIntNetSubProjectObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IIntNetSubProjectObj readCachedSubProjectByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetSubProjectObj obj = null;
		obj = readCachedSubProject( Id );
		return( obj );
	}

	@Override
	public List<IIntNetSubProjectObj> readCachedSubProjectByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedSubProjectByTenantIdx";
		IIntNetSubProjectByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IIntNetSubProjectObj> arrayList = new ArrayList<IIntNetSubProjectObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IIntNetSubProjectObj arr[] = new IIntNetSubProjectObj[len];
				Iterator<IIntNetSubProjectObj> valIter = dict.values().iterator();
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
			IIntNetSubProjectObj obj;
			Iterator<IIntNetSubProjectObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IIntNetSubProjectObj> cmp = new Comparator<IIntNetSubProjectObj>() {
			@Override
			public int compare( IIntNetSubProjectObj lhs, IIntNetSubProjectObj rhs ) {
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
	public List<IIntNetSubProjectObj> readCachedSubProjectByTopProjectIdx( IYCFKeyHash256 TopProjectId )
	{
		final String S_ProcName = "readCachedSubProjectByTopProjectIdx";
		IIntNetSubProjectByTopProjectIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByTopProjectIdxKey();
		key.setRequiredTopProjectId( TopProjectId );
		ArrayList<IIntNetSubProjectObj> arrayList = new ArrayList<IIntNetSubProjectObj>();
		if( indexByTopProjectIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj> dict;
			if( indexByTopProjectIdx.containsKey( key ) ) {
				dict = indexByTopProjectIdx.get( key );
				int len = dict.size();
				IIntNetSubProjectObj arr[] = new IIntNetSubProjectObj[len];
				Iterator<IIntNetSubProjectObj> valIter = dict.values().iterator();
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
			IIntNetSubProjectObj obj;
			Iterator<IIntNetSubProjectObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IIntNetSubProjectObj> cmp = new Comparator<IIntNetSubProjectObj>() {
			@Override
			public int compare( IIntNetSubProjectObj lhs, IIntNetSubProjectObj rhs ) {
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
	public IIntNetSubProjectObj readCachedSubProjectByNameIdx( IYCFKeyHash256 TopProjectId,
		String Name )
	{
		IIntNetSubProjectObj obj = null;
		IIntNetSubProjectByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByNameIdxKey();
		key.setRequiredTopProjectId( TopProjectId );
		key.setRequiredName( Name );
		if( indexByNameIdx != null ) {
			if( indexByNameIdx.containsKey( key ) ) {
				obj = indexByNameIdx.get( key );
			}
			else {
				Iterator<IIntNetSubProjectObj> valIter = members.values().iterator();
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
			Iterator<IIntNetSubProjectObj> valIter = members.values().iterator();
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
	public void deepDisposeSubProjectByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetSubProjectObj obj = readCachedSubProjectByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSubProjectByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeSubProjectByTenantIdx";
		IIntNetSubProjectObj obj;
		List<IIntNetSubProjectObj> arrayList = readCachedSubProjectByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IIntNetSubProjectObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSubProjectByTopProjectIdx( IYCFKeyHash256 TopProjectId )
	{
		final String S_ProcName = "deepDisposeSubProjectByTopProjectIdx";
		IIntNetSubProjectObj obj;
		List<IIntNetSubProjectObj> arrayList = readCachedSubProjectByTopProjectIdx( TopProjectId );
		if( arrayList != null )  {
			Iterator<IIntNetSubProjectObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSubProjectByNameIdx( IYCFKeyHash256 TopProjectId,
		String Name )
	{
		IIntNetSubProjectObj obj = readCachedSubProjectByNameIdx( TopProjectId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IIntNetSubProjectObj updateSubProject( IIntNetSubProjectObj Obj ) {
		IIntNetSubProjectObj obj = Obj;
		schema.getIntNetBackingStore().getTableSubProject().updateSubProject( null,
			Obj.getSubProjectRec() );
		obj = (IIntNetSubProjectObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSubProject( IIntNetSubProjectObj Obj ) {
		IIntNetSubProjectObj obj = Obj;
		schema.getIntNetBackingStore().getTableSubProject().deleteSubProject( null,
			obj.getSubProjectRec() );
		Obj.forget();
	}

	@Override
	public void deleteSubProjectByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetSubProjectObj obj = readSubProject(Id);
		if( obj != null ) {
			IIntNetSubProjectEditObj editObj = (IIntNetSubProjectEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IIntNetSubProjectEditObj)obj.beginEdit();
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
		deepDisposeSubProjectByIdIdx( Id );
	}

	@Override
	public void deleteSubProjectByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IIntNetSubProjectByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IIntNetSubProjectByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetSubProjectObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj> dict = indexByTenantIdx.get( key );
			schema.getIntNetBackingStore().getTableSubProject().deleteSubProjectByTenantIdx( null,
				TenantId );
			Iterator<IIntNetSubProjectObj> iter = dict.values().iterator();
			IIntNetSubProjectObj obj;
			List<IIntNetSubProjectObj> toForget = new LinkedList<IIntNetSubProjectObj>();
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
			schema.getIntNetBackingStore().getTableSubProject().deleteSubProjectByTenantIdx( null,
				TenantId );
		}
		deepDisposeSubProjectByTenantIdx( TenantId );
	}

	@Override
	public void deleteSubProjectByTopProjectIdx( IYCFKeyHash256 TopProjectId )
	{
		IIntNetSubProjectByTopProjectIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByTopProjectIdxKey();
		key.setRequiredTopProjectId( TopProjectId );
		if( indexByTopProjectIdx == null ) {
			indexByTopProjectIdx = new HashMap< IIntNetSubProjectByTopProjectIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetSubProjectObj > >();
		}
		if( indexByTopProjectIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetSubProjectObj> dict = indexByTopProjectIdx.get( key );
			schema.getIntNetBackingStore().getTableSubProject().deleteSubProjectByTopProjectIdx( null,
				TopProjectId );
			Iterator<IIntNetSubProjectObj> iter = dict.values().iterator();
			IIntNetSubProjectObj obj;
			List<IIntNetSubProjectObj> toForget = new LinkedList<IIntNetSubProjectObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByTopProjectIdx.remove( key );
		}
		else {
			schema.getIntNetBackingStore().getTableSubProject().deleteSubProjectByTopProjectIdx( null,
				TopProjectId );
		}
		deepDisposeSubProjectByTopProjectIdx( TopProjectId );
	}

	@Override
	public void deleteSubProjectByNameIdx( IYCFKeyHash256 TopProjectId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< IIntNetSubProjectByNameIdxKey,
				IIntNetSubProjectObj >();
		}
		IIntNetSubProjectByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newByNameIdxKey();
		key.setRequiredTopProjectId( TopProjectId );
		key.setRequiredName( Name );
		IIntNetSubProjectObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			schema.getIntNetBackingStore().getTableSubProject().deleteSubProjectByNameIdx( null,
				TopProjectId,
				Name );
			obj.forget();
		}
		else {
			schema.getIntNetBackingStore().getTableSubProject().deleteSubProjectByNameIdx( null,
				TopProjectId,
				Name );
		}
		deepDisposeSubProjectByNameIdx( TopProjectId,
				Name );
	}
}