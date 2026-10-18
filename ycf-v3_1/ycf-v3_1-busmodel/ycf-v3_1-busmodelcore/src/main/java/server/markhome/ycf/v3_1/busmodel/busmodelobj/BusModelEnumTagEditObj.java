// Description: Java 25 edit object instance implementation for BusModel EnumTag.

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

public class BusModelEnumTagEditObj
	implements IBusModelEnumTagEditObj
{
	protected IBusModelEnumTagObj orig;
	protected IBusModelEnumTag rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected IBusModelEnumDefObj requiredContainerEnumDef;
	protected IBusModelSchemaDefObj optionalLookupDefSchema;
	protected IBusModelEnumTagObj optionalLookupPrev;
	protected IBusModelEnumTagObj optionalLookupNext;

	public BusModelEnumTagEditObj( IBusModelEnumTagObj argOrig ) {
		orig = argOrig;
		getRec();
		IBusModelEnumTag origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerEnumDef = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			IBusModelEnumTag rec = getRec();
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
			IBusModelEnumTag rec = getRec();
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
		return( ((IBusModelSchemaObj)orig.getSchema()).getEnumTagTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "EnumTag" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelEnumDefObj scope = getRequiredContainerEnumDef();
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
	public IBusModelEnumTagObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		IBusModelEnumTagObj retobj = getSchema().getEnumTagTableObj().realiseEnumTag( (IBusModelEnumTagObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsEnumTag().forget();
	}

	@Override
	public IBusModelEnumTagObj read() {
		IBusModelEnumTagObj retval = getOrigAsEnumTag().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IBusModelEnumTagObj read( boolean forceRead ) {
		IBusModelEnumTagObj retval = getOrigAsEnumTag().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IBusModelEnumTagObj moveUp() {
		throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUp" );
	}

	@Override
	public IBusModelEnumTagObj moveDown() {
		throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDown" );
	}

	@Override
	public IBusModelEnumTagObj create() {
		copyRecToOrig();
		IBusModelEnumTagObj retobj = ((IBusModelSchemaObj)getOrigAsEnumTag().getSchema()).getEnumTagTableObj().createEnumTag( getOrigAsEnumTag() );
		if( retobj == getOrigAsEnumTag() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelEnumTagEditObj update() {
		getSchema().getEnumTagTableObj().updateEnumTag( (IBusModelEnumTagObj)this );
		return( null );
	}

	@Override
	public BusModelEnumTagEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getEnumTagTableObj().deleteEnumTag( getOrigAsEnumTag() );
		return( null );
	}

	@Override
	public IBusModelEnumTagTableObj getEnumTagTable() {
		return( orig.getSchema().getEnumTagTableObj() );
	}

	@Override
	public IBusModelEnumTagEditObj getEdit() {
		return( (IBusModelEnumTagEditObj)this );
	}

	@Override
	public IBusModelEnumTagEditObj getEditAsEnumTag() {
		return( (IBusModelEnumTagEditObj)this );
	}

	@Override
	public IBusModelEnumTagEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public IBusModelEnumTagObj getOrig() {
		return( orig );
	}

	@Override
	public IBusModelEnumTagObj getOrigAsEnumTag() {
		return( (IBusModelEnumTagObj)orig );
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
	public IBusModelEnumTag getRec() {
		if( rec == null ) {
			rec = getOrigAsEnumTag().getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryEnumTag().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelEnumTag value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerEnumDef = null;
			optionalLookupDefSchema = null;
			optionalLookupPrev = null;
			optionalLookupNext = null;
		}
	}

	@Override
	public IBusModelEnumTag getEnumTagRec() {
		return( (IBusModelEnumTag)getRec() );
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
	public IYCFKeyHash256 getOptionalDefSchemaId() {
		return( getEnumTagRec().getOptionalDefSchemaId() );
	}

	@Override
	public IYCFKeyHash256 getRequiredEnumId() {
		return( getEnumTagRec().getRequiredEnumId() );
	}

	@Override
	public Short getOptionalEnumCode() {
		return( getEnumTagRec().getOptionalEnumCode() );
	}

	@Override
	public void setOptionalEnumCode( Short value ) {
		if( getEnumTagRec().getOptionalEnumCode() != value ) {
			getEnumTagRec().setOptionalEnumCode( value );
		}
	}

	@Override
	public String getRequiredName() {
		return( getEnumTagRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getEnumTagRec().getRequiredName() != value ) {
			getEnumTagRec().setRequiredName( value );
		}
	}

	@Override
	public IYCFKeyHash256 getOptionalPrevId() {
		return( getEnumTagRec().getOptionalPrevId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalNextId() {
		return( getEnumTagRec().getOptionalNextId() );
	}

	@Override
	public IBusModelEnumDefObj getRequiredContainerEnumDef() {
		return( getRequiredContainerEnumDef( false ) );
	}

	@Override
	public IBusModelEnumDefObj getRequiredContainerEnumDef( boolean forceRead ) {
		if( forceRead || ( requiredContainerEnumDef == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelEnumDefObj obj = ((IBusModelSchemaObj)getOrigAsEnumTag().getSchema()).getEnumDefTableObj().readEnumDefByIdIdx( getEnumTagRec().getRequiredEnumId() );
				requiredContainerEnumDef = obj;
				if( obj != null ) {
					requiredContainerEnumDef = obj;
				}
			}
		}
		return( requiredContainerEnumDef );
	}

	@Override
	public void setRequiredContainerEnumDef( IBusModelEnumDefObj value ) {
		if( rec == null ) {
			getEnumTagRec();
		}
		if( value != null ) {
			requiredContainerEnumDef = value;
			getEnumTagRec().setRequiredContainerEnumDef(value.getEnumDefRec());
		}
		requiredContainerEnumDef = value;
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getEnumTagRec().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelSchemaDefObj obj = ((IBusModelSchemaObj)getOrigAsEnumTag().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getEnumTagRec().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	@Override
	public void setOptionalLookupDefSchema( IBusModelSchemaDefObj value ) {
		if( rec == null ) {
			getEnumTagRec();
		}
		if( value != null ) {
			optionalLookupDefSchema = value;
			getEnumTagRec().setOptionalLookupDefSchema(value.getSchemaDefRec());
		}
		else {
			optionalLookupDefSchema = null;
			getEnumTagRec().setOptionalLookupDefSchema((IBusModelSchemaDef)null);
		}
		optionalLookupDefSchema = value;
	}

	@Override
	public IBusModelEnumTagObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	@Override
	public IBusModelEnumTagObj getOptionalLookupPrev( boolean forceRead ) {
		if( forceRead || ( optionalLookupPrev == null ) ) {
			boolean anyMissing = false;
			if( getEnumTagRec().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelEnumTagObj obj = ((IBusModelSchemaObj)getOrigAsEnumTag().getSchema()).getEnumTagTableObj().readEnumTagByIdIdx( getEnumTagRec().getOptionalPrevId() );
				optionalLookupPrev = obj;
			}
		}
		return( optionalLookupPrev );
	}

	@Override
	public void setOptionalLookupPrev( IBusModelEnumTagObj value ) {
		if( rec == null ) {
			getEnumTagRec();
		}
		if( value != null ) {
			optionalLookupPrev = value;
			getEnumTagRec().setOptionalLookupPrev(value.getEnumTagRec());
		}
		else {
			optionalLookupPrev = null;
			getEnumTagRec().setOptionalLookupPrev((IBusModelEnumTag)null);
		}
		optionalLookupPrev = value;
	}

	@Override
	public IBusModelEnumTagObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	@Override
	public IBusModelEnumTagObj getOptionalLookupNext( boolean forceRead ) {
		if( forceRead || ( optionalLookupNext == null ) ) {
			boolean anyMissing = false;
			if( getEnumTagRec().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelEnumTagObj obj = ((IBusModelSchemaObj)getOrigAsEnumTag().getSchema()).getEnumTagTableObj().readEnumTagByIdIdx( getEnumTagRec().getOptionalNextId() );
				optionalLookupNext = obj;
			}
		}
		return( optionalLookupNext );
	}

	@Override
	public void setOptionalLookupNext( IBusModelEnumTagObj value ) {
		if( rec == null ) {
			getEnumTagRec();
		}
		if( value != null ) {
			optionalLookupNext = value;
			getEnumTagRec().setOptionalLookupNext(value.getEnumTagRec());
		}
		else {
			optionalLookupNext = null;
			getEnumTagRec().setOptionalLookupNext((IBusModelEnumTag)null);
		}
		optionalLookupNext = value;
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
		IBusModelEnumTag origRec = getOrigAsEnumTag().getEnumTagRec();
		IBusModelEnumTag myRec = getEnumTagRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelEnumTag origRec = getOrigAsEnumTag().getEnumTagRec();
		IBusModelEnumTag myRec = getEnumTagRec();
		myRec.set( origRec );
	}
}
