
// Description: Java 25 Factory service implementation for Int32Type buffers

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
 *	Java 25 Factory service implementation for Int32Type buffers.
 */
@Service("busmodel31BuffInt32TypeFactoryService")
public class BusModelBuffInt32TypeFactoryService
	implements IBusModelInt32TypeFactory
{
	public BusModelBuffInt32TypeFactoryService() {
	}

	@Override
	public IBusModelInt32TypeBySchemaIdxKey newBySchemaIdxKey() {
		IBusModelInt32TypeBySchemaIdxKey key =
			new BusModelBuffInt32TypeBySchemaIdxKey();
		return( key );
	}

	public BusModelBuffInt32TypeBySchemaIdxKey ensureBySchemaIdxKey(IBusModelInt32TypeBySchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffInt32TypeBySchemaIdxKey) {
			return( (BusModelBuffInt32TypeBySchemaIdxKey)key );
		}
		else {
			BusModelBuffInt32TypeBySchemaIdxKey mapped = new BusModelBuffInt32TypeBySchemaIdxKey();
			mapped.setRequiredSchemaDefId( key.getRequiredSchemaDefId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelInt32Type newRec() {
		IBusModelInt32Type rec =
			new BusModelBuffInt32Type();
		return( rec );
	}

	public BusModelBuffInt32Type ensureRec(IBusModelInt32Type rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffInt32Type) {
			return ((BusModelBuffInt32Type)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelInt32Type.CLASS_CODE: {
					BusModelBuffInt32Type mapped = new BusModelBuffInt32Type();
					mapped.set(rec);
					return(mapped); }
				case IBusModelId32Gen.CLASS_CODE: {
					BusModelBuffId32Gen mapped = new BusModelBuffId32Gen();
					mapped.set((IBusModelId32Gen)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelInt32Type",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelInt32Type");
			}
		}
	}

	@Override
	public IBusModelInt32TypeH newHRec() {
		IBusModelInt32TypeH hrec =
			new BusModelBuffInt32TypeH();
		return( hrec );
	}

	public BusModelBuffInt32TypeH ensureHRec(IBusModelInt32TypeH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffInt32TypeH) {
			return ((BusModelBuffInt32TypeH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelInt32Type.CLASS_CODE: {
					BusModelBuffInt32TypeH mapped = new BusModelBuffInt32TypeH();
					mapped.set(hrec);
					return(mapped); }
				case IBusModelId32Gen.CLASS_CODE: {
					BusModelBuffId32GenH mapped = new BusModelBuffId32GenH();
					mapped.set((IBusModelId32GenH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelInt32Type",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelInt32Type");
			}
		}
	}
}
