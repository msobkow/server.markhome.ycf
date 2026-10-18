// Description: Java 25 edit object instance implementation for BusModel DelDep.

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

public class BusModelDelDepEditObj
	extends BusModelScopeEditObj

	implements IBusModelDelDepEditObj
{
	protected IBusModelRelationObj requiredLookupRelation;
	protected IBusModelSchemaDefObj optionalLookupDefSchema;

	public BusModelDelDepEditObj( IBusModelDelDepObj argOrig ) {
		super( argOrig );
		requiredLookupRelation = null;
		optionalLookupDefSchema = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)orig.getSchema()).getDelDepTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "DelDep" );
	}

	@Override
	public String getObjName() {
		String objName;
		YCFDbKeyHash256 val = rec.getRequiredId();
		if (val != null) {
			objName = val.toString();
		}
		else {
			objName = "";
		}
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
		// We realise this so that it's record will get copied to orig during realization
		IBusModelDelDepObj retobj = getSchema().getDelDepTableObj().realiseDelDep( (IBusModelDelDepObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsDelDep().forget();
	}

	@Override
	public IBusModelScopeObj create() {
		copyRecToOrig();
		IBusModelDelDepObj retobj = ((IBusModelSchemaObj)getOrigAsDelDep().getSchema()).getDelDepTableObj().createDelDep( getOrigAsDelDep() );
		if( retobj == getOrigAsDelDep() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelScopeEditObj update() {
		getSchema().getDelDepTableObj().updateDelDep( (IBusModelDelDepObj)this );
		return( null );
	}

	@Override
	public BusModelScopeEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getDelDepTableObj().deleteDelDep( getOrigAsDelDep() );
		return( null );
	}

	@Override
	public IBusModelDelDepTableObj getDelDepTable() {
		return( orig.getSchema().getDelDepTableObj() );
	}

	@Override
	public IBusModelDelDepEditObj getEditAsDelDep() {
		return( (IBusModelDelDepEditObj)this );
	}

	@Override
	public IBusModelDelDepObj getOrigAsDelDep() {
		return( (IBusModelDelDepObj)orig );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			rec = getOrigAsDelDep().getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryDelDep().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelScope value ) {
		if( rec != value ) {
			super.setRec( value );
			requiredLookupRelation = null;
			optionalLookupDefSchema = null;
		}
	}

	@Override
	public IBusModelDelDep getDelDepRec() {
		return( (IBusModelDelDep)getRec() );
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
		return( getDelDepRec().getOptionalDefSchemaId() );
	}

	@Override
	public IYCFKeyHash256 getRequiredRelationId() {
		return( getDelDepRec().getRequiredRelationId() );
	}

	@Override
	public IBusModelRelationObj getRequiredLookupRelation() {
		return( getRequiredLookupRelation( false ) );
	}

	@Override
	public IBusModelRelationObj getRequiredLookupRelation( boolean forceRead ) {
		if( forceRead || ( requiredLookupRelation == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelRelationObj obj = ((IBusModelSchemaObj)getOrigAsDelDep().getSchema()).getRelationTableObj().readRelationByIdIdx( getDelDepRec().getRequiredRelationId() );
				requiredLookupRelation = obj;
			}
		}
		return( requiredLookupRelation );
	}

	@Override
	public void setRequiredLookupRelation( IBusModelRelationObj value ) {
		if( rec == null ) {
			getDelDepRec();
		}
		if( value != null ) {
			requiredLookupRelation = value;
			getDelDepRec().setRequiredLookupRelation(value.getRelationRec());
		}
		else {
			requiredLookupRelation = null;
			getDelDepRec().setRequiredLookupRelation((IBusModelRelation)null);
		}
		requiredLookupRelation = value;
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getDelDepRec().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelSchemaDefObj obj = ((IBusModelSchemaObj)getOrigAsDelDep().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getDelDepRec().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	@Override
	public void setOptionalLookupDefSchema( IBusModelSchemaDefObj value ) {
		if( rec == null ) {
			getDelDepRec();
		}
		if( value != null ) {
			optionalLookupDefSchema = value;
			getDelDepRec().setOptionalLookupDefSchema(value.getSchemaDefRec());
		}
		else {
			optionalLookupDefSchema = null;
			getDelDepRec().setOptionalLookupDefSchema((IBusModelSchemaDef)null);
		}
		optionalLookupDefSchema = value;
	}

	@Override
	public void copyRecToOrig() {
		IBusModelDelDep origRec = getOrigAsDelDep().getDelDepRec();
		IBusModelDelDep myRec = getDelDepRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelDelDep origRec = getOrigAsDelDep().getDelDepRec();
		IBusModelDelDep myRec = getDelDepRec();
		myRec.set( origRec );
	}
}
