// Description: Java 25 implementation of a ISOLang by Code3Idx index key buffer

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

package server.markhome.ycf.v3_1.secure.secure.buff;

import java.lang.reflect.*;
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;

public class SecureBuffISOLangByCode3IdxKey
	implements ISecureISOLangByCode3IdxKey, Comparable<Object>, Serializable
{
	protected String requiredISO6392Code;
	public SecureBuffISOLangByCode3IdxKey() {
		requiredISO6392Code = ISecurePubISOLang.ISO6392CODE_INIT_VALUE;
	}

	@Override
	public String getRequiredISO6392Code() {
		return(requiredISO6392Code);
	}

	public void setRequiredISO6392Code( String value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredISO6392Code",
				1,
				"value" );
		}
		else if( value.length() > 3 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredISO6392Code",
				1,
				"value.length()",
				value.length(),
				3 );
		}
		requiredISO6392Code = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ISecureISOLangByCode3IdxKey ) {
			ISecureISOLangByCode3IdxKey rhs = (ISecureISOLangByCode3IdxKey)obj;
			if( getRequiredISO6392Code() != null ) {
				if( rhs.getRequiredISO6392Code() != null ) {
					if( ! getRequiredISO6392Code().equals( rhs.getRequiredISO6392Code() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredISO6392Code() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ISecureISOLang) {
			ISecureISOLang rhs = (ISecureISOLang)obj;
			if( getRequiredISO6392Code() != null ) {
				if( rhs.getRequiredISO6392Code() != null ) {
					if( ! getRequiredISO6392Code().equals( rhs.getRequiredISO6392Code() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredISO6392Code() != null ) {
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
		if( getRequiredISO6392Code() != null ) {
			hashCode = hashCode + getRequiredISO6392Code().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof ISecureISOLangByCode3IdxKey ) {
			ISecureISOLangByCode3IdxKey rhs = (ISecureISOLangByCode3IdxKey)obj;
			if (getRequiredISO6392Code() != null) {
				if (rhs.getRequiredISO6392Code() != null) {
					cmp = getRequiredISO6392Code().compareTo( rhs.getRequiredISO6392Code() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredISO6392Code() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ISecureISOLang ) {
			ISecureISOLang rhs = (ISecureISOLang)obj;
			if (getRequiredISO6392Code() != null) {
				if (rhs.getRequiredISO6392Code() != null) {
					cmp = getRequiredISO6392Code().compareTo( rhs.getRequiredISO6392Code() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredISO6392Code() != null) {
				return( -1 );
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
	public String getXmlAttrFragment() {
		String ret = ""
			+ " RequiredISO6392Code=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredISO6392Code() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<SecureBuffISOLangByCode3IdxKey" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
