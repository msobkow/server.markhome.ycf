// Description: Java 25 JPA implementation of a DelSubDep2 entity definition object.

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
	name = "delsubdep2", schema = "BusModel31",
	indexes = {
		@Index(name = "DelSubDep2IdIdx", columnList = "Id", unique = true),
		@Index(name = "DelSubDep2DelSubDep1Idx", columnList = "contdeldep1id", unique = false),
		@Index(name = "DelSubDep2UNameIdx", columnList = "contdeldep1id, safe_name", unique = true),
		@Index(name = "DelSubDep2DelSubDep1IdxDelSubDep1", columnList = "contdeldep1idDelSubDep1", unique = false)
	}
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("43037")
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "BusModelPU")
public class BusModelJpaDelSubDep2 extends BusModelJpaDelDep
	implements IBusModelDelSubDep2
{
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn( name="contdeldep1idDelSubDep1", referencedColumnName="Id" )
	protected BusModelJpaDelSubDep1 requiredContainerDelSubDep1;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="requiredContainerDelSubDep2")
	protected Set<BusModelJpaDelSubDep3> optionalComponentsDelDep;

	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="contdeldep1id", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredDelSubDep1Id;
	@Column( name="safe_name", nullable=false, length=192 )
	protected String requiredName;

	public BusModelJpaDelSubDep2() {
		super();
		requiredDelSubDep1Id = YCFDbKeyHash256.fromHex( IBusModelPubDelSubDep2.DELSUBDEP1ID_INIT_VALUE.toString() );
		requiredName = IBusModelPubDelSubDep2.NAME_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( IBusModelDelSubDep2.CLASS_CODE );
	}

	@Override
	public IBusModelDelSubDep1 getRequiredContainerDelSubDep1() {
		return(requiredContainerDelSubDep1);
	}

	@Override
	public void setRequiredContainerDelSubDep1(IBusModelDelSubDep1 argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerDelSubDep1", 1, "argObj");
		}
		else if (argObj instanceof BusModelJpaDelSubDep1) {
			requiredContainerDelSubDep1 = (BusModelJpaDelSubDep1)argObj;
			if (requiredContainerDelSubDep1 != null) {
				requiredDelSubDep1Id = requiredContainerDelSubDep1.getRequiredId();
			}
			else {
			}
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setContainerDelSubDep1", "argObj", argObj, "BusModelJpaDelSubDep1");
		}
	}

	@Override
	public void setRequiredContainerDelSubDep1(IBusModelProtDelSubDep1 argObj) {
		setRequiredContainerDelSubDep1(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerDelSubDep1(IBusModelPubDelSubDep1 argObj) {
		setRequiredContainerDelSubDep1(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerDelSubDep1(IYCFKeyHash256 argDelSubDep1Id) {
		IBusModelSchema targetBackingSchema = IBusModelSchema.getBackingBusModel();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerDelSubDep1", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelSubDep1Table targetTable = targetBackingSchema.getTableDelSubDep1();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerDelSubDep1", 0, "IBusModelSchema.getBackingBusModel().getTableDelSubDep1()");
		}
		IBusModelDelSubDep1 targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argDelSubDep1Id);
		setRequiredContainerDelSubDep1(targetRec);
	}

	@Override
	public List<IBusModelDelSubDep3> getOptionalComponentsDelDep() {
		List<IBusModelDelSubDep3> retlist = (optionalComponentsDelDep != null) ? new ArrayList<>(optionalComponentsDelDep) : new ArrayList<>();
		return( retlist );
	}

	@Override
	public IYCFKeyHash256 getRequiredDelSubDep1Id() {
		return(requiredDelSubDep1Id);
	}

	public void setRequiredDelSubDep1Id( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredDelSubDep1Id",
				1,
				"value" );
		}
		requiredDelSubDep1Id = value;
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
		else if (obj instanceof IBusModelDelSubDep2) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelDelSubDep2 rhs = (IBusModelDelSubDep2)obj;
			if( getRequiredDelSubDep1Id() != null ) {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					if( ! getRequiredDelSubDep1Id().equals( rhs.getRequiredDelSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
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
		else if (obj instanceof IBusModelDelSubDep2H) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelDelSubDep2H rhs = (IBusModelDelSubDep2H)obj;
			if( getRequiredDelSubDep1Id() != null ) {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					if( ! getRequiredDelSubDep1Id().equals( rhs.getRequiredDelSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
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
		else if (obj instanceof IBusModelDelSubDep2ByContDelDep1IdxKey) {
			IBusModelDelSubDep2ByContDelDep1IdxKey rhs = (IBusModelDelSubDep2ByContDelDep1IdxKey)obj;
			if( getRequiredDelSubDep1Id() != null ) {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					if( ! getRequiredDelSubDep1Id().equals( rhs.getRequiredDelSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelDelSubDep2ByUNameIdxKey) {
			IBusModelDelSubDep2ByUNameIdxKey rhs = (IBusModelDelSubDep2ByUNameIdxKey)obj;
			if( getRequiredDelSubDep1Id() != null ) {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
					if( ! getRequiredDelSubDep1Id().equals( rhs.getRequiredDelSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep1Id() != null ) {
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
		hashCode = hashCode + getRequiredDelSubDep1Id().hashCode();
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
		else if (obj instanceof IBusModelDelSubDep2) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelDelSubDep2 rhs = (IBusModelDelSubDep2)obj;
			if (getRequiredDelSubDep1Id() != null) {
				if (rhs.getRequiredDelSubDep1Id() != null) {
					cmp = getRequiredDelSubDep1Id().compareTo( rhs.getRequiredDelSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep1Id() != null) {
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
		else if( obj instanceof IBusModelDelSubDep2H ) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelDelSubDep2H rhs = (IBusModelDelSubDep2H)obj;
			if (getRequiredDelSubDep1Id() != null) {
				if (rhs.getRequiredDelSubDep1Id() != null) {
					cmp = getRequiredDelSubDep1Id().compareTo( rhs.getRequiredDelSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep1Id() != null) {
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
		else if (obj instanceof IBusModelDelSubDep2ByContDelDep1IdxKey) {
			IBusModelDelSubDep2ByContDelDep1IdxKey rhs = (IBusModelDelSubDep2ByContDelDep1IdxKey)obj;
			if (getRequiredDelSubDep1Id() != null) {
				if (rhs.getRequiredDelSubDep1Id() != null) {
					cmp = getRequiredDelSubDep1Id().compareTo( rhs.getRequiredDelSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep1Id() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelDelSubDep2ByUNameIdxKey) {
			IBusModelDelSubDep2ByUNameIdxKey rhs = (IBusModelDelSubDep2ByUNameIdxKey)obj;
			if (getRequiredDelSubDep1Id() != null) {
				if (rhs.getRequiredDelSubDep1Id() != null) {
					cmp = getRequiredDelSubDep1Id().compareTo( rhs.getRequiredDelSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep1Id() != null) {
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
		if( src instanceof IBusModelDelSubDep2 ) {
			setDelSubDep2( (IBusModelDelSubDep2)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelJpaDelSubDep2" );
		}
	}

	@Override
	public void setDelSubDep2( IBusModelDelSubDep2 src ) {
		super.setDelDep( src );
		setRequiredContainerDelSubDep1(src.getRequiredContainerDelSubDep1());
		setRequiredDelSubDep1Id(src.getRequiredDelSubDep1Id());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelScopeH src ) {
		if( src instanceof IBusModelDelSubDep2H ) {
			setDelSubDep2( (IBusModelDelSubDep2H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelDelSubDep2H" );
		}
	}

	@Override
	public void setDelSubDep2( IBusModelDelSubDep2H src ) {
		super.setDelDep( src );
		setRequiredContainerDelSubDep1(src.getRequiredDelSubDep1Id());
		setRequiredDelSubDep1Id(src.getRequiredDelSubDep1Id());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment() 
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredDelSubDep1Id=" + "\"" + getRequiredDelSubDep1Id().toString() + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelJpaDelSubDep2" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
