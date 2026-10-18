
// Description: Java 25 Factory service implementation for DbKeyHash512Type JPA objects

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
 *	Java 25 Factory service implementation for DbKeyHash512Type JPA objects.
 */
public class BusModelJpaDbKeyHash512TypeFactoryService
    implements IBusModelDbKeyHash512TypeFactory
{
    public BusModelJpaDbKeyHash512TypeFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelDbKeyHash512TypeBySchemaIdxKey newBySchemaIdxKey() {
		IBusModelDbKeyHash512TypeBySchemaIdxKey key = new BusModelJpaDbKeyHash512TypeBySchemaIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDbKeyHash512TypeBySchemaIdxKey ensureBySchemaIdxKey(IBusModelDbKeyHash512TypeBySchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaDbKeyHash512TypeBySchemaIdxKey) {
			return( (BusModelJpaDbKeyHash512TypeBySchemaIdxKey)key );
		}
		else {
			BusModelJpaDbKeyHash512TypeBySchemaIdxKey mapped = new BusModelJpaDbKeyHash512TypeBySchemaIdxKey();
			mapped.setRequiredSchemaDefId( key.getRequiredSchemaDefId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelDbKeyHash512Type newRec() {
        IBusModelDbKeyHash512Type rec = new BusModelJpaDbKeyHash512Type();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDbKeyHash512Type ensureRec(IBusModelDbKeyHash512Type rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaDbKeyHash512Type) {
			return( (BusModelJpaDbKeyHash512Type)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelDbKeyHash512Type.CLASS_CODE: {
					BusModelJpaDbKeyHash512Type mapped = new BusModelJpaDbKeyHash512Type();
					mapped.set(rec);
					return( mapped ); }
				case IBusModelDbKeyHash512Gen.CLASS_CODE: {
					BusModelJpaDbKeyHash512Gen mapped = new BusModelJpaDbKeyHash512Gen();
					mapped.set((IBusModelDbKeyHash512Gen)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelDbKeyHash512Type",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelDbKeyHash512Type");
			}
		}
	}

    @Override
    public IBusModelDbKeyHash512TypeH newHRec() {
        IBusModelDbKeyHash512TypeH hrec = new BusModelJpaDbKeyHash512TypeH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDbKeyHash512TypeH ensureHRec(IBusModelDbKeyHash512TypeH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaDbKeyHash512TypeH) {
			return( (BusModelJpaDbKeyHash512TypeH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelDbKeyHash512Type.CLASS_CODE: {
					BusModelJpaDbKeyHash512TypeH mapped = new BusModelJpaDbKeyHash512TypeH();
					mapped.set(hrec);
					return( mapped ); }
				case IBusModelDbKeyHash512Gen.CLASS_CODE: {
					BusModelJpaDbKeyHash512GenH mapped = new BusModelJpaDbKeyHash512GenH();
					mapped.set((IBusModelDbKeyHash512GenH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelDbKeyHash512Type",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelDbKeyHash512Type");
			}
		}
	}
}
