
// Description: Java 25 Factory service implementation for ClearDep JPA objects

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
 *	Java 25 Factory service implementation for ClearDep JPA objects.
 */
public class BusModelJpaClearDepFactoryService
    implements IBusModelClearDepFactory
{
    public BusModelJpaClearDepFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelClearDepByClearDepIdxKey newByClearDepIdxKey() {
		IBusModelClearDepByClearDepIdxKey key = new BusModelJpaClearDepByClearDepIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaClearDepByClearDepIdxKey ensureByClearDepIdxKey(IBusModelClearDepByClearDepIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaClearDepByClearDepIdxKey) {
			return( (BusModelJpaClearDepByClearDepIdxKey)key );
		}
		else {
			BusModelJpaClearDepByClearDepIdxKey mapped = new BusModelJpaClearDepByClearDepIdxKey();
			mapped.setRequiredRelationId( key.getRequiredRelationId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelClearDepByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelClearDepByDefSchemaIdxKey key = new BusModelJpaClearDepByDefSchemaIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaClearDepByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelClearDepByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaClearDepByDefSchemaIdxKey) {
			return( (BusModelJpaClearDepByDefSchemaIdxKey)key );
		}
		else {
			BusModelJpaClearDepByDefSchemaIdxKey mapped = new BusModelJpaClearDepByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelClearDep newRec() {
        IBusModelClearDep rec = new BusModelJpaClearDep();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaClearDep ensureRec(IBusModelClearDep rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaClearDep) {
			return( (BusModelJpaClearDep)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelClearDep.CLASS_CODE: {
					BusModelJpaClearDep mapped = new BusModelJpaClearDep();
					mapped.set(rec);
					return( mapped ); }
				case IBusModelClearSubDep1.CLASS_CODE: {
					BusModelJpaClearSubDep1 mapped = new BusModelJpaClearSubDep1();
					mapped.set((IBusModelClearSubDep1)rec);
					return(mapped); }
				case IBusModelClearSubDep2.CLASS_CODE: {
					BusModelJpaClearSubDep2 mapped = new BusModelJpaClearSubDep2();
					mapped.set((IBusModelClearSubDep2)rec);
					return(mapped); }
				case IBusModelClearSubDep3.CLASS_CODE: {
					BusModelJpaClearSubDep3 mapped = new BusModelJpaClearSubDep3();
					mapped.set((IBusModelClearSubDep3)rec);
					return(mapped); }
				case IBusModelClearTopDep.CLASS_CODE: {
					BusModelJpaClearTopDep mapped = new BusModelJpaClearTopDep();
					mapped.set((IBusModelClearTopDep)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelClearDep",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelClearDep");
			}
		}
	}

    @Override
    public IBusModelClearDepH newHRec() {
        IBusModelClearDepH hrec = new BusModelJpaClearDepH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaClearDepH ensureHRec(IBusModelClearDepH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaClearDepH) {
			return( (BusModelJpaClearDepH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelClearDep.CLASS_CODE: {
					BusModelJpaClearDepH mapped = new BusModelJpaClearDepH();
					mapped.set(hrec);
					return( mapped ); }
				case IBusModelClearSubDep1.CLASS_CODE: {
					BusModelJpaClearSubDep1H mapped = new BusModelJpaClearSubDep1H();
					mapped.set((IBusModelClearSubDep1H)hrec);
					return(mapped); }
				case IBusModelClearSubDep2.CLASS_CODE: {
					BusModelJpaClearSubDep2H mapped = new BusModelJpaClearSubDep2H();
					mapped.set((IBusModelClearSubDep2H)hrec);
					return(mapped); }
				case IBusModelClearSubDep3.CLASS_CODE: {
					BusModelJpaClearSubDep3H mapped = new BusModelJpaClearSubDep3H();
					mapped.set((IBusModelClearSubDep3H)hrec);
					return(mapped); }
				case IBusModelClearTopDep.CLASS_CODE: {
					BusModelJpaClearTopDepH mapped = new BusModelJpaClearTopDepH();
					mapped.set((IBusModelClearTopDepH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelClearDep",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelClearDep");
			}
		}
	}
}
