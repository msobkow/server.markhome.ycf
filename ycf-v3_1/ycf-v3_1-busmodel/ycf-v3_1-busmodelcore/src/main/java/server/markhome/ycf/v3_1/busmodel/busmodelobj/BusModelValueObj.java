// Description: Java 25 base object instance implementation for Value

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

public class BusModelValueObj
	implements IBusModelValueObj
{
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected boolean isNew;
	protected IBusModelValueEditObj edit;
	protected IBusModelSchemaObj schema;
	protected $implCommaIJavaOptAtomType$ pKey;
	protected IBusModelValue rec;
	protected IBusModelScopeObj requiredContainerScope;
	protected IBusModelSchemaDefObj optionalLookupDefSchema;
	protected List<IBusModelTableColObj> optionalChildrenRefTableCol;
	protected List<IBusModelIndexColObj> optionalChildrenRefIndexCol;
	protected IBusModelValueObj optionalLookupPrev;
	protected IBusModelValueObj optionalLookupNext;

	public BusModelValueObj() {
		isNew = true;
		requiredContainerScope = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	public BusModelValueObj( IBusModelSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerScope = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)schema).getValueTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "Value" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelScopeObj scope = getRequiredContainerScope();
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
	public IBusModelValueObj realise() {
		IBusModelValueObj retobj = ((IBusModelSchemaObj)getSchema()).getValueTableObj().realiseValue(
			(IBusModelValueObj)this );
		return( (IBusModelValueObj)retobj );
	}

	@Override
	public void forget() {
		((IBusModelSchemaObj)getSchema()).getValueTableObj().reallyDeepDisposeValue( (IBusModelValueObj)this );
	}

	@Override
	public IBusModelValueObj read() {
		IBusModelValueObj retobj = ((IBusModelSchemaObj)getSchema()).getValueTableObj().readValueByIdIdx( getPKey(), false );
		return( (IBusModelValueObj)retobj );
	}

	@Override
	public IBusModelValueObj read( boolean forceRead ) {
		IBusModelValueObj retobj = ((IBusModelSchemaObj)getSchema()).getValueTableObj().readValueByIdIdx( getPKey(), forceRead );
		return( (IBusModelValueObj)retobj );
	}

	@Override
	public IBusModelValueObj moveUp() {
		IBusModelValueObj retobj = ((IBusModelSchemaObj)getSchema()).getValueTableObj().moveUpValue( this );
		return( (IBusModelValueObj)retobj );
	}

	@Override
	public IBusModelValueObj moveDown() {
		IBusModelValueObj retobj = ((IBusModelSchemaObj)getSchema()).getValueTableObj().moveDownValue( this );
		return( (IBusModelValueObj)retobj );
	}

	@Override
	public IBusModelValueTableObj getValueTable() {
		return( ((IBusModelSchemaObj)getSchema()).getValueTableObj() );
	}

	@Override
	public IBusModelSchemaObj getSchema() {
		return( schema );
	}

	@Override
	public void setSchema( IBusModelSchemaObj value ) {
		schema = value;
	}

	@Override
	public IBusModelValue getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryValue().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getBusModelBackingStore().getTableValue().readDerivedByIdIdx( ((IBusModelSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelValue value ) {
		if( ! ( ( value == null ) || ! ( value instanceof IBusModelValue ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"BusModelValueRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredContainerScope = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	@Override
	public IBusModelValue getValueRec() {
		return( (IBusModelValue)getRec() );
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
	public IBusModelValueEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		IBusModelValueObj lockobj;
		if( getIsNew() ) {
			lockobj = (IBusModelValueObj)this;
		}
		else {
			lockobj = ((IBusModelSchemaObj)getSchema()).getValueTableObj().lockValue( getPKey() );
		}
		edit = ((IBusModelSchemaObj)getSchema()).getValueTableObj().newEditInstance( lockobj );
		return( (IBusModelValueEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public IBusModelValueEditObj getEdit() {
		return( edit );
	}

	@Override
	public IBusModelValueEditObj getEditAsValue() {
		return( (IBusModelValueEditObj)edit );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			IBusModelValue rec = getRec();
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
			IBusModelValue rec = getRec();
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
	public IBusModelScopeObj getRequiredContainerScope() {
		return( getRequiredContainerScope( false ) );
	}

	@Override
	public IBusModelScopeObj getRequiredContainerScope( boolean forceRead ) {
		if( ( requiredContainerScope == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerScope = ((IBusModelSchemaObj)getSchema()).getScopeTableObj().readScopeByIdIdx( getValueRec().getRequiredScopeId(), forceRead );
			}
		}
		return( requiredContainerScope );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( ( optionalLookupDefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getValueRec().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefSchema = ((IBusModelSchemaObj)getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getValueRec().getOptionalDefSchemaId(), forceRead );
			}
		}
		return( optionalLookupDefSchema );
	}

	@Override
	public List<IBusModelTableColObj> getOptionalChildrenRefTableCol() {
		List<IBusModelTableColObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getTableColTableObj().readTableColByDataIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelTableColObj> getOptionalChildrenRefTableCol( boolean forceRead ) {
		List<IBusModelTableColObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getTableColTableObj().readTableColByDataIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<IBusModelIndexColObj> getOptionalChildrenRefIndexCol() {
		List<IBusModelIndexColObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getIndexColTableObj().readIndexColByColIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelIndexColObj> getOptionalChildrenRefIndexCol( boolean forceRead ) {
		List<IBusModelIndexColObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getIndexColTableObj().readIndexColByColIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public IBusModelValueObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	@Override
	public IBusModelValueObj getOptionalLookupPrev( boolean forceRead ) {
		if( ( optionalLookupPrev == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getValueRec().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrev = ((IBusModelSchemaObj)getSchema()).getValueTableObj().readValueByIdIdx( getValueRec().getOptionalPrevId(), forceRead );
			}
		}
		return( optionalLookupPrev );
	}

	@Override
	public IBusModelValueObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	@Override
	public IBusModelValueObj getOptionalLookupNext( boolean forceRead ) {
		if( ( optionalLookupNext == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getValueRec().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupNext = ((IBusModelSchemaObj)getSchema()).getValueTableObj().readValueByIdIdx( getValueRec().getOptionalNextId(), forceRead );
			}
		}
		return( optionalLookupNext );
	}

	@Override
	public IYCFKeyHash256 getRequiredScopeId() {
		return( getValueRec().getRequiredScopeId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalDefSchemaId() {
		return( getValueRec().getOptionalDefSchemaId() );
	}

	@Override
	public String getRequiredName() {
		return( getValueRec().getRequiredName() );
	}

	@Override
	public String getOptionalShortName() {
		return( getValueRec().getOptionalShortName() );
	}

	@Override
	public String getOptionalLabel() {
		return( getValueRec().getOptionalLabel() );
	}

	@Override
	public String getOptionalShortDescription() {
		return( getValueRec().getOptionalShortDescription() );
	}

	@Override
	public String getOptionalDescription() {
		return( getValueRec().getOptionalDescription() );
	}

	@Override
	public String getOptionalDefaultXmlValue() {
		return( getValueRec().getOptionalDefaultXmlValue() );
	}

	@Override
	public boolean getRequiredIsNullable() {
		return( getValueRec().getRequiredIsNullable() );
	}

	@Override
	public Boolean getOptionalGenerateId() {
		return( getValueRec().getOptionalGenerateId() );
	}

	@Override
	public boolean getRequiredImplementsPolymorph() {
		return( getValueRec().getRequiredImplementsPolymorph() );
	}

	@Override
	public IYCFKeyHash256 getOptionalPrevId() {
		return( getValueRec().getOptionalPrevId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalNextId() {
		return( getValueRec().getOptionalNextId() );
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

	public List<IBusModelIndexObj> getAffectedIndexes() {
		List<IBusModelIndexObj> list = new LinkedList<IBusModelIndexObj>();
		IBusModelScopeObj container = getRequiredContainerScope();
		IBusModelTableObj tableDef = null;
		if( container == null ) {
			throw new RuntimeException("ValueDefObj.getAffectedIndexes() RequiredContainerScope has no value");
		}
		else if( container instanceof IBusModelTableObj ) {
			tableDef = (IBusModelTableObj)container;
		}
		else {
			throw new RuntimeException( "ValueDefObj.getAffectedIndexes() RequiredContainerScope is not an IBusModelTableObj");
		}
		Iterator<IBusModelIndexObj> cursorIndexDef = tableDef.getOptionalComponentsIndex().iterator();
		while (cursorIndexDef.hasNext())
		{
			IBusModelIndexObj indexDef = cursorIndexDef.next();

			Iterator<IBusModelIndexColObj> cursorIndexColDef = indexDef.getOptionalComponentsColumns().iterator();
			while (cursorIndexColDef.hasNext())
			{
				IBusModelIndexColObj indexColDef = cursorIndexColDef.next();
				if( indexColDef.getRequiredLookupColumn().equals(this))
				{
					list.add(indexDef);
				}
			}
		}
		return( list );
	}

	public List<IBusModelRelationObj> getAffectedRelations() {
		List<IBusModelRelationObj> list = new LinkedList<IBusModelRelationObj>();
		IBusModelScopeObj container = getRequiredContainerScope();
		IBusModelTableObj tableDef = null;
		if( container == null ) {
			throw new RuntimeException("ValueDefObj.getAffectedRelations() RequiredContainerScope has no value");
		}
		else if( container instanceof IBusModelTableObj ) {
			tableDef = (IBusModelTableObj)container;
		}
		else {
			throw new RuntimeException( "ValueDefObj.getAffectedRelations() RequiredContainerScope is not an IBusModelTableObj");
		}
		Iterator<IBusModelRelationObj> cursorRelationDef = tableDef.getOptionalComponentsRelation().iterator();
		while (cursorRelationDef.hasNext())
		{
			IBusModelRelationObj relationDef = cursorRelationDef.next();
			Iterator<IBusModelRelationColObj> cursorRelationColDef = relationDef.getOptionalComponentsColumns().iterator();
			while (cursorRelationColDef.hasNext())
			{
				IBusModelRelationColObj relationColDef = cursorRelationColDef.next();
				if( relationColDef.getRequiredLookupFromCol().equals(this))
				{
					list.add(relationDef);
				}
			}
		}
		return( list );
	}

	public List<IBusModelIndexObj> getAffectedUniqueIndexes() {
		List<IBusModelIndexObj> affectedIndexes = getAffectedIndexes();
		List<IBusModelIndexObj> list = new LinkedList<IBusModelIndexObj>();
		IBusModelScopeObj container = getRequiredContainerScope();
		IBusModelTableObj tableDef = null;
		if( container == null ) {
			throw new RuntimeException("ValueDefObj.getAffectedUniqueIndexes() RequiredContainerScope has no value");
		}
		else if( container instanceof IBusModelTableObj ) {
			tableDef = (IBusModelTableObj)container;
		}
		else {
			throw new RuntimeException( "ValueDefObj.getAffectedUniqueIndexes() RequiredContainerScope is not an IBusModelTableObj");
		}
		Iterator<IBusModelIndexObj> cursorIndexDef = affectedIndexes.iterator();
		while (cursorIndexDef.hasNext())
		{
			IBusModelIndexObj indexDef = cursorIndexDef.next();
			if( indexDef.getRequiredIsUnique())
			{
				list.add(indexDef);
			}
		}
		return( list );
	}

	public List<IBusModelRelationObj> getColumnInMemberRelations() {
		final String S_ProcName = "ValueDefObj.getColumnInMemberRelations() ";

		IBusModelScopeObj scopeDef = (IBusModelScopeObj)getObjScope();
		if( scopeDef == null)
		{
			throw new RuntimeException(S_ProcName + "OptionalParentScope is required");
		}
		else if( scopeDef instanceof IBusModelTableObj)
		{
			List<IBusModelRelationObj> list = new LinkedList<IBusModelRelationObj>();
			Iterator<IBusModelRelationObj> relations = ((IBusModelTableObj)scopeDef).getOptionalComponentsRelation().iterator();
			IBusModelRelationColObj relationCol;
			Iterator<IBusModelRelationColObj> relationColumns;
			IBusModelRelationObj relation;
			IBusModelSchema.RelationTypeEnum relType;
			while (relations.hasNext())
			{
				relation = relations.next();
				relType = relation.getRequiredRelationType();
				if( ( relType == IBusModelSchema.RelationTypeEnum.Lookup )
				 || ( relType == IBusModelSchema.RelationTypeEnum.Container )
				 || ( relType == IBusModelSchema.RelationTypeEnum.Components )
				 || ( relType == IBusModelSchema.RelationTypeEnum.Parent )
				 || ( relType == IBusModelSchema.RelationTypeEnum.Children )
				 || ( relType == IBusModelSchema.RelationTypeEnum.Owner ) )
				{
					relationColumns = relation.getOptionalComponentsColumns().iterator();
					while (relationColumns.hasNext())
					{
						relationCol = relationColumns.next();
						if( this == relationCol.getRequiredLookupFromCol().getRequiredLookupColumn() )
						{
							list.add(relation);
							break;
						}
					}
				}
			}
			return( list );
		}
		else
		{
			throw new RuntimeException(S_ProcName + "Expected scope definition to be an IBusModelTableObj");
		}
	}

	public List<IBusModelRelationObj> getColumnInComponentsRelations() {
		final String S_ProcName = "ValueDefObj.getColumnInComponentsRelations() ";

		IBusModelScopeObj container = getRequiredContainerScope();
		IBusModelTableObj tableDef = null;
		if( container == null ) {
			throw new RuntimeException("ValueDefObj.getColumnInComponentsRelations() RequiredContainerScope has no value");
		}
		else if( container instanceof IBusModelTableObj ) {
			tableDef = (IBusModelTableObj)container;
		}
		else {
			throw new RuntimeException( "ValueDefObj.getColumnInComponentsRelations() RequiredContainerScope is not an IBusModelTableObj");
		}

		IBusModelRelationColObj relationCol;
		IBusModelRelationObj relation;
		Iterator<IBusModelRelationColObj> relationColumns;
		List<IBusModelRelationObj> list = new LinkedList<IBusModelRelationObj>();
		Iterator<IBusModelRelationObj> relations = tableDef.getOptionalComponentsRelation().iterator();

		while( relations.hasNext() ) {
			relation = relations.next();
			if( relation.getRequiredRelationType() == IBusModelSchema.RelationTypeEnum.Components ) {
				relationColumns = relation.getOptionalComponentsColumns().iterator();
				while (relationColumns.hasNext()) {
					relationCol = relationColumns.next();
					if( this == relationCol.getRequiredLookupFromCol().getRequiredLookupColumn() ) {
						list.add(relation);
						break;
					}
				}
			}
		}

		return( list );
	}

	public boolean getGenerateId() {
		boolean ret;
		if( getOptionalGenerateId() != null )		 {
			ret = getOptionalGenerateId().booleanValue();
		}
		else {
			ret = false;
		}
		return( ret );
	}
}
