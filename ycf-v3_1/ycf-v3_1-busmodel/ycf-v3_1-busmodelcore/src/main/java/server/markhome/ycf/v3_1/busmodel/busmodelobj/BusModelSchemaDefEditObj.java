// Description: Java 25 edit object instance implementation for BusModel SchemaDef.

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
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

public class BusModelSchemaDefEditObj
	extends BusModelScopeEditObj

	implements IBusModelSchemaDefEditObj
{
	protected IIntNetMinorVersionObj requiredContainerMinorVersion;
	protected List<IBusModelTableObj> optionalComponentsTables;
	protected List<IBusModelValueObj> optionalComponentsTypes;
	protected List<IBusModelSchemaRefObj> optionalComponentsSchemaRefs;
	protected List<IBusModelTweakObj> optionalComponentsTweaks;
	protected List<IBusModelSchemaRoleObj> optionalComponentsRoles;
	protected ISecureTenantObj requiredOwnerCTenant;

	public BusModelSchemaDefEditObj( IBusModelSchemaDefObj argOrig ) {
		super( argOrig );
		requiredContainerMinorVersion = null;
		requiredOwnerCTenant = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)orig.getSchema()).getSchemaDefTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SchemaDef" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IIntNetMinorVersionObj scope = getRequiredContainerMinorVersion();
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
				subObj = ((IBusModelSchemaObj)getSchema()).getTableTableObj().readTableByUNameIdx( getRequiredId(),
				natNextName, false );
			}
			catch (Throwable th) {
				subObj = null;
			}
		}
		if( subObj == null ) {
			try {
				if (nextName == null) {
					throw new YCFNullArgumentException(getClass(), "getNamedObject", 0, "RequiredName");
				}
				String natNextName = nextName;
				subObj = ((IBusModelSchemaObj)getSchema()).getValueTableObj().readValueByUNameIdx( getRequiredId(),
				natNextName, false );
			}
			catch (Throwable th) {
				subObj = null;
			}
		}
		if( subObj == null ) {
			try {
				if (nextName == null) {
					throw new YCFNullArgumentException(getClass(), "getNamedObject", 0, "RequiredName");
				}
				String natNextName = nextName;
				subObj = ((IBusModelSchemaObj)getSchema()).getTweakTableObj().readTweakByUNameIdx( getRequiredId(),
				natNextName, false );
			}
			catch (Throwable th) {
				subObj = null;
			}
		}
		if( subObj == null ) {
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
			else if( container instanceof IBusModelSubProjectObj ) {
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
	public IBusModelScopeObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		IBusModelSchemaDefObj retobj = getSchema().getSchemaDefTableObj().realiseSchemaDef( (IBusModelSchemaDefObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSchemaDef().forget();
	}

	@Override
	public IBusModelScopeObj create() {
		copyRecToOrig();
		IBusModelSchemaDefObj retobj = ((IBusModelSchemaObj)getOrigAsSchemaDef().getSchema()).getSchemaDefTableObj().createSchemaDef( getOrigAsSchemaDef() );
		if( retobj == getOrigAsSchemaDef() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelScopeEditObj update() {
		getSchema().getSchemaDefTableObj().updateSchemaDef( (IBusModelSchemaDefObj)this );
		return( null );
	}

	@Override
	public BusModelScopeEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSchemaDefTableObj().deleteSchemaDef( getOrigAsSchemaDef() );
		return( null );
	}

	@Override
	public IBusModelSchemaDefTableObj getSchemaDefTable() {
		return( orig.getSchema().getSchemaDefTableObj() );
	}

	@Override
	public IBusModelSchemaDefEditObj getEditAsSchemaDef() {
		return( (IBusModelSchemaDefEditObj)this );
	}

	@Override
	public IBusModelSchemaDefObj getOrigAsSchemaDef() {
		return( (IBusModelSchemaDefObj)orig );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			rec = getOrigAsSchemaDef().getSchema().getBusModelBackingStore().getBusModelFactory().getFactorySchemaDef().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelScope value ) {
		if( rec != value ) {
			super.setRec( value );
			requiredContainerMinorVersion = null;
			requiredOwnerCTenant = null;
		}
	}

	@Override
	public IBusModelSchemaDef getSchemaDefRec() {
		return( (IBusModelSchemaDef)getRec() );
	}

	@Override
	public IYCFKeyHash256 getRequiredId() {
		return( getPKey() );
	}

	@Override
	public void setRequiredId(IYCFKeyHash256 value) {
		if (getPKey() != value) {
			setPKey(value);
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredCTenantId() {
		return( getSchemaDefRec().getRequiredCTenantId() );
	}

	@Override
	public IYCFKeyHash256 getRequiredMinorVersionId() {
		return( getSchemaDefRec().getRequiredMinorVersionId() );
	}

	@Override
	public String getRequiredName() {
		return( getSchemaDefRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getSchemaDefRec().getRequiredName() != value ) {
			getSchemaDefRec().setRequiredName( value );
		}
	}

	@Override
	public String getOptionalDbName() {
		return( getSchemaDefRec().getOptionalDbName() );
	}

	@Override
	public void setOptionalDbName( String value ) {
		if( getSchemaDefRec().getOptionalDbName() != value ) {
			getSchemaDefRec().setOptionalDbName( value );
		}
	}

	@Override
	public String getOptionalShortName() {
		return( getSchemaDefRec().getOptionalShortName() );
	}

	@Override
	public void setOptionalShortName( String value ) {
		if( getSchemaDefRec().getOptionalShortName() != value ) {
			getSchemaDefRec().setOptionalShortName( value );
		}
	}

	@Override
	public String getOptionalLabel() {
		return( getSchemaDefRec().getOptionalLabel() );
	}

	@Override
	public void setOptionalLabel( String value ) {
		if( getSchemaDefRec().getOptionalLabel() != value ) {
			getSchemaDefRec().setOptionalLabel( value );
		}
	}

	@Override
	public String getOptionalShortDescription() {
		return( getSchemaDefRec().getOptionalShortDescription() );
	}

	@Override
	public void setOptionalShortDescription( String value ) {
		if( getSchemaDefRec().getOptionalShortDescription() != value ) {
			getSchemaDefRec().setOptionalShortDescription( value );
		}
	}

	@Override
	public String getOptionalDescription() {
		return( getSchemaDefRec().getOptionalDescription() );
	}

	@Override
	public void setOptionalDescription( String value ) {
		if( getSchemaDefRec().getOptionalDescription() != value ) {
			getSchemaDefRec().setOptionalDescription( value );
		}
	}

	@Override
	public String getRequiredCopyrightPeriod() {
		return( getSchemaDefRec().getRequiredCopyrightPeriod() );
	}

	@Override
	public void setRequiredCopyrightPeriod( String value ) {
		if( getSchemaDefRec().getRequiredCopyrightPeriod() != value ) {
			getSchemaDefRec().setRequiredCopyrightPeriod( value );
		}
	}

	@Override
	public String getRequiredCopyrightHolder() {
		return( getSchemaDefRec().getRequiredCopyrightHolder() );
	}

	@Override
	public void setRequiredCopyrightHolder( String value ) {
		if( getSchemaDefRec().getRequiredCopyrightHolder() != value ) {
			getSchemaDefRec().setRequiredCopyrightHolder( value );
		}
	}

	@Override
	public String getRequiredAuthorEMail() {
		return( getSchemaDefRec().getRequiredAuthorEMail() );
	}

	@Override
	public void setRequiredAuthorEMail( String value ) {
		if( getSchemaDefRec().getRequiredAuthorEMail() != value ) {
			getSchemaDefRec().setRequiredAuthorEMail( value );
		}
	}

	@Override
	public String getRequiredProjectURL() {
		return( getSchemaDefRec().getRequiredProjectURL() );
	}

	@Override
	public void setRequiredProjectURL( String value ) {
		if( getSchemaDefRec().getRequiredProjectURL() != value ) {
			getSchemaDefRec().setRequiredProjectURL( value );
		}
	}

	@Override
	public String getRequiredPublishURI() {
		return( getSchemaDefRec().getRequiredPublishURI() );
	}

	@Override
	public void setRequiredPublishURI( String value ) {
		if( getSchemaDefRec().getRequiredPublishURI() != value ) {
			getSchemaDefRec().setRequiredPublishURI( value );
		}
	}

	@Override
	public IIntNetMinorVersionObj getRequiredContainerMinorVersion() {
		return( getRequiredContainerMinorVersion( false ) );
	}

	@Override
	public IIntNetMinorVersionObj getRequiredContainerMinorVersion( boolean forceRead ) {
		if( forceRead || ( requiredContainerMinorVersion == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IIntNetMinorVersionObj obj = ((IBusModelSchemaObj)getOrigAsSchemaDef().getSchema()).getMinorVersionTableObj().readMinorVersionByIdIdx( getSchemaDefRec().getRequiredMinorVersionId() );
				requiredContainerMinorVersion = obj;
				if( obj != null ) {
					requiredContainerMinorVersion = obj;
				}
			}
		}
		return( requiredContainerMinorVersion );
	}

	@Override
	public void setRequiredContainerMinorVersion( IIntNetMinorVersionObj value ) {
		if( rec == null ) {
			getSchemaDefRec();
		}
		if( value != null ) {
			requiredContainerMinorVersion = value;
			getSchemaDefRec().setRequiredContainerMinorVersion(value.getMinorVersionRec());
		}
		requiredContainerMinorVersion = value;
	}

	@Override
	public List<IBusModelTableObj> getOptionalComponentsTables() {
		List<IBusModelTableObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getTableTableObj().readTableBySchemaDefIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelTableObj> getOptionalComponentsTables( boolean forceRead ) {
		List<IBusModelTableObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getTableTableObj().readTableBySchemaDefIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<IBusModelValueObj> getOptionalComponentsTypes() {
		List<IBusModelValueObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getValueTableObj().readValueByScopeIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelValueObj> getOptionalComponentsTypes( boolean forceRead ) {
		List<IBusModelValueObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getValueTableObj().readValueByScopeIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<IBusModelSchemaRefObj> getOptionalComponentsSchemaRefs() {
		List<IBusModelSchemaRefObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getSchemaRefTableObj().readSchemaRefBySchemaIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelSchemaRefObj> getOptionalComponentsSchemaRefs( boolean forceRead ) {
		List<IBusModelSchemaRefObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getSchemaRefTableObj().readSchemaRefBySchemaIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<IBusModelTweakObj> getOptionalComponentsTweaks() {
		List<IBusModelTweakObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getTweakTableObj().readTweakByScopeIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelTweakObj> getOptionalComponentsTweaks( boolean forceRead ) {
		List<IBusModelTweakObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getTweakTableObj().readTweakByScopeIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<IBusModelSchemaRoleObj> getOptionalComponentsRoles() {
		List<IBusModelSchemaRoleObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getSchemaRoleTableObj().readSchemaRoleBySchemaIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelSchemaRoleObj> getOptionalComponentsRoles( boolean forceRead ) {
		List<IBusModelSchemaRoleObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getSchemaRoleTableObj().readSchemaRoleBySchemaIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public ISecureTenantObj getRequiredOwnerCTenant() {
		return( getRequiredOwnerCTenant( false ) );
	}

	@Override
	public ISecureTenantObj getRequiredOwnerCTenant( boolean forceRead ) {
		if( forceRead || ( requiredOwnerCTenant == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				ISecureTenantObj obj = ((IBusModelSchemaObj)getOrigAsSchemaDef().getSchema()).getTenantTableObj().readTenantByIdIdx( getSchemaDefRec().getRequiredCTenantId() );
				requiredOwnerCTenant = obj;
			}
		}
		return( requiredOwnerCTenant );
	}

	@Override
	public void setRequiredOwnerCTenant( ISecureTenantObj value ) {
		if( rec == null ) {
			getSchemaDefRec();
		}
		if( value != null ) {
			requiredOwnerCTenant = value;
			getSchemaDefRec().setRequiredOwnerCTenant(value.getTenantRec());
		}
		requiredOwnerCTenant = value;
			super.setRequiredOwnerTenant( value );
	}

	@Override
	public void copyRecToOrig() {
		IBusModelSchemaDef origRec = getOrigAsSchemaDef().getSchemaDefRec();
		IBusModelSchemaDef myRec = getSchemaDefRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelSchemaDef origRec = getOrigAsSchemaDef().getSchemaDefRec();
		IBusModelSchemaDef myRec = getSchemaDefRec();
		myRec.set( origRec );
	}
}
