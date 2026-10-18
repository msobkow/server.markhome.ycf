
// Description: Java 25 Factory service implementation for Int32Def JPA objects

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
 *	Java 25 Factory service implementation for Int32Def JPA objects.
 */
public class BusModelJpaInt32DefFactoryService
    implements IBusModelInt32DefFactory
{
    public BusModelJpaInt32DefFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelInt32Def newRec() {
        IBusModelInt32Def rec = new BusModelJpaInt32Def();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaInt32Def ensureRec(IBusModelInt32Def rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaInt32Def) {
			return( (BusModelJpaInt32Def)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelInt32Def.CLASS_CODE: {
					BusModelJpaInt32Def mapped = new BusModelJpaInt32Def();
					mapped.set(rec);
					return( mapped ); }
				case IBusModelInt32Type.CLASS_CODE: {
					BusModelJpaInt32Type mapped = new BusModelJpaInt32Type();
					mapped.set((IBusModelInt32Type)rec);
					return(mapped); }
				case IBusModelId32Gen.CLASS_CODE: {
					BusModelJpaId32Gen mapped = new BusModelJpaId32Gen();
					mapped.set((IBusModelId32Gen)rec);
					return(mapped); }
				case IBusModelInt32Col.CLASS_CODE: {
					BusModelJpaInt32Col mapped = new BusModelJpaInt32Col();
					mapped.set((IBusModelInt32Col)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelInt32Def",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelInt32Def");
			}
		}
	}

    @Override
    public IBusModelInt32DefH newHRec() {
        IBusModelInt32DefH hrec = new BusModelJpaInt32DefH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaInt32DefH ensureHRec(IBusModelInt32DefH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaInt32DefH) {
			return( (BusModelJpaInt32DefH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelInt32Def.CLASS_CODE: {
					BusModelJpaInt32DefH mapped = new BusModelJpaInt32DefH();
					mapped.set(hrec);
					return( mapped ); }
				case IBusModelInt32Type.CLASS_CODE: {
					BusModelJpaInt32TypeH mapped = new BusModelJpaInt32TypeH();
					mapped.set((IBusModelInt32TypeH)hrec);
					return(mapped); }
				case IBusModelId32Gen.CLASS_CODE: {
					BusModelJpaId32GenH mapped = new BusModelJpaId32GenH();
					mapped.set((IBusModelId32GenH)hrec);
					return(mapped); }
				case IBusModelInt32Col.CLASS_CODE: {
					BusModelJpaInt32ColH mapped = new BusModelJpaInt32ColH();
					mapped.set((IBusModelInt32ColH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelInt32Def",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelInt32Def");
			}
		}
	}
}
