// Description: Java 25 JPA implementation of a License entity definition object.

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

package server.markhome.ycf.v3_1.intnet.intnet.jpa;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.*;

@Entity
@Table(
	name = "licn", schema = "IntNet31",
	indexes = {
		@Index(name = "LicenseIdIdx", columnList = "Id", unique = true),
		@Index(name = "LicenseTenantIdx", columnList = "TenantId", unique = false),
		@Index(name = "LicenseTopDomainIdx", columnList = "TopDomainId", unique = false),
		@Index(name = "LicenseUNameIdx", columnList = "TopDomainId, safe_name", unique = true),
		@Index(name = "LicenseTopDomainIdxTopDomain", columnList = "TopDomainIdTopDomain", unique = false)
	}
)
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "IntNetPU")
public class IntNetJpaLicense
	implements Comparable<Object>,
		IIntNetLicense,
		Serializable
{
	@Id
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="Id", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredId;
	protected int requiredRevision;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn( name="TopDomainIdTopDomain", referencedColumnName="Id" )
	protected IntNetJpaTopDomain requiredContainerTopDomain;

	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="TenantId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredTenantId;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="TopDomainId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredTopDomainId;
	@Column( name="safe_name", nullable=false, length=64 )
	protected String requiredName;
	@Column( name="descr", nullable=true, length=1024 )
	protected String optionalDescription;
	@Column( name="EmbeddedText", nullable=true, length=8000 )
	protected String optionalEmbeddedText;
	@Column( name="FullTxt", nullable=true, length=8000 )
	protected String optionalFullText;

	public IntNetJpaLicense() {
		requiredId = YCFDbKeyHash256.fromHex( IIntNetPubLicense.ID_INIT_VALUE.toString() );
		requiredTenantId = YCFDbKeyHash256.fromHex( IIntNetPubLicense.TENANTID_INIT_VALUE.toString() );
		requiredTopDomainId = YCFDbKeyHash256.fromHex( IIntNetPubLicense.TOPDOMAINID_INIT_VALUE.toString() );
		requiredName = IIntNetPubLicense.NAME_INIT_VALUE;
		optionalDescription = null;
		optionalEmbeddedText = null;
		optionalFullText = null;
	}

	@Override
	public int getClassCode() {
		return( IIntNetLicense.CLASS_CODE );
	}

	@Override
	public ISecureTenant getRequiredOwnerTenant() {
		ISecureSchema targetBackingSchema = ISecureSchema.getBackingSecure();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredOwnerTenant", 0, "ISecureSchema.getBackingSecure()");
		}
		ISecureTenantTable targetTable = targetBackingSchema.getTableTenant();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredOwnerTenant", 0, "ISecureSchema.getBackingSecure().getTableTenant()");
		}
		ISecureTenant targetRec = targetTable.readDerivedByIdIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredTenantId());
		return(targetRec);
	}

	@Override
	public void setRequiredOwnerTenant(ISecureTenant argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setOwnerTenant", 1, "argObj");
		}
		else {
			requiredTenantId = argObj.getRequiredId();
		}
	}

	@Override
	public void setRequiredOwnerTenant(IYCFKeyHash256 argTenantId) {
		requiredTenantId = argTenantId;
	}

	@Override
	public IIntNetTopDomain getRequiredContainerTopDomain() {
		return(requiredContainerTopDomain);
	}

	@Override
	public void setRequiredContainerTopDomain(IIntNetTopDomain argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerTopDomain", 1, "argObj");
		}
		else if (argObj instanceof IntNetJpaTopDomain) {
			requiredContainerTopDomain = (IntNetJpaTopDomain)argObj;
			if (requiredContainerTopDomain != null) {
				requiredTopDomainId = requiredContainerTopDomain.getRequiredId();
			}
			else {
			}
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setContainerTopDomain", "argObj", argObj, "IntNetJpaTopDomain");
		}
	}

	@Override
	public void setRequiredContainerTopDomain(IIntNetProtTopDomain argObj) {
		setRequiredContainerTopDomain(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerTopDomain(IIntNetPubTopDomain argObj) {
		setRequiredContainerTopDomain(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerTopDomain(IYCFKeyHash256 argTopDomainId) {
		IIntNetSchema targetBackingSchema = IIntNetSchema.getBackingIntNet();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerTopDomain", 0, "IIntNetSchema.getBackingIntNet()");
		}
		IIntNetTopDomainTable targetTable = targetBackingSchema.getTableTopDomain();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerTopDomain", 0, "IIntNetSchema.getBackingIntNet().getTableTopDomain()");
		}
		IIntNetTopDomain targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argTopDomainId);
		setRequiredContainerTopDomain(targetRec);
	}

	@Override
	public $implCommaIJavaOptAtomType$ getPKey() {
		return getRequiredId();
	}

	@Override
	public void setPKey($implCommaIJavaOptAtomType$ requiredId) {
		this.requiredId = requiredId;
	}

	@Override
	public IYCFKeyHash256 getRequiredId() {
		return(getPKey().getRequiredId());
	}

	public void setRequiredId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredId",
				1,
				"value" );
		}
		getPKey().setRequiredId(value);
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
		if (obj == null) {
			return( false );
		}
		else if (obj instanceof IIntNetLicense) {
			IIntNetLicense rhs = (IIntNetLicense)obj;
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
		else if (obj instanceof IIntNetLicenseH) {
			IIntNetLicenseH rhs = (IIntNetLicenseH)obj;
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
		else if (obj instanceof IIntNetLicenseHPKey) {
			IIntNetLicenseHPKey rhs = (IIntNetLicenseHPKey)obj;
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
		else if (obj instanceof IIntNetLicenseByLicnTenantIdxKey) {
			IIntNetLicenseByLicnTenantIdxKey rhs = (IIntNetLicenseByLicnTenantIdxKey)obj;
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
		else if (obj instanceof IIntNetLicenseByDomainIdxKey) {
			IIntNetLicenseByDomainIdxKey rhs = (IIntNetLicenseByDomainIdxKey)obj;
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
		else if (obj instanceof IIntNetLicenseByUNameIdxKey) {
			IIntNetLicenseByUNameIdxKey rhs = (IIntNetLicenseByUNameIdxKey)obj;
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
		int hashCode = getPKey().hashCode();
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
		if (obj == null) {
			return( 1 );
		}
		else if (obj instanceof IIntNetLicense) {
			IIntNetLicense rhs = (IIntNetLicense)obj;
			if (getPKey() == null) {
				if (rhs.getPKey() != null) {
					return( -1 );
				}
			}
			else {
				if (rhs.getPKey() == null) {
					return( 1 );
				}
				else {
					cmp = getPKey().compareTo(rhs.getPKey());
					if (cmp != 0) {
						return( cmp );
					}
				}
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
		else if (obj instanceof IIntNetLicenseHPKey) {
			IIntNetLicenseHPKey rhs = (IIntNetLicenseHPKey)obj;
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
		else if( obj instanceof IIntNetLicenseH ) {
			IIntNetLicenseH rhs = (IIntNetLicenseH)obj;
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
		else if (obj instanceof IIntNetLicenseByLicnTenantIdxKey) {
			IIntNetLicenseByLicnTenantIdxKey rhs = (IIntNetLicenseByLicnTenantIdxKey)obj;
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
			return( 0 );
		}
		else if (obj instanceof IIntNetLicenseByDomainIdxKey) {
			IIntNetLicenseByDomainIdxKey rhs = (IIntNetLicenseByDomainIdxKey)obj;
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
			return( 0 );
		}
		else if (obj instanceof IIntNetLicenseByUNameIdxKey) {
			IIntNetLicenseByUNameIdxKey rhs = (IIntNetLicenseByUNameIdxKey)obj;
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
			return( 0 );
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
	public void set( IIntNetLicense src ) {
		setLicense( src );
	}

	@Override
	public void setLicense( IIntNetLicense src ) {
		setRequiredId(src.getRequiredId());
		setRequiredRevision( src.getRequiredRevision() );
		setRequiredOwnerTenant(src.getRequiredTenantId());
		setRequiredContainerTopDomain(src.getRequiredContainerTopDomain());
		setRequiredTenantId(src.getRequiredTenantId());
		setRequiredTopDomainId(src.getRequiredTopDomainId());
		setRequiredName(src.getRequiredName());
		setOptionalDescription(src.getOptionalDescription());
		setOptionalEmbeddedText(src.getOptionalEmbeddedText());
		setOptionalFullText(src.getOptionalFullText());
	}

	@Override
	public void set( IIntNetLicenseH src ) {
		setLicense( src );
	}

	@Override
	public void setLicense( IIntNetLicenseH src ) {
		setRequiredId(src.getRequiredId());
		setRequiredOwnerTenant(src.getRequiredTenantId());
		setRequiredContainerTopDomain(src.getRequiredTopDomainId());
		setRequiredTenantId(src.getRequiredTenantId());
		setRequiredTopDomainId(src.getRequiredTopDomainId());
		setRequiredName(src.getRequiredName());
		setOptionalDescription(src.getOptionalDescription());
		setOptionalEmbeddedText(src.getOptionalEmbeddedText());
		setOptionalFullText(src.getOptionalFullText());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = ""
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " classCode=\"" + getClassCode() + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredTenantId=" + "\"" + getRequiredTenantId().toString() + "\""
			+ " RequiredTopDomainId=" + "\"" + getRequiredTopDomainId().toString() + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\""
			+ " OptionalDescription=" + ( ( getOptionalDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDescription() ) + "\"" )
			+ " OptionalEmbeddedText=" + ( ( getOptionalEmbeddedText() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalEmbeddedText() ) + "\"" )
			+ " OptionalFullText=" + ( ( getOptionalFullText() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalFullText() ) + "\"" );
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<IntNetJpaLicense" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
