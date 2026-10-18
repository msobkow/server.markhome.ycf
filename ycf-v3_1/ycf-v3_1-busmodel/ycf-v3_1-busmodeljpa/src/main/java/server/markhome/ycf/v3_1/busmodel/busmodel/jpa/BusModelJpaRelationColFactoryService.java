
// Description: Java 25 Factory service implementation for RelationCol JPA objects

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
 *	Java 25 Factory service implementation for RelationCol JPA objects.
 */
public class BusModelJpaRelationColFactoryService
    implements IBusModelRelationColFactory
{
    public BusModelJpaRelationColFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationColHPKey newHPKey() {
        IBusModelRelationColHPKey hpkey = new BusModelJpaRelationColHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationColHPKey ensureHPKey(IBusModelRelationColHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof BusModelJpaRelationColHPKey) {
			return( (BusModelJpaRelationColHPKey)key );
		}
		else {
			BusModelJpaRelationColHPKey mapped = new BusModelJpaRelationColHPKey();
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
    public IBusModelRelationColByUNameIdxKey newByUNameIdxKey() {
		IBusModelRelationColByUNameIdxKey key = new BusModelJpaRelationColByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationColByUNameIdxKey ensureByUNameIdxKey(IBusModelRelationColByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationColByUNameIdxKey) {
			return( (BusModelJpaRelationColByUNameIdxKey)key );
		}
		else {
			BusModelJpaRelationColByUNameIdxKey mapped = new BusModelJpaRelationColByUNameIdxKey();
			mapped.setRequiredRelationId( key.getRequiredRelationId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationColByRelationIdxKey newByRelationIdxKey() {
		IBusModelRelationColByRelationIdxKey key = new BusModelJpaRelationColByRelationIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationColByRelationIdxKey ensureByRelationIdxKey(IBusModelRelationColByRelationIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationColByRelationIdxKey) {
			return( (BusModelJpaRelationColByRelationIdxKey)key );
		}
		else {
			BusModelJpaRelationColByRelationIdxKey mapped = new BusModelJpaRelationColByRelationIdxKey();
			mapped.setRequiredRelationId( key.getRequiredRelationId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationColByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelRelationColByDefSchemaIdxKey key = new BusModelJpaRelationColByDefSchemaIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationColByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelRelationColByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationColByDefSchemaIdxKey) {
			return( (BusModelJpaRelationColByDefSchemaIdxKey)key );
		}
		else {
			BusModelJpaRelationColByDefSchemaIdxKey mapped = new BusModelJpaRelationColByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationColByFromColIdxKey newByFromColIdxKey() {
		IBusModelRelationColByFromColIdxKey key = new BusModelJpaRelationColByFromColIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationColByFromColIdxKey ensureByFromColIdxKey(IBusModelRelationColByFromColIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationColByFromColIdxKey) {
			return( (BusModelJpaRelationColByFromColIdxKey)key );
		}
		else {
			BusModelJpaRelationColByFromColIdxKey mapped = new BusModelJpaRelationColByFromColIdxKey();
			mapped.setRequiredFromColId( key.getRequiredFromColId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationColByToColIdxKey newByToColIdxKey() {
		IBusModelRelationColByToColIdxKey key = new BusModelJpaRelationColByToColIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationColByToColIdxKey ensureByToColIdxKey(IBusModelRelationColByToColIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationColByToColIdxKey) {
			return( (BusModelJpaRelationColByToColIdxKey)key );
		}
		else {
			BusModelJpaRelationColByToColIdxKey mapped = new BusModelJpaRelationColByToColIdxKey();
			mapped.setRequiredToColId( key.getRequiredToColId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationColByPrevIdxKey newByPrevIdxKey() {
		IBusModelRelationColByPrevIdxKey key = new BusModelJpaRelationColByPrevIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationColByPrevIdxKey ensureByPrevIdxKey(IBusModelRelationColByPrevIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationColByPrevIdxKey) {
			return( (BusModelJpaRelationColByPrevIdxKey)key );
		}
		else {
			BusModelJpaRelationColByPrevIdxKey mapped = new BusModelJpaRelationColByPrevIdxKey();
			mapped.setOptionalPrevId( key.getOptionalPrevId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationColByNextIdxKey newByNextIdxKey() {
		IBusModelRelationColByNextIdxKey key = new BusModelJpaRelationColByNextIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationColByNextIdxKey ensureByNextIdxKey(IBusModelRelationColByNextIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationColByNextIdxKey) {
			return( (BusModelJpaRelationColByNextIdxKey)key );
		}
		else {
			BusModelJpaRelationColByNextIdxKey mapped = new BusModelJpaRelationColByNextIdxKey();
			mapped.setOptionalNextId( key.getOptionalNextId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationColByRelPrevIdxKey newByRelPrevIdxKey() {
		IBusModelRelationColByRelPrevIdxKey key = new BusModelJpaRelationColByRelPrevIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationColByRelPrevIdxKey ensureByRelPrevIdxKey(IBusModelRelationColByRelPrevIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationColByRelPrevIdxKey) {
			return( (BusModelJpaRelationColByRelPrevIdxKey)key );
		}
		else {
			BusModelJpaRelationColByRelPrevIdxKey mapped = new BusModelJpaRelationColByRelPrevIdxKey();
			mapped.setRequiredRelationId( key.getRequiredRelationId() );
			mapped.setOptionalPrevId( key.getOptionalPrevId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationColByRelNextIdxKey newByRelNextIdxKey() {
		IBusModelRelationColByRelNextIdxKey key = new BusModelJpaRelationColByRelNextIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationColByRelNextIdxKey ensureByRelNextIdxKey(IBusModelRelationColByRelNextIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationColByRelNextIdxKey) {
			return( (BusModelJpaRelationColByRelNextIdxKey)key );
		}
		else {
			BusModelJpaRelationColByRelNextIdxKey mapped = new BusModelJpaRelationColByRelNextIdxKey();
			mapped.setRequiredRelationId( key.getRequiredRelationId() );
			mapped.setOptionalNextId( key.getOptionalNextId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationCol newRec() {
        IBusModelRelationCol rec = new BusModelJpaRelationCol();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationCol ensureRec(IBusModelRelationCol rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaRelationCol) {
			return( (BusModelJpaRelationCol)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelRelationCol.CLASS_CODE: {
					BusModelJpaRelationCol mapped = new BusModelJpaRelationCol();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelRelationCol",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelRelationCol");
			}
		}
	}

    @Override
    public IBusModelRelationColH newHRec() {
        IBusModelRelationColH hrec = new BusModelJpaRelationColH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationColH ensureHRec(IBusModelRelationColH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaRelationColH) {
			return( (BusModelJpaRelationColH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelRelationCol.CLASS_CODE: {
					BusModelJpaRelationColH mapped = new BusModelJpaRelationColH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelRelationCol",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelRelationCol");
			}
		}
	}
}
