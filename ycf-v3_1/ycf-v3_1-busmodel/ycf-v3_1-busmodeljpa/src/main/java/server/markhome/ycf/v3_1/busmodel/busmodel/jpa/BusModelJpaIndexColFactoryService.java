
// Description: Java 25 Factory service implementation for IndexCol JPA objects

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
 *	Java 25 Factory service implementation for IndexCol JPA objects.
 */
public class BusModelJpaIndexColFactoryService
    implements IBusModelIndexColFactory
{
    public BusModelJpaIndexColFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelIndexColHPKey newHPKey() {
        IBusModelIndexColHPKey hpkey = new BusModelJpaIndexColHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexColHPKey ensureHPKey(IBusModelIndexColHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof BusModelJpaIndexColHPKey) {
			return( (BusModelJpaIndexColHPKey)key );
		}
		else {
			BusModelJpaIndexColHPKey mapped = new BusModelJpaIndexColHPKey();
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
    public IBusModelIndexColByUNameIdxKey newByUNameIdxKey() {
		IBusModelIndexColByUNameIdxKey key = new BusModelJpaIndexColByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexColByUNameIdxKey ensureByUNameIdxKey(IBusModelIndexColByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaIndexColByUNameIdxKey) {
			return( (BusModelJpaIndexColByUNameIdxKey)key );
		}
		else {
			BusModelJpaIndexColByUNameIdxKey mapped = new BusModelJpaIndexColByUNameIdxKey();
			mapped.setRequiredIndexId( key.getRequiredIndexId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelIndexColByIndexIdxKey newByIndexIdxKey() {
		IBusModelIndexColByIndexIdxKey key = new BusModelJpaIndexColByIndexIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexColByIndexIdxKey ensureByIndexIdxKey(IBusModelIndexColByIndexIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaIndexColByIndexIdxKey) {
			return( (BusModelJpaIndexColByIndexIdxKey)key );
		}
		else {
			BusModelJpaIndexColByIndexIdxKey mapped = new BusModelJpaIndexColByIndexIdxKey();
			mapped.setRequiredIndexId( key.getRequiredIndexId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelIndexColByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelIndexColByDefSchemaIdxKey key = new BusModelJpaIndexColByDefSchemaIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexColByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelIndexColByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaIndexColByDefSchemaIdxKey) {
			return( (BusModelJpaIndexColByDefSchemaIdxKey)key );
		}
		else {
			BusModelJpaIndexColByDefSchemaIdxKey mapped = new BusModelJpaIndexColByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelIndexColByColIdxKey newByColIdxKey() {
		IBusModelIndexColByColIdxKey key = new BusModelJpaIndexColByColIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexColByColIdxKey ensureByColIdxKey(IBusModelIndexColByColIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaIndexColByColIdxKey) {
			return( (BusModelJpaIndexColByColIdxKey)key );
		}
		else {
			BusModelJpaIndexColByColIdxKey mapped = new BusModelJpaIndexColByColIdxKey();
			mapped.setRequiredColumnId( key.getRequiredColumnId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelIndexColByPrevIdxKey newByPrevIdxKey() {
		IBusModelIndexColByPrevIdxKey key = new BusModelJpaIndexColByPrevIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexColByPrevIdxKey ensureByPrevIdxKey(IBusModelIndexColByPrevIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaIndexColByPrevIdxKey) {
			return( (BusModelJpaIndexColByPrevIdxKey)key );
		}
		else {
			BusModelJpaIndexColByPrevIdxKey mapped = new BusModelJpaIndexColByPrevIdxKey();
			mapped.setOptionalPrevId( key.getOptionalPrevId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelIndexColByNextIdxKey newByNextIdxKey() {
		IBusModelIndexColByNextIdxKey key = new BusModelJpaIndexColByNextIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexColByNextIdxKey ensureByNextIdxKey(IBusModelIndexColByNextIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaIndexColByNextIdxKey) {
			return( (BusModelJpaIndexColByNextIdxKey)key );
		}
		else {
			BusModelJpaIndexColByNextIdxKey mapped = new BusModelJpaIndexColByNextIdxKey();
			mapped.setOptionalNextId( key.getOptionalNextId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelIndexColByIdxPrevIdxKey newByIdxPrevIdxKey() {
		IBusModelIndexColByIdxPrevIdxKey key = new BusModelJpaIndexColByIdxPrevIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexColByIdxPrevIdxKey ensureByIdxPrevIdxKey(IBusModelIndexColByIdxPrevIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaIndexColByIdxPrevIdxKey) {
			return( (BusModelJpaIndexColByIdxPrevIdxKey)key );
		}
		else {
			BusModelJpaIndexColByIdxPrevIdxKey mapped = new BusModelJpaIndexColByIdxPrevIdxKey();
			mapped.setRequiredIndexId( key.getRequiredIndexId() );
			mapped.setOptionalPrevId( key.getOptionalPrevId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelIndexColByIdxNextIdxKey newByIdxNextIdxKey() {
		IBusModelIndexColByIdxNextIdxKey key = new BusModelJpaIndexColByIdxNextIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexColByIdxNextIdxKey ensureByIdxNextIdxKey(IBusModelIndexColByIdxNextIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaIndexColByIdxNextIdxKey) {
			return( (BusModelJpaIndexColByIdxNextIdxKey)key );
		}
		else {
			BusModelJpaIndexColByIdxNextIdxKey mapped = new BusModelJpaIndexColByIdxNextIdxKey();
			mapped.setRequiredIndexId( key.getRequiredIndexId() );
			mapped.setOptionalNextId( key.getOptionalNextId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelIndexCol newRec() {
        IBusModelIndexCol rec = new BusModelJpaIndexCol();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexCol ensureRec(IBusModelIndexCol rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaIndexCol) {
			return( (BusModelJpaIndexCol)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelIndexCol.CLASS_CODE: {
					BusModelJpaIndexCol mapped = new BusModelJpaIndexCol();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelIndexCol",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelIndexCol");
			}
		}
	}

    @Override
    public IBusModelIndexColH newHRec() {
        IBusModelIndexColH hrec = new BusModelJpaIndexColH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexColH ensureHRec(IBusModelIndexColH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaIndexColH) {
			return( (BusModelJpaIndexColH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelIndexCol.CLASS_CODE: {
					BusModelJpaIndexColH mapped = new BusModelJpaIndexColH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelIndexCol",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelIndexCol");
			}
		}
	}
}
