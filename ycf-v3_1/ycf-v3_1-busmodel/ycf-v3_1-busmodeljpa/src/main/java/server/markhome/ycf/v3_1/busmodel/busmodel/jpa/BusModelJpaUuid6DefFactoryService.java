
// Description: Java 25 Factory service implementation for Uuid6Def JPA objects

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
 *	Java 25 Factory service implementation for Uuid6Def JPA objects.
 */
public class BusModelJpaUuid6DefFactoryService
    implements IBusModelUuid6DefFactory
{
    public BusModelJpaUuid6DefFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelUuid6Def newRec() {
        IBusModelUuid6Def rec = new BusModelJpaUuid6Def();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaUuid6Def ensureRec(IBusModelUuid6Def rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaUuid6Def) {
			return( (BusModelJpaUuid6Def)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelUuid6Def.CLASS_CODE: {
					BusModelJpaUuid6Def mapped = new BusModelJpaUuid6Def();
					mapped.set(rec);
					return( mapped ); }
				case IBusModelUuid6Type.CLASS_CODE: {
					BusModelJpaUuid6Type mapped = new BusModelJpaUuid6Type();
					mapped.set((IBusModelUuid6Type)rec);
					return(mapped); }
				case IBusModelUuid6Gen.CLASS_CODE: {
					BusModelJpaUuid6Gen mapped = new BusModelJpaUuid6Gen();
					mapped.set((IBusModelUuid6Gen)rec);
					return(mapped); }
				case IBusModelUuid6Col.CLASS_CODE: {
					BusModelJpaUuid6Col mapped = new BusModelJpaUuid6Col();
					mapped.set((IBusModelUuid6Col)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelUuid6Def",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelUuid6Def");
			}
		}
	}

    @Override
    public IBusModelUuid6DefH newHRec() {
        IBusModelUuid6DefH hrec = new BusModelJpaUuid6DefH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaUuid6DefH ensureHRec(IBusModelUuid6DefH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaUuid6DefH) {
			return( (BusModelJpaUuid6DefH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelUuid6Def.CLASS_CODE: {
					BusModelJpaUuid6DefH mapped = new BusModelJpaUuid6DefH();
					mapped.set(hrec);
					return( mapped ); }
				case IBusModelUuid6Type.CLASS_CODE: {
					BusModelJpaUuid6TypeH mapped = new BusModelJpaUuid6TypeH();
					mapped.set((IBusModelUuid6TypeH)hrec);
					return(mapped); }
				case IBusModelUuid6Gen.CLASS_CODE: {
					BusModelJpaUuid6GenH mapped = new BusModelJpaUuid6GenH();
					mapped.set((IBusModelUuid6GenH)hrec);
					return(mapped); }
				case IBusModelUuid6Col.CLASS_CODE: {
					BusModelJpaUuid6ColH mapped = new BusModelJpaUuid6ColH();
					mapped.set((IBusModelUuid6ColH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelUuid6Def",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelUuid6Def");
			}
		}
	}
}
