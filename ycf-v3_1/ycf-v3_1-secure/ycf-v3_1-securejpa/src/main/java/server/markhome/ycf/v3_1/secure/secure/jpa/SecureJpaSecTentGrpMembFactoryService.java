
// Description: Java 25 Factory service implementation for SecTentGrpMemb JPA objects

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
 *	Java 25 Factory service implementation for SecTentGrpMemb JPA objects.
 */
public class SecureJpaSecTentGrpMembFactoryService
    implements ISecureSecTentGrpMembFactory
{
    public SecureJpaSecTentGrpMembFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentGrpMembPKey newPKey() {
        ISecureSecTentGrpMembPKey pkey = new SecureJpaSecTentGrpMembPKey();
        return( pkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentGrpMembPKey ensurePKey(ISecureSecTentGrpMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecTentGrpMembPKey) {
			return( (SecureJpaSecTentGrpMembPKey)key );
		}
		else {
			SecureJpaSecTentGrpMembPKey mapped = new SecureJpaSecTentGrpMembPKey();
			mapped.setRequiredSecTentGrpId( key.getRequiredSecTentGrpId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentGrpMembHPKey newHPKey() {
        ISecureSecTentGrpMembHPKey hpkey = new SecureJpaSecTentGrpMembHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentGrpMembHPKey ensureHPKey(ISecureSecTentGrpMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecTentGrpMembHPKey) {
			return( (SecureJpaSecTentGrpMembHPKey)key );
		}
		else {
			SecureJpaSecTentGrpMembHPKey mapped = new SecureJpaSecTentGrpMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecTentGrpId( key.getRequiredSecTentGrpId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentGrpMembByTentGrpIdxKey newByTentGrpIdxKey() {
		ISecureSecTentGrpMembByTentGrpIdxKey key = new SecureJpaSecTentGrpMembByTentGrpIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentGrpMembByTentGrpIdxKey ensureByTentGrpIdxKey(ISecureSecTentGrpMembByTentGrpIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecTentGrpMembByTentGrpIdxKey) {
			return( (SecureJpaSecTentGrpMembByTentGrpIdxKey)key );
		}
		else {
			SecureJpaSecTentGrpMembByTentGrpIdxKey mapped = new SecureJpaSecTentGrpMembByTentGrpIdxKey();
			mapped.setRequiredSecTentGrpId( key.getRequiredSecTentGrpId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentGrpMembByUserIdxKey newByUserIdxKey() {
		ISecureSecTentGrpMembByUserIdxKey key = new SecureJpaSecTentGrpMembByUserIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentGrpMembByUserIdxKey ensureByUserIdxKey(ISecureSecTentGrpMembByUserIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecTentGrpMembByUserIdxKey) {
			return( (SecureJpaSecTentGrpMembByUserIdxKey)key );
		}
		else {
			SecureJpaSecTentGrpMembByUserIdxKey mapped = new SecureJpaSecTentGrpMembByUserIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecTentGrpMemb newRec() {
        ISecureSecTentGrpMemb rec = new SecureJpaSecTentGrpMemb();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentGrpMemb ensureRec(ISecureSecTentGrpMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecTentGrpMemb) {
			return( (SecureJpaSecTentGrpMemb)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecTentGrpMemb.CLASS_CODE: {
					SecureJpaSecTentGrpMemb mapped = new SecureJpaSecTentGrpMemb();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecTentGrpMemb",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecTentGrpMemb");
			}
		}
	}

    @Override
    public ISecureSecTentGrpMembH newHRec() {
        ISecureSecTentGrpMembH hrec = new SecureJpaSecTentGrpMembH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecTentGrpMembH ensureHRec(ISecureSecTentGrpMembH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecTentGrpMembH) {
			return( (SecureJpaSecTentGrpMembH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecTentGrpMemb.CLASS_CODE: {
					SecureJpaSecTentGrpMembH mapped = new SecureJpaSecTentGrpMembH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecTentGrpMemb",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecTentGrpMemb");
			}
		}
	}
}
