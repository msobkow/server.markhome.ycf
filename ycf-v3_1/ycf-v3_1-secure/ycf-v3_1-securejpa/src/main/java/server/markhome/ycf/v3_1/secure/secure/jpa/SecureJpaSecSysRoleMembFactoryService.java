
// Description: Java 25 Factory service implementation for SecSysRoleMemb JPA objects

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
 *	Java 25 Factory service implementation for SecSysRoleMemb JPA objects.
 */
public class SecureJpaSecSysRoleMembFactoryService
    implements ISecureSecSysRoleMembFactory
{
    public SecureJpaSecSysRoleMembFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysRoleMembPKey newPKey() {
        ISecureSecSysRoleMembPKey pkey = new SecureJpaSecSysRoleMembPKey();
        return( pkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysRoleMembPKey ensurePKey(ISecureSecSysRoleMembPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecSysRoleMembPKey) {
			return( (SecureJpaSecSysRoleMembPKey)key );
		}
		else {
			SecureJpaSecSysRoleMembPKey mapped = new SecureJpaSecSysRoleMembPKey();
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysRoleMembHPKey newHPKey() {
        ISecureSecSysRoleMembHPKey hpkey = new SecureJpaSecSysRoleMembHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysRoleMembHPKey ensureHPKey(ISecureSecSysRoleMembHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecSysRoleMembHPKey) {
			return( (SecureJpaSecSysRoleMembHPKey)key );
		}
		else {
			SecureJpaSecSysRoleMembHPKey mapped = new SecureJpaSecSysRoleMembHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysRoleMembBySysRoleIdxKey newBySysRoleIdxKey() {
		ISecureSecSysRoleMembBySysRoleIdxKey key = new SecureJpaSecSysRoleMembBySysRoleIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysRoleMembBySysRoleIdxKey ensureBySysRoleIdxKey(ISecureSecSysRoleMembBySysRoleIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecSysRoleMembBySysRoleIdxKey) {
			return( (SecureJpaSecSysRoleMembBySysRoleIdxKey)key );
		}
		else {
			SecureJpaSecSysRoleMembBySysRoleIdxKey mapped = new SecureJpaSecSysRoleMembBySysRoleIdxKey();
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysRoleMembByLoginIdxKey newByLoginIdxKey() {
		ISecureSecSysRoleMembByLoginIdxKey key = new SecureJpaSecSysRoleMembByLoginIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysRoleMembByLoginIdxKey ensureByLoginIdxKey(ISecureSecSysRoleMembByLoginIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecSysRoleMembByLoginIdxKey) {
			return( (SecureJpaSecSysRoleMembByLoginIdxKey)key );
		}
		else {
			SecureJpaSecSysRoleMembByLoginIdxKey mapped = new SecureJpaSecSysRoleMembByLoginIdxKey();
			mapped.setRequiredLoginId( key.getRequiredLoginId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysRoleMemb newRec() {
        ISecureSecSysRoleMemb rec = new SecureJpaSecSysRoleMemb();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysRoleMemb ensureRec(ISecureSecSysRoleMemb rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecSysRoleMemb) {
			return( (SecureJpaSecSysRoleMemb)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecSysRoleMemb.CLASS_CODE: {
					SecureJpaSecSysRoleMemb mapped = new SecureJpaSecSysRoleMemb();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysRoleMemb",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysRoleMemb");
			}
		}
	}

    @Override
    public ISecureSecSysRoleMembH newHRec() {
        ISecureSecSysRoleMembH hrec = new SecureJpaSecSysRoleMembH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysRoleMembH ensureHRec(ISecureSecSysRoleMembH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecSysRoleMembH) {
			return( (SecureJpaSecSysRoleMembH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecSysRoleMemb.CLASS_CODE: {
					SecureJpaSecSysRoleMembH mapped = new SecureJpaSecSysRoleMembH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysRoleMemb",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysRoleMemb");
			}
		}
	}
}
