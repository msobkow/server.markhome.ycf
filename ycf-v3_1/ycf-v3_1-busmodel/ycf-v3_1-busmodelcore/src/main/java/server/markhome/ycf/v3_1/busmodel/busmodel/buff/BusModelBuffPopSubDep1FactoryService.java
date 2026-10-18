
// Description: Java 25 Factory service implementation for PopSubDep1 buffers

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

package server.markhome.ycf.v3_1.busmodel.busmodel.buff;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;

/*
 *	Java 25 Factory service implementation for PopSubDep1 buffers.
 */
@Service("busmodel31BuffPopSubDep1FactoryService")
public class BusModelBuffPopSubDep1FactoryService
	implements IBusModelPopSubDep1Factory
{
	public BusModelBuffPopSubDep1FactoryService() {
	}

	@Override
	public IBusModelPopSubDep1ByPopTopDepIdxKey newByPopTopDepIdxKey() {
		IBusModelPopSubDep1ByPopTopDepIdxKey key =
			new BusModelBuffPopSubDep1ByPopTopDepIdxKey();
		return( key );
	}

	public BusModelBuffPopSubDep1ByPopTopDepIdxKey ensureByPopTopDepIdxKey(IBusModelPopSubDep1ByPopTopDepIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffPopSubDep1ByPopTopDepIdxKey) {
			return( (BusModelBuffPopSubDep1ByPopTopDepIdxKey)key );
		}
		else {
			BusModelBuffPopSubDep1ByPopTopDepIdxKey mapped = new BusModelBuffPopSubDep1ByPopTopDepIdxKey();
			mapped.setRequiredPopTopDepId( key.getRequiredPopTopDepId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelPopSubDep1ByUNameIdxKey newByUNameIdxKey() {
		IBusModelPopSubDep1ByUNameIdxKey key =
			new BusModelBuffPopSubDep1ByUNameIdxKey();
		return( key );
	}

	public BusModelBuffPopSubDep1ByUNameIdxKey ensureByUNameIdxKey(IBusModelPopSubDep1ByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffPopSubDep1ByUNameIdxKey) {
			return( (BusModelBuffPopSubDep1ByUNameIdxKey)key );
		}
		else {
			BusModelBuffPopSubDep1ByUNameIdxKey mapped = new BusModelBuffPopSubDep1ByUNameIdxKey();
			mapped.setRequiredPopTopDepId( key.getRequiredPopTopDepId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IBusModelPopSubDep1 newRec() {
		IBusModelPopSubDep1 rec =
			new BusModelBuffPopSubDep1();
		return( rec );
	}

	public BusModelBuffPopSubDep1 ensureRec(IBusModelPopSubDep1 rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffPopSubDep1) {
			return ((BusModelBuffPopSubDep1)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelPopSubDep1.CLASS_CODE: {
					BusModelBuffPopSubDep1 mapped = new BusModelBuffPopSubDep1();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelPopSubDep1",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelPopSubDep1");
			}
		}
	}

	@Override
	public IBusModelPopSubDep1H newHRec() {
		IBusModelPopSubDep1H hrec =
			new BusModelBuffPopSubDep1H();
		return( hrec );
	}

	public BusModelBuffPopSubDep1H ensureHRec(IBusModelPopSubDep1H hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffPopSubDep1H) {
			return ((BusModelBuffPopSubDep1H)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelPopSubDep1.CLASS_CODE: {
					BusModelBuffPopSubDep1H mapped = new BusModelBuffPopSubDep1H();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelPopSubDep1",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelPopSubDep1");
			}
		}
	}
}
