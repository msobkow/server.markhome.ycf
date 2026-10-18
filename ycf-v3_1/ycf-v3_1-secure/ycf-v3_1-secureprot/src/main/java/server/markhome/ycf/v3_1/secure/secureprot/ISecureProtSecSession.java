// Description: Java 25 protected interface for a SecSession record implementation

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

package server.markhome.ycf.v3_1.secure.secureprot;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;

/**
 *	ISecureProtSecSession persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ISecureProtSecSession
{
	public static final String S_SECSESSIONID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 SECSESSIONID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_SECSESSIONID_INIT_VALUE );
	public static final String S_SECUSERID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 SECUSERID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_SECUSERID_INIT_VALUE );
	public static final LocalDateTime START_INIT_VALUE = YCFXmlUtil.parseTimestamp("2020-01-01T00:00:00");
	public static final String S_SECPROXYID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 SECPROXYID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_SECPROXYID_INIT_VALUE );
	public final static int CLASS_CODE = 0xa01e;
	public final static String S_CLASS_CODE = "a01e";

	public int getClassCode();

	public YCFDbKeyHash256 getPKey();
	public void setPKey(YCFDbKeyHash256 requiredSecSessionId);
	public IYCFKeyHash256 getRequiredSecSessionId();
	public void setRequiredSecSessionId( IYCFKeyHash256 value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public ISecureProtSecUser getRequiredContainerSecUser();

	public void setRequiredContainerSecUser(IYCFKeyHash256 argSecUserId);


	public void setRequiredContainerSecUser(ISecureProtSecUser argObj);

	public void setRequiredContainerSecUser(ISecurePubSecUser argObj);

	public ISecureProtSecUser getRequiredParentSecProxy();

	public void setRequiredParentSecProxy(IYCFKeyHash256 argSecProxyId);


	public void setRequiredParentSecProxy(ISecureProtSecUser argObj);

	public void setRequiredParentSecProxy(ISecurePubSecUser argObj);

	public IYCFKeyHash256 getRequiredSecUserId();
	public void setRequiredSecUserId( IYCFKeyHash256 value );
	public LocalDateTime getRequiredStart();
	public void setRequiredStart( LocalDateTime value );
	public LocalDateTime getOptionalFinish();
	public void setOptionalFinish( LocalDateTime value );
	public IYCFKeyHash256 getOptionalSecProxyId();
	public void setOptionalSecProxyId( IYCFKeyHash256 value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( ISecureProtSecSession src );

	public void setSecSession( ISecureProtSecSession src );

	public void set( ISecureProtSecSessionH src );

	public void setSecSession( ISecureProtSecSessionH src );

	public void set( ISecurePubSecSession src );

	public void setSecSession( ISecurePubSecSession src );

	public void set( ISecurePubSecSessionH src );

	public void setSecSession( ISecurePubSecSessionH src );

	public String getXmlAttrFragment();

	public String toString();
}
