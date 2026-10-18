
// Description: Java 25 Factory service implementation for SecUserPassword JPA objects

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
 *	Java 25 Factory service implementation for SecUserPassword JPA objects.
 */
public class SecureJpaSecUserPasswordFactoryService
    implements ISecureSecUserPasswordFactory
{
    public SecureJpaSecUserPasswordFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecUserPasswordHPKey newHPKey() {
        ISecureSecUserPasswordHPKey hpkey = new SecureJpaSecUserPasswordHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserPasswordHPKey ensureHPKey(ISecureSecUserPasswordHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecUserPasswordHPKey) {
			return( (SecureJpaSecUserPasswordHPKey)key );
		}
		else {
			SecureJpaSecUserPasswordHPKey mapped = new SecureJpaSecUserPasswordHPKey();
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
    public ISecureSecUserPasswordBySetStampIdxKey newBySetStampIdxKey() {
		ISecureSecUserPasswordBySetStampIdxKey key = new SecureJpaSecUserPasswordBySetStampIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserPasswordBySetStampIdxKey ensureBySetStampIdxKey(ISecureSecUserPasswordBySetStampIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecUserPasswordBySetStampIdxKey) {
			return( (SecureJpaSecUserPasswordBySetStampIdxKey)key );
		}
		else {
			SecureJpaSecUserPasswordBySetStampIdxKey mapped = new SecureJpaSecUserPasswordBySetStampIdxKey();
			mapped.setRequiredPWSetStamp( key.getRequiredPWSetStamp() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecUserPassword newRec() {
        ISecureSecUserPassword rec = new SecureJpaSecUserPassword();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserPassword ensureRec(ISecureSecUserPassword rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecUserPassword) {
			return( (SecureJpaSecUserPassword)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecUserPassword.CLASS_CODE: {
					SecureJpaSecUserPassword mapped = new SecureJpaSecUserPassword();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUserPassword",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUserPassword");
			}
		}
	}

    @Override
    public ISecureSecUserPasswordH newHRec() {
        ISecureSecUserPasswordH hrec = new SecureJpaSecUserPasswordH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserPasswordH ensureHRec(ISecureSecUserPasswordH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecUserPasswordH) {
			return( (SecureJpaSecUserPasswordH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecUserPassword.CLASS_CODE: {
					SecureJpaSecUserPasswordH mapped = new SecureJpaSecUserPasswordH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUserPassword",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUserPassword");
			}
		}
	}
}
