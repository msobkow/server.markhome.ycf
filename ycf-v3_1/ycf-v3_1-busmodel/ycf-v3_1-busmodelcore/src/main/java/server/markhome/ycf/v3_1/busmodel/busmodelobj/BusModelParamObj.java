// Description: Java 25 base object instance implementation for Param

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

public class BusModelParamObj
	implements IBusModelParamObj
{
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected boolean isNew;
	protected IBusModelParamEditObj edit;
	protected IBusModelSchemaObj schema;
	protected $implCommaIJavaOptAtomType$ pKey;
	protected IBusModelParam rec;
	protected IBusModelServerMethodObj requiredContainerServerMeth;
	protected IBusModelSchemaDefObj optionalLookupDefSchema;
	protected IBusModelParamObj optionalLookupPrev;
	protected IBusModelParamObj optionalLookupNext;
	protected IBusModelValueObj requiredLookupType;

	public BusModelParamObj() {
		isNew = true;
		requiredContainerServerMeth = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupType = null;
	}

	public BusModelParamObj( IBusModelSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerServerMeth = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupType = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)schema).getParamTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "Param" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelServerMethodObj scope = getRequiredContainerServerMeth();
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
	public IBusModelParamObj realise() {
		IBusModelParamObj retobj = ((IBusModelSchemaObj)getSchema()).getParamTableObj().realiseParam(
			(IBusModelParamObj)this );
		return( (IBusModelParamObj)retobj );
	}

	@Override
	public void forget() {
		((IBusModelSchemaObj)getSchema()).getParamTableObj().reallyDeepDisposeParam( (IBusModelParamObj)this );
	}

	@Override
	public IBusModelParamObj read() {
		IBusModelParamObj retobj = ((IBusModelSchemaObj)getSchema()).getParamTableObj().readParamByIdIdx( getPKey(), false );
		return( (IBusModelParamObj)retobj );
	}

	@Override
	public IBusModelParamObj read( boolean forceRead ) {
		IBusModelParamObj retobj = ((IBusModelSchemaObj)getSchema()).getParamTableObj().readParamByIdIdx( getPKey(), forceRead );
		return( (IBusModelParamObj)retobj );
	}

	@Override
	public IBusModelParamObj moveUp() {
		IBusModelParamObj retobj = ((IBusModelSchemaObj)getSchema()).getParamTableObj().moveUpParam( this );
		return( (IBusModelParamObj)retobj );
	}

	@Override
	public IBusModelParamObj moveDown() {
		IBusModelParamObj retobj = ((IBusModelSchemaObj)getSchema()).getParamTableObj().moveDownParam( this );
		return( (IBusModelParamObj)retobj );
	}

	@Override
	public IBusModelParamTableObj getParamTable() {
		return( ((IBusModelSchemaObj)getSchema()).getParamTableObj() );
	}

	@Override
	public IBusModelSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( IBusModelSchemaObj value ) {
		schema = value;
	}

	@Override
	public IBusModelParam getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryParam().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getBusModelBackingStore().getTableParam().readDerivedByIdIdx( ((IBusModelSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelParam value ) {
		if( ! ( ( value == null ) || ! ( value instanceof IBusModelParam ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"BusModelParamRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredContainerServerMeth = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupType = null;
	}

	@Override
	public IBusModelParam getParamRec() {
		return( (IBusModelParam)getRec() );
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
	public IBusModelParamEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		IBusModelParamObj lockobj;
		if( getIsNew() ) {
			lockobj = (IBusModelParamObj)this;
		}
		else {
			lockobj = ((IBusModelSchemaObj)getSchema()).getParamTableObj().lockParam( getPKey() );
		}
		edit = ((IBusModelSchemaObj)getSchema()).getParamTableObj().newEditInstance( lockobj );
		return( (IBusModelParamEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public IBusModelParamEditObj getEdit() {
		return( edit );
	}

	@Override
	public IBusModelParamEditObj getEditAsParam() {
		return( (IBusModelParamEditObj)edit );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			IBusModelParam rec = getRec();
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
			IBusModelParam rec = getRec();
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
	public IBusModelServerMethodObj getRequiredContainerServerMeth() {
		return( getRequiredContainerServerMeth( false ) );
	}

	@Override
	public IBusModelServerMethodObj getRequiredContainerServerMeth( boolean forceRead ) {
		if( ( requiredContainerServerMeth == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerServerMeth = ((IBusModelSchemaObj)getSchema()).getServerMethodTableObj().readServerMethodByIdIdx( getParamRec().getRequiredServerMethodId(), forceRead );
			}
		}
		return( requiredContainerServerMeth );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( ( optionalLookupDefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getParamRec().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefSchema = ((IBusModelSchemaObj)getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getParamRec().getOptionalDefSchemaId(), forceRead );
			}
		}
		return( optionalLookupDefSchema );
	}

	@Override
	public IBusModelParamObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	@Override
	public IBusModelParamObj getOptionalLookupPrev( boolean forceRead ) {
		if( ( optionalLookupPrev == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getParamRec().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrev = ((IBusModelSchemaObj)getSchema()).getParamTableObj().readParamByIdIdx( getParamRec().getOptionalPrevId(), forceRead );
			}
		}
		return( optionalLookupPrev );
	}

	@Override
	public IBusModelParamObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	@Override
	public IBusModelParamObj getOptionalLookupNext( boolean forceRead ) {
		if( ( optionalLookupNext == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getParamRec().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupNext = ((IBusModelSchemaObj)getSchema()).getParamTableObj().readParamByIdIdx( getParamRec().getOptionalNextId(), forceRead );
			}
		}
		return( optionalLookupNext );
	}

	@Override
	public IBusModelValueObj getRequiredLookupType() {
		return( getRequiredLookupType( false ) );
	}

	@Override
	public IBusModelValueObj getRequiredLookupType( boolean forceRead ) {
		if( ( requiredLookupType == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getParamRec().getOptionalTypeId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				requiredLookupType = ((IBusModelSchemaObj)getSchema()).getValueTableObj().readValueByIdIdx( getParamRec().getOptionalTypeId(), forceRead );
			}
		}
		return( requiredLookupType );
	}

	@Override
	public IYCFKeyHash256 getRequiredServerMethodId() {
		return( getParamRec().getRequiredServerMethodId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalDefSchemaId() {
		return( getParamRec().getOptionalDefSchemaId() );
	}

	@Override
	public String getRequiredName() {
		return( getParamRec().getRequiredName() );
	}

	@Override
	public String getOptionalShortDescription() {
		return( getParamRec().getOptionalShortDescription() );
	}

	@Override
	public String getOptionalDescription() {
		return( getParamRec().getOptionalDescription() );
	}

	@Override
	public boolean getRequiredIsNullable() {
		return( getParamRec().getRequiredIsNullable() );
	}

	@Override
	public IYCFKeyHash256 getOptionalTypeId() {
		return( getParamRec().getOptionalTypeId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalPrevId() {
		return( getParamRec().getOptionalPrevId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalNextId() {
		return( getParamRec().getOptionalNextId() );
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
