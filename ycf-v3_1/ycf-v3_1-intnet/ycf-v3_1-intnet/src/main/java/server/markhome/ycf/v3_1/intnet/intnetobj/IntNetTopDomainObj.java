// Description: Java 25 base object instance implementation for TopDomain

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

public class IntNetTopDomainObj
	implements IIntNetTopDomainObj
{
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected boolean isNew;
	protected IIntNetTopDomainEditObj edit;
	protected IIntNetSchemaObj schema;
	protected $implCommaIJavaOptAtomType$ pKey;
	protected IIntNetTopDomain rec;
	protected ISecureTenantObj requiredOwnerTenant;
	protected IIntNetTldObj requiredContainerParentTld;
	protected List<IIntNetTopProjectObj> optionalComponentsTopProject;
	protected List<IIntNetLicenseObj> optionalComponentsLicense;

	public IntNetTopDomainObj() {
		isNew = true;
		requiredOwnerTenant = null;
		requiredContainerParentTld = null;
	}

	public IntNetTopDomainObj( IIntNetSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredOwnerTenant = null;
		requiredContainerParentTld = null;
	}

	@Override
	public int getClassCode() {
		return( ((IIntNetSchemaObj)schema).getTopDomainTableObj().getClassCode() );
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
		IIntNetTopDomainObj retobj = ((IIntNetSchemaObj)getSchema()).getTopDomainTableObj().realiseTopDomain(
			(IIntNetTopDomainObj)this );
		return( (IIntNetTopDomainObj)retobj );
	}

	@Override
	public void forget() {
		((IIntNetSchemaObj)getSchema()).getTopDomainTableObj().reallyDeepDisposeTopDomain( (IIntNetTopDomainObj)this );
	}

	@Override
	public IIntNetTopDomainObj read() {
		IIntNetTopDomainObj retobj = ((IIntNetSchemaObj)getSchema()).getTopDomainTableObj().readTopDomainByIdIdx( getPKey(), false );
		return( (IIntNetTopDomainObj)retobj );
	}

	@Override
	public IIntNetTopDomainObj read( boolean forceRead ) {
		IIntNetTopDomainObj retobj = ((IIntNetSchemaObj)getSchema()).getTopDomainTableObj().readTopDomainByIdIdx( getPKey(), forceRead );
		return( (IIntNetTopDomainObj)retobj );
	}

	@Override
	public IIntNetTopDomainTableObj getTopDomainTable() {
		return( ((IIntNetSchemaObj)getSchema()).getTopDomainTableObj() );
	}

	@Override
	public IIntNetSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( IIntNetSchemaObj value ) {
		schema = value;
	}

	@Override
	public IIntNetTopDomain getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getIntNetBackingStore().getIntNetFactory().getFactoryTopDomain().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getIntNetBackingStore().getTableTopDomain().readDerivedByIdIdx( ((IIntNetSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( IIntNetTopDomain value ) {
		if( ! ( ( value == null ) || ! ( value instanceof IIntNetTopDomain ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"IntNetTopDomainRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredOwnerTenant = null;
		requiredContainerParentTld = null;
	}

	@Override
	public IIntNetTopDomain getTopDomainRec() {
		return( (IIntNetTopDomain)getRec() );
	}

	@Override
	public $implCommaIJavaOptAtomType$ getPKey() {
		return( pKey );
	}

	@Override
	public void setPKey( $implCommaIJavaOptAtomType$ value ) {
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
	public IIntNetTopDomainEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		IIntNetTopDomainObj lockobj;
		if( getIsNew() ) {
			lockobj = (IIntNetTopDomainObj)this;
		}
		else {
			lockobj = ((IIntNetSchemaObj)getSchema()).getTopDomainTableObj().lockTopDomain( getPKey() );
		}
		edit = ((IIntNetSchemaObj)getSchema()).getTopDomainTableObj().newEditInstance( lockobj );
		return( (IIntNetTopDomainEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public IIntNetTopDomainEditObj getEdit() {
		return( edit );
	}

	@Override
	public IIntNetTopDomainEditObj getEditAsTopDomain() {
		return( (IIntNetTopDomainEditObj)edit );
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
	public IYCFKeyHash256 getRequiredId() {
		return( getPKey() );
	}

	@Override
	public ISecureTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	@Override
	public ISecureTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( ( requiredOwnerTenant == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerTenant = ((IIntNetSchemaObj)getSchema()).getTenantTableObj().readTenantByIdIdx( getTopDomainRec().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerTenant );
	}

	@Override
	public IIntNetTldObj getRequiredContainerParentTld() {
		return( getRequiredContainerParentTld( false ) );
	}

	@Override
	public IIntNetTldObj getRequiredContainerParentTld( boolean forceRead ) {
		if( ( requiredContainerParentTld == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerParentTld = ((IIntNetSchemaObj)getSchema()).getTldTableObj().readTldByIdIdx( getTopDomainRec().getRequiredTldId(), forceRead );
			}
		}
		return( requiredContainerParentTld );
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
	public String getOptionalDescription() {
		return( getTopDomainRec().getOptionalDescription() );
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			if (getPKey() != rec.getPKey()) {
				rec.setPKey(getPKey());
			}
		}
		if( edit != null ) {
			edit.copyPKeyToRec();
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
}
