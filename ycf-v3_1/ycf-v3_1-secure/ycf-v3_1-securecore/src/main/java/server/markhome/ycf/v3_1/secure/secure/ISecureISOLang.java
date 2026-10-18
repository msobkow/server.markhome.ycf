// Description: Java 25 interface for a ISOLang record declementation

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

package server.markhome.ycf.v3_1.secure.secure;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;

import server.markhome.ycf.v3_1.secure.secureprotobj.*;

/**
 *	ISecureISOLang persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ISecureISOLang
{
	public static final short ISOLANGID_MIN_VALUE = (short)0;
	public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_CREATED_BY = YCFDbKeyHash256.fromHex(S_INIT_CREATED_BY);
	public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_UPDATED_BY = YCFDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final short ISOLANGID_INIT_VALUE = (short)0;
	public static final String ISO6392CODE_INIT_VALUE = new String( "" );
	public static final String ISO6391CODE_INIT_VALUE = new String( "" );
	public static final String ENGLISHNAME_INIT_VALUE = new String( "" );
	public final static int CLASS_CODE = 0xa007;
	public final static String S_CLASS_CODE = "a007";

	public int getClassCode();

	public YCFDbKeyHash256 getCreatedByUserId();

	public void setCreatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getCreatedAt();

	public void setCreatedAt( LocalDateTime value );

	public YCFDbKeyHash256 getUpdatedByUserId();

	public void setUpdatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getUpdatedAt();

	public void setUpdatedAt( LocalDateTime value );

	public $implCommaIJavaOptAtomType$ getPKey();
	public void setPKey($implCommaIJavaOptAtomType$ requiredISOLangId);
	public List<ISecureISOCtryLang> getOptionalChildrenCtry();

	public short getRequiredISOLangId();
	public void setRequiredISOLangId( short value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public String getRequiredISO6392Code();
	public void setRequiredISO6392Code( String value );
	public String getOptionalISO6391Code();
	public void setOptionalISO6391Code( String value );
	public String getRequiredEnglishName();
	public void setRequiredEnglishName( String value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( ISecureISOLang src );

	public void setISOLang( ISecureISOLang src );

	public void set( ISecureISOLangH src );

	public void setISOLang( ISecureISOLangH src );

	public void set( ISecureProtISOLang src );

	public void setISOLang( ISecureProtISOLang src );

	public void set( ISecureProtISOLangH src );

	public void setISOLang( ISecureProtISOLangH src );

	public void set( ISecurePubISOLang src );

	public void setISOLang( ISecurePubISOLang src );

	public void set( ISecurePubISOLangH src );

	public void setISOLang( ISecurePubISOLangH src );

	public String getXmlAttrFragment();

	public String toString();
}
