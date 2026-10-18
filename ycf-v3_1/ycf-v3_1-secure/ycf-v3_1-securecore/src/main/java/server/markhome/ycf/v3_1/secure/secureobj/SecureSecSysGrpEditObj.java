// Description: Java 25 edit object instance implementation for Secure SecSysGrp.

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

public class SecureSecSysGrpEditObj
	implements ISecureSecSysGrpEditObj
{
	protected ISecureSecSysGrpObj orig;
	protected ISecureSecSysGrp rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected List<ISecureSecSysGrpIncObj> optionalComponentsIncByGrp;
	protected List<ISecureSecSysGrpMembObj> optionalChildrenMembByGrp;
	protected List<ISecureSecClusGrpObj> optionalComponentsImplClusGrp;
	protected List<ISecureSecTentGrpObj> optionalComponentsImplTentGrp;
	protected ISecureSecSysRoleObj optionalComponentsImplSysRole;
	protected List<ISecureSecClusRoleObj> optionalComponentsImplClusRole;
	protected List<ISecureSecTentRoleObj> optionalComponentsImplTentRole;
	protected List<ISecureSecSysGrpIncObj> optionalChildrenSysGrpByName;
	protected List<ISecureSecSysRoleEnablesObj> optionalChildrenRoleByEnableName;

	public SecureSecSysGrpEditObj( ISecureSecSysGrpObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureSecSysGrp origRec = orig.getRec();
		rec.set( origRec );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureSecSysGrp rec = getRec();
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
			ISecureSecSysGrp rec = getRec();
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
		return( ((ISecureSchemaObj)orig.getSchema()).getSecSysGrpTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecSysGrp" );
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
					throw new YCFNullArgumentException(getClass(), "getNamedObject", 0, "RequiredInclName");
				}
				String natNextName = nextName;
				subObj = ((ISecureSchemaObj)getSchema()).getSecSysGrpIncTableObj().readSecSysGrpIncByIdIdx( getRequiredSecSysGrpId(),
				natNextName, false );
			}
			catch (Throwable th) {
				subObj = null;
			}
		}
		if( subObj == null ) {
			try {
				if (nextName == null) {
					throw new YCFNullArgumentException(getClass(), "getNamedObject", 0, "RequiredName");
				}
				String natNextName = nextName;
				subObj = ((ISecureSchemaObj)getSchema()).getSecClusGrpTableObj().readSecClusGrpByUNameIdx( getRequiredSecSysGrpId(),
				natNextName, false );
			}
			catch (Throwable th) {
				subObj = null;
			}
		}
		if( subObj == null ) {
			try {
				if (nextName == null) {
					throw new YCFNullArgumentException(getClass(), "getNamedObject", 0, "RequiredName");
				}
				String natNextName = nextName;
				subObj = ((ISecureSchemaObj)getSchema()).getSecTentGrpTableObj().readSecTentGrpByUNameIdx( getRequiredSecSysGrpId(),
				natNextName, false );
			}
			catch (Throwable th) {
				subObj = null;
			}
		}
		if( subObj == null ) {
			try {
				if (nextName == null) {
					throw new YCFNullArgumentException(getClass(), "getNamedObject", 0, "RequiredName");
				}
				String natNextName = nextName;
				subObj = ((ISecureSchemaObj)getSchema()).getSecSysRoleTableObj().readSecSysRoleByUNameIdx( natNextName, false );
			}
			catch (Throwable th) {
				subObj = null;
			}
		}
		if( subObj == null ) {
			try {
				if (nextName == null) {
					throw new YCFNullArgumentException(getClass(), "getNamedObject", 0, "RequiredName");
				}
				String natNextName = nextName;
				subObj = ((ISecureSchemaObj)getSchema()).getSecClusRoleTableObj().readSecClusRoleByUNameIdx( getRequiredSecSysGrpId(),
				natNextName, false );
			}
			catch (Throwable th) {
				subObj = null;
			}
		}
		if( subObj == null ) {
			try {
				if (nextName == null) {
					throw new YCFNullArgumentException(getClass(), "getNamedObject", 0, "RequiredName");
				}
				String natNextName = nextName;
				subObj = ((ISecureSchemaObj)getSchema()).getSecTentRoleTableObj().readSecTentRoleByUNameIdx( getRequiredSecSysGrpId(),
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
	public ISecureSecSysGrpObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureSecSysGrpObj retobj = getSchema().getSecSysGrpTableObj().realiseSecSysGrp( (ISecureSecSysGrpObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecSysGrp().forget();
	}

	@Override
	public ISecureSecSysGrpObj read() {
		ISecureSecSysGrpObj retval = getOrigAsSecSysGrp().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecSysGrpObj read( boolean forceRead ) {
		ISecureSecSysGrpObj retval = getOrigAsSecSysGrp().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecSysGrpObj create() {
		copyRecToOrig();
		ISecureSecSysGrpObj retobj = ((ISecureSchemaObj)getOrigAsSecSysGrp().getSchema()).getSecSysGrpTableObj().createSecSysGrp( getOrigAsSecSysGrp() );
		if( retobj == getOrigAsSecSysGrp() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureSecSysGrpEditObj update() {
		getSchema().getSecSysGrpTableObj().updateSecSysGrp( (ISecureSecSysGrpObj)this );
		return( null );
	}

	@Override
	public SecureSecSysGrpEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecSysGrpTableObj().deleteSecSysGrp( getOrigAsSecSysGrp() );
		return( null );
	}

	@Override
	public ISecureSecSysGrpTableObj getSecSysGrpTable() {
		return( orig.getSchema().getSecSysGrpTableObj() );
	}

	@Override
	public ISecureSecSysGrpEditObj getEdit() {
		return( (ISecureSecSysGrpEditObj)this );
	}

	@Override
	public ISecureSecSysGrpEditObj getEditAsSecSysGrp() {
		return( (ISecureSecSysGrpEditObj)this );
	}

	@Override
	public ISecureSecSysGrpEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureSecSysGrpObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureSecSysGrpObj getOrigAsSecSysGrp() {
		return( (ISecureSecSysGrpObj)orig );
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
	public ISecureSecSysGrp getRec() {
		if( rec == null ) {
			rec = getOrigAsSecSysGrp().getSchema().getSecureBackingStore().getSecureFactory().getFactorySecSysGrp().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecSysGrp value ) {
		if( rec != value ) {
			rec = value;
		}
	}

	@Override
	public ISecureSecSysGrp getSecSysGrpRec() {
		return( (ISecureSecSysGrp)getRec() );
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
	public IYCFKeyHash256 getRequiredSecSysGrpId() {
		return( getPKey() );
	}

	@Override
	public void setRequiredSecSysGrpId(IYCFKeyHash256 value) {
		if (getPKey() != value) {
			setPKey(value);
			optionalComponentsIncByGrp = null;
			optionalChildrenMembByGrp = null;
			optionalComponentsImplClusGrp = null;
			optionalComponentsImplTentGrp = null;
			optionalComponentsImplSysRole = null;
			optionalComponentsImplClusRole = null;
			optionalComponentsImplTentRole = null;
			optionalChildrenSysGrpByName = null;
			optionalChildrenRoleByEnableName = null;
		}
	}

	@Override
	public String getRequiredName() {
		return( getSecSysGrpRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getSecSysGrpRec().getRequiredName() != value ) {
			getSecSysGrpRec().setRequiredName( value );
			optionalComponentsIncByGrp = null;
			optionalChildrenMembByGrp = null;
			optionalComponentsImplClusGrp = null;
			optionalComponentsImplTentGrp = null;
			optionalComponentsImplSysRole = null;
			optionalComponentsImplClusRole = null;
			optionalComponentsImplTentRole = null;
			optionalChildrenSysGrpByName = null;
			optionalChildrenRoleByEnableName = null;
		}
	}

	@Override
	public ISecurePubSchema.SecLevelEnum getRequiredSecLevel() {
		return( getSecSysGrpRec().getRequiredSecLevel() );
	}

	@Override
	public void setRequiredSecLevel( ISecurePubSchema.SecLevelEnum value ) {
		if( getSecSysGrpRec().getRequiredSecLevel() != value ) {
			getSecSysGrpRec().setRequiredSecLevel( value );
		}
	}

	@Override
	public List<ISecureSecSysGrpIncObj> getOptionalComponentsIncByGrp() {
		List<ISecureSecSysGrpIncObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSysGrpIncTableObj().readSecSysGrpIncBySysGrpIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecSysGrpIncObj> getOptionalComponentsIncByGrp( boolean forceRead ) {
		List<ISecureSecSysGrpIncObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSysGrpIncTableObj().readSecSysGrpIncBySysGrpIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecSysGrpMembObj> getOptionalChildrenMembByGrp() {
		List<ISecureSecSysGrpMembObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSysGrpMembTableObj().readSecSysGrpMembBySysGrpIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecSysGrpMembObj> getOptionalChildrenMembByGrp( boolean forceRead ) {
		List<ISecureSecSysGrpMembObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSysGrpMembTableObj().readSecSysGrpMembBySysGrpIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecClusGrpObj> getOptionalComponentsImplClusGrp() {
		List<ISecureSecClusGrpObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecClusGrpTableObj().readSecClusGrpByNameIdx( getSecSysGrpRec().getRequiredName(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecClusGrpObj> getOptionalComponentsImplClusGrp( boolean forceRead ) {
		List<ISecureSecClusGrpObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecClusGrpTableObj().readSecClusGrpByNameIdx( getSecSysGrpRec().getRequiredName(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecTentGrpObj> getOptionalComponentsImplTentGrp() {
		List<ISecureSecTentGrpObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecTentGrpTableObj().readSecTentGrpByNameIdx( getSecSysGrpRec().getRequiredName(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecTentGrpObj> getOptionalComponentsImplTentGrp( boolean forceRead ) {
		List<ISecureSecTentGrpObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecTentGrpTableObj().readSecTentGrpByNameIdx( getSecSysGrpRec().getRequiredName(),
			forceRead );
		return( retval );
	}

	@Override
	public ISecureSecSysRoleObj getOptionalComponentsImplSysRole() {
		return( getOptionalComponentsImplSysRole( false ) );
	}

	@Override
	public ISecureSecSysRoleObj getOptionalComponentsImplSysRole( boolean forceRead ) {
		if( forceRead || ( optionalComponentsImplSysRole == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecSysRoleObj obj = ((ISecureSchemaObj)getOrigAsSecSysGrp().getSchema()).getSecSysRoleTableObj().readSecSysRoleByIdIdx( getPKey() );
				optionalComponentsImplSysRole = obj;
			}
		}
		return( optionalComponentsImplSysRole );
	}

	@Override
	public List<ISecureSecClusRoleObj> getOptionalComponentsImplClusRole() {
		List<ISecureSecClusRoleObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecClusRoleTableObj().readSecClusRoleByNameIdx( getSecSysGrpRec().getRequiredName(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecClusRoleObj> getOptionalComponentsImplClusRole( boolean forceRead ) {
		List<ISecureSecClusRoleObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecClusRoleTableObj().readSecClusRoleByNameIdx( getSecSysGrpRec().getRequiredName(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecTentRoleObj> getOptionalComponentsImplTentRole() {
		List<ISecureSecTentRoleObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecTentRoleTableObj().readSecTentRoleByNameIdx( getSecSysGrpRec().getRequiredName(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecTentRoleObj> getOptionalComponentsImplTentRole( boolean forceRead ) {
		List<ISecureSecTentRoleObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecTentRoleTableObj().readSecTentRoleByNameIdx( getSecSysGrpRec().getRequiredName(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecSysGrpIncObj> getOptionalChildrenSysGrpByName() {
		List<ISecureSecSysGrpIncObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSysGrpIncTableObj().readSecSysGrpIncByNameIdx( getSecSysGrpRec().getRequiredName(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecSysGrpIncObj> getOptionalChildrenSysGrpByName( boolean forceRead ) {
		List<ISecureSecSysGrpIncObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSysGrpIncTableObj().readSecSysGrpIncByNameIdx( getSecSysGrpRec().getRequiredName(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecSysRoleEnablesObj> getOptionalChildrenRoleByEnableName() {
		List<ISecureSecSysRoleEnablesObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSysRoleEnablesTableObj().readSecSysRoleEnablesByNameIdx( getSecSysGrpRec().getRequiredName(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecSysRoleEnablesObj> getOptionalChildrenRoleByEnableName( boolean forceRead ) {
		List<ISecureSecSysRoleEnablesObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSysRoleEnablesTableObj().readSecSysRoleEnablesByNameIdx( getSecSysGrpRec().getRequiredName(),
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
		ISecureSecSysGrp origRec = getOrigAsSecSysGrp().getSecSysGrpRec();
		ISecureSecSysGrp myRec = getSecSysGrpRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureSecSysGrp origRec = getOrigAsSecSysGrp().getSecSysGrpRec();
		ISecureSecSysGrp myRec = getSecSysGrpRec();
		myRec.set( origRec );
	}
}
