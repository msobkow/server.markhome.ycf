// Description: Java 25 edit object instance implementation for IntNet License.

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

public class IntNetLicenseEditObj
	implements IIntNetLicenseEditObj
{
	protected IIntNetLicenseObj orig;
	protected IIntNetLicense rec;
	protected ISecureTenantObj requiredOwnerTenant;
	protected IIntNetTopDomainObj requiredContainerTopDomain;

	public IntNetLicenseEditObj( IIntNetLicenseObj argOrig ) {
		orig = argOrig;
		getRec();
		IIntNetLicense origRec = orig.getRec();
		rec.set( origRec );
		requiredOwnerTenant = null;
		requiredContainerTopDomain = null;
	}

	@Override
	public int getClassCode() {
		return( ((IIntNetSchemaObj)orig.getSchema()).getLicenseTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "License" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IIntNetTopDomainObj scope = getRequiredContainerTopDomain();
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
	public IIntNetLicenseObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		IIntNetLicenseObj retobj = getSchema().getLicenseTableObj().realiseLicense( (IIntNetLicenseObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsLicense().forget();
	}

	@Override
	public IIntNetLicenseObj read() {
		IIntNetLicenseObj retval = getOrigAsLicense().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IIntNetLicenseObj read( boolean forceRead ) {
		IIntNetLicenseObj retval = getOrigAsLicense().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IIntNetLicenseObj create() {
		copyRecToOrig();
		IIntNetLicenseObj retobj = ((IIntNetSchemaObj)getOrigAsLicense().getSchema()).getLicenseTableObj().createLicense( getOrigAsLicense() );
		if( retobj == getOrigAsLicense() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public IntNetLicenseEditObj update() {
		getSchema().getLicenseTableObj().updateLicense( (IIntNetLicenseObj)this );
		return( null );
	}

	@Override
	public IntNetLicenseEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getLicenseTableObj().deleteLicense( getOrigAsLicense() );
		return( null );
	}

	@Override
	public IIntNetLicenseTableObj getLicenseTable() {
		return( orig.getSchema().getLicenseTableObj() );
	}

	@Override
	public IIntNetLicenseEditObj getEdit() {
		return( (IIntNetLicenseEditObj)this );
	}

	@Override
	public IIntNetLicenseEditObj getEditAsLicense() {
		return( (IIntNetLicenseEditObj)this );
	}

	@Override
	public IIntNetLicenseEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public IIntNetLicenseObj getOrig() {
		return( orig );
	}

	@Override
	public IIntNetLicenseObj getOrigAsLicense() {
		return( (IIntNetLicenseObj)orig );
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
	public IIntNetLicense getRec() {
		if( rec == null ) {
			rec = getOrigAsLicense().getSchema().getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IIntNetLicense value ) {
		if( rec != value ) {
			rec = value;
			requiredOwnerTenant = null;
			requiredContainerTopDomain = null;
		}
	}

	@Override
	public IIntNetLicense getLicenseRec() {
		return( (IIntNetLicense)getRec() );
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
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredTenantId() {
		return( getLicenseRec().getRequiredTenantId() );
	}

	@Override
	public IYCFKeyHash256 getRequiredTopDomainId() {
		return( getLicenseRec().getRequiredTopDomainId() );
	}

	@Override
	public String getRequiredName() {
		return( getLicenseRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getLicenseRec().getRequiredName() != value ) {
			getLicenseRec().setRequiredName( value );
		}
	}

	@Override
	public String getOptionalDescription() {
		return( getLicenseRec().getOptionalDescription() );
	}

	@Override
	public void setOptionalDescription( String value ) {
		if( getLicenseRec().getOptionalDescription() != value ) {
			getLicenseRec().setOptionalDescription( value );
		}
	}

	@Override
	public String getOptionalEmbeddedText() {
		return( getLicenseRec().getOptionalEmbeddedText() );
	}

	@Override
	public void setOptionalEmbeddedText( String value ) {
		if( getLicenseRec().getOptionalEmbeddedText() != value ) {
			getLicenseRec().setOptionalEmbeddedText( value );
		}
	}

	@Override
	public String getOptionalFullText() {
		return( getLicenseRec().getOptionalFullText() );
	}

	@Override
	public void setOptionalFullText( String value ) {
		if( getLicenseRec().getOptionalFullText() != value ) {
			getLicenseRec().setOptionalFullText( value );
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
				ISecureTenantObj obj = ((IIntNetSchemaObj)getOrigAsLicense().getSchema()).getTenantTableObj().readTenantByIdIdx( getLicenseRec().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	@Override
	public void setRequiredOwnerTenant( ISecureTenantObj value ) {
		if( rec == null ) {
			getLicenseRec();
		}
		if( value != null ) {
			requiredOwnerTenant = value;
			getLicenseRec().setRequiredOwnerTenant(value.getTenantRec());
		}
		requiredOwnerTenant = value;
	}

	@Override
	public IIntNetTopDomainObj getRequiredContainerTopDomain() {
		return( getRequiredContainerTopDomain( false ) );
	}

	@Override
	public IIntNetTopDomainObj getRequiredContainerTopDomain( boolean forceRead ) {
		if( forceRead || ( requiredContainerTopDomain == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IIntNetTopDomainObj obj = ((IIntNetSchemaObj)getOrigAsLicense().getSchema()).getTopDomainTableObj().readTopDomainByIdIdx( getLicenseRec().getRequiredTopDomainId() );
				requiredContainerTopDomain = obj;
				if( obj != null ) {
					requiredContainerTopDomain = obj;
				}
			}
		}
		return( requiredContainerTopDomain );
	}

	@Override
	public void setRequiredContainerTopDomain( IIntNetTopDomainObj value ) {
		if( rec == null ) {
			getLicenseRec();
		}
		if( value != null ) {
			requiredContainerTopDomain = value;
			getLicenseRec().setRequiredContainerTopDomain(value.getTopDomainRec());
		}
		requiredContainerTopDomain = value;
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
		IIntNetLicense origRec = getOrigAsLicense().getLicenseRec();
		IIntNetLicense myRec = getLicenseRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IIntNetLicense origRec = getOrigAsLicense().getLicenseRec();
		IIntNetLicense myRec = getLicenseRec();
		myRec.set( origRec );
	}
}
