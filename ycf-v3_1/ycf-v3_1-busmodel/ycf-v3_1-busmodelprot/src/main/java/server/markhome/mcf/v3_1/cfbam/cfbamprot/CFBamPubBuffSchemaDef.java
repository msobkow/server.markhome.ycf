// Description: Java 17 implJustPubementation of a SchemaDef buffer

/*
 *	server.markhome.mcf.CFBam
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal CFBam 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Mark's Code Fractal CFBam.
 *	
 *	Mark's Code Fractal CFBam is available under dual commercial license from
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
 *	Mark's Code Fractal CFBam is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFBam is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Mark's Code Fractal CFBam.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.mcf.v3_1.cfbam.cfbam.buff;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cflib.xml.MCFXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;
import server.markhome.mcf.v3_1.cfbam.cfbampub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;
import server.markhome.mcf.v3_1.cfbam.cfbampubobj.*;
import server.markhome.mcf.v3_1.cfbam.cfbampub.*;
import server.markhome.mcf.v3_1.cfbam.cfbampubobj.*;

public class CFBamPubBuffSchemaDef
	extends CFBamPubBuffScope
	implements ICFBamSchemaDef
{
	protected IMCFKeyHash256 requiredCTenantId;
	protected IMCFKeyHash256 requiredMinorVersionId;
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

	public CFBamPubBuffSchemaDef() {
		super();
		requiredCTenantId = MCFDbKeyHash256.fromHex( ICFBamPubSchemaDef.CTENANTID_INIT_VALUE.toString() );
		requiredMinorVersionId = MCFDbKeyHash256.fromHex( ICFBamPubSchemaDef.MINORVERSIONID_INIT_VALUE.toString() );
		requiredName = ICFBamPubSchemaDef.NAME_INIT_VALUE;
		optionalDbName = null;
		optionalShortName = null;
		optionalLabel = null;
		optionalShortDescription = null;
		optionalDescription = null;
		requiredCopyrightPeriod = ICFBamPubSchemaDef.COPYRIGHTPERIOD_INIT_VALUE;
		requiredCopyrightHolder = ICFBamPubSchemaDef.COPYRIGHTHOLDER_INIT_VALUE;
		requiredAuthorEMail = ICFBamPubSchemaDef.AUTHOREMAIL_INIT_VALUE;
		requiredProjectURL = ICFBamPubSchemaDef.PROJECTURL_INIT_VALUE;
		requiredPublishURI = ICFBamPubSchemaDef.PUBLISHURI_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( ICFBamPubSchemaDef.CLASS_CODE );
	}

	@Override
	public ICFIntPubMinorVersion getRequiredContainerMinorVersion(IMCFKeyHash256 argMinorVersionId) {
		ICFIntPubSchema targetBackingCFInt = ICFIntPubSchema.getBackingCFInt();
		if (targetBackingCFInt == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredContainerMinorVersion", 0, "ICFIntPubSchema.getBackingCFInt()");
		}
		ICFIntPubMinorVersionTable targetTable = targetBackingCFInt.getTableMinorVersion();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredContainerMinorVersion", 0, "ICFIntPubSchema.getBackingCFInt().getTableMinorVersion()");
		}
		return(targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredMinorVersionId()));
	}

	@Override
	public void setRequiredContainerMinorVersion(IMCFKeyHash256 argMinorVersionId) {
		ICFIntPubSchema targetBackingCFInt = ICFIntPubSchema.getBackingCFInt();
		if (targetBackingCFInt == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerMinorVersion-args", 0, "ICFIntPubSchema.getBackingCFInt()");
		}
		ICFIntPubMinorVersionTable targetTable = targetBackingCFInt.getTableMinorVersion();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerMinorVersion", 0, "ICFIntSchema.getBackingCFInt().getTableMinorVersion()");
		}
		ICFIntPubMinorVersion found = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argMinorVersionId);
		if (found == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerMinorVersion-args", 0, "found");
		}
		else if (found instanceof ICFIntPubMinorVersion) || (found instanceof ICFIntPubMinorVersion)) {
			super.setRequiredContainerMinorVersion(argMinorVersionId);
		requiredMinorVersionId = argMinorVersionId;
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setRequiredContainerMinorVersion-args", "found", found, "ICFIntPubMinorVersionICFIntPubMinorVersion");
		}
	}

	@Override
	public void setRequiredContainerMinorVersion(ICFIntPubMinorVersion argObj) {

		if(argObj == null) {
			throw new MCFNullArgumentException(getClass(), "setContainerMinorVersion", 1, "argObj");
		}
		else {
			setRequiredMinorVersionId(argObj.getRequiredId());
		}
	}

	@Override
	public ICFSecPubTenant getRequiredOwnerCTenant(IMCFKeyHash256 argCTenantId) {
		ICFSecPubSchema targetBackingCFSec = ICFSecPubSchema.getBackingCFSec();
		if (targetBackingCFSec == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredOwnerCTenant", 0, "ICFSecPubSchema.getBackingCFSec()");
		}
		ICFSecPubTenantTable targetTable = targetBackingCFSec.getTableTenant();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredOwnerCTenant", 0, "ICFSecPubSchema.getBackingCFSec().getTableTenant()");
		}
		return(targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredCTenantId()));
	}

	@Override
	public void setRequiredOwnerTenant(IMCFKeyHash256 argCTenantId) {
		ICFSecPubSchema targetBackingCFSec = ICFSecPubSchema.getBackingCFSec();
		if (targetBackingCFSec == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredOwnerCTenant-args", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecPubTenantTable targetTable = targetBackingCFSec.getTableTenant();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredOwnerTenant", 0, "ICFSecSchema.getBackingCFSec().getTableTenant()");
		}
		ICFSecPubTenant found = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argCTenantId);
		if (found == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredOwnerTenant-args", 0, "found");
		}
		else if (found instanceof ICFSecPubTenant) || (found instanceof ICFSecPubTenant)) {
			super.setRequiredOwnerTenant(argCTenantId);
		requiredCTenantId = argCTenantId;
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setRequiredOwnerTenant-args", "found", found, "ICFSecPubTenantICFSecPubTenant");
		}
	}
$reimplJustPubSchemaPubBuffTableNarrowedPubRelationSetter$
	@Override
	public void setRequiredOwnerCTenant(IMCFKeyHash256 argCTenantId) {
		ICFSecPubSchema targetBackingCFSec = ICFSecPubSchema.getBackingCFSec();
		if (targetBackingCFSec == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredOwnerCTenant-args", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecPubTenantTable targetTable = targetBackingCFSec.getTableTenant();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredOwnerTenant", 0, "ICFSecSchema.getBackingCFSec().getTableTenant()");
		}
		ICFSecPubTenant found = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argCTenantId);
		if (found == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredOwnerTenant-args", 0, "found");
		}
		else if (found instanceof ICFSecPubTenant) || (found instanceof ICFSecPubTenant)) {
			super.setRequiredOwnerTenant(argCTenantId);
		requiredCTenantId = argCTenantId;
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setRequiredOwnerTenant-args", "found", found, "ICFSecPubTenantICFSecPubTenant");
		}
	}

	@Override
	public void setRequiredOwnerCTenant(ICFSecPubTenant argObj) {

		if(argObj == null) {
			throw new MCFNullArgumentException(getClass(), "setOwnerCTenant", 1, "argObj");
		}
		else {
			setRequiredCTenantId(argObj.getRequiredId());
		}
	}

	@Override
	public List<ICFBamPubTable> getOptionalComponentsTables(IMCFKeyHash256 argId) {
		ICFBamPubSchema targetBackingCFBam = ICFBamPubSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalComponentsTables", 0, "ICFBamPubSchema.getBackingCFBam()");
		}
		ICFBamPubTableTable targetTable = targetBackingCFBam.getTableTable();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalComponentsTables", 0, "ICFBamPubSchema.getBackingCFBam().getTableTable()");
		}
		ICFBamPubTable[] targetArr = targetTable.readDerivedBySchemaDefIdx(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<ICFBamPubTable> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<ICFBamPubTable> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public List<ICFBamPubValue> getOptionalComponentsTypes(IMCFKeyHash256 argId) {
		ICFBamPubSchema targetBackingCFBam = ICFBamPubSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalComponentsTypes", 0, "ICFBamPubSchema.getBackingCFBam()");
		}
		ICFBamPubValueTable targetTable = targetBackingCFBam.getTableValue();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalComponentsTypes", 0, "ICFBamPubSchema.getBackingCFBam().getTableValue()");
		}
		ICFBamPubValue[] targetArr = targetTable.readDerivedByScopeIdx(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<ICFBamPubValue> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<ICFBamPubValue> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public List<ICFBamPubSchemaRef> getOptionalComponentsSchemaRefs(IMCFKeyHash256 argId) {
		ICFBamPubSchema targetBackingCFBam = ICFBamPubSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalComponentsSchemaRefs", 0, "ICFBamPubSchema.getBackingCFBam()");
		}
		ICFBamPubSchemaRefTable targetTable = targetBackingCFBam.getTableSchemaRef();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalComponentsSchemaRefs", 0, "ICFBamPubSchema.getBackingCFBam().getTableSchemaRef()");
		}
		ICFBamPubSchemaRef[] targetArr = targetTable.readDerivedBySchemaIdx(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<ICFBamPubSchemaRef> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<ICFBamPubSchemaRef> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public List<ICFBamPubTweak> getOptionalComponentsTweaks(IMCFKeyHash256 argId) {
		ICFBamPubSchema targetBackingCFBam = ICFBamPubSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalComponentsTweaks", 0, "ICFBamPubSchema.getBackingCFBam()");
		}
		ICFBamPubTweakTable targetTable = targetBackingCFBam.getTableTweak();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalComponentsTweaks", 0, "ICFBamPubSchema.getBackingCFBam().getTableTweak()");
		}
		ICFBamPubTweak[] targetArr = targetTable.readDerivedByScopeIdx(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<ICFBamPubTweak> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<ICFBamPubTweak> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public List<ICFBamPubSchemaRole> getOptionalComponentsRoles(IMCFKeyHash256 argId) {
		ICFBamPubSchema targetBackingCFBam = ICFBamPubSchema.getBackingCFBam();
		if (targetBackingCFBam == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalComponentsRoles", 0, "ICFBamPubSchema.getBackingCFBam()");
		}
		ICFBamPubSchemaRoleTable targetTable = targetBackingCFBam.getTableSchemaRole();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getOptionalComponentsRoles", 0, "ICFBamPubSchema.getBackingCFBam().getTableSchemaRole()");
		}
		ICFBamPubSchemaRole[] targetArr = targetTable.readDerivedBySchemaIdx(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<ICFBamPubSchemaRole> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<ICFBamPubSchemaRole> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public IMCFKeyHash256 getRequiredCTenantId() {
		return(requiredCTenantId);
	}

	public void setRequiredCTenantId( IMCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredCTenantId",
				1,
				"value" );
		}
		requiredCTenantId = value;
	}

	@Override
	public IMCFKeyHash256 getRequiredMinorVersionId() {
		return(requiredMinorVersionId);
	}

	public void setRequiredMinorVersionId( IMCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new MCFNullArgumentException( getClass(),
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
			throw new MCFNullArgumentException( getClass(),
				"setRequiredName",
				1,
				"value" );
		}
		else if( value.length() > 192 ) {
			throw new MCFArgumentOverflowException( getClass(),
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
			throw new MCFArgumentOverflowException( getClass(),
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
			throw new MCFArgumentOverflowException( getClass(),
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
			throw new MCFArgumentOverflowException( getClass(),
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
			throw new MCFArgumentOverflowException( getClass(),
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
			throw new MCFArgumentOverflowException( getClass(),
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
			throw new MCFNullArgumentException( getClass(),
				"setRequiredCopyrightPeriod",
				1,
				"value" );
		}
		else if( value.length() > 10 ) {
			throw new MCFArgumentOverflowException( getClass(),
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
			throw new MCFNullArgumentException( getClass(),
				"setRequiredCopyrightHolder",
				1,
				"value" );
		}
		else if( value.length() > 511 ) {
			throw new MCFArgumentOverflowException( getClass(),
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
			throw new MCFNullArgumentException( getClass(),
				"setRequiredAuthorEMail",
				1,
				"value" );
		}
		else if( value.length() > 512 ) {
			throw new MCFArgumentOverflowException( getClass(),
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
			throw new MCFNullArgumentException( getClass(),
				"setRequiredProjectURL",
				1,
				"value" );
		}
		else if( value.length() > 1024 ) {
			throw new MCFArgumentOverflowException( getClass(),
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
			throw new MCFNullArgumentException( getClass(),
				"setRequiredPublishURI",
				1,
				"value" );
		}
		else if( value.length() > 512 ) {
			throw new MCFArgumentOverflowException( getClass(),
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
		else if( obj instanceof ICFBamPubSchemaDef rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefH rhs ) {
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
		else if( obj instanceof ICFBamPubScopeHPKey ) {
			ICFBamPubScopeHPKey rhs = (ICFBamPubScopeHPKey)obj;
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
		else if( obj instanceof ICFBamPubSchemaDefByCTenantIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByMinorVersionIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByUNameIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByAuthEMailIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByProjectURLIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByPubURIIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDef rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefH rhs ) {
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
		else if( obj instanceof ICFBamPubScopeHPKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByCTenantIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByMinorVersionIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByUNameIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByAuthEMailIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByProjectURLIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByPubURIIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDef rhs ) {
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
		else if( obj instanceof ICFBamPubScopeHPKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefH rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByCTenantIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByMinorVersionIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByUNameIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByAuthEMailIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByProjectURLIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByPubURIIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDef rhs ) {
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
		else if( obj instanceof ICFBamPubScopeHPKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefH rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByCTenantIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByMinorVersionIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByUNameIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByAuthEMailIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByProjectURLIdxKey rhs ) {
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
		else if( obj instanceof ICFBamPubSchemaDefByPubURIIdxKey rhs ) {
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
	public void set( ICFBamPubScope src ) {
		if( src instanceof CFBamPubBuffSchemaDef ) {
			setJustPubSchemaDef( (CFBamPubBuffSchemaDef)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamPubBuffSchemaDef" );
		}
	}

	@Override
	public void setSchemaDef( ICFBamPubSchemaDef src ) {
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
	public void set( ICFBamPubScopeH src ) {
		if( src instanceof ICFBamPubSchemaDefH ) {
			setSchemaDef( (ICFBamPubSchemaDefH)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"ICFBamPubSchemaDefH" );
		}
	}

	@Override
	public void setSchemaDef( ICFBamPubSchemaDefH src ) {
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
	public void set( ICFBamPubScope src ) {
		if( src instanceof CFBamPubPubBuffSchemaDef ) {
			setJustPubSchemaDef( (CFBamPubPubBuffSchemaDef)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"CFBamPubPubBuffSchemaDef" );
		}
	}

	@Override
	public void setSchemaDef( ICFBamPubSchemaDef src ) {
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
	public void set( ICFBamPubScopeH src ) {
		if( src instanceof ICFBamPubSchemaDefH ) {
			setSchemaDef( (ICFBamPubSchemaDefH)src );
		}
		else {
			throw new MCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"ICFBamPubSchemaDefH" );
		}
	}

	@Override
	public void setSchemaDef( ICFBamPubSchemaDefH src ) {
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
		String ret = "<CFBamPubBuffSchemaDef" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
