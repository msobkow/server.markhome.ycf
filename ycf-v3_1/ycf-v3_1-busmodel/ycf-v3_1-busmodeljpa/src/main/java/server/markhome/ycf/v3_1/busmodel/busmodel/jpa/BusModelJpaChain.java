// Description: Java 25 JPA implementation of a Chain entity definition object.

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
	name = "chain_def", schema = "BusModel31",
	indexes = {
		@Index(name = "ChainIdIdx", columnList = "Id", unique = true),
		@Index(name = "ChainTableIdx", columnList = "TableId", unique = false),
		@Index(name = "ChainDefSchemaDefIdx", columnList = "defschid", unique = false),
		@Index(name = "ChainUNameIdx", columnList = "TableId, safe_name", unique = true),
		@Index(name = "ChainPrevRelIdx", columnList = "PrevRelationId", unique = false),
		@Index(name = "ChainNextRelIdx", columnList = "NextRelationId", unique = false),
		@Index(name = "ChainTableIdxTable", columnList = "TableIdTable", unique = false),
		@Index(name = "ChainDefSchemaDefIdxDefSchema", columnList = "defschidDefSchema", unique = false),
		@Index(name = "ChainPrevRelIdxPrevRel", columnList = "PrevRelationIdPrevRel", unique = false),
		@Index(name = "ChainNextRelIdxNextRel", columnList = "NextRelationIdNextRel", unique = false)
	}
)
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "BusModelPU")
public class BusModelJpaChain
	implements Comparable<Object>,
		IBusModelChain,
		Serializable
{
	@Id
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="Id", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredId;
	protected int requiredRevision;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn( name="TableIdTable", referencedColumnName="Id" )
	protected BusModelJpaTable requiredContainerTable;
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn( name="defschidDefSchema", referencedColumnName="Id" )
	protected BusModelJpaSchemaDef optionalLookupDefSchema;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn( name="PrevRelationIdPrevRel", referencedColumnName="Id" )
	protected BusModelJpaRelation requiredLookupPrevRel;
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn( name="NextRelationIdNextRel", referencedColumnName="Id" )
	protected BusModelJpaRelation requiredLookupNextRel;

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
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="TableId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredTableId;
	@Column( name="Suffix", nullable=true, length=16 )
	protected String optionalSuffix;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="PrevRelationId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredPrevRelationId;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="NextRelationId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredNextRelationId;

	public BusModelJpaChain() {
		requiredId = YCFDbKeyHash256.fromHex( IBusModelPubChain.ID_INIT_VALUE.toString() );
		optionalDefSchemaId = YCFDbKeyHash256.nullGet();
		requiredName = IBusModelPubChain.NAME_INIT_VALUE;
		optionalShortName = null;
		optionalLabel = null;
		optionalShortDescription = null;
		optionalDescription = null;
		requiredTableId = YCFDbKeyHash256.fromHex( IBusModelPubChain.TABLEID_INIT_VALUE.toString() );
		optionalSuffix = null;
		requiredPrevRelationId = YCFDbKeyHash256.fromHex( IBusModelPubChain.PREVRELATIONID_INIT_VALUE.toString() );
		requiredNextRelationId = YCFDbKeyHash256.fromHex( IBusModelPubChain.NEXTRELATIONID_INIT_VALUE.toString() );
	}

	@Override
	public int getClassCode() {
		return( IBusModelChain.CLASS_CODE );
	}

	@Override
	public IBusModelTable getRequiredContainerTable() {
		return(requiredContainerTable);
	}

	@Override
	public void setRequiredContainerTable(IBusModelTable argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerTable", 1, "argObj");
		}
		else if (argObj instanceof BusModelJpaTable) {
			requiredContainerTable = (BusModelJpaTable)argObj;
			if (requiredContainerTable != null) {
				requiredTableId = requiredContainerTable.getRequiredId();
			}
			else {
			}
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setContainerTable", "argObj", argObj, "BusModelJpaTable");
		}
	}

	@Override
	public void setRequiredContainerTable(IBusModelProtTable argObj) {
		setRequiredContainerTable(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerTable(IBusModelPubTable argObj) {
		setRequiredContainerTable(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerTable(IYCFKeyHash256 argTableId) {
		IBusModelSchema targetBackingSchema = IBusModelSchema.getBackingBusModel();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerTable", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelTableTable targetTable = targetBackingSchema.getTableTable();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerTable", 0, "IBusModelSchema.getBackingBusModel().getTableTable()");
		}
		IBusModelTable targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argTableId);
		setRequiredContainerTable(targetRec);
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
	public IBusModelRelation getRequiredLookupPrevRel() {
		return(requiredLookupPrevRel);
	}

	@Override
	public void setRequiredLookupPrevRel(IBusModelRelation argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setLookupPrevRel", 1, "argObj");
		}
		else if (argObj instanceof BusModelJpaRelation) {
			requiredLookupPrevRel = (BusModelJpaRelation)argObj;
			if (requiredLookupPrevRel != null) {
				requiredPrevRelationId = requiredLookupPrevRel.getRequiredId();
			}
			else {
			}
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setLookupPrevRel", "argObj", argObj, "BusModelJpaRelation");
		}
	}

	@Override
	public void setRequiredLookupPrevRel(IBusModelProtRelation argObj) {
		setRequiredLookupPrevRel(argObj.getRequiredId());
	}

	@Override
	public void setRequiredLookupPrevRel(IBusModelPubRelation argObj) {
		setRequiredLookupPrevRel(argObj.getRequiredId());
	}

	@Override
	public void setRequiredLookupPrevRel(IYCFKeyHash256 argPrevRelationId) {
		IBusModelSchema targetBackingSchema = IBusModelSchema.getBackingBusModel();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredLookupPrevRel", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelRelationTable targetTable = targetBackingSchema.getTableRelation();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredLookupPrevRel", 0, "IBusModelSchema.getBackingBusModel().getTableRelation()");
		}
		IBusModelRelation targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argPrevRelationId);
		setRequiredLookupPrevRel(targetRec);
	}

	@Override
	public IBusModelRelation getRequiredLookupNextRel() {
		return(requiredLookupNextRel);
	}

	@Override
	public void setRequiredLookupNextRel(IBusModelRelation argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setLookupNextRel", 1, "argObj");
		}
		else if (argObj instanceof BusModelJpaRelation) {
			requiredLookupNextRel = (BusModelJpaRelation)argObj;
			if (requiredLookupNextRel != null) {
				requiredNextRelationId = requiredLookupNextRel.getRequiredId();
			}
			else {
			}
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setLookupNextRel", "argObj", argObj, "BusModelJpaRelation");
		}
	}

	@Override
	public void setRequiredLookupNextRel(IBusModelProtRelation argObj) {
		setRequiredLookupNextRel(argObj.getRequiredId());
	}

	@Override
	public void setRequiredLookupNextRel(IBusModelPubRelation argObj) {
		setRequiredLookupNextRel(argObj.getRequiredId());
	}

	@Override
	public void setRequiredLookupNextRel(IYCFKeyHash256 argNextRelationId) {
		IBusModelSchema targetBackingSchema = IBusModelSchema.getBackingBusModel();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredLookupNextRel", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelRelationTable targetTable = targetBackingSchema.getTableRelation();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredLookupNextRel", 0, "IBusModelSchema.getBackingBusModel().getTableRelation()");
		}
		IBusModelRelation targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argNextRelationId);
		setRequiredLookupNextRel(targetRec);
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
	public IYCFKeyHash256 getRequiredTableId() {
		return(requiredTableId);
	}

	public void setRequiredTableId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredTableId",
				1,
				"value" );
		}
		requiredTableId = value;
	}

	@Override
	public String getOptionalSuffix() {
		return(optionalSuffix);
	}

	public void setOptionalSuffix( String value ) {
		if( value != null && value.length() > 16 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalSuffix",
				1,
				"value.length()",
				value.length(),
				16 );
		}
		optionalSuffix = value;
	}

	@Override
	public IYCFKeyHash256 getRequiredPrevRelationId() {
		return(requiredPrevRelationId);
	}

	public void setRequiredPrevRelationId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredPrevRelationId",
				1,
				"value" );
		}
		requiredPrevRelationId = value;
	}

	@Override
	public IYCFKeyHash256 getRequiredNextRelationId() {
		return(requiredNextRelationId);
	}

	public void setRequiredNextRelationId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredNextRelationId",
				1,
				"value" );
		}
		requiredNextRelationId = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if (obj == null) {
			return( false );
		}
		else if (obj instanceof IBusModelChain) {
			IBusModelChain rhs = (IBusModelChain)obj;
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
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					if( ! getOptionalSuffix().equals( rhs.getOptionalSuffix() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( false );
				}
			}
			if( getRequiredPrevRelationId() != null ) {
				if( rhs.getRequiredPrevRelationId() != null ) {
					if( ! getRequiredPrevRelationId().equals( rhs.getRequiredPrevRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPrevRelationId() != null ) {
					return( false );
				}
			}
			if( getRequiredNextRelationId() != null ) {
				if( rhs.getRequiredNextRelationId() != null ) {
					if( ! getRequiredNextRelationId().equals( rhs.getRequiredNextRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredNextRelationId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelChainH) {
			IBusModelChainH rhs = (IBusModelChainH)obj;
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
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					if( ! getOptionalSuffix().equals( rhs.getOptionalSuffix() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( false );
				}
			}
			if( getRequiredPrevRelationId() != null ) {
				if( rhs.getRequiredPrevRelationId() != null ) {
					if( ! getRequiredPrevRelationId().equals( rhs.getRequiredPrevRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPrevRelationId() != null ) {
					return( false );
				}
			}
			if( getRequiredNextRelationId() != null ) {
				if( rhs.getRequiredNextRelationId() != null ) {
					if( ! getRequiredNextRelationId().equals( rhs.getRequiredNextRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredNextRelationId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelChainHPKey) {
			IBusModelChainHPKey rhs = (IBusModelChainHPKey)obj;
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
		else if (obj instanceof IBusModelChainByChainTableIdxKey) {
			IBusModelChainByChainTableIdxKey rhs = (IBusModelChainByChainTableIdxKey)obj;
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelChainByDefSchemaIdxKey) {
			IBusModelChainByDefSchemaIdxKey rhs = (IBusModelChainByDefSchemaIdxKey)obj;
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
		else if (obj instanceof IBusModelChainByUNameIdxKey) {
			IBusModelChainByUNameIdxKey rhs = (IBusModelChainByUNameIdxKey)obj;
			if( getRequiredTableId() != null ) {
				if( rhs.getRequiredTableId() != null ) {
					if( ! getRequiredTableId().equals( rhs.getRequiredTableId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTableId() != null ) {
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
		else if (obj instanceof IBusModelChainByPrevRelIdxKey) {
			IBusModelChainByPrevRelIdxKey rhs = (IBusModelChainByPrevRelIdxKey)obj;
			if( getRequiredPrevRelationId() != null ) {
				if( rhs.getRequiredPrevRelationId() != null ) {
					if( ! getRequiredPrevRelationId().equals( rhs.getRequiredPrevRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPrevRelationId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelChainByNextRelIdxKey) {
			IBusModelChainByNextRelIdxKey rhs = (IBusModelChainByNextRelIdxKey)obj;
			if( getRequiredNextRelationId() != null ) {
				if( rhs.getRequiredNextRelationId() != null ) {
					if( ! getRequiredNextRelationId().equals( rhs.getRequiredNextRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredNextRelationId() != null ) {
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
		hashCode = hashCode + getRequiredTableId().hashCode();
		if( getOptionalSuffix() != null ) {
			hashCode = hashCode + getOptionalSuffix().hashCode();
		}
		hashCode = hashCode + getRequiredPrevRelationId().hashCode();
		hashCode = hashCode + getRequiredNextRelationId().hashCode();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if (obj == null) {
			return( 1 );
		}
		else if (obj instanceof IBusModelChain) {
			IBusModelChain rhs = (IBusModelChain)obj;
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
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					cmp = getOptionalSuffix().compareTo( rhs.getOptionalSuffix() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( -1 );
				}
			}
			if (getRequiredPrevRelationId() != null) {
				if (rhs.getRequiredPrevRelationId() != null) {
					cmp = getRequiredPrevRelationId().compareTo( rhs.getRequiredPrevRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPrevRelationId() != null) {
				return( -1 );
			}
			if (getRequiredNextRelationId() != null) {
				if (rhs.getRequiredNextRelationId() != null) {
					cmp = getRequiredNextRelationId().compareTo( rhs.getRequiredNextRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredNextRelationId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelChainHPKey) {
			IBusModelChainHPKey rhs = (IBusModelChainHPKey)obj;
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
		else if( obj instanceof IBusModelChainH ) {
			IBusModelChainH rhs = (IBusModelChainH)obj;
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
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			if( getOptionalSuffix() != null ) {
				if( rhs.getOptionalSuffix() != null ) {
					cmp = getOptionalSuffix().compareTo( rhs.getOptionalSuffix() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalSuffix() != null ) {
					return( -1 );
				}
			}
			if (getRequiredPrevRelationId() != null) {
				if (rhs.getRequiredPrevRelationId() != null) {
					cmp = getRequiredPrevRelationId().compareTo( rhs.getRequiredPrevRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPrevRelationId() != null) {
				return( -1 );
			}
			if (getRequiredNextRelationId() != null) {
				if (rhs.getRequiredNextRelationId() != null) {
					cmp = getRequiredNextRelationId().compareTo( rhs.getRequiredNextRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredNextRelationId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelChainByChainTableIdxKey) {
			IBusModelChainByChainTableIdxKey rhs = (IBusModelChainByChainTableIdxKey)obj;
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelChainByDefSchemaIdxKey) {
			IBusModelChainByDefSchemaIdxKey rhs = (IBusModelChainByDefSchemaIdxKey)obj;
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
		else if (obj instanceof IBusModelChainByUNameIdxKey) {
			IBusModelChainByUNameIdxKey rhs = (IBusModelChainByUNameIdxKey)obj;
			if (getRequiredTableId() != null) {
				if (rhs.getRequiredTableId() != null) {
					cmp = getRequiredTableId().compareTo( rhs.getRequiredTableId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTableId() != null) {
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
		else if (obj instanceof IBusModelChainByPrevRelIdxKey) {
			IBusModelChainByPrevRelIdxKey rhs = (IBusModelChainByPrevRelIdxKey)obj;
			if (getRequiredPrevRelationId() != null) {
				if (rhs.getRequiredPrevRelationId() != null) {
					cmp = getRequiredPrevRelationId().compareTo( rhs.getRequiredPrevRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPrevRelationId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelChainByNextRelIdxKey) {
			IBusModelChainByNextRelIdxKey rhs = (IBusModelChainByNextRelIdxKey)obj;
			if (getRequiredNextRelationId() != null) {
				if (rhs.getRequiredNextRelationId() != null) {
					cmp = getRequiredNextRelationId().compareTo( rhs.getRequiredNextRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredNextRelationId() != null) {
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
	public void set( IBusModelChain src ) {
		setChain( src );
	}

	@Override
	public void setChain( IBusModelChain src ) {
		setRequiredId(src.getRequiredId());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredContainerTable(src.getRequiredContainerTable());
		setOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setRequiredLookupPrevRel(src.getRequiredLookupPrevRel());
		setRequiredLookupNextRel(src.getRequiredLookupNextRel());
		setOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setRequiredName(src.getRequiredName());
		setOptionalShortName(src.getOptionalShortName());
		setOptionalLabel(src.getOptionalLabel());
		setOptionalShortDescription(src.getOptionalShortDescription());
		setOptionalDescription(src.getOptionalDescription());
		setRequiredTableId(src.getRequiredTableId());
		setOptionalSuffix(src.getOptionalSuffix());
		setRequiredPrevRelationId(src.getRequiredPrevRelationId());
		setRequiredNextRelationId(src.getRequiredNextRelationId());
	}

	@Override
	public void set( IBusModelChainH src ) {
		setChain( src );
	}

	@Override
	public void setChain( IBusModelChainH src ) {
		setRequiredId(src.getRequiredId());
		setRequiredContainerTable(src.getRequiredTableId());
		setOptionalLookupDefSchema(src.getOptionalDefSchemaId());
		setRequiredLookupPrevRel(src.getRequiredPrevRelationId());
		setRequiredLookupNextRel(src.getRequiredNextRelationId());
		setOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setRequiredName(src.getRequiredName());
		setOptionalShortName(src.getOptionalShortName());
		setOptionalLabel(src.getOptionalLabel());
		setOptionalShortDescription(src.getOptionalShortDescription());
		setOptionalDescription(src.getOptionalDescription());
		setRequiredTableId(src.getRequiredTableId());
		setOptionalSuffix(src.getOptionalSuffix());
		setRequiredPrevRelationId(src.getRequiredPrevRelationId());
		setRequiredNextRelationId(src.getRequiredNextRelationId());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = ""
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " classCode=\"" + getClassCode() + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " OptionalDefSchemaId=" + ( ( getOptionalDefSchemaId() == null ) ? "null" : "\"" + getOptionalDefSchemaId().toString() + "\"" )
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\""
			+ " OptionalShortName=" + ( ( getOptionalShortName() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalShortName() ) + "\"" )
			+ " OptionalLabel=" + ( ( getOptionalLabel() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalLabel() ) + "\"" )
			+ " OptionalShortDescription=" + ( ( getOptionalShortDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalShortDescription() ) + "\"" )
			+ " OptionalDescription=" + ( ( getOptionalDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDescription() ) + "\"" )
			+ " RequiredTableId=" + "\"" + getRequiredTableId().toString() + "\""
			+ " OptionalSuffix=" + ( ( getOptionalSuffix() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalSuffix() ) + "\"" )
			+ " RequiredPrevRelationId=" + "\"" + getRequiredPrevRelationId().toString() + "\""
			+ " RequiredNextRelationId=" + "\"" + getRequiredNextRelationId().toString() + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelJpaChain" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
