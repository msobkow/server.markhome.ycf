
// Description: Java 25 Factory service implementation for Param JPA objects

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
 *	Java 25 Factory service implementation for Param JPA objects.
 */
public class BusModelJpaParamFactoryService
    implements IBusModelParamFactory
{
    public BusModelJpaParamFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelParamHPKey newHPKey() {
        IBusModelParamHPKey hpkey = new BusModelJpaParamHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParamHPKey ensureHPKey(IBusModelParamHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof BusModelJpaParamHPKey) {
			return( (BusModelJpaParamHPKey)key );
		}
		else {
			BusModelJpaParamHPKey mapped = new BusModelJpaParamHPKey();
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
    public IBusModelParamByUNameIdxKey newByUNameIdxKey() {
		IBusModelParamByUNameIdxKey key = new BusModelJpaParamByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParamByUNameIdxKey ensureByUNameIdxKey(IBusModelParamByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaParamByUNameIdxKey) {
			return( (BusModelJpaParamByUNameIdxKey)key );
		}
		else {
			BusModelJpaParamByUNameIdxKey mapped = new BusModelJpaParamByUNameIdxKey();
			mapped.setRequiredServerMethodId( key.getRequiredServerMethodId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelParamByServerMethodIdxKey newByServerMethodIdxKey() {
		IBusModelParamByServerMethodIdxKey key = new BusModelJpaParamByServerMethodIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParamByServerMethodIdxKey ensureByServerMethodIdxKey(IBusModelParamByServerMethodIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaParamByServerMethodIdxKey) {
			return( (BusModelJpaParamByServerMethodIdxKey)key );
		}
		else {
			BusModelJpaParamByServerMethodIdxKey mapped = new BusModelJpaParamByServerMethodIdxKey();
			mapped.setRequiredServerMethodId( key.getRequiredServerMethodId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelParamByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelParamByDefSchemaIdxKey key = new BusModelJpaParamByDefSchemaIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParamByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelParamByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaParamByDefSchemaIdxKey) {
			return( (BusModelJpaParamByDefSchemaIdxKey)key );
		}
		else {
			BusModelJpaParamByDefSchemaIdxKey mapped = new BusModelJpaParamByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelParamByServerTypeIdxKey newByServerTypeIdxKey() {
		IBusModelParamByServerTypeIdxKey key = new BusModelJpaParamByServerTypeIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParamByServerTypeIdxKey ensureByServerTypeIdxKey(IBusModelParamByServerTypeIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaParamByServerTypeIdxKey) {
			return( (BusModelJpaParamByServerTypeIdxKey)key );
		}
		else {
			BusModelJpaParamByServerTypeIdxKey mapped = new BusModelJpaParamByServerTypeIdxKey();
			mapped.setOptionalTypeId( key.getOptionalTypeId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelParamByPrevIdxKey newByPrevIdxKey() {
		IBusModelParamByPrevIdxKey key = new BusModelJpaParamByPrevIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParamByPrevIdxKey ensureByPrevIdxKey(IBusModelParamByPrevIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaParamByPrevIdxKey) {
			return( (BusModelJpaParamByPrevIdxKey)key );
		}
		else {
			BusModelJpaParamByPrevIdxKey mapped = new BusModelJpaParamByPrevIdxKey();
			mapped.setOptionalPrevId( key.getOptionalPrevId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelParamByNextIdxKey newByNextIdxKey() {
		IBusModelParamByNextIdxKey key = new BusModelJpaParamByNextIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParamByNextIdxKey ensureByNextIdxKey(IBusModelParamByNextIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaParamByNextIdxKey) {
			return( (BusModelJpaParamByNextIdxKey)key );
		}
		else {
			BusModelJpaParamByNextIdxKey mapped = new BusModelJpaParamByNextIdxKey();
			mapped.setOptionalNextId( key.getOptionalNextId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelParamByContPrevIdxKey newByContPrevIdxKey() {
		IBusModelParamByContPrevIdxKey key = new BusModelJpaParamByContPrevIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParamByContPrevIdxKey ensureByContPrevIdxKey(IBusModelParamByContPrevIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaParamByContPrevIdxKey) {
			return( (BusModelJpaParamByContPrevIdxKey)key );
		}
		else {
			BusModelJpaParamByContPrevIdxKey mapped = new BusModelJpaParamByContPrevIdxKey();
			mapped.setRequiredServerMethodId( key.getRequiredServerMethodId() );
			mapped.setOptionalPrevId( key.getOptionalPrevId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelParamByContNextIdxKey newByContNextIdxKey() {
		IBusModelParamByContNextIdxKey key = new BusModelJpaParamByContNextIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParamByContNextIdxKey ensureByContNextIdxKey(IBusModelParamByContNextIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaParamByContNextIdxKey) {
			return( (BusModelJpaParamByContNextIdxKey)key );
		}
		else {
			BusModelJpaParamByContNextIdxKey mapped = new BusModelJpaParamByContNextIdxKey();
			mapped.setRequiredServerMethodId( key.getRequiredServerMethodId() );
			mapped.setOptionalNextId( key.getOptionalNextId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelParam newRec() {
        IBusModelParam rec = new BusModelJpaParam();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParam ensureRec(IBusModelParam rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaParam) {
			return( (BusModelJpaParam)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelParam.CLASS_CODE: {
					BusModelJpaParam mapped = new BusModelJpaParam();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelParam",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelParam");
			}
		}
	}

    @Override
    public IBusModelParamH newHRec() {
        IBusModelParamH hrec = new BusModelJpaParamH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParamH ensureHRec(IBusModelParamH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaParamH) {
			return( (BusModelJpaParamH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelParam.CLASS_CODE: {
					BusModelJpaParamH mapped = new BusModelJpaParamH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelParam",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelParam");
			}
		}
	}
}
