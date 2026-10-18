
// Description: Java 25 Factory service implementation for SecClusRole buffers

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
 *	Java 25 Factory service implementation for SecClusRole buffers.
 */
@Service("secure31BuffSecClusRoleFactoryService")
public class SecureBuffSecClusRoleFactoryService
	implements ISecureSecClusRoleFactory
{
	public SecureBuffSecClusRoleFactoryService() {
	}

	@Override
	public ISecureSecClusRoleHPKey newHPKey() {
		ISecureSecClusRoleHPKey hpkey =
			new SecureBuffSecClusRoleHPKey();
		return( hpkey );
	}

	public SecureBuffSecClusRoleHPKey ensureHPKey(ISecureSecClusRoleHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecClusRoleHPKey) {
			return( (SecureBuffSecClusRoleHPKey)key );
		}
		else {
			SecureBuffSecClusRoleHPKey mapped = new SecureBuffSecClusRoleHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecClusRoleId( key.getRequiredSecClusRoleId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecClusRoleByClusterIdxKey newByClusterIdxKey() {
		ISecureSecClusRoleByClusterIdxKey key =
			new SecureBuffSecClusRoleByClusterIdxKey();
		return( key );
	}

	public SecureBuffSecClusRoleByClusterIdxKey ensureByClusterIdxKey(ISecureSecClusRoleByClusterIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecClusRoleByClusterIdxKey) {
			return( (SecureBuffSecClusRoleByClusterIdxKey)key );
		}
		else {
			SecureBuffSecClusRoleByClusterIdxKey mapped = new SecureBuffSecClusRoleByClusterIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecClusRoleByNameIdxKey newByNameIdxKey() {
		ISecureSecClusRoleByNameIdxKey key =
			new SecureBuffSecClusRoleByNameIdxKey();
		return( key );
	}

	public SecureBuffSecClusRoleByNameIdxKey ensureByNameIdxKey(ISecureSecClusRoleByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecClusRoleByNameIdxKey) {
			return( (SecureBuffSecClusRoleByNameIdxKey)key );
		}
		else {
			SecureBuffSecClusRoleByNameIdxKey mapped = new SecureBuffSecClusRoleByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecClusRoleByUNameIdxKey newByUNameIdxKey() {
		ISecureSecClusRoleByUNameIdxKey key =
			new SecureBuffSecClusRoleByUNameIdxKey();
		return( key );
	}

	public SecureBuffSecClusRoleByUNameIdxKey ensureByUNameIdxKey(ISecureSecClusRoleByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecClusRoleByUNameIdxKey) {
			return( (SecureBuffSecClusRoleByUNameIdxKey)key );
		}
		else {
			SecureBuffSecClusRoleByUNameIdxKey mapped = new SecureBuffSecClusRoleByUNameIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecClusRole newRec() {
		ISecureSecClusRole rec =
			new SecureBuffSecClusRole();
		return( rec );
	}

	public SecureBuffSecClusRole ensureRec(ISecureSecClusRole rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecClusRole) {
			return ((SecureBuffSecClusRole)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecClusRole.CLASS_CODE: {
					SecureBuffSecClusRole mapped = new SecureBuffSecClusRole();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecClusRole",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecClusRole");
			}
		}
	}

	@Override
	public ISecureSecClusRoleH newHRec() {
		ISecureSecClusRoleH hrec =
			new SecureBuffSecClusRoleH();
		return( hrec );
	}

	public SecureBuffSecClusRoleH ensureHRec(ISecureSecClusRoleH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecClusRoleH) {
			return ((SecureBuffSecClusRoleH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecClusRole.CLASS_CODE: {
					SecureBuffSecClusRoleH mapped = new SecureBuffSecClusRoleH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecClusRole",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecClusRole");
			}
		}
	}
}
