
// Description: Java 25 Factory service implementation for Int16Def buffers

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
 *	Java 25 Factory service implementation for Int16Def buffers.
 */
@Service("busmodel31BuffInt16DefFactoryService")
public class BusModelBuffInt16DefFactoryService
	implements IBusModelInt16DefFactory
{
	public BusModelBuffInt16DefFactoryService() {
	}

	@Override
	public IBusModelInt16Def newRec() {
		IBusModelInt16Def rec =
			new BusModelBuffInt16Def();
		return( rec );
	}

	public BusModelBuffInt16Def ensureRec(IBusModelInt16Def rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffInt16Def) {
			return ((BusModelBuffInt16Def)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelInt16Def.CLASS_CODE: {
					BusModelBuffInt16Def mapped = new BusModelBuffInt16Def();
					mapped.set(rec);
					return(mapped); }
				case IBusModelInt16Type.CLASS_CODE: {
					BusModelBuffInt16Type mapped = new BusModelBuffInt16Type();
					mapped.set((IBusModelInt16Type)rec);
					return(mapped); }
				case IBusModelId16Gen.CLASS_CODE: {
					BusModelBuffId16Gen mapped = new BusModelBuffId16Gen();
					mapped.set((IBusModelId16Gen)rec);
					return(mapped); }
				case IBusModelEnumDef.CLASS_CODE: {
					BusModelBuffEnumDef mapped = new BusModelBuffEnumDef();
					mapped.set((IBusModelEnumDef)rec);
					return(mapped); }
				case IBusModelEnumType.CLASS_CODE: {
					BusModelBuffEnumType mapped = new BusModelBuffEnumType();
					mapped.set((IBusModelEnumType)rec);
					return(mapped); }
				case IBusModelInt16Col.CLASS_CODE: {
					BusModelBuffInt16Col mapped = new BusModelBuffInt16Col();
					mapped.set((IBusModelInt16Col)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelInt16Def",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelInt16Def");
			}
		}
	}

	@Override
	public IBusModelInt16DefH newHRec() {
		IBusModelInt16DefH hrec =
			new BusModelBuffInt16DefH();
		return( hrec );
	}

	public BusModelBuffInt16DefH ensureHRec(IBusModelInt16DefH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffInt16DefH) {
			return ((BusModelBuffInt16DefH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelInt16Def.CLASS_CODE: {
					BusModelBuffInt16DefH mapped = new BusModelBuffInt16DefH();
					mapped.set(hrec);
					return(mapped); }
				case IBusModelInt16Type.CLASS_CODE: {
					BusModelBuffInt16TypeH mapped = new BusModelBuffInt16TypeH();
					mapped.set((IBusModelInt16TypeH)hrec);
					return(mapped); }
				case IBusModelId16Gen.CLASS_CODE: {
					BusModelBuffId16GenH mapped = new BusModelBuffId16GenH();
					mapped.set((IBusModelId16GenH)hrec);
					return(mapped); }
				case IBusModelEnumDef.CLASS_CODE: {
					BusModelBuffEnumDefH mapped = new BusModelBuffEnumDefH();
					mapped.set((IBusModelEnumDefH)hrec);
					return(mapped); }
				case IBusModelEnumType.CLASS_CODE: {
					BusModelBuffEnumTypeH mapped = new BusModelBuffEnumTypeH();
					mapped.set((IBusModelEnumTypeH)hrec);
					return(mapped); }
				case IBusModelInt16Col.CLASS_CODE: {
					BusModelBuffInt16ColH mapped = new BusModelBuffInt16ColH();
					mapped.set((IBusModelInt16ColH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelInt16Def",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelInt16Def");
			}
		}
	}
}
