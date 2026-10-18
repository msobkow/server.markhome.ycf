
// Description: Java 25 Factory service implementation for NmTokenDef JPA objects

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
 *	Java 25 Factory service implementation for NmTokenDef JPA objects.
 */
public class BusModelJpaNmTokenDefFactoryService
    implements IBusModelNmTokenDefFactory
{
    public BusModelJpaNmTokenDefFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelNmTokenDef newRec() {
        IBusModelNmTokenDef rec = new BusModelJpaNmTokenDef();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaNmTokenDef ensureRec(IBusModelNmTokenDef rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaNmTokenDef) {
			return( (BusModelJpaNmTokenDef)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelNmTokenDef.CLASS_CODE: {
					BusModelJpaNmTokenDef mapped = new BusModelJpaNmTokenDef();
					mapped.set(rec);
					return( mapped ); }
				case IBusModelNmTokenType.CLASS_CODE: {
					BusModelJpaNmTokenType mapped = new BusModelJpaNmTokenType();
					mapped.set((IBusModelNmTokenType)rec);
					return(mapped); }
				case IBusModelNmTokenCol.CLASS_CODE: {
					BusModelJpaNmTokenCol mapped = new BusModelJpaNmTokenCol();
					mapped.set((IBusModelNmTokenCol)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelNmTokenDef",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelNmTokenDef");
			}
		}
	}

    @Override
    public IBusModelNmTokenDefH newHRec() {
        IBusModelNmTokenDefH hrec = new BusModelJpaNmTokenDefH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaNmTokenDefH ensureHRec(IBusModelNmTokenDefH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaNmTokenDefH) {
			return( (BusModelJpaNmTokenDefH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelNmTokenDef.CLASS_CODE: {
					BusModelJpaNmTokenDefH mapped = new BusModelJpaNmTokenDefH();
					mapped.set(hrec);
					return( mapped ); }
				case IBusModelNmTokenType.CLASS_CODE: {
					BusModelJpaNmTokenTypeH mapped = new BusModelJpaNmTokenTypeH();
					mapped.set((IBusModelNmTokenTypeH)hrec);
					return(mapped); }
				case IBusModelNmTokenCol.CLASS_CODE: {
					BusModelJpaNmTokenColH mapped = new BusModelJpaNmTokenColH();
					mapped.set((IBusModelNmTokenColH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelNmTokenDef",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelNmTokenDef");
			}
		}
	}
}
