// Description: Java 25 base object instance implementation for TableInfo

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
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public class BusModelTableInfoObj
	implements IBusModelTableInfoObj
{
	protected boolean isNew;
	protected ISecureTableInfoEditObj edit;
	protected ISecureSchemaObj schema;
	protected $implCommaIJavaOptAtomType$ pKey;
	protected ISecureTableInfo rec;
	protected ISecureTableInfoObj optionalParentSuperRef;
	protected List<ISecureTableInfoObj> optionalChildrenSubRefs;

	public BusModelTableInfoObj() {
		isNew = true;
		optionalParentSuperRef = null;
	}

	public BusModelTableInfoObj( ISecureSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		optionalParentSuperRef = null;
	}

	@Override
	public int getClassCode() {
		return( ((ISecureSchemaObj)schema).getTableInfoTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "TableInfo" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		return( null );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredTableName();
		return( objName );
	}

	@Override
	public IYCFAnyObj getObjQualifier( Class qualifyingClass ) {
		IYCFAnyObj container = this;
		if( qualifyingClass != null ) {
			while( container != null ) {
				if( container instanceof IBusModelClusterObj ) {
					break;
				}
				else if( container instanceof IBusModelTenantObj ) {
					break;
				}
				else if( qualifyingClass.isInstance( container ) ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		else {
			while( container != null ) {
				if( container instanceof IBusModelClusterObj ) {
					break;
				}
				else if( container instanceof IBusModelTenantObj ) {
					break;
				}
				container = container.getObjScope();
			}
		}
		return( container );
	}

	@Override
	public IYCFAnyObj getNamedObject( Class qualifyingClass, String objName ) {
		IYCFAnyObj topContainer = getObjQualifier( qualifyingClass );
		if( topContainer == null ) {
			return( null );
		}
		IYCFAnyObj namedObject = topContainer.getNamedObject( objName );
		return( namedObject );
	}

	@Override
	public IYCFAnyObj getNamedObject( String objName ) {
		String nextName;
		String remainingName;
		IYCFAnyObj subObj = null;
		IYCFAnyObj retObj;
		int nextDot = objName.indexOf( '.' );
		if( nextDot >= 0 ) {
			nextName = objName.substring( 0, nextDot );
			remainingName = objName.substring( nextDot + 1 );
		}
		else {
			nextName = objName;
			remainingName = null;
		}
		if( remainingName == null ) {
			retObj = subObj;
		}
		else if( subObj == null ) {
			retObj = null;
		}
		else {
			retObj = subObj.getNamedObject( remainingName );
		}
		return( retObj );
	}

	@Override
	public String getObjQualifiedName() {
		String qualName = getObjName();
		IYCFAnyObj container = getObjScope();
		String containerName;
		while( container != null ) {
			if( container instanceof ISecureClusterObj ) {
				container = null;
			}
			else if( container instanceof ISecureTenantObj ) {
				container = null;
			}
			else {
				containerName = container.getObjName();
				qualName = containerName + "." + qualName;
				container = container.getObjScope();
			}
		}
		return( qualName );
	}

	@Override
	public String getObjFullName() {
		String fullName = getObjName();
		IYCFAnyObj container = getObjScope();
		String containerName;
		while( container != null ) {
			if( container instanceof ISecureClusterObj ) {
				container = null;
			}
			else if( container instanceof ISecureTenantObj ) {
				container = null;
			}
			else {
				containerName = container.getObjName();
				fullName = containerName + "." + fullName;
				container = container.getObjScope();
			}
		}
		return( fullName );
	}

	@Override
	public ISecureTableInfoObj realise() {
		ISecureTableInfoObj retobj = ((IBusModelSchemaObj)getSchema()).getTableInfoTableObj().realiseTableInfo(
			(ISecureTableInfoObj)this );
		return( (ISecureTableInfoObj)retobj );
	}

	@Override
	public void forget() {
		((IBusModelSchemaObj)getSchema()).getTableInfoTableObj().reallyDeepDisposeTableInfo( (ISecureTableInfoObj)this );
	}

	@Override
	public ISecureTableInfoObj read() {
		ISecureTableInfoObj retobj = ((IBusModelSchemaObj)getSchema()).getTableInfoTableObj().readTableInfoByIdIdx( getPKey(), false );
		return( (ISecureTableInfoObj)retobj );
	}

	@Override
	public ISecureTableInfoObj read( boolean forceRead ) {
		ISecureTableInfoObj retobj = ((IBusModelSchemaObj)getSchema()).getTableInfoTableObj().readTableInfoByIdIdx( getPKey(), forceRead );
		return( (ISecureTableInfoObj)retobj );
	}

	@Override
	public ISecureTableInfoTableObj getTableInfoTable() {
		return( ((IBusModelSchemaObj)getSchema()).getTableInfoTableObj() );
	}

	@Override
	public ISecureSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( ISecureSchemaObj value ) {
		schema = value;
	}

	@Override
	public ISecureTableInfo getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getSecureBackingStore().getSecureFactory().getFactoryTableInfo().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getSecureBackingStore().getTableTableInfo().readDerivedByIdIdx( ((IBusModelSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureTableInfo value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ISecureTableInfo ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"SecureTableInfoRec" );
		}
		rec = value;
		copyRecToPKey();
		optionalParentSuperRef = null;
	}

	@Override
	public ISecureTableInfo getTableInfoRec() {
		return( (ISecureTableInfo)getRec() );
	}

	@Override
	public $implCommaIJavaOptAtomType$ getPKey() {
		return( pKey );
	}

	@Override
	public void setPKey( $implCommaIJavaOptAtomType$ value ) {
		if( pKey != value ) {
       		pKey = value;
			copyPKeyToRec();
		}
	}

	@Override
	public boolean getIsNew() {
		return( isNew );
	}

	@Override
	public void setIsNew( boolean value ) {
		isNew = value;
	}

	@Override
	public ISecureTableInfoEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ISecureTableInfoObj lockobj;
		if( getIsNew() ) {
			lockobj = (ISecureTableInfoObj)this;
		}
		else {
			lockobj = ((IBusModelSchemaObj)getSchema()).getTableInfoTableObj().lockTableInfo( getPKey() );
		}
		edit = ((IBusModelSchemaObj)getSchema()).getTableInfoTableObj().newEditInstance( lockobj );
		return( (ISecureTableInfoEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ISecureTableInfoEditObj getEdit() {
		return( edit );
	}

	@Override
	public ISecureTableInfoEditObj getEditAsTableInfo() {
		return( (ISecureTableInfoEditObj)edit );
	}

	@Override
	public int getRequiredTableInfoId() {
		return( getPKey() );
	}

	@Override
	public ISecureTableInfoObj getOptionalParentSuperRef() {
		return( getOptionalParentSuperRef( false ) );
	}

	@Override
	public ISecureTableInfoObj getOptionalParentSuperRef( boolean forceRead ) {
		if( ( optionalParentSuperRef == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableInfoRec().getOptionalSuperName() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalParentSuperRef = ((IBusModelSchemaObj)getSchema()).getTableInfoTableObj().readTableInfoByTableNameIdx( getTableInfoRec().getOptionalSuperName(), forceRead );
			}
		}
		return( optionalParentSuperRef );
	}

	@Override
	public List<ISecureTableInfoObj> getOptionalChildrenSubRefs() {
		List<ISecureTableInfoObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getTableInfoTableObj().readTableInfoBySuperNameIdx( getTableInfoRec().getRequiredTableName(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureTableInfoObj> getOptionalChildrenSubRefs( boolean forceRead ) {
		List<ISecureTableInfoObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getTableInfoTableObj().readTableInfoBySuperNameIdx( getTableInfoRec().getRequiredTableName(),
			forceRead );
		return( retval );
	}

	@Override
	public String getRequiredSchemaName() {
		return( getTableInfoRec().getRequiredSchemaName() );
	}

	@Override
	public String getRequiredTableName() {
		return( getTableInfoRec().getRequiredTableName() );
	}

	@Override
	public String getOptionalSuperName() {
		return( getTableInfoRec().getOptionalSuperName() );
	}

	@Override
	public int getRequiredBackingClassCode() {
		return( getTableInfoRec().getRequiredBackingClassCode() );
	}

	@Override
	public int getRequiredRuntimeClassCode() {
		return( getTableInfoRec().getRequiredRuntimeClassCode() );
	}

	@Override
	public boolean getRequiredHasHistory() {
		return( getTableInfoRec().getRequiredHasHistory() );
	}

	@Override
	public boolean getRequiredIsMutable() {
		return( getTableInfoRec().getRequiredIsMutable() );
	}

	@Override
	public String getRequiredSecScopeName() {
		return( getTableInfoRec().getRequiredSecScopeName() );
	}

	@Override
	public String getRequiredCodeVis() {
		return( getTableInfoRec().getRequiredCodeVis() );
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			if (getPKey() != rec.getPKey()) {
				rec.setPKey(getPKey());
			}
		}
		if( edit != null ) {
			edit.copyPKeyToRec();
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			if (getPKey() != rec.getPKey()) {
				setPKey(rec.getPKey());
			}
		}
	}
}
