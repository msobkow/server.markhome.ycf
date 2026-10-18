
// Description: Java 25 Factory service implementation for Chain JPA objects

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
 *	Java 25 Factory service implementation for Chain JPA objects.
 */
public class BusModelJpaChainFactoryService
    implements IBusModelChainFactory
{
    public BusModelJpaChainFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelChainHPKey newHPKey() {
        IBusModelChainHPKey hpkey = new BusModelJpaChainHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaChainHPKey ensureHPKey(IBusModelChainHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof BusModelJpaChainHPKey) {
			return( (BusModelJpaChainHPKey)key );
		}
		else {
			BusModelJpaChainHPKey mapped = new BusModelJpaChainHPKey();
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
    public IBusModelChainByChainTableIdxKey newByChainTableIdxKey() {
		IBusModelChainByChainTableIdxKey key = new BusModelJpaChainByChainTableIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaChainByChainTableIdxKey ensureByChainTableIdxKey(IBusModelChainByChainTableIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaChainByChainTableIdxKey) {
			return( (BusModelJpaChainByChainTableIdxKey)key );
		}
		else {
			BusModelJpaChainByChainTableIdxKey mapped = new BusModelJpaChainByChainTableIdxKey();
			mapped.setRequiredTableId( key.getRequiredTableId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelChainByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelChainByDefSchemaIdxKey key = new BusModelJpaChainByDefSchemaIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaChainByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelChainByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaChainByDefSchemaIdxKey) {
			return( (BusModelJpaChainByDefSchemaIdxKey)key );
		}
		else {
			BusModelJpaChainByDefSchemaIdxKey mapped = new BusModelJpaChainByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelChainByUNameIdxKey newByUNameIdxKey() {
		IBusModelChainByUNameIdxKey key = new BusModelJpaChainByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaChainByUNameIdxKey ensureByUNameIdxKey(IBusModelChainByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaChainByUNameIdxKey) {
			return( (BusModelJpaChainByUNameIdxKey)key );
		}
		else {
			BusModelJpaChainByUNameIdxKey mapped = new BusModelJpaChainByUNameIdxKey();
			mapped.setRequiredTableId( key.getRequiredTableId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelChainByPrevRelIdxKey newByPrevRelIdxKey() {
		IBusModelChainByPrevRelIdxKey key = new BusModelJpaChainByPrevRelIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaChainByPrevRelIdxKey ensureByPrevRelIdxKey(IBusModelChainByPrevRelIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaChainByPrevRelIdxKey) {
			return( (BusModelJpaChainByPrevRelIdxKey)key );
		}
		else {
			BusModelJpaChainByPrevRelIdxKey mapped = new BusModelJpaChainByPrevRelIdxKey();
			mapped.setRequiredPrevRelationId( key.getRequiredPrevRelationId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelChainByNextRelIdxKey newByNextRelIdxKey() {
		IBusModelChainByNextRelIdxKey key = new BusModelJpaChainByNextRelIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaChainByNextRelIdxKey ensureByNextRelIdxKey(IBusModelChainByNextRelIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaChainByNextRelIdxKey) {
			return( (BusModelJpaChainByNextRelIdxKey)key );
		}
		else {
			BusModelJpaChainByNextRelIdxKey mapped = new BusModelJpaChainByNextRelIdxKey();
			mapped.setRequiredNextRelationId( key.getRequiredNextRelationId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelChain newRec() {
        IBusModelChain rec = new BusModelJpaChain();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaChain ensureRec(IBusModelChain rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaChain) {
			return( (BusModelJpaChain)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelChain.CLASS_CODE: {
					BusModelJpaChain mapped = new BusModelJpaChain();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelChain",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelChain");
			}
		}
	}

    @Override
    public IBusModelChainH newHRec() {
        IBusModelChainH hrec = new BusModelJpaChainH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaChainH ensureHRec(IBusModelChainH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaChainH) {
			return( (BusModelJpaChainH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelChain.CLASS_CODE: {
					BusModelJpaChainH mapped = new BusModelJpaChainH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelChain",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelChain");
			}
		}
	}
}
