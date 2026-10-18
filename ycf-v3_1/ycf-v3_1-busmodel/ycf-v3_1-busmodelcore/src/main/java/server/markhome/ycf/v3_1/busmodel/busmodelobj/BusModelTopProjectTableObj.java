// Description: Java 25 Table Object implementation for TopProject.

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

public class BusModelTopProjectTableObj
	implements IBusModelTopProjectTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj> members;
	private Map<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj> allTopProject;
	private Map< IIntNetTopProjectByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj > > indexByTenantIdx;
	private Map< IIntNetTopProjectByTopDomainIdxKey,
		Map<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj > > indexByTopDomainIdx;
	private Map< IIntNetTopProjectByNameIdxKey,
		IIntNetTopProjectObj > indexByNameIdx;
	public static String TABLE_NAME = "TopProject";
	public static String TABLE_DBNAME = "tprjdef";

	public BusModelTopProjectTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj>();
		allTopProject = null;
		indexByTenantIdx = null;
		indexByTopDomainIdx = null;
		indexByNameIdx = null;
	}

	public BusModelTopProjectTableObj( IIntNetSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj>();
		allTopProject = null;
		indexByTenantIdx = null;
		indexByTopDomainIdx = null;
		indexByNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return IntNetTopProjectTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( IntNetTopProjectTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( IntNetTopProjectTableObj.getRuntimeClassCode() );
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
		allTopProject = null;
		indexByTenantIdx = null;
		indexByTopDomainIdx = null;
		indexByNameIdx = null;
		List<IIntNetTopProjectObj> toForget = new LinkedList<IIntNetTopProjectObj>();
		IIntNetTopProjectObj cur = null;
		Iterator<IIntNetTopProjectObj> iter = members.values().iterator();
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
	 *	BusModelTopProjectObj.
	 */
	@Override
	public IIntNetTopProjectObj newInstance() {
		IIntNetTopProjectObj inst = new BusModelTopProjectObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelTopProjectObj.
	 */
	@Override
	public IIntNetTopProjectEditObj newEditInstance( IIntNetTopProjectObj orig ) {
		IIntNetTopProjectEditObj edit = new BusModelTopProjectEditObj( orig );
		return( edit );
	}

	@Override
	public IIntNetTopProjectObj constructByClassCode( int backingClassCode ) {
		IIntNetTopProjectObj obj = null;
		if( backingClassCode == IIntNetTopProject.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getTopProjectTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public IIntNetTopProjectObj realiseTopProject( IIntNetTopProjectObj Obj ) {
		IIntNetTopProjectObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetTopProjectObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IIntNetTopProjectObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				IIntNetTopProjectByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByTopDomainIdx != null ) {
				IIntNetTopProjectByTopDomainIdxKey keyTopDomainIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByTopDomainIdxKey();
				keyTopDomainIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj > mapTopDomainIdx = indexByTopDomainIdx.get( keyTopDomainIdx );
				if( mapTopDomainIdx != null ) {
					mapTopDomainIdx.remove( keepObj.getPKey() );
					if( mapTopDomainIdx.size() <= 0 ) {
						indexByTopDomainIdx.remove( keyTopDomainIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetTopProjectByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByNameIdxKey();
				keyNameIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IIntNetTopProjectByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTopDomainIdx != null ) {
				IIntNetTopProjectByTopDomainIdxKey keyTopDomainIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByTopDomainIdxKey();
				keyTopDomainIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj > mapTopDomainIdx = indexByTopDomainIdx.get( keyTopDomainIdx );
				if( mapTopDomainIdx != null ) {
					mapTopDomainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetTopProjectByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByNameIdxKey();
				keyNameIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( allTopProject != null ) {
				allTopProject.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTopProject != null ) {
				allTopProject.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IIntNetTopProjectByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTopDomainIdx != null ) {
				IIntNetTopProjectByTopDomainIdxKey keyTopDomainIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByTopDomainIdxKey();
				keyTopDomainIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj > mapTopDomainIdx = indexByTopDomainIdx.get( keyTopDomainIdx );
				if( mapTopDomainIdx != null ) {
					mapTopDomainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetTopProjectByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByNameIdxKey();
				keyNameIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public IIntNetTopProjectObj createTopProject( IIntNetTopProjectObj Obj ) {
		IIntNetTopProjectObj obj = Obj;
		IIntNetTopProject rec = obj.getTopProjectRec();
		schema.getIntNetBackingStore().getTableTopProject().createTopProject(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public IIntNetTopProjectObj readTopProject( $implCommaIJavaOptAtomType$ pkey ) {
		return( readTopProject( pkey, false ) );
	}

	@Override
	public IIntNetTopProjectObj readTopProject( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IIntNetTopProjectObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IIntNetTopProject readRec = schema.getIntNetBackingStore().getTableTopProject().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getTopProjectTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IIntNetTopProjectObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IIntNetTopProjectObj readCachedTopProject( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetTopProjectObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeTopProject( IIntNetTopProjectObj obj )
	{
		final String S_ProcName = "BusModelTopProjectTableObj.reallyDeepDisposeTopProject() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetTopProjectObj existing = readCachedTopProject( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IIntNetTopProjectByTenantIdxKey keyTenantIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IIntNetTopProjectByTopDomainIdxKey keyTopDomainIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByTopDomainIdxKey();
		keyTopDomainIdx.setRequiredTopDomainId( existing.getRequiredTopDomainId() );

		IIntNetTopProjectByNameIdxKey keyNameIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByNameIdxKey();
		keyNameIdx.setRequiredTopDomainId( existing.getRequiredTopDomainId() );
		keyNameIdx.setRequiredName( existing.getRequiredName() );


					schema.getSubProjectTableObj().deepDisposeSubProjectByTopProjectIdx( existing.getRequiredId() );

		if( indexByTenantIdx != null ) {
			if( indexByTenantIdx.containsKey( keyTenantIdx ) ) {
				indexByTenantIdx.get( keyTenantIdx ).remove( pkey );
				if( indexByTenantIdx.get( keyTenantIdx ).size() <= 0 ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}
		}

		if( indexByTopDomainIdx != null ) {
			if( indexByTopDomainIdx.containsKey( keyTopDomainIdx ) ) {
				indexByTopDomainIdx.get( keyTopDomainIdx ).remove( pkey );
				if( indexByTopDomainIdx.get( keyTopDomainIdx ).size() <= 0 ) {
					indexByTopDomainIdx.remove( keyTopDomainIdx );
				}
			}
		}

		if( indexByNameIdx != null ) {
			indexByNameIdx.remove( keyNameIdx );
		}


	}
	@Override
	public void deepDisposeTopProject( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetTopProjectObj obj = readCachedTopProject( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IIntNetTopProjectObj lockTopProject( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetTopProjectObj locked = null;
		IIntNetTopProject lockRec = schema.getIntNetBackingStore().getTableTopProject().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getTopProjectTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IIntNetTopProjectObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockTopProject", pkey );
		}
		return( locked );
	}

	@Override
	public List<IIntNetTopProjectObj> readAllTopProject() {
		return( readAllTopProject( false ) );
	}

	@Override
	public List<IIntNetTopProjectObj> readAllTopProject( boolean forceRead ) {
		final String S_ProcName = "readAllTopProject";
		if( ( allTopProject == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj> map = new HashMap<$implCommaIJavaOptAtomType$,IIntNetTopProjectObj>();
			allTopProject = map;
			IIntNetTopProject[] recList = schema.getIntNetBackingStore().getTableTopProject().readAllDerived( null );
			IIntNetTopProject rec;
			IIntNetTopProjectObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetTopProjectObj realised = (IIntNetTopProjectObj)obj.realise();
			}
		}
		int len = allTopProject.size();
		IIntNetTopProjectObj arr[] = new IIntNetTopProjectObj[len];
		Iterator<IIntNetTopProjectObj> valIter = allTopProject.values().iterator();
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
		ArrayList<IIntNetTopProjectObj> arrayList = new ArrayList<IIntNetTopProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetTopProjectObj> cmp = new Comparator<IIntNetTopProjectObj>() {
			@Override
			public int compare( IIntNetTopProjectObj lhs, IIntNetTopProjectObj rhs ) {
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
		List<IIntNetTopProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IIntNetTopProjectObj> readCachedAllTopProject() {
		final String S_ProcName = "readCachedAllTopProject";
		ArrayList<IIntNetTopProjectObj> arrayList = new ArrayList<IIntNetTopProjectObj>();
		if( allTopProject != null ) {
			int len = allTopProject.size();
			IIntNetTopProjectObj arr[] = new IIntNetTopProjectObj[len];
			Iterator<IIntNetTopProjectObj> valIter = allTopProject.values().iterator();
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
		Comparator<IIntNetTopProjectObj> cmp = new Comparator<IIntNetTopProjectObj>() {
			public int compare( IIntNetTopProjectObj lhs, IIntNetTopProjectObj rhs ) {
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
	public IIntNetTopProjectObj readTopProjectByIdIdx( IYCFKeyHash256 Id )
	{
		return( readTopProjectByIdIdx( Id,
			false ) );
	}

	@Override
	public IIntNetTopProjectObj readTopProjectByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IIntNetTopProjectObj obj = readTopProject( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IIntNetTopProjectObj> readTopProjectByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readTopProjectByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IIntNetTopProjectObj> readTopProjectByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTopProjectByTenantIdx";
		IIntNetTopProjectByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IIntNetTopProjectByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetTopProjectObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj>();
			IIntNetTopProjectObj obj;
			IIntNetTopProject[] recList = schema.getIntNetBackingStore().getTableTopProject().readDerivedByTenantIdx( null,
				TenantId );
			IIntNetTopProject rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getTopProjectTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetTopProjectObj realised = (IIntNetTopProjectObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IIntNetTopProjectObj arr[] = new IIntNetTopProjectObj[len];
		Iterator<IIntNetTopProjectObj> valIter = dict.values().iterator();
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
		ArrayList<IIntNetTopProjectObj> arrayList = new ArrayList<IIntNetTopProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetTopProjectObj> cmp = new Comparator<IIntNetTopProjectObj>() {
			@Override
			public int compare( IIntNetTopProjectObj lhs, IIntNetTopProjectObj rhs ) {
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
		List<IIntNetTopProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IIntNetTopProjectObj> readTopProjectByTopDomainIdx( IYCFKeyHash256 TopDomainId )
	{
		return( readTopProjectByTopDomainIdx( TopDomainId,
			false ) );
	}

	@Override
	public List<IIntNetTopProjectObj> readTopProjectByTopDomainIdx( IYCFKeyHash256 TopDomainId,
		boolean forceRead )
	{
		final String S_ProcName = "readTopProjectByTopDomainIdx";
		IIntNetTopProjectByTopDomainIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByTopDomainIdxKey();
		key.setRequiredTopDomainId( TopDomainId );
		Map<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj> dict;
		if( indexByTopDomainIdx == null ) {
			indexByTopDomainIdx = new HashMap< IIntNetTopProjectByTopDomainIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetTopProjectObj > >();
		}
		if( ( ! forceRead ) && indexByTopDomainIdx.containsKey( key ) ) {
			dict = indexByTopDomainIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj>();
			IIntNetTopProjectObj obj;
			IIntNetTopProject[] recList = schema.getIntNetBackingStore().getTableTopProject().readDerivedByTopDomainIdx( null,
				TopDomainId );
			IIntNetTopProject rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getTopProjectTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetTopProjectObj realised = (IIntNetTopProjectObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTopDomainIdx.put( key, dict );
		}
		int len = dict.size();
		IIntNetTopProjectObj arr[] = new IIntNetTopProjectObj[len];
		Iterator<IIntNetTopProjectObj> valIter = dict.values().iterator();
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
		ArrayList<IIntNetTopProjectObj> arrayList = new ArrayList<IIntNetTopProjectObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetTopProjectObj> cmp = new Comparator<IIntNetTopProjectObj>() {
			@Override
			public int compare( IIntNetTopProjectObj lhs, IIntNetTopProjectObj rhs ) {
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
		List<IIntNetTopProjectObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IIntNetTopProjectObj readTopProjectByNameIdx( IYCFKeyHash256 TopDomainId,
		String Name )
	{
		return( readTopProjectByNameIdx( TopDomainId,
			Name,
			false ) );
	}

	@Override
	public IIntNetTopProjectObj readTopProjectByNameIdx( IYCFKeyHash256 TopDomainId,
		String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< IIntNetTopProjectByNameIdxKey,
				IIntNetTopProjectObj >();
		}
		IIntNetTopProjectByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByNameIdxKey();
		key.setRequiredTopDomainId( TopDomainId );
		key.setRequiredName( Name );
		IIntNetTopProjectObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			IIntNetTopProject rec = schema.getIntNetBackingStore().getTableTopProject().readDerivedByNameIdx( null,
				TopDomainId,
				Name );
			if( rec != null ) {
				obj = schema.getTopProjectTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IIntNetTopProjectObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IIntNetTopProjectObj readCachedTopProjectByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetTopProjectObj obj = null;
		obj = readCachedTopProject( Id );
		return( obj );
	}

	@Override
	public List<IIntNetTopProjectObj> readCachedTopProjectByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedTopProjectByTenantIdx";
		IIntNetTopProjectByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IIntNetTopProjectObj> arrayList = new ArrayList<IIntNetTopProjectObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IIntNetTopProjectObj arr[] = new IIntNetTopProjectObj[len];
				Iterator<IIntNetTopProjectObj> valIter = dict.values().iterator();
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
			IIntNetTopProjectObj obj;
			Iterator<IIntNetTopProjectObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IIntNetTopProjectObj> cmp = new Comparator<IIntNetTopProjectObj>() {
			@Override
			public int compare( IIntNetTopProjectObj lhs, IIntNetTopProjectObj rhs ) {
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
	public List<IIntNetTopProjectObj> readCachedTopProjectByTopDomainIdx( IYCFKeyHash256 TopDomainId )
	{
		final String S_ProcName = "readCachedTopProjectByTopDomainIdx";
		IIntNetTopProjectByTopDomainIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByTopDomainIdxKey();
		key.setRequiredTopDomainId( TopDomainId );
		ArrayList<IIntNetTopProjectObj> arrayList = new ArrayList<IIntNetTopProjectObj>();
		if( indexByTopDomainIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj> dict;
			if( indexByTopDomainIdx.containsKey( key ) ) {
				dict = indexByTopDomainIdx.get( key );
				int len = dict.size();
				IIntNetTopProjectObj arr[] = new IIntNetTopProjectObj[len];
				Iterator<IIntNetTopProjectObj> valIter = dict.values().iterator();
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
			IIntNetTopProjectObj obj;
			Iterator<IIntNetTopProjectObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IIntNetTopProjectObj> cmp = new Comparator<IIntNetTopProjectObj>() {
			@Override
			public int compare( IIntNetTopProjectObj lhs, IIntNetTopProjectObj rhs ) {
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
	public IIntNetTopProjectObj readCachedTopProjectByNameIdx( IYCFKeyHash256 TopDomainId,
		String Name )
	{
		IIntNetTopProjectObj obj = null;
		IIntNetTopProjectByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByNameIdxKey();
		key.setRequiredTopDomainId( TopDomainId );
		key.setRequiredName( Name );
		if( indexByNameIdx != null ) {
			if( indexByNameIdx.containsKey( key ) ) {
				obj = indexByNameIdx.get( key );
			}
			else {
				Iterator<IIntNetTopProjectObj> valIter = members.values().iterator();
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
			Iterator<IIntNetTopProjectObj> valIter = members.values().iterator();
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
	public void deepDisposeTopProjectByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetTopProjectObj obj = readCachedTopProjectByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTopProjectByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeTopProjectByTenantIdx";
		IIntNetTopProjectObj obj;
		List<IIntNetTopProjectObj> arrayList = readCachedTopProjectByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IIntNetTopProjectObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTopProjectByTopDomainIdx( IYCFKeyHash256 TopDomainId )
	{
		final String S_ProcName = "deepDisposeTopProjectByTopDomainIdx";
		IIntNetTopProjectObj obj;
		List<IIntNetTopProjectObj> arrayList = readCachedTopProjectByTopDomainIdx( TopDomainId );
		if( arrayList != null )  {
			Iterator<IIntNetTopProjectObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTopProjectByNameIdx( IYCFKeyHash256 TopDomainId,
		String Name )
	{
		IIntNetTopProjectObj obj = readCachedTopProjectByNameIdx( TopDomainId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IIntNetTopProjectObj updateTopProject( IIntNetTopProjectObj Obj ) {
		IIntNetTopProjectObj obj = Obj;
		schema.getIntNetBackingStore().getTableTopProject().updateTopProject( null,
			Obj.getTopProjectRec() );
		obj = (IIntNetTopProjectObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteTopProject( IIntNetTopProjectObj Obj ) {
		IIntNetTopProjectObj obj = Obj;
		schema.getIntNetBackingStore().getTableTopProject().deleteTopProject( null,
			obj.getTopProjectRec() );
		Obj.forget();
	}

	@Override
	public void deleteTopProjectByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetTopProjectObj obj = readTopProject(Id);
		if( obj != null ) {
			IIntNetTopProjectEditObj editObj = (IIntNetTopProjectEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IIntNetTopProjectEditObj)obj.beginEdit();
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
		deepDisposeTopProjectByIdIdx( Id );
	}

	@Override
	public void deleteTopProjectByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IIntNetTopProjectByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IIntNetTopProjectByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetTopProjectObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj> dict = indexByTenantIdx.get( key );
			schema.getIntNetBackingStore().getTableTopProject().deleteTopProjectByTenantIdx( null,
				TenantId );
			Iterator<IIntNetTopProjectObj> iter = dict.values().iterator();
			IIntNetTopProjectObj obj;
			List<IIntNetTopProjectObj> toForget = new LinkedList<IIntNetTopProjectObj>();
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
			schema.getIntNetBackingStore().getTableTopProject().deleteTopProjectByTenantIdx( null,
				TenantId );
		}
		deepDisposeTopProjectByTenantIdx( TenantId );
	}

	@Override
	public void deleteTopProjectByTopDomainIdx( IYCFKeyHash256 TopDomainId )
	{
		IIntNetTopProjectByTopDomainIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByTopDomainIdxKey();
		key.setRequiredTopDomainId( TopDomainId );
		if( indexByTopDomainIdx == null ) {
			indexByTopDomainIdx = new HashMap< IIntNetTopProjectByTopDomainIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetTopProjectObj > >();
		}
		if( indexByTopDomainIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetTopProjectObj> dict = indexByTopDomainIdx.get( key );
			schema.getIntNetBackingStore().getTableTopProject().deleteTopProjectByTopDomainIdx( null,
				TopDomainId );
			Iterator<IIntNetTopProjectObj> iter = dict.values().iterator();
			IIntNetTopProjectObj obj;
			List<IIntNetTopProjectObj> toForget = new LinkedList<IIntNetTopProjectObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByTopDomainIdx.remove( key );
		}
		else {
			schema.getIntNetBackingStore().getTableTopProject().deleteTopProjectByTopDomainIdx( null,
				TopDomainId );
		}
		deepDisposeTopProjectByTopDomainIdx( TopDomainId );
	}

	@Override
	public void deleteTopProjectByNameIdx( IYCFKeyHash256 TopDomainId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< IIntNetTopProjectByNameIdxKey,
				IIntNetTopProjectObj >();
		}
		IIntNetTopProjectByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newByNameIdxKey();
		key.setRequiredTopDomainId( TopDomainId );
		key.setRequiredName( Name );
		IIntNetTopProjectObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			schema.getIntNetBackingStore().getTableTopProject().deleteTopProjectByNameIdx( null,
				TopDomainId,
				Name );
			obj.forget();
		}
		else {
			schema.getIntNetBackingStore().getTableTopProject().deleteTopProjectByNameIdx( null,
				TopDomainId,
				Name );
		}
		deepDisposeTopProjectByNameIdx( TopDomainId,
				Name );
	}
}