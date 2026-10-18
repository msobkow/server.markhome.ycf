// Description: Java 25 interface for a SecSysRoleMemb record declementation

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
 *	ISecureSecSysRoleMemb persistence instances have CodeVis Protected, meaning that any only user interfaces and application code specific to the defining schema can access it.
 */
public interface ISecureSecSysRoleMemb
{
	public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_CREATED_BY = YCFDbKeyHash256.fromHex(S_INIT_CREATED_BY);
	public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_UPDATED_BY = YCFDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final String S_SECSYSROLEID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 SECSYSROLEID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_SECSYSROLEID_INIT_VALUE );
	public static final String LOGINID_INIT_VALUE = new String( "" );
	public final static int CLASS_CODE = 0xa019;
	public final static String S_CLASS_CODE = "a019";

	public int getClassCode();

	public YCFDbKeyHash256 getCreatedByUserId();

	public void setCreatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getCreatedAt();

	public void setCreatedAt( LocalDateTime value );

	public YCFDbKeyHash256 getUpdatedByUserId();

	public void setUpdatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getUpdatedAt();

	public void setUpdatedAt( LocalDateTime value );

	public ISecureSecSysRoleMembPKey getPKey();
	public void setPKey(ISecureSecSysRoleMembPKey pkey );
	public ISecureSecSysRole getRequiredContainerSysRole();

	public void setRequiredContainerSysRole(IYCFKeyHash256 argSecSysRoleId);

	public void setRequiredContainerSysRole(ISecureSecSysRole argObj);

	public void setRequiredContainerSysRole(ISecureProtSecSysRole argObj);

	public void setRequiredContainerSysRole(ISecurePubSecSysRole argObj);

	public ISecureSecUser getRequiredParentUser();

	public void setRequiredParentUser(String argLoginId);

	public void setRequiredParentUser(ISecureSecUser argObj);

	public void setRequiredParentUser(ISecureProtSecUser argObj);

	public void setRequiredParentUser(ISecurePubSecUser argObj);

	public IYCFKeyHash256 getRequiredSecSysRoleId();

	public void setRequiredSecSysRoleId(IYCFKeyHash256 value);

	public String getRequiredLoginId();

	public void setRequiredLoginId(String value);

	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( ISecureSecSysRoleMemb src );

	public void setSecSysRoleMemb( ISecureSecSysRoleMemb src );

	public void set( ISecureSecSysRoleMembH src );

	public void setSecSysRoleMemb( ISecureSecSysRoleMembH src );

	public void set( ISecureProtSecSysRoleMemb src );

	public void setSecSysRoleMemb( ISecureProtSecSysRoleMemb src );

	public void set( ISecureProtSecSysRoleMembH src );

	public void setSecSysRoleMemb( ISecureProtSecSysRoleMembH src );

	public String getXmlAttrFragment();

	public String toString();
}
