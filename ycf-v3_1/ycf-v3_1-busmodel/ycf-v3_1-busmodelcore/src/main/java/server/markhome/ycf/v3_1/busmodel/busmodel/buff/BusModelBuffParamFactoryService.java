
// Description: Java 25 Factory service implementation for Param buffers

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
 *	Java 25 Factory service implementation for Param buffers.
 */
@Service("busmodel31BuffParamFactoryService")
public class BusModelBuffParamFactoryService
	implements IBusModelParamFactory
{
	public BusModelBuffParamFactoryService() {
	}

	@Override
	public IBusModelParamHPKey newHPKey() {
		IBusModelParamHPKey hpkey =
			new BusModelBuffParamHPKey();
		return( hpkey );
	}

	public BusModelBuffParamHPKey ensureHPKey(IBusModelParamHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof BusModelBuffParamHPKey) {
			return( (BusModelBuffParamHPKey)key );
		}
		else {
			BusModelBuffParamHPKey mapped = new BusModelBuffParamHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelParamByUNameIdxKey newByUNameIdxKey() {
		IBusModelParamByUNameIdxKey key =
			new BusModelBuffParamByUNameIdxKey();
		return( key );
	}

	public BusModelBuffParamByUNameIdxKey ensureByUNameIdxKey(IBusModelParamByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffParamByUNameIdxKey) {
			return( (BusModelBuffParamByUNameIdxKey)key );
		}
		else {
			BusModelBuffParamByUNameIdxKey mapped = new BusModelBuffParamByUNameIdxKey();
			mapped.setRequiredServerMethodId( key.getRequiredServerMethodId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IBusModelParamByServerMethodIdxKey newByServerMethodIdxKey() {
		IBusModelParamByServerMethodIdxKey key =
			new BusModelBuffParamByServerMethodIdxKey();
		return( key );
	}

	public BusModelBuffParamByServerMethodIdxKey ensureByServerMethodIdxKey(IBusModelParamByServerMethodIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffParamByServerMethodIdxKey) {
			return( (BusModelBuffParamByServerMethodIdxKey)key );
		}
		else {
			BusModelBuffParamByServerMethodIdxKey mapped = new BusModelBuffParamByServerMethodIdxKey();
			mapped.setRequiredServerMethodId( key.getRequiredServerMethodId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelParamByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelParamByDefSchemaIdxKey key =
			new BusModelBuffParamByDefSchemaIdxKey();
		return( key );
	}

	public BusModelBuffParamByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelParamByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffParamByDefSchemaIdxKey) {
			return( (BusModelBuffParamByDefSchemaIdxKey)key );
		}
		else {
			BusModelBuffParamByDefSchemaIdxKey mapped = new BusModelBuffParamByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelParamByServerTypeIdxKey newByServerTypeIdxKey() {
		IBusModelParamByServerTypeIdxKey key =
			new BusModelBuffParamByServerTypeIdxKey();
		return( key );
	}

	public BusModelBuffParamByServerTypeIdxKey ensureByServerTypeIdxKey(IBusModelParamByServerTypeIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffParamByServerTypeIdxKey) {
			return( (BusModelBuffParamByServerTypeIdxKey)key );
		}
		else {
			BusModelBuffParamByServerTypeIdxKey mapped = new BusModelBuffParamByServerTypeIdxKey();
			mapped.setOptionalTypeId( key.getOptionalTypeId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelParamByPrevIdxKey newByPrevIdxKey() {
		IBusModelParamByPrevIdxKey key =
			new BusModelBuffParamByPrevIdxKey();
		return( key );
	}

	public BusModelBuffParamByPrevIdxKey ensureByPrevIdxKey(IBusModelParamByPrevIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffParamByPrevIdxKey) {
			return( (BusModelBuffParamByPrevIdxKey)key );
		}
		else {
			BusModelBuffParamByPrevIdxKey mapped = new BusModelBuffParamByPrevIdxKey();
			mapped.setOptionalPrevId( key.getOptionalPrevId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelParamByNextIdxKey newByNextIdxKey() {
		IBusModelParamByNextIdxKey key =
			new BusModelBuffParamByNextIdxKey();
		return( key );
	}

	public BusModelBuffParamByNextIdxKey ensureByNextIdxKey(IBusModelParamByNextIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffParamByNextIdxKey) {
			return( (BusModelBuffParamByNextIdxKey)key );
		}
		else {
			BusModelBuffParamByNextIdxKey mapped = new BusModelBuffParamByNextIdxKey();
			mapped.setOptionalNextId( key.getOptionalNextId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelParamByContPrevIdxKey newByContPrevIdxKey() {
		IBusModelParamByContPrevIdxKey key =
			new BusModelBuffParamByContPrevIdxKey();
		return( key );
	}

	public BusModelBuffParamByContPrevIdxKey ensureByContPrevIdxKey(IBusModelParamByContPrevIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffParamByContPrevIdxKey) {
			return( (BusModelBuffParamByContPrevIdxKey)key );
		}
		else {
			BusModelBuffParamByContPrevIdxKey mapped = new BusModelBuffParamByContPrevIdxKey();
			mapped.setRequiredServerMethodId( key.getRequiredServerMethodId() );
			mapped.setOptionalPrevId( key.getOptionalPrevId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelParamByContNextIdxKey newByContNextIdxKey() {
		IBusModelParamByContNextIdxKey key =
			new BusModelBuffParamByContNextIdxKey();
		return( key );
	}

	public BusModelBuffParamByContNextIdxKey ensureByContNextIdxKey(IBusModelParamByContNextIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffParamByContNextIdxKey) {
			return( (BusModelBuffParamByContNextIdxKey)key );
		}
		else {
			BusModelBuffParamByContNextIdxKey mapped = new BusModelBuffParamByContNextIdxKey();
			mapped.setRequiredServerMethodId( key.getRequiredServerMethodId() );
			mapped.setOptionalNextId( key.getOptionalNextId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelParam newRec() {
		IBusModelParam rec =
			new BusModelBuffParam();
		return( rec );
	}

	public BusModelBuffParam ensureRec(IBusModelParam rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffParam) {
			return ((BusModelBuffParam)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelParam.CLASS_CODE: {
					BusModelBuffParam mapped = new BusModelBuffParam();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelParam",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelParam");
			}
		}
	}

	@Override
	public IBusModelParamH newHRec() {
		IBusModelParamH hrec =
			new BusModelBuffParamH();
		return( hrec );
	}

	public BusModelBuffParamH ensureHRec(IBusModelParamH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffParamH) {
			return ((BusModelBuffParamH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelParam.CLASS_CODE: {
					BusModelBuffParamH mapped = new BusModelBuffParamH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelParam",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelParam");
			}
		}
	}
}
