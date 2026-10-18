
// Description: Java 25 Factory service implementation for ServerMethod buffers

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
 *	Java 25 Factory service implementation for ServerMethod buffers.
 */
@Service("busmodel31BuffServerMethodFactoryService")
public class BusModelBuffServerMethodFactoryService
	implements IBusModelServerMethodFactory
{
	public BusModelBuffServerMethodFactoryService() {
	}

	@Override
	public IBusModelServerMethodByUNameIdxKey newByUNameIdxKey() {
		IBusModelServerMethodByUNameIdxKey key =
			new BusModelBuffServerMethodByUNameIdxKey();
		return( key );
	}

	public BusModelBuffServerMethodByUNameIdxKey ensureByUNameIdxKey(IBusModelServerMethodByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffServerMethodByUNameIdxKey) {
			return( (BusModelBuffServerMethodByUNameIdxKey)key );
		}
		else {
			BusModelBuffServerMethodByUNameIdxKey mapped = new BusModelBuffServerMethodByUNameIdxKey();
			mapped.setRequiredTableId( key.getRequiredTableId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IBusModelServerMethodByMethTableIdxKey newByMethTableIdxKey() {
		IBusModelServerMethodByMethTableIdxKey key =
			new BusModelBuffServerMethodByMethTableIdxKey();
		return( key );
	}

	public BusModelBuffServerMethodByMethTableIdxKey ensureByMethTableIdxKey(IBusModelServerMethodByMethTableIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffServerMethodByMethTableIdxKey) {
			return( (BusModelBuffServerMethodByMethTableIdxKey)key );
		}
		else {
			BusModelBuffServerMethodByMethTableIdxKey mapped = new BusModelBuffServerMethodByMethTableIdxKey();
			mapped.setRequiredTableId( key.getRequiredTableId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelServerMethodByMethCodeVisIdxKey newByMethCodeVisIdxKey() {
		IBusModelServerMethodByMethCodeVisIdxKey key =
			new BusModelBuffServerMethodByMethCodeVisIdxKey();
		return( key );
	}

	public BusModelBuffServerMethodByMethCodeVisIdxKey ensureByMethCodeVisIdxKey(IBusModelServerMethodByMethCodeVisIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffServerMethodByMethCodeVisIdxKey) {
			return( (BusModelBuffServerMethodByMethCodeVisIdxKey)key );
		}
		else {
			BusModelBuffServerMethodByMethCodeVisIdxKey mapped = new BusModelBuffServerMethodByMethCodeVisIdxKey();
			mapped.setRequiredCodeVis( key.getRequiredCodeVis() );
			return( mapped );
		}
	}

	@Override
	public IBusModelServerMethodByMethTableVisIdxKey newByMethTableVisIdxKey() {
		IBusModelServerMethodByMethTableVisIdxKey key =
			new BusModelBuffServerMethodByMethTableVisIdxKey();
		return( key );
	}

	public BusModelBuffServerMethodByMethTableVisIdxKey ensureByMethTableVisIdxKey(IBusModelServerMethodByMethTableVisIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffServerMethodByMethTableVisIdxKey) {
			return( (BusModelBuffServerMethodByMethTableVisIdxKey)key );
		}
		else {
			BusModelBuffServerMethodByMethTableVisIdxKey mapped = new BusModelBuffServerMethodByMethTableVisIdxKey();
			mapped.setRequiredTableId( key.getRequiredTableId() );
			mapped.setRequiredCodeVis( key.getRequiredCodeVis() );
			return( mapped );
		}
	}

	@Override
	public IBusModelServerMethodByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelServerMethodByDefSchemaIdxKey key =
			new BusModelBuffServerMethodByDefSchemaIdxKey();
		return( key );
	}

	public BusModelBuffServerMethodByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelServerMethodByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffServerMethodByDefSchemaIdxKey) {
			return( (BusModelBuffServerMethodByDefSchemaIdxKey)key );
		}
		else {
			BusModelBuffServerMethodByDefSchemaIdxKey mapped = new BusModelBuffServerMethodByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelServerMethod newRec() {
		IBusModelServerMethod rec =
			new BusModelBuffServerMethod();
		return( rec );
	}

	public BusModelBuffServerMethod ensureRec(IBusModelServerMethod rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffServerMethod) {
			return ((BusModelBuffServerMethod)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelServerMethod.CLASS_CODE: {
					BusModelBuffServerMethod mapped = new BusModelBuffServerMethod();
					mapped.set(rec);
					return(mapped); }
				case IBusModelServerObjFunc.CLASS_CODE: {
					BusModelBuffServerObjFunc mapped = new BusModelBuffServerObjFunc();
					mapped.set((IBusModelServerObjFunc)rec);
					return(mapped); }
				case IBusModelServerProc.CLASS_CODE: {
					BusModelBuffServerProc mapped = new BusModelBuffServerProc();
					mapped.set((IBusModelServerProc)rec);
					return(mapped); }
				case IBusModelServerListFunc.CLASS_CODE: {
					BusModelBuffServerListFunc mapped = new BusModelBuffServerListFunc();
					mapped.set((IBusModelServerListFunc)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelServerMethod",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelServerMethod");
			}
		}
	}

	@Override
	public IBusModelServerMethodH newHRec() {
		IBusModelServerMethodH hrec =
			new BusModelBuffServerMethodH();
		return( hrec );
	}

	public BusModelBuffServerMethodH ensureHRec(IBusModelServerMethodH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffServerMethodH) {
			return ((BusModelBuffServerMethodH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelServerMethod.CLASS_CODE: {
					BusModelBuffServerMethodH mapped = new BusModelBuffServerMethodH();
					mapped.set(hrec);
					return(mapped); }
				case IBusModelServerObjFunc.CLASS_CODE: {
					BusModelBuffServerObjFuncH mapped = new BusModelBuffServerObjFuncH();
					mapped.set((IBusModelServerObjFuncH)hrec);
					return(mapped); }
				case IBusModelServerProc.CLASS_CODE: {
					BusModelBuffServerProcH mapped = new BusModelBuffServerProcH();
					mapped.set((IBusModelServerProcH)hrec);
					return(mapped); }
				case IBusModelServerListFunc.CLASS_CODE: {
					BusModelBuffServerListFuncH mapped = new BusModelBuffServerListFuncH();
					mapped.set((IBusModelServerListFuncH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelServerMethod",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelServerMethod");
			}
		}
	}
}
