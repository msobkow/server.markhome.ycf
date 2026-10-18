// Description: Java 25 JPA implementation of a DelSubDep3 by DelSubDep2Idx index key object.

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

public class BusModelJpaDelSubDep3ByDelSubDep2IdxKey
	implements IBusModelDelSubDep3ByDelSubDep2IdxKey, Comparable<Object>, Serializable
{
	protected IYCFKeyHash256 requiredDelSubDep2Id;
	public BusModelJpaDelSubDep3ByDelSubDep2IdxKey() {
		requiredDelSubDep2Id = YCFDbKeyHash256.fromHex( IBusModelPubDelSubDep3.DELSUBDEP2ID_INIT_VALUE.toString() );
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
	public boolean equals( Object obj ) {
		if (obj == null) {
			return( false );
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
		else if (obj instanceof IBusModelDelSubDep3) {
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
			return( true );
		}
		else if (obj instanceof IBusModelDelSubDep3H) {
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
			return( true );
		}
		else {
			return( false );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		hashCode = hashCode + getRequiredDelSubDep2Id().hashCode();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if (obj == null) {
			return( 1 );
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
		else if (obj instanceof IBusModelDelSubDep3) {
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
			return( 0 );
		}
		else if (obj instanceof IBusModelDelSubDep3H) {
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
			return( 0 );
		}
		else {
			throw new YCFUnsupportedClassException(getClass(),
				"compareTo",
				"obj",
				obj,
				"IBusModelDelSubDep3ByDelSubDep2IdxKey, IBusModelDelSubDep3, IBusModelDelSubDep3H");
		}
	}

	public String getXmlAttrFragment() {
		String ret = "" 
			+ " RequiredDelSubDep2Id=" + "\"" + getRequiredDelSubDep2Id().toString() + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<BusModelDelSubDep3ByDelSubDep2IdxKey" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
