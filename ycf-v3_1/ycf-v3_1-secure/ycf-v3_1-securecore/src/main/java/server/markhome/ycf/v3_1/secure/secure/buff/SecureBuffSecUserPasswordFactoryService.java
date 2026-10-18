
// Description: Java 25 Factory service implementation for SecUserPassword buffers

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
 *	Java 25 Factory service implementation for SecUserPassword buffers.
 */
@Service("secure31BuffSecUserPasswordFactoryService")
public class SecureBuffSecUserPasswordFactoryService
	implements ISecureSecUserPasswordFactory
{
	public SecureBuffSecUserPasswordFactoryService() {
	}

	@Override
	public ISecureSecUserPasswordHPKey newHPKey() {
		ISecureSecUserPasswordHPKey hpkey =
			new SecureBuffSecUserPasswordHPKey();
		return( hpkey );
	}

	public SecureBuffSecUserPasswordHPKey ensureHPKey(ISecureSecUserPasswordHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecUserPasswordHPKey) {
			return( (SecureBuffSecUserPasswordHPKey)key );
		}
		else {
			SecureBuffSecUserPasswordHPKey mapped = new SecureBuffSecUserPasswordHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserPasswordBySetStampIdxKey newBySetStampIdxKey() {
		ISecureSecUserPasswordBySetStampIdxKey key =
			new SecureBuffSecUserPasswordBySetStampIdxKey();
		return( key );
	}

	public SecureBuffSecUserPasswordBySetStampIdxKey ensureBySetStampIdxKey(ISecureSecUserPasswordBySetStampIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecUserPasswordBySetStampIdxKey) {
			return( (SecureBuffSecUserPasswordBySetStampIdxKey)key );
		}
		else {
			SecureBuffSecUserPasswordBySetStampIdxKey mapped = new SecureBuffSecUserPasswordBySetStampIdxKey();
			mapped.setRequiredPWSetStamp( key.getRequiredPWSetStamp() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserPassword newRec() {
		ISecureSecUserPassword rec =
			new SecureBuffSecUserPassword();
		return( rec );
	}

	public SecureBuffSecUserPassword ensureRec(ISecureSecUserPassword rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecUserPassword) {
			return ((SecureBuffSecUserPassword)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecUserPassword.CLASS_CODE: {
					SecureBuffSecUserPassword mapped = new SecureBuffSecUserPassword();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUserPassword",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUserPassword");
			}
		}
	}

	@Override
	public ISecureSecUserPasswordH newHRec() {
		ISecureSecUserPasswordH hrec =
			new SecureBuffSecUserPasswordH();
		return( hrec );
	}

	public SecureBuffSecUserPasswordH ensureHRec(ISecureSecUserPasswordH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecUserPasswordH) {
			return ((SecureBuffSecUserPasswordH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecUserPassword.CLASS_CODE: {
					SecureBuffSecUserPasswordH mapped = new SecureBuffSecUserPasswordH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUserPassword",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUserPassword");
			}
		}
	}
}
