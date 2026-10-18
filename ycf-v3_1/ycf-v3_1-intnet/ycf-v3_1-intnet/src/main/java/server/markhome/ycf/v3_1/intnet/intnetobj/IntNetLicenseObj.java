// Description: Java 25 base object instance implementation for License

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

public class IntNetLicenseObj
	implements IIntNetLicenseObj
{
	protected boolean isNew;
	protected IIntNetLicenseEditObj edit;
	protected IIntNetSchemaObj schema;
	protected $implCommaIJavaOptAtomType$ pKey;
	protected IIntNetLicense rec;
	protected ISecureTenantObj requiredOwnerTenant;
	protected IIntNetTopDomainObj requiredContainerTopDomain;

	public IntNetLicenseObj() {
		isNew = true;
		requiredOwnerTenant = null;
		requiredContainerTopDomain = null;
	}

	public IntNetLicenseObj( IIntNetSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredOwnerTenant = null;
		requiredContainerTopDomain = null;
	}

	@Override
	public int getClassCode() {
		return( ((IIntNetSchemaObj)schema).getLicenseTableObj().getClassCode() );
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
		IIntNetLicenseObj retobj = ((IIntNetSchemaObj)getSchema()).getLicenseTableObj().realiseLicense(
			(IIntNetLicenseObj)this );
		return( (IIntNetLicenseObj)retobj );
	}

	@Override
	public void forget() {
		((IIntNetSchemaObj)getSchema()).getLicenseTableObj().reallyDeepDisposeLicense( (IIntNetLicenseObj)this );
	}

	@Override
	public IIntNetLicenseObj read() {
		IIntNetLicenseObj retobj = ((IIntNetSchemaObj)getSchema()).getLicenseTableObj().readLicenseByIdIdx( getPKey(), false );
		return( (IIntNetLicenseObj)retobj );
	}

	@Override
	public IIntNetLicenseObj read( boolean forceRead ) {
		IIntNetLicenseObj retobj = ((IIntNetSchemaObj)getSchema()).getLicenseTableObj().readLicenseByIdIdx( getPKey(), forceRead );
		return( (IIntNetLicenseObj)retobj );
	}

	@Override
	public IIntNetLicenseTableObj getLicenseTable() {
		return( ((IIntNetSchemaObj)getSchema()).getLicenseTableObj() );
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
	public IIntNetLicense getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getIntNetBackingStore().getIntNetFactory().getFactoryLicense().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getIntNetBackingStore().getTableLicense().readDerivedByIdIdx( ((IIntNetSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( IIntNetLicense value ) {
		if( ! ( ( value == null ) || ! ( value instanceof IIntNetLicense ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"IntNetLicenseRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredOwnerTenant = null;
		requiredContainerTopDomain = null;
	}

	@Override
	public IIntNetLicense getLicenseRec() {
		return( (IIntNetLicense)getRec() );
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
	public IIntNetLicenseEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		IIntNetLicenseObj lockobj;
		if( getIsNew() ) {
			lockobj = (IIntNetLicenseObj)this;
		}
		else {
			lockobj = ((IIntNetSchemaObj)getSchema()).getLicenseTableObj().lockLicense( getPKey() );
		}
		edit = ((IIntNetSchemaObj)getSchema()).getLicenseTableObj().newEditInstance( lockobj );
		return( (IIntNetLicenseEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public IIntNetLicenseEditObj getEdit() {
		return( edit );
	}

	@Override
	public IIntNetLicenseEditObj getEditAsLicense() {
		return( (IIntNetLicenseEditObj)edit );
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
				requiredOwnerTenant = ((IIntNetSchemaObj)getSchema()).getTenantTableObj().readTenantByIdIdx( getLicenseRec().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerTenant );
	}

	@Override
	public IIntNetTopDomainObj getRequiredContainerTopDomain() {
		return( getRequiredContainerTopDomain( false ) );
	}

	@Override
	public IIntNetTopDomainObj getRequiredContainerTopDomain( boolean forceRead ) {
		if( ( requiredContainerTopDomain == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerTopDomain = ((IIntNetSchemaObj)getSchema()).getTopDomainTableObj().readTopDomainByIdIdx( getLicenseRec().getRequiredTopDomainId(), forceRead );
			}
		}
		return( requiredContainerTopDomain );
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
	public String getOptionalDescription() {
		return( getLicenseRec().getOptionalDescription() );
	}

	@Override
	public String getOptionalEmbeddedText() {
		return( getLicenseRec().getOptionalEmbeddedText() );
	}

	@Override
	public String getOptionalFullText() {
		return( getLicenseRec().getOptionalFullText() );
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
