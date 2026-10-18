// Description: Java 25 base object instance implementation for Int64Type

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

public class BusModelInt64TypeObj
	extends BusModelInt64DefObj
	implements IBusModelInt64TypeObj
{
	protected IBusModelSchemaDefObj requiredContainerSchemaDef;

	public BusModelInt64TypeObj() {
		super();
		requiredContainerSchemaDef = null;
	}

	public BusModelInt64TypeObj( IBusModelSchemaObj argSchema ) {
		super( argSchema );
		requiredContainerSchemaDef = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)schema).getInt64TypeTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "Int64Type" );
	}

	@Override
	public IYCFAnyObj getObjScope() {
		IBusModelSchemaDefObj scope = getRequiredContainerSchemaDef();
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
	public IBusModelValueObj realise() {
		IBusModelInt64TypeObj retobj = ((IBusModelSchemaObj)getSchema()).getInt64TypeTableObj().realiseInt64Type(
			(IBusModelInt64TypeObj)this );
		return( (IBusModelValueObj)retobj );
	}

	@Override
	public void forget() {
		((IBusModelSchemaObj)getSchema()).getInt64TypeTableObj().reallyDeepDisposeInt64Type( (IBusModelInt64TypeObj)this );
	}

	@Override
	public IBusModelValueObj read() {
		IBusModelInt64TypeObj retobj = ((IBusModelSchemaObj)getSchema()).getInt64TypeTableObj().readInt64TypeByIdIdx( getPKey(), false );
		return( (IBusModelValueObj)retobj );
	}

	@Override
	public IBusModelValueObj read( boolean forceRead ) {
		IBusModelInt64TypeObj retobj = ((IBusModelSchemaObj)getSchema()).getInt64TypeTableObj().readInt64TypeByIdIdx( getPKey(), forceRead );
		return( (IBusModelValueObj)retobj );
	}

	@Override
	public IBusModelValueObj moveUp() {
		IBusModelInt64TypeObj retobj = ((IBusModelSchemaObj)getSchema()).getInt64TypeTableObj().moveUpInt64Type( this );
		return( (IBusModelValueObj)retobj );
	}

	@Override
	public IBusModelValueObj moveDown() {
		IBusModelInt64TypeObj retobj = ((IBusModelSchemaObj)getSchema()).getInt64TypeTableObj().moveDownInt64Type( this );
		return( (IBusModelValueObj)retobj );
	}

	@Override
	public IBusModelInt64TypeTableObj getInt64TypeTable() {
		return( ((IBusModelSchemaObj)getSchema()).getInt64TypeTableObj() );
	}

	@Override
	public IBusModelValue getRec() {
		if( rec == null ) {
			if( isNew ) {
				rec = getSchema().getBusModelBackingStore().getBusModelFactory().getFactoryInt64Type().newRec();
			}
			else {
				// Read the data rec via the backing store
				rec = getSchema().getBusModelBackingStore().getTableInt64Type().readDerivedByIdIdx( ((IBusModelSchemaObj)getSchema()).getAuthorization(),
						getPKey() );
				if( rec != null ) {
					copyRecToPKey();
				}
			}
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelValue value ) {
		if( ! ( ( value == null ) || ! ( value instanceof IBusModelInt64Type ) ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRec",
				"value",
				value,
				"BusModelInt64TypeRec" );
		}
		rec = value;
		copyRecToPKey();
		requiredContainerScope = null;
		optionalLookupDefSchema = null;
		optionalLookupPrev = null;
		optionalLookupNext = null;
		requiredContainerSchemaDef = null;
	}

	@Override
	public IBusModelInt64Type getInt64TypeRec() {
		return( (IBusModelInt64Type)getRec() );
	}

	@Override
	public IBusModelValueEditObj beginEdit() {
		if( edit != null ) {
			throw new YCFEditAlreadyOpenException( getClass(), "beginEdit" );
		}
		IBusModelInt64TypeObj lockobj;
		if( getIsNew() ) {
			lockobj = (IBusModelInt64TypeObj)this;
		}
		else {
			lockobj = ((IBusModelSchemaObj)getSchema()).getInt64TypeTableObj().lockInt64Type( getPKey() );
		}
		edit = ((IBusModelSchemaObj)getSchema()).getInt64TypeTableObj().newEditInstance( lockobj );
		return( (IBusModelValueEditObj)edit );
	}

	@Override
	public IBusModelInt64TypeEditObj getEditAsInt64Type() {
		return( (IBusModelInt64TypeEditObj)edit );
	}

	@Override
	public ISecureSecUserObj getCreatedBy() {
		if( createdBy == null ) {
			IBusModelValue rec = getRec();
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
			IBusModelValue rec = getRec();
			updatedBy = ((IBusModelSchemaObj)getSchema()).getSecUserTableObj().readSecUserByIdIdx( rec.getUpdatedByUserId() );
		}
		return( updatedBy );
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( getRec().getUpdatedAt() );
	}

	@Override
	public IYCFKeyHash256 getRequiredId() {
		return( getPKey() );
	}

	@Override
	public IBusModelSchemaDefObj getRequiredContainerSchemaDef() {
		return( getRequiredContainerSchemaDef( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getRequiredContainerSchemaDef( boolean forceRead ) {
		if( ( requiredContainerSchemaDef == null ) || forceRead ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				requiredContainerSchemaDef = ((IBusModelSchemaObj)getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getInt64TypeRec().getRequiredSchemaDefId(), forceRead );
			}
		}
		return( requiredContainerSchemaDef );
	}

	@Override
	public IYCFKeyHash256 getRequiredSchemaDefId() {
		return( getInt64TypeRec().getRequiredSchemaDefId() );
	}
}
