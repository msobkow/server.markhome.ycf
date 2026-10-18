// Description: Java 25 edit object instance implementation for IntNet Tenant.

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

public class IntNetTenantEditObj
	implements IIntNetTenantEditObj
{
	protected ISecureTenantObj orig;
	protected ISecureTenant rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected ISecureClusterObj requiredContainerCluster;
	protected List<ISecureSecTentGrpObj> optionalComponentsSecGroup;
	protected List<ISecureSecTentRoleObj> optionalComponentsSecRole;
	protected List<IIntNetTldObj> optionalComponentsTld;

	public IntNetTenantEditObj( ISecureTenantObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureTenant origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerCluster = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureTenant rec = getRec();
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
			ISecureTenant rec = getRec();
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
		return( ((ISecureSchemaObj)orig.getSchema()).getTenantTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "Tenant" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		ISecureClusterObj scope = getRequiredContainerCluster();
		return( scope );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredTenantName();
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
		if( subObj == null ) {
			try {
				if (nextName == null) {
					throw new YCFNullArgumentException(getClass(), "getNamedObject", 0, "RequiredName");
				}
				String natNextName = nextName;
				subObj = ((IIntNetSchemaObj)getSchema()).getSecTentGrpTableObj().readSecTentGrpByUNameIdx( getRequiredId(),
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
				subObj = ((IIntNetSchemaObj)getSchema()).getSecTentRoleTableObj().readSecTentRoleByUNameIdx( getRequiredId(),
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
				subObj = ((IIntNetSchemaObj)getSchema()).getTldTableObj().readTldByNameIdx( natNextName, false );
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
	public ISecureTenantObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureTenantObj retobj = getSchema().getTenantTableObj().realiseTenant( (IIntNetTenantObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsTenant().forget();
	}

	@Override
	public ISecureTenantObj read() {
		ISecureTenantObj retval = getOrigAsTenant().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureTenantObj read( boolean forceRead ) {
		ISecureTenantObj retval = getOrigAsTenant().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureTenantObj create() {
		copyRecToOrig();
		ISecureTenantObj retobj = ((IIntNetSchemaObj)getOrigAsTenant().getSchema()).getTenantTableObj().createTenant( getOrigAsTenant() );
		if( retobj == getOrigAsTenant() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureTenantEditObj update() {
		getSchema().getTenantTableObj().updateTenant( (ISecureTenantObj)this );
		return( null );
	}

	@Override
	public SecureTenantEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getTenantTableObj().deleteTenant( getOrigAsTenant() );
		return( null );
	}

	@Override
	public ISecureTenantTableObj getTenantTable() {
		return( orig.getSchema().getTenantTableObj() );
	}

	@Override
	public ISecureTenantEditObj getEdit() {
		return( (ISecureTenantEditObj)this );
	}

	@Override
	public ISecureTenantEditObj getEditAsTenant() {
		return( (ISecureTenantEditObj)this );
	}

	@Override
	public ISecureTenantEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureTenantObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureTenantObj getOrigAsTenant() {
		return( (ISecureTenantObj)orig );
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
	public ISecureTenant getRec() {
		if( rec == null ) {
			rec = getOrigAsTenant().getSchema().getSecureBackingStore().getSecureFactory().getFactoryTenant().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureTenant value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerCluster = null;
		}
	}

	@Override
	public ISecureTenant getTenantRec() {
		return( (ISecureTenant)getRec() );
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
	public IYCFKeyHash256 getRequiredId() {
		return( getPKey() );
	}

	@Override
	public void setRequiredId(IYCFKeyHash256 value) {
		if (getPKey() != value) {
			setPKey(value);
			requiredContainerCluster = null;
			optionalComponentsSecGroup = null;
			optionalComponentsSecRole = null;
			optionalComponentsTld = null;
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredClusterId() {
		return( getTenantRec().getRequiredClusterId() );
	}

	@Override
	public String getRequiredTenantName() {
		return( getTenantRec().getRequiredTenantName() );
	}

	@Override
	public void setRequiredTenantName( String value ) {
		if( getTenantRec().getRequiredTenantName() != value ) {
			getTenantRec().setRequiredTenantName( value );
		}
	}

	@Override
	public ISecureClusterObj getRequiredContainerCluster() {
		return( getRequiredContainerCluster( false ) );
	}

	@Override
	public ISecureClusterObj getRequiredContainerCluster( boolean forceRead ) {
		if( forceRead || ( requiredContainerCluster == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureClusterObj obj = ((IIntNetSchemaObj)getOrigAsTenant().getSchema()).getClusterTableObj().readClusterByIdIdx( getTenantRec().getRequiredClusterId() );
				requiredContainerCluster = obj;
				if( obj != null ) {
					requiredContainerCluster = obj;
				}
			}
		}
		return( requiredContainerCluster );
	}

	@Override
	public void setRequiredContainerCluster( ISecureClusterObj value ) {
		if( rec == null ) {
			getTenantRec();
		}
		if( value != null ) {
			requiredContainerCluster = value;
			getTenantRec().setRequiredContainerCluster(value.getClusterRec());
		}
		requiredContainerCluster = value;
	}

	@Override
	public List<ISecureSecTentGrpObj> getOptionalComponentsSecGroup() {
		List<ISecureSecTentGrpObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecTentGrpTableObj().readSecTentGrpByTenantIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecTentGrpObj> getOptionalComponentsSecGroup( boolean forceRead ) {
		List<ISecureSecTentGrpObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecTentGrpTableObj().readSecTentGrpByTenantIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecTentRoleObj> getOptionalComponentsSecRole() {
		List<ISecureSecTentRoleObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecTentRoleTableObj().readSecTentRoleByTenantIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecTentRoleObj> getOptionalComponentsSecRole( boolean forceRead ) {
		List<ISecureSecTentRoleObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecTentRoleTableObj().readSecTentRoleByTenantIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<IIntNetTldObj> getOptionalComponentsTld() {
		List<IIntNetTldObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getTldTableObj().readTldByTenantIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IIntNetTldObj> getOptionalComponentsTld( boolean forceRead ) {
		List<IIntNetTldObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getTldTableObj().readTldByTenantIdx( getPKey(),
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
		ISecureTenant origRec = getOrigAsTenant().getTenantRec();
		ISecureTenant myRec = getTenantRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureTenant origRec = getOrigAsTenant().getTenantRec();
		ISecureTenant myRec = getTenantRec();
		myRec.set( origRec );
	}
}
