// Description: Java 25 JPA implementation of a DelSubDep3 entity definition object.

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
	name = "delsubdep3", schema = "BusModel31",
	indexes = {
		@Index(name = "DelSubDep3IdIdx", columnList = "Id", unique = true),
		@Index(name = "DelSubDep3DelSubDep2Idx", columnList = "contdeldep2id", unique = false),
		@Index(name = "DelSubDep3UNameIdx", columnList = "contdeldep2id, safe_name", unique = true),
		@Index(name = "DelSubDep3DelSubDep2IdxDelSubDep2", columnList = "contdeldep2idDelSubDep2", unique = false)
	}
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("43038")
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "BusModelPU")
public class BusModelJpaDelSubDep3 extends BusModelJpaDelDep
	implements IBusModelDelSubDep3
{
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn( name="contdeldep2idDelSubDep2", referencedColumnName="Id" )
	protected BusModelJpaDelSubDep2 requiredContainerDelSubDep2;

	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="contdeldep2id", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredDelSubDep2Id;
	@Column( name="safe_name", nullable=false, length=192 )
	protected String requiredName;

	public BusModelJpaDelSubDep3() {
		super();
		requiredDelSubDep2Id = YCFDbKeyHash256.fromHex( IBusModelPubDelSubDep3.DELSUBDEP2ID_INIT_VALUE.toString() );
		requiredName = IBusModelPubDelSubDep3.NAME_INIT_VALUE;
	}

	@Override
	public int getClassCode() {
		return( IBusModelDelSubDep3.CLASS_CODE );
	}

	@Override
	public IBusModelDelSubDep2 getRequiredContainerDelSubDep2() {
		return(requiredContainerDelSubDep2);
	}

	@Override
	public void setRequiredContainerDelSubDep2(IBusModelDelSubDep2 argObj) {
		if(argObj == null) {
			throw new YCFNullArgumentException(getClass(), "setContainerDelSubDep2", 1, "argObj");
		}
		else if (argObj instanceof BusModelJpaDelSubDep2) {
			requiredContainerDelSubDep2 = (BusModelJpaDelSubDep2)argObj;
			if (requiredContainerDelSubDep2 != null) {
				requiredDelSubDep2Id = requiredContainerDelSubDep2.getRequiredId();
			}
			else {
			}
		}
		else {
			throw new YCFUnsupportedClassException(getClass(), "setContainerDelSubDep2", "argObj", argObj, "BusModelJpaDelSubDep2");
		}
	}

	@Override
	public void setRequiredContainerDelSubDep2(IBusModelProtDelSubDep2 argObj) {
		setRequiredContainerDelSubDep2(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerDelSubDep2(IBusModelPubDelSubDep2 argObj) {
		setRequiredContainerDelSubDep2(argObj.getRequiredId());
	}

	@Override
	public void setRequiredContainerDelSubDep2(IYCFKeyHash256 argDelSubDep2Id) {
		IBusModelSchema targetBackingSchema = IBusModelSchema.getBackingBusModel();
		if (targetBackingSchema == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerDelSubDep2", 0, "IBusModelSchema.getBackingBusModel()");
		}
		IBusModelDelSubDep2Table targetTable = targetBackingSchema.getTableDelSubDep2();
		if (targetTable == null) {
			throw new YCFNullArgumentException(getClass(), "setRequiredContainerDelSubDep2", 0, "IBusModelSchema.getBackingBusModel().getTableDelSubDep2()");
		}
		IBusModelDelSubDep2 targetRec = targetTable.readDerived(ISecureSchema.getAuthorizationCallback().getEffectiveAuthorization(), argDelSubDep2Id);
		setRequiredContainerDelSubDep2(targetRec);
	}

	@Override
	public IYCFKeyHash256 getRequiredDelSubDep2Id() {
		return(requiredDelSubDep2Id);
	}

	public void setRequiredDelSubDep2Id( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredDelSubDep2Id",
				1,
				"value" );
		}
		requiredDelSubDep2Id = value;
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
		else if (obj instanceof IBusModelDelSubDep3) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelDelSubDep3 rhs = (IBusModelDelSubDep3)obj;
			if( getRequiredDelSubDep2Id() != null ) {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
					if( ! getRequiredDelSubDep2Id().equals( rhs.getRequiredDelSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
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
		else if (obj instanceof IBusModelDelSubDep3H) {
			if (!super.equals(obj)) {
				return( false );
			}
			IBusModelDelSubDep3H rhs = (IBusModelDelSubDep3H)obj;
			if( getRequiredDelSubDep2Id() != null ) {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
					if( ! getRequiredDelSubDep2Id().equals( rhs.getRequiredDelSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
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
		else if (obj instanceof IBusModelDelSubDep3ByDelSubDep2IdxKey) {
			IBusModelDelSubDep3ByDelSubDep2IdxKey rhs = (IBusModelDelSubDep3ByDelSubDep2IdxKey)obj;
			if( getRequiredDelSubDep2Id() != null ) {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
					if( ! getRequiredDelSubDep2Id().equals( rhs.getRequiredDelSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IBusModelDelSubDep3ByUNameIdxKey) {
			IBusModelDelSubDep3ByUNameIdxKey rhs = (IBusModelDelSubDep3ByUNameIdxKey)obj;
			if( getRequiredDelSubDep2Id() != null ) {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
					if( ! getRequiredDelSubDep2Id().equals( rhs.getRequiredDelSubDep2Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDelSubDep2Id() != null ) {
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
		hashCode = hashCode + getRequiredDelSubDep2Id().hashCode();
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
		else if (obj instanceof IBusModelDelSubDep3) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelDelSubDep3 rhs = (IBusModelDelSubDep3)obj;
			if (getRequiredDelSubDep2Id() != null) {
				if (rhs.getRequiredDelSubDep2Id() != null) {
					cmp = getRequiredDelSubDep2Id().compareTo( rhs.getRequiredDelSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep2Id() != null) {
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
		else if( obj instanceof IBusModelDelSubDep3H ) {
			cmp = super.compareTo(obj);
			if (cmp != 0) {
				return( cmp );
			}
			IBusModelDelSubDep3H rhs = (IBusModelDelSubDep3H)obj;
			if (getRequiredDelSubDep2Id() != null) {
				if (rhs.getRequiredDelSubDep2Id() != null) {
					cmp = getRequiredDelSubDep2Id().compareTo( rhs.getRequiredDelSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep2Id() != null) {
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
		else if (obj instanceof IBusModelDelSubDep3ByDelSubDep2IdxKey) {
			IBusModelDelSubDep3ByDelSubDep2IdxKey rhs = (IBusModelDelSubDep3ByDelSubDep2IdxKey)obj;
			if (getRequiredDelSubDep2Id() != null) {
				if (rhs.getRequiredDelSubDep2Id() != null) {
					cmp = getRequiredDelSubDep2Id().compareTo( rhs.getRequiredDelSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep2Id() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof IBusModelDelSubDep3ByUNameIdxKey) {
			IBusModelDelSubDep3ByUNameIdxKey rhs = (IBusModelDelSubDep3ByUNameIdxKey)obj;
			if (getRequiredDelSubDep2Id() != null) {
				if (rhs.getRequiredDelSubDep2Id() != null) {
					cmp = getRequiredDelSubDep2Id().compareTo( rhs.getRequiredDelSubDep2Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDelSubDep2Id() != null) {
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
		if( src instanceof IBusModelDelSubDep3 ) {
			setDelSubDep3( (IBusModelDelSubDep3)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelJpaDelSubDep3" );
		}
	}

	@Override
	public void setDelSubDep3( IBusModelDelSubDep3 src ) {
		super.setDelDep( src );
		setRequiredContainerDelSubDep2(src.getRequiredContainerDelSubDep2());
		setRequiredDelSubDep2Id(src.getRequiredDelSubDep2Id());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public void set( IBusModelScopeH src ) {
		if( src instanceof IBusModelDelSubDep3H ) {
			setDelSubDep3( (IBusModelDelSubDep3H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelDelSubDep3H" );
		}
	}

	@Override
	public void setDelSubDep3( IBusModelDelSubDep3H src ) {
		super.setDelDep( src );
		setRequiredContainerDelSubDep2(src.getRequiredDelSubDep2Id());
		setRequiredDelSubDep2Id(src.getRequiredDelSubDep2Id());
		setRequiredName(src.getRequiredName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = super.getXmlAttrFragment() 
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredDelSubDep2Id=" + "\"" + getRequiredDelSubDep2Id().toString() + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelJpaDelSubDep3" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
