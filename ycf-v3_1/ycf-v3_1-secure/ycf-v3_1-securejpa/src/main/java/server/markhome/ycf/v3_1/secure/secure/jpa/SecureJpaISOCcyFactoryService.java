
// Description: Java 25 Factory service implementation for ISOCcy JPA objects

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
 *	Java 25 Factory service implementation for ISOCcy JPA objects.
 */
public class SecureJpaISOCcyFactoryService
    implements ISecureISOCcyFactory
{
    public SecureJpaISOCcyFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCcyHPKey newHPKey() {
        ISecureISOCcyHPKey hpkey = new SecureJpaISOCcyHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCcyHPKey ensureHPKey(ISecureISOCcyHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaISOCcyHPKey) {
			return( (SecureJpaISOCcyHPKey)key );
		}
		else {
			SecureJpaISOCcyHPKey mapped = new SecureJpaISOCcyHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredISOCcyId( key.getRequiredISOCcyId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCcyByCcyCdIdxKey newByCcyCdIdxKey() {
		ISecureISOCcyByCcyCdIdxKey key = new SecureJpaISOCcyByCcyCdIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCcyByCcyCdIdxKey ensureByCcyCdIdxKey(ISecureISOCcyByCcyCdIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaISOCcyByCcyCdIdxKey) {
			return( (SecureJpaISOCcyByCcyCdIdxKey)key );
		}
		else {
			SecureJpaISOCcyByCcyCdIdxKey mapped = new SecureJpaISOCcyByCcyCdIdxKey();
			mapped.setRequiredISOCode( key.getRequiredISOCode() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCcyByCcyNmIdxKey newByCcyNmIdxKey() {
		ISecureISOCcyByCcyNmIdxKey key = new SecureJpaISOCcyByCcyNmIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCcyByCcyNmIdxKey ensureByCcyNmIdxKey(ISecureISOCcyByCcyNmIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaISOCcyByCcyNmIdxKey) {
			return( (SecureJpaISOCcyByCcyNmIdxKey)key );
		}
		else {
			SecureJpaISOCcyByCcyNmIdxKey mapped = new SecureJpaISOCcyByCcyNmIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCcy newRec() {
        ISecureISOCcy rec = new SecureJpaISOCcy();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCcy ensureRec(ISecureISOCcy rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaISOCcy) {
			return( (SecureJpaISOCcy)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureISOCcy.CLASS_CODE: {
					SecureJpaISOCcy mapped = new SecureJpaISOCcy();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOCcy",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOCcy");
			}
		}
	}

    @Override
    public ISecureISOCcyH newHRec() {
        ISecureISOCcyH hrec = new SecureJpaISOCcyH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCcyH ensureHRec(ISecureISOCcyH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaISOCcyH) {
			return( (SecureJpaISOCcyH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureISOCcy.CLASS_CODE: {
					SecureJpaISOCcyH mapped = new SecureJpaISOCcyH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOCcy",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOCcy");
			}
		}
	}
}
