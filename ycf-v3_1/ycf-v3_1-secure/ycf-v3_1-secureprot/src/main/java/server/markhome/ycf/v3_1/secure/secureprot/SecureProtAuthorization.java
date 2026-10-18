// Description: Java 25 Secure Protected Authorization Implementation

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

/*
 *	A SecureProtAuthorization is a protected authorization ticket
 *	for the system providing services.  Most modern authorizations
 *	are based on OAuth2 tickets, but I haven't gotten there yet.
 */
public class SecureProtAuthorization extends SecurePubAuthorization implements ISecureProtAuthorization, Serializable
{

	public SecureProtAuthorization() {
		super();
	}

	public SecureProtAuthorization(IYCFUuid6 authUuid6, YCFDbKeyHash256 secSessionId, YCFDbKeyHash256 secUserId, YCFDbKeyHash256 secClusterId, YCFDbKeyHash256 secTenantId) {
		super(authUuid6, secSessionId, secUserId, secClusterId, secTenantId);
	}

	public SecureProtAuthorization(ISecureProtAuthorization src) {
		super(src);
	}

	public SecureProtAuthorization(ISecurePubAuthorization src) {
		super(src);
	}

}
