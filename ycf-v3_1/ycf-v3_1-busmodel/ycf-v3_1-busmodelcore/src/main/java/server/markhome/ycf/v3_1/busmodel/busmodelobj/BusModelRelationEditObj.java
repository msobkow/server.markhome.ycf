// Description: Java 25 edit object instance implementation for BusModel Relation.

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

public class BusModelRelationEditObj
	extends BusModelScopeEditObj

	implements IBusModelRelationEditObj
{
	protected IBusModelSchemaDefObj optionalLookupDefSchema;
	protected IBusModelTableObj requiredContainerFromTable;
	protected List<IBusModelRelationColObj> optionalComponentsColumns;
	protected List<IBusModelPopTopDepObj> optionalComponentsPopDep;
	protected IBusModelIndexObj requiredLookupFromIndex;
	protected IBusModelTableObj requiredLookupToTable;
	protected IBusModelIndexObj requiredLookupToIndex;
	protected IBusModelRelationObj optionalLookupNarrowed;

	public BusModelRelationEditObj( IBusModelRelationObj argOrig ) {
		super( argOrig );
		optionalLookupDefSchema = null;
		requiredContainerFromTable = null;
		requiredLookupFromIndex = null;
		requiredLookupToTable = null;
		requiredLookupToIndex = null;
		optionalLookupNarrowed = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)orig.getSchema()).getRelationTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "Relation" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelTableObj scope = getRequiredContainerFromTable();
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
				subObj = ((IBusModelSchemaObj)getSchema()).getRelationColTableObj().readRelationColByUNameIdx( getRequiredId(),
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
			else if( container instanceof IBusModelSchemaDefObj ) {
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
		IBusModelRelationObj retobj = getSchema().getRelationTableObj().realiseRelation( (IBusModelRelationObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsRelation().forget();
	}

	@Override
	public IBusModelScopeObj create() {
		copyRecToOrig();
		IBusModelRelationObj retobj = ((IBusModelSchemaObj)getOrigAsRelation().getSchema()).getRelationTableObj().createRelation( getOrigAsRelation() );
		if( retobj == getOrigAsRelation() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelScopeEditObj update() {
		getSchema().getRelationTableObj().updateRelation( (IBusModelRelationObj)this );
		return( null );
	}

	@Override
	public BusModelScopeEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getRelationTableObj().deleteRelation( getOrigAsRelation() );
		return( null );
	}

	@Override
	public IBusModelRelationTableObj getRelationTable() {
		return( orig.getSchema().getRelationTableObj() );
	}

	@Override
	public IBusModelRelationEditObj getEditAsRelation() {
		return( (IBusModelRelationEditObj)this );
	}

	@Override
	public IBusModelRelationObj getOrigAsRelation() {
		return( (IBusModelRelationObj)orig );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			rec = getOrigAsRelation().getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryRelation().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelScope value ) {
		if( rec != value ) {
			super.setRec( value );
			optionalLookupDefSchema = null;
			requiredContainerFromTable = null;
			requiredLookupFromIndex = null;
			requiredLookupToTable = null;
			requiredLookupToIndex = null;
			optionalLookupNarrowed = null;
		}
	}

	@Override
	public IBusModelRelation getRelationRec() {
		return( (IBusModelRelation)getRec() );
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
	public IYCFKeyHash256 getRequiredTableId() {
		return( getRelationRec().getRequiredTableId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalDefSchemaId() {
		return( getRelationRec().getOptionalDefSchemaId() );
	}

	@Override
	public String getRequiredName() {
		return( getRelationRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getRelationRec().getRequiredName() != value ) {
			getRelationRec().setRequiredName( value );
		}
	}

	@Override
	public String getOptionalShortName() {
		return( getRelationRec().getOptionalShortName() );
	}

	@Override
	public void setOptionalShortName( String value ) {
		if( getRelationRec().getOptionalShortName() != value ) {
			getRelationRec().setOptionalShortName( value );
		}
	}

	@Override
	public String getOptionalLabel() {
		return( getRelationRec().getOptionalLabel() );
	}

	@Override
	public void setOptionalLabel( String value ) {
		if( getRelationRec().getOptionalLabel() != value ) {
			getRelationRec().setOptionalLabel( value );
		}
	}

	@Override
	public String getOptionalShortDescription() {
		return( getRelationRec().getOptionalShortDescription() );
	}

	@Override
	public void setOptionalShortDescription( String value ) {
		if( getRelationRec().getOptionalShortDescription() != value ) {
			getRelationRec().setOptionalShortDescription( value );
		}
	}

	@Override
	public String getOptionalDescription() {
		return( getRelationRec().getOptionalDescription() );
	}

	@Override
	public void setOptionalDescription( String value ) {
		if( getRelationRec().getOptionalDescription() != value ) {
			getRelationRec().setOptionalDescription( value );
		}
	}

	@Override
	public IBusModelPubSchema.RelationTypeEnum getRequiredRelationType() {
		return( getRelationRec().getRequiredRelationType() );
	}

	@Override
	public void setRequiredRelationType( IBusModelPubSchema.RelationTypeEnum value ) {
		if( getRelationRec().getRequiredRelationType() != value ) {
			getRelationRec().setRequiredRelationType( value );
		}
	}

	@Override
	public String getOptionalDbName() {
		return( getRelationRec().getOptionalDbName() );
	}

	@Override
	public void setOptionalDbName( String value ) {
		if( getRelationRec().getOptionalDbName() != value ) {
			getRelationRec().setOptionalDbName( value );
		}
	}

	@Override
	public String getOptionalSuffix() {
		return( getRelationRec().getOptionalSuffix() );
	}

	@Override
	public void setOptionalSuffix( String value ) {
		if( getRelationRec().getOptionalSuffix() != value ) {
			getRelationRec().setOptionalSuffix( value );
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredFromIndexId() {
		return( getRelationRec().getRequiredFromIndexId() );
	}

	@Override
	public IYCFKeyHash256 getRequiredToTableId() {
		return( getRelationRec().getRequiredToTableId() );
	}

	@Override
	public IYCFKeyHash256 getRequiredToIndexId() {
		return( getRelationRec().getRequiredToIndexId() );
	}

	@Override
	public boolean getRequiredIsRequired() {
		return( getRelationRec().getRequiredIsRequired() );
	}

	@Override
	public void setRequiredIsRequired( boolean value ) {
		if( getRelationRec().getRequiredIsRequired() != value ) {
			getRelationRec().setRequiredIsRequired( value );
		}
	}

	@Override
	public boolean getRequiredIsXsdContainer() {
		return( getRelationRec().getRequiredIsXsdContainer() );
	}

	@Override
	public void setRequiredIsXsdContainer( boolean value ) {
		if( getRelationRec().getRequiredIsXsdContainer() != value ) {
			getRelationRec().setRequiredIsXsdContainer( value );
		}
	}

	@Override
	public boolean getRequiredIsLateResolver() {
		return( getRelationRec().getRequiredIsLateResolver() );
	}

	@Override
	public void setRequiredIsLateResolver( boolean value ) {
		if( getRelationRec().getRequiredIsLateResolver() != value ) {
			getRelationRec().setRequiredIsLateResolver( value );
		}
	}

	@Override
	public boolean getRequiredAllowAddendum() {
		return( getRelationRec().getRequiredAllowAddendum() );
	}

	@Override
	public void setRequiredAllowAddendum( boolean value ) {
		if( getRelationRec().getRequiredAllowAddendum() != value ) {
			getRelationRec().setRequiredAllowAddendum( value );
		}
	}

	@Override
	public IYCFKeyHash256 getOptionalNarrowedId() {
		return( getRelationRec().getOptionalNarrowedId() );
	}

	@Override
	public IBusModelPubSchema.CodeVisibilityEnum getRequiredCodeVis() {
		return( getRelationRec().getRequiredCodeVis() );
	}

	@Override
	public void setRequiredCodeVis( IBusModelPubSchema.CodeVisibilityEnum value ) {
		if( getRelationRec().getRequiredCodeVis() != value ) {
			getRelationRec().setRequiredCodeVis( value );
		}
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getRelationRec().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelSchemaDefObj obj = ((IBusModelSchemaObj)getOrigAsRelation().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getRelationRec().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	@Override
	public void setOptionalLookupDefSchema( IBusModelSchemaDefObj value ) {
		if( rec == null ) {
			getRelationRec();
		}
		if( value != null ) {
			optionalLookupDefSchema = value;
			getRelationRec().setOptionalLookupDefSchema(value.getSchemaDefRec());
		}
		else {
			optionalLookupDefSchema = null;
			getRelationRec().setOptionalLookupDefSchema((IBusModelSchemaDef)null);
		}
		optionalLookupDefSchema = value;
	}

	@Override
	public IBusModelTableObj getRequiredContainerFromTable() {
		return( getRequiredContainerFromTable( false ) );
	}

	@Override
	public IBusModelTableObj getRequiredContainerFromTable( boolean forceRead ) {
		if( forceRead || ( requiredContainerFromTable == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelTableObj obj = ((IBusModelSchemaObj)getOrigAsRelation().getSchema()).getTableTableObj().readTableByIdIdx( getRelationRec().getRequiredTableId() );
				requiredContainerFromTable = obj;
				if( obj != null ) {
					requiredContainerFromTable = obj;
				}
			}
		}
		return( requiredContainerFromTable );
	}

	@Override
	public void setRequiredContainerFromTable( IBusModelTableObj value ) {
		if( rec == null ) {
			getRelationRec();
		}
		if( value != null ) {
			requiredContainerFromTable = value;
			getRelationRec().setRequiredContainerFromTable(value.getTableRec());
		}
		requiredContainerFromTable = value;
	}

	@Override
	public List<IBusModelRelationColObj> getOptionalComponentsColumns() {
		List<IBusModelRelationColObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getRelationColTableObj().readRelationColByRelationIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelRelationColObj> getOptionalComponentsColumns( boolean forceRead ) {
		List<IBusModelRelationColObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getRelationColTableObj().readRelationColByRelationIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<IBusModelPopTopDepObj> getOptionalComponentsPopDep() {
		List<IBusModelPopTopDepObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getPopTopDepTableObj().readPopTopDepByContRelIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelPopTopDepObj> getOptionalComponentsPopDep( boolean forceRead ) {
		List<IBusModelPopTopDepObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getPopTopDepTableObj().readPopTopDepByContRelIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public IBusModelIndexObj getRequiredLookupFromIndex() {
		return( getRequiredLookupFromIndex( false ) );
	}

	@Override
	public IBusModelIndexObj getRequiredLookupFromIndex( boolean forceRead ) {
		if( forceRead || ( requiredLookupFromIndex == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelIndexObj obj = ((IBusModelSchemaObj)getOrigAsRelation().getSchema()).getIndexTableObj().readIndexByIdIdx( getRelationRec().getRequiredFromIndexId() );
				requiredLookupFromIndex = obj;
			}
		}
		return( requiredLookupFromIndex );
	}

	@Override
	public void setRequiredLookupFromIndex( IBusModelIndexObj value ) {
		if( rec == null ) {
			getRelationRec();
		}
		if( value != null ) {
			requiredLookupFromIndex = value;
			getRelationRec().setRequiredLookupFromIndex(value.getIndexRec());
		}
		else {
			requiredLookupFromIndex = null;
			getRelationRec().setRequiredLookupFromIndex((IBusModelIndex)null);
		}
		requiredLookupFromIndex = value;
	}

	@Override
	public IBusModelTableObj getRequiredLookupToTable() {
		return( getRequiredLookupToTable( false ) );
	}

	@Override
	public IBusModelTableObj getRequiredLookupToTable( boolean forceRead ) {
		if( forceRead || ( requiredLookupToTable == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelTableObj obj = ((IBusModelSchemaObj)getOrigAsRelation().getSchema()).getTableTableObj().readTableByIdIdx( getRelationRec().getRequiredToTableId() );
				requiredLookupToTable = obj;
			}
		}
		return( requiredLookupToTable );
	}

	@Override
	public void setRequiredLookupToTable( IBusModelTableObj value ) {
		if( rec == null ) {
			getRelationRec();
		}
		if( value != null ) {
			requiredLookupToTable = value;
			getRelationRec().setRequiredLookupToTable(value.getTableRec());
		}
		else {
			requiredLookupToTable = null;
			getRelationRec().setRequiredLookupToTable((IBusModelTable)null);
		}
		requiredLookupToTable = value;
	}

	@Override
	public IBusModelIndexObj getRequiredLookupToIndex() {
		return( getRequiredLookupToIndex( false ) );
	}

	@Override
	public IBusModelIndexObj getRequiredLookupToIndex( boolean forceRead ) {
		if( forceRead || ( requiredLookupToIndex == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelIndexObj obj = ((IBusModelSchemaObj)getOrigAsRelation().getSchema()).getIndexTableObj().readIndexByIdIdx( getRelationRec().getRequiredToIndexId() );
				requiredLookupToIndex = obj;
			}
		}
		return( requiredLookupToIndex );
	}

	@Override
	public void setRequiredLookupToIndex( IBusModelIndexObj value ) {
		if( rec == null ) {
			getRelationRec();
		}
		if( value != null ) {
			requiredLookupToIndex = value;
			getRelationRec().setRequiredLookupToIndex(value.getIndexRec());
		}
		else {
			requiredLookupToIndex = null;
			getRelationRec().setRequiredLookupToIndex((IBusModelIndex)null);
		}
		requiredLookupToIndex = value;
	}

	@Override
	public IBusModelRelationObj getOptionalLookupNarrowed() {
		return( getOptionalLookupNarrowed( false ) );
	}

	@Override
	public IBusModelRelationObj getOptionalLookupNarrowed( boolean forceRead ) {
		if( forceRead || ( optionalLookupNarrowed == null ) ) {
			boolean anyMissing = false;
			if( getRelationRec().getOptionalNarrowedId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelRelationObj obj = ((IBusModelSchemaObj)getOrigAsRelation().getSchema()).getRelationTableObj().readRelationByIdIdx( getRelationRec().getOptionalNarrowedId() );
				optionalLookupNarrowed = obj;
			}
		}
		return( optionalLookupNarrowed );
	}

	@Override
	public void setOptionalLookupNarrowed( IBusModelRelationObj value ) {
		if( rec == null ) {
			getRelationRec();
		}
		if( value != null ) {
			optionalLookupNarrowed = value;
			getRelationRec().setOptionalLookupNarrowed(value.getRelationRec());
		}
		else {
			optionalLookupNarrowed = null;
			getRelationRec().setOptionalLookupNarrowed((IBusModelRelation)null);
		}
		optionalLookupNarrowed = value;
	}

	@Override
	public void copyRecToOrig() {
		IBusModelRelation origRec = getOrigAsRelation().getRelationRec();
		IBusModelRelation myRec = getRelationRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelRelation origRec = getOrigAsRelation().getRelationRec();
		IBusModelRelation myRec = getRelationRec();
		myRec.set( origRec );
	}

	public IBusModelSubProjectObj getProject() {
		for( ICFLibAnyObj curDef = this; curDef != null; curDef = curDef.getObjScope() ) {
			if( curDef instanceof IBusModelSubProjectObj ) {
				return ((IBusModelSubProjectObj)curDef);
			}
			else if( curDef instanceof IBusModelTldObj ) {
				return( null );
			}
		}
		return( null );
	}

	public IBusModelTopDomainObj getCompany() {
		for( ICFLibAnyObj curDef = this; curDef != null; curDef = curDef.getObjScope() ) {
			if( curDef instanceof IBusModelTopDomainObj ) {
				return ((IBusModelTopDomainObj)curDef);
			}
			else if( curDef instanceof IBusModelTldObj ) {
				return( null );
			}
		}
		return( null );
	}

	public IBusModelSchemaDefObj getSchemaDef() {
		for( ICFLibAnyObj curDef = this; curDef != null; curDef = curDef.getObjScope() ) {
			if( curDef instanceof IBusModelSchemaDefObj ) {
				return ((IBusModelSchemaDefObj)curDef);
			}
			else if( curDef instanceof IBusModelTldObj ) {
				return( null );
			}
		}
		return( null );
	}

	public IBusModelMinorVersionObj getVersion() {
		for( ICFLibAnyObj curDef = this; curDef != null; curDef = curDef.getObjScope() ) {
			if( curDef instanceof IBusModelMinorVersionObj ) {
				return ((IBusModelMinorVersionObj)curDef);
			}
			else if( curDef instanceof IBusModelMajorVersionObj ) {
				return( null );
			}
			else if( curDef instanceof IBusModelSubProjectObj ) {
				return( null );
			}
			else if( curDef instanceof IBusModelTopProjectObj ) {
				return( null );
			}
			else if( curDef instanceof IBusModelTopDomainObj ) {
				return( null );
			}
			else if( curDef instanceof IBusModelTldObj ) {
				return( null );
			}
		}
		return( null );
	}

	protected String getVersionStringForVersion( ICFLibAnyObj value ) {
		String ret;
		if( value instanceof IBusModelMinorVersionObj ) {
			ret = ((IBusModelMinorVersionObj)value).getRequiredName();
		}
		else if( value instanceof IBusModelMajorVersionObj ) {
			ret = ((IBusModelMajorVersionObj)value).getRequiredName();
		}
		else {
			ret = null;
		}
		return( ret );
	}

	public String getVersionString() {
		ICFLibAnyObj scopeDef;
		ICFLibAnyObj curDef = getVersion();
		List<String> invertedNodeNames = new ArrayList<String>();
		while (curDef != null) {
			if( curDef instanceof IBusModelMinorVersionObj ) {
				invertedNodeNames.add( getVersionStringForVersion( (IBusModelMinorVersionObj) curDef ) );
			}
			else if( curDef instanceof IBusModelMajorVersionObj ) {
				invertedNodeNames.add( getVersionStringForVersion( (IBusModelMajorVersionObj) curDef ) );
			}
			scopeDef = curDef.getObjScope();
			if( scopeDef == null) {
				curDef = null;
			}
			else if( scopeDef instanceof IBusModelMinorVersionObj ) {
				curDef = scopeDef;
			}
			else if( scopeDef instanceof IBusModelMajorVersionObj ) {
				curDef = scopeDef;
			}
			else {
				curDef = null;
			}
		}
		String ret = "";
		for( int idx = invertedNodeNames.size() - 1; idx >= 0; idx-- )
		{
			if( ret.length() == 0) {
				ret = invertedNodeNames.get(idx);
			}
			else {
				ret = ret + "-" + invertedNodeNames.get(idx);
			}
		}
		return( ret );
	}

	public String getPackedVersionString() {
		ICFLibAnyObj scopeDef;
		ICFLibAnyObj curDef = getVersion();
		List<String> invertedNodeNames = new ArrayList<String>();
		while (curDef != null) {
			if( curDef instanceof IBusModelMinorVersionObj ) {
				invertedNodeNames.add( getVersionStringForVersion( (IBusModelMinorVersionObj) curDef ) );
			}
			else if( curDef instanceof IBusModelMajorVersionObj ) {
				invertedNodeNames.add( getVersionStringForVersion( (IBusModelMajorVersionObj) curDef ) );
			}
			scopeDef = curDef.getObjScope();
			if( scopeDef == null) {
				curDef = null;
			}
			else if( scopeDef instanceof IBusModelMinorVersionObj ) {
				curDef = scopeDef;
			}
			else if( scopeDef instanceof IBusModelMajorVersionObj ) {
				curDef = scopeDef;
			}
			else {
				curDef = null;
			}
		}
		String ret = "";
		for( int idx = invertedNodeNames.size() - 1; idx >= 0; idx-- )
		{
			if( ret.length() == 0) {
				ret = invertedNodeNames.get(idx);
			}
			else {
				ret = ret + invertedNodeNames.get(idx);
			}
		}
		return( ret );
	}

	public Boolean isColumnInOwnerRelation() {

		ICFLibAnyObj		focusDef;
		IBusModelTableObj		tableDef;
		final String S_ProcName = "isColumnInOwnerRelation() ";

		if( this instanceof IBusModelAtomObj ) {
			IBusModelAtomObj atomDef = (IBusModelAtomObj)this;
			ICFLibAnyObj atomScopeDef = atomDef.getObjScope();
			tableDef = (IBusModelTableObj)atomScopeDef;
			focusDef = this;
		}
		else if( this instanceof IBusModelTableColObj ) {
			IBusModelTableColObj tableColDef = (IBusModelTableColObj)this;
			ICFLibAnyObj tableColScopeDef = tableColDef.getObjScope();
			tableDef = (IBusModelTableObj)tableColScopeDef;
			focusDef = this;
		}
		else if( this instanceof IBusModelIndexColObj ) {
			IBusModelIndexColObj indexColDef = (IBusModelIndexColObj)this;
			focusDef = indexColDef.getRequiredLookupColumn();
			if( focusDef instanceof IBusModelAtomObj ) {
				tableDef = (IBusModelTableObj)((IBusModelAtomObj)focusDef).getObjScope();
			}
			else if( focusDef instanceof IBusModelTableColObj ) {
				tableDef = (IBusModelTableObj)((IBusModelTableColObj)focusDef).getObjScope();
			}
			else {
				throw new RuntimeException(
					S_ProcName + "genContext.getGenDef().getColumnDef() for a IBusModelIndexColObj did not return a IBusModelAtomObj"
						+	" nor a IBusModelTableColObj" );
			}
		}
		else if( this instanceof IBusModelRelationColObj ) {
			IBusModelRelationColObj relColDef = (IBusModelRelationColObj)this;
			ICFLibAnyObj columnDef = relColDef.getRequiredLookupFromCol();
			if( columnDef instanceof IBusModelAtomObj ) {
				focusDef = columnDef;
				tableDef = (IBusModelTableObj)columnDef.getObjScope();
			}
			else if( columnDef instanceof IBusModelTableColObj ) {
				focusDef = columnDef;
				tableDef = (IBusModelTableObj)columnDef.getObjScope();
			}
			else {
				throw new RuntimeException(
					S_ProcName + "genContext.getGenDef().getFromColumnDef() for a IBusModelIndexColObj did not return a IBusModelAtomObj"
						+	" nor a IBusModelTableColObj" );
			}
		}
		else {
			throw new RuntimeException(
				S_ProcName + "genContext.getGenDef() did not return a IBusModelAtomObj, IBusModelTableColObj, nor IBusModelIndexColObj instance" );
		}

		List<IBusModelRelationObj> ownerRelations = tableDef.getContainerOwnerRelations();
		if( ( ownerRelations == null )
		 || ( ( ownerRelations != null ) && ( ownerRelations.size() == 0 ) ) )
		{
			return( false );
		}

		ListIterator<IBusModelRelationObj> ownerEnumerator = ownerRelations.listIterator();

		IBusModelRelationObj ownerRelation;
		IBusModelRelationColObj ownerRelationCol;
		Iterator<IBusModelRelationColObj> ownerRelationCols;

		while( ownerEnumerator.hasNext() ) {

			ownerRelation = ownerEnumerator.next();
			ownerRelationCols = ownerRelation.getOptionalComponentsColumns().iterator();

			while( ownerRelationCols.hasNext() ) {
				ownerRelationCol = ownerRelationCols.next();
				if( ownerRelationCol.getRequiredLookupFromCol() == focusDef ) {
					return( true );
				}
			}
		}

		return( false );
	}
}
