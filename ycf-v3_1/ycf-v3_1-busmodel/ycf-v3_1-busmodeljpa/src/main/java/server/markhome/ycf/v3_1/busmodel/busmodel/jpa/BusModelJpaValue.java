// Description: Java 25 JPA implementation of a Value entity definition object.

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
	name = "valdef", schema = "BusModel31",
	indexes = {
		@Index(name = "ValueIdIdx", columnList = "Id", unique = true),
		@Index(name = "ValueUNameIdx", columnList = "ScopeId, safe_name", unique = true),
		@Index(name = "ValueScopeIdx", columnList = "ScopeId", unique = false),
		@Index(name = "ValueDefSchemaDefIdx", columnList = "defschid", unique = false),
		@Index(name = "ValuePrevIdx", columnList = "PrevId", unique = false),
		@Index(name = "ValueNextIdx", columnList = "NextId", unique = false),
		@Index(name = "ValueContPrevIdx", columnList = "ScopeId, PrevId", unique = false),
		@Index(name = "ValueContNextIdx", columnList = "ScopeId, NextId", unique = false),
		@Index(name = "ValueScopeIdxScope", columnList = "ScopeIdScope", unique = false),
		@Index(name = "ValueDefSchemaDefIdxDefSchema", columnList = "defschidDefSchema", unique = false),
		@Index(name = "ValuePrevIdxPrev", columnList = "PrevIdPrev", unique = false),
		@Index(name = "ValueNextIdxNext", columnList = "NextIdNext", unique = false)
	}
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "class_code", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue("43021")
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "BusModelPU")
public class BusModelJpaValue
	implements Comparable<Object>,
		IBusModelValue,
		Serializable
{
	@Id
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="Id", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredId;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="requiredParentDataType")
	protected Set<BusModelJpaTableCol> optionalChildrenRefTableCol;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="requiredLookupColumn")
	protected Set<BusModelJpaIndexCol> optionalChildrenRefIndexCol;
	protected int requiredRevision;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn( name="ScopeIdScope", referencedColumnName="Id" )
	protected BusModelJpaScope requiredContainerScope;
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn( name="defschidDefSchema", referencedColumnName="Id" )
	protected BusModelJpaSchemaDef optionalLookupDefSchema;
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn( name="PrevIdPrev", referencedColumnName="Id" )
	protected BusModelJpaValue optionalLookupPrev;
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn( name="NextIdNext", referencedColumnName="Id" )
	protected BusModelJpaValue optionalLookupNext;

	@AttributeOverrides({
		@AttributeOverride( name="bytes", column = @Column( name="CreatedByUserId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected YCFDbKeyHash256 createdByUserId = YCFDbKeyHash256.fromHex(IBusModelPubSecUser.S_INIT_CREATED_BY);

	@AttributeOverrides({
		@AttributeOverride( name="bytes", column = @Column( name="CreatedBySessionId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected YCFDbKeyHash256 createdBySessionId = YCFDbKeyHash256.fromHex(IBusModelPubSecSession.S_SECSESSIONID_INIT_VALUE);

	@Column(name="CreatedAt", nullable=false)
	protected LocalDateTime createdAt = LocalDateTime.now();

	@AttributeOverrides({
		@AttributeOverride( name="bytes", column= @Column( name="UpdatedByUserId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected YCFDbKeyHash256 updatedByUserId = YCFDbKeyHash256.fromHex(IBusModelPubSecUser.S_INIT_UPDATED_BY);

	@AttributeOverrides({
		@AttributeOverride( name="bytes", column= @Column( name="UpdatedBySessionId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected YCFDbKeyHash256 updatedBySessionId = YCFDbKeyHash256.fromHex(IBusModelPubSecSession.S_SECSESSIONID_INIT_VALUE);

	@Column(name="UpdatedAt", nullable=false)
	protected LocalDateTime updatedAt = LocalDateTime.now();
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="ScopeId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredScopeId;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="defschid", nullable=true, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 optionalDefSchemaId;
	@Column( name="safe_name", nullable=false, length=192 )
	protected String requiredName;
	@Column( name="short_name", nullable=true, length=16 )
	protected String optionalShortName;
	@Column( name="Label", nullable=true, length=64 )
	protected String optionalLabel;
	@Column( name="short_descr", nullable=true, length=128 )
	protected String optionalShortDescription;
	@Column( name="descr", nullable=true, length=1023 )
	protected String optionalDescription;
	@Column( name="dflt_xml_val", nullable=true, length=1023 )
	protected String optionalDefaultXmlValue;
	@Column( name="IsNullable", nullable=false )
	protected boolean requiredIsNullable;
	@Column( name="GenerateId", nullable=true )
	protected Boolean optionalGenerateId;
	@Column( name="ImplementsPolymorph", nullable=false )
	protected boolean requiredImplementsPolymorph;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="PrevId", nullable=true, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 optionalPrevId;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="NextId", nullable=true, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 optionalNextId;

	public BusModelJpaValue() {
		requiredId = YCFDbKeyHash256.fromHex( IBusModelPubValue.ID_INIT_VALUE.toString() );
		requiredScopeId = YCFDbKeyHash256.fromHex( IBusModelPubValue.SCOPEID_INIT_VALUE.toString() );
		optionalDefSchemaId = YCFDbKeyHash256.nullGet();
		requiredName = IBusModelPubValue.NAME_INIT_VALUE;
		optionalShortName = null;
		optionalLabel = null;
		optionalShortDescription = null;
		optionalDescription = null;
		optionalDefaultXmlValue = null;
		requiredIsNullable = IBusModelPubValue.ISNULLABLE_INIT_VALUE;
		optionalGenerateId = null;
		requiredImplementsPolymorph = IBusModelPubValue.IMPLEMENTSPOLYMORPH_INIT_VALUE;
		optionalPrevId = YCFDbKeyHash256.nullGet();
		optionalNextId = YCFDbKeyHash256.nullGet();
	}

	@Override
	public int getClassCode() {
		return( IBusModelValue.CLASS_CODE );
	}

	@Override
	public List<IBusModelTableCol> getOptionalChildrenRefTableCol() {
		List<IBusModelTableCol> retlist = (optionalChildrenRefTableCol != null) ? new ArrayList<>(optionalChildrenRefTableCol) : new ArrayList<>();
		return( retlist );
	}

	@Override
	public List<IBusModelIndexCol> getOptionalChildrenRefIndexCol() {
		List<IBusModelIndexCol> retlist = (optionalChildrenRefIndexCol != null) ? new ArrayList<>(optionalChildrenRefIndexCol) : new ArrayList<>();
		return( retlist );
	}

	@Override
	public IBusModelScope getRequiredContainerScope() {
		return(requiredContainerScope);
	}

	@Override
	public void setRequiredContainerScope(IBusModelScope argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerScope", 1, "argObj");
		}
		else if (argObj instanceof BusModelJpaScope) {
			requiredContainerScope = (BusModelJpaScope)argObj;
			if (requiredContainerScope != null) {
				requiredScopeId = requiredContainerScope.getRequiredId();
			}
			else {
			}
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setContainerScope", "argObj", argObj, "BusModelJpaScope");
		}
	}

	@Override
	public void setRequiredContainerScope(IBusModelProtScope argObj) {
		setRequiredContainerScope(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerScope(IBusModelPubScope argObj) {
		setRequiredContainerScope(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerScope(IYCFKeyHash256 argScopeId) {
		IBusModelSchema targetBackingSchema = IBusModelSchema.getBackingBusModel();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerScope", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelScopeTable targetTable = targetBackingSchema.getTableScope();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerScope", 0, "IBusModelSchema.getBackingBusModel().getTableScope()");
		}
		IBusModelScope targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argScopeId);
		setRequiredContainerScope(targetRec);
	}

	@Override
	public IBusModelSchemaDef getOptionalLookupDefSchema() {
		return(optionalLookupDefSchema);
	}

	@Override
	public void setOptionalLookupDefSchema(IBusModelSchemaDef argObj) {
		if(argObj == null) {
			optionalLookupDefSchema = null;
		}
		else if (argObj instanceof BusModelJpaSchemaDef) {
			optionalLookupDefSchema = (BusModelJpaSchemaDef)argObj;
			if (optionalLookupDefSchema != null) {
				optionalDefSchemaId = optionalLookupDefSchema.getRequiredId();
			}
			else {
				optionalDefSchemaId = null;
			}
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setLookupDefSchema", "argObj", argObj, "BusModelJpaSchemaDef");
		}
	}

	@Override
	public void setOptionalLookupDefSchema(IBusModelProtSchemaDef argObj) {
		setOptionalLookupDefSchema(argObj.getRequiredId());
	}

	@Override
	public void setOptionalLookupDefSchema(IBusModelPubSchemaDef argObj) {
		setOptionalLookupDefSchema(argObj.getRequiredId());
	}

	@Override
	public void setOptionalLookupDefSchema(IYCFKeyHash256 argDefSchemaId) {
		IBusModelSchema targetBackingSchema = IBusModelSchema.getBackingBusModel();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupDefSchema", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelSchemaDefTable targetTable = targetBackingSchema.getTableSchemaDef();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupDefSchema", 0, "IBusModelSchema.getBackingBusModel().getTableSchemaDef()");
		}
		IBusModelSchemaDef targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argDefSchemaId);
		setOptionalLookupDefSchema(targetRec);
	}

	@Override
	public IBusModelValue getOptionalLookupPrev() {
		return(optionalLookupPrev);
	}

	@Override
	public void setOptionalLookupPrev(IBusModelValue argObj) {
		if(argObj == null) {
			optionalLookupPrev = null;
		}
		else if (argObj instanceof BusModelJpaValue) {
			optionalLookupPrev = (BusModelJpaValue)argObj;
			if (optionalLookupPrev != null) {
				optionalPrevId = optionalLookupPrev.getRequiredId();
			}
			else {
				optionalPrevId = null;
			}
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setLookupPrev", "argObj", argObj, "BusModelJpaValue");
		}
	}

	@Override
	public void setOptionalLookupPrev(IBusModelProtValue argObj) {
		setOptionalLookupPrev(argObj.getRequiredId());
	}

	@Override
	public void setOptionalLookupPrev(IBusModelPubValue argObj) {
		setOptionalLookupPrev(argObj.getRequiredId());
	}

	@Override
	public void setOptionalLookupPrev(IYCFKeyHash256 argPrevId) {
		IBusModelSchema targetBackingSchema = IBusModelSchema.getBackingBusModel();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupPrev", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelValueTable targetTable = targetBackingSchema.getTableValue();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupPrev", 0, "IBusModelSchema.getBackingBusModel().getTableValue()");
		}
		IBusModelValue targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argPrevId);
		setOptionalLookupPrev(targetRec);
	}

	@Override
	public IBusModelValue getOptionalLookupNext() {
		return(optionalLookupNext);
	}

	@Override
	public void setOptionalLookupNext(IBusModelValue argObj) {
		if(argObj == null) {
			optionalLookupNext = null;
		}
		else if (argObj instanceof BusModelJpaValue) {
			optionalLookupNext = (BusModelJpaValue)argObj;
			if (optionalLookupNext != null) {
				optionalNextId = optionalLookupNext.getRequiredId();
			}
			else {
				optionalNextId = null;
			}
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setLookupNext", "argObj", argObj, "BusModelJpaValue");
		}
	}

	@Override
	public void setOptionalLookupNext(IBusModelProtValue argObj) {
		setOptionalLookupNext(argObj.getRequiredId());
	}

	@Override
	public void setOptionalLookupNext(IBusModelPubValue argObj) {
		setOptionalLookupNext(argObj.getRequiredId());
	}

	@Override
	public void setOptionalLookupNext(IYCFKeyHash256 argNextId) {
		IBusModelSchema targetBackingSchema = IBusModelSchema.getBackingBusModel();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupNext", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelValueTable targetTable = targetBackingSchema.getTableValue();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setOptionalLookupNext", 0, "IBusModelSchema.getBackingBusModel().getTableValue()");
		}
		IBusModelValue targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argNextId);
		setOptionalLookupNext(targetRec);
	}

	@Override
	public YCFDbKeyHash256 getCreatedByUserId() {
		return( createdByUserId );
	}

	@Override
	public void setCreatedByUserId( YCFDbKeyHash256 value ) {
		if (value == null || value.isNull()) {
			throw new YCFNullArgumentException(getClass(), "setCreatedByUserId", 1, "value");
		}
		createdByUserId = value;
	}

	@Override
	public LocalDateTime getCreatedAt() {
		return( createdAt );
	}

	@Override
	public void setCreatedAt( LocalDateTime value ) {
		if (value == null) {
			throw new YCFNullArgumentException(getClass(), "setCreatedAt", 1, "value");
		}
		createdAt = value;
	}

	@Override
	public YCFDbKeyHash256 getUpdatedByUserId() {
		return( updatedByUserId );
	}

	@Override
	public void setUpdatedByUserId( YCFDbKeyHash256 value ) {
		if (value == null || value.isNull()) {
			throw new YCFNullArgumentException(getClass(), "setUpdatedByUserId", 1, "value");
		}
		updatedByUserId = value;
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( updatedAt );
	}

	@Override
	public void setUpdatedAt( LocalDateTime value ) {
		if (value == null) {
			throw new YCFNullArgumentException(getClass(), "setUpdatedAt", 1, "value");
		}
		updatedAt = value;
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
	public String getOptionalDefaultXmlValue() {
		return(optionalDefaultXmlValue);
	}

	public void setOptionalDefaultXmlValue( String value ) {
		if( value != null && value.length() > 1023 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalDefaultXmlValue",
				1,
				"value.length()",
				value.length(),
				1023 );
		}
		optionalDefaultXmlValue = value;
	}

	@Override
	public boolean getRequiredIsNullable() {
		return(requiredIsNullable);
	}

	public void setRequiredIsNullable( boolean value ) {
		requiredIsNullable = value;
	}

	@Override
	public Boolean getOptionalGenerateId() {
		return(optionalGenerateId);
	}

	public void setOptionalGenerateId( Boolean value ) {
		optionalGenerateId = value;
	}

	@Override
	public boolean getRequiredImplementsPolymorph() {
		return(requiredImplementsPolymorph);
	}

	public void setRequiredImplementsPolymorph( boolean value ) {
		requiredImplementsPolymorph = value;
	}

	@Override
	public IYCFKeyHash256 getOptionalPrevId() {
		return(optionalPrevId);
	}

	public void setOptionalPrevId( IYCFKeyHash256 value ) {
		optionalPrevId = value;
	}

	@Override
	public IYCFKeyHash256 getOptionalNextId() {
		return(optionalNextId);
	}

	public void setOptionalNextId( IYCFKeyHash256 value ) {
		optionalNextId = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if (obj == null) {
			return( false );
		}
		else if (obj instanceof IBusModelValue) {
			IBusModelValue rhs = (IBusModelValue)obj;
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
			if( getOptionalDefaultXmlValue() != null ) {
				if( rhs.getOptionalDefaultXmlValue() != null ) {
					if( ! getOptionalDefaultXmlValue().equals( rhs.getOptionalDefaultXmlValue() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefaultXmlValue() != null ) {
					return( false );
				}
			}
			if( getRequiredIsNullable() != rhs.getRequiredIsNullable() ) {
				return( false );
			}
			if( getOptionalGenerateId() != null ) {
				if( rhs.getOptionalGenerateId() != null ) {
					if( ! getOptionalGenerateId().equals( rhs.getOptionalGenerateId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalGenerateId() != null ) {
					return( false );
				}
			}
			if( getRequiredImplementsPolymorph() != rhs.getRequiredImplementsPolymorph() ) {
				return( false );
			}
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					if( ! getOptionalPrevId().equals( rhs.getOptionalPrevId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelValueH) {
			IBusModelValueH rhs = (IBusModelValueH)obj;
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
			if( getOptionalDefaultXmlValue() != null ) {
				if( rhs.getOptionalDefaultXmlValue() != null ) {
					if( ! getOptionalDefaultXmlValue().equals( rhs.getOptionalDefaultXmlValue() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefaultXmlValue() != null ) {
					return( false );
				}
			}
			if( getRequiredIsNullable() != rhs.getRequiredIsNullable() ) {
				return( false );
			}
			if( getOptionalGenerateId() != null ) {
				if( rhs.getOptionalGenerateId() != null ) {
					if( ! getOptionalGenerateId().equals( rhs.getOptionalGenerateId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalGenerateId() != null ) {
					return( false );
				}
			}
			if( getRequiredImplementsPolymorph() != rhs.getRequiredImplementsPolymorph() ) {
				return( false );
			}
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					if( ! getOptionalPrevId().equals( rhs.getOptionalPrevId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelValueHPKey) {
			IBusModelValueHPKey rhs = (IBusModelValueHPKey)obj;
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
		else if (obj instanceof IBusModelValueByUNameIdxKey) {
			IBusModelValueByUNameIdxKey rhs = (IBusModelValueByUNameIdxKey)obj;
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
		else if (obj instanceof IBusModelValueByScopeIdxKey) {
			IBusModelValueByScopeIdxKey rhs = (IBusModelValueByScopeIdxKey)obj;
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
		else if (obj instanceof IBusModelValueByDefSchemaIdxKey) {
			IBusModelValueByDefSchemaIdxKey rhs = (IBusModelValueByDefSchemaIdxKey)obj;
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
		else if (obj instanceof IBusModelValueByPrevIdxKey) {
			IBusModelValueByPrevIdxKey rhs = (IBusModelValueByPrevIdxKey)obj;
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					if( ! getOptionalPrevId().equals( rhs.getOptionalPrevId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelValueByNextIdxKey) {
			IBusModelValueByNextIdxKey rhs = (IBusModelValueByNextIdxKey)obj;
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelValueByContPrevIdxKey) {
			IBusModelValueByContPrevIdxKey rhs = (IBusModelValueByContPrevIdxKey)obj;
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
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					if( ! getOptionalPrevId().equals( rhs.getOptionalPrevId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelValueByContNextIdxKey) {
			IBusModelValueByContNextIdxKey rhs = (IBusModelValueByContNextIdxKey)obj;
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
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
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
		if( getOptionalDefaultXmlValue() != null ) {
			hashCode = hashCode + getOptionalDefaultXmlValue().hashCode();
		}
		if( getRequiredIsNullable() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getOptionalGenerateId() != null ) {
			if( getOptionalGenerateId() ) {
				hashCode = ( hashCode * 4 ) + 1;
			}
			else {
				hashCode = hashCode * 4;
			}
		}
		else {
			hashCode = (hashCode * 4 ) + 3;
		}
		if( getRequiredImplementsPolymorph() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getOptionalPrevId() != null ) {
			hashCode = hashCode + getOptionalPrevId().hashCode();
		}
		if( getOptionalNextId() != null ) {
			hashCode = hashCode + getOptionalNextId().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if (obj == null) {
			return( 1 );
		}
		else if (obj instanceof IBusModelValue) {
			IBusModelValue rhs = (IBusModelValue)obj;
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
			if( getOptionalDefaultXmlValue() != null ) {
				if( rhs.getOptionalDefaultXmlValue() != null ) {
					cmp = getOptionalDefaultXmlValue().compareTo( rhs.getOptionalDefaultXmlValue() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultXmlValue() != null ) {
					return( -1 );
				}
			}
			if( getRequiredIsNullable() ) {
				if( ! rhs.getRequiredIsNullable() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsNullable() ) {
					return( -1 );
				}
			}
			if( getOptionalGenerateId() != null ) {
				Boolean lhsGenerateId = getOptionalGenerateId();
				if( rhs.getOptionalGenerateId() ) {
					Boolean rhsGenerateId = rhs.getOptionalGenerateId();
					if( lhsGenerateId ) {
						if( ! rhsGenerateId ) {
							return( 1 );
						}
					}
					else {
						if( rhsGenerateId ) {
							return( -1 );
						}
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalGenerateId() != null ) {
					return( -1 );
				}
			}
			if( getRequiredImplementsPolymorph() ) {
				if( ! rhs.getRequiredImplementsPolymorph() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredImplementsPolymorph() ) {
					return( -1 );
				}
			}
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					cmp = getOptionalPrevId().compareTo( rhs.getOptionalPrevId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					cmp = getOptionalNextId().compareTo( rhs.getOptionalNextId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelValueHPKey) {
			IBusModelValueHPKey rhs = (IBusModelValueHPKey)obj;
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
		else if( obj instanceof IBusModelValueH ) {
			IBusModelValueH rhs = (IBusModelValueH)obj;
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
			if( getOptionalDefaultXmlValue() != null ) {
				if( rhs.getOptionalDefaultXmlValue() != null ) {
					cmp = getOptionalDefaultXmlValue().compareTo( rhs.getOptionalDefaultXmlValue() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefaultXmlValue() != null ) {
					return( -1 );
				}
			}
			if( getRequiredIsNullable() ) {
				if( ! rhs.getRequiredIsNullable() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsNullable() ) {
					return( -1 );
				}
			}
			if( getOptionalGenerateId() != null ) {
				Boolean lhsGenerateId = getOptionalGenerateId();
				if( rhs.getOptionalGenerateId() ) {
					Boolean rhsGenerateId = rhs.getOptionalGenerateId();
					if( lhsGenerateId ) {
						if( ! rhsGenerateId ) {
							return( 1 );
						}
					}
					else {
						if( rhsGenerateId ) {
							return( -1 );
						}
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalGenerateId() != null ) {
					return( -1 );
				}
			}
			if( getRequiredImplementsPolymorph() ) {
				if( ! rhs.getRequiredImplementsPolymorph() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredImplementsPolymorph() ) {
					return( -1 );
				}
			}
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					cmp = getOptionalPrevId().compareTo( rhs.getOptionalPrevId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					cmp = getOptionalNextId().compareTo( rhs.getOptionalNextId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelValueByUNameIdxKey) {
			IBusModelValueByUNameIdxKey rhs = (IBusModelValueByUNameIdxKey)obj;
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
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelValueByScopeIdxKey) {
			IBusModelValueByScopeIdxKey rhs = (IBusModelValueByScopeIdxKey)obj;
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
			return( 0 );
		}
		else if (obj instanceof IBusModelValueByDefSchemaIdxKey) {
			IBusModelValueByDefSchemaIdxKey rhs = (IBusModelValueByDefSchemaIdxKey)obj;
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
			return( 0 );
		}
		else if (obj instanceof IBusModelValueByPrevIdxKey) {
			IBusModelValueByPrevIdxKey rhs = (IBusModelValueByPrevIdxKey)obj;
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					cmp = getOptionalPrevId().compareTo( rhs.getOptionalPrevId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelValueByNextIdxKey) {
			IBusModelValueByNextIdxKey rhs = (IBusModelValueByNextIdxKey)obj;
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					cmp = getOptionalNextId().compareTo( rhs.getOptionalNextId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelValueByContPrevIdxKey) {
			IBusModelValueByContPrevIdxKey rhs = (IBusModelValueByContPrevIdxKey)obj;
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
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					cmp = getOptionalPrevId().compareTo( rhs.getOptionalPrevId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelValueByContNextIdxKey) {
			IBusModelValueByContNextIdxKey rhs = (IBusModelValueByContNextIdxKey)obj;
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
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					cmp = getOptionalNextId().compareTo( rhs.getOptionalNextId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( -1 );
				}
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
	public void set( IBusModelValue src ) {
		setValue( src );
	}

	@Override
	public void setValue( IBusModelValue src ) {
		setRequiredId(src.getRequiredId());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredContainerScope(src.getRequiredContainerScope());
		setOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setOptionalLookupPrev(src.getOptionalLookupPrev());
		setOptionalLookupNext(src.getOptionalLookupNext());
		setRequiredScopeId(src.getRequiredScopeId());
		setOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setRequiredName(src.getRequiredName());
		setOptionalShortName(src.getOptionalShortName());
		setOptionalLabel(src.getOptionalLabel());
		setOptionalShortDescription(src.getOptionalShortDescription());
		setOptionalDescription(src.getOptionalDescription());
		setOptionalDefaultXmlValue(src.getOptionalDefaultXmlValue());
		setRequiredIsNullable(src.getRequiredIsNullable());
		setOptionalGenerateId(src.getOptionalGenerateId());
		setRequiredImplementsPolymorph(src.getRequiredImplementsPolymorph());
		setOptionalPrevId(src.getOptionalPrevId());
		setOptionalNextId(src.getOptionalNextId());
	}

	@Override
	public void set( IBusModelValueH src ) {
		setValue( src );
	}

	@Override
	public void setValue( IBusModelValueH src ) {
		setRequiredId(src.getRequiredId());
		setRequiredContainerScope(src.getRequiredScopeId());
		setOptionalLookupDefSchema(src.getOptionalDefSchemaId());
		setOptionalLookupPrev(src.getOptionalPrevId());
		setOptionalLookupNext(src.getOptionalNextId());
		setRequiredScopeId(src.getRequiredScopeId());
		setOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setRequiredName(src.getRequiredName());
		setOptionalShortName(src.getOptionalShortName());
		setOptionalLabel(src.getOptionalLabel());
		setOptionalShortDescription(src.getOptionalShortDescription());
		setOptionalDescription(src.getOptionalDescription());
		setOptionalDefaultXmlValue(src.getOptionalDefaultXmlValue());
		setRequiredIsNullable(src.getRequiredIsNullable());
		setOptionalGenerateId(src.getOptionalGenerateId());
		setRequiredImplementsPolymorph(src.getRequiredImplementsPolymorph());
		setOptionalPrevId(src.getOptionalPrevId());
		setOptionalNextId(src.getOptionalNextId());
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
			+ " OptionalShortName=" + ( ( getOptionalShortName() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalShortName() ) + "\"" )
			+ " OptionalLabel=" + ( ( getOptionalLabel() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalLabel() ) + "\"" )
			+ " OptionalShortDescription=" + ( ( getOptionalShortDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalShortDescription() ) + "\"" )
			+ " OptionalDescription=" + ( ( getOptionalDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDescription() ) + "\"" )
			+ " OptionalDefaultXmlValue=" + ( ( getOptionalDefaultXmlValue() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDefaultXmlValue() ) + "\"" )
			+ " RequiredIsNullable=" + (( getRequiredIsNullable() ) ? "\"true\"" : "\"false\"" )
			+ " OptionalGenerateId=" + ( ( getOptionalGenerateId() == null ) ? "null" : ( ( getOptionalGenerateId() ) ? "\"true\"" : "\"false\"" ) )
			+ " RequiredImplementsPolymorph=" + (( getRequiredImplementsPolymorph() ) ? "\"true\"" : "\"false\"" )
			+ " OptionalPrevId=" + ( ( getOptionalPrevId() == null ) ? "null" : "\"" + getOptionalPrevId().toString() + "\"" )
			+ " OptionalNextId=" + ( ( getOptionalNextId() == null ) ? "null" : "\"" + getOptionalNextId().toString() + "\"" );
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelJpaValue" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
