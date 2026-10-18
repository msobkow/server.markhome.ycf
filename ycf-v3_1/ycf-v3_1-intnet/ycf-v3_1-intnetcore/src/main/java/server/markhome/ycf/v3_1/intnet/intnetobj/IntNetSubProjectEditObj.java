// Description: Java 25 edit object instance implementation for IntNet SubProject.

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

public class IntNetSubProjectEditObj
	implements IIntNetSubProjectEditObj
{
	protected IIntNetSubProjectObj orig;
	protected IIntNetSubProject rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected ISecureTenantObj requiredOwnerTenant;
	protected IIntNetTopProjectObj requiredContainerParentTPrj;
	protected List<IIntNetMajorVersionObj> optionalComponentsMajorVer;

	public IntNetSubProjectEditObj( IIntNetSubProjectObj argOrig ) {
		orig = argOrig;
		getRec();
		IIntNetSubProject origRec = orig.getRec();
		rec.set( origRec );
		requiredOwnerTenant = null;
		requiredContainerParentTPrj = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			IIntNetSubProject rec = getRec();
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
			IIntNetSubProject rec = getRec();
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
		return( ((IIntNetSchemaObj)orig.getSchema()).getSubProjectTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SubProject" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IIntNetTopProjectObj scope = getRequiredContainerParentTPrj();
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
				subObj = ((IIntNetSchemaObj)getSchema()).getMajorVersionTableObj().readMajorVersionByNameIdx( getRequiredId(),
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
	public IIntNetSubProjectObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		IIntNetSubProjectObj retobj = getSchema().getSubProjectTableObj().realiseSubProject( (IIntNetSubProjectObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSubProject().forget();
	}

	@Override
	public IIntNetSubProjectObj read() {
		IIntNetSubProjectObj retval = getOrigAsSubProject().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IIntNetSubProjectObj read( boolean forceRead ) {
		IIntNetSubProjectObj retval = getOrigAsSubProject().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IIntNetSubProjectObj create() {
		copyRecToOrig();
		IIntNetSubProjectObj retobj = ((IIntNetSchemaObj)getOrigAsSubProject().getSchema()).getSubProjectTableObj().createSubProject( getOrigAsSubProject() );
		if( retobj == getOrigAsSubProject() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public IntNetSubProjectEditObj update() {
		getSchema().getSubProjectTableObj().updateSubProject( (IIntNetSubProjectObj)this );
		return( null );
	}

	@Override
	public IntNetSubProjectEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSubProjectTableObj().deleteSubProject( getOrigAsSubProject() );
		return( null );
	}

	@Override
	public IIntNetSubProjectTableObj getSubProjectTable() {
		return( orig.getSchema().getSubProjectTableObj() );
	}

	@Override
	public IIntNetSubProjectEditObj getEdit() {
		return( (IIntNetSubProjectEditObj)this );
	}

	@Override
	public IIntNetSubProjectEditObj getEditAsSubProject() {
		return( (IIntNetSubProjectEditObj)this );
	}

	@Override
	public IIntNetSubProjectEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public IIntNetSubProjectObj getOrig() {
		return( orig );
	}

	@Override
	public IIntNetSubProjectObj getOrigAsSubProject() {
		return( (IIntNetSubProjectObj)orig );
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
	public IIntNetSubProject getRec() {
		if( rec == null ) {
			rec = getOrigAsSubProject().getSchema().getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IIntNetSubProject value ) {
		if( rec != value ) {
			rec = value;
			requiredOwnerTenant = null;
			requiredContainerParentTPrj = null;
		}
	}

	@Override
	public IIntNetSubProject getSubProjectRec() {
		return( (IIntNetSubProject)getRec() );
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
			requiredContainerParentTPrj = null;
			optionalComponentsMajorVer = null;
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredTenantId() {
		return( getSubProjectRec().getRequiredTenantId() );
	}

	@Override
	public IYCFKeyHash256 getRequiredTopProjectId() {
		return( getSubProjectRec().getRequiredTopProjectId() );
	}

	@Override
	public String getRequiredName() {
		return( getSubProjectRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getSubProjectRec().getRequiredName() != value ) {
			getSubProjectRec().setRequiredName( value );
		}
	}

	@Override
	public String getOptionalDescription() {
		return( getSubProjectRec().getOptionalDescription() );
	}

	@Override
	public void setOptionalDescription( String value ) {
		if( getSubProjectRec().getOptionalDescription() != value ) {
			getSubProjectRec().setOptionalDescription( value );
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
				ISecureTenantObj obj = ((IIntNetSchemaObj)getOrigAsSubProject().getSchema()).getTenantTableObj().readTenantByIdIdx( getSubProjectRec().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	@Override
	public void setRequiredOwnerTenant( ISecureTenantObj value ) {
		if( rec == null ) {
			getSubProjectRec();
		}
		if( value != null ) {
			requiredOwnerTenant = value;
			getSubProjectRec().setRequiredOwnerTenant(value.getTenantRec());
		}
		requiredOwnerTenant = value;
	}

	@Override
	public IIntNetTopProjectObj getRequiredContainerParentTPrj() {
		return( getRequiredContainerParentTPrj( false ) );
	}

	@Override
	public IIntNetTopProjectObj getRequiredContainerParentTPrj( boolean forceRead ) {
		if( forceRead || ( requiredContainerParentTPrj == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IIntNetTopProjectObj obj = ((IIntNetSchemaObj)getOrigAsSubProject().getSchema()).getTopProjectTableObj().readTopProjectByIdIdx( getSubProjectRec().getRequiredTopProjectId() );
				requiredContainerParentTPrj = obj;
				if( obj != null ) {
					requiredContainerParentTPrj = obj;
				}
			}
		}
		return( requiredContainerParentTPrj );
	}

	@Override
	public void setRequiredContainerParentTPrj( IIntNetTopProjectObj value ) {
		if( rec == null ) {
			getSubProjectRec();
		}
		if( value != null ) {
			requiredContainerParentTPrj = value;
			getSubProjectRec().setRequiredContainerParentTPrj(value.getTopProjectRec());
		}
		requiredContainerParentTPrj = value;
	}

	@Override
	public List<IIntNetMajorVersionObj> getOptionalComponentsMajorVer() {
		List<IIntNetMajorVersionObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getMajorVersionTableObj().readMajorVersionBySubProjectIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IIntNetMajorVersionObj> getOptionalComponentsMajorVer( boolean forceRead ) {
		List<IIntNetMajorVersionObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getMajorVersionTableObj().readMajorVersionBySubProjectIdx( getPKey(),
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
		IIntNetSubProject origRec = getOrigAsSubProject().getSubProjectRec();
		IIntNetSubProject myRec = getSubProjectRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IIntNetSubProject origRec = getOrigAsSubProject().getSubProjectRec();
		IIntNetSubProject myRec = getSubProjectRec();
		myRec.set( origRec );
	}
}
