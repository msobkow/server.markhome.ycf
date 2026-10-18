// Description: Java 25 Secure Public Authorization Implementation

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

import java.lang.reflect.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;

/*
 *	A SecurePubAuthorization is a public authorization ticket
 *	for the system providing services.  Most modern authorizations
 *	are based on OAuth2 tickets, but I haven't gotten there yet.
 */
public class SecurePubAuthorization implements ISecurePubAuthorization, Serializable
{
	protected IYCFUuid6 authUuid6;
	protected String authUuid6Str;

	protected YCFDbKeyHash256 secSessionId;
	protected YCFDbKeyHash256 secUserId;
	protected YCFDbKeyHash256 secClusterId;
	protected YCFDbKeyHash256 secTenantId;

	public SecurePubAuthorization() {
		authUuid6 = YCFUuid6.generateUuid6();
		authUuid6Str = authUuid6.toString();
		secSessionId = YCFDbKeyHash256.nullGet();
		secUserId = YCFDbKeyHash256.nullGet();
		secClusterId = YCFDbKeyHash256.nullGet();
		secTenantId = YCFDbKeyHash256.nullGet();
	}

	public SecurePubAuthorization(IYCFUuid6 authUuid6, YCFDbKeyHash256 secSessionId, YCFDbKeyHash256 secUserId, YCFDbKeyHash256 secClusterId, YCFDbKeyHash256 secTenantId) {
		this.authUuid6 = authUuid6;
		this.authUuid6Str = this.authUuid6.toString();
		this.secSessionId = secSessionId;
		this.secUserId = secUserId;
		this.secClusterId = secClusterId;
		this.secTenantId = secTenantId;
	}

	public SecurePubAuthorization(ISecurePubAuthorization src) {
		authUuid6 = new YCFUuid6(src.getAuthUuid6().getBytes());
		authUuid6Str = authUuid6.toString();
		secSessionId = new YCFDbKeyHash256(src.getSecSessionId());
		secUserId = new YCFDbKeyHash256(src.getSecUserId());
		secClusterId = new YCFDbKeyHash256(src.getSecClusterId());
		secTenantId = new YCFDbKeyHash256(src.getSecTenantId());
	}

	public IYCFUuid6 getAuthUuid6() {
		return( authUuid6 );
	}

	public String getAuthUuid6Str() {
		return( authUuid6Str );
	}

	public YCFDbKeyHash256 getSecSessionId() {
		return( secSessionId );
	}

	public YCFDbKeyHash256 getSecUserId() {
		return( secUserId );
	}

	public YCFDbKeyHash256 getSecClusterId() {
		return( secClusterId );
	}

	public YCFDbKeyHash256 getSecTenantId() {
		return( secTenantId );
	}
}
