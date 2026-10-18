// Description: Java 25 edit object instance implementation for BusModel ClearSubDep3.

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

public class BusModelClearSubDep3EditObj
	extends BusModelClearDepEditObj

	implements IBusModelClearSubDep3EditObj
{
	protected IBusModelClearSubDep2Obj requiredContainerClearSubDep2;

	public BusModelClearSubDep3EditObj( IBusModelClearSubDep3Obj argOrig ) {
		super( argOrig );
		requiredContainerClearSubDep2 = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)orig.getSchema()).getClearSubDep3TableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "ClearSubDep3" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelClearSubDep2Obj scope = getRequiredContainerClearSubDep2();
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
		IBusModelClearSubDep3Obj retobj = getSchema().getClearSubDep3TableObj().realiseClearSubDep3( (IBusModelClearSubDep3Obj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsClearSubDep3().forget();
	}

	@Override
	public IBusModelScopeObj create() {
		copyRecToOrig();
		IBusModelClearSubDep3Obj retobj = ((IBusModelSchemaObj)getOrigAsClearSubDep3().getSchema()).getClearSubDep3TableObj().createClearSubDep3( getOrigAsClearSubDep3() );
		if( retobj == getOrigAsClearSubDep3() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelScopeEditObj update() {
		getSchema().getClearSubDep3TableObj().updateClearSubDep3( (IBusModelClearSubDep3Obj)this );
		return( null );
	}

	@Override
	public BusModelScopeEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getClearSubDep3TableObj().deleteClearSubDep3( getOrigAsClearSubDep3() );
		return( null );
	}

	@Override
	public IBusModelClearSubDep3TableObj getClearSubDep3Table() {
		return( orig.getSchema().getClearSubDep3TableObj() );
	}

	@Override
	public IBusModelClearSubDep3EditObj getEditAsClearSubDep3() {
		return( (IBusModelClearSubDep3EditObj)this );
	}

	@Override
	public IBusModelClearSubDep3Obj getOrigAsClearSubDep3() {
		return( (IBusModelClearSubDep3Obj)orig );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			rec = getOrigAsClearSubDep3().getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryClearSubDep3().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelScope value ) {
		if( rec != value ) {
			super.setRec( value );
			requiredContainerClearSubDep2 = null;
		}
	}

	@Override
	public IBusModelClearSubDep3 getClearSubDep3Rec() {
		return( (IBusModelClearSubDep3)getRec() );
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
	public IYCFKeyHash256 getRequiredClearSubDep2Id() {
		return( getClearSubDep3Rec().getRequiredClearSubDep2Id() );
	}

	@Override
	public String getRequiredName() {
		return( getClearSubDep3Rec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getClearSubDep3Rec().getRequiredName() != value ) {
			getClearSubDep3Rec().setRequiredName( value );
		}
	}

	@Override
	public IBusModelClearSubDep2Obj getRequiredContainerClearSubDep2() {
		return( getRequiredContainerClearSubDep2( false ) );
	}

	@Override
	public IBusModelClearSubDep2Obj getRequiredContainerClearSubDep2( boolean forceRead ) {
		if( forceRead || ( requiredContainerClearSubDep2 == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelClearSubDep2Obj obj = ((IBusModelSchemaObj)getOrigAsClearSubDep3().getSchema()).getClearSubDep2TableObj().readClearSubDep2ByIdIdx( getClearSubDep3Rec().getRequiredClearSubDep2Id() );
				requiredContainerClearSubDep2 = obj;
				if( obj != null ) {
					requiredContainerClearSubDep2 = obj;
				}
			}
		}
		return( requiredContainerClearSubDep2 );
	}

	@Override
	public void setRequiredContainerClearSubDep2( IBusModelClearSubDep2Obj value ) {
		if( rec == null ) {
			getClearSubDep3Rec();
		}
		if( value != null ) {
			requiredContainerClearSubDep2 = value;
			getClearSubDep3Rec().setRequiredContainerClearSubDep2(value.getClearSubDep2Rec());
		}
		requiredContainerClearSubDep2 = value;
	}

	@Override
	public void copyRecToOrig() {
		IBusModelClearSubDep3 origRec = getOrigAsClearSubDep3().getClearSubDep3Rec();
		IBusModelClearSubDep3 myRec = getClearSubDep3Rec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelClearSubDep3 origRec = getOrigAsClearSubDep3().getClearSubDep3Rec();
		IBusModelClearSubDep3 myRec = getClearSubDep3Rec();
		myRec.set( origRec );
	}
}
