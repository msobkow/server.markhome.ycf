
// Description: Java 25 Factory service implementation for EnumTag buffers

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
 *	Java 25 Factory service implementation for EnumTag buffers.
 */
@Service("busmodel31BuffEnumTagFactoryService")
public class BusModelBuffEnumTagFactoryService
	implements IBusModelEnumTagFactory
{
	public BusModelBuffEnumTagFactoryService() {
	}

	@Override
	public IBusModelEnumTagHPKey newHPKey() {
		IBusModelEnumTagHPKey hpkey =
			new BusModelBuffEnumTagHPKey();
		return( hpkey );
	}

	public BusModelBuffEnumTagHPKey ensureHPKey(IBusModelEnumTagHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof BusModelBuffEnumTagHPKey) {
			return( (BusModelBuffEnumTagHPKey)key );
		}
		else {
			BusModelBuffEnumTagHPKey mapped = new BusModelBuffEnumTagHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelEnumTagByEnumIdxKey newByEnumIdxKey() {
		IBusModelEnumTagByEnumIdxKey key =
			new BusModelBuffEnumTagByEnumIdxKey();
		return( key );
	}

	public BusModelBuffEnumTagByEnumIdxKey ensureByEnumIdxKey(IBusModelEnumTagByEnumIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffEnumTagByEnumIdxKey) {
			return( (BusModelBuffEnumTagByEnumIdxKey)key );
		}
		else {
			BusModelBuffEnumTagByEnumIdxKey mapped = new BusModelBuffEnumTagByEnumIdxKey();
			mapped.setRequiredEnumId( key.getRequiredEnumId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelEnumTagByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelEnumTagByDefSchemaIdxKey key =
			new BusModelBuffEnumTagByDefSchemaIdxKey();
		return( key );
	}

	public BusModelBuffEnumTagByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelEnumTagByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffEnumTagByDefSchemaIdxKey) {
			return( (BusModelBuffEnumTagByDefSchemaIdxKey)key );
		}
		else {
			BusModelBuffEnumTagByDefSchemaIdxKey mapped = new BusModelBuffEnumTagByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelEnumTagByEnumNameIdxKey newByEnumNameIdxKey() {
		IBusModelEnumTagByEnumNameIdxKey key =
			new BusModelBuffEnumTagByEnumNameIdxKey();
		return( key );
	}

	public BusModelBuffEnumTagByEnumNameIdxKey ensureByEnumNameIdxKey(IBusModelEnumTagByEnumNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffEnumTagByEnumNameIdxKey) {
			return( (BusModelBuffEnumTagByEnumNameIdxKey)key );
		}
		else {
			BusModelBuffEnumTagByEnumNameIdxKey mapped = new BusModelBuffEnumTagByEnumNameIdxKey();
			mapped.setRequiredEnumId( key.getRequiredEnumId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IBusModelEnumTagByPrevIdxKey newByPrevIdxKey() {
		IBusModelEnumTagByPrevIdxKey key =
			new BusModelBuffEnumTagByPrevIdxKey();
		return( key );
	}

	public BusModelBuffEnumTagByPrevIdxKey ensureByPrevIdxKey(IBusModelEnumTagByPrevIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffEnumTagByPrevIdxKey) {
			return( (BusModelBuffEnumTagByPrevIdxKey)key );
		}
		else {
			BusModelBuffEnumTagByPrevIdxKey mapped = new BusModelBuffEnumTagByPrevIdxKey();
			mapped.setOptionalPrevId( key.getOptionalPrevId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelEnumTagByNextIdxKey newByNextIdxKey() {
		IBusModelEnumTagByNextIdxKey key =
			new BusModelBuffEnumTagByNextIdxKey();
		return( key );
	}

	public BusModelBuffEnumTagByNextIdxKey ensureByNextIdxKey(IBusModelEnumTagByNextIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffEnumTagByNextIdxKey) {
			return( (BusModelBuffEnumTagByNextIdxKey)key );
		}
		else {
			BusModelBuffEnumTagByNextIdxKey mapped = new BusModelBuffEnumTagByNextIdxKey();
			mapped.setOptionalNextId( key.getOptionalNextId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelEnumTag newRec() {
		IBusModelEnumTag rec =
			new BusModelBuffEnumTag();
		return( rec );
	}

	public BusModelBuffEnumTag ensureRec(IBusModelEnumTag rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffEnumTag) {
			return ((BusModelBuffEnumTag)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelEnumTag.CLASS_CODE: {
					BusModelBuffEnumTag mapped = new BusModelBuffEnumTag();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelEnumTag",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelEnumTag");
			}
		}
	}

	@Override
	public IBusModelEnumTagH newHRec() {
		IBusModelEnumTagH hrec =
			new BusModelBuffEnumTagH();
		return( hrec );
	}

	public BusModelBuffEnumTagH ensureHRec(IBusModelEnumTagH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffEnumTagH) {
			return ((BusModelBuffEnumTagH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelEnumTag.CLASS_CODE: {
					BusModelBuffEnumTagH mapped = new BusModelBuffEnumTagH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelEnumTag",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelEnumTag");
			}
		}
	}
}
