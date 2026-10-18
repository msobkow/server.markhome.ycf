// Description: Java 25 edit object instance implementation for BusModel ClearSubDep1.

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

public class BusModelClearSubDep1EditObj
	extends BusModelClearDepEditObj

	implements IBusModelClearSubDep1EditObj
{
	protected IBusModelClearTopDepObj requiredContainerClearTopDep;
	protected List<IBusModelClearSubDep2Obj> optionalComponentsClearDep;

	public BusModelClearSubDep1EditObj( IBusModelClearSubDep1Obj argOrig ) {
		super( argOrig );
		requiredContainerClearTopDep = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)orig.getSchema()).getClearSubDep1TableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "ClearSubDep1" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelClearTopDepObj scope = getRequiredContainerClearTopDep();
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
		IBusModelClearSubDep1Obj retobj = getSchema().getClearSubDep1TableObj().realiseClearSubDep1( (IBusModelClearSubDep1Obj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsClearSubDep1().forget();
	}

	@Override
	public IBusModelScopeObj create() {
		copyRecToOrig();
		IBusModelClearSubDep1Obj retobj = ((IBusModelSchemaObj)getOrigAsClearSubDep1().getSchema()).getClearSubDep1TableObj().createClearSubDep1( getOrigAsClearSubDep1() );
		if( retobj == getOrigAsClearSubDep1() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelScopeEditObj update() {
		getSchema().getClearSubDep1TableObj().updateClearSubDep1( (IBusModelClearSubDep1Obj)this );
		return( null );
	}

	@Override
	public BusModelScopeEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getClearSubDep1TableObj().deleteClearSubDep1( getOrigAsClearSubDep1() );
		return( null );
	}

	@Override
	public IBusModelClearSubDep1TableObj getClearSubDep1Table() {
		return( orig.getSchema().getClearSubDep1TableObj() );
	}

	@Override
	public IBusModelClearSubDep1EditObj getEditAsClearSubDep1() {
		return( (IBusModelClearSubDep1EditObj)this );
	}

	@Override
	public IBusModelClearSubDep1Obj getOrigAsClearSubDep1() {
		return( (IBusModelClearSubDep1Obj)orig );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			rec = getOrigAsClearSubDep1().getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryClearSubDep1().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelScope value ) {
		if( rec != value ) {
			super.setRec( value );
			requiredContainerClearTopDep = null;
		}
	}

	@Override
	public IBusModelClearSubDep1 getClearSubDep1Rec() {
		return( (IBusModelClearSubDep1)getRec() );
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
	public IYCFKeyHash256 getRequiredClearTopDepId() {
		return( getClearSubDep1Rec().getRequiredClearTopDepId() );
	}

	@Override
	public String getRequiredName() {
		return( getClearSubDep1Rec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getClearSubDep1Rec().getRequiredName() != value ) {
			getClearSubDep1Rec().setRequiredName( value );
		}
	}

	@Override
	public IBusModelClearTopDepObj getRequiredContainerClearTopDep() {
		return( getRequiredContainerClearTopDep( false ) );
	}

	@Override
	public IBusModelClearTopDepObj getRequiredContainerClearTopDep( boolean forceRead ) {
		if( forceRead || ( requiredContainerClearTopDep == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelClearTopDepObj obj = ((IBusModelSchemaObj)getOrigAsClearSubDep1().getSchema()).getClearTopDepTableObj().readClearTopDepByIdIdx( getClearSubDep1Rec().getRequiredClearTopDepId() );
				requiredContainerClearTopDep = obj;
				if( obj != null ) {
					requiredContainerClearTopDep = obj;
				}
			}
		}
		return( requiredContainerClearTopDep );
	}

	@Override
	public void setRequiredContainerClearTopDep( IBusModelClearTopDepObj value ) {
		if( rec == null ) {
			getClearSubDep1Rec();
		}
		if( value != null ) {
			requiredContainerClearTopDep = value;
			getClearSubDep1Rec().setRequiredContainerClearTopDep(value.getClearTopDepRec());
		}
		requiredContainerClearTopDep = value;
	}

	@Override
	public List<IBusModelClearSubDep2Obj> getOptionalComponentsClearDep() {
		List<IBusModelClearSubDep2Obj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getClearSubDep2TableObj().readClearSubDep2ByClearSubDep1Idx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelClearSubDep2Obj> getOptionalComponentsClearDep( boolean forceRead ) {
		List<IBusModelClearSubDep2Obj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getClearSubDep2TableObj().readClearSubDep2ByClearSubDep1Idx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public void copyRecToOrig() {
		IBusModelClearSubDep1 origRec = getOrigAsClearSubDep1().getClearSubDep1Rec();
		IBusModelClearSubDep1 myRec = getClearSubDep1Rec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelClearSubDep1 origRec = getOrigAsClearSubDep1().getClearSubDep1Rec();
		IBusModelClearSubDep1 myRec = getClearSubDep1Rec();
		myRec.set( origRec );
	}
}
