
// Description: Java 25 Factory service implementation for Table JPA objects

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
 *	Java 25 Factory service implementation for Table JPA objects.
 */
public class BusModelJpaTableFactoryService
    implements IBusModelTableFactory
{
    public BusModelJpaTableFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelTableBySchemaDefIdxKey newBySchemaDefIdxKey() {
		IBusModelTableBySchemaDefIdxKey key = new BusModelJpaTableBySchemaDefIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableBySchemaDefIdxKey ensureBySchemaDefIdxKey(IBusModelTableBySchemaDefIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaTableBySchemaDefIdxKey) {
			return( (BusModelJpaTableBySchemaDefIdxKey)key );
		}
		else {
			BusModelJpaTableBySchemaDefIdxKey mapped = new BusModelJpaTableBySchemaDefIdxKey();
			mapped.setRequiredSchemaDefId( key.getRequiredSchemaDefId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelTableByCodeVisIdxKey newByCodeVisIdxKey() {
		IBusModelTableByCodeVisIdxKey key = new BusModelJpaTableByCodeVisIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableByCodeVisIdxKey ensureByCodeVisIdxKey(IBusModelTableByCodeVisIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaTableByCodeVisIdxKey) {
			return( (BusModelJpaTableByCodeVisIdxKey)key );
		}
		else {
			BusModelJpaTableByCodeVisIdxKey mapped = new BusModelJpaTableByCodeVisIdxKey();
			mapped.setRequiredCodeVis( key.getRequiredCodeVis() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelTableBySchemaCodeVisIdxKey newBySchemaCodeVisIdxKey() {
		IBusModelTableBySchemaCodeVisIdxKey key = new BusModelJpaTableBySchemaCodeVisIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableBySchemaCodeVisIdxKey ensureBySchemaCodeVisIdxKey(IBusModelTableBySchemaCodeVisIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaTableBySchemaCodeVisIdxKey) {
			return( (BusModelJpaTableBySchemaCodeVisIdxKey)key );
		}
		else {
			BusModelJpaTableBySchemaCodeVisIdxKey mapped = new BusModelJpaTableBySchemaCodeVisIdxKey();
			mapped.setRequiredSchemaDefId( key.getRequiredSchemaDefId() );
			mapped.setRequiredCodeVis( key.getRequiredCodeVis() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelTableByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelTableByDefSchemaIdxKey key = new BusModelJpaTableByDefSchemaIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelTableByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaTableByDefSchemaIdxKey) {
			return( (BusModelJpaTableByDefSchemaIdxKey)key );
		}
		else {
			BusModelJpaTableByDefSchemaIdxKey mapped = new BusModelJpaTableByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelTableByUNameIdxKey newByUNameIdxKey() {
		IBusModelTableByUNameIdxKey key = new BusModelJpaTableByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableByUNameIdxKey ensureByUNameIdxKey(IBusModelTableByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaTableByUNameIdxKey) {
			return( (BusModelJpaTableByUNameIdxKey)key );
		}
		else {
			BusModelJpaTableByUNameIdxKey mapped = new BusModelJpaTableByUNameIdxKey();
			mapped.setRequiredSchemaDefId( key.getRequiredSchemaDefId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelTableBySchemaCdIdxKey newBySchemaCdIdxKey() {
		IBusModelTableBySchemaCdIdxKey key = new BusModelJpaTableBySchemaCdIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableBySchemaCdIdxKey ensureBySchemaCdIdxKey(IBusModelTableBySchemaCdIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaTableBySchemaCdIdxKey) {
			return( (BusModelJpaTableBySchemaCdIdxKey)key );
		}
		else {
			BusModelJpaTableBySchemaCdIdxKey mapped = new BusModelJpaTableBySchemaCdIdxKey();
			mapped.setRequiredSchemaDefId( key.getRequiredSchemaDefId() );
			mapped.setRequiredTableClassCode( key.getRequiredTableClassCode() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelTableByPrimaryIndexIdxKey newByPrimaryIndexIdxKey() {
		IBusModelTableByPrimaryIndexIdxKey key = new BusModelJpaTableByPrimaryIndexIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableByPrimaryIndexIdxKey ensureByPrimaryIndexIdxKey(IBusModelTableByPrimaryIndexIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaTableByPrimaryIndexIdxKey) {
			return( (BusModelJpaTableByPrimaryIndexIdxKey)key );
		}
		else {
			BusModelJpaTableByPrimaryIndexIdxKey mapped = new BusModelJpaTableByPrimaryIndexIdxKey();
			mapped.setOptionalPrimaryIndexId( key.getOptionalPrimaryIndexId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelTableByLookupIndexIdxKey newByLookupIndexIdxKey() {
		IBusModelTableByLookupIndexIdxKey key = new BusModelJpaTableByLookupIndexIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableByLookupIndexIdxKey ensureByLookupIndexIdxKey(IBusModelTableByLookupIndexIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaTableByLookupIndexIdxKey) {
			return( (BusModelJpaTableByLookupIndexIdxKey)key );
		}
		else {
			BusModelJpaTableByLookupIndexIdxKey mapped = new BusModelJpaTableByLookupIndexIdxKey();
			mapped.setOptionalLookupIndexId( key.getOptionalLookupIndexId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelTableByAltIndexIdxKey newByAltIndexIdxKey() {
		IBusModelTableByAltIndexIdxKey key = new BusModelJpaTableByAltIndexIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableByAltIndexIdxKey ensureByAltIndexIdxKey(IBusModelTableByAltIndexIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaTableByAltIndexIdxKey) {
			return( (BusModelJpaTableByAltIndexIdxKey)key );
		}
		else {
			BusModelJpaTableByAltIndexIdxKey mapped = new BusModelJpaTableByAltIndexIdxKey();
			mapped.setOptionalAltIndexId( key.getOptionalAltIndexId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelTableByQualTableIdxKey newByQualTableIdxKey() {
		IBusModelTableByQualTableIdxKey key = new BusModelJpaTableByQualTableIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableByQualTableIdxKey ensureByQualTableIdxKey(IBusModelTableByQualTableIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaTableByQualTableIdxKey) {
			return( (BusModelJpaTableByQualTableIdxKey)key );
		}
		else {
			BusModelJpaTableByQualTableIdxKey mapped = new BusModelJpaTableByQualTableIdxKey();
			mapped.setOptionalQualifyingTableId( key.getOptionalQualifyingTableId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelTable newRec() {
        IBusModelTable rec = new BusModelJpaTable();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTable ensureRec(IBusModelTable rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaTable) {
			return( (BusModelJpaTable)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelTable.CLASS_CODE: {
					BusModelJpaTable mapped = new BusModelJpaTable();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelTable",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelTable");
			}
		}
	}

    @Override
    public IBusModelTableH newHRec() {
        IBusModelTableH hrec = new BusModelJpaTableH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableH ensureHRec(IBusModelTableH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaTableH) {
			return( (BusModelJpaTableH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelTable.CLASS_CODE: {
					BusModelJpaTableH mapped = new BusModelJpaTableH();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelTable",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelTable");
			}
		}
	}
}
