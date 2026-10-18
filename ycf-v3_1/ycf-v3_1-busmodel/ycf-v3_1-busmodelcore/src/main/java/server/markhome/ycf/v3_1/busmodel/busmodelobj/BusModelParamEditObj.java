// Description: Java 25 edit object instance implementation for BusModel Param.

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

public class BusModelParamEditObj
	implements IBusModelParamEditObj
{
	protected IBusModelParamObj orig;
	protected IBusModelParam rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected IBusModelServerMethodObj requiredContainerServerMeth;
	protected IBusModelSchemaDefObj optionalLookupDefSchema;
	protected IBusModelParamObj optionalLookupPrev;
	protected IBusModelParamObj optionalLookupNext;
	protected IBusModelValueObj requiredLookupType;

	public BusModelParamEditObj( IBusModelParamObj argOrig ) {
		orig = argOrig;
		getRec();
		IBusModelParam origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerServerMeth = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupType = null;
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
	public void setCreatedBy( ISecureSecUserObj value ) {
		createdBy = value;
		if( value != null ) {
			getRec().setCreatedByUserId( value.getRequiredSecUserId() );
		}
	}

	@Override
	public void setCreatedAt( LocalDateTime value ) {
		getRec().setCreatedAt( value );
	}

	@Override
	public void setUpdatedBy( ISecureSecUserObj value ) {
		updatedBy = value;
		if( value != null ) {
			getRec().setUpdatedByUserId( value.getRequiredSecUserId() );
		}
	}

	@Override
	public void setUpdatedAt( LocalDateTime value ) {
		getRec().setUpdatedAt( value );
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)orig.getSchema()).getParamTableObj().getClassCode() );
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
		// We realise this so that it's record will get copied to orig during realization
		IBusModelParamObj retobj = getSchema().getParamTableObj().realiseParam( (IBusModelParamObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsParam().forget();
	}

	@Override
	public IBusModelParamObj read() {
		IBusModelParamObj retval = getOrigAsParam().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IBusModelParamObj read( boolean forceRead ) {
		IBusModelParamObj retval = getOrigAsParam().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IBusModelParamObj moveUp() {
		throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUp" );
	}

	@Override
	public IBusModelParamObj moveDown() {
		throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDown" );
	}

	@Override
	public IBusModelParamObj create() {
		copyRecToOrig();
		IBusModelParamObj retobj = ((IBusModelSchemaObj)getOrigAsParam().getSchema()).getParamTableObj().createParam( getOrigAsParam() );
		if( retobj == getOrigAsParam() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelParamEditObj update() {
		getSchema().getParamTableObj().updateParam( (IBusModelParamObj)this );
		return( null );
	}

	@Override
	public BusModelParamEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getParamTableObj().deleteParam( getOrigAsParam() );
		return( null );
	}

	@Override
	public IBusModelParamTableObj getParamTable() {
		return( orig.getSchema().getParamTableObj() );
	}

	@Override
	public IBusModelParamEditObj getEdit() {
		return( (IBusModelParamEditObj)this );
	}

	@Override
	public IBusModelParamEditObj getEditAsParam() {
		return( (IBusModelParamEditObj)this );
	}

	@Override
	public IBusModelParamEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public IBusModelParamObj getOrig() {
		return( orig );
	}

	@Override
	public IBusModelParamObj getOrigAsParam() {
		return( (IBusModelParamObj)orig );
	}

	@Override
	public IBusModelSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	@Override
	public void setSchema( IBusModelSchemaObj value ) {
		orig.setSchema(value);
	}

	@Override
	public IBusModelParam getRec() {
		if( rec == null ) {
			rec = getOrigAsParam().getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryParam().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelParam value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerServerMeth = null;
			optionalLookupDefSchema = null;
			optionalLookupPrev = null;
			optionalLookupNext = null;
			requiredLookupType = null;
		}
	}

	@Override
	public IBusModelParam getParamRec() {
		return( (IBusModelParam)getRec() );
	}

	@Override
	public $implCommaIJavaOptAtomType$ getPKey() {
		return( orig.getPKey() );
	}

	@Override
	public void setPKey( $implCommaIJavaOptAtomType$ value ) {
		orig.setPKey( value );
		copyPKeyToRec();
	}

	@Override
	public boolean getIsNew() {
		return( orig.getIsNew() );
	}

	@Override
	public void setIsNew( boolean value ) {
		orig.setIsNew( value );
	}

	@Override
	public IYCFKeyHash256 getRequiredId() {
		return( getPKey() );
	}

	@Override
	public void setRequiredId(IYCFKeyHash256 value) {
		if (getPKey() != value) {
			setPKey(value);
		}
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
	public void setRequiredName( String value ) {
		if( getParamRec().getRequiredName() != value ) {
			getParamRec().setRequiredName( value );
		}
	}

	@Override
	public String getOptionalShortDescription() {
		return( getParamRec().getOptionalShortDescription() );
	}

	@Override
	public void setOptionalShortDescription( String value ) {
		if( getParamRec().getOptionalShortDescription() != value ) {
			getParamRec().setOptionalShortDescription( value );
		}
	}

	@Override
	public String getOptionalDescription() {
		return( getParamRec().getOptionalDescription() );
	}

	@Override
	public void setOptionalDescription( String value ) {
		if( getParamRec().getOptionalDescription() != value ) {
			getParamRec().setOptionalDescription( value );
		}
	}

	@Override
	public boolean getRequiredIsNullable() {
		return( getParamRec().getRequiredIsNullable() );
	}

	@Override
	public void setRequiredIsNullable( boolean value ) {
		if( getParamRec().getRequiredIsNullable() != value ) {
			getParamRec().setRequiredIsNullable( value );
		}
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
	public IBusModelServerMethodObj getRequiredContainerServerMeth() {
		return( getRequiredContainerServerMeth( false ) );
	}

	@Override
	public IBusModelServerMethodObj getRequiredContainerServerMeth( boolean forceRead ) {
		if( forceRead || ( requiredContainerServerMeth == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelServerMethodObj obj = ((IBusModelSchemaObj)getOrigAsParam().getSchema()).getServerMethodTableObj().readServerMethodByIdIdx( getParamRec().getRequiredServerMethodId() );
				requiredContainerServerMeth = obj;
				if( obj != null ) {
					requiredContainerServerMeth = obj;
				}
			}
		}
		return( requiredContainerServerMeth );
	}

	@Override
	public void setRequiredContainerServerMeth( IBusModelServerMethodObj value ) {
		if( rec == null ) {
			getParamRec();
		}
		if( value != null ) {
			requiredContainerServerMeth = value;
			getParamRec().setRequiredContainerServerMeth(value.getServerMethodRec());
		}
		requiredContainerServerMeth = value;
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getParamRec().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelSchemaDefObj obj = ((IBusModelSchemaObj)getOrigAsParam().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getParamRec().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	@Override
	public void setOptionalLookupDefSchema( IBusModelSchemaDefObj value ) {
		if( rec == null ) {
			getParamRec();
		}
		if( value != null ) {
			optionalLookupDefSchema = value;
			getParamRec().setOptionalLookupDefSchema(value.getSchemaDefRec());
		}
		else {
			optionalLookupDefSchema = null;
			getParamRec().setOptionalLookupDefSchema((IBusModelSchemaDef)null);
		}
		optionalLookupDefSchema = value;
	}

	@Override
	public IBusModelParamObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	@Override
	public IBusModelParamObj getOptionalLookupPrev( boolean forceRead ) {
		if( forceRead || ( optionalLookupPrev == null ) ) {
			boolean anyMissing = false;
			if( getParamRec().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelParamObj obj = ((IBusModelSchemaObj)getOrigAsParam().getSchema()).getParamTableObj().readParamByIdIdx( getParamRec().getOptionalPrevId() );
				optionalLookupPrev = obj;
			}
		}
		return( optionalLookupPrev );
	}

	@Override
	public void setOptionalLookupPrev( IBusModelParamObj value ) {
		if( rec == null ) {
			getParamRec();
		}
		if( value != null ) {
			optionalLookupPrev = value;
			getParamRec().setOptionalLookupPrev(value.getParamRec());
		}
		else {
			optionalLookupPrev = null;
			getParamRec().setOptionalLookupPrev((IBusModelParam)null);
		}
		optionalLookupPrev = value;
	}

	@Override
	public IBusModelParamObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	@Override
	public IBusModelParamObj getOptionalLookupNext( boolean forceRead ) {
		if( forceRead || ( optionalLookupNext == null ) ) {
			boolean anyMissing = false;
			if( getParamRec().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelParamObj obj = ((IBusModelSchemaObj)getOrigAsParam().getSchema()).getParamTableObj().readParamByIdIdx( getParamRec().getOptionalNextId() );
				optionalLookupNext = obj;
			}
		}
		return( optionalLookupNext );
	}

	@Override
	public void setOptionalLookupNext( IBusModelParamObj value ) {
		if( rec == null ) {
			getParamRec();
		}
		if( value != null ) {
			optionalLookupNext = value;
			getParamRec().setOptionalLookupNext(value.getParamRec());
		}
		else {
			optionalLookupNext = null;
			getParamRec().setOptionalLookupNext((IBusModelParam)null);
		}
		optionalLookupNext = value;
	}

	@Override
	public IBusModelValueObj getRequiredLookupType() {
		return( getRequiredLookupType( false ) );
	}

	@Override
	public IBusModelValueObj getRequiredLookupType( boolean forceRead ) {
		if( forceRead || ( requiredLookupType == null ) ) {
			boolean anyMissing = false;
			if( getParamRec().getOptionalTypeId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelValueObj obj = ((IBusModelSchemaObj)getOrigAsParam().getSchema()).getValueTableObj().readValueByIdIdx( getParamRec().getOptionalTypeId() );
				requiredLookupType = obj;
			}
		}
		return( requiredLookupType );
	}

	@Override
	public void setRequiredLookupType( IBusModelValueObj value ) {
		if( rec == null ) {
			getParamRec();
		}
		if( value != null ) {
			requiredLookupType = value;
			getParamRec().setRequiredLookupType(value.getValueRec());
		}
		else {
			requiredLookupType = null;
			getParamRec().setRequiredLookupType((IBusModelValue)null);
		}
		requiredLookupType = value;
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			if (getPKey() != rec.getPKey()) {
				rec.setPKey(getPKey());
			}
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

	@Override
	public void copyRecToOrig() {
		IBusModelParam origRec = getOrigAsParam().getParamRec();
		IBusModelParam myRec = getParamRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelParam origRec = getOrigAsParam().getParamRec();
		IBusModelParam myRec = getParamRec();
		myRec.set( origRec );
	}
}
