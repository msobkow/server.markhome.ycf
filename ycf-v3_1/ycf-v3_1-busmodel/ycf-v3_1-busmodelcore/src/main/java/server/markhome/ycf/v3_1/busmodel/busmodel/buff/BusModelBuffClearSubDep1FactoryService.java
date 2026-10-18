
// Description: Java 25 Factory service implementation for ClearSubDep1 buffers

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
 *	Java 25 Factory service implementation for ClearSubDep1 buffers.
 */
@Service("busmodel31BuffClearSubDep1FactoryService")
public class BusModelBuffClearSubDep1FactoryService
	implements IBusModelClearSubDep1Factory
{
	public BusModelBuffClearSubDep1FactoryService() {
	}

	@Override
	public IBusModelClearSubDep1ByClearTopDepIdxKey newByClearTopDepIdxKey() {
		IBusModelClearSubDep1ByClearTopDepIdxKey key =
			new BusModelBuffClearSubDep1ByClearTopDepIdxKey();
		return( key );
	}

	public BusModelBuffClearSubDep1ByClearTopDepIdxKey ensureByClearTopDepIdxKey(IBusModelClearSubDep1ByClearTopDepIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffClearSubDep1ByClearTopDepIdxKey) {
			return( (BusModelBuffClearSubDep1ByClearTopDepIdxKey)key );
		}
		else {
			BusModelBuffClearSubDep1ByClearTopDepIdxKey mapped = new BusModelBuffClearSubDep1ByClearTopDepIdxKey();
			mapped.setRequiredClearTopDepId( key.getRequiredClearTopDepId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelClearSubDep1ByUNameIdxKey newByUNameIdxKey() {
		IBusModelClearSubDep1ByUNameIdxKey key =
			new BusModelBuffClearSubDep1ByUNameIdxKey();
		return( key );
	}

	public BusModelBuffClearSubDep1ByUNameIdxKey ensureByUNameIdxKey(IBusModelClearSubDep1ByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffClearSubDep1ByUNameIdxKey) {
			return( (BusModelBuffClearSubDep1ByUNameIdxKey)key );
		}
		else {
			BusModelBuffClearSubDep1ByUNameIdxKey mapped = new BusModelBuffClearSubDep1ByUNameIdxKey();
			mapped.setRequiredClearTopDepId( key.getRequiredClearTopDepId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IBusModelClearSubDep1 newRec() {
		IBusModelClearSubDep1 rec =
			new BusModelBuffClearSubDep1();
		return( rec );
	}

	public BusModelBuffClearSubDep1 ensureRec(IBusModelClearSubDep1 rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffClearSubDep1) {
			return ((BusModelBuffClearSubDep1)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelClearSubDep1.CLASS_CODE: {
					BusModelBuffClearSubDep1 mapped = new BusModelBuffClearSubDep1();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelClearSubDep1",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelClearSubDep1");
			}
		}
	}

	@Override
	public IBusModelClearSubDep1H newHRec() {
		IBusModelClearSubDep1H hrec =
			new BusModelBuffClearSubDep1H();
		return( hrec );
	}

	public BusModelBuffClearSubDep1H ensureHRec(IBusModelClearSubDep1H hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffClearSubDep1H) {
			return ((BusModelBuffClearSubDep1H)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelClearSubDep1.CLASS_CODE: {
					BusModelBuffClearSubDep1H mapped = new BusModelBuffClearSubDep1H();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelClearSubDep1",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelClearSubDep1");
			}
		}
	}
}
