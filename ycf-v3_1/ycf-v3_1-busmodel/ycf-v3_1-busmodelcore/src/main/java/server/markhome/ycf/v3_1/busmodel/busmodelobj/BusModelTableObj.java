// Description: Java 25 base object instance implementation for Table

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

public class BusModelTableObj
	extends BusModelScopeObj
	implements IBusModelTableObj
{
	protected IBusModelSchemaDefObj requiredContainerSchemaDef;
	protected IBusModelSchemaDefObj optionalLookupDefSchema;
	protected List<IBusModelRelationObj> optionalComponentsRelation;
	protected IBusModelIndexObj optionalLookupLookupIndex;
	protected IBusModelIndexObj optionalLookupAltIndex;
	protected IBusModelTableObj optionalLookupQualTable;
	protected List<IBusModelIndexObj> optionalComponentsIndex;
	protected IBusModelIndexObj optionalLookupPrimaryIndex;
	protected List<IBusModelValueObj> optionalComponentsColumns;
	protected List<IBusModelRelationObj> optionalChildrenReverseRelations;
	protected List<IBusModelChainObj> optionalComponentsChains;
	protected List<IBusModelDelTopDepObj> optionalComponentsDelDep;
	protected List<IBusModelClearTopDepObj> optionalComponentsClearDep;
	protected List<IBusModelServerMethodObj> optionalComponentsServerMethods;
	protected List<IBusModelTweakObj> optionalComponentsTweaks;

	public BusModelTableObj() {
		super();
		requiredContainerSchemaDef = null;
		optionalLookupDefSchema = null;
		optionalLookupLookupIndex = null;
		optionalLookupAltIndex = null;
		optionalLookupQualTable = null;
		optionalLookupPrimaryIndex = null;
	}

	public BusModelTableObj( IBusModelSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerSchemaDef = null;
		optionalLookupDefSchema = null;
		optionalLookupLookupIndex = null;
		optionalLookupAltIndex = null;
		optionalLookupQualTable = null;
		optionalLookupPrimaryIndex = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)schema).getTableTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "Table" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelSchemaDefObj scope = getRequiredContainerSchemaDef();
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
				subObj = ((IBusModelSchemaObj)getSchema()).getRelationTableObj().readRelationByUNameIdx( getRequiredId(),
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
				subObj = ((IBusModelSchemaObj)getSchema()).getIndexTableObj().readIndexByUNameIdx( getRequiredId(),
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
				subObj = ((IBusModelSchemaObj)getSchema()).getChainTableObj().readChainByUNameIdx( getRequiredId(),
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
				subObj = ((IBusModelSchemaObj)getSchema()).getServerMethodTableObj().readServerMethodByUNameIdx( getRequiredId(),
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
		IBusModelTableObj retobj = ((IBusModelSchemaObj)getSchema()).getTableTableObj().realiseTable(
			(IBusModelTableObj)this );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public void forget() {
		((IBusModelSchemaObj)getSchema()).getTableTableObj().reallyDeepDisposeTable( (IBusModelTableObj)this );
	}

	@Override
	public IBusModelScopeObj read() {
		IBusModelTableObj retobj = ((IBusModelSchemaObj)getSchema()).getTableTableObj().readTableByIdIdx( getPKey(), false );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public IBusModelScopeObj read( boolean forceRead ) {
		IBusModelTableObj retobj = ((IBusModelSchemaObj)getSchema()).getTableTableObj().readTableByIdIdx( getPKey(), forceRead );
		return( (IBusModelScopeObj)retobj );
	}

	@Override
	public IBusModelTableTableObj getTableTable() {
		return( ((IBusModelSchemaObj)getSchema()).getTableTableObj() );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryTable().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getBusModelBackingStore().getTableTable().readDerivedByIdIdx( ((IBusModelSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelScope value ) {
		if( ! ( ( value == null ) || ! ( value instanceof IBusModelTable ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"BusModelTableRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredOwnerTenant = null;
		requiredContainerSchemaDef = null;
		optionalLookupDefSchema = null;
		optionalLookupLookupIndex = null;
		optionalLookupAltIndex = null;
		optionalLookupQualTable = null;
		optionalLookupPrimaryIndex = null;
	}

	@Override
	public IBusModelTable getTableRec() {
		return( (IBusModelTable)getRec() );
	}

	@Override
	public IBusModelScopeEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		IBusModelTableObj lockobj;
		if( getIsNew() ) {
			lockobj = (IBusModelTableObj)this;
		}
		else {
			lockobj = ((IBusModelSchemaObj)getSchema()).getTableTableObj().lockTable( getPKey() );
		}
		edit = ((IBusModelSchemaObj)getSchema()).getTableTableObj().newEditInstance( lockobj );
		return( (IBusModelScopeEditObj)edit );
	}

	@Override
	public IBusModelTableEditObj getEditAsTable() {
		return( (IBusModelTableEditObj)edit );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			IBusModelScope rec = getRec();
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
			IBusModelScope rec = getRec();
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
	public IBusModelSchemaDefObj getRequiredContainerSchemaDef() {
		return( getRequiredContainerSchemaDef( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getRequiredContainerSchemaDef( boolean forceRead ) {
		if( ( requiredContainerSchemaDef == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerSchemaDef = ((IBusModelSchemaObj)getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getTableRec().getRequiredSchemaDefId(), forceRead );
			}
		}
		return( requiredContainerSchemaDef );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( ( optionalLookupDefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableRec().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefSchema = ((IBusModelSchemaObj)getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getTableRec().getOptionalDefSchemaId(), forceRead );
			}
		}
		return( optionalLookupDefSchema );
	}

	@Override
	public List<IBusModelRelationObj> getOptionalComponentsRelation() {
		List<IBusModelRelationObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getRelationTableObj().readRelationByRelTableIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelRelationObj> getOptionalComponentsRelation( boolean forceRead ) {
		List<IBusModelRelationObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getRelationTableObj().readRelationByRelTableIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public IBusModelIndexObj getOptionalLookupLookupIndex() {
		return( getOptionalLookupLookupIndex( false ) );
	}

	@Override
	public IBusModelIndexObj getOptionalLookupLookupIndex( boolean forceRead ) {
		if( ( optionalLookupLookupIndex == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableRec().getOptionalLookupIndexId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupLookupIndex = ((IBusModelSchemaObj)getSchema()).getIndexTableObj().readIndexByIdIdx( getTableRec().getOptionalLookupIndexId(), forceRead );
			}
		}
		return( optionalLookupLookupIndex );
	}

	@Override
	public IBusModelIndexObj getOptionalLookupAltIndex() {
		return( getOptionalLookupAltIndex( false ) );
	}

	@Override
	public IBusModelIndexObj getOptionalLookupAltIndex( boolean forceRead ) {
		if( ( optionalLookupAltIndex == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableRec().getOptionalAltIndexId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupAltIndex = ((IBusModelSchemaObj)getSchema()).getIndexTableObj().readIndexByIdIdx( getTableRec().getOptionalAltIndexId(), forceRead );
			}
		}
		return( optionalLookupAltIndex );
	}

	@Override
	public IBusModelTableObj getOptionalLookupQualTable() {
		return( getOptionalLookupQualTable( false ) );
	}

	@Override
	public IBusModelTableObj getOptionalLookupQualTable( boolean forceRead ) {
		if( ( optionalLookupQualTable == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableRec().getOptionalQualifyingTableId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupQualTable = ((IBusModelSchemaObj)getSchema()).getTableTableObj().readTableByIdIdx( getTableRec().getOptionalQualifyingTableId(), forceRead );
			}
		}
		return( optionalLookupQualTable );
	}

	@Override
	public List<IBusModelIndexObj> getOptionalComponentsIndex() {
		List<IBusModelIndexObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getIndexTableObj().readIndexByIdxTableIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelIndexObj> getOptionalComponentsIndex( boolean forceRead ) {
		List<IBusModelIndexObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getIndexTableObj().readIndexByIdxTableIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public IBusModelIndexObj getOptionalLookupPrimaryIndex() {
		return( getOptionalLookupPrimaryIndex( false ) );
	}

	@Override
	public IBusModelIndexObj getOptionalLookupPrimaryIndex( boolean forceRead ) {
		if( ( optionalLookupPrimaryIndex == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getTableRec().getOptionalPrimaryIndexId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrimaryIndex = ((IBusModelSchemaObj)getSchema()).getIndexTableObj().readIndexByIdIdx( getTableRec().getOptionalPrimaryIndexId(), forceRead );
			}
		}
		return( optionalLookupPrimaryIndex );
	}

	@Override
	public List<IBusModelValueObj> getOptionalComponentsColumns() {
		List<IBusModelValueObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getValueTableObj().readValueByScopeIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelValueObj> getOptionalComponentsColumns( boolean forceRead ) {
		List<IBusModelValueObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getValueTableObj().readValueByScopeIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<IBusModelRelationObj> getOptionalChildrenReverseRelations() {
		List<IBusModelRelationObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getRelationTableObj().readRelationByToTblIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelRelationObj> getOptionalChildrenReverseRelations( boolean forceRead ) {
		List<IBusModelRelationObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getRelationTableObj().readRelationByToTblIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<IBusModelChainObj> getOptionalComponentsChains() {
		List<IBusModelChainObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getChainTableObj().readChainByChainTableIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelChainObj> getOptionalComponentsChains( boolean forceRead ) {
		List<IBusModelChainObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getChainTableObj().readChainByChainTableIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<IBusModelDelTopDepObj> getOptionalComponentsDelDep() {
		List<IBusModelDelTopDepObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getDelTopDepTableObj().readDelTopDepByDelTopDepTblIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelDelTopDepObj> getOptionalComponentsDelDep( boolean forceRead ) {
		List<IBusModelDelTopDepObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getDelTopDepTableObj().readDelTopDepByDelTopDepTblIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<IBusModelClearTopDepObj> getOptionalComponentsClearDep() {
		List<IBusModelClearTopDepObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getClearTopDepTableObj().readClearTopDepByClrTopDepTblIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelClearTopDepObj> getOptionalComponentsClearDep( boolean forceRead ) {
		List<IBusModelClearTopDepObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getClearTopDepTableObj().readClearTopDepByClrTopDepTblIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<IBusModelServerMethodObj> getOptionalComponentsServerMethods() {
		List<IBusModelServerMethodObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getServerMethodTableObj().readServerMethodByMethTableIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelServerMethodObj> getOptionalComponentsServerMethods( boolean forceRead ) {
		List<IBusModelServerMethodObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getServerMethodTableObj().readServerMethodByMethTableIdx( getPKey(),
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
	public IYCFKeyHash256 getRequiredSchemaDefId() {
		return( getTableRec().getRequiredSchemaDefId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalDefSchemaId() {
		return( getTableRec().getOptionalDefSchemaId() );
	}

	@Override
	public String getRequiredName() {
		return( getTableRec().getRequiredName() );
	}

	@Override
	public String getOptionalDbName() {
		return( getTableRec().getOptionalDbName() );
	}

	@Override
	public String getOptionalShortName() {
		return( getTableRec().getOptionalShortName() );
	}

	@Override
	public String getOptionalLabel() {
		return( getTableRec().getOptionalLabel() );
	}

	@Override
	public String getOptionalShortDescription() {
		return( getTableRec().getOptionalShortDescription() );
	}

	@Override
	public String getOptionalDescription() {
		return( getTableRec().getOptionalDescription() );
	}

	@Override
	public boolean getRequiredPageData() {
		return( getTableRec().getRequiredPageData() );
	}

	@Override
	public IYCFKeyHash256 getOptionalPrimaryIndexId() {
		return( getTableRec().getOptionalPrimaryIndexId() );
	}

	@Override
	public String getRequiredTableClassCode() {
		return( getTableRec().getRequiredTableClassCode() );
	}

	@Override
	public IYCFKeyHash256 getOptionalLookupIndexId() {
		return( getTableRec().getOptionalLookupIndexId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalAltIndexId() {
		return( getTableRec().getOptionalAltIndexId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalQualifyingTableId() {
		return( getTableRec().getOptionalQualifyingTableId() );
	}

	@Override
	public boolean getRequiredIsInstantiable() {
		return( getTableRec().getRequiredIsInstantiable() );
	}

	@Override
	public boolean getRequiredHasHistory() {
		return( getTableRec().getRequiredHasHistory() );
	}

	@Override
	public boolean getRequiredHasAuditColumns() {
		return( getTableRec().getRequiredHasAuditColumns() );
	}

	@Override
	public boolean getRequiredIsMutable() {
		return( getTableRec().getRequiredIsMutable() );
	}

	@Override
	public boolean getRequiredIsServerOnly() {
		return( getTableRec().getRequiredIsServerOnly() );
	}

	@Override
	public IBusModelPubSchema.LoaderBehaviourEnum getRequiredLoaderBehaviour() {
		return( getTableRec().getRequiredLoaderBehaviour() );
	}

	@Override
	public IBusModelPubSchema.SecScopeEnum getRequiredSecScope() {
		return( getTableRec().getRequiredSecScope() );
	}

	@Override
	public IBusModelPubSchema.CodeVisibilityEnum getRequiredCodeVis() {
		return( getTableRec().getRequiredCodeVis() );
	}

	public List<IBusModelRelationObj> getOnlyOwnerRelations() {
		IBusModelTableObj tableDef;
		IBusModelRelationObj relationDef = null;
		List<IBusModelRelationObj> list = new LinkedList<IBusModelRelationObj>();
		Iterator<IBusModelRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			relationDef = childrenRelations.next();
			if( relationDef.getRequiredRelationType() == IBusModelSchema.RelationTypeEnum.Owner ) {
				list.add(relationDef);
			}
		}

		IBusModelRelationObj superClass = getSuperClassRelation();
		while( superClass != null ) {
			tableDef = superClass.getRequiredLookupToTable();
			childrenRelations = tableDef.getOptionalComponentsRelation().iterator();
			while (childrenRelations.hasNext()) {
				relationDef = childrenRelations.next();
				if( relationDef.getRequiredRelationType() == IBusModelSchema.RelationTypeEnum.Owner ) {
					list.add(relationDef);
				}
			}
			superClass = tableDef.getSuperClassRelation();
		}

		childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			relationDef = childrenRelations.next();
			if( relationDef.getRequiredRelationType() == IBusModelSchema.RelationTypeEnum.Container ) {
				list.add(relationDef);
			}
		}

		superClass = getSuperClassRelation();
		while( superClass != null ) {
			tableDef = superClass.getRequiredLookupToTable();
			childrenRelations = tableDef.getOptionalComponentsRelation().iterator();
			while (childrenRelations.hasNext()) {
				relationDef = childrenRelations.next();
				if( relationDef.getRequiredRelationType() == IBusModelSchema.RelationTypeEnum.Container ) {
					list.add(relationDef);
				}
			}
			superClass = tableDef.getSuperClassRelation();
		}

		return( list );
	}

	public List<IBusModelRelationObj> getContainerOwnerRelations() {
		IBusModelTableObj tableDef;
		IBusModelRelationObj relationDef = null;
		IBusModelSchema.RelationTypeEnum relType;
		List<IBusModelRelationObj> list = new LinkedList<IBusModelRelationObj>();
		Iterator<IBusModelRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			relationDef = childrenRelations.next();
			relType = relationDef.getRequiredRelationType();
			if( ( relType == IBusModelSchema.RelationTypeEnum.Owner )
			 || ( relType == IBusModelSchema.RelationTypeEnum.Parent )
			 || ( relType == IBusModelSchema.RelationTypeEnum.Container ) )
			{
				list.add(relationDef);
			}
		}

		IBusModelRelationObj superClass = getSuperClassRelation();
		while( superClass != null ) {
			tableDef = superClass.getRequiredLookupToTable();
			childrenRelations = tableDef.getOptionalComponentsRelation().iterator();
			while (childrenRelations.hasNext()) {
				relationDef = childrenRelations.next();
				relType = relationDef.getRequiredRelationType();
				if( ( relType == IBusModelSchema.RelationTypeEnum.Owner )
				 || ( relType == IBusModelSchema.RelationTypeEnum.Parent )
				 || ( relType == IBusModelSchema.RelationTypeEnum.Container ) )
				{
					list.add(relationDef);
				}
			}
			superClass = tableDef.getSuperClassRelation();
		}

		return( list );
	}

	public IBusModelRelationObj getContainerRelation() {
		IBusModelRelationObj relationDef;
		Iterator<IBusModelRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			relationDef = childrenRelations.next();
			if( relationDef.getRequiredRelationType() == IBusModelSchema.RelationTypeEnum.Container ) {
				return( relationDef );
			}
		}
		return( null );
	}

	public IBusModelRelationObj getInheritedContainerRelation() {
		IBusModelRelationObj inheritedContainerRelation = null;
		IBusModelRelationObj relationDef;
		Iterator<IBusModelRelationObj> childrenRelations;
		IBusModelTableObj tableDef = this;
		while( ( inheritedContainerRelation == null ) && ( tableDef != null ) ) {
			childrenRelations = tableDef.getOptionalComponentsRelation().iterator();
			while (childrenRelations.hasNext()) {
				relationDef = childrenRelations.next();
				if( relationDef.getRequiredRelationType() == IBusModelSchema.RelationTypeEnum.Container ) {
					return( relationDef );
				}
			}
			relationDef = tableDef.getSuperClassRelation();
			if( relationDef == null ) {
				tableDef = null;
			}
			else {
				tableDef = relationDef.getRequiredLookupToTable();
			}
		}
		return( null );
	}

	public IBusModelRelationObj getOwnerRelation() {
		IBusModelRelationObj relationDef;
		Iterator<IBusModelRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			relationDef = childrenRelations.next();
			if( relationDef.getRequiredRelationType() == IBusModelSchema.RelationTypeEnum.Owner ) {
				return( relationDef );
			}
		}
		return( null );
	}

	public IBusModelRelationObj getInheritedOwnerRelation() {
		IBusModelTableObj tableDef = this;
		IBusModelRelationObj inheritedOwnerRelation = null;
		IBusModelRelationObj relationDef;
		Iterator<IBusModelRelationObj> childrenRelations;
		while( ( inheritedOwnerRelation == null ) && ( tableDef != null ) ) {
			childrenRelations = tableDef.getOptionalComponentsRelation().iterator();
			while (childrenRelations.hasNext()) {
				relationDef = childrenRelations.next();
				if( relationDef.getRequiredRelationType() == IBusModelSchema.RelationTypeEnum.Owner ) {
					return( relationDef );
				}
			}
			relationDef = tableDef.getSuperClassRelation();
			if( relationDef == null ) {
				tableDef = null;
			}
			else {
				tableDef = relationDef.getRequiredLookupToTable();
			}
		}
		return( null );
	}

	public List<IBusModelRelationObj> getOwnerLookupRelations() {
		IBusModelSchema.RelationTypeEnum relType;
		IBusModelRelationObj relationDef;
		List<IBusModelRelationObj> list = new LinkedList<IBusModelRelationObj>();
		Iterator<IBusModelRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext())
		{
			relationDef = childrenRelations.next();
			relType = relationDef.getRequiredRelationType();
			if( ( relType == IBusModelSchema.RelationTypeEnum.Parent )
			 || ( relType == IBusModelSchema.RelationTypeEnum.Container )
			 || ( relType == IBusModelSchema.RelationTypeEnum.Lookup )
			 || ( relType == IBusModelSchema.RelationTypeEnum.Owner ) )
			{
				list.add(relationDef);
			}
		}
		return( list );
	}

	public List<IBusModelRelationObj> getOwnerContainerNamedLookupChainRelations() {
		IBusModelSchema.RelationTypeEnum relType;
		IBusModelRelationObj relationDef;
		List<IBusModelRelationObj> list = new LinkedList<IBusModelRelationObj>();
		List<IBusModelChainObj> componentChains = getOptionalComponentsChains();
		Iterator<IBusModelRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext()) {
			relationDef = childrenRelations.next();
			relType = relationDef.getRequiredRelationType();
			if( relType == IBusModelSchema.RelationTypeEnum.Superclass ) {
				;
			}
			else if( ( relType == IBusModelSchema.RelationTypeEnum.Container )
				|| ( relType == IBusModelSchema.RelationTypeEnum.Owner ) )
			{
				list.add(relationDef);
			}
			else {
				if( ! relationDef.getRequiredIsXsdContainer() ) {
					IBusModelIndexObj toIndex = relationDef.getRequiredLookupToIndex();
					if( toIndex.getRequiredIsUnique() ) {
						boolean referencedByChain = false;
						Iterator<IBusModelChainObj> iterChain = componentChains.iterator();
						while( ( ! referencedByChain ) && iterChain.hasNext() ) {
							IBusModelChainObj chain = iterChain.next();
							if( chain.getRequiredLookupPrevRel() == relationDef ) {
								referencedByChain = true;
							}
							else if( chain.getRequiredLookupNextRel() == relationDef ) {
								referencedByChain = true;
							}
						}
						if( referencedByChain ) {
							list.add( relationDef );
						}
						else {
							IBusModelTableObj toTable = relationDef.getRequiredLookupToTable();
							IBusModelIndexObj lookupIndex = toTable.getOptionalLookupLookupIndex();
							while( ( lookupIndex == null ) && ( toTable != null ) ) {
								IBusModelRelationObj superRelation = toTable.getSuperClassRelation();
								if( superRelation != null ) {
									toTable = superRelation.getRequiredLookupToTable();
									if( toTable != null ) {
										lookupIndex = toTable.getOptionalLookupLookupIndex();
									}
								}
								else {
									toTable = null;
								}
							}
							if( lookupIndex != null ) {
								list.add( relationDef );
							}
						}
					}
				}
			}
		}
		return( list );
	}

	public List<IBusModelAtomObj> getChildrenAtoms() {
		List<IBusModelAtomObj> list = new LinkedList<IBusModelAtomObj>();
		Iterator<IBusModelValueObj> childrenColumns = getOptionalComponentsColumns().iterator();
		while (childrenColumns.hasNext())
		{
			IBusModelValueObj colDef = childrenColumns.next();
			if( colDef instanceof IBusModelAtomObj)
			{
				list.add( (IBusModelAtomObj)colDef);
			}
		}
		return( list );
	}

	public IBusModelRelationObj getSuperClassRelation() {
		Iterator<IBusModelRelationObj> childrenRelations = getOptionalComponentsRelation().iterator();
		while (childrenRelations.hasNext())
		{
			IBusModelRelationObj relationDef = childrenRelations.next();
			if( relationDef.getRequiredRelationType() == IBusModelSchema.RelationTypeEnum.Superclass ) {
				return( relationDef );
			}
		}
		return( null );
	}

	public List<IBusModelRelationObj> getSubClassRelations() {
		List<IBusModelRelationObj> list = new LinkedList<IBusModelRelationObj>();
		Iterator<IBusModelRelationObj> reverseRelations = getOptionalChildrenReverseRelations().iterator();
		while (reverseRelations.hasNext())
		{
			IBusModelRelationObj reverseRelation = reverseRelations.next();
			if( reverseRelation.getRequiredRelationType() == IBusModelSchema.RelationTypeEnum.Superclass ) {
				list.add(reverseRelation);
			}
		}
		return( list );
	}

	public IBusModelIndexObj getPrimaryKeyIndex() {
		IBusModelIndexObj primaryIndex = getOptionalLookupPrimaryIndex();
		return( primaryIndex );
	}

	public List<IBusModelRelationObj> getFactoryOwnerRelations() {
		List<IBusModelRelationObj> list = new LinkedList<IBusModelRelationObj>();
		Iterator<IBusModelRelationObj> ownerRelations = getContainerOwnerRelations().iterator();
		while (ownerRelations.hasNext())
		{
			// throw new NotImplementedException();
			IBusModelRelationObj ownerRelation = ownerRelations.next();
			if( ownerRelation.getRequiredRelationType() == IBusModelSchema.RelationTypeEnum.Superclass ) {
				list.add(ownerRelation);
			}
		}
		return( list );
	}

	public List<IBusModelIndexObj> getInheritedIndexes() {
		List<IBusModelIndexObj> list = new LinkedList<IBusModelIndexObj>();
		IBusModelRelationObj superClassRelation = getSuperClassRelation();
		if( superClassRelation != null)
		{
			Iterator<IBusModelIndexObj> superClassInheritedIndexes
				= superClassRelation.getRequiredLookupToTable().getInheritedIndexes().iterator();
			while (superClassInheritedIndexes.hasNext())
			{
				list.add(superClassInheritedIndexes.next());
			}
			Iterator<IBusModelIndexObj> myIndexes = getChildrenIndexes().iterator();
			while( myIndexes.hasNext() )
			{
				list.add( myIndexes.next() );
			}
		}
		return( list );
	}

	public List<IBusModelIndexObj> getChildrenIndexes() {
		Iterator<IBusModelIndexObj> iter = getOptionalComponentsIndex().iterator();
		List<IBusModelIndexObj> list = new LinkedList<IBusModelIndexObj>();
		while( iter.hasNext() ) {
			list.add( iter.next() );
		}
		return( list );
	}

	public List<IBusModelRelationObj> getInheritedRelations() {
		List<IBusModelRelationObj> list = new LinkedList<IBusModelRelationObj>();
		IBusModelRelationObj superClassRelation = getSuperClassRelation();
		if( superClassRelation != null)
		{
			Iterator<IBusModelRelationObj> superClassInheritedRelations
				= superClassRelation.getRequiredLookupToTable().getInheritedRelations().iterator();
			while (superClassInheritedRelations.hasNext())
			{
				list.add(superClassInheritedRelations.next());
			}
			Iterator<IBusModelRelationObj> myRelations = getChildrenRelations().iterator();
			while (myRelations.hasNext())
			{
				list.add(myRelations.next());
			}
		}
		return( list );
	}

	public List<IBusModelRelationObj> getChildrenRelations() {
		List<IBusModelRelationObj> childrenRelations = new LinkedList<IBusModelRelationObj>();
		Collection<IBusModelRelationObj> cltn = getOptionalComponentsRelation();
		Iterator<IBusModelRelationObj> iter = cltn.iterator();
		while( iter.hasNext() ) {
			childrenRelations.add( iter.next() );
		}
		return( childrenRelations );
	}
}
