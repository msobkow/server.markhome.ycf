
// Description: Java 25 Factory service implementation for URLProtocol JPA objects

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
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

package server.markhome.ycf.v3_1.intnet.intnet.jpa;

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
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.*;

/*
 *	Java 25 Factory service implementation for URLProtocol JPA objects.
 */
public class IntNetJpaURLProtocolFactoryService
    implements IIntNetURLProtocolFactory
{
    public IntNetJpaURLProtocolFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetURLProtocolHPKey newHPKey() {
        IIntNetURLProtocolHPKey hpkey = new IntNetJpaURLProtocolHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaURLProtocolHPKey ensureHPKey(IIntNetURLProtocolHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof IntNetJpaURLProtocolHPKey) {
			return( (IntNetJpaURLProtocolHPKey)key );
		}
		else {
			IntNetJpaURLProtocolHPKey mapped = new IntNetJpaURLProtocolHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredURLProtocolId( key.getRequiredURLProtocolId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetURLProtocolByUNameIdxKey newByUNameIdxKey() {
		IIntNetURLProtocolByUNameIdxKey key = new IntNetJpaURLProtocolByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaURLProtocolByUNameIdxKey ensureByUNameIdxKey(IIntNetURLProtocolByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaURLProtocolByUNameIdxKey) {
			return( (IntNetJpaURLProtocolByUNameIdxKey)key );
		}
		else {
			IntNetJpaURLProtocolByUNameIdxKey mapped = new IntNetJpaURLProtocolByUNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetURLProtocolByIsSecureIdxKey newByIsSecureIdxKey() {
		IIntNetURLProtocolByIsSecureIdxKey key = new IntNetJpaURLProtocolByIsSecureIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaURLProtocolByIsSecureIdxKey ensureByIsSecureIdxKey(IIntNetURLProtocolByIsSecureIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaURLProtocolByIsSecureIdxKey) {
			return( (IntNetJpaURLProtocolByIsSecureIdxKey)key );
		}
		else {
			IntNetJpaURLProtocolByIsSecureIdxKey mapped = new IntNetJpaURLProtocolByIsSecureIdxKey();
			mapped.setRequiredIsSecure( key.getRequiredIsSecure() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetURLProtocol newRec() {
        IIntNetURLProtocol rec = new IntNetJpaURLProtocol();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaURLProtocol ensureRec(IIntNetURLProtocol rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof IntNetJpaURLProtocol) {
			return( (IntNetJpaURLProtocol)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IIntNetURLProtocol.CLASS_CODE: {
					IntNetJpaURLProtocol mapped = new IntNetJpaURLProtocol();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetURLProtocol",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetURLProtocol");
			}
		}
	}

    @Override
    public IIntNetURLProtocolH newHRec() {
        IIntNetURLProtocolH hrec = new IntNetJpaURLProtocolH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaURLProtocolH ensureHRec(IIntNetURLProtocolH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof IntNetJpaURLProtocolH) {
			return( (IntNetJpaURLProtocolH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IIntNetURLProtocol.CLASS_CODE: {
					IntNetJpaURLProtocolH mapped = new IntNetJpaURLProtocolH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetURLProtocol",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetURLProtocol");
			}
		}
	}
}
