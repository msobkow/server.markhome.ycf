// Description: Java 25 base object instance implementation for Cluster

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

public class SecureClusterObj
	implements ISecureClusterObj
{
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected boolean isNew;
	protected ISecureClusterEditObj edit;
	protected ISecureSchemaObj schema;
	protected $implCommaIJavaOptAtomType$ pKey;
	protected ISecureCluster rec;
	protected List<ISecureTenantObj> optionalComponentsTenant;
	protected List<ISecureSecClusGrpObj> optionalComponentsSecGroup;
	protected List<ISecureSecClusRoleObj> optionalComponentsSecRole;
	protected List<ISecureSysClusterObj> optionalComponentsSysCluster;

	public SecureClusterObj() {
		isNew = true;
	}

	public SecureClusterObj( ISecureSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
	}

	@Override
	public int getClassCode() {
		return( ((ISecureSchemaObj)schema).getClusterTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "Cluster" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		return( null );
	}

	@Override
	public String getObjName() {
		String objName;
		objName = getRequiredFullDomName();
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
		if( subObj == null ) {
			try {
				if (nextName == null) {
					throw new YCFNullArgumentException(getClass(), "getNamedObject", 0, "RequiredTenantName");
				}
				String natNextName = nextName;
				subObj = ((ISecureSchemaObj)getSchema()).getTenantTableObj().readTenantByUNameIdx( getRequiredId(),
				natNextName, false );
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
	public ISecureClusterObj realise() {
		ISecureClusterObj retobj = ((ISecureSchemaObj)getSchema()).getClusterTableObj().realiseCluster(
			(ISecureClusterObj)this );
		return( (ISecureClusterObj)retobj );
	}

	@Override
	public void forget() {
		((ISecureSchemaObj)getSchema()).getClusterTableObj().reallyDeepDisposeCluster( (ISecureClusterObj)this );
	}

	@Override
	public ISecureClusterObj read() {
		ISecureClusterObj retobj = ((ISecureSchemaObj)getSchema()).getClusterTableObj().readClusterByIdIdx( getPKey(), false );
		return( (ISecureClusterObj)retobj );
	}

	@Override
	public ISecureClusterObj read( boolean forceRead ) {
		ISecureClusterObj retobj = ((ISecureSchemaObj)getSchema()).getClusterTableObj().readClusterByIdIdx( getPKey(), forceRead );
		return( (ISecureClusterObj)retobj );
	}

	@Override
	public ISecureClusterTableObj getClusterTable() {
		return( ((ISecureSchemaObj)getSchema()).getClusterTableObj() );
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
	public ISecureCluster getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getSecureBackingStore().getSecureFactory().getFactoryCluster().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getSecureBackingStore().getTableCluster().readDerivedByIdIdx( ((ISecureSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureCluster value ) {
		if( ! ( ( value == null ) || ! ( value instanceof ISecureCluster ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"SecureClusterRec" );
		}
		rec = value;
		copyRecToPKey();
	}

	@Override
	public ISecureCluster getClusterRec() {
		return( (ISecureCluster)getRec() );
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
	public ISecureClusterEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		ISecureClusterObj lockobj;
		if( getIsNew() ) {
			lockobj = (ISecureClusterObj)this;
		}
		else {
			lockobj = ((ISecureSchemaObj)getSchema()).getClusterTableObj().lockCluster( getPKey() );
		}
		edit = ((ISecureSchemaObj)getSchema()).getClusterTableObj().newEditInstance( lockobj );
		return( (ISecureClusterEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public ISecureClusterEditObj getEdit() {
		return( edit );
	}

	@Override
	public ISecureClusterEditObj getEditAsCluster() {
		return( (ISecureClusterEditObj)edit );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureCluster rec = getRec();
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
			ISecureCluster rec = getRec();
			updatedBy = ((ISecureSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public IYCFKeyHash256 getRequiredId() {
		return( getPKey() );
	}

	@Override
	public List<ISecureTenantObj> getOptionalComponentsTenant() {
		List<ISecureTenantObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getTenantTableObj().readTenantByClusterIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureTenantObj> getOptionalComponentsTenant( boolean forceRead ) {
		List<ISecureTenantObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getTenantTableObj().readTenantByClusterIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecClusGrpObj> getOptionalComponentsSecGroup() {
		List<ISecureSecClusGrpObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecClusGrpTableObj().readSecClusGrpByClusterIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecClusGrpObj> getOptionalComponentsSecGroup( boolean forceRead ) {
		List<ISecureSecClusGrpObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecClusGrpTableObj().readSecClusGrpByClusterIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecClusRoleObj> getOptionalComponentsSecRole() {
		List<ISecureSecClusRoleObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecClusRoleTableObj().readSecClusRoleByClusterIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecClusRoleObj> getOptionalComponentsSecRole( boolean forceRead ) {
		List<ISecureSecClusRoleObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSecClusRoleTableObj().readSecClusRoleByClusterIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSysClusterObj> getOptionalComponentsSysCluster() {
		List<ISecureSysClusterObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSysClusterTableObj().readSysClusterByClusterIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSysClusterObj> getOptionalComponentsSysCluster( boolean forceRead ) {
		List<ISecureSysClusterObj> retval;
		retval = ((ISecureSchemaObj)getSchema()).getSysClusterTableObj().readSysClusterByClusterIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public String getRequiredFullDomName() {
		return( getClusterRec().getRequiredFullDomName() );
	}

	@Override
	public String getRequiredDescription() {
		return( getClusterRec().getRequiredDescription() );
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
