
// Description: Java 25 Factory service implementation for ISOCtryCcy JPA objects

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
 *	Java 25 Factory service implementation for ISOCtryCcy JPA objects.
 */
public class SecureJpaISOCtryCcyFactoryService
    implements ISecureISOCtryCcyFactory
{
    public SecureJpaISOCtryCcyFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCtryCcyPKey newPKey() {
        ISecureISOCtryCcyPKey pkey = new SecureJpaISOCtryCcyPKey();
        return( pkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCtryCcyPKey ensurePKey(ISecureISOCtryCcyPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaISOCtryCcyPKey) {
			return( (SecureJpaISOCtryCcyPKey)key );
		}
		else {
			SecureJpaISOCtryCcyPKey mapped = new SecureJpaISOCtryCcyPKey();
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			mapped.setRequiredISOCcyId( key.getRequiredISOCcyId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCtryCcyHPKey newHPKey() {
        ISecureISOCtryCcyHPKey hpkey = new SecureJpaISOCtryCcyHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCtryCcyHPKey ensureHPKey(ISecureISOCtryCcyHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaISOCtryCcyHPKey) {
			return( (SecureJpaISOCtryCcyHPKey)key );
		}
		else {
			SecureJpaISOCtryCcyHPKey mapped = new SecureJpaISOCtryCcyHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			mapped.setRequiredISOCcyId( key.getRequiredISOCcyId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCtryCcyByCtryIdxKey newByCtryIdxKey() {
		ISecureISOCtryCcyByCtryIdxKey key = new SecureJpaISOCtryCcyByCtryIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCtryCcyByCtryIdxKey ensureByCtryIdxKey(ISecureISOCtryCcyByCtryIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaISOCtryCcyByCtryIdxKey) {
			return( (SecureJpaISOCtryCcyByCtryIdxKey)key );
		}
		else {
			SecureJpaISOCtryCcyByCtryIdxKey mapped = new SecureJpaISOCtryCcyByCtryIdxKey();
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCtryCcyByCcyIdxKey newByCcyIdxKey() {
		ISecureISOCtryCcyByCcyIdxKey key = new SecureJpaISOCtryCcyByCcyIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCtryCcyByCcyIdxKey ensureByCcyIdxKey(ISecureISOCtryCcyByCcyIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaISOCtryCcyByCcyIdxKey) {
			return( (SecureJpaISOCtryCcyByCcyIdxKey)key );
		}
		else {
			SecureJpaISOCtryCcyByCcyIdxKey mapped = new SecureJpaISOCtryCcyByCcyIdxKey();
			mapped.setRequiredISOCcyId( key.getRequiredISOCcyId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCtryCcy newRec() {
        ISecureISOCtryCcy rec = new SecureJpaISOCtryCcy();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCtryCcy ensureRec(ISecureISOCtryCcy rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaISOCtryCcy) {
			return( (SecureJpaISOCtryCcy)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureISOCtryCcy.CLASS_CODE: {
					SecureJpaISOCtryCcy mapped = new SecureJpaISOCtryCcy();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOCtryCcy",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOCtryCcy");
			}
		}
	}

    @Override
    public ISecureISOCtryCcyH newHRec() {
        ISecureISOCtryCcyH hrec = new SecureJpaISOCtryCcyH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCtryCcyH ensureHRec(ISecureISOCtryCcyH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaISOCtryCcyH) {
			return( (SecureJpaISOCtryCcyH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureISOCtryCcy.CLASS_CODE: {
					SecureJpaISOCtryCcyH mapped = new SecureJpaISOCtryCcyH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOCtryCcy",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOCtryCcy");
			}
		}
	}
}
