// Description: Java 25 edit object instance implementation for Secure SecSession.

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

public class SecureSecSessionEditObj
	implements ISecureSecSessionEditObj
{
	protected ISecureSecSessionObj orig;
	protected ISecureSecSession rec;
	protected ISecureSecUserObj requiredContainerSecUser;
	protected ISecureSecUserObj requiredParentSecProxy;

	public SecureSecSessionEditObj( ISecureSecSessionObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureSecSession origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerSecUser = null;
		requiredParentSecProxy = null;
	}

	@Override
	public int getClassCode() {
		return( ((ISecureSchemaObj)orig.getSchema()).getSecSessionTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecSession" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		ISecureSecUserObj scope = getRequiredContainerSecUser();
		return( scope );
	}

	@Override
	public String getObjName() {
		String objName;
		YCFDbKeyHash256 val = rec.getRequiredSecSessionId();
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
	public ISecureSecSessionObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureSecSessionObj retobj = getSchema().getSecSessionTableObj().realiseSecSession( (ISecureSecSessionObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecSession().forget();
	}

	@Override
	public ISecureSecSessionObj read() {
		ISecureSecSessionObj retval = getOrigAsSecSession().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecSessionObj read( boolean forceRead ) {
		ISecureSecSessionObj retval = getOrigAsSecSession().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecSessionObj create() {
		copyRecToOrig();
		ISecureSecSessionObj retobj = ((ISecureSchemaObj)getOrigAsSecSession().getSchema()).getSecSessionTableObj().createSecSession( getOrigAsSecSession() );
		if( retobj == getOrigAsSecSession() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureSecSessionEditObj update() {
		getSchema().getSecSessionTableObj().updateSecSession( (ISecureSecSessionObj)this );
		return( null );
	}

	@Override
	public SecureSecSessionEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecSessionTableObj().deleteSecSession( getOrigAsSecSession() );
		return( null );
	}

	@Override
	public ISecureSecSessionTableObj getSecSessionTable() {
		return( orig.getSchema().getSecSessionTableObj() );
	}

	@Override
	public ISecureSecSessionEditObj getEdit() {
		return( (ISecureSecSessionEditObj)this );
	}

	@Override
	public ISecureSecSessionEditObj getEditAsSecSession() {
		return( (ISecureSecSessionEditObj)this );
	}

	@Override
	public ISecureSecSessionEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureSecSessionObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureSecSessionObj getOrigAsSecSession() {
		return( (ISecureSecSessionObj)orig );
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
	public ISecureSecSession getRec() {
		if( rec == null ) {
			rec = getOrigAsSecSession().getSchema().getSecureBackingStore().getSecureFactory().getFactorySecSession().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecSession value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerSecUser = null;
			requiredParentSecProxy = null;
		}
	}

	@Override
	public ISecureSecSession getSecSessionRec() {
		return( (ISecureSecSession)getRec() );
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
	public IYCFKeyHash256 getRequiredSecSessionId() {
		return( getPKey() );
	}

	@Override
	public void setRequiredSecSessionId(IYCFKeyHash256 value) {
		if (getPKey() != value) {
			setPKey(value);
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredSecUserId() {
		return( getSecSessionRec().getRequiredSecUserId() );
	}

	@Override
	public LocalDateTime getRequiredStart() {
		return( getSecSessionRec().getRequiredStart() );
	}

	@Override
	public void setRequiredStart( LocalDateTime value ) {
		if( getSecSessionRec().getRequiredStart() != value ) {
			getSecSessionRec().setRequiredStart( value );
		}
	}

	@Override
	public LocalDateTime getOptionalFinish() {
		return( getSecSessionRec().getOptionalFinish() );
	}

	@Override
	public void setOptionalFinish( LocalDateTime value ) {
		if( getSecSessionRec().getOptionalFinish() != value ) {
			getSecSessionRec().setOptionalFinish( value );
		}
	}

	@Override
	public IYCFKeyHash256 getOptionalSecProxyId() {
		return( getSecSessionRec().getOptionalSecProxyId() );
	}

	@Override
	public ISecureSecUserObj getRequiredContainerSecUser() {
		return( getRequiredContainerSecUser( false ) );
	}

	@Override
	public ISecureSecUserObj getRequiredContainerSecUser( boolean forceRead ) {
		if( forceRead || ( requiredContainerSecUser == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecUserObj obj = ((ISecureSchemaObj)getOrigAsSecSession().getSchema()).getSecUserTableObj().readSecUserByIdIdx( getSecSessionRec().getRequiredSecUserId() );
				requiredContainerSecUser = obj;
				if( obj != null ) {
					requiredContainerSecUser = obj;
				}
			}
		}
		return( requiredContainerSecUser );
	}

	@Override
	public void setRequiredContainerSecUser( ISecureSecUserObj value ) {
		if( rec == null ) {
			getSecSessionRec();
		}
		if( value != null ) {
			requiredContainerSecUser = value;
			getSecSessionRec().setRequiredContainerSecUser(value.getSecUserRec());
		}
		requiredContainerSecUser = value;
	}

	@Override
	public ISecureSecUserObj getRequiredParentSecProxy() {
		return( getRequiredParentSecProxy( false ) );
	}

	@Override
	public ISecureSecUserObj getRequiredParentSecProxy( boolean forceRead ) {
		if( forceRead || ( requiredParentSecProxy == null ) ) {
			boolean anyMissing = false;
			if( getSecSessionRec().getOptionalSecProxyId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				ISecureSecUserObj obj = ((ISecureSchemaObj)getOrigAsSecSession().getSchema()).getSecUserTableObj().readSecUserByIdIdx( getSecSessionRec().getOptionalSecProxyId() );
				requiredParentSecProxy = obj;
			}
		}
		return( requiredParentSecProxy );
	}

	@Override
	public void setRequiredParentSecProxy( ISecureSecUserObj value ) {
		if( rec == null ) {
			getSecSessionRec();
		}
		if( value != null ) {
			requiredParentSecProxy = value;
			getSecSessionRec().setRequiredParentSecProxy(value.getSecUserRec());
		}
		else {
			requiredParentSecProxy = null;
			getSecSessionRec().setRequiredParentSecProxy((ISecureSecUser)null);
		}
		requiredParentSecProxy = value;
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
		ISecureSecSession origRec = getOrigAsSecSession().getSecSessionRec();
		ISecureSecSession myRec = getSecSessionRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureSecSession origRec = getOrigAsSecSession().getSecSessionRec();
		ISecureSecSession myRec = getSecSessionRec();
		myRec.set( origRec );
	}
}
