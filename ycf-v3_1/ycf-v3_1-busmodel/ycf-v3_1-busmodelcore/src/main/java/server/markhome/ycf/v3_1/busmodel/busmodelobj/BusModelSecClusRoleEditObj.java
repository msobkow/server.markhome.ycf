// Description: Java 25 edit object instance implementation for BusModel SecClusRole.

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodelobj;

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
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public class BusModelSecClusRoleEditObj
	implements IBusModelSecClusRoleEditObj
{
	protected ISecureSecClusRoleObj orig;
	protected ISecureSecClusRole rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected ISecureClusterObj requiredOwnerCluster;
	protected ISecureSecSysGrpObj requiredContainerSysRole;
	protected List<ISecureSecClusRoleMembObj> optionalChildrenMembByGrp;

	public BusModelSecClusRoleEditObj( ISecureSecClusRoleObj argOrig ) {
		orig = argOrig;
		getRec();
		ISecureSecClusRole origRec = orig.getRec();
		rec.set( origRec );
		requiredOwnerCluster = null;
		requiredContainerSysRole = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			ISecureSecClusRole rec = getRec();
			createdBy = ((IBusModelSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getCreatedByUserId() );
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
			ISecureSecClusRole rec = getRec();
			updatedBy = ((IBusModelSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
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
		return( ((ISecureSchemaObj)orig.getSchema()).getSecClusRoleTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SecClusRole" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		ISecureSecSysGrpObj scope = getRequiredContainerSysRole();
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
				if( container instanceof IBusModelClusterObj ) {
					break;
				}
				else if( container instanceof IBusModelTenantObj ) {
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
				if( container instanceof IBusModelClusterObj ) {
					break;
				}
				else if( container instanceof IBusModelTenantObj ) {
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
	public ISecureSecClusRoleObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		ISecureSecClusRoleObj retobj = getSchema().getSecClusRoleTableObj().realiseSecClusRole( (IBusModelSecClusRoleObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSecClusRole().forget();
	}

	@Override
	public ISecureSecClusRoleObj read() {
		ISecureSecClusRoleObj retval = getOrigAsSecClusRole().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecClusRoleObj read( boolean forceRead ) {
		ISecureSecClusRoleObj retval = getOrigAsSecClusRole().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public ISecureSecClusRoleObj create() {
		copyRecToOrig();
		ISecureSecClusRoleObj retobj = ((IBusModelSchemaObj)getOrigAsSecClusRole().getSchema()).getSecClusRoleTableObj().createSecClusRole( getOrigAsSecClusRole() );
		if( retobj == getOrigAsSecClusRole() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public SecureSecClusRoleEditObj update() {
		getSchema().getSecClusRoleTableObj().updateSecClusRole( (ISecureSecClusRoleObj)this );
		return( null );
	}

	@Override
	public SecureSecClusRoleEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSecClusRoleTableObj().deleteSecClusRole( getOrigAsSecClusRole() );
		return( null );
	}

	@Override
	public ISecureSecClusRoleTableObj getSecClusRoleTable() {
		return( orig.getSchema().getSecClusRoleTableObj() );
	}

	@Override
	public ISecureSecClusRoleEditObj getEdit() {
		return( (ISecureSecClusRoleEditObj)this );
	}

	@Override
	public ISecureSecClusRoleEditObj getEditAsSecClusRole() {
		return( (ISecureSecClusRoleEditObj)this );
	}

	@Override
	public ISecureSecClusRoleEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public ISecureSecClusRoleObj getOrig() {
		return( orig );
	}

	@Override
	public ISecureSecClusRoleObj getOrigAsSecClusRole() {
		return( (ISecureSecClusRoleObj)orig );
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
	public ISecureSecClusRole getRec() {
		if( rec == null ) {
			rec = getOrigAsSecClusRole().getSchema().getSecureBackingStore().getSecureFactory().getFactorySecClusRole().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( ISecureSecClusRole value ) {
		if( rec != value ) {
			rec = value;
			requiredOwnerCluster = null;
			requiredContainerSysRole = null;
		}
	}

	@Override
	public ISecureSecClusRole getSecClusRoleRec() {
		return( (ISecureSecClusRole)getRec() );
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
	public IYCFKeyHash256 getRequiredSecClusRoleId() {
		return( getPKey() );
	}

	@Override
	public void setRequiredSecClusRoleId(IYCFKeyHash256 value) {
		if (getPKey() != value) {
			setPKey(value);
			requiredOwnerCluster = null;
			requiredContainerSysRole = null;
			optionalChildrenMembByGrp = null;
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredClusterId() {
		return( getSecClusRoleRec().getRequiredClusterId() );
	}

	@Override
	public String getRequiredName() {
		return( getSecClusRoleRec().getRequiredName() );
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
				ISecureClusterObj obj = ((IBusModelSchemaObj)getOrigAsSecClusRole().getSchema()).getClusterTableObj().readClusterByIdIdx( getSecClusRoleRec().getRequiredClusterId() );
				requiredOwnerCluster = obj;
			}
		}
		return( requiredOwnerCluster );
	}

	@Override
	public void setRequiredOwnerCluster( ISecureClusterObj value ) {
		if( rec == null ) {
			getSecClusRoleRec();
		}
		if( value != null ) {
			requiredOwnerCluster = value;
			getSecClusRoleRec().setRequiredOwnerCluster(value.getClusterRec());
		}
		requiredOwnerCluster = value;
	}

	@Override
	public ISecureSecSysGrpObj getRequiredContainerSysRole() {
		return( getRequiredContainerSysRole( false ) );
	}

	@Override
	public ISecureSecSysGrpObj getRequiredContainerSysRole( boolean forceRead ) {
		if( forceRead || ( requiredContainerSysRole == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureSecSysGrpObj obj = ((IBusModelSchemaObj)getOrigAsSecClusRole().getSchema()).getSecSysGrpTableObj().readSecSysGrpByUNameIdx( getSecClusRoleRec().getRequiredName() );
				requiredContainerSysRole = obj;
				if( obj != null ) {
					requiredContainerSysRole = obj;
				}
			}
		}
		return( requiredContainerSysRole );
	}

	@Override
	public void setRequiredContainerSysRole( ISecureSecSysGrpObj value ) {
		if( rec == null ) {
			getSecClusRoleRec();
		}
		if( value != null ) {
			requiredContainerSysRole = value;
			getSecClusRoleRec().setRequiredContainerSysRole(value.getSecSysGrpRec());
		}
		requiredContainerSysRole = value;
	}

	@Override
	public List<ISecureSecClusRoleMembObj> getOptionalChildrenMembByGrp() {
		List<ISecureSecClusRoleMembObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getSecClusRoleMembTableObj().readSecClusRoleMembByClusRoleIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<ISecureSecClusRoleMembObj> getOptionalChildrenMembByGrp( boolean forceRead ) {
		List<ISecureSecClusRoleMembObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getSecClusRoleMembTableObj().readSecClusRoleMembByClusRoleIdx( getPKey(),
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
		ISecureSecClusRole origRec = getOrigAsSecClusRole().getSecClusRoleRec();
		ISecureSecClusRole myRec = getSecClusRoleRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		ISecureSecClusRole origRec = getOrigAsSecClusRole().getSecClusRoleRec();
		ISecureSecClusRole myRec = getSecClusRoleRec();
		myRec.set( origRec );
	}
}
