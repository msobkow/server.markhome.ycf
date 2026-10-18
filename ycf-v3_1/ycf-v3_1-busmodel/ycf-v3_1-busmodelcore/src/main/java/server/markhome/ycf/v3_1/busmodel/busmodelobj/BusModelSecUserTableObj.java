// Description: Java 25 Table Object implementation for SecUser.

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

public class BusModelSecUserTableObj
	implements IBusModelSecUserTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecUserObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecUserObj> allSecUser;
	private Map< ISecureSecUserByULoginIdxKey,
		ISecureSecUserObj > indexByULoginIdx;
	private Map< ISecureSecUserByEMAddrIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecUserObj > > indexByEMAddrIdx;
	public static String TABLE_NAME = "SecUser";
	public static String TABLE_DBNAME = "secuser";

	public BusModelSecUserTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecUserObj>();
		allSecUser = null;
		indexByULoginIdx = null;
		indexByEMAddrIdx = null;
	}

	public BusModelSecUserTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecUserObj>();
		allSecUser = null;
		indexByULoginIdx = null;
		indexByEMAddrIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSecUserTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecUserTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecUserTableObj.getRuntimeClassCode() );
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
		allSecUser = null;
		indexByULoginIdx = null;
		indexByEMAddrIdx = null;
		List<ISecureSecUserObj> toForget = new LinkedList<ISecureSecUserObj>();
		ISecureSecUserObj cur = null;
		Iterator<ISecureSecUserObj> iter = members.values().iterator();
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
	 *	BusModelSecUserObj.
	 */
	@Override
	public ISecureSecUserObj newInstance() {
		ISecureSecUserObj inst = new BusModelSecUserObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecUserObj.
	 */
	@Override
	public ISecureSecUserEditObj newEditInstance( ISecureSecUserObj orig ) {
		ISecureSecUserEditObj edit = new BusModelSecUserEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecUserObj constructByClassCode( int backingClassCode ) {
		ISecureSecUserObj obj = null;
		if( backingClassCode == ISecureSecUser.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecUserTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecUserObj realiseSecUser( ISecureSecUserObj Obj ) {
		ISecureSecUserObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecUserObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecUserObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByULoginIdx != null ) {
				ISecureSecUserByULoginIdxKey keyULoginIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUser().newByULoginIdxKey();
				keyULoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				indexByULoginIdx.remove( keyULoginIdx );
			}

			if( indexByEMAddrIdx != null ) {
				ISecureSecUserByEMAddrIdxKey keyEMAddrIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUser().newByEMAddrIdxKey();
				keyEMAddrIdx.setRequiredEMailAddress( keepObj.getRequiredEMailAddress() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserObj > mapEMAddrIdx = indexByEMAddrIdx.get( keyEMAddrIdx );
				if( mapEMAddrIdx != null ) {
					mapEMAddrIdx.remove( keepObj.getPKey() );
					if( mapEMAddrIdx.size() <= 0 ) {
						indexByEMAddrIdx.remove( keyEMAddrIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByULoginIdx != null ) {
				ISecureSecUserByULoginIdxKey keyULoginIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUser().newByULoginIdxKey();
				keyULoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				indexByULoginIdx.put( keyULoginIdx, keepObj );
			}

			if( indexByEMAddrIdx != null ) {
				ISecureSecUserByEMAddrIdxKey keyEMAddrIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUser().newByEMAddrIdxKey();
				keyEMAddrIdx.setRequiredEMailAddress( keepObj.getRequiredEMailAddress() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserObj > mapEMAddrIdx = indexByEMAddrIdx.get( keyEMAddrIdx );
				if( mapEMAddrIdx != null ) {
					mapEMAddrIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSecUser != null ) {
				allSecUser.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecUser != null ) {
				allSecUser.put( keepObj.getPKey(), keepObj );
			}

			if( indexByULoginIdx != null ) {
				ISecureSecUserByULoginIdxKey keyULoginIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUser().newByULoginIdxKey();
				keyULoginIdx.setRequiredLoginId( keepObj.getRequiredLoginId() );
				indexByULoginIdx.put( keyULoginIdx, keepObj );
			}

			if( indexByEMAddrIdx != null ) {
				ISecureSecUserByEMAddrIdxKey keyEMAddrIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUser().newByEMAddrIdxKey();
				keyEMAddrIdx.setRequiredEMailAddress( keepObj.getRequiredEMailAddress() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserObj > mapEMAddrIdx = indexByEMAddrIdx.get( keyEMAddrIdx );
				if( mapEMAddrIdx != null ) {
					mapEMAddrIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecUserObj createSecUser( ISecureSecUserObj Obj ) {
		ISecureSecUserObj obj = Obj;
		ISecureSecUser rec = obj.getSecUserRec();
		schema.getSecureBackingStore().getTableSecUser().createSecUser(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecUserObj readSecUser( $implCommaIJavaOptAtomType$ pkey ) {
		return( readSecUser( pkey, false ) );
	}

	@Override
	public ISecureSecUserObj readSecUser( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureSecUserObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecUser readRec = schema.getSecureBackingStore().getTableSecUser().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getSecUserTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecUserObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecUserObj readCachedSecUser( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecUserObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecUser( ISecureSecUserObj obj )
	{
		final String S_ProcName = "BusModelSecUserTableObj.reallyDeepDisposeSecUser() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecUserObj existing = readCachedSecUser( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecUserByULoginIdxKey keyULoginIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecUser().newByULoginIdxKey();
		keyULoginIdx.setRequiredLoginId( existing.getRequiredLoginId() );

		ISecureSecUserByEMAddrIdxKey keyEMAddrIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecUser().newByEMAddrIdxKey();
		keyEMAddrIdx.setRequiredEMailAddress( existing.getRequiredEMailAddress() );


					schema.getSecUserPasswordTableObj().deepDisposeSecUserPasswordByIdIdx( existing.getRequiredSecUserId() );
					schema.getSecSysGrpMembTableObj().deepDisposeSecSysGrpMembByLoginIdx( existing.getRequiredLoginId() );
					schema.getSecClusGrpMembTableObj().deepDisposeSecClusGrpMembByLoginIdx( existing.getRequiredLoginId() );
					schema.getSecTentGrpMembTableObj().deepDisposeSecTentGrpMembByUserIdx( existing.getRequiredLoginId() );
					schema.getSecUserPasswordTableObj().deepDisposeSecUserPasswordByIdIdx( existing.getRequiredSecUserId() );
					schema.getSecUserPWResetTableObj().deepDisposeSecUserPWResetByIdIdx( existing.getRequiredSecUserId() );
					schema.getSecUserEMConfTableObj().deepDisposeSecUserEMConfByIdIdx( existing.getRequiredSecUserId() );

		if( indexByULoginIdx != null ) {
			indexByULoginIdx.remove( keyULoginIdx );
		}

		if( indexByEMAddrIdx != null ) {
			if( indexByEMAddrIdx.containsKey( keyEMAddrIdx ) ) {
				indexByEMAddrIdx.get( keyEMAddrIdx ).remove( pkey );
				if( indexByEMAddrIdx.get( keyEMAddrIdx ).size() <= 0 ) {
					indexByEMAddrIdx.remove( keyEMAddrIdx );
				}
			}
		}


	}
	@Override
	public void deepDisposeSecUser( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecUserObj obj = readCachedSecUser( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecUserObj lockSecUser( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecUserObj locked = null;
		ISecureSecUser lockRec = schema.getSecureBackingStore().getTableSecUser().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecUserTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecUserObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecUser", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecUserObj> readAllSecUser() {
		return( readAllSecUser( false ) );
	}

	@Override
	public List<ISecureSecUserObj> readAllSecUser( boolean forceRead ) {
		final String S_ProcName = "readAllSecUser";
		if( ( allSecUser == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureSecUserObj>();
			allSecUser = map;
			ISecureSecUser[] recList = schema.getSecureBackingStore().getTableSecUser().readAllDerived( null );
			ISecureSecUser rec;
			ISecureSecUserObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecUserObj realised = (ISecureSecUserObj)obj.realise();
			}
		}
		int len = allSecUser.size();
		ISecureSecUserObj arr[] = new ISecureSecUserObj[len];
		Iterator<ISecureSecUserObj> valIter = allSecUser.values().iterator();
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
		ArrayList<ISecureSecUserObj> arrayList = new ArrayList<ISecureSecUserObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecUserObj> cmp = new Comparator<ISecureSecUserObj>() {
			@Override
			public int compare( ISecureSecUserObj lhs, ISecureSecUserObj rhs ) {
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
		List<ISecureSecUserObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecUserObj> readCachedAllSecUser() {
		final String S_ProcName = "readCachedAllSecUser";
		ArrayList<ISecureSecUserObj> arrayList = new ArrayList<ISecureSecUserObj>();
		if( allSecUser != null ) {
			int len = allSecUser.size();
			ISecureSecUserObj arr[] = new ISecureSecUserObj[len];
			Iterator<ISecureSecUserObj> valIter = allSecUser.values().iterator();
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
		Comparator<ISecureSecUserObj> cmp = new Comparator<ISecureSecUserObj>() {
			public int compare( ISecureSecUserObj lhs, ISecureSecUserObj rhs ) {
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
	 *	Return a sorted map of a page of the SecUser-derived instances in the database.
	 *
	 *	@return	List of ISecureSecUserObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	@Override
	public List<ISecureSecUserObj> pageAllSecUser(IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageAllSecUser";
		Map<$implCommaIJavaOptAtomType$, ISecureSecUserObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureSecUserObj>();
		ISecureSecUser[] recList = schema.getSecureBackingStore().getTableSecUser().pageAllRec( null,
			priorSecUserId );
		ISecureSecUser rec;
		ISecureSecUserObj obj;
		ISecureSecUserObj realised;
		ArrayList<ISecureSecUserObj> arrayList = new ArrayList<ISecureSecUserObj>( recList.length );
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			realised = (ISecureSecUserObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	@Override
	public ISecureSecUserObj readSecUserByIdIdx( IYCFKeyHash256 SecUserId )
	{
		return( readSecUserByIdIdx( SecUserId,
			false ) );
	}

	@Override
	public ISecureSecUserObj readSecUserByIdIdx( IYCFKeyHash256 SecUserId, boolean forceRead )
	{
		ISecureSecUserObj obj = readSecUser( SecUserId, forceRead );
		return( obj );
	}

	@Override
	public ISecureSecUserObj readSecUserByULoginIdx( String LoginId )
	{
		return( readSecUserByULoginIdx( LoginId,
			false ) );
	}

	@Override
	public ISecureSecUserObj readSecUserByULoginIdx( String LoginId, boolean forceRead )
	{
		if( indexByULoginIdx == null ) {
			indexByULoginIdx = new HashMap< ISecureSecUserByULoginIdxKey,
				ISecureSecUserObj >();
		}
		ISecureSecUserByULoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUser().newByULoginIdxKey();
		key.setRequiredLoginId( LoginId );
		ISecureSecUserObj obj = null;
		if( ( ! forceRead ) && indexByULoginIdx.containsKey( key ) ) {
			obj = indexByULoginIdx.get( key );
		}
		else {
			ISecureSecUser rec = schema.getSecureBackingStore().getTableSecUser().readDerivedByULoginIdx( null,
				LoginId );
			if( rec != null ) {
				obj = schema.getSecUserTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureSecUserObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<ISecureSecUserObj> readSecUserByEMAddrIdx( String EMailAddress )
	{
		return( readSecUserByEMAddrIdx( EMailAddress,
			false ) );
	}

	@Override
	public List<ISecureSecUserObj> readSecUserByEMAddrIdx( String EMailAddress,
		boolean forceRead )
	{
		final String S_ProcName = "readSecUserByEMAddrIdx";
		ISecureSecUserByEMAddrIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUser().newByEMAddrIdxKey();
		key.setRequiredEMailAddress( EMailAddress );
		Map<$implCommaIJavaOptAtomType$, ISecureSecUserObj> dict;
		if( indexByEMAddrIdx == null ) {
			indexByEMAddrIdx = new HashMap< ISecureSecUserByEMAddrIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecUserObj > >();
		}
		if( ( ! forceRead ) && indexByEMAddrIdx.containsKey( key ) ) {
			dict = indexByEMAddrIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecUserObj>();
			ISecureSecUserObj obj;
			ISecureSecUser[] recList = schema.getSecureBackingStore().getTableSecUser().readDerivedByEMAddrIdx( null,
				EMailAddress );
			ISecureSecUser rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecUserTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecUserObj realised = (ISecureSecUserObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByEMAddrIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecUserObj arr[] = new ISecureSecUserObj[len];
		Iterator<ISecureSecUserObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecUserObj> arrayList = new ArrayList<ISecureSecUserObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecUserObj> cmp = new Comparator<ISecureSecUserObj>() {
			@Override
			public int compare( ISecureSecUserObj lhs, ISecureSecUserObj rhs ) {
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
		List<ISecureSecUserObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecUserObj readCachedSecUserByIdIdx( IYCFKeyHash256 SecUserId )
	{
		ISecureSecUserObj obj = null;
		obj = readCachedSecUser( SecUserId );
		return( obj );
	}

	@Override
	public ISecureSecUserObj readCachedSecUserByULoginIdx( String LoginId )
	{
		ISecureSecUserObj obj = null;
		ISecureSecUserByULoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUser().newByULoginIdxKey();
		key.setRequiredLoginId( LoginId );
		if( indexByULoginIdx != null ) {
			if( indexByULoginIdx.containsKey( key ) ) {
				obj = indexByULoginIdx.get( key );
			}
			else {
				Iterator<ISecureSecUserObj> valIter = members.values().iterator();
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
			Iterator<ISecureSecUserObj> valIter = members.values().iterator();
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
	public List<ISecureSecUserObj> readCachedSecUserByEMAddrIdx( String EMailAddress )
	{
		final String S_ProcName = "readCachedSecUserByEMAddrIdx";
		ISecureSecUserByEMAddrIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUser().newByEMAddrIdxKey();
		key.setRequiredEMailAddress( EMailAddress );
		ArrayList<ISecureSecUserObj> arrayList = new ArrayList<ISecureSecUserObj>();
		if( indexByEMAddrIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserObj> dict;
			if( indexByEMAddrIdx.containsKey( key ) ) {
				dict = indexByEMAddrIdx.get( key );
				int len = dict.size();
				ISecureSecUserObj arr[] = new ISecureSecUserObj[len];
				Iterator<ISecureSecUserObj> valIter = dict.values().iterator();
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
			ISecureSecUserObj obj;
			Iterator<ISecureSecUserObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecUserObj> cmp = new Comparator<ISecureSecUserObj>() {
			@Override
			public int compare( ISecureSecUserObj lhs, ISecureSecUserObj rhs ) {
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
	public void deepDisposeSecUserByIdIdx( IYCFKeyHash256 SecUserId )
	{
		ISecureSecUserObj obj = readCachedSecUserByIdIdx( SecUserId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecUserByULoginIdx( String LoginId )
	{
		ISecureSecUserObj obj = readCachedSecUserByULoginIdx( LoginId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecUserByEMAddrIdx( String EMailAddress )
	{
		final String S_ProcName = "deepDisposeSecUserByEMAddrIdx";
		ISecureSecUserObj obj;
		List<ISecureSecUserObj> arrayList = readCachedSecUserByEMAddrIdx( EMailAddress );
		if( arrayList != null )  {
			Iterator<ISecureSecUserObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	/**
	 *	Read a page of data as a List of SecUser-derived instances sorted by their primary keys,
	 *	as identified by the duplicate EMAddrIdx key attributes.
	 *
	 *	@param	EMailAddress	The SecUser key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecUser-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecUserObj> pageSecUserByEMAddrIdx( String EMailAddress,
		IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageSecUserByEMAddrIdx";
		ISecureSecUserByEMAddrIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUser().newByEMAddrIdxKey();
		key.setRequiredEMailAddress( EMailAddress );
		List<ISecureSecUserObj> retList = new LinkedList<ISecureSecUserObj>();
		ISecureSecUserObj obj;
		ISecureSecUser[] recList = schema.getSecureBackingStore().getTableSecUser().pageRecByEMAddrIdx( null,
				EMailAddress,
			priorSecUserId );
		ISecureSecUser rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecUserTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecUserObj realised = (ISecureSecUserObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	@Override
	public ISecureSecUserObj updateSecUser( ISecureSecUserObj Obj ) {
		ISecureSecUserObj obj = Obj;
		schema.getSecureBackingStore().getTableSecUser().updateSecUser( null,
			Obj.getSecUserRec() );
		obj = (ISecureSecUserObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecUser( ISecureSecUserObj Obj ) {
		ISecureSecUserObj obj = Obj;
		schema.getSecureBackingStore().getTableSecUser().deleteSecUser( null,
			obj.getSecUserRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecUserByIdIdx( IYCFKeyHash256 SecUserId )
	{
		ISecureSecUserObj obj = readSecUser(SecUserId);
		if( obj != null ) {
			ISecureSecUserEditObj editObj = (ISecureSecUserEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecUserEditObj)obj.beginEdit();
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
		deepDisposeSecUserByIdIdx( SecUserId );
	}

	@Override
	public void deleteSecUserByULoginIdx( String LoginId )
	{
		if( indexByULoginIdx == null ) {
			indexByULoginIdx = new HashMap< ISecureSecUserByULoginIdxKey,
				ISecureSecUserObj >();
		}
		ISecureSecUserByULoginIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUser().newByULoginIdxKey();
		key.setRequiredLoginId( LoginId );
		ISecureSecUserObj obj = null;
		if( indexByULoginIdx.containsKey( key ) ) {
			obj = indexByULoginIdx.get( key );
			schema.getSecureBackingStore().getTableSecUser().deleteSecUserByULoginIdx( null,
				LoginId );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableSecUser().deleteSecUserByULoginIdx( null,
				LoginId );
		}
		deepDisposeSecUserByULoginIdx( LoginId );
	}

	@Override
	public void deleteSecUserByEMAddrIdx( String EMailAddress )
	{
		ISecureSecUserByEMAddrIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUser().newByEMAddrIdxKey();
		key.setRequiredEMailAddress( EMailAddress );
		if( indexByEMAddrIdx == null ) {
			indexByEMAddrIdx = new HashMap< ISecureSecUserByEMAddrIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecUserObj > >();
		}
		if( indexByEMAddrIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserObj> dict = indexByEMAddrIdx.get( key );
			schema.getSecureBackingStore().getTableSecUser().deleteSecUserByEMAddrIdx( null,
				EMailAddress );
			Iterator<ISecureSecUserObj> iter = dict.values().iterator();
			ISecureSecUserObj obj;
			List<ISecureSecUserObj> toForget = new LinkedList<ISecureSecUserObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByEMAddrIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecUser().deleteSecUserByEMAddrIdx( null,
				EMailAddress );
		}
		deepDisposeSecUserByEMAddrIdx( EMailAddress );
	}
}