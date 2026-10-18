// Description: Java 25 base object instance implementation for ServerMethod

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

public class BusModelServerMethodObj
	extends BusModelScopeObj
	implements IBusModelServerMethodObj
{
	protected IBusModelSchemaDefObj optionalLookupDefSchema;
	protected IBusModelTableObj requiredContainerForTable;
	protected List<IBusModelParamObj> optionalComponentsParams;

	public BusModelServerMethodObj() {
		super();
		optionalLookupDefSchema = null;
		requiredContainerForTable = null;
	}

	public BusModelServerMethodObj( IBusModelSchemaObj argSchema ) {
		super( argSchema );
		optionalLookupDefSchema = null;
		requiredContainerForTable = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)schema).getServerMethodTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "ServerMethod" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelTableObj scope = getRequiredContainerForTable();
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
		IBusModelServerMethodObj retobj = ((IBusModelSchemaObj)getSchema()).getServerMethodTableObj().realiseServerMethod(
			(IBusModelServerMethodObj)this );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public void forget() {
		((IBusModelSchemaObj)getSchema()).getServerMethodTableObj().reallyDeepDisposeServerMethod( (IBusModelServerMethodObj)this );
	}

	@Override
	public IBusModelScopeObj read() {
		IBusModelServerMethodObj retobj = ((IBusModelSchemaObj)getSchema()).getServerMethodTableObj().readServerMethodByIdIdx( getPKey(), false );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public IBusModelScopeObj read( boolean forceRead ) {
		IBusModelServerMethodObj retobj = ((IBusModelSchemaObj)getSchema()).getServerMethodTableObj().readServerMethodByIdIdx( getPKey(), forceRead );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public IBusModelServerMethodTableObj getServerMethodTable() {
		return( ((IBusModelSchemaObj)getSchema()).getServerMethodTableObj() );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryServerMethod().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getBusModelBackingStore().getTableServerMethod().readDerivedByIdIdx( ((IBusModelSchemaObj)getSchema()).getAuthorization(),
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
		if( ! ( ( value == null ) || ! ( value instanceof IBusModelServerMethod ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"BusModelServerMethodRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredOwnerTenant = null;
		optionalLookupDefSchema = null;
		requiredContainerForTable = null;
	}

	@Override
	public IBusModelServerMethod getServerMethodRec() {
		return( (IBusModelServerMethod)getRec() );
	}

	@Override
	public IBusModelScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		IBusModelServerMethodObj lockobj;
		if( getIsNew() ) {
			lockobj = (IBusModelServerMethodObj)this;
		}
		else {
			lockobj = ((IBusModelSchemaObj)getSchema()).getServerMethodTableObj().lockServerMethod( getPKey() );
		}
		edit = ((IBusModelSchemaObj)getSchema()).getServerMethodTableObj().newEditInstance( lockobj );
		return( (IBusModelScopeEditObj)edit );
	}

	@Override
	public IBusModelServerMethodEditObj getEditAsServerMethod() {
		return( (IBusModelServerMethodEditObj)edit );
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
	public IBusModelSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( ( optionalLookupDefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getServerMethodRec().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefSchema = ((IBusModelSchemaObj)getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getServerMethodRec().getOptionalDefSchemaId(), forceRead );
			}
		}
		return( optionalLookupDefSchema );
	}

	@Override
	public IBusModelTableObj getRequiredContainerForTable() {
		return( getRequiredContainerForTable( false ) );
	}

	@Override
	public IBusModelTableObj getRequiredContainerForTable( boolean forceRead ) {
		if( ( requiredContainerForTable == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerForTable = ((IBusModelSchemaObj)getSchema()).getTableTableObj().readTableByIdIdx( getServerMethodRec().getRequiredTableId(), forceRead );
			}
		}
		return( requiredContainerForTable );
	}

	@Override
	public List<IBusModelParamObj> getOptionalComponentsParams() {
		List<IBusModelParamObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getParamTableObj().readParamByServerMethodIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelParamObj> getOptionalComponentsParams( boolean forceRead ) {
		List<IBusModelParamObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getParamTableObj().readParamByServerMethodIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public IYCFKeyHash256 getRequiredTableId() {
		return( getServerMethodRec().getRequiredTableId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalDefSchemaId() {
		return( getServerMethodRec().getOptionalDefSchemaId() );
	}

	@Override
	public String getRequiredName() {
		return( getServerMethodRec().getRequiredName() );
	}

	@Override
	public String getOptionalShortName() {
		return( getServerMethodRec().getOptionalShortName() );
	}

	@Override
	public String getOptionalLabel() {
		return( getServerMethodRec().getOptionalLabel() );
	}

	@Override
	public String getOptionalShortDescription() {
		return( getServerMethodRec().getOptionalShortDescription() );
	}

	@Override
	public String getOptionalDescription() {
		return( getServerMethodRec().getOptionalDescription() );
	}

	@Override
	public String getOptionalSuffix() {
		return( getServerMethodRec().getOptionalSuffix() );
	}

	@Override
	public boolean getRequiredIsInstanceMethod() {
		return( getServerMethodRec().getRequiredIsInstanceMethod() );
	}

	@Override
	public boolean getRequiredIsServerOnly() {
		return( getServerMethodRec().getRequiredIsServerOnly() );
	}

	@Override
	public IBusModelPubSchema.CodeVisibilityEnum getRequiredCodeVis() {
		return( getServerMethodRec().getRequiredCodeVis() );
	}

	@Override
	public String getRequiredJMethodBody() {
		return( getServerMethodRec().getRequiredJMethodBody() );
	}

	@Override
	public String getRequiredCppMethodBody() {
		return( getServerMethodRec().getRequiredCppMethodBody() );
	}

	@Override
	public String getRequiredCsMethodBody() {
		return( getServerMethodRec().getRequiredCsMethodBody() );
	}
}
