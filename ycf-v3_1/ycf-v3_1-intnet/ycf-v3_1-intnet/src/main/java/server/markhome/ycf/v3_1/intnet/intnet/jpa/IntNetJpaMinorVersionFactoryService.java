
// Description: Java 25 Factory service implementation for MinorVersion JPA objects

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
 *	Java 25 Factory service implementation for MinorVersion JPA objects.
 */
public class IntNetJpaMinorVersionFactoryService
    implements IIntNetMinorVersionFactory
{
    public IntNetJpaMinorVersionFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetMinorVersionHPKey newHPKey() {
        IIntNetMinorVersionHPKey hpkey = new IntNetJpaMinorVersionHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaMinorVersionHPKey ensureHPKey(IIntNetMinorVersionHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof IntNetJpaMinorVersionHPKey) {
			return( (IntNetJpaMinorVersionHPKey)key );
		}
		else {
			IntNetJpaMinorVersionHPKey mapped = new IntNetJpaMinorVersionHPKey();
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
    public IIntNetMinorVersionByTenantIdxKey newByTenantIdxKey() {
		IIntNetMinorVersionByTenantIdxKey key = new IntNetJpaMinorVersionByTenantIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaMinorVersionByTenantIdxKey ensureByTenantIdxKey(IIntNetMinorVersionByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaMinorVersionByTenantIdxKey) {
			return( (IntNetJpaMinorVersionByTenantIdxKey)key );
		}
		else {
			IntNetJpaMinorVersionByTenantIdxKey mapped = new IntNetJpaMinorVersionByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetMinorVersionByMajorVerIdxKey newByMajorVerIdxKey() {
		IIntNetMinorVersionByMajorVerIdxKey key = new IntNetJpaMinorVersionByMajorVerIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaMinorVersionByMajorVerIdxKey ensureByMajorVerIdxKey(IIntNetMinorVersionByMajorVerIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaMinorVersionByMajorVerIdxKey) {
			return( (IntNetJpaMinorVersionByMajorVerIdxKey)key );
		}
		else {
			IntNetJpaMinorVersionByMajorVerIdxKey mapped = new IntNetJpaMinorVersionByMajorVerIdxKey();
			mapped.setRequiredMajorVersionId( key.getRequiredMajorVersionId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetMinorVersionByNameIdxKey newByNameIdxKey() {
		IIntNetMinorVersionByNameIdxKey key = new IntNetJpaMinorVersionByNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaMinorVersionByNameIdxKey ensureByNameIdxKey(IIntNetMinorVersionByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaMinorVersionByNameIdxKey) {
			return( (IntNetJpaMinorVersionByNameIdxKey)key );
		}
		else {
			IntNetJpaMinorVersionByNameIdxKey mapped = new IntNetJpaMinorVersionByNameIdxKey();
			mapped.setRequiredMajorVersionId( key.getRequiredMajorVersionId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetMinorVersion newRec() {
        IIntNetMinorVersion rec = new IntNetJpaMinorVersion();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaMinorVersion ensureRec(IIntNetMinorVersion rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof IntNetJpaMinorVersion) {
			return( (IntNetJpaMinorVersion)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IIntNetMinorVersion.CLASS_CODE: {
					IntNetJpaMinorVersion mapped = new IntNetJpaMinorVersion();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetMinorVersion",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetMinorVersion");
			}
		}
	}

    @Override
    public IIntNetMinorVersionH newHRec() {
        IIntNetMinorVersionH hrec = new IntNetJpaMinorVersionH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaMinorVersionH ensureHRec(IIntNetMinorVersionH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof IntNetJpaMinorVersionH) {
			return( (IntNetJpaMinorVersionH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IIntNetMinorVersion.CLASS_CODE: {
					IntNetJpaMinorVersionH mapped = new IntNetJpaMinorVersionH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetMinorVersion",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetMinorVersion");
			}
		}
	}
}
