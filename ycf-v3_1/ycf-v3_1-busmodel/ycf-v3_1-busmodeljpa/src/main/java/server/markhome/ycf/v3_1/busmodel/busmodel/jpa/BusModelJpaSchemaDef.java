// Description: Java 25 JPA implementation of a SchemaDef entity definition object.

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

package server.markhome.ycf.v3_1.busmodel.busmodel.jpa;

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
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.*;
import server.markhome.ycf.v3_1.intnet.intnet.jpa.*;

@Entity
@Table(
	name = "schemadef", schema = "BusModel31",
	indexes = {
		@Index(name = "SchemaDefIdIdx", columnList = "Id", unique = true),
		@Index(name = "SchemaDefCTenantIdx", columnList = "CTenantId", unique = false),
		@Index(name = "SchemaDefMinorVersionIdx", columnList = "MinorVersionId", unique = false),
		@Index(name = "SchemaDefUNameIdx", columnList = "MinorVersionId, safe_name", unique = true),
		@Index(name = "SchemaAuthorEMailIdx", columnList = "CTenantId, AuthEMail", unique = false),
		@Index(name = "SchemaProjectURLIdx", columnList = "CTenantId, ProjURL", unique = false),
		@Index(name = "SchemaPublishURIIdx", columnList = "CTenantId, PubURI", unique = true)
	}
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("43010")
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "BusModelPU")
public class BusModelJpaSchemaDef extends BusModelJpaScope
	implements IBusModelSchemaDef
{
	@OneToMany(fetch=FetchType.LAZY, mappedBy="requiredContainerSchemaDef")
	protected Set<BusModelJpaTable> optionalComponentsTables;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="optionalLookupDefSchema")
	protected Set<BusModelJpaValue> optionalComponentsTypes;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="requiredContainerSchema")
	protected Set<BusModelJpaSchemaRef> optionalComponentsSchemaRefs;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="optionalLookupDefSchema")
	protected Set<BusModelJpaTweak> optionalComponentsTweaks;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="requiredContainerSchemaDef")
	protected Set<BusModelJpaSchemaRole> optionalComponentsRoles;

	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="CTenantId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredCTenantId;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="MinorVersionId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredMinorVersionId;
	@Column( name="safe_name", nullable=false, length=192 )
	protected String requiredName;
	@Column( name="DbName", nullable=true, length=12 )
	protected String optionalDbName;
	@Column( name="short_name", nullable=true, length=16 )
	protected String optionalShortName;
	@Column( name="Label", nullable=true, length=64 )
	protected String optionalLabel;
	@Column( name="short_descr", nullable=true, length=128 )
	protected String optionalShortDescription;
	@Column( name="descr", nullable=true, length=1023 )
	protected String optionalDescription;
	@Column( name="CopyPerd", nullable=false, length=10 )
	protected String requiredCopyrightPeriod;
	@Column( name="CopyHold", nullable=false, length=511 )
	protected String requiredCopyrightHolder;
	@Column( name="AuthEMail", nullable=false, length=512 )
	protected String requiredAuthorEMail;
	@Column( name="ProjURL", nullable=false, length=1024 )
	protected String requiredProjectURL;
	@Column( name="PubURI", nullable=false, length=512 )
	protected String requiredPublishURI;

	public BusModelJpaSchemaDef() {
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
		return( IBusModelSchemaDef.CLASS_CODE );
	}

	@Override
	public IIntNetMinorVersion getRequiredContainerMinorVersion() {
		IIntNetSchema targetBackingSchema = IIntNetSchema.getBackingIntNet();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerMinorVersion", 0, "IIntNetSchema.getBackingIntNet()");
		}
		IIntNetMinorVersionTable targetTable = targetBackingSchema.getTableMinorVersion();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerMinorVersion", 0, "IIntNetSchema.getBackingIntNet().getTableMinorVersion()");
		}
		IIntNetMinorVersion targetRec = targetTable.readDerivedByIdIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredMinorVersionId());
		return(targetRec);
	}

	@Override
	public void setRequiredContainerMinorVersion(IIntNetMinorVersion argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerMinorVersion", 1, "argObj");
		}
		else {
			requiredMinorVersionId = argObj.getRequiredId();
		}
	}

	@Override
	public void setRequiredContainerMinorVersion(IYCFKeyHash256 argMinorVersionId) {
		requiredMinorVersionId = argMinorVersionId;
	}

	@Override
	public ISecureTenant getRequiredOwnerCTenant() {
		ISecureSchema targetBackingSchema = ISecureSchema.getBackingSecure();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredOwnerCTenant", 0, "ISecureSchema.getBackingSecure()");
		}
		ISecureTenantTable targetTable = targetBackingSchema.getTableTenant();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredOwnerCTenant", 0, "ISecureSchema.getBackingSecure().getTableTenant()");
		}
		ISecureTenant targetRec = targetTable.readDerivedByIdIdx(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), getRequiredCTenantId());
		return(targetRec);
	}

	@Override
	public void setRequiredOwnerCTenant(ISecureTenant argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setOwnerCTenant", 1, "argObj");
		}
		else {
			requiredCTenantId = argObj.getRequiredId();
		}
	}

	@Override
	public void setRequiredOwnerCTenant(IYCFKeyHash256 argCTenantId) {
		requiredCTenantId = argCTenantId;
	}

	@Override
	public List<IBusModelTable> getOptionalComponentsTables() {
		List<IBusModelTable> retlist = (optionalComponentsTables != null) ? new ArrayList<>(optionalComponentsTables) : new ArrayList<>();
		return( retlist );
	}

	@Override
	public List<IBusModelValue> getOptionalComponentsTypes() {
		List<IBusModelValue> retlist = (optionalComponentsTypes != null) ? new ArrayList<>(optionalComponentsTypes) : new ArrayList<>();
		return( retlist );
	}

	@Override
	public List<IBusModelSchemaRef> getOptionalComponentsSchemaRefs() {
		List<IBusModelSchemaRef> retlist = (optionalComponentsSchemaRefs != null) ? new ArrayList<>(optionalComponentsSchemaRefs) : new ArrayList<>();
		return( retlist );
	}

	@Override
	public List<IBusModelTweak> getOptionalComponentsTweaks() {
		List<IBusModelTweak> retlist = (optionalComponentsTweaks != null) ? new ArrayList<>(optionalComponentsTweaks) : new ArrayList<>();
		return( retlist );
	}

	@Override
	public List<IBusModelSchemaRole> getOptionalComponentsRoles() {
		List<IBusModelSchemaRole> retlist = (optionalComponentsRoles != null) ? new ArrayList<>(optionalComponentsRoles) : new ArrayList<>();
		return( retlist );
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
		if (obj == null) {
			return( false );
		}
		else if (obj instanceof IBusModelSchemaDef) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelSchemaDef rhs = (IBusModelSchemaDef)obj;
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
		else if (obj instanceof IBusModelSchemaDefH) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelSchemaDefH rhs = (IBusModelSchemaDefH)obj;
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
		else if (obj instanceof IBusModelScopeHPKey) {
			return( super.equals(obj) );
		}
		else if (obj instanceof IBusModelSchemaDefByCTenantIdxKey) {
			IBusModelSchemaDefByCTenantIdxKey rhs = (IBusModelSchemaDefByCTenantIdxKey)obj;
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
		else if (obj instanceof IBusModelSchemaDefByMinorVersionIdxKey) {
			IBusModelSchemaDefByMinorVersionIdxKey rhs = (IBusModelSchemaDefByMinorVersionIdxKey)obj;
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
		else if (obj instanceof IBusModelSchemaDefByUNameIdxKey) {
			IBusModelSchemaDefByUNameIdxKey rhs = (IBusModelSchemaDefByUNameIdxKey)obj;
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
		else if (obj instanceof IBusModelSchemaDefByAuthEMailIdxKey) {
			IBusModelSchemaDefByAuthEMailIdxKey rhs = (IBusModelSchemaDefByAuthEMailIdxKey)obj;
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
		else if (obj instanceof IBusModelSchemaDefByProjectURLIdxKey) {
			IBusModelSchemaDefByProjectURLIdxKey rhs = (IBusModelSchemaDefByProjectURLIdxKey)obj;
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
		else if (obj instanceof IBusModelSchemaDefByPubURIIdxKey) {
			IBusModelSchemaDefByPubURIIdxKey rhs = (IBusModelSchemaDefByPubURIIdxKey)obj;
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
			return( super.equals(obj) );
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
		if (obj == null) {
			return( 1 );
		}
		else if (obj instanceof IBusModelSchemaDef) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelSchemaDef rhs = (IBusModelSchemaDef)obj;
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
		else if( obj instanceof IBusModelSchemaDefH ) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelSchemaDefH rhs = (IBusModelSchemaDefH)obj;
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
		else if (obj instanceof IBusModelSchemaDefByCTenantIdxKey) {
			IBusModelSchemaDefByCTenantIdxKey rhs = (IBusModelSchemaDefByCTenantIdxKey)obj;
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
			return( 0 );
		}
		else if (obj instanceof IBusModelSchemaDefByMinorVersionIdxKey) {
			IBusModelSchemaDefByMinorVersionIdxKey rhs = (IBusModelSchemaDefByMinorVersionIdxKey)obj;
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
			return( 0 );
		}
		else if (obj instanceof IBusModelSchemaDefByUNameIdxKey) {
			IBusModelSchemaDefByUNameIdxKey rhs = (IBusModelSchemaDefByUNameIdxKey)obj;
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
			return( 0 );
		}
		else if (obj instanceof IBusModelSchemaDefByAuthEMailIdxKey) {
			IBusModelSchemaDefByAuthEMailIdxKey rhs = (IBusModelSchemaDefByAuthEMailIdxKey)obj;
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
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelSchemaDefByProjectURLIdxKey) {
			IBusModelSchemaDefByProjectURLIdxKey rhs = (IBusModelSchemaDefByProjectURLIdxKey)obj;
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
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelSchemaDefByPubURIIdxKey) {
			IBusModelSchemaDefByPubURIIdxKey rhs = (IBusModelSchemaDefByPubURIIdxKey)obj;
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
			}
			return( 0 );
		}
		else {
			cmp = super.compareTo(obj);
			return( cmp );
		}
	}

	@Override
	public void set( IBusModelScope src ) {
		if( src instanceof IBusModelSchemaDef ) {
			setSchemaDef( (IBusModelSchemaDef)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelJpaSchemaDef" );
		}
	}

	@Override
	public void setSchemaDef( IBusModelSchemaDef src ) {
		super.setScope( src );
		setRequiredContainerMinorVersion(src.getRequiredMinorVersionId());
		setRequiredOwnerCTenant(src.getRequiredCTenantId());
		setRequiredCTenantId(src.getRequiredCTenantId());
		setRequiredMinorVersionId(src.getRequiredMinorVersionId());
		setRequiredName(src.getRequiredName());
		setOptionalDbName(src.getOptionalDbName());
		setOptionalShortName(src.getOptionalShortName());
		setOptionalLabel(src.getOptionalLabel());
		setOptionalShortDescription(src.getOptionalShortDescription());
		setOptionalDescription(src.getOptionalDescription());
		setRequiredCopyrightPeriod(src.getRequiredCopyrightPeriod());
		setRequiredCopyrightHolder(src.getRequiredCopyrightHolder());
		setRequiredAuthorEMail(src.getRequiredAuthorEMail());
		setRequiredProjectURL(src.getRequiredProjectURL());
		setRequiredPublishURI(src.getRequiredPublishURI());
	}

	@Override
	public void set( IBusModelScopeH src ) {
		if( src instanceof IBusModelSchemaDefH ) {
			setSchemaDef( (IBusModelSchemaDefH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelSchemaDefH" );
		}
	}

	@Override
	public void setSchemaDef( IBusModelSchemaDefH src ) {
		super.setScope( src );
		setRequiredContainerMinorVersion(src.getRequiredMinorVersionId());
		setRequiredOwnerCTenant(src.getRequiredCTenantId());
		setRequiredCTenantId(src.getRequiredCTenantId());
		setRequiredMinorVersionId(src.getRequiredMinorVersionId());
		setRequiredName(src.getRequiredName());
		setOptionalDbName(src.getOptionalDbName());
		setOptionalShortName(src.getOptionalShortName());
		setOptionalLabel(src.getOptionalLabel());
		setOptionalShortDescription(src.getOptionalShortDescription());
		setOptionalDescription(src.getOptionalDescription());
		setRequiredCopyrightPeriod(src.getRequiredCopyrightPeriod());
		setRequiredCopyrightHolder(src.getRequiredCopyrightHolder());
		setRequiredAuthorEMail(src.getRequiredAuthorEMail());
		setRequiredProjectURL(src.getRequiredProjectURL());
		setRequiredPublishURI(src.getRequiredPublishURI());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment() 
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredCTenantId=" + "\"" + getRequiredCTenantId().toString() + "\""
			+ " RequiredMinorVersionId=" + "\"" + getRequiredMinorVersionId().toString() + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\""
			+ " OptionalDbName=" + ( ( getOptionalDbName() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDbName() ) + "\"" )
			+ " OptionalShortName=" + ( ( getOptionalShortName() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalShortName() ) + "\"" )
			+ " OptionalLabel=" + ( ( getOptionalLabel() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalLabel() ) + "\"" )
			+ " OptionalShortDescription=" + ( ( getOptionalShortDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalShortDescription() ) + "\"" )
			+ " OptionalDescription=" + ( ( getOptionalDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDescription() ) + "\"" )
			+ " RequiredCopyrightPeriod=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredCopyrightPeriod() ) + "\""
			+ " RequiredCopyrightHolder=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredCopyrightHolder() ) + "\""
			+ " RequiredAuthorEMail=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredAuthorEMail() ) + "\""
			+ " RequiredProjectURL=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredProjectURL() ) + "\""
			+ " RequiredPublishURI=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredPublishURI() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelJpaSchemaDef" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
