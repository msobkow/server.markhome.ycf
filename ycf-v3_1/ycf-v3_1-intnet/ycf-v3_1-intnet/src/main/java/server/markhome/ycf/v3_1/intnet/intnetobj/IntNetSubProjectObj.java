// Description: Java 25 base object instance implementation for SubProject

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

public class IntNetSubProjectObj
	implements IIntNetSubProjectObj
{
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected boolean isNew;
	protected IIntNetSubProjectEditObj edit;
	protected IIntNetSchemaObj schema;
	protected $implCommaIJavaOptAtomType$ pKey;
	protected IIntNetSubProject rec;
	protected ISecureTenantObj requiredOwnerTenant;
	protected IIntNetTopProjectObj requiredContainerParentTPrj;
	protected List<IIntNetMajorVersionObj> optionalComponentsMajorVer;

	public IntNetSubProjectObj() {
		isNew = true;
		requiredOwnerTenant = null;
		requiredContainerParentTPrj = null;
	}

	public IntNetSubProjectObj( IIntNetSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredOwnerTenant = null;
		requiredContainerParentTPrj = null;
	}

	@Override
	public int getClassCode() {
		return( ((IIntNetSchemaObj)schema).getSubProjectTableObj().getClassCode() );
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
		IIntNetSubProjectObj retobj = ((IIntNetSchemaObj)getSchema()).getSubProjectTableObj().realiseSubProject(
			(IIntNetSubProjectObj)this );
		return( (IIntNetSubProjectObj)retobj );
	}

	@Override
	public void forget() {
		((IIntNetSchemaObj)getSchema()).getSubProjectTableObj().reallyDeepDisposeSubProject( (IIntNetSubProjectObj)this );
	}

	@Override
	public IIntNetSubProjectObj read() {
		IIntNetSubProjectObj retobj = ((IIntNetSchemaObj)getSchema()).getSubProjectTableObj().readSubProjectByIdIdx( getPKey(), false );
		return( (IIntNetSubProjectObj)retobj );
	}

	@Override
	public IIntNetSubProjectObj read( boolean forceRead ) {
		IIntNetSubProjectObj retobj = ((IIntNetSchemaObj)getSchema()).getSubProjectTableObj().readSubProjectByIdIdx( getPKey(), forceRead );
		return( (IIntNetSubProjectObj)retobj );
	}

	@Override
	public IIntNetSubProjectTableObj getSubProjectTable() {
		return( ((IIntNetSchemaObj)getSchema()).getSubProjectTableObj() );
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
	public IIntNetSubProject getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getIntNetBackingStore().getIntNetFactory().getFactorySubProject().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getIntNetBackingStore().getTableSubProject().readDerivedByIdIdx( ((IIntNetSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( IIntNetSubProject value ) {
		if( ! ( ( value == null ) || ! ( value instanceof IIntNetSubProject ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"IntNetSubProjectRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredOwnerTenant = null;
		requiredContainerParentTPrj = null;
	}

	@Override
	public IIntNetSubProject getSubProjectRec() {
		return( (IIntNetSubProject)getRec() );
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
	public IIntNetSubProjectEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		IIntNetSubProjectObj lockobj;
		if( getIsNew() ) {
			lockobj = (IIntNetSubProjectObj)this;
		}
		else {
			lockobj = ((IIntNetSchemaObj)getSchema()).getSubProjectTableObj().lockSubProject( getPKey() );
		}
		edit = ((IIntNetSchemaObj)getSchema()).getSubProjectTableObj().newEditInstance( lockobj );
		return( (IIntNetSubProjectEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public IIntNetSubProjectEditObj getEdit() {
		return( edit );
	}

	@Override
	public IIntNetSubProjectEditObj getEditAsSubProject() {
		return( (IIntNetSubProjectEditObj)edit );
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
				requiredOwnerTenant = ((IIntNetSchemaObj)getSchema()).getTenantTableObj().readTenantByIdIdx( getSubProjectRec().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerTenant );
	}

	@Override
	public IIntNetTopProjectObj getRequiredContainerParentTPrj() {
		return( getRequiredContainerParentTPrj( false ) );
	}

	@Override
	public IIntNetTopProjectObj getRequiredContainerParentTPrj( boolean forceRead ) {
		if( ( requiredContainerParentTPrj == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerParentTPrj = ((IIntNetSchemaObj)getSchema()).getTopProjectTableObj().readTopProjectByIdIdx( getSubProjectRec().getRequiredTopProjectId(), forceRead );
			}
		}
		return( requiredContainerParentTPrj );
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
	public String getOptionalDescription() {
		return( getSubProjectRec().getOptionalDescription() );
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
