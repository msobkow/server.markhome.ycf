// Description: Java 25 implementation of a RoleDef buffer

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

public class BusModelBuffRoleDef
	implements IBusModelRoleDef, Comparable<Object>, Serializable
{
	protected IYCFKeyHash256 requiredId;
	protected int requiredRevision;
	protected YCFDbKeyHash256 createdByUserId = YCFDbKeyHash256.fromHex(IBusModelPubSecUser.S_INIT_CREATED_BY);
	protected YCFDbKeyHash256 createdBySessionId = YCFDbKeyHash256.fromHex(IBusModelPubSecSession.S_SECSESSIONID_INIT_VALUE);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected YCFDbKeyHash256 updatedByUserId = YCFDbKeyHash256.fromHex(IBusModelPubSecUser.S_INIT_UPDATED_BY);
	protected YCFDbKeyHash256 updatedBySessionId = YCFDbKeyHash256.fromHex(IBusModelPubSecSession.S_SECSESSIONID_INIT_VALUE);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected IYCFKeyHash256 requiredScopeId;
	protected IYCFKeyHash256 optionalDefSchemaId;
	protected String requiredName;
	protected String requiredEnables;
	protected String requiredIncludes;

	public BusModelBuffRoleDef() {
		requiredId = YCFDbKeyHash256.fromHex( IBusModelPubRoleDef.ID_INIT_VALUE.toString() );
		requiredScopeId = YCFDbKeyHash256.fromHex( IBusModelPubRoleDef.SCOPEID_INIT_VALUE.toString() );
		optionalDefSchemaId = YCFDbKeyHash256.nullGet();
		requiredName = IBusModelPubRoleDef.NAME_INIT_VALUE;
		requiredEnables = IBusModelPubRoleDef.ENABLES_INIT_VALUE;
		requiredIncludes = IBusModelPubRoleDef.INCLUDES_INIT_VALUE;
	}

	@Override
	public $implCommaIJavaOptAtomType$ getPKey() {
		return (requiredId);
	}

	@Override
	public void setPKey($implCommaIJavaOptAtomType$ requiredId) {
		if(requiredId != null) {
			this.requiredId = requiredId;
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredId() {
		return(requiredId);
	}

	public void setRequiredId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredId",
				1,
				"value" );
		}
		requiredId = value;
	}

	@Override
	public YCFDbKeyHash256 getCreatedByUserId() {
		return( createdByUserId );
	}

	@Override
	public void setCreatedByUserId( YCFDbKeyHash256 value ) {
		createdByUserId = value;
	}

	@Override
	public LocalDateTime getCreatedAt() {
		return( createdAt );
	}

	@Override
	public void setCreatedAt( LocalDateTime value ) {
		createdAt = value;
	}

	@Override
	public YCFDbKeyHash256 getUpdatedByUserId() {
		return( updatedByUserId );
	}

	@Override
	public void setUpdatedByUserId( YCFDbKeyHash256 value ) {
		updatedByUserId = value;
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( updatedAt );
	}

	@Override
	public void setUpdatedAt( LocalDateTime value ) {
		updatedAt = value;
	}

	@Override
	public int getRequiredRevision() {
		return( requiredRevision );
	}

	@Override
	public void setRequiredRevision( int value ) {
		requiredRevision = value;
	}

	@Override
	public int getClassCode() {
		return( IBusModelRoleDef.CLASS_CODE );
	}

	@Override
	public IBusModelScope getRequiredContainerScopeDef() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerScopeDef", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelScopeTable targetTable = targetBackingBusModel.getTableScope();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerScopeDef", 0, "IBusModelSchema.getBackingBusModel().getTableScope()");
		}
		IBusModelScope targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredScopeId());
		return(targetRec);
	}

	@Override
	public IBusModelScope getRequiredContainerScopeDef() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerScopeDef", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelScopeTable targetTable = targetBackingBusModel.getTableScope();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerScopeDef", 0, "IBusModelSchema.getBackingBusModel().getTableScope()");
		}
		IBusModelScope targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredScopeId());
		return(targetRec);
	}

	@Override
	public IBusModelScope getRequiredContainerScopeDef() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerScopeDef", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelScopeTable targetTable = targetBackingBusModel.getTableScope();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerScopeDef", 0, "IBusModelSchema.getBackingBusModel().getTableScope()");
		}
		IBusModelPubScope targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredScopeId());
		return(targetRec);
	}

	@Override
	public void setRequiredContainerScopeDef(IYCFKeyHash256 argScopeId) {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerScopeDef-args", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelScopeTable targetTable = targetBackingBusModel.getTableScope();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerScopeDef", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelScope found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argScopeId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerScopeDef-args", 0, "found");
		}
		else if ((found instanceof IBusModelScope) || (found instanceof IBusModelProtScope) || (found instanceof IBusModelPubScope)) {
		requiredScopeId = argScopeId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredContainerScopeDef-args", "found", found, "IBusModelScopeIBusModelProtScopeIBusModelPubScope");
		}
	}

	@Override
	public void setRequiredContainerScopeDef(IBusModelScope argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerScopeDef", 1, "argObj");
		}
		else {
			setRequiredScopeId(argObj.getRequiredId());
		}
	}

	@Override
	public IBusModelSchemaDef getOptionalLookupDefSchema() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupDefSchema", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelSchemaDefTable targetTable = targetBackingBusModel.getTableSchemaDef();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupDefSchema", 0, "IBusModelSchema.getBackingBusModel().getTableSchemaDef()");
		}
		IBusModelSchemaDef targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getOptionalDefSchemaId());
		return(targetRec);
	}

	@Override
	public IBusModelSchemaDef getOptionalLookupDefSchema() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupDefSchema", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelSchemaDefTable targetTable = targetBackingBusModel.getTableSchemaDef();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupDefSchema", 0, "IBusModelSchema.getBackingBusModel().getTableSchemaDef()");
		}
		IBusModelSchemaDef targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getOptionalDefSchemaId());
		return(targetRec);
	}

	@Override
	public IBusModelSchemaDef getOptionalLookupDefSchema() {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupDefSchema", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelSchemaDefTable targetTable = targetBackingBusModel.getTableSchemaDef();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalLookupDefSchema", 0, "IBusModelSchema.getBackingBusModel().getTableSchemaDef()");
		}
		IBusModelPubSchemaDef targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getOptionalDefSchemaId());
		return(targetRec);
	}

	@Override
	public void setOptionalLookupDefSchema(IYCFKeyHash256 argDefSchemaId) {
		IBusModelSchema targetBackingBusModel = IBusModelSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupDefSchema-args", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelSchemaDefTable targetTable = targetBackingBusModel.getTableSchemaDef();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupDefSchema", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelSchemaDef found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argDefSchemaId);
		if (found == null || (found != null && ((found instanceof IBusModelSchemaDef) || (found instanceof IBusModelProtSchemaDef) || (found instanceof IBusModelPubSchemaDef)))) {
		optionalDefSchemaId = argDefSchemaId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setOptionalLookupDefSchema-args", "found", found, "IBusModelSchemaDefIBusModelProtSchemaDefIBusModelPubSchemaDef");
		}
	}

	@Override
	public void setOptionalLookupDefSchema(IBusModelSchemaDef argObj) {
		if(argObj == null) {
			setOptionalDefSchemaId(null);
		}
		else {
			setOptionalDefSchemaId(argObj.getRequiredId());
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredScopeId() {
		return(requiredScopeId);
	}

	public void setRequiredScopeId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredScopeId",
				1,
				"value" );
		}
		requiredScopeId = value;
	}

	@Override
	public IYCFKeyHash256 getOptionalDefSchemaId() {
		return(optionalDefSchemaId);
	}

	public void setOptionalDefSchemaId( IYCFKeyHash256 value ) {
		optionalDefSchemaId = value;
	}

	@Override
	public String getRequiredName() {
		return(requiredName);
	}

	public void setRequiredName( String value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredName",
				1,
				"value" );
		}
		else if( value.length() > 192 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				192 );
		}
		requiredName = value;
	}

	@Override
	public String getRequiredEnables() {
		return(requiredEnables);
	}

	public void setRequiredEnables( String value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredEnables",
				1,
				"value" );
		}
		else if( value.length() > 2000000 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredEnables",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		requiredEnables = value;
	}

	@Override
	public String getRequiredIncludes() {
		return(requiredIncludes);
	}

	public void setRequiredIncludes( String value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredIncludes",
				1,
				"value" );
		}
		else if( value.length() > 2000000 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredIncludes",
				1,
				"value.length()",
				value.length(),
				2000000 );
		}
		requiredIncludes = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof IBusModelRoleDef rhs ) {
			if( ! getCreatedByUserId().equals( rhs.getCreatedByUserId() ) ) {
				return( false );
			}
			if( ! getCreatedAt().equals( rhs.getCreatedAt() ) ) {
				return( false );
			}
			if( ! getUpdatedByUserId().equals( rhs.getUpdatedByUserId() ) ) {
				return( false );
			}
			if( ! getUpdatedAt().equals( rhs.getUpdatedAt() ) ) {
				return( false );
			}
			if( getRequiredScopeId() != null ) {
				if( rhs.getRequiredScopeId() != null ) {
					if( ! getRequiredScopeId().equals( rhs.getRequiredScopeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredScopeId() != null ) {
					return( false );
				}
			}
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
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getRequiredEnables() != null ) {
				if( rhs.getRequiredEnables() != null ) {
					if( ! getRequiredEnables().equals( rhs.getRequiredEnables() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnables() != null ) {
					return( false );
				}
			}
			if( getRequiredIncludes() != null ) {
				if( rhs.getRequiredIncludes() != null ) {
					if( ! getRequiredIncludes().equals( rhs.getRequiredIncludes() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIncludes() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelRoleDefH rhs ) {
			if( getRequiredScopeId() != null ) {
				if( rhs.getRequiredScopeId() != null ) {
					if( ! getRequiredScopeId().equals( rhs.getRequiredScopeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredScopeId() != null ) {
					return( false );
				}
			}
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
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getRequiredEnables() != null ) {
				if( rhs.getRequiredEnables() != null ) {
					if( ! getRequiredEnables().equals( rhs.getRequiredEnables() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnables() != null ) {
					return( false );
				}
			}
			if( getRequiredIncludes() != null ) {
				if( rhs.getRequiredIncludes() != null ) {
					if( ! getRequiredIncludes().equals( rhs.getRequiredIncludes() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIncludes() != null ) {
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
		else if( obj instanceof IBusModelRoleDefByUNameIdxKey rhs ) {
			if( getRequiredScopeId() != null ) {
				if( rhs.getRequiredScopeId() != null ) {
					if( ! getRequiredScopeId().equals( rhs.getRequiredScopeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredScopeId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelRoleDefByScopeIdxKey rhs ) {
			if( getRequiredScopeId() != null ) {
				if( rhs.getRequiredScopeId() != null ) {
					if( ! getRequiredScopeId().equals( rhs.getRequiredScopeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredScopeId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelRoleDefByDefSchemaIdxKey rhs ) {
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelRoleDefByUDefIdxKey rhs ) {
			if( getRequiredScopeId() != null ) {
				if( rhs.getRequiredScopeId() != null ) {
					if( ! getRequiredScopeId().equals( rhs.getRequiredScopeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredScopeId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRoleDef rhs ) {
			if( ! getCreatedByUserId().equals( rhs.getCreatedByUserId() ) ) {
				return( false );
			}
			if( ! getCreatedAt().equals( rhs.getCreatedAt() ) ) {
				return( false );
			}
			if( ! getUpdatedByUserId().equals( rhs.getUpdatedByUserId() ) ) {
				return( false );
			}
			if( ! getUpdatedAt().equals( rhs.getUpdatedAt() ) ) {
				return( false );
			}
			if( getRequiredScopeId() != null ) {
				if( rhs.getRequiredScopeId() != null ) {
					if( ! getRequiredScopeId().equals( rhs.getRequiredScopeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredScopeId() != null ) {
					return( false );
				}
			}
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
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getRequiredEnables() != null ) {
				if( rhs.getRequiredEnables() != null ) {
					if( ! getRequiredEnables().equals( rhs.getRequiredEnables() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnables() != null ) {
					return( false );
				}
			}
			if( getRequiredIncludes() != null ) {
				if( rhs.getRequiredIncludes() != null ) {
					if( ! getRequiredIncludes().equals( rhs.getRequiredIncludes() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIncludes() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelProtRoleDefH rhs ) {
			if( getRequiredScopeId() != null ) {
				if( rhs.getRequiredScopeId() != null ) {
					if( ! getRequiredScopeId().equals( rhs.getRequiredScopeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredScopeId() != null ) {
					return( false );
				}
			}
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
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getRequiredEnables() != null ) {
				if( rhs.getRequiredEnables() != null ) {
					if( ! getRequiredEnables().equals( rhs.getRequiredEnables() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnables() != null ) {
					return( false );
				}
			}
			if( getRequiredIncludes() != null ) {
				if( rhs.getRequiredIncludes() != null ) {
					if( ! getRequiredIncludes().equals( rhs.getRequiredIncludes() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIncludes() != null ) {
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
		else if( obj instanceof IBusModelRoleDefByUNameIdxKey rhs ) {
			if( getRequiredScopeId() != null ) {
				if( rhs.getRequiredScopeId() != null ) {
					if( ! getRequiredScopeId().equals( rhs.getRequiredScopeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredScopeId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelRoleDefByScopeIdxKey rhs ) {
			if( getRequiredScopeId() != null ) {
				if( rhs.getRequiredScopeId() != null ) {
					if( ! getRequiredScopeId().equals( rhs.getRequiredScopeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredScopeId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelRoleDefByDefSchemaIdxKey rhs ) {
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelRoleDefByUDefIdxKey rhs ) {
			if( getRequiredScopeId() != null ) {
				if( rhs.getRequiredScopeId() != null ) {
					if( ! getRequiredScopeId().equals( rhs.getRequiredScopeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredScopeId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubRoleDef rhs ) {
			if( ! getCreatedByUserId().equals( rhs.getCreatedByUserId() ) ) {
				return( false );
			}
			if( ! getCreatedAt().equals( rhs.getCreatedAt() ) ) {
				return( false );
			}
			if( ! getUpdatedByUserId().equals( rhs.getUpdatedByUserId() ) ) {
				return( false );
			}
			if( ! getUpdatedAt().equals( rhs.getUpdatedAt() ) ) {
				return( false );
			}
			if( getRequiredScopeId() != null ) {
				if( rhs.getRequiredScopeId() != null ) {
					if( ! getRequiredScopeId().equals( rhs.getRequiredScopeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredScopeId() != null ) {
					return( false );
				}
			}
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
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getRequiredEnables() != null ) {
				if( rhs.getRequiredEnables() != null ) {
					if( ! getRequiredEnables().equals( rhs.getRequiredEnables() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnables() != null ) {
					return( false );
				}
			}
			if( getRequiredIncludes() != null ) {
				if( rhs.getRequiredIncludes() != null ) {
					if( ! getRequiredIncludes().equals( rhs.getRequiredIncludes() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIncludes() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubRoleDefH rhs ) {
			if( getRequiredScopeId() != null ) {
				if( rhs.getRequiredScopeId() != null ) {
					if( ! getRequiredScopeId().equals( rhs.getRequiredScopeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredScopeId() != null ) {
					return( false );
				}
			}
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
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			if( getRequiredEnables() != null ) {
				if( rhs.getRequiredEnables() != null ) {
					if( ! getRequiredEnables().equals( rhs.getRequiredEnables() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnables() != null ) {
					return( false );
				}
			}
			if( getRequiredIncludes() != null ) {
				if( rhs.getRequiredIncludes() != null ) {
					if( ! getRequiredIncludes().equals( rhs.getRequiredIncludes() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIncludes() != null ) {
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
		else if( obj instanceof IBusModelRoleDefByUNameIdxKey rhs ) {
			if( getRequiredScopeId() != null ) {
				if( rhs.getRequiredScopeId() != null ) {
					if( ! getRequiredScopeId().equals( rhs.getRequiredScopeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredScopeId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelRoleDefByScopeIdxKey rhs ) {
			if( getRequiredScopeId() != null ) {
				if( rhs.getRequiredScopeId() != null ) {
					if( ! getRequiredScopeId().equals( rhs.getRequiredScopeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredScopeId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelRoleDefByDefSchemaIdxKey rhs ) {
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelRoleDefByUDefIdxKey rhs ) {
			if( getRequiredScopeId() != null ) {
				if( rhs.getRequiredScopeId() != null ) {
					if( ! getRequiredScopeId().equals( rhs.getRequiredScopeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredScopeId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
			if( getRequiredName() != null ) {
				if( rhs.getRequiredName() != null ) {
					if( ! getRequiredName().equals( rhs.getRequiredName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			return( false );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		hashCode = hashCode + getCreatedByUserId().hashCode();
		hashCode = hashCode + getCreatedAt().hashCode();
		hashCode = hashCode + getUpdatedByUserId().hashCode();
		hashCode = hashCode + getUpdatedAt().hashCode();
		hashCode = hashCode + getRequiredScopeId().hashCode();
		hashCode = hashCode + getRequiredId().hashCode();
		if( getOptionalDefSchemaId() != null ) {
			hashCode = hashCode + getOptionalDefSchemaId().hashCode();
		}
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getRequiredEnables() != null ) {
			hashCode = hashCode + getRequiredEnables().hashCode();
		}
		if( getRequiredIncludes() != null ) {
			hashCode = hashCode + getRequiredIncludes().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof IBusModelRoleDef rhs ) {
			cmp = 0;
			{
				cmp = getCreatedByUserId().compareTo( rhs.getCreatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getCreatedAt().compareTo( rhs.getCreatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedByUserId().compareTo( rhs.getUpdatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedAt().compareTo( rhs.getUpdatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if (getRequiredScopeId() != null) {
				if (rhs.getRequiredScopeId() != null) {
					cmp = getRequiredScopeId().compareTo( rhs.getRequiredScopeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredScopeId() != null) {
				return( -1 );
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
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if (getRequiredEnables() != null) {
				if (rhs.getRequiredEnables() != null) {
					cmp = getRequiredEnables().compareTo( rhs.getRequiredEnables() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnables() != null) {
				return( -1 );
			}
			if (getRequiredIncludes() != null) {
				if (rhs.getRequiredIncludes() != null) {
					cmp = getRequiredIncludes().compareTo( rhs.getRequiredIncludes() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIncludes() != null) {
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
		else if( obj instanceof IBusModelRoleDefH rhs ) {
			cmp = 0;
			if (getRequiredScopeId() != null) {
				if (rhs.getRequiredScopeId() != null) {
					cmp = getRequiredScopeId().compareTo( rhs.getRequiredScopeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredScopeId() != null) {
				return( -1 );
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
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if (getRequiredEnables() != null) {
				if (rhs.getRequiredEnables() != null) {
					cmp = getRequiredEnables().compareTo( rhs.getRequiredEnables() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnables() != null) {
				return( -1 );
			}
			if (getRequiredIncludes() != null) {
				if (rhs.getRequiredIncludes() != null) {
					cmp = getRequiredIncludes().compareTo( rhs.getRequiredIncludes() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIncludes() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelRoleDefByUNameIdxKey rhs ) {
			if (getRequiredScopeId() != null) {
				if (rhs.getRequiredScopeId() != null) {
					cmp = getRequiredScopeId().compareTo( rhs.getRequiredScopeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredScopeId() != null) {
				return( -1 );
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelRoleDefByScopeIdxKey rhs ) {
			if (getRequiredScopeId() != null) {
				if (rhs.getRequiredScopeId() != null) {
					cmp = getRequiredScopeId().compareTo( rhs.getRequiredScopeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredScopeId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelRoleDefByDefSchemaIdxKey rhs ) {
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof IBusModelRoleDefByUDefIdxKey rhs ) {
			if (getRequiredScopeId() != null) {
				if (rhs.getRequiredScopeId() != null) {
					cmp = getRequiredScopeId().compareTo( rhs.getRequiredScopeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredScopeId() != null) {
				return( -1 );
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtRoleDef rhs ) {
			cmp = 0;
			{
				cmp = getCreatedByUserId().compareTo( rhs.getCreatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getCreatedAt().compareTo( rhs.getCreatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedByUserId().compareTo( rhs.getUpdatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedAt().compareTo( rhs.getUpdatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if (getRequiredScopeId() != null) {
				if (rhs.getRequiredScopeId() != null) {
					cmp = getRequiredScopeId().compareTo( rhs.getRequiredScopeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredScopeId() != null) {
				return( -1 );
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
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if (getRequiredEnables() != null) {
				if (rhs.getRequiredEnables() != null) {
					cmp = getRequiredEnables().compareTo( rhs.getRequiredEnables() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnables() != null) {
				return( -1 );
			}
			if (getRequiredIncludes() != null) {
				if (rhs.getRequiredIncludes() != null) {
					cmp = getRequiredIncludes().compareTo( rhs.getRequiredIncludes() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIncludes() != null) {
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
		else if( obj instanceof IBusModelProtRoleDefH rhs ) {
			cmp = 0;
			if (getRequiredScopeId() != null) {
				if (rhs.getRequiredScopeId() != null) {
					cmp = getRequiredScopeId().compareTo( rhs.getRequiredScopeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredScopeId() != null) {
				return( -1 );
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
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if (getRequiredEnables() != null) {
				if (rhs.getRequiredEnables() != null) {
					cmp = getRequiredEnables().compareTo( rhs.getRequiredEnables() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnables() != null) {
				return( -1 );
			}
			if (getRequiredIncludes() != null) {
				if (rhs.getRequiredIncludes() != null) {
					cmp = getRequiredIncludes().compareTo( rhs.getRequiredIncludes() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIncludes() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelProtRoleDefByUNameIdxKey rhs ) {
			if (getRequiredScopeId() != null) {
				if (rhs.getRequiredScopeId() != null) {
					cmp = getRequiredScopeId().compareTo( rhs.getRequiredScopeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredScopeId() != null) {
				return( -1 );
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtRoleDefByScopeIdxKey rhs ) {
			if (getRequiredScopeId() != null) {
				if (rhs.getRequiredScopeId() != null) {
					cmp = getRequiredScopeId().compareTo( rhs.getRequiredScopeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredScopeId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtRoleDefByDefSchemaIdxKey rhs ) {
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof IBusModelProtRoleDefByUDefIdxKey rhs ) {
			if (getRequiredScopeId() != null) {
				if (rhs.getRequiredScopeId() != null) {
					cmp = getRequiredScopeId().compareTo( rhs.getRequiredScopeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredScopeId() != null) {
				return( -1 );
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubRoleDef rhs ) {
			cmp = 0;
			{
				cmp = getCreatedByUserId().compareTo( rhs.getCreatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getCreatedAt().compareTo( rhs.getCreatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedByUserId().compareTo( rhs.getUpdatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedAt().compareTo( rhs.getUpdatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if (getRequiredScopeId() != null) {
				if (rhs.getRequiredScopeId() != null) {
					cmp = getRequiredScopeId().compareTo( rhs.getRequiredScopeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredScopeId() != null) {
				return( -1 );
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
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if (getRequiredEnables() != null) {
				if (rhs.getRequiredEnables() != null) {
					cmp = getRequiredEnables().compareTo( rhs.getRequiredEnables() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnables() != null) {
				return( -1 );
			}
			if (getRequiredIncludes() != null) {
				if (rhs.getRequiredIncludes() != null) {
					cmp = getRequiredIncludes().compareTo( rhs.getRequiredIncludes() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIncludes() != null) {
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
		else if( obj instanceof IBusModelPubRoleDefH rhs ) {
			cmp = 0;
			if (getRequiredScopeId() != null) {
				if (rhs.getRequiredScopeId() != null) {
					cmp = getRequiredScopeId().compareTo( rhs.getRequiredScopeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredScopeId() != null) {
				return( -1 );
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
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}
			if (getRequiredEnables() != null) {
				if (rhs.getRequiredEnables() != null) {
					cmp = getRequiredEnables().compareTo( rhs.getRequiredEnables() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnables() != null) {
				return( -1 );
			}
			if (getRequiredIncludes() != null) {
				if (rhs.getRequiredIncludes() != null) {
					cmp = getRequiredIncludes().compareTo( rhs.getRequiredIncludes() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIncludes() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelPubRoleDefByUNameIdxKey rhs ) {
			if (getRequiredScopeId() != null) {
				if (rhs.getRequiredScopeId() != null) {
					cmp = getRequiredScopeId().compareTo( rhs.getRequiredScopeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredScopeId() != null) {
				return( -1 );
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubRoleDefByScopeIdxKey rhs ) {
			if (getRequiredScopeId() != null) {
				if (rhs.getRequiredScopeId() != null) {
					cmp = getRequiredScopeId().compareTo( rhs.getRequiredScopeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredScopeId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubRoleDefByDefSchemaIdxKey rhs ) {
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubRoleDefByUDefIdxKey rhs ) {
			if (getRequiredScopeId() != null) {
				if (rhs.getRequiredScopeId() != null) {
					cmp = getRequiredScopeId().compareTo( rhs.getRequiredScopeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredScopeId() != null) {
				return( -1 );
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
			if (getRequiredName() != null) {
				if (rhs.getRequiredName() != null) {
					cmp = getRequiredName().compareTo( rhs.getRequiredName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredName() != null) {
				return( -1 );
			}			return( 0 );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	@Override
	public void set( IBusModelRoleDef src ) {
		setRoleDef( src );
	}

	@Override
	public void setRoleDef( IBusModelRoleDef src ) {
		setRequiredId(src.getRequiredId());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredContainerScopeDef(src.getRequiredContainerScopeDef());
		setOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setRequiredScopeId(src.getRequiredScopeId());
		setOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setRequiredName(src.getRequiredName());
		setRequiredEnables(src.getRequiredEnables());
		setRequiredIncludes(src.getRequiredIncludes());
	}

	@Override
	public void set( IBusModelRoleDefH src ) {
		setRoleDef( src );
	}

	@Override
	public void setRoleDef( IBusModelRoleDefH src ) {
		setRequiredId(src.getRequiredId());
		setRequiredContainerScopeDef(src.getRequiredContainerScopeDef());
		setOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setRequiredScopeId(src.getRequiredScopeId());
		setOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setRequiredName(src.getRequiredName());
		setRequiredEnables(src.getRequiredEnables());
		setRequiredIncludes(src.getRequiredIncludes());
	}

	@Override
	public void set( IBusModelProtRoleDef src ) {
		setRoleDef( src );
	}

	@Override
	public void setRoleDef( IBusModelProtRoleDef src ) {
		setRequiredId(src.getRequiredId());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredContainerScopeDef(src.getRequiredContainerScopeDef());
		setOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setRequiredScopeId(src.getRequiredScopeId());
		setOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setRequiredName(src.getRequiredName());
		setRequiredEnables(src.getRequiredEnables());
		setRequiredIncludes(src.getRequiredIncludes());
	}

	@Override
	public void set( IBusModelProtRoleDefH src ) {
		setRoleDef( src );
	}

	@Override
	public void setRoleDef( IBusModelProtRoleDefH src ) {
		setRequiredId(src.getRequiredId());
		setRequiredContainerScopeDef(src.getRequiredContainerScopeDef());
		setOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setRequiredScopeId(src.getRequiredScopeId());
		setOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setRequiredName(src.getRequiredName());
		setRequiredEnables(src.getRequiredEnables());
		setRequiredIncludes(src.getRequiredIncludes());
	}

	@Override
	public void set( IBusModelPubRoleDef src ) {
		setRoleDef( src );
	}

	@Override
	public void setRoleDef( IBusModelPubRoleDef src ) {
		setRequiredId(src.getRequiredId());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredContainerScopeDef(src.getRequiredContainerScopeDef());
		setOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setRequiredScopeId(src.getRequiredScopeId());
		setOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setRequiredName(src.getRequiredName());
		setRequiredEnables(src.getRequiredEnables());
		setRequiredIncludes(src.getRequiredIncludes());
	}

	@Override
	public void set( IBusModelPubRoleDefH src ) {
		setRoleDef( src );
	}

	@Override
	public void setRoleDef( IBusModelPubRoleDefH src ) {
		setRequiredId(src.getRequiredId());
		setRequiredContainerScopeDef(src.getRequiredContainerScopeDef());
		setOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setRequiredScopeId(src.getRequiredScopeId());
		setOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setRequiredName(src.getRequiredName());
		setRequiredEnables(src.getRequiredEnables());
		setRequiredIncludes(src.getRequiredIncludes());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = ""
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " classCode=\"" + getClassCode() + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredScopeId=" + "\"" + getRequiredScopeId().toString() + "\""
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " OptionalDefSchemaId=" + ( ( getOptionalDefSchemaId() == null ) ? "null" : "\"" + getOptionalDefSchemaId().toString() + "\"" )
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\""
			+ " RequiredEnables=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredEnables() ) + "\""
			+ " RequiredIncludes=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredIncludes() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelBuffRoleDef" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
