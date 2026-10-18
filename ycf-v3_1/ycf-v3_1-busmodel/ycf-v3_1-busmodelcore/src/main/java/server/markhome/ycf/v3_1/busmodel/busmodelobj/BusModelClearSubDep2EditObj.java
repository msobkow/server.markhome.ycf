// Description: Java 25 edit object instance implementation for BusModel ClearSubDep2.

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

public class BusModelClearSubDep2EditObj
	extends BusModelClearDepEditObj

	implements IBusModelClearSubDep2EditObj
{
	protected IBusModelClearSubDep1Obj requiredContainerClearSubDep1;
	protected List<IBusModelClearSubDep3Obj> optionalComponentsClearDep;

	public BusModelClearSubDep2EditObj( IBusModelClearSubDep2Obj argOrig ) {
		super( argOrig );
		requiredContainerClearSubDep1 = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)orig.getSchema()).getClearSubDep2TableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "ClearSubDep2" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelClearSubDep1Obj scope = getRequiredContainerClearSubDep1();
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
		IBusModelClearSubDep2Obj retobj = getSchema().getClearSubDep2TableObj().realiseClearSubDep2( (IBusModelClearSubDep2Obj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsClearSubDep2().forget();
	}

	@Override
	public IBusModelScopeObj create() {
		copyRecToOrig();
		IBusModelClearSubDep2Obj retobj = ((IBusModelSchemaObj)getOrigAsClearSubDep2().getSchema()).getClearSubDep2TableObj().createClearSubDep2( getOrigAsClearSubDep2() );
		if( retobj == getOrigAsClearSubDep2() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelScopeEditObj update() {
		getSchema().getClearSubDep2TableObj().updateClearSubDep2( (IBusModelClearSubDep2Obj)this );
		return( null );
	}

	@Override
	public BusModelScopeEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getClearSubDep2TableObj().deleteClearSubDep2( getOrigAsClearSubDep2() );
		return( null );
	}

	@Override
	public IBusModelClearSubDep2TableObj getClearSubDep2Table() {
		return( orig.getSchema().getClearSubDep2TableObj() );
	}

	@Override
	public IBusModelClearSubDep2EditObj getEditAsClearSubDep2() {
		return( (IBusModelClearSubDep2EditObj)this );
	}

	@Override
	public IBusModelClearSubDep2Obj getOrigAsClearSubDep2() {
		return( (IBusModelClearSubDep2Obj)orig );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			rec = getOrigAsClearSubDep2().getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryClearSubDep2().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelScope value ) {
		if( rec != value ) {
			super.setRec( value );
			requiredContainerClearSubDep1 = null;
		}
	}

	@Override
	public IBusModelClearSubDep2 getClearSubDep2Rec() {
		return( (IBusModelClearSubDep2)getRec() );
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
	public IYCFKeyHash256 getRequiredClearSubDep1Id() {
		return( getClearSubDep2Rec().getRequiredClearSubDep1Id() );
	}

	@Override
	public String getRequiredName() {
		return( getClearSubDep2Rec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getClearSubDep2Rec().getRequiredName() != value ) {
			getClearSubDep2Rec().setRequiredName( value );
		}
	}

	@Override
	public IBusModelClearSubDep1Obj getRequiredContainerClearSubDep1() {
		return( getRequiredContainerClearSubDep1( false ) );
	}

	@Override
	public IBusModelClearSubDep1Obj getRequiredContainerClearSubDep1( boolean forceRead ) {
		if( forceRead || ( requiredContainerClearSubDep1 == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelClearSubDep1Obj obj = ((IBusModelSchemaObj)getOrigAsClearSubDep2().getSchema()).getClearSubDep1TableObj().readClearSubDep1ByIdIdx( getClearSubDep2Rec().getRequiredClearSubDep1Id() );
				requiredContainerClearSubDep1 = obj;
				if( obj != null ) {
					requiredContainerClearSubDep1 = obj;
				}
			}
		}
		return( requiredContainerClearSubDep1 );
	}

	@Override
	public void setRequiredContainerClearSubDep1( IBusModelClearSubDep1Obj value ) {
		if( rec == null ) {
			getClearSubDep2Rec();
		}
		if( value != null ) {
			requiredContainerClearSubDep1 = value;
			getClearSubDep2Rec().setRequiredContainerClearSubDep1(value.getClearSubDep1Rec());
		}
		requiredContainerClearSubDep1 = value;
	}

	@Override
	public List<IBusModelClearSubDep3Obj> getOptionalComponentsClearDep() {
		List<IBusModelClearSubDep3Obj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getClearSubDep3TableObj().readClearSubDep3ByClearSubDep2Idx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelClearSubDep3Obj> getOptionalComponentsClearDep( boolean forceRead ) {
		List<IBusModelClearSubDep3Obj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getClearSubDep3TableObj().readClearSubDep3ByClearSubDep2Idx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public void copyRecToOrig() {
		IBusModelClearSubDep2 origRec = getOrigAsClearSubDep2().getClearSubDep2Rec();
		IBusModelClearSubDep2 myRec = getClearSubDep2Rec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelClearSubDep2 origRec = getOrigAsClearSubDep2().getClearSubDep2Rec();
		IBusModelClearSubDep2 myRec = getClearSubDep2Rec();
		myRec.set( origRec );
	}
}
