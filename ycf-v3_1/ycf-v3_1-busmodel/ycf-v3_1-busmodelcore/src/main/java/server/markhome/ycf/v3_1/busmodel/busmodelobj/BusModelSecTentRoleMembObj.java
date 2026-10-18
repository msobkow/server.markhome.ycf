// Description: Java 25 base object instance implementation for SecTentRoleMemb

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public class BusModelSecTentRoleMembObj
	implements IBusModelSecTentRoleMembObj
{
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ISecureSecTentRoleMembEditObj edit;
	protected ISecureSchemaObj schema;
	protected ISecureSecTentRoleMembPKey pKey;
	protected ISecureSecTentRoleMemb rec;
	protected ISecureSecTentRoleObj requiredContainerRole;
	protected ISecureSecUserObj requiredParentUser;

	public BusModelSecTentRoleMembObj() {
		isNew = true;
		requiredContainerRole = null;
		requiredParentUser = null;
	}

	public BusModelSecTentRoleMembObj( ISecureSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerRole = null;
		requiredParentUser = null;
	}

	@Override
	public int getClassCode() {
		return( ((ISecureSchemaObj)schema).getSecTentRoleMembTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecTentRoleMemb" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		ISecureSecTentRoleObj scope = getRequiredContainerRole();
		return( scope );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredLoginId();
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
	public ISecureSecTentRoleMembObj realise() {
		ISecureSecTentRoleMembObj retobj = ((IBusModelSchemaObj)getSchema()).getSecTentRoleMembTableObj().realiseSecTentRoleMemb(
			(ISecureSecTentRoleMembObj)this );
		return( (ISecureSecTentRoleMembObj)retobj );
	}

	@Override
	public void forget() {
		((IBusModelSchemaObj)getSchema()).getSecTentRoleMembTableObj().reallyDeepDisposeSecTentRoleMemb( (ISecureSecTentRoleMembObj)this );
	}

	@Override
	public ISecureSecTentRoleMembObj read() {
		ISecureSecTentRoleMembObj retobj = ((IBusModelSchemaObj)getSchema()).getSecTentRoleMembTableObj().readSecTentRoleMembByIdIdx( getPKey().getRequiredSecTentRoleId(),
			getPKey().getRequiredLoginId(), false );
		return( (ISecureSecTentRoleMembObj)retobj );
	}

	@Override
	public ISecureSecTentRoleMembObj read( boolean forceRead ) {
		ISecureSecTentRoleMembObj retobj = ((IBusModelSchemaObj)getSchema()).getSecTentRoleMembTableObj().readSecTentRoleMembByIdIdx( getPKey().getRequiredSecTentRoleId(),
			getPKey().getRequiredLoginId(), forceRead );
		return( (ISecureSecTentRoleMembObj)retobj );
	}

	@Override
	public ISecureSecTentRoleMembTableObj getSecTentRoleMembTable() {
		return( ((IBusModelSchemaObj)getSchema()).getSecTentRoleMembTableObj() );
	}

	@Override
	public ISecureSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( ISecureSchemaObj value ) {
		schema = value;
	}

	@Override
	public ISecureSecTentRoleMemb getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getSecureBackingStore().getTableSecTentRoleMemb().readDerivedByIdIdx( ((IBusModelSchemaObj)getSchema()).getAuthorization(),
						getPKey().getRequiredSecTentRoleId(),
						getPKey().getRequiredLoginId() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecTentRoleMemb value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ISecureSecTentRoleMemb ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"SecureSecTentRoleMembRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredContainerRole = null;
		requiredParentUser = null;
	}

	@Override
	public ISecureSecTentRoleMemb getSecTentRoleMembRec() {
		return( (ISecureSecTentRoleMemb)getRec() );
	}

	@Override
	public ISecureSecTentRoleMembPKey getPKey() {
		if( pKey == null ) {
			pKey = getSchema().getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newPKey();
		}
		return( pKey );
	}

	@Override
	public void setPKey( ISecureSecTentRoleMembPKey value ) {
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
	public ISecureSecTentRoleMembEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ISecureSecTentRoleMembObj lockobj;
		if( getIsNew() ) {
			lockobj = (ISecureSecTentRoleMembObj)this;
		}
		else {
			lockobj = ((IBusModelSchemaObj)getSchema()).getSecTentRoleMembTableObj().lockSecTentRoleMemb( getPKey() );
		}
		edit = ((IBusModelSchemaObj)getSchema()).getSecTentRoleMembTableObj().newEditInstance( lockobj );
		return( (ISecureSecTentRoleMembEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ISecureSecTentRoleMembEditObj getEdit() {
		return( edit );
	}

	@Override
	public ISecureSecTentRoleMembEditObj getEditAsSecTentRoleMemb() {
		return( (ISecureSecTentRoleMembEditObj)edit );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureSecTentRoleMemb rec = getRec();
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
			ISecureSecTentRoleMemb rec = getRec();
			updatedBy = ((IBusModelSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public IYCFKeyHash256 getRequiredSecTentRoleId() {
		return( getPKey().getRequiredSecTentRoleId() );
	}

	@Override
	public String getRequiredLoginId() {
		return( getPKey().getRequiredLoginId() );
	}

	@Override
	public ISecureSecTentRoleObj getRequiredContainerRole() {
		return( getRequiredContainerRole( false ) );
	}

	@Override
	public ISecureSecTentRoleObj getRequiredContainerRole( boolean forceRead ) {
		if( ( requiredContainerRole == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerRole = ((IBusModelSchemaObj)getSchema()).getSecTentRoleTableObj().readSecTentRoleByIdIdx( getPKey().getRequiredSecTentRoleId(), forceRead );
			}
		}
		return( requiredContainerRole );
	}

	@Override
	public ISecureSecUserObj getRequiredParentUser() {
		return( getRequiredParentUser( false ) );
	}

	@Override
	public ISecureSecUserObj getRequiredParentUser( boolean forceRead ) {
		if( ( requiredParentUser == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredParentUser = ((IBusModelSchemaObj)getSchema()).getSecUserTableObj().readSecUserByULoginIdx( getPKey().getRequiredLoginId(), forceRead );
			}
		}
		return( requiredParentUser );
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredSecTentRoleId(getPKey().getRequiredSecTentRoleId());
			rec.getPKey().setRequiredLoginId(getPKey().getRequiredLoginId());
		}
		if( edit != null ) {
			edit.copyPKeyToRec();
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredSecTentRoleId(rec.getPKey().getRequiredSecTentRoleId());
			getPKey().setRequiredLoginId(rec.getPKey().getRequiredLoginId());
		}
	}
}
