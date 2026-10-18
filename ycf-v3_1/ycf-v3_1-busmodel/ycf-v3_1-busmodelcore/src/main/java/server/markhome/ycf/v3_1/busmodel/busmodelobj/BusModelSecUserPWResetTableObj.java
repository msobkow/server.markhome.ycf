// Description: Java 25 Table Object implementation for SecUserPWReset.

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

public class BusModelSecUserPWResetTableObj
	implements IBusModelSecUserPWResetTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj> allSecUserPWReset;
	private Map< ISecureSecUserPWResetByUUuid6IdxKey,
		ISecureSecUserPWResetObj > indexByUUuid6Idx;
	private Map< ISecureSecUserPWResetBySentEMAddrIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj > > indexBySentEMAddrIdx;
	private Map< ISecureSecUserPWResetByNewAcctIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj > > indexByNewAcctIdx;
	public static String TABLE_NAME = "SecUserPWReset";
	public static String TABLE_DBNAME = "secusrpwrst";

	public BusModelSecUserPWResetTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj>();
		allSecUserPWReset = null;
		indexByUUuid6Idx = null;
		indexBySentEMAddrIdx = null;
		indexByNewAcctIdx = null;
	}

	public BusModelSecUserPWResetTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj>();
		allSecUserPWReset = null;
		indexByUUuid6Idx = null;
		indexBySentEMAddrIdx = null;
		indexByNewAcctIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSecUserPWResetTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecUserPWResetTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecUserPWResetTableObj.getRuntimeClassCode() );
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
		allSecUserPWReset = null;
		indexByUUuid6Idx = null;
		indexBySentEMAddrIdx = null;
		indexByNewAcctIdx = null;
		List<ISecureSecUserPWResetObj> toForget = new LinkedList<ISecureSecUserPWResetObj>();
		ISecureSecUserPWResetObj cur = null;
		Iterator<ISecureSecUserPWResetObj> iter = members.values().iterator();
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
	 *	BusModelSecUserPWResetObj.
	 */
	@Override
	public ISecureSecUserPWResetObj newInstance() {
		ISecureSecUserPWResetObj inst = new BusModelSecUserPWResetObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecUserPWResetObj.
	 */
	@Override
	public ISecureSecUserPWResetEditObj newEditInstance( ISecureSecUserPWResetObj orig ) {
		ISecureSecUserPWResetEditObj edit = new BusModelSecUserPWResetEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecUserPWResetObj constructByClassCode( int backingClassCode ) {
		ISecureSecUserPWResetObj obj = null;
		if( backingClassCode == ISecureSecUserPWReset.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecUserPWResetTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecUserPWResetObj realiseSecUserPWReset( ISecureSecUserPWResetObj Obj ) {
		ISecureSecUserPWResetObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecUserPWResetObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecUserPWResetObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUUuid6Idx != null ) {
				ISecureSecUserPWResetByUUuid6IdxKey keyUUuid6Idx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newByUUuid6IdxKey();
				keyUUuid6Idx.setRequiredPasswordResetUuid6( keepObj.getRequiredPasswordResetUuid6() );
				indexByUUuid6Idx.remove( keyUUuid6Idx );
			}

			if( indexBySentEMAddrIdx != null ) {
				ISecureSecUserPWResetBySentEMAddrIdxKey keySentEMAddrIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newBySentEMAddrIdxKey();
				keySentEMAddrIdx.setRequiredSentToEMailAddr( keepObj.getRequiredSentToEMailAddr() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj > mapSentEMAddrIdx = indexBySentEMAddrIdx.get( keySentEMAddrIdx );
				if( mapSentEMAddrIdx != null ) {
					mapSentEMAddrIdx.remove( keepObj.getPKey() );
					if( mapSentEMAddrIdx.size() <= 0 ) {
						indexBySentEMAddrIdx.remove( keySentEMAddrIdx );
					}
				}
			}

			if( indexByNewAcctIdx != null ) {
				ISecureSecUserPWResetByNewAcctIdxKey keyNewAcctIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newByNewAcctIdxKey();
				keyNewAcctIdx.setRequiredNewAccount( keepObj.getRequiredNewAccount() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj > mapNewAcctIdx = indexByNewAcctIdx.get( keyNewAcctIdx );
				if( mapNewAcctIdx != null ) {
					mapNewAcctIdx.remove( keepObj.getPKey() );
					if( mapNewAcctIdx.size() <= 0 ) {
						indexByNewAcctIdx.remove( keyNewAcctIdx );
					}
				}
			}

			keepObj.setRec( Obj.getRec() );
			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByUUuid6Idx != null ) {
				ISecureSecUserPWResetByUUuid6IdxKey keyUUuid6Idx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newByUUuid6IdxKey();
				keyUUuid6Idx.setRequiredPasswordResetUuid6( keepObj.getRequiredPasswordResetUuid6() );
				indexByUUuid6Idx.put( keyUUuid6Idx, keepObj );
			}

			if( indexBySentEMAddrIdx != null ) {
				ISecureSecUserPWResetBySentEMAddrIdxKey keySentEMAddrIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newBySentEMAddrIdxKey();
				keySentEMAddrIdx.setRequiredSentToEMailAddr( keepObj.getRequiredSentToEMailAddr() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj > mapSentEMAddrIdx = indexBySentEMAddrIdx.get( keySentEMAddrIdx );
				if( mapSentEMAddrIdx != null ) {
					mapSentEMAddrIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNewAcctIdx != null ) {
				ISecureSecUserPWResetByNewAcctIdxKey keyNewAcctIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newByNewAcctIdxKey();
				keyNewAcctIdx.setRequiredNewAccount( keepObj.getRequiredNewAccount() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj > mapNewAcctIdx = indexByNewAcctIdx.get( keyNewAcctIdx );
				if( mapNewAcctIdx != null ) {
					mapNewAcctIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSecUserPWReset != null ) {
				allSecUserPWReset.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecUserPWReset != null ) {
				allSecUserPWReset.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUUuid6Idx != null ) {
				ISecureSecUserPWResetByUUuid6IdxKey keyUUuid6Idx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newByUUuid6IdxKey();
				keyUUuid6Idx.setRequiredPasswordResetUuid6( keepObj.getRequiredPasswordResetUuid6() );
				indexByUUuid6Idx.put( keyUUuid6Idx, keepObj );
			}

			if( indexBySentEMAddrIdx != null ) {
				ISecureSecUserPWResetBySentEMAddrIdxKey keySentEMAddrIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newBySentEMAddrIdxKey();
				keySentEMAddrIdx.setRequiredSentToEMailAddr( keepObj.getRequiredSentToEMailAddr() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj > mapSentEMAddrIdx = indexBySentEMAddrIdx.get( keySentEMAddrIdx );
				if( mapSentEMAddrIdx != null ) {
					mapSentEMAddrIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNewAcctIdx != null ) {
				ISecureSecUserPWResetByNewAcctIdxKey keyNewAcctIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newByNewAcctIdxKey();
				keyNewAcctIdx.setRequiredNewAccount( keepObj.getRequiredNewAccount() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj > mapNewAcctIdx = indexByNewAcctIdx.get( keyNewAcctIdx );
				if( mapNewAcctIdx != null ) {
					mapNewAcctIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecUserPWResetObj createSecUserPWReset( ISecureSecUserPWResetObj Obj ) {
		ISecureSecUserPWResetObj obj = Obj;
		ISecureSecUserPWReset rec = obj.getSecUserPWResetRec();
		schema.getSecureBackingStore().getTableSecUserPWReset().createSecUserPWReset(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecUserPWResetObj readSecUserPWReset( $implCommaIJavaOptAtomType$ pkey ) {
		return( readSecUserPWReset( pkey, false ) );
	}

	@Override
	public ISecureSecUserPWResetObj readSecUserPWReset( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureSecUserPWResetObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecUserPWReset readRec = schema.getSecureBackingStore().getTableSecUserPWReset().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getSecUserPWResetTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecUserPWResetObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecUserPWResetObj readCachedSecUserPWReset( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecUserPWResetObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecUserPWReset( ISecureSecUserPWResetObj obj )
	{
		final String S_ProcName = "BusModelSecUserPWResetTableObj.reallyDeepDisposeSecUserPWReset() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecUserPWResetObj existing = readCachedSecUserPWReset( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecUserPWResetByUUuid6IdxKey keyUUuid6Idx = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newByUUuid6IdxKey();
		keyUUuid6Idx.setRequiredPasswordResetUuid6( existing.getRequiredPasswordResetUuid6() );

		ISecureSecUserPWResetBySentEMAddrIdxKey keySentEMAddrIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newBySentEMAddrIdxKey();
		keySentEMAddrIdx.setRequiredSentToEMailAddr( existing.getRequiredSentToEMailAddr() );

		ISecureSecUserPWResetByNewAcctIdxKey keyNewAcctIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newByNewAcctIdxKey();
		keyNewAcctIdx.setRequiredNewAccount( existing.getRequiredNewAccount() );



		if( indexByUUuid6Idx != null ) {
			indexByUUuid6Idx.remove( keyUUuid6Idx );
		}

		if( indexBySentEMAddrIdx != null ) {
			if( indexBySentEMAddrIdx.containsKey( keySentEMAddrIdx ) ) {
				indexBySentEMAddrIdx.get( keySentEMAddrIdx ).remove( pkey );
				if( indexBySentEMAddrIdx.get( keySentEMAddrIdx ).size() <= 0 ) {
					indexBySentEMAddrIdx.remove( keySentEMAddrIdx );
				}
			}
		}

		if( indexByNewAcctIdx != null ) {
			if( indexByNewAcctIdx.containsKey( keyNewAcctIdx ) ) {
				indexByNewAcctIdx.get( keyNewAcctIdx ).remove( pkey );
				if( indexByNewAcctIdx.get( keyNewAcctIdx ).size() <= 0 ) {
					indexByNewAcctIdx.remove( keyNewAcctIdx );
				}
			}
		}


	}
	@Override
	public void deepDisposeSecUserPWReset( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecUserPWResetObj obj = readCachedSecUserPWReset( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecUserPWResetObj lockSecUserPWReset( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecUserPWResetObj locked = null;
		ISecureSecUserPWReset lockRec = schema.getSecureBackingStore().getTableSecUserPWReset().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecUserPWResetTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecUserPWResetObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecUserPWReset", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecUserPWResetObj> readAllSecUserPWReset() {
		return( readAllSecUserPWReset( false ) );
	}

	@Override
	public List<ISecureSecUserPWResetObj> readAllSecUserPWReset( boolean forceRead ) {
		final String S_ProcName = "readAllSecUserPWReset";
		if( ( allSecUserPWReset == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureSecUserPWResetObj>();
			allSecUserPWReset = map;
			ISecureSecUserPWReset[] recList = schema.getSecureBackingStore().getTableSecUserPWReset().readAllDerived( null );
			ISecureSecUserPWReset rec;
			ISecureSecUserPWResetObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecUserPWResetObj realised = (ISecureSecUserPWResetObj)obj.realise();
			}
		}
		int len = allSecUserPWReset.size();
		ISecureSecUserPWResetObj arr[] = new ISecureSecUserPWResetObj[len];
		Iterator<ISecureSecUserPWResetObj> valIter = allSecUserPWReset.values().iterator();
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
		ArrayList<ISecureSecUserPWResetObj> arrayList = new ArrayList<ISecureSecUserPWResetObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecUserPWResetObj> cmp = new Comparator<ISecureSecUserPWResetObj>() {
			@Override
			public int compare( ISecureSecUserPWResetObj lhs, ISecureSecUserPWResetObj rhs ) {
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
		List<ISecureSecUserPWResetObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecUserPWResetObj> readCachedAllSecUserPWReset() {
		final String S_ProcName = "readCachedAllSecUserPWReset";
		ArrayList<ISecureSecUserPWResetObj> arrayList = new ArrayList<ISecureSecUserPWResetObj>();
		if( allSecUserPWReset != null ) {
			int len = allSecUserPWReset.size();
			ISecureSecUserPWResetObj arr[] = new ISecureSecUserPWResetObj[len];
			Iterator<ISecureSecUserPWResetObj> valIter = allSecUserPWReset.values().iterator();
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
		Comparator<ISecureSecUserPWResetObj> cmp = new Comparator<ISecureSecUserPWResetObj>() {
			public int compare( ISecureSecUserPWResetObj lhs, ISecureSecUserPWResetObj rhs ) {
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
	 *	Return a sorted map of a page of the SecUserPWReset-derived instances in the database.
	 *
	 *	@return	List of ISecureSecUserPWResetObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	@Override
	public List<ISecureSecUserPWResetObj> pageAllSecUserPWReset(IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageAllSecUserPWReset";
		Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureSecUserPWResetObj>();
		ISecureSecUserPWReset[] recList = schema.getSecureBackingStore().getTableSecUserPWReset().pageAllRec( null,
			priorSecUserId );
		ISecureSecUserPWReset rec;
		ISecureSecUserPWResetObj obj;
		ISecureSecUserPWResetObj realised;
		ArrayList<ISecureSecUserPWResetObj> arrayList = new ArrayList<ISecureSecUserPWResetObj>( recList.length );
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			realised = (ISecureSecUserPWResetObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	@Override
	public ISecureSecUserPWResetObj readSecUserPWResetByIdIdx( IYCFKeyHash256 SecUserId )
	{
		return( readSecUserPWResetByIdIdx( SecUserId,
			false ) );
	}

	@Override
	public ISecureSecUserPWResetObj readSecUserPWResetByIdIdx( IYCFKeyHash256 SecUserId, boolean forceRead )
	{
		ISecureSecUserPWResetObj obj = readSecUserPWReset( SecUserId, forceRead );
		return( obj );
	}

	@Override
	public ISecureSecUserPWResetObj readSecUserPWResetByUUuid6Idx( IYCFUuid6 PasswordResetUuid6 )
	{
		return( readSecUserPWResetByUUuid6Idx( PasswordResetUuid6,
			false ) );
	}

	@Override
	public ISecureSecUserPWResetObj readSecUserPWResetByUUuid6Idx( IYCFUuid6 PasswordResetUuid6, boolean forceRead )
	{
		if( indexByUUuid6Idx == null ) {
			indexByUUuid6Idx = new HashMap< ISecureSecUserPWResetByUUuid6IdxKey,
				ISecureSecUserPWResetObj >();
		}
		ISecureSecUserPWResetByUUuid6IdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newByUUuid6IdxKey();
		key.setRequiredPasswordResetUuid6( PasswordResetUuid6 );
		ISecureSecUserPWResetObj obj = null;
		if( ( ! forceRead ) && indexByUUuid6Idx.containsKey( key ) ) {
			obj = indexByUUuid6Idx.get( key );
		}
		else {
			ISecureSecUserPWReset rec = schema.getSecureBackingStore().getTableSecUserPWReset().readDerivedByUUuid6Idx( null,
				PasswordResetUuid6 );
			if( rec != null ) {
				obj = schema.getSecUserPWResetTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureSecUserPWResetObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<ISecureSecUserPWResetObj> readSecUserPWResetBySentEMAddrIdx( String SentToEMailAddr )
	{
		return( readSecUserPWResetBySentEMAddrIdx( SentToEMailAddr,
			false ) );
	}

	@Override
	public List<ISecureSecUserPWResetObj> readSecUserPWResetBySentEMAddrIdx( String SentToEMailAddr,
		boolean forceRead )
	{
		final String S_ProcName = "readSecUserPWResetBySentEMAddrIdx";
		ISecureSecUserPWResetBySentEMAddrIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newBySentEMAddrIdxKey();
		key.setRequiredSentToEMailAddr( SentToEMailAddr );
		Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj> dict;
		if( indexBySentEMAddrIdx == null ) {
			indexBySentEMAddrIdx = new HashMap< ISecureSecUserPWResetBySentEMAddrIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj > >();
		}
		if( ( ! forceRead ) && indexBySentEMAddrIdx.containsKey( key ) ) {
			dict = indexBySentEMAddrIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj>();
			ISecureSecUserPWResetObj obj;
			ISecureSecUserPWReset[] recList = schema.getSecureBackingStore().getTableSecUserPWReset().readDerivedBySentEMAddrIdx( null,
				SentToEMailAddr );
			ISecureSecUserPWReset rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecUserPWResetTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecUserPWResetObj realised = (ISecureSecUserPWResetObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySentEMAddrIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecUserPWResetObj arr[] = new ISecureSecUserPWResetObj[len];
		Iterator<ISecureSecUserPWResetObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecUserPWResetObj> arrayList = new ArrayList<ISecureSecUserPWResetObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecUserPWResetObj> cmp = new Comparator<ISecureSecUserPWResetObj>() {
			@Override
			public int compare( ISecureSecUserPWResetObj lhs, ISecureSecUserPWResetObj rhs ) {
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
		List<ISecureSecUserPWResetObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecUserPWResetObj> readSecUserPWResetByNewAcctIdx( boolean NewAccount )
	{
		return( readSecUserPWResetByNewAcctIdx( NewAccount,
			false ) );
	}

	@Override
	public List<ISecureSecUserPWResetObj> readSecUserPWResetByNewAcctIdx( boolean NewAccount,
		boolean forceRead )
	{
		final String S_ProcName = "readSecUserPWResetByNewAcctIdx";
		ISecureSecUserPWResetByNewAcctIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newByNewAcctIdxKey();
		key.setRequiredNewAccount( NewAccount );
		Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj> dict;
		if( indexByNewAcctIdx == null ) {
			indexByNewAcctIdx = new HashMap< ISecureSecUserPWResetByNewAcctIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj > >();
		}
		if( ( ! forceRead ) && indexByNewAcctIdx.containsKey( key ) ) {
			dict = indexByNewAcctIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj>();
			ISecureSecUserPWResetObj obj;
			ISecureSecUserPWReset[] recList = schema.getSecureBackingStore().getTableSecUserPWReset().readDerivedByNewAcctIdx( null,
				NewAccount );
			ISecureSecUserPWReset rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecUserPWResetTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecUserPWResetObj realised = (ISecureSecUserPWResetObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNewAcctIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecUserPWResetObj arr[] = new ISecureSecUserPWResetObj[len];
		Iterator<ISecureSecUserPWResetObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecUserPWResetObj> arrayList = new ArrayList<ISecureSecUserPWResetObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecUserPWResetObj> cmp = new Comparator<ISecureSecUserPWResetObj>() {
			@Override
			public int compare( ISecureSecUserPWResetObj lhs, ISecureSecUserPWResetObj rhs ) {
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
		List<ISecureSecUserPWResetObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecUserPWResetObj readCachedSecUserPWResetByIdIdx( IYCFKeyHash256 SecUserId )
	{
		ISecureSecUserPWResetObj obj = null;
		obj = readCachedSecUserPWReset( SecUserId );
		return( obj );
	}

	@Override
	public ISecureSecUserPWResetObj readCachedSecUserPWResetByUUuid6Idx( IYCFUuid6 PasswordResetUuid6 )
	{
		ISecureSecUserPWResetObj obj = null;
		ISecureSecUserPWResetByUUuid6IdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newByUUuid6IdxKey();
		key.setRequiredPasswordResetUuid6( PasswordResetUuid6 );
		if( indexByUUuid6Idx != null ) {
			if( indexByUUuid6Idx.containsKey( key ) ) {
				obj = indexByUUuid6Idx.get( key );
			}
			else {
				Iterator<ISecureSecUserPWResetObj> valIter = members.values().iterator();
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
			Iterator<ISecureSecUserPWResetObj> valIter = members.values().iterator();
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
	public List<ISecureSecUserPWResetObj> readCachedSecUserPWResetBySentEMAddrIdx( String SentToEMailAddr )
	{
		final String S_ProcName = "readCachedSecUserPWResetBySentEMAddrIdx";
		ISecureSecUserPWResetBySentEMAddrIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newBySentEMAddrIdxKey();
		key.setRequiredSentToEMailAddr( SentToEMailAddr );
		ArrayList<ISecureSecUserPWResetObj> arrayList = new ArrayList<ISecureSecUserPWResetObj>();
		if( indexBySentEMAddrIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj> dict;
			if( indexBySentEMAddrIdx.containsKey( key ) ) {
				dict = indexBySentEMAddrIdx.get( key );
				int len = dict.size();
				ISecureSecUserPWResetObj arr[] = new ISecureSecUserPWResetObj[len];
				Iterator<ISecureSecUserPWResetObj> valIter = dict.values().iterator();
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
			ISecureSecUserPWResetObj obj;
			Iterator<ISecureSecUserPWResetObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecUserPWResetObj> cmp = new Comparator<ISecureSecUserPWResetObj>() {
			@Override
			public int compare( ISecureSecUserPWResetObj lhs, ISecureSecUserPWResetObj rhs ) {
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
	public List<ISecureSecUserPWResetObj> readCachedSecUserPWResetByNewAcctIdx( boolean NewAccount )
	{
		final String S_ProcName = "readCachedSecUserPWResetByNewAcctIdx";
		ISecureSecUserPWResetByNewAcctIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newByNewAcctIdxKey();
		key.setRequiredNewAccount( NewAccount );
		ArrayList<ISecureSecUserPWResetObj> arrayList = new ArrayList<ISecureSecUserPWResetObj>();
		if( indexByNewAcctIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj> dict;
			if( indexByNewAcctIdx.containsKey( key ) ) {
				dict = indexByNewAcctIdx.get( key );
				int len = dict.size();
				ISecureSecUserPWResetObj arr[] = new ISecureSecUserPWResetObj[len];
				Iterator<ISecureSecUserPWResetObj> valIter = dict.values().iterator();
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
			ISecureSecUserPWResetObj obj;
			Iterator<ISecureSecUserPWResetObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecUserPWResetObj> cmp = new Comparator<ISecureSecUserPWResetObj>() {
			@Override
			public int compare( ISecureSecUserPWResetObj lhs, ISecureSecUserPWResetObj rhs ) {
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
	public void deepDisposeSecUserPWResetByIdIdx( IYCFKeyHash256 SecUserId )
	{
		ISecureSecUserPWResetObj obj = readCachedSecUserPWResetByIdIdx( SecUserId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecUserPWResetByUUuid6Idx( IYCFUuid6 PasswordResetUuid6 )
	{
		ISecureSecUserPWResetObj obj = readCachedSecUserPWResetByUUuid6Idx( PasswordResetUuid6 );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecUserPWResetBySentEMAddrIdx( String SentToEMailAddr )
	{
		final String S_ProcName = "deepDisposeSecUserPWResetBySentEMAddrIdx";
		ISecureSecUserPWResetObj obj;
		List<ISecureSecUserPWResetObj> arrayList = readCachedSecUserPWResetBySentEMAddrIdx( SentToEMailAddr );
		if( arrayList != null )  {
			Iterator<ISecureSecUserPWResetObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecUserPWResetByNewAcctIdx( boolean NewAccount )
	{
		final String S_ProcName = "deepDisposeSecUserPWResetByNewAcctIdx";
		ISecureSecUserPWResetObj obj;
		List<ISecureSecUserPWResetObj> arrayList = readCachedSecUserPWResetByNewAcctIdx( NewAccount );
		if( arrayList != null )  {
			Iterator<ISecureSecUserPWResetObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	/**
	 *	Read a page of data as a List of SecUserPWReset-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SentEMAddrIdx key attributes.
	 *
	 *	@param	SentToEMailAddr	The SecUserPWReset key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecUserPWReset-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecUserPWResetObj> pageSecUserPWResetBySentEMAddrIdx( String SentToEMailAddr,
		IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageSecUserPWResetBySentEMAddrIdx";
		ISecureSecUserPWResetBySentEMAddrIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newBySentEMAddrIdxKey();
		key.setRequiredSentToEMailAddr( SentToEMailAddr );
		List<ISecureSecUserPWResetObj> retList = new LinkedList<ISecureSecUserPWResetObj>();
		ISecureSecUserPWResetObj obj;
		ISecureSecUserPWReset[] recList = schema.getSecureBackingStore().getTableSecUserPWReset().pageRecBySentEMAddrIdx( null,
				SentToEMailAddr,
			priorSecUserId );
		ISecureSecUserPWReset rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecUserPWResetTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecUserPWResetObj realised = (ISecureSecUserPWResetObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecUserPWReset-derived instances sorted by their primary keys,
	 *	as identified by the duplicate NewAcctIdx key attributes.
	 *
	 *	@param	NewAccount	The SecUserPWReset key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecUserPWReset-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecUserPWResetObj> pageSecUserPWResetByNewAcctIdx( boolean NewAccount,
		IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageSecUserPWResetByNewAcctIdx";
		ISecureSecUserPWResetByNewAcctIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newByNewAcctIdxKey();
		key.setRequiredNewAccount( NewAccount );
		List<ISecureSecUserPWResetObj> retList = new LinkedList<ISecureSecUserPWResetObj>();
		ISecureSecUserPWResetObj obj;
		ISecureSecUserPWReset[] recList = schema.getSecureBackingStore().getTableSecUserPWReset().pageRecByNewAcctIdx( null,
				NewAccount,
			priorSecUserId );
		ISecureSecUserPWReset rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecUserPWResetTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecUserPWResetObj realised = (ISecureSecUserPWResetObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	@Override
	public ISecureSecUserPWResetObj updateSecUserPWReset( ISecureSecUserPWResetObj Obj ) {
		ISecureSecUserPWResetObj obj = Obj;
		schema.getSecureBackingStore().getTableSecUserPWReset().updateSecUserPWReset( null,
			Obj.getSecUserPWResetRec() );
		obj = (ISecureSecUserPWResetObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecUserPWReset( ISecureSecUserPWResetObj Obj ) {
		ISecureSecUserPWResetObj obj = Obj;
		schema.getSecureBackingStore().getTableSecUserPWReset().deleteSecUserPWReset( null,
			obj.getSecUserPWResetRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecUserPWResetByIdIdx( IYCFKeyHash256 SecUserId )
	{
		ISecureSecUserPWResetObj obj = readSecUserPWReset(SecUserId);
		if( obj != null ) {
			ISecureSecUserPWResetEditObj editObj = (ISecureSecUserPWResetEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecUserPWResetEditObj)obj.beginEdit();
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
		deepDisposeSecUserPWResetByIdIdx( SecUserId );
	}

	@Override
	public void deleteSecUserPWResetByUUuid6Idx( IYCFUuid6 PasswordResetUuid6 )
	{
		if( indexByUUuid6Idx == null ) {
			indexByUUuid6Idx = new HashMap< ISecureSecUserPWResetByUUuid6IdxKey,
				ISecureSecUserPWResetObj >();
		}
		ISecureSecUserPWResetByUUuid6IdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newByUUuid6IdxKey();
		key.setRequiredPasswordResetUuid6( PasswordResetUuid6 );
		ISecureSecUserPWResetObj obj = null;
		if( indexByUUuid6Idx.containsKey( key ) ) {
			obj = indexByUUuid6Idx.get( key );
			schema.getSecureBackingStore().getTableSecUserPWReset().deleteSecUserPWResetByUUuid6Idx( null,
				PasswordResetUuid6 );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableSecUserPWReset().deleteSecUserPWResetByUUuid6Idx( null,
				PasswordResetUuid6 );
		}
		deepDisposeSecUserPWResetByUUuid6Idx( PasswordResetUuid6 );
	}

	@Override
	public void deleteSecUserPWResetBySentEMAddrIdx( String SentToEMailAddr )
	{
		ISecureSecUserPWResetBySentEMAddrIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newBySentEMAddrIdxKey();
		key.setRequiredSentToEMailAddr( SentToEMailAddr );
		if( indexBySentEMAddrIdx == null ) {
			indexBySentEMAddrIdx = new HashMap< ISecureSecUserPWResetBySentEMAddrIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj > >();
		}
		if( indexBySentEMAddrIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj> dict = indexBySentEMAddrIdx.get( key );
			schema.getSecureBackingStore().getTableSecUserPWReset().deleteSecUserPWResetBySentEMAddrIdx( null,
				SentToEMailAddr );
			Iterator<ISecureSecUserPWResetObj> iter = dict.values().iterator();
			ISecureSecUserPWResetObj obj;
			List<ISecureSecUserPWResetObj> toForget = new LinkedList<ISecureSecUserPWResetObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexBySentEMAddrIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecUserPWReset().deleteSecUserPWResetBySentEMAddrIdx( null,
				SentToEMailAddr );
		}
		deepDisposeSecUserPWResetBySentEMAddrIdx( SentToEMailAddr );
	}

	@Override
	public void deleteSecUserPWResetByNewAcctIdx( boolean NewAccount )
	{
		ISecureSecUserPWResetByNewAcctIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newByNewAcctIdxKey();
		key.setRequiredNewAccount( NewAccount );
		if( indexByNewAcctIdx == null ) {
			indexByNewAcctIdx = new HashMap< ISecureSecUserPWResetByNewAcctIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj > >();
		}
		if( indexByNewAcctIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserPWResetObj> dict = indexByNewAcctIdx.get( key );
			schema.getSecureBackingStore().getTableSecUserPWReset().deleteSecUserPWResetByNewAcctIdx( null,
				NewAccount );
			Iterator<ISecureSecUserPWResetObj> iter = dict.values().iterator();
			ISecureSecUserPWResetObj obj;
			List<ISecureSecUserPWResetObj> toForget = new LinkedList<ISecureSecUserPWResetObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByNewAcctIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecUserPWReset().deleteSecUserPWResetByNewAcctIdx( null,
				NewAccount );
		}
		deepDisposeSecUserPWResetByNewAcctIdx( NewAccount );
	}
}