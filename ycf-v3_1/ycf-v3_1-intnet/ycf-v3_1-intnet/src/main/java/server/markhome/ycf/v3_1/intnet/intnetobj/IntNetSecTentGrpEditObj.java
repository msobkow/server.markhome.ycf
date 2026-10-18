// Description: Java 25 edit object instance implementation for IntNet SecTentGrp.

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

public class IntNetSecTentGrpEditObj
	implements IIntNetSecTentGrpEditObj
{
	protected ISecureSecTentGrpObj orig;
	protected ISecureSecTentGrp rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected ISecureTenantObj requiredOwnerTenant;
	protected ISecureSecSysGrpObj requiredContainerSysGrp;
	protected List<ISecureSecTentGrpMembObj> optionalChildrenMembByGrp;

	public IntNetSecTentGrpEditObj( ISecureSecTentGrpObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureSecTentGrp origRec = orig.getRec();
		rec.set( origRec );
		requiredOwnerTenant = null;
		requiredContainerSysGrp = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureSecTentGrp rec = getRec();
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
			ISecureSecTentGrp rec = getRec();
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
		return( ((ISecureSchemaObj)orig.getSchema()).getSecTentGrpTableObj().getClassCode() );
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
	public ISecureSecTentGrpObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureSecTentGrpObj retobj = getSchema().getSecTentGrpTableObj().realiseSecTentGrp( (IIntNetSecTentGrpObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecTentGrp().forget();
	}

	@Override
	public ISecureSecTentGrpObj read() {
		ISecureSecTentGrpObj retval = getOrigAsSecTentGrp().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecTentGrpObj read( boolean forceRead ) {
		ISecureSecTentGrpObj retval = getOrigAsSecTentGrp().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecTentGrpObj create() {
		copyRecToOrig();
		ISecureSecTentGrpObj retobj = ((IIntNetSchemaObj)getOrigAsSecTentGrp().getSchema()).getSecTentGrpTableObj().createSecTentGrp( getOrigAsSecTentGrp() );
		if( retobj == getOrigAsSecTentGrp() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureSecTentGrpEditObj update() {
		getSchema().getSecTentGrpTableObj().updateSecTentGrp( (ISecureSecTentGrpObj)this );
		return( null );
	}

	@Override
	public SecureSecTentGrpEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecTentGrpTableObj().deleteSecTentGrp( getOrigAsSecTentGrp() );
		return( null );
	}

	@Override
	public ISecureSecTentGrpTableObj getSecTentGrpTable() {
		return( orig.getSchema().getSecTentGrpTableObj() );
	}

	@Override
	public ISecureSecTentGrpEditObj getEdit() {
		return( (ISecureSecTentGrpEditObj)this );
	}

	@Override
	public ISecureSecTentGrpEditObj getEditAsSecTentGrp() {
		return( (ISecureSecTentGrpEditObj)this );
	}

	@Override
	public ISecureSecTentGrpEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureSecTentGrpObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureSecTentGrpObj getOrigAsSecTentGrp() {
		return( (ISecureSecTentGrpObj)orig );
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
	public ISecureSecTentGrp getRec() {
		if( rec == null ) {
			rec = getOrigAsSecTentGrp().getSchema().getSecureBackingStore().getSecureFactory().getFactorySecTentGrp().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecTentGrp value ) {
		if( rec != value ) {
			rec = value;
			requiredOwnerTenant = null;
			requiredContainerSysGrp = null;
		}
	}

	@Override
	public ISecureSecTentGrp getSecTentGrpRec() {
		return( (ISecureSecTentGrp)getRec() );
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
	public IYCFKeyHash256 getRequiredSecTentGrpId() {
		return( getPKey() );
	}

	@Override
	public void setRequiredSecTentGrpId(IYCFKeyHash256 value) {
		if (getPKey() != value) {
			setPKey(value);
			requiredOwnerTenant = null;
			requiredContainerSysGrp = null;
			optionalChildrenMembByGrp = null;
		}
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
	public ISecureTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	@Override
	public ISecureTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureTenantObj obj = ((IIntNetSchemaObj)getOrigAsSecTentGrp().getSchema()).getTenantTableObj().readTenantByIdIdx( getSecTentGrpRec().getRequiredTenantId() );
				requiredOwnerTenant = obj;
			}
		}
		return( requiredOwnerTenant );
	}

	@Override
	public void setRequiredOwnerTenant( ISecureTenantObj value ) {
		if( rec == null ) {
			getSecTentGrpRec();
		}
		if( value != null ) {
			requiredOwnerTenant = value;
			getSecTentGrpRec().setRequiredOwnerTenant(value.getTenantRec());
		}
		requiredOwnerTenant = value;
	}

	@Override
	public ISecureSecSysGrpObj getRequiredContainerSysGrp() {
		return( getRequiredContainerSysGrp( false ) );
	}

	@Override
	public ISecureSecSysGrpObj getRequiredContainerSysGrp( boolean forceRead ) {
		if( forceRead || ( requiredContainerSysGrp == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecSysGrpObj obj = ((IIntNetSchemaObj)getOrigAsSecTentGrp().getSchema()).getSecSysGrpTableObj().readSecSysGrpByUNameIdx( getSecTentGrpRec().getRequiredName() );
				requiredContainerSysGrp = obj;
				if( obj != null ) {
					requiredContainerSysGrp = obj;
				}
			}
		}
		return( requiredContainerSysGrp );
	}

	@Override
	public void setRequiredContainerSysGrp( ISecureSecSysGrpObj value ) {
		if( rec == null ) {
			getSecTentGrpRec();
		}
		if( value != null ) {
			requiredContainerSysGrp = value;
			getSecTentGrpRec().setRequiredContainerSysGrp(value.getSecSysGrpRec());
		}
		requiredContainerSysGrp = value;
	}

	@Override
	public List<ISecureSecTentGrpMembObj> getOptionalChildrenMembByGrp() {
		List<ISecureSecTentGrpMembObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecTentGrpMembTableObj().readSecTentGrpMembByTentGrpIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecTentGrpMembObj> getOptionalChildrenMembByGrp( boolean forceRead ) {
		List<ISecureSecTentGrpMembObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecTentGrpMembTableObj().readSecTentGrpMembByTentGrpIdx( getPKey(),
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
		ISecureSecTentGrp origRec = getOrigAsSecTentGrp().getSecTentGrpRec();
		ISecureSecTentGrp myRec = getSecTentGrpRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureSecTentGrp origRec = getOrigAsSecTentGrp().getSecTentGrpRec();
		ISecureSecTentGrp myRec = getSecTentGrpRec();
		myRec.set( origRec );
	}
}
