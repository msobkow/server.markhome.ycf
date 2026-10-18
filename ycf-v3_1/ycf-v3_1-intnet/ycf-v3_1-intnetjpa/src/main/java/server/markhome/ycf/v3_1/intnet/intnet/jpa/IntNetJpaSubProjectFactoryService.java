
// Description: Java 25 Factory service implementation for SubProject JPA objects

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
 *	Java 25 Factory service implementation for SubProject JPA objects.
 */
public class IntNetJpaSubProjectFactoryService
    implements IIntNetSubProjectFactory
{
    public IntNetJpaSubProjectFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetSubProjectHPKey newHPKey() {
        IIntNetSubProjectHPKey hpkey = new IntNetJpaSubProjectHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaSubProjectHPKey ensureHPKey(IIntNetSubProjectHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof IntNetJpaSubProjectHPKey) {
			return( (IntNetJpaSubProjectHPKey)key );
		}
		else {
			IntNetJpaSubProjectHPKey mapped = new IntNetJpaSubProjectHPKey();
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
    public IIntNetSubProjectByTenantIdxKey newByTenantIdxKey() {
		IIntNetSubProjectByTenantIdxKey key = new IntNetJpaSubProjectByTenantIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaSubProjectByTenantIdxKey ensureByTenantIdxKey(IIntNetSubProjectByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaSubProjectByTenantIdxKey) {
			return( (IntNetJpaSubProjectByTenantIdxKey)key );
		}
		else {
			IntNetJpaSubProjectByTenantIdxKey mapped = new IntNetJpaSubProjectByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetSubProjectByTopProjectIdxKey newByTopProjectIdxKey() {
		IIntNetSubProjectByTopProjectIdxKey key = new IntNetJpaSubProjectByTopProjectIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaSubProjectByTopProjectIdxKey ensureByTopProjectIdxKey(IIntNetSubProjectByTopProjectIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaSubProjectByTopProjectIdxKey) {
			return( (IntNetJpaSubProjectByTopProjectIdxKey)key );
		}
		else {
			IntNetJpaSubProjectByTopProjectIdxKey mapped = new IntNetJpaSubProjectByTopProjectIdxKey();
			mapped.setRequiredTopProjectId( key.getRequiredTopProjectId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetSubProjectByNameIdxKey newByNameIdxKey() {
		IIntNetSubProjectByNameIdxKey key = new IntNetJpaSubProjectByNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaSubProjectByNameIdxKey ensureByNameIdxKey(IIntNetSubProjectByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaSubProjectByNameIdxKey) {
			return( (IntNetJpaSubProjectByNameIdxKey)key );
		}
		else {
			IntNetJpaSubProjectByNameIdxKey mapped = new IntNetJpaSubProjectByNameIdxKey();
			mapped.setRequiredTopProjectId( key.getRequiredTopProjectId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetSubProject newRec() {
        IIntNetSubProject rec = new IntNetJpaSubProject();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaSubProject ensureRec(IIntNetSubProject rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof IntNetJpaSubProject) {
			return( (IntNetJpaSubProject)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IIntNetSubProject.CLASS_CODE: {
					IntNetJpaSubProject mapped = new IntNetJpaSubProject();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetSubProject",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetSubProject");
			}
		}
	}

    @Override
    public IIntNetSubProjectH newHRec() {
        IIntNetSubProjectH hrec = new IntNetJpaSubProjectH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaSubProjectH ensureHRec(IIntNetSubProjectH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof IntNetJpaSubProjectH) {
			return( (IntNetJpaSubProjectH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IIntNetSubProject.CLASS_CODE: {
					IntNetJpaSubProjectH mapped = new IntNetJpaSubProjectH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetSubProject",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetSubProject");
			}
		}
	}
}
