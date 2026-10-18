// Description: Java 25 edit object instance implementation for Secure SecClusGrpMemb.

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

public class SecureSecClusGrpMembEditObj
	implements ISecureSecClusGrpMembEditObj
{
	protected ISecureSecClusGrpMembObj orig;
	protected ISecureSecClusGrpMemb rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected ISecureSecClusGrpObj requiredContainerGroup;
	protected ISecureSecUserObj requiredParentUser;

	public SecureSecClusGrpMembEditObj( ISecureSecClusGrpMembObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureSecClusGrpMemb origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerGroup = null;
		requiredParentUser = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureSecClusGrpMemb rec = getRec();
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
			ISecureSecClusGrpMemb rec = getRec();
			updatedBy = ((ISecureSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
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
		return( ((ISecureSchemaObj)orig.getSchema()).getSecClusGrpMembTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecClusGrpMemb" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		ISecureSecClusGrpObj scope = getRequiredContainerGroup();
		return( scope );
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
	public ISecureSecClusGrpMembObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureSecClusGrpMembObj retobj = getSchema().getSecClusGrpMembTableObj().realiseSecClusGrpMemb( (ISecureSecClusGrpMembObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecClusGrpMemb().forget();
	}

	@Override
	public ISecureSecClusGrpMembObj read() {
		ISecureSecClusGrpMembObj retval = getOrigAsSecClusGrpMemb().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecClusGrpMembObj read( boolean forceRead ) {
		ISecureSecClusGrpMembObj retval = getOrigAsSecClusGrpMemb().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecClusGrpMembObj create() {
		copyRecToOrig();
		ISecureSecClusGrpMembObj retobj = ((ISecureSchemaObj)getOrigAsSecClusGrpMemb().getSchema()).getSecClusGrpMembTableObj().createSecClusGrpMemb( getOrigAsSecClusGrpMemb() );
		if( retobj == getOrigAsSecClusGrpMemb() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureSecClusGrpMembEditObj update() {
		getSchema().getSecClusGrpMembTableObj().updateSecClusGrpMemb( (ISecureSecClusGrpMembObj)this );
		return( null );
	}

	@Override
	public SecureSecClusGrpMembEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecClusGrpMembTableObj().deleteSecClusGrpMemb( getOrigAsSecClusGrpMemb() );
		return( null );
	}

	@Override
	public ISecureSecClusGrpMembTableObj getSecClusGrpMembTable() {
		return( orig.getSchema().getSecClusGrpMembTableObj() );
	}

	@Override
	public ISecureSecClusGrpMembEditObj getEdit() {
		return( (ISecureSecClusGrpMembEditObj)this );
	}

	@Override
	public ISecureSecClusGrpMembEditObj getEditAsSecClusGrpMemb() {
		return( (ISecureSecClusGrpMembEditObj)this );
	}

	@Override
	public ISecureSecClusGrpMembEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureSecClusGrpMembObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureSecClusGrpMembObj getOrigAsSecClusGrpMemb() {
		return( (ISecureSecClusGrpMembObj)orig );
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
	public ISecureSecClusGrpMemb getRec() {
		if( rec == null ) {
			rec = getOrigAsSecClusGrpMemb().getSchema().getSecureBackingStore().getSecureFactory().getFactorySecClusGrpMemb().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecClusGrpMemb value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerGroup = null;
			requiredParentUser = null;
		}
	}

	@Override
	public ISecureSecClusGrpMemb getSecClusGrpMembRec() {
		return( (ISecureSecClusGrpMemb)getRec() );
	}

	@Override
	public ISecureSecClusGrpMembPKey getPKey() {
		return( orig.getPKey() );
	}

	@Override
	public void setPKey( ISecureSecClusGrpMembPKey value ) {
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
	public IYCFKeyHash256 getRequiredSecClusGrpId() {
		return( getPKey().getRequiredSecClusGrpId() );
	}

	@Override
	public String getRequiredLoginId() {
		return( getPKey().getRequiredLoginId() );
	}

	@Override
	public ISecureSecClusGrpObj getRequiredContainerGroup() {
		return( getRequiredContainerGroup( false ) );
	}

	@Override
	public ISecureSecClusGrpObj getRequiredContainerGroup( boolean forceRead ) {
		if( forceRead || ( requiredContainerGroup == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecClusGrpObj obj = ((ISecureSchemaObj)getOrigAsSecClusGrpMemb().getSchema()).getSecClusGrpTableObj().readSecClusGrpByIdIdx( getPKey().getRequiredSecClusGrpId() );
				requiredContainerGroup = obj;
				if( obj != null ) {
					requiredContainerGroup = obj;
				}
			}
		}
		return( requiredContainerGroup );
	}

	@Override
	public void setRequiredContainerGroup( ISecureSecClusGrpObj value ) {
		if( rec == null ) {
			getSecClusGrpMembRec();
		}
		if( value != null ) {
			requiredContainerGroup = value;
			getSecClusGrpMembRec().setRequiredContainerGroup(value.getSecClusGrpRec());
		}
		requiredContainerGroup = value;
	}

	@Override
	public ISecureSecUserObj getRequiredParentUser() {
		return( getRequiredParentUser( false ) );
	}

	@Override
	public ISecureSecUserObj getRequiredParentUser( boolean forceRead ) {
		if( forceRead || ( requiredParentUser == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecUserObj obj = ((ISecureSchemaObj)getOrigAsSecClusGrpMemb().getSchema()).getSecUserTableObj().readSecUserByULoginIdx( getPKey().getRequiredLoginId() );
				requiredParentUser = obj;
			}
		}
		return( requiredParentUser );
	}

	@Override
	public void setRequiredParentUser( ISecureSecUserObj value ) {
		if( rec == null ) {
			getSecClusGrpMembRec();
		}
		if( value != null ) {
			requiredParentUser = value;
			getSecClusGrpMembRec().setRequiredParentUser(value.getSecUserRec());
		}
		else {
			requiredParentUser = null;
			getSecClusGrpMembRec().setRequiredParentUser((ISecureSecUser)null);
		}
		requiredParentUser = value;
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredSecClusGrpId(getPKey().getRequiredSecClusGrpId());
			rec.getPKey().setRequiredLoginId(getPKey().getRequiredLoginId());
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredSecClusGrpId(rec.getPKey().getRequiredSecClusGrpId());
			getPKey().setRequiredLoginId(rec.getPKey().getRequiredLoginId());
		}
	}

	@Override
	public void copyRecToOrig() {
		ISecureSecClusGrpMemb origRec = getOrigAsSecClusGrpMemb().getSecClusGrpMembRec();
		ISecureSecClusGrpMemb myRec = getSecClusGrpMembRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureSecClusGrpMemb origRec = getOrigAsSecClusGrpMemb().getSecClusGrpMembRec();
		ISecureSecClusGrpMemb myRec = getSecClusGrpMembRec();
		myRec.set( origRec );
	}
}
