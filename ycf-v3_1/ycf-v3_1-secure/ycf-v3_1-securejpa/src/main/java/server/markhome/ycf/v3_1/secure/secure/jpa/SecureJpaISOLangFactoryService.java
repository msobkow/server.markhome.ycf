
// Description: Java 25 Factory service implementation for ISOLang JPA objects

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
 *	Java 25 Factory service implementation for ISOLang JPA objects.
 */
public class SecureJpaISOLangFactoryService
    implements ISecureISOLangFactory
{
    public SecureJpaISOLangFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOLangHPKey newHPKey() {
        ISecureISOLangHPKey hpkey = new SecureJpaISOLangHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOLangHPKey ensureHPKey(ISecureISOLangHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaISOLangHPKey) {
			return( (SecureJpaISOLangHPKey)key );
		}
		else {
			SecureJpaISOLangHPKey mapped = new SecureJpaISOLangHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredISOLangId( key.getRequiredISOLangId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOLangByCode3IdxKey newByCode3IdxKey() {
		ISecureISOLangByCode3IdxKey key = new SecureJpaISOLangByCode3IdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOLangByCode3IdxKey ensureByCode3IdxKey(ISecureISOLangByCode3IdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaISOLangByCode3IdxKey) {
			return( (SecureJpaISOLangByCode3IdxKey)key );
		}
		else {
			SecureJpaISOLangByCode3IdxKey mapped = new SecureJpaISOLangByCode3IdxKey();
			mapped.setRequiredISO6392Code( key.getRequiredISO6392Code() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOLangByCode2IdxKey newByCode2IdxKey() {
		ISecureISOLangByCode2IdxKey key = new SecureJpaISOLangByCode2IdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOLangByCode2IdxKey ensureByCode2IdxKey(ISecureISOLangByCode2IdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaISOLangByCode2IdxKey) {
			return( (SecureJpaISOLangByCode2IdxKey)key );
		}
		else {
			SecureJpaISOLangByCode2IdxKey mapped = new SecureJpaISOLangByCode2IdxKey();
			mapped.setOptionalISO6391Code( key.getOptionalISO6391Code() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOLang newRec() {
        ISecureISOLang rec = new SecureJpaISOLang();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOLang ensureRec(ISecureISOLang rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaISOLang) {
			return( (SecureJpaISOLang)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureISOLang.CLASS_CODE: {
					SecureJpaISOLang mapped = new SecureJpaISOLang();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOLang",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOLang");
			}
		}
	}

    @Override
    public ISecureISOLangH newHRec() {
        ISecureISOLangH hrec = new SecureJpaISOLangH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOLangH ensureHRec(ISecureISOLangH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaISOLangH) {
			return( (SecureJpaISOLangH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureISOLang.CLASS_CODE: {
					SecureJpaISOLangH mapped = new SecureJpaISOLangH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOLang",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOLang");
			}
		}
	}
}
