// Description: Java 25 edit object instance implementation for BusModel DelSubDep3.

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

public class BusModelDelSubDep3EditObj
	extends BusModelDelDepEditObj

	implements IBusModelDelSubDep3EditObj
{
	protected IBusModelDelSubDep2Obj requiredContainerDelSubDep2;

	public BusModelDelSubDep3EditObj( IBusModelDelSubDep3Obj argOrig ) {
		super( argOrig );
		requiredContainerDelSubDep2 = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)orig.getSchema()).getDelSubDep3TableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "DelSubDep3" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelDelSubDep2Obj scope = getRequiredContainerDelSubDep2();
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
		IBusModelDelSubDep3Obj retobj = getSchema().getDelSubDep3TableObj().realiseDelSubDep3( (IBusModelDelSubDep3Obj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsDelSubDep3().forget();
	}

	@Override
	public IBusModelScopeObj create() {
		copyRecToOrig();
		IBusModelDelSubDep3Obj retobj = ((IBusModelSchemaObj)getOrigAsDelSubDep3().getSchema()).getDelSubDep3TableObj().createDelSubDep3( getOrigAsDelSubDep3() );
		if( retobj == getOrigAsDelSubDep3() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelScopeEditObj update() {
		getSchema().getDelSubDep3TableObj().updateDelSubDep3( (IBusModelDelSubDep3Obj)this );
		return( null );
	}

	@Override
	public BusModelScopeEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getDelSubDep3TableObj().deleteDelSubDep3( getOrigAsDelSubDep3() );
		return( null );
	}

	@Override
	public IBusModelDelSubDep3TableObj getDelSubDep3Table() {
		return( orig.getSchema().getDelSubDep3TableObj() );
	}

	@Override
	public IBusModelDelSubDep3EditObj getEditAsDelSubDep3() {
		return( (IBusModelDelSubDep3EditObj)this );
	}

	@Override
	public IBusModelDelSubDep3Obj getOrigAsDelSubDep3() {
		return( (IBusModelDelSubDep3Obj)orig );
	}

	@Override
	public IBusModelScope getRec() {
		if( rec == null ) {
			rec = getOrigAsDelSubDep3().getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryDelSubDep3().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelScope value ) {
		if( rec != value ) {
			super.setRec( value );
			requiredContainerDelSubDep2 = null;
		}
	}

	@Override
	public IBusModelDelSubDep3 getDelSubDep3Rec() {
		return( (IBusModelDelSubDep3)getRec() );
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
	public IYCFKeyHash256 getRequiredDelSubDep2Id() {
		return( getDelSubDep3Rec().getRequiredDelSubDep2Id() );
	}

	@Override
	public String getRequiredName() {
		return( getDelSubDep3Rec().getRequiredName() );
	}

	@Override
	public void setRequiredName( String value ) {
		if( getDelSubDep3Rec().getRequiredName() != value ) {
			getDelSubDep3Rec().setRequiredName( value );
		}
	}

	@Override
	public IBusModelDelSubDep2Obj getRequiredContainerDelSubDep2() {
		return( getRequiredContainerDelSubDep2( false ) );
	}

	@Override
	public IBusModelDelSubDep2Obj getRequiredContainerDelSubDep2( boolean forceRead ) {
		if( forceRead || ( requiredContainerDelSubDep2 == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelDelSubDep2Obj obj = ((IBusModelSchemaObj)getOrigAsDelSubDep3().getSchema()).getDelSubDep2TableObj().readDelSubDep2ByIdIdx( getDelSubDep3Rec().getRequiredDelSubDep2Id() );
				requiredContainerDelSubDep2 = obj;
				if( obj != null ) {
					requiredContainerDelSubDep2 = obj;
				}
			}
		}
		return( requiredContainerDelSubDep2 );
	}

	@Override
	public void setRequiredContainerDelSubDep2( IBusModelDelSubDep2Obj value ) {
		if( rec == null ) {
			getDelSubDep3Rec();
		}
		if( value != null ) {
			requiredContainerDelSubDep2 = value;
			getDelSubDep3Rec().setRequiredContainerDelSubDep2(value.getDelSubDep2Rec());
		}
		requiredContainerDelSubDep2 = value;
	}

	@Override
	public void copyRecToOrig() {
		IBusModelDelSubDep3 origRec = getOrigAsDelSubDep3().getDelSubDep3Rec();
		IBusModelDelSubDep3 myRec = getDelSubDep3Rec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelDelSubDep3 origRec = getOrigAsDelSubDep3().getDelSubDep3Rec();
		IBusModelDelSubDep3 myRec = getDelSubDep3Rec();
		myRec.set( origRec );
	}
}
