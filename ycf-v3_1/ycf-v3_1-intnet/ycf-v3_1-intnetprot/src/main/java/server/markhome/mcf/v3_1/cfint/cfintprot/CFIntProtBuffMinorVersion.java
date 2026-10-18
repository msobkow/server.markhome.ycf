// Description: Java 17 implJustProtementation of a MinorVersion buffer

/*
 *	server.markhome.mcf.CFInt
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFInt - Internet Essentials
 *	
 *	This file is part of Mark's Code Fractal CFInt.
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

package server.markhome.mcf.v3_1.cfint.cfint.buff;

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
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintprot.*;
import server.markhome.mcf.v3_1.cfint.cfintprotobj.*;

public class CFIntProtBuffMinorVersion
	implements ICFIntProtMinorVersion, Comparable<Object>, Serializable
{
	protected IMCFKeyHash256 requiredId;
	protected int requiredRevision;
	protected MCFDbKeyHash256 createdByUserId = MCFDbKeyHash256.fromHex(ICFIntPubSecUser.S_INIT_CREATED_BY);
	protected MCFDbKeyHash256 createdBySessionId = MCFDbKeyHash256.fromHex(ICFIntPubSecSession.S_SECSESSIONID_INIT_VALUE);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected MCFDbKeyHash256 updatedByUserId = MCFDbKeyHash256.fromHex(ICFIntPubSecUser.S_INIT_UPDATED_BY);
	protected MCFDbKeyHash256 updatedBySessionId = MCFDbKeyHash256.fromHex(ICFIntPubSecSession.S_SECSESSIONID_INIT_VALUE);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected IMCFKeyHash256 requiredTenantId;
	protected IMCFKeyHash256 requiredMajorVersionId;
	protected String requiredName;
	protected String optionalDescription;

	public CFIntProtBuffMinorVersion() {
		requiredId = MCFDbKeyHash256.fromHex( ICFIntPubMinorVersion.ID_INIT_VALUE.toString() );
		requiredTenantId = MCFDbKeyHash256.fromHex( ICFIntPubMinorVersion.TENANTID_INIT_VALUE.toString() );
		requiredMajorVersionId = MCFDbKeyHash256.fromHex( ICFIntPubMinorVersion.MAJORVERSIONID_INIT_VALUE.toString() );
		requiredName = ICFIntPubMinorVersion.NAME_INIT_VALUE;
		optionalDescription = null;
	}

	@Override
	public IMCFKeyHash256 getPKey() {
		return (requiredId);
	}

	@Override
	public void setPKey(IMCFKeyHash256 requiredId) {
		if(requiredId != null) {
			this.requiredId = requiredId;
		}
	}

	@Override
	public IMCFKeyHash256 getRequiredId() {
		return(requiredId);
	}

	public void setRequiredId( IMCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredId",
				1,
				"value" );
		}
		requiredId = value;
	}

	@Override
	public MCFDbKeyHash256 getCreatedByUserId() {
		return( createdByUserId );
	}

	@Override
	public void setJustProtCreatedByUserId( MCFDbKeyHash256 value ) {
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
	public MCFDbKeyHash256 getUpdatedByUserId() {
		return( updatedByUserId );
	}

	@Override
	public void setJustProtUpdatedByUserId( MCFDbKeyHash256 value ) {
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
		return( ICFIntProtMinorVersion.CLASS_CODE );
	}

	@Override
	public ICFSecProtTenant getRequiredOwnerTenant(IMCFKeyHash256 argTenantId) {
		ICFSecProtSchema targetBackingCFSec = ICFSecProtSchema.getBackingCFSec();
		if (targetBackingCFSec == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredOwnerTenant", 0, "ICFSecProtSchema.getBackingCFSec()");
		}
		ICFSecProtTenantTable targetTable = targetBackingCFSec.getTableTenant();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredOwnerTenant", 0, "ICFSecProtSchema.getBackingCFSec().getTableTenant()");
		}
		return(targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredTenantId()));
	}

	@Override
	public void setRequiredOwnerTenant(IMCFKeyHash256 argTenantId) {
		ICFSecPubSchema targetBackingCFSec = ICFSecPubSchema.getBackingCFSec();
		if (targetBackingCFSec == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredOwnerTenant-args", 0, "ICFSecPubSchema.getBackingCFSec()");
		}
		ICFSecPubTenantTable targetTable = targetBackingCFSec.getTableTenant();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredOwnerTenant", 0, "ICFSecPubSchema.getBackingCFSec().getTableTenant()");
		}
		ICFSecPubTenant found = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argTenantId);
		if (found == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredOwnerTenant-args", 0, "found");
		}
		else if (found instanceof ICFSecProtTenant) || (found instanceof ICFSecProtTenant) || (found instanceof ICFSecPubTenant)) {
			super.setRequiredOwnerTenant(argTenantId);
		requiredTenantId = argTenantId;
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setRequiredOwnerTenant-args", "found", found, "ICFSecProtTenantICFSecProtTenantICFSecPubTenant");
		}
	}

	@Override
	public void setRequiredOwnerTenant(ICFSecProtTenant argObj) {

		if(argObj == null) {
			throw new MCFNullArgumentException(getClass(), "setOwnerTenant", 1, "argObj");
		}
		else {
			setJustProtRequiredTenantId(argObj.getRequiredId());
		}
	}

	@Override
	public void setRequiredOwnerTenant(ICFSecPubTenant argObj) {

		if(argObj == null) {
			throw new MCFNullArgumentException(getClass(), "setOwnerTenant", 1, "argObj");
		}
		else {
			setJustProtRequiredTenantId(argObj.getRequiredId());
		}
	}

	@Override
	public ICFIntProtMajorVersion getRequiredContainerParentMajVer(IMCFKeyHash256 argMajorVersionId) {
		ICFIntProtSchema targetBackingCFInt = ICFIntProtSchema.getBackingCFInt();
		if (targetBackingCFInt == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredContainerParentMajVer", 0, "ICFIntProtSchema.getBackingCFInt()");
		}
		ICFIntProtMajorVersionTable targetTable = targetBackingCFInt.getTableMajorVersion();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "getRequiredContainerParentMajVer", 0, "ICFIntProtSchema.getBackingCFInt().getTableMajorVersion()");
		}
		return(targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredMajorVersionId()));
	}

	@Override
	public void setRequiredContainerParentMajVer(IMCFKeyHash256 argMajorVersionId) {
		ICFIntProtSchema targetBackingCFInt = ICFIntProtSchema.getBackingCFInt();
		if (targetBackingCFInt == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerParentMajVer-args", 0, "ICFIntProtSchema.getBackingCFInt()");
		}
		ICFIntProtMajorVersionTable targetTable = targetBackingCFInt.getTableMajorVersion();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerParentMajVer", 0, "ICFIntSchema.getBackingCFInt().getTableMajorVersion()");
		}
		ICFIntProtMajorVersion found = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argMajorVersionId);
		if (found == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerParentMajVer-args", 0, "found");
		}
		else if (found instanceof ICFIntProtMajorVersion) || (found instanceof ICFIntProtMajorVersion) || (found instanceof ICFIntPubMajorVersion)) {
			super.setRequiredContainerParentMajVer(argMajorVersionId);
		requiredMajorVersionId = argMajorVersionId;
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setRequiredContainerParentMajVer-args", "found", found, "ICFIntProtMajorVersionICFIntProtMajorVersionICFIntPubMajorVersion");
		}
	}

	@Override
	public void setRequiredContainerParentMajVer(ICFIntProtMajorVersion argObj) {

		if(argObj == null) {
			throw new MCFNullArgumentException(getClass(), "setContainerParentMajVer", 1, "argObj");
		}
		else {
			setJustProtRequiredMajorVersionId(argObj.getRequiredId());
		}
	}

	@Override
	public void setRequiredContainerParentMajVer(ICFIntPubMajorVersion argObj) {

		if(argObj == null) {
			throw new MCFNullArgumentException(getClass(), "setContainerParentMajVer", 1, "argObj");
		}
		else {
			setJustProtRequiredMajorVersionId(argObj.getRequiredId());
		}
	}

	@Override
	public IMCFKeyHash256 getRequiredTenantId() {
		return(requiredTenantId);
	}

	public void setRequiredTenantId( IMCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredTenantId",
				1,
				"value" );
		}
		requiredTenantId = value;
	}

	@Override
	public IMCFKeyHash256 getRequiredMajorVersionId() {
		return(requiredMajorVersionId);
	}

	public void setRequiredMajorVersionId( IMCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredMajorVersionId",
				1,
				"value" );
		}
		requiredMajorVersionId = value;
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
		else if( value.length() > 64 ) {
			throw new MCFArgumentOverflowException( getClass(),
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
			throw new MCFArgumentOverflowException( getClass(),
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
		else if( obj instanceof ICFIntProtMinorVersion rhs ) {
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
			if( getRequiredMajorVersionId() != null ) {
				if( rhs.getRequiredMajorVersionId() != null ) {
					if( ! getRequiredMajorVersionId().equals( rhs.getRequiredMajorVersionId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredMajorVersionId() != null ) {
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
		else if( obj instanceof ICFIntProtMinorVersionH rhs ) {
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
			if( getRequiredMajorVersionId() != null ) {
				if( rhs.getRequiredMajorVersionId() != null ) {
					if( ! getRequiredMajorVersionId().equals( rhs.getRequiredMajorVersionId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredMajorVersionId() != null ) {
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
		else if( obj instanceof ICFIntProtMinorVersionHPKey ) {
			ICFIntProtMinorVersionHPKey rhs = (ICFIntProtMinorVersionHPKey)obj;
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
		else if( obj instanceof ICFIntProtMinorVersionByTenantIdxKey rhs ) {
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
		else if( obj instanceof ICFIntProtMinorVersionByMajorVerIdxKey rhs ) {
			if( getRequiredMajorVersionId() != null ) {
				if( rhs.getRequiredMajorVersionId() != null ) {
					if( ! getRequiredMajorVersionId().equals( rhs.getRequiredMajorVersionId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredMajorVersionId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFIntProtMinorVersionByNameIdxKey rhs ) {
			if( getRequiredMajorVersionId() != null ) {
				if( rhs.getRequiredMajorVersionId() != null ) {
					if( ! getRequiredMajorVersionId().equals( rhs.getRequiredMajorVersionId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredMajorVersionId() != null ) {
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
		else if( obj instanceof ICFIntPubMinorVersion rhs ) {
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
			if( getRequiredMajorVersionId() != null ) {
				if( rhs.getRequiredMajorVersionId() != null ) {
					if( ! getRequiredMajorVersionId().equals( rhs.getRequiredMajorVersionId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredMajorVersionId() != null ) {
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
		else if( obj instanceof ICFIntPubMinorVersionH rhs ) {
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
			if( getRequiredMajorVersionId() != null ) {
				if( rhs.getRequiredMajorVersionId() != null ) {
					if( ! getRequiredMajorVersionId().equals( rhs.getRequiredMajorVersionId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredMajorVersionId() != null ) {
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
		else if( obj instanceof ICFIntPubMinorVersionHPKey rhs ) {
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
		else if( obj instanceof ICFIntProtMinorVersionByTenantIdxKey rhs ) {
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
		else if( obj instanceof ICFIntProtMinorVersionByMajorVerIdxKey rhs ) {
			if( getRequiredMajorVersionId() != null ) {
				if( rhs.getRequiredMajorVersionId() != null ) {
					if( ! getRequiredMajorVersionId().equals( rhs.getRequiredMajorVersionId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredMajorVersionId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFIntProtMinorVersionByNameIdxKey rhs ) {
			if( getRequiredMajorVersionId() != null ) {
				if( rhs.getRequiredMajorVersionId() != null ) {
					if( ! getRequiredMajorVersionId().equals( rhs.getRequiredMajorVersionId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredMajorVersionId() != null ) {
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
			boolean retval = super.equals( obj );
			return( retval );
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
		hashCode = hashCode + getRequiredMajorVersionId().hashCode();
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
		else if( obj instanceof ICFIntProtMinorVersion rhs ) {
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
			if (getRequiredMajorVersionId() != null) {
				if (rhs.getRequiredMajorVersionId() != null) {
					cmp = getRequiredMajorVersionId().compareTo( rhs.getRequiredMajorVersionId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredMajorVersionId() != null) {
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
		else if( obj instanceof ICFIntProtMinorVersionHPKey rhs ) {
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
		else if( obj instanceof ICFIntProtMinorVersionH rhs ) {
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
			if (getRequiredMajorVersionId() != null) {
				if (rhs.getRequiredMajorVersionId() != null) {
					cmp = getRequiredMajorVersionId().compareTo( rhs.getRequiredMajorVersionId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredMajorVersionId() != null) {
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
		else if( obj instanceof ICFIntProtMinorVersionByTenantIdxKey rhs ) {
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
		else if( obj instanceof ICFIntProtMinorVersionByMajorVerIdxKey rhs ) {
			if (getRequiredMajorVersionId() != null) {
				if (rhs.getRequiredMajorVersionId() != null) {
					cmp = getRequiredMajorVersionId().compareTo( rhs.getRequiredMajorVersionId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredMajorVersionId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFIntProtMinorVersionByNameIdxKey rhs ) {
			if (getRequiredMajorVersionId() != null) {
				if (rhs.getRequiredMajorVersionId() != null) {
					cmp = getRequiredMajorVersionId().compareTo( rhs.getRequiredMajorVersionId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredMajorVersionId() != null) {
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
		else if( obj instanceof ICFIntPubMinorVersion rhs ) {
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
			if (getRequiredMajorVersionId() != null) {
				if (rhs.getRequiredMajorVersionId() != null) {
					cmp = getRequiredMajorVersionId().compareTo( rhs.getRequiredMajorVersionId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredMajorVersionId() != null) {
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
		else if( obj instanceof ICFIntPubMinorVersionHPKey rhs ) {
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
		else if( obj instanceof ICFIntPubMinorVersionH rhs ) {
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
			if (getRequiredMajorVersionId() != null) {
				if (rhs.getRequiredMajorVersionId() != null) {
					cmp = getRequiredMajorVersionId().compareTo( rhs.getRequiredMajorVersionId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredMajorVersionId() != null) {
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
		else if( obj instanceof ICFIntPubMinorVersionByTenantIdxKey rhs ) {
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
		else if( obj instanceof ICFIntPubMinorVersionByMajorVerIdxKey rhs ) {
			if (getRequiredMajorVersionId() != null) {
				if (rhs.getRequiredMajorVersionId() != null) {
					cmp = getRequiredMajorVersionId().compareTo( rhs.getRequiredMajorVersionId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredMajorVersionId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFIntPubMinorVersionByNameIdxKey rhs ) {
			if (getRequiredMajorVersionId() != null) {
				if (rhs.getRequiredMajorVersionId() != null) {
					cmp = getRequiredMajorVersionId().compareTo( rhs.getRequiredMajorVersionId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredMajorVersionId() != null) {
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
			throw new MCFUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	@Override
	public void set( ICFIntProtMinorVersion src ) {
		setJustProtMinorVersion( src );
	}

	@Override
	public void setMinorVersion( ICFIntProtMinorVersion src ) {
		setJustProtRequiredId(src.getRequiredId());
		setJustProtRequiredRevision( src.getRequiredRevision() );
		setJustProtCreatedByUserId( src.getCreatedByUserId() );
		setJustProtCreatedAt( src.getCreatedAt() );
		setJustProtUpdatedByUserId( src.getUpdatedByUserId() );
		setJustProtUpdatedAt( src.getUpdatedAt() );
		setJustProtRequiredOwnerTenant(src.getRequiredOwnerTenant());
		setJustProtRequiredContainerParentMajVer(src.getRequiredContainerParentMajVer());
		setJustProtRequiredTenantId(src.getRequiredTenantId());
		setJustProtRequiredMajorVersionId(src.getRequiredMajorVersionId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalDescription(src.getOptionalDescription());
	}

	@Override
	public void set( ICFIntProtMinorVersionH src ) {
		setJustProtMinorVersion( src );
	}

	@Override
	public void setMinorVersion( ICFIntProtMinorVersionH src ) {
		setJustProtRequiredId(src.getRequiredId());
		setJustProtRequiredOwnerTenant(src.getRequiredOwnerTenant());
		setJustProtRequiredContainerParentMajVer(src.getRequiredContainerParentMajVer());
		setJustProtRequiredTenantId(src.getRequiredTenantId());
		setJustProtRequiredMajorVersionId(src.getRequiredMajorVersionId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalDescription(src.getOptionalDescription());
	}

	@Override
	public void set( ICFIntPubMinorVersion src ) {
		setJustProtMinorVersion( src );
	}

	@Override
	public void setMinorVersion( ICFIntPubMinorVersion src ) {
		setJustProtRequiredId(src.getRequiredId());
		setJustProtRequiredRevision( src.getRequiredRevision() );
		setJustProtCreatedByUserId( src.getCreatedByUserId() );
		setJustProtCreatedAt( src.getCreatedAt() );
		setJustProtUpdatedByUserId( src.getUpdatedByUserId() );
		setJustProtUpdatedAt( src.getUpdatedAt() );
		setJustProtRequiredOwnerTenant(src.getRequiredOwnerTenant());
		setJustProtRequiredContainerParentMajVer(src.getRequiredContainerParentMajVer());
		setJustProtRequiredTenantId(src.getRequiredTenantId());
		setJustProtRequiredMajorVersionId(src.getRequiredMajorVersionId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalDescription(src.getOptionalDescription());
	}

	@Override
	public void set( ICFIntPubMinorVersionH src ) {
		setJustProtMinorVersion( src );
	}

	@Override
	public void setMinorVersion( ICFIntPubMinorVersionH src ) {
		setJustProtRequiredId(src.getRequiredId());
		setJustProtRequiredOwnerTenant(src.getRequiredOwnerTenant());
		setJustProtRequiredContainerParentMajVer(src.getRequiredContainerParentMajVer());
		setJustProtRequiredTenantId(src.getRequiredTenantId());
		setJustProtRequiredMajorVersionId(src.getRequiredMajorVersionId());
		setJustProtRequiredName(src.getRequiredName());
		setJustProtOptionalDescription(src.getOptionalDescription());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = pkey.getXmlAttrFragment()
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\"" + "\"" + getRequiredId().toString() + "\"" + "\"" + getRequiredTenantId().toString() + "\"" + "\"" + getRequiredMajorVersionId().toString() + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"" + ( ( getOptionalDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDescription() ) + "\"" );
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFIntProtBuffMinorVersion" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
