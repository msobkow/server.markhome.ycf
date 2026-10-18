
// Description: Java 25 Factory service implementation for MajorVersion JPA objects

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
 *	Java 25 Factory service implementation for MajorVersion JPA objects.
 */
public class IntNetJpaMajorVersionFactoryService
    implements IIntNetMajorVersionFactory
{
    public IntNetJpaMajorVersionFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetMajorVersionHPKey newHPKey() {
        IIntNetMajorVersionHPKey hpkey = new IntNetJpaMajorVersionHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaMajorVersionHPKey ensureHPKey(IIntNetMajorVersionHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof IntNetJpaMajorVersionHPKey) {
			return( (IntNetJpaMajorVersionHPKey)key );
		}
		else {
			IntNetJpaMajorVersionHPKey mapped = new IntNetJpaMajorVersionHPKey();
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
    public IIntNetMajorVersionByTenantIdxKey newByTenantIdxKey() {
		IIntNetMajorVersionByTenantIdxKey key = new IntNetJpaMajorVersionByTenantIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaMajorVersionByTenantIdxKey ensureByTenantIdxKey(IIntNetMajorVersionByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaMajorVersionByTenantIdxKey) {
			return( (IntNetJpaMajorVersionByTenantIdxKey)key );
		}
		else {
			IntNetJpaMajorVersionByTenantIdxKey mapped = new IntNetJpaMajorVersionByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetMajorVersionBySubProjectIdxKey newBySubProjectIdxKey() {
		IIntNetMajorVersionBySubProjectIdxKey key = new IntNetJpaMajorVersionBySubProjectIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaMajorVersionBySubProjectIdxKey ensureBySubProjectIdxKey(IIntNetMajorVersionBySubProjectIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaMajorVersionBySubProjectIdxKey) {
			return( (IntNetJpaMajorVersionBySubProjectIdxKey)key );
		}
		else {
			IntNetJpaMajorVersionBySubProjectIdxKey mapped = new IntNetJpaMajorVersionBySubProjectIdxKey();
			mapped.setRequiredSubProjectId( key.getRequiredSubProjectId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetMajorVersionByNameIdxKey newByNameIdxKey() {
		IIntNetMajorVersionByNameIdxKey key = new IntNetJpaMajorVersionByNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaMajorVersionByNameIdxKey ensureByNameIdxKey(IIntNetMajorVersionByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaMajorVersionByNameIdxKey) {
			return( (IntNetJpaMajorVersionByNameIdxKey)key );
		}
		else {
			IntNetJpaMajorVersionByNameIdxKey mapped = new IntNetJpaMajorVersionByNameIdxKey();
			mapped.setRequiredSubProjectId( key.getRequiredSubProjectId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetMajorVersion newRec() {
        IIntNetMajorVersion rec = new IntNetJpaMajorVersion();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaMajorVersion ensureRec(IIntNetMajorVersion rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof IntNetJpaMajorVersion) {
			return( (IntNetJpaMajorVersion)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IIntNetMajorVersion.CLASS_CODE: {
					IntNetJpaMajorVersion mapped = new IntNetJpaMajorVersion();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetMajorVersion",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetMajorVersion");
			}
		}
	}

    @Override
    public IIntNetMajorVersionH newHRec() {
        IIntNetMajorVersionH hrec = new IntNetJpaMajorVersionH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaMajorVersionH ensureHRec(IIntNetMajorVersionH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof IntNetJpaMajorVersionH) {
			return( (IntNetJpaMajorVersionH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IIntNetMajorVersion.CLASS_CODE: {
					IntNetJpaMajorVersionH mapped = new IntNetJpaMajorVersionH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetMajorVersion",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetMajorVersion");
			}
		}
	}
}
