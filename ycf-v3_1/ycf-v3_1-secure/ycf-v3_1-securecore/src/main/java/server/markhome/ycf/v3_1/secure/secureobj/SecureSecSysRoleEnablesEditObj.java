// Description: Java 25 edit object instance implementation for Secure SecSysRoleEnables.

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

public class SecureSecSysRoleEnablesEditObj
	implements ISecureSecSysRoleEnablesEditObj
{
	protected ISecureSecSysRoleEnablesObj orig;
	protected ISecureSecSysRoleEnables rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected ISecureSecSysRoleObj requiredContainerSysRole;
	protected ISecureSecSysGrpObj requiredParentEnableGroup;

	public SecureSecSysRoleEnablesEditObj( ISecureSecSysRoleEnablesObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureSecSysRoleEnables origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerSysRole = null;
		requiredParentEnableGroup = null;
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
		return( ((ISecureSchemaObj)orig.getSchema()).getSecSysRoleEnablesTableObj().getClassCode() );
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
		// We realise this so that it's record will get copied to orig during realization
		ISecureSecSysRoleEnablesObj retobj = getSchema().getSecSysRoleEnablesTableObj().realiseSecSysRoleEnables( (ISecureSecSysRoleEnablesObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecSysRoleEnables().forget();
	}

	@Override
	public ISecureSecSysRoleEnablesObj read() {
		ISecureSecSysRoleEnablesObj retval = getOrigAsSecSysRoleEnables().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecSysRoleEnablesObj read( boolean forceRead ) {
		ISecureSecSysRoleEnablesObj retval = getOrigAsSecSysRoleEnables().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecSysRoleEnablesObj create() {
		copyRecToOrig();
		ISecureSecSysRoleEnablesObj retobj = ((ISecureSchemaObj)getOrigAsSecSysRoleEnables().getSchema()).getSecSysRoleEnablesTableObj().createSecSysRoleEnables( getOrigAsSecSysRoleEnables() );
		if( retobj == getOrigAsSecSysRoleEnables() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureSecSysRoleEnablesEditObj update() {
		getSchema().getSecSysRoleEnablesTableObj().updateSecSysRoleEnables( (ISecureSecSysRoleEnablesObj)this );
		return( null );
	}

	@Override
	public SecureSecSysRoleEnablesEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecSysRoleEnablesTableObj().deleteSecSysRoleEnables( getOrigAsSecSysRoleEnables() );
		return( null );
	}

	@Override
	public ISecureSecSysRoleEnablesTableObj getSecSysRoleEnablesTable() {
		return( orig.getSchema().getSecSysRoleEnablesTableObj() );
	}

	@Override
	public ISecureSecSysRoleEnablesEditObj getEdit() {
		return( (ISecureSecSysRoleEnablesEditObj)this );
	}

	@Override
	public ISecureSecSysRoleEnablesEditObj getEditAsSecSysRoleEnables() {
		return( (ISecureSecSysRoleEnablesEditObj)this );
	}

	@Override
	public ISecureSecSysRoleEnablesEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureSecSysRoleEnablesObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureSecSysRoleEnablesObj getOrigAsSecSysRoleEnables() {
		return( (ISecureSecSysRoleEnablesObj)orig );
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
	public ISecureSecSysRoleEnables getRec() {
		if( rec == null ) {
			rec = getOrigAsSecSysRoleEnables().getSchema().getSecureBackingStore().getSecureFactory().getFactorySecSysRoleEnables().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecSysRoleEnables value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerSysRole = null;
			requiredParentEnableGroup = null;
		}
	}

	@Override
	public ISecureSecSysRoleEnables getSecSysRoleEnablesRec() {
		return( (ISecureSecSysRoleEnables)getRec() );
	}

	@Override
	public ISecureSecSysRoleEnablesPKey getPKey() {
		return( orig.getPKey() );
	}

	@Override
	public void setPKey( ISecureSecSysRoleEnablesPKey value ) {
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
		if( forceRead || ( requiredContainerSysRole == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecSysRoleObj obj = ((ISecureSchemaObj)getOrigAsSecSysRoleEnables().getSchema()).getSecSysRoleTableObj().readSecSysRoleByIdIdx( getPKey().getRequiredSecSysRoleId() );
				requiredContainerSysRole = obj;
				if( obj != null ) {
					requiredContainerSysRole = obj;
				}
			}
		}
		return( requiredContainerSysRole );
	}

	@Override
	public void setRequiredContainerSysRole( ISecureSecSysRoleObj value ) {
		if( rec == null ) {
			getSecSysRoleEnablesRec();
		}
		if( value != null ) {
			requiredContainerSysRole = value;
			getSecSysRoleEnablesRec().setRequiredContainerSysRole(value.getSecSysRoleRec());
		}
		requiredContainerSysRole = value;
	}

	@Override
	public ISecureSecSysGrpObj getRequiredParentEnableGroup() {
		return( getRequiredParentEnableGroup( false ) );
	}

	@Override
	public ISecureSecSysGrpObj getRequiredParentEnableGroup( boolean forceRead ) {
		if( forceRead || ( requiredParentEnableGroup == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecSysGrpObj obj = ((ISecureSchemaObj)getOrigAsSecSysRoleEnables().getSchema()).getSecSysGrpTableObj().readSecSysGrpByUNameIdx( getPKey().getRequiredEnableName() );
				requiredParentEnableGroup = obj;
			}
		}
		return( requiredParentEnableGroup );
	}

	@Override
	public void setRequiredParentEnableGroup( ISecureSecSysGrpObj value ) {
		if( rec == null ) {
			getSecSysRoleEnablesRec();
		}
		if( value != null ) {
			requiredParentEnableGroup = value;
			getSecSysRoleEnablesRec().setRequiredParentEnableGroup(value.getSecSysGrpRec());
		}
		else {
			requiredParentEnableGroup = null;
			getSecSysRoleEnablesRec().setRequiredParentEnableGroup((ISecureSecSysGrp)null);
		}
		requiredParentEnableGroup = value;
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredSecSysRoleId(getPKey().getRequiredSecSysRoleId());
			rec.getPKey().setRequiredEnableName(getPKey().getRequiredEnableName());
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredSecSysRoleId(rec.getPKey().getRequiredSecSysRoleId());
			getPKey().setRequiredEnableName(rec.getPKey().getRequiredEnableName());
		}
	}

	@Override
	public void copyRecToOrig() {
		ISecureSecSysRoleEnables origRec = getOrigAsSecSysRoleEnables().getSecSysRoleEnablesRec();
		ISecureSecSysRoleEnables myRec = getSecSysRoleEnablesRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureSecSysRoleEnables origRec = getOrigAsSecSysRoleEnables().getSecSysRoleEnablesRec();
		ISecureSecSysRoleEnables myRec = getSecSysRoleEnablesRec();
		myRec.set( origRec );
	}
}
