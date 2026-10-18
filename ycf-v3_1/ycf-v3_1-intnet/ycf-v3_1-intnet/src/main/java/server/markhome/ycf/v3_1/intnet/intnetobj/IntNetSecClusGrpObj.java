// Description: Java 25 base object instance implementation for SecClusGrp

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

public class IntNetSecClusGrpObj
	implements IIntNetSecClusGrpObj
{
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ISecureSecClusGrpEditObj edit;
	protected ISecureSchemaObj schema;
	protected $implCommaIJavaOptAtomType$ pKey;
	protected ISecureSecClusGrp rec;
	protected ISecureClusterObj requiredOwnerCluster;
	protected ISecureSecSysGrpObj requiredContainerSysGrp;
	protected List<ISecureSecClusGrpMembObj> optionalChildrenMembByGrp;

	public IntNetSecClusGrpObj() {
		isNew = true;
		requiredOwnerCluster = null;
		requiredContainerSysGrp = null;
	}

	public IntNetSecClusGrpObj( ISecureSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredOwnerCluster = null;
		requiredContainerSysGrp = null;
	}

	@Override
	public int getClassCode() {
		return( ((ISecureSchemaObj)schema).getSecClusGrpTableObj().getClassCode() );
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
	public ISecureSecClusGrpObj realise() {
		ISecureSecClusGrpObj retobj = ((IIntNetSchemaObj)getSchema()).getSecClusGrpTableObj().realiseSecClusGrp(
			(ISecureSecClusGrpObj)this );
		return( (ISecureSecClusGrpObj)retobj );
	}

	@Override
	public void forget() {
		((IIntNetSchemaObj)getSchema()).getSecClusGrpTableObj().reallyDeepDisposeSecClusGrp( (ISecureSecClusGrpObj)this );
	}

	@Override
	public ISecureSecClusGrpObj read() {
		ISecureSecClusGrpObj retobj = ((IIntNetSchemaObj)getSchema()).getSecClusGrpTableObj().readSecClusGrpByIdIdx( getPKey(), false );
		return( (ISecureSecClusGrpObj)retobj );
	}

	@Override
	public ISecureSecClusGrpObj read( boolean forceRead ) {
		ISecureSecClusGrpObj retobj = ((IIntNetSchemaObj)getSchema()).getSecClusGrpTableObj().readSecClusGrpByIdIdx( getPKey(), forceRead );
		return( (ISecureSecClusGrpObj)retobj );
	}

	@Override
	public ISecureSecClusGrpTableObj getSecClusGrpTable() {
		return( ((IIntNetSchemaObj)getSchema()).getSecClusGrpTableObj() );
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
	public ISecureSecClusGrp getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getSecureBackingStore().getSecureFactory().getFactorySecClusGrp().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getSecureBackingStore().getTableSecClusGrp().readDerivedByIdIdx( ((IIntNetSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecClusGrp value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ISecureSecClusGrp ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"SecureSecClusGrpRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredOwnerCluster = null;
		requiredContainerSysGrp = null;
	}

	@Override
	public ISecureSecClusGrp getSecClusGrpRec() {
		return( (ISecureSecClusGrp)getRec() );
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
	public ISecureSecClusGrpEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ISecureSecClusGrpObj lockobj;
		if( getIsNew() ) {
			lockobj = (ISecureSecClusGrpObj)this;
		}
		else {
			lockobj = ((IIntNetSchemaObj)getSchema()).getSecClusGrpTableObj().lockSecClusGrp( getPKey() );
		}
		edit = ((IIntNetSchemaObj)getSchema()).getSecClusGrpTableObj().newEditInstance( lockobj );
		return( (ISecureSecClusGrpEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ISecureSecClusGrpEditObj getEdit() {
		return( edit );
	}

	@Override
	public ISecureSecClusGrpEditObj getEditAsSecClusGrp() {
		return( (ISecureSecClusGrpEditObj)edit );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureSecClusGrp rec = getRec();
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
			ISecureSecClusGrp rec = getRec();
			updatedBy = ((IIntNetSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public IYCFKeyHash256 getRequiredSecClusGrpId() {
		return( getPKey() );
	}

	@Override
	public ISecureClusterObj getRequiredOwnerCluster() {
		return( getRequiredOwnerCluster( false ) );
	}

	@Override
	public ISecureClusterObj getRequiredOwnerCluster( boolean forceRead ) {
		if( ( requiredOwnerCluster == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerCluster = ((IIntNetSchemaObj)getSchema()).getClusterTableObj().readClusterByIdIdx( getSecClusGrpRec().getRequiredClusterId(), forceRead );
			}
		}
		return( requiredOwnerCluster );
	}

	@Override
	public ISecureSecSysGrpObj getRequiredContainerSysGrp() {
		return( getRequiredContainerSysGrp( false ) );
	}

	@Override
	public ISecureSecSysGrpObj getRequiredContainerSysGrp( boolean forceRead ) {
		if( ( requiredContainerSysGrp == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerSysGrp = ((IIntNetSchemaObj)getSchema()).getSecSysGrpTableObj().readSecSysGrpByUNameIdx( getSecClusGrpRec().getRequiredName(), forceRead );
			}
		}
		return( requiredContainerSysGrp );
	}

	@Override
	public List<ISecureSecClusGrpMembObj> getOptionalChildrenMembByGrp() {
		List<ISecureSecClusGrpMembObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecClusGrpMembTableObj().readSecClusGrpMembByClusGrpIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecClusGrpMembObj> getOptionalChildrenMembByGrp( boolean forceRead ) {
		List<ISecureSecClusGrpMembObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecClusGrpMembTableObj().readSecClusGrpMembByClusGrpIdx( getPKey(),
			forceRead );
		return( retval );
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
