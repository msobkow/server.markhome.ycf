// Description: Java 25 JPA implementation of ClearSubDep2 history objects

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

/**
 *  BusModelJpaClearSubDep2H provides history objects matching the BusModelClearSubDep2 change history.
 *	Note that because all indexes are historical with multiple instances of history records, the only key that can be unique is the primary key of a history table.
 */
@Entity
@Table(
    name = "clrsubdep2_h", schema = "BusModel31",
    indexes = {
        @Index(name = "ClearSubDep2IdIdx_h", columnList = "auditClusterId, auditStamp, auditAction, requiredRevision, auditSessionId, Id", unique = true),
        @Index(name = "ClearSubDep2ClearSubDep1Idx_h", columnList = "contclrdep1id", unique = false),
        @Index(name = "ClearSubDep2UNameIdx_h", columnList = "contclrdep1id, safe_name", unique = false)
    }
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("43030")
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "BusModelPU")
public class BusModelJpaClearSubDep2H extends BusModelJpaClearDepH
    implements IBusModelClearSubDep2H
{
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="contclrdep1id", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredClearSubDep1Id;
	@Column( name="safe_name", nullable=false, length=192 )
	protected String requiredName;

    public BusModelJpaClearSubDep2H() {
            super();
		requiredClearSubDep1Id = YCFDbKeyHash256.fromHex( IBusModelPubClearSubDep2.CLEARSUBDEP1ID_INIT_VALUE.toString() );
		requiredName = IBusModelPubClearSubDep2.NAME_INIT_VALUE;
    }

    @Override
    public int getClassCode() {
            return( IBusModelClearSubDep2.CLASS_CODE );
    }

	@Override
	public IYCFKeyHash256 getRequiredClearSubDep1Id() {
		return(requiredClearSubDep1Id);
	}

	public void setRequiredClearSubDep1Id( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredClearSubDep1Id",
				1,
				"value" );
		}
		requiredClearSubDep1Id = value;
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
        else if (obj instanceof IBusModelClearSubDep2) {
            IBusModelClearSubDep2 rhs = (IBusModelClearSubDep2)obj;
        if (!super.equals(obj)) {
            return( false );
        }
			if( getRequiredClearSubDep1Id() != null ) {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
					if( ! getRequiredClearSubDep1Id().equals( rhs.getRequiredClearSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
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
        else if (obj instanceof IBusModelClearSubDep2H) {
			if (!super.equals(obj)) {
				return( false );
			}
            IBusModelClearSubDep2H rhs = (IBusModelClearSubDep2H)obj;
        if (!super.equals(obj)) {
            return( false );
        }
			if( getRequiredClearSubDep1Id() != null ) {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
					if( ! getRequiredClearSubDep1Id().equals( rhs.getRequiredClearSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
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
        else if (obj instanceof IBusModelClearSubDep2ByClearSubDep1IdxKey) {
            IBusModelClearSubDep2ByClearSubDep1IdxKey rhs = (IBusModelClearSubDep2ByClearSubDep1IdxKey)obj;
			if( getRequiredClearSubDep1Id() != null ) {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
					if( ! getRequiredClearSubDep1Id().equals( rhs.getRequiredClearSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof IBusModelClearSubDep2ByUNameIdxKey) {
            IBusModelClearSubDep2ByUNameIdxKey rhs = (IBusModelClearSubDep2ByUNameIdxKey)obj;
			if( getRequiredClearSubDep1Id() != null ) {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
					if( ! getRequiredClearSubDep1Id().equals( rhs.getRequiredClearSubDep1Id() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredClearSubDep1Id() != null ) {
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
		hashCode = hashCode + getRequiredClearSubDep1Id().hashCode();
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
        else if (obj instanceof IBusModelClearSubDep2) {
        cmp = super.compareTo(obj);
        if (cmp != 0) {
            return( cmp );
        }
        IBusModelClearSubDep2 rhs = (IBusModelClearSubDep2)obj;
			if (getRequiredClearSubDep1Id() != null) {
				if (rhs.getRequiredClearSubDep1Id() != null) {
					cmp = getRequiredClearSubDep1Id().compareTo( rhs.getRequiredClearSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep1Id() != null) {
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
        else if (obj instanceof IBusModelScopeHPKey) {
        return( super.compareTo(obj) );
        }
        else if (obj instanceof IBusModelClearSubDep2H) {
        cmp = super.compareTo(obj);
        if (cmp != 0) {
            return( cmp );
        }
        IBusModelClearSubDep2H rhs = (IBusModelClearSubDep2H)obj;
			if (getRequiredClearSubDep1Id() != null) {
				if (rhs.getRequiredClearSubDep1Id() != null) {
					cmp = getRequiredClearSubDep1Id().compareTo( rhs.getRequiredClearSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep1Id() != null) {
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
        else if (obj instanceof IBusModelClearSubDep2ByClearSubDep1IdxKey ) {
            IBusModelClearSubDep2ByClearSubDep1IdxKey rhs = (IBusModelClearSubDep2ByClearSubDep1IdxKey)obj;
			if (getRequiredClearSubDep1Id() != null) {
				if (rhs.getRequiredClearSubDep1Id() != null) {
					cmp = getRequiredClearSubDep1Id().compareTo( rhs.getRequiredClearSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep1Id() != null) {
				return( -1 );
			}
            return( 0 );
        }
        else if (obj instanceof IBusModelClearSubDep2ByUNameIdxKey ) {
            IBusModelClearSubDep2ByUNameIdxKey rhs = (IBusModelClearSubDep2ByUNameIdxKey)obj;
			if (getRequiredClearSubDep1Id() != null) {
				if (rhs.getRequiredClearSubDep1Id() != null) {
					cmp = getRequiredClearSubDep1Id().compareTo( rhs.getRequiredClearSubDep1Id() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredClearSubDep1Id() != null) {
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
        return( super.compareTo(obj) );
        }
    }
	@Override
    public void set( IBusModelScope src ) {
		if( src instanceof IBusModelClearSubDep2 ) {
			setClearSubDep2( (IBusModelClearSubDep2)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelJpaClearSubDep2" );
		}
    }

	@Override
    public void setClearSubDep2( IBusModelClearSubDep2 src ) {
        super.setClearDep( src );
		setRequiredClearSubDep1Id( src.getRequiredClearSubDep1Id() );
		setRequiredName( src.getRequiredName() );
    }

	@Override
    public void set( IBusModelScopeH src ) {
		if( src instanceof IBusModelClearSubDep2H ) {
			setClearSubDep2( (IBusModelClearSubDep2H)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelClearSubDep2H" );
		}
    }

	@Override
    public void setClearSubDep2( IBusModelClearSubDep2H src ) {
        super.setClearDep( src );
		setRequiredClearSubDep1Id( src.getRequiredClearSubDep1Id() );
		setRequiredName( src.getRequiredName() );
    }

    public String getXmlAttrFragment() {
        String ret = super.getXmlAttrFragment() 
			+ " RequiredClearSubDep1Id=" + "\"" + getRequiredClearSubDep1Id().toString() + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\"";
        return( ret );
    }

    public String toString() {
        String ret = "<BusModelJpaClearSubDep2H" + getXmlAttrFragment() + "/>";
        return( ret );
    }
}
