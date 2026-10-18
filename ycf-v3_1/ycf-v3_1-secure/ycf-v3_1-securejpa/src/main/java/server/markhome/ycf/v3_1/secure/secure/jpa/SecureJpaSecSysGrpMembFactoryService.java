
// Description: Java 25 Factory service implementation for SecSysGrpMemb JPA objects

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
 *	Java 25 Factory service implementation for SecSysGrpMemb JPA objects.
 */
public class SecureJpaSecSysGrpMembFactoryService
    implements ISecureSecSysGrpMembFactory
{
    public SecureJpaSecSysGrpMembFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysGrpMembPKey newPKey() {
        ISecureSecSysGrpMembPKey pkey = new SecureJpaSecSysGrpMembPKey();
        return( pkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysGrpMembPKey ensurePKey(ISecureSecSysGrpMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecSysGrpMembPKey) {
			return( (SecureJpaSecSysGrpMembPKey)key );
		}
		else {
			SecureJpaSecSysGrpMembPKey mapped = new SecureJpaSecSysGrpMembPKey();
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysGrpMembHPKey newHPKey() {
        ISecureSecSysGrpMembHPKey hpkey = new SecureJpaSecSysGrpMembHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysGrpMembHPKey ensureHPKey(ISecureSecSysGrpMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecSysGrpMembHPKey) {
			return( (SecureJpaSecSysGrpMembHPKey)key );
		}
		else {
			SecureJpaSecSysGrpMembHPKey mapped = new SecureJpaSecSysGrpMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysGrpMembBySysGrpIdxKey newBySysGrpIdxKey() {
		ISecureSecSysGrpMembBySysGrpIdxKey key = new SecureJpaSecSysGrpMembBySysGrpIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysGrpMembBySysGrpIdxKey ensureBySysGrpIdxKey(ISecureSecSysGrpMembBySysGrpIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecSysGrpMembBySysGrpIdxKey) {
			return( (SecureJpaSecSysGrpMembBySysGrpIdxKey)key );
		}
		else {
			SecureJpaSecSysGrpMembBySysGrpIdxKey mapped = new SecureJpaSecSysGrpMembBySysGrpIdxKey();
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysGrpMembByLoginIdxKey newByLoginIdxKey() {
		ISecureSecSysGrpMembByLoginIdxKey key = new SecureJpaSecSysGrpMembByLoginIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysGrpMembByLoginIdxKey ensureByLoginIdxKey(ISecureSecSysGrpMembByLoginIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecSysGrpMembByLoginIdxKey) {
			return( (SecureJpaSecSysGrpMembByLoginIdxKey)key );
		}
		else {
			SecureJpaSecSysGrpMembByLoginIdxKey mapped = new SecureJpaSecSysGrpMembByLoginIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysGrpMemb newRec() {
        ISecureSecSysGrpMemb rec = new SecureJpaSecSysGrpMemb();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysGrpMemb ensureRec(ISecureSecSysGrpMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecSysGrpMemb) {
			return( (SecureJpaSecSysGrpMemb)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecSysGrpMemb.CLASS_CODE: {
					SecureJpaSecSysGrpMemb mapped = new SecureJpaSecSysGrpMemb();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysGrpMemb",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysGrpMemb");
			}
		}
	}

    @Override
    public ISecureSecSysGrpMembH newHRec() {
        ISecureSecSysGrpMembH hrec = new SecureJpaSecSysGrpMembH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysGrpMembH ensureHRec(ISecureSecSysGrpMembH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecSysGrpMembH) {
			return( (SecureJpaSecSysGrpMembH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecSysGrpMemb.CLASS_CODE: {
					SecureJpaSecSysGrpMembH mapped = new SecureJpaSecSysGrpMembH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysGrpMemb",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysGrpMemb");
			}
		}
	}
}
