
// Description: Java 25 Factory service implementation for SecUserPWReset buffers

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
 *	Java 25 Factory service implementation for SecUserPWReset buffers.
 */
@Service("secure31BuffSecUserPWResetFactoryService")
public class SecureBuffSecUserPWResetFactoryService
	implements ISecureSecUserPWResetFactory
{
	public SecureBuffSecUserPWResetFactoryService() {
	}

	@Override
	public ISecureSecUserPWResetHPKey newHPKey() {
		ISecureSecUserPWResetHPKey hpkey =
			new SecureBuffSecUserPWResetHPKey();
		return( hpkey );
	}

	public SecureBuffSecUserPWResetHPKey ensureHPKey(ISecureSecUserPWResetHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecUserPWResetHPKey) {
			return( (SecureBuffSecUserPWResetHPKey)key );
		}
		else {
			SecureBuffSecUserPWResetHPKey mapped = new SecureBuffSecUserPWResetHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserPWResetByUUuid6IdxKey newByUUuid6IdxKey() {
		ISecureSecUserPWResetByUUuid6IdxKey key =
			new SecureBuffSecUserPWResetByUUuid6IdxKey();
		return( key );
	}

	public SecureBuffSecUserPWResetByUUuid6IdxKey ensureByUUuid6IdxKey(ISecureSecUserPWResetByUUuid6IdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecUserPWResetByUUuid6IdxKey) {
			return( (SecureBuffSecUserPWResetByUUuid6IdxKey)key );
		}
		else {
			SecureBuffSecUserPWResetByUUuid6IdxKey mapped = new SecureBuffSecUserPWResetByUUuid6IdxKey();
			mapped.setRequiredPasswordResetUuid6( key.getRequiredPasswordResetUuid6() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserPWResetBySentEMAddrIdxKey newBySentEMAddrIdxKey() {
		ISecureSecUserPWResetBySentEMAddrIdxKey key =
			new SecureBuffSecUserPWResetBySentEMAddrIdxKey();
		return( key );
	}

	public SecureBuffSecUserPWResetBySentEMAddrIdxKey ensureBySentEMAddrIdxKey(ISecureSecUserPWResetBySentEMAddrIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecUserPWResetBySentEMAddrIdxKey) {
			return( (SecureBuffSecUserPWResetBySentEMAddrIdxKey)key );
		}
		else {
			SecureBuffSecUserPWResetBySentEMAddrIdxKey mapped = new SecureBuffSecUserPWResetBySentEMAddrIdxKey();
			mapped.setRequiredSentToEMailAddr( key.getRequiredSentToEMailAddr() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserPWResetByNewAcctIdxKey newByNewAcctIdxKey() {
		ISecureSecUserPWResetByNewAcctIdxKey key =
			new SecureBuffSecUserPWResetByNewAcctIdxKey();
		return( key );
	}

	public SecureBuffSecUserPWResetByNewAcctIdxKey ensureByNewAcctIdxKey(ISecureSecUserPWResetByNewAcctIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecUserPWResetByNewAcctIdxKey) {
			return( (SecureBuffSecUserPWResetByNewAcctIdxKey)key );
		}
		else {
			SecureBuffSecUserPWResetByNewAcctIdxKey mapped = new SecureBuffSecUserPWResetByNewAcctIdxKey();
			mapped.setRequiredNewAccount( key.getRequiredNewAccount() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserPWReset newRec() {
		ISecureSecUserPWReset rec =
			new SecureBuffSecUserPWReset();
		return( rec );
	}

	public SecureBuffSecUserPWReset ensureRec(ISecureSecUserPWReset rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecUserPWReset) {
			return ((SecureBuffSecUserPWReset)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecUserPWReset.CLASS_CODE: {
					SecureBuffSecUserPWReset mapped = new SecureBuffSecUserPWReset();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUserPWReset",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUserPWReset");
			}
		}
	}

	@Override
	public ISecureSecUserPWResetH newHRec() {
		ISecureSecUserPWResetH hrec =
			new SecureBuffSecUserPWResetH();
		return( hrec );
	}

	public SecureBuffSecUserPWResetH ensureHRec(ISecureSecUserPWResetH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecUserPWResetH) {
			return ((SecureBuffSecUserPWResetH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecUserPWReset.CLASS_CODE: {
					SecureBuffSecUserPWResetH mapped = new SecureBuffSecUserPWResetH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUserPWReset",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUserPWReset");
			}
		}
	}
}
