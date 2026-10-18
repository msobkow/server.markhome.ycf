
// Description: Java 25 Factory service implementation for TopProject JPA objects

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
 *	Java 25 Factory service implementation for TopProject JPA objects.
 */
public class IntNetJpaTopProjectFactoryService
    implements IIntNetTopProjectFactory
{
    public IntNetJpaTopProjectFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetTopProjectHPKey newHPKey() {
        IIntNetTopProjectHPKey hpkey = new IntNetJpaTopProjectHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTopProjectHPKey ensureHPKey(IIntNetTopProjectHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof IntNetJpaTopProjectHPKey) {
			return( (IntNetJpaTopProjectHPKey)key );
		}
		else {
			IntNetJpaTopProjectHPKey mapped = new IntNetJpaTopProjectHPKey();
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
    public IIntNetTopProjectByTenantIdxKey newByTenantIdxKey() {
		IIntNetTopProjectByTenantIdxKey key = new IntNetJpaTopProjectByTenantIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTopProjectByTenantIdxKey ensureByTenantIdxKey(IIntNetTopProjectByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaTopProjectByTenantIdxKey) {
			return( (IntNetJpaTopProjectByTenantIdxKey)key );
		}
		else {
			IntNetJpaTopProjectByTenantIdxKey mapped = new IntNetJpaTopProjectByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetTopProjectByTopDomainIdxKey newByTopDomainIdxKey() {
		IIntNetTopProjectByTopDomainIdxKey key = new IntNetJpaTopProjectByTopDomainIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTopProjectByTopDomainIdxKey ensureByTopDomainIdxKey(IIntNetTopProjectByTopDomainIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaTopProjectByTopDomainIdxKey) {
			return( (IntNetJpaTopProjectByTopDomainIdxKey)key );
		}
		else {
			IntNetJpaTopProjectByTopDomainIdxKey mapped = new IntNetJpaTopProjectByTopDomainIdxKey();
			mapped.setRequiredTopDomainId( key.getRequiredTopDomainId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetTopProjectByNameIdxKey newByNameIdxKey() {
		IIntNetTopProjectByNameIdxKey key = new IntNetJpaTopProjectByNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTopProjectByNameIdxKey ensureByNameIdxKey(IIntNetTopProjectByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaTopProjectByNameIdxKey) {
			return( (IntNetJpaTopProjectByNameIdxKey)key );
		}
		else {
			IntNetJpaTopProjectByNameIdxKey mapped = new IntNetJpaTopProjectByNameIdxKey();
			mapped.setRequiredTopDomainId( key.getRequiredTopDomainId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetTopProject newRec() {
        IIntNetTopProject rec = new IntNetJpaTopProject();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTopProject ensureRec(IIntNetTopProject rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof IntNetJpaTopProject) {
			return( (IntNetJpaTopProject)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IIntNetTopProject.CLASS_CODE: {
					IntNetJpaTopProject mapped = new IntNetJpaTopProject();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetTopProject",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetTopProject");
			}
		}
	}

    @Override
    public IIntNetTopProjectH newHRec() {
        IIntNetTopProjectH hrec = new IntNetJpaTopProjectH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTopProjectH ensureHRec(IIntNetTopProjectH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof IntNetJpaTopProjectH) {
			return( (IntNetJpaTopProjectH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IIntNetTopProject.CLASS_CODE: {
					IntNetJpaTopProjectH mapped = new IntNetJpaTopProjectH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetTopProject",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetTopProject");
			}
		}
	}
}
