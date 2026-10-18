// Description: Java 25 base object instance implementation for DelSubDep2

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

public class BusModelDelSubDep2Obj
	extends BusModelDelDepObj
	implements IBusModelDelSubDep2Obj
{
	protected IBusModelDelSubDep1Obj requiredContainerDelSubDep1;
	protected List<IBusModelDelSubDep3Obj> optionalComponentsDelDep;

	public BusModelDelSubDep2Obj() {
		super();
		requiredContainerDelSubDep1 = null;
	}

	public BusModelDelSubDep2Obj( IBusModelSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerDelSubDep1 = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)schema).getDelSubDep2TableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "DelSubDep2" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelDelSubDep1Obj scope = getRequiredContainerDelSubDep1();
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
		IBusModelDelSubDep2Obj retobj = ((IBusModelSchemaObj)getSchema()).getDelSubDep2TableObj().realiseDelSubDep2(
			(IBusModelDelSubDep2Obj)this );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public void forget() {
		((IBusModelSchemaObj)getSchema()).getDelSubDep2TableObj().reallyDeepDisposeDelSubDep2( (IBusModelDelSubDep2Obj)this );
	}

	@Override
	public IBusModelScopeObj read() {
		IBusModelDelSubDep2Obj retobj = ((IBusModelSchemaObj)getSchema()).getDelSubDep2TableObj().readDelSubDep2ByIdIdx( getPKey(), false );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public IBusModelScopeObj read( boolean forceRead ) {
		IBusModelDelSubDep2Obj retobj = ((IBusModelSchemaObj)getSchema()).getDelSubDep2TableObj().readDelSubDep2ByIdIdx( getPKey(), forceRead );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public IBusModelDelSubDep2TableObj getDelSubDep2Table() {
		return( ((IBusModelSchemaObj)getSchema()).getDelSubDep2TableObj() );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep2().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getBusModelBackingStore().getTableDelSubDep2().readDerivedByIdIdx( ((IBusModelSchemaObj)getSchema()).getAuthorization(),
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
		if( ! ( ( value == null ) || ! ( value instanceof IBusModelDelSubDep2 ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"BusModelDelSubDep2Rec" );
		}
		rec = value;
		copyRecToPKey();
		requiredOwnerTenant = null;
		requiredLookupRelation = null;
		optionalLookupDefSchema = null;
		requiredContainerDelSubDep1 = null;
	}

	@Override
	public IBusModelDelSubDep2 getDelSubDep2Rec() {
		return( (IBusModelDelSubDep2)getRec() );
	}

	@Override
	public IBusModelScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		IBusModelDelSubDep2Obj lockobj;
		if( getIsNew() ) {
			lockobj = (IBusModelDelSubDep2Obj)this;
		}
		else {
			lockobj = ((IBusModelSchemaObj)getSchema()).getDelSubDep2TableObj().lockDelSubDep2( getPKey() );
		}
		edit = ((IBusModelSchemaObj)getSchema()).getDelSubDep2TableObj().newEditInstance( lockobj );
		return( (IBusModelScopeEditObj)edit );
	}

	@Override
	public IBusModelDelSubDep2EditObj getEditAsDelSubDep2() {
		return( (IBusModelDelSubDep2EditObj)edit );
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
	public IBusModelDelSubDep1Obj getRequiredContainerDelSubDep1() {
		return( getRequiredContainerDelSubDep1( false ) );
	}

	@Override
	public IBusModelDelSubDep1Obj getRequiredContainerDelSubDep1( boolean forceRead ) {
		if( ( requiredContainerDelSubDep1 == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerDelSubDep1 = ((IBusModelSchemaObj)getSchema()).getDelSubDep1TableObj().readDelSubDep1ByIdIdx( getDelSubDep2Rec().getRequiredDelSubDep1Id(), forceRead );
			}
		}
		return( requiredContainerDelSubDep1 );
	}

	@Override
	public List<IBusModelDelSubDep3Obj> getOptionalComponentsDelDep() {
		List<IBusModelDelSubDep3Obj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getDelSubDep3TableObj().readDelSubDep3ByDelSubDep2Idx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelDelSubDep3Obj> getOptionalComponentsDelDep( boolean forceRead ) {
		List<IBusModelDelSubDep3Obj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getDelSubDep3TableObj().readDelSubDep3ByDelSubDep2Idx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public IYCFKeyHash256 getRequiredDelSubDep1Id() {
		return( getDelSubDep2Rec().getRequiredDelSubDep1Id() );
	}

	@Override
	public String getRequiredName() {
		return( getDelSubDep2Rec().getRequiredName() );
	}
}
