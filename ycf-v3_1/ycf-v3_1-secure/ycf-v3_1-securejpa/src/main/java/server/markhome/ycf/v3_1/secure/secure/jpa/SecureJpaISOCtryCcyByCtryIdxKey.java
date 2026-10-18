// Description: Java 25 JPA implementation of a ISOCtryCcy by CtryIdx index key object.

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

public class SecureJpaISOCtryCcyByCtryIdxKey
	implements ISecureISOCtryCcyByCtryIdxKey, Comparable<Object>, Serializable
{
	protected short requiredISOCtryId;
	public SecureJpaISOCtryCcyByCtryIdxKey() {
		requiredISOCtryId = ISecurePubISOCtryCcy.ISOCTRYID_INIT_VALUE;
	}

	@Override
	public short getRequiredISOCtryId() {
		return(getPKey().getRequiredISOCtryId());
	}

	@Override
	public void setRequiredISOCtryId( short value ) {
		if( value < ISecurePubISOCtryCcy.ISOCTRYID_MIN_VALUE ) {
			throw new YCFArgumentUnderflowException( getClass(),
				"setRequiredISOCtryId",
				1,
				"value",
				value,
				ISecurePubISOCtryCcy.ISOCTRYID_MIN_VALUE );
		}
		getPKey().setRequiredISOCtryId(value);
	}

	@Override
	public boolean equals( Object obj ) {
		if (obj == null) {
			return( false );
		}
		else if (obj instanceof ISecureISOCtryCcyByCtryIdxKey) {
			ISecureISOCtryCcyByCtryIdxKey rhs = (ISecureISOCtryCcyByCtryIdxKey)obj;
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			return( true );
		}
		else if (obj instanceof ISecureISOCtryCcy) {
			ISecureISOCtryCcy rhs = (ISecureISOCtryCcy)obj;
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
				return( false );
			}
			return( true );
		}
		else if (obj instanceof ISecureISOCtryCcyH) {
			ISecureISOCtryCcyH rhs = (ISecureISOCtryCcyH)obj;
			if( getRequiredISOCtryId() != rhs.getRequiredISOCtryId() ) {
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
		hashCode = ( hashCode * 0x10000 ) + getRequiredISOCtryId();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if (obj == null) {
			return( 1 );
		}
		else if (obj instanceof ISecureISOCtryCcyByCtryIdxKey) {
			ISecureISOCtryCcyByCtryIdxKey rhs = (ISecureISOCtryCcyByCtryIdxKey)obj;
			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if (obj instanceof ISecureISOCtryCcy) {
			ISecureISOCtryCcy rhs = (ISecureISOCtryCcy)obj;
			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else if (obj instanceof ISecureISOCtryCcyH) {
			ISecureISOCtryCcyH rhs = (ISecureISOCtryCcyH)obj;
			if( getRequiredISOCtryId() < rhs.getRequiredISOCtryId() ) {
				return( -1 );
			}
			else if( getRequiredISOCtryId() > rhs.getRequiredISOCtryId() ) {
				return( 1 );
			}
			return( 0 );
		}
		else {
			throw new YCFUnsupportedClassException(getClass(),
				"compareTo",
				"obj",
				obj,
				"ISecureISOCtryCcyByCtryIdxKey, ISecureISOCtryCcy, ISecureISOCtryCcyH");
		}
	}

	public String getXmlAttrFragment() {
		String ret = "" 
			+ " RequiredISOCtryId=" + "\"" + Short.toString( getRequiredISOCtryId() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<SecureISOCtryCcyByCtryIdxKey" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
