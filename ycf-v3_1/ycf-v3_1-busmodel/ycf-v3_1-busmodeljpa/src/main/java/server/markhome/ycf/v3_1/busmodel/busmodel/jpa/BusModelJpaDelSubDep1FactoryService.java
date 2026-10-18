
// Description: Java 25 Factory service implementation for DelSubDep1 JPA objects

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
 *	Java 25 Factory service implementation for DelSubDep1 JPA objects.
 */
public class BusModelJpaDelSubDep1FactoryService
    implements IBusModelDelSubDep1Factory
{
    public BusModelJpaDelSubDep1FactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelDelSubDep1ByDelTopDepIdxKey newByDelTopDepIdxKey() {
		IBusModelDelSubDep1ByDelTopDepIdxKey key = new BusModelJpaDelSubDep1ByDelTopDepIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDelSubDep1ByDelTopDepIdxKey ensureByDelTopDepIdxKey(IBusModelDelSubDep1ByDelTopDepIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaDelSubDep1ByDelTopDepIdxKey) {
			return( (BusModelJpaDelSubDep1ByDelTopDepIdxKey)key );
		}
		else {
			BusModelJpaDelSubDep1ByDelTopDepIdxKey mapped = new BusModelJpaDelSubDep1ByDelTopDepIdxKey();
			mapped.setRequiredDelTopDepId( key.getRequiredDelTopDepId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelDelSubDep1ByUNameIdxKey newByUNameIdxKey() {
		IBusModelDelSubDep1ByUNameIdxKey key = new BusModelJpaDelSubDep1ByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDelSubDep1ByUNameIdxKey ensureByUNameIdxKey(IBusModelDelSubDep1ByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaDelSubDep1ByUNameIdxKey) {
			return( (BusModelJpaDelSubDep1ByUNameIdxKey)key );
		}
		else {
			BusModelJpaDelSubDep1ByUNameIdxKey mapped = new BusModelJpaDelSubDep1ByUNameIdxKey();
			mapped.setRequiredDelTopDepId( key.getRequiredDelTopDepId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelDelSubDep1 newRec() {
        IBusModelDelSubDep1 rec = new BusModelJpaDelSubDep1();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDelSubDep1 ensureRec(IBusModelDelSubDep1 rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaDelSubDep1) {
			return( (BusModelJpaDelSubDep1)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelDelSubDep1.CLASS_CODE: {
					BusModelJpaDelSubDep1 mapped = new BusModelJpaDelSubDep1();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelDelSubDep1",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelDelSubDep1");
			}
		}
	}

    @Override
    public IBusModelDelSubDep1H newHRec() {
        IBusModelDelSubDep1H hrec = new BusModelJpaDelSubDep1H();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDelSubDep1H ensureHRec(IBusModelDelSubDep1H hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaDelSubDep1H) {
			return( (BusModelJpaDelSubDep1H)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelDelSubDep1.CLASS_CODE: {
					BusModelJpaDelSubDep1H mapped = new BusModelJpaDelSubDep1H();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelDelSubDep1",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelDelSubDep1");
			}
		}
	}
}
