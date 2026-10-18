
// Description: Java 25 Factory service implementation for SecSysGrp JPA objects

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
 *	Java 25 Factory service implementation for SecSysGrp JPA objects.
 */
public class SecureJpaSecSysGrpFactoryService
    implements ISecureSecSysGrpFactory
{
    public SecureJpaSecSysGrpFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysGrpHPKey newHPKey() {
        ISecureSecSysGrpHPKey hpkey = new SecureJpaSecSysGrpHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysGrpHPKey ensureHPKey(ISecureSecSysGrpHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecSysGrpHPKey) {
			return( (SecureJpaSecSysGrpHPKey)key );
		}
		else {
			SecureJpaSecSysGrpHPKey mapped = new SecureJpaSecSysGrpHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysGrpId( key.getRequiredSecSysGrpId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysGrpByUNameIdxKey newByUNameIdxKey() {
		ISecureSecSysGrpByUNameIdxKey key = new SecureJpaSecSysGrpByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysGrpByUNameIdxKey ensureByUNameIdxKey(ISecureSecSysGrpByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecSysGrpByUNameIdxKey) {
			return( (SecureJpaSecSysGrpByUNameIdxKey)key );
		}
		else {
			SecureJpaSecSysGrpByUNameIdxKey mapped = new SecureJpaSecSysGrpByUNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysGrpBySecLevelIdxKey newBySecLevelIdxKey() {
		ISecureSecSysGrpBySecLevelIdxKey key = new SecureJpaSecSysGrpBySecLevelIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysGrpBySecLevelIdxKey ensureBySecLevelIdxKey(ISecureSecSysGrpBySecLevelIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecSysGrpBySecLevelIdxKey) {
			return( (SecureJpaSecSysGrpBySecLevelIdxKey)key );
		}
		else {
			SecureJpaSecSysGrpBySecLevelIdxKey mapped = new SecureJpaSecSysGrpBySecLevelIdxKey();
			mapped.setRequiredSecLevel( key.getRequiredSecLevel() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysGrp newRec() {
        ISecureSecSysGrp rec = new SecureJpaSecSysGrp();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysGrp ensureRec(ISecureSecSysGrp rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecSysGrp) {
			return( (SecureJpaSecSysGrp)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecSysGrp.CLASS_CODE: {
					SecureJpaSecSysGrp mapped = new SecureJpaSecSysGrp();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysGrp",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysGrp");
			}
		}
	}

    @Override
    public ISecureSecSysGrpH newHRec() {
        ISecureSecSysGrpH hrec = new SecureJpaSecSysGrpH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysGrpH ensureHRec(ISecureSecSysGrpH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecSysGrpH) {
			return( (SecureJpaSecSysGrpH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecSysGrp.CLASS_CODE: {
					SecureJpaSecSysGrpH mapped = new SecureJpaSecSysGrpH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysGrp",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysGrp");
			}
		}
	}
}
