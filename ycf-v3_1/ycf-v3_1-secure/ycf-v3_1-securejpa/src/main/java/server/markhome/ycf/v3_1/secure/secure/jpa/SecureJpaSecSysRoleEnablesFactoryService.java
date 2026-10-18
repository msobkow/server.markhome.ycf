
// Description: Java 25 Factory service implementation for SecSysRoleEnables JPA objects

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
 *	Java 25 Factory service implementation for SecSysRoleEnables JPA objects.
 */
public class SecureJpaSecSysRoleEnablesFactoryService
    implements ISecureSecSysRoleEnablesFactory
{
    public SecureJpaSecSysRoleEnablesFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysRoleEnablesPKey newPKey() {
        ISecureSecSysRoleEnablesPKey pkey = new SecureJpaSecSysRoleEnablesPKey();
        return( pkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysRoleEnablesPKey ensurePKey(ISecureSecSysRoleEnablesPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecSysRoleEnablesPKey) {
			return( (SecureJpaSecSysRoleEnablesPKey)key );
		}
		else {
			SecureJpaSecSysRoleEnablesPKey mapped = new SecureJpaSecSysRoleEnablesPKey();
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			mapped.setRequiredEnableName( key.getRequiredEnableName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysRoleEnablesHPKey newHPKey() {
        ISecureSecSysRoleEnablesHPKey hpkey = new SecureJpaSecSysRoleEnablesHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysRoleEnablesHPKey ensureHPKey(ISecureSecSysRoleEnablesHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSecSysRoleEnablesHPKey) {
			return( (SecureJpaSecSysRoleEnablesHPKey)key );
		}
		else {
			SecureJpaSecSysRoleEnablesHPKey mapped = new SecureJpaSecSysRoleEnablesHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			mapped.setRequiredEnableName( key.getRequiredEnableName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysRoleEnablesBySysRoleIdxKey newBySysRoleIdxKey() {
		ISecureSecSysRoleEnablesBySysRoleIdxKey key = new SecureJpaSecSysRoleEnablesBySysRoleIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysRoleEnablesBySysRoleIdxKey ensureBySysRoleIdxKey(ISecureSecSysRoleEnablesBySysRoleIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecSysRoleEnablesBySysRoleIdxKey) {
			return( (SecureJpaSecSysRoleEnablesBySysRoleIdxKey)key );
		}
		else {
			SecureJpaSecSysRoleEnablesBySysRoleIdxKey mapped = new SecureJpaSecSysRoleEnablesBySysRoleIdxKey();
			mapped.setRequiredSecSysRoleId( key.getRequiredSecSysRoleId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysRoleEnablesByNameIdxKey newByNameIdxKey() {
		ISecureSecSysRoleEnablesByNameIdxKey key = new SecureJpaSecSysRoleEnablesByNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysRoleEnablesByNameIdxKey ensureByNameIdxKey(ISecureSecSysRoleEnablesByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSecSysRoleEnablesByNameIdxKey) {
			return( (SecureJpaSecSysRoleEnablesByNameIdxKey)key );
		}
		else {
			SecureJpaSecSysRoleEnablesByNameIdxKey mapped = new SecureJpaSecSysRoleEnablesByNameIdxKey();
			mapped.setRequiredEnableName( key.getRequiredEnableName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSecSysRoleEnables newRec() {
        ISecureSecSysRoleEnables rec = new SecureJpaSecSysRoleEnables();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysRoleEnables ensureRec(ISecureSecSysRoleEnables rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSecSysRoleEnables) {
			return( (SecureJpaSecSysRoleEnables)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSecSysRoleEnables.CLASS_CODE: {
					SecureJpaSecSysRoleEnables mapped = new SecureJpaSecSysRoleEnables();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysRoleEnables",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSecSysRoleEnables");
			}
		}
	}

    @Override
    public ISecureSecSysRoleEnablesH newHRec() {
        ISecureSecSysRoleEnablesH hrec = new SecureJpaSecSysRoleEnablesH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSecSysRoleEnablesH ensureHRec(ISecureSecSysRoleEnablesH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSecSysRoleEnablesH) {
			return( (SecureJpaSecSysRoleEnablesH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSecSysRoleEnables.CLASS_CODE: {
					SecureJpaSecSysRoleEnablesH mapped = new SecureJpaSecSysRoleEnablesH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysRoleEnables",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSecSysRoleEnables");
			}
		}
	}
}
