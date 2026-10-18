
// Description: Java 25 Factory service implementation for SecUserPWReset JPA objects

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

package server.markhome.ycf.v3_1.secure.secure.jpa;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.v3_1.secure.secure.*;

/*
 *	Java 25 Factory service implementation for SecUserPWReset JPA objects.
 */
public class SecureJpaSecUserPWResetFactoryService
    implements ISecureSecUserPWResetFactory
{
    public SecureJpaSecUserPWResetFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecUserPWResetHPKey newHPKey() {
        ISecureSecUserPWResetHPKey hpkey = new SecureJpaSecUserPWResetHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserPWResetHPKey ensureHPKey(ISecureSecUserPWResetHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecUserPWResetHPKey) {
			return( (SecureJpaSecUserPWResetHPKey)key );
		}
		else {
			SecureJpaSecUserPWResetHPKey mapped = new SecureJpaSecUserPWResetHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecUserId( key.getRequiredSecUserId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecUserPWResetByUUuid6IdxKey newByUUuid6IdxKey() {
		ISecureSecUserPWResetByUUuid6IdxKey key = new SecureJpaSecUserPWResetByUUuid6IdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserPWResetByUUuid6IdxKey ensureByUUuid6IdxKey(ISecureSecUserPWResetByUUuid6IdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecUserPWResetByUUuid6IdxKey) {
			return( (SecureJpaSecUserPWResetByUUuid6IdxKey)key );
		}
		else {
			SecureJpaSecUserPWResetByUUuid6IdxKey mapped = new SecureJpaSecUserPWResetByUUuid6IdxKey();
			mapped.setRequiredPasswordResetUuid6( key.getRequiredPasswordResetUuid6() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecUserPWResetBySentEMAddrIdxKey newBySentEMAddrIdxKey() {
		ISecureSecUserPWResetBySentEMAddrIdxKey key = new SecureJpaSecUserPWResetBySentEMAddrIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserPWResetBySentEMAddrIdxKey ensureBySentEMAddrIdxKey(ISecureSecUserPWResetBySentEMAddrIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecUserPWResetBySentEMAddrIdxKey) {
			return( (SecureJpaSecUserPWResetBySentEMAddrIdxKey)key );
		}
		else {
			SecureJpaSecUserPWResetBySentEMAddrIdxKey mapped = new SecureJpaSecUserPWResetBySentEMAddrIdxKey();
			mapped.setRequiredSentToEMailAddr( key.getRequiredSentToEMailAddr() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecUserPWResetByNewAcctIdxKey newByNewAcctIdxKey() {
		ISecureSecUserPWResetByNewAcctIdxKey key = new SecureJpaSecUserPWResetByNewAcctIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserPWResetByNewAcctIdxKey ensureByNewAcctIdxKey(ISecureSecUserPWResetByNewAcctIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecUserPWResetByNewAcctIdxKey) {
			return( (SecureJpaSecUserPWResetByNewAcctIdxKey)key );
		}
		else {
			SecureJpaSecUserPWResetByNewAcctIdxKey mapped = new SecureJpaSecUserPWResetByNewAcctIdxKey();
			mapped.setRequiredNewAccount( key.getRequiredNewAccount() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecUserPWReset newRec() {
        ISecureSecUserPWReset rec = new SecureJpaSecUserPWReset();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserPWReset ensureRec(ISecureSecUserPWReset rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecUserPWReset) {
			return( (SecureJpaSecUserPWReset)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecUserPWReset.CLASS_CODE: {
					SecureJpaSecUserPWReset mapped = new SecureJpaSecUserPWReset();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUserPWReset",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUserPWReset");
			}
		}
	}

    @Override
    public ISecureSecUserPWResetH newHRec() {
        ISecureSecUserPWResetH hrec = new SecureJpaSecUserPWResetH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserPWResetH ensureHRec(ISecureSecUserPWResetH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecUserPWResetH) {
			return( (SecureJpaSecUserPWResetH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecUserPWReset.CLASS_CODE: {
					SecureJpaSecUserPWResetH mapped = new SecureJpaSecUserPWResetH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUserPWReset",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUserPWReset");
			}
		}
	}
}
