// Description: Java 25 JPA implementation of a PopSubDep3 entity definition object.

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
	name = "popsubdep3", schema = "BusModel31",
	indexes = {
		@Index(name = "PopSubDep3IdIdx", columnList = "Id", unique = true),
		@Index(name = "PopSubDep3PopSubDep2Idx", columnList = "contpopdep2id", unique = false),
		@Index(name = "PopSubDep3UNameIdx", columnList = "contpopdep2id, safe_name", unique = true),
		@Index(name = "PopSubDep3PopSubDep2IdxPopSubDep2", columnList = "contpopdep2idPopSubDep2", unique = false)
	}
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("43063")
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "BusModelPU")
public class BusModelJpaPopSubDep3 extends BusModelJpaPopDep
	implements IBusModelPopSubDep3
{
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn( name="contpopdep2idPopSubDep2", referencedColumnName="Id" )
	protected BusModelJpaPopSubDep2 requiredContainerPopSubDep2;

	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="contpopdep2id", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredPopSubDep2Id;
	@Column( name="safe_name", nullable=false, length=192 )
	protected String requiredName;

	public BusModelJpaPopSubDep3() {
		super();
		requiredPopSubDep2Id = YCFDbKeyHash256.fromHex( IBusModelPubPopSubDep3.POPSUBDEP2ID_INIT_VALUE.toString() );
		requiredName = IBusModelPubPopSubDep3.NAME_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( IBusModelPopSubDep3.CLASS_CODE );
	}

	@Override
	public IBusModelPopSubDep2 getRequiredContainerPopSubDep2() {
		return(requiredContainerPopSubDep2);
	}

	@Override
	public void setRequiredContainerPopSubDep2(IBusModelPopSubDep2 argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerPopSubDep2", 1, "argObj");
		}
		else if (argObj instanceof BusModelJpaPopSubDep2) {
			requiredContainerPopSubDep2 = (BusModelJpaPopSubDep2)argObj;
			if (requiredContainerPopSubDep2 != null) {
				requiredPopSubDep2Id = requiredContainerPopSubDep2.getRequiredId();
			}
			else {
			}
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setContainerPopSubDep2", "argObj", argObj, "BusModelJpaPopSubDep2");
		}
	}

	@Override
	public void setRequiredContainerPopSubDep2(IBusModelProtPopSubDep2 argObj) {
		setRequiredContainerPopSubDep2(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerPopSubDep2(IBusModelPubPopSubDep2 argObj) {
		setRequiredContainerPopSubDep2(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerPopSubDep2(IYCFKeyHash256 argPopSubDep2Id) {
		IBusModelSchema targetBackingSchema = IBusModelSchema.getBackingBusModel();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerPopSubDep2", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelPopSubDep2Table targetTable = targetBackingSchema.getTablePopSubDep2();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerPopSubDep2", 0, "IBusModelSchema.getBackingBusModel().getTablePopSubDep2()");
		}
		IBusModelPopSubDep2 targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argPopSubDep2Id);
		setRequiredContainerPopSubDep2(targetRec);
	}

	@Override
	public IYCFKeyHash256 getRequiredPopSubDep2Id() {
		return(requiredPopSubDep2Id);
	}

	public void setRequiredPopSubDep2Id( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredPopSubDep2Id",
				1,
				"value" );
		}
		requiredPopSubDep2Id = value;
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
		else if (obj instanceof IBusModelPopSubDep3) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelPopSubDep3 rhs = (IBusModelPopSubDep3)obj;
			if( getRequiredPopSubDep2Id() != null ) {
				if( rhs.getRequiredPopSubDep2Id() != null ) {
					if( ! getRequiredPopSubDep2Id().equals( rhs.getRequiredPopSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopSubDep2Id() != null ) {
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
		else if (obj instanceof IBusModelPopSubDep3H) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelPopSubDep3H rhs = (IBusModelPopSubDep3H)obj;
			if( getRequiredPopSubDep2Id() != null ) {
				if( rhs.getRequiredPopSubDep2Id() != null ) {
					if( ! getRequiredPopSubDep2Id().equals( rhs.getRequiredPopSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopSubDep2Id() != null ) {
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
		else if (obj instanceof IBusModelPopSubDep3ByPopSubDep2IdxKey) {
			IBusModelPopSubDep3ByPopSubDep2IdxKey rhs = (IBusModelPopSubDep3ByPopSubDep2IdxKey)obj;
			if( getRequiredPopSubDep2Id() != null ) {
				if( rhs.getRequiredPopSubDep2Id() != null ) {
					if( ! getRequiredPopSubDep2Id().equals( rhs.getRequiredPopSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopSubDep2Id() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelPopSubDep3ByUNameIdxKey) {
			IBusModelPopSubDep3ByUNameIdxKey rhs = (IBusModelPopSubDep3ByUNameIdxKey)obj;
			if( getRequiredPopSubDep2Id() != null ) {
				if( rhs.getRequiredPopSubDep2Id() != null ) {
					if( ! getRequiredPopSubDep2Id().equals( rhs.getRequiredPopSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPopSubDep2Id() != null ) {
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
		hashCode = hashCode + getRequiredPopSubDep2Id().hashCode();
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
		else if (obj instanceof IBusModelPopSubDep3) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelPopSubDep3 rhs = (IBusModelPopSubDep3)obj;
			if (getRequiredPopSubDep2Id() != null) {
				if (rhs.getRequiredPopSubDep2Id() != null) {
					cmp = getRequiredPopSubDep2Id().compareTo( rhs.getRequiredPopSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopSubDep2Id() != null) {
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
		else if( obj instanceof IBusModelPopSubDep3H ) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelPopSubDep3H rhs = (IBusModelPopSubDep3H)obj;
			if (getRequiredPopSubDep2Id() != null) {
				if (rhs.getRequiredPopSubDep2Id() != null) {
					cmp = getRequiredPopSubDep2Id().compareTo( rhs.getRequiredPopSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopSubDep2Id() != null) {
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
		else if (obj instanceof IBusModelPopSubDep3ByPopSubDep2IdxKey) {
			IBusModelPopSubDep3ByPopSubDep2IdxKey rhs = (IBusModelPopSubDep3ByPopSubDep2IdxKey)obj;
			if (getRequiredPopSubDep2Id() != null) {
				if (rhs.getRequiredPopSubDep2Id() != null) {
					cmp = getRequiredPopSubDep2Id().compareTo( rhs.getRequiredPopSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopSubDep2Id() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelPopSubDep3ByUNameIdxKey) {
			IBusModelPopSubDep3ByUNameIdxKey rhs = (IBusModelPopSubDep3ByUNameIdxKey)obj;
			if (getRequiredPopSubDep2Id() != null) {
				if (rhs.getRequiredPopSubDep2Id() != null) {
					cmp = getRequiredPopSubDep2Id().compareTo( rhs.getRequiredPopSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPopSubDep2Id() != null) {
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
		if( src instanceof IBusModelPopSubDep3 ) {
			setPopSubDep3( (IBusModelPopSubDep3)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelJpaPopSubDep3" );
		}
	}

	@Override
	public void setPopSubDep3( IBusModelPopSubDep3 src ) {
		super.setPopDep( src );
		setRequiredContainerPopSubDep2(src.getRequiredContainerPopSubDep2());
		setRequiredPopSubDep2Id(src.getRequiredPopSubDep2Id());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelScopeH src ) {
		if( src instanceof IBusModelPopSubDep3H ) {
			setPopSubDep3( (IBusModelPopSubDep3H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelPopSubDep3H" );
		}
	}

	@Override
	public void setPopSubDep3( IBusModelPopSubDep3H src ) {
		super.setPopDep( src );
		setRequiredContainerPopSubDep2(src.getRequiredPopSubDep2Id());
		setRequiredPopSubDep2Id(src.getRequiredPopSubDep2Id());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment() 
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredPopSubDep2Id=" + "\"" + getRequiredPopSubDep2Id().toString() + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelJpaPopSubDep3" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
