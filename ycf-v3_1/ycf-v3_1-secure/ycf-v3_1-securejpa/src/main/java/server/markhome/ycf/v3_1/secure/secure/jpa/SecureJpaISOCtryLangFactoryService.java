
// Description: Java 25 Factory service implementation for ISOCtryLang JPA objects

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
 *	Java 25 Factory service implementation for ISOCtryLang JPA objects.
 */
public class SecureJpaISOCtryLangFactoryService
    implements ISecureISOCtryLangFactory
{
    public SecureJpaISOCtryLangFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCtryLangPKey newPKey() {
        ISecureISOCtryLangPKey pkey = new SecureJpaISOCtryLangPKey();
        return( pkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCtryLangPKey ensurePKey(ISecureISOCtryLangPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaISOCtryLangPKey) {
			return( (SecureJpaISOCtryLangPKey)key );
		}
		else {
			SecureJpaISOCtryLangPKey mapped = new SecureJpaISOCtryLangPKey();
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			mapped.setRequiredISOLangId( key.getRequiredISOLangId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCtryLangHPKey newHPKey() {
        ISecureISOCtryLangHPKey hpkey = new SecureJpaISOCtryLangHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCtryLangHPKey ensureHPKey(ISecureISOCtryLangHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaISOCtryLangHPKey) {
			return( (SecureJpaISOCtryLangHPKey)key );
		}
		else {
			SecureJpaISOCtryLangHPKey mapped = new SecureJpaISOCtryLangHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			mapped.setRequiredISOLangId( key.getRequiredISOLangId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCtryLangByCtryIdxKey newByCtryIdxKey() {
		ISecureISOCtryLangByCtryIdxKey key = new SecureJpaISOCtryLangByCtryIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCtryLangByCtryIdxKey ensureByCtryIdxKey(ISecureISOCtryLangByCtryIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaISOCtryLangByCtryIdxKey) {
			return( (SecureJpaISOCtryLangByCtryIdxKey)key );
		}
		else {
			SecureJpaISOCtryLangByCtryIdxKey mapped = new SecureJpaISOCtryLangByCtryIdxKey();
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCtryLangByLangIdxKey newByLangIdxKey() {
		ISecureISOCtryLangByLangIdxKey key = new SecureJpaISOCtryLangByLangIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCtryLangByLangIdxKey ensureByLangIdxKey(ISecureISOCtryLangByLangIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaISOCtryLangByLangIdxKey) {
			return( (SecureJpaISOCtryLangByLangIdxKey)key );
		}
		else {
			SecureJpaISOCtryLangByLangIdxKey mapped = new SecureJpaISOCtryLangByLangIdxKey();
			mapped.setRequiredISOLangId( key.getRequiredISOLangId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOCtryLang newRec() {
        ISecureISOCtryLang rec = new SecureJpaISOCtryLang();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCtryLang ensureRec(ISecureISOCtryLang rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaISOCtryLang) {
			return( (SecureJpaISOCtryLang)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureISOCtryLang.CLASS_CODE: {
					SecureJpaISOCtryLang mapped = new SecureJpaISOCtryLang();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOCtryLang",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOCtryLang");
			}
		}
	}

    @Override
    public ISecureISOCtryLangH newHRec() {
        ISecureISOCtryLangH hrec = new SecureJpaISOCtryLangH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOCtryLangH ensureHRec(ISecureISOCtryLangH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaISOCtryLangH) {
			return( (SecureJpaISOCtryLangH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureISOCtryLang.CLASS_CODE: {
					SecureJpaISOCtryLangH mapped = new SecureJpaISOCtryLangH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOCtryLang",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOCtryLang");
			}
		}
	}
}
