
// Description: Java 25 Factory service implementation for SecTentRole buffers

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
 *	Java 25 Factory service implementation for SecTentRole buffers.
 */
@Service("secure31BuffSecTentRoleFactoryService")
public class SecureBuffSecTentRoleFactoryService
	implements ISecureSecTentRoleFactory
{
	public SecureBuffSecTentRoleFactoryService() {
	}

	@Override
	public ISecureSecTentRoleHPKey newHPKey() {
		ISecureSecTentRoleHPKey hpkey =
			new SecureBuffSecTentRoleHPKey();
		return( hpkey );
	}

	public SecureBuffSecTentRoleHPKey ensureHPKey(ISecureSecTentRoleHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecTentRoleHPKey) {
			return( (SecureBuffSecTentRoleHPKey)key );
		}
		else {
			SecureBuffSecTentRoleHPKey mapped = new SecureBuffSecTentRoleHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecTentRoleId( key.getRequiredSecTentRoleId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecTentRoleByTenantIdxKey newByTenantIdxKey() {
		ISecureSecTentRoleByTenantIdxKey key =
			new SecureBuffSecTentRoleByTenantIdxKey();
		return( key );
	}

	public SecureBuffSecTentRoleByTenantIdxKey ensureByTenantIdxKey(ISecureSecTentRoleByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecTentRoleByTenantIdxKey) {
			return( (SecureBuffSecTentRoleByTenantIdxKey)key );
		}
		else {
			SecureBuffSecTentRoleByTenantIdxKey mapped = new SecureBuffSecTentRoleByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecTentRoleByNameIdxKey newByNameIdxKey() {
		ISecureSecTentRoleByNameIdxKey key =
			new SecureBuffSecTentRoleByNameIdxKey();
		return( key );
	}

	public SecureBuffSecTentRoleByNameIdxKey ensureByNameIdxKey(ISecureSecTentRoleByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecTentRoleByNameIdxKey) {
			return( (SecureBuffSecTentRoleByNameIdxKey)key );
		}
		else {
			SecureBuffSecTentRoleByNameIdxKey mapped = new SecureBuffSecTentRoleByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecTentRoleByUNameIdxKey newByUNameIdxKey() {
		ISecureSecTentRoleByUNameIdxKey key =
			new SecureBuffSecTentRoleByUNameIdxKey();
		return( key );
	}

	public SecureBuffSecTentRoleByUNameIdxKey ensureByUNameIdxKey(ISecureSecTentRoleByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecTentRoleByUNameIdxKey) {
			return( (SecureBuffSecTentRoleByUNameIdxKey)key );
		}
		else {
			SecureBuffSecTentRoleByUNameIdxKey mapped = new SecureBuffSecTentRoleByUNameIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecTentRole newRec() {
		ISecureSecTentRole rec =
			new SecureBuffSecTentRole();
		return( rec );
	}

	public SecureBuffSecTentRole ensureRec(ISecureSecTentRole rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecTentRole) {
			return ((SecureBuffSecTentRole)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecTentRole.CLASS_CODE: {
					SecureBuffSecTentRole mapped = new SecureBuffSecTentRole();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecTentRole",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecTentRole");
			}
		}
	}

	@Override
	public ISecureSecTentRoleH newHRec() {
		ISecureSecTentRoleH hrec =
			new SecureBuffSecTentRoleH();
		return( hrec );
	}

	public SecureBuffSecTentRoleH ensureHRec(ISecureSecTentRoleH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecTentRoleH) {
			return ((SecureBuffSecTentRoleH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecTentRole.CLASS_CODE: {
					SecureBuffSecTentRoleH mapped = new SecureBuffSecTentRoleH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecTentRole",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecTentRole");
			}
		}
	}
}
