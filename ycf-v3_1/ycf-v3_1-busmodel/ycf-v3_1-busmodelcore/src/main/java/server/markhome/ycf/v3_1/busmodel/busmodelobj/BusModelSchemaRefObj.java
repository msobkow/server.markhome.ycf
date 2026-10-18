// Description: Java 25 base object instance implementation for SchemaRef

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

public class BusModelSchemaRefObj
	extends BusModelScopeObj
	implements IBusModelSchemaRefObj
{
	protected IBusModelSchemaDefObj requiredContainerSchema;
	protected IBusModelSchemaDefObj optionalLookupRefSchema;
	protected IBusModelSchemaRefObj optionalLookupPrev;
	protected IBusModelSchemaRefObj optionalLookupNext;

	public BusModelSchemaRefObj() {
		super();
		requiredContainerSchema = null;
		optionalLookupRefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public BusModelSchemaRefObj( IBusModelSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerSchema = null;
		optionalLookupRefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)schema).getSchemaRefTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SchemaRef" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelSchemaDefObj scope = getRequiredContainerSchema();
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
		IBusModelSchemaRefObj retobj = ((IBusModelSchemaObj)getSchema()).getSchemaRefTableObj().realiseSchemaRef(
			(IBusModelSchemaRefObj)this );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public void forget() {
		((IBusModelSchemaObj)getSchema()).getSchemaRefTableObj().reallyDeepDisposeSchemaRef( (IBusModelSchemaRefObj)this );
	}

	@Override
	public IBusModelScopeObj read() {
		IBusModelSchemaRefObj retobj = ((IBusModelSchemaObj)getSchema()).getSchemaRefTableObj().readSchemaRefByIdIdx( getPKey(), false );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public IBusModelScopeObj read( boolean forceRead ) {
		IBusModelSchemaRefObj retobj = ((IBusModelSchemaObj)getSchema()).getSchemaRefTableObj().readSchemaRefByIdIdx( getPKey(), forceRead );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public IBusModelSchemaRefObj moveUp() {
		IBusModelSchemaRefObj retobj = ((IBusModelSchemaObj)getSchema()).getSchemaRefTableObj().moveUpSchemaRef( this );
		return( (IBusModelSchemaRefObj)retobj );
	}

	@Override
	public IBusModelSchemaRefObj moveDown() {
		IBusModelSchemaRefObj retobj = ((IBusModelSchemaObj)getSchema()).getSchemaRefTableObj().moveDownSchemaRef( this );
		return( (IBusModelSchemaRefObj)retobj );
	}

	@Override
	public IBusModelSchemaRefTableObj getSchemaRefTable() {
		return( ((IBusModelSchemaObj)getSchema()).getSchemaRefTableObj() );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getBusModelBackingStore().getTableSchemaRef().readDerivedByIdIdx( ((IBusModelSchemaObj)getSchema()).getAuthorization(),
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
		if( ! ( ( value == null ) || ! ( value instanceof IBusModelSchemaRef ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"BusModelSchemaRefRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredOwnerTenant = null;
		requiredContainerSchema = null;
		optionalLookupRefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	@Override
	public IBusModelSchemaRef getSchemaRefRec() {
		return( (IBusModelSchemaRef)getRec() );
	}

	@Override
	public IBusModelScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		IBusModelSchemaRefObj lockobj;
		if( getIsNew() ) {
			lockobj = (IBusModelSchemaRefObj)this;
		}
		else {
			lockobj = ((IBusModelSchemaObj)getSchema()).getSchemaRefTableObj().lockSchemaRef( getPKey() );
		}
		edit = ((IBusModelSchemaObj)getSchema()).getSchemaRefTableObj().newEditInstance( lockobj );
		return( (IBusModelScopeEditObj)edit );
	}

	@Override
	public IBusModelSchemaRefEditObj getEditAsSchemaRef() {
		return( (IBusModelSchemaRefEditObj)edit );
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
	public IBusModelSchemaDefObj getRequiredContainerSchema() {
		return( getRequiredContainerSchema( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getRequiredContainerSchema( boolean forceRead ) {
		if( ( requiredContainerSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerSchema = ((IBusModelSchemaObj)getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getSchemaRefRec().getRequiredSchemaId(), forceRead );
			}
		}
		return( requiredContainerSchema );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupRefSchema() {
		return( getOptionalLookupRefSchema( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupRefSchema( boolean forceRead ) {
		if( ( optionalLookupRefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getSchemaRefRec().getOptionalRefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupRefSchema = ((IBusModelSchemaObj)getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getSchemaRefRec().getOptionalRefSchemaId(), forceRead );
			}
		}
		return( optionalLookupRefSchema );
	}

	@Override
	public IBusModelSchemaRefObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	@Override
	public IBusModelSchemaRefObj getOptionalLookupPrev( boolean forceRead ) {
		if( ( optionalLookupPrev == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getSchemaRefRec().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrev = ((IBusModelSchemaObj)getSchema()).getSchemaRefTableObj().readSchemaRefByIdIdx( getSchemaRefRec().getOptionalPrevId(), forceRead );
			}
		}
		return( optionalLookupPrev );
	}

	@Override
	public IBusModelSchemaRefObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	@Override
	public IBusModelSchemaRefObj getOptionalLookupNext( boolean forceRead ) {
		if( ( optionalLookupNext == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getSchemaRefRec().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupNext = ((IBusModelSchemaObj)getSchema()).getSchemaRefTableObj().readSchemaRefByIdIdx( getSchemaRefRec().getOptionalNextId(), forceRead );
			}
		}
		return( optionalLookupNext );
	}

	@Override
	public IYCFKeyHash256 getRequiredSchemaId() {
		return( getSchemaRefRec().getRequiredSchemaId() );
	}

	@Override
	public String getRequiredName() {
		return( getSchemaRefRec().getRequiredName() );
	}

	@Override
	public String getRequiredRefModelName() {
		return( getSchemaRefRec().getRequiredRefModelName() );
	}

	@Override
	public String getRequiredIncludeRoot() {
		return( getSchemaRefRec().getRequiredIncludeRoot() );
	}

	@Override
	public IYCFKeyHash256 getOptionalRefSchemaId() {
		return( getSchemaRefRec().getOptionalRefSchemaId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalPrevId() {
		return( getSchemaRefRec().getOptionalPrevId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalNextId() {
		return( getSchemaRefRec().getOptionalNextId() );
	}
}
