
// Description: Java 25 Factory service implementation for PopSubDep2 JPA objects

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
 *	Java 25 Factory service implementation for PopSubDep2 JPA objects.
 */
public class BusModelJpaPopSubDep2FactoryService
    implements IBusModelPopSubDep2Factory
{
    public BusModelJpaPopSubDep2FactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelPopSubDep2ByPopSubDep1IdxKey newByPopSubDep1IdxKey() {
		IBusModelPopSubDep2ByPopSubDep1IdxKey key = new BusModelJpaPopSubDep2ByPopSubDep1IdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopSubDep2ByPopSubDep1IdxKey ensureByPopSubDep1IdxKey(IBusModelPopSubDep2ByPopSubDep1IdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaPopSubDep2ByPopSubDep1IdxKey) {
			return( (BusModelJpaPopSubDep2ByPopSubDep1IdxKey)key );
		}
		else {
			BusModelJpaPopSubDep2ByPopSubDep1IdxKey mapped = new BusModelJpaPopSubDep2ByPopSubDep1IdxKey();
			mapped.setRequiredPopSubDep1Id( key.getRequiredPopSubDep1Id() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelPopSubDep2ByUNameIdxKey newByUNameIdxKey() {
		IBusModelPopSubDep2ByUNameIdxKey key = new BusModelJpaPopSubDep2ByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopSubDep2ByUNameIdxKey ensureByUNameIdxKey(IBusModelPopSubDep2ByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaPopSubDep2ByUNameIdxKey) {
			return( (BusModelJpaPopSubDep2ByUNameIdxKey)key );
		}
		else {
			BusModelJpaPopSubDep2ByUNameIdxKey mapped = new BusModelJpaPopSubDep2ByUNameIdxKey();
			mapped.setRequiredPopSubDep1Id( key.getRequiredPopSubDep1Id() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelPopSubDep2 newRec() {
        IBusModelPopSubDep2 rec = new BusModelJpaPopSubDep2();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopSubDep2 ensureRec(IBusModelPopSubDep2 rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaPopSubDep2) {
			return( (BusModelJpaPopSubDep2)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelPopSubDep2.CLASS_CODE: {
					BusModelJpaPopSubDep2 mapped = new BusModelJpaPopSubDep2();
					mapped.set(rec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelPopSubDep2",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelPopSubDep2");
			}
		}
	}

    @Override
    public IBusModelPopSubDep2H newHRec() {
        IBusModelPopSubDep2H hrec = new BusModelJpaPopSubDep2H();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopSubDep2H ensureHRec(IBusModelPopSubDep2H hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaPopSubDep2H) {
			return( (BusModelJpaPopSubDep2H)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelPopSubDep2.CLASS_CODE: {
					BusModelJpaPopSubDep2H mapped = new BusModelJpaPopSubDep2H();
					mapped.set(hrec);
					return( mapped ); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelPopSubDep2",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelPopSubDep2");
			}
		}
	}
}
