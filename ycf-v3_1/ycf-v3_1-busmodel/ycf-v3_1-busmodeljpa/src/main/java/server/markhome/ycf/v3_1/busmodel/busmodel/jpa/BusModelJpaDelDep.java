// Description: Java 25 JPA implementation of a DelDep entity definition object.

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
	name = "del_dep", schema = "BusModel31",
	indexes = {
		@Index(name = "DelDepIdIdx", columnList = "Id", unique = true),
		@Index(name = "DelDepDefSchemaDefIdx", columnList = "defschid", unique = false),
		@Index(name = "DelDepRelationIdx", columnList = "RelationId", unique = false),
		@Index(name = "DelDepRelationIdxRelation", columnList = "RelationIdRelation", unique = false),
		@Index(name = "DelDepDefSchemaDefIdxDefSchema", columnList = "defschidDefSchema", unique = false)
	}
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("43035")
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "BusModelPU")
public class BusModelJpaDelDep extends BusModelJpaScope
	implements IBusModelDelDep
{
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn( name="RelationIdRelation", referencedColumnName="Id" )
	protected BusModelJpaRelation requiredLookupRelation;
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn( name="defschidDefSchema", referencedColumnName="Id" )
	protected BusModelJpaSchemaDef optionalLookupDefSchema;

	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="defschid", nullable=true, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 optionalDefSchemaId;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="RelationId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredRelationId;

	public BusModelJpaDelDep() {
		super();
		optionalDefSchemaId = YCFDbKeyHash256.nullGet();
		requiredRelationId = YCFDbKeyHash256.fromHex( IBusModelPubDelDep.RELATIONID_INIT_VALUE.toString() );
	}

	@Override
	public int getClassCode() {
		return( IBusModelDelDep.CLASS_CODE );
	}

	@Override
	public IBusModelRelation getRequiredLookupRelation() {
		return(requiredLookupRelation);
	}

	@Override
	public void setRequiredLookupRelation(IBusModelRelation argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setLookupRelation", 1, "argObj");
		}
		else if (argObj instanceof BusModelJpaRelation) {
			requiredLookupRelation = (BusModelJpaRelation)argObj;
			if (requiredLookupRelation != null) {
				requiredRelationId = requiredLookupRelation.getRequiredId();
			}
			else {
			}
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setLookupRelation", "argObj", argObj, "BusModelJpaRelation");
		}
	}

	@Override
	public void setRequiredLookupRelation(IBusModelProtRelation argObj) {
		setRequiredLookupRelation(argObj.getRequiredId());
	}

	@Override
	public void setRequiredLookupRelation(IBusModelPubRelation argObj) {
		setRequiredLookupRelation(argObj.getRequiredId());
	}

	@Override
	public void setRequiredLookupRelation(IYCFKeyHash256 argRelationId) {
		IBusModelSchema targetBackingSchema = IBusModelSchema.getBackingBusModel();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredLookupRelation", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelRelationTable targetTable = targetBackingSchema.getTableRelation();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredLookupRelation", 0, "IBusModelSchema.getBackingBusModel().getTableRelation()");
		}
		IBusModelRelation targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argRelationId);
		setRequiredLookupRelation(targetRec);
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
	public IYCFKeyHash256 getOptionalDefSchemaId() {
		return(optionalDefSchemaId);
	}

	public void setOptionalDefSchemaId( IYCFKeyHash256 value ) {
		optionalDefSchemaId = value;
	}

	@Override
	public IYCFKeyHash256 getRequiredRelationId() {
		return(requiredRelationId);
	}

	public void setRequiredRelationId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredRelationId",
				1,
				"value" );
		}
		requiredRelationId = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if (obj == null) {
			return( false );
		}
		else if (obj instanceof IBusModelDelDep) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelDelDep rhs = (IBusModelDelDep)obj;
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
			if( getRequiredRelationId() != null ) {
				if( rhs.getRequiredRelationId() != null ) {
					if( ! getRequiredRelationId().equals( rhs.getRequiredRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRelationId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelDelDepH) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelDelDepH rhs = (IBusModelDelDepH)obj;
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
			if( getRequiredRelationId() != null ) {
				if( rhs.getRequiredRelationId() != null ) {
					if( ! getRequiredRelationId().equals( rhs.getRequiredRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRelationId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelScopeHPKey) {
			return( super.equals(obj) );
		}
		else if (obj instanceof IBusModelDelDepByDefSchemaIdxKey) {
			IBusModelDelDepByDefSchemaIdxKey rhs = (IBusModelDelDepByDefSchemaIdxKey)obj;
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
		else if (obj instanceof IBusModelDelDepByDelDepIdxKey) {
			IBusModelDelDepByDelDepIdxKey rhs = (IBusModelDelDepByDelDepIdxKey)obj;
			if( getRequiredRelationId() != null ) {
				if( rhs.getRequiredRelationId() != null ) {
					if( ! getRequiredRelationId().equals( rhs.getRequiredRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRelationId() != null ) {
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
		if( getOptionalDefSchemaId() != null ) {
			hashCode = hashCode + getOptionalDefSchemaId().hashCode();
		}
		hashCode = hashCode + getRequiredRelationId().hashCode();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if (obj == null) {
			return( 1 );
		}
		else if (obj instanceof IBusModelDelDep) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelDelDep rhs = (IBusModelDelDep)obj;
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
			if (getRequiredRelationId() != null) {
				if (rhs.getRequiredRelationId() != null) {
					cmp = getRequiredRelationId().compareTo( rhs.getRequiredRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRelationId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelDelDepH ) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelDelDepH rhs = (IBusModelDelDepH)obj;
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
			if (getRequiredRelationId() != null) {
				if (rhs.getRequiredRelationId() != null) {
					cmp = getRequiredRelationId().compareTo( rhs.getRequiredRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRelationId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelDelDepByDefSchemaIdxKey) {
			IBusModelDelDepByDefSchemaIdxKey rhs = (IBusModelDelDepByDefSchemaIdxKey)obj;
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
		else if (obj instanceof IBusModelDelDepByDelDepIdxKey) {
			IBusModelDelDepByDelDepIdxKey rhs = (IBusModelDelDepByDelDepIdxKey)obj;
			if (getRequiredRelationId() != null) {
				if (rhs.getRequiredRelationId() != null) {
					cmp = getRequiredRelationId().compareTo( rhs.getRequiredRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRelationId() != null) {
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
		if( src instanceof IBusModelDelDep ) {
			setDelDep( (IBusModelDelDep)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelJpaDelDep" );
		}
	}

	@Override
	public void setDelDep( IBusModelDelDep src ) {
		super.setScope( src );
		setRequiredLookupRelation(src.getRequiredLookupRelation());
		setOptionalLookupDefSchema(src.getOptionalLookupDefSchema());
		setOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setRequiredRelationId(src.getRequiredRelationId());
	}

	@Override
	public void set( IBusModelScopeH src ) {
		if( src instanceof IBusModelDelDepH ) {
			setDelDep( (IBusModelDelDepH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelDelDepH" );
		}
	}

	@Override
	public void setDelDep( IBusModelDelDepH src ) {
		super.setScope( src );
		setRequiredLookupRelation(src.getRequiredRelationId());
		setOptionalLookupDefSchema(src.getOptionalDefSchemaId());
		setOptionalDefSchemaId(src.getOptionalDefSchemaId());
		setRequiredRelationId(src.getRequiredRelationId());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment() 
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " OptionalDefSchemaId=" + ( ( getOptionalDefSchemaId() == null ) ? "null" : "\"" + getOptionalDefSchemaId().toString() + "\"" )
			+ " RequiredRelationId=" + "\"" + getRequiredRelationId().toString() + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelJpaDelDep" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
