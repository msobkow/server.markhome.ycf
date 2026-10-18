
// Description: Java 25 Factory service implementation for Cluster JPA objects

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
 *	Java 25 Factory service implementation for Cluster JPA objects.
 */
public class SecureJpaClusterFactoryService
    implements ISecureClusterFactory
{
    public SecureJpaClusterFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureClusterHPKey newHPKey() {
        ISecureClusterHPKey hpkey = new SecureJpaClusterHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaClusterHPKey ensureHPKey(ISecureClusterHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaClusterHPKey) {
			return( (SecureJpaClusterHPKey)key );
		}
		else {
			SecureJpaClusterHPKey mapped = new SecureJpaClusterHPKey();
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
    public ISecureClusterByUDomNameIdxKey newByUDomNameIdxKey() {
		ISecureClusterByUDomNameIdxKey key = new SecureJpaClusterByUDomNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaClusterByUDomNameIdxKey ensureByUDomNameIdxKey(ISecureClusterByUDomNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaClusterByUDomNameIdxKey) {
			return( (SecureJpaClusterByUDomNameIdxKey)key );
		}
		else {
			SecureJpaClusterByUDomNameIdxKey mapped = new SecureJpaClusterByUDomNameIdxKey();
			mapped.setRequiredFullDomName( key.getRequiredFullDomName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureClusterByUDescrIdxKey newByUDescrIdxKey() {
		ISecureClusterByUDescrIdxKey key = new SecureJpaClusterByUDescrIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaClusterByUDescrIdxKey ensureByUDescrIdxKey(ISecureClusterByUDescrIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaClusterByUDescrIdxKey) {
			return( (SecureJpaClusterByUDescrIdxKey)key );
		}
		else {
			SecureJpaClusterByUDescrIdxKey mapped = new SecureJpaClusterByUDescrIdxKey();
			mapped.setRequiredDescription( key.getRequiredDescription() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureCluster newRec() {
        ISecureCluster rec = new SecureJpaCluster();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaCluster ensureRec(ISecureCluster rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaCluster) {
			return( (SecureJpaCluster)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureCluster.CLASS_CODE: {
					SecureJpaCluster mapped = new SecureJpaCluster();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureCluster",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureCluster");
			}
		}
	}

    @Override
    public ISecureClusterH newHRec() {
        ISecureClusterH hrec = new SecureJpaClusterH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaClusterH ensureHRec(ISecureClusterH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaClusterH) {
			return( (SecureJpaClusterH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureCluster.CLASS_CODE: {
					SecureJpaClusterH mapped = new SecureJpaClusterH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureCluster",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureCluster");
			}
		}
	}
}
