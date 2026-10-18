// Description: Java 25 JPA implementation of a PopSubDep1 entity definition object.

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
	name = "popsubdep1", schema = "BusModel31",
	indexes = {
		@Index(name = "PopSubDep1IdIdx", columnList = "Id", unique = true),
		@Index(name = "PopSubDep1PopTopDepIdx", columnList = "contpopdepid", unique = false),
		@Index(name = "PopSubDep1UNameIdx", columnList = "contpopdepid, safe_name", unique = true),
		@Index(name = "PopSubDep1PopTopDepIdxContPopTopDep", columnList = "contpopdepidContPopTopDep", unique = false)
	}
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("43061")
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "BusModelPU")
public class BusModelJpaPopSubDep1 extends BusModelJpaPopDep
	implements IBusModelPopSubDep1
{
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn( name="contpopdepidContPopTopDep", referencedColumnName="Id" )
	protected BusModelJpaPopTopDep requiredContainerContPopTopDep;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="requiredContainerPopSubDep1")
	protected Set<BusModelJpaPopSubDep2> optionalComponentsPopDep;

	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="contpopdepid", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredPopTopDepId;
	@Column( name="safe_name", nullable=false, length=192 )
	protected String requiredName;

	public BusModelJpaPopSubDep1() {
		super();
		requiredPopTopDepId = YCFDbKeyHash256.fromHex( IBusModelPubPopSubDep1.POPTOPDEPID_INIT_VALUE.toString() );
		requiredName = IBusModelPubPopSubDep1.NAME_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( IBusModelPopSubDep1.CLASS_CODE );
	}

	@Override
	public IBusModelPopTopDep getRequiredContainerContPopTopDep() {
		return(requiredContainerContPopTopDep);
	}

	@Override
	public void setRequiredContainerContPopTopDep(IBusModelPopTopDep argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerContPopTopDep", 1, "argObj");
		}
		else if (argObj instanceof BusModelJpaPopTopDep) {
			requiredContainerContPopTopDep = (BusModelJpaPopTopDep)argObj;
			if (requiredContainerContPopTopDep != null) {
				requiredPopTopDepId = requiredContainerContPopTopDep.getRequiredId();
			}
			else {
			}
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setContainerContPopTopDep", "argObj", argObj, "BusModelJpaPopTopDep");
		}
	}

	@Override
	public void setRequiredContainerContPopTopDep(IBusModelProtPopTopDep argObj) {
		setRequiredContainerContPopTopDep(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerContPopTopDep(IBusModelPubPopTopDep argObj) {
		setRequiredContainerContPopTopDep(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerContPopTopDep(IYCFKeyHash256 argPopTopDepId) {
		IBusModelSchema targetBackingSchema = IBusModelSchema.getBackingBusModel();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerContPopTopDep", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelPopTopDepTable targetTable = targetBackingSchema.getTablePopTopDep();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerContPopTopDep", 0, "IBusModelSchema.getBackingBusModel().getTablePopTopDep()");
		}
		IBusModelPopTopDep targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argPopTopDepId);
		setRequiredContainerContPopTopDep(targetRec);
	}

	@Override
	public List<IBusModelPopSubDep2> getOptionalComponentsPopDep() {
		List<IBusModelPopSubDep2> retlist = (optionalComponentsPopDep != null) ? new ArrayList<>(optionalComponentsPopDep) : new ArrayList<>();
		return( retlist );
	}

	@Override
	public IYCFKeyHash256 getRequiredPopTopDepId() {
		return(requiredPopTopDepId);
	}

	public void setRequiredPopTopDepId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredPopTopDepId",
				1,
				"value" );
		}
		requiredPopTopDepId = value;
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
		else if (obj instanceof IBusModelPopSubDep1) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelPopSubDep1 rhs = (IBusModelPopSubDep1)obj;
			if( getRequiredPopTopDepId() != null ) {
				if( rhs.getRequiredPopTopDepId() != null ) {
					if( ! getRequiredPopTopDepId().equals( rhs.getRequiredPopTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopTopDepId() != null ) {
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
		else if (obj instanceof IBusModelPopSubDep1H) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelPopSubDep1H rhs = (IBusModelPopSubDep1H)obj;
			if( getRequiredPopTopDepId() != null ) {
				if( rhs.getRequiredPopTopDepId() != null ) {
					if( ! getRequiredPopTopDepId().equals( rhs.getRequiredPopTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopTopDepId() != null ) {
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
		else if (obj instanceof IBusModelPopSubDep1ByPopTopDepIdxKey) {
			IBusModelPopSubDep1ByPopTopDepIdxKey rhs = (IBusModelPopSubDep1ByPopTopDepIdxKey)obj;
			if( getRequiredPopTopDepId() != null ) {
				if( rhs.getRequiredPopTopDepId() != null ) {
					if( ! getRequiredPopTopDepId().equals( rhs.getRequiredPopTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopTopDepId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelPopSubDep1ByUNameIdxKey) {
			IBusModelPopSubDep1ByUNameIdxKey rhs = (IBusModelPopSubDep1ByUNameIdxKey)obj;
			if( getRequiredPopTopDepId() != null ) {
				if( rhs.getRequiredPopTopDepId() != null ) {
					if( ! getRequiredPopTopDepId().equals( rhs.getRequiredPopTopDepId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopTopDepId() != null ) {
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
		hashCode = hashCode + getRequiredPopTopDepId().hashCode();
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
		else if (obj instanceof IBusModelPopSubDep1) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelPopSubDep1 rhs = (IBusModelPopSubDep1)obj;
			if (getRequiredPopTopDepId() != null) {
				if (rhs.getRequiredPopTopDepId() != null) {
					cmp = getRequiredPopTopDepId().compareTo( rhs.getRequiredPopTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopTopDepId() != null) {
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
		else if( obj instanceof IBusModelPopSubDep1H ) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelPopSubDep1H rhs = (IBusModelPopSubDep1H)obj;
			if (getRequiredPopTopDepId() != null) {
				if (rhs.getRequiredPopTopDepId() != null) {
					cmp = getRequiredPopTopDepId().compareTo( rhs.getRequiredPopTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopTopDepId() != null) {
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
		else if (obj instanceof IBusModelPopSubDep1ByPopTopDepIdxKey) {
			IBusModelPopSubDep1ByPopTopDepIdxKey rhs = (IBusModelPopSubDep1ByPopTopDepIdxKey)obj;
			if (getRequiredPopTopDepId() != null) {
				if (rhs.getRequiredPopTopDepId() != null) {
					cmp = getRequiredPopTopDepId().compareTo( rhs.getRequiredPopTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopTopDepId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelPopSubDep1ByUNameIdxKey) {
			IBusModelPopSubDep1ByUNameIdxKey rhs = (IBusModelPopSubDep1ByUNameIdxKey)obj;
			if (getRequiredPopTopDepId() != null) {
				if (rhs.getRequiredPopTopDepId() != null) {
					cmp = getRequiredPopTopDepId().compareTo( rhs.getRequiredPopTopDepId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopTopDepId() != null) {
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
		if( src instanceof IBusModelPopSubDep1 ) {
			setPopSubDep1( (IBusModelPopSubDep1)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelJpaPopSubDep1" );
		}
	}

	@Override
	public void setPopSubDep1( IBusModelPopSubDep1 src ) {
		super.setPopDep( src );
		setRequiredContainerContPopTopDep(src.getRequiredContainerContPopTopDep());
		setRequiredPopTopDepId(src.getRequiredPopTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelScopeH src ) {
		if( src instanceof IBusModelPopSubDep1H ) {
			setPopSubDep1( (IBusModelPopSubDep1H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPopSubDep1H" );
		}
	}

	@Override
	public void setPopSubDep1( IBusModelPopSubDep1H src ) {
		super.setPopDep( src );
		setRequiredContainerContPopTopDep(src.getRequiredPopTopDepId());
		setRequiredPopTopDepId(src.getRequiredPopTopDepId());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment() 
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredPopTopDepId=" + "\"" + getRequiredPopTopDepId().toString() + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelJpaPopSubDep1" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
