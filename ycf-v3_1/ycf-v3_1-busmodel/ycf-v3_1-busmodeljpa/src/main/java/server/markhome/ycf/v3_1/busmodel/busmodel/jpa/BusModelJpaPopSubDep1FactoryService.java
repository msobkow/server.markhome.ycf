
// Description: Java 25 Factory service implementation for PopSubDep1 JPA objects

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
 *	Java 25 Factory service implementation for PopSubDep1 JPA objects.
 */
public class BusModelJpaPopSubDep1FactoryService
    implements IBusModelPopSubDep1Factory
{
    public BusModelJpaPopSubDep1FactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelPopSubDep1ByPopTopDepIdxKey newByPopTopDepIdxKey() {
		IBusModelPopSubDep1ByPopTopDepIdxKey key = new BusModelJpaPopSubDep1ByPopTopDepIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopSubDep1ByPopTopDepIdxKey ensureByPopTopDepIdxKey(IBusModelPopSubDep1ByPopTopDepIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaPopSubDep1ByPopTopDepIdxKey) {
			return( (BusModelJpaPopSubDep1ByPopTopDepIdxKey)key );
		}
		else {
			BusModelJpaPopSubDep1ByPopTopDepIdxKey mapped = new BusModelJpaPopSubDep1ByPopTopDepIdxKey();
			mapped.setRequiredPopTopDepId( key.getRequiredPopTopDepId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelPopSubDep1ByUNameIdxKey newByUNameIdxKey() {
		IBusModelPopSubDep1ByUNameIdxKey key = new BusModelJpaPopSubDep1ByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopSubDep1ByUNameIdxKey ensureByUNameIdxKey(IBusModelPopSubDep1ByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaPopSubDep1ByUNameIdxKey) {
			return( (BusModelJpaPopSubDep1ByUNameIdxKey)key );
		}
		else {
			BusModelJpaPopSubDep1ByUNameIdxKey mapped = new BusModelJpaPopSubDep1ByUNameIdxKey();
			mapped.setRequiredPopTopDepId( key.getRequiredPopTopDepId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelPopSubDep1 newRec() {
        IBusModelPopSubDep1 rec = new BusModelJpaPopSubDep1();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopSubDep1 ensureRec(IBusModelPopSubDep1 rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaPopSubDep1) {
			return( (BusModelJpaPopSubDep1)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelPopSubDep1.CLASS_CODE: {
					BusModelJpaPopSubDep1 mapped = new BusModelJpaPopSubDep1();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelPopSubDep1",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelPopSubDep1");
			}
		}
	}

    @Override
    public IBusModelPopSubDep1H newHRec() {
        IBusModelPopSubDep1H hrec = new BusModelJpaPopSubDep1H();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopSubDep1H ensureHRec(IBusModelPopSubDep1H hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaPopSubDep1H) {
			return( (BusModelJpaPopSubDep1H)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelPopSubDep1.CLASS_CODE: {
					BusModelJpaPopSubDep1H mapped = new BusModelJpaPopSubDep1H();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelPopSubDep1",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelPopSubDep1");
			}
		}
	}
}
