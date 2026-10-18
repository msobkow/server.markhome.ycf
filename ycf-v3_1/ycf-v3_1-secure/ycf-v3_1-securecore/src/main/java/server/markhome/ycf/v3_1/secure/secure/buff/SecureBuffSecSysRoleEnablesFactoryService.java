
// Description: Java 25 Factory service implementation for SecSysRoleEnables buffers

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
 *	Java 25 Factory service implementation for SecSysRoleEnables buffers.
 */
@Service("secure31BuffSecSysRoleEnablesFactoryService")
public class SecureBuffSecSysRoleEnablesFactoryService
	implements ISecureSecSysRoleEnablesFactory
{
	public SecureBuffSecSysRoleEnablesFactoryService() {
	}

    @Override
    public ISecureSecSysRoleEnablesPKey newPKey() {
        ISecureSecSysRoleEnablesPKey pkey =
            new SecureBuffSecSysRoleEnablesPKey();
        return( pkey );
    }

	public SecureBuffSecSysRoleEnablesPKey ensurePKey(ISecureSecSysRoleEnablesPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSysRoleEnablesPKey) {
			return( (SecureBuffSecSysRoleEnablesPKey)key );
		}
		else {
			SecureBuffSecSysRoleEnablesPKey mapped = new SecureBuffSecSysRoleEnablesPKey();
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			mapped.setRequiredEnableName( key.getRequiredEnableName() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysRoleEnablesHPKey newHPKey() {
		ISecureSecSysRoleEnablesHPKey hpkey =
			new SecureBuffSecSysRoleEnablesHPKey();
		return( hpkey );
	}

	public SecureBuffSecSysRoleEnablesHPKey ensureHPKey(ISecureSecSysRoleEnablesHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecSysRoleEnablesHPKey) {
			return( (SecureBuffSecSysRoleEnablesHPKey)key );
		}
		else {
			SecureBuffSecSysRoleEnablesHPKey mapped = new SecureBuffSecSysRoleEnablesHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			mapped.setRequiredEnableName( key.getRequiredEnableName() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysRoleEnablesBySysRoleIdxKey newBySysRoleIdxKey() {
		ISecureSecSysRoleEnablesBySysRoleIdxKey key =
			new SecureBuffSecSysRoleEnablesBySysRoleIdxKey();
		return( key );
	}

	public SecureBuffSecSysRoleEnablesBySysRoleIdxKey ensureBySysRoleIdxKey(ISecureSecSysRoleEnablesBySysRoleIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSysRoleEnablesBySysRoleIdxKey) {
			return( (SecureBuffSecSysRoleEnablesBySysRoleIdxKey)key );
		}
		else {
			SecureBuffSecSysRoleEnablesBySysRoleIdxKey mapped = new SecureBuffSecSysRoleEnablesBySysRoleIdxKey();
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysRoleEnablesByNameIdxKey newByNameIdxKey() {
		ISecureSecSysRoleEnablesByNameIdxKey key =
			new SecureBuffSecSysRoleEnablesByNameIdxKey();
		return( key );
	}

	public SecureBuffSecSysRoleEnablesByNameIdxKey ensureByNameIdxKey(ISecureSecSysRoleEnablesByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSysRoleEnablesByNameIdxKey) {
			return( (SecureBuffSecSysRoleEnablesByNameIdxKey)key );
		}
		else {
			SecureBuffSecSysRoleEnablesByNameIdxKey mapped = new SecureBuffSecSysRoleEnablesByNameIdxKey();
			mapped.setRequiredEnableName( key.getRequiredEnableName() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysRoleEnables newRec() {
		ISecureSecSysRoleEnables rec =
			new SecureBuffSecSysRoleEnables();
		return( rec );
	}

	public SecureBuffSecSysRoleEnables ensureRec(ISecureSecSysRoleEnables rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecSysRoleEnables) {
			return ((SecureBuffSecSysRoleEnables)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecSysRoleEnables.CLASS_CODE: {
					SecureBuffSecSysRoleEnables mapped = new SecureBuffSecSysRoleEnables();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysRoleEnables",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysRoleEnables");
			}
		}
	}

	@Override
	public ISecureSecSysRoleEnablesH newHRec() {
		ISecureSecSysRoleEnablesH hrec =
			new SecureBuffSecSysRoleEnablesH();
		return( hrec );
	}

	public SecureBuffSecSysRoleEnablesH ensureHRec(ISecureSecSysRoleEnablesH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecSysRoleEnablesH) {
			return ((SecureBuffSecSysRoleEnablesH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecSysRoleEnables.CLASS_CODE: {
					SecureBuffSecSysRoleEnablesH mapped = new SecureBuffSecSysRoleEnablesH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysRoleEnables",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysRoleEnables");
			}
		}
	}
}
