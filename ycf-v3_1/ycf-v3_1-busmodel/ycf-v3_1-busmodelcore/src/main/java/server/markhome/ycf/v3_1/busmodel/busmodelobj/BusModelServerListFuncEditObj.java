// Description: Java 25 edit object instance implementation for BusModel ServerListFunc.

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

public class BusModelServerListFuncEditObj
	extends BusModelServerMethodEditObj

	implements IBusModelServerListFuncEditObj
{
	protected IBusModelTableObj optionalLookupRetTable;

	public BusModelServerListFuncEditObj( IBusModelServerListFuncObj argOrig ) {
		super( argOrig );
		optionalLookupRetTable = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)orig.getSchema()).getServerListFuncTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "ServerListFunc" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		return( super.getObjScope() );
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
		IBusModelServerListFuncObj retobj = getSchema().getServerListFuncTableObj().realiseServerListFunc( (IBusModelServerListFuncObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsServerListFunc().forget();
	}

	@Override
	public IBusModelScopeObj create() {
		copyRecToOrig();
		IBusModelServerListFuncObj retobj = ((IBusModelSchemaObj)getOrigAsServerListFunc().getSchema()).getServerListFuncTableObj().createServerListFunc( getOrigAsServerListFunc() );
		if( retobj == getOrigAsServerListFunc() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelScopeEditObj update() {
		getSchema().getServerListFuncTableObj().updateServerListFunc( (IBusModelServerListFuncObj)this );
		return( null );
	}

	@Override
	public BusModelScopeEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getServerListFuncTableObj().deleteServerListFunc( getOrigAsServerListFunc() );
		return( null );
	}

	@Override
	public IBusModelServerListFuncTableObj getServerListFuncTable() {
		return( orig.getSchema().getServerListFuncTableObj() );
	}

	@Override
	public IBusModelServerListFuncEditObj getEditAsServerListFunc() {
		return( (IBusModelServerListFuncEditObj)this );
	}

	@Override
	public IBusModelServerListFuncObj getOrigAsServerListFunc() {
		return( (IBusModelServerListFuncObj)orig );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			rec = getOrigAsServerListFunc().getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryServerListFunc().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelScope value ) {
		if( rec != value ) {
			super.setRec( value );
			optionalLookupRetTable = null;
		}
	}

	@Override
	public IBusModelServerListFunc getServerListFuncRec() {
		return( (IBusModelServerListFunc)getRec() );
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
	public IYCFKeyHash256 getOptionalRetTableId() {
		return( getServerListFuncRec().getOptionalRetTableId() );
	}

	@Override
	public IBusModelTableObj getOptionalLookupRetTable() {
		return( getOptionalLookupRetTable( false ) );
	}

	@Override
	public IBusModelTableObj getOptionalLookupRetTable( boolean forceRead ) {
		if( forceRead || ( optionalLookupRetTable == null ) ) {
			boolean anyMissing = false;
			if( getServerListFuncRec().getOptionalRetTableId() == null ) {
				anyMissing = true;
			}
			if( ! anyMissing ) {
				IBusModelTableObj obj = ((IBusModelSchemaObj)getOrigAsServerListFunc().getSchema()).getTableTableObj().readTableByIdIdx( getServerListFuncRec().getOptionalRetTableId() );
				optionalLookupRetTable = obj;
			}
		}
		return( optionalLookupRetTable );
	}

	@Override
	public void setOptionalLookupRetTable( IBusModelTableObj value ) {
		if( rec == null ) {
			getServerListFuncRec();
		}
		if( value != null ) {
			optionalLookupRetTable = value;
			getServerListFuncRec().setOptionalLookupRetTable(value.getTableRec());
		}
		else {
			optionalLookupRetTable = null;
			getServerListFuncRec().setOptionalLookupRetTable((IBusModelTable)null);
		}
		optionalLookupRetTable = value;
	}

	@Override
	public void copyRecToOrig() {
		IBusModelServerListFunc origRec = getOrigAsServerListFunc().getServerListFuncRec();
		IBusModelServerListFunc myRec = getServerListFuncRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelServerListFunc origRec = getOrigAsServerListFunc().getServerListFuncRec();
		IBusModelServerListFunc myRec = getServerListFuncRec();
		myRec.set( origRec );
	}
}
