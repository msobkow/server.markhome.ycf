// Description: Java 25 Secure Private Authorization Implementation

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

import java.lang.reflect.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.v3_1.secure.securepub.ISecurePubAuthorization;
import server.markhome.ycf.v3_1.secure.securepub.SecurePubAuthorization;
import server.markhome.ycf.v3_1.secure.secureprot.ISecureProtAuthorization;
import server.markhome.ycf.v3_1.secure.secureprot.SecureProtAuthorization;
import server.markhome.ycf.v3_1.secure.secureobj.ISecureClusterObj;
import server.markhome.ycf.v3_1.secure.secureobj.ISecureTenantObj;
import server.markhome.ycf.v3_1.secure.secureobj.ISecureSecSessionObj;
import server.markhome.ycf.v3_1.secure.secureobj.ISecureSecUserObj;

/*
 *	A SecureAuthorization is a private authorization ticket
 *	for the system providing services.  Most modern authorizations
 *	are based on OAuth2 tickets, but I haven't gotten there yet.
 */
public class SecureAuthorization extends SecureProtAuthorization implements ISecureAuthorization, Serializable
{
	public SecureAuthorization() {
		super();
	}

	public SecureAuthorization(IYCFUuid6 authUuid6, YCFDbKeyHash256 secSessionId, YCFDbKeyHash256 secUserId, YCFDbKeyHash256 secClusterId, YCFDbKeyHash256 secTenantId) {
		super(authUuid6, secSessionId, secUserId, secClusterId, secTenantId);
	}

	public SecureAuthorization(ISecureAuthorization src) {
		super(src);
	}

	public SecureAuthorization(ISecureProtAuthorization src) {
		super(src);
	}

	public SecureAuthorization(ISecurePubAuthorization src) {
		super(src);
	}

	@Override
	public void setAuthUuid6( IYCFUuid6 value ) {
		this.authUuid6 = new YCFUuid6(value.getBytes());
		this.authUuid6Str = this.authUuid6.toString();
	}

	@Override
	public void setSecClusterId( YCFDbKeyHash256 clusterId ) {
		this.secClusterId = new YCFDbKeyHash256(clusterId);
	}

	@Override
	public void setSecCluster(ISecureClusterObj cluster) {
		if (cluster == null) {
			this.secClusterId = YCFDbKeyHash256.nullGet();
		}
		else {
			this.secClusterId = cluster.getRequiredId();
		}
	}

	@Override
	public void setSecTenantId( YCFDbKeyHash256 tenantId ) {
		this.secTenantId = new YCFDbKeyHash256(tenantId);
	}

	@Override
	public void setSecTenant(ISecureTenantObj tenant) {
		if (tenant == null) {
			this.secTenantId = YCFDbKeyHash256.nullGet();
		}
		else {
			this.secTenantId = new YCFDbKeyHash256(tenant.getRequiredId());
		}
	}

	@Override
	public void setSecSessionId( YCFDbKeyHash256 sessionId ) {
		this.secSessionId = new YCFDbKeyHash256(sessionId);
	}

	@Override
	public void setSecSession(ISecureSecSessionObj session) {
		if (session == null) {
			this.secSessionId = YCFDbKeyHash256.nullGet();
		}
		else {
			this.secSessionId = new YCFDbKeyHash256(session.getRequiredSecSessionId());
		}
	}

	@Override
	public void setSecUserId( YCFDbKeyHash256 userId ) {
		this.secUserId = new YCFDbKeyHash256(userId);
	}

	@Override
	public void setSecUser(ISecureSecUserObj user) {
		if (user == null) {
			this.secUserId = YCFDbKeyHash256.nullGet();
		}
		else {
			this.secUserId = new YCFDbKeyHash256(user.getRequiredSecUserId());
		}
	}
}
