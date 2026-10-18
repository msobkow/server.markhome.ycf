// Description: Java 17 implJustPubementation of a SchemaDef buffer

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
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;

public class BusModelPubBuffSchemaDef
	extends BusModelPubBuffScope
	implements IBusModelSchemaDef
{
	protected IYCFKeyHash256 requiredCTenantId;
	protected IYCFKeyHash256 requiredMinorVersionId;
	protected String requiredName;
	protected String optionalDbName;
	protected String optionalShortName;
	protected String optionalLabel;
	protected String optionalShortDescription;
	protected String optionalDescription;
	protected String requiredCopyrightPeriod;
	protected String requiredCopyrightHolder;
	protected String requiredAuthorEMail;
	protected String requiredProjectURL;
	protected String requiredPublishURI;

	public BusModelPubBuffSchemaDef() {
		super();
		requiredCTenantId = YCFDbKeyHash256.fromHex( IBusModelPubSchemaDef.CTENANTID_INIT_VALUE.toString() );
		requiredMinorVersionId = YCFDbKeyHash256.fromHex( IBusModelPubSchemaDef.MINORVERSIONID_INIT_VALUE.toString() );
		requiredName = IBusModelPubSchemaDef.NAME_INIT_VALUE;
		optionalDbName = null;
		optionalShortName = null;
		optionalLabel = null;
		optionalShortDescription = null;
		optionalDescription = null;
		requiredCopyrightPeriod = IBusModelPubSchemaDef.COPYRIGHTPERIOD_INIT_VALUE;
		requiredCopyrightHolder = IBusModelPubSchemaDef.COPYRIGHTHOLDER_INIT_VALUE;
		requiredAuthorEMail = IBusModelPubSchemaDef.AUTHOREMAIL_INIT_VALUE;
		requiredProjectURL = IBusModelPubSchemaDef.PROJECTURL_INIT_VALUE;
		requiredPublishURI = IBusModelPubSchemaDef.PUBLISHURI_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( IBusModelPubSchemaDef.CLASS_CODE );
	}

	@Override
	public IIntNetPubMinorVersion getRequiredContainerMinorVersion(IYCFKeyHash256 argMinorVersionId) {
		IIntNetPubSchema targetBackingIntNet = IIntNetPubSchema.getBackingIntNet();
		if (targetBackingIntNet == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerMinorVersion", 0, "IIntNetPubSchema.getBackingIntNet()");
		}
		IIntNetPubMinorVersionTable targetTable = targetBackingIntNet.getTableMinorVersion();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerMinorVersion", 0, "IIntNetPubSchema.getBackingIntNet().getTableMinorVersion()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredMinorVersionId()));
	}

	@Override
	public void setRequiredContainerMinorVersion(IYCFKeyHash256 argMinorVersionId) {
		IIntNetPubSchema targetBackingIntNet = IIntNetPubSchema.getBackingIntNet();
		if (targetBackingIntNet == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerMinorVersion-args", 0, "IIntNetPubSchema.getBackingIntNet()");
		}
		IIntNetPubMinorVersionTable targetTable = targetBackingIntNet.getTableMinorVersion();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerMinorVersion", 0, "IIntNetSchema.getBackingIntNet().getTableMinorVersion()");
		}
		IIntNetPubMinorVersion found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argMinorVersionId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerMinorVersion-args", 0, "found");
		}
		else if (found instanceof IIntNetPubMinorVersion) || (found instanceof IIntNetPubMinorVersion)) {
			super.setRequiredContainerMinorVersion(argMinorVersionId);
		requiredMinorVersionId = argMinorVersionId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredContainerMinorVersion-args", "found", found, "IIntNetPubMinorVersionIIntNetPubMinorVersion");
		}
	}

	@Override
	public void setRequiredContainerMinorVersion(IIntNetPubMinorVersion argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerMinorVersion", 1, "argObj");
		}
		else {
			setRequiredMinorVersionId(argObj.getRequiredId());
		}
	}

	@Override
	public ISecurePubTenant getRequiredOwnerCTenant(IYCFKeyHash256 argCTenantId) {
		ISecurePubSchema targetBackingSecure = ISecurePubSchema.getBackingSecure();
		if (targetBackingSecure == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredOwnerCTenant", 0, "ISecurePubSchema.getBackingSecure()");
		}
		ISecurePubTenantTable targetTable = targetBackingSecure.getTableTenant();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredOwnerCTenant", 0, "ISecurePubSchema.getBackingSecure().getTableTenant()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredCTenantId()));
	}

	@Override
	public void setRequiredOwnerTenant(IYCFKeyHash256 argCTenantId) {
		ISecurePubSchema targetBackingSecure = ISecurePubSchema.getBackingSecure();
		if (targetBackingSecure == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredOwnerCTenant-args", 0, "ISecureSchema.getBackingSecure()");
		}
		ISecurePubTenantTable targetTable = targetBackingSecure.getTableTenant();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredOwnerTenant", 0, "ISecureSchema.getBackingSecure().getTableTenant()");
		}
		ISecurePubTenant found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argCTenantId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredOwnerTenant-args", 0, "found");
		}
		else if (found instanceof ISecurePubTenant) || (found instanceof ISecurePubTenant)) {
			super.setRequiredOwnerTenant(argCTenantId);
		requiredCTenantId = argCTenantId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredOwnerTenant-args", "found", found, "ISecurePubTenantISecurePubTenant");
		}
	}
$reimplJustPubSchemaPubBuffTableNarrowedPubRelationSetter$
	@Override
	public void setRequiredOwnerCTenant(IYCFKeyHash256 argCTenantId) {
		ISecurePubSchema targetBackingSecure = ISecurePubSchema.getBackingSecure();
		if (targetBackingSecure == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredOwnerCTenant-args", 0, "ISecureSchema.getBackingSecure()");
		}
		ISecurePubTenantTable targetTable = targetBackingSecure.getTableTenant();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredOwnerTenant", 0, "ISecureSchema.getBackingSecure().getTableTenant()");
		}
		ISecurePubTenant found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argCTenantId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredOwnerTenant-args", 0, "found");
		}
		else if (found instanceof ISecurePubTenant) || (found instanceof ISecurePubTenant)) {
			super.setRequiredOwnerTenant(argCTenantId);
		requiredCTenantId = argCTenantId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredOwnerTenant-args", "found", found, "ISecurePubTenantISecurePubTenant");
		}
	}

	@Override
	public void setRequiredOwnerCTenant(ISecurePubTenant argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setOwnerCTenant", 1, "argObj");
		}
		else {
			setRequiredCTenantId(argObj.getRequiredId());
		}
	}

	@Override
	public List<IBusModelPubTable> getOptionalComponentsTables(IYCFKeyHash256 argId) {
		IBusModelPubSchema targetBackingBusModel = IBusModelPubSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsTables", 0, "IBusModelPubSchema.getBackingBusModel()");
		}
		IBusModelPubTableTable targetTable = targetBackingBusModel.getTableTable();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsTables", 0, "IBusModelPubSchema.getBackingBusModel().getTableTable()");
		}
		IBusModelPubTable[] targetArr = targetTable.readDerivedBySchemaDefIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelPubTable> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IBusModelPubTable> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public List<IBusModelPubValue> getOptionalComponentsTypes(IYCFKeyHash256 argId) {
		IBusModelPubSchema targetBackingBusModel = IBusModelPubSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsTypes", 0, "IBusModelPubSchema.getBackingBusModel()");
		}
		IBusModelPubValueTable targetTable = targetBackingBusModel.getTableValue();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsTypes", 0, "IBusModelPubSchema.getBackingBusModel().getTableValue()");
		}
		IBusModelPubValue[] targetArr = targetTable.readDerivedByScopeIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelPubValue> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IBusModelPubValue> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public List<IBusModelPubSchemaRef> getOptionalComponentsSchemaRefs(IYCFKeyHash256 argId) {
		IBusModelPubSchema targetBackingBusModel = IBusModelPubSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsSchemaRefs", 0, "IBusModelPubSchema.getBackingBusModel()");
		}
		IBusModelPubSchemaRefTable targetTable = targetBackingBusModel.getTableSchemaRef();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsSchemaRefs", 0, "IBusModelPubSchema.getBackingBusModel().getTableSchemaRef()");
		}
		IBusModelPubSchemaRef[] targetArr = targetTable.readDerivedBySchemaIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelPubSchemaRef> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IBusModelPubSchemaRef> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public List<IBusModelPubTweak> getOptionalComponentsTweaks(IYCFKeyHash256 argId) {
		IBusModelPubSchema targetBackingBusModel = IBusModelPubSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsTweaks", 0, "IBusModelPubSchema.getBackingBusModel()");
		}
		IBusModelPubTweakTable targetTable = targetBackingBusModel.getTableTweak();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsTweaks", 0, "IBusModelPubSchema.getBackingBusModel().getTableTweak()");
		}
		IBusModelPubTweak[] targetArr = targetTable.readDerivedByScopeIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelPubTweak> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IBusModelPubTweak> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public List<IBusModelPubSchemaRole> getOptionalComponentsRoles(IYCFKeyHash256 argId) {
		IBusModelPubSchema targetBackingBusModel = IBusModelPubSchema.getBackingBusModel();
		if (targetBackingBusModel == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsRoles", 0, "IBusModelPubSchema.getBackingBusModel()");
		}
		IBusModelPubSchemaRoleTable targetTable = targetBackingBusModel.getTableSchemaRole();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsRoles", 0, "IBusModelPubSchema.getBackingBusModel().getTableSchemaRole()");
		}
		IBusModelPubSchemaRole[] targetArr = targetTable.readDerivedBySchemaIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IBusModelPubSchemaRole> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IBusModelPubSchemaRole> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredCTenantId() {
		return(requiredCTenantId);
	}

	public void setRequiredCTenantId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredCTenantId",
				1,
				"value" );
		}
		requiredCTenantId = value;
	}

	@Override
	public IYCFKeyHash256 getRequiredMinorVersionId() {
		return(requiredMinorVersionId);
	}

	public void setRequiredMinorVersionId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredMinorVersionId",
				1,
				"value" );
		}
		requiredMinorVersionId = value;
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
	public String getOptionalDbName() {
		return(optionalDbName);
	}

	public void setOptionalDbName( String value ) {
		if( value != null && value.length() > 12 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalDbName",
				1,
				"value.length()",
				value.length(),
				12 );
		}
		optionalDbName = value;
	}

	@Override
	public String getOptionalShortName() {
		return(optionalShortName);
	}

	public void setOptionalShortName( String value ) {
		if( value != null && value.length() > 16 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalShortName",
				1,
				"value.length()",
				value.length(),
				16 );
		}
		optionalShortName = value;
	}

	@Override
	public String getOptionalLabel() {
		return(optionalLabel);
	}

	public void setOptionalLabel( String value ) {
		if( value != null && value.length() > 64 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalLabel",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		optionalLabel = value;
	}

	@Override
	public String getOptionalShortDescription() {
		return(optionalShortDescription);
	}

	public void setOptionalShortDescription( String value ) {
		if( value != null && value.length() > 128 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalShortDescription",
				1,
				"value.length()",
				value.length(),
				128 );
		}
		optionalShortDescription = value;
	}

	@Override
	public String getOptionalDescription() {
		return(optionalDescription);
	}

	public void setOptionalDescription( String value ) {
		if( value != null && value.length() > 1023 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalDescription",
				1,
				"value.length()",
				value.length(),
				1023 );
		}
		optionalDescription = value;
	}

	@Override
	public String getRequiredCopyrightPeriod() {
		return(requiredCopyrightPeriod);
	}

	public void setRequiredCopyrightPeriod( String value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredCopyrightPeriod",
				1,
				"value" );
		}
		else if( value.length() > 10 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredCopyrightPeriod",
				1,
				"value.length()",
				value.length(),
				10 );
		}
		requiredCopyrightPeriod = value;
	}

	@Override
	public String getRequiredCopyrightHolder() {
		return(requiredCopyrightHolder);
	}

	public void setRequiredCopyrightHolder( String value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredCopyrightHolder",
				1,
				"value" );
		}
		else if( value.length() > 511 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredCopyrightHolder",
				1,
				"value.length()",
				value.length(),
				511 );
		}
		requiredCopyrightHolder = value;
	}

	@Override
	public String getRequiredAuthorEMail() {
		return(requiredAuthorEMail);
	}

	public void setRequiredAuthorEMail( String value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredAuthorEMail",
				1,
				"value" );
		}
		else if( value.length() > 512 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredAuthorEMail",
				1,
				"value.length()",
				value.length(),
				512 );
		}
		requiredAuthorEMail = value;
	}

	@Override
	public String getRequiredProjectURL() {
		return(requiredProjectURL);
	}

	public void setRequiredProjectURL( String value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredProjectURL",
				1,
				"value" );
		}
		else if( value.length() > 1024 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredProjectURL",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		requiredProjectURL = value;
	}

	@Override
	public String getRequiredPublishURI() {
		return(requiredPublishURI);
	}

	public void setRequiredPublishURI( String value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredPublishURI",
				1,
				"value" );
		}
		else if( value.length() > 512 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredPublishURI",
				1,
				"value.length()",
				value.length(),
				512 );
		}
		requiredPublishURI = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof IBusModelPubSchemaDef rhs ) {
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
			if( getRequiredCTenantId() != null ) {
				if( rhs.getRequiredCTenantId() != null ) {
					if( ! getRequiredCTenantId().equals( rhs.getRequiredCTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredMinorVersionId() != null ) {
				if( rhs.getRequiredMinorVersionId() != null ) {
					if( ! getRequiredMinorVersionId().equals( rhs.getRequiredMinorVersionId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredMinorVersionId() != null ) {
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
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					if( ! getOptionalDbName().equals( rhs.getOptionalDbName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( false );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getRequiredCopyrightPeriod() != null ) {
				if( rhs.getRequiredCopyrightPeriod() != null ) {
					if( ! getRequiredCopyrightPeriod().equals( rhs.getRequiredCopyrightPeriod() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCopyrightPeriod() != null ) {
					return( false );
				}
			}
			if( getRequiredCopyrightHolder() != null ) {
				if( rhs.getRequiredCopyrightHolder() != null ) {
					if( ! getRequiredCopyrightHolder().equals( rhs.getRequiredCopyrightHolder() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCopyrightHolder() != null ) {
					return( false );
				}
			}
			if( getRequiredAuthorEMail() != null ) {
				if( rhs.getRequiredAuthorEMail() != null ) {
					if( ! getRequiredAuthorEMail().equals( rhs.getRequiredAuthorEMail() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredAuthorEMail() != null ) {
					return( false );
				}
			}
			if( getRequiredProjectURL() != null ) {
				if( rhs.getRequiredProjectURL() != null ) {
					if( ! getRequiredProjectURL().equals( rhs.getRequiredProjectURL() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredProjectURL() != null ) {
					return( false );
				}
			}
			if( getRequiredPublishURI() != null ) {
				if( rhs.getRequiredPublishURI() != null ) {
					if( ! getRequiredPublishURI().equals( rhs.getRequiredPublishURI() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPublishURI() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubSchemaDefH rhs ) {
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
			if( getRequiredCTenantId() != null ) {
				if( rhs.getRequiredCTenantId() != null ) {
					if( ! getRequiredCTenantId().equals( rhs.getRequiredCTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredMinorVersionId() != null ) {
				if( rhs.getRequiredMinorVersionId() != null ) {
					if( ! getRequiredMinorVersionId().equals( rhs.getRequiredMinorVersionId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredMinorVersionId() != null ) {
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
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					if( ! getOptionalDbName().equals( rhs.getOptionalDbName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( false );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getRequiredCopyrightPeriod() != null ) {
				if( rhs.getRequiredCopyrightPeriod() != null ) {
					if( ! getRequiredCopyrightPeriod().equals( rhs.getRequiredCopyrightPeriod() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCopyrightPeriod() != null ) {
					return( false );
				}
			}
			if( getRequiredCopyrightHolder() != null ) {
				if( rhs.getRequiredCopyrightHolder() != null ) {
					if( ! getRequiredCopyrightHolder().equals( rhs.getRequiredCopyrightHolder() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCopyrightHolder() != null ) {
					return( false );
				}
			}
			if( getRequiredAuthorEMail() != null ) {
				if( rhs.getRequiredAuthorEMail() != null ) {
					if( ! getRequiredAuthorEMail().equals( rhs.getRequiredAuthorEMail() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredAuthorEMail() != null ) {
					return( false );
				}
			}
			if( getRequiredProjectURL() != null ) {
				if( rhs.getRequiredProjectURL() != null ) {
					if( ! getRequiredProjectURL().equals( rhs.getRequiredProjectURL() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredProjectURL() != null ) {
					return( false );
				}
			}
			if( getRequiredPublishURI() != null ) {
				if( rhs.getRequiredPublishURI() != null ) {
					if( ! getRequiredPublishURI().equals( rhs.getRequiredPublishURI() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPublishURI() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubScopeHPKey ) {
			IBusModelPubScopeHPKey rhs = (IBusModelPubScopeHPKey)obj;
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
		else if( obj instanceof IBusModelPubSchemaDefByCTenantIdxKey rhs ) {
			if( getRequiredCTenantId() != null ) {
				if( rhs.getRequiredCTenantId() != null ) {
					if( ! getRequiredCTenantId().equals( rhs.getRequiredCTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCTenantId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubSchemaDefByMinorVersionIdxKey rhs ) {
			if( getRequiredMinorVersionId() != null ) {
				if( rhs.getRequiredMinorVersionId() != null ) {
					if( ! getRequiredMinorVersionId().equals( rhs.getRequiredMinorVersionId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredMinorVersionId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubSchemaDefByUNameIdxKey rhs ) {
			if( getRequiredMinorVersionId() != null ) {
				if( rhs.getRequiredMinorVersionId() != null ) {
					if( ! getRequiredMinorVersionId().equals( rhs.getRequiredMinorVersionId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredMinorVersionId() != null ) {
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
		else if( obj instanceof IBusModelPubSchemaDefByAuthEMailIdxKey rhs ) {
			if( getRequiredCTenantId() != null ) {
				if( rhs.getRequiredCTenantId() != null ) {
					if( ! getRequiredCTenantId().equals( rhs.getRequiredCTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredAuthorEMail() != null ) {
				if( rhs.getRequiredAuthorEMail() != null ) {
					if( ! getRequiredAuthorEMail().equals( rhs.getRequiredAuthorEMail() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredAuthorEMail() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubSchemaDefByProjectURLIdxKey rhs ) {
			if( getRequiredCTenantId() != null ) {
				if( rhs.getRequiredCTenantId() != null ) {
					if( ! getRequiredCTenantId().equals( rhs.getRequiredCTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredProjectURL() != null ) {
				if( rhs.getRequiredProjectURL() != null ) {
					if( ! getRequiredProjectURL().equals( rhs.getRequiredProjectURL() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredProjectURL() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubSchemaDefByPubURIIdxKey rhs ) {
			if( getRequiredCTenantId() != null ) {
				if( rhs.getRequiredCTenantId() != null ) {
					if( ! getRequiredCTenantId().equals( rhs.getRequiredCTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredPublishURI() != null ) {
				if( rhs.getRequiredPublishURI() != null ) {
					if( ! getRequiredPublishURI().equals( rhs.getRequiredPublishURI() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPublishURI() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubSchemaDef rhs ) {
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
			if( getRequiredCTenantId() != null ) {
				if( rhs.getRequiredCTenantId() != null ) {
					if( ! getRequiredCTenantId().equals( rhs.getRequiredCTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredMinorVersionId() != null ) {
				if( rhs.getRequiredMinorVersionId() != null ) {
					if( ! getRequiredMinorVersionId().equals( rhs.getRequiredMinorVersionId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredMinorVersionId() != null ) {
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
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					if( ! getOptionalDbName().equals( rhs.getOptionalDbName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( false );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getRequiredCopyrightPeriod() != null ) {
				if( rhs.getRequiredCopyrightPeriod() != null ) {
					if( ! getRequiredCopyrightPeriod().equals( rhs.getRequiredCopyrightPeriod() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCopyrightPeriod() != null ) {
					return( false );
				}
			}
			if( getRequiredCopyrightHolder() != null ) {
				if( rhs.getRequiredCopyrightHolder() != null ) {
					if( ! getRequiredCopyrightHolder().equals( rhs.getRequiredCopyrightHolder() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCopyrightHolder() != null ) {
					return( false );
				}
			}
			if( getRequiredAuthorEMail() != null ) {
				if( rhs.getRequiredAuthorEMail() != null ) {
					if( ! getRequiredAuthorEMail().equals( rhs.getRequiredAuthorEMail() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredAuthorEMail() != null ) {
					return( false );
				}
			}
			if( getRequiredProjectURL() != null ) {
				if( rhs.getRequiredProjectURL() != null ) {
					if( ! getRequiredProjectURL().equals( rhs.getRequiredProjectURL() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredProjectURL() != null ) {
					return( false );
				}
			}
			if( getRequiredPublishURI() != null ) {
				if( rhs.getRequiredPublishURI() != null ) {
					if( ! getRequiredPublishURI().equals( rhs.getRequiredPublishURI() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPublishURI() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubSchemaDefH rhs ) {
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
			if( getRequiredCTenantId() != null ) {
				if( rhs.getRequiredCTenantId() != null ) {
					if( ! getRequiredCTenantId().equals( rhs.getRequiredCTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredMinorVersionId() != null ) {
				if( rhs.getRequiredMinorVersionId() != null ) {
					if( ! getRequiredMinorVersionId().equals( rhs.getRequiredMinorVersionId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredMinorVersionId() != null ) {
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
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					if( ! getOptionalDbName().equals( rhs.getOptionalDbName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( false );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					if( ! getOptionalShortName().equals( rhs.getOptionalShortName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( false );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					if( ! getOptionalLabel().equals( rhs.getOptionalLabel() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( false );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getRequiredCopyrightPeriod() != null ) {
				if( rhs.getRequiredCopyrightPeriod() != null ) {
					if( ! getRequiredCopyrightPeriod().equals( rhs.getRequiredCopyrightPeriod() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCopyrightPeriod() != null ) {
					return( false );
				}
			}
			if( getRequiredCopyrightHolder() != null ) {
				if( rhs.getRequiredCopyrightHolder() != null ) {
					if( ! getRequiredCopyrightHolder().equals( rhs.getRequiredCopyrightHolder() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCopyrightHolder() != null ) {
					return( false );
				}
			}
			if( getRequiredAuthorEMail() != null ) {
				if( rhs.getRequiredAuthorEMail() != null ) {
					if( ! getRequiredAuthorEMail().equals( rhs.getRequiredAuthorEMail() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredAuthorEMail() != null ) {
					return( false );
				}
			}
			if( getRequiredProjectURL() != null ) {
				if( rhs.getRequiredProjectURL() != null ) {
					if( ! getRequiredProjectURL().equals( rhs.getRequiredProjectURL() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredProjectURL() != null ) {
					return( false );
				}
			}
			if( getRequiredPublishURI() != null ) {
				if( rhs.getRequiredPublishURI() != null ) {
					if( ! getRequiredPublishURI().equals( rhs.getRequiredPublishURI() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPublishURI() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubScopeHPKey rhs ) {
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
		else if( obj instanceof IBusModelPubSchemaDefByCTenantIdxKey rhs ) {
			if( getRequiredCTenantId() != null ) {
				if( rhs.getRequiredCTenantId() != null ) {
					if( ! getRequiredCTenantId().equals( rhs.getRequiredCTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCTenantId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubSchemaDefByMinorVersionIdxKey rhs ) {
			if( getRequiredMinorVersionId() != null ) {
				if( rhs.getRequiredMinorVersionId() != null ) {
					if( ! getRequiredMinorVersionId().equals( rhs.getRequiredMinorVersionId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredMinorVersionId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubSchemaDefByUNameIdxKey rhs ) {
			if( getRequiredMinorVersionId() != null ) {
				if( rhs.getRequiredMinorVersionId() != null ) {
					if( ! getRequiredMinorVersionId().equals( rhs.getRequiredMinorVersionId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredMinorVersionId() != null ) {
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
		else if( obj instanceof IBusModelPubSchemaDefByAuthEMailIdxKey rhs ) {
			if( getRequiredCTenantId() != null ) {
				if( rhs.getRequiredCTenantId() != null ) {
					if( ! getRequiredCTenantId().equals( rhs.getRequiredCTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredAuthorEMail() != null ) {
				if( rhs.getRequiredAuthorEMail() != null ) {
					if( ! getRequiredAuthorEMail().equals( rhs.getRequiredAuthorEMail() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredAuthorEMail() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubSchemaDefByProjectURLIdxKey rhs ) {
			if( getRequiredCTenantId() != null ) {
				if( rhs.getRequiredCTenantId() != null ) {
					if( ! getRequiredCTenantId().equals( rhs.getRequiredCTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredProjectURL() != null ) {
				if( rhs.getRequiredProjectURL() != null ) {
					if( ! getRequiredProjectURL().equals( rhs.getRequiredProjectURL() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredProjectURL() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IBusModelPubSchemaDefByPubURIIdxKey rhs ) {
			if( getRequiredCTenantId() != null ) {
				if( rhs.getRequiredCTenantId() != null ) {
					if( ! getRequiredCTenantId().equals( rhs.getRequiredCTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredCTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredPublishURI() != null ) {
				if( rhs.getRequiredPublishURI() != null ) {
					if( ! getRequiredPublishURI().equals( rhs.getRequiredPublishURI() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPublishURI() != null ) {
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
		hashCode = hashCode + getRequiredCTenantId().hashCode();
		hashCode = hashCode + getRequiredMinorVersionId().hashCode();
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalDbName() != null ) {
			hashCode = hashCode + getOptionalDbName().hashCode();
		}
		if( getOptionalShortName() != null ) {
			hashCode = hashCode + getOptionalShortName().hashCode();
		}
		if( getOptionalLabel() != null ) {
			hashCode = hashCode + getOptionalLabel().hashCode();
		}
		if( getOptionalShortDescription() != null ) {
			hashCode = hashCode + getOptionalShortDescription().hashCode();
		}
		if( getOptionalDescription() != null ) {
			hashCode = hashCode + getOptionalDescription().hashCode();
		}
		if( getRequiredCopyrightPeriod() != null ) {
			hashCode = hashCode + getRequiredCopyrightPeriod().hashCode();
		}
		if( getRequiredCopyrightHolder() != null ) {
			hashCode = hashCode + getRequiredCopyrightHolder().hashCode();
		}
		if( getRequiredAuthorEMail() != null ) {
			hashCode = hashCode + getRequiredAuthorEMail().hashCode();
		}
		if( getRequiredProjectURL() != null ) {
			hashCode = hashCode + getRequiredProjectURL().hashCode();
		}
		if( getRequiredPublishURI() != null ) {
			hashCode = hashCode + getRequiredPublishURI().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof IBusModelPubSchemaDef rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredCTenantId() != null) {
				if (rhs.getRequiredCTenantId() != null) {
					cmp = getRequiredCTenantId().compareTo( rhs.getRequiredCTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCTenantId() != null) {
				return( -1 );
			}
			if (getRequiredMinorVersionId() != null) {
				if (rhs.getRequiredMinorVersionId() != null) {
					cmp = getRequiredMinorVersionId().compareTo( rhs.getRequiredMinorVersionId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredMinorVersionId() != null) {
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
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					cmp = getOptionalDbName().compareTo( rhs.getOptionalDbName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if (getRequiredCopyrightPeriod() != null) {
				if (rhs.getRequiredCopyrightPeriod() != null) {
					cmp = getRequiredCopyrightPeriod().compareTo( rhs.getRequiredCopyrightPeriod() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCopyrightPeriod() != null) {
				return( -1 );
			}
			if (getRequiredCopyrightHolder() != null) {
				if (rhs.getRequiredCopyrightHolder() != null) {
					cmp = getRequiredCopyrightHolder().compareTo( rhs.getRequiredCopyrightHolder() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCopyrightHolder() != null) {
				return( -1 );
			}
			if (getRequiredAuthorEMail() != null) {
				if (rhs.getRequiredAuthorEMail() != null) {
					cmp = getRequiredAuthorEMail().compareTo( rhs.getRequiredAuthorEMail() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredAuthorEMail() != null) {
				return( -1 );
			}
			if (getRequiredProjectURL() != null) {
				if (rhs.getRequiredProjectURL() != null) {
					cmp = getRequiredProjectURL().compareTo( rhs.getRequiredProjectURL() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredProjectURL() != null) {
				return( -1 );
			}
			if (getRequiredPublishURI() != null) {
				if (rhs.getRequiredPublishURI() != null) {
					cmp = getRequiredPublishURI().compareTo( rhs.getRequiredPublishURI() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPublishURI() != null) {
				return( -1 );
			}
			return( 0 );
 		}
		else if( obj instanceof IBusModelPubScopeHPKey rhs ) {
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
		else if( obj instanceof IBusModelPubSchemaDefH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredCTenantId() != null) {
				if (rhs.getRequiredCTenantId() != null) {
					cmp = getRequiredCTenantId().compareTo( rhs.getRequiredCTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCTenantId() != null) {
				return( -1 );
			}
			if (getRequiredMinorVersionId() != null) {
				if (rhs.getRequiredMinorVersionId() != null) {
					cmp = getRequiredMinorVersionId().compareTo( rhs.getRequiredMinorVersionId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredMinorVersionId() != null) {
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
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					cmp = getOptionalDbName().compareTo( rhs.getOptionalDbName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if (getRequiredCopyrightPeriod() != null) {
				if (rhs.getRequiredCopyrightPeriod() != null) {
					cmp = getRequiredCopyrightPeriod().compareTo( rhs.getRequiredCopyrightPeriod() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCopyrightPeriod() != null) {
				return( -1 );
			}
			if (getRequiredCopyrightHolder() != null) {
				if (rhs.getRequiredCopyrightHolder() != null) {
					cmp = getRequiredCopyrightHolder().compareTo( rhs.getRequiredCopyrightHolder() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCopyrightHolder() != null) {
				return( -1 );
			}
			if (getRequiredAuthorEMail() != null) {
				if (rhs.getRequiredAuthorEMail() != null) {
					cmp = getRequiredAuthorEMail().compareTo( rhs.getRequiredAuthorEMail() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredAuthorEMail() != null) {
				return( -1 );
			}
			if (getRequiredProjectURL() != null) {
				if (rhs.getRequiredProjectURL() != null) {
					cmp = getRequiredProjectURL().compareTo( rhs.getRequiredProjectURL() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredProjectURL() != null) {
				return( -1 );
			}
			if (getRequiredPublishURI() != null) {
				if (rhs.getRequiredPublishURI() != null) {
					cmp = getRequiredPublishURI().compareTo( rhs.getRequiredPublishURI() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPublishURI() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelPubSchemaDefByCTenantIdxKey rhs ) {
			if (getRequiredCTenantId() != null) {
				if (rhs.getRequiredCTenantId() != null) {
					cmp = getRequiredCTenantId().compareTo( rhs.getRequiredCTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCTenantId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubSchemaDefByMinorVersionIdxKey rhs ) {
			if (getRequiredMinorVersionId() != null) {
				if (rhs.getRequiredMinorVersionId() != null) {
					cmp = getRequiredMinorVersionId().compareTo( rhs.getRequiredMinorVersionId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredMinorVersionId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubSchemaDefByUNameIdxKey rhs ) {
			if (getRequiredMinorVersionId() != null) {
				if (rhs.getRequiredMinorVersionId() != null) {
					cmp = getRequiredMinorVersionId().compareTo( rhs.getRequiredMinorVersionId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredMinorVersionId() != null) {
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
		else if( obj instanceof IBusModelPubSchemaDefByAuthEMailIdxKey rhs ) {
			if (getRequiredCTenantId() != null) {
				if (rhs.getRequiredCTenantId() != null) {
					cmp = getRequiredCTenantId().compareTo( rhs.getRequiredCTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCTenantId() != null) {
				return( -1 );
			}
			if (getRequiredAuthorEMail() != null) {
				if (rhs.getRequiredAuthorEMail() != null) {
					cmp = getRequiredAuthorEMail().compareTo( rhs.getRequiredAuthorEMail() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredAuthorEMail() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubSchemaDefByProjectURLIdxKey rhs ) {
			if (getRequiredCTenantId() != null) {
				if (rhs.getRequiredCTenantId() != null) {
					cmp = getRequiredCTenantId().compareTo( rhs.getRequiredCTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCTenantId() != null) {
				return( -1 );
			}
			if (getRequiredProjectURL() != null) {
				if (rhs.getRequiredProjectURL() != null) {
					cmp = getRequiredProjectURL().compareTo( rhs.getRequiredProjectURL() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredProjectURL() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubSchemaDefByPubURIIdxKey rhs ) {
			if (getRequiredCTenantId() != null) {
				if (rhs.getRequiredCTenantId() != null) {
					cmp = getRequiredCTenantId().compareTo( rhs.getRequiredCTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCTenantId() != null) {
				return( -1 );
			}
			if (getRequiredPublishURI() != null) {
				if (rhs.getRequiredPublishURI() != null) {
					cmp = getRequiredPublishURI().compareTo( rhs.getRequiredPublishURI() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPublishURI() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubSchemaDef rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredCTenantId() != null) {
				if (rhs.getRequiredCTenantId() != null) {
					cmp = getRequiredCTenantId().compareTo( rhs.getRequiredCTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCTenantId() != null) {
				return( -1 );
			}
			if (getRequiredMinorVersionId() != null) {
				if (rhs.getRequiredMinorVersionId() != null) {
					cmp = getRequiredMinorVersionId().compareTo( rhs.getRequiredMinorVersionId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredMinorVersionId() != null) {
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
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					cmp = getOptionalDbName().compareTo( rhs.getOptionalDbName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if (getRequiredCopyrightPeriod() != null) {
				if (rhs.getRequiredCopyrightPeriod() != null) {
					cmp = getRequiredCopyrightPeriod().compareTo( rhs.getRequiredCopyrightPeriod() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCopyrightPeriod() != null) {
				return( -1 );
			}
			if (getRequiredCopyrightHolder() != null) {
				if (rhs.getRequiredCopyrightHolder() != null) {
					cmp = getRequiredCopyrightHolder().compareTo( rhs.getRequiredCopyrightHolder() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCopyrightHolder() != null) {
				return( -1 );
			}
			if (getRequiredAuthorEMail() != null) {
				if (rhs.getRequiredAuthorEMail() != null) {
					cmp = getRequiredAuthorEMail().compareTo( rhs.getRequiredAuthorEMail() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredAuthorEMail() != null) {
				return( -1 );
			}
			if (getRequiredProjectURL() != null) {
				if (rhs.getRequiredProjectURL() != null) {
					cmp = getRequiredProjectURL().compareTo( rhs.getRequiredProjectURL() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredProjectURL() != null) {
				return( -1 );
			}
			if (getRequiredPublishURI() != null) {
				if (rhs.getRequiredPublishURI() != null) {
					cmp = getRequiredPublishURI().compareTo( rhs.getRequiredPublishURI() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPublishURI() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelPubScopeHPKey rhs ) {
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
		else if( obj instanceof IBusModelPubSchemaDefH rhs ) {
			cmp = super.compareTo( rhs );
			if( cmp != 0 ) {
				return( cmp );
			}
			if (getRequiredCTenantId() != null) {
				if (rhs.getRequiredCTenantId() != null) {
					cmp = getRequiredCTenantId().compareTo( rhs.getRequiredCTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCTenantId() != null) {
				return( -1 );
			}
			if (getRequiredMinorVersionId() != null) {
				if (rhs.getRequiredMinorVersionId() != null) {
					cmp = getRequiredMinorVersionId().compareTo( rhs.getRequiredMinorVersionId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredMinorVersionId() != null) {
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
			}
			if( getOptionalDbName() != null ) {
				if( rhs.getOptionalDbName() != null ) {
					cmp = getOptionalDbName().compareTo( rhs.getOptionalDbName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDbName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortName() != null ) {
				if( rhs.getOptionalShortName() != null ) {
					cmp = getOptionalShortName().compareTo( rhs.getOptionalShortName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortName() != null ) {
					return( -1 );
				}
			}
			if( getOptionalLabel() != null ) {
				if( rhs.getOptionalLabel() != null ) {
					cmp = getOptionalLabel().compareTo( rhs.getOptionalLabel() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalLabel() != null ) {
					return( -1 );
				}
			}
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if (getRequiredCopyrightPeriod() != null) {
				if (rhs.getRequiredCopyrightPeriod() != null) {
					cmp = getRequiredCopyrightPeriod().compareTo( rhs.getRequiredCopyrightPeriod() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCopyrightPeriod() != null) {
				return( -1 );
			}
			if (getRequiredCopyrightHolder() != null) {
				if (rhs.getRequiredCopyrightHolder() != null) {
					cmp = getRequiredCopyrightHolder().compareTo( rhs.getRequiredCopyrightHolder() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCopyrightHolder() != null) {
				return( -1 );
			}
			if (getRequiredAuthorEMail() != null) {
				if (rhs.getRequiredAuthorEMail() != null) {
					cmp = getRequiredAuthorEMail().compareTo( rhs.getRequiredAuthorEMail() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredAuthorEMail() != null) {
				return( -1 );
			}
			if (getRequiredProjectURL() != null) {
				if (rhs.getRequiredProjectURL() != null) {
					cmp = getRequiredProjectURL().compareTo( rhs.getRequiredProjectURL() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredProjectURL() != null) {
				return( -1 );
			}
			if (getRequiredPublishURI() != null) {
				if (rhs.getRequiredPublishURI() != null) {
					cmp = getRequiredPublishURI().compareTo( rhs.getRequiredPublishURI() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPublishURI() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelPubSchemaDefByCTenantIdxKey rhs ) {
			if (getRequiredCTenantId() != null) {
				if (rhs.getRequiredCTenantId() != null) {
					cmp = getRequiredCTenantId().compareTo( rhs.getRequiredCTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCTenantId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubSchemaDefByMinorVersionIdxKey rhs ) {
			if (getRequiredMinorVersionId() != null) {
				if (rhs.getRequiredMinorVersionId() != null) {
					cmp = getRequiredMinorVersionId().compareTo( rhs.getRequiredMinorVersionId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredMinorVersionId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubSchemaDefByUNameIdxKey rhs ) {
			if (getRequiredMinorVersionId() != null) {
				if (rhs.getRequiredMinorVersionId() != null) {
					cmp = getRequiredMinorVersionId().compareTo( rhs.getRequiredMinorVersionId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredMinorVersionId() != null) {
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
		else if( obj instanceof IBusModelPubSchemaDefByAuthEMailIdxKey rhs ) {
			if (getRequiredCTenantId() != null) {
				if (rhs.getRequiredCTenantId() != null) {
					cmp = getRequiredCTenantId().compareTo( rhs.getRequiredCTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCTenantId() != null) {
				return( -1 );
			}
			if (getRequiredAuthorEMail() != null) {
				if (rhs.getRequiredAuthorEMail() != null) {
					cmp = getRequiredAuthorEMail().compareTo( rhs.getRequiredAuthorEMail() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredAuthorEMail() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubSchemaDefByProjectURLIdxKey rhs ) {
			if (getRequiredCTenantId() != null) {
				if (rhs.getRequiredCTenantId() != null) {
					cmp = getRequiredCTenantId().compareTo( rhs.getRequiredCTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCTenantId() != null) {
				return( -1 );
			}
			if (getRequiredProjectURL() != null) {
				if (rhs.getRequiredProjectURL() != null) {
					cmp = getRequiredProjectURL().compareTo( rhs.getRequiredProjectURL() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredProjectURL() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IBusModelPubSchemaDefByPubURIIdxKey rhs ) {
			if (getRequiredCTenantId() != null) {
				if (rhs.getRequiredCTenantId() != null) {
					cmp = getRequiredCTenantId().compareTo( rhs.getRequiredCTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredCTenantId() != null) {
				return( -1 );
			}
			if (getRequiredPublishURI() != null) {
				if (rhs.getRequiredPublishURI() != null) {
					cmp = getRequiredPublishURI().compareTo( rhs.getRequiredPublishURI() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPublishURI() != null) {
				return( -1 );
			}			return( 0 );
		}
		else {
			cmp = super.compareTo( obj );
			return( cmp );
		}
	}

	@Override
	public void set( IBusModelPubScope src ) {
		if( src instanceof BusModelPubBuffSchemaDef ) {
			setJustPubSchemaDef( (BusModelPubBuffSchemaDef)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelPubBuffSchemaDef" );
		}
	}

	@Override
	public void setSchemaDef( IBusModelPubSchemaDef src ) {
		super.setScope( src );
		setJustPubRequiredContainerMinorVersion(src.getRequiredContainerMinorVersion());
		setJustPubRequiredOwnerCTenant(src.getRequiredOwnerCTenant());
		setJustPubRequiredCTenantId(src.getRequiredCTenantId());
		setJustPubRequiredMinorVersionId(src.getRequiredMinorVersionId());
		setJustPubRequiredName(src.getRequiredName());
		setJustPubOptionalDbName(src.getOptionalDbName());
		setJustPubOptionalShortName(src.getOptionalShortName());
		setJustPubOptionalLabel(src.getOptionalLabel());
		setJustPubOptionalShortDescription(src.getOptionalShortDescription());
		setJustPubOptionalDescription(src.getOptionalDescription());
		setJustPubRequiredCopyrightPeriod(src.getRequiredCopyrightPeriod());
		setJustPubRequiredCopyrightHolder(src.getRequiredCopyrightHolder());
		setJustPubRequiredAuthorEMail(src.getRequiredAuthorEMail());
		setJustPubRequiredProjectURL(src.getRequiredProjectURL());
		setJustPubRequiredPublishURI(src.getRequiredPublishURI());
	}

	@Override
	public void set( IBusModelPubScopeH src ) {
		if( src instanceof IBusModelPubSchemaDefH ) {
			setSchemaDef( (IBusModelPubSchemaDefH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubSchemaDefH" );
		}
	}

	@Override
	public void setSchemaDef( IBusModelPubSchemaDefH src ) {
		super.setScope( src );
		setJustPubRequiredContainerMinorVersion(src.getRequiredContainerMinorVersion());
		setJustPubRequiredOwnerCTenant(src.getRequiredOwnerCTenant());
		setJustPubRequiredCTenantId(src.getRequiredCTenantId());
		setJustPubRequiredMinorVersionId(src.getRequiredMinorVersionId());
		setJustPubRequiredName(src.getRequiredName());
		setJustPubOptionalDbName(src.getOptionalDbName());
		setJustPubOptionalShortName(src.getOptionalShortName());
		setJustPubOptionalLabel(src.getOptionalLabel());
		setJustPubOptionalShortDescription(src.getOptionalShortDescription());
		setJustPubOptionalDescription(src.getOptionalDescription());
		setJustPubRequiredCopyrightPeriod(src.getRequiredCopyrightPeriod());
		setJustPubRequiredCopyrightHolder(src.getRequiredCopyrightHolder());
		setJustPubRequiredAuthorEMail(src.getRequiredAuthorEMail());
		setJustPubRequiredProjectURL(src.getRequiredProjectURL());
		setJustPubRequiredPublishURI(src.getRequiredPublishURI());
	}

	@Override
	public void set( IBusModelPubScope src ) {
		if( src instanceof BusModelPubPubBuffSchemaDef ) {
			setJustPubSchemaDef( (BusModelPubPubBuffSchemaDef)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelPubPubBuffSchemaDef" );
		}
	}

	@Override
	public void setSchemaDef( IBusModelPubSchemaDef src ) {
		super.setScope( src );
		setJustPubRequiredContainerMinorVersion(src.getRequiredContainerMinorVersion());
		setJustPubRequiredOwnerCTenant(src.getRequiredOwnerCTenant());
		setJustPubRequiredCTenantId(src.getRequiredCTenantId());
		setJustPubRequiredMinorVersionId(src.getRequiredMinorVersionId());
		setJustPubRequiredName(src.getRequiredName());
		setJustPubOptionalDbName(src.getOptionalDbName());
		setJustPubOptionalShortName(src.getOptionalShortName());
		setJustPubOptionalLabel(src.getOptionalLabel());
		setJustPubOptionalShortDescription(src.getOptionalShortDescription());
		setJustPubOptionalDescription(src.getOptionalDescription());
		setJustPubRequiredCopyrightPeriod(src.getRequiredCopyrightPeriod());
		setJustPubRequiredCopyrightHolder(src.getRequiredCopyrightHolder());
		setJustPubRequiredAuthorEMail(src.getRequiredAuthorEMail());
		setJustPubRequiredProjectURL(src.getRequiredProjectURL());
		setJustPubRequiredPublishURI(src.getRequiredPublishURI());
	}

	@Override
	public void set( IBusModelPubScopeH src ) {
		if( src instanceof IBusModelPubSchemaDefH ) {
			setSchemaDef( (IBusModelPubSchemaDefH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPubSchemaDefH" );
		}
	}

	@Override
	public void setSchemaDef( IBusModelPubSchemaDefH src ) {
		super.setScope( src );
		setJustPubRequiredContainerMinorVersion(src.getRequiredContainerMinorVersion());
		setJustPubRequiredOwnerCTenant(src.getRequiredOwnerCTenant());
		setJustPubRequiredCTenantId(src.getRequiredCTenantId());
		setJustPubRequiredMinorVersionId(src.getRequiredMinorVersionId());
		setJustPubRequiredName(src.getRequiredName());
		setJustPubOptionalDbName(src.getOptionalDbName());
		setJustPubOptionalShortName(src.getOptionalShortName());
		setJustPubOptionalLabel(src.getOptionalLabel());
		setJustPubOptionalShortDescription(src.getOptionalShortDescription());
		setJustPubOptionalDescription(src.getOptionalDescription());
		setJustPubRequiredCopyrightPeriod(src.getRequiredCopyrightPeriod());
		setJustPubRequiredCopyrightHolder(src.getRequiredCopyrightHolder());
		setJustPubRequiredAuthorEMail(src.getRequiredAuthorEMail());
		setJustPubRequiredProjectURL(src.getRequiredProjectURL());
		setJustPubRequiredPublishURI(src.getRequiredPublishURI());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment()  + "\"" + getRequiredId().toString() + "\"" + "\"" + getRequiredCTenantId().toString() + "\"" + "\"" + getRequiredMinorVersionId().toString() + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"" + ( ( getOptionalDbName() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDbName() ) + "\"" ) + ( ( getOptionalShortName() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalShortName() ) + "\"" ) + ( ( getOptionalLabel() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalLabel() ) + "\"" ) + ( ( getOptionalShortDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalShortDescription() ) + "\"" ) + ( ( getOptionalDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDescription() ) + "\"" ) + "\"" + StringEscapeUtils.escapeXml11( getRequiredCopyrightPeriod() ) + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredCopyrightHolder() ) + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredAuthorEMail() ) + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredProjectURL() ) + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredPublishURI() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelPubBuffSchemaDef" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
