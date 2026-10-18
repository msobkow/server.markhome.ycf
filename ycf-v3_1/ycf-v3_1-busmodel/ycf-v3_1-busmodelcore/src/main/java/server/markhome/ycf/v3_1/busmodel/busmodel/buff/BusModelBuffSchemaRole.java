// Description: Java 25 implementation of a SchemaRole buffer

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

package server.markhome.ycf.v3_1.busmodel.busmodel.buff;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
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
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;

public class BusModelBuffSchemaRole
	extends BusModelBuffRoleDef
	implements IBusModelSchemaRole
{
	protected IYCFKeyHash256 requiredSchemaDefId;
	protected IBusModelPubSchema.RoleScopeEnum requiredRoleScope;

	public BusModelBuffSchemaRole() {
		super();
		requiredSchemaDefId = YCFDbKeyHash256.fromHex( IBusModelPubSchemaRole.SCHEMADEFID_INIT_VALUE.toString() );
		requiredRoleScope = IBusModelPubSchemaRole.ROLESCOPE_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( IBusModelSchemaRole.CLASS_CODE );
	}

	@Override
	public void setRequiredContainerScopeDef(IYCFKeyHash256 argSchemaDefId) {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerSchemaDef-args", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelScopeTable targetTable = targetBackingBusModel.getTableScope();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerScopeDef", 0, "IBusModelSchema.getBackingBusModel().getTableScope()");
		}
		IBusModelScope found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argSchemaDefId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerScopeDef-args", 0, "found");
		}
		else if (found instanceof IBusModelSchemaDef) || (found instanceof IBusModelProtSchemaDef) || (found instanceof IBusModelPubSchemaDef)) {
			super.setRequiredContainerScopeDef(argSchemaDefId);
		requiredSchemaDefId = argSchemaDefId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredContainerScopeDef-args", "found", found, "IBusModelSchemaDefIBusModelProtSchemaDefIBusModelPubSchemaDef");
		}
	}

	@Override
	public void setRequiredContainerScopeDef(IBusModelSchemaDef argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerSchemaDef", 1, "argObj");
		}
		else if ((argObj instanceof IBusModelSchemaDef) || (argObj instanceof IBusModelProtSchemaDef) || (argObj instanceof IBusModelPubSchemaDef)) {
			setRequiredSchemaDefId(argObj.getRequiredId());
		else {
			throw new YCFUnsupportedClassException(getClass(), "setContainerSchemaDef", "argObj", argObj, "IBusModelSchemaDef, IBusModelProtSchemaDef), IBusModelPubSchemaDef)");
		}
	}

	@Override
	public void setRequiredContainerScopeDef(IBusModelProtSchemaDef argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerSchemaDef", 1, "argObj");
		}
		else if ((argObj instanceof IBusModelProtSchemaDef) || (argObj instanceof IBusModelPubSchemaDef)) {
			setRequiredSchemaDefId(argObj.getRequiredId());
		else {
			throw new YCFUnsupportedClassException(getClass(), "setContainerSchemaDef", "argObj", argObj, "IBusModelProtSchemaDef, IBusModelPubSchemaDef)");
		}
	}

	@Override
	public void setRequiredContainerScopeDef(IBusModelPubSchemaDef argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerSchemaDef", 1, "argObj");
		}
		else if (argObj instanceof IBusModelPubSchemaDef) {
			setRequiredSchemaDefId(argObj.getRequiredId());
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setContainerSchemaDef", "argObj", argObj, "IBusModelPubSchemaDef");
		}
	}

	@Override
	public IBusModelSchemaDef getRequiredContainerSchemaDef() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerSchemaDef", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelSchemaDefTable targetTable = targetBackingBusModel.getTableSchemaDef();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerSchemaDef", 0, "IBusModelSchema.getBackingBusModel().getTableSchemaDef()");
		}
		IBusModelSchemaDef targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredSchemaDefId());
		return(targetRec);
	}

	@Override
	public IBusModelSchemaDef getRequiredContainerSchemaDef() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerSchemaDef", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelSchemaDefTable targetTable = targetBackingBusModel.getTableSchemaDef();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerSchemaDef", 0, "IBusModelSchema.getBackingBusModel().getTableSchemaDef()");
		}
		IBusModelSchemaDef targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredSchemaDefId());
		return(targetRec);
	}

	@Override
	public IBusModelSchemaDef getRequiredContainerSchemaDef() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerSchemaDef", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelSchemaDefTable targetTable = targetBackingBusModel.getTableSchemaDef();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerSchemaDef", 0, "IBusModelSchema.getBackingBusModel().getTableSchemaDef()");
		}
		IBusModelPubSchemaDef targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredSchemaDefId());
		return(targetRec);
	}

	@Override
	public void setRequiredContainerScopeDef(IYCFKeyHash256 argSchemaDefId) {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerSchemaDef-args", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelScopeTable targetTable = targetBackingBusModel.getTableScope();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerScopeDef", 0, "IBusModelSchema.getBackingBusModel().getTableScope()");
		}
		IBusModelScope found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argSchemaDefId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerScopeDef-args", 0, "found");
		}
		else if (found instanceof IBusModelSchemaDef) || (found instanceof IBusModelProtSchemaDef) || (found instanceof IBusModelPubSchemaDef)) {
			super.setRequiredContainerScopeDef(argSchemaDefId);
		requiredSchemaDefId = argSchemaDefId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredContainerScopeDef-args", "found", found, "IBusModelSchemaDefIBusModelProtSchemaDefIBusModelPubSchemaDef");
		}
	}

	@Override
	public void setRequiredContainerSchemaDef(IYCFKeyHash256 argSchemaDefId) {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerSchemaDef-args", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelScopeTable targetTable = targetBackingBusModel.getTableScope();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerScopeDef", 0, "IBusModelSchema.getBackingBusModel().getTableScope()");
		}
		IBusModelScope found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argSchemaDefId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerScopeDef-args", 0, "found");
		}
		else if (found instanceof IBusModelSchemaDef) || (found instanceof IBusModelProtSchemaDef) || (found instanceof IBusModelPubSchemaDef)) {
			super.setRequiredContainerScopeDef(argSchemaDefId);
		requiredSchemaDefId = argSchemaDefId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredContainerScopeDef-args", "found", found, "IBusModelSchemaDefIBusModelProtSchemaDefIBusModelPubSchemaDef");
		}
	}

	@Override
	public void setRequiredContainerSchemaDef(IBusModelSchemaDef argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerSchemaDef", 1, "argObj");
		}
		else {
			setRequiredSchemaDefId(argObj.getRequiredId());
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredSchemaDefId() {
		return(requiredSchemaDefId);
	}

	public void setRequiredSchemaDefId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredSchemaDefId",
				1,
				"value" );
		}
		requiredSchemaDefId = value;
	}

	@Override
	public IBusModelPubSchema.RoleScopeEnum getRequiredRoleScope() {
		return(requiredRoleScope);
	}

	public void setRequiredRoleScope( IBusModelPubSchema.RoleScopeEnum value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredRoleScope",
				1,
				"value" );
		}
		requiredRoleScope = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof IBusModelSchemaRole rhs ) {
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			if( getRequiredRoleScope() != null ) {
				if( rhs.getRequiredRoleScope() != null ) {
					if( ! getRequiredRoleScope().equals( rhs.getRequiredRoleScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRoleScope() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelSchemaRoleH rhs ) {
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			if( getRequiredRoleScope() != null ) {
				if( rhs.getRequiredRoleScope() != null ) {
					if( ! getRequiredRoleScope().equals( rhs.getRequiredRoleScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRoleScope() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelRoleDefHPKey ) {
			IBusModelRoleDefHPKey rhs = (IBusModelRoleDefHPKey)obj;
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelSchemaRoleBySchemaIdxKey rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelSchemaRoleByRoleScopeIdxKey rhs ) {
			if( getRequiredRoleScope() != null ) {
				if( rhs.getRequiredRoleScope() != null ) {
					if( ! getRequiredRoleScope().equals( rhs.getRequiredRoleScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRoleScope() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelSchemaRoleBySchRoleScpIdxKey rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			if( getRequiredRoleScope() != null ) {
				if( rhs.getRequiredRoleScope() != null ) {
					if( ! getRequiredRoleScope().equals( rhs.getRequiredRoleScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRoleScope() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtSchemaRole rhs ) {
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			if( getRequiredRoleScope() != null ) {
				if( rhs.getRequiredRoleScope() != null ) {
					if( ! getRequiredRoleScope().equals( rhs.getRequiredRoleScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRoleScope() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtSchemaRoleH rhs ) {
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			if( getRequiredRoleScope() != null ) {
				if( rhs.getRequiredRoleScope() != null ) {
					if( ! getRequiredRoleScope().equals( rhs.getRequiredRoleScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRoleScope() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRoleDefHPKey rhs ) {
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelSchemaRoleBySchemaIdxKey rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelSchemaRoleByRoleScopeIdxKey rhs ) {
			if( getRequiredRoleScope() != null ) {
				if( rhs.getRequiredRoleScope() != null ) {
					if( ! getRequiredRoleScope().equals( rhs.getRequiredRoleScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRoleScope() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelSchemaRoleBySchRoleScpIdxKey rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			if( getRequiredRoleScope() != null ) {
				if( rhs.getRequiredRoleScope() != null ) {
					if( ! getRequiredRoleScope().equals( rhs.getRequiredRoleScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRoleScope() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubSchemaRole rhs ) {
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			if( getRequiredRoleScope() != null ) {
				if( rhs.getRequiredRoleScope() != null ) {
					if( ! getRequiredRoleScope().equals( rhs.getRequiredRoleScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRoleScope() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubSchemaRoleH rhs ) {
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			if( getRequiredRoleScope() != null ) {
				if( rhs.getRequiredRoleScope() != null ) {
					if( ! getRequiredRoleScope().equals( rhs.getRequiredRoleScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRoleScope() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubRoleDefHPKey rhs ) {
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelSchemaRoleBySchemaIdxKey rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelSchemaRoleByRoleScopeIdxKey rhs ) {
			if( getRequiredRoleScope() != null ) {
				if( rhs.getRequiredRoleScope() != null ) {
					if( ! getRequiredRoleScope().equals( rhs.getRequiredRoleScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRoleScope() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelSchemaRoleBySchRoleScpIdxKey rhs ) {
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			if( getRequiredRoleScope() != null ) {
				if( rhs.getRequiredRoleScope() != null ) {
					if( ! getRequiredRoleScope().equals( rhs.getRequiredRoleScope() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRoleScope() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = hashCode + getRequiredSchemaDefId().hashCode();
		hashCode = ( hashCode * 0x10000 ) + getRequiredRoleScope().ordinal();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof IBusModelSchemaRole rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}
			if (getRequiredRoleScope() != null) {
				if (rhs.getRequiredRoleScope() != null) {
					cmp = getRequiredRoleScope().compareTo( rhs.getRequiredRoleScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRoleScope() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelRoleDefHPKey rhs ) {
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if (getRequiredId() != null) {
				if (rhs.getRequiredId() != null) {
					cmp = getRequiredId().compareTo( rhs.getRequiredId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelSchemaRoleH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}
			if (getRequiredRoleScope() != null) {
				if (rhs.getRequiredRoleScope() != null) {
					cmp = getRequiredRoleScope().compareTo( rhs.getRequiredRoleScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRoleScope() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelSchemaRoleBySchemaIdxKey rhs ) {
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelSchemaRoleByRoleScopeIdxKey rhs ) {
			if (getRequiredRoleScope() != null) {
				if (rhs.getRequiredRoleScope() != null) {
					cmp = getRequiredRoleScope().compareTo( rhs.getRequiredRoleScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRoleScope() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelSchemaRoleBySchRoleScpIdxKey rhs ) {
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}
			if (getRequiredRoleScope() != null) {
				if (rhs.getRequiredRoleScope() != null) {
					cmp = getRequiredRoleScope().compareTo( rhs.getRequiredRoleScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRoleScope() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtSchemaRole rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}
			if (getRequiredRoleScope() != null) {
				if (rhs.getRequiredRoleScope() != null) {
					cmp = getRequiredRoleScope().compareTo( rhs.getRequiredRoleScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRoleScope() != null) {
				return( -1 );
			}
			return( 0 );
 		}
		else if( obj instanceof IBusModelProtRoleDefHPKey rhs ) {
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if (getRequiredId() != null) {
				if (rhs.getRequiredId() != null) {
					cmp = getRequiredId().compareTo( rhs.getRequiredId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelProtSchemaRoleH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}
			if (getRequiredRoleScope() != null) {
				if (rhs.getRequiredRoleScope() != null) {
					cmp = getRequiredRoleScope().compareTo( rhs.getRequiredRoleScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRoleScope() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelProtSchemaRoleBySchemaIdxKey rhs ) {
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtSchemaRoleByRoleScopeIdxKey rhs ) {
			if (getRequiredRoleScope() != null) {
				if (rhs.getRequiredRoleScope() != null) {
					cmp = getRequiredRoleScope().compareTo( rhs.getRequiredRoleScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRoleScope() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtSchemaRoleBySchRoleScpIdxKey rhs ) {
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}
			if (getRequiredRoleScope() != null) {
				if (rhs.getRequiredRoleScope() != null) {
					cmp = getRequiredRoleScope().compareTo( rhs.getRequiredRoleScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRoleScope() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubSchemaRole rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}
			if (getRequiredRoleScope() != null) {
				if (rhs.getRequiredRoleScope() != null) {
					cmp = getRequiredRoleScope().compareTo( rhs.getRequiredRoleScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRoleScope() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelPubRoleDefHPKey rhs ) {
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if (getRequiredId() != null) {
				if (rhs.getRequiredId() != null) {
					cmp = getRequiredId().compareTo( rhs.getRequiredId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelPubSchemaRoleH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}
			if (getRequiredRoleScope() != null) {
				if (rhs.getRequiredRoleScope() != null) {
					cmp = getRequiredRoleScope().compareTo( rhs.getRequiredRoleScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRoleScope() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelPubSchemaRoleBySchemaIdxKey rhs ) {
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubSchemaRoleByRoleScopeIdxKey rhs ) {
			if (getRequiredRoleScope() != null) {
				if (rhs.getRequiredRoleScope() != null) {
					cmp = getRequiredRoleScope().compareTo( rhs.getRequiredRoleScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRoleScope() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubSchemaRoleBySchRoleScpIdxKey rhs ) {
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}
			if (getRequiredRoleScope() != null) {
				if (rhs.getRequiredRoleScope() != null) {
					cmp = getRequiredRoleScope().compareTo( rhs.getRequiredRoleScope() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRoleScope() != null) {
				return( -1 );
			}			return( 0 );
		}
		else {
			cmp = super.compareTo( obj );
			return( cmp );
		}
	}

	@Override
	public void set( IBusModelRoleDef src ) {
		if( src instanceof BusModelBuffSchemaRole ) {
			setSchemaRole( (BusModelBuffSchemaRole)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelBuffSchemaRole" );
		}
	}

	@Override
	public void setSchemaRole( IBusModelSchemaRole src ) {
		super.setRoleDef( src );
		setRequiredContainerSchemaDef(src.getRequiredContainerSchemaDef());
		setRequiredSchemaDefId(src.getRequiredSchemaDefId());
		setRequiredRoleScope(src.getRequiredRoleScope());
	}

	@Override
	public void set( IBusModelRoleDefH src ) {
		if( src instanceof IBusModelSchemaRoleH ) {
			setSchemaRole( (IBusModelSchemaRoleH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelSchemaRoleH" );
		}
	}

	@Override
	public void setSchemaRole( IBusModelSchemaRoleH src ) {
		super.setRoleDef( src );
		setRequiredContainerSchemaDef(src.getRequiredContainerSchemaDef());
		setRequiredSchemaDefId(src.getRequiredSchemaDefId());
		setRequiredRoleScope(src.getRequiredRoleScope());
	}

	@Override
	public void set( IBusModelProtRoleDef src ) {
		if( src instanceof BusModelProtBuffSchemaRole ) {
			setSchemaRole( (BusModelProtBuffSchemaRole)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelProtBuffSchemaRole" );
		}
	}

	@Override
	public void setSchemaRole( IBusModelProtSchemaRole src ) {
		super.setRoleDef( src );
		setRequiredContainerSchemaDef(src.getRequiredContainerSchemaDef());
		setRequiredSchemaDefId(src.getRequiredSchemaDefId());
		setRequiredRoleScope(src.getRequiredRoleScope());
	}

	@Override
	public void set( IBusModelProtRoleDefH src ) {
		if( src instanceof IBusModelProtSchemaRoleH ) {
			setSchemaRole( (IBusModelProtSchemaRoleH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelProtSchemaRoleH" );
		}
	}

	@Override
	public void setSchemaRole( IBusModelProtSchemaRoleH src ) {
		super.setRoleDef( src );
		setRequiredContainerSchemaDef(src.getRequiredContainerSchemaDef());
		setRequiredSchemaDefId(src.getRequiredSchemaDefId());
		setRequiredRoleScope(src.getRequiredRoleScope());
	}

	@Override
	public void set( IBusModelPubRoleDef src ) {
		if( src instanceof BusModelPubBuffSchemaRole ) {
			setSchemaRole( (BusModelPubBuffSchemaRole)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelPubBuffSchemaRole" );
		}
	}

	@Override
	public void setSchemaRole( IBusModelPubSchemaRole src ) {
		super.setRoleDef( src );
		setRequiredContainerSchemaDef(src.getRequiredContainerSchemaDef());
		setRequiredSchemaDefId(src.getRequiredSchemaDefId());
		setRequiredRoleScope(src.getRequiredRoleScope());
	}

	@Override
	public void set( IBusModelPubRoleDefH src ) {
		if( src instanceof IBusModelPubSchemaRoleH ) {
			setSchemaRole( (IBusModelPubSchemaRoleH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubSchemaRoleH" );
		}
	}

	@Override
	public void setSchemaRole( IBusModelPubSchemaRoleH src ) {
		super.setRoleDef( src );
		setRequiredContainerSchemaDef(src.getRequiredContainerSchemaDef());
		setRequiredSchemaDefId(src.getRequiredSchemaDefId());
		setRequiredRoleScope(src.getRequiredRoleScope());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment() 
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredSchemaDefId=" + "\"" + getRequiredSchemaDefId().toString() + "\""
			+ " RequiredRoleScope=" + "\"" + getRequiredRoleScope().toString() + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelBuffSchemaRole" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
