
// Description: Java 25 Factory service implementation for RelationCol buffers

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
 *	Java 25 Factory service implementation for RelationCol buffers.
 */
@Service("busmodel31BuffRelationColFactoryService")
public class BusModelBuffRelationColFactoryService
	implements IBusModelRelationColFactory
{
	public BusModelBuffRelationColFactoryService() {
	}

	@Override
	public IBusModelRelationColHPKey newHPKey() {
		IBusModelRelationColHPKey hpkey =
			new BusModelBuffRelationColHPKey();
		return( hpkey );
	}

	public BusModelBuffRelationColHPKey ensureHPKey(IBusModelRelationColHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof BusModelBuffRelationColHPKey) {
			return( (BusModelBuffRelationColHPKey)key );
		}
		else {
			BusModelBuffRelationColHPKey mapped = new BusModelBuffRelationColHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationColByUNameIdxKey newByUNameIdxKey() {
		IBusModelRelationColByUNameIdxKey key =
			new BusModelBuffRelationColByUNameIdxKey();
		return( key );
	}

	public BusModelBuffRelationColByUNameIdxKey ensureByUNameIdxKey(IBusModelRelationColByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationColByUNameIdxKey) {
			return( (BusModelBuffRelationColByUNameIdxKey)key );
		}
		else {
			BusModelBuffRelationColByUNameIdxKey mapped = new BusModelBuffRelationColByUNameIdxKey();
			mapped.setRequiredRelationId( key.getRequiredRelationId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationColByRelationIdxKey newByRelationIdxKey() {
		IBusModelRelationColByRelationIdxKey key =
			new BusModelBuffRelationColByRelationIdxKey();
		return( key );
	}

	public BusModelBuffRelationColByRelationIdxKey ensureByRelationIdxKey(IBusModelRelationColByRelationIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationColByRelationIdxKey) {
			return( (BusModelBuffRelationColByRelationIdxKey)key );
		}
		else {
			BusModelBuffRelationColByRelationIdxKey mapped = new BusModelBuffRelationColByRelationIdxKey();
			mapped.setRequiredRelationId( key.getRequiredRelationId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationColByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelRelationColByDefSchemaIdxKey key =
			new BusModelBuffRelationColByDefSchemaIdxKey();
		return( key );
	}

	public BusModelBuffRelationColByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelRelationColByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationColByDefSchemaIdxKey) {
			return( (BusModelBuffRelationColByDefSchemaIdxKey)key );
		}
		else {
			BusModelBuffRelationColByDefSchemaIdxKey mapped = new BusModelBuffRelationColByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationColByFromColIdxKey newByFromColIdxKey() {
		IBusModelRelationColByFromColIdxKey key =
			new BusModelBuffRelationColByFromColIdxKey();
		return( key );
	}

	public BusModelBuffRelationColByFromColIdxKey ensureByFromColIdxKey(IBusModelRelationColByFromColIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationColByFromColIdxKey) {
			return( (BusModelBuffRelationColByFromColIdxKey)key );
		}
		else {
			BusModelBuffRelationColByFromColIdxKey mapped = new BusModelBuffRelationColByFromColIdxKey();
			mapped.setRequiredFromColId( key.getRequiredFromColId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationColByToColIdxKey newByToColIdxKey() {
		IBusModelRelationColByToColIdxKey key =
			new BusModelBuffRelationColByToColIdxKey();
		return( key );
	}

	public BusModelBuffRelationColByToColIdxKey ensureByToColIdxKey(IBusModelRelationColByToColIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationColByToColIdxKey) {
			return( (BusModelBuffRelationColByToColIdxKey)key );
		}
		else {
			BusModelBuffRelationColByToColIdxKey mapped = new BusModelBuffRelationColByToColIdxKey();
			mapped.setRequiredToColId( key.getRequiredToColId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationColByPrevIdxKey newByPrevIdxKey() {
		IBusModelRelationColByPrevIdxKey key =
			new BusModelBuffRelationColByPrevIdxKey();
		return( key );
	}

	public BusModelBuffRelationColByPrevIdxKey ensureByPrevIdxKey(IBusModelRelationColByPrevIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationColByPrevIdxKey) {
			return( (BusModelBuffRelationColByPrevIdxKey)key );
		}
		else {
			BusModelBuffRelationColByPrevIdxKey mapped = new BusModelBuffRelationColByPrevIdxKey();
			mapped.setOptionalPrevId( key.getOptionalPrevId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationColByNextIdxKey newByNextIdxKey() {
		IBusModelRelationColByNextIdxKey key =
			new BusModelBuffRelationColByNextIdxKey();
		return( key );
	}

	public BusModelBuffRelationColByNextIdxKey ensureByNextIdxKey(IBusModelRelationColByNextIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationColByNextIdxKey) {
			return( (BusModelBuffRelationColByNextIdxKey)key );
		}
		else {
			BusModelBuffRelationColByNextIdxKey mapped = new BusModelBuffRelationColByNextIdxKey();
			mapped.setOptionalNextId( key.getOptionalNextId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationColByRelPrevIdxKey newByRelPrevIdxKey() {
		IBusModelRelationColByRelPrevIdxKey key =
			new BusModelBuffRelationColByRelPrevIdxKey();
		return( key );
	}

	public BusModelBuffRelationColByRelPrevIdxKey ensureByRelPrevIdxKey(IBusModelRelationColByRelPrevIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationColByRelPrevIdxKey) {
			return( (BusModelBuffRelationColByRelPrevIdxKey)key );
		}
		else {
			BusModelBuffRelationColByRelPrevIdxKey mapped = new BusModelBuffRelationColByRelPrevIdxKey();
			mapped.setRequiredRelationId( key.getRequiredRelationId() );
			mapped.setOptionalPrevId( key.getOptionalPrevId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationColByRelNextIdxKey newByRelNextIdxKey() {
		IBusModelRelationColByRelNextIdxKey key =
			new BusModelBuffRelationColByRelNextIdxKey();
		return( key );
	}

	public BusModelBuffRelationColByRelNextIdxKey ensureByRelNextIdxKey(IBusModelRelationColByRelNextIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationColByRelNextIdxKey) {
			return( (BusModelBuffRelationColByRelNextIdxKey)key );
		}
		else {
			BusModelBuffRelationColByRelNextIdxKey mapped = new BusModelBuffRelationColByRelNextIdxKey();
			mapped.setRequiredRelationId( key.getRequiredRelationId() );
			mapped.setOptionalNextId( key.getOptionalNextId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationCol newRec() {
		IBusModelRelationCol rec =
			new BusModelBuffRelationCol();
		return( rec );
	}

	public BusModelBuffRelationCol ensureRec(IBusModelRelationCol rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffRelationCol) {
			return ((BusModelBuffRelationCol)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelRelationCol.CLASS_CODE: {
					BusModelBuffRelationCol mapped = new BusModelBuffRelationCol();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelRelationCol",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelRelationCol");
			}
		}
	}

	@Override
	public IBusModelRelationColH newHRec() {
		IBusModelRelationColH hrec =
			new BusModelBuffRelationColH();
		return( hrec );
	}

	public BusModelBuffRelationColH ensureHRec(IBusModelRelationColH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffRelationColH) {
			return ((BusModelBuffRelationColH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelRelationCol.CLASS_CODE: {
					BusModelBuffRelationColH mapped = new BusModelBuffRelationColH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelRelationCol",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelRelationCol");
			}
		}
	}
}
