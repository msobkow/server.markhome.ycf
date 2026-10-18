// Description: Java 25 JPA implementation of Id32Gen history objects

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
 *  BusModelJpaId32GenH provides history objects matching the BusModelId32Gen change history.
 *	Note that because all indexes are historical with multiple instances of history records, the only key that can be unique is the primary key of a history table.
 */
@Entity
@Table(
    name = "idg32_h", schema = "BusModel31",
    indexes = {
        @Index(name = "Id32GenIdIdx_h", columnList = "auditClusterId, auditStamp, auditAction, requiredRevision, auditSessionId, Id", unique = true)
    }
)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("43127")
@Transactional(Transactional.TxType.REQUIRED)
@PersistenceContext(unitName = "BusModelPU")
public class BusModelJpaId32GenH extends BusModelJpaInt32TypeH
    implements IBusModelId32GenH
{
	@Column( name="Slice", nullable=false )
	protected short requiredSlice;
	@Column( name="BlockSize", nullable=false )
	protected int requiredBlockSize;

    public BusModelJpaId32GenH() {
            super();
		requiredSlice = IBusModelPubId32Gen.SLICE_INIT_VALUE;
		requiredBlockSize = IBusModelPubId32Gen.BLOCKSIZE_INIT_VALUE;
    }

    @Override
    public int getClassCode() {
            return( IBusModelId32Gen.CLASS_CODE );
    }

	@Override
	public short getRequiredSlice() {
		return(requiredSlice);
	}

	@Override
	public void setRequiredSlice( short value ) {
		if( value < IBusModelPubId32Gen.SLICE_MIN_VALUE ) {
			throw new YCFArgumentUnderflowException( getClass(),
				"setRequiredSlice",
				1,
				"value",
				value,
				IBusModelPubId32Gen.SLICE_MIN_VALUE );
		}
		if( value > IBusModelPubId32Gen.SLICE_MAX_VALUE ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredSlice",
				1,
				"value",
				value,
				IBusModelPubId32Gen.SLICE_MAX_VALUE );
		}
		requiredSlice = value;
	}

	@Override
	public int getRequiredBlockSize() {
		return(requiredBlockSize);
	}

	@Override
	public void setRequiredBlockSize( int value ) {
		if( value < IBusModelPubId32Gen.BLOCKSIZE_MIN_VALUE ) {
			throw new YCFArgumentUnderflowException( getClass(),
				"setRequiredBlockSize",
				1,
				"value",
				value,
				IBusModelPubId32Gen.BLOCKSIZE_MIN_VALUE );
		}
		if( value > IBusModelPubId32Gen.BLOCKSIZE_MAX_VALUE ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredBlockSize",
				1,
				"value",
				value,
				IBusModelPubId32Gen.BLOCKSIZE_MAX_VALUE );
		}
		requiredBlockSize = value;
	}

    @Override
    public boolean equals( Object obj ) {
        if (obj == null) {
            return( false );
        }
        else if (obj instanceof IBusModelId32Gen) {
            IBusModelId32Gen rhs = (IBusModelId32Gen)obj;
        if (!super.equals(obj)) {
            return( false );
        }
			if( getRequiredSlice() != rhs.getRequiredSlice() ) {
				return( false );
			}
			if( getRequiredBlockSize() != rhs.getRequiredBlockSize() ) {
				return( false );
			}
            return( true );
        }
        else if (obj instanceof IBusModelId32GenH) {
			if (!super.equals(obj)) {
				return( false );
			}
            IBusModelId32GenH rhs = (IBusModelId32GenH)obj;
        if (!super.equals(obj)) {
            return( false );
        }
			if( getRequiredSlice() != rhs.getRequiredSlice() ) {
				return( false );
			}
			if( getRequiredBlockSize() != rhs.getRequiredBlockSize() ) {
				return( false );
			}
            return( true );
        }
        else if (obj instanceof IBusModelValueHPKey) {
			return( super.equals(obj) );
        }
        else {
			return( super.equals(obj) );
        }
    }
    
    @Override
    public int hashCode() {
        int hashCode = super.hashCode();
		hashCode = ( hashCode * 0x10000 ) + getRequiredSlice();
		hashCode = hashCode + getRequiredBlockSize();
        return( hashCode & 0x7fffffff );
    }

    @Override
    public int compareTo( Object obj ) {
        int cmp;
        if (obj == null) {
            return( 1 );
        }
        else if (obj instanceof IBusModelId32Gen) {
        cmp = super.compareTo(obj);
        if (cmp != 0) {
            return( cmp );
        }
        IBusModelId32Gen rhs = (IBusModelId32Gen)obj;
			if( getRequiredSlice() < rhs.getRequiredSlice() ) {
				return( -1 );
			}
			else if( getRequiredSlice() > rhs.getRequiredSlice() ) {
				return( 1 );
			}
			if( getRequiredBlockSize() < rhs.getRequiredBlockSize() ) {
				return( -1 );
			}
			else if( getRequiredBlockSize() > rhs.getRequiredBlockSize() ) {
				return( 1 );
			}
            return( 0 );
        }
        else if (obj instanceof IBusModelValueHPKey) {
        return( super.compareTo(obj) );
        }
        else if (obj instanceof IBusModelId32GenH) {
        cmp = super.compareTo(obj);
        if (cmp != 0) {
            return( cmp );
        }
        IBusModelId32GenH rhs = (IBusModelId32GenH)obj;
			if( getRequiredSlice() < rhs.getRequiredSlice() ) {
				return( -1 );
			}
			else if( getRequiredSlice() > rhs.getRequiredSlice() ) {
				return( 1 );
			}
			if( getRequiredBlockSize() < rhs.getRequiredBlockSize() ) {
				return( -1 );
			}
			else if( getRequiredBlockSize() > rhs.getRequiredBlockSize() ) {
				return( 1 );
			}
            return( 0 );
        }
        else {
        return( super.compareTo(obj) );
        }
    }
	@Override
    public void set( IBusModelValue src ) {
		if( src instanceof IBusModelId32Gen ) {
			setId32Gen( (IBusModelId32Gen)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"src",
				src,
				"BusModelJpaId32Gen" );
		}
    }

	@Override
    public void setId32Gen( IBusModelId32Gen src ) {
        super.setInt32Type( src );
		setRequiredSlice( src.getRequiredSlice() );
		setRequiredBlockSize( src.getRequiredBlockSize() );
    }

	@Override
    public void set( IBusModelValueH src ) {
		if( src instanceof IBusModelId32GenH ) {
			setId32Gen( (IBusModelId32GenH)src );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
					"set",
					"src",
					src,
					"IBusModelId32GenH" );
		}
    }

	@Override
    public void setId32Gen( IBusModelId32GenH src ) {
        super.setInt32Type( src );
		setRequiredSlice( src.getRequiredSlice() );
		setRequiredBlockSize( src.getRequiredBlockSize() );
    }

    public String getXmlAttrFragment() {
        String ret = super.getXmlAttrFragment() 
			+ " RequiredSlice=" + "\"" + Short.toString( getRequiredSlice() ) + "\""
			+ " RequiredBlockSize=" + "\"" + Integer.toString( getRequiredBlockSize() ) + "\"";
        return( ret );
    }

    public String toString() {
        String ret = "<BusModelJpaId32GenH" + getXmlAttrFragment() + "/>";
        return( ret );
    }
}
