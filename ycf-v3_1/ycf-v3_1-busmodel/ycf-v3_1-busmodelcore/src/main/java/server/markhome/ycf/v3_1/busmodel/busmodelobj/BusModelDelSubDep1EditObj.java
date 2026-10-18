// Description: Java 25 edit object instance implementation for BusModel DelSubDep1.

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

public class BusModelDelSubDep1EditObj
	extends BusModelDelDepEditObj

	implements IBusModelDelSubDep1EditObj
{
	protected IBusModelDelTopDepObj requiredContainerDelTopDep;
	protected List<IBusModelDelSubDep2Obj> optionalComponentsDelDep;

	public BusModelDelSubDep1EditObj( IBusModelDelSubDep1Obj argOrig ) {
		super( argOrig );
		requiredContainerDelTopDep = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)orig.getSchema()).getDelSubDep1TableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "DelSubDep1" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelDelTopDepObj scope = getRequiredContainerDelTopDep();
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
		IBusModelDelSubDep1Obj retobj = getSchema().getDelSubDep1TableObj().realiseDelSubDep1( (IBusModelDelSubDep1Obj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsDelSubDep1().forget();
	}

	@Override
	public IBusModelScopeObj create() {
		copyRecToOrig();
		IBusModelDelSubDep1Obj retobj = ((IBusModelSchemaObj)getOrigAsDelSubDep1().getSchema()).getDelSubDep1TableObj().createDelSubDep1( getOrigAsDelSubDep1() );
		if( retobj == getOrigAsDelSubDep1() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelScopeEditObj update() {
		getSchema().getDelSubDep1TableObj().updateDelSubDep1( (IBusModelDelSubDep1Obj)this );
		return( null );
	}

	@Override
	public BusModelScopeEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getDelSubDep1TableObj().deleteDelSubDep1( getOrigAsDelSubDep1() );
		return( null );
	}

	@Override
	public IBusModelDelSubDep1TableObj getDelSubDep1Table() {
		return( orig.getSchema().getDelSubDep1TableObj() );
	}

	@Override
	public IBusModelDelSubDep1EditObj getEditAsDelSubDep1() {
		return( (IBusModelDelSubDep1EditObj)this );
	}

	@Override
	public IBusModelDelSubDep1Obj getOrigAsDelSubDep1() {
		return( (IBusModelDelSubDep1Obj)orig );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			rec = getOrigAsDelSubDep1().getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep1().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelScope value ) {
		if( rec != value ) {
			super.setRec( value );
			requiredContainerDelTopDep = null;
		}
	}

	@Override
	public IBusModelDelSubDep1 getDelSubDep1Rec() {
		return( (IBusModelDelSubDep1)getRec() );
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
	public IYCFKeyHash256 getRequiredDelTopDepId() {
		return( getDelSubDep1Rec().getRequiredDelTopDepId() );
	}

	@Override
	public String getRequiredName() {
		return( getDelSubDep1Rec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getDelSubDep1Rec().getRequiredName() != value ) {
			getDelSubDep1Rec().setRequiredName( value );
		}
	}

	@Override
	public IBusModelDelTopDepObj getRequiredContainerDelTopDep() {
		return( getRequiredContainerDelTopDep( false ) );
	}

	@Override
	public IBusModelDelTopDepObj getRequiredContainerDelTopDep( boolean forceRead ) {
		if( forceRead || ( requiredContainerDelTopDep == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelDelTopDepObj obj = ((IBusModelSchemaObj)getOrigAsDelSubDep1().getSchema()).getDelTopDepTableObj().readDelTopDepByIdIdx( getDelSubDep1Rec().getRequiredDelTopDepId() );
				requiredContainerDelTopDep = obj;
				if( obj != null ) {
					requiredContainerDelTopDep = obj;
				}
			}
		}
		return( requiredContainerDelTopDep );
	}

	@Override
	public void setRequiredContainerDelTopDep( IBusModelDelTopDepObj value ) {
		if( rec == null ) {
			getDelSubDep1Rec();
		}
		if( value != null ) {
			requiredContainerDelTopDep = value;
			getDelSubDep1Rec().setRequiredContainerDelTopDep(value.getDelTopDepRec());
		}
		requiredContainerDelTopDep = value;
	}

	@Override
	public List<IBusModelDelSubDep2Obj> getOptionalComponentsDelDep() {
		List<IBusModelDelSubDep2Obj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getDelSubDep2TableObj().readDelSubDep2ByContDelDep1Idx( getPKey(),
			false );
		return( retval );
	}

	@Override
	public List<IBusModelDelSubDep2Obj> getOptionalComponentsDelDep( boolean forceRead ) {
		List<IBusModelDelSubDep2Obj> retval;
		retval = ((IBusModelSchemaObj)getSchema()).getDelSubDep2TableObj().readDelSubDep2ByContDelDep1Idx( getPKey(),
			forceRead );
		return( retval );
	}

	@Override
	public void copyRecToOrig() {
		IBusModelDelSubDep1 origRec = getOrigAsDelSubDep1().getDelSubDep1Rec();
		IBusModelDelSubDep1 myRec = getDelSubDep1Rec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelDelSubDep1 origRec = getOrigAsDelSubDep1().getDelSubDep1Rec();
		IBusModelDelSubDep1 myRec = getDelSubDep1Rec();
		myRec.set( origRec );
	}
}
