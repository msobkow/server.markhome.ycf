// Description: Java 25 edit object instance implementation for Secure SecClusGrp.

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

public class SecureSecClusGrpEditObj
	implements ISecureSecClusGrpEditObj
{
	protected ISecureSecClusGrpObj orig;
	protected ISecureSecClusGrp rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected ISecureClusterObj requiredOwnerCluster;
	protected ISecureSecSysGrpObj requiredContainerSysGrp;
	protected List<ISecureSecClusGrpMembObj> optionalChildrenMembByGrp;

	public SecureSecClusGrpEditObj( ISecureSecClusGrpObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureSecClusGrp origRec = orig.getRec();
		rec.set( origRec );
		requiredOwnerCluster = null;
		requiredContainerSysGrp = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureSecClusGrp rec = getRec();
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
			ISecureSecClusGrp rec = getRec();
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
		return( ((ISecureSchemaObj)orig.getSchema()).getSecClusGrpTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecClusGrp" );
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
	public ISecureSecClusGrpObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureSecClusGrpObj retobj = getSchema().getSecClusGrpTableObj().realiseSecClusGrp( (ISecureSecClusGrpObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecClusGrp().forget();
	}

	@Override
	public ISecureSecClusGrpObj read() {
		ISecureSecClusGrpObj retval = getOrigAsSecClusGrp().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecClusGrpObj read( boolean forceRead ) {
		ISecureSecClusGrpObj retval = getOrigAsSecClusGrp().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecClusGrpObj create() {
		copyRecToOrig();
		ISecureSecClusGrpObj retobj = ((ISecureSchemaObj)getOrigAsSecClusGrp().getSchema()).getSecClusGrpTableObj().createSecClusGrp( getOrigAsSecClusGrp() );
		if( retobj == getOrigAsSecClusGrp() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureSecClusGrpEditObj update() {
		getSchema().getSecClusGrpTableObj().updateSecClusGrp( (ISecureSecClusGrpObj)this );
		return( null );
	}

	@Override
	public SecureSecClusGrpEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecClusGrpTableObj().deleteSecClusGrp( getOrigAsSecClusGrp() );
		return( null );
	}

	@Override
	public ISecureSecClusGrpTableObj getSecClusGrpTable() {
		return( orig.getSchema().getSecClusGrpTableObj() );
	}

	@Override
	public ISecureSecClusGrpEditObj getEdit() {
		return( (ISecureSecClusGrpEditObj)this );
	}

	@Override
	public ISecureSecClusGrpEditObj getEditAsSecClusGrp() {
		return( (ISecureSecClusGrpEditObj)this );
	}

	@Override
	public ISecureSecClusGrpEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureSecClusGrpObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureSecClusGrpObj getOrigAsSecClusGrp() {
		return( (ISecureSecClusGrpObj)orig );
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
	public ISecureSecClusGrp getRec() {
		if( rec == null ) {
			rec = getOrigAsSecClusGrp().getSchema().getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecClusGrp value ) {
		if( rec != value ) {
			rec = value;
			requiredOwnerCluster = null;
			requiredContainerSysGrp = null;
		}
	}

	@Override
	public ISecureSecClusGrp getSecClusGrpRec() {
		return( (ISecureSecClusGrp)getRec() );
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
	public IYCFKeyHash256 getRequiredSecClusGrpId() {
		return( getPKey() );
	}

	@Override
	public void setRequiredSecClusGrpId(IYCFKeyHash256 value) {
		if (getPKey() != value) {
			setPKey(value);
			requiredOwnerCluster = null;
			requiredContainerSysGrp = null;
			optionalChildrenMembByGrp = null;
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredClusterId() {
		return( getSecClusGrpRec().getRequiredClusterId() );
	}

	@Override
	public String getRequiredName() {
		return( getSecClusGrpRec().getRequiredName() );
	}

	@Override
	public ISecureClusterObj getRequiredOwnerCluster() {
		return( getRequiredOwnerCluster( false ) );
	}

	@Override
	public ISecureClusterObj getRequiredOwnerCluster( boolean forceRead ) {
		if( forceRead || ( requiredOwnerCluster == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureClusterObj obj = ((ISecureSchemaObj)getOrigAsSecClusGrp().getSchema()).getClusterTableObj().readClusterByIdIdx( getSecClusGrpRec().getRequiredClusterId() );
				requiredOwnerCluster = obj;
			}
		}
		return( requiredOwnerCluster );
	}

	@Override
	public void setRequiredOwnerCluster( ISecureClusterObj value ) {
		if( rec == null ) {
			getSecClusGrpRec();
		}
		if( value != null ) {
			requiredOwnerCluster = value;
			getSecClusGrpRec().setRequiredOwnerCluster(value.getClusterRec());
		}
		requiredOwnerCluster = value;
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
				ISecureSecSysGrpObj obj = ((ISecureSchemaObj)getOrigAsSecClusGrp().getSchema()).getSecSysGrpTableObj().readSecSysGrpByUNameIdx( getSecClusGrpRec().getRequiredName() );
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
			getSecClusGrpRec();
		}
		if( value != null ) {
			requiredContainerSysGrp = value;
			getSecClusGrpRec().setRequiredContainerSysGrp(value.getSecSysGrpRec());
		}
		requiredContainerSysGrp = value;
	}

	@Override
	public List<ISecureSecClusGrpMembObj> getOptionalChildrenMembByGrp() {
		List<ISecureSecClusGrpMembObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecClusGrpMembTableObj().readSecClusGrpMembByClusGrpIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecClusGrpMembObj> getOptionalChildrenMembByGrp( boolean forceRead ) {
		List<ISecureSecClusGrpMembObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecClusGrpMembTableObj().readSecClusGrpMembByClusGrpIdx( getPKey(),
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
		ISecureSecClusGrp origRec = getOrigAsSecClusGrp().getSecClusGrpRec();
		ISecureSecClusGrp myRec = getSecClusGrpRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureSecClusGrp origRec = getOrigAsSecClusGrp().getSecClusGrpRec();
		ISecureSecClusGrp myRec = getSecClusGrpRec();
		myRec.set( origRec );
	}
}
