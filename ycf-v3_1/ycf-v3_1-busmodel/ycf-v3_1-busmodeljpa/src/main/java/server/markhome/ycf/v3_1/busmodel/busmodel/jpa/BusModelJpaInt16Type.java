// Description: Java 25 JPA implementation of a Int16Type entity definition object.

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
	name = "int16typ", schema = "BusModel31",
	indexes = {
		@Index(name = "Int16TypeIdIdx", columnList = "Id", unique = true),
		@Index(name = "Int16TypeSchemaDefIdx", columnList = "SchemaDefId", unique = false),
		@Index(name = "Int16TypeSchemaDefIdxSchemaDef", columnList = "SchemaDefIdSchemaDef", unique = false)
	}
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("43048")
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "BusModelPU")
public class BusModelJpaInt16Type extends BusModelJpaInt16Def
	implements IBusModelInt16Type
{
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn( name="SchemaDefIdSchemaDef", referencedColumnName="Id" )
	protected BusModelJpaSchemaDef requiredContainerSchemaDef;

	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="SchemaDefId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredSchemaDefId;

	public BusModelJpaInt16Type() {
		super();
		requiredSchemaDefId = YCFDbKeyHash256.fromHex( IBusModelPubInt16Type.SCHEMADEFID_INIT_VALUE.toString() );
	}

	@Override
	public int getClassCode() {
		return( IBusModelInt16Type.CLASS_CODE );
	}

	@Override
	public IBusModelSchemaDef getRequiredContainerSchemaDef() {
		return(requiredContainerSchemaDef);
	}

	@Override
	public void setRequiredContainerSchemaDef(IBusModelSchemaDef argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerSchemaDef", 1, "argObj");
		}
		else if (argObj instanceof BusModelJpaSchemaDef) {
			requiredContainerSchemaDef = (BusModelJpaSchemaDef)argObj;
			if (requiredContainerSchemaDef != null) {
				requiredSchemaDefId = requiredContainerSchemaDef.getRequiredId();
			}
			else {
			}
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setContainerSchemaDef", "argObj", argObj, "BusModelJpaSchemaDef");
		}
	}

	@Override
	public void setRequiredContainerSchemaDef(IBusModelProtSchemaDef argObj) {
		setRequiredContainerSchemaDef(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerSchemaDef(IBusModelPubSchemaDef argObj) {
		setRequiredContainerSchemaDef(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerSchemaDef(IYCFKeyHash256 argSchemaDefId) {
		IBusModelSchema targetBackingSchema = IBusModelSchema.getBackingBusModel();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerSchemaDef", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelSchemaDefTable targetTable = targetBackingSchema.getTableSchemaDef();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerSchemaDef", 0, "IBusModelSchema.getBackingBusModel().getTableSchemaDef()");
		}
		IBusModelSchemaDef targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argSchemaDefId);
		setRequiredContainerSchemaDef(targetRec);
	}

	@Override
	public IYCFKeyHash256 getRequiredSchemaDefId() {
		return(requiredSchemaDefId);
	}

	public void setRequiredSchemaDefId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredSchemaDefId",
				1,
				"value" );
		}
		requiredSchemaDefId = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if (obj == null) {
			return( false );
		}
		else if (obj instanceof IBusModelInt16Type) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelInt16Type rhs = (IBusModelInt16Type)obj;
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelInt16TypeH) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelInt16TypeH rhs = (IBusModelInt16TypeH)obj;
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelValueHPKey) {
			return( super.equals(obj) );
		}
		else if (obj instanceof IBusModelInt16TypeBySchemaIdxKey) {
			IBusModelInt16TypeBySchemaIdxKey rhs = (IBusModelInt16TypeBySchemaIdxKey)obj;
			if( getRequiredSchemaDefId() != null ) {
				if( rhs.getRequiredSchemaDefId() != null ) {
					if( ! getRequiredSchemaDefId().equals( rhs.getRequiredSchemaDefId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaDefId() != null ) {
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
		hashCode = hashCode + getRequiredSchemaDefId().hashCode();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if (obj == null) {
			return( 1 );
		}
		else if (obj instanceof IBusModelInt16Type) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelInt16Type rhs = (IBusModelInt16Type)obj;
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof IBusModelInt16TypeH ) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelInt16TypeH rhs = (IBusModelInt16TypeH)obj;
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelInt16TypeBySchemaIdxKey) {
			IBusModelInt16TypeBySchemaIdxKey rhs = (IBusModelInt16TypeBySchemaIdxKey)obj;
			if (getRequiredSchemaDefId() != null) {
				if (rhs.getRequiredSchemaDefId() != null) {
					cmp = getRequiredSchemaDefId().compareTo( rhs.getRequiredSchemaDefId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaDefId() != null) {
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
	public void set( IBusModelValue src ) {
		if( src instanceof IBusModelInt16Type ) {
			setInt16Type( (IBusModelInt16Type)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelJpaInt16Type" );
		}
	}

	@Override
	public void setInt16Type( IBusModelInt16Type src ) {
		super.setInt16Def( src );
		setRequiredContainerSchemaDef(src.getRequiredContainerSchemaDef());
		setRequiredSchemaDefId(src.getRequiredSchemaDefId());
	}

	@Override
	public void set( IBusModelValueH src ) {
		if( src instanceof IBusModelInt16TypeH ) {
			setInt16Type( (IBusModelInt16TypeH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelInt16TypeH" );
		}
	}

	@Override
	public void setInt16Type( IBusModelInt16TypeH src ) {
		super.setInt16Def( src );
		setRequiredContainerSchemaDef(src.getRequiredSchemaDefId());
		setRequiredSchemaDefId(src.getRequiredSchemaDefId());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment() 
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredSchemaDefId=" + "\"" + getRequiredSchemaDefId().toString() + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelJpaInt16Type" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
