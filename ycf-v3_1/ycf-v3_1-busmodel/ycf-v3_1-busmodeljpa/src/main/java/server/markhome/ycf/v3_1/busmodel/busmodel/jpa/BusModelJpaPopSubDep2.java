// Description: Java 25 JPA implementation of a PopSubDep2 entity definition object.

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
	name = "popsubdep2", schema = "BusModel31",
	indexes = {
		@Index(name = "PopSubDep2IdIdx", columnList = "Id", unique = true),
		@Index(name = "PopSubDep2PopSubDep1Idx", columnList = "contpopdep1id", unique = false),
		@Index(name = "PopSubDep2UNameIdx", columnList = "contpopdep1id, safe_name", unique = true),
		@Index(name = "PopSubDep2PopSubDep1IdxPopSubDep1", columnList = "contpopdep1idPopSubDep1", unique = false)
	}
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("43062")
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "BusModelPU")
public class BusModelJpaPopSubDep2 extends BusModelJpaPopDep
	implements IBusModelPopSubDep2
{
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn( name="contpopdep1idPopSubDep1", referencedColumnName="Id" )
	protected BusModelJpaPopSubDep1 requiredContainerPopSubDep1;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="requiredContainerPopSubDep2")
	protected Set<BusModelJpaPopSubDep3> optionalComponentsPopDep;

	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="contpopdep1id", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredPopSubDep1Id;
	@Column( name="safe_name", nullable=false, length=192 )
	protected String requiredName;

	public BusModelJpaPopSubDep2() {
		super();
		requiredPopSubDep1Id = YCFDbKeyHash256.fromHex( IBusModelPubPopSubDep2.POPSUBDEP1ID_INIT_VALUE.toString() );
		requiredName = IBusModelPubPopSubDep2.NAME_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( IBusModelPopSubDep2.CLASS_CODE );
	}

	@Override
	public IBusModelPopSubDep1 getRequiredContainerPopSubDep1() {
		return(requiredContainerPopSubDep1);
	}

	@Override
	public void setRequiredContainerPopSubDep1(IBusModelPopSubDep1 argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerPopSubDep1", 1, "argObj");
		}
		else if (argObj instanceof BusModelJpaPopSubDep1) {
			requiredContainerPopSubDep1 = (BusModelJpaPopSubDep1)argObj;
			if (requiredContainerPopSubDep1 != null) {
				requiredPopSubDep1Id = requiredContainerPopSubDep1.getRequiredId();
			}
			else {
			}
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setContainerPopSubDep1", "argObj", argObj, "BusModelJpaPopSubDep1");
		}
	}

	@Override
	public void setRequiredContainerPopSubDep1(IBusModelProtPopSubDep1 argObj) {
		setRequiredContainerPopSubDep1(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerPopSubDep1(IBusModelPubPopSubDep1 argObj) {
		setRequiredContainerPopSubDep1(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerPopSubDep1(IYCFKeyHash256 argPopSubDep1Id) {
		IBusModelSchema targetBackingSchema = IBusModelSchema.getBackingBusModel();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerPopSubDep1", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelPopSubDep1Table targetTable = targetBackingSchema.getTablePopSubDep1();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerPopSubDep1", 0, "IBusModelSchema.getBackingBusModel().getTablePopSubDep1()");
		}
		IBusModelPopSubDep1 targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argPopSubDep1Id);
		setRequiredContainerPopSubDep1(targetRec);
	}

	@Override
	public List<IBusModelPopSubDep3> getOptionalComponentsPopDep() {
		List<IBusModelPopSubDep3> retlist = (optionalComponentsPopDep != null) ? new ArrayList<>(optionalComponentsPopDep) : new ArrayList<>();
		return( retlist );
	}

	@Override
	public IYCFKeyHash256 getRequiredPopSubDep1Id() {
		return(requiredPopSubDep1Id);
	}

	public void setRequiredPopSubDep1Id( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredPopSubDep1Id",
				1,
				"value" );
		}
		requiredPopSubDep1Id = value;
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
		else if (obj instanceof IBusModelPopSubDep2) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelPopSubDep2 rhs = (IBusModelPopSubDep2)obj;
			if( getRequiredPopSubDep1Id() != null ) {
				if( rhs.getRequiredPopSubDep1Id() != null ) {
					if( ! getRequiredPopSubDep1Id().equals( rhs.getRequiredPopSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopSubDep1Id() != null ) {
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
		else if (obj instanceof IBusModelPopSubDep2H) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelPopSubDep2H rhs = (IBusModelPopSubDep2H)obj;
			if( getRequiredPopSubDep1Id() != null ) {
				if( rhs.getRequiredPopSubDep1Id() != null ) {
					if( ! getRequiredPopSubDep1Id().equals( rhs.getRequiredPopSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopSubDep1Id() != null ) {
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
		else if (obj instanceof IBusModelPopSubDep2ByPopSubDep1IdxKey) {
			IBusModelPopSubDep2ByPopSubDep1IdxKey rhs = (IBusModelPopSubDep2ByPopSubDep1IdxKey)obj;
			if( getRequiredPopSubDep1Id() != null ) {
				if( rhs.getRequiredPopSubDep1Id() != null ) {
					if( ! getRequiredPopSubDep1Id().equals( rhs.getRequiredPopSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopSubDep1Id() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelPopSubDep2ByUNameIdxKey) {
			IBusModelPopSubDep2ByUNameIdxKey rhs = (IBusModelPopSubDep2ByUNameIdxKey)obj;
			if( getRequiredPopSubDep1Id() != null ) {
				if( rhs.getRequiredPopSubDep1Id() != null ) {
					if( ! getRequiredPopSubDep1Id().equals( rhs.getRequiredPopSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopSubDep1Id() != null ) {
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
		hashCode = hashCode + getRequiredPopSubDep1Id().hashCode();
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
		else if (obj instanceof IBusModelPopSubDep2) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelPopSubDep2 rhs = (IBusModelPopSubDep2)obj;
			if (getRequiredPopSubDep1Id() != null) {
				if (rhs.getRequiredPopSubDep1Id() != null) {
					cmp = getRequiredPopSubDep1Id().compareTo( rhs.getRequiredPopSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopSubDep1Id() != null) {
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
		else if( obj instanceof IBusModelPopSubDep2H ) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelPopSubDep2H rhs = (IBusModelPopSubDep2H)obj;
			if (getRequiredPopSubDep1Id() != null) {
				if (rhs.getRequiredPopSubDep1Id() != null) {
					cmp = getRequiredPopSubDep1Id().compareTo( rhs.getRequiredPopSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopSubDep1Id() != null) {
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
		else if (obj instanceof IBusModelPopSubDep2ByPopSubDep1IdxKey) {
			IBusModelPopSubDep2ByPopSubDep1IdxKey rhs = (IBusModelPopSubDep2ByPopSubDep1IdxKey)obj;
			if (getRequiredPopSubDep1Id() != null) {
				if (rhs.getRequiredPopSubDep1Id() != null) {
					cmp = getRequiredPopSubDep1Id().compareTo( rhs.getRequiredPopSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopSubDep1Id() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelPopSubDep2ByUNameIdxKey) {
			IBusModelPopSubDep2ByUNameIdxKey rhs = (IBusModelPopSubDep2ByUNameIdxKey)obj;
			if (getRequiredPopSubDep1Id() != null) {
				if (rhs.getRequiredPopSubDep1Id() != null) {
					cmp = getRequiredPopSubDep1Id().compareTo( rhs.getRequiredPopSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopSubDep1Id() != null) {
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
		if( src instanceof IBusModelPopSubDep2 ) {
			setPopSubDep2( (IBusModelPopSubDep2)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelJpaPopSubDep2" );
		}
	}

	@Override
	public void setPopSubDep2( IBusModelPopSubDep2 src ) {
		super.setPopDep( src );
		setRequiredContainerPopSubDep1(src.getRequiredContainerPopSubDep1());
		setRequiredPopSubDep1Id(src.getRequiredPopSubDep1Id());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelScopeH src ) {
		if( src instanceof IBusModelPopSubDep2H ) {
			setPopSubDep2( (IBusModelPopSubDep2H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPopSubDep2H" );
		}
	}

	@Override
	public void setPopSubDep2( IBusModelPopSubDep2H src ) {
		super.setPopDep( src );
		setRequiredContainerPopSubDep1(src.getRequiredPopSubDep1Id());
		setRequiredPopSubDep1Id(src.getRequiredPopSubDep1Id());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment() 
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredPopSubDep1Id=" + "\"" + getRequiredPopSubDep1Id().toString() + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelJpaPopSubDep2" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
