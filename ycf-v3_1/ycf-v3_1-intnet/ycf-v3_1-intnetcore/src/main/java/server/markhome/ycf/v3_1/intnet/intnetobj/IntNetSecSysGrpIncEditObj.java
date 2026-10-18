// Description: Java 25 edit object instance implementation for IntNet SecSysGrpInc.

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

public class IntNetSecSysGrpIncEditObj
	implements IIntNetSecSysGrpIncEditObj
{
	protected ISecureSecSysGrpIncObj orig;
	protected ISecureSecSysGrpInc rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected ISecureSecSysGrpObj requiredContainerGroup;
	protected ISecureSecSysGrpObj requiredParentSubGroup;

	public IntNetSecSysGrpIncEditObj( ISecureSecSysGrpIncObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureSecSysGrpInc origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerGroup = null;
		requiredParentSubGroup = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureSecSysGrpInc rec = getRec();
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
			ISecureSecSysGrpInc rec = getRec();
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
		return( ((ISecureSchemaObj)orig.getSchema()).getSecSysGrpIncTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecSysGrpInc" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		ISecureSecSysGrpObj scope = getRequiredContainerGroup();
		return( scope );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredInclName();
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
	public ISecureSecSysGrpIncObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureSecSysGrpIncObj retobj = getSchema().getSecSysGrpIncTableObj().realiseSecSysGrpInc( (IIntNetSecSysGrpIncObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecSysGrpInc().forget();
	}

	@Override
	public ISecureSecSysGrpIncObj read() {
		ISecureSecSysGrpIncObj retval = getOrigAsSecSysGrpInc().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecSysGrpIncObj read( boolean forceRead ) {
		ISecureSecSysGrpIncObj retval = getOrigAsSecSysGrpInc().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecSysGrpIncObj create() {
		copyRecToOrig();
		ISecureSecSysGrpIncObj retobj = ((IIntNetSchemaObj)getOrigAsSecSysGrpInc().getSchema()).getSecSysGrpIncTableObj().createSecSysGrpInc( getOrigAsSecSysGrpInc() );
		if( retobj == getOrigAsSecSysGrpInc() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureSecSysGrpIncEditObj update() {
		getSchema().getSecSysGrpIncTableObj().updateSecSysGrpInc( (ISecureSecSysGrpIncObj)this );
		return( null );
	}

	@Override
	public SecureSecSysGrpIncEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecSysGrpIncTableObj().deleteSecSysGrpInc( getOrigAsSecSysGrpInc() );
		return( null );
	}

	@Override
	public ISecureSecSysGrpIncTableObj getSecSysGrpIncTable() {
		return( orig.getSchema().getSecSysGrpIncTableObj() );
	}

	@Override
	public ISecureSecSysGrpIncEditObj getEdit() {
		return( (ISecureSecSysGrpIncEditObj)this );
	}

	@Override
	public ISecureSecSysGrpIncEditObj getEditAsSecSysGrpInc() {
		return( (ISecureSecSysGrpIncEditObj)this );
	}

	@Override
	public ISecureSecSysGrpIncEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureSecSysGrpIncObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureSecSysGrpIncObj getOrigAsSecSysGrpInc() {
		return( (ISecureSecSysGrpIncObj)orig );
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
	public ISecureSecSysGrpInc getRec() {
		if( rec == null ) {
			rec = getOrigAsSecSysGrpInc().getSchema().getSecureBackingStore().getSecureFactory().getFactorySecSysGrpInc().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecSysGrpInc value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerGroup = null;
			requiredParentSubGroup = null;
		}
	}

	@Override
	public ISecureSecSysGrpInc getSecSysGrpIncRec() {
		return( (ISecureSecSysGrpInc)getRec() );
	}

	@Override
	public ISecureSecSysGrpIncPKey getPKey() {
		return( orig.getPKey() );
	}

	@Override
	public void setPKey( ISecureSecSysGrpIncPKey value ) {
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
	public IYCFKeyHash256 getRequiredSecSysGrpId() {
		return( getPKey().getRequiredSecSysGrpId() );
	}

	@Override
	public String getRequiredInclName() {
		return( getPKey().getRequiredInclName() );
	}

	@Override
	public ISecureSecSysGrpObj getRequiredContainerGroup() {
		return( getRequiredContainerGroup( false ) );
	}

	@Override
	public ISecureSecSysGrpObj getRequiredContainerGroup( boolean forceRead ) {
		if( forceRead || ( requiredContainerGroup == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecSysGrpObj obj = ((IIntNetSchemaObj)getOrigAsSecSysGrpInc().getSchema()).getSecSysGrpTableObj().readSecSysGrpByIdIdx( getPKey().getRequiredSecSysGrpId() );
				requiredContainerGroup = obj;
				if( obj != null ) {
					requiredContainerGroup = obj;
				}
			}
		}
		return( requiredContainerGroup );
	}

	@Override
	public void setRequiredContainerGroup( ISecureSecSysGrpObj value ) {
		if( rec == null ) {
			getSecSysGrpIncRec();
		}
		if( value != null ) {
			requiredContainerGroup = value;
			getSecSysGrpIncRec().setRequiredContainerGroup(value.getSecSysGrpRec());
		}
		requiredContainerGroup = value;
	}

	@Override
	public ISecureSecSysGrpObj getRequiredParentSubGroup() {
		return( getRequiredParentSubGroup( false ) );
	}

	@Override
	public ISecureSecSysGrpObj getRequiredParentSubGroup( boolean forceRead ) {
		if( forceRead || ( requiredParentSubGroup == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecSysGrpObj obj = ((IIntNetSchemaObj)getOrigAsSecSysGrpInc().getSchema()).getSecSysGrpTableObj().readSecSysGrpByUNameIdx( getPKey().getRequiredInclName() );
				requiredParentSubGroup = obj;
			}
		}
		return( requiredParentSubGroup );
	}

	@Override
	public void setRequiredParentSubGroup( ISecureSecSysGrpObj value ) {
		if( rec == null ) {
			getSecSysGrpIncRec();
		}
		if( value != null ) {
			requiredParentSubGroup = value;
			getSecSysGrpIncRec().setRequiredParentSubGroup(value.getSecSysGrpRec());
		}
		else {
			requiredParentSubGroup = null;
			getSecSysGrpIncRec().setRequiredParentSubGroup((ISecureSecSysGrp)null);
		}
		requiredParentSubGroup = value;
	}

	@Override
	public void copyPKeyToRec() {
		if( rec != null ) {
			rec.getPKey().setRequiredSecSysGrpId(getPKey().getRequiredSecSysGrpId());
			rec.getPKey().setRequiredInclName(getPKey().getRequiredInclName());
		}
	}

	@Override
	public void copyRecToPKey() {
		if( rec != null ) {
			getPKey().setRequiredSecSysGrpId(rec.getPKey().getRequiredSecSysGrpId());
			getPKey().setRequiredInclName(rec.getPKey().getRequiredInclName());
		}
	}

	@Override
	public void copyRecToOrig() {
		ISecureSecSysGrpInc origRec = getOrigAsSecSysGrpInc().getSecSysGrpIncRec();
		ISecureSecSysGrpInc myRec = getSecSysGrpIncRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureSecSysGrpInc origRec = getOrigAsSecSysGrpInc().getSecSysGrpIncRec();
		ISecureSecSysGrpInc myRec = getSecSysGrpIncRec();
		myRec.set( origRec );
	}
}
