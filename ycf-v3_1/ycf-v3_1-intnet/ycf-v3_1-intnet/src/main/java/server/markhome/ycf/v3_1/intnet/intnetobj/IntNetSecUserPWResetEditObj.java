// Description: Java 25 edit object instance implementation for IntNet SecUserPWReset.

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

public class IntNetSecUserPWResetEditObj
	implements IIntNetSecUserPWResetEditObj
{
	protected ISecureSecUserPWResetObj orig;
	protected ISecureSecUserPWReset rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected ISecureSecUserObj requiredContainerUser;

	public IntNetSecUserPWResetEditObj( ISecureSecUserPWResetObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureSecUserPWReset origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerUser = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureSecUserPWReset rec = getRec();
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
			ISecureSecUserPWReset rec = getRec();
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
		return( ((ISecureSchemaObj)orig.getSchema()).getSecUserPWResetTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecUserPWReset" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		ISecureSecUserObj scope = getRequiredContainerUser();
		return( scope );
	}

	@Override
	public String getObjName() {
		String objName;
		IYCFUuid6 val = rec.getRequiredPasswordResetUuid6();
		if (val != null) {
			objName = val.toString();
		}
		else {
			objName = "";
		}
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
	public ISecureSecUserPWResetObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureSecUserPWResetObj retobj = getSchema().getSecUserPWResetTableObj().realiseSecUserPWReset( (IIntNetSecUserPWResetObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecUserPWReset().forget();
	}

	@Override
	public ISecureSecUserPWResetObj read() {
		ISecureSecUserPWResetObj retval = getOrigAsSecUserPWReset().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecUserPWResetObj read( boolean forceRead ) {
		ISecureSecUserPWResetObj retval = getOrigAsSecUserPWReset().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecUserPWResetObj create() {
		copyRecToOrig();
		ISecureSecUserPWResetObj retobj = ((IIntNetSchemaObj)getOrigAsSecUserPWReset().getSchema()).getSecUserPWResetTableObj().createSecUserPWReset( getOrigAsSecUserPWReset() );
		if( retobj == getOrigAsSecUserPWReset() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureSecUserPWResetEditObj update() {
		getSchema().getSecUserPWResetTableObj().updateSecUserPWReset( (ISecureSecUserPWResetObj)this );
		return( null );
	}

	@Override
	public SecureSecUserPWResetEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecUserPWResetTableObj().deleteSecUserPWReset( getOrigAsSecUserPWReset() );
		return( null );
	}

	@Override
	public ISecureSecUserPWResetTableObj getSecUserPWResetTable() {
		return( orig.getSchema().getSecUserPWResetTableObj() );
	}

	@Override
	public ISecureSecUserPWResetEditObj getEdit() {
		return( (ISecureSecUserPWResetEditObj)this );
	}

	@Override
	public ISecureSecUserPWResetEditObj getEditAsSecUserPWReset() {
		return( (ISecureSecUserPWResetEditObj)this );
	}

	@Override
	public ISecureSecUserPWResetEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureSecUserPWResetObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureSecUserPWResetObj getOrigAsSecUserPWReset() {
		return( (ISecureSecUserPWResetObj)orig );
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
	public ISecureSecUserPWReset getRec() {
		if( rec == null ) {
			rec = getOrigAsSecUserPWReset().getSchema().getSecureBackingStore().getSecureFactory().getFactorySecUserPWReset().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecUserPWReset value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerUser = null;
		}
	}

	@Override
	public ISecureSecUserPWReset getSecUserPWResetRec() {
		return( (ISecureSecUserPWReset)getRec() );
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
	public String getRequiredSentToEMailAddr() {
		return( getSecUserPWResetRec().getRequiredSentToEMailAddr() );
	}

	@Override
	public void setRequiredSentToEMailAddr( String value ) {
		if( getSecUserPWResetRec().getRequiredSentToEMailAddr() != value ) {
			getSecUserPWResetRec().setRequiredSentToEMailAddr( value );
		}
	}

	@Override
	public IYCFUuid6 getRequiredPasswordResetUuid6() {
		return( getSecUserPWResetRec().getRequiredPasswordResetUuid6() );
	}

	@Override
	public void setRequiredPasswordResetUuid6( IYCFUuid6 value ) {
		if( getSecUserPWResetRec().getRequiredPasswordResetUuid6() != value ) {
			getSecUserPWResetRec().setRequiredPasswordResetUuid6( value );
		}
	}

	@Override
	public boolean getRequiredNewAccount() {
		return( getSecUserPWResetRec().getRequiredNewAccount() );
	}

	@Override
	public void setRequiredNewAccount( boolean value ) {
		if( getSecUserPWResetRec().getRequiredNewAccount() != value ) {
			getSecUserPWResetRec().setRequiredNewAccount( value );
		}
	}

	@Override
	public ISecureSecUserObj getRequiredContainerUser() {
		return( getRequiredContainerUser( false ) );
	}

	@Override
	public ISecureSecUserObj getRequiredContainerUser( boolean forceRead ) {
		if( forceRead || ( requiredContainerUser == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecUserObj obj = ((IIntNetSchemaObj)getOrigAsSecUserPWReset().getSchema()).getSecUserTableObj().readSecUserByIdIdx( getPKey() );
				requiredContainerUser = obj;
				if( obj != null ) {
					requiredContainerUser = obj;
				}
			}
		}
		return( requiredContainerUser );
	}

	@Override
	public void setRequiredContainerUser( ISecureSecUserObj value ) {
		if( rec == null ) {
			getSecUserPWResetRec();
		}
		if( value != null ) {
			requiredContainerUser = value;
			getSecUserPWResetRec().setRequiredContainerUser(value.getSecUserRec());
		}
		requiredContainerUser = value;
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
		ISecureSecUserPWReset origRec = getOrigAsSecUserPWReset().getSecUserPWResetRec();
		ISecureSecUserPWReset myRec = getSecUserPWResetRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureSecUserPWReset origRec = getOrigAsSecUserPWReset().getSecUserPWResetRec();
		ISecureSecUserPWReset myRec = getSecUserPWResetRec();
		myRec.set( origRec );
	}
}
