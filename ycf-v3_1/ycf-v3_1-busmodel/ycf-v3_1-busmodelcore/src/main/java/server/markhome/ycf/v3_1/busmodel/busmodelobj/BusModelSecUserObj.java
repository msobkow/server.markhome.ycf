// Description: Java 25 base object instance implementation for SecUser

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodelobj;

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public class BusModelSecUserObj
	implements IBusModelSecUserObj
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

	public BusModelSecUserObj() {
		isNew = true;
	}

	public BusModelSecUserObj( ISecureSchemaObj argSchema ) {
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
				if( container instanceof IBusModelClusterObj ) {
					break;
				}
				else if( container instanceof IBusModelTenantObj ) {
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
				if( container instanceof IBusModelClusterObj ) {
					break;
				}
				else if( container instanceof IBusModelTenantObj ) {
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
				subObj = ((IBusModelSchemaObj)getSchema()).getSecUserEMConfTableObj().readSecUserEMConfByUUuid6Idx( natNextName, false );
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
				subObj = ((IBusModelSchemaObj)getSchema()).getSecUserPWResetTableObj().readSecUserPWResetByUUuid6Idx( natNextName, false );
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
		ISecureSecUserObj retobj = ((IBusModelSchemaObj)getSchema()).getSecUserTableObj().realiseSecUser(
			(ISecureSecUserObj)this );
		return( (ISecureSecUserObj)retobj );
	}

	@Override
	public void forget() {
		((IBusModelSchemaObj)getSchema()).getSecUserTableObj().reallyDeepDisposeSecUser( (ISecureSecUserObj)this );
	}

	@Override
	public ISecureSecUserObj read() {
		ISecureSecUserObj retobj = ((IBusModelSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( getPKey(), false );
		return( (ISecureSecUserObj)retobj );
	}

	@Override
	public ISecureSecUserObj read( boolean forceRead ) {
		ISecureSecUserObj retobj = ((IBusModelSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( getPKey(), forceRead );
		return( (ISecureSecUserObj)retobj );
	}

	@Override
	public ISecureSecUserTableObj getSecUserTable() {
		return( ((IBusModelSchemaObj)getSchema()).getSecUserTableObj() );
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
				rec = getSchema().getSecureBackingStore().getTableSecUser().readDerivedByIdIdx( ((IBusModelSchemaObj)getSchema()).getAuthorization(),
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
			lockobj = ((IBusModelSchemaObj)getSchema()).getSecUserTableObj().lockSecUser( getPKey() );
		}
		edit = ((IBusModelSchemaObj)getSchema()).getSecUserTableObj().newEditInstance( lockobj );
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
			createdBy = ((IBusModelSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getCreatedByUserId() );
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
			updatedBy = ((IBusModelSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
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
		retval = ((IBusModelSchemaObj)getSchema()).getSecSessionTableObj().readSecSessionBySecUserIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecSessionObj> getOptionalComponentsSecSess( boolean forceRead ) {
		List<ISecureSecSessionObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getSecSessionTableObj().readSecSessionBySecUserIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecSessionObj> getOptionalChildrenSecProxy() {
		List<ISecureSecSessionObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getSecSessionTableObj().readSecSessionBySecProxyIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecSessionObj> getOptionalChildrenSecProxy( boolean forceRead ) {
		List<ISecureSecSessionObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getSecSessionTableObj().readSecSessionBySecProxyIdx( getPKey(),
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
				optionalComponentsPassword = ((IBusModelSchemaObj)getSchema()).getSecUserPasswordTableObj().readSecUserPasswordByIdIdx( getPKey(), forceRead );
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
				optionalComponentsEMConf = ((IBusModelSchemaObj)getSchema()).getSecUserEMConfTableObj().readSecUserEMConfByIdIdx( getPKey(), forceRead );
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
				optionalComponentsPWReset = ((IBusModelSchemaObj)getSchema()).getSecUserPWResetTableObj().readSecUserPWResetByIdIdx( getPKey(), forceRead );
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
				optionalChildrenPWHistory = ((IBusModelSchemaObj)getSchema()).getSecUserPWHistoryTableObj().readSecUserPWHistoryByUserIdx( getPKey(), forceRead );
			}
		}
		return( optionalChildrenPWHistory );
	}

	@Override
	public List<ISecureSecSysGrpMembObj> getOptionalChildrenSysSecGrpMemb() {
		List<ISecureSecSysGrpMembObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getSecSysGrpMembTableObj().readSecSysGrpMembByLoginIdx( getSecUserRec().getRequiredLoginId(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecSysGrpMembObj> getOptionalChildrenSysSecGrpMemb( boolean forceRead ) {
		List<ISecureSecSysGrpMembObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getSecSysGrpMembTableObj().readSecSysGrpMembByLoginIdx( getSecUserRec().getRequiredLoginId(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecClusGrpMembObj> getOptionalChildrenClusSecGrpMemb() {
		List<ISecureSecClusGrpMembObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getSecClusGrpMembTableObj().readSecClusGrpMembByLoginIdx( getSecUserRec().getRequiredLoginId(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecClusGrpMembObj> getOptionalChildrenClusSecGrpMemb( boolean forceRead ) {
		List<ISecureSecClusGrpMembObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getSecClusGrpMembTableObj().readSecClusGrpMembByLoginIdx( getSecUserRec().getRequiredLoginId(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecTentGrpMembObj> getOptionalChildrenTentSecGrpMemb() {
		List<ISecureSecTentGrpMembObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getSecTentGrpMembTableObj().readSecTentGrpMembByUserIdx( getSecUserRec().getRequiredLoginId(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecTentGrpMembObj> getOptionalChildrenTentSecGrpMemb( boolean forceRead ) {
		List<ISecureSecTentGrpMembObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getSecTentGrpMembTableObj().readSecTentGrpMembByUserIdx( getSecUserRec().getRequiredLoginId(),
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
