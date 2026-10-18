// Description: Java 25 edit object instance implementation for IntNet SecTentRoleMemb.

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
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

package server.markhome.ycf.v3_1.intnet.intnetobj;

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public class IntNetSecTentRoleMembEditObj
	implements IIntNetSecTentRoleMembEditObj
{
	protected ISecureSecTentRoleMembObj orig;
	protected ISecureSecTentRoleMemb rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected ISecureSecTentRoleObj requiredContainerRole;
	protected ISecureSecUserObj requiredParentUser;

	public IntNetSecTentRoleMembEditObj( ISecureSecTentRoleMembObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureSecTentRoleMemb origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerRole = null;
		requiredParentUser = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureSecTentRoleMemb rec = getRec();
			createdBy = ((IIntNetSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getCreatedByUserId() );
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
			updatedBy = ((IIntNetSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
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
		return( ((ISecureSchemaObj)orig.getSchema()).getSecTentRoleMembTableObj().getClassCode() );
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
				if( container instanceof IIntNetClusterObj ) {
					break;
				}
				else if( container instanceof IIntNetTenantObj ) {
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
				if( container instanceof IIntNetClusterObj ) {
					break;
				}
				else if( container instanceof IIntNetTenantObj ) {
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
		// We realise this so that it's record will get copied to orig during realization
		ISecureSecTentRoleMembObj retobj = getSchema().getSecTentRoleMembTableObj().realiseSecTentRoleMemb( (IIntNetSecTentRoleMembObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecTentRoleMemb().forget();
	}

	@Override
	public ISecureSecTentRoleMembObj read() {
		ISecureSecTentRoleMembObj retval = getOrigAsSecTentRoleMemb().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecTentRoleMembObj read( boolean forceRead ) {
		ISecureSecTentRoleMembObj retval = getOrigAsSecTentRoleMemb().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecTentRoleMembObj create() {
		copyRecToOrig();
		ISecureSecTentRoleMembObj retobj = ((IIntNetSchemaObj)getOrigAsSecTentRoleMemb().getSchema()).getSecTentRoleMembTableObj().createSecTentRoleMemb( getOrigAsSecTentRoleMemb() );
		if( retobj == getOrigAsSecTentRoleMemb() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureSecTentRoleMembEditObj update() {
		getSchema().getSecTentRoleMembTableObj().updateSecTentRoleMemb( (ISecureSecTentRoleMembObj)this );
		return( null );
	}

	@Override
	public SecureSecTentRoleMembEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecTentRoleMembTableObj().deleteSecTentRoleMemb( getOrigAsSecTentRoleMemb() );
		return( null );
	}

	@Override
	public ISecureSecTentRoleMembTableObj getSecTentRoleMembTable() {
		return( orig.getSchema().getSecTentRoleMembTableObj() );
	}

	@Override
	public ISecureSecTentRoleMembEditObj getEdit() {
		return( (ISecureSecTentRoleMembEditObj)this );
	}

	@Override
	public ISecureSecTentRoleMembEditObj getEditAsSecTentRoleMemb() {
		return( (ISecureSecTentRoleMembEditObj)this );
	}

	@Override
	public ISecureSecTentRoleMembEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureSecTentRoleMembObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureSecTentRoleMembObj getOrigAsSecTentRoleMemb() {
		return( (ISecureSecTentRoleMembObj)orig );
	}

	@Override
	public ISecureSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	@Override
	public void setSchema( ISecureSchemaObj value ) {
		orig.setSchema(value);
	}

	@Override
	public ISecureSecTentRoleMemb getRec() {
		if( rec == null ) {
			rec = getOrigAsSecTentRoleMemb().getSchema().getSecureBackingStore().getSecureFactory().getFactorySecTentRoleMemb().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecTentRoleMemb value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerRole = null;
			requiredParentUser = null;
		}
	}

	@Override
	public ISecureSecTentRoleMemb getSecTentRoleMembRec() {
		return( (ISecureSecTentRoleMemb)getRec() );
	}

	@Override
	public ISecureSecTentRoleMembPKey getPKey() {
		return( orig.getPKey() );
	}

	@Override
	public void setPKey( ISecureSecTentRoleMembPKey value ) {
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
		if( forceRead || ( requiredContainerRole == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecTentRoleObj obj = ((IIntNetSchemaObj)getOrigAsSecTentRoleMemb().getSchema()).getSecTentRoleTableObj().readSecTentRoleByIdIdx( getPKey().getRequiredSecTentRoleId() );
				requiredContainerRole = obj;
				if( obj != null ) {
					requiredContainerRole = obj;
				}
			}
		}
		return( requiredContainerRole );
	}

	@Override
	public void setRequiredContainerRole( ISecureSecTentRoleObj value ) {
		if( rec == null ) {
			getSecTentRoleMembRec();
		}
		if( value != null ) {
			requiredContainerRole = value;
			getSecTentRoleMembRec().setRequiredContainerRole(value.getSecTentRoleRec());
		}
		requiredContainerRole = value;
	}

	@Override
	public ISecureSecUserObj getRequiredParentUser() {
		return( getRequiredParentUser( false ) );
	}

	@Override
	public ISecureSecUserObj getRequiredParentUser( boolean forceRead ) {
		if( forceRead || ( requiredParentUser == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecUserObj obj = ((IIntNetSchemaObj)getOrigAsSecTentRoleMemb().getSchema()).getSecUserTableObj().readSecUserByULoginIdx( getPKey().getRequiredLoginId() );
				requiredParentUser = obj;
			}
		}
		return( requiredParentUser );
	}

	@Override
	public void setRequiredParentUser( ISecureSecUserObj value ) {
		if( rec == null ) {
			getSecTentRoleMembRec();
		}
		if( value != null ) {
			requiredParentUser = value;
			getSecTentRoleMembRec().setRequiredParentUser(value.getSecUserRec());
		}
		else {
			requiredParentUser = null;
			getSecTentRoleMembRec().setRequiredParentUser((ISecureSecUser)null);
		}
		requiredParentUser = value;
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredSecTentRoleId(getPKey().getRequiredSecTentRoleId());
			rec.getPKey().setRequiredLoginId(getPKey().getRequiredLoginId());
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredSecTentRoleId(rec.getPKey().getRequiredSecTentRoleId());
			getPKey().setRequiredLoginId(rec.getPKey().getRequiredLoginId());
		}
	}

	@Override
	public void copyRecToOrig() {
		ISecureSecTentRoleMemb origRec = getOrigAsSecTentRoleMemb().getSecTentRoleMembRec();
		ISecureSecTentRoleMemb myRec = getSecTentRoleMembRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureSecTentRoleMemb origRec = getOrigAsSecTentRoleMemb().getSecTentRoleMembRec();
		ISecureSecTentRoleMemb myRec = getSecTentRoleMembRec();
		myRec.set( origRec );
	}
}
