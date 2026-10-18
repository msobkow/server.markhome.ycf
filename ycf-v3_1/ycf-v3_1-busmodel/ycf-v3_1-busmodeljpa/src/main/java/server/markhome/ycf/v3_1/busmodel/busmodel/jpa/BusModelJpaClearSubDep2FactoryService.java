
// Description: Java 25 Factory service implementation for ClearSubDep2 JPA objects

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
 *	Java 25 Factory service implementation for ClearSubDep2 JPA objects.
 */
public class BusModelJpaClearSubDep2FactoryService
    implements IBusModelClearSubDep2Factory
{
    public BusModelJpaClearSubDep2FactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelClearSubDep2ByClearSubDep1IdxKey newByClearSubDep1IdxKey() {
		IBusModelClearSubDep2ByClearSubDep1IdxKey key = new BusModelJpaClearSubDep2ByClearSubDep1IdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaClearSubDep2ByClearSubDep1IdxKey ensureByClearSubDep1IdxKey(IBusModelClearSubDep2ByClearSubDep1IdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaClearSubDep2ByClearSubDep1IdxKey) {
			return( (BusModelJpaClearSubDep2ByClearSubDep1IdxKey)key );
		}
		else {
			BusModelJpaClearSubDep2ByClearSubDep1IdxKey mapped = new BusModelJpaClearSubDep2ByClearSubDep1IdxKey();
			mapped.setRequiredClearSubDep1Id( key.getRequiredClearSubDep1Id() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelClearSubDep2ByUNameIdxKey newByUNameIdxKey() {
		IBusModelClearSubDep2ByUNameIdxKey key = new BusModelJpaClearSubDep2ByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaClearSubDep2ByUNameIdxKey ensureByUNameIdxKey(IBusModelClearSubDep2ByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaClearSubDep2ByUNameIdxKey) {
			return( (BusModelJpaClearSubDep2ByUNameIdxKey)key );
		}
		else {
			BusModelJpaClearSubDep2ByUNameIdxKey mapped = new BusModelJpaClearSubDep2ByUNameIdxKey();
			mapped.setRequiredClearSubDep1Id( key.getRequiredClearSubDep1Id() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelClearSubDep2 newRec() {
        IBusModelClearSubDep2 rec = new BusModelJpaClearSubDep2();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaClearSubDep2 ensureRec(IBusModelClearSubDep2 rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaClearSubDep2) {
			return( (BusModelJpaClearSubDep2)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelClearSubDep2.CLASS_CODE: {
					BusModelJpaClearSubDep2 mapped = new BusModelJpaClearSubDep2();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelClearSubDep2",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelClearSubDep2");
			}
		}
	}

    @Override
    public IBusModelClearSubDep2H newHRec() {
        IBusModelClearSubDep2H hrec = new BusModelJpaClearSubDep2H();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaClearSubDep2H ensureHRec(IBusModelClearSubDep2H hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaClearSubDep2H) {
			return( (BusModelJpaClearSubDep2H)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelClearSubDep2.CLASS_CODE: {
					BusModelJpaClearSubDep2H mapped = new BusModelJpaClearSubDep2H();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelClearSubDep2",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelClearSubDep2");
			}
		}
	}
}
