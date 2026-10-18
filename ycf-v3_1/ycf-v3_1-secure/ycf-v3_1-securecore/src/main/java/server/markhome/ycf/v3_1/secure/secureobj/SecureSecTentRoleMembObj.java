// Description: Java 25 base object instance implementation for SecTentRoleMemb

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.secure.secureobj;

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
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;

public class SecureSecTentRoleMembObj
	implements ISecureSecTentRoleMembObj
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

	public SecureSecTentRoleMembObj() {
		isNew = true;
		requiredContainerRole = null;
		requiredParentUser = null;
	}

	public SecureSecTentRoleMembObj( ISecureSchemaObj argSchema ) {
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
				if( container instanceof ISecureClusterObj ) {
					break;
				}
				else if( container instanceof ISecureTenantObj ) {
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
				if( container instanceof ISecureClusterObj ) {
					break;
				}
				else if( container instanceof ISecureTenantObj ) {
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
		ISecureSecTentRoleMembObj retobj = ((ISecureSchemaObj)getSchema()).getSecTentRoleMembTableObj().realiseSecTentRoleMemb(
			(ISecureSecTentRoleMembObj)this );
		return( (ISecureSecTentRoleMembObj)retobj );
	}

	@Override
	public void forget() {
		((ISecureSchemaObj)getSchema()).getSecTentRoleMembTableObj().reallyDeepDisposeSecTentRoleMemb( (ISecureSecTentRoleMembObj)this );
	}

	@Override
	public ISecureSecTentRoleMembObj read() {
		ISecureSecTentRoleMembObj retobj = ((ISecureSchemaObj)getSchema()).getSecTentRoleMembTableObj().readSecTentRoleMembByIdIdx( getPKey().getRequiredSecTentRoleId(),
			getPKey().getRequiredLoginId(), false );
		return( (ISecureSecTentRoleMembObj)retobj );
	}

	@Override
	public ISecureSecTentRoleMembObj read( boolean forceRead ) {
		ISecureSecTentRoleMembObj retobj = ((ISecureSchemaObj)getSchema()).getSecTentRoleMembTableObj().readSecTentRoleMembByIdIdx( getPKey().getRequiredSecTentRoleId(),
			getPKey().getRequiredLoginId(), forceRead );
		return( (ISecureSecTentRoleMembObj)retobj );
	}

	@Override
	public ISecureSecTentRoleMembTableObj getSecTentRoleMembTable() {
		return( ((ISecureSchemaObj)getSchema()).getSecTentRoleMembTableObj() );
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
				rec = getSchema().getSecureBackingStore().getTableSecTentRoleMemb().readDerivedByIdIdx( ((ISecureSchemaObj)getSchema()).getAuthorization(),
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
			lockobj = ((ISecureSchemaObj)getSchema()).getSecTentRoleMembTableObj().lockSecTentRoleMemb( getPKey() );
		}
		edit = ((ISecureSchemaObj)getSchema()).getSecTentRoleMembTableObj().newEditInstance( lockobj );
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
			createdBy = ((ISecureSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getCreatedByUserId() );
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
			updatedBy = ((ISecureSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
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
				requiredContainerRole = ((ISecureSchemaObj)getSchema()).getSecTentRoleTableObj().readSecTentRoleByIdIdx( getPKey().getRequiredSecTentRoleId(), forceRead );
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
				requiredParentUser = ((ISecureSchemaObj)getSchema()).getSecUserTableObj().readSecUserByULoginIdx( getPKey().getRequiredLoginId(), forceRead );
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
