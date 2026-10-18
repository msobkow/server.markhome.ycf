
// Description: Java 25 Factory service implementation for ISOTZone JPA objects

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
 *	Java 25 Factory service implementation for ISOTZone JPA objects.
 */
public class SecureJpaISOTZoneFactoryService
    implements ISecureISOTZoneFactory
{
    public SecureJpaISOTZoneFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOTZoneHPKey newHPKey() {
        ISecureISOTZoneHPKey hpkey = new SecureJpaISOTZoneHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOTZoneHPKey ensureHPKey(ISecureISOTZoneHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureJpaISOTZoneHPKey) {
			return( (SecureJpaISOTZoneHPKey)key );
		}
		else {
			SecureJpaISOTZoneHPKey mapped = new SecureJpaISOTZoneHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredISOTZoneId( key.getRequiredISOTZoneId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOTZoneByOffsetIdxKey newByOffsetIdxKey() {
		ISecureISOTZoneByOffsetIdxKey key = new SecureJpaISOTZoneByOffsetIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOTZoneByOffsetIdxKey ensureByOffsetIdxKey(ISecureISOTZoneByOffsetIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaISOTZoneByOffsetIdxKey) {
			return( (SecureJpaISOTZoneByOffsetIdxKey)key );
		}
		else {
			SecureJpaISOTZoneByOffsetIdxKey mapped = new SecureJpaISOTZoneByOffsetIdxKey();
			mapped.setRequiredTZHourOffset( key.getRequiredTZHourOffset() );
			mapped.setRequiredTZMinOffset( key.getRequiredTZMinOffset() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOTZoneByUTZNameIdxKey newByUTZNameIdxKey() {
		ISecureISOTZoneByUTZNameIdxKey key = new SecureJpaISOTZoneByUTZNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOTZoneByUTZNameIdxKey ensureByUTZNameIdxKey(ISecureISOTZoneByUTZNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaISOTZoneByUTZNameIdxKey) {
			return( (SecureJpaISOTZoneByUTZNameIdxKey)key );
		}
		else {
			SecureJpaISOTZoneByUTZNameIdxKey mapped = new SecureJpaISOTZoneByUTZNameIdxKey();
			mapped.setRequiredTZName( key.getRequiredTZName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOTZoneByIso8601IdxKey newByIso8601IdxKey() {
		ISecureISOTZoneByIso8601IdxKey key = new SecureJpaISOTZoneByIso8601IdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOTZoneByIso8601IdxKey ensureByIso8601IdxKey(ISecureISOTZoneByIso8601IdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureJpaISOTZoneByIso8601IdxKey) {
			return( (SecureJpaISOTZoneByIso8601IdxKey)key );
		}
		else {
			SecureJpaISOTZoneByIso8601IdxKey mapped = new SecureJpaISOTZoneByIso8601IdxKey();
			mapped.setRequiredIso8601( key.getRequiredIso8601() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
    public ISecureISOTZone newRec() {
        ISecureISOTZone rec = new SecureJpaISOTZone();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOTZone ensureRec(ISecureISOTZone rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureJpaISOTZone) {
			return( (SecureJpaISOTZone)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case ISecureISOTZone.CLASS_CODE: {
					SecureJpaISOTZone mapped = new SecureJpaISOTZone();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOTZone",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOTZone");
			}
		}
	}

    @Override
    public ISecureISOTZoneH newHRec() {
        ISecureISOTZoneH hrec = new SecureJpaISOTZoneH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "secure31TransactionManager")
	public SecureJpaISOTZoneH ensureHRec(ISecureISOTZoneH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureJpaISOTZoneH) {
			return( (SecureJpaISOTZoneH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case ISecureISOTZone.CLASS_CODE: {
					SecureJpaISOTZoneH mapped = new SecureJpaISOTZoneH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOTZone",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOTZone");
			}
		}
	}
}
