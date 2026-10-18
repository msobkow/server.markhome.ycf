// Description: Java 25 edit object instance implementation for BusModel Index.

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

public class BusModelIndexEditObj
	extends BusModelScopeEditObj

	implements IBusModelIndexEditObj
{
	protected IBusModelTableObj requiredContainerTable;
	protected IBusModelSchemaDefObj optionalLookupDefSchema;
	protected List<IBusModelIndexColObj> optionalComponentsColumns;
	protected List<IBusModelIndexTweakObj> optionalComponentsTweaks;

	public BusModelIndexEditObj( IBusModelIndexObj argOrig ) {
		super( argOrig );
		requiredContainerTable = null;
		optionalLookupDefSchema = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)orig.getSchema()).getIndexTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "Index" );
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
				subObj = ((IBusModelSchemaObj)getSchema()).getIndexColTableObj().readIndexColByUNameIdx( getRequiredId(),
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
		IBusModelIndexObj retobj = getSchema().getIndexTableObj().realiseIndex( (IBusModelIndexObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsIndex().forget();
	}

	@Override
	public IBusModelScopeObj create() {
		copyRecToOrig();
		IBusModelIndexObj retobj = ((IBusModelSchemaObj)getOrigAsIndex().getSchema()).getIndexTableObj().createIndex( getOrigAsIndex() );
		if( retobj == getOrigAsIndex() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelScopeEditObj update() {
		getSchema().getIndexTableObj().updateIndex( (IBusModelIndexObj)this );
		return( null );
	}

	@Override
	public BusModelScopeEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getIndexTableObj().deleteIndex( getOrigAsIndex() );
		return( null );
	}

	@Override
	public IBusModelIndexTableObj getIndexTable() {
		return( orig.getSchema().getIndexTableObj() );
	}

	@Override
	public IBusModelIndexEditObj getEditAsIndex() {
		return( (IBusModelIndexEditObj)this );
	}

	@Override
	public IBusModelIndexObj getOrigAsIndex() {
		return( (IBusModelIndexObj)orig );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			rec = getOrigAsIndex().getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryIndex().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelScope value ) {
		if( rec != value ) {
			super.setRec( value );
			requiredContainerTable = null;
			optionalLookupDefSchema = null;
		}
	}

	@Override
	public IBusModelIndex getIndexRec() {
		return( (IBusModelIndex)getRec() );
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
		return( getIndexRec().getRequiredTableId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalDefSchemaId() {
		return( getIndexRec().getOptionalDefSchemaId() );
	}

	@Override
	public String getRequiredName() {
		return( getIndexRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getIndexRec().getRequiredName() != value ) {
			getIndexRec().setRequiredName( value );
		}
	}

	@Override
	public String getOptionalShortName() {
		return( getIndexRec().getOptionalShortName() );
	}

	@Override
	public void setOptionalShortName( String value ) {
		if( getIndexRec().getOptionalShortName() != value ) {
			getIndexRec().setOptionalShortName( value );
		}
	}

	@Override
	public String getOptionalLabel() {
		return( getIndexRec().getOptionalLabel() );
	}

	@Override
	public void setOptionalLabel( String value ) {
		if( getIndexRec().getOptionalLabel() != value ) {
			getIndexRec().setOptionalLabel( value );
		}
	}

	@Override
	public String getOptionalShortDescription() {
		return( getIndexRec().getOptionalShortDescription() );
	}

	@Override
	public void setOptionalShortDescription( String value ) {
		if( getIndexRec().getOptionalShortDescription() != value ) {
			getIndexRec().setOptionalShortDescription( value );
		}
	}

	@Override
	public String getOptionalDescription() {
		return( getIndexRec().getOptionalDescription() );
	}

	@Override
	public void setOptionalDescription( String value ) {
		if( getIndexRec().getOptionalDescription() != value ) {
			getIndexRec().setOptionalDescription( value );
		}
	}

	@Override
	public String getOptionalDbName() {
		return( getIndexRec().getOptionalDbName() );
	}

	@Override
	public void setOptionalDbName( String value ) {
		if( getIndexRec().getOptionalDbName() != value ) {
			getIndexRec().setOptionalDbName( value );
		}
	}

	@Override
	public String getOptionalSuffix() {
		return( getIndexRec().getOptionalSuffix() );
	}

	@Override
	public void setOptionalSuffix( String value ) {
		if( getIndexRec().getOptionalSuffix() != value ) {
			getIndexRec().setOptionalSuffix( value );
		}
	}

	@Override
	public boolean getRequiredIsUnique() {
		return( getIndexRec().getRequiredIsUnique() );
	}

	@Override
	public void setRequiredIsUnique( boolean value ) {
		if( getIndexRec().getRequiredIsUnique() != value ) {
			getIndexRec().setRequiredIsUnique( value );
		}
	}

	@Override
	public boolean getRequiredIsDbMapped() {
		return( getIndexRec().getRequiredIsDbMapped() );
	}

	@Override
	public void setRequiredIsDbMapped( boolean value ) {
		if( getIndexRec().getRequiredIsDbMapped() != value ) {
			getIndexRec().setRequiredIsDbMapped( value );
		}
	}

	@Override
	public IBusModelPubSchema.CodeVisibilityEnum getRequiredCodeVis() {
		return( getIndexRec().getRequiredCodeVis() );
	}

	@Override
	public void setRequiredCodeVis( IBusModelPubSchema.CodeVisibilityEnum value ) {
		if( getIndexRec().getRequiredCodeVis() != value ) {
			getIndexRec().setRequiredCodeVis( value );
		}
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
				IBusModelTableObj obj = ((IBusModelSchemaObj)getOrigAsIndex().getSchema()).getTableTableObj().readTableByIdIdx( getIndexRec().getRequiredTableId() );
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
			getIndexRec();
		}
		if( value != null ) {
			requiredContainerTable = value;
			getIndexRec().setRequiredContainerTable(value.getTableRec());
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
			if( getIndexRec().getOptionalDefSchemaId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelSchemaDefObj obj = ((IBusModelSchemaObj)getOrigAsIndex().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getIndexRec().getOptionalDefSchemaId() );
				optionalLookupDefSchema = obj;
			}
		}
		return( optionalLookupDefSchema );
	}

	@Override
	public void setOptionalLookupDefSchema( IBusModelSchemaDefObj value ) {
		if( rec == null ) {
			getIndexRec();
		}
		if( value != null ) {
			optionalLookupDefSchema = value;
			getIndexRec().setOptionalLookupDefSchema(value.getSchemaDefRec());
		}
		else {
			optionalLookupDefSchema = null;
			getIndexRec().setOptionalLookupDefSchema((IBusModelSchemaDef)null);
		}
		optionalLookupDefSchema = value;
	}

	@Override
	public List<IBusModelIndexColObj> getOptionalComponentsColumns() {
		List<IBusModelIndexColObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getIndexColTableObj().readIndexColByIndexIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelIndexColObj> getOptionalComponentsColumns( boolean forceRead ) {
		List<IBusModelIndexColObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getIndexColTableObj().readIndexColByIndexIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public List<IBusModelIndexTweakObj> getOptionalComponentsTweaks() {
		List<IBusModelIndexTweakObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getIndexTweakTableObj().readIndexTweakByIndexIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelIndexTweakObj> getOptionalComponentsTweaks( boolean forceRead ) {
		List<IBusModelIndexTweakObj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getIndexTweakTableObj().readIndexTweakByIndexIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public void copyRecToOrig() {
		IBusModelIndex origRec = getOrigAsIndex().getIndexRec();
		IBusModelIndex myRec = getIndexRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelIndex origRec = getOrigAsIndex().getIndexRec();
		IBusModelIndex myRec = getIndexRec();
		myRec.set( origRec );
	}
}
