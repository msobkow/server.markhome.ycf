// Description: Java 25 edit object instance implementation for IntNet Tld.

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

public class IntNetTldEditObj
	implements IIntNetTldEditObj
{
	protected IIntNetTldObj orig;
	protected IIntNetTld rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected ISecureTenantObj requiredContainerTenant;
	protected List<IIntNetTopDomainObj> optionalComponentsTopDomain;

	public IntNetTldEditObj( IIntNetTldObj argOrig ) {
		orig = argOrig;
		getRec();
		IIntNetTld origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerTenant = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			IIntNetTld rec = getRec();
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
			IIntNetTld rec = getRec();
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
		return( ((IIntNetSchemaObj)orig.getSchema()).getTldTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "Tld" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		return( getRequiredContainerTenant() );
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
				subObj = ((IIntNetSchemaObj)getSchema()).getTopDomainTableObj().readTopDomainByNameIdx( getRequiredId(),
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
	public IIntNetTldObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		IIntNetTldObj retobj = getSchema().getTldTableObj().realiseTld( (IIntNetTldObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsTld().forget();
	}

	@Override
	public IIntNetTldObj read() {
		IIntNetTldObj retval = getOrigAsTld().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IIntNetTldObj read( boolean forceRead ) {
		IIntNetTldObj retval = getOrigAsTld().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IIntNetTldObj create() {
		copyRecToOrig();
		IIntNetTldObj retobj = ((IIntNetSchemaObj)getOrigAsTld().getSchema()).getTldTableObj().createTld( getOrigAsTld() );
		if( retobj == getOrigAsTld() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public IntNetTldEditObj update() {
		getSchema().getTldTableObj().updateTld( (IIntNetTldObj)this );
		return( null );
	}

	@Override
	public IntNetTldEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getTldTableObj().deleteTld( getOrigAsTld() );
		return( null );
	}

	@Override
	public IIntNetTldTableObj getTldTable() {
		return( orig.getSchema().getTldTableObj() );
	}

	@Override
	public IIntNetTldEditObj getEdit() {
		return( (IIntNetTldEditObj)this );
	}

	@Override
	public IIntNetTldEditObj getEditAsTld() {
		return( (IIntNetTldEditObj)this );
	}

	@Override
	public IIntNetTldEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public IIntNetTldObj getOrig() {
		return( orig );
	}

	@Override
	public IIntNetTldObj getOrigAsTld() {
		return( (IIntNetTldObj)orig );
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
	public IIntNetTld getRec() {
		if( rec == null ) {
			rec = getOrigAsTld().getSchema().getIntNetBackingStore().getIntNetFactory().getFactoryTld().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IIntNetTld value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerTenant = null;
		}
	}

	@Override
	public IIntNetTld getTldRec() {
		return( (IIntNetTld)getRec() );
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
			requiredContainerTenant = null;
			optionalComponentsTopDomain = null;
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredTenantId() {
		return( getTldRec().getRequiredTenantId() );
	}

	@Override
	public String getRequiredName() {
		return( getTldRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getTldRec().getRequiredName() != value ) {
			getTldRec().setRequiredName( value );
		}
	}

	@Override
	public String getOptionalDescription() {
		return( getTldRec().getOptionalDescription() );
	}

	@Override
	public void setOptionalDescription( String value ) {
		if( getTldRec().getOptionalDescription() != value ) {
			getTldRec().setOptionalDescription( value );
		}
	}

	@Override
	public ISecureTenantObj getRequiredContainerTenant() {
		return( getRequiredContainerTenant( false ) );
	}

	@Override
	public ISecureTenantObj getRequiredContainerTenant( boolean forceRead ) {
		if( forceRead || ( requiredContainerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureTenantObj obj = ((IIntNetSchemaObj)getOrigAsTld().getSchema()).getTenantTableObj().readTenantByIdIdx( getTldRec().getRequiredTenantId() );
				requiredContainerTenant = obj;
				if( obj != null ) {
					requiredContainerTenant = obj;
				}
			}
		}
		return( requiredContainerTenant );
	}

	@Override
	public void setRequiredContainerTenant( ISecureTenantObj value ) {
		if( rec == null ) {
			getTldRec();
		}
		if( value != null ) {
			requiredContainerTenant = value;
			getTldRec().setRequiredContainerTenant(value.getTenantRec());
		}
		requiredContainerTenant = value;
	}

	@Override
	public List<IIntNetTopDomainObj> getOptionalComponentsTopDomain() {
		List<IIntNetTopDomainObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getTopDomainTableObj().readTopDomainByTldIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IIntNetTopDomainObj> getOptionalComponentsTopDomain( boolean forceRead ) {
		List<IIntNetTopDomainObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getTopDomainTableObj().readTopDomainByTldIdx( getPKey(),
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
		IIntNetTld origRec = getOrigAsTld().getTldRec();
		IIntNetTld myRec = getTldRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IIntNetTld origRec = getOrigAsTld().getTldRec();
		IIntNetTld myRec = getTldRec();
		myRec.set( origRec );
	}
}
