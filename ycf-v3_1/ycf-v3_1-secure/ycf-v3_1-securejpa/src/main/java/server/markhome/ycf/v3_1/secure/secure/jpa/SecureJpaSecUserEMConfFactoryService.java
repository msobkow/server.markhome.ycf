
// Description: Java 25 Factory service implementation for SecUserEMConf JPA objects

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
 *	Java 25 Factory service implementation for SecUserEMConf JPA objects.
 */
public class SecureJpaSecUserEMConfFactoryService
    implements ISecureSecUserEMConfFactory
{
    public SecureJpaSecUserEMConfFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecUserEMConfHPKey newHPKey() {
        ISecureSecUserEMConfHPKey hpkey = new SecureJpaSecUserEMConfHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserEMConfHPKey ensureHPKey(ISecureSecUserEMConfHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecUserEMConfHPKey) {
			return( (SecureJpaSecUserEMConfHPKey)key );
		}
		else {
			SecureJpaSecUserEMConfHPKey mapped = new SecureJpaSecUserEMConfHPKey();
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
    public ISecureSecUserEMConfByUUuid6IdxKey newByUUuid6IdxKey() {
		ISecureSecUserEMConfByUUuid6IdxKey key = new SecureJpaSecUserEMConfByUUuid6IdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserEMConfByUUuid6IdxKey ensureByUUuid6IdxKey(ISecureSecUserEMConfByUUuid6IdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecUserEMConfByUUuid6IdxKey) {
			return( (SecureJpaSecUserEMConfByUUuid6IdxKey)key );
		}
		else {
			SecureJpaSecUserEMConfByUUuid6IdxKey mapped = new SecureJpaSecUserEMConfByUUuid6IdxKey();
			mapped.setRequiredEMConfirmationUuid6( key.getRequiredEMConfirmationUuid6() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecUserEMConfByConfEMAddrIdxKey newByConfEMAddrIdxKey() {
		ISecureSecUserEMConfByConfEMAddrIdxKey key = new SecureJpaSecUserEMConfByConfEMAddrIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserEMConfByConfEMAddrIdxKey ensureByConfEMAddrIdxKey(ISecureSecUserEMConfByConfEMAddrIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecUserEMConfByConfEMAddrIdxKey) {
			return( (SecureJpaSecUserEMConfByConfEMAddrIdxKey)key );
		}
		else {
			SecureJpaSecUserEMConfByConfEMAddrIdxKey mapped = new SecureJpaSecUserEMConfByConfEMAddrIdxKey();
			mapped.setRequiredConfirmEMailAddr( key.getRequiredConfirmEMailAddr() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecUserEMConfBySentStampIdxKey newBySentStampIdxKey() {
		ISecureSecUserEMConfBySentStampIdxKey key = new SecureJpaSecUserEMConfBySentStampIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserEMConfBySentStampIdxKey ensureBySentStampIdxKey(ISecureSecUserEMConfBySentStampIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecUserEMConfBySentStampIdxKey) {
			return( (SecureJpaSecUserEMConfBySentStampIdxKey)key );
		}
		else {
			SecureJpaSecUserEMConfBySentStampIdxKey mapped = new SecureJpaSecUserEMConfBySentStampIdxKey();
			mapped.setRequiredEMailSentStamp( key.getRequiredEMailSentStamp() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecUserEMConfByNewAcctIdxKey newByNewAcctIdxKey() {
		ISecureSecUserEMConfByNewAcctIdxKey key = new SecureJpaSecUserEMConfByNewAcctIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserEMConfByNewAcctIdxKey ensureByNewAcctIdxKey(ISecureSecUserEMConfByNewAcctIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecUserEMConfByNewAcctIdxKey) {
			return( (SecureJpaSecUserEMConfByNewAcctIdxKey)key );
		}
		else {
			SecureJpaSecUserEMConfByNewAcctIdxKey mapped = new SecureJpaSecUserEMConfByNewAcctIdxKey();
			mapped.setRequiredNewAccount( key.getRequiredNewAccount() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecUserEMConf newRec() {
        ISecureSecUserEMConf rec = new SecureJpaSecUserEMConf();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserEMConf ensureRec(ISecureSecUserEMConf rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecUserEMConf) {
			return( (SecureJpaSecUserEMConf)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecUserEMConf.CLASS_CODE: {
					SecureJpaSecUserEMConf mapped = new SecureJpaSecUserEMConf();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUserEMConf",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUserEMConf");
			}
		}
	}

    @Override
    public ISecureSecUserEMConfH newHRec() {
        ISecureSecUserEMConfH hrec = new SecureJpaSecUserEMConfH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserEMConfH ensureHRec(ISecureSecUserEMConfH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecUserEMConfH) {
			return( (SecureJpaSecUserEMConfH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecUserEMConf.CLASS_CODE: {
					SecureJpaSecUserEMConfH mapped = new SecureJpaSecUserEMConfH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUserEMConf",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUserEMConf");
			}
		}
	}
}
