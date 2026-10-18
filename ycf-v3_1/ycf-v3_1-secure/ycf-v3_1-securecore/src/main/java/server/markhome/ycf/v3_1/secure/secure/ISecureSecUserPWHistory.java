// Description: Java 25 interface for a SecUserPWHistory record declementation

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
 *	ISecureSecUserPWHistory persistence instances have CodeVis Private, meaning that only the back-end code for the schema implementation can access it, and even the code specific user interface cannot.
 */
public interface ISecureSecUserPWHistory
{
	public static final String S_SECUSERID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 SECUSERID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_SECUSERID_INIT_VALUE );
	public static final LocalDateTime PWSETSTAMP_INIT_VALUE = YCFXmlUtil.parseTimestamp("2020-01-01T00:00:00");
	public static final LocalDateTime PWREPLACEDSTAMP_INIT_VALUE = YCFXmlUtil.parseTimestamp("2020-01-01T00:00:00");
	public final static int CLASS_CODE = 0xa00d;
	public final static String S_CLASS_CODE = "a00d";

	public int getClassCode();

	public ISecureSecUserPWHistoryPKey getPKey();
	public void setPKey(ISecureSecUserPWHistoryPKey pkey );
	public IYCFKeyHash256 getRequiredSecUserId();

	public void setRequiredSecUserId(IYCFKeyHash256 value);

	public LocalDateTime getRequiredPWSetStamp();

	public void setRequiredPWSetStamp(LocalDateTime value);

	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public LocalDateTime getRequiredPWReplacedStamp();
	public void setRequiredPWReplacedStamp( LocalDateTime value );
	public String getRequiredPasswordHash();
	public void setRequiredPasswordHash( String value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( ISecureSecUserPWHistory src );

	public void setSecUserPWHistory( ISecureSecUserPWHistory src );

	public void set( ISecureSecUserPWHistoryH src );

	public void setSecUserPWHistory( ISecureSecUserPWHistoryH src );

	public String getXmlAttrFragment();

	public String toString();
}
