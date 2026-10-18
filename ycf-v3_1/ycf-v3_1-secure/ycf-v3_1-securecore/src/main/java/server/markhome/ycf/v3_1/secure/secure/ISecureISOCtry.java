// Description: Java 25 interface for a ISOCtry record declementation

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
 *	ISecureISOCtry persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ISecureISOCtry
{
	public static final short ISOCTRYID_MIN_VALUE = (short)0;
	public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_CREATED_BY = YCFDbKeyHash256.fromHex(S_INIT_CREATED_BY);
	public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_UPDATED_BY = YCFDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final short ISOCTRYID_INIT_VALUE = (short)0;
	public static final String ISOCODE_INIT_VALUE = new String( "" );
	public static final String NAME_INIT_VALUE = new String( "" );
	public final static int CLASS_CODE = 0xa004;
	public final static String S_CLASS_CODE = "a004";

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
	public void setPKey($implCommaIJavaOptAtomType$ requiredISOCtryId);
	public List<ISecureISOCtryCcy> getOptionalComponentsCcy();

	public List<ISecureISOCtryLang> getOptionalComponentsLang();

	public short getRequiredISOCtryId();
	public void setRequiredISOCtryId( short value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public String getRequiredISOCode();
	public void setRequiredISOCode( String value );
	public String getRequiredName();
	public void setRequiredName( String value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( ISecureISOCtry src );

	public void setISOCtry( ISecureISOCtry src );

	public void set( ISecureISOCtryH src );

	public void setISOCtry( ISecureISOCtryH src );

	public void set( ISecureProtISOCtry src );

	public void setISOCtry( ISecureProtISOCtry src );

	public void set( ISecureProtISOCtryH src );

	public void setISOCtry( ISecureProtISOCtryH src );

	public void set( ISecurePubISOCtry src );

	public void setISOCtry( ISecurePubISOCtry src );

	public void set( ISecurePubISOCtryH src );

	public void setISOCtry( ISecurePubISOCtryH src );

	public String getXmlAttrFragment();

	public String toString();
}
