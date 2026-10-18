// Description: Java 17 implJustPubementation of a License buffer

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
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;

public class IntNetPubBuffLicense
	implements IIntNetPubLicense, Comparable<Object>, Serializable
{
	protected IYCFKeyHash256 requiredId;
	protected int requiredRevision;
	protected IYCFKeyHash256 requiredTenantId;
	protected IYCFKeyHash256 requiredTopDomainId;
	protected String requiredName;
	protected String optionalDescription;
	protected String optionalEmbeddedText;
	protected String optionalFullText;

	public IntNetPubBuffLicense() {
		requiredId = YCFDbKeyHash256.fromHex( IIntNetPubLicense.ID_INIT_VALUE.toString() );
		requiredTenantId = YCFDbKeyHash256.fromHex( IIntNetPubLicense.TENANTID_INIT_VALUE.toString() );
		requiredTopDomainId = YCFDbKeyHash256.fromHex( IIntNetPubLicense.TOPDOMAINID_INIT_VALUE.toString() );
		requiredName = IIntNetPubLicense.NAME_INIT_VALUE;
		optionalDescription = null;
		optionalEmbeddedText = null;
		optionalFullText = null;
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
	public int getRequiredRevision() {
		return( requiredRevision );
	}

	@Override
	public void setRequiredRevision( int value ) {
		requiredRevision = value;
	}

	@Override
	public int getClassCode() {
		return( IIntNetPubLicense.CLASS_CODE );
	}

	@Override
	public ISecurePubTenant getRequiredOwnerTenant(IYCFKeyHash256 argTenantId) {
		ISecurePubSchema targetBackingSecure = ISecurePubSchema.getBackingSecure();
		if (targetBackingSecure == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredOwnerTenant", 0, "ISecurePubSchema.getBackingSecure()");
		}
		ISecurePubTenantTable targetTable = targetBackingSecure.getTableTenant();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredOwnerTenant", 0, "ISecurePubSchema.getBackingSecure().getTableTenant()");
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
			throw new YCFNullArgumentException(getClass(), "setRequiredOwnerTenant", 0, "ISecureSchema.getBackingSecure().getTableTenant()");
		}
		ISecurePubTenant found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argTenantId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredOwnerTenant-args", 0, "found");
		}
		else if (found instanceof ISecurePubTenant) || (found instanceof ISecurePubTenant)) {
			super.setRequiredOwnerTenant(argTenantId);
		requiredTenantId = argTenantId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredOwnerTenant-args", "found", found, "ISecurePubTenantISecurePubTenant");
		}
	}

	@Override
	public void setRequiredOwnerTenant(ISecurePubTenant argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setOwnerTenant", 1, "argObj");
		}
		else {
			setRequiredTenantId(argObj.getRequiredId());
		}
	}

	@Override
	public IIntNetPubTopDomain getRequiredContainerTopDomain(IYCFKeyHash256 argTopDomainId) {
		IIntNetPubSchema targetBackingIntNet = IIntNetPubSchema.getBackingIntNet();
		if (targetBackingIntNet == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerTopDomain", 0, "IIntNetPubSchema.getBackingIntNet()");
		}
		IIntNetPubTopDomainTable targetTable = targetBackingIntNet.getTableTopDomain();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "getRequiredContainerTopDomain", 0, "IIntNetPubSchema.getBackingIntNet().getTableTopDomain()");
		}
		return(targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredTopDomainId()));
	}

	@Override
	public void setRequiredContainerTopDomain(IYCFKeyHash256 argTopDomainId) {
		IIntNetPubSchema targetBackingIntNet = IIntNetPubSchema.getBackingIntNet();
		if (targetBackingIntNet == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerTopDomain-args", 0, "IIntNetPubSchema.getBackingIntNet()");
		}
		IIntNetPubTopDomainTable targetTable = targetBackingIntNet.getTableTopDomain();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerTopDomain", 0, "IIntNetSchema.getBackingIntNet().getTableTopDomain()");
		}
		IIntNetPubTopDomain found = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argTopDomainId);
		if (found == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerTopDomain-args", 0, "found");
		}
		else if (found instanceof IIntNetPubTopDomain) || (found instanceof IIntNetPubTopDomain)) {
			super.setRequiredContainerTopDomain(argTopDomainId);
		requiredTopDomainId = argTopDomainId;
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setRequiredContainerTopDomain-args", "found", found, "IIntNetPubTopDomainIIntNetPubTopDomain");
		}
	}

	@Override
	public void setRequiredContainerTopDomain(IIntNetPubTopDomain argObj) {

		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerTopDomain", 1, "argObj");
		}
		else {
			setRequiredTopDomainId(argObj.getRequiredId());
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
	public IYCFKeyHash256 getRequiredTopDomainId() {
		return(requiredTopDomainId);
	}

	public void setRequiredTopDomainId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredTopDomainId",
				1,
				"value" );
		}
		requiredTopDomainId = value;
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
	public String getOptionalEmbeddedText() {
		return(optionalEmbeddedText);
	}

	public void setOptionalEmbeddedText( String value ) {
		if( value != null && value.length() > 8000 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalEmbeddedText",
				1,
				"value.length()",
				value.length(),
				8000 );
		}
		optionalEmbeddedText = value;
	}

	@Override
	public String getOptionalFullText() {
		return(optionalFullText);
	}

	public void setOptionalFullText( String value ) {
		if( value != null && value.length() > 8000 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalFullText",
				1,
				"value.length()",
				value.length(),
				8000 );
		}
		optionalFullText = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof IIntNetPubLicense rhs ) {
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
			if( getRequiredTopDomainId() != null ) {
				if( rhs.getRequiredTopDomainId() != null ) {
					if( ! getRequiredTopDomainId().equals( rhs.getRequiredTopDomainId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTopDomainId() != null ) {
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
			if( getOptionalEmbeddedText() != null ) {
				if( rhs.getOptionalEmbeddedText() != null ) {
					if( ! getOptionalEmbeddedText().equals( rhs.getOptionalEmbeddedText() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalEmbeddedText() != null ) {
					return( false );
				}
			}
			if( getOptionalFullText() != null ) {
				if( rhs.getOptionalFullText() != null ) {
					if( ! getOptionalFullText().equals( rhs.getOptionalFullText() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalFullText() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IIntNetPubLicenseH rhs ) {
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
			if( getRequiredTopDomainId() != null ) {
				if( rhs.getRequiredTopDomainId() != null ) {
					if( ! getRequiredTopDomainId().equals( rhs.getRequiredTopDomainId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTopDomainId() != null ) {
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
			if( getOptionalEmbeddedText() != null ) {
				if( rhs.getOptionalEmbeddedText() != null ) {
					if( ! getOptionalEmbeddedText().equals( rhs.getOptionalEmbeddedText() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalEmbeddedText() != null ) {
					return( false );
				}
			}
			if( getOptionalFullText() != null ) {
				if( rhs.getOptionalFullText() != null ) {
					if( ! getOptionalFullText().equals( rhs.getOptionalFullText() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalFullText() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IIntNetPubLicenseHPKey ) {
			IIntNetPubLicenseHPKey rhs = (IIntNetPubLicenseHPKey)obj;
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
		else if( obj instanceof IIntNetPubLicenseByLicnTenantIdxKey rhs ) {
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
		else if( obj instanceof IIntNetPubLicenseByDomainIdxKey rhs ) {
			if( getRequiredTopDomainId() != null ) {
				if( rhs.getRequiredTopDomainId() != null ) {
					if( ! getRequiredTopDomainId().equals( rhs.getRequiredTopDomainId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTopDomainId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IIntNetPubLicenseByUNameIdxKey rhs ) {
			if( getRequiredTopDomainId() != null ) {
				if( rhs.getRequiredTopDomainId() != null ) {
					if( ! getRequiredTopDomainId().equals( rhs.getRequiredTopDomainId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTopDomainId() != null ) {
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
		else if( obj instanceof IIntNetPubLicense rhs ) {
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
			if( getRequiredTopDomainId() != null ) {
				if( rhs.getRequiredTopDomainId() != null ) {
					if( ! getRequiredTopDomainId().equals( rhs.getRequiredTopDomainId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTopDomainId() != null ) {
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
			if( getOptionalEmbeddedText() != null ) {
				if( rhs.getOptionalEmbeddedText() != null ) {
					if( ! getOptionalEmbeddedText().equals( rhs.getOptionalEmbeddedText() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalEmbeddedText() != null ) {
					return( false );
				}
			}
			if( getOptionalFullText() != null ) {
				if( rhs.getOptionalFullText() != null ) {
					if( ! getOptionalFullText().equals( rhs.getOptionalFullText() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalFullText() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IIntNetPubLicenseH rhs ) {
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
			if( getRequiredTopDomainId() != null ) {
				if( rhs.getRequiredTopDomainId() != null ) {
					if( ! getRequiredTopDomainId().equals( rhs.getRequiredTopDomainId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTopDomainId() != null ) {
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
			if( getOptionalEmbeddedText() != null ) {
				if( rhs.getOptionalEmbeddedText() != null ) {
					if( ! getOptionalEmbeddedText().equals( rhs.getOptionalEmbeddedText() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalEmbeddedText() != null ) {
					return( false );
				}
			}
			if( getOptionalFullText() != null ) {
				if( rhs.getOptionalFullText() != null ) {
					if( ! getOptionalFullText().equals( rhs.getOptionalFullText() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalFullText() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IIntNetPubLicenseHPKey rhs ) {
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
		else if( obj instanceof IIntNetPubLicenseByLicnTenantIdxKey rhs ) {
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
		else if( obj instanceof IIntNetPubLicenseByDomainIdxKey rhs ) {
			if( getRequiredTopDomainId() != null ) {
				if( rhs.getRequiredTopDomainId() != null ) {
					if( ! getRequiredTopDomainId().equals( rhs.getRequiredTopDomainId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTopDomainId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof IIntNetPubLicenseByUNameIdxKey rhs ) {
			if( getRequiredTopDomainId() != null ) {
				if( rhs.getRequiredTopDomainId() != null ) {
					if( ! getRequiredTopDomainId().equals( rhs.getRequiredTopDomainId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTopDomainId() != null ) {
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
		hashCode = hashCode + getRequiredId().hashCode();
		hashCode = hashCode + getRequiredTenantId().hashCode();
		hashCode = hashCode + getRequiredTopDomainId().hashCode();
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalDescription() != null ) {
			hashCode = hashCode + getOptionalDescription().hashCode();
		}
		if( getOptionalEmbeddedText() != null ) {
			hashCode = hashCode + getOptionalEmbeddedText().hashCode();
		}
		if( getOptionalFullText() != null ) {
			hashCode = hashCode + getOptionalFullText().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof IIntNetPubLicense rhs ) {
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
			if (getRequiredTopDomainId() != null) {
				if (rhs.getRequiredTopDomainId() != null) {
					cmp = getRequiredTopDomainId().compareTo( rhs.getRequiredTopDomainId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTopDomainId() != null) {
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
			if( getOptionalEmbeddedText() != null ) {
				if( rhs.getOptionalEmbeddedText() != null ) {
					cmp = getOptionalEmbeddedText().compareTo( rhs.getOptionalEmbeddedText() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEmbeddedText() != null ) {
					return( -1 );
				}
			}
			if( getOptionalFullText() != null ) {
				if( rhs.getOptionalFullText() != null ) {
					cmp = getOptionalFullText().compareTo( rhs.getOptionalFullText() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFullText() != null ) {
					return( -1 );
				}
			}
			return( 0 );
 		}
		else if( obj instanceof IIntNetPubLicenseHPKey rhs ) {
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
		else if( obj instanceof IIntNetPubLicenseH rhs ) {
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
			if (getRequiredTopDomainId() != null) {
				if (rhs.getRequiredTopDomainId() != null) {
					cmp = getRequiredTopDomainId().compareTo( rhs.getRequiredTopDomainId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTopDomainId() != null) {
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
			if( getOptionalEmbeddedText() != null ) {
				if( rhs.getOptionalEmbeddedText() != null ) {
					cmp = getOptionalEmbeddedText().compareTo( rhs.getOptionalEmbeddedText() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEmbeddedText() != null ) {
					return( -1 );
				}
			}
			if( getOptionalFullText() != null ) {
				if( rhs.getOptionalFullText() != null ) {
					cmp = getOptionalFullText().compareTo( rhs.getOptionalFullText() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFullText() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof IIntNetPubLicenseByLicnTenantIdxKey rhs ) {
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
		else if( obj instanceof IIntNetPubLicenseByDomainIdxKey rhs ) {
			if (getRequiredTopDomainId() != null) {
				if (rhs.getRequiredTopDomainId() != null) {
					cmp = getRequiredTopDomainId().compareTo( rhs.getRequiredTopDomainId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTopDomainId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IIntNetPubLicenseByUNameIdxKey rhs ) {
			if (getRequiredTopDomainId() != null) {
				if (rhs.getRequiredTopDomainId() != null) {
					cmp = getRequiredTopDomainId().compareTo( rhs.getRequiredTopDomainId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTopDomainId() != null) {
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
		else if( obj instanceof IIntNetPubLicense rhs ) {
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
			if (getRequiredTopDomainId() != null) {
				if (rhs.getRequiredTopDomainId() != null) {
					cmp = getRequiredTopDomainId().compareTo( rhs.getRequiredTopDomainId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTopDomainId() != null) {
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
			if( getOptionalEmbeddedText() != null ) {
				if( rhs.getOptionalEmbeddedText() != null ) {
					cmp = getOptionalEmbeddedText().compareTo( rhs.getOptionalEmbeddedText() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEmbeddedText() != null ) {
					return( -1 );
				}
			}
			if( getOptionalFullText() != null ) {
				if( rhs.getOptionalFullText() != null ) {
					cmp = getOptionalFullText().compareTo( rhs.getOptionalFullText() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFullText() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof IIntNetPubLicenseHPKey rhs ) {
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
		else if( obj instanceof IIntNetPubLicenseH rhs ) {
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
			if (getRequiredTopDomainId() != null) {
				if (rhs.getRequiredTopDomainId() != null) {
					cmp = getRequiredTopDomainId().compareTo( rhs.getRequiredTopDomainId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTopDomainId() != null) {
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
			if( getOptionalEmbeddedText() != null ) {
				if( rhs.getOptionalEmbeddedText() != null ) {
					cmp = getOptionalEmbeddedText().compareTo( rhs.getOptionalEmbeddedText() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEmbeddedText() != null ) {
					return( -1 );
				}
			}
			if( getOptionalFullText() != null ) {
				if( rhs.getOptionalFullText() != null ) {
					cmp = getOptionalFullText().compareTo( rhs.getOptionalFullText() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalFullText() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if( obj instanceof IIntNetPubLicenseByLicnTenantIdxKey rhs ) {
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
		else if( obj instanceof IIntNetPubLicenseByDomainIdxKey rhs ) {
			if (getRequiredTopDomainId() != null) {
				if (rhs.getRequiredTopDomainId() != null) {
					cmp = getRequiredTopDomainId().compareTo( rhs.getRequiredTopDomainId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTopDomainId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof IIntNetPubLicenseByUNameIdxKey rhs ) {
			if (getRequiredTopDomainId() != null) {
				if (rhs.getRequiredTopDomainId() != null) {
					cmp = getRequiredTopDomainId().compareTo( rhs.getRequiredTopDomainId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTopDomainId() != null) {
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
	public void set( IIntNetPubLicense src ) {
		setJustPubLicense( src );
	}

	@Override
	public void setLicense( IIntNetPubLicense src ) {
		setJustPubRequiredId(src.getRequiredId());
		setJustPubRequiredRevision( src.getRequiredRevision() );
		setJustPubRequiredOwnerTenant(src.getRequiredOwnerTenant());
		setJustPubRequiredContainerTopDomain(src.getRequiredContainerTopDomain());
		setJustPubRequiredTenantId(src.getRequiredTenantId());
		setJustPubRequiredTopDomainId(src.getRequiredTopDomainId());
		setJustPubRequiredName(src.getRequiredName());
		setJustPubOptionalDescription(src.getOptionalDescription());
		setJustPubOptionalEmbeddedText(src.getOptionalEmbeddedText());
		setJustPubOptionalFullText(src.getOptionalFullText());
	}

	@Override
	public void set( IIntNetPubLicenseH src ) {
		setJustPubLicense( src );
	}

	@Override
	public void setLicense( IIntNetPubLicenseH src ) {
		setJustPubRequiredId(src.getRequiredId());
		setJustPubRequiredOwnerTenant(src.getRequiredOwnerTenant());
		setJustPubRequiredContainerTopDomain(src.getRequiredContainerTopDomain());
		setJustPubRequiredTenantId(src.getRequiredTenantId());
		setJustPubRequiredTopDomainId(src.getRequiredTopDomainId());
		setJustPubRequiredName(src.getRequiredName());
		setJustPubOptionalDescription(src.getOptionalDescription());
		setJustPubOptionalEmbeddedText(src.getOptionalEmbeddedText());
		setJustPubOptionalFullText(src.getOptionalFullText());
	}

	@Override
	public void set( IIntNetPubLicense src ) {
		setJustPubLicense( src );
	}

	@Override
	public void setLicense( IIntNetPubLicense src ) {
		setJustPubRequiredId(src.getRequiredId());
		setJustPubRequiredRevision( src.getRequiredRevision() );
		setJustPubRequiredOwnerTenant(src.getRequiredOwnerTenant());
		setJustPubRequiredContainerTopDomain(src.getRequiredContainerTopDomain());
		setJustPubRequiredTenantId(src.getRequiredTenantId());
		setJustPubRequiredTopDomainId(src.getRequiredTopDomainId());
		setJustPubRequiredName(src.getRequiredName());
		setJustPubOptionalDescription(src.getOptionalDescription());
		setJustPubOptionalEmbeddedText(src.getOptionalEmbeddedText());
		setJustPubOptionalFullText(src.getOptionalFullText());
	}

	@Override
	public void set( IIntNetPubLicenseH src ) {
		setJustPubLicense( src );
	}

	@Override
	public void setLicense( IIntNetPubLicenseH src ) {
		setJustPubRequiredId(src.getRequiredId());
		setJustPubRequiredOwnerTenant(src.getRequiredOwnerTenant());
		setJustPubRequiredContainerTopDomain(src.getRequiredContainerTopDomain());
		setJustPubRequiredTenantId(src.getRequiredTenantId());
		setJustPubRequiredTopDomainId(src.getRequiredTopDomainId());
		setJustPubRequiredName(src.getRequiredName());
		setJustPubOptionalDescription(src.getOptionalDescription());
		setJustPubOptionalEmbeddedText(src.getOptionalEmbeddedText());
		setJustPubOptionalFullText(src.getOptionalFullText());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = pkey.getXmlAttrFragment()
			+ " classCode=\"" + getClassCode() + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\"" + "\"" + getRequiredId().toString() + "\"" + "\"" + getRequiredTenantId().toString() + "\"" + "\"" + getRequiredTopDomainId().toString() + "\"" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"" + ( ( getOptionalDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDescription() ) + "\"" ) + ( ( getOptionalEmbeddedText() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalEmbeddedText() ) + "\"" ) + ( ( getOptionalFullText() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalFullText() ) + "\"" );
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<IntNetPubBuffLicense" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
