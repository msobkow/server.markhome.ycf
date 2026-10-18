// Description: Java 25 JPA implementation of SchemaRef history objects

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
 *  BusModelJpaSchemaRefH provides history objects matching the BusModelSchemaRef change history.
 *	Note that because all indexes are historical with multiple instances of history records, the only key that can be unique is the primary key of a history table.
 */
@Entity
@Table(
    name = "schema_ref_h", schema = "BusModel31",
    indexes = {
        @Index(name = "SchemaRefIdIdx_h", columnList = "auditClusterId, auditStamp, auditAction, requiredRevision, auditSessionId, Id", unique = true),
        @Index(name = "SchemaRefSchemaIdx_h", columnList = "SchemaId", unique = false),
        @Index(name = "SchemaRefUNameIdx_h", columnList = "SchemaId, safe_name", unique = false),
        @Index(name = "SchemaRefRefSchemaIdx_h", columnList = "RefSchId", unique = false),
        @Index(name = "SchemaRefPrevIdx_h", columnList = "PrevId", unique = false),
        @Index(name = "SchemaRefNextIdx_h", columnList = "NextId", unique = false)
    }
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("43011")
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "BusModelPU")
public class BusModelJpaSchemaRefH extends BusModelJpaScopeH
    implements IBusModelSchemaRefH
{
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="SchemaId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredSchemaId;
	@Column( name="safe_name", nullable=false, length=192 )
	protected String requiredName;
	@Column( name="RefModelName", nullable=false, length=1024 )
	protected String requiredRefModelName;
	@Column( name="IncludeRoot", nullable=false, length=1024 )
	protected String requiredIncludeRoot;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="RefSchId", nullable=true, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 optionalRefSchemaId;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="PrevId", nullable=true, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 optionalPrevId;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="NextId", nullable=true, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 optionalNextId;

    public BusModelJpaSchemaRefH() {
            super();
		requiredSchemaId = YCFDbKeyHash256.fromHex( IBusModelPubSchemaRef.SCHEMAID_INIT_VALUE.toString() );
		requiredName = IBusModelPubSchemaRef.NAME_INIT_VALUE;
		requiredRefModelName = IBusModelPubSchemaRef.REFMODELNAME_INIT_VALUE;
		requiredIncludeRoot = IBusModelPubSchemaRef.INCLUDEROOT_INIT_VALUE;
		optionalRefSchemaId = YCFDbKeyHash256.nullGet();
		optionalPrevId = YCFDbKeyHash256.nullGet();
		optionalNextId = YCFDbKeyHash256.nullGet();
    }

    @Override
    public int getClassCode() {
            return( IBusModelSchemaRef.CLASS_CODE );
    }

	@Override
	public IYCFKeyHash256 getRequiredSchemaId() {
		return(requiredSchemaId);
	}

	public void setRequiredSchemaId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredSchemaId",
				1,
				"value" );
		}
		requiredSchemaId = value;
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
	public String getRequiredRefModelName() {
		return(requiredRefModelName);
	}

	public void setRequiredRefModelName( String value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredRefModelName",
				1,
				"value" );
		}
		else if( value.length() > 1024 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredRefModelName",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		requiredRefModelName = value;
	}

	@Override
	public String getRequiredIncludeRoot() {
		return(requiredIncludeRoot);
	}

	public void setRequiredIncludeRoot( String value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredIncludeRoot",
				1,
				"value" );
		}
		else if( value.length() > 1024 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredIncludeRoot",
				1,
				"value.length()",
				value.length(),
				1024 );
		}
		requiredIncludeRoot = value;
	}

	@Override
	public IYCFKeyHash256 getOptionalRefSchemaId() {
		return(optionalRefSchemaId);
	}

	public void setOptionalRefSchemaId( IYCFKeyHash256 value ) {
		optionalRefSchemaId = value;
	}

	@Override
	public IYCFKeyHash256 getOptionalPrevId() {
		return(optionalPrevId);
	}

	public void setOptionalPrevId( IYCFKeyHash256 value ) {
		optionalPrevId = value;
	}

	@Override
	public IYCFKeyHash256 getOptionalNextId() {
		return(optionalNextId);
	}

	public void setOptionalNextId( IYCFKeyHash256 value ) {
		optionalNextId = value;
	}

    @Override
    public boolean equals( Object obj ) {
        if (obj == null) {
            return( false );
        }
        else if (obj instanceof IBusModelSchemaRef) {
            IBusModelSchemaRef rhs = (IBusModelSchemaRef)obj;
        if (!super.equals(obj)) {
            return( false );
        }
			if( getRequiredSchemaId() != null ) {
				if( rhs.getRequiredSchemaId() != null ) {
					if( ! getRequiredSchemaId().equals( rhs.getRequiredSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaId() != null ) {
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
			if( getRequiredRefModelName() != null ) {
				if( rhs.getRequiredRefModelName() != null ) {
					if( ! getRequiredRefModelName().equals( rhs.getRequiredRefModelName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRefModelName() != null ) {
					return( false );
				}
			}
			if( getRequiredIncludeRoot() != null ) {
				if( rhs.getRequiredIncludeRoot() != null ) {
					if( ! getRequiredIncludeRoot().equals( rhs.getRequiredIncludeRoot() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIncludeRoot() != null ) {
					return( false );
				}
			}
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					if( ! getOptionalRefSchemaId().equals( rhs.getOptionalRefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					if( ! getOptionalPrevId().equals( rhs.getOptionalPrevId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof IBusModelSchemaRefH) {
			if (!super.equals(obj)) {
				return( false );
			}
            IBusModelSchemaRefH rhs = (IBusModelSchemaRefH)obj;
        if (!super.equals(obj)) {
            return( false );
        }
			if( getRequiredSchemaId() != null ) {
				if( rhs.getRequiredSchemaId() != null ) {
					if( ! getRequiredSchemaId().equals( rhs.getRequiredSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaId() != null ) {
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
			if( getRequiredRefModelName() != null ) {
				if( rhs.getRequiredRefModelName() != null ) {
					if( ! getRequiredRefModelName().equals( rhs.getRequiredRefModelName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredRefModelName() != null ) {
					return( false );
				}
			}
			if( getRequiredIncludeRoot() != null ) {
				if( rhs.getRequiredIncludeRoot() != null ) {
					if( ! getRequiredIncludeRoot().equals( rhs.getRequiredIncludeRoot() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredIncludeRoot() != null ) {
					return( false );
				}
			}
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					if( ! getOptionalRefSchemaId().equals( rhs.getOptionalRefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( false );
				}
			}
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					if( ! getOptionalPrevId().equals( rhs.getOptionalPrevId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( false );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof IBusModelScopeHPKey) {
			return( super.equals(obj) );
        }
        else if (obj instanceof IBusModelSchemaRefBySchemaIdxKey) {
            IBusModelSchemaRefBySchemaIdxKey rhs = (IBusModelSchemaRefBySchemaIdxKey)obj;
			if( getRequiredSchemaId() != null ) {
				if( rhs.getRequiredSchemaId() != null ) {
					if( ! getRequiredSchemaId().equals( rhs.getRequiredSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaId() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof IBusModelSchemaRefByUNameIdxKey) {
            IBusModelSchemaRefByUNameIdxKey rhs = (IBusModelSchemaRefByUNameIdxKey)obj;
			if( getRequiredSchemaId() != null ) {
				if( rhs.getRequiredSchemaId() != null ) {
					if( ! getRequiredSchemaId().equals( rhs.getRequiredSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSchemaId() != null ) {
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
        else if (obj instanceof IBusModelSchemaRefByRefSchemaIdxKey) {
            IBusModelSchemaRefByRefSchemaIdxKey rhs = (IBusModelSchemaRefByRefSchemaIdxKey)obj;
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					if( ! getOptionalRefSchemaId().equals( rhs.getOptionalRefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof IBusModelSchemaRefByPrevIdxKey) {
            IBusModelSchemaRefByPrevIdxKey rhs = (IBusModelSchemaRefByPrevIdxKey)obj;
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					if( ! getOptionalPrevId().equals( rhs.getOptionalPrevId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof IBusModelSchemaRefByNextIdxKey) {
            IBusModelSchemaRefByNextIdxKey rhs = (IBusModelSchemaRefByNextIdxKey)obj;
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					if( ! getOptionalNextId().equals( rhs.getOptionalNextId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
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
		hashCode = hashCode + getRequiredSchemaId().hashCode();
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getRequiredRefModelName() != null ) {
			hashCode = hashCode + getRequiredRefModelName().hashCode();
		}
		if( getRequiredIncludeRoot() != null ) {
			hashCode = hashCode + getRequiredIncludeRoot().hashCode();
		}
		if( getOptionalRefSchemaId() != null ) {
			hashCode = hashCode + getOptionalRefSchemaId().hashCode();
		}
		if( getOptionalPrevId() != null ) {
			hashCode = hashCode + getOptionalPrevId().hashCode();
		}
		if( getOptionalNextId() != null ) {
			hashCode = hashCode + getOptionalNextId().hashCode();
		}
        return( hashCode & 0x7fffffff );
    }

    @Override
    public int compareTo( Object obj ) {
        int cmp;
        if (obj == null) {
            return( 1 );
        }
        else if (obj instanceof IBusModelSchemaRef) {
        cmp = super.compareTo(obj);
        if (cmp != 0) {
            return( cmp );
        }
        IBusModelSchemaRef rhs = (IBusModelSchemaRef)obj;
			if (getRequiredSchemaId() != null) {
				if (rhs.getRequiredSchemaId() != null) {
					cmp = getRequiredSchemaId().compareTo( rhs.getRequiredSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaId() != null) {
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
			if (getRequiredRefModelName() != null) {
				if (rhs.getRequiredRefModelName() != null) {
					cmp = getRequiredRefModelName().compareTo( rhs.getRequiredRefModelName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRefModelName() != null) {
				return( -1 );
			}
			if (getRequiredIncludeRoot() != null) {
				if (rhs.getRequiredIncludeRoot() != null) {
					cmp = getRequiredIncludeRoot().compareTo( rhs.getRequiredIncludeRoot() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIncludeRoot() != null) {
				return( -1 );
			}
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					cmp = getOptionalRefSchemaId().compareTo( rhs.getOptionalRefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					cmp = getOptionalPrevId().compareTo( rhs.getOptionalPrevId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					cmp = getOptionalNextId().compareTo( rhs.getOptionalNextId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( -1 );
				}
			}
            return( 0 );
        }
        else if (obj instanceof IBusModelScopeHPKey) {
        return( super.compareTo(obj) );
        }
        else if (obj instanceof IBusModelSchemaRefH) {
        cmp = super.compareTo(obj);
        if (cmp != 0) {
            return( cmp );
        }
        IBusModelSchemaRefH rhs = (IBusModelSchemaRefH)obj;
			if (getRequiredSchemaId() != null) {
				if (rhs.getRequiredSchemaId() != null) {
					cmp = getRequiredSchemaId().compareTo( rhs.getRequiredSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaId() != null) {
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
			if (getRequiredRefModelName() != null) {
				if (rhs.getRequiredRefModelName() != null) {
					cmp = getRequiredRefModelName().compareTo( rhs.getRequiredRefModelName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredRefModelName() != null) {
				return( -1 );
			}
			if (getRequiredIncludeRoot() != null) {
				if (rhs.getRequiredIncludeRoot() != null) {
					cmp = getRequiredIncludeRoot().compareTo( rhs.getRequiredIncludeRoot() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredIncludeRoot() != null) {
				return( -1 );
			}
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					cmp = getOptionalRefSchemaId().compareTo( rhs.getOptionalRefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					cmp = getOptionalPrevId().compareTo( rhs.getOptionalPrevId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( -1 );
				}
			}
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					cmp = getOptionalNextId().compareTo( rhs.getOptionalNextId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( -1 );
				}
			}
            return( 0 );
        }
        else if (obj instanceof IBusModelSchemaRefBySchemaIdxKey ) {
            IBusModelSchemaRefBySchemaIdxKey rhs = (IBusModelSchemaRefBySchemaIdxKey)obj;
			if (getRequiredSchemaId() != null) {
				if (rhs.getRequiredSchemaId() != null) {
					cmp = getRequiredSchemaId().compareTo( rhs.getRequiredSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaId() != null) {
				return( -1 );
			}
            return( 0 );
        }
        else if (obj instanceof IBusModelSchemaRefByUNameIdxKey ) {
            IBusModelSchemaRefByUNameIdxKey rhs = (IBusModelSchemaRefByUNameIdxKey)obj;
			if (getRequiredSchemaId() != null) {
				if (rhs.getRequiredSchemaId() != null) {
					cmp = getRequiredSchemaId().compareTo( rhs.getRequiredSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSchemaId() != null) {
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
        else if (obj instanceof IBusModelSchemaRefByRefSchemaIdxKey ) {
            IBusModelSchemaRefByRefSchemaIdxKey rhs = (IBusModelSchemaRefByRefSchemaIdxKey)obj;
			if( getOptionalRefSchemaId() != null ) {
				if( rhs.getOptionalRefSchemaId() != null ) {
					cmp = getOptionalRefSchemaId().compareTo( rhs.getOptionalRefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalRefSchemaId() != null ) {
					return( -1 );
				}
			}
            return( 0 );
        }
        else if (obj instanceof IBusModelSchemaRefByPrevIdxKey ) {
            IBusModelSchemaRefByPrevIdxKey rhs = (IBusModelSchemaRefByPrevIdxKey)obj;
			if( getOptionalPrevId() != null ) {
				if( rhs.getOptionalPrevId() != null ) {
					cmp = getOptionalPrevId().compareTo( rhs.getOptionalPrevId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPrevId() != null ) {
					return( -1 );
				}
			}
            return( 0 );
        }
        else if (obj instanceof IBusModelSchemaRefByNextIdxKey ) {
            IBusModelSchemaRefByNextIdxKey rhs = (IBusModelSchemaRefByNextIdxKey)obj;
			if( getOptionalNextId() != null ) {
				if( rhs.getOptionalNextId() != null ) {
					cmp = getOptionalNextId().compareTo( rhs.getOptionalNextId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalNextId() != null ) {
					return( -1 );
				}
			}
            return( 0 );
        }
        else {
        return( super.compareTo(obj) );
        }
    }
	@Override
    public void set( IBusModelScope src ) {
		if( src instanceof IBusModelSchemaRef ) {
			setSchemaRef( (IBusModelSchemaRef)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelJpaSchemaRef" );
		}
    }

	@Override
    public void setSchemaRef( IBusModelSchemaRef src ) {
        super.setScope( src );
		setRequiredSchemaId( src.getRequiredSchemaId() );
		setRequiredName( src.getRequiredName() );
		setRequiredRefModelName( src.getRequiredRefModelName() );
		setRequiredIncludeRoot( src.getRequiredIncludeRoot() );
		setOptionalRefSchemaId( src.getOptionalRefSchemaId() );
		setOptionalPrevId( src.getOptionalPrevId() );
		setOptionalNextId( src.getOptionalNextId() );
    }

	@Override
    public void set( IBusModelScopeH src ) {
		if( src instanceof IBusModelSchemaRefH ) {
			setSchemaRef( (IBusModelSchemaRefH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelSchemaRefH" );
		}
    }

	@Override
    public void setSchemaRef( IBusModelSchemaRefH src ) {
        super.setScope( src );
		setRequiredSchemaId( src.getRequiredSchemaId() );
		setRequiredName( src.getRequiredName() );
		setRequiredRefModelName( src.getRequiredRefModelName() );
		setRequiredIncludeRoot( src.getRequiredIncludeRoot() );
		setOptionalRefSchemaId( src.getOptionalRefSchemaId() );
		setOptionalPrevId( src.getOptionalPrevId() );
		setOptionalNextId( src.getOptionalNextId() );
    }

    public String getXmlAttrFragment() {
        String ret = super.getXmlAttrFragment() 
			+ " RequiredSchemaId=" + "\"" + getRequiredSchemaId().toString() + "\""
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\""
			+ " RequiredRefModelName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredRefModelName() ) + "\""
			+ " RequiredIncludeRoot=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredIncludeRoot() ) + "\""
			+ " OptionalRefSchemaId=" + ( ( getOptionalRefSchemaId() == null ) ? "null" : "\"" + getOptionalRefSchemaId().toString() + "\"" )
			+ " OptionalPrevId=" + ( ( getOptionalPrevId() == null ) ? "null" : "\"" + getOptionalPrevId().toString() + "\"" )
			+ " OptionalNextId=" + ( ( getOptionalNextId() == null ) ? "null" : "\"" + getOptionalNextId().toString() + "\"" );
        return( ret );
    }

    public String toString() {
        String ret = "<BusModelJpaSchemaRefH" + getXmlAttrFragment() + "/>";
        return( ret );
    }
}
