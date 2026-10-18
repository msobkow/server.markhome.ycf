// Description: Java 25 JPA implementation of Param history objects

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
 *  BusModelJpaParamH provides history objects matching the BusModelParam change history.
 *	Note that because all indexes are historical with multiple instances of history records, the only key that can be unique is the primary key of a history table.
 */
@Entity
@Table(
    name = "srvprm_h", schema = "BusModel31",
    indexes = {
        @Index(name = "ParamIdIdx_h", columnList = "auditClusterId, auditStamp, auditAction, requiredRevision, auditSessionId, Id", unique = true),
        @Index(name = "ParamUNameIdx_h", columnList = "srvmeth_id, safe_name", unique = false),
        @Index(name = "ParamServerMethodIdx_h", columnList = "srvmeth_id", unique = false),
        @Index(name = "ParamDefSchemaDefIdx_h", columnList = "defschid", unique = false),
        @Index(name = "ParamTypeIdx_h", columnList = "TpId", unique = false),
        @Index(name = "ParamPrevIdx_h", columnList = "PrevId", unique = false),
        @Index(name = "ParamNextIdx_h", columnList = "NextId", unique = false),
        @Index(name = "ParamContPrevIdx_h", columnList = "srvmeth_id, PrevId", unique = false),
        @Index(name = "ParamContNextIdx_h", columnList = "srvmeth_id, NextId", unique = false)
    }
)
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "BusModelPU")
public class BusModelJpaParamH
    implements IBusModelParamH, Comparable<Object>, Serializable
{
	@AttributeOverrides({
		@AttributeOverride(name="auditClusterId", column = @Column( name="auditClusterId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) ),
		@AttributeOverride(name="auditStamp", column = @Column( name="auditStamp", nullable=false ) ),
		@AttributeOverride(name="auditAction", column = @Column( name="auditAction", nullable=false ) ),
		@AttributeOverride(name="requiredRevision", column = @Column( name="requiredRevision", nullable=false ) ),
		@AttributeOverride(name="auditSessionId", column = @Column( name="auditSessionId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) ),
		@AttributeOverride(name="Id", column = @Column( name="Id", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
    @EmbeddedId
    protected BusModelJpaParamHPKey pkey;
	@AttributeOverrides({
		@AttributeOverride( name="bytes", column = @Column( name="CreatedByUserId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected YCFDbKeyHash256 createdByUserId = YCFDbKeyHash256.fromHex(IBusModelPubSecUser.S_INIT_CREATED_BY);

	@AttributeOverrides({
		@AttributeOverride( name="bytes", column = @Column( name="CreatedBySessionId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected YCFDbKeyHash256 createdBySessionId = YCFDbKeyHash256.fromHex(IBusModelPubSecSession.S_SECSESSIONID_INIT_VALUE);

	@Column(name="CreatedAt", nullable=false)
	protected LocalDateTime createdAt = LocalDateTime.now();

	@AttributeOverrides({
		@AttributeOverride( name="bytes", column= @Column( name="UpdatedByUserId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected YCFDbKeyHash256 updatedByUserId = YCFDbKeyHash256.fromHex(IBusModelPubSecUser.S_INIT_UPDATED_BY);

	@AttributeOverrides({
		@AttributeOverride( name="bytes", column= @Column( name="UpdatedBySessionId", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected YCFDbKeyHash256 updatedBySessionId = YCFDbKeyHash256.fromHex(IBusModelPubSecSession.S_SECSESSIONID_INIT_VALUE);

	@Column(name="UpdatedAt", nullable=false)
	protected LocalDateTime updatedAt = LocalDateTime.now();
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="srvmeth_id", nullable=false, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 requiredServerMethodId;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="defschid", nullable=true, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 optionalDefSchemaId;
	@Column( name="safe_name", nullable=false, length=192 )
	protected String requiredName;
	@Column( name="short_descr", nullable=true, length=128 )
	protected String optionalShortDescription;
	@Column( name="descr", nullable=true, length=1023 )
	protected String optionalDescription;
	@Column( name="IsNullable", nullable=false )
	protected boolean requiredIsNullable;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="TpId", nullable=true, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 optionalTypeId;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="PrevId", nullable=true, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 optionalPrevId;
	@AttributeOverrides({
		@AttributeOverride(name="bytes", column = @Column( name="NextId", nullable=true, length=YCFDbKeyHash256.HASH_LENGTH ) )
	})
	protected IYCFKeyHash256 optionalNextId;

    public BusModelJpaParamH() {
            // The primary key member attributes are initialized on construction
            pkey = new BusModelJpaParamHPKey();
		requiredServerMethodId = YCFDbKeyHash256.fromHex( IBusModelPubParam.SERVERMETHODID_INIT_VALUE.toString() );
		optionalDefSchemaId = YCFDbKeyHash256.nullGet();
		requiredName = IBusModelPubParam.NAME_INIT_VALUE;
		optionalShortDescription = null;
		optionalDescription = null;
		requiredIsNullable = IBusModelPubParam.ISNULLABLE_INIT_VALUE;
		optionalTypeId = YCFDbKeyHash256.nullGet();
		optionalPrevId = YCFDbKeyHash256.nullGet();
		optionalNextId = YCFDbKeyHash256.nullGet();
    }

    @Override
    public int getClassCode() {
            return( IBusModelParam.CLASS_CODE );
    }

    @Override
    public YCFDbKeyHash256 getCreatedByUserId() {
        return( createdByUserId );
    }

    @Override
    public void setCreatedByUserId( YCFDbKeyHash256 value ) {
        if (value == null || value.isNull()) {
            throw new YCFNullArgumentException(getClass(), "setCreatedByUserId", 1, "value");
        }
        createdByUserId = value;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return( createdAt );
    }

    @Override
    public void setCreatedAt( LocalDateTime value ) {
        if (value == null) {
            throw new YCFNullArgumentException(getClass(), "setCreatedAt", 1, "value");
        }
        createdAt = value;
    }

    @Override
    public YCFDbKeyHash256 getUpdatedByUserId() {
        return( updatedByUserId );
    }

    @Override
    public void setUpdatedByUserId( YCFDbKeyHash256 value ) {
        if (value == null || value.isNull()) {
            throw new YCFNullArgumentException(getClass(), "setUpdatedByUserId", 1, "value");
        }
        updatedByUserId = value;
    }

    @Override
    public LocalDateTime getUpdatedAt() {
        return( updatedAt );
    }

    @Override
    public void setUpdatedAt( LocalDateTime value ) {
        if (value == null) {
            throw new YCFNullArgumentException(getClass(), "setUpdatedAt", 1, "value");
        }
        updatedAt = value;
    }

    @Override
    public IBusModelParamHPKey getPKey() {
        return( pkey );
    }

    @Override
    public void setPKey( IBusModelParamHPKey pkey ) {
        if (pkey != null) {
            if (pkey instanceof BusModelJpaParamHPKey) {
                this.pkey = (BusModelJpaParamHPKey)pkey;
            }
            else {
                throw new YCFUnsupportedClassException(getClass(), "setPKey", "pkey", pkey, "BusModelJpaParamHPKey");
            }
        }
    }

    @Override
    public YCFDbKeyHash256 getAuditClusterId() {
        return pkey.getAuditClusterId();
    }

    @Override
    public void setAuditClusterId(YCFDbKeyHash256 auditClusterId) {
        pkey.setAuditClusterId(auditClusterId);
    }

    @Override
    public LocalDateTime getAuditStamp() {
        return pkey.getAuditStamp();
    }

    @Override
    public void setAuditStamp(LocalDateTime auditStamp) {
        pkey.setAuditStamp(auditStamp);
    }

    @Override
    public short getAuditActionId() {
        return pkey.getAuditActionId();
    }

    @Override
    public void setAuditActionId(short auditActionId) {
        pkey.setAuditActionId(auditActionId);
    }

    @Override
    public int getRequiredRevision() {
        return pkey.getRequiredRevision();
    }

    @Override
    public void setRequiredRevision(int revision) {
        pkey.setRequiredRevision(revision);
    }

    @Override
    public YCFDbKeyHash256 getAuditSessionId() {
        return pkey.getAuditSessionId();
    }

    @Override
    public void setAuditSessionId(YCFDbKeyHash256 auditSessionId) {
        pkey.setAuditSessionId(auditSessionId);
    }

    @Override
    public IYCFKeyHash256 getRequiredId() {
        return( pkey.getRequiredId() );
    }

    @Override
    public void setRequiredId( IYCFKeyHash256 requiredId ) {
        pkey.setRequiredId( requiredId );
    }

	@Override
	public IYCFKeyHash256 getRequiredServerMethodId() {
		return(requiredServerMethodId);
	}

	public void setRequiredServerMethodId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredServerMethodId",
				1,
				"value" );
		}
		requiredServerMethodId = value;
	}

	@Override
	public IYCFKeyHash256 getOptionalDefSchemaId() {
		return(optionalDefSchemaId);
	}

	public void setOptionalDefSchemaId( IYCFKeyHash256 value ) {
		optionalDefSchemaId = value;
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
	public String getOptionalShortDescription() {
		return(optionalShortDescription);
	}

	public void setOptionalShortDescription( String value ) {
		if( value != null && value.length() > 128 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalShortDescription",
				1,
				"value.length()",
				value.length(),
				128 );
		}
		optionalShortDescription = value;
	}

	@Override
	public String getOptionalDescription() {
		return(optionalDescription);
	}

	public void setOptionalDescription( String value ) {
		if( value != null && value.length() > 1023 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setOptionalDescription",
				1,
				"value.length()",
				value.length(),
				1023 );
		}
		optionalDescription = value;
	}

	@Override
	public boolean getRequiredIsNullable() {
		return(requiredIsNullable);
	}

	public void setRequiredIsNullable( boolean value ) {
		requiredIsNullable = value;
	}

	@Override
	public IYCFKeyHash256 getOptionalTypeId() {
		return(optionalTypeId);
	}

	public void setOptionalTypeId( IYCFKeyHash256 value ) {
		optionalTypeId = value;
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
        else if (obj instanceof IBusModelParam) {
            IBusModelParam rhs = (IBusModelParam)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() != null) {
				if (!getPKey().equals(rhs.getPKey())) {
					return( false );
				}
			}
			else {
				return( false );
			}
		}
		else if (rhs.getPKey() != null) {
			return( false );
		}

			if( getRequiredServerMethodId() != null ) {
				if( rhs.getRequiredServerMethodId() != null ) {
					if( ! getRequiredServerMethodId().equals( rhs.getRequiredServerMethodId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredServerMethodId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
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
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getRequiredIsNullable() != rhs.getRequiredIsNullable() ) {
				return( false );
			}
			if( getOptionalTypeId() != null ) {
				if( rhs.getOptionalTypeId() != null ) {
					if( ! getOptionalTypeId().equals( rhs.getOptionalTypeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalTypeId() != null ) {
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
        else if (obj instanceof IBusModelParamH) {
            IBusModelParamH rhs = (IBusModelParamH)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() != null) {
				if (!getPKey().equals(rhs.getPKey())) {
					return( false );
				}
			}
			else {
				return( false );
			}
		}
		else if (rhs.getPKey() != null) {
			return( false );
		}

			if( getRequiredServerMethodId() != null ) {
				if( rhs.getRequiredServerMethodId() != null ) {
					if( ! getRequiredServerMethodId().equals( rhs.getRequiredServerMethodId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredServerMethodId() != null ) {
					return( false );
				}
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
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
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					if( ! getOptionalShortDescription().equals( rhs.getOptionalShortDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( false );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					if( ! getOptionalDescription().equals( rhs.getOptionalDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( false );
				}
			}
			if( getRequiredIsNullable() != rhs.getRequiredIsNullable() ) {
				return( false );
			}
			if( getOptionalTypeId() != null ) {
				if( rhs.getOptionalTypeId() != null ) {
					if( ! getOptionalTypeId().equals( rhs.getOptionalTypeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalTypeId() != null ) {
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
        else if (obj instanceof IBusModelParamHPKey) {
		IBusModelParamHPKey rhs = (IBusModelParamHPKey)obj;
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
		return( true );
        }
        else if (obj instanceof IBusModelParamByUNameIdxKey) {
            IBusModelParamByUNameIdxKey rhs = (IBusModelParamByUNameIdxKey)obj;
			if( getRequiredServerMethodId() != null ) {
				if( rhs.getRequiredServerMethodId() != null ) {
					if( ! getRequiredServerMethodId().equals( rhs.getRequiredServerMethodId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredServerMethodId() != null ) {
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
        else if (obj instanceof IBusModelParamByServerMethodIdxKey) {
            IBusModelParamByServerMethodIdxKey rhs = (IBusModelParamByServerMethodIdxKey)obj;
			if( getRequiredServerMethodId() != null ) {
				if( rhs.getRequiredServerMethodId() != null ) {
					if( ! getRequiredServerMethodId().equals( rhs.getRequiredServerMethodId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredServerMethodId() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof IBusModelParamByDefSchemaIdxKey) {
            IBusModelParamByDefSchemaIdxKey rhs = (IBusModelParamByDefSchemaIdxKey)obj;
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					if( ! getOptionalDefSchemaId().equals( rhs.getOptionalDefSchemaId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof IBusModelParamByServerTypeIdxKey) {
            IBusModelParamByServerTypeIdxKey rhs = (IBusModelParamByServerTypeIdxKey)obj;
			if( getOptionalTypeId() != null ) {
				if( rhs.getOptionalTypeId() != null ) {
					if( ! getOptionalTypeId().equals( rhs.getOptionalTypeId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalTypeId() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof IBusModelParamByPrevIdxKey) {
            IBusModelParamByPrevIdxKey rhs = (IBusModelParamByPrevIdxKey)obj;
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
        else if (obj instanceof IBusModelParamByNextIdxKey) {
            IBusModelParamByNextIdxKey rhs = (IBusModelParamByNextIdxKey)obj;
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
        else if (obj instanceof IBusModelParamByContPrevIdxKey) {
            IBusModelParamByContPrevIdxKey rhs = (IBusModelParamByContPrevIdxKey)obj;
			if( getRequiredServerMethodId() != null ) {
				if( rhs.getRequiredServerMethodId() != null ) {
					if( ! getRequiredServerMethodId().equals( rhs.getRequiredServerMethodId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredServerMethodId() != null ) {
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
            return( true );
        }
        else if (obj instanceof IBusModelParamByContNextIdxKey) {
            IBusModelParamByContNextIdxKey rhs = (IBusModelParamByContNextIdxKey)obj;
			if( getRequiredServerMethodId() != null ) {
				if( rhs.getRequiredServerMethodId() != null ) {
					if( ! getRequiredServerMethodId().equals( rhs.getRequiredServerMethodId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredServerMethodId() != null ) {
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
        else {
			return( false );
        }
    }
    
    @Override
    public int hashCode() {
        int hashCode = pkey.hashCode();
		hashCode = hashCode + getRequiredServerMethodId().hashCode();
		if( getOptionalDefSchemaId() != null ) {
			hashCode = hashCode + getOptionalDefSchemaId().hashCode();
		}
		if( getRequiredName() != null ) {
			hashCode = hashCode + getRequiredName().hashCode();
		}
		if( getOptionalShortDescription() != null ) {
			hashCode = hashCode + getOptionalShortDescription().hashCode();
		}
		if( getOptionalDescription() != null ) {
			hashCode = hashCode + getOptionalDescription().hashCode();
		}
		if( getRequiredIsNullable() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		if( getOptionalTypeId() != null ) {
			hashCode = hashCode + getOptionalTypeId().hashCode();
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
        else if (obj instanceof IBusModelParam) {
		IBusModelParam rhs = (IBusModelParam)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() == null) {
				return( 1 );
			}
			else {
				cmp = getPKey().compareTo(rhs.getPKey());
				if (cmp != 0) {
					return( cmp );
				}
			}
		}
		else {
			if (rhs.getPKey() != null) {
				return( -1 );
			}
		}
			if (getRequiredServerMethodId() != null) {
				if (rhs.getRequiredServerMethodId() != null) {
					cmp = getRequiredServerMethodId().compareTo( rhs.getRequiredServerMethodId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredServerMethodId() != null) {
				return( -1 );
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
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
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if( getRequiredIsNullable() ) {
				if( ! rhs.getRequiredIsNullable() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsNullable() ) {
					return( -1 );
				}
			}
			if( getOptionalTypeId() != null ) {
				if( rhs.getOptionalTypeId() != null ) {
					cmp = getOptionalTypeId().compareTo( rhs.getOptionalTypeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalTypeId() != null ) {
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
        else if (obj instanceof IBusModelParamHPKey) {
        if (getPKey() != null) {
            return( getPKey().compareTo( obj ));
        }
        else {
            return( -1 );
        }
        }
        else if (obj instanceof IBusModelParamH) {
		IBusModelParamH rhs = (IBusModelParamH)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() == null) {
				return( 1 );
			}
			else {
				cmp = getPKey().compareTo(rhs.getPKey());
				if (cmp != 0) {
					return( cmp );
				}
			}
		}
		else {
			if (rhs.getPKey() != null) {
				return( -1 );
			}
		}
			if (getRequiredServerMethodId() != null) {
				if (rhs.getRequiredServerMethodId() != null) {
					cmp = getRequiredServerMethodId().compareTo( rhs.getRequiredServerMethodId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredServerMethodId() != null) {
				return( -1 );
			}
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
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
			if( getOptionalShortDescription() != null ) {
				if( rhs.getOptionalShortDescription() != null ) {
					cmp = getOptionalShortDescription().compareTo( rhs.getOptionalShortDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalShortDescription() != null ) {
					return( -1 );
				}
			}
			if( getOptionalDescription() != null ) {
				if( rhs.getOptionalDescription() != null ) {
					cmp = getOptionalDescription().compareTo( rhs.getOptionalDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDescription() != null ) {
					return( -1 );
				}
			}
			if( getRequiredIsNullable() ) {
				if( ! rhs.getRequiredIsNullable() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredIsNullable() ) {
					return( -1 );
				}
			}
			if( getOptionalTypeId() != null ) {
				if( rhs.getOptionalTypeId() != null ) {
					cmp = getOptionalTypeId().compareTo( rhs.getOptionalTypeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalTypeId() != null ) {
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
        else if (obj instanceof IBusModelParamByUNameIdxKey ) {
            IBusModelParamByUNameIdxKey rhs = (IBusModelParamByUNameIdxKey)obj;
			if (getRequiredServerMethodId() != null) {
				if (rhs.getRequiredServerMethodId() != null) {
					cmp = getRequiredServerMethodId().compareTo( rhs.getRequiredServerMethodId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredServerMethodId() != null) {
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
        else if (obj instanceof IBusModelParamByServerMethodIdxKey ) {
            IBusModelParamByServerMethodIdxKey rhs = (IBusModelParamByServerMethodIdxKey)obj;
			if (getRequiredServerMethodId() != null) {
				if (rhs.getRequiredServerMethodId() != null) {
					cmp = getRequiredServerMethodId().compareTo( rhs.getRequiredServerMethodId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredServerMethodId() != null) {
				return( -1 );
			}
            return( 0 );
        }
        else if (obj instanceof IBusModelParamByDefSchemaIdxKey ) {
            IBusModelParamByDefSchemaIdxKey rhs = (IBusModelParamByDefSchemaIdxKey)obj;
			if( getOptionalDefSchemaId() != null ) {
				if( rhs.getOptionalDefSchemaId() != null ) {
					cmp = getOptionalDefSchemaId().compareTo( rhs.getOptionalDefSchemaId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalDefSchemaId() != null ) {
					return( -1 );
				}
			}
            return( 0 );
        }
        else if (obj instanceof IBusModelParamByServerTypeIdxKey ) {
            IBusModelParamByServerTypeIdxKey rhs = (IBusModelParamByServerTypeIdxKey)obj;
			if( getOptionalTypeId() != null ) {
				if( rhs.getOptionalTypeId() != null ) {
					cmp = getOptionalTypeId().compareTo( rhs.getOptionalTypeId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalTypeId() != null ) {
					return( -1 );
				}
			}
            return( 0 );
        }
        else if (obj instanceof IBusModelParamByPrevIdxKey ) {
            IBusModelParamByPrevIdxKey rhs = (IBusModelParamByPrevIdxKey)obj;
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
        else if (obj instanceof IBusModelParamByNextIdxKey ) {
            IBusModelParamByNextIdxKey rhs = (IBusModelParamByNextIdxKey)obj;
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
        else if (obj instanceof IBusModelParamByContPrevIdxKey ) {
            IBusModelParamByContPrevIdxKey rhs = (IBusModelParamByContPrevIdxKey)obj;
			if (getRequiredServerMethodId() != null) {
				if (rhs.getRequiredServerMethodId() != null) {
					cmp = getRequiredServerMethodId().compareTo( rhs.getRequiredServerMethodId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredServerMethodId() != null) {
				return( -1 );
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
            return( 0 );
        }
        else if (obj instanceof IBusModelParamByContNextIdxKey ) {
            IBusModelParamByContNextIdxKey rhs = (IBusModelParamByContNextIdxKey)obj;
			if (getRequiredServerMethodId() != null) {
				if (rhs.getRequiredServerMethodId() != null) {
					cmp = getRequiredServerMethodId().compareTo( rhs.getRequiredServerMethodId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredServerMethodId() != null) {
				return( -1 );
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
        else {
            throw new YCFUnsupportedClassException( getClass(),
                "compareTo",
                "obj",
                obj,
                null );
        }
    }
	@Override
    public void set( IBusModelParam src ) {
		setParam( src );
    }

	@Override
    public void setParam( IBusModelParam src ) {
		setRequiredId( src.getRequiredId() );
		setRequiredServerMethodId( src.getRequiredServerMethodId() );
		setOptionalDefSchemaId( src.getOptionalDefSchemaId() );
		setRequiredName( src.getRequiredName() );
		setOptionalShortDescription( src.getOptionalShortDescription() );
		setOptionalDescription( src.getOptionalDescription() );
		setRequiredIsNullable( src.getRequiredIsNullable() );
		setOptionalTypeId( src.getOptionalTypeId() );
		setOptionalPrevId( src.getOptionalPrevId() );
		setOptionalNextId( src.getOptionalNextId() );
		setRequiredRevision( src.getRequiredRevision() );
    }

	@Override
    public void set( IBusModelParamH src ) {
		setParam( src );
    }

	@Override
    public void setParam( IBusModelParamH src ) {
		setRequiredId( src.getRequiredId() );
		setRequiredServerMethodId( src.getRequiredServerMethodId() );
		setOptionalDefSchemaId( src.getOptionalDefSchemaId() );
		setRequiredName( src.getRequiredName() );
		setOptionalShortDescription( src.getOptionalShortDescription() );
		setOptionalDescription( src.getOptionalDescription() );
		setRequiredIsNullable( src.getRequiredIsNullable() );
		setOptionalTypeId( src.getOptionalTypeId() );
		setOptionalPrevId( src.getOptionalPrevId() );
		setOptionalNextId( src.getOptionalNextId() );
		setRequiredRevision( src.getRequiredRevision() );
    }

    public String getXmlAttrFragment() {
        String ret = pkey.getXmlAttrFragment()
			+ " classCode=\"" + getClassCode() + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredServerMethodId=" + "\"" + getRequiredServerMethodId().toString() + "\""
			+ " OptionalDefSchemaId=" + ( ( getOptionalDefSchemaId() == null ) ? "null" : "\"" + getOptionalDefSchemaId().toString() + "\"" )
			+ " RequiredName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredName() ) + "\""
			+ " OptionalShortDescription=" + ( ( getOptionalShortDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalShortDescription() ) + "\"" )
			+ " OptionalDescription=" + ( ( getOptionalDescription() == null ) ? "null" : "\"" + StringEscapeUtils.escapeXml11( getOptionalDescription() ) + "\"" )
			+ " RequiredIsNullable=" + (( getRequiredIsNullable() ) ? "\"true\"" : "\"false\"" )
			+ " OptionalTypeId=" + ( ( getOptionalTypeId() == null ) ? "null" : "\"" + getOptionalTypeId().toString() + "\"" )
			+ " OptionalPrevId=" + ( ( getOptionalPrevId() == null ) ? "null" : "\"" + getOptionalPrevId().toString() + "\"" )
			+ " OptionalNextId=" + ( ( getOptionalNextId() == null ) ? "null" : "\"" + getOptionalNextId().toString() + "\"" );
        return( ret );
    }

    public String toString() {
        String ret = "<BusModelJpaParamH" + getXmlAttrFragment() + "/>";
        return( ret );
    }
}
