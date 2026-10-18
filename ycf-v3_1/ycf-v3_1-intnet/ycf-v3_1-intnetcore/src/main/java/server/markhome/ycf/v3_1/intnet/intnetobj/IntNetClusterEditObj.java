// Description: Java 25 edit object instance implementation for IntNet Cluster.

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

public class IntNetClusterEditObj
	implements IIntNetClusterEditObj
{
	protected ISecureClusterObj orig;
	protected ISecureCluster rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected List<ISecureTenantObj> optionalComponentsTenant;
	protected List<ISecureSecClusGrpObj> optionalComponentsSecGroup;
	protected List<ISecureSecClusRoleObj> optionalComponentsSecRole;
	protected List<ISecureSysClusterObj> optionalComponentsSysCluster;

	public IntNetClusterEditObj( ISecureClusterObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureCluster origRec = orig.getRec();
		rec.set( origRec );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureCluster rec = getRec();
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
			ISecureCluster rec = getRec();
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
		return( ((ISecureSchemaObj)orig.getSchema()).getClusterTableObj().getClassCode() );
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
		if( subObj == null ) {
			try {
				if (nextName == null) {
					throw new YCFNullArgumentException(getClass(), "getNamedObject", 0, "RequiredTenantName");
				}
				String natNextName = nextName;
				subObj = ((IIntNetSchemaObj)getSchema()).getTenantTableObj().readTenantByUNameIdx( getRequiredId(),
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
		// We realise this so that it's record will get copied to orig during realization
		ISecureClusterObj retobj = getSchema().getClusterTableObj().realiseCluster( (IIntNetClusterObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsCluster().forget();
	}

	@Override
	public ISecureClusterObj read() {
		ISecureClusterObj retval = getOrigAsCluster().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureClusterObj read( boolean forceRead ) {
		ISecureClusterObj retval = getOrigAsCluster().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureClusterObj create() {
		copyRecToOrig();
		ISecureClusterObj retobj = ((IIntNetSchemaObj)getOrigAsCluster().getSchema()).getClusterTableObj().createCluster( getOrigAsCluster() );
		if( retobj == getOrigAsCluster() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureClusterEditObj update() {
		getSchema().getClusterTableObj().updateCluster( (ISecureClusterObj)this );
		return( null );
	}

	@Override
	public SecureClusterEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getClusterTableObj().deleteCluster( getOrigAsCluster() );
		return( null );
	}

	@Override
	public ISecureClusterTableObj getClusterTable() {
		return( orig.getSchema().getClusterTableObj() );
	}

	@Override
	public ISecureClusterEditObj getEdit() {
		return( (ISecureClusterEditObj)this );
	}

	@Override
	public ISecureClusterEditObj getEditAsCluster() {
		return( (ISecureClusterEditObj)this );
	}

	@Override
	public ISecureClusterEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureClusterObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureClusterObj getOrigAsCluster() {
		return( (ISecureClusterObj)orig );
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
	public ISecureCluster getRec() {
		if( rec == null ) {
			rec = getOrigAsCluster().getSchema().getSecureBackingStore().getSecureFactory().getFactoryCluster().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureCluster value ) {
		if( rec != value ) {
			rec = value;
		}
	}

	@Override
	public ISecureCluster getClusterRec() {
		return( (ISecureCluster)getRec() );
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
	public IYCFKeyHash256 getRequiredId() {
		return( getPKey() );
	}

	@Override
	public void setRequiredId(IYCFKeyHash256 value) {
		if (getPKey() != value) {
			setPKey(value);
			optionalComponentsTenant = null;
			optionalComponentsSecGroup = null;
			optionalComponentsSecRole = null;
			optionalComponentsSysCluster = null;
		}
	}

	@Override
	public String getRequiredFullDomName() {
		return( getClusterRec().getRequiredFullDomName() );
	}

	@Override
	public void setRequiredFullDomName( String value ) {
		if( getClusterRec().getRequiredFullDomName() != value ) {
			getClusterRec().setRequiredFullDomName( value );
		}
	}

	@Override
	public String getRequiredDescription() {
		return( getClusterRec().getRequiredDescription() );
	}

	@Override
	public void setRequiredDescription( String value ) {
		if( getClusterRec().getRequiredDescription() != value ) {
			getClusterRec().setRequiredDescription( value );
		}
	}

	@Override
	public List<ISecureTenantObj> getOptionalComponentsTenant() {
		List<ISecureTenantObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getTenantTableObj().readTenantByClusterIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureTenantObj> getOptionalComponentsTenant( boolean forceRead ) {
		List<ISecureTenantObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getTenantTableObj().readTenantByClusterIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecClusGrpObj> getOptionalComponentsSecGroup() {
		List<ISecureSecClusGrpObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecClusGrpTableObj().readSecClusGrpByClusterIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecClusGrpObj> getOptionalComponentsSecGroup( boolean forceRead ) {
		List<ISecureSecClusGrpObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecClusGrpTableObj().readSecClusGrpByClusterIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSecClusRoleObj> getOptionalComponentsSecRole() {
		List<ISecureSecClusRoleObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecClusRoleTableObj().readSecClusRoleByClusterIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecClusRoleObj> getOptionalComponentsSecRole( boolean forceRead ) {
		List<ISecureSecClusRoleObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSecClusRoleTableObj().readSecClusRoleByClusterIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<ISecureSysClusterObj> getOptionalComponentsSysCluster() {
		List<ISecureSysClusterObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSysClusterTableObj().readSysClusterByClusterIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSysClusterObj> getOptionalComponentsSysCluster( boolean forceRead ) {
		List<ISecureSysClusterObj> retval;
		retval = ((IIntNetSchemaObj)getSchema()).getSysClusterTableObj().readSysClusterByClusterIdx( getPKey(),
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
		ISecureCluster origRec = getOrigAsCluster().getClusterRec();
		ISecureCluster myRec = getClusterRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureCluster origRec = getOrigAsCluster().getClusterRec();
		ISecureCluster myRec = getClusterRec();
		myRec.set( origRec );
	}
}
