// Description: Java 25 edit object instance implementation for BusModel Chain.

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

public class BusModelChainEditObj
	implements IBusModelChainEditObj
{
	protected IBusModelChainObj orig;
	protected IBusModelChain rec;
	protected ISecureSecUserObj createdBy = null;
	protected ISecureSecUserObj updatedBy = null;
	protected IBusModelTableObj requiredContainerTable;
	protected IBusModelSchemaDefObj optionalLookupDefSchema;
	protected IBusModelRelationObj requiredLookupPrevRel;
	protected IBusModelRelationObj requiredLookupNextRel;

	public BusModelChainEditObj( IBusModelChainObj argOrig ) {
		orig = argOrig;
		getRec();
		IBusModelChain origRec = orig.getRec();
		rec.set( origRec );
		requiredContainerTable = null;
		optionalLookupDefSchema = null;
		requiredLookupPrevRel = null;
		requiredLookupNextRel = null;
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			IBusModelChain rec = getRec();
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
			IBusModelChain rec = getRec();
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
		return( ((IBusModelSchemaObj)orig.getSchema()).getChainTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "Chain" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelTableObj scope = getRequiredContainerTable();
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
	public IBusModelChainObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		IBusModelChainObj retobj = getSchema().getChainTableObj().realiseChain( (IBusModelChainObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsChain().forget();
	}

	@Override
	public IBusModelChainObj read() {
		IBusModelChainObj retval = getOrigAsChain().read();
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IBusModelChainObj read( boolean forceRead ) {
		IBusModelChainObj retval = getOrigAsChain().read( forceRead );
		if( retval != orig ) {
			throw new YCFStaleCacheDetectedException( getClass(),	"read" );
		}
		copyOrigToRec();
		return( retval );
	}

	@Override
	public IBusModelChainObj create() {
		copyRecToOrig();
		IBusModelChainObj retobj = ((IBusModelSchemaObj)getOrigAsChain().getSchema()).getChainTableObj().createChain( getOrigAsChain() );
		if( retobj == getOrigAsChain() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelChainEditObj update() {
		getSchema().getChainTableObj().updateChain( (IBusModelChainObj)this );
		return( null );
	}

	@Override
	public BusModelChainEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getChainTableObj().deleteChain( getOrigAsChain() );
		return( null );
	}

	@Override
	public IBusModelChainTableObj getChainTable() {
		return( orig.getSchema().getChainTableObj() );
	}

	@Override
	public IBusModelChainEditObj getEdit() {
		return( (IBusModelChainEditObj)this );
	}

	@Override
	public IBusModelChainEditObj getEditAsChain() {
		return( (IBusModelChainEditObj)this );
	}

	@Override
	public IBusModelChainEditObj beginEdit() {
		throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
	}

	@Override
	public void endEdit() {
		orig.endEdit();
	}

	@Override
	public IBusModelChainObj getOrig() {
		return( orig );
	}

	@Override
	public IBusModelChainObj getOrigAsChain() {
		return( (IBusModelChainObj)orig );
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
	public IBusModelChain getRec() {
		if( rec == null ) {
			rec = getOrigAsChain().getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryChain().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelChain value ) {
		if( rec != value ) {
			rec = value;
			requiredContainerTable = null;
			optionalLookupDefSchema = null;
			requiredLookupPrevRel = null;
			requiredLookupNextRel = null;
		}
	}

	@Override
	public IBusModelChain getChainRec() {
		return( (IBusModelChain)getRec() );
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
		}
	}

	@Override
	public IYCFKeyHash256 getOptionalDefSchemaId() {
		return( getChainRec().getOptionalDefSchemaId() );
	}

	@Override
	public String getRequiredName() {
		return( getChainRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getChainRec().getRequiredName() != value ) {
			getChainRec().setRequiredName( value );
		}
	}

	@Override
	public String getOptionalShortName() {
		return( getChainRec().getOptionalShortName() );
	}

	@Override
	public void setOptionalShortName( String value ) {
		if( getChainRec().getOptionalShortName() != value ) {
			getChainRec().setOptionalShortName( value );
		}
	}

	@Override
	public String getOptionalLabel() {
		return( getChainRec().getOptionalLabel() );
	}

	@Override
	public void setOptionalLabel( String value ) {
		if( getChainRec().getOptionalLabel() != value ) {
			getChainRec().setOptionalLabel( value );
		}
	}

	@Override
	public String getOptionalShortDescription() {
		return( getChainRec().getOptionalShortDescription() );
	}

	@Override
	public void setOptionalShortDescription( String value ) {
		if( getChainRec().getOptionalShortDescription() != value ) {
			getChainRec().setOptionalShortDescription( value );
		}
	}

	@Override
	public String getOptionalDescription() {
		return( getChainRec().getOptionalDescription() );
	}

	@Override
	public void setOptionalDescription( String value ) {
		if( getChainRec().getOptionalDescription() != value ) {
			getChainRec().setOptionalDescription( value );
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredTableId() {
		return( getChainRec().getRequiredTableId() );
	}

	@Override
	public String getOptionalSuffix() {
		return( getChainRec().getOptionalSuffix() );
	}

	@Override
	public void setOptionalSuffix( String value ) {
		if( getChainRec().getOptionalSuffix() != value ) {
			getChainRec().setOptionalSuffix( value );
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredPrevRelationId() {
		return( getChainRec().getRequiredPrevRelationId() );
	}

	@Override
	public IYCFKeyHash256 getRequiredNextRelationId() {
		return( getChainRec().getRequiredNextRelationId() );
	}

	@Override
	public IBusModelTableObj getRequiredContainerTable() {
		return( getRequiredContainerTable( false ) );
	}

	@Override
	public IBusModelTableObj getRequiredContainerTable( boolean forceRead ) {
		if( forceRead || ( requiredContainerTable == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelTableObj obj = ((IBusModelSchemaObj)getOrigAsChain().getSchema()).getTableTableObj().readTableByIdIdx( getChainRec().getRequiredTableId() );
				requiredContainerTable = obj;
				if( obj != null ) {
					requiredContainerTable = obj;
				}
			}
		}
		return( requiredContainerTable );
	}

	@Override
	public void setRequiredContainerTable( IBusModelTableObj value ) {
		if( rec == null ) {
			getChainRec();
		}
		if( value != null ) {
			requiredContainerTable = value;
			getChainRec().setRequiredContainerTable(value.getTableRec());
		}
		requiredContainerTable = value;
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema() {
		return( getOptionalLookupDefSchema( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getOptionalLookupDefSchema( boolean forceRead ) {
		if( forceRead || ( optionalLookupDefSchema == null ) ) {
			boolean anyMissing = false;
			if( getChainRec().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelSchemaDefObj obj = ((IBusModelSchemaObj)getOrigAsChain().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getChainRec().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	@Override
	public void setOptionalLookupDefSchema( IBusModelSchemaDefObj value ) {
		if( rec == null ) {
			getChainRec();
		}
		if( value != null ) {
			optionalLookupDefSchema = value;
			getChainRec().setOptionalLookupDefSchema(value.getSchemaDefRec());
		}
		else {
			optionalLookupDefSchema = null;
			getChainRec().setOptionalLookupDefSchema((IBusModelSchemaDef)null);
		}
		optionalLookupDefSchema = value;
	}

	@Override
	public IBusModelRelationObj getRequiredLookupPrevRel() {
		return( getRequiredLookupPrevRel( false ) );
	}

	@Override
	public IBusModelRelationObj getRequiredLookupPrevRel( boolean forceRead ) {
		if( forceRead || ( requiredLookupPrevRel == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelRelationObj obj = ((IBusModelSchemaObj)getOrigAsChain().getSchema()).getRelationTableObj().readRelationByIdIdx( getChainRec().getRequiredPrevRelationId() );
				requiredLookupPrevRel = obj;
			}
		}
		return( requiredLookupPrevRel );
	}

	@Override
	public void setRequiredLookupPrevRel( IBusModelRelationObj value ) {
		if( rec == null ) {
			getChainRec();
		}
		if( value != null ) {
			requiredLookupPrevRel = value;
			getChainRec().setRequiredLookupPrevRel(value.getRelationRec());
		}
		else {
			requiredLookupPrevRel = null;
			getChainRec().setRequiredLookupPrevRel((IBusModelRelation)null);
		}
		requiredLookupPrevRel = value;
	}

	@Override
	public IBusModelRelationObj getRequiredLookupNextRel() {
		return( getRequiredLookupNextRel( false ) );
	}

	@Override
	public IBusModelRelationObj getRequiredLookupNextRel( boolean forceRead ) {
		if( forceRead || ( requiredLookupNextRel == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelRelationObj obj = ((IBusModelSchemaObj)getOrigAsChain().getSchema()).getRelationTableObj().readRelationByIdIdx( getChainRec().getRequiredNextRelationId() );
				requiredLookupNextRel = obj;
			}
		}
		return( requiredLookupNextRel );
	}

	@Override
	public void setRequiredLookupNextRel( IBusModelRelationObj value ) {
		if( rec == null ) {
			getChainRec();
		}
		if( value != null ) {
			requiredLookupNextRel = value;
			getChainRec().setRequiredLookupNextRel(value.getRelationRec());
		}
		else {
			requiredLookupNextRel = null;
			getChainRec().setRequiredLookupNextRel((IBusModelRelation)null);
		}
		requiredLookupNextRel = value;
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
		IBusModelChain origRec = getOrigAsChain().getChainRec();
		IBusModelChain myRec = getChainRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelChain origRec = getOrigAsChain().getChainRec();
		IBusModelChain myRec = getChainRec();
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
