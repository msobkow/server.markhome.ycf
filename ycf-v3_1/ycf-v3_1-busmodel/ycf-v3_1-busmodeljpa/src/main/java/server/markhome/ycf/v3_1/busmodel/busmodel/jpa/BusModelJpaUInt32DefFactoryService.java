
// Description: Java 25 Factory service implementation for UInt32Def JPA objects

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
 *	Java 25 Factory service implementation for UInt32Def JPA objects.
 */
public class BusModelJpaUInt32DefFactoryService
    implements IBusModelUInt32DefFactory
{
    public BusModelJpaUInt32DefFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelUInt32Def newRec() {
        IBusModelUInt32Def rec = new BusModelJpaUInt32Def();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaUInt32Def ensureRec(IBusModelUInt32Def rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaUInt32Def) {
			return( (BusModelJpaUInt32Def)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelUInt32Def.CLASS_CODE: {
					BusModelJpaUInt32Def mapped = new BusModelJpaUInt32Def();
					mapped.set(rec);
					return( mapped ); }
				case IBusModelUInt32Type.CLASS_CODE: {
					BusModelJpaUInt32Type mapped = new BusModelJpaUInt32Type();
					mapped.set((IBusModelUInt32Type)rec);
					return(mapped); }
				case IBusModelUInt32Col.CLASS_CODE: {
					BusModelJpaUInt32Col mapped = new BusModelJpaUInt32Col();
					mapped.set((IBusModelUInt32Col)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelUInt32Def",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelUInt32Def");
			}
		}
	}

    @Override
    public IBusModelUInt32DefH newHRec() {
        IBusModelUInt32DefH hrec = new BusModelJpaUInt32DefH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaUInt32DefH ensureHRec(IBusModelUInt32DefH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaUInt32DefH) {
			return( (BusModelJpaUInt32DefH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelUInt32Def.CLASS_CODE: {
					BusModelJpaUInt32DefH mapped = new BusModelJpaUInt32DefH();
					mapped.set(hrec);
					return( mapped ); }
				case IBusModelUInt32Type.CLASS_CODE: {
					BusModelJpaUInt32TypeH mapped = new BusModelJpaUInt32TypeH();
					mapped.set((IBusModelUInt32TypeH)hrec);
					return(mapped); }
				case IBusModelUInt32Col.CLASS_CODE: {
					BusModelJpaUInt32ColH mapped = new BusModelJpaUInt32ColH();
					mapped.set((IBusModelUInt32ColH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelUInt32Def",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelUInt32Def");
			}
		}
	}
}
