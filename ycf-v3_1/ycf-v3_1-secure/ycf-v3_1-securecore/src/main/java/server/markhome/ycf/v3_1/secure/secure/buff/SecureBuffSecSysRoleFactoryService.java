
// Description: Java 25 Factory service implementation for SecSysRole buffers

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
 *	Java 25 Factory service implementation for SecSysRole buffers.
 */
@Service("secure31BuffSecSysRoleFactoryService")
public class SecureBuffSecSysRoleFactoryService
	implements ISecureSecSysRoleFactory
{
	public SecureBuffSecSysRoleFactoryService() {
	}

	@Override
	public ISecureSecSysRoleHPKey newHPKey() {
		ISecureSecSysRoleHPKey hpkey =
			new SecureBuffSecSysRoleHPKey();
		return( hpkey );
	}

	public SecureBuffSecSysRoleHPKey ensureHPKey(ISecureSecSysRoleHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecSysRoleHPKey) {
			return( (SecureBuffSecSysRoleHPKey)key );
		}
		else {
			SecureBuffSecSysRoleHPKey mapped = new SecureBuffSecSysRoleHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysRoleByUNameIdxKey newByUNameIdxKey() {
		ISecureSecSysRoleByUNameIdxKey key =
			new SecureBuffSecSysRoleByUNameIdxKey();
		return( key );
	}

	public SecureBuffSecSysRoleByUNameIdxKey ensureByUNameIdxKey(ISecureSecSysRoleByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecSysRoleByUNameIdxKey) {
			return( (SecureBuffSecSysRoleByUNameIdxKey)key );
		}
		else {
			SecureBuffSecSysRoleByUNameIdxKey mapped = new SecureBuffSecSysRoleByUNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecSysRole newRec() {
		ISecureSecSysRole rec =
			new SecureBuffSecSysRole();
		return( rec );
	}

	public SecureBuffSecSysRole ensureRec(ISecureSecSysRole rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecSysRole) {
			return ((SecureBuffSecSysRole)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecSysRole.CLASS_CODE: {
					SecureBuffSecSysRole mapped = new SecureBuffSecSysRole();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysRole",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysRole");
			}
		}
	}

	@Override
	public ISecureSecSysRoleH newHRec() {
		ISecureSecSysRoleH hrec =
			new SecureBuffSecSysRoleH();
		return( hrec );
	}

	public SecureBuffSecSysRoleH ensureHRec(ISecureSecSysRoleH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecSysRoleH) {
			return ((SecureBuffSecSysRoleH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecSysRole.CLASS_CODE: {
					SecureBuffSecSysRoleH mapped = new SecureBuffSecSysRoleH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysRole",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysRole");
			}
		}
	}
}
