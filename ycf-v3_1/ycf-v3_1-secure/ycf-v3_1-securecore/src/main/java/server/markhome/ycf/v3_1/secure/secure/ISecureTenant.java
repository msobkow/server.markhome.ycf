// Description: Java 25 interface for a Tenant record declementation

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
 *	ISecureTenant persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ISecureTenant
{
	public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_CREATED_BY = YCFDbKeyHash256.fromHex(S_INIT_CREATED_BY);
	public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_UPDATED_BY = YCFDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final String S_ID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 ID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_ID_INIT_VALUE );
	public static final String S_CLUSTERID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 CLUSTERID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_CLUSTERID_INIT_VALUE );
	public static final String TENANTNAME_INIT_VALUE = new String( "" );
	public final static int CLASS_CODE = 0xa002;
	public final static String S_CLASS_CODE = "a002";

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
	public void setPKey($implCommaIJavaOptAtomType$ requiredId);
	public List<ISecureSecTentGrp> getOptionalComponentsSecGroup();

	public List<ISecureSecTentRole> getOptionalComponentsSecRole();

	public IYCFKeyHash256 getRequiredId();
	public void setRequiredId( IYCFKeyHash256 value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public ISecureCluster getRequiredContainerCluster();

	public void setRequiredContainerCluster(IYCFKeyHash256 argClusterId);

	public void setRequiredContainerCluster(ISecureCluster argObj);

	public void setRequiredContainerCluster(ISecureProtCluster argObj);

	public void setRequiredContainerCluster(ISecurePubCluster argObj);

	public IYCFKeyHash256 getRequiredClusterId();
	public void setRequiredClusterId( IYCFKeyHash256 value );
	public String getRequiredTenantName();
	public void setRequiredTenantName( String value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( ISecureTenant src );

	public void setTenant( ISecureTenant src );

	public void set( ISecureTenantH src );

	public void setTenant( ISecureTenantH src );

	public void set( ISecureProtTenant src );

	public void setTenant( ISecureProtTenant src );

	public void set( ISecureProtTenantH src );

	public void setTenant( ISecureProtTenantH src );

	public void set( ISecurePubTenant src );

	public void setTenant( ISecurePubTenant src );

	public void set( ISecurePubTenantH src );

	public void setTenant( ISecurePubTenantH src );

	public String getXmlAttrFragment();

	public String toString();
}
