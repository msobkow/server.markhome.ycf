
// Description: Java 25 Factory service implementation for IndexCol buffers

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
 *	Java 25 Factory service implementation for IndexCol buffers.
 */
@Service("busmodel31BuffIndexColFactoryService")
public class BusModelBuffIndexColFactoryService
	implements IBusModelIndexColFactory
{
	public BusModelBuffIndexColFactoryService() {
	}

	@Override
	public IBusModelIndexColHPKey newHPKey() {
		IBusModelIndexColHPKey hpkey =
			new BusModelBuffIndexColHPKey();
		return( hpkey );
	}

	public BusModelBuffIndexColHPKey ensureHPKey(IBusModelIndexColHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof BusModelBuffIndexColHPKey) {
			return( (BusModelBuffIndexColHPKey)key );
		}
		else {
			BusModelBuffIndexColHPKey mapped = new BusModelBuffIndexColHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelIndexColByUNameIdxKey newByUNameIdxKey() {
		IBusModelIndexColByUNameIdxKey key =
			new BusModelBuffIndexColByUNameIdxKey();
		return( key );
	}

	public BusModelBuffIndexColByUNameIdxKey ensureByUNameIdxKey(IBusModelIndexColByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffIndexColByUNameIdxKey) {
			return( (BusModelBuffIndexColByUNameIdxKey)key );
		}
		else {
			BusModelBuffIndexColByUNameIdxKey mapped = new BusModelBuffIndexColByUNameIdxKey();
			mapped.setRequiredIndexId( key.getRequiredIndexId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IBusModelIndexColByIndexIdxKey newByIndexIdxKey() {
		IBusModelIndexColByIndexIdxKey key =
			new BusModelBuffIndexColByIndexIdxKey();
		return( key );
	}

	public BusModelBuffIndexColByIndexIdxKey ensureByIndexIdxKey(IBusModelIndexColByIndexIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffIndexColByIndexIdxKey) {
			return( (BusModelBuffIndexColByIndexIdxKey)key );
		}
		else {
			BusModelBuffIndexColByIndexIdxKey mapped = new BusModelBuffIndexColByIndexIdxKey();
			mapped.setRequiredIndexId( key.getRequiredIndexId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelIndexColByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelIndexColByDefSchemaIdxKey key =
			new BusModelBuffIndexColByDefSchemaIdxKey();
		return( key );
	}

	public BusModelBuffIndexColByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelIndexColByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffIndexColByDefSchemaIdxKey) {
			return( (BusModelBuffIndexColByDefSchemaIdxKey)key );
		}
		else {
			BusModelBuffIndexColByDefSchemaIdxKey mapped = new BusModelBuffIndexColByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelIndexColByColIdxKey newByColIdxKey() {
		IBusModelIndexColByColIdxKey key =
			new BusModelBuffIndexColByColIdxKey();
		return( key );
	}

	public BusModelBuffIndexColByColIdxKey ensureByColIdxKey(IBusModelIndexColByColIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffIndexColByColIdxKey) {
			return( (BusModelBuffIndexColByColIdxKey)key );
		}
		else {
			BusModelBuffIndexColByColIdxKey mapped = new BusModelBuffIndexColByColIdxKey();
			mapped.setRequiredColumnId( key.getRequiredColumnId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelIndexColByPrevIdxKey newByPrevIdxKey() {
		IBusModelIndexColByPrevIdxKey key =
			new BusModelBuffIndexColByPrevIdxKey();
		return( key );
	}

	public BusModelBuffIndexColByPrevIdxKey ensureByPrevIdxKey(IBusModelIndexColByPrevIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffIndexColByPrevIdxKey) {
			return( (BusModelBuffIndexColByPrevIdxKey)key );
		}
		else {
			BusModelBuffIndexColByPrevIdxKey mapped = new BusModelBuffIndexColByPrevIdxKey();
			mapped.setOptionalPrevId( key.getOptionalPrevId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelIndexColByNextIdxKey newByNextIdxKey() {
		IBusModelIndexColByNextIdxKey key =
			new BusModelBuffIndexColByNextIdxKey();
		return( key );
	}

	public BusModelBuffIndexColByNextIdxKey ensureByNextIdxKey(IBusModelIndexColByNextIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffIndexColByNextIdxKey) {
			return( (BusModelBuffIndexColByNextIdxKey)key );
		}
		else {
			BusModelBuffIndexColByNextIdxKey mapped = new BusModelBuffIndexColByNextIdxKey();
			mapped.setOptionalNextId( key.getOptionalNextId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelIndexColByIdxPrevIdxKey newByIdxPrevIdxKey() {
		IBusModelIndexColByIdxPrevIdxKey key =
			new BusModelBuffIndexColByIdxPrevIdxKey();
		return( key );
	}

	public BusModelBuffIndexColByIdxPrevIdxKey ensureByIdxPrevIdxKey(IBusModelIndexColByIdxPrevIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffIndexColByIdxPrevIdxKey) {
			return( (BusModelBuffIndexColByIdxPrevIdxKey)key );
		}
		else {
			BusModelBuffIndexColByIdxPrevIdxKey mapped = new BusModelBuffIndexColByIdxPrevIdxKey();
			mapped.setRequiredIndexId( key.getRequiredIndexId() );
			mapped.setOptionalPrevId( key.getOptionalPrevId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelIndexColByIdxNextIdxKey newByIdxNextIdxKey() {
		IBusModelIndexColByIdxNextIdxKey key =
			new BusModelBuffIndexColByIdxNextIdxKey();
		return( key );
	}

	public BusModelBuffIndexColByIdxNextIdxKey ensureByIdxNextIdxKey(IBusModelIndexColByIdxNextIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffIndexColByIdxNextIdxKey) {
			return( (BusModelBuffIndexColByIdxNextIdxKey)key );
		}
		else {
			BusModelBuffIndexColByIdxNextIdxKey mapped = new BusModelBuffIndexColByIdxNextIdxKey();
			mapped.setRequiredIndexId( key.getRequiredIndexId() );
			mapped.setOptionalNextId( key.getOptionalNextId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelIndexCol newRec() {
		IBusModelIndexCol rec =
			new BusModelBuffIndexCol();
		return( rec );
	}

	public BusModelBuffIndexCol ensureRec(IBusModelIndexCol rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffIndexCol) {
			return ((BusModelBuffIndexCol)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelIndexCol.CLASS_CODE: {
					BusModelBuffIndexCol mapped = new BusModelBuffIndexCol();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelIndexCol",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelIndexCol");
			}
		}
	}

	@Override
	public IBusModelIndexColH newHRec() {
		IBusModelIndexColH hrec =
			new BusModelBuffIndexColH();
		return( hrec );
	}

	public BusModelBuffIndexColH ensureHRec(IBusModelIndexColH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffIndexColH) {
			return ((BusModelBuffIndexColH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelIndexCol.CLASS_CODE: {
					BusModelBuffIndexColH mapped = new BusModelBuffIndexColH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelIndexCol",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelIndexCol");
			}
		}
	}
}
