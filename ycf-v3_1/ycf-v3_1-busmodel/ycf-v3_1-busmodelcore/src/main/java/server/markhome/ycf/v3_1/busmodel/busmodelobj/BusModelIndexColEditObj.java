// Description: Java 25 edit object instance implementation for BusModel IndexCol.

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

public class BusModelIndexColEditObj
	implements IBusModelIndexColEditObj
{
	protected IBusModelIndexColObj orig;
	protected IBusModelIndexCol rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected IBusModelIndexObj requiredContainerIndex;
	protected IBusModelSchemaDefObj optionalLookupDefSchema;
	protected List<IBusModelRelationColObj> optionalChildrenRefRelFromCol;
	protected List<IBusModelRelationColObj> optionalChildrenRefRelToCol;
	protected IBusModelIndexColObj optionalLookupPrev;
	protected IBusModelIndexColObj optionalLookupNext;
	protected IBusModelValueObj requiredLookupColumn;

	public BusModelIndexColEditObj( IBusModelIndexColObj argOrig ) {
		orig = argOrig;
		getRec();
		IBusModelIndexCol origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerIndex = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredLookupColumn = null;
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
		return( ((IBusModelSchemaObj)orig.getSchema()).getIndexColTableObj().getClassCode() );
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
		// We realise this so that it's record will get copied to orig during realization
		IBusModelIndexColObj retobj = getSchema().getIndexColTableObj().realiseIndexCol( (IBusModelIndexColObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsIndexCol().forget();
	}

	@Override
	public IBusModelIndexColObj read() {
		IBusModelIndexColObj retval = getOrigAsIndexCol().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IBusModelIndexColObj read( boolean forceRead ) {
		IBusModelIndexColObj retval = getOrigAsIndexCol().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IBusModelIndexColObj moveUp() {
		throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUp" );
	}

	@Override
	public IBusModelIndexColObj moveDown() {
		throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDown" );
	}

	@Override
	public IBusModelIndexColObj create() {
		copyRecToOrig();
		IBusModelIndexColObj retobj = ((IBusModelSchemaObj)getOrigAsIndexCol().getSchema()).getIndexColTableObj().createIndexCol( getOrigAsIndexCol() );
		if( retobj == getOrigAsIndexCol() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelIndexColEditObj update() {
		getSchema().getIndexColTableObj().updateIndexCol( (IBusModelIndexColObj)this );
		return( null );
	}

	@Override
	public BusModelIndexColEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getIndexColTableObj().deleteIndexCol( getOrigAsIndexCol() );
		return( null );
	}

	@Override
	public IBusModelIndexColTableObj getIndexColTable() {
		return( orig.getSchema().getIndexColTableObj() );
	}

	@Override
	public IBusModelIndexColEditObj getEdit() {
		return( (IBusModelIndexColEditObj)this );
	}

	@Override
	public IBusModelIndexColEditObj getEditAsIndexCol() {
		return( (IBusModelIndexColEditObj)this );
	}

	@Override
	public IBusModelIndexColEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public IBusModelIndexColObj getOrig() {
		return( orig );
	}

	@Override
	public IBusModelIndexColObj getOrigAsIndexCol() {
		return( (IBusModelIndexColObj)orig );
	}

	@Override
	public IBusModelSchemaObj getSchema() {
		return( orig.getSchema() );
	}

	@Override
	public void setSchema( IBusModelSchemaObj value ) {
		orig.setSchema(value);
	}

	@Override
	public IBusModelIndexCol getRec() {
		if( rec == null ) {
			rec = getOrigAsIndexCol().getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryIndexCol().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelIndexCol value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerIndex = null;
			optionalLookupDefSchema = null;
			optionalLookupPrev = null;
			optionalLookupNext = null;
			requiredLookupColumn = null;
		}
	}

	@Override
	public IBusModelIndexCol getIndexColRec() {
		return( (IBusModelIndexCol)getRec() );
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
			requiredContainerIndex = null;
			optionalLookupDefSchema = null;
			optionalChildrenRefRelFromCol = null;
			optionalChildrenRefRelToCol = null;
			optionalLookupPrev = null;
			optionalLookupNext = null;
			requiredLookupColumn = null;
		}
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
	public void setRequiredName( String value ) {
		if( getIndexColRec().getRequiredName() != value ) {
			getIndexColRec().setRequiredName( value );
		}
	}

	@Override
	public String getOptionalShortName() {
		return( getIndexColRec().getOptionalShortName() );
	}

	@Override
	public void setOptionalShortName( String value ) {
		if( getIndexColRec().getOptionalShortName() != value ) {
			getIndexColRec().setOptionalShortName( value );
		}
	}

	@Override
	public String getOptionalLabel() {
		return( getIndexColRec().getOptionalLabel() );
	}

	@Override
	public void setOptionalLabel( String value ) {
		if( getIndexColRec().getOptionalLabel() != value ) {
			getIndexColRec().setOptionalLabel( value );
		}
	}

	@Override
	public String getOptionalShortDescription() {
		return( getIndexColRec().getOptionalShortDescription() );
	}

	@Override
	public void setOptionalShortDescription( String value ) {
		if( getIndexColRec().getOptionalShortDescription() != value ) {
			getIndexColRec().setOptionalShortDescription( value );
		}
	}

	@Override
	public String getOptionalDescription() {
		return( getIndexColRec().getOptionalDescription() );
	}

	@Override
	public void setOptionalDescription( String value ) {
		if( getIndexColRec().getOptionalDescription() != value ) {
			getIndexColRec().setOptionalDescription( value );
		}
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
	public void setRequiredIsAscending( boolean value ) {
		if( getIndexColRec().getRequiredIsAscending() != value ) {
			getIndexColRec().setRequiredIsAscending( value );
		}
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
	public IBusModelIndexObj getRequiredContainerIndex() {
		return( getRequiredContainerIndex( false ) );
	}

	@Override
	public IBusModelIndexObj getRequiredContainerIndex( boolean forceRead ) {
		if( forceRead || ( requiredContainerIndex == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelIndexObj obj = ((IBusModelSchemaObj)getOrigAsIndexCol().getSchema()).getIndexTableObj().readIndexByIdIdx( getIndexColRec().getRequiredIndexId() );
				requiredContainerIndex = obj;
				if( obj != null ) {
					requiredContainerIndex = obj;
				}
			}
		}
		return( requiredContainerIndex );
	}

	@Override
	public void setRequiredContainerIndex( IBusModelIndexObj value ) {
		if( rec == null ) {
			getIndexColRec();
		}
		if( value != null ) {
			requiredContainerIndex = value;
			getIndexColRec().setRequiredContainerIndex(value.getIndexRec());
		}
		requiredContainerIndex = value;
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getIndexColRec().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelSchemaDefObj obj = ((IBusModelSchemaObj)getOrigAsIndexCol().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getIndexColRec().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	@Override
	public void setOptionalLookupDefSchema( IBusModelSchemaDefObj value ) {
		if( rec == null ) {
			getIndexColRec();
		}
		if( value != null ) {
			optionalLookupDefSchema = value;
			getIndexColRec().setOptionalLookupDefSchema(value.getSchemaDefRec());
		}
		else {
			optionalLookupDefSchema = null;
			getIndexColRec().setOptionalLookupDefSchema((IBusModelSchemaDef)null);
		}
		optionalLookupDefSchema = value;
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
		if( forceRead || ( optionalLookupPrev == null ) ) {
			boolean anyMissing = false;
			if( getIndexColRec().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelIndexColObj obj = ((IBusModelSchemaObj)getOrigAsIndexCol().getSchema()).getIndexColTableObj().readIndexColByIdIdx( getIndexColRec().getOptionalPrevId() );
				optionalLookupPrev = obj;
			}
		}
		return( optionalLookupPrev );
	}

	@Override
	public void setOptionalLookupPrev( IBusModelIndexColObj value ) {
		if( rec == null ) {
			getIndexColRec();
		}
		if( value != null ) {
			optionalLookupPrev = value;
			getIndexColRec().setOptionalLookupPrev(value.getIndexColRec());
		}
		else {
			optionalLookupPrev = null;
			getIndexColRec().setOptionalLookupPrev((IBusModelIndexCol)null);
		}
		optionalLookupPrev = value;
	}

	@Override
	public IBusModelIndexColObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	@Override
	public IBusModelIndexColObj getOptionalLookupNext( boolean forceRead ) {
		if( forceRead || ( optionalLookupNext == null ) ) {
			boolean anyMissing = false;
			if( getIndexColRec().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelIndexColObj obj = ((IBusModelSchemaObj)getOrigAsIndexCol().getSchema()).getIndexColTableObj().readIndexColByIdIdx( getIndexColRec().getOptionalNextId() );
				optionalLookupNext = obj;
			}
		}
		return( optionalLookupNext );
	}

	@Override
	public void setOptionalLookupNext( IBusModelIndexColObj value ) {
		if( rec == null ) {
			getIndexColRec();
		}
		if( value != null ) {
			optionalLookupNext = value;
			getIndexColRec().setOptionalLookupNext(value.getIndexColRec());
		}
		else {
			optionalLookupNext = null;
			getIndexColRec().setOptionalLookupNext((IBusModelIndexCol)null);
		}
		optionalLookupNext = value;
	}

	@Override
	public IBusModelValueObj getRequiredLookupColumn() {
		return( getRequiredLookupColumn( false ) );
	}

	@Override
	public IBusModelValueObj getRequiredLookupColumn( boolean forceRead ) {
		if( forceRead || ( requiredLookupColumn == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelValueObj obj = ((IBusModelSchemaObj)getOrigAsIndexCol().getSchema()).getValueTableObj().readValueByIdIdx( getIndexColRec().getRequiredColumnId() );
				requiredLookupColumn = obj;
			}
		}
		return( requiredLookupColumn );
	}

	@Override
	public void setRequiredLookupColumn( IBusModelValueObj value ) {
		if( rec == null ) {
			getIndexColRec();
		}
		if( value != null ) {
			requiredLookupColumn = value;
			getIndexColRec().setRequiredLookupColumn(value.getValueRec());
		}
		else {
			requiredLookupColumn = null;
			getIndexColRec().setRequiredLookupColumn((IBusModelValue)null);
		}
		requiredLookupColumn = value;
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
		IBusModelIndexCol origRec = getOrigAsIndexCol().getIndexColRec();
		IBusModelIndexCol myRec = getIndexColRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelIndexCol origRec = getOrigAsIndexCol().getIndexColRec();
		IBusModelIndexCol myRec = getIndexColRec();
		myRec.set( origRec );
	}
}
