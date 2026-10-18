// Description: Java 25 edit object instance implementation for IntNet TopDomain.

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
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.intnet.intnetprot.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetprotobj.*;

public class IntNetTopDomainEditObj
	implements IIntNetTopDomainEditObj
{
	protected IIntNetTopDomainObj orig;
	protected IIntNetTopDomain rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected ISecureTenantObj requiredOwnerTenant;
	protected IIntNetTldObj requiredContainerParentTld;
	protected List<IIntNetTopProjectObj> optionalComponentsTopProject;
	protected List<IIntNetLicenseObj> optionalComponentsLicense;

	public IntNetTopDomainEditObj( IIntNetTopDomainObj argOrig ) {
		orig = argOrig;
		getRec();
		IIntNetTopDomain origRec = orig.getRec();
		rec.set( origRec );
		requiredOwnerTenant = null;
		requiredContainerParentTld = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			IIntNetTopDomain rec = getRec();
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
			IIntNetTopDomain rec = getRec();
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
		return( ((IIntNetSchemaObj)orig.getSchema()).getTopDomainTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "TopDomain" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IIntNetTldObj scope = getRequiredContainerParentTld();
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
				subObj = ((IIntNetSchemaObj)getSchema()).getTopProjectTableObj().readTopProjectByNameIdx( getRequiredId(),
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
				subObj = ((IIntNetSchemaObj)getSchema()).getLicenseTableObj().readLicenseByUNameIdx( getRequiredId(),
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
			else if( container instanceof IIntNetTenantObj ) {
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
	public IIntNetTopDomainObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		IIntNetTopDomainObj retobj = getSchema().getTopDomainTableObj().realiseTopDomain( (IIntNetTopDomainObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsTopDomain().forget();
	}

	@Override
	public IIntNetTopDomainObj read() {
		IIntNetTopDomainObj retval = getOrigAsTopDomain().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IIntNetTopDomainObj read( boolean forceRead ) {
		IIntNetTopDomainObj retval = getOrigAsTopDomain().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IIntNetTopDomainObj create() {
		copyRecToOrig();
		IIntNetTopDomainObj retobj = ((IIntNetSchemaObj)getOrigAsTopDomain().getSchema()).getTopDomainTableObj().createTopDomain( getOrigAsTopDomain() );
		if( retobj == getOrigAsTopDomain() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public IntNetTopDomainEditObj update() {
		getSchema().getTopDomainTableObj().updateTopDomain( (IIntNetTopDomainObj)this );
		return( null );
	}

	@Override
	public IntNetTopDomainEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getTopDomainTableObj().deleteTopDomain( getOrigAsTopDomain() );
		return( null );
	}

	@Override
	public IIntNetTopDomainTableObj getTopDomainTable() {
		return( orig.getSchema().getTopDomainTableObj() );
	}

	@Override
	public IIntNetTopDomainEditObj getEdit() {
		return( (IIntNetTopDomainEditObj)this );
	}

	@Override
	public IIntNetTopDomainEditObj getEditAsTopDomain() {
		return( (IIntNetTopDomainEditObj)this );
	}

	@Override
	public IIntNetTopDomainEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public IIntNetTopDomainObj getOrig() {
		return( orig );
	}

	@Override
	public IIntNetTopDomainObj getOrigAsTopDomain() {
		return( (IIntNetTopDomainObj)orig );
	}

	@Override
	public IIntNetSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	@Override
	public void setSchema( IIntNetSchemaObj value ) {
		orig.setSchema(value);
	}

	@Override
	public IIntNetTopDomain getRec() {
		if( rec == null ) {
			rec = getOrigAsTopDomain().getSchema().getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IIntNetTopDomain value ) {
		if( rec != value ) {
			rec = value;
			requiredOwnerTenant = null;
			requiredContainerParentTld = null;
		}
	}

	@Override
	public IIntNetTopDomain getTopDomainRec() {
		return( (IIntNetTopDomain)getRec() );
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
			requiredOwnerTenant = null;
			requiredContainerParentTld = null;
			optionalComponentsTopProject = null;
			optionalComponentsLicense = null;
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredTenantId() {
		return( getTopDomainRec().getRequiredTenantId() );
	}

	@Override
	public IYCFKeyHash256 getRequiredTldId() {
		return( getTopDomainRec().getRequiredTldId() );
	}

	@Override
	public String getRequiredName() {
		return( getTopDomainRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getTopDomainRec().getRequiredName() != value ) {
			getTopDomainRec().setRequiredName( value );
		}
	}

	@Override
	public String getOptionalDescription() {
		return( getTopDomainRec().getOptionalDescription() );
	}

	@Override
	public void setOptionalDescription( String value ) {
		if( getTopDomainRec().getOptionalDescription() != value ) {
			getTopDomainRec().setOptionalDescription( value );
		}
	}

	@Override
	public ISecureTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	@Override
	public ISecureTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureTenantObj obj = ((IIntNetSchemaObj)getOrigAsTopDomain().getSchema()).getTenantTableObj().readTenantByIdIdx( getTopDomainRec().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	@Override
	public void setRequiredOwnerTenant( ISecureTenantObj value ) {
		if( rec == null ) {
			getTopDomainRec();
		}
		if( value != null ) {
			requiredOwnerTenant = value;
			getTopDomainRec().setRequiredOwnerTenant(value.getTenantRec());
		}
		requiredOwnerTenant = value;
	}

	@Override
	public IIntNetTldObj getRequiredContainerParentTld() {
		return( getRequiredContainerParentTld( false ) );
	}

	@Override
	public IIntNetTldObj getRequiredContainerParentTld( boolean forceRead ) {
		if( forceRead || ( requiredContainerParentTld == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IIntNetTldObj obj = ((IIntNetSchemaObj)getOrigAsTopDomain().getSchema()).getTldTableObj().readTldByIdIdx( getTopDomainRec().getRequiredTldId() );
				requiredContainerParentTld = obj;
				if( obj != null ) {
					requiredContainerParentTld = obj;
				}
			}
		}
		return( requiredContainerParentTld );
	}

	@Override
	public void setRequiredContainerParentTld( IIntNetTldObj value ) {
		if( rec == null ) {
			getTopDomainRec();
		}
		if( value != null ) {
			requiredContainerParentTld = value;
			getTopDomainRec().setRequiredContainerParentTld(value.getTldRec());
		}
		requiredContainerParentTld = value;
	}

	@Override
	public List<IIntNetTopProjectObj> getOptionalComponentsTopProject() {
		List<IIntNetTopProjectObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getTopProjectTableObj().readTopProjectByTopDomainIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IIntNetTopProjectObj> getOptionalComponentsTopProject( boolean forceRead ) {
		List<IIntNetTopProjectObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getTopProjectTableObj().readTopProjectByTopDomainIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<IIntNetLicenseObj> getOptionalComponentsLicense() {
		List<IIntNetLicenseObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getLicenseTableObj().readLicenseByDomainIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IIntNetLicenseObj> getOptionalComponentsLicense( boolean forceRead ) {
		List<IIntNetLicenseObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getLicenseTableObj().readLicenseByDomainIdx( getPKey(),
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
		IIntNetTopDomain origRec = getOrigAsTopDomain().getTopDomainRec();
		IIntNetTopDomain myRec = getTopDomainRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IIntNetTopDomain origRec = getOrigAsTopDomain().getTopDomainRec();
		IIntNetTopDomain myRec = getTopDomainRec();
		myRec.set( origRec );
	}
}
