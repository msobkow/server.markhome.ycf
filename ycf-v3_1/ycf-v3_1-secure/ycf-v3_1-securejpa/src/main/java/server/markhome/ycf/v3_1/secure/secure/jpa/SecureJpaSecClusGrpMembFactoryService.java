
// Description: Java 25 Factory service implementation for SecClusGrpMemb JPA objects

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
 *	Java 25 Factory service implementation for SecClusGrpMemb JPA objects.
 */
public class SecureJpaSecClusGrpMembFactoryService
    implements ISecureSecClusGrpMembFactory
{
    public SecureJpaSecClusGrpMembFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusGrpMembPKey newPKey() {
        ISecureSecClusGrpMembPKey pkey = new SecureJpaSecClusGrpMembPKey();
        return( pkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusGrpMembPKey ensurePKey(ISecureSecClusGrpMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecClusGrpMembPKey) {
			return( (SecureJpaSecClusGrpMembPKey)key );
		}
		else {
			SecureJpaSecClusGrpMembPKey mapped = new SecureJpaSecClusGrpMembPKey();
			mapped.setRequiredSecClusGrpId( key.getRequiredSecClusGrpId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusGrpMembHPKey newHPKey() {
        ISecureSecClusGrpMembHPKey hpkey = new SecureJpaSecClusGrpMembHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusGrpMembHPKey ensureHPKey(ISecureSecClusGrpMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecClusGrpMembHPKey) {
			return( (SecureJpaSecClusGrpMembHPKey)key );
		}
		else {
			SecureJpaSecClusGrpMembHPKey mapped = new SecureJpaSecClusGrpMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecClusGrpId( key.getRequiredSecClusGrpId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusGrpMembByClusGrpIdxKey newByClusGrpIdxKey() {
		ISecureSecClusGrpMembByClusGrpIdxKey key = new SecureJpaSecClusGrpMembByClusGrpIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusGrpMembByClusGrpIdxKey ensureByClusGrpIdxKey(ISecureSecClusGrpMembByClusGrpIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecClusGrpMembByClusGrpIdxKey) {
			return( (SecureJpaSecClusGrpMembByClusGrpIdxKey)key );
		}
		else {
			SecureJpaSecClusGrpMembByClusGrpIdxKey mapped = new SecureJpaSecClusGrpMembByClusGrpIdxKey();
			mapped.setRequiredSecClusGrpId( key.getRequiredSecClusGrpId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusGrpMembByLoginIdxKey newByLoginIdxKey() {
		ISecureSecClusGrpMembByLoginIdxKey key = new SecureJpaSecClusGrpMembByLoginIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusGrpMembByLoginIdxKey ensureByLoginIdxKey(ISecureSecClusGrpMembByLoginIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecClusGrpMembByLoginIdxKey) {
			return( (SecureJpaSecClusGrpMembByLoginIdxKey)key );
		}
		else {
			SecureJpaSecClusGrpMembByLoginIdxKey mapped = new SecureJpaSecClusGrpMembByLoginIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecClusGrpMemb newRec() {
        ISecureSecClusGrpMemb rec = new SecureJpaSecClusGrpMemb();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusGrpMemb ensureRec(ISecureSecClusGrpMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecClusGrpMemb) {
			return( (SecureJpaSecClusGrpMemb)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecClusGrpMemb.CLASS_CODE: {
					SecureJpaSecClusGrpMemb mapped = new SecureJpaSecClusGrpMemb();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecClusGrpMemb",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecClusGrpMemb");
			}
		}
	}

    @Override
    public ISecureSecClusGrpMembH newHRec() {
        ISecureSecClusGrpMembH hrec = new SecureJpaSecClusGrpMembH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecClusGrpMembH ensureHRec(ISecureSecClusGrpMembH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecClusGrpMembH) {
			return( (SecureJpaSecClusGrpMembH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecClusGrpMemb.CLASS_CODE: {
					SecureJpaSecClusGrpMembH mapped = new SecureJpaSecClusGrpMembH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecClusGrpMemb",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecClusGrpMemb");
			}
		}
	}
}
