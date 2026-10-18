// Description: Java 25 implementation of a SecUserPWReset by UUuid6Idx index key buffer

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

public class SecureBuffSecUserPWResetByUUuid6IdxKey
	implements ISecureSecUserPWResetByUUuid6IdxKey, Comparable<Object>, Serializable
{
	protected IYCFUuid6 requiredPasswordResetUuid6;
	public SecureBuffSecUserPWResetByUUuid6IdxKey() {
	}

	@Override
	public IYCFUuid6 getRequiredPasswordResetUuid6() {
		return(requiredPasswordResetUuid6);
	}

	public void setRequiredPasswordResetUuid6( IYCFUuid6 value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredPasswordResetUuid6",
				1,
				"value" );
		}
		requiredPasswordResetUuid6 = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ISecureSecUserPWResetByUUuid6IdxKey ) {
			ISecureSecUserPWResetByUUuid6IdxKey rhs = (ISecureSecUserPWResetByUUuid6IdxKey)obj;
			if( getRequiredPasswordResetUuid6() != null ) {
				if( rhs.getRequiredPasswordResetUuid6() != null ) {
					if( ! getRequiredPasswordResetUuid6().equals( rhs.getRequiredPasswordResetUuid6() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPasswordResetUuid6() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ISecureSecUserPWReset) {
			ISecureSecUserPWReset rhs = (ISecureSecUserPWReset)obj;
			if( getRequiredPasswordResetUuid6() != null ) {
				if( rhs.getRequiredPasswordResetUuid6() != null ) {
					if( ! getRequiredPasswordResetUuid6().equals( rhs.getRequiredPasswordResetUuid6() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPasswordResetUuid6() != null ) {
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
		hashCode = hashCode + getRequiredPasswordResetUuid6().hashCode();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( 1 );
		}
		else if( obj instanceof ISecureSecUserPWResetByUUuid6IdxKey ) {
			ISecureSecUserPWResetByUUuid6IdxKey rhs = (ISecureSecUserPWResetByUUuid6IdxKey)obj;
			if (getRequiredPasswordResetUuid6() != null) {
				if (rhs.getRequiredPasswordResetUuid6() != null) {
					cmp = getRequiredPasswordResetUuid6().compareTo( rhs.getRequiredPasswordResetUuid6() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPasswordResetUuid6() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ISecureSecUserPWReset ) {
			ISecureSecUserPWReset rhs = (ISecureSecUserPWReset)obj;
			if (getRequiredPasswordResetUuid6() != null) {
				if (rhs.getRequiredPasswordResetUuid6() != null) {
					cmp = getRequiredPasswordResetUuid6().compareTo( rhs.getRequiredPasswordResetUuid6() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPasswordResetUuid6() != null) {
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
			+ " RequiredPasswordResetUuid6=" + "\"" + getRequiredPasswordResetUuid6().toString() + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<SecureBuffSecUserPWResetByUUuid6IdxKey" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
