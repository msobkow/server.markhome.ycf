
// Description: Java 25 Factory service implementation for SysCluster JPA objects

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
 *	Java 25 Factory service implementation for SysCluster JPA objects.
 */
public class SecureJpaSysClusterFactoryService
    implements ISecureSysClusterFactory
{
    public SecureJpaSysClusterFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSysClusterHPKey newHPKey() {
        ISecureSysClusterHPKey hpkey = new SecureJpaSysClusterHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSysClusterHPKey ensureHPKey(ISecureSysClusterHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaSysClusterHPKey) {
			return( (SecureJpaSysClusterHPKey)key );
		}
		else {
			SecureJpaSysClusterHPKey mapped = new SecureJpaSysClusterHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredSingletonId( key.getRequiredSingletonId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSysClusterByClusterIdxKey newByClusterIdxKey() {
		ISecureSysClusterByClusterIdxKey key = new SecureJpaSysClusterByClusterIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSysClusterByClusterIdxKey ensureByClusterIdxKey(ISecureSysClusterByClusterIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaSysClusterByClusterIdxKey) {
			return( (SecureJpaSysClusterByClusterIdxKey)key );
		}
		else {
			SecureJpaSysClusterByClusterIdxKey mapped = new SecureJpaSysClusterByClusterIdxKey();
			mapped.setRequiredClusterId( key.getRequiredClusterId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureSysCluster newRec() {
        ISecureSysCluster rec = new SecureJpaSysCluster();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSysCluster ensureRec(ISecureSysCluster rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaSysCluster) {
			return( (SecureJpaSysCluster)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureSysCluster.CLASS_CODE: {
					SecureJpaSysCluster mapped = new SecureJpaSysCluster();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSysCluster",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureSysCluster");
			}
		}
	}

    @Override
    public ISecureSysClusterH newHRec() {
        ISecureSysClusterH hrec = new SecureJpaSysClusterH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaSysClusterH ensureHRec(ISecureSysClusterH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaSysClusterH) {
			return( (SecureJpaSysClusterH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureSysCluster.CLASS_CODE: {
					SecureJpaSysClusterH mapped = new SecureJpaSysClusterH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSysCluster",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureSysCluster");
			}
		}
	}
}
