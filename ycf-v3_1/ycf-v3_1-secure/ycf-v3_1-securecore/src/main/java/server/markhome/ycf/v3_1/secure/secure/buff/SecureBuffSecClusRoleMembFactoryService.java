
// Description: Java 25 Factory service implementation for SecClusRoleMemb buffers

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
 *	Java 25 Factory service implementation for SecClusRoleMemb buffers.
 */
@Service("secure31BuffSecClusRoleMembFactoryService")
public class SecureBuffSecClusRoleMembFactoryService
	implements ISecureSecClusRoleMembFactory
{
	public SecureBuffSecClusRoleMembFactoryService() {
	}

    @Override
    public ISecureSecClusRoleMembPKey newPKey() {
        ISecureSecClusRoleMembPKey pkey =
            new SecureBuffSecClusRoleMembPKey();
        return( pkey );
    }

	public SecureBuffSecClusRoleMembPKey ensurePKey(ISecureSecClusRoleMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecClusRoleMembPKey) {
			return( (SecureBuffSecClusRoleMembPKey)key );
		}
		else {
			SecureBuffSecClusRoleMembPKey mapped = new SecureBuffSecClusRoleMembPKey();
			mapped.setRequiredSecClusRoleId( key.getRequiredSecClusRoleId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecClusRoleMembHPKey newHPKey() {
		ISecureSecClusRoleMembHPKey hpkey =
			new SecureBuffSecClusRoleMembHPKey();
		return( hpkey );
	}

	public SecureBuffSecClusRoleMembHPKey ensureHPKey(ISecureSecClusRoleMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecClusRoleMembHPKey) {
			return( (SecureBuffSecClusRoleMembHPKey)key );
		}
		else {
			SecureBuffSecClusRoleMembHPKey mapped = new SecureBuffSecClusRoleMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecClusRoleId( key.getRequiredSecClusRoleId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecClusRoleMembByClusRoleIdxKey newByClusRoleIdxKey() {
		ISecureSecClusRoleMembByClusRoleIdxKey key =
			new SecureBuffSecClusRoleMembByClusRoleIdxKey();
		return( key );
	}

	public SecureBuffSecClusRoleMembByClusRoleIdxKey ensureByClusRoleIdxKey(ISecureSecClusRoleMembByClusRoleIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecClusRoleMembByClusRoleIdxKey) {
			return( (SecureBuffSecClusRoleMembByClusRoleIdxKey)key );
		}
		else {
			SecureBuffSecClusRoleMembByClusRoleIdxKey mapped = new SecureBuffSecClusRoleMembByClusRoleIdxKey();
			mapped.setRequiredSecClusRoleId( key.getRequiredSecClusRoleId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecClusRoleMembByLoginIdxKey newByLoginIdxKey() {
		ISecureSecClusRoleMembByLoginIdxKey key =
			new SecureBuffSecClusRoleMembByLoginIdxKey();
		return( key );
	}

	public SecureBuffSecClusRoleMembByLoginIdxKey ensureByLoginIdxKey(ISecureSecClusRoleMembByLoginIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecClusRoleMembByLoginIdxKey) {
			return( (SecureBuffSecClusRoleMembByLoginIdxKey)key );
		}
		else {
			SecureBuffSecClusRoleMembByLoginIdxKey mapped = new SecureBuffSecClusRoleMembByLoginIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecClusRoleMemb newRec() {
		ISecureSecClusRoleMemb rec =
			new SecureBuffSecClusRoleMemb();
		return( rec );
	}

	public SecureBuffSecClusRoleMemb ensureRec(ISecureSecClusRoleMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecClusRoleMemb) {
			return ((SecureBuffSecClusRoleMemb)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecClusRoleMemb.CLASS_CODE: {
					SecureBuffSecClusRoleMemb mapped = new SecureBuffSecClusRoleMemb();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecClusRoleMemb",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecClusRoleMemb");
			}
		}
	}

	@Override
	public ISecureSecClusRoleMembH newHRec() {
		ISecureSecClusRoleMembH hrec =
			new SecureBuffSecClusRoleMembH();
		return( hrec );
	}

	public SecureBuffSecClusRoleMembH ensureHRec(ISecureSecClusRoleMembH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecClusRoleMembH) {
			return ((SecureBuffSecClusRoleMembH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecClusRoleMemb.CLASS_CODE: {
					SecureBuffSecClusRoleMembH mapped = new SecureBuffSecClusRoleMembH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecClusRoleMemb",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecClusRoleMemb");
			}
		}
	}
}
