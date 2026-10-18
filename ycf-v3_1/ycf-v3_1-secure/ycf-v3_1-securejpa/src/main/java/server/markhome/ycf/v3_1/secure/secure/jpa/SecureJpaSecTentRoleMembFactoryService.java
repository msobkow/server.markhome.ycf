
// Description: Java 25 Factory service implementation for SecTentRoleMemb JPA objects

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
 *	Java 25 Factory service implementation for SecTentRoleMemb JPA objects.
 */
public class SecureJpaSecTentRoleMembFactoryService
    implements ISecureSecTentRoleMembFactory
{
    public SecureJpaSecTentRoleMembFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentRoleMembPKey newPKey() {
        ISecureSecTentRoleMembPKey pkey = new SecureJpaSecTentRoleMembPKey();
        return( pkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentRoleMembPKey ensurePKey(ISecureSecTentRoleMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecTentRoleMembPKey) {
			return( (SecureJpaSecTentRoleMembPKey)key );
		}
		else {
			SecureJpaSecTentRoleMembPKey mapped = new SecureJpaSecTentRoleMembPKey();
			mapped.setRequiredSecTentRoleId( key.getRequiredSecTentRoleId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentRoleMembHPKey newHPKey() {
        ISecureSecTentRoleMembHPKey hpkey = new SecureJpaSecTentRoleMembHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentRoleMembHPKey ensureHPKey(ISecureSecTentRoleMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecTentRoleMembHPKey) {
			return( (SecureJpaSecTentRoleMembHPKey)key );
		}
		else {
			SecureJpaSecTentRoleMembHPKey mapped = new SecureJpaSecTentRoleMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecTentRoleId( key.getRequiredSecTentRoleId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentRoleMembByTentRoleIdxKey newByTentRoleIdxKey() {
		ISecureSecTentRoleMembByTentRoleIdxKey key = new SecureJpaSecTentRoleMembByTentRoleIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentRoleMembByTentRoleIdxKey ensureByTentRoleIdxKey(ISecureSecTentRoleMembByTentRoleIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecTentRoleMembByTentRoleIdxKey) {
			return( (SecureJpaSecTentRoleMembByTentRoleIdxKey)key );
		}
		else {
			SecureJpaSecTentRoleMembByTentRoleIdxKey mapped = new SecureJpaSecTentRoleMembByTentRoleIdxKey();
			mapped.setRequiredSecTentRoleId( key.getRequiredSecTentRoleId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentRoleMembByUserIdxKey newByUserIdxKey() {
		ISecureSecTentRoleMembByUserIdxKey key = new SecureJpaSecTentRoleMembByUserIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentRoleMembByUserIdxKey ensureByUserIdxKey(ISecureSecTentRoleMembByUserIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecTentRoleMembByUserIdxKey) {
			return( (SecureJpaSecTentRoleMembByUserIdxKey)key );
		}
		else {
			SecureJpaSecTentRoleMembByUserIdxKey mapped = new SecureJpaSecTentRoleMembByUserIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentRoleMemb newRec() {
        ISecureSecTentRoleMemb rec = new SecureJpaSecTentRoleMemb();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentRoleMemb ensureRec(ISecureSecTentRoleMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecTentRoleMemb) {
			return( (SecureJpaSecTentRoleMemb)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecTentRoleMemb.CLASS_CODE: {
					SecureJpaSecTentRoleMemb mapped = new SecureJpaSecTentRoleMemb();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecTentRoleMemb",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecTentRoleMemb");
			}
		}
	}

    @Override
    public ISecureSecTentRoleMembH newHRec() {
        ISecureSecTentRoleMembH hrec = new SecureJpaSecTentRoleMembH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentRoleMembH ensureHRec(ISecureSecTentRoleMembH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecTentRoleMembH) {
			return( (SecureJpaSecTentRoleMembH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecTentRoleMemb.CLASS_CODE: {
					SecureJpaSecTentRoleMembH mapped = new SecureJpaSecTentRoleMembH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecTentRoleMemb",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecTentRoleMemb");
			}
		}
	}
}
