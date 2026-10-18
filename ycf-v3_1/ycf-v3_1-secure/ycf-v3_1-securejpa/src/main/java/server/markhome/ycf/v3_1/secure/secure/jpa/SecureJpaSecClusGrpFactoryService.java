
// Description: Java 25 Factory service implementation for SecClusGrp JPA objects

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
 *	Java 25 Factory service implementation for SecClusGrp JPA objects.
 */
public class SecureJpaSecClusGrpFactoryService
    implements ISecureSecClusGrpFactory
{
    public SecureJpaSecClusGrpFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusGrpHPKey newHPKey() {
        ISecureSecClusGrpHPKey hpkey = new SecureJpaSecClusGrpHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusGrpHPKey ensureHPKey(ISecureSecClusGrpHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecClusGrpHPKey) {
			return( (SecureJpaSecClusGrpHPKey)key );
		}
		else {
			SecureJpaSecClusGrpHPKey mapped = new SecureJpaSecClusGrpHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecClusGrpId( key.getRequiredSecClusGrpId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusGrpByClusterIdxKey newByClusterIdxKey() {
		ISecureSecClusGrpByClusterIdxKey key = new SecureJpaSecClusGrpByClusterIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusGrpByClusterIdxKey ensureByClusterIdxKey(ISecureSecClusGrpByClusterIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecClusGrpByClusterIdxKey) {
			return( (SecureJpaSecClusGrpByClusterIdxKey)key );
		}
		else {
			SecureJpaSecClusGrpByClusterIdxKey mapped = new SecureJpaSecClusGrpByClusterIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusGrpByNameIdxKey newByNameIdxKey() {
		ISecureSecClusGrpByNameIdxKey key = new SecureJpaSecClusGrpByNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusGrpByNameIdxKey ensureByNameIdxKey(ISecureSecClusGrpByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecClusGrpByNameIdxKey) {
			return( (SecureJpaSecClusGrpByNameIdxKey)key );
		}
		else {
			SecureJpaSecClusGrpByNameIdxKey mapped = new SecureJpaSecClusGrpByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusGrpByUNameIdxKey newByUNameIdxKey() {
		ISecureSecClusGrpByUNameIdxKey key = new SecureJpaSecClusGrpByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusGrpByUNameIdxKey ensureByUNameIdxKey(ISecureSecClusGrpByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecClusGrpByUNameIdxKey) {
			return( (SecureJpaSecClusGrpByUNameIdxKey)key );
		}
		else {
			SecureJpaSecClusGrpByUNameIdxKey mapped = new SecureJpaSecClusGrpByUNameIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusGrp newRec() {
        ISecureSecClusGrp rec = new SecureJpaSecClusGrp();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusGrp ensureRec(ISecureSecClusGrp rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecClusGrp) {
			return( (SecureJpaSecClusGrp)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecClusGrp.CLASS_CODE: {
					SecureJpaSecClusGrp mapped = new SecureJpaSecClusGrp();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecClusGrp",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecClusGrp");
			}
		}
	}

    @Override
    public ISecureSecClusGrpH newHRec() {
        ISecureSecClusGrpH hrec = new SecureJpaSecClusGrpH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusGrpH ensureHRec(ISecureSecClusGrpH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecClusGrpH) {
			return( (SecureJpaSecClusGrpH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecClusGrp.CLASS_CODE: {
					SecureJpaSecClusGrpH mapped = new SecureJpaSecClusGrpH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecClusGrp",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecClusGrp");
			}
		}
	}
}
