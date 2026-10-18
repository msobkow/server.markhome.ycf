
// Description: Java 25 Factory service implementation for SecTentRoleMemb buffers

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
 *	Java 25 Factory service implementation for SecTentRoleMemb buffers.
 */
@Service("secure31BuffSecTentRoleMembFactoryService")
public class SecureBuffSecTentRoleMembFactoryService
	implements ISecureSecTentRoleMembFactory
{
	public SecureBuffSecTentRoleMembFactoryService() {
	}

    @Override
    public ISecureSecTentRoleMembPKey newPKey() {
        ISecureSecTentRoleMembPKey pkey =
            new SecureBuffSecTentRoleMembPKey();
        return( pkey );
    }

	public SecureBuffSecTentRoleMembPKey ensurePKey(ISecureSecTentRoleMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecTentRoleMembPKey) {
			return( (SecureBuffSecTentRoleMembPKey)key );
		}
		else {
			SecureBuffSecTentRoleMembPKey mapped = new SecureBuffSecTentRoleMembPKey();
			mapped.setRequiredSecTentRoleId( key.getRequiredSecTentRoleId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecTentRoleMembHPKey newHPKey() {
		ISecureSecTentRoleMembHPKey hpkey =
			new SecureBuffSecTentRoleMembHPKey();
		return( hpkey );
	}

	public SecureBuffSecTentRoleMembHPKey ensureHPKey(ISecureSecTentRoleMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecTentRoleMembHPKey) {
			return( (SecureBuffSecTentRoleMembHPKey)key );
		}
		else {
			SecureBuffSecTentRoleMembHPKey mapped = new SecureBuffSecTentRoleMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecTentRoleId( key.getRequiredSecTentRoleId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecTentRoleMembByTentRoleIdxKey newByTentRoleIdxKey() {
		ISecureSecTentRoleMembByTentRoleIdxKey key =
			new SecureBuffSecTentRoleMembByTentRoleIdxKey();
		return( key );
	}

	public SecureBuffSecTentRoleMembByTentRoleIdxKey ensureByTentRoleIdxKey(ISecureSecTentRoleMembByTentRoleIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecTentRoleMembByTentRoleIdxKey) {
			return( (SecureBuffSecTentRoleMembByTentRoleIdxKey)key );
		}
		else {
			SecureBuffSecTentRoleMembByTentRoleIdxKey mapped = new SecureBuffSecTentRoleMembByTentRoleIdxKey();
			mapped.setRequiredSecTentRoleId( key.getRequiredSecTentRoleId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecTentRoleMembByUserIdxKey newByUserIdxKey() {
		ISecureSecTentRoleMembByUserIdxKey key =
			new SecureBuffSecTentRoleMembByUserIdxKey();
		return( key );
	}

	public SecureBuffSecTentRoleMembByUserIdxKey ensureByUserIdxKey(ISecureSecTentRoleMembByUserIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecTentRoleMembByUserIdxKey) {
			return( (SecureBuffSecTentRoleMembByUserIdxKey)key );
		}
		else {
			SecureBuffSecTentRoleMembByUserIdxKey mapped = new SecureBuffSecTentRoleMembByUserIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecTentRoleMemb newRec() {
		ISecureSecTentRoleMemb rec =
			new SecureBuffSecTentRoleMemb();
		return( rec );
	}

	public SecureBuffSecTentRoleMemb ensureRec(ISecureSecTentRoleMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecTentRoleMemb) {
			return ((SecureBuffSecTentRoleMemb)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecTentRoleMemb.CLASS_CODE: {
					SecureBuffSecTentRoleMemb mapped = new SecureBuffSecTentRoleMemb();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecTentRoleMemb",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecTentRoleMemb");
			}
		}
	}

	@Override
	public ISecureSecTentRoleMembH newHRec() {
		ISecureSecTentRoleMembH hrec =
			new SecureBuffSecTentRoleMembH();
		return( hrec );
	}

	public SecureBuffSecTentRoleMembH ensureHRec(ISecureSecTentRoleMembH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecTentRoleMembH) {
			return ((SecureBuffSecTentRoleMembH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecTentRoleMemb.CLASS_CODE: {
					SecureBuffSecTentRoleMembH mapped = new SecureBuffSecTentRoleMembH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecTentRoleMemb",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecTentRoleMemb");
			}
		}
	}
}
