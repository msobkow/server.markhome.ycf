
// Description: Java 25 Factory service implementation for Tenant JPA objects

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
 *	Java 25 Factory service implementation for Tenant JPA objects.
 */
public class SecureJpaTenantFactoryService
    implements ISecureTenantFactory
{
    public SecureJpaTenantFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureTenantHPKey newHPKey() {
        ISecureTenantHPKey hpkey = new SecureJpaTenantHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaTenantHPKey ensureHPKey(ISecureTenantHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaTenantHPKey) {
			return( (SecureJpaTenantHPKey)key );
		}
		else {
			SecureJpaTenantHPKey mapped = new SecureJpaTenantHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureTenantByClusterIdxKey newByClusterIdxKey() {
		ISecureTenantByClusterIdxKey key = new SecureJpaTenantByClusterIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaTenantByClusterIdxKey ensureByClusterIdxKey(ISecureTenantByClusterIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaTenantByClusterIdxKey) {
			return( (SecureJpaTenantByClusterIdxKey)key );
		}
		else {
			SecureJpaTenantByClusterIdxKey mapped = new SecureJpaTenantByClusterIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureTenantByUNameIdxKey newByUNameIdxKey() {
		ISecureTenantByUNameIdxKey key = new SecureJpaTenantByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaTenantByUNameIdxKey ensureByUNameIdxKey(ISecureTenantByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaTenantByUNameIdxKey) {
			return( (SecureJpaTenantByUNameIdxKey)key );
		}
		else {
			SecureJpaTenantByUNameIdxKey mapped = new SecureJpaTenantByUNameIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			mapped.setRequiredTenantName( key.getRequiredTenantName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureTenant newRec() {
        ISecureTenant rec = new SecureJpaTenant();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaTenant ensureRec(ISecureTenant rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaTenant) {
			return( (SecureJpaTenant)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureTenant.CLASS_CODE: {
					SecureJpaTenant mapped = new SecureJpaTenant();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureTenant",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureTenant");
			}
		}
	}

    @Override
    public ISecureTenantH newHRec() {
        ISecureTenantH hrec = new SecureJpaTenantH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaTenantH ensureHRec(ISecureTenantH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaTenantH) {
			return( (SecureJpaTenantH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureTenant.CLASS_CODE: {
					SecureJpaTenantH mapped = new SecureJpaTenantH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureTenant",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureTenant");
			}
		}
	}
}
