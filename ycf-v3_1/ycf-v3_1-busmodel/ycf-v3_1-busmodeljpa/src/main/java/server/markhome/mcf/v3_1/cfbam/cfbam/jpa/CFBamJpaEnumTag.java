// Description: Java 25 JPA implementation of a EnumTag entity definition object.

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

package server.markhome.mcf.v3_1.cfbam.cfbam.jpa;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cflib.xml.MCFXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;
import server.markhome.mcf.v3_1.cfint.cfint.*;
import server.markhome.mcf.v3_1.cfbam.cfbam.*;
import server.markhome.mcf.v3_1.cfsec.cfsec.jpa.*;
import server.markhome.mcf.v3_1.cfint.cfint.jpa.*;

@Entity
@Table(
	name = "enum_tag", schema = "CFBam31",
	indexes = {
		@Index(name = "EnumTagIdIdx", columnList = "Id", unique = true),
		@Index(name = "EnumTagEnumIdx", columnList = "EnumId", unique = false),
		@Index(name = "EnumTagDefSchemaDefIdx", columnList = "defschid", unique = false),
		@Index(name = "EnumTagEnumNameIdx", columnList = "EnumId, safe_name", unique = true),
		@Index(name = "EnumTagPrevIdx", columnList = "PrevId", unique = false),
		@Index(name = "EnumTagNextIdx", columnList = "NextId", unique = false),
		@Index(name = "EnumTagEnumIdxEnumDef", columnList = "EnumIdEnumDef", unique = false),
		@Index(name = "EnumTagDefSchemaDefIdxDefSchema", columnList = "defschidDefSchema", unique = false),
		@Index(name = "EnumTagPrevIdxPrev", columnList = "PrevIdPrev", unique = false),
		@Index(name = "EnumTagNextIdxNext", columnList = "NextIdNext", unique = false)
	}
)
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "CFBamPU")
public class CFBamJpaEnumTag
	implements Comparable<Object>,
		ICFBamEnumTag,
		Serializable
{
	@Id
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="Id", nullable=false, length=MCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IMCFKeyHash256 requiredId;
	protected int requiredRevision;

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn( name="EnumIdEnumDef", referencedColumnName="Id" )
	protected CFBamJpaEnumDef requiredContainerEnumDef;
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn( name="defschidDefSchema", referencedColumnName="Id" )
	protected CFBamJpaSchemaDef optionalLookupDefSchema;
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn( name="PrevIdPrev", referencedColumnName="Id" )
	protected CFBamJpaEnumTag optionalLookupPrev;
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn( name="NextIdNext", referencedColumnName="Id" )
	protected CFBamJpaEnumTag optionalLookupNext;

	@AttributeOverrides({
		@AttributeOverride( name="bytes", column = @Column( name="CreatedByUserId", nullable=false, length=MCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected MCFDbKeyHash256 createdByUserId = MCFDbKeyHash256.fromHex(ICFBamPubSecUser.S_INIT_CREATED_BY);

	@AttributeOverrides({
		@AttributeOverride( name="bytes", column = @Column( name="CreatedBySessionId", nullable=false, length=MCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected MCFDbKeyHash256 createdBySessionId = MCFDbKeyHash256.fromHex(ICFBamPubSecSession.S_SECSESSIONID_INIT_VALUE);

	@Column(name="CreatedAt", nullable=false)
	protected LocalDateTime createdAt = LocalDateTime.now();

	@AttributeOverrides({
		@AttributeOverride( name="bytes", column= @Column( name="UpdatedByUserId", nullable=false, length=MCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected MCFDbKeyHash256 updatedByUserId = MCFDbKeyHash256.fromHex(ICFBamPubSecUser.S_INIT_UPDATED_BY);

	@AttributeOverrides({
		@AttributeOverride( name="bytes", column= @Column( name="UpdatedBySessionId", nullable=false, length=MCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected MCFDbKeyHash256 updatedBySessionId = MCFDbKeyHash256.fromHex(ICFBamPubSecSession.S_SECSESSIONID_INIT_VALUE);

	@Column(name="UpdatedAt", nullable=false)
	protected LocalDateTime updatedAt = LocalDateTime.now();
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="defschid", nullable=true, length=MCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IMCFKeyHash256 optionalDefSchemaId;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="EnumId", nullable=false, length=MCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IMCFKeyHash256 requiredEnumId;
	@Column( name="EnumCode", nullable=true )
	protected Short optionalEnumCode;
	@Column( name="safe_name", nullable=false, length=64 )
	protected String requiredName;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="PrevId", nullable=true, length=MCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IMCFKeyHash256 optionalPrevId;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="NextId", nullable=true, length=MCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IMCFKeyHash256 optionalNextId;

	public CFBamJpaEnumTag() {
		requiredId = MCFDbKeyHash256.fromHex( ICFBamPubEnumTag.ID_INIT_VALUE.toString() );
		optionalDefSchemaId = MCFDbKeyHash256.nullGet();
		requiredEnumId = MCFDbKeyHash256.fromHex( ICFBamPubEnumTag.ENUMID_INIT_VALUE.toString() );
		optionalEnumCode = null;
		requiredName = ICFBamPubEnumTag.NAME_INIT_VALUE;
		optionalPrevId = MCFDbKeyHash256.nullGet();
		optionalNextId = MCFDbKeyHash256.nullGet();
	}

	@Override
	public int getClassCode() {
		return( ICFBamEnumTag.CLASS_CODE );
	}

	@Override
	public ICFBamEnumDef getRequiredContainerEnumDef() {
		return(requiredContainerEnumDef);
	}

	@Override
	public void setRequiredContainerEnumDef(ICFBamEnumDef argObj) {
		if(argObj == null) {
			throw new MCFNullArgumentException(getClass(), "setContainerEnumDef", 1, "argObj");
		}
		else if (argObj instanceof CFBamJpaEnumDef) {
			requiredContainerEnumDef = (CFBamJpaEnumDef)argObj;
			if (requiredContainerEnumDef != null) {
				requiredEnumId = requiredContainerEnumDef.getRequiredId();
			}
			else {
			}
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setContainerEnumDef", "argObj", argObj, "CFBamJpaEnumDef");
		}
	}

	@Override
	public void setRequiredContainerEnumDef(ICFBamProtEnumDef argObj) {
		setRequiredContainerEnumDef(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerEnumDef(ICFBamPubEnumDef argObj) {
		setRequiredContainerEnumDef(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerEnumDef(IMCFKeyHash256 argEnumId) {
		ICFBamSchema targetBackingSchema = ICFBamSchema.getBackingCFBam();
		if (targetBackingSchema == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerEnumDef", 0, "ICFBamSchema.getBackingCFBam()");
		}
		ICFBamEnumDefTable targetTable = targetBackingSchema.getTableEnumDef();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setRequiredContainerEnumDef", 0, "ICFBamSchema.getBackingCFBam().getTableEnumDef()");
		}
		ICFBamEnumDef targetRec = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argEnumId);
		setRequiredContainerEnumDef(targetRec);
	}

	@Override
	public ICFBamSchemaDef getOptionalLookupDefSchema() {
		return(optionalLookupDefSchema);
	}

	@Override
	public void setOptionalLookupDefSchema(ICFBamSchemaDef argObj) {
		if(argObj == null) {
			optionalLookupDefSchema = null;
		}
		else if (argObj instanceof CFBamJpaSchemaDef) {
			optionalLookupDefSchema = (CFBamJpaSchemaDef)argObj;
			if (optionalLookupDefSchema != null) {
				optionalDefSchemaId = optionalLookupDefSchema.getRequiredId();
			}
			else {
				optionalDefSchemaId = null;
			}
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setLookupDefSchema", "argObj", argObj, "CFBamJpaSchemaDef");
		}
	}

	@Override
	public void setOptionalLookupDefSchema(ICFBamProtSchemaDef argObj) {
		setOptionalLookupDefSchema(argObj.getRequiredId());
	}

	@Override
	public void setOptionalLookupDefSchema(ICFBamPubSchemaDef argObj) {
		setOptionalLookupDefSchema(argObj.getRequiredId());
	}

	@Override
	public void setOptionalLookupDefSchema(IMCFKeyHash256 argDefSchemaId) {
		ICFBamSchema targetBackingSchema = ICFBamSchema.getBackingCFBam();
		if (targetBackingSchema == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupDefSchema", 0, "ICFBamSchema.getBackingCFBam()");
		}
		ICFBamSchemaDefTable targetTable = targetBackingSchema.getTableSchemaDef();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupDefSchema", 0, "ICFBamSchema.getBackingCFBam().getTableSchemaDef()");
		}
		ICFBamSchemaDef targetRec = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argDefSchemaId);
		setOptionalLookupDefSchema(targetRec);
	}

	@Override
	public ICFBamEnumTag getOptionalLookupPrev() {
		return(optionalLookupPrev);
	}

	@Override
	public void setOptionalLookupPrev(ICFBamEnumTag argObj) {
		if(argObj == null) {
			optionalLookupPrev = null;
		}
		else if (argObj instanceof CFBamJpaEnumTag) {
			optionalLookupPrev = (CFBamJpaEnumTag)argObj;
			if (optionalLookupPrev != null) {
				optionalPrevId = optionalLookupPrev.getRequiredId();
			}
			else {
				optionalPrevId = null;
			}
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setLookupPrev", "argObj", argObj, "CFBamJpaEnumTag");
		}
	}

	@Override
	public void setOptionalLookupPrev(ICFBamProtEnumTag argObj) {
		setOptionalLookupPrev(argObj.getRequiredId());
	}

	@Override
	public void setOptionalLookupPrev(ICFBamPubEnumTag argObj) {
		setOptionalLookupPrev(argObj.getRequiredId());
	}

	@Override
	public void setOptionalLookupPrev(IMCFKeyHash256 argPrevId) {
		ICFBamSchema targetBackingSchema = ICFBamSchema.getBackingCFBam();
		if (targetBackingSchema == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupPrev", 0, "ICFBamSchema.getBackingCFBam()");
		}
		ICFBamEnumTagTable targetTable = targetBackingSchema.getTableEnumTag();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupPrev", 0, "ICFBamSchema.getBackingCFBam().getTableEnumTag()");
		}
		ICFBamEnumTag targetRec = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argPrevId);
		setOptionalLookupPrev(targetRec);
	}

	@Override
	public ICFBamEnumTag getOptionalLookupNext() {
		return(optionalLookupNext);
	}

	@Override
	public void setOptionalLookupNext(ICFBamEnumTag argObj) {
		if(argObj == null) {
			optionalLookupNext = null;
		}
		else if (argObj instanceof CFBamJpaEnumTag) {
			optionalLookupNext = (CFBamJpaEnumTag)argObj;
			if (optionalLookupNext != null) {
				optionalNextId = optionalLookupNext.getRequiredId();
			}
			else {
				optionalNextId = null;
			}
		}
		else {
			throw new MCFUnsupportedClassException(getClass(), "setLookupNext", "argObj", argObj, "CFBamJpaEnumTag");
		}
	}

	@Override
	public void setOptionalLookupNext(ICFBamProtEnumTag argObj) {
		setOptionalLookupNext(argObj.getRequiredId());
	}

	@Override
	public void setOptionalLookupNext(ICFBamPubEnumTag argObj) {
		setOptionalLookupNext(argObj.getRequiredId());
	}

	@Override
	public void setOptionalLookupNext(IMCFKeyHash256 argNextId) {
		ICFBamSchema targetBackingSchema = ICFBamSchema.getBackingCFBam();
		if (targetBackingSchema == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupNext", 0, "ICFBamSchema.getBackingCFBam()");
		}
		ICFBamEnumTagTable targetTable = targetBackingSchema.getTableEnumTag();
		if (targetTable == null) {
			throw new MCFNullArgumentException(getClass(), "setOptionalLookupNext", 0, "ICFBamSchema.getBackingCFBam().getTableEnumTag()");
		}
		ICFBamEnumTag targetRec = targetTable.readDerived(ICFSecSchema.getAuthorizationCallback().getEffectiveAuthorization(), argNextId);
		setOptionalLookupNext(targetRec);
	}

	@Override
	public MCFDbKeyHash256 getCreatedByUserId() {
		return( createdByUserId );
	}

	@Override
	public void setCreatedByUserId( MCFDbKeyHash256 value ) {
		if (value == null || value.isNull()) {
			throw new MCFNullArgumentException(getClass(), "setCreatedByUserId", 1, "value");
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
			throw new MCFNullArgumentException(getClass(), "setCreatedAt", 1, "value");
		}
		createdAt = value;
	}

	@Override
	public MCFDbKeyHash256 getUpdatedByUserId() {
		return( updatedByUserId );
	}

	@Override
	public void setUpdatedByUserId( MCFDbKeyHash256 value ) {
		if (value == null || value.isNull()) {
			throw new MCFNullArgumentException(getClass(), "setUpdatedByUserId", 1, "value");
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
			throw new MCFNullArgumentException(getClass(), "setUpdatedAt", 1, "value");
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
	public IMCFKeyHash256 getRequiredId() {
		return(getPKey().getRequiredId());
	}

	public void setRequiredId( IMCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new MCFNullArgumentException( getClass(),
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
	public IMCFKeyHash256 getOptionalDefSchemaId() {
		return(optionalDefSchemaId);
	}

	public void setOptionalDefSchemaId( IMCFKeyHash256 value ) {
		optionalDefSchemaId = value;
	}

	@Override
	public IMCFKeyHash256 getRequiredEnumId() {
		return(requiredEnumId);
	}

	public void setRequiredEnumId( IMCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new MCFNullArgumentException( getClass(),
				"setRequiredEnumId",
				1,
				"value" );
		}
		requiredEnumId = value;
	}

	@Override
	public Short getOptionalEnumCode() {
		return(optionalEnumCode);
	}

	@Override
	public void setOptionalEnumCode( Short value ) {
		if( value < ICFBamPubEnumTag.ENUMCODE_MIN_VALUE ) {
			throw new MCFArgumentUnderflowException( getClass(),
				"setOptionalEnumCode",
				1,
				"value",
				value,
				ICFBamPubEnumTag.ENUMCODE_MIN_VALUE );
		}
		if( value > ICFBamPubEnumTag.ENUMCODE_MAX_VALUE ) {
			throw new MCFArgumentOverflowException( getClass(),
				"setOptionalEnumCode",
				1,
				"value",
				value,
				ICFBamPubEnumTag.ENUMCODE_MAX_VALUE );
		}
		optionalEnumCode = value;
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
	public IMCFKeyHash256 getOptionalPrevId() {
		return(optionalPrevId);
	}

	public void setOptionalPrevId( IMCFKeyHash256 value ) {
		optionalPrevId = value;
	}

	@Override
	public IMCFKeyHash256 getOptionalNextId() {
		return(optionalNextId);
	}

	public void setOptionalNextId( IMCFKeyHash256 value ) {
		optionalNextId = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if (obj == null) {
			return( false );
		}
		else if (obj instanceof ICFBamEnumTag) {
			ICFBamEnumTag rhs = (ICFBamEnumTag)obj;
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
			if( getRequiredEnumId() != null ) {
				if( rhs.getRequiredEnumId() != null ) {
					if( ! getRequiredEnumId().equals( rhs.getRequiredEnumId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnumId() != null ) {
					return( false );
				}
			}
			if( getOptionalEnumCode() != null ) {
				if( rhs.getOptionalEnumCode() != null ) {
					if( ! getOptionalEnumCode().equals( rhs.getOptionalEnumCode() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalEnumCode() != null ) {
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
		else if (obj instanceof ICFBamEnumTagH) {
			ICFBamEnumTagH rhs = (ICFBamEnumTagH)obj;
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
			if( getRequiredEnumId() != null ) {
				if( rhs.getRequiredEnumId() != null ) {
					if( ! getRequiredEnumId().equals( rhs.getRequiredEnumId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnumId() != null ) {
					return( false );
				}
			}
			if( getOptionalEnumCode() != null ) {
				if( rhs.getOptionalEnumCode() != null ) {
					if( ! getOptionalEnumCode().equals( rhs.getOptionalEnumCode() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalEnumCode() != null ) {
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
		else if (obj instanceof ICFBamEnumTagHPKey) {
			ICFBamEnumTagHPKey rhs = (ICFBamEnumTagHPKey)obj;
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
		else if (obj instanceof ICFBamEnumTagByEnumIdxKey) {
			ICFBamEnumTagByEnumIdxKey rhs = (ICFBamEnumTagByEnumIdxKey)obj;
			if( getRequiredEnumId() != null ) {
				if( rhs.getRequiredEnumId() != null ) {
					if( ! getRequiredEnumId().equals( rhs.getRequiredEnumId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnumId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof ICFBamEnumTagByDefSchemaIdxKey) {
			ICFBamEnumTagByDefSchemaIdxKey rhs = (ICFBamEnumTagByDefSchemaIdxKey)obj;
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
		else if (obj instanceof ICFBamEnumTagByEnumNameIdxKey) {
			ICFBamEnumTagByEnumNameIdxKey rhs = (ICFBamEnumTagByEnumNameIdxKey)obj;
			if( getRequiredEnumId() != null ) {
				if( rhs.getRequiredEnumId() != null ) {
					if( ! getRequiredEnumId().equals( rhs.getRequiredEnumId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnumId() != null ) {
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
		else if (obj instanceof ICFBamEnumTagByPrevIdxKey) {
			ICFBamEnumTagByPrevIdxKey rhs = (ICFBamEnumTagByPrevIdxKey)obj;
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
		else if (obj instanceof ICFBamEnumTagByNextIdxKey) {
			ICFBamEnumTagByNextIdxKey rhs = (ICFBamEnumTagByNextIdxKey)obj;
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
		hashCode = hashCode + getRequiredId().hashCode();
		if( getOptionalDefSchemaId() != null ) {
			hashCode = hashCode + getOptionalDefSchemaId().hashCode();
		}
		hashCode = hashCode + getRequiredEnumId().hashCode();
		if( getOptionalEnumCode() != null ) {
			hashCode = ( hashCode * 0x10000 ) + getOptionalEnumCode();
		}
		else {
			hashCode = (hashCode * 0x10000 );
		}
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
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
		else if (obj instanceof ICFBamEnumTag) {
			ICFBamEnumTag rhs = (ICFBamEnumTag)obj;
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
			if (getRequiredEnumId() != null) {
				if (rhs.getRequiredEnumId() != null) {
					cmp = getRequiredEnumId().compareTo( rhs.getRequiredEnumId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnumId() != null) {
				return( -1 );
			}
			if( getOptionalEnumCode() != null ) {
				Short lhsEnumCode = getOptionalEnumCode();
				if( rhs.getOptionalEnumCode() != null ) {
					Short rhsEnumCode = rhs.getOptionalEnumCode();
					cmp = lhsEnumCode.compareTo( rhsEnumCode );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEnumCode() != null ) {
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
		else if (obj instanceof ICFBamEnumTagHPKey) {
			ICFBamEnumTagHPKey rhs = (ICFBamEnumTagHPKey)obj;
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
		else if( obj instanceof ICFBamEnumTagH ) {
			ICFBamEnumTagH rhs = (ICFBamEnumTagH)obj;
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
			if (getRequiredEnumId() != null) {
				if (rhs.getRequiredEnumId() != null) {
					cmp = getRequiredEnumId().compareTo( rhs.getRequiredEnumId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnumId() != null) {
				return( -1 );
			}
			if( getOptionalEnumCode() != null ) {
				Short lhsEnumCode = getOptionalEnumCode();
				if( rhs.getOptionalEnumCode() != null ) {
					Short rhsEnumCode = rhs.getOptionalEnumCode();
					cmp = lhsEnumCode.compareTo( rhsEnumCode );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEnumCode() != null ) {
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
		else if (obj instanceof ICFBamEnumTagByEnumIdxKey) {
			ICFBamEnumTagByEnumIdxKey rhs = (ICFBamEnumTagByEnumIdxKey)obj;
			if (getRequiredEnumId() != null) {
				if (rhs.getRequiredEnumId() != null) {
					cmp = getRequiredEnumId().compareTo( rhs.getRequiredEnumId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnumId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof ICFBamEnumTagByDefSchemaIdxKey) {
			ICFBamEnumTagByDefSchemaIdxKey rhs = (ICFBamEnumTagByDefSchemaIdxKey)obj;
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
		else if (obj instanceof ICFBamEnumTagByEnumNameIdxKey) {
			ICFBamEnumTagByEnumNameIdxKey rhs = (ICFBamEnumTagByEnumNameIdxKey)obj;
			if (getRequiredEnumId() != null) {
				if (rhs.getRequiredEnumId() != null) {
					cmp = getRequiredEnumId().compareTo( rhs.getRequiredEnumId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnumId() != null) {
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
		else if (obj instanceof ICFBamEnumTagByPrevIdxKey) {
			ICFBamEnumTagByPrevIdxKey rhs = (ICFBamEnumTagByPrevIdxKey)obj;
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
		else if (obj instanceof ICFBamEnumTagByNextIdxKey) {
			ICFBamEnumTagByNextIdxKey rhs = (ICFBamEnumTagByNextIdxKey)obj;
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
			throw new MCFUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	@Override
	public void set( ICFBamEnumTag src ) {
		setEnumTag( src );
	}

	@Override
	public void setEnumTag( ICFBamEnumTag src ) {
		setRequiredId(src.getRequiredId());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredContainerEnumDef(src.getRequiredContainerEnumDef());
		setOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setOptionalLookupPrev(src.getOptionalLookupPrev());
		setOptionalLookupNext(src.getOptionalLookupNext());
		setOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setRequiredEnumId(src.getRequiredEnumId());
		setOptionalEnumCode(src.getOptionalEnumCode());
		setRequiredName(src.getRequiredName());
		setOptionalPrevId(src.getOptionalPrevId());
		setOptionalNextId(src.getOptionalNextId());
	}

	@Override
	public void set( ICFBamEnumTagH src ) {
		setEnumTag( src );
	}

	@Override
	public void setEnumTag( ICFBamEnumTagH src ) {
		setRequiredId(src.getRequiredId());
		setRequiredContainerEnumDef(src.getRequiredEnumId());
		setOptionalLookupDefSchema(src.getOptionalDefSchemaId());
		setOptionalLookupPrev(src.getOptionalPrevId());
		setOptionalLookupNext(src.getOptionalNextId());
		setOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setRequiredEnumId(src.getRequiredEnumId());
		setOptionalEnumCode(src.getOptionalEnumCode());
		setRequiredName(src.getRequiredName());
		setOptionalPrevId(src.getOptionalPrevId());
		setOptionalNextId(src.getOptionalNextId());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = ""
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " OptionalDefSchemaId=" + ( ( getOptionalDefSchemaId() == null ) ? "null" : "\"" + getOptionalDefSchemaId().toString() + "\"" )
			+ " RequiredEnumId=" + "\"" + getRequiredEnumId().toString() + "\""
			+ " OptionalEnumCode=" + ( ( getOptionalEnumCode() == null ) ? "null" : "\"" + getOptionalEnumCode().toString() + "\"" )
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\""
			+ " OptionalPrevId=" + ( ( getOptionalPrevId() == null ) ? "null" : "\"" + getOptionalPrevId().toString() + "\"" )
			+ " OptionalNextId=" + ( ( getOptionalNextId() == null ) ? "null" : "\"" + getOptionalNextId().toString() + "\"" );
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFBamJpaEnumTag" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
