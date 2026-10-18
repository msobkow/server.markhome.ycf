
// Description: Java 25 Factory service implementation for License JPA objects

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
 *	Java 25 Factory service implementation for License JPA objects.
 */
public class IntNetJpaLicenseFactoryService
    implements IIntNetLicenseFactory
{
    public IntNetJpaLicenseFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetLicenseHPKey newHPKey() {
        IIntNetLicenseHPKey hpkey = new IntNetJpaLicenseHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaLicenseHPKey ensureHPKey(IIntNetLicenseHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof IntNetJpaLicenseHPKey) {
			return( (IntNetJpaLicenseHPKey)key );
		}
		else {
			IntNetJpaLicenseHPKey mapped = new IntNetJpaLicenseHPKey();
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
    public IIntNetLicenseByLicnTenantIdxKey newByLicnTenantIdxKey() {
		IIntNetLicenseByLicnTenantIdxKey key = new IntNetJpaLicenseByLicnTenantIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaLicenseByLicnTenantIdxKey ensureByLicnTenantIdxKey(IIntNetLicenseByLicnTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaLicenseByLicnTenantIdxKey) {
			return( (IntNetJpaLicenseByLicnTenantIdxKey)key );
		}
		else {
			IntNetJpaLicenseByLicnTenantIdxKey mapped = new IntNetJpaLicenseByLicnTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetLicenseByDomainIdxKey newByDomainIdxKey() {
		IIntNetLicenseByDomainIdxKey key = new IntNetJpaLicenseByDomainIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaLicenseByDomainIdxKey ensureByDomainIdxKey(IIntNetLicenseByDomainIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaLicenseByDomainIdxKey) {
			return( (IntNetJpaLicenseByDomainIdxKey)key );
		}
		else {
			IntNetJpaLicenseByDomainIdxKey mapped = new IntNetJpaLicenseByDomainIdxKey();
			mapped.setRequiredTopDomainId( key.getRequiredTopDomainId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetLicenseByUNameIdxKey newByUNameIdxKey() {
		IIntNetLicenseByUNameIdxKey key = new IntNetJpaLicenseByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaLicenseByUNameIdxKey ensureByUNameIdxKey(IIntNetLicenseByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetJpaLicenseByUNameIdxKey) {
			return( (IntNetJpaLicenseByUNameIdxKey)key );
		}
		else {
			IntNetJpaLicenseByUNameIdxKey mapped = new IntNetJpaLicenseByUNameIdxKey();
			mapped.setRequiredTopDomainId( key.getRequiredTopDomainId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
    public IIntNetLicense newRec() {
        IIntNetLicense rec = new IntNetJpaLicense();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaLicense ensureRec(IIntNetLicense rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof IntNetJpaLicense) {
			return( (IntNetJpaLicense)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IIntNetLicense.CLASS_CODE: {
					IntNetJpaLicense mapped = new IntNetJpaLicense();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetLicense",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetLicense");
			}
		}
	}

    @Override
    public IIntNetLicenseH newHRec() {
        IIntNetLicenseH hrec = new IntNetJpaLicenseH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaLicenseH ensureHRec(IIntNetLicenseH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof IntNetJpaLicenseH) {
			return( (IntNetJpaLicenseH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IIntNetLicense.CLASS_CODE: {
					IntNetJpaLicenseH mapped = new IntNetJpaLicenseH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetLicense",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetLicense");
			}
		}
	}
}
