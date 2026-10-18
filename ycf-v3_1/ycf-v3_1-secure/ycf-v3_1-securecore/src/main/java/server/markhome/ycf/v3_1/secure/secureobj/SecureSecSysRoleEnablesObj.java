// Description: Java 25 base object instance implementation for SecSysRoleEnables

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

public class SecureSecSysRoleEnablesObj
	implements ISecureSecSysRoleEnablesObj
{
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ISecureSecSysRoleEnablesEditObj edit;
	protected ISecureSchemaObj schema;
	protected ISecureSecSysRoleEnablesPKey pKey;
	protected ISecureSecSysRoleEnables rec;
	protected ISecureSecSysRoleObj requiredContainerSysRole;
	protected ISecureSecSysGrpObj requiredParentEnableGroup;

	public SecureSecSysRoleEnablesObj() {
		isNew = true;
		requiredContainerSysRole = null;
		requiredParentEnableGroup = null;
	}

	public SecureSecSysRoleEnablesObj( ISecureSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerSysRole = null;
		requiredParentEnableGroup = null;
	}

	@Override
	public int getClassCode() {
		return( ((ISecureSchemaObj)schema).getSecSysRoleEnablesTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecSysRoleEnables" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		ISecureSecSysRoleObj scope = getRequiredContainerSysRole();
		return( scope );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredEnableName();
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
	public ISecureSecSysRoleEnablesObj realise() {
		ISecureSecSysRoleEnablesObj retobj = ((ISecureSchemaObj)getSchema()).getSecSysRoleEnablesTableObj().realiseSecSysRoleEnables(
			(ISecureSecSysRoleEnablesObj)this );
		return( (ISecureSecSysRoleEnablesObj)retobj );
	}

	@Override
	public void forget() {
		((ISecureSchemaObj)getSchema()).getSecSysRoleEnablesTableObj().reallyDeepDisposeSecSysRoleEnables( (ISecureSecSysRoleEnablesObj)this );
	}

	@Override
	public ISecureSecSysRoleEnablesObj read() {
		ISecureSecSysRoleEnablesObj retobj = ((ISecureSchemaObj)getSchema()).getSecSysRoleEnablesTableObj().readSecSysRoleEnablesByIdIdx( getPKey().getRequiredSecSysRoleId(),
			getPKey().getRequiredEnableName(), false );
		return( (ISecureSecSysRoleEnablesObj)retobj );
	}

	@Override
	public ISecureSecSysRoleEnablesObj read( boolean forceRead ) {
		ISecureSecSysRoleEnablesObj retobj = ((ISecureSchemaObj)getSchema()).getSecSysRoleEnablesTableObj().readSecSysRoleEnablesByIdIdx( getPKey().getRequiredSecSysRoleId(),
			getPKey().getRequiredEnableName(), forceRead );
		return( (ISecureSecSysRoleEnablesObj)retobj );
	}

	@Override
	public ISecureSecSysRoleEnablesTableObj getSecSysRoleEnablesTable() {
		return( ((ISecureSchemaObj)getSchema()).getSecSysRoleEnablesTableObj() );
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
	public ISecureSecSysRoleEnables getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getSecureBackingStore().getTableSecSysRoleEnables().readDerivedByIdIdx( ((ISecureSchemaObj)getSchema()).getAuthorization(),
						getPKey().getRequiredSecSysRoleId(),
						getPKey().getRequiredEnableName() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecSysRoleEnables value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ISecureSecSysRoleEnables ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"SecureSecSysRoleEnablesRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredContainerSysRole = null;
		requiredParentEnableGroup = null;
	}

	@Override
	public ISecureSecSysRoleEnables getSecSysRoleEnablesRec() {
		return( (ISecureSecSysRoleEnables)getRec() );
	}

	@Override
	public ISecureSecSysRoleEnablesPKey getPKey() {
		if( pKey == null ) {
			pKey = getSchema().getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newPKey();
		}
		return( pKey );
	}

	@Override
	public void setPKey( ISecureSecSysRoleEnablesPKey value ) {
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
	public ISecureSecSysRoleEnablesEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ISecureSecSysRoleEnablesObj lockobj;
		if( getIsNew() ) {
			lockobj = (ISecureSecSysRoleEnablesObj)this;
		}
		else {
			lockobj = ((ISecureSchemaObj)getSchema()).getSecSysRoleEnablesTableObj().lockSecSysRoleEnables( getPKey() );
		}
		edit = ((ISecureSchemaObj)getSchema()).getSecSysRoleEnablesTableObj().newEditInstance( lockobj );
		return( (ISecureSecSysRoleEnablesEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ISecureSecSysRoleEnablesEditObj getEdit() {
		return( edit );
	}

	@Override
	public ISecureSecSysRoleEnablesEditObj getEditAsSecSysRoleEnables() {
		return( (ISecureSecSysRoleEnablesEditObj)edit );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureSecSysRoleEnables rec = getRec();
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
			ISecureSecSysRoleEnables rec = getRec();
			updatedBy = ((ISecureSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public IYCFKeyHash256 getRequiredSecSysRoleId() {
		return( getPKey().getRequiredSecSysRoleId() );
	}

	@Override
	public String getRequiredEnableName() {
		return( getPKey().getRequiredEnableName() );
	}

	@Override
	public ISecureSecSysRoleObj getRequiredContainerSysRole() {
		return( getRequiredContainerSysRole( false ) );
	}

	@Override
	public ISecureSecSysRoleObj getRequiredContainerSysRole( boolean forceRead ) {
		if( ( requiredContainerSysRole == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerSysRole = ((ISecureSchemaObj)getSchema()).getSecSysRoleTableObj().readSecSysRoleByIdIdx( getPKey().getRequiredSecSysRoleId(), forceRead );
			}
		}
		return( requiredContainerSysRole );
	}

	@Override
	public ISecureSecSysGrpObj getRequiredParentEnableGroup() {
		return( getRequiredParentEnableGroup( false ) );
	}

	@Override
	public ISecureSecSysGrpObj getRequiredParentEnableGroup( boolean forceRead ) {
		if( ( requiredParentEnableGroup == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredParentEnableGroup = ((ISecureSchemaObj)getSchema()).getSecSysGrpTableObj().readSecSysGrpByUNameIdx( getPKey().getRequiredEnableName(), forceRead );
			}
		}
		return( requiredParentEnableGroup );
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredSecSysRoleId(getPKey().getRequiredSecSysRoleId());
			rec.getPKey().setRequiredEnableName(getPKey().getRequiredEnableName());
		}
		if( edit != null ) {
			edit.copyPKeyToRec();
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredSecSysRoleId(rec.getPKey().getRequiredSecSysRoleId());
			getPKey().setRequiredEnableName(rec.getPKey().getRequiredEnableName());
		}
	}
}
