// Description: Java 25 base object instance implementation for ClearTopDep

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
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

public class BusModelClearTopDepObj
	extends BusModelClearDepObj
	implements IBusModelClearTopDepObj
{
	protected IBusModelTableObj requiredContainerTable;
	protected List<IBusModelClearSubDep1Obj> optionalComponentsClearDep;
	protected IBusModelClearTopDepObj optionalLookupPrev;
	protected IBusModelClearTopDepObj optionalLookupNext;

	public BusModelClearTopDepObj() {
		super();
		requiredContainerTable = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public BusModelClearTopDepObj( IBusModelSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerTable = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)schema).getClearTopDepTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "ClearTopDep" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelTableObj scope = getRequiredContainerTable();
		return( scope );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredName();
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
			else if( container instanceof IBusModelSchemaDefObj ) {
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
	public IBusModelScopeObj realise() {
		IBusModelClearTopDepObj retobj = ((IBusModelSchemaObj)getSchema()).getClearTopDepTableObj().realiseClearTopDep(
			(IBusModelClearTopDepObj)this );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public void forget() {
		((IBusModelSchemaObj)getSchema()).getClearTopDepTableObj().reallyDeepDisposeClearTopDep( (IBusModelClearTopDepObj)this );
	}

	@Override
	public IBusModelScopeObj read() {
		IBusModelClearTopDepObj retobj = ((IBusModelSchemaObj)getSchema()).getClearTopDepTableObj().readClearTopDepByIdIdx( getPKey(), false );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public IBusModelScopeObj read( boolean forceRead ) {
		IBusModelClearTopDepObj retobj = ((IBusModelSchemaObj)getSchema()).getClearTopDepTableObj().readClearTopDepByIdIdx( getPKey(), forceRead );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public IBusModelClearTopDepObj moveUp() {
		IBusModelClearTopDepObj retobj = ((IBusModelSchemaObj)getSchema()).getClearTopDepTableObj().moveUpClearTopDep( this );
		return( (IBusModelClearTopDepObj)retobj );
	}

	@Override
	public IBusModelClearTopDepObj moveDown() {
		IBusModelClearTopDepObj retobj = ((IBusModelSchemaObj)getSchema()).getClearTopDepTableObj().moveDownClearTopDep( this );
		return( (IBusModelClearTopDepObj)retobj );
	}

	@Override
	public IBusModelClearTopDepTableObj getClearTopDepTable() {
		return( ((IBusModelSchemaObj)getSchema()).getClearTopDepTableObj() );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getBusModelBackingStore().getTableClearTopDep().readDerivedByIdIdx( ((IBusModelSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelScope value ) {
		if( ! ( ( value == null ) || ! ( value instanceof IBusModelClearTopDep ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"BusModelClearTopDepRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredOwnerTenant = null;
		requiredLookupRelation = null;
		optionalLookupDefSchema = null;
		requiredContainerTable = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	@Override
	public IBusModelClearTopDep getClearTopDepRec() {
		return( (IBusModelClearTopDep)getRec() );
	}

	@Override
	public IBusModelScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		IBusModelClearTopDepObj lockobj;
		if( getIsNew() ) {
			lockobj = (IBusModelClearTopDepObj)this;
		}
		else {
			lockobj = ((IBusModelSchemaObj)getSchema()).getClearTopDepTableObj().lockClearTopDep( getPKey() );
		}
		edit = ((IBusModelSchemaObj)getSchema()).getClearTopDepTableObj().newEditInstance( lockobj );
		return( (IBusModelScopeEditObj)edit );
	}

	@Override
	public IBusModelClearTopDepEditObj getEditAsClearTopDep() {
		return( (IBusModelClearTopDepEditObj)edit );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			IBusModelScope rec = getRec();
			createdBy = ((IBusModelSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getCreatedByUserId() );
		}
		return( createdBy );
	}

	@Override
	public LocalDateTime getCreatedAt() {
		return( getRec().getCreatedAt() );
	}

	@Override
	public ISecureSecUserObj getUpdatedBy() {
		if( updatedBy == null ) {
			IBusModelScope rec = getRec();
			updatedBy = ((IBusModelSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public IYCFKeyHash256 getRequiredId() {
		return( getPKey() );
	}

	@Override
	public IBusModelTableObj getRequiredContainerTable() {
		return( getRequiredContainerTable( false ) );
	}

	@Override
	public IBusModelTableObj getRequiredContainerTable( boolean forceRead ) {
		if( ( requiredContainerTable == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerTable = ((IBusModelSchemaObj)getSchema()).getTableTableObj().readTableByIdIdx( getClearTopDepRec().getRequiredTableId(), forceRead );
			}
		}
		return( requiredContainerTable );
	}

	@Override
	public List<IBusModelClearSubDep1Obj> getOptionalComponentsClearDep() {
		List<IBusModelClearSubDep1Obj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getClearSubDep1TableObj().readClearSubDep1ByClearTopDepIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelClearSubDep1Obj> getOptionalComponentsClearDep( boolean forceRead ) {
		List<IBusModelClearSubDep1Obj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getClearSubDep1TableObj().readClearSubDep1ByClearTopDepIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public IBusModelClearTopDepObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	@Override
	public IBusModelClearTopDepObj getOptionalLookupPrev( boolean forceRead ) {
		if( ( optionalLookupPrev == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getClearTopDepRec().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrev = ((IBusModelSchemaObj)getSchema()).getClearTopDepTableObj().readClearTopDepByIdIdx( getClearTopDepRec().getOptionalPrevId(), forceRead );
			}
		}
		return( optionalLookupPrev );
	}

	@Override
	public IBusModelClearTopDepObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	@Override
	public IBusModelClearTopDepObj getOptionalLookupNext( boolean forceRead ) {
		if( ( optionalLookupNext == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getClearTopDepRec().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupNext = ((IBusModelSchemaObj)getSchema()).getClearTopDepTableObj().readClearTopDepByIdIdx( getClearTopDepRec().getOptionalNextId(), forceRead );
			}
		}
		return( optionalLookupNext );
	}

	@Override
	public IYCFKeyHash256 getRequiredTableId() {
		return( getClearTopDepRec().getRequiredTableId() );
	}

	@Override
	public String getRequiredName() {
		return( getClearTopDepRec().getRequiredName() );
	}

	@Override
	public IYCFKeyHash256 getOptionalPrevId() {
		return( getClearTopDepRec().getOptionalPrevId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalNextId() {
		return( getClearTopDepRec().getOptionalNextId() );
	}
}
