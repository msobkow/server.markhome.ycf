// Description: Java 25 Table Object implementation for SecUserEMConf.

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

public class BusModelSecUserEMConfTableObj
	implements IBusModelSecUserEMConfTableObj
{
	protected IBusModelSchemaObj schema;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj> members;
	private Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj> allSecUserEMConf;
	private Map< ISecureSecUserEMConfByUUuid6IdxKey,
		ISecureSecUserEMConfObj > indexByUUuid6Idx;
	private Map< ISecureSecUserEMConfByConfEMAddrIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > > indexByConfEMAddrIdx;
	private Map< ISecureSecUserEMConfBySentStampIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > > indexBySentStampIdx;
	private Map< ISecureSecUserEMConfByNewAcctIdxKey,
		Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > > indexByNewAcctIdx;
	public static String TABLE_NAME = "SecUserEMConf";
	public static String TABLE_DBNAME = "secusremcnf";

	public BusModelSecUserEMConfTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj>();
		allSecUserEMConf = null;
		indexByUUuid6Idx = null;
		indexByConfEMAddrIdx = null;
		indexBySentStampIdx = null;
		indexByNewAcctIdx = null;
	}

	public BusModelSecUserEMConfTableObj( ISecureSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj>();
		allSecUserEMConf = null;
		indexByUUuid6Idx = null;
		indexByConfEMAddrIdx = null;
		indexBySentStampIdx = null;
		indexByNewAcctIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return SecureSecUserEMConfTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( SecureSecUserEMConfTableObj.getBackingClassCode() );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( SecureSecUserEMConfTableObj.getRuntimeClassCode() );
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
		allSecUserEMConf = null;
		indexByUUuid6Idx = null;
		indexByConfEMAddrIdx = null;
		indexBySentStampIdx = null;
		indexByNewAcctIdx = null;
		List<ISecureSecUserEMConfObj> toForget = new LinkedList<ISecureSecUserEMConfObj>();
		ISecureSecUserEMConfObj cur = null;
		Iterator<ISecureSecUserEMConfObj> iter = members.values().iterator();
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
	 *	BusModelSecUserEMConfObj.
	 */
	@Override
	public ISecureSecUserEMConfObj newInstance() {
		ISecureSecUserEMConfObj inst = new BusModelSecUserEMConfObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSecUserEMConfObj.
	 */
	@Override
	public ISecureSecUserEMConfEditObj newEditInstance( ISecureSecUserEMConfObj orig ) {
		ISecureSecUserEMConfEditObj edit = new BusModelSecUserEMConfEditObj( orig );
		return( edit );
	}

	@Override
	public ISecureSecUserEMConfObj constructByClassCode( int backingClassCode ) {
		ISecureSecUserEMConfObj obj = null;
		if( backingClassCode == ISecureSecUserEMConf.CLASS_CODE) {
			obj = ((IBusModelSchemaObj)schema).getSecUserEMConfTableObj().newInstance();
		}
		return( obj );
	}

	@Override
	public ISecureSecUserEMConfObj realiseSecUserEMConf( ISecureSecUserEMConfObj Obj ) {
		ISecureSecUserEMConfObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecUserEMConfObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			ISecureSecUserEMConfObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByUUuid6Idx != null ) {
				ISecureSecUserEMConfByUUuid6IdxKey keyUUuid6Idx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByUUuid6IdxKey();
				keyUUuid6Idx.setRequiredEMConfirmationUuid6( keepObj.getRequiredEMConfirmationUuid6() );
				indexByUUuid6Idx.remove( keyUUuid6Idx );
			}

			if( indexByConfEMAddrIdx != null ) {
				ISecureSecUserEMConfByConfEMAddrIdxKey keyConfEMAddrIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByConfEMAddrIdxKey();
				keyConfEMAddrIdx.setRequiredConfirmEMailAddr( keepObj.getRequiredConfirmEMailAddr() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > mapConfEMAddrIdx = indexByConfEMAddrIdx.get( keyConfEMAddrIdx );
				if( mapConfEMAddrIdx != null ) {
					mapConfEMAddrIdx.remove( keepObj.getPKey() );
					if( mapConfEMAddrIdx.size() <= 0 ) {
						indexByConfEMAddrIdx.remove( keyConfEMAddrIdx );
					}
				}
			}

			if( indexBySentStampIdx != null ) {
				ISecureSecUserEMConfBySentStampIdxKey keySentStampIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newBySentStampIdxKey();
				keySentStampIdx.setRequiredEMailSentStamp( keepObj.getRequiredEMailSentStamp() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > mapSentStampIdx = indexBySentStampIdx.get( keySentStampIdx );
				if( mapSentStampIdx != null ) {
					mapSentStampIdx.remove( keepObj.getPKey() );
					if( mapSentStampIdx.size() <= 0 ) {
						indexBySentStampIdx.remove( keySentStampIdx );
					}
				}
			}

			if( indexByNewAcctIdx != null ) {
				ISecureSecUserEMConfByNewAcctIdxKey keyNewAcctIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByNewAcctIdxKey();
				keyNewAcctIdx.setRequiredNewAccount( keepObj.getRequiredNewAccount() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > mapNewAcctIdx = indexByNewAcctIdx.get( keyNewAcctIdx );
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
				ISecureSecUserEMConfByUUuid6IdxKey keyUUuid6Idx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByUUuid6IdxKey();
				keyUUuid6Idx.setRequiredEMConfirmationUuid6( keepObj.getRequiredEMConfirmationUuid6() );
				indexByUUuid6Idx.put( keyUUuid6Idx, keepObj );
			}

			if( indexByConfEMAddrIdx != null ) {
				ISecureSecUserEMConfByConfEMAddrIdxKey keyConfEMAddrIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByConfEMAddrIdxKey();
				keyConfEMAddrIdx.setRequiredConfirmEMailAddr( keepObj.getRequiredConfirmEMailAddr() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > mapConfEMAddrIdx = indexByConfEMAddrIdx.get( keyConfEMAddrIdx );
				if( mapConfEMAddrIdx != null ) {
					mapConfEMAddrIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySentStampIdx != null ) {
				ISecureSecUserEMConfBySentStampIdxKey keySentStampIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newBySentStampIdxKey();
				keySentStampIdx.setRequiredEMailSentStamp( keepObj.getRequiredEMailSentStamp() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > mapSentStampIdx = indexBySentStampIdx.get( keySentStampIdx );
				if( mapSentStampIdx != null ) {
					mapSentStampIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNewAcctIdx != null ) {
				ISecureSecUserEMConfByNewAcctIdxKey keyNewAcctIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByNewAcctIdxKey();
				keyNewAcctIdx.setRequiredNewAccount( keepObj.getRequiredNewAccount() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > mapNewAcctIdx = indexByNewAcctIdx.get( keyNewAcctIdx );
				if( mapNewAcctIdx != null ) {
					mapNewAcctIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( allSecUserEMConf != null ) {
				allSecUserEMConf.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj.setIsNew( false );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSecUserEMConf != null ) {
				allSecUserEMConf.put( keepObj.getPKey(), keepObj );
			}

			if( indexByUUuid6Idx != null ) {
				ISecureSecUserEMConfByUUuid6IdxKey keyUUuid6Idx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByUUuid6IdxKey();
				keyUUuid6Idx.setRequiredEMConfirmationUuid6( keepObj.getRequiredEMConfirmationUuid6() );
				indexByUUuid6Idx.put( keyUUuid6Idx, keepObj );
			}

			if( indexByConfEMAddrIdx != null ) {
				ISecureSecUserEMConfByConfEMAddrIdxKey keyConfEMAddrIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByConfEMAddrIdxKey();
				keyConfEMAddrIdx.setRequiredConfirmEMailAddr( keepObj.getRequiredConfirmEMailAddr() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > mapConfEMAddrIdx = indexByConfEMAddrIdx.get( keyConfEMAddrIdx );
				if( mapConfEMAddrIdx != null ) {
					mapConfEMAddrIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexBySentStampIdx != null ) {
				ISecureSecUserEMConfBySentStampIdxKey keySentStampIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newBySentStampIdxKey();
				keySentStampIdx.setRequiredEMailSentStamp( keepObj.getRequiredEMailSentStamp() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > mapSentStampIdx = indexBySentStampIdx.get( keySentStampIdx );
				if( mapSentStampIdx != null ) {
					mapSentStampIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByNewAcctIdx != null ) {
				ISecureSecUserEMConfByNewAcctIdxKey keyNewAcctIdx =
					schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByNewAcctIdxKey();
				keyNewAcctIdx.setRequiredNewAccount( keepObj.getRequiredNewAccount() );
				Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > mapNewAcctIdx = indexByNewAcctIdx.get( keyNewAcctIdx );
				if( mapNewAcctIdx != null ) {
					mapNewAcctIdx.put( keepObj.getPKey(), keepObj );
				}
			}

		}
		return( keepObj );
	}

	@Override
	public ISecureSecUserEMConfObj createSecUserEMConf( ISecureSecUserEMConfObj Obj ) {
		ISecureSecUserEMConfObj obj = Obj;
		ISecureSecUserEMConf rec = obj.getSecUserEMConfRec();
		schema.getSecureBackingStore().getTableSecUserEMConf().createSecUserEMConf(
			null,
			rec );
		obj.copyRecToPKey();
		obj = obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public ISecureSecUserEMConfObj readSecUserEMConf( $implCommaIJavaOptAtomType$ pkey ) {
		return( readSecUserEMConf( pkey, false ) );
	}

	@Override
	public ISecureSecUserEMConfObj readSecUserEMConf( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		ISecureSecUserEMConfObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			ISecureSecUserEMConf readRec = schema.getSecureBackingStore().getTableSecUserEMConf().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = schema.getSecUserEMConfTableObj().newInstance();
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (ISecureSecUserEMConfObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public ISecureSecUserEMConfObj readCachedSecUserEMConf( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecUserEMConfObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSecUserEMConf( ISecureSecUserEMConfObj obj )
	{
		final String S_ProcName = "BusModelSecUserEMConfTableObj.reallyDeepDisposeSecUserEMConf() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		ISecureSecUserEMConfObj existing = readCachedSecUserEMConf( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		ISecureSecUserEMConfByUUuid6IdxKey keyUUuid6Idx = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByUUuid6IdxKey();
		keyUUuid6Idx.setRequiredEMConfirmationUuid6( existing.getRequiredEMConfirmationUuid6() );

		ISecureSecUserEMConfByConfEMAddrIdxKey keyConfEMAddrIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByConfEMAddrIdxKey();
		keyConfEMAddrIdx.setRequiredConfirmEMailAddr( existing.getRequiredConfirmEMailAddr() );

		ISecureSecUserEMConfBySentStampIdxKey keySentStampIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newBySentStampIdxKey();
		keySentStampIdx.setRequiredEMailSentStamp( existing.getRequiredEMailSentStamp() );

		ISecureSecUserEMConfByNewAcctIdxKey keyNewAcctIdx = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByNewAcctIdxKey();
		keyNewAcctIdx.setRequiredNewAccount( existing.getRequiredNewAccount() );



		if( indexByUUuid6Idx != null ) {
			indexByUUuid6Idx.remove( keyUUuid6Idx );
		}

		if( indexByConfEMAddrIdx != null ) {
			if( indexByConfEMAddrIdx.containsKey( keyConfEMAddrIdx ) ) {
				indexByConfEMAddrIdx.get( keyConfEMAddrIdx ).remove( pkey );
				if( indexByConfEMAddrIdx.get( keyConfEMAddrIdx ).size() <= 0 ) {
					indexByConfEMAddrIdx.remove( keyConfEMAddrIdx );
				}
			}
		}

		if( indexBySentStampIdx != null ) {
			if( indexBySentStampIdx.containsKey( keySentStampIdx ) ) {
				indexBySentStampIdx.get( keySentStampIdx ).remove( pkey );
				if( indexBySentStampIdx.get( keySentStampIdx ).size() <= 0 ) {
					indexBySentStampIdx.remove( keySentStampIdx );
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
	public void deepDisposeSecUserEMConf( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecUserEMConfObj obj = readCachedSecUserEMConf( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public ISecureSecUserEMConfObj lockSecUserEMConf( $implCommaIJavaOptAtomType$ pkey ) {
		ISecureSecUserEMConfObj locked = null;
		ISecureSecUserEMConf lockRec = schema.getSecureBackingStore().getTableSecUserEMConf().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = schema.getSecUserEMConfTableObj().newInstance();
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (ISecureSecUserEMConfObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSecUserEMConf", pkey );
		}
		return( locked );
	}

	@Override
	public List<ISecureSecUserEMConfObj> readAllSecUserEMConf() {
		return( readAllSecUserEMConf( false ) );
	}

	@Override
	public List<ISecureSecUserEMConfObj> readAllSecUserEMConf( boolean forceRead ) {
		final String S_ProcName = "readAllSecUserEMConf";
		if( ( allSecUserEMConf == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureSecUserEMConfObj>();
			allSecUserEMConf = map;
			ISecureSecUserEMConf[] recList = schema.getSecureBackingStore().getTableSecUserEMConf().readAllDerived( null );
			ISecureSecUserEMConf rec;
			ISecureSecUserEMConfObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecUserEMConfObj realised = (ISecureSecUserEMConfObj)obj.realise();
			}
		}
		int len = allSecUserEMConf.size();
		ISecureSecUserEMConfObj arr[] = new ISecureSecUserEMConfObj[len];
		Iterator<ISecureSecUserEMConfObj> valIter = allSecUserEMConf.values().iterator();
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
		ArrayList<ISecureSecUserEMConfObj> arrayList = new ArrayList<ISecureSecUserEMConfObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecUserEMConfObj> cmp = new Comparator<ISecureSecUserEMConfObj>() {
			@Override
			public int compare( ISecureSecUserEMConfObj lhs, ISecureSecUserEMConfObj rhs ) {
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
		List<ISecureSecUserEMConfObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecUserEMConfObj> readCachedAllSecUserEMConf() {
		final String S_ProcName = "readCachedAllSecUserEMConf";
		ArrayList<ISecureSecUserEMConfObj> arrayList = new ArrayList<ISecureSecUserEMConfObj>();
		if( allSecUserEMConf != null ) {
			int len = allSecUserEMConf.size();
			ISecureSecUserEMConfObj arr[] = new ISecureSecUserEMConfObj[len];
			Iterator<ISecureSecUserEMConfObj> valIter = allSecUserEMConf.values().iterator();
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
		Comparator<ISecureSecUserEMConfObj> cmp = new Comparator<ISecureSecUserEMConfObj>() {
			public int compare( ISecureSecUserEMConfObj lhs, ISecureSecUserEMConfObj rhs ) {
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
	 *	Return a sorted map of a page of the SecUserEMConf-derived instances in the database.
	 *
	 *	@return	List of ISecureSecUserEMConfObj instance, sorted by their primary keys, which
	 *		may include an empty set.
	 */
	@Override
	public List<ISecureSecUserEMConfObj> pageAllSecUserEMConf(IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageAllSecUserEMConf";
		Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj> map = new HashMap<$implCommaIJavaOptAtomType$,ISecureSecUserEMConfObj>();
		ISecureSecUserEMConf[] recList = schema.getSecureBackingStore().getTableSecUserEMConf().pageAllRec( null,
			priorSecUserId );
		ISecureSecUserEMConf rec;
		ISecureSecUserEMConfObj obj;
		ISecureSecUserEMConfObj realised;
		ArrayList<ISecureSecUserEMConfObj> arrayList = new ArrayList<ISecureSecUserEMConfObj>( recList.length );
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			realised = (ISecureSecUserEMConfObj)obj.realise();
			arrayList.add( realised );
		}
		return( arrayList );
	}

	@Override
	public ISecureSecUserEMConfObj readSecUserEMConfByIdIdx( IYCFKeyHash256 SecUserId )
	{
		return( readSecUserEMConfByIdIdx( SecUserId,
			false ) );
	}

	@Override
	public ISecureSecUserEMConfObj readSecUserEMConfByIdIdx( IYCFKeyHash256 SecUserId, boolean forceRead )
	{
		ISecureSecUserEMConfObj obj = readSecUserEMConf( SecUserId, forceRead );
		return( obj );
	}

	@Override
	public ISecureSecUserEMConfObj readSecUserEMConfByUUuid6Idx( IYCFUuid6 EMConfirmationUuid6 )
	{
		return( readSecUserEMConfByUUuid6Idx( EMConfirmationUuid6,
			false ) );
	}

	@Override
	public ISecureSecUserEMConfObj readSecUserEMConfByUUuid6Idx( IYCFUuid6 EMConfirmationUuid6, boolean forceRead )
	{
		if( indexByUUuid6Idx == null ) {
			indexByUUuid6Idx = new HashMap< ISecureSecUserEMConfByUUuid6IdxKey,
				ISecureSecUserEMConfObj >();
		}
		ISecureSecUserEMConfByUUuid6IdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByUUuid6IdxKey();
		key.setRequiredEMConfirmationUuid6( EMConfirmationUuid6 );
		ISecureSecUserEMConfObj obj = null;
		if( ( ! forceRead ) && indexByUUuid6Idx.containsKey( key ) ) {
			obj = indexByUUuid6Idx.get( key );
		}
		else {
			ISecureSecUserEMConf rec = schema.getSecureBackingStore().getTableSecUserEMConf().readDerivedByUUuid6Idx( null,
				EMConfirmationUuid6 );
			if( rec != null ) {
				obj = schema.getSecUserEMConfTableObj().newInstance();
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (ISecureSecUserEMConfObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<ISecureSecUserEMConfObj> readSecUserEMConfByConfEMAddrIdx( String ConfirmEMailAddr )
	{
		return( readSecUserEMConfByConfEMAddrIdx( ConfirmEMailAddr,
			false ) );
	}

	@Override
	public List<ISecureSecUserEMConfObj> readSecUserEMConfByConfEMAddrIdx( String ConfirmEMailAddr,
		boolean forceRead )
	{
		final String S_ProcName = "readSecUserEMConfByConfEMAddrIdx";
		ISecureSecUserEMConfByConfEMAddrIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByConfEMAddrIdxKey();
		key.setRequiredConfirmEMailAddr( ConfirmEMailAddr );
		Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj> dict;
		if( indexByConfEMAddrIdx == null ) {
			indexByConfEMAddrIdx = new HashMap< ISecureSecUserEMConfByConfEMAddrIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > >();
		}
		if( ( ! forceRead ) && indexByConfEMAddrIdx.containsKey( key ) ) {
			dict = indexByConfEMAddrIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj>();
			ISecureSecUserEMConfObj obj;
			ISecureSecUserEMConf[] recList = schema.getSecureBackingStore().getTableSecUserEMConf().readDerivedByConfEMAddrIdx( null,
				ConfirmEMailAddr );
			ISecureSecUserEMConf rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecUserEMConfTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecUserEMConfObj realised = (ISecureSecUserEMConfObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByConfEMAddrIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecUserEMConfObj arr[] = new ISecureSecUserEMConfObj[len];
		Iterator<ISecureSecUserEMConfObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecUserEMConfObj> arrayList = new ArrayList<ISecureSecUserEMConfObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecUserEMConfObj> cmp = new Comparator<ISecureSecUserEMConfObj>() {
			@Override
			public int compare( ISecureSecUserEMConfObj lhs, ISecureSecUserEMConfObj rhs ) {
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
		List<ISecureSecUserEMConfObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecUserEMConfObj> readSecUserEMConfBySentStampIdx( LocalDateTime EMailSentStamp )
	{
		return( readSecUserEMConfBySentStampIdx( EMailSentStamp,
			false ) );
	}

	@Override
	public List<ISecureSecUserEMConfObj> readSecUserEMConfBySentStampIdx( LocalDateTime EMailSentStamp,
		boolean forceRead )
	{
		final String S_ProcName = "readSecUserEMConfBySentStampIdx";
		ISecureSecUserEMConfBySentStampIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newBySentStampIdxKey();
		key.setRequiredEMailSentStamp( EMailSentStamp );
		Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj> dict;
		if( indexBySentStampIdx == null ) {
			indexBySentStampIdx = new HashMap< ISecureSecUserEMConfBySentStampIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > >();
		}
		if( ( ! forceRead ) && indexBySentStampIdx.containsKey( key ) ) {
			dict = indexBySentStampIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj>();
			ISecureSecUserEMConfObj obj;
			ISecureSecUserEMConf[] recList = schema.getSecureBackingStore().getTableSecUserEMConf().readDerivedBySentStampIdx( null,
				EMailSentStamp );
			ISecureSecUserEMConf rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecUserEMConfTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecUserEMConfObj realised = (ISecureSecUserEMConfObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexBySentStampIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecUserEMConfObj arr[] = new ISecureSecUserEMConfObj[len];
		Iterator<ISecureSecUserEMConfObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecUserEMConfObj> arrayList = new ArrayList<ISecureSecUserEMConfObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecUserEMConfObj> cmp = new Comparator<ISecureSecUserEMConfObj>() {
			@Override
			public int compare( ISecureSecUserEMConfObj lhs, ISecureSecUserEMConfObj rhs ) {
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
		List<ISecureSecUserEMConfObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<ISecureSecUserEMConfObj> readSecUserEMConfByNewAcctIdx( boolean NewAccount )
	{
		return( readSecUserEMConfByNewAcctIdx( NewAccount,
			false ) );
	}

	@Override
	public List<ISecureSecUserEMConfObj> readSecUserEMConfByNewAcctIdx( boolean NewAccount,
		boolean forceRead )
	{
		final String S_ProcName = "readSecUserEMConfByNewAcctIdx";
		ISecureSecUserEMConfByNewAcctIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByNewAcctIdxKey();
		key.setRequiredNewAccount( NewAccount );
		Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj> dict;
		if( indexByNewAcctIdx == null ) {
			indexByNewAcctIdx = new HashMap< ISecureSecUserEMConfByNewAcctIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > >();
		}
		if( ( ! forceRead ) && indexByNewAcctIdx.containsKey( key ) ) {
			dict = indexByNewAcctIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj>();
			ISecureSecUserEMConfObj obj;
			ISecureSecUserEMConf[] recList = schema.getSecureBackingStore().getTableSecUserEMConf().readDerivedByNewAcctIdx( null,
				NewAccount );
			ISecureSecUserEMConf rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = schema.getSecUserEMConfTableObj().newInstance();
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				ISecureSecUserEMConfObj realised = (ISecureSecUserEMConfObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByNewAcctIdx.put( key, dict );
		}
		int len = dict.size();
		ISecureSecUserEMConfObj arr[] = new ISecureSecUserEMConfObj[len];
		Iterator<ISecureSecUserEMConfObj> valIter = dict.values().iterator();
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
		ArrayList<ISecureSecUserEMConfObj> arrayList = new ArrayList<ISecureSecUserEMConfObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<ISecureSecUserEMConfObj> cmp = new Comparator<ISecureSecUserEMConfObj>() {
			@Override
			public int compare( ISecureSecUserEMConfObj lhs, ISecureSecUserEMConfObj rhs ) {
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
		List<ISecureSecUserEMConfObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public ISecureSecUserEMConfObj readCachedSecUserEMConfByIdIdx( IYCFKeyHash256 SecUserId )
	{
		ISecureSecUserEMConfObj obj = null;
		obj = readCachedSecUserEMConf( SecUserId );
		return( obj );
	}

	@Override
	public ISecureSecUserEMConfObj readCachedSecUserEMConfByUUuid6Idx( IYCFUuid6 EMConfirmationUuid6 )
	{
		ISecureSecUserEMConfObj obj = null;
		ISecureSecUserEMConfByUUuid6IdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByUUuid6IdxKey();
		key.setRequiredEMConfirmationUuid6( EMConfirmationUuid6 );
		if( indexByUUuid6Idx != null ) {
			if( indexByUUuid6Idx.containsKey( key ) ) {
				obj = indexByUUuid6Idx.get( key );
			}
			else {
				Iterator<ISecureSecUserEMConfObj> valIter = members.values().iterator();
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
			Iterator<ISecureSecUserEMConfObj> valIter = members.values().iterator();
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
	public List<ISecureSecUserEMConfObj> readCachedSecUserEMConfByConfEMAddrIdx( String ConfirmEMailAddr )
	{
		final String S_ProcName = "readCachedSecUserEMConfByConfEMAddrIdx";
		ISecureSecUserEMConfByConfEMAddrIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByConfEMAddrIdxKey();
		key.setRequiredConfirmEMailAddr( ConfirmEMailAddr );
		ArrayList<ISecureSecUserEMConfObj> arrayList = new ArrayList<ISecureSecUserEMConfObj>();
		if( indexByConfEMAddrIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj> dict;
			if( indexByConfEMAddrIdx.containsKey( key ) ) {
				dict = indexByConfEMAddrIdx.get( key );
				int len = dict.size();
				ISecureSecUserEMConfObj arr[] = new ISecureSecUserEMConfObj[len];
				Iterator<ISecureSecUserEMConfObj> valIter = dict.values().iterator();
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
			ISecureSecUserEMConfObj obj;
			Iterator<ISecureSecUserEMConfObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecUserEMConfObj> cmp = new Comparator<ISecureSecUserEMConfObj>() {
			@Override
			public int compare( ISecureSecUserEMConfObj lhs, ISecureSecUserEMConfObj rhs ) {
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
	public List<ISecureSecUserEMConfObj> readCachedSecUserEMConfBySentStampIdx( LocalDateTime EMailSentStamp )
	{
		final String S_ProcName = "readCachedSecUserEMConfBySentStampIdx";
		ISecureSecUserEMConfBySentStampIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newBySentStampIdxKey();
		key.setRequiredEMailSentStamp( EMailSentStamp );
		ArrayList<ISecureSecUserEMConfObj> arrayList = new ArrayList<ISecureSecUserEMConfObj>();
		if( indexBySentStampIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj> dict;
			if( indexBySentStampIdx.containsKey( key ) ) {
				dict = indexBySentStampIdx.get( key );
				int len = dict.size();
				ISecureSecUserEMConfObj arr[] = new ISecureSecUserEMConfObj[len];
				Iterator<ISecureSecUserEMConfObj> valIter = dict.values().iterator();
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
			ISecureSecUserEMConfObj obj;
			Iterator<ISecureSecUserEMConfObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecUserEMConfObj> cmp = new Comparator<ISecureSecUserEMConfObj>() {
			@Override
			public int compare( ISecureSecUserEMConfObj lhs, ISecureSecUserEMConfObj rhs ) {
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
	public List<ISecureSecUserEMConfObj> readCachedSecUserEMConfByNewAcctIdx( boolean NewAccount )
	{
		final String S_ProcName = "readCachedSecUserEMConfByNewAcctIdx";
		ISecureSecUserEMConfByNewAcctIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByNewAcctIdxKey();
		key.setRequiredNewAccount( NewAccount );
		ArrayList<ISecureSecUserEMConfObj> arrayList = new ArrayList<ISecureSecUserEMConfObj>();
		if( indexByNewAcctIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj> dict;
			if( indexByNewAcctIdx.containsKey( key ) ) {
				dict = indexByNewAcctIdx.get( key );
				int len = dict.size();
				ISecureSecUserEMConfObj arr[] = new ISecureSecUserEMConfObj[len];
				Iterator<ISecureSecUserEMConfObj> valIter = dict.values().iterator();
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
			ISecureSecUserEMConfObj obj;
			Iterator<ISecureSecUserEMConfObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<ISecureSecUserEMConfObj> cmp = new Comparator<ISecureSecUserEMConfObj>() {
			@Override
			public int compare( ISecureSecUserEMConfObj lhs, ISecureSecUserEMConfObj rhs ) {
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
	public void deepDisposeSecUserEMConfByIdIdx( IYCFKeyHash256 SecUserId )
	{
		ISecureSecUserEMConfObj obj = readCachedSecUserEMConfByIdIdx( SecUserId );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecUserEMConfByUUuid6Idx( IYCFUuid6 EMConfirmationUuid6 )
	{
		ISecureSecUserEMConfObj obj = readCachedSecUserEMConfByUUuid6Idx( EMConfirmationUuid6 );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSecUserEMConfByConfEMAddrIdx( String ConfirmEMailAddr )
	{
		final String S_ProcName = "deepDisposeSecUserEMConfByConfEMAddrIdx";
		ISecureSecUserEMConfObj obj;
		List<ISecureSecUserEMConfObj> arrayList = readCachedSecUserEMConfByConfEMAddrIdx( ConfirmEMailAddr );
		if( arrayList != null )  {
			Iterator<ISecureSecUserEMConfObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecUserEMConfBySentStampIdx( LocalDateTime EMailSentStamp )
	{
		final String S_ProcName = "deepDisposeSecUserEMConfBySentStampIdx";
		ISecureSecUserEMConfObj obj;
		List<ISecureSecUserEMConfObj> arrayList = readCachedSecUserEMConfBySentStampIdx( EMailSentStamp );
		if( arrayList != null )  {
			Iterator<ISecureSecUserEMConfObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSecUserEMConfByNewAcctIdx( boolean NewAccount )
	{
		final String S_ProcName = "deepDisposeSecUserEMConfByNewAcctIdx";
		ISecureSecUserEMConfObj obj;
		List<ISecureSecUserEMConfObj> arrayList = readCachedSecUserEMConfByNewAcctIdx( NewAccount );
		if( arrayList != null )  {
			Iterator<ISecureSecUserEMConfObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	/**
	 *	Read a page of data as a List of SecUserEMConf-derived instances sorted by their primary keys,
	 *	as identified by the duplicate ConfEMAddrIdx key attributes.
	 *
	 *	@param	ConfirmEMailAddr	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecUserEMConf-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecUserEMConfObj> pageSecUserEMConfByConfEMAddrIdx( String ConfirmEMailAddr,
		IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageSecUserEMConfByConfEMAddrIdx";
		ISecureSecUserEMConfByConfEMAddrIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByConfEMAddrIdxKey();
		key.setRequiredConfirmEMailAddr( ConfirmEMailAddr );
		List<ISecureSecUserEMConfObj> retList = new LinkedList<ISecureSecUserEMConfObj>();
		ISecureSecUserEMConfObj obj;
		ISecureSecUserEMConf[] recList = schema.getSecureBackingStore().getTableSecUserEMConf().pageRecByConfEMAddrIdx( null,
				ConfirmEMailAddr,
			priorSecUserId );
		ISecureSecUserEMConf rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecUserEMConfTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecUserEMConfObj realised = (ISecureSecUserEMConfObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecUserEMConf-derived instances sorted by their primary keys,
	 *	as identified by the duplicate SentStampIdx key attributes.
	 *
	 *	@param	EMailSentStamp	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecUserEMConf-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecUserEMConfObj> pageSecUserEMConfBySentStampIdx( LocalDateTime EMailSentStamp,
		IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageSecUserEMConfBySentStampIdx";
		ISecureSecUserEMConfBySentStampIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newBySentStampIdxKey();
		key.setRequiredEMailSentStamp( EMailSentStamp );
		List<ISecureSecUserEMConfObj> retList = new LinkedList<ISecureSecUserEMConfObj>();
		ISecureSecUserEMConfObj obj;
		ISecureSecUserEMConf[] recList = schema.getSecureBackingStore().getTableSecUserEMConf().pageRecBySentStampIdx( null,
				EMailSentStamp,
			priorSecUserId );
		ISecureSecUserEMConf rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecUserEMConfTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecUserEMConfObj realised = (ISecureSecUserEMConfObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	/**
	 *	Read a page of data as a List of SecUserEMConf-derived instances sorted by their primary keys,
	 *	as identified by the duplicate NewAcctIdx key attributes.
	 *
	 *	@param	NewAccount	The SecUserEMConf key attribute of the instance generating the id.
	 *
	 *	@return	A List of SecUserEMConf-derived instances sorted by their primary keys,
	 *		as identified by the key attributes, which may be an empty set.
	 */
	@Override
	public List<ISecureSecUserEMConfObj> pageSecUserEMConfByNewAcctIdx( boolean NewAccount,
		IYCFKeyHash256 priorSecUserId )
	{
		final String S_ProcName = "pageSecUserEMConfByNewAcctIdx";
		ISecureSecUserEMConfByNewAcctIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByNewAcctIdxKey();
		key.setRequiredNewAccount( NewAccount );
		List<ISecureSecUserEMConfObj> retList = new LinkedList<ISecureSecUserEMConfObj>();
		ISecureSecUserEMConfObj obj;
		ISecureSecUserEMConf[] recList = schema.getSecureBackingStore().getTableSecUserEMConf().pageRecByNewAcctIdx( null,
				NewAccount,
			priorSecUserId );
		ISecureSecUserEMConf rec;
		for( int idx = 0; idx < recList.length; idx ++ ) {
			rec = recList[ idx ];
				obj = schema.getSecUserEMConfTableObj().newInstance();
			obj.setPKey( rec.getPKey() );
			obj.setRec( rec );
			ISecureSecUserEMConfObj realised = (ISecureSecUserEMConfObj)obj.realise();
			retList.add( realised );
		}
		return( retList );
	}

	@Override
	public ISecureSecUserEMConfObj updateSecUserEMConf( ISecureSecUserEMConfObj Obj ) {
		ISecureSecUserEMConfObj obj = Obj;
		schema.getSecureBackingStore().getTableSecUserEMConf().updateSecUserEMConf( null,
			Obj.getSecUserEMConfRec() );
		obj = (ISecureSecUserEMConfObj)Obj.realise();
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSecUserEMConf( ISecureSecUserEMConfObj Obj ) {
		ISecureSecUserEMConfObj obj = Obj;
		schema.getSecureBackingStore().getTableSecUserEMConf().deleteSecUserEMConf( null,
			obj.getSecUserEMConfRec() );
		Obj.forget();
	}

	@Override
	public void deleteSecUserEMConfByIdIdx( IYCFKeyHash256 SecUserId )
	{
		ISecureSecUserEMConfObj obj = readSecUserEMConf(SecUserId);
		if( obj != null ) {
			ISecureSecUserEMConfEditObj editObj = (ISecureSecUserEMConfEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (ISecureSecUserEMConfEditObj)obj.beginEdit();
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
		deepDisposeSecUserEMConfByIdIdx( SecUserId );
	}

	@Override
	public void deleteSecUserEMConfByUUuid6Idx( IYCFUuid6 EMConfirmationUuid6 )
	{
		if( indexByUUuid6Idx == null ) {
			indexByUUuid6Idx = new HashMap< ISecureSecUserEMConfByUUuid6IdxKey,
				ISecureSecUserEMConfObj >();
		}
		ISecureSecUserEMConfByUUuid6IdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByUUuid6IdxKey();
		key.setRequiredEMConfirmationUuid6( EMConfirmationUuid6 );
		ISecureSecUserEMConfObj obj = null;
		if( indexByUUuid6Idx.containsKey( key ) ) {
			obj = indexByUUuid6Idx.get( key );
			schema.getSecureBackingStore().getTableSecUserEMConf().deleteSecUserEMConfByUUuid6Idx( null,
				EMConfirmationUuid6 );
			obj.forget();
		}
		else {
			schema.getSecureBackingStore().getTableSecUserEMConf().deleteSecUserEMConfByUUuid6Idx( null,
				EMConfirmationUuid6 );
		}
		deepDisposeSecUserEMConfByUUuid6Idx( EMConfirmationUuid6 );
	}

	@Override
	public void deleteSecUserEMConfByConfEMAddrIdx( String ConfirmEMailAddr )
	{
		ISecureSecUserEMConfByConfEMAddrIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByConfEMAddrIdxKey();
		key.setRequiredConfirmEMailAddr( ConfirmEMailAddr );
		if( indexByConfEMAddrIdx == null ) {
			indexByConfEMAddrIdx = new HashMap< ISecureSecUserEMConfByConfEMAddrIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > >();
		}
		if( indexByConfEMAddrIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj> dict = indexByConfEMAddrIdx.get( key );
			schema.getSecureBackingStore().getTableSecUserEMConf().deleteSecUserEMConfByConfEMAddrIdx( null,
				ConfirmEMailAddr );
			Iterator<ISecureSecUserEMConfObj> iter = dict.values().iterator();
			ISecureSecUserEMConfObj obj;
			List<ISecureSecUserEMConfObj> toForget = new LinkedList<ISecureSecUserEMConfObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByConfEMAddrIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecUserEMConf().deleteSecUserEMConfByConfEMAddrIdx( null,
				ConfirmEMailAddr );
		}
		deepDisposeSecUserEMConfByConfEMAddrIdx( ConfirmEMailAddr );
	}

	@Override
	public void deleteSecUserEMConfBySentStampIdx( LocalDateTime EMailSentStamp )
	{
		ISecureSecUserEMConfBySentStampIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newBySentStampIdxKey();
		key.setRequiredEMailSentStamp( EMailSentStamp );
		if( indexBySentStampIdx == null ) {
			indexBySentStampIdx = new HashMap< ISecureSecUserEMConfBySentStampIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > >();
		}
		if( indexBySentStampIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj> dict = indexBySentStampIdx.get( key );
			schema.getSecureBackingStore().getTableSecUserEMConf().deleteSecUserEMConfBySentStampIdx( null,
				EMailSentStamp );
			Iterator<ISecureSecUserEMConfObj> iter = dict.values().iterator();
			ISecureSecUserEMConfObj obj;
			List<ISecureSecUserEMConfObj> toForget = new LinkedList<ISecureSecUserEMConfObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexBySentStampIdx.remove( key );
		}
		else {
			schema.getSecureBackingStore().getTableSecUserEMConf().deleteSecUserEMConfBySentStampIdx( null,
				EMailSentStamp );
		}
		deepDisposeSecUserEMConfBySentStampIdx( EMailSentStamp );
	}

	@Override
	public void deleteSecUserEMConfByNewAcctIdx( boolean NewAccount )
	{
		ISecureSecUserEMConfByNewAcctIdxKey key = schema.getSecureBackingStore().getSecureFactory().getFactorySecUserEMConf().newByNewAcctIdxKey();
		key.setRequiredNewAccount( NewAccount );
		if( indexByNewAcctIdx == null ) {
			indexByNewAcctIdx = new HashMap< ISecureSecUserEMConfByNewAcctIdxKey,
				Map< $implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj > >();
		}
		if( indexByNewAcctIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, ISecureSecUserEMConfObj> dict = indexByNewAcctIdx.get( key );
			schema.getSecureBackingStore().getTableSecUserEMConf().deleteSecUserEMConfByNewAcctIdx( null,
				NewAccount );
			Iterator<ISecureSecUserEMConfObj> iter = dict.values().iterator();
			ISecureSecUserEMConfObj obj;
			List<ISecureSecUserEMConfObj> toForget = new LinkedList<ISecureSecUserEMConfObj>();
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
			schema.getSecureBackingStore().getTableSecUserEMConf().deleteSecUserEMConfByNewAcctIdx( null,
				NewAccount );
		}
		deepDisposeSecUserEMConfByNewAcctIdx( NewAccount );
	}
}