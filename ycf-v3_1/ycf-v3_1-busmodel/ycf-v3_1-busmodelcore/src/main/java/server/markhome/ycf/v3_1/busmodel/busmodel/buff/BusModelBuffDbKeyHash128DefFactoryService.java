
// Description: Java 25 Factory service implementation for DbKeyHash128Def buffers

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
 *	Java 25 Factory service implementation for DbKeyHash128Def buffers.
 */
@Service("busmodel31BuffDbKeyHash128DefFactoryService")
public class BusModelBuffDbKeyHash128DefFactoryService
	implements IBusModelDbKeyHash128DefFactory
{
	public BusModelBuffDbKeyHash128DefFactoryService() {
	}

	@Override
	public IBusModelDbKeyHash128Def newRec() {
		IBusModelDbKeyHash128Def rec =
			new BusModelBuffDbKeyHash128Def();
		return( rec );
	}

	public BusModelBuffDbKeyHash128Def ensureRec(IBusModelDbKeyHash128Def rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffDbKeyHash128Def) {
			return ((BusModelBuffDbKeyHash128Def)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelDbKeyHash128Def.CLASS_CODE: {
					BusModelBuffDbKeyHash128Def mapped = new BusModelBuffDbKeyHash128Def();
					mapped.set(rec);
					return(mapped); }
				case IBusModelDbKeyHash128Col.CLASS_CODE: {
					BusModelBuffDbKeyHash128Col mapped = new BusModelBuffDbKeyHash128Col();
					mapped.set((IBusModelDbKeyHash128Col)rec);
					return(mapped); }
				case IBusModelDbKeyHash128Type.CLASS_CODE: {
					BusModelBuffDbKeyHash128Type mapped = new BusModelBuffDbKeyHash128Type();
					mapped.set((IBusModelDbKeyHash128Type)rec);
					return(mapped); }
				case IBusModelDbKeyHash128Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash128Gen mapped = new BusModelBuffDbKeyHash128Gen();
					mapped.set((IBusModelDbKeyHash128Gen)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelDbKeyHash128Def",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelDbKeyHash128Def");
			}
		}
	}

	@Override
	public IBusModelDbKeyHash128DefH newHRec() {
		IBusModelDbKeyHash128DefH hrec =
			new BusModelBuffDbKeyHash128DefH();
		return( hrec );
	}

	public BusModelBuffDbKeyHash128DefH ensureHRec(IBusModelDbKeyHash128DefH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffDbKeyHash128DefH) {
			return ((BusModelBuffDbKeyHash128DefH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelDbKeyHash128Def.CLASS_CODE: {
					BusModelBuffDbKeyHash128DefH mapped = new BusModelBuffDbKeyHash128DefH();
					mapped.set(hrec);
					return(mapped); }
				case IBusModelDbKeyHash128Col.CLASS_CODE: {
					BusModelBuffDbKeyHash128ColH mapped = new BusModelBuffDbKeyHash128ColH();
					mapped.set((IBusModelDbKeyHash128ColH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash128Type.CLASS_CODE: {
					BusModelBuffDbKeyHash128TypeH mapped = new BusModelBuffDbKeyHash128TypeH();
					mapped.set((IBusModelDbKeyHash128TypeH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash128Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash128GenH mapped = new BusModelBuffDbKeyHash128GenH();
					mapped.set((IBusModelDbKeyHash128GenH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelDbKeyHash128Def",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelDbKeyHash128Def");
			}
		}
	}
}
