
// Description: Java 25 Factory service implementation for SecClusRole JPA objects

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
 *	Java 25 Factory service implementation for SecClusRole JPA objects.
 */
public class SecureJpaSecClusRoleFactoryService
    implements ISecureSecClusRoleFactory
{
    public SecureJpaSecClusRoleFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusRoleHPKey newHPKey() {
        ISecureSecClusRoleHPKey hpkey = new SecureJpaSecClusRoleHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusRoleHPKey ensureHPKey(ISecureSecClusRoleHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecClusRoleHPKey) {
			return( (SecureJpaSecClusRoleHPKey)key );
		}
		else {
			SecureJpaSecClusRoleHPKey mapped = new SecureJpaSecClusRoleHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecClusRoleId( key.getRequiredSecClusRoleId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusRoleByClusterIdxKey newByClusterIdxKey() {
		ISecureSecClusRoleByClusterIdxKey key = new SecureJpaSecClusRoleByClusterIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusRoleByClusterIdxKey ensureByClusterIdxKey(ISecureSecClusRoleByClusterIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecClusRoleByClusterIdxKey) {
			return( (SecureJpaSecClusRoleByClusterIdxKey)key );
		}
		else {
			SecureJpaSecClusRoleByClusterIdxKey mapped = new SecureJpaSecClusRoleByClusterIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusRoleByNameIdxKey newByNameIdxKey() {
		ISecureSecClusRoleByNameIdxKey key = new SecureJpaSecClusRoleByNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusRoleByNameIdxKey ensureByNameIdxKey(ISecureSecClusRoleByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecClusRoleByNameIdxKey) {
			return( (SecureJpaSecClusRoleByNameIdxKey)key );
		}
		else {
			SecureJpaSecClusRoleByNameIdxKey mapped = new SecureJpaSecClusRoleByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusRoleByUNameIdxKey newByUNameIdxKey() {
		ISecureSecClusRoleByUNameIdxKey key = new SecureJpaSecClusRoleByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusRoleByUNameIdxKey ensureByUNameIdxKey(ISecureSecClusRoleByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecClusRoleByUNameIdxKey) {
			return( (SecureJpaSecClusRoleByUNameIdxKey)key );
		}
		else {
			SecureJpaSecClusRoleByUNameIdxKey mapped = new SecureJpaSecClusRoleByUNameIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusRole newRec() {
        ISecureSecClusRole rec = new SecureJpaSecClusRole();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusRole ensureRec(ISecureSecClusRole rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecClusRole) {
			return( (SecureJpaSecClusRole)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecClusRole.CLASS_CODE: {
					SecureJpaSecClusRole mapped = new SecureJpaSecClusRole();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecClusRole",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecClusRole");
			}
		}
	}

    @Override
    public ISecureSecClusRoleH newHRec() {
        ISecureSecClusRoleH hrec = new SecureJpaSecClusRoleH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusRoleH ensureHRec(ISecureSecClusRoleH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecClusRoleH) {
			return( (SecureJpaSecClusRoleH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecClusRole.CLASS_CODE: {
					SecureJpaSecClusRoleH mapped = new SecureJpaSecClusRoleH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecClusRole",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecClusRole");
			}
		}
	}
}
