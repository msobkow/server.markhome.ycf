
// Description: Java 25 Factory service implementation for SecTentGrp JPA objects

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
 *	Java 25 Factory service implementation for SecTentGrp JPA objects.
 */
public class SecureJpaSecTentGrpFactoryService
    implements ISecureSecTentGrpFactory
{
    public SecureJpaSecTentGrpFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentGrpHPKey newHPKey() {
        ISecureSecTentGrpHPKey hpkey = new SecureJpaSecTentGrpHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentGrpHPKey ensureHPKey(ISecureSecTentGrpHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecTentGrpHPKey) {
			return( (SecureJpaSecTentGrpHPKey)key );
		}
		else {
			SecureJpaSecTentGrpHPKey mapped = new SecureJpaSecTentGrpHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecTentGrpId( key.getRequiredSecTentGrpId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentGrpByTenantIdxKey newByTenantIdxKey() {
		ISecureSecTentGrpByTenantIdxKey key = new SecureJpaSecTentGrpByTenantIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentGrpByTenantIdxKey ensureByTenantIdxKey(ISecureSecTentGrpByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecTentGrpByTenantIdxKey) {
			return( (SecureJpaSecTentGrpByTenantIdxKey)key );
		}
		else {
			SecureJpaSecTentGrpByTenantIdxKey mapped = new SecureJpaSecTentGrpByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentGrpByNameIdxKey newByNameIdxKey() {
		ISecureSecTentGrpByNameIdxKey key = new SecureJpaSecTentGrpByNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentGrpByNameIdxKey ensureByNameIdxKey(ISecureSecTentGrpByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecTentGrpByNameIdxKey) {
			return( (SecureJpaSecTentGrpByNameIdxKey)key );
		}
		else {
			SecureJpaSecTentGrpByNameIdxKey mapped = new SecureJpaSecTentGrpByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentGrpByUNameIdxKey newByUNameIdxKey() {
		ISecureSecTentGrpByUNameIdxKey key = new SecureJpaSecTentGrpByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentGrpByUNameIdxKey ensureByUNameIdxKey(ISecureSecTentGrpByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecTentGrpByUNameIdxKey) {
			return( (SecureJpaSecTentGrpByUNameIdxKey)key );
		}
		else {
			SecureJpaSecTentGrpByUNameIdxKey mapped = new SecureJpaSecTentGrpByUNameIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentGrp newRec() {
        ISecureSecTentGrp rec = new SecureJpaSecTentGrp();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentGrp ensureRec(ISecureSecTentGrp rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecTentGrp) {
			return( (SecureJpaSecTentGrp)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecTentGrp.CLASS_CODE: {
					SecureJpaSecTentGrp mapped = new SecureJpaSecTentGrp();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecTentGrp",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecTentGrp");
			}
		}
	}

    @Override
    public ISecureSecTentGrpH newHRec() {
        ISecureSecTentGrpH hrec = new SecureJpaSecTentGrpH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentGrpH ensureHRec(ISecureSecTentGrpH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecTentGrpH) {
			return( (SecureJpaSecTentGrpH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecTentGrp.CLASS_CODE: {
					SecureJpaSecTentGrpH mapped = new SecureJpaSecTentGrpH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecTentGrp",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecTentGrp");
			}
		}
	}
}
