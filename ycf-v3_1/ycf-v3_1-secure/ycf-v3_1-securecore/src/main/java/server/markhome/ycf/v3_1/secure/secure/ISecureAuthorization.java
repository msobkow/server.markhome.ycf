// Description: Java 25 Private Authorization Interface.

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
import server.markhome.ycf.v3_1.secure.secureprot.ISecureProtAuthorization;
import server.markhome.ycf.v3_1.secure.secureobj.ISecureClusterObj;
import server.markhome.ycf.v3_1.secure.secureobj.ISecureTenantObj;
import server.markhome.ycf.v3_1.secure.secureobj.ISecureSecSessionObj;
import server.markhome.ycf.v3_1.secure.secureobj.ISecureSecUserObj;


/*
 *	An ISecureAuthorization is an authorization ticket
 *	for the system providing services.
 */
public interface ISecureAuthorization extends ISecureProtAuthorization
{
	public void setAuthUuid6( IYCFUuid6 value );

	public void setSecClusterId( YCFDbKeyHash256 clusterId );
	public void setSecCluster(ISecureClusterObj cluster);
	public void setSecTenantId( YCFDbKeyHash256 tenantId );
	public void setSecTenant(ISecureTenantObj tenant);
	public void setSecSessionId( YCFDbKeyHash256 sessionId );
	public void setSecSession(ISecureSecSessionObj session);
	public void setSecUserId( YCFDbKeyHash256 userId );
	public void setSecUser(ISecureSecUserObj user);
}
