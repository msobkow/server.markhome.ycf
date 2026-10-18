// Description: Java 25 Table Object implementation for License.

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

public class BusModelLicenseTableObj
	implements IBusModelLicenseTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, IIntNetLicenseObj> members;
	private Map<$implCommaIJavaOptAtomType$, IIntNetLicenseObj> allLicense;
	private Map< IIntNetLicenseByLicnTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IIntNetLicenseObj > > indexByLicnTenantIdx;
	private Map< IIntNetLicenseByDomainIdxKey,
		Map<$implCommaIJavaOptAtomType$, IIntNetLicenseObj > > indexByDomainIdx;
	private Map< IIntNetLicenseByUNameIdxKey,
		IIntNetLicenseObj > indexByUNameIdx;
	public static String TABLE_NAME = "License";
	public static String TABLE_DBNAME = "licn";

	public BusModelLicenseTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetLicenseObj>();
		allLicense = null;
		indexByLicnTenantIdx = null;
		indexByDomainIdx = null;
		indexByUNameIdx = null;
	}

	public BusModelLicenseTableObj( IIntNetSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IIntNetLicenseObj>();
		allLicense = null;
		indexByLicnTenantIdx = null;
		indexByDomainIdx = null;
		indexByUNameIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return IntNetLicenseTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( IntNetLicenseTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( IntNetLicenseTableObj.getRuntimeClassCode() );
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
		allLicense = null;
		indexByLicnTenantIdx = null;
		indexByDomainIdx = null;
		indexByUNameIdx = null;
		List<IIntNetLicenseObj> toForget = new LinkedList<IIntNetLicenseObj>();
		IIntNetLicenseObj cur = null;
		Iterator<IIntNetLicenseObj> iter = members.values().iterator();
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
	 *	BusModelLicenseObj.
	 */
	@Override
	public IIntNetLicenseObj newInstance() {
		IIntNetLicenseObj inst = new BusModelLicenseObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelLicenseObj.
	 */
	@Override
	public IIntNetLicenseEditObj newEditInstance( IIntNetLicenseObj orig ) {
		IIntNetLicenseEditObj edit = new BusModelLicenseEditObj( orig );
		return( edit );
	}

	@Override
	public IIntNetLicenseObj constructByClassCode( int backingClassCode ) {
		IIntNetLicenseObj obj = null;
		if( backingClassCode == IIntNetLicense.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getLicenseTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public IIntNetLicenseObj realiseLicense( IIntNetLicenseObj Obj ) {
		IIntNetLicenseObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetLicenseObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IIntNetLicenseObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByLicnTenantIdx != null ) {
				IIntNetLicenseByLicnTenantIdxKey keyLicnTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByLicnTenantIdxKey();
				keyLicnTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetLicenseObj > mapLicnTenantIdx = indexByLicnTenantIdx.get( keyLicnTenantIdx );
				if( mapLicnTenantIdx != null ) {
					mapLicnTenantIdx.remove( keepObj.getPKey() );
					if( mapLicnTenantIdx.size() <= 0 ) {
						indexByLicnTenantIdx.remove( keyLicnTenantIdx );
					}
				}
			}

			if( indexByDomainIdx != null ) {
				IIntNetLicenseByDomainIdxKey keyDomainIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByDomainIdxKey();
				keyDomainIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetLicenseObj > mapDomainIdx = indexByDomainIdx.get( keyDomainIdx );
				if( mapDomainIdx != null ) {
					mapDomainIdx.remove( keepObj.getPKey() );
					if( mapDomainIdx.size() <= 0 ) {
						indexByDomainIdx.remove( keyDomainIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				IIntNetLicenseByUNameIdxKey keyUNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByUNameIdxKey();
				keyUNameIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByLicnTenantIdx != null ) {
				IIntNetLicenseByLicnTenantIdxKey keyLicnTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByLicnTenantIdxKey();
				keyLicnTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetLicenseObj > mapLicnTenantIdx = indexByLicnTenantIdx.get( keyLicnTenantIdx );
				if( mapLicnTenantIdx != null ) {
					mapLicnTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDomainIdx != null ) {
				IIntNetLicenseByDomainIdxKey keyDomainIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByDomainIdxKey();
				keyDomainIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetLicenseObj > mapDomainIdx = indexByDomainIdx.get( keyDomainIdx );
				if( mapDomainIdx != null ) {
					mapDomainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IIntNetLicenseByUNameIdxKey keyUNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByUNameIdxKey();
				keyUNameIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( allLicense != null ) {
				allLicense.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allLicense != null ) {
				allLicense.put( keepObj.getPKey(), keepObj );
			}

			if( indexByLicnTenantIdx != null ) {
				IIntNetLicenseByLicnTenantIdxKey keyLicnTenantIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByLicnTenantIdxKey();
				keyLicnTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetLicenseObj > mapLicnTenantIdx = indexByLicnTenantIdx.get( keyLicnTenantIdx );
				if( mapLicnTenantIdx != null ) {
					mapLicnTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByDomainIdx != null ) {
				IIntNetLicenseByDomainIdxKey keyDomainIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByDomainIdxKey();
				keyDomainIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				Map<$implCommaIJavaOptAtomType$, IIntNetLicenseObj > mapDomainIdx = indexByDomainIdx.get( keyDomainIdx );
				if( mapDomainIdx != null ) {
					mapDomainIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IIntNetLicenseByUNameIdxKey keyUNameIdx =
					schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByUNameIdxKey();
				keyUNameIdx.setRequiredTopDomainId( keepObj.getRequiredTopDomainId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public IIntNetLicenseObj createLicense( IIntNetLicenseObj Obj ) {
		IIntNetLicenseObj obj = Obj;
		IIntNetLicense rec = obj.getLicenseRec();
		schema.getIntNetBackingStore().getTableLicense().createLicense(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public IIntNetLicenseObj readLicense( $implCommaIJavaOptAtomType$ pkey ) {
		return( readLicense( pkey, false ) );
	}

	@Override
	public IIntNetLicenseObj readLicense( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IIntNetLicenseObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IIntNetLicense readRec = schema.getIntNetBackingStore().getTableLicense().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getLicenseTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IIntNetLicenseObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IIntNetLicenseObj readCachedLicense( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetLicenseObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeLicense( IIntNetLicenseObj obj )
	{
		final String S_ProcName = "BusModelLicenseTableObj.reallyDeepDisposeLicense() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IIntNetLicenseObj existing = readCachedLicense( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IIntNetLicenseByLicnTenantIdxKey keyLicnTenantIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByLicnTenantIdxKey();
		keyLicnTenantIdx.setRequiredTenantId( existing.getRequiredTenantId() );

		IIntNetLicenseByDomainIdxKey keyDomainIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByDomainIdxKey();
		keyDomainIdx.setRequiredTopDomainId( existing.getRequiredTopDomainId() );

		IIntNetLicenseByUNameIdxKey keyUNameIdx = schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByUNameIdxKey();
		keyUNameIdx.setRequiredTopDomainId( existing.getRequiredTopDomainId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );



		if( indexByLicnTenantIdx != null ) {
			if( indexByLicnTenantIdx.containsKey( keyLicnTenantIdx ) ) {
				indexByLicnTenantIdx.get( keyLicnTenantIdx ).remove( pkey );
				if( indexByLicnTenantIdx.get( keyLicnTenantIdx ).size() <= 0 ) {
					indexByLicnTenantIdx.remove( keyLicnTenantIdx );
				}
			}
		}

		if( indexByDomainIdx != null ) {
			if( indexByDomainIdx.containsKey( keyDomainIdx ) ) {
				indexByDomainIdx.get( keyDomainIdx ).remove( pkey );
				if( indexByDomainIdx.get( keyDomainIdx ).size() <= 0 ) {
					indexByDomainIdx.remove( keyDomainIdx );
				}
			}
		}

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}


	}
	@Override
	public void deepDisposeLicense( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetLicenseObj obj = readCachedLicense( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IIntNetLicenseObj lockLicense( $implCommaIJavaOptAtomType$ pkey ) {
		IIntNetLicenseObj locked = null;
		IIntNetLicense lockRec = schema.getIntNetBackingStore().getTableLicense().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getLicenseTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IIntNetLicenseObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockLicense", pkey );
		}
		return( locked );
	}

	@Override
	public List<IIntNetLicenseObj> readAllLicense() {
		return( readAllLicense( false ) );
	}

	@Override
	public List<IIntNetLicenseObj> readAllLicense( boolean forceRead ) {
		final String S_ProcName = "readAllLicense";
		if( ( allLicense == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetLicenseObj> map = new HashMap<$implCommaIJavaOptAtomType$,IIntNetLicenseObj>();
			allLicense = map;
			IIntNetLicense[] recList = schema.getIntNetBackingStore().getTableLicense().readAllDerived( null );
			IIntNetLicense rec;
			IIntNetLicenseObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetLicenseObj realised = (IIntNetLicenseObj)obj.realise();
			}
		}
		int len = allLicense.size();
		IIntNetLicenseObj arr[] = new IIntNetLicenseObj[len];
		Iterator<IIntNetLicenseObj> valIter = allLicense.values().iterator();
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
		ArrayList<IIntNetLicenseObj> arrayList = new ArrayList<IIntNetLicenseObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetLicenseObj> cmp = new Comparator<IIntNetLicenseObj>() {
			@Override
			public int compare( IIntNetLicenseObj lhs, IIntNetLicenseObj rhs ) {
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
		List<IIntNetLicenseObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IIntNetLicenseObj> readCachedAllLicense() {
		final String S_ProcName = "readCachedAllLicense";
		ArrayList<IIntNetLicenseObj> arrayList = new ArrayList<IIntNetLicenseObj>();
		if( allLicense != null ) {
			int len = allLicense.size();
			IIntNetLicenseObj arr[] = new IIntNetLicenseObj[len];
			Iterator<IIntNetLicenseObj> valIter = allLicense.values().iterator();
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
		Comparator<IIntNetLicenseObj> cmp = new Comparator<IIntNetLicenseObj>() {
			public int compare( IIntNetLicenseObj lhs, IIntNetLicenseObj rhs ) {
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
	public IIntNetLicenseObj readLicenseByIdIdx( IYCFKeyHash256 Id )
	{
		return( readLicenseByIdIdx( Id,
			false ) );
	}

	@Override
	public IIntNetLicenseObj readLicenseByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IIntNetLicenseObj obj = readLicense( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IIntNetLicenseObj> readLicenseByLicnTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readLicenseByLicnTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IIntNetLicenseObj> readLicenseByLicnTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readLicenseByLicnTenantIdx";
		IIntNetLicenseByLicnTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByLicnTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IIntNetLicenseObj> dict;
		if( indexByLicnTenantIdx == null ) {
			indexByLicnTenantIdx = new HashMap< IIntNetLicenseByLicnTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetLicenseObj > >();
		}
		if( ( ! forceRead ) && indexByLicnTenantIdx.containsKey( key ) ) {
			dict = indexByLicnTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IIntNetLicenseObj>();
			IIntNetLicenseObj obj;
			IIntNetLicense[] recList = schema.getIntNetBackingStore().getTableLicense().readDerivedByLicnTenantIdx( null,
				TenantId );
			IIntNetLicense rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getLicenseTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetLicenseObj realised = (IIntNetLicenseObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByLicnTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IIntNetLicenseObj arr[] = new IIntNetLicenseObj[len];
		Iterator<IIntNetLicenseObj> valIter = dict.values().iterator();
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
		ArrayList<IIntNetLicenseObj> arrayList = new ArrayList<IIntNetLicenseObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetLicenseObj> cmp = new Comparator<IIntNetLicenseObj>() {
			@Override
			public int compare( IIntNetLicenseObj lhs, IIntNetLicenseObj rhs ) {
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
		List<IIntNetLicenseObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IIntNetLicenseObj> readLicenseByDomainIdx( IYCFKeyHash256 TopDomainId )
	{
		return( readLicenseByDomainIdx( TopDomainId,
			false ) );
	}

	@Override
	public List<IIntNetLicenseObj> readLicenseByDomainIdx( IYCFKeyHash256 TopDomainId,
		boolean forceRead )
	{
		final String S_ProcName = "readLicenseByDomainIdx";
		IIntNetLicenseByDomainIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByDomainIdxKey();
		key.setRequiredTopDomainId( TopDomainId );
		Map<$implCommaIJavaOptAtomType$, IIntNetLicenseObj> dict;
		if( indexByDomainIdx == null ) {
			indexByDomainIdx = new HashMap< IIntNetLicenseByDomainIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetLicenseObj > >();
		}
		if( ( ! forceRead ) && indexByDomainIdx.containsKey( key ) ) {
			dict = indexByDomainIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IIntNetLicenseObj>();
			IIntNetLicenseObj obj;
			IIntNetLicense[] recList = schema.getIntNetBackingStore().getTableLicense().readDerivedByDomainIdx( null,
				TopDomainId );
			IIntNetLicense rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getLicenseTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IIntNetLicenseObj realised = (IIntNetLicenseObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByDomainIdx.put( key, dict );
		}
		int len = dict.size();
		IIntNetLicenseObj arr[] = new IIntNetLicenseObj[len];
		Iterator<IIntNetLicenseObj> valIter = dict.values().iterator();
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
		ArrayList<IIntNetLicenseObj> arrayList = new ArrayList<IIntNetLicenseObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IIntNetLicenseObj> cmp = new Comparator<IIntNetLicenseObj>() {
			@Override
			public int compare( IIntNetLicenseObj lhs, IIntNetLicenseObj rhs ) {
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
		List<IIntNetLicenseObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IIntNetLicenseObj readLicenseByUNameIdx( IYCFKeyHash256 TopDomainId,
		String Name )
	{
		return( readLicenseByUNameIdx( TopDomainId,
			Name,
			false ) );
	}

	@Override
	public IIntNetLicenseObj readLicenseByUNameIdx( IYCFKeyHash256 TopDomainId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IIntNetLicenseByUNameIdxKey,
				IIntNetLicenseObj >();
		}
		IIntNetLicenseByUNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByUNameIdxKey();
		key.setRequiredTopDomainId( TopDomainId );
		key.setRequiredName( Name );
		IIntNetLicenseObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IIntNetLicense rec = schema.getIntNetBackingStore().getTableLicense().readDerivedByUNameIdx( null,
				TopDomainId,
				Name );
			if( rec != null ) {
				obj = schema.getLicenseTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IIntNetLicenseObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IIntNetLicenseObj readCachedLicenseByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetLicenseObj obj = null;
		obj = readCachedLicense( Id );
		return( obj );
	}

	@Override
	public List<IIntNetLicenseObj> readCachedLicenseByLicnTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedLicenseByLicnTenantIdx";
		IIntNetLicenseByLicnTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByLicnTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IIntNetLicenseObj> arrayList = new ArrayList<IIntNetLicenseObj>();
		if( indexByLicnTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetLicenseObj> dict;
			if( indexByLicnTenantIdx.containsKey( key ) ) {
				dict = indexByLicnTenantIdx.get( key );
				int len = dict.size();
				IIntNetLicenseObj arr[] = new IIntNetLicenseObj[len];
				Iterator<IIntNetLicenseObj> valIter = dict.values().iterator();
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
			IIntNetLicenseObj obj;
			Iterator<IIntNetLicenseObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IIntNetLicenseObj> cmp = new Comparator<IIntNetLicenseObj>() {
			@Override
			public int compare( IIntNetLicenseObj lhs, IIntNetLicenseObj rhs ) {
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
	public List<IIntNetLicenseObj> readCachedLicenseByDomainIdx( IYCFKeyHash256 TopDomainId )
	{
		final String S_ProcName = "readCachedLicenseByDomainIdx";
		IIntNetLicenseByDomainIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByDomainIdxKey();
		key.setRequiredTopDomainId( TopDomainId );
		ArrayList<IIntNetLicenseObj> arrayList = new ArrayList<IIntNetLicenseObj>();
		if( indexByDomainIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetLicenseObj> dict;
			if( indexByDomainIdx.containsKey( key ) ) {
				dict = indexByDomainIdx.get( key );
				int len = dict.size();
				IIntNetLicenseObj arr[] = new IIntNetLicenseObj[len];
				Iterator<IIntNetLicenseObj> valIter = dict.values().iterator();
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
			IIntNetLicenseObj obj;
			Iterator<IIntNetLicenseObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IIntNetLicenseObj> cmp = new Comparator<IIntNetLicenseObj>() {
			@Override
			public int compare( IIntNetLicenseObj lhs, IIntNetLicenseObj rhs ) {
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
	public IIntNetLicenseObj readCachedLicenseByUNameIdx( IYCFKeyHash256 TopDomainId,
		String Name )
	{
		IIntNetLicenseObj obj = null;
		IIntNetLicenseByUNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByUNameIdxKey();
		key.setRequiredTopDomainId( TopDomainId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IIntNetLicenseObj> valIter = members.values().iterator();
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
			Iterator<IIntNetLicenseObj> valIter = members.values().iterator();
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
	public void deepDisposeLicenseByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetLicenseObj obj = readCachedLicenseByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeLicenseByLicnTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeLicenseByLicnTenantIdx";
		IIntNetLicenseObj obj;
		List<IIntNetLicenseObj> arrayList = readCachedLicenseByLicnTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IIntNetLicenseObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeLicenseByDomainIdx( IYCFKeyHash256 TopDomainId )
	{
		final String S_ProcName = "deepDisposeLicenseByDomainIdx";
		IIntNetLicenseObj obj;
		List<IIntNetLicenseObj> arrayList = readCachedLicenseByDomainIdx( TopDomainId );
		if( arrayList != null )  {
			Iterator<IIntNetLicenseObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeLicenseByUNameIdx( IYCFKeyHash256 TopDomainId,
		String Name )
	{
		IIntNetLicenseObj obj = readCachedLicenseByUNameIdx( TopDomainId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IIntNetLicenseObj updateLicense( IIntNetLicenseObj Obj ) {
		IIntNetLicenseObj obj = Obj;
		schema.getIntNetBackingStore().getTableLicense().updateLicense( null,
			Obj.getLicenseRec() );
		obj = (IIntNetLicenseObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteLicense( IIntNetLicenseObj Obj ) {
		IIntNetLicenseObj obj = Obj;
		schema.getIntNetBackingStore().getTableLicense().deleteLicense( null,
			obj.getLicenseRec() );
		Obj.forget();
	}

	@Override
	public void deleteLicenseByIdIdx( IYCFKeyHash256 Id )
	{
		IIntNetLicenseObj obj = readLicense(Id);
		if( obj != null ) {
			IIntNetLicenseEditObj editObj = (IIntNetLicenseEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IIntNetLicenseEditObj)obj.beginEdit();
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
		deepDisposeLicenseByIdIdx( Id );
	}

	@Override
	public void deleteLicenseByLicnTenantIdx( IYCFKeyHash256 TenantId )
	{
		IIntNetLicenseByLicnTenantIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByLicnTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByLicnTenantIdx == null ) {
			indexByLicnTenantIdx = new HashMap< IIntNetLicenseByLicnTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetLicenseObj > >();
		}
		if( indexByLicnTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetLicenseObj> dict = indexByLicnTenantIdx.get( key );
			schema.getIntNetBackingStore().getTableLicense().deleteLicenseByLicnTenantIdx( null,
				TenantId );
			Iterator<IIntNetLicenseObj> iter = dict.values().iterator();
			IIntNetLicenseObj obj;
			List<IIntNetLicenseObj> toForget = new LinkedList<IIntNetLicenseObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByLicnTenantIdx.remove( key );
		}
		else {
			schema.getIntNetBackingStore().getTableLicense().deleteLicenseByLicnTenantIdx( null,
				TenantId );
		}
		deepDisposeLicenseByLicnTenantIdx( TenantId );
	}

	@Override
	public void deleteLicenseByDomainIdx( IYCFKeyHash256 TopDomainId )
	{
		IIntNetLicenseByDomainIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByDomainIdxKey();
		key.setRequiredTopDomainId( TopDomainId );
		if( indexByDomainIdx == null ) {
			indexByDomainIdx = new HashMap< IIntNetLicenseByDomainIdxKey,
				Map< $implCommaIJavaOptAtomType$, IIntNetLicenseObj > >();
		}
		if( indexByDomainIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IIntNetLicenseObj> dict = indexByDomainIdx.get( key );
			schema.getIntNetBackingStore().getTableLicense().deleteLicenseByDomainIdx( null,
				TopDomainId );
			Iterator<IIntNetLicenseObj> iter = dict.values().iterator();
			IIntNetLicenseObj obj;
			List<IIntNetLicenseObj> toForget = new LinkedList<IIntNetLicenseObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByDomainIdx.remove( key );
		}
		else {
			schema.getIntNetBackingStore().getTableLicense().deleteLicenseByDomainIdx( null,
				TopDomainId );
		}
		deepDisposeLicenseByDomainIdx( TopDomainId );
	}

	@Override
	public void deleteLicenseByUNameIdx( IYCFKeyHash256 TopDomainId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IIntNetLicenseByUNameIdxKey,
				IIntNetLicenseObj >();
		}
		IIntNetLicenseByUNameIdxKey key = schema.getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newByUNameIdxKey();
		key.setRequiredTopDomainId( TopDomainId );
		key.setRequiredName( Name );
		IIntNetLicenseObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getIntNetBackingStore().getTableLicense().deleteLicenseByUNameIdx( null,
				TopDomainId,
				Name );
			obj.forget();
		}
		else {
			schema.getIntNetBackingStore().getTableLicense().deleteLicenseByUNameIdx( null,
				TopDomainId,
				Name );
		}
		deepDisposeLicenseByUNameIdx( TopDomainId,
				Name );
	}
}