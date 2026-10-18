// Description: Java 17 implJustProtementation of a SubProject buffer

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.intnet.intnet.buff;

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
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetprot.*;
import server.markhome.ycf.v3_1.intnet.intnetprotobj.*;

public class IntNetProtBuffSubProject
	implements IIntNetProtSubProject, Comparable<Object>, Serializable
{
	protected IYCFKeyHash256 requiredId;
	protected int requiredRevision;
	protected YCFDbKeyHash256 createdByUserId = YCFDbKeyHash256.fromHex(IIntNetPubSecUser.S_INIT_CREATED_BY);
	protected YCFDbKeyHash256 createdBySessionId = YCFDbKeyHash256.fromHex(IIntNetPubSecSession.S_SECSESSIONID_INIT_VALUE);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected YCFDbKeyHash256 updatedByUserId = YCFDbKeyHash256.fromHex(IIntNetPubSecUser.S_INIT_UPDATED_BY);
	protected YCFDbKeyHash256 updatedBySessionId = YCFDbKeyHash256.fromHex(IIntNetPubSecSession.S_SECSESSIONID_INIT_VALUE);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected IYCFKeyHash256 requiredTenantId;
	protected IYCFKeyHash256 requiredTopProjectId;
	protected String requiredName;
	protected String optionalDescription;

	public IntNetProtBuffSubProject() {
		requiredId = YCFDbKeyHash256.fromHex( IIntNetPubSubProject.ID_INIT_VALUE.toString() );
		requiredTenantId = YCFDbKeyHash256.fromHex( IIntNetPubSubProject.TENANTID_INIT_VALUE.toString() );
		requiredTopProjectId = YCFDbKeyHash256.fromHex( IIntNetPubSubProject.TOPPROJECTID_INIT_VALUE.toString() );
		requiredName = IIntNetPubSubProject.NAME_INIT_VALUE;
		optionalDescription = null;
	}

	@Override
	public IYCFKeyHash256 getPKey() {
		return (requiredId);
	}

	@Override
	public void setPKey(IYCFKeyHash256 requiredId) {
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
	public List<IIntNetProtMajorVersion> getOptionalComponentsMajorVer(IYCFKeyHash256 argId) {
		IIntNetProtSchema targetBackingIntNet = IIntNetProtSchema.getBackingIntNet();
		if (targetBackingIntNet == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsMajorVer", 0, "IIntNetProtSchema.getBackingIntNet()");
		}
		IIntNetProtMajorVersionTable targetTable = targetBackingIntNet.getTableMajorVersion();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getOptionalComponentsMajorVer", 0, "IIntNetProtSchema.getBackingIntNet().getTableMajorVersion()");
		}
		IIntNetProtMajorVersion[] targetArr = targetTable.readDerivedBySubProjectIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredId());
		if( targetArr != null ) {
			List<IIntNetProtMajorVersion> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return(results);
		}
		else {
			List<IIntNetProtMajorVersion> results = new ArrayList<>();
			return(results);
		}
	}

	@Override
	public YCFDbKeyHash256 getCreatedByUserId() {
		return( createdByUserId );
	}

	@Override
	public void setJustProtCreatedByUserId( YCFDbKeyHash256 value ) {
		createdByUserId = value;
	}

	@Override
	public LocalDateTime getCreatedAt() {
		return( createdAt );
	}

	@Override
	public void setJustProtCreatedAt( LocalDateTime value ) {
		createdAt = value;
	}

	@Override
	public YCFDbKeyHash256 getUpdatedByUserId() {
		return( updatedByUserId );
	}

	@Override
	public void setJustProtUpdatedByUserId( YCFDbKeyHash256 value ) {
		updatedByUserId = value;
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( updatedAt );
	}

	@Override
	public void setJustProtUpdatedAt( LocalDateTime value ) {
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
		return( IIntNetProtSubProject.CLASS_CODE );
	}

	@Override
	public ISecureProtTenant getRequiredOwnerTenant(IYCFKeyHash256 argTenantId) {
		ISecureProtSchema targetBackingSecure = ISecureProtSchema.getBackingSecure();
		if (targetBackingSecure == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredOwnerTenant", 0, "ISecureProtSchema.getBackingSecure()");
		}
		ISecureProtTenantTable targetTable = targetBackingSecure.getTableTenant();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredOwnerTenant", 0, "ISecureProtSchema.getBackingSecure().getTableTenant()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredTenantId()));
	}

	@Override
	public void setRequiredOwnerTenant(IYCFKeyHash256 argTenantId) {
		ISecurePubSchema targetBackingSecure = ISecurePubSchema.getBackingSecure();
		if (targetBackingSecure == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredOwnerTenant-args", 0, "ISecurePubSchema.getBackingSecure()");
		}
		ISecurePubTenantTable targetTable = targetBackingSecure.getTableTenant();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredOwnerTenant", 0, "ISecurePubSchema.getBackingSecure().getTableTenant()");
		}
		ISecurePubTenant found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argTenantId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredOwnerTenant-args", 0, "found");
		}
		else if (found instanceof ISecureProtTenant) || (found instanceof ISecureProtTenant) || (found instanceof ISecurePubTenant)) {
			super.setRequiredOwnerTenant(argTenantId);
		requiredTenantId = argTenantId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredOwnerTenant-args", "found", found, "ISecureProtTenantISecureProtTenantISecurePubTenant");
		}
	}

	@Override
	public void setRequiredOwnerTenant(ISecureProtTenant argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setOwnerTenant", 1, "argObj");
		}
		else {
			setJustProtRequiredTenantId(argObj.getRequiredId());
		}
	}

	@Override
	public void setRequiredOwnerTenant(ISecurePubTenant argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setOwnerTenant", 1, "argObj");
		}
		else {
			setJustProtRequiredTenantId(argObj.getRequiredId());
		}
	}

	@Override
	public IIntNetProtTopProject getRequiredContainerParentTPrj(IYCFKeyHash256 argTopProjectId) {
		IIntNetProtSchema targetBackingIntNet = IIntNetProtSchema.getBackingIntNet();
		if (targetBackingIntNet == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerParentTPrj", 0, "IIntNetProtSchema.getBackingIntNet()");
		}
		IIntNetProtTopProjectTable targetTable = targetBackingIntNet.getTableTopProject();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerParentTPrj", 0, "IIntNetProtSchema.getBackingIntNet().getTableTopProject()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredTopProjectId()));
	}

	@Override
	public void setRequiredContainerParentTPrj(IYCFKeyHash256 argTopProjectId) {
		IIntNetProtSchema targetBackingIntNet = IIntNetProtSchema.getBackingIntNet();
		if (targetBackingIntNet == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerParentTPrj-args", 0, "IIntNetProtSchema.getBackingIntNet()");
		}
		IIntNetProtTopProjectTable targetTable = targetBackingIntNet.getTableTopProject();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerParentTPrj", 0, "IIntNetSchema.getBackingIntNet().getTableTopProject()");
		}
		IIntNetProtTopProject found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argTopProjectId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerParentTPrj-args", 0, "found");
		}
		else if (found instanceof IIntNetProtTopProject) || (found instanceof IIntNetProtTopProject) || (found instanceof IIntNetPubTopProject)) {
			super.setRequiredContainerParentTPrj(argTopProjectId);
		requiredTopProjectId = argTopProjectId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredContainerParentTPrj-args", "found", found, "IIntNetProtTopProjectIIntNetProtTopProjectIIntNetPubTopProject");
		}
	}

	@Override
	public void setRequiredContainerParentTPrj(IIntNetProtTopProject argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerParentTPrj", 1, "argObj");
		}
		else {
			setJustProtRequiredTopProjectId(argObj.getRequiredId());
		}
	}

	@Override
	public void setRequiredContainerParentTPrj(IIntNetPubTopProject argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerParentTPrj", 1, "argObj");
		}
		else {
			setJustProtRequiredTopProjectId(argObj.getRequiredId());
		}
	}

	@Override
	public IYCFKeyHash256 getRequiredTenantId() {
		return(requiredTenantId);
	}

	public void setRequiredTenantId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredTenantId",
				1,
				"value" );
		}
		requiredTenantId = value;
	}

	@Override
	public IYCFKeyHash256 getRequiredTopProjectId() {
		return(requiredTopProjectId);
	}

	public void setRequiredTopProjectId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredTopProjectId",
				1,
				"value" );
		}
		requiredTopProjectId = value;
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
		else if( value.length() > 64 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredName",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		requiredName = value;
	}

	@Override
	public String getOptionalDescription() {
		return(optionalDescription);
	}

	public void setOptionalDescription( String value ) {
		if( value != null && value.length() > 1024 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalDescription",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		optionalDescription = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof IIntNetProtSubProject rhs ) {
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
			if( getRequiredTenantId() != null ) {
				if( rhs.getRequiredTenantId() != null ) {
					if( ! getRequiredTenantId().equals( rhs.getRequiredTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredTopProjectId() != null ) {
				if( rhs.getRequiredTopProjectId() != null ) {
					if( ! getRequiredTopProjectId().equals( rhs.getRequiredTopProjectId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTopProjectId() != null ) {
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
			return( true );
		}
		else if( obj instanceof IIntNetProtSubProjectH rhs ) {
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
			if( getRequiredTenantId() != null ) {
				if( rhs.getRequiredTenantId() != null ) {
					if( ! getRequiredTenantId().equals( rhs.getRequiredTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredTopProjectId() != null ) {
				if( rhs.getRequiredTopProjectId() != null ) {
					if( ! getRequiredTopProjectId().equals( rhs.getRequiredTopProjectId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTopProjectId() != null ) {
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
			return( true );
		}
		else if( obj instanceof IIntNetProtSubProjectHPKey ) {
			IIntNetProtSubProjectHPKey rhs = (IIntNetProtSubProjectHPKey)obj;
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
		else if( obj instanceof IIntNetProtSubProjectByTenantIdxKey rhs ) {
			if( getRequiredTenantId() != null ) {
				if( rhs.getRequiredTenantId() != null ) {
					if( ! getRequiredTenantId().equals( rhs.getRequiredTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTenantId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IIntNetProtSubProjectByTopProjectIdxKey rhs ) {
			if( getRequiredTopProjectId() != null ) {
				if( rhs.getRequiredTopProjectId() != null ) {
					if( ! getRequiredTopProjectId().equals( rhs.getRequiredTopProjectId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTopProjectId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IIntNetProtSubProjectByNameIdxKey rhs ) {
			if( getRequiredTopProjectId() != null ) {
				if( rhs.getRequiredTopProjectId() != null ) {
					if( ! getRequiredTopProjectId().equals( rhs.getRequiredTopProjectId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTopProjectId() != null ) {
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
		else if( obj instanceof IIntNetPubSubProject rhs ) {
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
			if( getRequiredTenantId() != null ) {
				if( rhs.getRequiredTenantId() != null ) {
					if( ! getRequiredTenantId().equals( rhs.getRequiredTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredTopProjectId() != null ) {
				if( rhs.getRequiredTopProjectId() != null ) {
					if( ! getRequiredTopProjectId().equals( rhs.getRequiredTopProjectId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTopProjectId() != null ) {
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
			return( true );
		}
		else if( obj instanceof IIntNetPubSubProjectH rhs ) {
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
			if( getRequiredTenantId() != null ) {
				if( rhs.getRequiredTenantId() != null ) {
					if( ! getRequiredTenantId().equals( rhs.getRequiredTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredTopProjectId() != null ) {
				if( rhs.getRequiredTopProjectId() != null ) {
					if( ! getRequiredTopProjectId().equals( rhs.getRequiredTopProjectId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTopProjectId() != null ) {
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
			return( true );
		}
		else if( obj instanceof IIntNetPubSubProjectHPKey rhs ) {
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
		else if( obj instanceof IIntNetProtSubProjectByTenantIdxKey rhs ) {
			if( getRequiredTenantId() != null ) {
				if( rhs.getRequiredTenantId() != null ) {
					if( ! getRequiredTenantId().equals( rhs.getRequiredTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTenantId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IIntNetProtSubProjectByTopProjectIdxKey rhs ) {
			if( getRequiredTopProjectId() != null ) {
				if( rhs.getRequiredTopProjectId() != null ) {
					if( ! getRequiredTopProjectId().equals( rhs.getRequiredTopProjectId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTopProjectId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IIntNetProtSubProjectByNameIdxKey rhs ) {
			if( getRequiredTopProjectId() != null ) {
				if( rhs.getRequiredTopProjectId() != null ) {
					if( ! getRequiredTopProjectId().equals( rhs.getRequiredTopProjectId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTopProjectId() != null ) {
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
		hashCode = hashCode + getRequiredId().hashCode();
		hashCode = hashCode + getRequiredTenantId().hashCode();
		hashCode = hashCode + getRequiredTopProjectId().hashCode();
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalDescription() != null ) {
			hashCode = hashCode + getOptionalDescription().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof IIntNetProtSubProject rhs ) {
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
			if (getRequiredTenantId() != null) {
				if (rhs.getRequiredTenantId() != null) {
					cmp = getRequiredTenantId().compareTo( rhs.getRequiredTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTenantId() != null) {
				return( -1 );
			}
			if (getRequiredTopProjectId() != null) {
				if (rhs.getRequiredTopProjectId() != null) {
					cmp = getRequiredTopProjectId().compareTo( rhs.getRequiredTopProjectId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTopProjectId() != null) {
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
			return( 0 );
 		}
		else if( obj instanceof IIntNetProtSubProjectHPKey rhs ) {
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
		else if( obj instanceof IIntNetProtSubProjectH rhs ) {
			cmp = 0;
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
			if (getRequiredTenantId() != null) {
				if (rhs.getRequiredTenantId() != null) {
					cmp = getRequiredTenantId().compareTo( rhs.getRequiredTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTenantId() != null) {
				return( -1 );
			}
			if (getRequiredTopProjectId() != null) {
				if (rhs.getRequiredTopProjectId() != null) {
					cmp = getRequiredTopProjectId().compareTo( rhs.getRequiredTopProjectId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTopProjectId() != null) {
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
			return( 0 );
		}
		else if( obj instanceof IIntNetProtSubProjectByTenantIdxKey rhs ) {
			if (getRequiredTenantId() != null) {
				if (rhs.getRequiredTenantId() != null) {
					cmp = getRequiredTenantId().compareTo( rhs.getRequiredTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTenantId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IIntNetProtSubProjectByTopProjectIdxKey rhs ) {
			if (getRequiredTopProjectId() != null) {
				if (rhs.getRequiredTopProjectId() != null) {
					cmp = getRequiredTopProjectId().compareTo( rhs.getRequiredTopProjectId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTopProjectId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IIntNetProtSubProjectByNameIdxKey rhs ) {
			if (getRequiredTopProjectId() != null) {
				if (rhs.getRequiredTopProjectId() != null) {
					cmp = getRequiredTopProjectId().compareTo( rhs.getRequiredTopProjectId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTopProjectId() != null) {
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
		else if( obj instanceof IIntNetPubSubProject rhs ) {
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
			if (getRequiredTenantId() != null) {
				if (rhs.getRequiredTenantId() != null) {
					cmp = getRequiredTenantId().compareTo( rhs.getRequiredTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTenantId() != null) {
				return( -1 );
			}
			if (getRequiredTopProjectId() != null) {
				if (rhs.getRequiredTopProjectId() != null) {
					cmp = getRequiredTopProjectId().compareTo( rhs.getRequiredTopProjectId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTopProjectId() != null) {
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
			return( 0 );
		}
		else if( obj instanceof IIntNetPubSubProjectHPKey rhs ) {
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
		else if( obj instanceof IIntNetPubSubProjectH rhs ) {
			cmp = 0;
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
			if (getRequiredTenantId() != null) {
				if (rhs.getRequiredTenantId() != null) {
					cmp = getRequiredTenantId().compareTo( rhs.getRequiredTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTenantId() != null) {
				return( -1 );
			}
			if (getRequiredTopProjectId() != null) {
				if (rhs.getRequiredTopProjectId() != null) {
					cmp = getRequiredTopProjectId().compareTo( rhs.getRequiredTopProjectId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTopProjectId() != null) {
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
			return( 0 );
		}
		else if( obj instanceof IIntNetPubSubProjectByTenantIdxKey rhs ) {
			if (getRequiredTenantId() != null) {
				if (rhs.getRequiredTenantId() != null) {
					cmp = getRequiredTenantId().compareTo( rhs.getRequiredTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTenantId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IIntNetPubSubProjectByTopProjectIdxKey rhs ) {
			if (getRequiredTopProjectId() != null) {
				if (rhs.getRequiredTopProjectId() != null) {
					cmp = getRequiredTopProjectId().compareTo( rhs.getRequiredTopProjectId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTopProjectId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IIntNetPubSubProjectByNameIdxKey rhs ) {
			if (getRequiredTopProjectId() != null) {
				if (rhs.getRequiredTopProjectId() != null) {
					cmp = getRequiredTopProjectId().compareTo( rhs.getRequiredTopProjectId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTopProjectId() != null) {
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
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	@Override
	public void set( IIntNetProtSubProject src ) {
		setJustProtSubProject( src );
	}

	@Override
	public void setSubProject( IIntNetProtSubProject src ) {
		setJustProtRequiredId(src.getRequiredId());
		setJustProtRequiredRevision( src.getRequiredRevision() );
		setJustProtCreatedByUserId( src.getCreatedByUserId() );
		setJustProtCreatedAt( src.getCreatedAt() );
		setJustProtUpdatedByUserId( src.getUpdatedByUserId() );
		setJustProtUpdatedAt( src.getUpdatedAt() );
		setJustProtRequiredOwnerTenant(src.getRequiredOwnerTenant());
		setJustProtRequiredContainerParentTPrj(src.getRequiredContainerParentTPrj());
		setJustProtRequiredTenantId(src.getRequiredTenantId());
		setJustProtRequiredTopProjectId(src.getRequiredTopProjectId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalDescription(src.getOptionalDescription());
	}

	@Override
	public void set( IIntNetProtSubProjectH src ) {
		setJustProtSubProject( src );
	}

	@Override
	public void setSubProject( IIntNetProtSubProjectH src ) {
		setJustProtRequiredId(src.getRequiredId());
		setJustProtRequiredOwnerTenant(src.getRequiredOwnerTenant());
		setJustProtRequiredContainerParentTPrj(src.getRequiredContainerParentTPrj());
		setJustProtRequiredTenantId(src.getRequiredTenantId());
		setJustProtRequiredTopProjectId(src.getRequiredTopProjectId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalDescription(src.getOptionalDescription());
	}

	@Override
	public void set( IIntNetPubSubProject src ) {
		setJustProtSubProject( src );
	}

	@Override
	public void setSubProject( IIntNetPubSubProject src ) {
		setJustProtRequiredId(src.getRequiredId());
		setJustProtRequiredRevision( src.getRequiredRevision() );
		setJustProtCreatedByUserId( src.getCreatedByUserId() );
		setJustProtCreatedAt( src.getCreatedAt() );
		setJustProtUpdatedByUserId( src.getUpdatedByUserId() );
		setJustProtUpdatedAt( src.getUpdatedAt() );
		setJustProtRequiredOwnerTenant(src.getRequiredOwnerTenant());
		setJustProtRequiredContainerParentTPrj(src.getRequiredContainerParentTPrj());
		setJustProtRequiredTenantId(src.getRequiredTenantId());
		setJustProtRequiredTopProjectId(src.getRequiredTopProjectId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalDescription(src.getOptionalDescription());
	}

	@Override
	public void set( IIntNetPubSubProjectH src ) {
		setJustProtSubProject( src );
	}

	@Override
	public void setSubProject( IIntNetPubSubProjectH src ) {
		setJustProtRequiredId(src.getRequiredId());
		setJustProtRequiredOwnerTenant(src.getRequiredOwnerTenant());
		setJustProtRequiredContainerParentTPrj(src.getRequiredContainerParentTPrj());
		setJustProtRequiredTenantId(src.getRequiredTenantId());
		setJustProtRequiredTopProjectId(src.getRequiredTopProjectId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalDescription(src.getOptionalDescription());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = pkey.getXmlAttrFragment()
			+ " classCode=\"" + getClassCode() + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\"" + "\"" + getRequiredId().toString() + "\"" + "\"" + getRequiredTenantId().toString() + "\"" + "\"" + getRequiredTopProjectId().toString() + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"" + ( ( getOptionalDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDescription() ) + "\"" );
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<IntNetProtBuffSubProject" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
