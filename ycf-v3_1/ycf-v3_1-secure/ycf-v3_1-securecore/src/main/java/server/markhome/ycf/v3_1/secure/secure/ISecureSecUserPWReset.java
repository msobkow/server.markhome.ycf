// Description: Java 25 interface for a SecUserPWReset record declementation

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
 *	ISecureSecUserPWReset persistence instances have CodeVis Protected, meaning that any only user interfaces and application code specific to the defining schema can access it.
 */
public interface ISecureSecUserPWReset
{
	public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_CREATED_BY = YCFDbKeyHash256.fromHex(S_INIT_CREATED_BY);
	public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_UPDATED_BY = YCFDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final String S_SECUSERID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 SECUSERID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_SECUSERID_INIT_VALUE );
	public static final String SENTTOEMAILADDR_INIT_VALUE = new String( "" );
	public final static boolean NEWACCOUNT_INIT_VALUE = false;
	public final static int CLASS_CODE = 0xa00c;
	public final static String S_CLASS_CODE = "a00c";

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
	public void setPKey($implCommaIJavaOptAtomType$ requiredSecUserId);
	public ISecureSecUser getRequiredContainerUser();

	public void setRequiredContainerUser(IYCFKeyHash256 argSecUserId);

	public void setRequiredContainerUser(ISecureSecUser argObj);

	public void setRequiredContainerUser(ISecureProtSecUser argObj);

	public void setRequiredContainerUser(ISecurePubSecUser argObj);

	public IYCFKeyHash256 getRequiredSecUserId();
	public void setRequiredSecUserId( IYCFKeyHash256 value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public String getRequiredSentToEMailAddr();
	public void setRequiredSentToEMailAddr( String value );
	public IYCFUuid6 getRequiredPasswordResetUuid6();
	public void setRequiredPasswordResetUuid6( IYCFUuid6 value );
	public boolean getRequiredNewAccount();
	public void setRequiredNewAccount( boolean value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( ISecureSecUserPWReset src );

	public void setSecUserPWReset( ISecureSecUserPWReset src );

	public void set( ISecureSecUserPWResetH src );

	public void setSecUserPWReset( ISecureSecUserPWResetH src );

	public void set( ISecureProtSecUserPWReset src );

	public void setSecUserPWReset( ISecureProtSecUserPWReset src );

	public void set( ISecureProtSecUserPWResetH src );

	public void setSecUserPWReset( ISecureProtSecUserPWResetH src );

	public String getXmlAttrFragment();

	public String toString();
}
