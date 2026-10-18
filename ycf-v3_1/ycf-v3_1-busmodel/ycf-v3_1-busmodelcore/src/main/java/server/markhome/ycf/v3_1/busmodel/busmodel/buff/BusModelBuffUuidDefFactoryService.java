
// Description: Java 25 Factory service implementation for UuidDef buffers

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
 *	Java 25 Factory service implementation for UuidDef buffers.
 */
@Service("busmodel31BuffUuidDefFactoryService")
public class BusModelBuffUuidDefFactoryService
	implements IBusModelUuidDefFactory
{
	public BusModelBuffUuidDefFactoryService() {
	}

	@Override
	public IBusModelUuidDef newRec() {
		IBusModelUuidDef rec =
			new BusModelBuffUuidDef();
		return( rec );
	}

	public BusModelBuffUuidDef ensureRec(IBusModelUuidDef rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffUuidDef) {
			return ((BusModelBuffUuidDef)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelUuidDef.CLASS_CODE: {
					BusModelBuffUuidDef mapped = new BusModelBuffUuidDef();
					mapped.set(rec);
					return(mapped); }
				case IBusModelUuidType.CLASS_CODE: {
					BusModelBuffUuidType mapped = new BusModelBuffUuidType();
					mapped.set((IBusModelUuidType)rec);
					return(mapped); }
				case IBusModelUuidGen.CLASS_CODE: {
					BusModelBuffUuidGen mapped = new BusModelBuffUuidGen();
					mapped.set((IBusModelUuidGen)rec);
					return(mapped); }
				case IBusModelUuidCol.CLASS_CODE: {
					BusModelBuffUuidCol mapped = new BusModelBuffUuidCol();
					mapped.set((IBusModelUuidCol)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelUuidDef",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelUuidDef");
			}
		}
	}

	@Override
	public IBusModelUuidDefH newHRec() {
		IBusModelUuidDefH hrec =
			new BusModelBuffUuidDefH();
		return( hrec );
	}

	public BusModelBuffUuidDefH ensureHRec(IBusModelUuidDefH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffUuidDefH) {
			return ((BusModelBuffUuidDefH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelUuidDef.CLASS_CODE: {
					BusModelBuffUuidDefH mapped = new BusModelBuffUuidDefH();
					mapped.set(hrec);
					return(mapped); }
				case IBusModelUuidType.CLASS_CODE: {
					BusModelBuffUuidTypeH mapped = new BusModelBuffUuidTypeH();
					mapped.set((IBusModelUuidTypeH)hrec);
					return(mapped); }
				case IBusModelUuidGen.CLASS_CODE: {
					BusModelBuffUuidGenH mapped = new BusModelBuffUuidGenH();
					mapped.set((IBusModelUuidGenH)hrec);
					return(mapped); }
				case IBusModelUuidCol.CLASS_CODE: {
					BusModelBuffUuidColH mapped = new BusModelBuffUuidColH();
					mapped.set((IBusModelUuidColH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelUuidDef",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelUuidDef");
			}
		}
	}
}
