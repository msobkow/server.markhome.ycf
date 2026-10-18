// Description: Java 25 base object instance implementation for PopSubDep2

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

public class BusModelPopSubDep2Obj
	extends BusModelPopDepObj
	implements IBusModelPopSubDep2Obj
{
	protected IBusModelPopSubDep1Obj requiredContainerPopSubDep1;
	protected List<IBusModelPopSubDep3Obj> optionalComponentsPopDep;

	public BusModelPopSubDep2Obj() {
		super();
		requiredContainerPopSubDep1 = null;
	}

	public BusModelPopSubDep2Obj( IBusModelSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerPopSubDep1 = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)schema).getPopSubDep2TableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "PopSubDep2" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelPopSubDep1Obj scope = getRequiredContainerPopSubDep1();
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
		IBusModelPopSubDep2Obj retobj = ((IBusModelSchemaObj)getSchema()).getPopSubDep2TableObj().realisePopSubDep2(
			(IBusModelPopSubDep2Obj)this );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public void forget() {
		((IBusModelSchemaObj)getSchema()).getPopSubDep2TableObj().reallyDeepDisposePopSubDep2( (IBusModelPopSubDep2Obj)this );
	}

	@Override
	public IBusModelScopeObj read() {
		IBusModelPopSubDep2Obj retobj = ((IBusModelSchemaObj)getSchema()).getPopSubDep2TableObj().readPopSubDep2ByIdIdx( getPKey(), false );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public IBusModelScopeObj read( boolean forceRead ) {
		IBusModelPopSubDep2Obj retobj = ((IBusModelSchemaObj)getSchema()).getPopSubDep2TableObj().readPopSubDep2ByIdIdx( getPKey(), forceRead );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public IBusModelPopSubDep2TableObj getPopSubDep2Table() {
		return( ((IBusModelSchemaObj)getSchema()).getPopSubDep2TableObj() );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryPopSubDep2().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getBusModelBackingStore().getTablePopSubDep2().readDerivedByIdIdx( ((IBusModelSchemaObj)getSchema()).getAuthorization(),
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
		if( ! ( ( value == null ) || ! ( value instanceof IBusModelPopSubDep2 ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"BusModelPopSubDep2Rec" );
		}
		rec = value;
		copyRecToPKey();
		requiredOwnerTenant = null;
		requiredLookupRelation = null;
		optionalLookupDefSchema = null;
		requiredContainerPopSubDep1 = null;
	}

	@Override
	public IBusModelPopSubDep2 getPopSubDep2Rec() {
		return( (IBusModelPopSubDep2)getRec() );
	}

	@Override
	public IBusModelScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		IBusModelPopSubDep2Obj lockobj;
		if( getIsNew() ) {
			lockobj = (IBusModelPopSubDep2Obj)this;
		}
		else {
			lockobj = ((IBusModelSchemaObj)getSchema()).getPopSubDep2TableObj().lockPopSubDep2( getPKey() );
		}
		edit = ((IBusModelSchemaObj)getSchema()).getPopSubDep2TableObj().newEditInstance( lockobj );
		return( (IBusModelScopeEditObj)edit );
	}

	@Override
	public IBusModelPopSubDep2EditObj getEditAsPopSubDep2() {
		return( (IBusModelPopSubDep2EditObj)edit );
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
	public IBusModelPopSubDep1Obj getRequiredContainerPopSubDep1() {
		return( getRequiredContainerPopSubDep1( false ) );
	}

	@Override
	public IBusModelPopSubDep1Obj getRequiredContainerPopSubDep1( boolean forceRead ) {
		if( ( requiredContainerPopSubDep1 == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerPopSubDep1 = ((IBusModelSchemaObj)getSchema()).getPopSubDep1TableObj().readPopSubDep1ByIdIdx( getPopSubDep2Rec().getRequiredPopSubDep1Id(), forceRead );
			}
		}
		return( requiredContainerPopSubDep1 );
	}

	@Override
	public List<IBusModelPopSubDep3Obj> getOptionalComponentsPopDep() {
		List<IBusModelPopSubDep3Obj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getPopSubDep3TableObj().readPopSubDep3ByPopSubDep2Idx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelPopSubDep3Obj> getOptionalComponentsPopDep( boolean forceRead ) {
		List<IBusModelPopSubDep3Obj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getPopSubDep3TableObj().readPopSubDep3ByPopSubDep2Idx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public IYCFKeyHash256 getRequiredPopSubDep1Id() {
		return( getPopSubDep2Rec().getRequiredPopSubDep1Id() );
	}

	@Override
	public String getRequiredName() {
		return( getPopSubDep2Rec().getRequiredName() );
	}
}
