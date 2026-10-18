
// Description: Java 25 Factory service implementation for SecUserEMConf buffers

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
 *	Java 25 Factory service implementation for SecUserEMConf buffers.
 */
@Service("secure31BuffSecUserEMConfFactoryService")
public class SecureBuffSecUserEMConfFactoryService
	implements ISecureSecUserEMConfFactory
{
	public SecureBuffSecUserEMConfFactoryService() {
	}

	@Override
	public ISecureSecUserEMConfHPKey newHPKey() {
		ISecureSecUserEMConfHPKey hpkey =
			new SecureBuffSecUserEMConfHPKey();
		return( hpkey );
	}

	public SecureBuffSecUserEMConfHPKey ensureHPKey(ISecureSecUserEMConfHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffSecUserEMConfHPKey) {
			return( (SecureBuffSecUserEMConfHPKey)key );
		}
		else {
			SecureBuffSecUserEMConfHPKey mapped = new SecureBuffSecUserEMConfHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserEMConfByUUuid6IdxKey newByUUuid6IdxKey() {
		ISecureSecUserEMConfByUUuid6IdxKey key =
			new SecureBuffSecUserEMConfByUUuid6IdxKey();
		return( key );
	}

	public SecureBuffSecUserEMConfByUUuid6IdxKey ensureByUUuid6IdxKey(ISecureSecUserEMConfByUUuid6IdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecUserEMConfByUUuid6IdxKey) {
			return( (SecureBuffSecUserEMConfByUUuid6IdxKey)key );
		}
		else {
			SecureBuffSecUserEMConfByUUuid6IdxKey mapped = new SecureBuffSecUserEMConfByUUuid6IdxKey();
			mapped.setRequiredEMConfirmationUuid6( key.getRequiredEMConfirmationUuid6() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserEMConfByConfEMAddrIdxKey newByConfEMAddrIdxKey() {
		ISecureSecUserEMConfByConfEMAddrIdxKey key =
			new SecureBuffSecUserEMConfByConfEMAddrIdxKey();
		return( key );
	}

	public SecureBuffSecUserEMConfByConfEMAddrIdxKey ensureByConfEMAddrIdxKey(ISecureSecUserEMConfByConfEMAddrIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecUserEMConfByConfEMAddrIdxKey) {
			return( (SecureBuffSecUserEMConfByConfEMAddrIdxKey)key );
		}
		else {
			SecureBuffSecUserEMConfByConfEMAddrIdxKey mapped = new SecureBuffSecUserEMConfByConfEMAddrIdxKey();
			mapped.setRequiredConfirmEMailAddr( key.getRequiredConfirmEMailAddr() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserEMConfBySentStampIdxKey newBySentStampIdxKey() {
		ISecureSecUserEMConfBySentStampIdxKey key =
			new SecureBuffSecUserEMConfBySentStampIdxKey();
		return( key );
	}

	public SecureBuffSecUserEMConfBySentStampIdxKey ensureBySentStampIdxKey(ISecureSecUserEMConfBySentStampIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecUserEMConfBySentStampIdxKey) {
			return( (SecureBuffSecUserEMConfBySentStampIdxKey)key );
		}
		else {
			SecureBuffSecUserEMConfBySentStampIdxKey mapped = new SecureBuffSecUserEMConfBySentStampIdxKey();
			mapped.setRequiredEMailSentStamp( key.getRequiredEMailSentStamp() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserEMConfByNewAcctIdxKey newByNewAcctIdxKey() {
		ISecureSecUserEMConfByNewAcctIdxKey key =
			new SecureBuffSecUserEMConfByNewAcctIdxKey();
		return( key );
	}

	public SecureBuffSecUserEMConfByNewAcctIdxKey ensureByNewAcctIdxKey(ISecureSecUserEMConfByNewAcctIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffSecUserEMConfByNewAcctIdxKey) {
			return( (SecureBuffSecUserEMConfByNewAcctIdxKey)key );
		}
		else {
			SecureBuffSecUserEMConfByNewAcctIdxKey mapped = new SecureBuffSecUserEMConfByNewAcctIdxKey();
			mapped.setRequiredNewAccount( key.getRequiredNewAccount() );
			return( mapped );
		}
	}

	@Override
	public ISecureSecUserEMConf newRec() {
		ISecureSecUserEMConf rec =
			new SecureBuffSecUserEMConf();
		return( rec );
	}

	public SecureBuffSecUserEMConf ensureRec(ISecureSecUserEMConf rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffSecUserEMConf) {
			return ((SecureBuffSecUserEMConf)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureSecUserEMConf.CLASS_CODE: {
					SecureBuffSecUserEMConf mapped = new SecureBuffSecUserEMConf();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUserEMConf",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUserEMConf");
			}
		}
	}

	@Override
	public ISecureSecUserEMConfH newHRec() {
		ISecureSecUserEMConfH hrec =
			new SecureBuffSecUserEMConfH();
		return( hrec );
	}

	public SecureBuffSecUserEMConfH ensureHRec(ISecureSecUserEMConfH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffSecUserEMConfH) {
			return ((SecureBuffSecUserEMConfH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureSecUserEMConf.CLASS_CODE: {
					SecureBuffSecUserEMConfH mapped = new SecureBuffSecUserEMConfH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUserEMConf",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUserEMConf");
			}
		}
	}
}
