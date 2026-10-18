// Description: Java 25 base object instance implementation for TopProject

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
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;

public class BusModelTopProjectObj
	implements IBusModelTopProjectObj
{
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected boolean isNew;
	protected IIntNetTopProjectEditObj edit;
	protected IIntNetSchemaObj schema;
	protected $implCommaIJavaOptAtomType$ pKey;
	protected IIntNetTopProject rec;
	protected ISecureTenantObj requiredOwnerTenant;
	protected IIntNetTopDomainObj requiredContainerParentSDom;
	protected List<IIntNetSubProjectObj> optionalComponentsSubProject;

	public BusModelTopProjectObj() {
		isNew = true;
		requiredOwnerTenant = null;
		requiredContainerParentSDom = null;
	}

	public BusModelTopProjectObj( IIntNetSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredOwnerTenant = null;
		requiredContainerParentSDom = null;
	}

	@Override
	public int getClassCode() {
		return( ((IIntNetSchemaObj)schema).getTopProjectTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "TopProject" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IIntNetTopDomainObj scope = getRequiredContainerParentSDom();
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
		if( subObj == null ) {
			try {
				if (nextName == null) {
					throw new YCFNullArgumentException(getClass(), "getNamedObject", 0, "RequiredName");
				}
				String natNextName = nextName;
				subObj = ((IBusModelSchemaObj)getSchema()).getSubProjectTableObj().readSubProjectByNameIdx( getRequiredId(),
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
			else if( container instanceof IIntNetTenantObj ) {
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
	public IIntNetTopProjectObj realise() {
		IIntNetTopProjectObj retobj = ((IBusModelSchemaObj)getSchema()).getTopProjectTableObj().realiseTopProject(
			(IIntNetTopProjectObj)this );
		return( (IIntNetTopProjectObj)retobj );
	}

	@Override
	public void forget() {
		((IBusModelSchemaObj)getSchema()).getTopProjectTableObj().reallyDeepDisposeTopProject( (IIntNetTopProjectObj)this );
	}

	@Override
	public IIntNetTopProjectObj read() {
		IIntNetTopProjectObj retobj = ((IBusModelSchemaObj)getSchema()).getTopProjectTableObj().readTopProjectByIdIdx( getPKey(), false );
		return( (IIntNetTopProjectObj)retobj );
	}

	@Override
	public IIntNetTopProjectObj read( boolean forceRead ) {
		IIntNetTopProjectObj retobj = ((IBusModelSchemaObj)getSchema()).getTopProjectTableObj().readTopProjectByIdIdx( getPKey(), forceRead );
		return( (IIntNetTopProjectObj)retobj );
	}

	@Override
	public IIntNetTopProjectTableObj getTopProjectTable() {
		return( ((IBusModelSchemaObj)getSchema()).getTopProjectTableObj() );
	}

	@Override
	public IIntNetSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( IIntNetSchemaObj value ) {
		schema = value;
	}

	@Override
	public IIntNetTopProject getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getIntNetBackingStore().getIntNetFactory().getFactoryTopProject().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getIntNetBackingStore().getTableTopProject().readDerivedByIdIdx( ((IBusModelSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( IIntNetTopProject value ) {
		if( ! ( ( value == null ) || ! ( value instanceof IIntNetTopProject ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"IntNetTopProjectRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredOwnerTenant = null;
		requiredContainerParentSDom = null;
	}

	@Override
	public IIntNetTopProject getTopProjectRec() {
		return( (IIntNetTopProject)getRec() );
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
	public IIntNetTopProjectEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		IIntNetTopProjectObj lockobj;
		if( getIsNew() ) {
			lockobj = (IIntNetTopProjectObj)this;
		}
		else {
			lockobj = ((IBusModelSchemaObj)getSchema()).getTopProjectTableObj().lockTopProject( getPKey() );
		}
		edit = ((IBusModelSchemaObj)getSchema()).getTopProjectTableObj().newEditInstance( lockobj );
		return( (IIntNetTopProjectEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public IIntNetTopProjectEditObj getEdit() {
		return( edit );
	}

	@Override
	public IIntNetTopProjectEditObj getEditAsTopProject() {
		return( (IIntNetTopProjectEditObj)edit );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			IIntNetTopProject rec = getRec();
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
			IIntNetTopProject rec = getRec();
			updatedBy = ((IBusModelSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
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
	public ISecureTenantObj getRequiredOwnerTenant() {
		return( getRequiredOwnerTenant( false ) );
	}

	@Override
	public ISecureTenantObj getRequiredOwnerTenant( boolean forceRead ) {
		if( ( requiredOwnerTenant == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredOwnerTenant = ((IBusModelSchemaObj)getSchema()).getTenantTableObj().readTenantByIdIdx( getTopProjectRec().getRequiredTenantId(), forceRead );
			}
		}
		return( requiredOwnerTenant );
	}

	@Override
	public IIntNetTopDomainObj getRequiredContainerParentSDom() {
		return( getRequiredContainerParentSDom( false ) );
	}

	@Override
	public IIntNetTopDomainObj getRequiredContainerParentSDom( boolean forceRead ) {
		if( ( requiredContainerParentSDom == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerParentSDom = ((IBusModelSchemaObj)getSchema()).getTopDomainTableObj().readTopDomainByIdIdx( getTopProjectRec().getRequiredTopDomainId(), forceRead );
			}
		}
		return( requiredContainerParentSDom );
	}

	@Override
	public List<IIntNetSubProjectObj> getOptionalComponentsSubProject() {
		List<IIntNetSubProjectObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getSubProjectTableObj().readSubProjectByTopProjectIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IIntNetSubProjectObj> getOptionalComponentsSubProject( boolean forceRead ) {
		List<IIntNetSubProjectObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getSubProjectTableObj().readSubProjectByTopProjectIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public IYCFKeyHash256 getRequiredTenantId() {
		return( getTopProjectRec().getRequiredTenantId() );
	}

	@Override
	public IYCFKeyHash256 getRequiredTopDomainId() {
		return( getTopProjectRec().getRequiredTopDomainId() );
	}

	@Override
	public String getRequiredName() {
		return( getTopProjectRec().getRequiredName() );
	}

	@Override
	public String getOptionalDescription() {
		return( getTopProjectRec().getOptionalDescription() );
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
