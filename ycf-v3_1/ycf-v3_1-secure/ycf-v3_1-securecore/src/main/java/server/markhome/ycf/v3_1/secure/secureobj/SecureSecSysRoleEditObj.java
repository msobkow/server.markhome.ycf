// Description: Java 25 edit object instance implementation for Secure SecSysRole.

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

public class SecureSecSysRoleEditObj
	implements ISecureSecSysRoleEditObj
{
	protected ISecureSecSysRoleObj orig;
	protected ISecureSecSysRole rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected List<ISecureSecSysRoleEnablesObj> optionalComponentsEnabledByRole;
	protected List<ISecureSecSysRoleMembObj> optionalChildrenMembByRole;

	public SecureSecSysRoleEditObj( ISecureSecSysRoleObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureSecSysRole origRec = orig.getRec();
		rec.set( origRec );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureSecSysRole rec = getRec();
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
			ISecureSecSysRole rec = getRec();
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
		return( ((ISecureSchemaObj)orig.getSchema()).getSecSysRoleTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecSysRole" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		return( null );
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
		if( subObj == null ) {
			try {
				if (nextName == null) {
					throw new YCFNullArgumentException(getClass(), "getNamedObject", 0, "RequiredEnableName");
				}
				String natNextName = nextName;
				subObj = ((ISecureSchemaObj)getSchema()).getSecSysRoleEnablesTableObj().readSecSysRoleEnablesByIdIdx( getRequiredSecSysRoleId(),
				natNextName, false );
			}
			catch (Throwable th) {
				subObj = null;
			}
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
	public ISecureSecSysRoleObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureSecSysRoleObj retobj = getSchema().getSecSysRoleTableObj().realiseSecSysRole( (ISecureSecSysRoleObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecSysRole().forget();
	}

	@Override
	public ISecureSecSysRoleObj read() {
		ISecureSecSysRoleObj retval = getOrigAsSecSysRole().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecSysRoleObj read( boolean forceRead ) {
		ISecureSecSysRoleObj retval = getOrigAsSecSysRole().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecSysRoleObj create() {
		copyRecToOrig();
		ISecureSecSysRoleObj retobj = ((ISecureSchemaObj)getOrigAsSecSysRole().getSchema()).getSecSysRoleTableObj().createSecSysRole( getOrigAsSecSysRole() );
		if( retobj == getOrigAsSecSysRole() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureSecSysRoleEditObj update() {
		getSchema().getSecSysRoleTableObj().updateSecSysRole( (ISecureSecSysRoleObj)this );
		return( null );
	}

	@Override
	public SecureSecSysRoleEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecSysRoleTableObj().deleteSecSysRole( getOrigAsSecSysRole() );
		return( null );
	}

	@Override
	public ISecureSecSysRoleTableObj getSecSysRoleTable() {
		return( orig.getSchema().getSecSysRoleTableObj() );
	}

	@Override
	public ISecureSecSysRoleEditObj getEdit() {
		return( (ISecureSecSysRoleEditObj)this );
	}

	@Override
	public ISecureSecSysRoleEditObj getEditAsSecSysRole() {
		return( (ISecureSecSysRoleEditObj)this );
	}

	@Override
	public ISecureSecSysRoleEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureSecSysRoleObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureSecSysRoleObj getOrigAsSecSysRole() {
		return( (ISecureSecSysRoleObj)orig );
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
	public ISecureSecSysRole getRec() {
		if( rec == null ) {
			rec = getOrigAsSecSysRole().getSchema().getSecureBackingStore().getSecureFactory().getFactorySecSysRole().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecSysRole value ) {
		if( rec != value ) {
			rec = value;
		}
	}

	@Override
	public ISecureSecSysRole getSecSysRoleRec() {
		return( (ISecureSecSysRole)getRec() );
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
	public IYCFKeyHash256 getRequiredSecSysRoleId() {
		return( getPKey() );
	}

	@Override
	public void setRequiredSecSysRoleId(IYCFKeyHash256 value) {
		if (getPKey() != value) {
			setPKey(value);
			optionalComponentsEnabledByRole = null;
			optionalChildrenMembByRole = null;
		}
	}

	@Override
	public String getRequiredName() {
		return( getSecSysRoleRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getSecSysRoleRec().getRequiredName() != value ) {
			getSecSysRoleRec().setRequiredName( value );
		}
	}

	@Override
	public List<ISecureSecSysRoleEnablesObj> getOptionalComponentsEnabledByRole() {
		List<ISecureSecSysRoleEnablesObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSysRoleEnablesTableObj().readSecSysRoleEnablesBySysRoleIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecSysRoleEnablesObj> getOptionalComponentsEnabledByRole( boolean forceRead ) {
		List<ISecureSecSysRoleEnablesObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSysRoleEnablesTableObj().readSecSysRoleEnablesBySysRoleIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecSysRoleMembObj> getOptionalChildrenMembByRole() {
		List<ISecureSecSysRoleMembObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSysRoleMembTableObj().readSecSysRoleMembBySysRoleIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecSysRoleMembObj> getOptionalChildrenMembByRole( boolean forceRead ) {
		List<ISecureSecSysRoleMembObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSysRoleMembTableObj().readSecSysRoleMembBySysRoleIdx( getPKey(),
			forceRead );
		return( retval );
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
		ISecureSecSysRole origRec = getOrigAsSecSysRole().getSecSysRoleRec();
		ISecureSecSysRole myRec = getSecSysRoleRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureSecSysRole origRec = getOrigAsSecSysRole().getSecSysRoleRec();
		ISecureSecSysRole myRec = getSecSysRoleRec();
		myRec.set( origRec );
	}
}
