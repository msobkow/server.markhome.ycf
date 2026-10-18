
// Description: Java 25 Factory service implementation for PopDep JPA objects

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
 *	Java 25 Factory service implementation for PopDep JPA objects.
 */
public class BusModelJpaPopDepFactoryService
    implements IBusModelPopDepFactory
{
    public BusModelJpaPopDepFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelPopDepByRelationIdxKey newByRelationIdxKey() {
		IBusModelPopDepByRelationIdxKey key = new BusModelJpaPopDepByRelationIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopDepByRelationIdxKey ensureByRelationIdxKey(IBusModelPopDepByRelationIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaPopDepByRelationIdxKey) {
			return( (BusModelJpaPopDepByRelationIdxKey)key );
		}
		else {
			BusModelJpaPopDepByRelationIdxKey mapped = new BusModelJpaPopDepByRelationIdxKey();
			mapped.setRequiredRelationId( key.getRequiredRelationId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelPopDepByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelPopDepByDefSchemaIdxKey key = new BusModelJpaPopDepByDefSchemaIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopDepByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelPopDepByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaPopDepByDefSchemaIdxKey) {
			return( (BusModelJpaPopDepByDefSchemaIdxKey)key );
		}
		else {
			BusModelJpaPopDepByDefSchemaIdxKey mapped = new BusModelJpaPopDepByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelPopDep newRec() {
        IBusModelPopDep rec = new BusModelJpaPopDep();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopDep ensureRec(IBusModelPopDep rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaPopDep) {
			return( (BusModelJpaPopDep)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelPopDep.CLASS_CODE: {
					BusModelJpaPopDep mapped = new BusModelJpaPopDep();
					mapped.set(rec);
					return( mapped ); }
				case IBusModelPopSubDep1.CLASS_CODE: {
					BusModelJpaPopSubDep1 mapped = new BusModelJpaPopSubDep1();
					mapped.set((IBusModelPopSubDep1)rec);
					return(mapped); }
				case IBusModelPopSubDep2.CLASS_CODE: {
					BusModelJpaPopSubDep2 mapped = new BusModelJpaPopSubDep2();
					mapped.set((IBusModelPopSubDep2)rec);
					return(mapped); }
				case IBusModelPopSubDep3.CLASS_CODE: {
					BusModelJpaPopSubDep3 mapped = new BusModelJpaPopSubDep3();
					mapped.set((IBusModelPopSubDep3)rec);
					return(mapped); }
				case IBusModelPopTopDep.CLASS_CODE: {
					BusModelJpaPopTopDep mapped = new BusModelJpaPopTopDep();
					mapped.set((IBusModelPopTopDep)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelPopDep",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelPopDep");
			}
		}
	}

    @Override
    public IBusModelPopDepH newHRec() {
        IBusModelPopDepH hrec = new BusModelJpaPopDepH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopDepH ensureHRec(IBusModelPopDepH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaPopDepH) {
			return( (BusModelJpaPopDepH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelPopDep.CLASS_CODE: {
					BusModelJpaPopDepH mapped = new BusModelJpaPopDepH();
					mapped.set(hrec);
					return( mapped ); }
				case IBusModelPopSubDep1.CLASS_CODE: {
					BusModelJpaPopSubDep1H mapped = new BusModelJpaPopSubDep1H();
					mapped.set((IBusModelPopSubDep1H)hrec);
					return(mapped); }
				case IBusModelPopSubDep2.CLASS_CODE: {
					BusModelJpaPopSubDep2H mapped = new BusModelJpaPopSubDep2H();
					mapped.set((IBusModelPopSubDep2H)hrec);
					return(mapped); }
				case IBusModelPopSubDep3.CLASS_CODE: {
					BusModelJpaPopSubDep3H mapped = new BusModelJpaPopSubDep3H();
					mapped.set((IBusModelPopSubDep3H)hrec);
					return(mapped); }
				case IBusModelPopTopDep.CLASS_CODE: {
					BusModelJpaPopTopDepH mapped = new BusModelJpaPopTopDepH();
					mapped.set((IBusModelPopTopDepH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelPopDep",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelPopDep");
			}
		}
	}
}
