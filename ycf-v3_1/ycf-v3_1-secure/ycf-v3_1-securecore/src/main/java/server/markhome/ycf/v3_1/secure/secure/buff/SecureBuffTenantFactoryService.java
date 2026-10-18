
// Description: Java 25 Factory service implementation for Tenant buffers

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

package server.markhome.ycf.v3_1.secure.secure.buff;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;

/*
 *	Java 25 Factory service implementation for Tenant buffers.
 */
@Service("secure31BuffTenantFactoryService")
public class SecureBuffTenantFactoryService
	implements ISecureTenantFactory
{
	public SecureBuffTenantFactoryService() {
	}

	@Override
	public ISecureTenantHPKey newHPKey() {
		ISecureTenantHPKey hpkey =
			new SecureBuffTenantHPKey();
		return( hpkey );
	}

	public SecureBuffTenantHPKey ensureHPKey(ISecureTenantHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffTenantHPKey) {
			return( (SecureBuffTenantHPKey)key );
		}
		else {
			SecureBuffTenantHPKey mapped = new SecureBuffTenantHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public ISecureTenantByClusterIdxKey newByClusterIdxKey() {
		ISecureTenantByClusterIdxKey key =
			new SecureBuffTenantByClusterIdxKey();
		return( key );
	}

	public SecureBuffTenantByClusterIdxKey ensureByClusterIdxKey(ISecureTenantByClusterIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffTenantByClusterIdxKey) {
			return( (SecureBuffTenantByClusterIdxKey)key );
		}
		else {
			SecureBuffTenantByClusterIdxKey mapped = new SecureBuffTenantByClusterIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			return( mapped );
		}
	}

	@Override
	public ISecureTenantByUNameIdxKey newByUNameIdxKey() {
		ISecureTenantByUNameIdxKey key =
			new SecureBuffTenantByUNameIdxKey();
		return( key );
	}

	public SecureBuffTenantByUNameIdxKey ensureByUNameIdxKey(ISecureTenantByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffTenantByUNameIdxKey) {
			return( (SecureBuffTenantByUNameIdxKey)key );
		}
		else {
			SecureBuffTenantByUNameIdxKey mapped = new SecureBuffTenantByUNameIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredTenantName( key.getRequiredTenantName() );
			return( mapped );
		}
	}

	@Override
	public ISecureTenant newRec() {
		ISecureTenant rec =
			new SecureBuffTenant();
		return( rec );
	}

	public SecureBuffTenant ensureRec(ISecureTenant rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffTenant) {
			return ((SecureBuffTenant)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureTenant.CLASS_CODE: {
					SecureBuffTenant mapped = new SecureBuffTenant();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureTenant",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureTenant");
			}
		}
	}

	@Override
	public ISecureTenantH newHRec() {
		ISecureTenantH hrec =
			new SecureBuffTenantH();
		return( hrec );
	}

	public SecureBuffTenantH ensureHRec(ISecureTenantH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffTenantH) {
			return ((SecureBuffTenantH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureTenant.CLASS_CODE: {
					SecureBuffTenantH mapped = new SecureBuffTenantH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureTenant",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureTenant");
			}
		}
	}
}
