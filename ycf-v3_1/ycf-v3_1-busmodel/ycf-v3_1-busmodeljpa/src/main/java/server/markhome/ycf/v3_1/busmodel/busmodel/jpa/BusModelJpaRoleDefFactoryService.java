
// Description: Java 25 Factory service implementation for RoleDef JPA objects

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodel.jpa;

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
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.*;
import server.markhome.ycf.v3_1.intnet.intnet.jpa.*;

/*
 *	Java 25 Factory service implementation for RoleDef JPA objects.
 */
public class BusModelJpaRoleDefFactoryService
    implements IBusModelRoleDefFactory
{
    public BusModelJpaRoleDefFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRoleDefHPKey newHPKey() {
        IBusModelRoleDefHPKey hpkey = new BusModelJpaRoleDefHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRoleDefHPKey ensureHPKey(IBusModelRoleDefHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof BusModelJpaRoleDefHPKey) {
			return( (BusModelJpaRoleDefHPKey)key );
		}
		else {
			BusModelJpaRoleDefHPKey mapped = new BusModelJpaRoleDefHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRoleDefByUNameIdxKey newByUNameIdxKey() {
		IBusModelRoleDefByUNameIdxKey key = new BusModelJpaRoleDefByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRoleDefByUNameIdxKey ensureByUNameIdxKey(IBusModelRoleDefByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRoleDefByUNameIdxKey) {
			return( (BusModelJpaRoleDefByUNameIdxKey)key );
		}
		else {
			BusModelJpaRoleDefByUNameIdxKey mapped = new BusModelJpaRoleDefByUNameIdxKey();
			mapped.setRequiredScopeId( key.getRequiredScopeId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRoleDefByScopeIdxKey newByScopeIdxKey() {
		IBusModelRoleDefByScopeIdxKey key = new BusModelJpaRoleDefByScopeIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRoleDefByScopeIdxKey ensureByScopeIdxKey(IBusModelRoleDefByScopeIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRoleDefByScopeIdxKey) {
			return( (BusModelJpaRoleDefByScopeIdxKey)key );
		}
		else {
			BusModelJpaRoleDefByScopeIdxKey mapped = new BusModelJpaRoleDefByScopeIdxKey();
			mapped.setRequiredScopeId( key.getRequiredScopeId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRoleDefByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelRoleDefByDefSchemaIdxKey key = new BusModelJpaRoleDefByDefSchemaIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRoleDefByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelRoleDefByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRoleDefByDefSchemaIdxKey) {
			return( (BusModelJpaRoleDefByDefSchemaIdxKey)key );
		}
		else {
			BusModelJpaRoleDefByDefSchemaIdxKey mapped = new BusModelJpaRoleDefByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRoleDefByUDefIdxKey newByUDefIdxKey() {
		IBusModelRoleDefByUDefIdxKey key = new BusModelJpaRoleDefByUDefIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRoleDefByUDefIdxKey ensureByUDefIdxKey(IBusModelRoleDefByUDefIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRoleDefByUDefIdxKey) {
			return( (BusModelJpaRoleDefByUDefIdxKey)key );
		}
		else {
			BusModelJpaRoleDefByUDefIdxKey mapped = new BusModelJpaRoleDefByUDefIdxKey();
			mapped.setRequiredScopeId( key.getRequiredScopeId() );
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRoleDef newRec() {
        IBusModelRoleDef rec = new BusModelJpaRoleDef();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRoleDef ensureRec(IBusModelRoleDef rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaRoleDef) {
			return( (BusModelJpaRoleDef)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelRoleDef.CLASS_CODE: {
					BusModelJpaRoleDef mapped = new BusModelJpaRoleDef();
					mapped.set(rec);
					return( mapped ); }
				case IBusModelSchemaRole.CLASS_CODE: {
					BusModelJpaSchemaRole mapped = new BusModelJpaSchemaRole();
					mapped.set((IBusModelSchemaRole)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelRoleDef",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelRoleDef");
			}
		}
	}

    @Override
    public IBusModelRoleDefH newHRec() {
        IBusModelRoleDefH hrec = new BusModelJpaRoleDefH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRoleDefH ensureHRec(IBusModelRoleDefH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaRoleDefH) {
			return( (BusModelJpaRoleDefH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelRoleDef.CLASS_CODE: {
					BusModelJpaRoleDefH mapped = new BusModelJpaRoleDefH();
					mapped.set(hrec);
					return( mapped ); }
				case IBusModelSchemaRole.CLASS_CODE: {
					BusModelJpaSchemaRoleH mapped = new BusModelJpaSchemaRoleH();
					mapped.set((IBusModelSchemaRoleH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelRoleDef",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelRoleDef");
			}
		}
	}
}
