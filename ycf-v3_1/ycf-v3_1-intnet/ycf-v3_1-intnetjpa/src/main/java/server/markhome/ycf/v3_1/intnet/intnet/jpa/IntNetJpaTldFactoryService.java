
// Description: Java 25 Factory service implementation for Tld JPA objects

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
 *	Java 25 Factory service implementation for Tld JPA objects.
 */
public class IntNetJpaTldFactoryService
    implements IIntNetTldFactory
{
    public IntNetJpaTldFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetTldHPKey newHPKey() {
        IIntNetTldHPKey hpkey = new IntNetJpaTldHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTldHPKey ensureHPKey(IIntNetTldHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof IntNetJpaTldHPKey) {
			return( (IntNetJpaTldHPKey)key );
		}
		else {
			IntNetJpaTldHPKey mapped = new IntNetJpaTldHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetTldByTenantIdxKey newByTenantIdxKey() {
		IIntNetTldByTenantIdxKey key = new IntNetJpaTldByTenantIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTldByTenantIdxKey ensureByTenantIdxKey(IIntNetTldByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaTldByTenantIdxKey) {
			return( (IntNetJpaTldByTenantIdxKey)key );
		}
		else {
			IntNetJpaTldByTenantIdxKey mapped = new IntNetJpaTldByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetTldByNameIdxKey newByNameIdxKey() {
		IIntNetTldByNameIdxKey key = new IntNetJpaTldByNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTldByNameIdxKey ensureByNameIdxKey(IIntNetTldByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaTldByNameIdxKey) {
			return( (IntNetJpaTldByNameIdxKey)key );
		}
		else {
			IntNetJpaTldByNameIdxKey mapped = new IntNetJpaTldByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetTld newRec() {
        IIntNetTld rec = new IntNetJpaTld();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTld ensureRec(IIntNetTld rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof IntNetJpaTld) {
			return( (IntNetJpaTld)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IIntNetTld.CLASS_CODE: {
					IntNetJpaTld mapped = new IntNetJpaTld();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetTld",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetTld");
			}
		}
	}

    @Override
    public IIntNetTldH newHRec() {
        IIntNetTldH hrec = new IntNetJpaTldH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTldH ensureHRec(IIntNetTldH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof IntNetJpaTldH) {
			return( (IntNetJpaTldH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IIntNetTld.CLASS_CODE: {
					IntNetJpaTldH mapped = new IntNetJpaTldH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetTld",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetTld");
			}
		}
	}
}
