
// Description: Java 25 Factory service implementation for SchemaRef JPA objects

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
 *	Java 25 Factory service implementation for SchemaRef JPA objects.
 */
public class BusModelJpaSchemaRefFactoryService
    implements IBusModelSchemaRefFactory
{
    public BusModelJpaSchemaRefFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelSchemaRefBySchemaIdxKey newBySchemaIdxKey() {
		IBusModelSchemaRefBySchemaIdxKey key = new BusModelJpaSchemaRefBySchemaIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRefBySchemaIdxKey ensureBySchemaIdxKey(IBusModelSchemaRefBySchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaSchemaRefBySchemaIdxKey) {
			return( (BusModelJpaSchemaRefBySchemaIdxKey)key );
		}
		else {
			BusModelJpaSchemaRefBySchemaIdxKey mapped = new BusModelJpaSchemaRefBySchemaIdxKey();
			mapped.setRequiredSchemaId( key.getRequiredSchemaId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelSchemaRefByUNameIdxKey newByUNameIdxKey() {
		IBusModelSchemaRefByUNameIdxKey key = new BusModelJpaSchemaRefByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRefByUNameIdxKey ensureByUNameIdxKey(IBusModelSchemaRefByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaSchemaRefByUNameIdxKey) {
			return( (BusModelJpaSchemaRefByUNameIdxKey)key );
		}
		else {
			BusModelJpaSchemaRefByUNameIdxKey mapped = new BusModelJpaSchemaRefByUNameIdxKey();
			mapped.setRequiredSchemaId( key.getRequiredSchemaId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelSchemaRefByRefSchemaIdxKey newByRefSchemaIdxKey() {
		IBusModelSchemaRefByRefSchemaIdxKey key = new BusModelJpaSchemaRefByRefSchemaIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRefByRefSchemaIdxKey ensureByRefSchemaIdxKey(IBusModelSchemaRefByRefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaSchemaRefByRefSchemaIdxKey) {
			return( (BusModelJpaSchemaRefByRefSchemaIdxKey)key );
		}
		else {
			BusModelJpaSchemaRefByRefSchemaIdxKey mapped = new BusModelJpaSchemaRefByRefSchemaIdxKey();
			mapped.setOptionalRefSchemaId( key.getOptionalRefSchemaId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelSchemaRefByPrevIdxKey newByPrevIdxKey() {
		IBusModelSchemaRefByPrevIdxKey key = new BusModelJpaSchemaRefByPrevIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRefByPrevIdxKey ensureByPrevIdxKey(IBusModelSchemaRefByPrevIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaSchemaRefByPrevIdxKey) {
			return( (BusModelJpaSchemaRefByPrevIdxKey)key );
		}
		else {
			BusModelJpaSchemaRefByPrevIdxKey mapped = new BusModelJpaSchemaRefByPrevIdxKey();
			mapped.setOptionalPrevId( key.getOptionalPrevId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelSchemaRefByNextIdxKey newByNextIdxKey() {
		IBusModelSchemaRefByNextIdxKey key = new BusModelJpaSchemaRefByNextIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRefByNextIdxKey ensureByNextIdxKey(IBusModelSchemaRefByNextIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaSchemaRefByNextIdxKey) {
			return( (BusModelJpaSchemaRefByNextIdxKey)key );
		}
		else {
			BusModelJpaSchemaRefByNextIdxKey mapped = new BusModelJpaSchemaRefByNextIdxKey();
			mapped.setOptionalNextId( key.getOptionalNextId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelSchemaRef newRec() {
        IBusModelSchemaRef rec = new BusModelJpaSchemaRef();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRef ensureRec(IBusModelSchemaRef rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaSchemaRef) {
			return( (BusModelJpaSchemaRef)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelSchemaRef.CLASS_CODE: {
					BusModelJpaSchemaRef mapped = new BusModelJpaSchemaRef();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelSchemaRef",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelSchemaRef");
			}
		}
	}

    @Override
    public IBusModelSchemaRefH newHRec() {
        IBusModelSchemaRefH hrec = new BusModelJpaSchemaRefH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRefH ensureHRec(IBusModelSchemaRefH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaSchemaRefH) {
			return( (BusModelJpaSchemaRefH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelSchemaRef.CLASS_CODE: {
					BusModelJpaSchemaRefH mapped = new BusModelJpaSchemaRefH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelSchemaRef",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelSchemaRef");
			}
		}
	}
}
