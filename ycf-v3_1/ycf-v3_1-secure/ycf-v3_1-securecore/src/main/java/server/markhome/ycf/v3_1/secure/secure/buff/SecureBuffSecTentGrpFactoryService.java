
// Description: Java 25 Factory service implementation for SecTentGrp buffers

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
 *	Java 25 Factory service implementation for SecTentGrp buffers.
 */
@Service("secure31BuffSecTentGrpFactoryService")
public class SecureBuffSecTentGrpFactoryService
	implements ISecureSecTentGrpFactory
{
	public SecureBuffSecTentGrpFactoryService() {
	}

	@Override
	public ISecureSecTentGrpHPKey newHPKey() {
		ISecureSecTentGrpHPKey hpkey =
			new SecureBuffSecTentGrpHPKey();
		return( hpkey );
	}

	public SecureBuffSecTentGrpHPKey ensureHPKey(ISecureSecTentGrpHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecTentGrpHPKey) {
			return( (SecureBuffSecTentGrpHPKey)key );
		}
		else {
			SecureBuffSecTentGrpHPKey mapped = new SecureBuffSecTentGrpHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecTentGrpId( key.getRequiredSecTentGrpId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecTentGrpByTenantIdxKey newByTenantIdxKey() {
		ISecureSecTentGrpByTenantIdxKey key =
			new SecureBuffSecTentGrpByTenantIdxKey();
		return( key );
	}

	public SecureBuffSecTentGrpByTenantIdxKey ensureByTenantIdxKey(ISecureSecTentGrpByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecTentGrpByTenantIdxKey) {
			return( (SecureBuffSecTentGrpByTenantIdxKey)key );
		}
		else {
			SecureBuffSecTentGrpByTenantIdxKey mapped = new SecureBuffSecTentGrpByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecTentGrpByNameIdxKey newByNameIdxKey() {
		ISecureSecTentGrpByNameIdxKey key =
			new SecureBuffSecTentGrpByNameIdxKey();
		return( key );
	}

	public SecureBuffSecTentGrpByNameIdxKey ensureByNameIdxKey(ISecureSecTentGrpByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecTentGrpByNameIdxKey) {
			return( (SecureBuffSecTentGrpByNameIdxKey)key );
		}
		else {
			SecureBuffSecTentGrpByNameIdxKey mapped = new SecureBuffSecTentGrpByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecTentGrpByUNameIdxKey newByUNameIdxKey() {
		ISecureSecTentGrpByUNameIdxKey key =
			new SecureBuffSecTentGrpByUNameIdxKey();
		return( key );
	}

	public SecureBuffSecTentGrpByUNameIdxKey ensureByUNameIdxKey(ISecureSecTentGrpByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecTentGrpByUNameIdxKey) {
			return( (SecureBuffSecTentGrpByUNameIdxKey)key );
		}
		else {
			SecureBuffSecTentGrpByUNameIdxKey mapped = new SecureBuffSecTentGrpByUNameIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecTentGrp newRec() {
		ISecureSecTentGrp rec =
			new SecureBuffSecTentGrp();
		return( rec );
	}

	public SecureBuffSecTentGrp ensureRec(ISecureSecTentGrp rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecTentGrp) {
			return ((SecureBuffSecTentGrp)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecTentGrp.CLASS_CODE: {
					SecureBuffSecTentGrp mapped = new SecureBuffSecTentGrp();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecTentGrp",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecTentGrp");
			}
		}
	}

	@Override
	public ISecureSecTentGrpH newHRec() {
		ISecureSecTentGrpH hrec =
			new SecureBuffSecTentGrpH();
		return( hrec );
	}

	public SecureBuffSecTentGrpH ensureHRec(ISecureSecTentGrpH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecTentGrpH) {
			return ((SecureBuffSecTentGrpH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecTentGrp.CLASS_CODE: {
					SecureBuffSecTentGrpH mapped = new SecureBuffSecTentGrpH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecTentGrp",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecTentGrp");
			}
		}
	}
}
