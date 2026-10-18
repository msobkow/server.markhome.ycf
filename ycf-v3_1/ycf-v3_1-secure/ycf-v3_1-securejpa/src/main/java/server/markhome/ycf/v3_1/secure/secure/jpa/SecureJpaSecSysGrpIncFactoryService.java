
// Description: Java 25 Factory service implementation for SecSysGrpInc JPA objects

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
 *	Java 25 Factory service implementation for SecSysGrpInc JPA objects.
 */
public class SecureJpaSecSysGrpIncFactoryService
    implements ISecureSecSysGrpIncFactory
{
    public SecureJpaSecSysGrpIncFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysGrpIncPKey newPKey() {
        ISecureSecSysGrpIncPKey pkey = new SecureJpaSecSysGrpIncPKey();
        return( pkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysGrpIncPKey ensurePKey(ISecureSecSysGrpIncPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecSysGrpIncPKey) {
			return( (SecureJpaSecSysGrpIncPKey)key );
		}
		else {
			SecureJpaSecSysGrpIncPKey mapped = new SecureJpaSecSysGrpIncPKey();
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			mapped.setRequiredInclName( key.getRequiredInclName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysGrpIncHPKey newHPKey() {
        ISecureSecSysGrpIncHPKey hpkey = new SecureJpaSecSysGrpIncHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysGrpIncHPKey ensureHPKey(ISecureSecSysGrpIncHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecSysGrpIncHPKey) {
			return( (SecureJpaSecSysGrpIncHPKey)key );
		}
		else {
			SecureJpaSecSysGrpIncHPKey mapped = new SecureJpaSecSysGrpIncHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			mapped.setRequiredInclName( key.getRequiredInclName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysGrpIncBySysGrpIdxKey newBySysGrpIdxKey() {
		ISecureSecSysGrpIncBySysGrpIdxKey key = new SecureJpaSecSysGrpIncBySysGrpIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysGrpIncBySysGrpIdxKey ensureBySysGrpIdxKey(ISecureSecSysGrpIncBySysGrpIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecSysGrpIncBySysGrpIdxKey) {
			return( (SecureJpaSecSysGrpIncBySysGrpIdxKey)key );
		}
		else {
			SecureJpaSecSysGrpIncBySysGrpIdxKey mapped = new SecureJpaSecSysGrpIncBySysGrpIdxKey();
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysGrpIncByNameIdxKey newByNameIdxKey() {
		ISecureSecSysGrpIncByNameIdxKey key = new SecureJpaSecSysGrpIncByNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysGrpIncByNameIdxKey ensureByNameIdxKey(ISecureSecSysGrpIncByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecSysGrpIncByNameIdxKey) {
			return( (SecureJpaSecSysGrpIncByNameIdxKey)key );
		}
		else {
			SecureJpaSecSysGrpIncByNameIdxKey mapped = new SecureJpaSecSysGrpIncByNameIdxKey();
			mapped.setRequiredInclName( key.getRequiredInclName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysGrpInc newRec() {
        ISecureSecSysGrpInc rec = new SecureJpaSecSysGrpInc();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysGrpInc ensureRec(ISecureSecSysGrpInc rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecSysGrpInc) {
			return( (SecureJpaSecSysGrpInc)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecSysGrpInc.CLASS_CODE: {
					SecureJpaSecSysGrpInc mapped = new SecureJpaSecSysGrpInc();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysGrpInc",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysGrpInc");
			}
		}
	}

    @Override
    public ISecureSecSysGrpIncH newHRec() {
        ISecureSecSysGrpIncH hrec = new SecureJpaSecSysGrpIncH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysGrpIncH ensureHRec(ISecureSecSysGrpIncH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecSysGrpIncH) {
			return( (SecureJpaSecSysGrpIncH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecSysGrpInc.CLASS_CODE: {
					SecureJpaSecSysGrpIncH mapped = new SecureJpaSecSysGrpIncH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysGrpInc",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysGrpInc");
			}
		}
	}
}
