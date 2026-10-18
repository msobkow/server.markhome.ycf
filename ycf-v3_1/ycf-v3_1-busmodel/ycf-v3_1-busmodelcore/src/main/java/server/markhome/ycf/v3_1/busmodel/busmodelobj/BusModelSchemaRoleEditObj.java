// Description: Java 25 edit object instance implementation for BusModel SchemaRole.

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

public class BusModelSchemaRoleEditObj
	extends BusModelRoleDefEditObj

	implements IBusModelSchemaRoleEditObj
{
	protected IBusModelSchemaDefObj requiredContainerSchemaDef;

	public BusModelSchemaRoleEditObj( IBusModelSchemaRoleObj argOrig ) {
		super( argOrig );
		requiredContainerSchemaDef = null;
	}

	@Override
	public int getClassCode() {
		return( ((IBusModelSchemaObj)orig.getSchema()).getSchemaRoleTableObj().getClassCode() );
	}

	@Override
	public String getGenDefName() {
		return( "SchemaRole" );
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
	public IBusModelRoleDefObj realise() {
		// We realise this so that it's record will get copied to orig during realization
		IBusModelSchemaRoleObj retobj = getSchema().getSchemaRoleTableObj().realiseSchemaRole( (IBusModelSchemaRoleObj)this );
		return( retobj );
	}

	@Override
	public void forget() {
		getOrigAsSchemaRole().forget();
	}

	@Override
	public IBusModelRoleDefObj create() {
		copyRecToOrig();
		IBusModelSchemaRoleObj retobj = ((IBusModelSchemaObj)getOrigAsSchemaRole().getSchema()).getSchemaRoleTableObj().createSchemaRole( getOrigAsSchemaRole() );
		if( retobj == getOrigAsSchemaRole() ) {
			copyOrigToRec();
		}
		return( retobj );
	}

	@Override
	public BusModelRoleDefEditObj update() {
		getSchema().getSchemaRoleTableObj().updateSchemaRole( (IBusModelSchemaRoleObj)this );
		return( null );
	}

	@Override
	public BusModelRoleDefEditObj deleteInstance() {
		if( getIsNew() ) {
			throw new YCFCannotDeleteNewInstanceException( getClass(), "delete" );
		}
		getSchema().getSchemaRoleTableObj().deleteSchemaRole( getOrigAsSchemaRole() );
		return( null );
	}

	@Override
	public IBusModelSchemaRoleTableObj getSchemaRoleTable() {
		return( orig.getSchema().getSchemaRoleTableObj() );
	}

	@Override
	public IBusModelSchemaRoleEditObj getEditAsSchemaRole() {
		return( (IBusModelSchemaRoleEditObj)this );
	}

	@Override
	public IBusModelSchemaRoleObj getOrigAsSchemaRole() {
		return( (IBusModelSchemaRoleObj)orig );
	}

	@Override
	public IBusModelRoleDef getRec() {
		if( rec == null ) {
			rec = getOrigAsSchemaRole().getSchema().getBusModelBackingStore().getBusModelFactory().getFactorySchemaRole().newRec();
			rec.set( orig.getRec() );
		}
		return( rec );
	}

	@Override
	public void setRec( IBusModelRoleDef value ) {
		if( rec != value ) {
			super.setRec( value );
			requiredContainerSchemaDef = null;
		}
	}

	@Override
	public IBusModelSchemaRole getSchemaRoleRec() {
		return( (IBusModelSchemaRole)getRec() );
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
	public IYCFKeyHash256 getRequiredSchemaDefId() {
		return( getSchemaRoleRec().getRequiredSchemaDefId() );
	}

	@Override
	public IBusModelPubSchema.RoleScopeEnum getRequiredRoleScope() {
		return( getSchemaRoleRec().getRequiredRoleScope() );
	}

	@Override
	public void setRequiredRoleScope( IBusModelPubSchema.RoleScopeEnum value ) {
		if( getSchemaRoleRec().getRequiredRoleScope() != value ) {
			getSchemaRoleRec().setRequiredRoleScope( value );
		}
	}

	@Override
	public void setRequiredContainerScopeDef( IBusModelScopeObj value ) {
		final String S_ProcName = "BusModelSchemaRoleEditObj.setRequiredContainerScopeDef() ";
		if( value == null ) {
			setRequiredContainerSchemaDef( null );
		}
		else if( ! ( value instanceof IBusModelSchemaDefObj ) ) {
			throw new YCFUnsupportedClassException( getClass(),
				"setRequiredContainerScopeDef",
				"value",
				value,
				"IBusModelSchemaDefObj" );
		}
		else {
			setRequiredContainerSchemaDef( (IBusModelSchemaDefObj)value );
		}
	}

	@Override
	public IBusModelSchemaDefObj getRequiredContainerSchemaDef() {
		return( getRequiredContainerSchemaDef( false ) );
	}

	@Override
	public IBusModelSchemaDefObj getRequiredContainerSchemaDef( boolean forceRead ) {
		if( forceRead || ( requiredContainerSchemaDef == null ) ) {
			boolean anyMissing = false;
			if( ! anyMissing ) {
				IBusModelSchemaDefObj obj = ((IBusModelSchemaObj)getOrigAsSchemaRole().getSchema()).getSchemaDefTableObj().readSchemaDefByIdIdx( getSchemaRoleRec().getRequiredSchemaDefId() );
				requiredContainerSchemaDef = obj;
				if( obj != null ) {
					requiredContainerSchemaDef = obj;
				}
			}
		}
		return( requiredContainerSchemaDef );
	}

	@Override
	public void setRequiredContainerSchemaDef( IBusModelSchemaDefObj value ) {
		if( rec == null ) {
			getSchemaRoleRec();
		}
		if( value != null ) {
			requiredContainerSchemaDef = value;
			getSchemaRoleRec().setRequiredContainerSchemaDef(value.getSchemaDefRec());
		}
		requiredContainerSchemaDef = value;
			super.setRequiredContainerScopeDef( value );
	}

	@Override
	public void copyRecToOrig() {
		IBusModelSchemaRole origRec = getOrigAsSchemaRole().getSchemaRoleRec();
		IBusModelSchemaRole myRec = getSchemaRoleRec();
		origRec.set( myRec );
	}

	@Override
	public void copyOrigToRec() {
		IBusModelSchemaRole origRec = getOrigAsSchemaRole().getSchemaRoleRec();
		IBusModelSchemaRole myRec = getSchemaRoleRec();
		myRec.set( origRec );
	}
}
