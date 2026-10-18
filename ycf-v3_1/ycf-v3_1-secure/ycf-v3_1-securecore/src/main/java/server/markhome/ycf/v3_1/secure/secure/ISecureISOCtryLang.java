// Description: Java 25 interface for a ISOCtryLang record declementation

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
 *	ISecureISOCtryLang persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ISecureISOCtryLang
{
	public static final short ISOCTRYID_MIN_VALUE = (short)0;
	public static final short ISOLANGID_MIN_VALUE = (short)0;
	public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_CREATED_BY = YCFDbKeyHash256.fromHex(S_INIT_CREATED_BY);
	public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_UPDATED_BY = YCFDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final short ISOCTRYID_INIT_VALUE = (short)0;
	public static final short ISOLANGID_INIT_VALUE = (short)0;
	public final static int CLASS_CODE = 0xa006;
	public final static String S_CLASS_CODE = "a006";

	public int getClassCode();

	public YCFDbKeyHash256 getCreatedByUserId();

	public void setCreatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getCreatedAt();

	public void setCreatedAt( LocalDateTime value );

	public YCFDbKeyHash256 getUpdatedByUserId();

	public void setUpdatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getUpdatedAt();

	public void setUpdatedAt( LocalDateTime value );

	public ISecureISOCtryLangPKey getPKey();
	public void setPKey(ISecureISOCtryLangPKey pkey );
	public ISecureISOCtry getRequiredContainerCtry();

	public void setRequiredContainerCtry(short argISOCtryId);

	public void setRequiredContainerCtry(ISecureISOCtry argObj);

	public void setRequiredContainerCtry(ISecureProtISOCtry argObj);

	public void setRequiredContainerCtry(ISecurePubISOCtry argObj);

	public ISecureISOLang getRequiredParentLang();

	public void setRequiredParentLang(short argISOLangId);

	public void setRequiredParentLang(ISecureISOLang argObj);

	public void setRequiredParentLang(ISecureProtISOLang argObj);

	public void setRequiredParentLang(ISecurePubISOLang argObj);

	public short getRequiredISOCtryId();

	public void setRequiredISOCtryId(short value);

	public short getRequiredISOLangId();

	public void setRequiredISOLangId(short value);

	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( ISecureISOCtryLang src );

	public void setISOCtryLang( ISecureISOCtryLang src );

	public void set( ISecureISOCtryLangH src );

	public void setISOCtryLang( ISecureISOCtryLangH src );

	public void set( ISecureProtISOCtryLang src );

	public void setISOCtryLang( ISecureProtISOCtryLang src );

	public void set( ISecureProtISOCtryLangH src );

	public void setISOCtryLang( ISecureProtISOCtryLangH src );

	public void set( ISecurePubISOCtryLang src );

	public void setISOCtryLang( ISecurePubISOCtryLang src );

	public void set( ISecurePubISOCtryLangH src );

	public void setISOCtryLang( ISecurePubISOCtryLangH src );

	public String getXmlAttrFragment();

	public String toString();
}
