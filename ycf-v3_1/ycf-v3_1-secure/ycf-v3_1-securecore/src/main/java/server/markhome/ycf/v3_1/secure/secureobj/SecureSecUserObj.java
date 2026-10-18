// Description: Java 25 base object instance implementation for SecUser

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

public class SecureSecUserObj
	implements ISecureSecUserObj
{
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ISecureSecUserEditObj edit;
	protected ISecureSchemaObj schema;
	protected $implCommaIJavaOptAtomType$ pKey;
	protected ISecureSecUser rec;
	protected List<ISecureSecSessionObj> optionalComponentsSecSess;
	protected List<ISecureSecSessionObj> optionalChildrenSecProxy;
	protected ISecureSecUserPasswordObj optionalComponentsPassword;
	protected ISecureSecUserEMConfObj optionalComponentsEMConf;
	protected ISecureSecUserPWResetObj optionalComponentsPWReset;
	protected ISecureSecUserPWHistoryObj optionalChildrenPWHistory;
	protected List<ISecureSecSysGrpMembObj> optionalChildrenSysSecGrpMemb;
	protected List<ISecureSecClusGrpMembObj> optionalChildrenClusSecGrpMemb;
	protected List<ISecureSecTentGrpMembObj> optionalChildrenTentSecGrpMemb;

	public SecureSecUserObj() {
		isNew = true;
	}

	public SecureSecUserObj( ISecureSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
	}

	@Override
	public int getClassCode() {
		return( ((ISecureSchemaObj)schema).getSecUserTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecUser" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		return( null );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredLoginId();
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
		if( subObj == null ) {
			try {
				if (nextName == null || (nextName != null && nextName.isEmpty())) {
					throw new YCFNullArgumentException(getClass(), "getNamedObject", 0, "RequiredEMConfirmationUuid6");
				}
				IYCFUuid6 natNextName = IYCFUuid6.fromString(nextName);
				subObj = ((ISecureSchemaObj)getSchema()).getSecUserEMConfTableObj().readSecUserEMConfByUUuid6Idx( natNextName, false );
			}
			catch (Throwable th) {
				subObj = null;
			}
		}
		if( subObj == null ) {
			try {
				if (nextName == null || (nextName != null && nextName.isEmpty())) {
					throw new YCFNullArgumentException(getClass(), "getNamedObject", 0, "RequiredPasswordResetUuid6");
				}
				IYCFUuid6 natNextName = IYCFUuid6.fromString(nextName);
				subObj = ((ISecureSchemaObj)getSchema()).getSecUserPWResetTableObj().readSecUserPWResetByUUuid6Idx( natNextName, false );
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
	public ISecureSecUserObj realise() {
		ISecureSecUserObj retobj = ((ISecureSchemaObj)getSchema()).getSecUserTableObj().realiseSecUser(
			(ISecureSecUserObj)this );
		return( (ISecureSecUserObj)retobj );
	}

	@Override
	public void forget() {
		((ISecureSchemaObj)getSchema()).getSecUserTableObj().reallyDeepDisposeSecUser( (ISecureSecUserObj)this );
	}

	@Override
	public ISecureSecUserObj read() {
		ISecureSecUserObj retobj = ((ISecureSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( getPKey(), false );
		return( (ISecureSecUserObj)retobj );
	}

	@Override
	public ISecureSecUserObj read( boolean forceRead ) {
		ISecureSecUserObj retobj = ((ISecureSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( getPKey(), forceRead );
		return( (ISecureSecUserObj)retobj );
	}

	@Override
	public ISecureSecUserTableObj getSecUserTable() {
		return( ((ISecureSchemaObj)getSchema()).getSecUserTableObj() );
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
	public ISecureSecUser getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getSecureBackingStore().getSecureFactory().getFactorySecUser().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getSecureBackingStore().getTableSecUser().readDerivedByIdIdx( ((ISecureSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecUser value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ISecureSecUser ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"SecureSecUserRec" );
		}
		rec = value;
		copyRecToPKey();
	}

	@Override
	public ISecureSecUser getSecUserRec() {
		return( (ISecureSecUser)getRec() );
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
	public ISecureSecUserEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ISecureSecUserObj lockobj;
		if( getIsNew() ) {
			lockobj = (ISecureSecUserObj)this;
		}
		else {
			lockobj = ((ISecureSchemaObj)getSchema()).getSecUserTableObj().lockSecUser( getPKey() );
		}
		edit = ((ISecureSchemaObj)getSchema()).getSecUserTableObj().newEditInstance( lockobj );
		return( (ISecureSecUserEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ISecureSecUserEditObj getEdit() {
		return( edit );
	}

	@Override
	public ISecureSecUserEditObj getEditAsSecUser() {
		return( (ISecureSecUserEditObj)edit );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureSecUser rec = getRec();
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
			ISecureSecUser rec = getRec();
			updatedBy = ((ISecureSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public IYCFKeyHash256 getRequiredSecUserId() {
		return( getPKey() );
	}

	@Override
	public List<ISecureSecSessionObj> getOptionalComponentsSecSess() {
		List<ISecureSecSessionObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSessionTableObj().readSecSessionBySecUserIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecSessionObj> getOptionalComponentsSecSess( boolean forceRead ) {
		List<ISecureSecSessionObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSessionTableObj().readSecSessionBySecUserIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecSessionObj> getOptionalChildrenSecProxy() {
		List<ISecureSecSessionObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSessionTableObj().readSecSessionBySecProxyIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecSessionObj> getOptionalChildrenSecProxy( boolean forceRead ) {
		List<ISecureSecSessionObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSessionTableObj().readSecSessionBySecProxyIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public ISecureSecUserPasswordObj getOptionalComponentsPassword() {
		return( getOptionalComponentsPassword( false ) );
	}

	@Override
	public ISecureSecUserPasswordObj getOptionalComponentsPassword( boolean forceRead ) {
		if( ( optionalComponentsPassword == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				optionalComponentsPassword = ((ISecureSchemaObj)getSchema()).getSecUserPasswordTableObj().readSecUserPasswordByIdIdx( getPKey(), forceRead );
			}
		}
		return( optionalComponentsPassword );
	}

	@Override
	public ISecureSecUserEMConfObj getOptionalComponentsEMConf() {
		return( getOptionalComponentsEMConf( false ) );
	}

	@Override
	public ISecureSecUserEMConfObj getOptionalComponentsEMConf( boolean forceRead ) {
		if( ( optionalComponentsEMConf == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				optionalComponentsEMConf = ((ISecureSchemaObj)getSchema()).getSecUserEMConfTableObj().readSecUserEMConfByIdIdx( getPKey(), forceRead );
			}
		}
		return( optionalComponentsEMConf );
	}

	@Override
	public ISecureSecUserPWResetObj getOptionalComponentsPWReset() {
		return( getOptionalComponentsPWReset( false ) );
	}

	@Override
	public ISecureSecUserPWResetObj getOptionalComponentsPWReset( boolean forceRead ) {
		if( ( optionalComponentsPWReset == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				optionalComponentsPWReset = ((ISecureSchemaObj)getSchema()).getSecUserPWResetTableObj().readSecUserPWResetByIdIdx( getPKey(), forceRead );
			}
		}
		return( optionalComponentsPWReset );
	}

	@Override
	public ISecureSecUserPWHistoryObj getOptionalChildrenPWHistory() {
		return( getOptionalChildrenPWHistory( false ) );
	}

	@Override
	public ISecureSecUserPWHistoryObj getOptionalChildrenPWHistory( boolean forceRead ) {
		if( ( optionalChildrenPWHistory == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				optionalChildrenPWHistory = ((ISecureSchemaObj)getSchema()).getSecUserPWHistoryTableObj().readSecUserPWHistoryByUserIdx( getPKey(), forceRead );
			}
		}
		return( optionalChildrenPWHistory );
	}

	@Override
	public List<ISecureSecSysGrpMembObj> getOptionalChildrenSysSecGrpMemb() {
		List<ISecureSecSysGrpMembObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSysGrpMembTableObj().readSecSysGrpMembByLoginIdx( getSecUserRec().getRequiredLoginId(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecSysGrpMembObj> getOptionalChildrenSysSecGrpMemb( boolean forceRead ) {
		List<ISecureSecSysGrpMembObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecSysGrpMembTableObj().readSecSysGrpMembByLoginIdx( getSecUserRec().getRequiredLoginId(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecClusGrpMembObj> getOptionalChildrenClusSecGrpMemb() {
		List<ISecureSecClusGrpMembObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecClusGrpMembTableObj().readSecClusGrpMembByLoginIdx( getSecUserRec().getRequiredLoginId(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecClusGrpMembObj> getOptionalChildrenClusSecGrpMemb( boolean forceRead ) {
		List<ISecureSecClusGrpMembObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecClusGrpMembTableObj().readSecClusGrpMembByLoginIdx( getSecUserRec().getRequiredLoginId(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecTentGrpMembObj> getOptionalChildrenTentSecGrpMemb() {
		List<ISecureSecTentGrpMembObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecTentGrpMembTableObj().readSecTentGrpMembByUserIdx( getSecUserRec().getRequiredLoginId(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecTentGrpMembObj> getOptionalChildrenTentSecGrpMemb( boolean forceRead ) {
		List<ISecureSecTentGrpMembObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecTentGrpMembTableObj().readSecTentGrpMembByUserIdx( getSecUserRec().getRequiredLoginId(),
			forceRead );
		return( retval );
	}

	@Override
	public String getRequiredLoginId() {
		return( getSecUserRec().getRequiredLoginId() );
	}

	@Override
	public ISecurePubSchema.SecAccountStatusEnum getRequiredAccountStatus() {
		return( getSecUserRec().getRequiredAccountStatus() );
	}

	@Override
	public String getOptionalDfltSysGrpName() {
		return( getSecUserRec().getOptionalDfltSysGrpName() );
	}

	@Override
	public String getOptionalDfltClusGrpName() {
		return( getSecUserRec().getOptionalDfltClusGrpName() );
	}

	@Override
	public String getOptionalDfltTentGrpName() {
		return( getSecUserRec().getOptionalDfltTentGrpName() );
	}

	@Override
	public String getRequiredEMailAddress() {
		return( getSecUserRec().getRequiredEMailAddress() );
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
