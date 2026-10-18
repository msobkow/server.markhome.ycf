// Description: Java 25 base object instance implementation for RelationCol

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

public class BusModelRelationColObj
	implements IBusModelRelationColObj
{
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected boolean isNew;
	protected IBusModelRelationColEditObj edit;
	protected IBusModelSchemaObj schema;
	protected $implCommaIJavaOptAtomType$ pKey;
	protected IBusModelRelationCol rec;
	protected IBusModelRelationObj requiredContainerRelation;
	protected IBusModelSchemaDefObj optionalLookupDefSchema;
	protected IBusModelRelationColObj optionalLookupPrev;
	protected IBusModelRelationColObj optionalLookupNext;
	protected IBusModelIndexColObj requiredLookupFromCol;
	protected IBusModelIndexColObj requiredLookupToCol;

	public BusModelRelationColObj() {
		isNew = true;
		requiredContainerRelation = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupFromCol = null;
		requiredLookupToCol = null;
	}

	public BusModelRelationColObj( IBusModelSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerRelation = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupFromCol = null;
		requiredLookupToCol = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)schema).getRelationColTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "RelationCol" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelRelationObj scope = getRequiredContainerRelation();
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
	public IBusModelRelationColObj realise() {
		IBusModelRelationColObj retobj = ((IBusModelSchemaObj)getSchema()).getRelationColTableObj().realiseRelationCol(
			(IBusModelRelationColObj)this );
		return( (IBusModelRelationColObj)retobj );
	}

	@Override
	public void forget() {
		((IBusModelSchemaObj)getSchema()).getRelationColTableObj().reallyDeepDisposeRelationCol( (IBusModelRelationColObj)this );
	}

	@Override
	public IBusModelRelationColObj read() {
		IBusModelRelationColObj retobj = ((IBusModelSchemaObj)getSchema()).getRelationColTableObj().readRelationColByIdIdx( getPKey(), false );
		return( (IBusModelRelationColObj)retobj );
	}

	@Override
	public IBusModelRelationColObj read( boolean forceRead ) {
		IBusModelRelationColObj retobj = ((IBusModelSchemaObj)getSchema()).getRelationColTableObj().readRelationColByIdIdx( getPKey(), forceRead );
		return( (IBusModelRelationColObj)retobj );
	}

	@Override
	public IBusModelRelationColObj moveUp() {
		IBusModelRelationColObj retobj = ((IBusModelSchemaObj)getSchema()).getRelationColTableObj().moveUpRelationCol( this );
		return( (IBusModelRelationColObj)retobj );
	}

	@Override
	public IBusModelRelationColObj moveDown() {
		IBusModelRelationColObj retobj = ((IBusModelSchemaObj)getSchema()).getRelationColTableObj().moveDownRelationCol( this );
		return( (IBusModelRelationColObj)retobj );
	}

	@Override
	public IBusModelRelationColTableObj getRelationColTable() {
		return( ((IBusModelSchemaObj)getSchema()).getRelationColTableObj() );
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
	public IBusModelRelationCol getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryRelationCol().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getBusModelBackingStore().getTableRelationCol().readDerivedByIdIdx( ((IBusModelSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelRelationCol value ) {
		if( ! ( ( value == null ) || ! ( value instanceof IBusModelRelationCol ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"BusModelRelationColRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredContainerRelation = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupFromCol = null;
		requiredLookupToCol = null;
	}

	@Override
	public IBusModelRelationCol getRelationColRec() {
		return( (IBusModelRelationCol)getRec() );
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
	public IBusModelRelationColEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		IBusModelRelationColObj lockobj;
		if( getIsNew() ) {
			lockobj = (IBusModelRelationColObj)this;
		}
		else {
			lockobj = ((IBusModelSchemaObj)getSchema()).getRelationColTableObj().lockRelationCol( getPKey() );
		}
		edit = ((IBusModelSchemaObj)getSchema()).getRelationColTableObj().newEditInstance( lockobj );
		return( (IBusModelRelationColEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public IBusModelRelationColEditObj getEdit() {
		return( edit );
	}

	@Override
	public IBusModelRelationColEditObj getEditAsRelationCol() {
		return( (IBusModelRelationColEditObj)edit );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			IBusModelRelationCol rec = getRec();
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
			IBusModelRelationCol rec = getRec();
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
	public IBusModelRelationObj getRequiredContainerRelation() {
		return( getRequiredContainerRelation( false ) );
	}

	@Override
	public IBusModelRelationObj getRequiredContainerRelation( boolean forceRead ) {
		if( ( requiredContainerRelation == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerRelation = ((IBusModelSchemaObj)getSchema()).getRelationTableObj().readRelationByIdIdx( getRelationColRec().getRequiredRelationId(), forceRead );
			}
		}
		return( requiredContainerRelation );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( ( optionalLookupDefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getRelationColRec().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefSchema = ((IBusModelSchemaObj)getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getRelationColRec().getOptionalDefSchemaId(), forceRead );
			}
		}
		return( optionalLookupDefSchema );
	}

	@Override
	public IBusModelRelationColObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	@Override
	public IBusModelRelationColObj getOptionalLookupPrev( boolean forceRead ) {
		if( ( optionalLookupPrev == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getRelationColRec().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrev = ((IBusModelSchemaObj)getSchema()).getRelationColTableObj().readRelationColByIdIdx( getRelationColRec().getOptionalPrevId(), forceRead );
			}
		}
		return( optionalLookupPrev );
	}

	@Override
	public IBusModelRelationColObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	@Override
	public IBusModelRelationColObj getOptionalLookupNext( boolean forceRead ) {
		if( ( optionalLookupNext == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getRelationColRec().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupNext = ((IBusModelSchemaObj)getSchema()).getRelationColTableObj().readRelationColByIdIdx( getRelationColRec().getOptionalNextId(), forceRead );
			}
		}
		return( optionalLookupNext );
	}

	@Override
	public IBusModelIndexColObj getRequiredLookupFromCol() {
		return( getRequiredLookupFromCol( false ) );
	}

	@Override
	public IBusModelIndexColObj getRequiredLookupFromCol( boolean forceRead ) {
		if( ( requiredLookupFromCol == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupFromCol = ((IBusModelSchemaObj)getSchema()).getIndexColTableObj().readIndexColByIdIdx( getRelationColRec().getRequiredFromColId(), forceRead );
			}
		}
		return( requiredLookupFromCol );
	}

	@Override
	public IBusModelIndexColObj getRequiredLookupToCol() {
		return( getRequiredLookupToCol( false ) );
	}

	@Override
	public IBusModelIndexColObj getRequiredLookupToCol( boolean forceRead ) {
		if( ( requiredLookupToCol == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupToCol = ((IBusModelSchemaObj)getSchema()).getIndexColTableObj().readIndexColByIdIdx( getRelationColRec().getRequiredToColId(), forceRead );
			}
		}
		return( requiredLookupToCol );
	}

	@Override
	public IYCFKeyHash256 getRequiredRelationId() {
		return( getRelationColRec().getRequiredRelationId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalDefSchemaId() {
		return( getRelationColRec().getOptionalDefSchemaId() );
	}

	@Override
	public String getRequiredName() {
		return( getRelationColRec().getRequiredName() );
	}

	@Override
	public String getOptionalShortName() {
		return( getRelationColRec().getOptionalShortName() );
	}

	@Override
	public String getOptionalLabel() {
		return( getRelationColRec().getOptionalLabel() );
	}

	@Override
	public String getOptionalShortDescription() {
		return( getRelationColRec().getOptionalShortDescription() );
	}

	@Override
	public String getOptionalDescription() {
		return( getRelationColRec().getOptionalDescription() );
	}

	@Override
	public IYCFKeyHash256 getRequiredFromColId() {
		return( getRelationColRec().getRequiredFromColId() );
	}

	@Override
	public IYCFKeyHash256 getRequiredToColId() {
		return( getRelationColRec().getRequiredToColId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalPrevId() {
		return( getRelationColRec().getOptionalPrevId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalNextId() {
		return( getRelationColRec().getOptionalNextId() );
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
				invertedNodeNames.add( getVersionStringForVersion( (IBusModelMinorVersionObj)( curDef ) ) );
			}
			else if( curDef instanceof IBusModelMajorVersionObj ) {
				invertedNodeNames.add( getVersionStringForVersion( (IBusModelMajorVersionObj)( curDef ) ) );
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
				invertedNodeNames.add( getVersionStringForVersion( (IBusModelMinorVersionObj)( curDef ) ) );
			}
			else if( curDef instanceof IBusModelMajorVersionObj ) {
				invertedNodeNames.add( getVersionStringForVersion( (IBusModelMajorVersionObj)( curDef ) ) );
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
