
// Description: Java 25 Factory service implementation for DbKeyHash160Def buffers

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
 *	Java 25 Factory service implementation for DbKeyHash160Def buffers.
 */
@Service("busmodel31BuffDbKeyHash160DefFactoryService")
public class BusModelBuffDbKeyHash160DefFactoryService
	implements IBusModelDbKeyHash160DefFactory
{
	public BusModelBuffDbKeyHash160DefFactoryService() {
	}

	@Override
	public IBusModelDbKeyHash160Def newRec() {
		IBusModelDbKeyHash160Def rec =
			new BusModelBuffDbKeyHash160Def();
		return( rec );
	}

	public BusModelBuffDbKeyHash160Def ensureRec(IBusModelDbKeyHash160Def rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffDbKeyHash160Def) {
			return ((BusModelBuffDbKeyHash160Def)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelDbKeyHash160Def.CLASS_CODE: {
					BusModelBuffDbKeyHash160Def mapped = new BusModelBuffDbKeyHash160Def();
					mapped.set(rec);
					return(mapped); }
				case IBusModelDbKeyHash160Col.CLASS_CODE: {
					BusModelBuffDbKeyHash160Col mapped = new BusModelBuffDbKeyHash160Col();
					mapped.set((IBusModelDbKeyHash160Col)rec);
					return(mapped); }
				case IBusModelDbKeyHash160Type.CLASS_CODE: {
					BusModelBuffDbKeyHash160Type mapped = new BusModelBuffDbKeyHash160Type();
					mapped.set((IBusModelDbKeyHash160Type)rec);
					return(mapped); }
				case IBusModelDbKeyHash160Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash160Gen mapped = new BusModelBuffDbKeyHash160Gen();
					mapped.set((IBusModelDbKeyHash160Gen)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelDbKeyHash160Def",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelDbKeyHash160Def");
			}
		}
	}

	@Override
	public IBusModelDbKeyHash160DefH newHRec() {
		IBusModelDbKeyHash160DefH hrec =
			new BusModelBuffDbKeyHash160DefH();
		return( hrec );
	}

	public BusModelBuffDbKeyHash160DefH ensureHRec(IBusModelDbKeyHash160DefH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffDbKeyHash160DefH) {
			return ((BusModelBuffDbKeyHash160DefH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelDbKeyHash160Def.CLASS_CODE: {
					BusModelBuffDbKeyHash160DefH mapped = new BusModelBuffDbKeyHash160DefH();
					mapped.set(hrec);
					return(mapped); }
				case IBusModelDbKeyHash160Col.CLASS_CODE: {
					BusModelBuffDbKeyHash160ColH mapped = new BusModelBuffDbKeyHash160ColH();
					mapped.set((IBusModelDbKeyHash160ColH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash160Type.CLASS_CODE: {
					BusModelBuffDbKeyHash160TypeH mapped = new BusModelBuffDbKeyHash160TypeH();
					mapped.set((IBusModelDbKeyHash160TypeH)hrec);
					return(mapped); }
				case IBusModelDbKeyHash160Gen.CLASS_CODE: {
					BusModelBuffDbKeyHash160GenH mapped = new BusModelBuffDbKeyHash160GenH();
					mapped.set((IBusModelDbKeyHash160GenH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelDbKeyHash160Def",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelDbKeyHash160Def");
			}
		}
	}
}
