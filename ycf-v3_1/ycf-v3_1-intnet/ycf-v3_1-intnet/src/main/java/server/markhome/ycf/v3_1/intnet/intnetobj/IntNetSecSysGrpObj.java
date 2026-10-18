// Description: Java 25 base object instance implementation for SecSysGrp

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

public class IntNetSecSysGrpObj
	implements IIntNetSecSysGrpObj
{
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ISecureSecSysGrpEditObj edit;
	protected ISecureSchemaObj schema;
	protected $implCommaIJavaOptAtomType$ pKey;
	protected ISecureSecSysGrp rec;
	protected List<ISecureSecSysGrpIncObj> optionalComponentsIncByGrp;
	protected List<ISecureSecSysGrpMembObj> optionalChildrenMembByGrp;
	protected List<ISecureSecClusGrpObj> optionalComponentsImplClusGrp;
	protected List<ISecureSecTentGrpObj> optionalComponentsImplTentGrp;
	protected ISecureSecSysRoleObj optionalComponentsImplSysRole;
	protected List<ISecureSecClusRoleObj> optionalComponentsImplClusRole;
	protected List<ISecureSecTentRoleObj> optionalComponentsImplTentRole;
	protected List<ISecureSecSysGrpIncObj> optionalChildrenSysGrpByName;
	protected List<ISecureSecSysRoleEnablesObj> optionalChildrenRoleByEnableName;

	public IntNetSecSysGrpObj() {
		isNew = true;
	}

	public IntNetSecSysGrpObj( ISecureSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
	}

	@Override
	public int getClassCode() {
		return( ((ISecureSchemaObj)schema).getSecSysGrpTableObj().getClassCode() );
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
					throw new YCFNullArgumentException(getClass(), "getNamedObject", 0, "RequiredInclName");
				}
				String natNextName = nextName;
				subObj = ((IIntNetSchemaObj)getSchema()).getSecSysGrpIncTableObj().readSecSysGrpIncByIdIdx( getRequiredSecSysGrpId(),
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
				subObj = ((IIntNetSchemaObj)getSchema()).getSecClusGrpTableObj().readSecClusGrpByUNameIdx( getRequiredSecSysGrpId(),
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
				subObj = ((IIntNetSchemaObj)getSchema()).getSecTentGrpTableObj().readSecTentGrpByUNameIdx( getRequiredSecSysGrpId(),
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
				subObj = ((IIntNetSchemaObj)getSchema()).getSecSysRoleTableObj().readSecSysRoleByUNameIdx( natNextName, false );
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
				subObj = ((IIntNetSchemaObj)getSchema()).getSecClusRoleTableObj().readSecClusRoleByUNameIdx( getRequiredSecSysGrpId(),
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
				subObj = ((IIntNetSchemaObj)getSchema()).getSecTentRoleTableObj().readSecTentRoleByUNameIdx( getRequiredSecSysGrpId(),
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
		ISecureSecSysGrpObj retobj = ((IIntNetSchemaObj)getSchema()).getSecSysGrpTableObj().realiseSecSysGrp(
			(ISecureSecSysGrpObj)this );
		return( (ISecureSecSysGrpObj)retobj );
	}

	@Override
	public void forget() {
		((IIntNetSchemaObj)getSchema()).getSecSysGrpTableObj().reallyDeepDisposeSecSysGrp( (ISecureSecSysGrpObj)this );
	}

	@Override
	public ISecureSecSysGrpObj read() {
		ISecureSecSysGrpObj retobj = ((IIntNetSchemaObj)getSchema()).getSecSysGrpTableObj().readSecSysGrpByIdIdx( getPKey(), false );
		return( (ISecureSecSysGrpObj)retobj );
	}

	@Override
	public ISecureSecSysGrpObj read( boolean forceRead ) {
		ISecureSecSysGrpObj retobj = ((IIntNetSchemaObj)getSchema()).getSecSysGrpTableObj().readSecSysGrpByIdIdx( getPKey(), forceRead );
		return( (ISecureSecSysGrpObj)retobj );
	}

	@Override
	public ISecureSecSysGrpTableObj getSecSysGrpTable() {
		return( ((IIntNetSchemaObj)getSchema()).getSecSysGrpTableObj() );
	}

	@Override
	public ISecureSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( ISecureSchemaObj value ) {
		schema = value;
	}

	@Override
	public ISecureSecSysGrp getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getSecureBackingStore().getSecureFactory().getFactorySecSysGrp().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getSecureBackingStore().getTableSecSysGrp().readDerivedByIdIdx( ((IIntNetSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecSysGrp value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ISecureSecSysGrp ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"SecureSecSysGrpRec" );
		}
		rec = value;
		copyRecToPKey();
	}

	@Override
	public ISecureSecSysGrp getSecSysGrpRec() {
		return( (ISecureSecSysGrp)getRec() );
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
	public ISecureSecSysGrpEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ISecureSecSysGrpObj lockobj;
		if( getIsNew() ) {
			lockobj = (ISecureSecSysGrpObj)this;
		}
		else {
			lockobj = ((IIntNetSchemaObj)getSchema()).getSecSysGrpTableObj().lockSecSysGrp( getPKey() );
		}
		edit = ((IIntNetSchemaObj)getSchema()).getSecSysGrpTableObj().newEditInstance( lockobj );
		return( (ISecureSecSysGrpEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ISecureSecSysGrpEditObj getEdit() {
		return( edit );
	}

	@Override
	public ISecureSecSysGrpEditObj getEditAsSecSysGrp() {
		return( (ISecureSecSysGrpEditObj)edit );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureSecSysGrp rec = getRec();
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
			ISecureSecSysGrp rec = getRec();
			updatedBy = ((IIntNetSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public IYCFKeyHash256 getRequiredSecSysGrpId() {
		return( getPKey() );
	}

	@Override
	public List<ISecureSecSysGrpIncObj> getOptionalComponentsIncByGrp() {
		List<ISecureSecSysGrpIncObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecSysGrpIncTableObj().readSecSysGrpIncBySysGrpIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecSysGrpIncObj> getOptionalComponentsIncByGrp( boolean forceRead ) {
		List<ISecureSecSysGrpIncObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecSysGrpIncTableObj().readSecSysGrpIncBySysGrpIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecSysGrpMembObj> getOptionalChildrenMembByGrp() {
		List<ISecureSecSysGrpMembObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecSysGrpMembTableObj().readSecSysGrpMembBySysGrpIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecSysGrpMembObj> getOptionalChildrenMembByGrp( boolean forceRead ) {
		List<ISecureSecSysGrpMembObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecSysGrpMembTableObj().readSecSysGrpMembBySysGrpIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecClusGrpObj> getOptionalComponentsImplClusGrp() {
		List<ISecureSecClusGrpObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecClusGrpTableObj().readSecClusGrpByNameIdx( getSecSysGrpRec().getRequiredName(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecClusGrpObj> getOptionalComponentsImplClusGrp( boolean forceRead ) {
		List<ISecureSecClusGrpObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecClusGrpTableObj().readSecClusGrpByNameIdx( getSecSysGrpRec().getRequiredName(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecTentGrpObj> getOptionalComponentsImplTentGrp() {
		List<ISecureSecTentGrpObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecTentGrpTableObj().readSecTentGrpByNameIdx( getSecSysGrpRec().getRequiredName(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecTentGrpObj> getOptionalComponentsImplTentGrp( boolean forceRead ) {
		List<ISecureSecTentGrpObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecTentGrpTableObj().readSecTentGrpByNameIdx( getSecSysGrpRec().getRequiredName(),
			forceRead );
		return( retval );
	}

	@Override
	public ISecureSecSysRoleObj getOptionalComponentsImplSysRole() {
		return( getOptionalComponentsImplSysRole( false ) );
	}

	@Override
	public ISecureSecSysRoleObj getOptionalComponentsImplSysRole( boolean forceRead ) {
		if( ( optionalComponentsImplSysRole == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				optionalComponentsImplSysRole = ((IIntNetSchemaObj)getSchema()).getSecSysRoleTableObj().readSecSysRoleByIdIdx( getPKey(), forceRead );
			}
		}
		return( optionalComponentsImplSysRole );
	}

	@Override
	public List<ISecureSecClusRoleObj> getOptionalComponentsImplClusRole() {
		List<ISecureSecClusRoleObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecClusRoleTableObj().readSecClusRoleByNameIdx( getSecSysGrpRec().getRequiredName(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecClusRoleObj> getOptionalComponentsImplClusRole( boolean forceRead ) {
		List<ISecureSecClusRoleObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecClusRoleTableObj().readSecClusRoleByNameIdx( getSecSysGrpRec().getRequiredName(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecTentRoleObj> getOptionalComponentsImplTentRole() {
		List<ISecureSecTentRoleObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecTentRoleTableObj().readSecTentRoleByNameIdx( getSecSysGrpRec().getRequiredName(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecTentRoleObj> getOptionalComponentsImplTentRole( boolean forceRead ) {
		List<ISecureSecTentRoleObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecTentRoleTableObj().readSecTentRoleByNameIdx( getSecSysGrpRec().getRequiredName(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecSysGrpIncObj> getOptionalChildrenSysGrpByName() {
		List<ISecureSecSysGrpIncObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecSysGrpIncTableObj().readSecSysGrpIncByNameIdx( getSecSysGrpRec().getRequiredName(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecSysGrpIncObj> getOptionalChildrenSysGrpByName( boolean forceRead ) {
		List<ISecureSecSysGrpIncObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecSysGrpIncTableObj().readSecSysGrpIncByNameIdx( getSecSysGrpRec().getRequiredName(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecSysRoleEnablesObj> getOptionalChildrenRoleByEnableName() {
		List<ISecureSecSysRoleEnablesObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecSysRoleEnablesTableObj().readSecSysRoleEnablesByNameIdx( getSecSysGrpRec().getRequiredName(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecSysRoleEnablesObj> getOptionalChildrenRoleByEnableName( boolean forceRead ) {
		List<ISecureSecSysRoleEnablesObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecSysRoleEnablesTableObj().readSecSysRoleEnablesByNameIdx( getSecSysGrpRec().getRequiredName(),
			forceRead );
		return( retval );
	}

	@Override
	public String getRequiredName() {
		return( getSecSysGrpRec().getRequiredName() );
	}

	@Override
	public ISecurePubSchema.SecLevelEnum getRequiredSecLevel() {
		return( getSecSysGrpRec().getRequiredSecLevel() );
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
