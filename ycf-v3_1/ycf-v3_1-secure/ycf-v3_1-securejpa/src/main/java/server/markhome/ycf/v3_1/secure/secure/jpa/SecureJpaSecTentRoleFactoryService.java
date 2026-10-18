
// Description: Java 25 Factory service implementation for SecTentRole JPA objects

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
 *	Java 25 Factory service implementation for SecTentRole JPA objects.
 */
public class SecureJpaSecTentRoleFactoryService
    implements ISecureSecTentRoleFactory
{
    public SecureJpaSecTentRoleFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentRoleHPKey newHPKey() {
        ISecureSecTentRoleHPKey hpkey = new SecureJpaSecTentRoleHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentRoleHPKey ensureHPKey(ISecureSecTentRoleHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecTentRoleHPKey) {
			return( (SecureJpaSecTentRoleHPKey)key );
		}
		else {
			SecureJpaSecTentRoleHPKey mapped = new SecureJpaSecTentRoleHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecTentRoleId( key.getRequiredSecTentRoleId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentRoleByTenantIdxKey newByTenantIdxKey() {
		ISecureSecTentRoleByTenantIdxKey key = new SecureJpaSecTentRoleByTenantIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentRoleByTenantIdxKey ensureByTenantIdxKey(ISecureSecTentRoleByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecTentRoleByTenantIdxKey) {
			return( (SecureJpaSecTentRoleByTenantIdxKey)key );
		}
		else {
			SecureJpaSecTentRoleByTenantIdxKey mapped = new SecureJpaSecTentRoleByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentRoleByNameIdxKey newByNameIdxKey() {
		ISecureSecTentRoleByNameIdxKey key = new SecureJpaSecTentRoleByNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentRoleByNameIdxKey ensureByNameIdxKey(ISecureSecTentRoleByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecTentRoleByNameIdxKey) {
			return( (SecureJpaSecTentRoleByNameIdxKey)key );
		}
		else {
			SecureJpaSecTentRoleByNameIdxKey mapped = new SecureJpaSecTentRoleByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentRoleByUNameIdxKey newByUNameIdxKey() {
		ISecureSecTentRoleByUNameIdxKey key = new SecureJpaSecTentRoleByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentRoleByUNameIdxKey ensureByUNameIdxKey(ISecureSecTentRoleByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecTentRoleByUNameIdxKey) {
			return( (SecureJpaSecTentRoleByUNameIdxKey)key );
		}
		else {
			SecureJpaSecTentRoleByUNameIdxKey mapped = new SecureJpaSecTentRoleByUNameIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentRole newRec() {
        ISecureSecTentRole rec = new SecureJpaSecTentRole();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentRole ensureRec(ISecureSecTentRole rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecTentRole) {
			return( (SecureJpaSecTentRole)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecTentRole.CLASS_CODE: {
					SecureJpaSecTentRole mapped = new SecureJpaSecTentRole();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecTentRole",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecTentRole");
			}
		}
	}

    @Override
    public ISecureSecTentRoleH newHRec() {
        ISecureSecTentRoleH hrec = new SecureJpaSecTentRoleH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentRoleH ensureHRec(ISecureSecTentRoleH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecTentRoleH) {
			return( (SecureJpaSecTentRoleH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecTentRole.CLASS_CODE: {
					SecureJpaSecTentRoleH mapped = new SecureJpaSecTentRoleH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecTentRole",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecTentRole");
			}
		}
	}
}
