// Description: Java 25 JPA implementation of a DelSubDep1 entity definition object.

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
	name = "delsubdep1", schema = "BusModel31",
	indexes = {
		@Index(name = "DelSubDep1IdIdx", columnList = "Id", unique = true),
		@Index(name = "DelSubDep1DelTopDepIdx", columnList = "contdeldepid", unique = false),
		@Index(name = "DelSubDep1UNameIdx", columnList = "contdeldepid, safe_name", unique = true),
		@Index(name = "DelSubDep1DelTopDepIdxDelTopDep", columnList = "contdeldepidDelTopDep", unique = false)
	}
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("43036")
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "BusModelPU")
public class BusModelJpaDelSubDep1 extends BusModelJpaDelDep
	implements IBusModelDelSubDep1
{
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn( name="contdeldepidDelTopDep", referencedColumnName="Id" )
	protected BusModelJpaDelTopDep requiredContainerDelTopDep;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="requiredContainerDelSubDep1")
	protected Set<BusModelJpaDelSubDep2> optionalComponentsDelDep;

	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="contdeldepid", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredDelTopDepId;
	@Column( name="safe_name", nullable=false, length=192 )
	protected String requiredName;

	public BusModelJpaDelSubDep1() {
		super();
		requiredDelTopDepId = YCFDbKeyHash256.fromHex( IBusModelPubDelSubDep1.DELTOPDEPID_INIT_VALUE.toString() );
		requiredName = IBusModelPubDelSubDep1.NAME_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( IBusModelDelSubDep1.CLASS_CODE );
	}

	@Override
	public IBusModelDelTopDep getRequiredContainerDelTopDep() {
		return(requiredContainerDelTopDep);
	}

	@Override
	public void setRequiredContainerDelTopDep(IBusModelDelTopDep argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerDelTopDep", 1, "argObj");
		}
		else if (argObj instanceof BusModelJpaDelTopDep) {
			requiredContainerDelTopDep = (BusModelJpaDelTopDep)argObj;
			if (requiredContainerDelTopDep != null) {
				requiredDelTopDepId = requiredContainerDelTopDep.getRequiredId();
			}
			else {
			}
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setContainerDelTopDep", "argObj", argObj, "BusModelJpaDelTopDep");
		}
	}

	@Override
	public void setRequiredContainerDelTopDep(IBusModelProtDelTopDep argObj) {
		setRequiredContainerDelTopDep(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerDelTopDep(IBusModelPubDelTopDep argObj) {
		setRequiredContainerDelTopDep(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerDelTopDep(IYCFKeyHash256 argDelTopDepId) {
		IBusModelSchema targetBackingSchema = IBusModelSchema.getBackingBusModel();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerDelTopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelTopDepTable targetTable = targetBackingSchema.getTableDelTopDep();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerDelTopDep", 0, "IBusModelSchema.getBackingBusModel().getTableDelTopDep()");
		}
		IBusModelDelTopDep targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argDelTopDepId);
		setRequiredContainerDelTopDep(targetRec);
	}

	@Override
	public List<IBusModelDelSubDep2> getOptionalComponentsDelDep() {
		List<IBusModelDelSubDep2> retlist = (optionalComponentsDelDep != null) ? new ArrayList<>(optionalComponentsDelDep) : new ArrayList<>();
		return( retlist );
	}

	@Override
	public IYCFKeyHash256 getRequiredDelTopDepId() {
		return(requiredDelTopDepId);
	}

	public void setRequiredDelTopDepId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredDelTopDepId",
				1,
				"value" );
		}
		requiredDelTopDepId = value;
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
		else if (obj instanceof IBusModelDelSubDep1) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelDelSubDep1 rhs = (IBusModelDelSubDep1)obj;
			if( getRequiredDelTopDepId() != null ) {
				if( rhs.getRequiredDelTopDepId() != null ) {
					if( ! getRequiredDelTopDepId().equals( rhs.getRequiredDelTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelTopDepId() != null ) {
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
		else if (obj instanceof IBusModelDelSubDep1H) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelDelSubDep1H rhs = (IBusModelDelSubDep1H)obj;
			if( getRequiredDelTopDepId() != null ) {
				if( rhs.getRequiredDelTopDepId() != null ) {
					if( ! getRequiredDelTopDepId().equals( rhs.getRequiredDelTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelTopDepId() != null ) {
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
		else if (obj instanceof IBusModelDelSubDep1ByDelTopDepIdxKey) {
			IBusModelDelSubDep1ByDelTopDepIdxKey rhs = (IBusModelDelSubDep1ByDelTopDepIdxKey)obj;
			if( getRequiredDelTopDepId() != null ) {
				if( rhs.getRequiredDelTopDepId() != null ) {
					if( ! getRequiredDelTopDepId().equals( rhs.getRequiredDelTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelTopDepId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelDelSubDep1ByUNameIdxKey) {
			IBusModelDelSubDep1ByUNameIdxKey rhs = (IBusModelDelSubDep1ByUNameIdxKey)obj;
			if( getRequiredDelTopDepId() != null ) {
				if( rhs.getRequiredDelTopDepId() != null ) {
					if( ! getRequiredDelTopDepId().equals( rhs.getRequiredDelTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelTopDepId() != null ) {
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
		hashCode = hashCode + getRequiredDelTopDepId().hashCode();
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
		else if (obj instanceof IBusModelDelSubDep1) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelDelSubDep1 rhs = (IBusModelDelSubDep1)obj;
			if (getRequiredDelTopDepId() != null) {
				if (rhs.getRequiredDelTopDepId() != null) {
					cmp = getRequiredDelTopDepId().compareTo( rhs.getRequiredDelTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelTopDepId() != null) {
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
		else if( obj instanceof IBusModelDelSubDep1H ) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelDelSubDep1H rhs = (IBusModelDelSubDep1H)obj;
			if (getRequiredDelTopDepId() != null) {
				if (rhs.getRequiredDelTopDepId() != null) {
					cmp = getRequiredDelTopDepId().compareTo( rhs.getRequiredDelTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelTopDepId() != null) {
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
		else if (obj instanceof IBusModelDelSubDep1ByDelTopDepIdxKey) {
			IBusModelDelSubDep1ByDelTopDepIdxKey rhs = (IBusModelDelSubDep1ByDelTopDepIdxKey)obj;
			if (getRequiredDelTopDepId() != null) {
				if (rhs.getRequiredDelTopDepId() != null) {
					cmp = getRequiredDelTopDepId().compareTo( rhs.getRequiredDelTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelTopDepId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelDelSubDep1ByUNameIdxKey) {
			IBusModelDelSubDep1ByUNameIdxKey rhs = (IBusModelDelSubDep1ByUNameIdxKey)obj;
			if (getRequiredDelTopDepId() != null) {
				if (rhs.getRequiredDelTopDepId() != null) {
					cmp = getRequiredDelTopDepId().compareTo( rhs.getRequiredDelTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelTopDepId() != null) {
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
		if( src instanceof IBusModelDelSubDep1 ) {
			setDelSubDep1( (IBusModelDelSubDep1)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelJpaDelSubDep1" );
		}
	}

	@Override
	public void setDelSubDep1( IBusModelDelSubDep1 src ) {
		super.setDelDep( src );
		setRequiredContainerDelTopDep(src.getRequiredContainerDelTopDep());
		setRequiredDelTopDepId(src.getRequiredDelTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelScopeH src ) {
		if( src instanceof IBusModelDelSubDep1H ) {
			setDelSubDep1( (IBusModelDelSubDep1H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelDelSubDep1H" );
		}
	}

	@Override
	public void setDelSubDep1( IBusModelDelSubDep1H src ) {
		super.setDelDep( src );
		setRequiredContainerDelTopDep(src.getRequiredDelTopDepId());
		setRequiredDelTopDepId(src.getRequiredDelTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment() 
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredDelTopDepId=" + "\"" + getRequiredDelTopDepId().toString() + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelJpaDelSubDep1" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
