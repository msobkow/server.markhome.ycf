
// Description: Java 25 Factory service implementation for EnumTag JPA objects

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
 *	Java 25 Factory service implementation for EnumTag JPA objects.
 */
public class BusModelJpaEnumTagFactoryService
    implements IBusModelEnumTagFactory
{
    public BusModelJpaEnumTagFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelEnumTagHPKey newHPKey() {
        IBusModelEnumTagHPKey hpkey = new BusModelJpaEnumTagHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaEnumTagHPKey ensureHPKey(IBusModelEnumTagHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof BusModelJpaEnumTagHPKey) {
			return( (BusModelJpaEnumTagHPKey)key );
		}
		else {
			BusModelJpaEnumTagHPKey mapped = new BusModelJpaEnumTagHPKey();
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
    public IBusModelEnumTagByEnumIdxKey newByEnumIdxKey() {
		IBusModelEnumTagByEnumIdxKey key = new BusModelJpaEnumTagByEnumIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaEnumTagByEnumIdxKey ensureByEnumIdxKey(IBusModelEnumTagByEnumIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaEnumTagByEnumIdxKey) {
			return( (BusModelJpaEnumTagByEnumIdxKey)key );
		}
		else {
			BusModelJpaEnumTagByEnumIdxKey mapped = new BusModelJpaEnumTagByEnumIdxKey();
			mapped.setRequiredEnumId( key.getRequiredEnumId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelEnumTagByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelEnumTagByDefSchemaIdxKey key = new BusModelJpaEnumTagByDefSchemaIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaEnumTagByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelEnumTagByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaEnumTagByDefSchemaIdxKey) {
			return( (BusModelJpaEnumTagByDefSchemaIdxKey)key );
		}
		else {
			BusModelJpaEnumTagByDefSchemaIdxKey mapped = new BusModelJpaEnumTagByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelEnumTagByEnumNameIdxKey newByEnumNameIdxKey() {
		IBusModelEnumTagByEnumNameIdxKey key = new BusModelJpaEnumTagByEnumNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaEnumTagByEnumNameIdxKey ensureByEnumNameIdxKey(IBusModelEnumTagByEnumNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaEnumTagByEnumNameIdxKey) {
			return( (BusModelJpaEnumTagByEnumNameIdxKey)key );
		}
		else {
			BusModelJpaEnumTagByEnumNameIdxKey mapped = new BusModelJpaEnumTagByEnumNameIdxKey();
			mapped.setRequiredEnumId( key.getRequiredEnumId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelEnumTagByPrevIdxKey newByPrevIdxKey() {
		IBusModelEnumTagByPrevIdxKey key = new BusModelJpaEnumTagByPrevIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaEnumTagByPrevIdxKey ensureByPrevIdxKey(IBusModelEnumTagByPrevIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaEnumTagByPrevIdxKey) {
			return( (BusModelJpaEnumTagByPrevIdxKey)key );
		}
		else {
			BusModelJpaEnumTagByPrevIdxKey mapped = new BusModelJpaEnumTagByPrevIdxKey();
			mapped.setOptionalPrevId( key.getOptionalPrevId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelEnumTagByNextIdxKey newByNextIdxKey() {
		IBusModelEnumTagByNextIdxKey key = new BusModelJpaEnumTagByNextIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaEnumTagByNextIdxKey ensureByNextIdxKey(IBusModelEnumTagByNextIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaEnumTagByNextIdxKey) {
			return( (BusModelJpaEnumTagByNextIdxKey)key );
		}
		else {
			BusModelJpaEnumTagByNextIdxKey mapped = new BusModelJpaEnumTagByNextIdxKey();
			mapped.setOptionalNextId( key.getOptionalNextId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelEnumTag newRec() {
        IBusModelEnumTag rec = new BusModelJpaEnumTag();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaEnumTag ensureRec(IBusModelEnumTag rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaEnumTag) {
			return( (BusModelJpaEnumTag)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelEnumTag.CLASS_CODE: {
					BusModelJpaEnumTag mapped = new BusModelJpaEnumTag();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelEnumTag",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelEnumTag");
			}
		}
	}

    @Override
    public IBusModelEnumTagH newHRec() {
        IBusModelEnumTagH hrec = new BusModelJpaEnumTagH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaEnumTagH ensureHRec(IBusModelEnumTagH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaEnumTagH) {
			return( (BusModelJpaEnumTagH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelEnumTag.CLASS_CODE: {
					BusModelJpaEnumTagH mapped = new BusModelJpaEnumTagH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelEnumTag",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelEnumTag");
			}
		}
	}
}
