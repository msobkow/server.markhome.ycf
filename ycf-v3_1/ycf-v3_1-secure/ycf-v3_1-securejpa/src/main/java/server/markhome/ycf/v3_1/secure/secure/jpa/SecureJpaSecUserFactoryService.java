
// Description: Java 25 Factory service implementation for SecUser JPA objects

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
 *	Java 25 Factory service implementation for SecUser JPA objects.
 */
public class SecureJpaSecUserFactoryService
    implements ISecureSecUserFactory
{
    public SecureJpaSecUserFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecUserHPKey newHPKey() {
        ISecureSecUserHPKey hpkey = new SecureJpaSecUserHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserHPKey ensureHPKey(ISecureSecUserHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecUserHPKey) {
			return( (SecureJpaSecUserHPKey)key );
		}
		else {
			SecureJpaSecUserHPKey mapped = new SecureJpaSecUserHPKey();
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
    public ISecureSecUserByULoginIdxKey newByULoginIdxKey() {
		ISecureSecUserByULoginIdxKey key = new SecureJpaSecUserByULoginIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserByULoginIdxKey ensureByULoginIdxKey(ISecureSecUserByULoginIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecUserByULoginIdxKey) {
			return( (SecureJpaSecUserByULoginIdxKey)key );
		}
		else {
			SecureJpaSecUserByULoginIdxKey mapped = new SecureJpaSecUserByULoginIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecUserByEMAddrIdxKey newByEMAddrIdxKey() {
		ISecureSecUserByEMAddrIdxKey key = new SecureJpaSecUserByEMAddrIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserByEMAddrIdxKey ensureByEMAddrIdxKey(ISecureSecUserByEMAddrIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecUserByEMAddrIdxKey) {
			return( (SecureJpaSecUserByEMAddrIdxKey)key );
		}
		else {
			SecureJpaSecUserByEMAddrIdxKey mapped = new SecureJpaSecUserByEMAddrIdxKey();
			mapped.setRequiredEMailAddress( key.getRequiredEMailAddress() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecUser newRec() {
        ISecureSecUser rec = new SecureJpaSecUser();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUser ensureRec(ISecureSecUser rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecUser) {
			return( (SecureJpaSecUser)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecUser.CLASS_CODE: {
					SecureJpaSecUser mapped = new SecureJpaSecUser();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUser",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecUser");
			}
		}
	}

    @Override
    public ISecureSecUserH newHRec() {
        ISecureSecUserH hrec = new SecureJpaSecUserH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecUserH ensureHRec(ISecureSecUserH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecUserH) {
			return( (SecureJpaSecUserH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecUser.CLASS_CODE: {
					SecureJpaSecUserH mapped = new SecureJpaSecUserH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUser",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecUser");
			}
		}
	}
}
