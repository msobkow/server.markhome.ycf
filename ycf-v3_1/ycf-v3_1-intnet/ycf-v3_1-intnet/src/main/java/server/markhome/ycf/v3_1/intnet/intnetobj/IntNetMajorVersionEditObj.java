// Description: Java 25 edit object instance implementation for IntNet MajorVersion.

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

public class IntNetMajorVersionEditObj
	implements IIntNetMajorVersionEditObj
{
	protected IIntNetMajorVersionObj orig;
	protected IIntNetMajorVersion rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected ISecureTenantObj requiredOwnerTenant;
	protected IIntNetSubProjectObj requiredContainerParentSPrj;
	protected List<IIntNetMinorVersionObj> optionalComponentsMinorVer;

	public IntNetMajorVersionEditObj( IIntNetMajorVersionObj argOrig ) {
		orig = argOrig;
		getRec();
		IIntNetMajorVersion origRec = orig.getRec();
		rec.set( origRec );
		requiredOwnerTenant = null;
		requiredContainerParentSPrj = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			IIntNetMajorVersion rec = getRec();
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
			IIntNetMajorVersion rec = getRec();
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
		return( ((IIntNetSchemaObj)orig.getSchema()).getMajorVersionTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "MajorVersion" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IIntNetSubProjectObj scope = getRequiredContainerParentSPrj();
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
				subObj = ((IIntNetSchemaObj)getSchema()).getMinorVersionTableObj().readMinorVersionByNameIdx( getRequiredId(),
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
	public IIntNetMajorVersionObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		IIntNetMajorVersionObj retobj = getSchema().getMajorVersionTableObj().realiseMajorVersion( (IIntNetMajorVersionObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsMajorVersion().forget();
	}

	@Override
	public IIntNetMajorVersionObj read() {
		IIntNetMajorVersionObj retval = getOrigAsMajorVersion().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IIntNetMajorVersionObj read( boolean forceRead ) {
		IIntNetMajorVersionObj retval = getOrigAsMajorVersion().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IIntNetMajorVersionObj create() {
		copyRecToOrig();
		IIntNetMajorVersionObj retobj = ((IIntNetSchemaObj)getOrigAsMajorVersion().getSchema()).getMajorVersionTableObj().createMajorVersion( getOrigAsMajorVersion() );
		if( retobj == getOrigAsMajorVersion() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public IntNetMajorVersionEditObj update() {
		getSchema().getMajorVersionTableObj().updateMajorVersion( (IIntNetMajorVersionObj)this );
		return( null );
	}

	@Override
	public IntNetMajorVersionEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getMajorVersionTableObj().deleteMajorVersion( getOrigAsMajorVersion() );
		return( null );
	}

	@Override
	public IIntNetMajorVersionTableObj getMajorVersionTable() {
		return( orig.getSchema().getMajorVersionTableObj() );
	}

	@Override
	public IIntNetMajorVersionEditObj getEdit() {
		return( (IIntNetMajorVersionEditObj)this );
	}

	@Override
	public IIntNetMajorVersionEditObj getEditAsMajorVersion() {
		return( (IIntNetMajorVersionEditObj)this );
	}

	@Override
	public IIntNetMajorVersionEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public IIntNetMajorVersionObj getOrig() {
		return( orig );
	}

	@Override
	public IIntNetMajorVersionObj getOrigAsMajorVersion() {
		return( (IIntNetMajorVersionObj)orig );
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
	public IIntNetMajorVersion getRec() {
		if( rec == null ) {
			rec = getOrigAsMajorVersion().getSchema().getIntNetBackingStore().getIntNetFactory().getFactoryMajorVersion().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IIntNetMajorVersion value ) {
		if( rec != value ) {
			rec = value;
			requiredOwnerTenant = null;
			requiredContainerParentSPrj = null;
		}
	}

	@Override
	public IIntNetMajorVersion getMajorVersionRec() {
		return( (IIntNetMajorVersion)getRec() );
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
			requiredContainerParentSPrj = null;
			optionalComponentsMinorVer = null;
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredTenantId() {
		return( getMajorVersionRec().getRequiredTenantId() );
	}

	@Override
	public IYCFKeyHash256 getRequiredSubProjectId() {
		return( getMajorVersionRec().getRequiredSubProjectId() );
	}

	@Override
	public String getRequiredName() {
		return( getMajorVersionRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getMajorVersionRec().getRequiredName() != value ) {
			getMajorVersionRec().setRequiredName( value );
		}
	}

	@Override
	public String getOptionalDescription() {
		return( getMajorVersionRec().getOptionalDescription() );
	}

	@Override
	public void setOptionalDescription( String value ) {
		if( getMajorVersionRec().getOptionalDescription() != value ) {
			getMajorVersionRec().setOptionalDescription( value );
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
				ISecureTenantObj obj = ((IIntNetSchemaObj)getOrigAsMajorVersion().getSchema()).getTenantTableObj().readTenantByIdIdx( getMajorVersionRec().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	@Override
	public void setRequiredOwnerTenant( ISecureTenantObj value ) {
		if( rec == null ) {
			getMajorVersionRec();
		}
		if( value != null ) {
			requiredOwnerTenant = value;
			getMajorVersionRec().setRequiredOwnerTenant(value.getTenantRec());
		}
		requiredOwnerTenant = value;
	}

	@Override
	public IIntNetSubProjectObj getRequiredContainerParentSPrj() {
		return( getRequiredContainerParentSPrj( false ) );
	}

	@Override
	public IIntNetSubProjectObj getRequiredContainerParentSPrj( boolean forceRead ) {
		if( forceRead || ( requiredContainerParentSPrj == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IIntNetSubProjectObj obj = ((IIntNetSchemaObj)getOrigAsMajorVersion().getSchema()).getSubProjectTableObj().readSubProjectByIdIdx( getMajorVersionRec().getRequiredSubProjectId() );
				requiredContainerParentSPrj = obj;
				if( obj != null ) {
					requiredContainerParentSPrj = obj;
				}
			}
		}
		return( requiredContainerParentSPrj );
	}

	@Override
	public void setRequiredContainerParentSPrj( IIntNetSubProjectObj value ) {
		if( rec == null ) {
			getMajorVersionRec();
		}
		if( value != null ) {
			requiredContainerParentSPrj = value;
			getMajorVersionRec().setRequiredContainerParentSPrj(value.getSubProjectRec());
		}
		requiredContainerParentSPrj = value;
	}

	@Override
	public List<IIntNetMinorVersionObj> getOptionalComponentsMinorVer() {
		List<IIntNetMinorVersionObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getMinorVersionTableObj().readMinorVersionByMajorVerIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IIntNetMinorVersionObj> getOptionalComponentsMinorVer( boolean forceRead ) {
		List<IIntNetMinorVersionObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getMinorVersionTableObj().readMinorVersionByMajorVerIdx( getPKey(),
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
		IIntNetMajorVersion origRec = getOrigAsMajorVersion().getMajorVersionRec();
		IIntNetMajorVersion myRec = getMajorVersionRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IIntNetMajorVersion origRec = getOrigAsMajorVersion().getMajorVersionRec();
		IIntNetMajorVersion myRec = getMajorVersionRec();
		myRec.set( origRec );
	}
}
