
// Description: Java 25 Factory service implementation for Relation JPA objects

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
 *	Java 25 Factory service implementation for Relation JPA objects.
 */
public class BusModelJpaRelationFactoryService
    implements IBusModelRelationFactory
{
    public BusModelJpaRelationFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationByUNameIdxKey newByUNameIdxKey() {
		IBusModelRelationByUNameIdxKey key = new BusModelJpaRelationByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationByUNameIdxKey ensureByUNameIdxKey(IBusModelRelationByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationByUNameIdxKey) {
			return( (BusModelJpaRelationByUNameIdxKey)key );
		}
		else {
			BusModelJpaRelationByUNameIdxKey mapped = new BusModelJpaRelationByUNameIdxKey();
			mapped.setRequiredTableId( key.getRequiredTableId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationByRelTableIdxKey newByRelTableIdxKey() {
		IBusModelRelationByRelTableIdxKey key = new BusModelJpaRelationByRelTableIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationByRelTableIdxKey ensureByRelTableIdxKey(IBusModelRelationByRelTableIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationByRelTableIdxKey) {
			return( (BusModelJpaRelationByRelTableIdxKey)key );
		}
		else {
			BusModelJpaRelationByRelTableIdxKey mapped = new BusModelJpaRelationByRelTableIdxKey();
			mapped.setRequiredTableId( key.getRequiredTableId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationByRelCodeVisIdxKey newByRelCodeVisIdxKey() {
		IBusModelRelationByRelCodeVisIdxKey key = new BusModelJpaRelationByRelCodeVisIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationByRelCodeVisIdxKey ensureByRelCodeVisIdxKey(IBusModelRelationByRelCodeVisIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationByRelCodeVisIdxKey) {
			return( (BusModelJpaRelationByRelCodeVisIdxKey)key );
		}
		else {
			BusModelJpaRelationByRelCodeVisIdxKey mapped = new BusModelJpaRelationByRelCodeVisIdxKey();
			mapped.setRequiredCodeVis( key.getRequiredCodeVis() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationByRelTableCodeVisXKey newByRelTableCodeVisXKey() {
		IBusModelRelationByRelTableCodeVisXKey key = new BusModelJpaRelationByRelTableCodeVisXKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationByRelTableCodeVisXKey ensureByRelTableCodeVisXKey(IBusModelRelationByRelTableCodeVisXKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationByRelTableCodeVisXKey) {
			return( (BusModelJpaRelationByRelTableCodeVisXKey)key );
		}
		else {
			BusModelJpaRelationByRelTableCodeVisXKey mapped = new BusModelJpaRelationByRelTableCodeVisXKey();
			mapped.setRequiredTableId( key.getRequiredTableId() );
			mapped.setRequiredCodeVis( key.getRequiredCodeVis() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelRelationByDefSchemaIdxKey key = new BusModelJpaRelationByDefSchemaIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelRelationByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationByDefSchemaIdxKey) {
			return( (BusModelJpaRelationByDefSchemaIdxKey)key );
		}
		else {
			BusModelJpaRelationByDefSchemaIdxKey mapped = new BusModelJpaRelationByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationByFromKeyIdxKey newByFromKeyIdxKey() {
		IBusModelRelationByFromKeyIdxKey key = new BusModelJpaRelationByFromKeyIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationByFromKeyIdxKey ensureByFromKeyIdxKey(IBusModelRelationByFromKeyIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationByFromKeyIdxKey) {
			return( (BusModelJpaRelationByFromKeyIdxKey)key );
		}
		else {
			BusModelJpaRelationByFromKeyIdxKey mapped = new BusModelJpaRelationByFromKeyIdxKey();
			mapped.setRequiredFromIndexId( key.getRequiredFromIndexId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationByToTblIdxKey newByToTblIdxKey() {
		IBusModelRelationByToTblIdxKey key = new BusModelJpaRelationByToTblIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationByToTblIdxKey ensureByToTblIdxKey(IBusModelRelationByToTblIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationByToTblIdxKey) {
			return( (BusModelJpaRelationByToTblIdxKey)key );
		}
		else {
			BusModelJpaRelationByToTblIdxKey mapped = new BusModelJpaRelationByToTblIdxKey();
			mapped.setRequiredToTableId( key.getRequiredToTableId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationByToKeyIdxKey newByToKeyIdxKey() {
		IBusModelRelationByToKeyIdxKey key = new BusModelJpaRelationByToKeyIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationByToKeyIdxKey ensureByToKeyIdxKey(IBusModelRelationByToKeyIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationByToKeyIdxKey) {
			return( (BusModelJpaRelationByToKeyIdxKey)key );
		}
		else {
			BusModelJpaRelationByToKeyIdxKey mapped = new BusModelJpaRelationByToKeyIdxKey();
			mapped.setRequiredToIndexId( key.getRequiredToIndexId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelationByNarrowedIdxKey newByNarrowedIdxKey() {
		IBusModelRelationByNarrowedIdxKey key = new BusModelJpaRelationByNarrowedIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationByNarrowedIdxKey ensureByNarrowedIdxKey(IBusModelRelationByNarrowedIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaRelationByNarrowedIdxKey) {
			return( (BusModelJpaRelationByNarrowedIdxKey)key );
		}
		else {
			BusModelJpaRelationByNarrowedIdxKey mapped = new BusModelJpaRelationByNarrowedIdxKey();
			mapped.setOptionalNarrowedId( key.getOptionalNarrowedId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelRelation newRec() {
        IBusModelRelation rec = new BusModelJpaRelation();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelation ensureRec(IBusModelRelation rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaRelation) {
			return( (BusModelJpaRelation)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelRelation.CLASS_CODE: {
					BusModelJpaRelation mapped = new BusModelJpaRelation();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelRelation",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelRelation");
			}
		}
	}

    @Override
    public IBusModelRelationH newHRec() {
        IBusModelRelationH hrec = new BusModelJpaRelationH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationH ensureHRec(IBusModelRelationH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaRelationH) {
			return( (BusModelJpaRelationH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelRelation.CLASS_CODE: {
					BusModelJpaRelationH mapped = new BusModelJpaRelationH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelRelation",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelRelation");
			}
		}
	}
}
