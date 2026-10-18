
// Description: Java 25 Factory service implementation for SchemaRef buffers

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
 *	Java 25 Factory service implementation for SchemaRef buffers.
 */
@Service("busmodel31BuffSchemaRefFactoryService")
public class BusModelBuffSchemaRefFactoryService
	implements IBusModelSchemaRefFactory
{
	public BusModelBuffSchemaRefFactoryService() {
	}

	@Override
	public IBusModelSchemaRefBySchemaIdxKey newBySchemaIdxKey() {
		IBusModelSchemaRefBySchemaIdxKey key =
			new BusModelBuffSchemaRefBySchemaIdxKey();
		return( key );
	}

	public BusModelBuffSchemaRefBySchemaIdxKey ensureBySchemaIdxKey(IBusModelSchemaRefBySchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffSchemaRefBySchemaIdxKey) {
			return( (BusModelBuffSchemaRefBySchemaIdxKey)key );
		}
		else {
			BusModelBuffSchemaRefBySchemaIdxKey mapped = new BusModelBuffSchemaRefBySchemaIdxKey();
			mapped.setRequiredSchemaId( key.getRequiredSchemaId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelSchemaRefByUNameIdxKey newByUNameIdxKey() {
		IBusModelSchemaRefByUNameIdxKey key =
			new BusModelBuffSchemaRefByUNameIdxKey();
		return( key );
	}

	public BusModelBuffSchemaRefByUNameIdxKey ensureByUNameIdxKey(IBusModelSchemaRefByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffSchemaRefByUNameIdxKey) {
			return( (BusModelBuffSchemaRefByUNameIdxKey)key );
		}
		else {
			BusModelBuffSchemaRefByUNameIdxKey mapped = new BusModelBuffSchemaRefByUNameIdxKey();
			mapped.setRequiredSchemaId( key.getRequiredSchemaId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IBusModelSchemaRefByRefSchemaIdxKey newByRefSchemaIdxKey() {
		IBusModelSchemaRefByRefSchemaIdxKey key =
			new BusModelBuffSchemaRefByRefSchemaIdxKey();
		return( key );
	}

	public BusModelBuffSchemaRefByRefSchemaIdxKey ensureByRefSchemaIdxKey(IBusModelSchemaRefByRefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffSchemaRefByRefSchemaIdxKey) {
			return( (BusModelBuffSchemaRefByRefSchemaIdxKey)key );
		}
		else {
			BusModelBuffSchemaRefByRefSchemaIdxKey mapped = new BusModelBuffSchemaRefByRefSchemaIdxKey();
			mapped.setOptionalRefSchemaId( key.getOptionalRefSchemaId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelSchemaRefByPrevIdxKey newByPrevIdxKey() {
		IBusModelSchemaRefByPrevIdxKey key =
			new BusModelBuffSchemaRefByPrevIdxKey();
		return( key );
	}

	public BusModelBuffSchemaRefByPrevIdxKey ensureByPrevIdxKey(IBusModelSchemaRefByPrevIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffSchemaRefByPrevIdxKey) {
			return( (BusModelBuffSchemaRefByPrevIdxKey)key );
		}
		else {
			BusModelBuffSchemaRefByPrevIdxKey mapped = new BusModelBuffSchemaRefByPrevIdxKey();
			mapped.setOptionalPrevId( key.getOptionalPrevId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelSchemaRefByNextIdxKey newByNextIdxKey() {
		IBusModelSchemaRefByNextIdxKey key =
			new BusModelBuffSchemaRefByNextIdxKey();
		return( key );
	}

	public BusModelBuffSchemaRefByNextIdxKey ensureByNextIdxKey(IBusModelSchemaRefByNextIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffSchemaRefByNextIdxKey) {
			return( (BusModelBuffSchemaRefByNextIdxKey)key );
		}
		else {
			BusModelBuffSchemaRefByNextIdxKey mapped = new BusModelBuffSchemaRefByNextIdxKey();
			mapped.setOptionalNextId( key.getOptionalNextId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelSchemaRef newRec() {
		IBusModelSchemaRef rec =
			new BusModelBuffSchemaRef();
		return( rec );
	}

	public BusModelBuffSchemaRef ensureRec(IBusModelSchemaRef rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffSchemaRef) {
			return ((BusModelBuffSchemaRef)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelSchemaRef.CLASS_CODE: {
					BusModelBuffSchemaRef mapped = new BusModelBuffSchemaRef();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelSchemaRef",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelSchemaRef");
			}
		}
	}

	@Override
	public IBusModelSchemaRefH newHRec() {
		IBusModelSchemaRefH hrec =
			new BusModelBuffSchemaRefH();
		return( hrec );
	}

	public BusModelBuffSchemaRefH ensureHRec(IBusModelSchemaRefH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffSchemaRefH) {
			return ((BusModelBuffSchemaRefH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelSchemaRef.CLASS_CODE: {
					BusModelBuffSchemaRefH mapped = new BusModelBuffSchemaRefH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelSchemaRef",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelSchemaRef");
			}
		}
	}
}
