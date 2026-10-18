
// Description: Java 25 Factory service implementation for UInt64Def buffers

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
 *	Java 25 Factory service implementation for UInt64Def buffers.
 */
@Service("busmodel31BuffUInt64DefFactoryService")
public class BusModelBuffUInt64DefFactoryService
	implements IBusModelUInt64DefFactory
{
	public BusModelBuffUInt64DefFactoryService() {
	}

	@Override
	public IBusModelUInt64Def newRec() {
		IBusModelUInt64Def rec =
			new BusModelBuffUInt64Def();
		return( rec );
	}

	public BusModelBuffUInt64Def ensureRec(IBusModelUInt64Def rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffUInt64Def) {
			return ((BusModelBuffUInt64Def)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelUInt64Def.CLASS_CODE: {
					BusModelBuffUInt64Def mapped = new BusModelBuffUInt64Def();
					mapped.set(rec);
					return(mapped); }
				case IBusModelUInt64Type.CLASS_CODE: {
					BusModelBuffUInt64Type mapped = new BusModelBuffUInt64Type();
					mapped.set((IBusModelUInt64Type)rec);
					return(mapped); }
				case IBusModelUInt64Col.CLASS_CODE: {
					BusModelBuffUInt64Col mapped = new BusModelBuffUInt64Col();
					mapped.set((IBusModelUInt64Col)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelUInt64Def",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelUInt64Def");
			}
		}
	}

	@Override
	public IBusModelUInt64DefH newHRec() {
		IBusModelUInt64DefH hrec =
			new BusModelBuffUInt64DefH();
		return( hrec );
	}

	public BusModelBuffUInt64DefH ensureHRec(IBusModelUInt64DefH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffUInt64DefH) {
			return ((BusModelBuffUInt64DefH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelUInt64Def.CLASS_CODE: {
					BusModelBuffUInt64DefH mapped = new BusModelBuffUInt64DefH();
					mapped.set(hrec);
					return(mapped); }
				case IBusModelUInt64Type.CLASS_CODE: {
					BusModelBuffUInt64TypeH mapped = new BusModelBuffUInt64TypeH();
					mapped.set((IBusModelUInt64TypeH)hrec);
					return(mapped); }
				case IBusModelUInt64Col.CLASS_CODE: {
					BusModelBuffUInt64ColH mapped = new BusModelBuffUInt64ColH();
					mapped.set((IBusModelUInt64ColH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelUInt64Def",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelUInt64Def");
			}
		}
	}
}
