
// Description: Java 25 Factory service implementation for DbKeyHash160Type buffers

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
 *	Java 25 Factory service implementation for DbKeyHash160Type buffers.
 */
@Service("busmodel31BuffDbKeyHash160TypeFactoryService")
public class BusModelBuffDbKeyHash160TypeFactoryService
	implements IBusModelDbKeyHash160TypeFactory
{
	public BusModelBuffDbKeyHash160TypeFactoryService() {
	}

	@Override
	public IBusModelDbKeyHash160TypeBySchemaIdxKey newBySchemaIdxKey() {
		IBusModelDbKeyHash160TypeBySchemaIdxKey key =
			new BusModelBuffDbKeyHash160TypeBySchemaIdxKey();
		return( key );
	}

	public BusModelBuffDbKeyHash160TypeBySchemaIdxKey ensureBySchemaIdxKey(IBusModelDbKeyHash160TypeBySchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffDbKeyHash160TypeBySchemaIdxKey) {
			return( (BusModelBuffDbKeyHash160TypeBySchemaIdxKey)key );
		}
		else {
			BusModelBuffDbKeyHash160TypeBySchemaIdxKey mapped = new BusModelBuffDbKeyHash160TypeBySchemaIdxKey();
			mapped.setRequiredSchemaDefId( key.getRequiredSchemaDefId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelDbKeyHash160Type newRec() {
		IBusModelDbKeyHash160Type rec =
			new BusModelBuffDbKeyHash160Type();
		return( rec );
	}

	public BusModelBuffDbKeyHash160Type ensureRec(IBusModelDbKeyHash160Type rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffDbKeyHash160Type) {
			return ((BusModelBuffDbKeyHash160Type)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelDbKeyHash160Type.CLASS_CODE: {
					BusModelBuffDbKeyHash160Type mapped = new BusModelBuffDbKeyHash160Type();
					mapped.set(rec);
					return(mapped); }
				case IBusModelDbKeyHash160Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash160Gen mapped = new BusModelBuffDbKeyHash160Gen();
					mapped.set((IBusModelDbKeyHash160Gen)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelDbKeyHash160Type",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelDbKeyHash160Type");
			}
		}
	}

	@Override
	public IBusModelDbKeyHash160TypeH newHRec() {
		IBusModelDbKeyHash160TypeH hrec =
			new BusModelBuffDbKeyHash160TypeH();
		return( hrec );
	}

	public BusModelBuffDbKeyHash160TypeH ensureHRec(IBusModelDbKeyHash160TypeH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffDbKeyHash160TypeH) {
			return ((BusModelBuffDbKeyHash160TypeH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelDbKeyHash160Type.CLASS_CODE: {
					BusModelBuffDbKeyHash160TypeH mapped = new BusModelBuffDbKeyHash160TypeH();
					mapped.set(hrec);
					return(mapped); }
				case IBusModelDbKeyHash160Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash160GenH mapped = new BusModelBuffDbKeyHash160GenH();
					mapped.set((IBusModelDbKeyHash160GenH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelDbKeyHash160Type",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelDbKeyHash160Type");
			}
		}
	}
}
