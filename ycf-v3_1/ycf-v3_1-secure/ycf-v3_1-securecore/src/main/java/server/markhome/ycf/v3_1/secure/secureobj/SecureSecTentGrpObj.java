// Description: Java 25 base object instance implementation for SecTentGrp

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
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

package server.markhome.ycf.v3_1.secure.secureobj;

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
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;

public class SecureSecTentGrpObj
	implements ISecureSecTentGrpObj
{
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ISecureSecTentGrpEditObj edit;
	protected ISecureSchemaObj schema;
	protected $implCommaIJavaOptAtomType$ pKey;
	protected ISecureSecTentGrp rec;
	protected ISecureTenantObj requiredOwnerTenant;
	protected ISecureSecSysGrpObj requiredContainerSysGrp;
	protected List<ISecureSecTentGrpMembObj> optionalChildrenMembByGrp;

	public SecureSecTentGrpObj() {
		isNew = true;
		requiredOwnerTenant = null;
		requiredContainerSysGrp = null;
	}

	public SecureSecTentGrpObj( ISecureSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredOwnerTenant = null;
		requiredContainerSysGrp = null;
	}

	@Override
	public int getClassCode() {
		return( ((ISecureSchemaObj)schema).getSecTentGrpTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecTentGrp" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		ISecureSecSysGrpObj scope = getRequiredContainerSysGrp();
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
				if( container instanceof ISecureClusterObj ) {
					break;
				}
				else if( container instanceof ISecureTenantObj ) {
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
				if( container instanceof ISecureClusterObj ) {
					break;
				}
				else if( container instanceof ISecureTenantObj ) {
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
	public ISecureSecTentGrpObj realise() {
		ISecureSecTentGrpObj retobj = ((ISecureSchemaObj)getSchema()).getSecTentGrpTableObj().realiseSecTentGrp(
			(ISecureSecTentGrpObj)this );
		return( (ISecureSecTentGrpObj)retobj );
	}

	@Override
	public void forget() {
		((ISecureSchemaObj)getSchema()).getSecTentGrpTableObj().reallyDeepDisposeSecTentGrp( (ISecureSecTentGrpObj)this );
	}

	@Override
	public ISecureSecTentGrpObj read() {
		ISecureSecTentGrpObj retobj = ((ISecureSchemaObj)getSchema()).getSecTentGrpTableObj().readSecTentGrpByIdIdx( getPKey(), false );
		return( (ISecureSecTentGrpObj)retobj );
	}

	@Override
	public ISecureSecTentGrpObj read( boolean forceRead ) {
		ISecureSecTentGrpObj retobj = ((ISecureSchemaObj)getSchema()).getSecTentGrpTableObj().readSecTentGrpByIdIdx( getPKey(), forceRead );
		return( (ISecureSecTentGrpObj)retobj );
	}

	@Override
	public ISecureSecTentGrpTableObj getSecTentGrpTable() {
		return( ((ISecureSchemaObj)getSchema()).getSecTentGrpTableObj() );
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
	public ISecureSecTentGrp getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getSecureBackingStore().getTableSecTentGrp().readDerivedByIdIdx( ((ISecureSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecTentGrp value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ISecureSecTentGrp ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"SecureSecTentGrpRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredOwnerTenant = null;
		requiredContainerSysGrp = null;
	}

	@Override
	public ISecureSecTentGrp getSecTentGrpRec() {
		return( (ISecureSecTentGrp)getRec() );
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
	public ISecureSecTentGrpEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ISecureSecTentGrpObj lockobj;
		if( getIsNew() ) {
			lockobj = (ISecureSecTentGrpObj)this;
		}
		else {
			lockobj = ((ISecureSchemaObj)getSchema()).getSecTentGrpTableObj().lockSecTentGrp( getPKey() );
		}
		edit = ((ISecureSchemaObj)getSchema()).getSecTentGrpTableObj().newEditInstance( lockobj );
		return( (ISecureSecTentGrpEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ISecureSecTentGrpEditObj getEdit() {
		return( edit );
	}

	@Override
	public ISecureSecTentGrpEditObj getEditAsSecTentGrp() {
		return( (ISecureSecTentGrpEditObj)edit );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureSecTentGrp rec = getRec();
			createdBy = ((ISecureSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getCreatedByUserId() );
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
			ISecureSecTentGrp rec = getRec();
			updatedBy = ((ISecureSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public IYCFKeyHash256 getRequiredSecTentGrpId() {
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
				requiredOwnerTenant = ((ISecureSchemaObj)getSchema()).getTenantTableObj().readTenantByIdIdx( getSecTentGrpRec().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerTenant );
	}

	@Override
	public ISecureSecSysGrpObj getRequiredContainerSysGrp() {
		return( getRequiredContainerSysGrp( false ) );
	}

	@Override
	public ISecureSecSysGrpObj getRequiredContainerSysGrp( boolean forceRead ) {
		if( ( requiredContainerSysGrp == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerSysGrp = ((ISecureSchemaObj)getSchema()).getSecSysGrpTableObj().readSecSysGrpByUNameIdx( getSecTentGrpRec().getRequiredName(), forceRead );
			}
		}
		return( requiredContainerSysGrp );
	}

	@Override
	public List<ISecureSecTentGrpMembObj> getOptionalChildrenMembByGrp() {
		List<ISecureSecTentGrpMembObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecTentGrpMembTableObj().readSecTentGrpMembByTentGrpIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecTentGrpMembObj> getOptionalChildrenMembByGrp( boolean forceRead ) {
		List<ISecureSecTentGrpMembObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecTentGrpMembTableObj().readSecTentGrpMembByTentGrpIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public IYCFKeyHash256 getRequiredTenantId() {
		return( getSecTentGrpRec().getRequiredTenantId() );
	}

	@Override
	public String getRequiredName() {
		return( getSecTentGrpRec().getRequiredName() );
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
