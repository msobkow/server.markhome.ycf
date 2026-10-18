// Description: Java 25 edit object instance implementation for BusModel SecUser.

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

public class BusModelSecUserEditObj
	implements IBusModelSecUserEditObj
{
	protected ISecureSecUserObj orig;
	protected ISecureSecUser rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected List<ISecureSecSessionObj> optionalComponentsSecSess;
	protected List<ISecureSecSessionObj> optionalChildrenSecProxy;
	protected ISecureSecUserPasswordObj optionalComponentsPassword;
	protected ISecureSecUserEMConfObj optionalComponentsEMConf;
	protected ISecureSecUserPWResetObj optionalComponentsPWReset;
	protected ISecureSecUserPWHistoryObj optionalChildrenPWHistory;
	protected List<ISecureSecSysGrpMembObj> optionalChildrenSysSecGrpMemb;
	protected List<ISecureSecClusGrpMembObj> optionalChildrenClusSecGrpMemb;
	protected List<ISecureSecTentGrpMembObj> optionalChildrenTentSecGrpMemb;

	public BusModelSecUserEditObj( ISecureSecUserObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureSecUser origRec = orig.getRec();
		rec.set( origRec );
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
		return( ((ISecureSchemaObj)orig.getSchema()).getSecUserTableObj().getClassCode() );
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
		// We realise this so that it's record will get copied to orig during realization
		ISecureSecUserObj retobj = getSchema().getSecUserTableObj().realiseSecUser( (IBusModelSecUserObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecUser().forget();
	}

	@Override
	public ISecureSecUserObj read() {
		ISecureSecUserObj retval = getOrigAsSecUser().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecUserObj read( boolean forceRead ) {
		ISecureSecUserObj retval = getOrigAsSecUser().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecUserObj create() {
		copyRecToOrig();
		ISecureSecUserObj retobj = ((IBusModelSchemaObj)getOrigAsSecUser().getSchema()).getSecUserTableObj().createSecUser( getOrigAsSecUser() );
		if( retobj == getOrigAsSecUser() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureSecUserEditObj update() {
		getSchema().getSecUserTableObj().updateSecUser( (ISecureSecUserObj)this );
		return( null );
	}

	@Override
	public SecureSecUserEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecUserTableObj().deleteSecUser( getOrigAsSecUser() );
		return( null );
	}

	@Override
	public ISecureSecUserTableObj getSecUserTable() {
		return( orig.getSchema().getSecUserTableObj() );
	}

	@Override
	public ISecureSecUserEditObj getEdit() {
		return( (ISecureSecUserEditObj)this );
	}

	@Override
	public ISecureSecUserEditObj getEditAsSecUser() {
		return( (ISecureSecUserEditObj)this );
	}

	@Override
	public ISecureSecUserEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureSecUserObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureSecUserObj getOrigAsSecUser() {
		return( (ISecureSecUserObj)orig );
	}

	@Override
	public ISecureSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	@Override
	public void setSchema( ISecureSchemaObj value ) {
		orig.setSchema(value);
	}

	@Override
	public ISecureSecUser getRec() {
		if( rec == null ) {
			rec = getOrigAsSecUser().getSchema().getSecureBackingStore().getSecureFactory().getFactorySecUser().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecUser value ) {
		if( rec != value ) {
			rec = value;
		}
	}

	@Override
	public ISecureSecUser getSecUserRec() {
		return( (ISecureSecUser)getRec() );
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
	public IYCFKeyHash256 getRequiredSecUserId() {
		return( getPKey() );
	}

	@Override
	public void setRequiredSecUserId(IYCFKeyHash256 value) {
		if (getPKey() != value) {
			setPKey(value);
			optionalComponentsSecSess = null;
			optionalChildrenSecProxy = null;
			optionalComponentsPassword = null;
			optionalComponentsEMConf = null;
			optionalComponentsPWReset = null;
			optionalChildrenPWHistory = null;
			optionalChildrenSysSecGrpMemb = null;
			optionalChildrenClusSecGrpMemb = null;
			optionalChildrenTentSecGrpMemb = null;
		}
	}

	@Override
	public String getRequiredLoginId() {
		return( getSecUserRec().getRequiredLoginId() );
	}

	@Override
	public void setRequiredLoginId( String value ) {
		if( getSecUserRec().getRequiredLoginId() != value ) {
			getSecUserRec().setRequiredLoginId( value );
			optionalComponentsSecSess = null;
			optionalChildrenSecProxy = null;
			optionalComponentsPassword = null;
			optionalComponentsEMConf = null;
			optionalComponentsPWReset = null;
			optionalChildrenPWHistory = null;
			optionalChildrenSysSecGrpMemb = null;
			optionalChildrenClusSecGrpMemb = null;
			optionalChildrenTentSecGrpMemb = null;
		}
	}

	@Override
	public ISecurePubSchema.SecAccountStatusEnum getRequiredAccountStatus() {
		return( getSecUserRec().getRequiredAccountStatus() );
	}

	@Override
	public void setRequiredAccountStatus( ISecurePubSchema.SecAccountStatusEnum value ) {
		if( getSecUserRec().getRequiredAccountStatus() != value ) {
			getSecUserRec().setRequiredAccountStatus( value );
		}
	}

	@Override
	public String getOptionalDfltSysGrpName() {
		return( getSecUserRec().getOptionalDfltSysGrpName() );
	}

	@Override
	public void setOptionalDfltSysGrpName( String value ) {
		if( getSecUserRec().getOptionalDfltSysGrpName() != value ) {
			getSecUserRec().setOptionalDfltSysGrpName( value );
		}
	}

	@Override
	public String getOptionalDfltClusGrpName() {
		return( getSecUserRec().getOptionalDfltClusGrpName() );
	}

	@Override
	public void setOptionalDfltClusGrpName( String value ) {
		if( getSecUserRec().getOptionalDfltClusGrpName() != value ) {
			getSecUserRec().setOptionalDfltClusGrpName( value );
		}
	}

	@Override
	public String getOptionalDfltTentGrpName() {
		return( getSecUserRec().getOptionalDfltTentGrpName() );
	}

	@Override
	public void setOptionalDfltTentGrpName( String value ) {
		if( getSecUserRec().getOptionalDfltTentGrpName() != value ) {
			getSecUserRec().setOptionalDfltTentGrpName( value );
		}
	}

	@Override
	public String getRequiredEMailAddress() {
		return( getSecUserRec().getRequiredEMailAddress() );
	}

	@Override
	public void setRequiredEMailAddress( String value ) {
		if( getSecUserRec().getRequiredEMailAddress() != value ) {
			getSecUserRec().setRequiredEMailAddress( value );
		}
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
		if( forceRead || ( optionalComponentsPassword == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecUserPasswordObj obj = ((IBusModelSchemaObj)getOrigAsSecUser().getSchema()).getSecUserPasswordTableObj().readSecUserPasswordByIdIdx( getPKey() );
				optionalComponentsPassword = obj;
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
		if( forceRead || ( optionalComponentsEMConf == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecUserEMConfObj obj = ((IBusModelSchemaObj)getOrigAsSecUser().getSchema()).getSecUserEMConfTableObj().readSecUserEMConfByIdIdx( getPKey() );
				optionalComponentsEMConf = obj;
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
		if( forceRead || ( optionalComponentsPWReset == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecUserPWResetObj obj = ((IBusModelSchemaObj)getOrigAsSecUser().getSchema()).getSecUserPWResetTableObj().readSecUserPWResetByIdIdx( getPKey() );
				optionalComponentsPWReset = obj;
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
		if( forceRead || ( optionalChildrenPWHistory == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecUserPWHistoryObj obj = ((IBusModelSchemaObj)getOrigAsSecUser().getSchema()).getSecUserPWHistoryTableObj().readSecUserPWHistoryByUserIdx( getPKey() );
				optionalChildrenPWHistory = obj;
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
		ISecureSecUser origRec = getOrigAsSecUser().getSecUserRec();
		ISecureSecUser myRec = getSecUserRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureSecUser origRec = getOrigAsSecUser().getSecUserRec();
		ISecureSecUser myRec = getSecUserRec();
		myRec.set( origRec );
	}
}
