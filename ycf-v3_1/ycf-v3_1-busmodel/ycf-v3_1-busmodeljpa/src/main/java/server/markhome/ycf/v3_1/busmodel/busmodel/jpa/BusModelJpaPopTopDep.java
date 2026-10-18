// Description: Java 25 JPA implementation of a PopTopDep entity definition object.

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
	name = "pop_topdep", schema = "BusModel31",
	indexes = {
		@Index(name = "PopTopDepIdIdx", columnList = "Id", unique = true),
		@Index(name = "PopTopDepContRelationIdx", columnList = "ContRelationId", unique = false),
		@Index(name = "PopTopDepUNameIdx", columnList = "ContRelationId, safe_name", unique = true),
		@Index(name = "PopTopDepContRelationIdxContRelation", columnList = "ContRelationIdContRelation", unique = false)
	}
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("43064")
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "BusModelPU")
public class BusModelJpaPopTopDep extends BusModelJpaPopDep
	implements IBusModelPopTopDep
{
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn( name="ContRelationIdContRelation", referencedColumnName="Id" )
	protected BusModelJpaRelation requiredContainerContRelation;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="requiredContainerContPopTopDep")
	protected Set<BusModelJpaPopSubDep1> optionalComponentsPopDep;

	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="ContRelationId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredContRelationId;
	@Column( name="safe_name", nullable=false, length=192 )
	protected String requiredName;

	public BusModelJpaPopTopDep() {
		super();
		requiredContRelationId = YCFDbKeyHash256.fromHex( IBusModelPubPopTopDep.CONTRELATIONID_INIT_VALUE.toString() );
		requiredName = IBusModelPubPopTopDep.NAME_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( IBusModelPopTopDep.CLASS_CODE );
	}

	@Override
	public IBusModelRelation getRequiredContainerContRelation() {
		return(requiredContainerContRelation);
	}

	@Override
	public void setRequiredContainerContRelation(IBusModelRelation argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerContRelation", 1, "argObj");
		}
		else if (argObj instanceof BusModelJpaRelation) {
			requiredContainerContRelation = (BusModelJpaRelation)argObj;
			if (requiredContainerContRelation != null) {
				requiredContRelationId = requiredContainerContRelation.getRequiredId();
			}
			else {
			}
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setContainerContRelation", "argObj", argObj, "BusModelJpaRelation");
		}
	}

	@Override
	public void setRequiredContainerContRelation(IBusModelProtRelation argObj) {
		setRequiredContainerContRelation(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerContRelation(IBusModelPubRelation argObj) {
		setRequiredContainerContRelation(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerContRelation(IYCFKeyHash256 argContRelationId) {
		IBusModelSchema targetBackingSchema = IBusModelSchema.getBackingBusModel();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerContRelation", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelRelationTable targetTable = targetBackingSchema.getTableRelation();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerContRelation", 0, "IBusModelSchema.getBackingBusModel().getTableRelation()");
		}
		IBusModelRelation targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argContRelationId);
		setRequiredContainerContRelation(targetRec);
	}

	@Override
	public List<IBusModelPopSubDep1> getOptionalComponentsPopDep() {
		List<IBusModelPopSubDep1> retlist = (optionalComponentsPopDep != null) ? new ArrayList<>(optionalComponentsPopDep) : new ArrayList<>();
		return( retlist );
	}

	@Override
	public IYCFKeyHash256 getRequiredContRelationId() {
		return(requiredContRelationId);
	}

	public void setRequiredContRelationId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredContRelationId",
				1,
				"value" );
		}
		requiredContRelationId = value;
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
	public boolean equals( Object obj ) {
		if (obj == null) {
			return( false );
		}
		else if (obj instanceof IBusModelPopTopDep) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelPopTopDep rhs = (IBusModelPopTopDep)obj;
			if( getRequiredContRelationId() != null ) {
				if( rhs.getRequiredContRelationId() != null ) {
					if( ! getRequiredContRelationId().equals( rhs.getRequiredContRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredContRelationId() != null ) {
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
		else if (obj instanceof IBusModelPopTopDepH) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelPopTopDepH rhs = (IBusModelPopTopDepH)obj;
			if( getRequiredContRelationId() != null ) {
				if( rhs.getRequiredContRelationId() != null ) {
					if( ! getRequiredContRelationId().equals( rhs.getRequiredContRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredContRelationId() != null ) {
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
		else if (obj instanceof IBusModelScopeHPKey) {
			return( super.equals(obj) );
		}
		else if (obj instanceof IBusModelPopTopDepByContRelIdxKey) {
			IBusModelPopTopDepByContRelIdxKey rhs = (IBusModelPopTopDepByContRelIdxKey)obj;
			if( getRequiredContRelationId() != null ) {
				if( rhs.getRequiredContRelationId() != null ) {
					if( ! getRequiredContRelationId().equals( rhs.getRequiredContRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredContRelationId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelPopTopDepByUNameIdxKey) {
			IBusModelPopTopDepByUNameIdxKey rhs = (IBusModelPopTopDepByUNameIdxKey)obj;
			if( getRequiredContRelationId() != null ) {
				if( rhs.getRequiredContRelationId() != null ) {
					if( ! getRequiredContRelationId().equals( rhs.getRequiredContRelationId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredContRelationId() != null ) {
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
			return( super.equals(obj) );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = super.hashCode();
		hashCode = hashCode + getRequiredContRelationId().hashCode();
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if (obj == null) {
			return( 1 );
		}
		else if (obj instanceof IBusModelPopTopDep) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelPopTopDep rhs = (IBusModelPopTopDep)obj;
			if (getRequiredContRelationId() != null) {
				if (rhs.getRequiredContRelationId() != null) {
					cmp = getRequiredContRelationId().compareTo( rhs.getRequiredContRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredContRelationId() != null) {
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
		else if( obj instanceof IBusModelPopTopDepH ) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelPopTopDepH rhs = (IBusModelPopTopDepH)obj;
			if (getRequiredContRelationId() != null) {
				if (rhs.getRequiredContRelationId() != null) {
					cmp = getRequiredContRelationId().compareTo( rhs.getRequiredContRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredContRelationId() != null) {
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
		else if (obj instanceof IBusModelPopTopDepByContRelIdxKey) {
			IBusModelPopTopDepByContRelIdxKey rhs = (IBusModelPopTopDepByContRelIdxKey)obj;
			if (getRequiredContRelationId() != null) {
				if (rhs.getRequiredContRelationId() != null) {
					cmp = getRequiredContRelationId().compareTo( rhs.getRequiredContRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredContRelationId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelPopTopDepByUNameIdxKey) {
			IBusModelPopTopDepByUNameIdxKey rhs = (IBusModelPopTopDepByUNameIdxKey)obj;
			if (getRequiredContRelationId() != null) {
				if (rhs.getRequiredContRelationId() != null) {
					cmp = getRequiredContRelationId().compareTo( rhs.getRequiredContRelationId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredContRelationId() != null) {
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
			cmp = super.compareTo(obj);
			return( cmp );
		}
	}

	@Override
	public void set( IBusModelScope src ) {
		if( src instanceof IBusModelPopTopDep ) {
			setPopTopDep( (IBusModelPopTopDep)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelJpaPopTopDep" );
		}
	}

	@Override
	public void setPopTopDep( IBusModelPopTopDep src ) {
		super.setPopDep( src );
		setRequiredContainerContRelation(src.getRequiredContainerContRelation());
		setRequiredContRelationId(src.getRequiredContRelationId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelScopeH src ) {
		if( src instanceof IBusModelPopTopDepH ) {
			setPopTopDep( (IBusModelPopTopDepH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPopTopDepH" );
		}
	}

	@Override
	public void setPopTopDep( IBusModelPopTopDepH src ) {
		super.setPopDep( src );
		setRequiredContainerContRelation(src.getRequiredContRelationId());
		setRequiredContRelationId(src.getRequiredContRelationId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment() 
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredContRelationId=" + "\"" + getRequiredContRelationId().toString() + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelJpaPopTopDep" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
