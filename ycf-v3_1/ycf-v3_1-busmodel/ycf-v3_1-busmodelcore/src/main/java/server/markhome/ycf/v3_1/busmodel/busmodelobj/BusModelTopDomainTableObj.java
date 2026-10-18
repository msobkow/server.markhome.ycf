// Description: Java 25 Table Object implementation for TopDomain.

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

public class BusModelTopDomainTableObj
	implements IBusModelTopDomainTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj> members;
	private Map<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj> allTopDomain;
	private Map< IIntNetTopDomainByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj > > indexByTenantIdx;
	private Map< IIntNetTopDomainByTldIdxKey,
		Map<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj > > indexByTldIdx;
	private Map< IIntNetTopDomainByNameIdxKey,
		IIntNetTopDomainObj > indexByNameIdx;
	public static String TABLE_NAME = "TopDomain";
	public static String TABLE_DBNAME = "tdomdef";

	public BusModelTopDomainTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj>();
		allTopDomain = null;
		indexByTenantIdx = null;
		indexByTldIdx = null;
		indexByNameIdx = null;
	}

	public BusModelTopDomainTableObj( IIntNetSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj>();
		allTopDomain = null;
		indexByTenantIdx = null;
		indexByTldIdx = null;
		indexByNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return IntNetTopDomainTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( IntNetTopDomainTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( IntNetTopDomainTableObj.getRuntimeClassCode() );
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
		allTopDomain = null;
		indexByTenantIdx = null;
		indexByTldIdx = null;
		indexByNameIdx = null;
		List<IIntNetTopDomainObj> toForget = new LinkedList<IIntNetTopDomainObj>();
		IIntNetTopDomainObj cur = null;
		Iterator<IIntNetTopDomainObj> iter = members.values().iterator();
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
	 *	BusModelTopDomainObj.
	 */
	@Override
	public IIntNetTopDomainObj newInstance() {
		IIntNetTopDomainObj inst = new BusModelTopDomainObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelTopDomainObj.
	 */
	@Override
	public IIntNetTopDomainEditObj newEditInstance( IIntNetTopDomainObj orig ) {
		IIntNetTopDomainEditObj edit = new BusModelTopDomainEditObj( orig );
		return( edit );
	}

	@Override
	public IIntNetTopDomainObj constructByClassCode( int backingClassCode ) {
		IIntNetTopDomainObj obj = null;
		if( backingClassCode == IIntNetTopDomain.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getTopDomainTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public IIntNetTopDomainObj realiseTopDomain( IIntNetTopDomainObj Obj ) {
		IIntNetTopDomainObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetTopDomainObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IIntNetTopDomainObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				IIntNetTopDomainByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.remove( keepObj.getPKey() );
					if( mapTenantIdx.size() <= 0 ) {
						indexByTenantIdx.remove( keyTenantIdx );
					}
				}
			}

			if( indexByTldIdx != null ) {
				IIntNetTopDomainByTldIdxKey keyTldIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByTldIdxKey();
				keyTldIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj > mapTldIdx = indexByTldIdx.get( keyTldIdx );
				if( mapTldIdx != null ) {
					mapTldIdx.remove( keepObj.getPKey() );
					if( mapTldIdx.size() <= 0 ) {
						indexByTldIdx.remove( keyTldIdx );
					}
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetTopDomainByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByNameIdxKey();
				keyNameIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.remove( keyNameIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IIntNetTopDomainByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTldIdx != null ) {
				IIntNetTopDomainByTldIdxKey keyTldIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByTldIdxKey();
				keyTldIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj > mapTldIdx = indexByTldIdx.get( keyTldIdx );
				if( mapTldIdx != null ) {
					mapTldIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetTopDomainByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByNameIdxKey();
				keyNameIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

			if( allTopDomain != null ) {
				allTopDomain.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allTopDomain != null ) {
				allTopDomain.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IIntNetTopDomainByTenantIdxKey keyTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByTldIdx != null ) {
				IIntNetTopDomainByTldIdxKey keyTldIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByTldIdxKey();
				keyTldIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj > mapTldIdx = indexByTldIdx.get( keyTldIdx );
				if( mapTldIdx != null ) {
					mapTldIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNameIdx != null ) {
				IIntNetTopDomainByNameIdxKey keyNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByNameIdxKey();
				keyNameIdx.setRequiredTldId( keepObj.getRequiredTldId() );
				keyNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByNameIdx.put( keyNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public IIntNetTopDomainObj createTopDomain( IIntNetTopDomainObj Obj ) {
		IIntNetTopDomainObj obj = Obj;
		IIntNetTopDomain rec = obj.getTopDomainRec();
		schema.getIntNetBackingStore().getTableTopDomain().createTopDomain(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public IIntNetTopDomainObj readTopDomain( $implCommaIJavaOptAtomType$ pkey ) {
		return( readTopDomain( pkey, false ) );
	}

	@Override
	public IIntNetTopDomainObj readTopDomain( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IIntNetTopDomainObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IIntNetTopDomain readRec = schema.getIntNetBackingStore().getTableTopDomain().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getTopDomainTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IIntNetTopDomainObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IIntNetTopDomainObj readCachedTopDomain( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetTopDomainObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeTopDomain( IIntNetTopDomainObj obj )
	{
		final String S_ProcName = "BusModelTopDomainTableObj.reallyDeepDisposeTopDomain() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetTopDomainObj existing = readCachedTopDomain( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IIntNetTopDomainByTenantIdxKey keyTenantIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByTenantIdxKey();
		keyTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IIntNetTopDomainByTldIdxKey keyTldIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByTldIdxKey();
		keyTldIdx.setRequiredTldId( existing.getRequiredTldId() );

		IIntNetTopDomainByNameIdxKey keyNameIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByNameIdxKey();
		keyNameIdx.setRequiredTldId( existing.getRequiredTldId() );
		keyNameIdx.setRequiredName( existing.getRequiredName() );


					schema.getTopProjectTableObj().deepDisposeTopProjectByTopDomainIdx( existing.getRequiredId() );

		if( indexByTenantIdx != null ) {
			if( indexByTenantIdx.containsKey( keyTenantIdx ) ) {
				indexByTenantIdx.get( keyTenantIdx ).remove( pkey );
				if( indexByTenantIdx.get( keyTenantIdx ).size() <= 0 ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}
		}

		if( indexByTldIdx != null ) {
			if( indexByTldIdx.containsKey( keyTldIdx ) ) {
				indexByTldIdx.get( keyTldIdx ).remove( pkey );
				if( indexByTldIdx.get( keyTldIdx ).size() <= 0 ) {
					indexByTldIdx.remove( keyTldIdx );
				}
			}
		}

		if( indexByNameIdx != null ) {
			indexByNameIdx.remove( keyNameIdx );
		}


	}
	@Override
	public void deepDisposeTopDomain( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetTopDomainObj obj = readCachedTopDomain( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IIntNetTopDomainObj lockTopDomain( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetTopDomainObj locked = null;
		IIntNetTopDomain lockRec = schema.getIntNetBackingStore().getTableTopDomain().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getTopDomainTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IIntNetTopDomainObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockTopDomain", pkey );
		}
		return( locked );
	}

	@Override
	public List<IIntNetTopDomainObj> readAllTopDomain() {
		return( readAllTopDomain( false ) );
	}

	@Override
	public List<IIntNetTopDomainObj> readAllTopDomain( boolean forceRead ) {
		final String S_ProcName = "readAllTopDomain";
		if( ( allTopDomain == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj> map = new HashMap<$implCommaIJavaOptAtomType$,IIntNetTopDomainObj>();
			allTopDomain = map;
			IIntNetTopDomain[] recList = schema.getIntNetBackingStore().getTableTopDomain().readAllDerived( null );
			IIntNetTopDomain rec;
			IIntNetTopDomainObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetTopDomainObj realised = (IIntNetTopDomainObj)obj.realise();
			}
		}
		int len = allTopDomain.size();
		IIntNetTopDomainObj arr[] = new IIntNetTopDomainObj[len];
		Iterator<IIntNetTopDomainObj> valIter = allTopDomain.values().iterator();
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
		ArrayList<IIntNetTopDomainObj> arrayList = new ArrayList<IIntNetTopDomainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetTopDomainObj> cmp = new Comparator<IIntNetTopDomainObj>() {
			@Override
			public int compare( IIntNetTopDomainObj lhs, IIntNetTopDomainObj rhs ) {
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
		List<IIntNetTopDomainObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IIntNetTopDomainObj> readCachedAllTopDomain() {
		final String S_ProcName = "readCachedAllTopDomain";
		ArrayList<IIntNetTopDomainObj> arrayList = new ArrayList<IIntNetTopDomainObj>();
		if( allTopDomain != null ) {
			int len = allTopDomain.size();
			IIntNetTopDomainObj arr[] = new IIntNetTopDomainObj[len];
			Iterator<IIntNetTopDomainObj> valIter = allTopDomain.values().iterator();
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
		Comparator<IIntNetTopDomainObj> cmp = new Comparator<IIntNetTopDomainObj>() {
			public int compare( IIntNetTopDomainObj lhs, IIntNetTopDomainObj rhs ) {
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
	public IIntNetTopDomainObj readTopDomainByIdIdx( IYCFKeyHash256 Id )
	{
		return( readTopDomainByIdIdx( Id,
			false ) );
	}

	@Override
	public IIntNetTopDomainObj readTopDomainByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IIntNetTopDomainObj obj = readTopDomain( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IIntNetTopDomainObj> readTopDomainByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readTopDomainByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IIntNetTopDomainObj> readTopDomainByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readTopDomainByTenantIdx";
		IIntNetTopDomainByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IIntNetTopDomainByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetTopDomainObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj>();
			IIntNetTopDomainObj obj;
			IIntNetTopDomain[] recList = schema.getIntNetBackingStore().getTableTopDomain().readDerivedByTenantIdx( null,
				TenantId );
			IIntNetTopDomain rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getTopDomainTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetTopDomainObj realised = (IIntNetTopDomainObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IIntNetTopDomainObj arr[] = new IIntNetTopDomainObj[len];
		Iterator<IIntNetTopDomainObj> valIter = dict.values().iterator();
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
		ArrayList<IIntNetTopDomainObj> arrayList = new ArrayList<IIntNetTopDomainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetTopDomainObj> cmp = new Comparator<IIntNetTopDomainObj>() {
			@Override
			public int compare( IIntNetTopDomainObj lhs, IIntNetTopDomainObj rhs ) {
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
		List<IIntNetTopDomainObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IIntNetTopDomainObj> readTopDomainByTldIdx( IYCFKeyHash256 TldId )
	{
		return( readTopDomainByTldIdx( TldId,
			false ) );
	}

	@Override
	public List<IIntNetTopDomainObj> readTopDomainByTldIdx( IYCFKeyHash256 TldId,
		boolean forceRead )
	{
		final String S_ProcName = "readTopDomainByTldIdx";
		IIntNetTopDomainByTldIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByTldIdxKey();
		key.setRequiredTldId( TldId );
		Map<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj> dict;
		if( indexByTldIdx == null ) {
			indexByTldIdx = new HashMap< IIntNetTopDomainByTldIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetTopDomainObj > >();
		}
		if( ( ! forceRead ) && indexByTldIdx.containsKey( key ) ) {
			dict = indexByTldIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj>();
			IIntNetTopDomainObj obj;
			IIntNetTopDomain[] recList = schema.getIntNetBackingStore().getTableTopDomain().readDerivedByTldIdx( null,
				TldId );
			IIntNetTopDomain rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getTopDomainTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetTopDomainObj realised = (IIntNetTopDomainObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTldIdx.put( key, dict );
		}
		int len = dict.size();
		IIntNetTopDomainObj arr[] = new IIntNetTopDomainObj[len];
		Iterator<IIntNetTopDomainObj> valIter = dict.values().iterator();
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
		ArrayList<IIntNetTopDomainObj> arrayList = new ArrayList<IIntNetTopDomainObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetTopDomainObj> cmp = new Comparator<IIntNetTopDomainObj>() {
			@Override
			public int compare( IIntNetTopDomainObj lhs, IIntNetTopDomainObj rhs ) {
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
		List<IIntNetTopDomainObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IIntNetTopDomainObj readTopDomainByNameIdx( IYCFKeyHash256 TldId,
		String Name )
	{
		return( readTopDomainByNameIdx( TldId,
			Name,
			false ) );
	}

	@Override
	public IIntNetTopDomainObj readTopDomainByNameIdx( IYCFKeyHash256 TldId,
		String Name, boolean forceRead )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< IIntNetTopDomainByNameIdxKey,
				IIntNetTopDomainObj >();
		}
		IIntNetTopDomainByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByNameIdxKey();
		key.setRequiredTldId( TldId );
		key.setRequiredName( Name );
		IIntNetTopDomainObj obj = null;
		if( ( ! forceRead ) && indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
		}
		else {
			IIntNetTopDomain rec = schema.getIntNetBackingStore().getTableTopDomain().readDerivedByNameIdx( null,
				TldId,
				Name );
			if( rec != null ) {
				obj = schema.getTopDomainTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IIntNetTopDomainObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IIntNetTopDomainObj readCachedTopDomainByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetTopDomainObj obj = null;
		obj = readCachedTopDomain( Id );
		return( obj );
	}

	@Override
	public List<IIntNetTopDomainObj> readCachedTopDomainByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedTopDomainByTenantIdx";
		IIntNetTopDomainByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IIntNetTopDomainObj> arrayList = new ArrayList<IIntNetTopDomainObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IIntNetTopDomainObj arr[] = new IIntNetTopDomainObj[len];
				Iterator<IIntNetTopDomainObj> valIter = dict.values().iterator();
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
			IIntNetTopDomainObj obj;
			Iterator<IIntNetTopDomainObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IIntNetTopDomainObj> cmp = new Comparator<IIntNetTopDomainObj>() {
			@Override
			public int compare( IIntNetTopDomainObj lhs, IIntNetTopDomainObj rhs ) {
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
	public List<IIntNetTopDomainObj> readCachedTopDomainByTldIdx( IYCFKeyHash256 TldId )
	{
		final String S_ProcName = "readCachedTopDomainByTldIdx";
		IIntNetTopDomainByTldIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByTldIdxKey();
		key.setRequiredTldId( TldId );
		ArrayList<IIntNetTopDomainObj> arrayList = new ArrayList<IIntNetTopDomainObj>();
		if( indexByTldIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj> dict;
			if( indexByTldIdx.containsKey( key ) ) {
				dict = indexByTldIdx.get( key );
				int len = dict.size();
				IIntNetTopDomainObj arr[] = new IIntNetTopDomainObj[len];
				Iterator<IIntNetTopDomainObj> valIter = dict.values().iterator();
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
			IIntNetTopDomainObj obj;
			Iterator<IIntNetTopDomainObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IIntNetTopDomainObj> cmp = new Comparator<IIntNetTopDomainObj>() {
			@Override
			public int compare( IIntNetTopDomainObj lhs, IIntNetTopDomainObj rhs ) {
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
	public IIntNetTopDomainObj readCachedTopDomainByNameIdx( IYCFKeyHash256 TldId,
		String Name )
	{
		IIntNetTopDomainObj obj = null;
		IIntNetTopDomainByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByNameIdxKey();
		key.setRequiredTldId( TldId );
		key.setRequiredName( Name );
		if( indexByNameIdx != null ) {
			if( indexByNameIdx.containsKey( key ) ) {
				obj = indexByNameIdx.get( key );
			}
			else {
				Iterator<IIntNetTopDomainObj> valIter = members.values().iterator();
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
			Iterator<IIntNetTopDomainObj> valIter = members.values().iterator();
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
	public void deepDisposeTopDomainByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetTopDomainObj obj = readCachedTopDomainByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeTopDomainByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeTopDomainByTenantIdx";
		IIntNetTopDomainObj obj;
		List<IIntNetTopDomainObj> arrayList = readCachedTopDomainByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IIntNetTopDomainObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTopDomainByTldIdx( IYCFKeyHash256 TldId )
	{
		final String S_ProcName = "deepDisposeTopDomainByTldIdx";
		IIntNetTopDomainObj obj;
		List<IIntNetTopDomainObj> arrayList = readCachedTopDomainByTldIdx( TldId );
		if( arrayList != null )  {
			Iterator<IIntNetTopDomainObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeTopDomainByNameIdx( IYCFKeyHash256 TldId,
		String Name )
	{
		IIntNetTopDomainObj obj = readCachedTopDomainByNameIdx( TldId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IIntNetTopDomainObj updateTopDomain( IIntNetTopDomainObj Obj ) {
		IIntNetTopDomainObj obj = Obj;
		schema.getIntNetBackingStore().getTableTopDomain().updateTopDomain( null,
			Obj.getTopDomainRec() );
		obj = (IIntNetTopDomainObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteTopDomain( IIntNetTopDomainObj Obj ) {
		IIntNetTopDomainObj obj = Obj;
		schema.getIntNetBackingStore().getTableTopDomain().deleteTopDomain( null,
			obj.getTopDomainRec() );
		Obj.forget();
	}

	@Override
	public void deleteTopDomainByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetTopDomainObj obj = readTopDomain(Id);
		if( obj != null ) {
			IIntNetTopDomainEditObj editObj = (IIntNetTopDomainEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IIntNetTopDomainEditObj)obj.beginEdit();
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
		deepDisposeTopDomainByIdIdx( Id );
	}

	@Override
	public void deleteTopDomainByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IIntNetTopDomainByTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IIntNetTopDomainByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetTopDomainObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj> dict = indexByTenantIdx.get( key );
			schema.getIntNetBackingStore().getTableTopDomain().deleteTopDomainByTenantIdx( null,
				TenantId );
			Iterator<IIntNetTopDomainObj> iter = dict.values().iterator();
			IIntNetTopDomainObj obj;
			List<IIntNetTopDomainObj> toForget = new LinkedList<IIntNetTopDomainObj>();
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
			schema.getIntNetBackingStore().getTableTopDomain().deleteTopDomainByTenantIdx( null,
				TenantId );
		}
		deepDisposeTopDomainByTenantIdx( TenantId );
	}

	@Override
	public void deleteTopDomainByTldIdx( IYCFKeyHash256 TldId )
	{
		IIntNetTopDomainByTldIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByTldIdxKey();
		key.setRequiredTldId( TldId );
		if( indexByTldIdx == null ) {
			indexByTldIdx = new HashMap< IIntNetTopDomainByTldIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetTopDomainObj > >();
		}
		if( indexByTldIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetTopDomainObj> dict = indexByTldIdx.get( key );
			schema.getIntNetBackingStore().getTableTopDomain().deleteTopDomainByTldIdx( null,
				TldId );
			Iterator<IIntNetTopDomainObj> iter = dict.values().iterator();
			IIntNetTopDomainObj obj;
			List<IIntNetTopDomainObj> toForget = new LinkedList<IIntNetTopDomainObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByTldIdx.remove( key );
		}
		else {
			schema.getIntNetBackingStore().getTableTopDomain().deleteTopDomainByTldIdx( null,
				TldId );
		}
		deepDisposeTopDomainByTldIdx( TldId );
	}

	@Override
	public void deleteTopDomainByNameIdx( IYCFKeyHash256 TldId,
		String Name )
	{
		if( indexByNameIdx == null ) {
			indexByNameIdx = new HashMap< IIntNetTopDomainByNameIdxKey,
				IIntNetTopDomainObj >();
		}
		IIntNetTopDomainByNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newByNameIdxKey();
		key.setRequiredTldId( TldId );
		key.setRequiredName( Name );
		IIntNetTopDomainObj obj = null;
		if( indexByNameIdx.containsKey( key ) ) {
			obj = indexByNameIdx.get( key );
			schema.getIntNetBackingStore().getTableTopDomain().deleteTopDomainByNameIdx( null,
				TldId,
				Name );
			obj.forget();
		}
		else {
			schema.getIntNetBackingStore().getTableTopDomain().deleteTopDomainByNameIdx( null,
				TldId,
				Name );
		}
		deepDisposeTopDomainByNameIdx( TldId,
				Name );
	}
}