// Description: Java 25 JPA implementation of a SecUserPWReset by NewAcctIdx index key object.

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

public class SecureJpaSecUserPWResetByNewAcctIdxKey
	implements ISecureSecUserPWResetByNewAcctIdxKey, Comparable<Object>, Serializable
{
	protected boolean requiredNewAccount;
	public SecureJpaSecUserPWResetByNewAcctIdxKey() {
		requiredNewAccount = ISecureProtSecUserPWReset.NEWACCOUNT_INIT_VALUE;
	}

	@Override
	public boolean getRequiredNewAccount() {
		return(requiredNewAccount);
	}

	public void setRequiredNewAccount( boolean value ) {
		requiredNewAccount = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if (obj == null) {
			return( false );
		}
		else if (obj instanceof ISecureSecUserPWResetByNewAcctIdxKey) {
			ISecureSecUserPWResetByNewAcctIdxKey rhs = (ISecureSecUserPWResetByNewAcctIdxKey)obj;
			if( getRequiredNewAccount() != rhs.getRequiredNewAccount() ) {
				return( false );
			}
			return( true );
		}
		else if (obj instanceof ISecureSecUserPWReset) {
			ISecureSecUserPWReset rhs = (ISecureSecUserPWReset)obj;
			if( getRequiredNewAccount() != rhs.getRequiredNewAccount() ) {
				return( false );
			}
			return( true );
		}
		else if (obj instanceof ISecureSecUserPWResetH) {
			ISecureSecUserPWResetH rhs = (ISecureSecUserPWResetH)obj;
			if( getRequiredNewAccount() != rhs.getRequiredNewAccount() ) {
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
		if( getRequiredNewAccount() ) {
			hashCode = ( hashCode * 2 ) + 1;
		}
		else {
			hashCode = hashCode * 2;
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if (obj == null) {
			return( 1 );
		}
		else if (obj instanceof ISecureSecUserPWResetByNewAcctIdxKey) {
			ISecureSecUserPWResetByNewAcctIdxKey rhs = (ISecureSecUserPWResetByNewAcctIdxKey)obj;
			if( getRequiredNewAccount() ) {
				if( ! rhs.getRequiredNewAccount() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredNewAccount() ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if (obj instanceof ISecureSecUserPWReset) {
			ISecureSecUserPWReset rhs = (ISecureSecUserPWReset)obj;
			if( getRequiredNewAccount() ) {
				if( ! rhs.getRequiredNewAccount() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredNewAccount() ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else if (obj instanceof ISecureSecUserPWResetH) {
			ISecureSecUserPWResetH rhs = (ISecureSecUserPWResetH)obj;
			if( getRequiredNewAccount() ) {
				if( ! rhs.getRequiredNewAccount() ) {
					return( 1 );
				}
			}
			else {
				if( rhs.getRequiredNewAccount() ) {
					return( -1 );
				}
			}
			return( 0 );
		}
		else {
			throw new YCFUnsupportedClassException(getClass(),
				"compareTo",
				"obj",
				obj,
				"ISecureSecUserPWResetByNewAcctIdxKey, ISecureSecUserPWReset, ISecureSecUserPWResetH");
		}
	}

	public String getXmlAttrFragment() {
		String ret = "" 
			+ " RequiredNewAccount=" + (( getRequiredNewAccount() ) ? "\"true\"" : "\"false\"" );
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<SecureSecUserPWResetByNewAcctIdxKey" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
