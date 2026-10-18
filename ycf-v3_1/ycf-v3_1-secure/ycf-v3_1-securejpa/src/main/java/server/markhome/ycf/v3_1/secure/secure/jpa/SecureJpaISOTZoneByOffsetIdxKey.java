// Description: Java 25 JPA implementation of a ISOTZone by OffsetIdx index key object.

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
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

package server.markhome.ycf.v3_1.secure.secure.jpa;

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

public class SecureJpaISOTZoneByOffsetIdxKey
	implements ISecureISOTZoneByOffsetIdxKey, Comparable<Object>, Serializable
{
	protected short requiredTZHourOffset;
	protected short requiredTZMinOffset;
	public SecureJpaISOTZoneByOffsetIdxKey() {
		requiredTZHourOffset = ISecurePubISOTZone.TZHOUROFFSET_INIT_VALUE;
		requiredTZMinOffset = ISecurePubISOTZone.TZMINOFFSET_INIT_VALUE;
	}

	@Override
	public short getRequiredTZHourOffset() {
		return(requiredTZHourOffset);
	}

	@Override
	public void setRequiredTZHourOffset( short value ) {
		if( value < ISecurePubISOTZone.TZHOUROFFSET_MIN_VALUE ) {
			throw new YCFArgumentUnderflowException( getClass(),
				"setRequiredTZHourOffset",
				1,
				"value",
				value,
				ISecurePubISOTZone.TZHOUROFFSET_MIN_VALUE );
		}
		if( value > ISecurePubISOTZone.TZHOUROFFSET_MAX_VALUE ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredTZHourOffset",
				1,
				"value",
				value,
				ISecurePubISOTZone.TZHOUROFFSET_MAX_VALUE );
		}
		requiredTZHourOffset = value;
	}

	@Override
	public short getRequiredTZMinOffset() {
		return(requiredTZMinOffset);
	}

	@Override
	public void setRequiredTZMinOffset( short value ) {
		if( value < ISecurePubISOTZone.TZMINOFFSET_MIN_VALUE ) {
			throw new YCFArgumentUnderflowException( getClass(),
				"setRequiredTZMinOffset",
				1,
				"value",
				value,
				ISecurePubISOTZone.TZMINOFFSET_MIN_VALUE );
		}
		if( value > ISecurePubISOTZone.TZMINOFFSET_MAX_VALUE ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredTZMinOffset",
				1,
				"value",
				value,
				ISecurePubISOTZone.TZMINOFFSET_MAX_VALUE );
		}
		requiredTZMinOffset = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if (obj == null) {
			return( false );
		}
		else if (obj instanceof ISecureISOTZoneByOffsetIdxKey) {
			ISecureISOTZoneByOffsetIdxKey rhs = (ISecureISOTZoneByOffsetIdxKey)obj;
			if( getRequiredTZHourOffset() != rhs.getRequiredTZHourOffset() ) {
				return( false );
			}
			if( getRequiredTZMinOffset() != rhs.getRequiredTZMinOffset() ) {
				return( false );
			}
			return( true );
		}
		else if (obj instanceof ISecureISOTZone) {
			ISecureISOTZone rhs = (ISecureISOTZone)obj;
			if( getRequiredTZHourOffset() != rhs.getRequiredTZHourOffset() ) {
				return( false );
			}
			if( getRequiredTZMinOffset() != rhs.getRequiredTZMinOffset() ) {
				return( false );
			}
			return( true );
		}
		else if (obj instanceof ISecureISOTZoneH) {
			ISecureISOTZoneH rhs = (ISecureISOTZoneH)obj;
			if( getRequiredTZHourOffset() != rhs.getRequiredTZHourOffset() ) {
				return( false );
			}
			if( getRequiredTZMinOffset() != rhs.getRequiredTZMinOffset() ) {
				return( false );
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
		hashCode = ( hashCode * 0x10000 ) + getRequiredTZHourOffset();
		hashCode = ( hashCode * 0x10000 ) + getRequiredTZMinOffset();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if (obj == null) {
			return( 1 );
		}
		else if (obj instanceof ISecureISOTZoneByOffsetIdxKey) {
			ISecureISOTZoneByOffsetIdxKey rhs = (ISecureISOTZoneByOffsetIdxKey)obj;
			if( getRequiredTZHourOffset() < rhs.getRequiredTZHourOffset() ) {
				return( -1 );
			}
			else if( getRequiredTZHourOffset() > rhs.getRequiredTZHourOffset() ) {
				return( 1 );
			}
			if( getRequiredTZMinOffset() < rhs.getRequiredTZMinOffset() ) {
				return( -1 );
			}
			else if( getRequiredTZMinOffset() > rhs.getRequiredTZMinOffset() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if (obj instanceof ISecureISOTZone) {
			ISecureISOTZone rhs = (ISecureISOTZone)obj;
			if( getRequiredTZHourOffset() < rhs.getRequiredTZHourOffset() ) {
				return( -1 );
			}
			else if( getRequiredTZHourOffset() > rhs.getRequiredTZHourOffset() ) {
				return( 1 );
			}
			if( getRequiredTZMinOffset() < rhs.getRequiredTZMinOffset() ) {
				return( -1 );
			}
			else if( getRequiredTZMinOffset() > rhs.getRequiredTZMinOffset() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if (obj instanceof ISecureISOTZoneH) {
			ISecureISOTZoneH rhs = (ISecureISOTZoneH)obj;
			if( getRequiredTZHourOffset() < rhs.getRequiredTZHourOffset() ) {
				return( -1 );
			}
			else if( getRequiredTZHourOffset() > rhs.getRequiredTZHourOffset() ) {
				return( 1 );
			}
			if( getRequiredTZMinOffset() < rhs.getRequiredTZMinOffset() ) {
				return( -1 );
			}
			else if( getRequiredTZMinOffset() > rhs.getRequiredTZMinOffset() ) {
				return( 1 );
			}
			return( 0 );
		}
		else {
			throw new YCFUnsupportedClassException(getClass(),
				"compareTo",
				"obj",
				obj,
				"ISecureISOTZoneByOffsetIdxKey, ISecureISOTZone, ISecureISOTZoneH");
		}
	}

	public String getXmlAttrFragment() {
		String ret = "" 
			+ " RequiredTZHourOffset=" + "\"" + Short.toString( getRequiredTZHourOffset() ) + "\""
			+ " RequiredTZMinOffset=" + "\"" + Short.toString( getRequiredTZMinOffset() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<SecureISOTZoneByOffsetIdxKey" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
