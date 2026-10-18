
// Description: Java 25 Factory service implementation for SecSysRole JPA objects

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
 *	Java 25 Factory service implementation for SecSysRole JPA objects.
 */
public class SecureJpaSecSysRoleFactoryService
    implements ISecureSecSysRoleFactory
{
    public SecureJpaSecSysRoleFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysRoleHPKey newHPKey() {
        ISecureSecSysRoleHPKey hpkey = new SecureJpaSecSysRoleHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysRoleHPKey ensureHPKey(ISecureSecSysRoleHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecSysRoleHPKey) {
			return( (SecureJpaSecSysRoleHPKey)key );
		}
		else {
			SecureJpaSecSysRoleHPKey mapped = new SecureJpaSecSysRoleHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysRoleByUNameIdxKey newByUNameIdxKey() {
		ISecureSecSysRoleByUNameIdxKey key = new SecureJpaSecSysRoleByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysRoleByUNameIdxKey ensureByUNameIdxKey(ISecureSecSysRoleByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecSysRoleByUNameIdxKey) {
			return( (SecureJpaSecSysRoleByUNameIdxKey)key );
		}
		else {
			SecureJpaSecSysRoleByUNameIdxKey mapped = new SecureJpaSecSysRoleByUNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysRole newRec() {
        ISecureSecSysRole rec = new SecureJpaSecSysRole();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysRole ensureRec(ISecureSecSysRole rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecSysRole) {
			return( (SecureJpaSecSysRole)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecSysRole.CLASS_CODE: {
					SecureJpaSecSysRole mapped = new SecureJpaSecSysRole();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysRole",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysRole");
			}
		}
	}

    @Override
    public ISecureSecSysRoleH newHRec() {
        ISecureSecSysRoleH hrec = new SecureJpaSecSysRoleH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysRoleH ensureHRec(ISecureSecSysRoleH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecSysRoleH) {
			return( (SecureJpaSecSysRoleH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecSysRole.CLASS_CODE: {
					SecureJpaSecSysRoleH mapped = new SecureJpaSecSysRoleH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysRole",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysRole");
			}
		}
	}
}
