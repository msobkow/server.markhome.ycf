// Description: Java 25 Table Object implementation for SchemaDef.

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
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

public class BusModelSchemaDefTableObj
	implements IBusModelSchemaDefTableObj
{
	protected IBusModelSchemaObj schema;
	protected static int runtimeClassCode = IBusModelSchemaDef.CLASS_CODE;
	protected static final int backingClassCode = IBusModelSchemaDef.CLASS_CODE;
	private Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> members;
	private Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> allSchemaDef;
	private Map< IBusModelScopeByTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > > indexByTenantIdx;
	private Map< IBusModelSchemaDefByCTenantIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > > indexByCTenantIdx;
	private Map< IBusModelSchemaDefByMinorVersionIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > > indexByMinorVersionIdx;
	private Map< IBusModelSchemaDefByUNameIdxKey,
		IBusModelSchemaDefObj > indexByUNameIdx;
	private Map< IBusModelSchemaDefByAuthEMailIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > > indexByAuthEMailIdx;
	private Map< IBusModelSchemaDefByProjectURLIdxKey,
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > > indexByProjectURLIdx;
	private Map< IBusModelSchemaDefByPubURIIdxKey,
		IBusModelSchemaDefObj > indexByPubURIIdx;
	public static String TABLE_NAME = "SchemaDef";
	public static String TABLE_DBNAME = "schemadef";

	public BusModelSchemaDefTableObj() {
		schema = null;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj>();
		allSchemaDef = null;
		indexByTenantIdx = null;
		indexByCTenantIdx = null;
		indexByMinorVersionIdx = null;
		indexByUNameIdx = null;
		indexByAuthEMailIdx = null;
		indexByProjectURLIdx = null;
		indexByPubURIIdx = null;
	}

	public BusModelSchemaDefTableObj( IBusModelSchemaObj argSchema ) {
		schema = (IBusModelSchemaObj)argSchema;
		members = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj>();
		allSchemaDef = null;
		indexByTenantIdx = null;
		indexByCTenantIdx = null;
		indexByMinorVersionIdx = null;
		indexByUNameIdx = null;
		indexByAuthEMailIdx = null;
		indexByProjectURLIdx = null;
		indexByPubURIIdx = null;
	}
	
	/**
	 *	Get class code always returns the runtime class code for the objects, which is not stable until the application is done initializing and registering its objects.
	 *
	 *	@return runtime classcode
	 */ 
	@Override
	public int getClassCode() {
		return BusModelSchemaDefTableObj.getRuntimeClassCode();
	}	

	/**
	 *	Get the backing store schema's class code, which is hard-coded into the object hierarchy.
	 *
	 *	@return The hardcoded backing store class code for this object, which is only valid in that schema.
	 */
	public static int getBackingClassCode() {
		return( backingClassCode );
	}

	/**
	 *	Get the runtime class code for this table; this value is only stable after the application is fully initialized.
	 *
	 *	@return runtimeClassCode
	 */
	public static int getRuntimeClassCode() {
		return( runtimeClassCode );
	}

	/**
	 *	Set the runtime class code for this table; this is done only during application initialization by the SchemaObj's <tt>initClassCodes()</tt> static method,
	 *	which will only set the class codes once and never again.  Once set, the class codes are immutable within the application.
	 *	Application programmers should never invoke this method, so it has package access only.
	 *
	 *	@param	argNewClassCode	The runtime class code to be used by clients and integrated application logic to identify this table of this schema.
	 */
	static void setRuntimeClassCode(int argNewClassCode ) {
		if (argNewClassCode <= 0) {
			throw new YCFArgumentUnderflowException(BusModelSchemaDefTableObj.class, "setRuntimeClassCode", 1, "argNewClassCode", argNewClassCode, 1);
		}
		runtimeClassCode = argNewClassCode;
	}

	@Override
	public IBusModelSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( IBusModelSchemaObj value ) {
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
		return( IBusModelSubProjectObj.class );
	}


	@Override
	public void minimizeMemory() {
		allSchemaDef = null;
		indexByTenantIdx = null;
		indexByCTenantIdx = null;
		indexByMinorVersionIdx = null;
		indexByUNameIdx = null;
		indexByAuthEMailIdx = null;
		indexByProjectURLIdx = null;
		indexByPubURIIdx = null;
		List<IBusModelSchemaDefObj> toForget = new LinkedList<IBusModelSchemaDefObj>();
		IBusModelSchemaDefObj cur = null;
		Iterator<IBusModelSchemaDefObj> iter = members.values().iterator();
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
	 *	BusModelSchemaDefObj.
	 */
	@Override
	public IBusModelSchemaDefObj newInstance() {
		IBusModelSchemaDefObj inst = new BusModelSchemaDefObj( schema );
		return( inst );
	}

	/**
	 *	If your implementation subclasses the objects,
	 *	you'll want to overload the constructByClassCode()
	 *	implementation to return your implementation's
	 *	instances instead of the base implementation.
	 *
	 *	This is the sole factory for instances derived from
	 *	BusModelSchemaDefObj.
	 */
	@Override
	public IBusModelSchemaDefEditObj newEditInstance( IBusModelSchemaDefObj orig ) {
		IBusModelSchemaDefEditObj edit = new BusModelSchemaDefEditObj( orig );
		return( edit );
	}

	@Override
	public IBusModelSchemaDefObj realiseSchemaDef( IBusModelSchemaDefObj Obj ) {
		IBusModelSchemaDefObj obj = Obj;
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelSchemaDefObj keepObj = null;
		if( members.containsKey( pkey ) && ( null != members.get( pkey ) ) ) {
			IBusModelSchemaDefObj existingObj = members.get( pkey );
			keepObj = existingObj;

			/*
			 *	We always rebind the data because if we're being called, some index has
			 *	been updated and is refreshing it's data, which may or may not have changed
			 */

			// Detach object from alternate and duplicate indexes, leave PKey alone

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					indexByTenantIdx.remove( keyTenantIdx );
				}
			}

			if( indexByCTenantIdx != null ) {
				IBusModelSchemaDefByCTenantIdxKey keyCTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByCTenantIdxKey();
				keyCTenantIdx.setRequiredCTenantId( keepObj.getRequiredCTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > mapCTenantIdx = indexByCTenantIdx.get( keyCTenantIdx );
				if( mapCTenantIdx != null ) {
					mapCTenantIdx.remove( keepObj.getPKey() );
					if( mapCTenantIdx.size() <= 0 ) {
						indexByCTenantIdx.remove( keyCTenantIdx );
					}
				}
			}

			if( indexByMinorVersionIdx != null ) {
				IBusModelSchemaDefByMinorVersionIdxKey keyMinorVersionIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByMinorVersionIdxKey();
				keyMinorVersionIdx.setRequiredMinorVersionId( keepObj.getRequiredMinorVersionId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > mapMinorVersionIdx = indexByMinorVersionIdx.get( keyMinorVersionIdx );
				if( mapMinorVersionIdx != null ) {
					mapMinorVersionIdx.remove( keepObj.getPKey() );
					if( mapMinorVersionIdx.size() <= 0 ) {
						indexByMinorVersionIdx.remove( keyMinorVersionIdx );
					}
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelSchemaDefByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByUNameIdxKey();
				keyUNameIdx.setRequiredMinorVersionId( keepObj.getRequiredMinorVersionId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.remove( keyUNameIdx );
			}

			if( indexByAuthEMailIdx != null ) {
				IBusModelSchemaDefByAuthEMailIdxKey keyAuthEMailIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByAuthEMailIdxKey();
				keyAuthEMailIdx.setRequiredCTenantId( keepObj.getRequiredCTenantId() );
				keyAuthEMailIdx.setRequiredAuthorEMail( keepObj.getRequiredAuthorEMail() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > mapAuthEMailIdx = indexByAuthEMailIdx.get( keyAuthEMailIdx );
				if( mapAuthEMailIdx != null ) {
					mapAuthEMailIdx.remove( keepObj.getPKey() );
					if( mapAuthEMailIdx.size() <= 0 ) {
						indexByAuthEMailIdx.remove( keyAuthEMailIdx );
					}
				}
			}

			if( indexByProjectURLIdx != null ) {
				IBusModelSchemaDefByProjectURLIdxKey keyProjectURLIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByProjectURLIdxKey();
				keyProjectURLIdx.setRequiredCTenantId( keepObj.getRequiredCTenantId() );
				keyProjectURLIdx.setRequiredProjectURL( keepObj.getRequiredProjectURL() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > mapProjectURLIdx = indexByProjectURLIdx.get( keyProjectURLIdx );
				if( mapProjectURLIdx != null ) {
					mapProjectURLIdx.remove( keepObj.getPKey() );
					if( mapProjectURLIdx.size() <= 0 ) {
						indexByProjectURLIdx.remove( keyProjectURLIdx );
					}
				}
			}

			if( indexByPubURIIdx != null ) {
				IBusModelSchemaDefByPubURIIdxKey keyPubURIIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByPubURIIdxKey();
				keyPubURIIdx.setRequiredCTenantId( keepObj.getRequiredCTenantId() );
				keyPubURIIdx.setRequiredPublishURI( keepObj.getRequiredPublishURI() );
				indexByPubURIIdx.remove( keyPubURIIdx );
			}
			// Keep passing the new object because it's the one with the record
			// that the base table needs to copy to the existing object from
			// the cache.
			keepObj = (IBusModelSchemaDefObj)schema.getScopeTableObj().realiseScope( Obj );

			// Attach new object to alternate and duplicate indexes -- PKey stay stable

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCTenantIdx != null ) {
				IBusModelSchemaDefByCTenantIdxKey keyCTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByCTenantIdxKey();
				keyCTenantIdx.setRequiredCTenantId( keepObj.getRequiredCTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > mapCTenantIdx = indexByCTenantIdx.get( keyCTenantIdx );
				if( mapCTenantIdx != null ) {
					mapCTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMinorVersionIdx != null ) {
				IBusModelSchemaDefByMinorVersionIdxKey keyMinorVersionIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByMinorVersionIdxKey();
				keyMinorVersionIdx.setRequiredMinorVersionId( keepObj.getRequiredMinorVersionId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > mapMinorVersionIdx = indexByMinorVersionIdx.get( keyMinorVersionIdx );
				if( mapMinorVersionIdx != null ) {
					mapMinorVersionIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelSchemaDefByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByUNameIdxKey();
				keyUNameIdx.setRequiredMinorVersionId( keepObj.getRequiredMinorVersionId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByAuthEMailIdx != null ) {
				IBusModelSchemaDefByAuthEMailIdxKey keyAuthEMailIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByAuthEMailIdxKey();
				keyAuthEMailIdx.setRequiredCTenantId( keepObj.getRequiredCTenantId() );
				keyAuthEMailIdx.setRequiredAuthorEMail( keepObj.getRequiredAuthorEMail() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > mapAuthEMailIdx = indexByAuthEMailIdx.get( keyAuthEMailIdx );
				if( mapAuthEMailIdx != null ) {
					mapAuthEMailIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByProjectURLIdx != null ) {
				IBusModelSchemaDefByProjectURLIdxKey keyProjectURLIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByProjectURLIdxKey();
				keyProjectURLIdx.setRequiredCTenantId( keepObj.getRequiredCTenantId() );
				keyProjectURLIdx.setRequiredProjectURL( keepObj.getRequiredProjectURL() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > mapProjectURLIdx = indexByProjectURLIdx.get( keyProjectURLIdx );
				if( mapProjectURLIdx != null ) {
					mapProjectURLIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPubURIIdx != null ) {
				IBusModelSchemaDefByPubURIIdxKey keyPubURIIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByPubURIIdxKey();
				keyPubURIIdx.setRequiredCTenantId( keepObj.getRequiredCTenantId() );
				keyPubURIIdx.setRequiredPublishURI( keepObj.getRequiredPublishURI() );
				indexByPubURIIdx.put( keyPubURIIdx, keepObj );
			}

			if( allSchemaDef != null ) {
				allSchemaDef.put( keepObj.getPKey(), keepObj );
			}
		}
		else {
			keepObj = obj;
			keepObj = (IBusModelSchemaDefObj)schema.getScopeTableObj().realiseScope( keepObj );

			// Attach new object to PKey, all, alternate, and duplicate indexes
			members.put( keepObj.getPKey(), keepObj );
			if( allSchemaDef != null ) {
				allSchemaDef.put( keepObj.getPKey(), keepObj );
			}

			if( indexByTenantIdx != null ) {
				IBusModelScopeByTenantIdxKey keyTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
				keyTenantIdx.setRequiredTenantId( keepObj.getRequiredTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > mapTenantIdx = indexByTenantIdx.get( keyTenantIdx );
				if( mapTenantIdx != null ) {
					mapTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByCTenantIdx != null ) {
				IBusModelSchemaDefByCTenantIdxKey keyCTenantIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByCTenantIdxKey();
				keyCTenantIdx.setRequiredCTenantId( keepObj.getRequiredCTenantId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > mapCTenantIdx = indexByCTenantIdx.get( keyCTenantIdx );
				if( mapCTenantIdx != null ) {
					mapCTenantIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByMinorVersionIdx != null ) {
				IBusModelSchemaDefByMinorVersionIdxKey keyMinorVersionIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByMinorVersionIdxKey();
				keyMinorVersionIdx.setRequiredMinorVersionId( keepObj.getRequiredMinorVersionId() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > mapMinorVersionIdx = indexByMinorVersionIdx.get( keyMinorVersionIdx );
				if( mapMinorVersionIdx != null ) {
					mapMinorVersionIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByUNameIdx != null ) {
				IBusModelSchemaDefByUNameIdxKey keyUNameIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByUNameIdxKey();
				keyUNameIdx.setRequiredMinorVersionId( keepObj.getRequiredMinorVersionId() );
				keyUNameIdx.setRequiredName( keepObj.getRequiredName() );
				indexByUNameIdx.put( keyUNameIdx, keepObj );
			}

			if( indexByAuthEMailIdx != null ) {
				IBusModelSchemaDefByAuthEMailIdxKey keyAuthEMailIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByAuthEMailIdxKey();
				keyAuthEMailIdx.setRequiredCTenantId( keepObj.getRequiredCTenantId() );
				keyAuthEMailIdx.setRequiredAuthorEMail( keepObj.getRequiredAuthorEMail() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > mapAuthEMailIdx = indexByAuthEMailIdx.get( keyAuthEMailIdx );
				if( mapAuthEMailIdx != null ) {
					mapAuthEMailIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByProjectURLIdx != null ) {
				IBusModelSchemaDefByProjectURLIdxKey keyProjectURLIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByProjectURLIdxKey();
				keyProjectURLIdx.setRequiredCTenantId( keepObj.getRequiredCTenantId() );
				keyProjectURLIdx.setRequiredProjectURL( keepObj.getRequiredProjectURL() );
				Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > mapProjectURLIdx = indexByProjectURLIdx.get( keyProjectURLIdx );
				if( mapProjectURLIdx != null ) {
					mapProjectURLIdx.put( keepObj.getPKey(), keepObj );
				}
			}

			if( indexByPubURIIdx != null ) {
				IBusModelSchemaDefByPubURIIdxKey keyPubURIIdx =
					schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByPubURIIdxKey();
				keyPubURIIdx.setRequiredCTenantId( keepObj.getRequiredCTenantId() );
				keyPubURIIdx.setRequiredPublishURI( keepObj.getRequiredPublishURI() );
				indexByPubURIIdx.put( keyPubURIIdx, keepObj );
			}

		}
		return( keepObj );
	}

	@Override
	public IBusModelSchemaDefObj createSchemaDef( IBusModelSchemaDefObj Obj ) {
		IBusModelSchemaDefObj obj = Obj;
		IBusModelSchemaDef rec = obj.getSchemaDefRec();
		schema.getBusModelBackingStore().getTableSchemaDef().createSchemaDef(
			null,
			rec );
		obj.copyRecToPKey();
		if( obj.getClassCode() == runtimeClassCode ) {
			obj = (IBusModelSchemaDefObj)(obj.realise());
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public IBusModelSchemaDefObj readSchemaDef( $implCommaIJavaOptAtomType$ pkey ) {
		return( readSchemaDef( pkey, false ) );
	}

	@Override
	public IBusModelSchemaDefObj readSchemaDef( $implCommaIJavaOptAtomType$ pkey, boolean forceRead ) {
		IBusModelSchemaDefObj obj = null;
		if( ( ! forceRead ) && members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		else {
			IBusModelSchemaDef readRec = schema.getBusModelBackingStore().getTableSchemaDef().readDerivedByIdIdx( null,
						pkey );
			if( readRec != null ) {
				obj = (IBusModelSchemaDefObj)schema.getScopeTableObj().constructByClassCode( readRec.getClassCode() );
				obj.setPKey( readRec.getPKey() );
				obj.setRec( readRec );
				obj = (IBusModelSchemaDefObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelSchemaDefObj readCachedSchemaDef( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelSchemaDefObj obj = null;
		if( members.containsKey( pkey ) ) {
			obj = members.get( pkey );
		}
		return( obj );
	}

	@Override
	public void reallyDeepDisposeSchemaDef( IBusModelSchemaDefObj obj )
	{
		final String S_ProcName = "BusModelSchemaDefTableObj.reallyDeepDisposeSchemaDef() ";
		String classCode;
		if( obj == null ) {
			return;
		}
		$implCommaIJavaOptAtomType$ pkey = obj.getPKey();
		IBusModelSchemaDefObj existing = readCachedSchemaDef( pkey );
		if( existing == null ) {
			return;
		}
		members.remove( pkey );
		IBusModelSchemaDefByCTenantIdxKey keyCTenantIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByCTenantIdxKey();
		keyCTenantIdx.setRequiredCTenantId( existing.getRequiredCTenantId() );

		IBusModelSchemaDefByMinorVersionIdxKey keyMinorVersionIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByMinorVersionIdxKey();
		keyMinorVersionIdx.setRequiredMinorVersionId( existing.getRequiredMinorVersionId() );

		IBusModelSchemaDefByUNameIdxKey keyUNameIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByUNameIdxKey();
		keyUNameIdx.setRequiredMinorVersionId( existing.getRequiredMinorVersionId() );
		keyUNameIdx.setRequiredName( existing.getRequiredName() );

		IBusModelSchemaDefByAuthEMailIdxKey keyAuthEMailIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByAuthEMailIdxKey();
		keyAuthEMailIdx.setRequiredCTenantId( existing.getRequiredCTenantId() );
		keyAuthEMailIdx.setRequiredAuthorEMail( existing.getRequiredAuthorEMail() );

		IBusModelSchemaDefByProjectURLIdxKey keyProjectURLIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByProjectURLIdxKey();
		keyProjectURLIdx.setRequiredCTenantId( existing.getRequiredCTenantId() );
		keyProjectURLIdx.setRequiredProjectURL( existing.getRequiredProjectURL() );

		IBusModelSchemaDefByPubURIIdxKey keyPubURIIdx = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByPubURIIdxKey();
		keyPubURIIdx.setRequiredCTenantId( existing.getRequiredCTenantId() );
		keyPubURIIdx.setRequiredPublishURI( existing.getRequiredPublishURI() );


		IBusModelTableObj objDelTableMethods;
		List<IBusModelTableObj> arrDelTableMethods = schema.getTableTableObj().readCachedTableBySchemaDefIdx( existing.getRequiredId() );
		Iterator<IBusModelTableObj> iterDelTableMethods = arrDelTableMethods.iterator();
		while( iterDelTableMethods.hasNext() ) {
			objDelTableMethods = iterDelTableMethods.next();
			if( objDelTableMethods != null ) {
						schema.getServerMethodTableObj().deepDisposeServerMethodByMethTableIdx( objDelTableMethods.getRequiredId() );
			}
		}
		IBusModelTableObj objDelTableDelDep;
		List<IBusModelTableObj> arrDelTableDelDep = schema.getTableTableObj().readCachedTableBySchemaDefIdx( existing.getRequiredId() );
		Iterator<IBusModelTableObj> iterDelTableDelDep = arrDelTableDelDep.iterator();
		while( iterDelTableDelDep.hasNext() ) {
			objDelTableDelDep = iterDelTableDelDep.next();
			if( objDelTableDelDep != null ) {
						schema.getDelTopDepTableObj().deepDisposeDelTopDepByDelTopDepTblIdx( objDelTableDelDep.getRequiredId() );
			}
		}
		IBusModelTableObj objDelTableClearDep;
		List<IBusModelTableObj> arrDelTableClearDep = schema.getTableTableObj().readCachedTableBySchemaDefIdx( existing.getRequiredId() );
		Iterator<IBusModelTableObj> iterDelTableClearDep = arrDelTableClearDep.iterator();
		while( iterDelTableClearDep.hasNext() ) {
			objDelTableClearDep = iterDelTableClearDep.next();
			if( objDelTableClearDep != null ) {
						schema.getClearTopDepTableObj().deepDisposeClearTopDepByClrTopDepTblIdx( objDelTableClearDep.getRequiredId() );
			}
		}
		IBusModelTableObj objDelTableChain;
		List<IBusModelTableObj> arrDelTableChain = schema.getTableTableObj().readCachedTableBySchemaDefIdx( existing.getRequiredId() );
		Iterator<IBusModelTableObj> iterDelTableChain = arrDelTableChain.iterator();
		while( iterDelTableChain.hasNext() ) {
			objDelTableChain = iterDelTableChain.next();
			if( objDelTableChain != null ) {
						schema.getChainTableObj().deepDisposeChainByChainTableIdx( objDelTableChain.getRequiredId() );
			}
		}
		IBusModelTableObj objDelTableRelationPopDep;
		List<IBusModelTableObj> arrDelTableRelationPopDep = schema.getTableTableObj().readCachedTableBySchemaDefIdx( existing.getRequiredId() );
		Iterator<IBusModelTableObj> iterDelTableRelationPopDep = arrDelTableRelationPopDep.iterator();
		while( iterDelTableRelationPopDep.hasNext() ) {
			objDelTableRelationPopDep = iterDelTableRelationPopDep.next();
			if( objDelTableRelationPopDep != null ) {
			IBusModelRelationObj objTableRelation;
			List<IBusModelRelationObj> arrTableRelation = schema.getRelationTableObj().readCachedRelationByRelTableIdx( objDelTableRelationPopDep.getRequiredId() );
			Iterator<IBusModelRelationObj> iterTableRelation = arrTableRelation.iterator();
			while( iterTableRelation.hasNext() ) {
				objTableRelation = iterTableRelation.next();
					schema.getPopTopDepTableObj().deepDisposePopTopDepByContRelIdx( objTableRelation.getRequiredId() );
			}
			}
		}
		IBusModelTableObj objDelTableRelationCol;
		List<IBusModelTableObj> arrDelTableRelationCol = schema.getTableTableObj().readCachedTableBySchemaDefIdx( existing.getRequiredId() );
		Iterator<IBusModelTableObj> iterDelTableRelationCol = arrDelTableRelationCol.iterator();
		while( iterDelTableRelationCol.hasNext() ) {
			objDelTableRelationCol = iterDelTableRelationCol.next();
			if( objDelTableRelationCol != null ) {
			IBusModelRelationObj objTableRelation;
			List<IBusModelRelationObj> arrTableRelation = schema.getRelationTableObj().readCachedRelationByRelTableIdx( objDelTableRelationCol.getRequiredId() );
			Iterator<IBusModelRelationObj> iterTableRelation = arrTableRelation.iterator();
			while( iterTableRelation.hasNext() ) {
				objTableRelation = iterTableRelation.next();
					schema.getRelationColTableObj().deepDisposeRelationColByRelationIdx( objTableRelation.getRequiredId() );
			}
			}
		}
		IBusModelTableObj objDelTableRelation;
		List<IBusModelTableObj> arrDelTableRelation = schema.getTableTableObj().readCachedTableBySchemaDefIdx( existing.getRequiredId() );
		Iterator<IBusModelTableObj> iterDelTableRelation = arrDelTableRelation.iterator();
		while( iterDelTableRelation.hasNext() ) {
			objDelTableRelation = iterDelTableRelation.next();
			if( objDelTableRelation != null ) {
						schema.getRelationTableObj().deepDisposeRelationByRelTableIdx( objDelTableRelation.getRequiredId() );
			}
		}
		IBusModelTableObj objDelTableIndexRefRelFmCol;
		List<IBusModelTableObj> arrDelTableIndexRefRelFmCol = schema.getTableTableObj().readCachedTableBySchemaDefIdx( existing.getRequiredId() );
		Iterator<IBusModelTableObj> iterDelTableIndexRefRelFmCol = arrDelTableIndexRefRelFmCol.iterator();
		while( iterDelTableIndexRefRelFmCol.hasNext() ) {
			objDelTableIndexRefRelFmCol = iterDelTableIndexRefRelFmCol.next();
			if( objDelTableIndexRefRelFmCol != null ) {
			IBusModelIndexObj objTableIndex;
			List<IBusModelIndexObj> arrTableIndex = schema.getIndexTableObj().readCachedIndexByIdxTableIdx( objDelTableIndexRefRelFmCol.getRequiredId() );
			Iterator<IBusModelIndexObj> iterTableIndex = arrTableIndex.iterator();
			while( iterTableIndex.hasNext() ) {
				objTableIndex = iterTableIndex.next();
			IBusModelIndexColObj objColumns;
			List<IBusModelIndexColObj> arrColumns = schema.getIndexColTableObj().readCachedIndexColByIndexIdx( objTableIndex.getRequiredId() );
			Iterator<IBusModelIndexColObj> iterColumns = arrColumns.iterator();
			while( iterColumns.hasNext() ) {
				objColumns = iterColumns.next();
					schema.getRelationColTableObj().deepDisposeRelationColByFromColIdx( objColumns.getRequiredId() );
			}
			}
			}
		}
		IBusModelTableObj objDelTableIndexRefRelToCol;
		List<IBusModelTableObj> arrDelTableIndexRefRelToCol = schema.getTableTableObj().readCachedTableBySchemaDefIdx( existing.getRequiredId() );
		Iterator<IBusModelTableObj> iterDelTableIndexRefRelToCol = arrDelTableIndexRefRelToCol.iterator();
		while( iterDelTableIndexRefRelToCol.hasNext() ) {
			objDelTableIndexRefRelToCol = iterDelTableIndexRefRelToCol.next();
			if( objDelTableIndexRefRelToCol != null ) {
			IBusModelIndexObj objTableIndex;
			List<IBusModelIndexObj> arrTableIndex = schema.getIndexTableObj().readCachedIndexByIdxTableIdx( objDelTableIndexRefRelToCol.getRequiredId() );
			Iterator<IBusModelIndexObj> iterTableIndex = arrTableIndex.iterator();
			while( iterTableIndex.hasNext() ) {
				objTableIndex = iterTableIndex.next();
			IBusModelIndexColObj objColumns;
			List<IBusModelIndexColObj> arrColumns = schema.getIndexColTableObj().readCachedIndexColByIndexIdx( objTableIndex.getRequiredId() );
			Iterator<IBusModelIndexColObj> iterColumns = arrColumns.iterator();
			while( iterColumns.hasNext() ) {
				objColumns = iterColumns.next();
					schema.getRelationColTableObj().deepDisposeRelationColByToColIdx( objColumns.getRequiredId() );
			}
			}
			}
		}
		IBusModelTableObj objDelTableIndexCols;
		List<IBusModelTableObj> arrDelTableIndexCols = schema.getTableTableObj().readCachedTableBySchemaDefIdx( existing.getRequiredId() );
		Iterator<IBusModelTableObj> iterDelTableIndexCols = arrDelTableIndexCols.iterator();
		while( iterDelTableIndexCols.hasNext() ) {
			objDelTableIndexCols = iterDelTableIndexCols.next();
			if( objDelTableIndexCols != null ) {
			IBusModelIndexObj objTableIndex;
			List<IBusModelIndexObj> arrTableIndex = schema.getIndexTableObj().readCachedIndexByIdxTableIdx( objDelTableIndexCols.getRequiredId() );
			Iterator<IBusModelIndexObj> iterTableIndex = arrTableIndex.iterator();
			while( iterTableIndex.hasNext() ) {
				objTableIndex = iterTableIndex.next();
					schema.getIndexColTableObj().deepDisposeIndexColByIndexIdx( objTableIndex.getRequiredId() );
			}
			}
		}
		IBusModelTableObj objDelTableIndexes;
		List<IBusModelTableObj> arrDelTableIndexes = schema.getTableTableObj().readCachedTableBySchemaDefIdx( existing.getRequiredId() );
		Iterator<IBusModelTableObj> iterDelTableIndexes = arrDelTableIndexes.iterator();
		while( iterDelTableIndexes.hasNext() ) {
			objDelTableIndexes = iterDelTableIndexes.next();
			if( objDelTableIndexes != null ) {
						schema.getIndexTableObj().deepDisposeIndexByIdxTableIdx( objDelTableIndexes.getRequiredId() );
			}
		}
		IBusModelTableObj objDelTableRefIndexColumns;
		List<IBusModelTableObj> arrDelTableRefIndexColumns = schema.getTableTableObj().readCachedTableBySchemaDefIdx( existing.getRequiredId() );
		Iterator<IBusModelTableObj> iterDelTableRefIndexColumns = arrDelTableRefIndexColumns.iterator();
		while( iterDelTableRefIndexColumns.hasNext() ) {
			objDelTableRefIndexColumns = iterDelTableRefIndexColumns.next();
			if( objDelTableRefIndexColumns != null ) {
			IBusModelValueObj objColumns;
			List<IBusModelValueObj> arrColumns = schema.getValueTableObj().readCachedValueByScopeIdx( objDelTableRefIndexColumns.getRequiredId() );
			Iterator<IBusModelValueObj> iterColumns = arrColumns.iterator();
			while( iterColumns.hasNext() ) {
				objColumns = iterColumns.next();
					schema.getIndexColTableObj().deepDisposeIndexColByColIdx( objColumns.getRequiredId() );
			}
			}
		}
		IBusModelTableObj objDelTableColumns;
		List<IBusModelTableObj> arrDelTableColumns = schema.getTableTableObj().readCachedTableBySchemaDefIdx( existing.getRequiredId() );
		Iterator<IBusModelTableObj> iterDelTableColumns = arrDelTableColumns.iterator();
		while( iterDelTableColumns.hasNext() ) {
			objDelTableColumns = iterDelTableColumns.next();
			if( objDelTableColumns != null ) {
						schema.getValueTableObj().deepDisposeValueByScopeIdx( objDelTableColumns.getRequiredId() );
			}
		}
					schema.getTableTableObj().deepDisposeTableBySchemaDefIdx( existing.getRequiredId() );
		IBusModelValueObj objDelTypeRefs;
		List<IBusModelValueObj> arrDelTypeRefs = schema.getValueTableObj().readCachedValueByScopeIdx( existing.getRequiredId() );
		Iterator<IBusModelValueObj> iterDelTypeRefs = arrDelTypeRefs.iterator();
		while( iterDelTypeRefs.hasNext() ) {
			objDelTypeRefs = iterDelTypeRefs.next();
			if( objDelTypeRefs != null ) {
						schema.getTableColTableObj().deepDisposeTableColByDataIdx( objDelTypeRefs.getRequiredId() );
			}
		}
					schema.getValueTableObj().deepDisposeValueByScopeIdx( existing.getRequiredId() );

		if( indexByCTenantIdx != null ) {
			if( indexByCTenantIdx.containsKey( keyCTenantIdx ) ) {
				indexByCTenantIdx.get( keyCTenantIdx ).remove( pkey );
				if( indexByCTenantIdx.get( keyCTenantIdx ).size() <= 0 ) {
					indexByCTenantIdx.remove( keyCTenantIdx );
				}
			}
		}

		if( indexByMinorVersionIdx != null ) {
			if( indexByMinorVersionIdx.containsKey( keyMinorVersionIdx ) ) {
				indexByMinorVersionIdx.get( keyMinorVersionIdx ).remove( pkey );
				if( indexByMinorVersionIdx.get( keyMinorVersionIdx ).size() <= 0 ) {
					indexByMinorVersionIdx.remove( keyMinorVersionIdx );
				}
			}
		}

		if( indexByUNameIdx != null ) {
			indexByUNameIdx.remove( keyUNameIdx );
		}

		if( indexByAuthEMailIdx != null ) {
			if( indexByAuthEMailIdx.containsKey( keyAuthEMailIdx ) ) {
				indexByAuthEMailIdx.get( keyAuthEMailIdx ).remove( pkey );
				if( indexByAuthEMailIdx.get( keyAuthEMailIdx ).size() <= 0 ) {
					indexByAuthEMailIdx.remove( keyAuthEMailIdx );
				}
			}
		}

		if( indexByProjectURLIdx != null ) {
			if( indexByProjectURLIdx.containsKey( keyProjectURLIdx ) ) {
				indexByProjectURLIdx.get( keyProjectURLIdx ).remove( pkey );
				if( indexByProjectURLIdx.get( keyProjectURLIdx ).size() <= 0 ) {
					indexByProjectURLIdx.remove( keyProjectURLIdx );
				}
			}
		}

		if( indexByPubURIIdx != null ) {
			indexByPubURIIdx.remove( keyPubURIIdx );
		}


		schema.getScopeTableObj().reallyDeepDisposeScope( obj );
	}
	@Override
	public void deepDisposeSchemaDef( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelSchemaDefObj obj = readCachedSchemaDef( pkey );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelSchemaDefObj lockSchemaDef( $implCommaIJavaOptAtomType$ pkey ) {
		IBusModelSchemaDefObj locked = null;
		IBusModelSchemaDef lockRec = schema.getBusModelBackingStore().getTableSchemaDef().lockDerived( null, pkey );
		if( lockRec != null ) {
				locked = (IBusModelSchemaDefObj)schema.getScopeTableObj().constructByClassCode( lockRec.getClassCode() );
			locked.setRec( lockRec );
			locked.setPKey( lockRec.getPKey() );
			locked = (IBusModelSchemaDefObj)locked.realise();
		}
		else {
			throw new YCFCollisionDetectedException( getClass(), "lockSchemaDef", pkey );
		}
		return( locked );
	}

	@Override
	public List<IBusModelSchemaDefObj> readAllSchemaDef() {
		return( readAllSchemaDef( false ) );
	}

	@Override
	public List<IBusModelSchemaDefObj> readAllSchemaDef( boolean forceRead ) {
		final String S_ProcName = "readAllSchemaDef";
		if( ( allSchemaDef == null ) || forceRead ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> map = new HashMap<$implCommaIJavaOptAtomType$,IBusModelSchemaDefObj>();
			allSchemaDef = map;
			IBusModelSchemaDef[] recList = schema.getBusModelBackingStore().getTableSchemaDef().readAllDerived( null );
			IBusModelSchemaDef rec;
			IBusModelSchemaDefObj obj;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaDefObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaDefObj realised = (IBusModelSchemaDefObj)obj.realise();
			}
		}
		int len = allSchemaDef.size();
		IBusModelSchemaDefObj arr[] = new IBusModelSchemaDefObj[len];
		Iterator<IBusModelSchemaDefObj> valIter = allSchemaDef.values().iterator();
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
		ArrayList<IBusModelSchemaDefObj> arrayList = new ArrayList<IBusModelSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaDefObj> cmp = new Comparator<IBusModelSchemaDefObj>() {
			@Override
			public int compare( IBusModelSchemaDefObj lhs, IBusModelSchemaDefObj rhs ) {
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
		List<IBusModelSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelSchemaDefObj> readCachedAllSchemaDef() {
		final String S_ProcName = "readCachedAllSchemaDef";
		ArrayList<IBusModelSchemaDefObj> arrayList = new ArrayList<IBusModelSchemaDefObj>();
		if( allSchemaDef != null ) {
			int len = allSchemaDef.size();
			IBusModelSchemaDefObj arr[] = new IBusModelSchemaDefObj[len];
			Iterator<IBusModelSchemaDefObj> valIter = allSchemaDef.values().iterator();
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
		Comparator<IBusModelSchemaDefObj> cmp = new Comparator<IBusModelSchemaDefObj>() {
			public int compare( IBusModelSchemaDefObj lhs, IBusModelSchemaDefObj rhs ) {
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
	public IBusModelSchemaDefObj readSchemaDefByIdIdx( IYCFKeyHash256 Id )
	{
		return( readSchemaDefByIdIdx( Id,
			false ) );
	}

	@Override
	public IBusModelSchemaDefObj readSchemaDefByIdIdx( IYCFKeyHash256 Id, boolean forceRead )
	{
		IBusModelSchemaDefObj obj = readSchemaDef( Id, forceRead );
		return( obj );
	}

	@Override
	public List<IBusModelSchemaDefObj> readSchemaDefByTenantIdx( IYCFKeyHash256 TenantId )
	{
		return( readSchemaDefByTenantIdx( TenantId,
			false ) );
	}

	@Override
	public List<IBusModelSchemaDefObj> readSchemaDefByTenantIdx( IYCFKeyHash256 TenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> dict;
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByTenantIdx.containsKey( key ) ) {
			dict = indexByTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj>();
			IBusModelScopeObj obj;
			IBusModelScope[] recList = schema.getBusModelBackingStore().getTableScope().readDerivedByTenantIdx( null,
				TenantId );
			IBusModelScope rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaDefObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaDefObj realised = (IBusModelSchemaDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaDefObj arr[] = new IBusModelSchemaDefObj[len];
		Iterator<IBusModelSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaDefObj> arrayList = new ArrayList<IBusModelSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaDefObj> cmp = new Comparator<IBusModelSchemaDefObj>() {
			@Override
			public int compare( IBusModelSchemaDefObj lhs, IBusModelSchemaDefObj rhs ) {
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
		List<IBusModelSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelSchemaDefObj> readSchemaDefByCTenantIdx( IYCFKeyHash256 CTenantId )
	{
		return( readSchemaDefByCTenantIdx( CTenantId,
			false ) );
	}

	@Override
	public List<IBusModelSchemaDefObj> readSchemaDefByCTenantIdx( IYCFKeyHash256 CTenantId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByCTenantIdx";
		IBusModelSchemaDefByCTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByCTenantIdxKey();
		key.setRequiredCTenantId( CTenantId );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> dict;
		if( indexByCTenantIdx == null ) {
			indexByCTenantIdx = new HashMap< IBusModelSchemaDefByCTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByCTenantIdx.containsKey( key ) ) {
			dict = indexByCTenantIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj>();
			IBusModelSchemaDefObj obj;
			IBusModelSchemaDef[] recList = schema.getBusModelBackingStore().getTableSchemaDef().readDerivedByCTenantIdx( null,
				CTenantId );
			IBusModelSchemaDef rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaDefObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaDefObj realised = (IBusModelSchemaDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByCTenantIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaDefObj arr[] = new IBusModelSchemaDefObj[len];
		Iterator<IBusModelSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaDefObj> arrayList = new ArrayList<IBusModelSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaDefObj> cmp = new Comparator<IBusModelSchemaDefObj>() {
			@Override
			public int compare( IBusModelSchemaDefObj lhs, IBusModelSchemaDefObj rhs ) {
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
		List<IBusModelSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelSchemaDefObj> readSchemaDefByMinorVersionIdx( IYCFKeyHash256 MinorVersionId )
	{
		return( readSchemaDefByMinorVersionIdx( MinorVersionId,
			false ) );
	}

	@Override
	public List<IBusModelSchemaDefObj> readSchemaDefByMinorVersionIdx( IYCFKeyHash256 MinorVersionId,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByMinorVersionIdx";
		IBusModelSchemaDefByMinorVersionIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByMinorVersionIdxKey();
		key.setRequiredMinorVersionId( MinorVersionId );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> dict;
		if( indexByMinorVersionIdx == null ) {
			indexByMinorVersionIdx = new HashMap< IBusModelSchemaDefByMinorVersionIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByMinorVersionIdx.containsKey( key ) ) {
			dict = indexByMinorVersionIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj>();
			IBusModelSchemaDefObj obj;
			IBusModelSchemaDef[] recList = schema.getBusModelBackingStore().getTableSchemaDef().readDerivedByMinorVersionIdx( null,
				MinorVersionId );
			IBusModelSchemaDef rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaDefObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaDefObj realised = (IBusModelSchemaDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByMinorVersionIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaDefObj arr[] = new IBusModelSchemaDefObj[len];
		Iterator<IBusModelSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaDefObj> arrayList = new ArrayList<IBusModelSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaDefObj> cmp = new Comparator<IBusModelSchemaDefObj>() {
			@Override
			public int compare( IBusModelSchemaDefObj lhs, IBusModelSchemaDefObj rhs ) {
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
		List<IBusModelSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelSchemaDefObj readSchemaDefByUNameIdx( IYCFKeyHash256 MinorVersionId,
		String Name )
	{
		return( readSchemaDefByUNameIdx( MinorVersionId,
			Name,
			false ) );
	}

	@Override
	public IBusModelSchemaDefObj readSchemaDefByUNameIdx( IYCFKeyHash256 MinorVersionId,
		String Name, boolean forceRead )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelSchemaDefByUNameIdxKey,
				IBusModelSchemaDefObj >();
		}
		IBusModelSchemaDefByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByUNameIdxKey();
		key.setRequiredMinorVersionId( MinorVersionId );
		key.setRequiredName( Name );
		IBusModelSchemaDefObj obj = null;
		if( ( ! forceRead ) && indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
		}
		else {
			IBusModelSchemaDef rec = schema.getBusModelBackingStore().getTableSchemaDef().readDerivedByUNameIdx( null,
				MinorVersionId,
				Name );
			if( rec != null ) {
				obj = (IBusModelSchemaDefObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelSchemaDefObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public List<IBusModelSchemaDefObj> readSchemaDefByAuthEMailIdx( IYCFKeyHash256 CTenantId,
		String AuthorEMail )
	{
		return( readSchemaDefByAuthEMailIdx( CTenantId,
			AuthorEMail,
			false ) );
	}

	@Override
	public List<IBusModelSchemaDefObj> readSchemaDefByAuthEMailIdx( IYCFKeyHash256 CTenantId,
		String AuthorEMail,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByAuthEMailIdx";
		IBusModelSchemaDefByAuthEMailIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByAuthEMailIdxKey();
		key.setRequiredCTenantId( CTenantId );
		key.setRequiredAuthorEMail( AuthorEMail );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> dict;
		if( indexByAuthEMailIdx == null ) {
			indexByAuthEMailIdx = new HashMap< IBusModelSchemaDefByAuthEMailIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByAuthEMailIdx.containsKey( key ) ) {
			dict = indexByAuthEMailIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj>();
			IBusModelSchemaDefObj obj;
			IBusModelSchemaDef[] recList = schema.getBusModelBackingStore().getTableSchemaDef().readDerivedByAuthEMailIdx( null,
				CTenantId,
				AuthorEMail );
			IBusModelSchemaDef rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaDefObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaDefObj realised = (IBusModelSchemaDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByAuthEMailIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaDefObj arr[] = new IBusModelSchemaDefObj[len];
		Iterator<IBusModelSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaDefObj> arrayList = new ArrayList<IBusModelSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaDefObj> cmp = new Comparator<IBusModelSchemaDefObj>() {
			@Override
			public int compare( IBusModelSchemaDefObj lhs, IBusModelSchemaDefObj rhs ) {
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
		List<IBusModelSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public List<IBusModelSchemaDefObj> readSchemaDefByProjectURLIdx( IYCFKeyHash256 CTenantId,
		String ProjectURL )
	{
		return( readSchemaDefByProjectURLIdx( CTenantId,
			ProjectURL,
			false ) );
	}

	@Override
	public List<IBusModelSchemaDefObj> readSchemaDefByProjectURLIdx( IYCFKeyHash256 CTenantId,
		String ProjectURL,
		boolean forceRead )
	{
		final String S_ProcName = "readSchemaDefByProjectURLIdx";
		IBusModelSchemaDefByProjectURLIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByProjectURLIdxKey();
		key.setRequiredCTenantId( CTenantId );
		key.setRequiredProjectURL( ProjectURL );
		Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> dict;
		if( indexByProjectURLIdx == null ) {
			indexByProjectURLIdx = new HashMap< IBusModelSchemaDefByProjectURLIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > >();
		}
		if( ( ! forceRead ) && indexByProjectURLIdx.containsKey( key ) ) {
			dict = indexByProjectURLIdx.get( key );
		}
		else {
			dict = new HashMap<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj>();
			IBusModelSchemaDefObj obj;
			IBusModelSchemaDef[] recList = schema.getBusModelBackingStore().getTableSchemaDef().readDerivedByProjectURLIdx( null,
				CTenantId,
				ProjectURL );
			IBusModelSchemaDef rec;
			for( int idx = 0; idx < recList.length; idx ++ ) {
				rec = recList[ idx ];
				obj = (IBusModelSchemaDefObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setPKey( rec.getPKey() );
				obj.setRec( rec );
				IBusModelSchemaDefObj realised = (IBusModelSchemaDefObj)obj.realise();
				dict.put( realised.getPKey(), realised );
			}
			indexByProjectURLIdx.put( key, dict );
		}
		int len = dict.size();
		IBusModelSchemaDefObj arr[] = new IBusModelSchemaDefObj[len];
		Iterator<IBusModelSchemaDefObj> valIter = dict.values().iterator();
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
		ArrayList<IBusModelSchemaDefObj> arrayList = new ArrayList<IBusModelSchemaDefObj>(len);
		for( idx = 0; idx < len; idx ++ ) {
			arrayList.add( arr[idx] );
		}

		Comparator<IBusModelSchemaDefObj> cmp = new Comparator<IBusModelSchemaDefObj>() {
			@Override
			public int compare( IBusModelSchemaDefObj lhs, IBusModelSchemaDefObj rhs ) {
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
		List<IBusModelSchemaDefObj> sortedList = arrayList;
		return( sortedList );
	}

	@Override
	public IBusModelSchemaDefObj readSchemaDefByPubURIIdx( IYCFKeyHash256 CTenantId,
		String PublishURI )
	{
		return( readSchemaDefByPubURIIdx( CTenantId,
			PublishURI,
			false ) );
	}

	@Override
	public IBusModelSchemaDefObj readSchemaDefByPubURIIdx( IYCFKeyHash256 CTenantId,
		String PublishURI, boolean forceRead )
	{
		if( indexByPubURIIdx == null ) {
			indexByPubURIIdx = new HashMap< IBusModelSchemaDefByPubURIIdxKey,
				IBusModelSchemaDefObj >();
		}
		IBusModelSchemaDefByPubURIIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByPubURIIdxKey();
		key.setRequiredCTenantId( CTenantId );
		key.setRequiredPublishURI( PublishURI );
		IBusModelSchemaDefObj obj = null;
		if( ( ! forceRead ) && indexByPubURIIdx.containsKey( key ) ) {
			obj = indexByPubURIIdx.get( key );
		}
		else {
			IBusModelSchemaDef rec = schema.getBusModelBackingStore().getTableSchemaDef().readDerivedByPubURIIdx( null,
				CTenantId,
				PublishURI );
			if( rec != null ) {
				obj = (IBusModelSchemaDefObj)schema.getScopeTableObj().constructByClassCode( rec.getClassCode() );
				obj.setRec( rec );
				obj.setPKey( rec.getPKey() );
				obj = (IBusModelSchemaDefObj)obj.realise();
			}
		}
		return( obj );
	}

	@Override
	public IBusModelSchemaDefObj readCachedSchemaDefByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelSchemaDefObj obj = null;
		obj = readCachedSchemaDef( Id );
		return( obj );
	}

	@Override
	public List<IBusModelSchemaDefObj> readCachedSchemaDefByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "readCachedSchemaDefByTenantIdx";
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		ArrayList<IBusModelSchemaDefObj> arrayList = new ArrayList<IBusModelSchemaDefObj>();
		if( indexByTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> dict;
			if( indexByTenantIdx.containsKey( key ) ) {
				dict = indexByTenantIdx.get( key );
				int len = dict.size();
				IBusModelSchemaDefObj arr[] = new IBusModelSchemaDefObj[len];
				Iterator<IBusModelSchemaDefObj> valIter = dict.values().iterator();
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
			IBusModelSchemaDefObj obj;
			Iterator<IBusModelSchemaDefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaDefObj> cmp = new Comparator<IBusModelSchemaDefObj>() {
			@Override
			public int compare( IBusModelSchemaDefObj lhs, IBusModelSchemaDefObj rhs ) {
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
	public List<IBusModelSchemaDefObj> readCachedSchemaDefByCTenantIdx( IYCFKeyHash256 CTenantId )
	{
		final String S_ProcName = "readCachedSchemaDefByCTenantIdx";
		IBusModelSchemaDefByCTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByCTenantIdxKey();
		key.setRequiredCTenantId( CTenantId );
		ArrayList<IBusModelSchemaDefObj> arrayList = new ArrayList<IBusModelSchemaDefObj>();
		if( indexByCTenantIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> dict;
			if( indexByCTenantIdx.containsKey( key ) ) {
				dict = indexByCTenantIdx.get( key );
				int len = dict.size();
				IBusModelSchemaDefObj arr[] = new IBusModelSchemaDefObj[len];
				Iterator<IBusModelSchemaDefObj> valIter = dict.values().iterator();
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
			IBusModelSchemaDefObj obj;
			Iterator<IBusModelSchemaDefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaDefObj> cmp = new Comparator<IBusModelSchemaDefObj>() {
			@Override
			public int compare( IBusModelSchemaDefObj lhs, IBusModelSchemaDefObj rhs ) {
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
	public List<IBusModelSchemaDefObj> readCachedSchemaDefByMinorVersionIdx( IYCFKeyHash256 MinorVersionId )
	{
		final String S_ProcName = "readCachedSchemaDefByMinorVersionIdx";
		IBusModelSchemaDefByMinorVersionIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByMinorVersionIdxKey();
		key.setRequiredMinorVersionId( MinorVersionId );
		ArrayList<IBusModelSchemaDefObj> arrayList = new ArrayList<IBusModelSchemaDefObj>();
		if( indexByMinorVersionIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> dict;
			if( indexByMinorVersionIdx.containsKey( key ) ) {
				dict = indexByMinorVersionIdx.get( key );
				int len = dict.size();
				IBusModelSchemaDefObj arr[] = new IBusModelSchemaDefObj[len];
				Iterator<IBusModelSchemaDefObj> valIter = dict.values().iterator();
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
			IBusModelSchemaDefObj obj;
			Iterator<IBusModelSchemaDefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaDefObj> cmp = new Comparator<IBusModelSchemaDefObj>() {
			@Override
			public int compare( IBusModelSchemaDefObj lhs, IBusModelSchemaDefObj rhs ) {
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
	public IBusModelSchemaDefObj readCachedSchemaDefByUNameIdx( IYCFKeyHash256 MinorVersionId,
		String Name )
	{
		IBusModelSchemaDefObj obj = null;
		IBusModelSchemaDefByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByUNameIdxKey();
		key.setRequiredMinorVersionId( MinorVersionId );
		key.setRequiredName( Name );
		if( indexByUNameIdx != null ) {
			if( indexByUNameIdx.containsKey( key ) ) {
				obj = indexByUNameIdx.get( key );
			}
			else {
				Iterator<IBusModelSchemaDefObj> valIter = members.values().iterator();
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
			Iterator<IBusModelSchemaDefObj> valIter = members.values().iterator();
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
	public List<IBusModelSchemaDefObj> readCachedSchemaDefByAuthEMailIdx( IYCFKeyHash256 CTenantId,
		String AuthorEMail )
	{
		final String S_ProcName = "readCachedSchemaDefByAuthEMailIdx";
		IBusModelSchemaDefByAuthEMailIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByAuthEMailIdxKey();
		key.setRequiredCTenantId( CTenantId );
		key.setRequiredAuthorEMail( AuthorEMail );
		ArrayList<IBusModelSchemaDefObj> arrayList = new ArrayList<IBusModelSchemaDefObj>();
		if( indexByAuthEMailIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> dict;
			if( indexByAuthEMailIdx.containsKey( key ) ) {
				dict = indexByAuthEMailIdx.get( key );
				int len = dict.size();
				IBusModelSchemaDefObj arr[] = new IBusModelSchemaDefObj[len];
				Iterator<IBusModelSchemaDefObj> valIter = dict.values().iterator();
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
			IBusModelSchemaDefObj obj;
			Iterator<IBusModelSchemaDefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaDefObj> cmp = new Comparator<IBusModelSchemaDefObj>() {
			@Override
			public int compare( IBusModelSchemaDefObj lhs, IBusModelSchemaDefObj rhs ) {
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
	public List<IBusModelSchemaDefObj> readCachedSchemaDefByProjectURLIdx( IYCFKeyHash256 CTenantId,
		String ProjectURL )
	{
		final String S_ProcName = "readCachedSchemaDefByProjectURLIdx";
		IBusModelSchemaDefByProjectURLIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByProjectURLIdxKey();
		key.setRequiredCTenantId( CTenantId );
		key.setRequiredProjectURL( ProjectURL );
		ArrayList<IBusModelSchemaDefObj> arrayList = new ArrayList<IBusModelSchemaDefObj>();
		if( indexByProjectURLIdx != null ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> dict;
			if( indexByProjectURLIdx.containsKey( key ) ) {
				dict = indexByProjectURLIdx.get( key );
				int len = dict.size();
				IBusModelSchemaDefObj arr[] = new IBusModelSchemaDefObj[len];
				Iterator<IBusModelSchemaDefObj> valIter = dict.values().iterator();
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
			IBusModelSchemaDefObj obj;
			Iterator<IBusModelSchemaDefObj> valIter = members.values().iterator();
			while( valIter.hasNext() ) {
				obj = valIter.next();
				if( obj != null ) {
					if( obj.getRec().compareTo( key ) == 0 ) {
						arrayList.add( obj );
					}
				}
			}
		}
		Comparator<IBusModelSchemaDefObj> cmp = new Comparator<IBusModelSchemaDefObj>() {
			@Override
			public int compare( IBusModelSchemaDefObj lhs, IBusModelSchemaDefObj rhs ) {
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
	public IBusModelSchemaDefObj readCachedSchemaDefByPubURIIdx( IYCFKeyHash256 CTenantId,
		String PublishURI )
	{
		IBusModelSchemaDefObj obj = null;
		IBusModelSchemaDefByPubURIIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByPubURIIdxKey();
		key.setRequiredCTenantId( CTenantId );
		key.setRequiredPublishURI( PublishURI );
		if( indexByPubURIIdx != null ) {
			if( indexByPubURIIdx.containsKey( key ) ) {
				obj = indexByPubURIIdx.get( key );
			}
			else {
				Iterator<IBusModelSchemaDefObj> valIter = members.values().iterator();
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
			Iterator<IBusModelSchemaDefObj> valIter = members.values().iterator();
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
	public void deepDisposeSchemaDefByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelSchemaDefObj obj = readCachedSchemaDefByIdIdx( Id );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSchemaDefByTenantIdx( IYCFKeyHash256 TenantId )
	{
		final String S_ProcName = "deepDisposeSchemaDefByTenantIdx";
		IBusModelSchemaDefObj obj;
		List<IBusModelSchemaDefObj> arrayList = readCachedSchemaDefByTenantIdx( TenantId );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaDefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSchemaDefByCTenantIdx( IYCFKeyHash256 CTenantId )
	{
		final String S_ProcName = "deepDisposeSchemaDefByCTenantIdx";
		IBusModelSchemaDefObj obj;
		List<IBusModelSchemaDefObj> arrayList = readCachedSchemaDefByCTenantIdx( CTenantId );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaDefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSchemaDefByMinorVersionIdx( IYCFKeyHash256 MinorVersionId )
	{
		final String S_ProcName = "deepDisposeSchemaDefByMinorVersionIdx";
		IBusModelSchemaDefObj obj;
		List<IBusModelSchemaDefObj> arrayList = readCachedSchemaDefByMinorVersionIdx( MinorVersionId );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaDefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSchemaDefByUNameIdx( IYCFKeyHash256 MinorVersionId,
		String Name )
	{
		IBusModelSchemaDefObj obj = readCachedSchemaDefByUNameIdx( MinorVersionId,
				Name );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public void deepDisposeSchemaDefByAuthEMailIdx( IYCFKeyHash256 CTenantId,
		String AuthorEMail )
	{
		final String S_ProcName = "deepDisposeSchemaDefByAuthEMailIdx";
		IBusModelSchemaDefObj obj;
		List<IBusModelSchemaDefObj> arrayList = readCachedSchemaDefByAuthEMailIdx( CTenantId,
				AuthorEMail );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaDefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSchemaDefByProjectURLIdx( IYCFKeyHash256 CTenantId,
		String ProjectURL )
	{
		final String S_ProcName = "deepDisposeSchemaDefByProjectURLIdx";
		IBusModelSchemaDefObj obj;
		List<IBusModelSchemaDefObj> arrayList = readCachedSchemaDefByProjectURLIdx( CTenantId,
				ProjectURL );
		if( arrayList != null )  {
			Iterator<IBusModelSchemaDefObj> arrayIter = arrayList.iterator();
			while( arrayIter.hasNext() ) {
				obj = arrayIter.next();
				if( obj != null ) {
					obj.forget();
				}
			}
		}
	}

	@Override
	public void deepDisposeSchemaDefByPubURIIdx( IYCFKeyHash256 CTenantId,
		String PublishURI )
	{
		IBusModelSchemaDefObj obj = readCachedSchemaDefByPubURIIdx( CTenantId,
				PublishURI );
		if( obj != null ) {
			obj.forget();
		}
	}

	@Override
	public IBusModelSchemaDefObj updateSchemaDef( IBusModelSchemaDefObj Obj ) {
		IBusModelSchemaDefObj obj = Obj;
		schema.getBusModelBackingStore().getTableSchemaDef().updateSchemaDef( null,
			Obj.getSchemaDefRec() );
		if( Obj.getClassCode() == ((IBusModelSchemaObj)getSchema()).getSchemaDefTableObj().getClassCode() ) {
			obj = (IBusModelSchemaDefObj)Obj.realise();
		}
		obj.endEdit();
		return( obj );
	}

	@Override
	public void deleteSchemaDef( IBusModelSchemaDefObj Obj ) {
		IBusModelSchemaDefObj obj = Obj;
		schema.getBusModelBackingStore().getTableSchemaDef().deleteSchemaDef( null,
			obj.getSchemaDefRec() );
		Obj.forget();
	}

	@Override
	public void deleteSchemaDefByIdIdx( IYCFKeyHash256 Id )
	{
		IBusModelSchemaDefObj obj = readSchemaDef(Id);
		if( obj != null ) {
			IBusModelSchemaDefEditObj editObj = (IBusModelSchemaDefEditObj)obj.getEdit();
			boolean editStarted;
			if( editObj == null ) {
				editObj = (IBusModelSchemaDefEditObj)obj.beginEdit();
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
		deepDisposeSchemaDefByIdIdx( Id );
	}

	@Override
	public void deleteSchemaDefByTenantIdx( IYCFKeyHash256 TenantId )
	{
		IBusModelScopeByTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactoryScope().newByTenantIdxKey();
		key.setRequiredTenantId( TenantId );
		if( indexByTenantIdx == null ) {
			indexByTenantIdx = new HashMap< IBusModelScopeByTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > >();
		}
		if( indexByTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> dict = indexByTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaDef().deleteSchemaDefByTenantIdx( null,
				TenantId );
			Iterator<IBusModelSchemaDefObj> iter = dict.values().iterator();
			IBusModelSchemaDefObj obj;
			List<IBusModelSchemaDefObj> toForget = new LinkedList<IBusModelSchemaDefObj>();
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
			schema.getBusModelBackingStore().getTableSchemaDef().deleteSchemaDefByTenantIdx( null,
				TenantId );
		}
		deepDisposeSchemaDefByTenantIdx( TenantId );
	}

	@Override
	public void deleteSchemaDefByCTenantIdx( IYCFKeyHash256 CTenantId )
	{
		IBusModelSchemaDefByCTenantIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByCTenantIdxKey();
		key.setRequiredCTenantId( CTenantId );
		if( indexByCTenantIdx == null ) {
			indexByCTenantIdx = new HashMap< IBusModelSchemaDefByCTenantIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > >();
		}
		if( indexByCTenantIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> dict = indexByCTenantIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaDef().deleteSchemaDefByCTenantIdx( null,
				CTenantId );
			Iterator<IBusModelSchemaDefObj> iter = dict.values().iterator();
			IBusModelSchemaDefObj obj;
			List<IBusModelSchemaDefObj> toForget = new LinkedList<IBusModelSchemaDefObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByCTenantIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableSchemaDef().deleteSchemaDefByCTenantIdx( null,
				CTenantId );
		}
		deepDisposeSchemaDefByCTenantIdx( CTenantId );
	}

	@Override
	public void deleteSchemaDefByMinorVersionIdx( IYCFKeyHash256 MinorVersionId )
	{
		IBusModelSchemaDefByMinorVersionIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByMinorVersionIdxKey();
		key.setRequiredMinorVersionId( MinorVersionId );
		if( indexByMinorVersionIdx == null ) {
			indexByMinorVersionIdx = new HashMap< IBusModelSchemaDefByMinorVersionIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > >();
		}
		if( indexByMinorVersionIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> dict = indexByMinorVersionIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaDef().deleteSchemaDefByMinorVersionIdx( null,
				MinorVersionId );
			Iterator<IBusModelSchemaDefObj> iter = dict.values().iterator();
			IBusModelSchemaDefObj obj;
			List<IBusModelSchemaDefObj> toForget = new LinkedList<IBusModelSchemaDefObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByMinorVersionIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableSchemaDef().deleteSchemaDefByMinorVersionIdx( null,
				MinorVersionId );
		}
		deepDisposeSchemaDefByMinorVersionIdx( MinorVersionId );
	}

	@Override
	public void deleteSchemaDefByUNameIdx( IYCFKeyHash256 MinorVersionId,
		String Name )
	{
		if( indexByUNameIdx == null ) {
			indexByUNameIdx = new HashMap< IBusModelSchemaDefByUNameIdxKey,
				IBusModelSchemaDefObj >();
		}
		IBusModelSchemaDefByUNameIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByUNameIdxKey();
		key.setRequiredMinorVersionId( MinorVersionId );
		key.setRequiredName( Name );
		IBusModelSchemaDefObj obj = null;
		if( indexByUNameIdx.containsKey( key ) ) {
			obj = indexByUNameIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaDef().deleteSchemaDefByUNameIdx( null,
				MinorVersionId,
				Name );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableSchemaDef().deleteSchemaDefByUNameIdx( null,
				MinorVersionId,
				Name );
		}
		deepDisposeSchemaDefByUNameIdx( MinorVersionId,
				Name );
	}

	@Override
	public void deleteSchemaDefByAuthEMailIdx( IYCFKeyHash256 CTenantId,
		String AuthorEMail )
	{
		IBusModelSchemaDefByAuthEMailIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByAuthEMailIdxKey();
		key.setRequiredCTenantId( CTenantId );
		key.setRequiredAuthorEMail( AuthorEMail );
		if( indexByAuthEMailIdx == null ) {
			indexByAuthEMailIdx = new HashMap< IBusModelSchemaDefByAuthEMailIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > >();
		}
		if( indexByAuthEMailIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> dict = indexByAuthEMailIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaDef().deleteSchemaDefByAuthEMailIdx( null,
				CTenantId,
				AuthorEMail );
			Iterator<IBusModelSchemaDefObj> iter = dict.values().iterator();
			IBusModelSchemaDefObj obj;
			List<IBusModelSchemaDefObj> toForget = new LinkedList<IBusModelSchemaDefObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByAuthEMailIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableSchemaDef().deleteSchemaDefByAuthEMailIdx( null,
				CTenantId,
				AuthorEMail );
		}
		deepDisposeSchemaDefByAuthEMailIdx( CTenantId,
				AuthorEMail );
	}

	@Override
	public void deleteSchemaDefByProjectURLIdx( IYCFKeyHash256 CTenantId,
		String ProjectURL )
	{
		IBusModelSchemaDefByProjectURLIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByProjectURLIdxKey();
		key.setRequiredCTenantId( CTenantId );
		key.setRequiredProjectURL( ProjectURL );
		if( indexByProjectURLIdx == null ) {
			indexByProjectURLIdx = new HashMap< IBusModelSchemaDefByProjectURLIdxKey,
				Map< $implCommaIJavaOptAtomType$, IBusModelSchemaDefObj > >();
		}
		if( indexByProjectURLIdx.containsKey( key ) ) {
			Map<$implCommaIJavaOptAtomType$, IBusModelSchemaDefObj> dict = indexByProjectURLIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaDef().deleteSchemaDefByProjectURLIdx( null,
				CTenantId,
				ProjectURL );
			Iterator<IBusModelSchemaDefObj> iter = dict.values().iterator();
			IBusModelSchemaDefObj obj;
			List<IBusModelSchemaDefObj> toForget = new LinkedList<IBusModelSchemaDefObj>();
			while( iter.hasNext() ) {
				obj = iter.next();
				toForget.add( obj );
			}
			iter = toForget.iterator();
			while( iter.hasNext() ) {
				obj = iter.next();
				obj.forget();
			}
			indexByProjectURLIdx.remove( key );
		}
		else {
			schema.getBusModelBackingStore().getTableSchemaDef().deleteSchemaDefByProjectURLIdx( null,
				CTenantId,
				ProjectURL );
		}
		deepDisposeSchemaDefByProjectURLIdx( CTenantId,
				ProjectURL );
	}

	@Override
	public void deleteSchemaDefByPubURIIdx( IYCFKeyHash256 CTenantId,
		String PublishURI )
	{
		if( indexByPubURIIdx == null ) {
			indexByPubURIIdx = new HashMap< IBusModelSchemaDefByPubURIIdxKey,
				IBusModelSchemaDefObj >();
		}
		IBusModelSchemaDefByPubURIIdxKey key = schema.getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newByPubURIIdxKey();
		key.setRequiredCTenantId( CTenantId );
		key.setRequiredPublishURI( PublishURI );
		IBusModelSchemaDefObj obj = null;
		if( indexByPubURIIdx.containsKey( key ) ) {
			obj = indexByPubURIIdx.get( key );
			schema.getBusModelBackingStore().getTableSchemaDef().deleteSchemaDefByPubURIIdx( null,
				CTenantId,
				PublishURI );
			obj.forget();
		}
		else {
			schema.getBusModelBackingStore().getTableSchemaDef().deleteSchemaDefByPubURIIdx( null,
				CTenantId,
				PublishURI );
		}
		deepDisposeSchemaDefByPubURIIdx( CTenantId,
				PublishURI );
	}
}