// Description: Java 25 edit object instance implementation for BusModel DbKeyHash512Gen.

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

public class BusModelDbKeyHash512GenEditObj
	extends BusModelDbKeyHash512TypeEditObj

	implements IBusModelDbKeyHash512GenEditObj
{

	public BusModelDbKeyHash512GenEditObj( IBusModelDbKeyHash512GenObj argOrig ) {
		super( argOrig );
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)orig.getSchema()).getDbKeyHash512GenTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "DbKeyHash512Gen" );
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
	public IBusModelValueObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		IBusModelDbKeyHash512GenObj retobj = getSchema().getDbKeyHash512GenTableObj().realiseDbKeyHash512Gen( (IBusModelDbKeyHash512GenObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsDbKeyHash512Gen().forget();
	}

	@Override
	public IBusModelValueObj moveUp() {
		throw new YCFCannotMoveEditedObjectException( getClass(),	"moveUp" );
	}

	@Override
	public IBusModelValueObj moveDown() {
		throw new YCFCannotMoveEditedObjectException( getClass(),	"moveDown" );
	}

	@Override
	public IBusModelValueObj create() {
		copyRecToOrig();
		IBusModelDbKeyHash512GenObj retobj = ((IBusModelSchemaObj)getOrigAsDbKeyHash512Gen().getSchema()).getDbKeyHash512GenTableObj().createDbKeyHash512Gen( getOrigAsDbKeyHash512Gen() );
		if( retobj == getOrigAsDbKeyHash512Gen() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelValueEditObj update() {
		getSchema().getDbKeyHash512GenTableObj().updateDbKeyHash512Gen( (IBusModelDbKeyHash512GenObj)this );
		return( null );
	}

	@Override
	public BusModelValueEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getDbKeyHash512GenTableObj().deleteDbKeyHash512Gen( getOrigAsDbKeyHash512Gen() );
		return( null );
	}

	@Override
	public IBusModelDbKeyHash512GenTableObj getDbKeyHash512GenTable() {
		return( orig.getSchema().getDbKeyHash512GenTableObj() );
	}

	@Override
	public IBusModelDbKeyHash512GenEditObj getEditAsDbKeyHash512Gen() {
		return( (IBusModelDbKeyHash512GenEditObj)this );
	}

	@Override
	public IBusModelDbKeyHash512GenObj getOrigAsDbKeyHash512Gen() {
		return( (IBusModelDbKeyHash512GenObj)orig );
	}

	@Override
	public IBusModelValue getRec() {
		if( rec == null ) {
			rec = getOrigAsDbKeyHash512Gen().getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryDbKeyHash512Gen().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelValue value ) {
		if( rec != value ) {
			super.setRec( value );
		}
	}

	@Override
	public IBusModelDbKeyHash512Gen getDbKeyHash512GenRec() {
		return( (IBusModelDbKeyHash512Gen)getRec() );
	}

	@Override
	public IYCFKeyHash256 getRequiredId() {
		return( getPKey() );
	}

	@Override
	public void setRequiredId(IYCFKeyHash256 value) {
		if (getPKey() != value) {
			setPKey(value);
			requiredContainerScope = null;
			optionalLookupDefSchema = null;
			optionalChildrenRefTableCol = null;
			optionalChildrenRefIndexCol = null;
			optionalLookupPrev = null;
			optionalLookupNext = null;
		}
	}

	@Override
	public short getRequiredSlice() {
		return( getDbKeyHash512GenRec().getRequiredSlice() );
	}

	@Override
	public void setRequiredSlice( short value ) {
		if( getDbKeyHash512GenRec().getRequiredSlice() != value ) {
			getDbKeyHash512GenRec().setRequiredSlice( value );
		}
	}

	@Override
	public int getRequiredBlockSize() {
		return( getDbKeyHash512GenRec().getRequiredBlockSize() );
	}

	@Override
	public void setRequiredBlockSize( int value ) {
		if( getDbKeyHash512GenRec().getRequiredBlockSize() != value ) {
			getDbKeyHash512GenRec().setRequiredBlockSize( value );
		}
	}

	@Override
	public void copyRecToOrig() {
		IBusModelDbKeyHash512Gen origRec = getOrigAsDbKeyHash512Gen().getDbKeyHash512GenRec();
		IBusModelDbKeyHash512Gen myRec = getDbKeyHash512GenRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelDbKeyHash512Gen origRec = getOrigAsDbKeyHash512Gen().getDbKeyHash512GenRec();
		IBusModelDbKeyHash512Gen myRec = getDbKeyHash512GenRec();
		myRec.set( origRec );
	}
}
