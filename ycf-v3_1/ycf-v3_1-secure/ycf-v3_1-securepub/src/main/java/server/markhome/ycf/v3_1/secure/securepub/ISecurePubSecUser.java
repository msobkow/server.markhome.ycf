// Description: Java 25 public interface for a SecUser record implementation

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

package server.markhome.ycf.v3_1.secure.securepub;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.YCFXmlUtil;
//import server.markhome.ycf.v3_1.secure.securepub.*;

/**
 *	ISecurePubSecUser persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ISecurePubSecUser
{
	public static final ISecurePubSchema.SecAccountStatusEnum ACCOUNTSTATUS_MIN_VALUE = ISecurePubSchema.SecAccountStatusEnum.System;
	public static final ISecurePubSchema.SecAccountStatusEnum ACCOUNTSTATUS_MAX_VALUE = ISecurePubSchema.SecAccountStatusEnum.Locked;
	public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_CREATED_BY = YCFDbKeyHash256.fromHex(S_INIT_CREATED_BY);
	public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_UPDATED_BY = YCFDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final String S_SECUSERID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 SECUSERID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_SECUSERID_INIT_VALUE );
	public static final String LOGINID_INIT_VALUE = new String( "" );
	public static final ISecurePubSchema.SecAccountStatusEnum ACCOUNTSTATUS_INIT_VALUE = ISecurePubSchema.ordinalToSecAccountStatusEnum( 5 );
	public static final String DFLTSYSGRPNAME_INIT_VALUE = new String( "" );
	public static final String DFLTCLUSGRPNAME_INIT_VALUE = new String( "" );
	public static final String DFLTTENTGRPNAME_INIT_VALUE = new String( "" );
	public static final String EMAILADDRESS_INIT_VALUE = new String( "" );
	public final static int CLASS_CODE = 0xa009;
	public final static String S_CLASS_CODE = "a009";

	public int getClassCode();

	public YCFDbKeyHash256 getCreatedByUserId();

	public void setCreatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getCreatedAt();

	public void setCreatedAt( LocalDateTime value );

	public YCFDbKeyHash256 getUpdatedByUserId();

	public void setUpdatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getUpdatedAt();

	public void setUpdatedAt( LocalDateTime value );

	public IYCFKeyHash256 getPKey();
	public void setPKey(IYCFKeyHash256 requiredSecUserId);
	public List<ISecurePubSecSession> getOptionalComponentsSecSess();

	public YCFDbKeyHash256 getRequiredSecUserId();
	public void setRequiredSecUserId( YCFDbKeyHash256 value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public String getRequiredLoginId();
	public void setRequiredLoginId( String value );
	public ISecurePubSchema.SecAccountStatusEnum getRequiredAccountStatus();
	public void setRequiredAccountStatus( ISecurePubSchema.SecAccountStatusEnum value );
	public String getOptionalDfltSysGrpName();
	public void setOptionalDfltSysGrpName( String value );
	public String getOptionalDfltClusGrpName();
	public void setOptionalDfltClusGrpName( String value );
	public String getOptionalDfltTentGrpName();
	public void setOptionalDfltTentGrpName( String value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( ISecurePubSecUser src );

	public void setSecUser( ISecurePubSecUser src );

	public void set( ISecurePubSecUserH src );

	public void setSecUser( ISecurePubSecUserH src );

	public String getXmlAttrFragment();

	public String toString();
}
