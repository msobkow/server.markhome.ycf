// Description: Java 25 JPA implementation of a MajorVersion by SubProjectIdx index key object.

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.intnet.intnet.jpa;

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
import server.markhome.ycf.v3_1.secure.secure.jpa.*;

public class IntNetJpaMajorVersionBySubProjectIdxKey
	implements IIntNetMajorVersionBySubProjectIdxKey, Comparable<Object>, Serializable
{
	protected IYCFKeyHash256 requiredSubProjectId;
	public IntNetJpaMajorVersionBySubProjectIdxKey() {
		requiredSubProjectId = YCFDbKeyHash256.fromHex( IIntNetPubMajorVersion.SUBPROJECTID_INIT_VALUE.toString() );
	}

	@Override
	public IYCFKeyHash256 getRequiredSubProjectId() {
		return(requiredSubProjectId);
	}

	public void setRequiredSubProjectId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredSubProjectId",
				1,
				"value" );
		}
		requiredSubProjectId = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if (obj == null) {
			return( false );
		}
		else if (obj instanceof IIntNetMajorVersionBySubProjectIdxKey) {
			IIntNetMajorVersionBySubProjectIdxKey rhs = (IIntNetMajorVersionBySubProjectIdxKey)obj;
			if( getRequiredSubProjectId() != null ) {
				if( rhs.getRequiredSubProjectId() != null ) {
					if( ! getRequiredSubProjectId().equals( rhs.getRequiredSubProjectId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSubProjectId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IIntNetMajorVersion) {
			IIntNetMajorVersion rhs = (IIntNetMajorVersion)obj;
			if( getRequiredSubProjectId() != null ) {
				if( rhs.getRequiredSubProjectId() != null ) {
					if( ! getRequiredSubProjectId().equals( rhs.getRequiredSubProjectId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSubProjectId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof IIntNetMajorVersionH) {
			IIntNetMajorVersionH rhs = (IIntNetMajorVersionH)obj;
			if( getRequiredSubProjectId() != null ) {
				if( rhs.getRequiredSubProjectId() != null ) {
					if( ! getRequiredSubProjectId().equals( rhs.getRequiredSubProjectId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSubProjectId() != null ) {
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
		hashCode = hashCode + getRequiredSubProjectId().hashCode();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if (obj == null) {
			return( 1 );
		}
		else if (obj instanceof IIntNetMajorVersionBySubProjectIdxKey) {
			IIntNetMajorVersionBySubProjectIdxKey rhs = (IIntNetMajorVersionBySubProjectIdxKey)obj;
			if (getRequiredSubProjectId() != null) {
				if (rhs.getRequiredSubProjectId() != null) {
					cmp = getRequiredSubProjectId().compareTo( rhs.getRequiredSubProjectId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSubProjectId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof IIntNetMajorVersion) {
			IIntNetMajorVersion rhs = (IIntNetMajorVersion)obj;
			if (getRequiredSubProjectId() != null) {
				if (rhs.getRequiredSubProjectId() != null) {
					cmp = getRequiredSubProjectId().compareTo( rhs.getRequiredSubProjectId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSubProjectId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof IIntNetMajorVersionH) {
			IIntNetMajorVersionH rhs = (IIntNetMajorVersionH)obj;
			if (getRequiredSubProjectId() != null) {
				if (rhs.getRequiredSubProjectId() != null) {
					cmp = getRequiredSubProjectId().compareTo( rhs.getRequiredSubProjectId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSubProjectId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else {
			throw new YCFUnsupportedClassException(getClass(),
				"compareTo",
				"obj",
				obj,
				"IIntNetMajorVersionBySubProjectIdxKey, IIntNetMajorVersion, IIntNetMajorVersionH");
		}
	}

	public String getXmlAttrFragment() {
		String ret = "" 
			+ " RequiredSubProjectId=" + "\"" + getRequiredSubProjectId().toString() + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<IntNetMajorVersionBySubProjectIdxKey" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
