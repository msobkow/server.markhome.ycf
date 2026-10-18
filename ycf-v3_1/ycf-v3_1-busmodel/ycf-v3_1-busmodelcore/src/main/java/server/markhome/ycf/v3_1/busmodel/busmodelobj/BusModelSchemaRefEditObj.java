// Description: Java 25 edit object instance implementation for BusModel SchemaRef.

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

public class BusModelSchemaRefEditObj
	extends BusModelScopeEditObj

	implements IBusModelSchemaRefEditObj
{
	protected IBusModelSchemaDefObj requiredContainerSchema;
	protected IBusModelSchemaDefObj optionalLookupRefSchema;
	protected IBusModelSchemaRefObj optionalLookupPrev;
	protected IBusModelSchemaRefObj optionalLookupNext;

	public BusModelSchemaRefEditObj( IBusModelSchemaRefObj argOrig ) {
		super( argOrig );
		requiredContainerSchema = null;
		optionalLookupRefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)orig.getSchema()).getSchemaRefTableObj().getClassCode() );
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
		// We realise this so that it's record will get copied to orig during realization
		IBusModelSchemaRefObj retobj = getSchema().getSchemaRefTableObj().realiseSchemaRef( (IBusModelSchemaRefObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSchemaRef().forget();
	}

	@Override
	public IBusModelSchemaRefObj moveUp() {
		throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUp" );
	}

	@Override
	public IBusModelSchemaRefObj moveDown() {
		throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDown" );
	}

	@Override
	public IBusModelScopeObj create() {
		copyRecToOrig();
		IBusModelSchemaRefObj retobj = ((IBusModelSchemaObj)getOrigAsSchemaRef().getSchema()).getSchemaRefTableObj().createSchemaRef( getOrigAsSchemaRef() );
		if( retobj == getOrigAsSchemaRef() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelScopeEditObj update() {
		getSchema().getSchemaRefTableObj().updateSchemaRef( (IBusModelSchemaRefObj)this );
		return( null );
	}

	@Override
	public BusModelScopeEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSchemaRefTableObj().deleteSchemaRef( getOrigAsSchemaRef() );
		return( null );
	}

	@Override
	public IBusModelSchemaRefTableObj getSchemaRefTable() {
		return( orig.getSchema().getSchemaRefTableObj() );
	}

	@Override
	public IBusModelSchemaRefEditObj getEditAsSchemaRef() {
		return( (IBusModelSchemaRefEditObj)this );
	}

	@Override
	public IBusModelSchemaRefObj getOrigAsSchemaRef() {
		return( (IBusModelSchemaRefObj)orig );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			rec = getOrigAsSchemaRef().getSchema().getBusModelBackingStore().getBusModelFactory().getFactorySchemaRef().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelScope value ) {
		if( rec != value ) {
			super.setRec( value );
			requiredContainerSchema = null;
			optionalLookupRefSchema = null;
			optionalLookupPrev = null;
			optionalLookupNext = null;
		}
	}

	@Override
	public IBusModelSchemaRef getSchemaRefRec() {
		return( (IBusModelSchemaRef)getRec() );
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
	public IYCFKeyHash256 getRequiredSchemaId() {
		return( getSchemaRefRec().getRequiredSchemaId() );
	}

	@Override
	public String getRequiredName() {
		return( getSchemaRefRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getSchemaRefRec().getRequiredName() != value ) {
			getSchemaRefRec().setRequiredName( value );
		}
	}

	@Override
	public String getRequiredRefModelName() {
		return( getSchemaRefRec().getRequiredRefModelName() );
	}

	@Override
	public void setRequiredRefModelName( String value ) {
		if( getSchemaRefRec().getRequiredRefModelName() != value ) {
			getSchemaRefRec().setRequiredRefModelName( value );
		}
	}

	@Override
	public String getRequiredIncludeRoot() {
		return( getSchemaRefRec().getRequiredIncludeRoot() );
	}

	@Override
	public void setRequiredIncludeRoot( String value ) {
		if( getSchemaRefRec().getRequiredIncludeRoot() != value ) {
			getSchemaRefRec().setRequiredIncludeRoot( value );
		}
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

	@Override
	public IBusModelSchemaDefObj getRequiredContainerSchema() {
		return( getRequiredContainerSchema( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getRequiredContainerSchema( boolean forceRead ) {
		if( forceRead || ( requiredContainerSchema == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelSchemaDefObj obj = ((IBusModelSchemaObj)getOrigAsSchemaRef().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getSchemaRefRec().getRequiredSchemaId() );
				requiredContainerSchema = obj;
				if( obj != null ) {
					requiredContainerSchema = obj;
				}
			}
		}
		return( requiredContainerSchema );
	}

	@Override
	public void setRequiredContainerSchema( IBusModelSchemaDefObj value ) {
		if( rec == null ) {
			getSchemaRefRec();
		}
		if( value != null ) {
			requiredContainerSchema = value;
			getSchemaRefRec().setRequiredContainerSchema(value.getSchemaDefRec());
		}
		requiredContainerSchema = value;
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupRefSchema() {
		return( getOptionalLookupRefSchema( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupRefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupRefSchema == null ) ) {
			boolean anyMissing = false;
			if( getSchemaRefRec().getOptionalRefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelSchemaDefObj obj = ((IBusModelSchemaObj)getOrigAsSchemaRef().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getSchemaRefRec().getOptionalRefSchemaId() );
				optionalLookupRefSchema = obj;
			}
		}
		return( optionalLookupRefSchema );
	}

	@Override
	public void setOptionalLookupRefSchema( IBusModelSchemaDefObj value ) {
		if( rec == null ) {
			getSchemaRefRec();
		}
		if( value != null ) {
			optionalLookupRefSchema = value;
			getSchemaRefRec().setOptionalLookupRefSchema(value.getSchemaDefRec());
		}
		else {
			optionalLookupRefSchema = null;
			getSchemaRefRec().setOptionalLookupRefSchema((IBusModelSchemaDef)null);
		}
		optionalLookupRefSchema = value;
	}

	@Override
	public IBusModelSchemaRefObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	@Override
	public IBusModelSchemaRefObj getOptionalLookupPrev( boolean forceRead ) {
		if( forceRead || ( optionalLookupPrev == null ) ) {
			boolean anyMissing = false;
			if( getSchemaRefRec().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelSchemaRefObj obj = ((IBusModelSchemaObj)getOrigAsSchemaRef().getSchema()).getSchemaRefTableObj().readSchemaRefByIdIdx( getSchemaRefRec().getOptionalPrevId() );
				optionalLookupPrev = obj;
			}
		}
		return( optionalLookupPrev );
	}

	@Override
	public void setOptionalLookupPrev( IBusModelSchemaRefObj value ) {
		if( rec == null ) {
			getSchemaRefRec();
		}
		if( value != null ) {
			optionalLookupPrev = value;
			getSchemaRefRec().setOptionalLookupPrev(value.getSchemaRefRec());
		}
		else {
			optionalLookupPrev = null;
			getSchemaRefRec().setOptionalLookupPrev((IBusModelSchemaRef)null);
		}
		optionalLookupPrev = value;
	}

	@Override
	public IBusModelSchemaRefObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	@Override
	public IBusModelSchemaRefObj getOptionalLookupNext( boolean forceRead ) {
		if( forceRead || ( optionalLookupNext == null ) ) {
			boolean anyMissing = false;
			if( getSchemaRefRec().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelSchemaRefObj obj = ((IBusModelSchemaObj)getOrigAsSchemaRef().getSchema()).getSchemaRefTableObj().readSchemaRefByIdIdx( getSchemaRefRec().getOptionalNextId() );
				optionalLookupNext = obj;
			}
		}
		return( optionalLookupNext );
	}

	@Override
	public void setOptionalLookupNext( IBusModelSchemaRefObj value ) {
		if( rec == null ) {
			getSchemaRefRec();
		}
		if( value != null ) {
			optionalLookupNext = value;
			getSchemaRefRec().setOptionalLookupNext(value.getSchemaRefRec());
		}
		else {
			optionalLookupNext = null;
			getSchemaRefRec().setOptionalLookupNext((IBusModelSchemaRef)null);
		}
		optionalLookupNext = value;
	}

	@Override
	public void copyRecToOrig() {
		IBusModelSchemaRef origRec = getOrigAsSchemaRef().getSchemaRefRec();
		IBusModelSchemaRef myRec = getSchemaRefRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelSchemaRef origRec = getOrigAsSchemaRef().getSchemaRefRec();
		IBusModelSchemaRef myRec = getSchemaRefRec();
		myRec.set( origRec );
	}
}
