
// Description: Java 25 Factory service implementation for SecSysRoleMemb buffers

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
 *	Java 25 Factory service implementation for SecSysRoleMemb buffers.
 */
@Service("secure31BuffSecSysRoleMembFactoryService")
public class SecureBuffSecSysRoleMembFactoryService
	implements ISecureSecSysRoleMembFactory
{
	public SecureBuffSecSysRoleMembFactoryService() {
	}

    @Override
    public ISecureSecSysRoleMembPKey newPKey() {
        ISecureSecSysRoleMembPKey pkey =
            new SecureBuffSecSysRoleMembPKey();
        return( pkey );
    }

	public SecureBuffSecSysRoleMembPKey ensurePKey(ISecureSecSysRoleMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSysRoleMembPKey) {
			return( (SecureBuffSecSysRoleMembPKey)key );
		}
		else {
			SecureBuffSecSysRoleMembPKey mapped = new SecureBuffSecSysRoleMembPKey();
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysRoleMembHPKey newHPKey() {
		ISecureSecSysRoleMembHPKey hpkey =
			new SecureBuffSecSysRoleMembHPKey();
		return( hpkey );
	}

	public SecureBuffSecSysRoleMembHPKey ensureHPKey(ISecureSecSysRoleMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecSysRoleMembHPKey) {
			return( (SecureBuffSecSysRoleMembHPKey)key );
		}
		else {
			SecureBuffSecSysRoleMembHPKey mapped = new SecureBuffSecSysRoleMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysRoleMembBySysRoleIdxKey newBySysRoleIdxKey() {
		ISecureSecSysRoleMembBySysRoleIdxKey key =
			new SecureBuffSecSysRoleMembBySysRoleIdxKey();
		return( key );
	}

	public SecureBuffSecSysRoleMembBySysRoleIdxKey ensureBySysRoleIdxKey(ISecureSecSysRoleMembBySysRoleIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSysRoleMembBySysRoleIdxKey) {
			return( (SecureBuffSecSysRoleMembBySysRoleIdxKey)key );
		}
		else {
			SecureBuffSecSysRoleMembBySysRoleIdxKey mapped = new SecureBuffSecSysRoleMembBySysRoleIdxKey();
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysRoleMembByLoginIdxKey newByLoginIdxKey() {
		ISecureSecSysRoleMembByLoginIdxKey key =
			new SecureBuffSecSysRoleMembByLoginIdxKey();
		return( key );
	}

	public SecureBuffSecSysRoleMembByLoginIdxKey ensureByLoginIdxKey(ISecureSecSysRoleMembByLoginIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSysRoleMembByLoginIdxKey) {
			return( (SecureBuffSecSysRoleMembByLoginIdxKey)key );
		}
		else {
			SecureBuffSecSysRoleMembByLoginIdxKey mapped = new SecureBuffSecSysRoleMembByLoginIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysRoleMemb newRec() {
		ISecureSecSysRoleMemb rec =
			new SecureBuffSecSysRoleMemb();
		return( rec );
	}

	public SecureBuffSecSysRoleMemb ensureRec(ISecureSecSysRoleMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecSysRoleMemb) {
			return ((SecureBuffSecSysRoleMemb)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecSysRoleMemb.CLASS_CODE: {
					SecureBuffSecSysRoleMemb mapped = new SecureBuffSecSysRoleMemb();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysRoleMemb",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysRoleMemb");
			}
		}
	}

	@Override
	public ISecureSecSysRoleMembH newHRec() {
		ISecureSecSysRoleMembH hrec =
			new SecureBuffSecSysRoleMembH();
		return( hrec );
	}

	public SecureBuffSecSysRoleMembH ensureHRec(ISecureSecSysRoleMembH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecSysRoleMembH) {
			return ((SecureBuffSecSysRoleMembH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecSysRoleMemb.CLASS_CODE: {
					SecureBuffSecSysRoleMembH mapped = new SecureBuffSecSysRoleMembH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysRoleMemb",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysRoleMemb");
			}
		}
	}
}
