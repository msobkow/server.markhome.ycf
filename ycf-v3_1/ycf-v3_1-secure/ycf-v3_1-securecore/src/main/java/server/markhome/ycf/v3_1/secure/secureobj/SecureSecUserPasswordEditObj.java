// Description: Java 25 edit object instance implementation for Secure SecUserPassword.

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

public class SecureSecUserPasswordEditObj
	implements ISecureSecUserPasswordEditObj
{
	protected ISecureSecUserPasswordObj orig;
	protected ISecureSecUserPassword rec;
	protected ISecureSecUserObj requiredContainerUser;

	public SecureSecUserPasswordEditObj( ISecureSecUserPasswordObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureSecUserPassword origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerUser = null;
	}

	@Override
	public int getClassCode() {
		return( ((ISecureSchemaObj)orig.getSchema()).getSecUserPasswordTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecUserPassword" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		ISecureSecUserObj scope = getRequiredContainerUser();
		return( scope );
	}

	@Override
	public String getObjName() {
		String objName;
		YCFDbKeyHash256 val = rec.getRequiredSecUserId();
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
	public ISecureSecUserPasswordObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureSecUserPasswordObj retobj = getSchema().getSecUserPasswordTableObj().realiseSecUserPassword( (ISecureSecUserPasswordObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecUserPassword().forget();
	}

	@Override
	public ISecureSecUserPasswordObj read() {
		ISecureSecUserPasswordObj retval = getOrigAsSecUserPassword().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecUserPasswordObj read( boolean forceRead ) {
		ISecureSecUserPasswordObj retval = getOrigAsSecUserPassword().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecUserPasswordObj create() {
		copyRecToOrig();
		ISecureSecUserPasswordObj retobj = ((ISecureSchemaObj)getOrigAsSecUserPassword().getSchema()).getSecUserPasswordTableObj().createSecUserPassword( getOrigAsSecUserPassword() );
		if( retobj == getOrigAsSecUserPassword() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureSecUserPasswordEditObj update() {
		getSchema().getSecUserPasswordTableObj().updateSecUserPassword( (ISecureSecUserPasswordObj)this );
		return( null );
	}

	@Override
	public SecureSecUserPasswordEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecUserPasswordTableObj().deleteSecUserPassword( getOrigAsSecUserPassword() );
		return( null );
	}

	@Override
	public ISecureSecUserPasswordTableObj getSecUserPasswordTable() {
		return( orig.getSchema().getSecUserPasswordTableObj() );
	}

	@Override
	public ISecureSecUserPasswordEditObj getEdit() {
		return( (ISecureSecUserPasswordEditObj)this );
	}

	@Override
	public ISecureSecUserPasswordEditObj getEditAsSecUserPassword() {
		return( (ISecureSecUserPasswordEditObj)this );
	}

	@Override
	public ISecureSecUserPasswordEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureSecUserPasswordObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureSecUserPasswordObj getOrigAsSecUserPassword() {
		return( (ISecureSecUserPasswordObj)orig );
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
	public ISecureSecUserPassword getRec() {
		if( rec == null ) {
			rec = getOrigAsSecUserPassword().getSchema().getSecureBackingStore().getSecureFactory().getFactorySecUserPassword().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecUserPassword value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerUser = null;
		}
	}

	@Override
	public ISecureSecUserPassword getSecUserPasswordRec() {
		return( (ISecureSecUserPassword)getRec() );
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
	public LocalDateTime getRequiredPWSetStamp() {
		return( getSecUserPasswordRec().getRequiredPWSetStamp() );
	}

	@Override
	public void setRequiredPWSetStamp( LocalDateTime value ) {
		if( getSecUserPasswordRec().getRequiredPWSetStamp() != value ) {
			getSecUserPasswordRec().setRequiredPWSetStamp( value );
		}
	}

	@Override
	public String getRequiredPasswordHash() {
		return( getSecUserPasswordRec().getRequiredPasswordHash() );
	}

	@Override
	public void setRequiredPasswordHash( String value ) {
		if( getSecUserPasswordRec().getRequiredPasswordHash() != value ) {
			getSecUserPasswordRec().setRequiredPasswordHash( value );
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
				ISecureSecUserObj obj = ((ISecureSchemaObj)getOrigAsSecUserPassword().getSchema()).getSecUserTableObj().readSecUserByIdIdx( getPKey() );
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
			getSecUserPasswordRec();
		}
		if( value != null ) {
			requiredContainerUser = value;
			getSecUserPasswordRec().setRequiredContainerUser(value.getSecUserRec());
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
		ISecureSecUserPassword origRec = getOrigAsSecUserPassword().getSecUserPasswordRec();
		ISecureSecUserPassword myRec = getSecUserPasswordRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureSecUserPassword origRec = getOrigAsSecUserPassword().getSecUserPasswordRec();
		ISecureSecUserPassword myRec = getSecUserPasswordRec();
		myRec.set( origRec );
	}
}
