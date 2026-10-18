
// Description: Java 25 Factory service implementation for SecClusRoleMemb JPA objects

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
 *	Java 25 Factory service implementation for SecClusRoleMemb JPA objects.
 */
public class SecureJpaSecClusRoleMembFactoryService
    implements ISecureSecClusRoleMembFactory
{
    public SecureJpaSecClusRoleMembFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusRoleMembPKey newPKey() {
        ISecureSecClusRoleMembPKey pkey = new SecureJpaSecClusRoleMembPKey();
        return( pkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusRoleMembPKey ensurePKey(ISecureSecClusRoleMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecClusRoleMembPKey) {
			return( (SecureJpaSecClusRoleMembPKey)key );
		}
		else {
			SecureJpaSecClusRoleMembPKey mapped = new SecureJpaSecClusRoleMembPKey();
			mapped.setRequiredSecClusRoleId( key.getRequiredSecClusRoleId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusRoleMembHPKey newHPKey() {
        ISecureSecClusRoleMembHPKey hpkey = new SecureJpaSecClusRoleMembHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusRoleMembHPKey ensureHPKey(ISecureSecClusRoleMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecClusRoleMembHPKey) {
			return( (SecureJpaSecClusRoleMembHPKey)key );
		}
		else {
			SecureJpaSecClusRoleMembHPKey mapped = new SecureJpaSecClusRoleMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecClusRoleId( key.getRequiredSecClusRoleId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusRoleMembByClusRoleIdxKey newByClusRoleIdxKey() {
		ISecureSecClusRoleMembByClusRoleIdxKey key = new SecureJpaSecClusRoleMembByClusRoleIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusRoleMembByClusRoleIdxKey ensureByClusRoleIdxKey(ISecureSecClusRoleMembByClusRoleIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecClusRoleMembByClusRoleIdxKey) {
			return( (SecureJpaSecClusRoleMembByClusRoleIdxKey)key );
		}
		else {
			SecureJpaSecClusRoleMembByClusRoleIdxKey mapped = new SecureJpaSecClusRoleMembByClusRoleIdxKey();
			mapped.setRequiredSecClusRoleId( key.getRequiredSecClusRoleId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusRoleMembByLoginIdxKey newByLoginIdxKey() {
		ISecureSecClusRoleMembByLoginIdxKey key = new SecureJpaSecClusRoleMembByLoginIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusRoleMembByLoginIdxKey ensureByLoginIdxKey(ISecureSecClusRoleMembByLoginIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecClusRoleMembByLoginIdxKey) {
			return( (SecureJpaSecClusRoleMembByLoginIdxKey)key );
		}
		else {
			SecureJpaSecClusRoleMembByLoginIdxKey mapped = new SecureJpaSecClusRoleMembByLoginIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusRoleMemb newRec() {
        ISecureSecClusRoleMemb rec = new SecureJpaSecClusRoleMemb();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusRoleMemb ensureRec(ISecureSecClusRoleMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecClusRoleMemb) {
			return( (SecureJpaSecClusRoleMemb)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecClusRoleMemb.CLASS_CODE: {
					SecureJpaSecClusRoleMemb mapped = new SecureJpaSecClusRoleMemb();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecClusRoleMemb",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecClusRoleMemb");
			}
		}
	}

    @Override
    public ISecureSecClusRoleMembH newHRec() {
        ISecureSecClusRoleMembH hrec = new SecureJpaSecClusRoleMembH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusRoleMembH ensureHRec(ISecureSecClusRoleMembH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecClusRoleMembH) {
			return( (SecureJpaSecClusRoleMembH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecClusRoleMemb.CLASS_CODE: {
					SecureJpaSecClusRoleMembH mapped = new SecureJpaSecClusRoleMembH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecClusRoleMemb",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecClusRoleMemb");
			}
		}
	}
}
