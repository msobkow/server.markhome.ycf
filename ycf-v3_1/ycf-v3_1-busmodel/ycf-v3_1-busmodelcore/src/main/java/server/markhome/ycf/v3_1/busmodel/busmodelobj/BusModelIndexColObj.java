// Description: Java 25 base object instance implementation for IndexCol

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

public class BusModelIndexColObj
	implements IBusModelIndexColObj
{
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected boolean isNew;
	protected IBusModelIndexColEditObj edit;
	protected IBusModelSchemaObj schema;
	protected $implCommaIJavaOptAtomType$ pKey;
	protected IBusModelIndexCol rec;
	protected IBusModelIndexObj requiredContainerIndex;
	protected IBusModelSchemaDefObj optionalLookupDefSchema;
	protected List<IBusModelRelationColObj> optionalChildrenRefRelFromCol;
	protected List<IBusModelRelationColObj> optionalChildrenRefRelToCol;
	protected IBusModelIndexColObj optionalLookupPrev;
	protected IBusModelIndexColObj optionalLookupNext;
	protected IBusModelValueObj requiredLookupColumn;

	public BusModelIndexColObj() {
		isNew = true;
		requiredContainerIndex = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupColumn = null;
	}

	public BusModelIndexColObj( IBusModelSchemaObj argSchema ) {
		schema = argSchema;
		isNew = true;
		edit = null;
		requiredContainerIndex = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupColumn = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)schema).getIndexColTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "IndexCol" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelIndexObj scope = getRequiredContainerIndex();
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
	public IBusModelIndexColObj realise() {
		IBusModelIndexColObj retobj = ((IBusModelSchemaObj)getSchema()).getIndexColTableObj().realiseIndexCol(
			(IBusModelIndexColObj)this );
		return( (IBusModelIndexColObj)retobj );
	}

	@Override
	public void forget() {
		((IBusModelSchemaObj)getSchema()).getIndexColTableObj().reallyDeepDisposeIndexCol( (IBusModelIndexColObj)this );
	}

	@Override
	public IBusModelIndexColObj read() {
		IBusModelIndexColObj retobj = ((IBusModelSchemaObj)getSchema()).getIndexColTableObj().readIndexColByIdIdx( getPKey(), false );
		return( (IBusModelIndexColObj)retobj );
	}

	@Override
	public IBusModelIndexColObj read( boolean forceRead ) {
		IBusModelIndexColObj retobj = ((IBusModelSchemaObj)getSchema()).getIndexColTableObj().readIndexColByIdIdx( getPKey(), forceRead );
		return( (IBusModelIndexColObj)retobj );
	}

	@Override
	public IBusModelIndexColObj moveUp() {
		IBusModelIndexColObj retobj = ((IBusModelSchemaObj)getSchema()).getIndexColTableObj().moveUpIndexCol( this );
		return( (IBusModelIndexColObj)retobj );
	}

	@Override
	public IBusModelIndexColObj moveDown() {
		IBusModelIndexColObj retobj = ((IBusModelSchemaObj)getSchema()).getIndexColTableObj().moveDownIndexCol( this );
		return( (IBusModelIndexColObj)retobj );
	}

	@Override
	public IBusModelIndexColTableObj getIndexColTable() {
		return( ((IBusModelSchemaObj)getSchema()).getIndexColTableObj() );
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
	public IBusModelIndexCol getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getBusModelBackingStore().getTableIndexCol().readDerivedByIdIdx( ((IBusModelSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelIndexCol value ) {
		if( ! ( ( value == null ) || ! ( value instanceof IBusModelIndexCol ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"BusModelIndexColRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredContainerIndex = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupColumn = null;
	}

	@Override
	public IBusModelIndexCol getIndexColRec() {
		return( (IBusModelIndexCol)getRec() );
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
	public IBusModelIndexColEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		IBusModelIndexColObj lockobj;
		if( getIsNew() ) {
			lockobj = (IBusModelIndexColObj)this;
		}
		else {
			lockobj = ((IBusModelSchemaObj)getSchema()).getIndexColTableObj().lockIndexCol( getPKey() );
		}
		edit = ((IBusModelSchemaObj)getSchema()).getIndexColTableObj().newEditInstance( lockobj );
		return( (IBusModelIndexColEditObj)edit );
	}

	@Override
	public void endEdit() {
		edit = null;
	}

	@Override
	public IBusModelIndexColEditObj getEdit() {
		return( edit );
	}

	@Override
	public IBusModelIndexColEditObj getEditAsIndexCol() {
		return( (IBusModelIndexColEditObj)edit );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			IBusModelIndexCol rec = getRec();
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
			IBusModelIndexCol rec = getRec();
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
	public IBusModelIndexObj getRequiredContainerIndex() {
		return( getRequiredContainerIndex( false ) );
	}

	@Override
	public IBusModelIndexObj getRequiredContainerIndex( boolean forceRead ) {
		if( ( requiredContainerIndex == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerIndex = ((IBusModelSchemaObj)getSchema()).getIndexTableObj().readIndexByIdIdx( getIndexColRec().getRequiredIndexId(), forceRead );
			}
		}
		return( requiredContainerIndex );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( ( optionalLookupDefSchema == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getIndexColRec().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupDefSchema = ((IBusModelSchemaObj)getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getIndexColRec().getOptionalDefSchemaId(), forceRead );
			}
		}
		return( optionalLookupDefSchema );
	}

	@Override
	public List<IBusModelRelationColObj> getOptionalChildrenRefRelFromCol() {
		List<IBusModelRelationColObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getRelationColTableObj().readRelationColByFromColIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelRelationColObj> getOptionalChildrenRefRelFromCol( boolean forceRead ) {
		List<IBusModelRelationColObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getRelationColTableObj().readRelationColByFromColIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<IBusModelRelationColObj> getOptionalChildrenRefRelToCol() {
		List<IBusModelRelationColObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getRelationColTableObj().readRelationColByToColIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelRelationColObj> getOptionalChildrenRefRelToCol( boolean forceRead ) {
		List<IBusModelRelationColObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getRelationColTableObj().readRelationColByToColIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public IBusModelIndexColObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	@Override
	public IBusModelIndexColObj getOptionalLookupPrev( boolean forceRead ) {
		if( ( optionalLookupPrev == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getIndexColRec().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupPrev = ((IBusModelSchemaObj)getSchema()).getIndexColTableObj().readIndexColByIdIdx( getIndexColRec().getOptionalPrevId(), forceRead );
			}
		}
		return( optionalLookupPrev );
	}

	@Override
	public IBusModelIndexColObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	@Override
	public IBusModelIndexColObj getOptionalLookupNext( boolean forceRead ) {
		if( ( optionalLookupNext == null ) || forceRead ) {
			boolean anyMissing = false;
			if( getIndexColRec().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				optionalLookupNext = ((IBusModelSchemaObj)getSchema()).getIndexColTableObj().readIndexColByIdIdx( getIndexColRec().getOptionalNextId(), forceRead );
			}
		}
		return( optionalLookupNext );
	}

	@Override
	public IBusModelValueObj getRequiredLookupColumn() {
		return( getRequiredLookupColumn( false ) );
	}

	@Override
	public IBusModelValueObj getRequiredLookupColumn( boolean forceRead ) {
		if( ( requiredLookupColumn == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredLookupColumn = ((IBusModelSchemaObj)getSchema()).getValueTableObj().readValueByIdIdx( getIndexColRec().getRequiredColumnId(), forceRead );
			}
		}
		return( requiredLookupColumn );
	}

	@Override
	public IYCFKeyHash256 getRequiredIndexId() {
		return( getIndexColRec().getRequiredIndexId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalDefSchemaId() {
		return( getIndexColRec().getOptionalDefSchemaId() );
	}

	@Override
	public String getRequiredName() {
		return( getIndexColRec().getRequiredName() );
	}

	@Override
	public String getOptionalShortName() {
		return( getIndexColRec().getOptionalShortName() );
	}

	@Override
	public String getOptionalLabel() {
		return( getIndexColRec().getOptionalLabel() );
	}

	@Override
	public String getOptionalShortDescription() {
		return( getIndexColRec().getOptionalShortDescription() );
	}

	@Override
	public String getOptionalDescription() {
		return( getIndexColRec().getOptionalDescription() );
	}

	@Override
	public IYCFKeyHash256 getRequiredColumnId() {
		return( getIndexColRec().getRequiredColumnId() );
	}

	@Override
	public boolean getRequiredIsAscending() {
		return( getIndexColRec().getRequiredIsAscending() );
	}

	@Override
	public IYCFKeyHash256 getOptionalPrevId() {
		return( getIndexColRec().getOptionalPrevId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalNextId() {
		return( getIndexColRec().getOptionalNextId() );
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
