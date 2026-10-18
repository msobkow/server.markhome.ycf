// Description: Java 25 edit object instance implementation for BusModel Tweak.

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

public class BusModelTweakEditObj
	implements IBusModelTweakEditObj
{
	protected IBusModelTweakObj orig;
	protected IBusModelTweak rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected IBusModelScopeObj requiredContainerScopeDef;
	protected IBusModelSchemaDefObj optionalLookupDefSchema;

	public BusModelTweakEditObj( IBusModelTweakObj argOrig ) {
		orig = argOrig;
		getRec();
		IBusModelTweak origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerScopeDef = null;
		optionalLookupDefSchema = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			IBusModelTweak rec = getRec();
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
			IBusModelTweak rec = getRec();
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
		return( ((IBusModelSchemaObj)orig.getSchema()).getTweakTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "Tweak" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelScopeObj scope = getRequiredContainerScopeDef();
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
	public IBusModelTweakObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		IBusModelTweakObj retobj = getSchema().getTweakTableObj().realiseTweak( (IBusModelTweakObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsTweak().forget();
	}

	@Override
	public IBusModelTweakObj read() {
		IBusModelTweakObj retval = getOrigAsTweak().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IBusModelTweakObj read( boolean forceRead ) {
		IBusModelTweakObj retval = getOrigAsTweak().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IBusModelTweakObj create() {
		copyRecToOrig();
		IBusModelTweakObj retobj = ((IBusModelSchemaObj)getOrigAsTweak().getSchema()).getTweakTableObj().createTweak( getOrigAsTweak() );
		if( retobj == getOrigAsTweak() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelTweakEditObj update() {
		getSchema().getTweakTableObj().updateTweak( (IBusModelTweakObj)this );
		return( null );
	}

	@Override
	public BusModelTweakEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getTweakTableObj().deleteTweak( getOrigAsTweak() );
		return( null );
	}

	@Override
	public IBusModelTweakTableObj getTweakTable() {
		return( orig.getSchema().getTweakTableObj() );
	}

	@Override
	public IBusModelTweakEditObj getEdit() {
		return( (IBusModelTweakEditObj)this );
	}

	@Override
	public IBusModelTweakEditObj getEditAsTweak() {
		return( (IBusModelTweakEditObj)this );
	}

	@Override
	public IBusModelTweakEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public IBusModelTweakObj getOrig() {
		return( orig );
	}

	@Override
	public IBusModelTweakObj getOrigAsTweak() {
		return( (IBusModelTweakObj)orig );
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
	public IBusModelTweak getRec() {
		if( rec == null ) {
			rec = getOrigAsTweak().getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryTweak().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelTweak value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerScopeDef = null;
			optionalLookupDefSchema = null;
		}
	}

	@Override
	public IBusModelTweak getTweakRec() {
		return( (IBusModelTweak)getRec() );
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
	public IYCFKeyHash256 getRequiredTenantId() {
		return( getTweakRec().getRequiredTenantId() );
	}

	@Override
	public void setRequiredTenantId( IYCFKeyHash256 value ) {
		if( getTweakRec().getRequiredTenantId() != value ) {
			getTweakRec().setRequiredTenantId( value );
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredScopeId() {
		return( getTweakRec().getRequiredScopeId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalDefSchemaTenantId() {
		return( getTweakRec().getOptionalDefSchemaTenantId() );
	}

	@Override
	public void setOptionalDefSchemaTenantId( IYCFKeyHash256 value ) {
		if( getTweakRec().getOptionalDefSchemaTenantId() != value ) {
			getTweakRec().setOptionalDefSchemaTenantId( value );
		}
	}

	@Override
	public IYCFKeyHash256 getOptionalDefSchemaId() {
		return( getTweakRec().getOptionalDefSchemaId() );
	}

	@Override
	public String getRequiredName() {
		return( getTweakRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getTweakRec().getRequiredName() != value ) {
			getTweakRec().setRequiredName( value );
		}
	}

	@Override
	public boolean getRequiredReplacesInherited() {
		return( getTweakRec().getRequiredReplacesInherited() );
	}

	@Override
	public void setRequiredReplacesInherited( boolean value ) {
		if( getTweakRec().getRequiredReplacesInherited() != value ) {
			getTweakRec().setRequiredReplacesInherited( value );
		}
	}

	@Override
	public String getRequiredTweakGelText() {
		return( getTweakRec().getRequiredTweakGelText() );
	}

	@Override
	public void setRequiredTweakGelText( String value ) {
		if( getTweakRec().getRequiredTweakGelText() != value ) {
			getTweakRec().setRequiredTweakGelText( value );
		}
	}

	@Override
	public IBusModelScopeObj getRequiredContainerScopeDef() {
		return( getRequiredContainerScopeDef( false ) );
	}

	@Override
	public IBusModelScopeObj getRequiredContainerScopeDef( boolean forceRead ) {
		if( forceRead || ( requiredContainerScopeDef == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelScopeObj obj = ((IBusModelSchemaObj)getOrigAsTweak().getSchema()).getScopeTableObj().readScopeByIdIdx( getTweakRec().getRequiredScopeId() );
				requiredContainerScopeDef = obj;
				if( obj != null ) {
					requiredContainerScopeDef = obj;
				}
			}
		}
		return( requiredContainerScopeDef );
	}

	@Override
	public void setRequiredContainerScopeDef( IBusModelScopeObj value ) {
		if( rec == null ) {
			getTweakRec();
		}
		if( value != null ) {
			requiredContainerScopeDef = value;
			getTweakRec().setRequiredContainerScopeDef(value.getScopeRec());
		}
		requiredContainerScopeDef = value;
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getTweakRec().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelSchemaDefObj obj = ((IBusModelSchemaObj)getOrigAsTweak().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getTweakRec().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	@Override
	public void setOptionalLookupDefSchema( IBusModelSchemaDefObj value ) {
		if( rec == null ) {
			getTweakRec();
		}
		if( value != null ) {
			optionalLookupDefSchema = value;
			getTweakRec().setOptionalLookupDefSchema(value.getSchemaDefRec());
		}
		else {
			optionalLookupDefSchema = null;
			getTweakRec().setOptionalLookupDefSchema((IBusModelSchemaDef)null);
		}
		optionalLookupDefSchema = value;
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
		IBusModelTweak origRec = getOrigAsTweak().getTweakRec();
		IBusModelTweak myRec = getTweakRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelTweak origRec = getOrigAsTweak().getTweakRec();
		IBusModelTweak myRec = getTweakRec();
		myRec.set( origRec );
	}
}
