// Description: Java 25 edit object instance implementation for BusModel ClearTopDep.

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

public class BusModelClearTopDepEditObj
	extends BusModelClearDepEditObj

	implements IBusModelClearTopDepEditObj
{
	protected IBusModelTableObj requiredContainerTable;
	protected List<IBusModelClearSubDep1Obj> optionalComponentsClearDep;
	protected IBusModelClearTopDepObj optionalLookupPrev;
	protected IBusModelClearTopDepObj optionalLookupNext;

	public BusModelClearTopDepEditObj( IBusModelClearTopDepObj argOrig ) {
		super( argOrig );
		requiredContainerTable = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)orig.getSchema()).getClearTopDepTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "ClearTopDep" );
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
		IBusModelClearTopDepObj retobj = getSchema().getClearTopDepTableObj().realiseClearTopDep( (IBusModelClearTopDepObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsClearTopDep().forget();
	}

	@Override
	public IBusModelClearTopDepObj moveUp() {
		throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUp" );
	}

	@Override
	public IBusModelClearTopDepObj moveDown() {
		throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDown" );
	}

	@Override
	public IBusModelScopeObj create() {
		copyRecToOrig();
		IBusModelClearTopDepObj retobj = ((IBusModelSchemaObj)getOrigAsClearTopDep().getSchema()).getClearTopDepTableObj().createClearTopDep( getOrigAsClearTopDep() );
		if( retobj == getOrigAsClearTopDep() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelScopeEditObj update() {
		getSchema().getClearTopDepTableObj().updateClearTopDep( (IBusModelClearTopDepObj)this );
		return( null );
	}

	@Override
	public BusModelScopeEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getClearTopDepTableObj().deleteClearTopDep( getOrigAsClearTopDep() );
		return( null );
	}

	@Override
	public IBusModelClearTopDepTableObj getClearTopDepTable() {
		return( orig.getSchema().getClearTopDepTableObj() );
	}

	@Override
	public IBusModelClearTopDepEditObj getEditAsClearTopDep() {
		return( (IBusModelClearTopDepEditObj)this );
	}

	@Override
	public IBusModelClearTopDepObj getOrigAsClearTopDep() {
		return( (IBusModelClearTopDepObj)orig );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			rec = getOrigAsClearTopDep().getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryClearTopDep().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelScope value ) {
		if( rec != value ) {
			super.setRec( value );
			requiredContainerTable = null;
			optionalLookupPrev = null;
			optionalLookupNext = null;
		}
	}

	@Override
	public IBusModelClearTopDep getClearTopDepRec() {
		return( (IBusModelClearTopDep)getRec() );
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
		return( getClearTopDepRec().getRequiredTableId() );
	}

	@Override
	public String getRequiredName() {
		return( getClearTopDepRec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getClearTopDepRec().getRequiredName() != value ) {
			getClearTopDepRec().setRequiredName( value );
		}
	}

	@Override
	public IYCFKeyHash256 getOptionalPrevId() {
		return( getClearTopDepRec().getOptionalPrevId() );
	}

	@Override
	public IYCFKeyHash256 getOptionalNextId() {
		return( getClearTopDepRec().getOptionalNextId() );
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
				IBusModelTableObj obj = ((IBusModelSchemaObj)getOrigAsClearTopDep().getSchema()).getTableTableObj().readTableByIdIdx( getClearTopDepRec().getRequiredTableId() );
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
			getClearTopDepRec();
		}
		if( value != null ) {
			requiredContainerTable = value;
			getClearTopDepRec().setRequiredContainerTable(value.getTableRec());
		}
		requiredContainerTable = value;
	}

	@Override
	public List<IBusModelClearSubDep1Obj> getOptionalComponentsClearDep() {
		List<IBusModelClearSubDep1Obj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getClearSubDep1TableObj().readClearSubDep1ByClearTopDepIdx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelClearSubDep1Obj> getOptionalComponentsClearDep( boolean forceRead ) {
		List<IBusModelClearSubDep1Obj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getClearSubDep1TableObj().readClearSubDep1ByClearTopDepIdx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public IBusModelClearTopDepObj getOptionalLookupPrev() {
		return( getOptionalLookupPrev( false ) );
	}

	@Override
	public IBusModelClearTopDepObj getOptionalLookupPrev( boolean forceRead ) {
		if( forceRead || ( optionalLookupPrev == null ) ) {
			boolean anyMissing = false;
			if( getClearTopDepRec().getOptionalPrevId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelClearTopDepObj obj = ((IBusModelSchemaObj)getOrigAsClearTopDep().getSchema()).getClearTopDepTableObj().readClearTopDepByIdIdx( getClearTopDepRec().getOptionalPrevId() );
				optionalLookupPrev = obj;
			}
		}
		return( optionalLookupPrev );
	}

	@Override
	public void setOptionalLookupPrev( IBusModelClearTopDepObj value ) {
		if( rec == null ) {
			getClearTopDepRec();
		}
		if( value != null ) {
			optionalLookupPrev = value;
			getClearTopDepRec().setOptionalLookupPrev(value.getClearTopDepRec());
		}
		else {
			optionalLookupPrev = null;
			getClearTopDepRec().setOptionalLookupPrev((IBusModelClearTopDep)null);
		}
		optionalLookupPrev = value;
	}

	@Override
	public IBusModelClearTopDepObj getOptionalLookupNext() {
		return( getOptionalLookupNext( false ) );
	}

	@Override
	public IBusModelClearTopDepObj getOptionalLookupNext( boolean forceRead ) {
		if( forceRead || ( optionalLookupNext == null ) ) {
			boolean anyMissing = false;
			if( getClearTopDepRec().getOptionalNextId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelClearTopDepObj obj = ((IBusModelSchemaObj)getOrigAsClearTopDep().getSchema()).getClearTopDepTableObj().readClearTopDepByIdIdx( getClearTopDepRec().getOptionalNextId() );
				optionalLookupNext = obj;
			}
		}
		return( optionalLookupNext );
	}

	@Override
	public void setOptionalLookupNext( IBusModelClearTopDepObj value ) {
		if( rec == null ) {
			getClearTopDepRec();
		}
		if( value != null ) {
			optionalLookupNext = value;
			getClearTopDepRec().setOptionalLookupNext(value.getClearTopDepRec());
		}
		else {
			optionalLookupNext = null;
			getClearTopDepRec().setOptionalLookupNext((IBusModelClearTopDep)null);
		}
		optionalLookupNext = value;
	}

	@Override
	public void copyRecToOrig() {
		IBusModelClearTopDep origRec = getOrigAsClearTopDep().getClearTopDepRec();
		IBusModelClearTopDep myRec = getClearTopDepRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelClearTopDep origRec = getOrigAsClearTopDep().getClearTopDepRec();
		IBusModelClearTopDep myRec = getClearTopDepRec();
		myRec.set( origRec );
	}
}
