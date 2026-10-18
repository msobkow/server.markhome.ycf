
// Description: Java 25 Factory service implementation for ISOCtry JPA objects

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
 *	Java 25 Factory service implementation for ISOCtry JPA objects.
 */
public class SecureJpaISOCtryFactoryService
    implements ISecureISOCtryFactory
{
    public SecureJpaISOCtryFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCtryHPKey newHPKey() {
        ISecureISOCtryHPKey hpkey = new SecureJpaISOCtryHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCtryHPKey ensureHPKey(ISecureISOCtryHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaISOCtryHPKey) {
			return( (SecureJpaISOCtryHPKey)key );
		}
		else {
			SecureJpaISOCtryHPKey mapped = new SecureJpaISOCtryHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCtryByISOCodeIdxKey newByISOCodeIdxKey() {
		ISecureISOCtryByISOCodeIdxKey key = new SecureJpaISOCtryByISOCodeIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCtryByISOCodeIdxKey ensureByISOCodeIdxKey(ISecureISOCtryByISOCodeIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaISOCtryByISOCodeIdxKey) {
			return( (SecureJpaISOCtryByISOCodeIdxKey)key );
		}
		else {
			SecureJpaISOCtryByISOCodeIdxKey mapped = new SecureJpaISOCtryByISOCodeIdxKey();
			mapped.setRequiredISOCode( key.getRequiredISOCode() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCtryByNameIdxKey newByNameIdxKey() {
		ISecureISOCtryByNameIdxKey key = new SecureJpaISOCtryByNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCtryByNameIdxKey ensureByNameIdxKey(ISecureISOCtryByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaISOCtryByNameIdxKey) {
			return( (SecureJpaISOCtryByNameIdxKey)key );
		}
		else {
			SecureJpaISOCtryByNameIdxKey mapped = new SecureJpaISOCtryByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCtry newRec() {
        ISecureISOCtry rec = new SecureJpaISOCtry();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCtry ensureRec(ISecureISOCtry rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaISOCtry) {
			return( (SecureJpaISOCtry)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureISOCtry.CLASS_CODE: {
					SecureJpaISOCtry mapped = new SecureJpaISOCtry();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOCtry",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOCtry");
			}
		}
	}

    @Override
    public ISecureISOCtryH newHRec() {
        ISecureISOCtryH hrec = new SecureJpaISOCtryH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCtryH ensureHRec(ISecureISOCtryH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaISOCtryH) {
			return( (SecureJpaISOCtryH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureISOCtry.CLASS_CODE: {
					SecureJpaISOCtryH mapped = new SecureJpaISOCtryH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOCtry",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOCtry");
			}
		}
	}
}
