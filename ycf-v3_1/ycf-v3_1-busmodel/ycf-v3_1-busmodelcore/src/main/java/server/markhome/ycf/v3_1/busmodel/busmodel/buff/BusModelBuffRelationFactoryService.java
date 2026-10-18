
// Description: Java 25 Factory service implementation for Relation buffers

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
 *	Java 25 Factory service implementation for Relation buffers.
 */
@Service("busmodel31BuffRelationFactoryService")
public class BusModelBuffRelationFactoryService
	implements IBusModelRelationFactory
{
	public BusModelBuffRelationFactoryService() {
	}

	@Override
	public IBusModelRelationByUNameIdxKey newByUNameIdxKey() {
		IBusModelRelationByUNameIdxKey key =
			new BusModelBuffRelationByUNameIdxKey();
		return( key );
	}

	public BusModelBuffRelationByUNameIdxKey ensureByUNameIdxKey(IBusModelRelationByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationByUNameIdxKey) {
			return( (BusModelBuffRelationByUNameIdxKey)key );
		}
		else {
			BusModelBuffRelationByUNameIdxKey mapped = new BusModelBuffRelationByUNameIdxKey();
			mapped.setRequiredTableId( key.getRequiredTableId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationByRelTableIdxKey newByRelTableIdxKey() {
		IBusModelRelationByRelTableIdxKey key =
			new BusModelBuffRelationByRelTableIdxKey();
		return( key );
	}

	public BusModelBuffRelationByRelTableIdxKey ensureByRelTableIdxKey(IBusModelRelationByRelTableIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationByRelTableIdxKey) {
			return( (BusModelBuffRelationByRelTableIdxKey)key );
		}
		else {
			BusModelBuffRelationByRelTableIdxKey mapped = new BusModelBuffRelationByRelTableIdxKey();
			mapped.setRequiredTableId( key.getRequiredTableId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationByRelCodeVisIdxKey newByRelCodeVisIdxKey() {
		IBusModelRelationByRelCodeVisIdxKey key =
			new BusModelBuffRelationByRelCodeVisIdxKey();
		return( key );
	}

	public BusModelBuffRelationByRelCodeVisIdxKey ensureByRelCodeVisIdxKey(IBusModelRelationByRelCodeVisIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationByRelCodeVisIdxKey) {
			return( (BusModelBuffRelationByRelCodeVisIdxKey)key );
		}
		else {
			BusModelBuffRelationByRelCodeVisIdxKey mapped = new BusModelBuffRelationByRelCodeVisIdxKey();
			mapped.setRequiredCodeVis( key.getRequiredCodeVis() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationByRelTableCodeVisXKey newByRelTableCodeVisXKey() {
		IBusModelRelationByRelTableCodeVisXKey key =
			new BusModelBuffRelationByRelTableCodeVisXKey();
		return( key );
	}

	public BusModelBuffRelationByRelTableCodeVisXKey ensureByRelTableCodeVisXKey(IBusModelRelationByRelTableCodeVisXKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationByRelTableCodeVisXKey) {
			return( (BusModelBuffRelationByRelTableCodeVisXKey)key );
		}
		else {
			BusModelBuffRelationByRelTableCodeVisXKey mapped = new BusModelBuffRelationByRelTableCodeVisXKey();
			mapped.setRequiredTableId( key.getRequiredTableId() );
			mapped.setRequiredCodeVis( key.getRequiredCodeVis() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelRelationByDefSchemaIdxKey key =
			new BusModelBuffRelationByDefSchemaIdxKey();
		return( key );
	}

	public BusModelBuffRelationByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelRelationByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationByDefSchemaIdxKey) {
			return( (BusModelBuffRelationByDefSchemaIdxKey)key );
		}
		else {
			BusModelBuffRelationByDefSchemaIdxKey mapped = new BusModelBuffRelationByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationByFromKeyIdxKey newByFromKeyIdxKey() {
		IBusModelRelationByFromKeyIdxKey key =
			new BusModelBuffRelationByFromKeyIdxKey();
		return( key );
	}

	public BusModelBuffRelationByFromKeyIdxKey ensureByFromKeyIdxKey(IBusModelRelationByFromKeyIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationByFromKeyIdxKey) {
			return( (BusModelBuffRelationByFromKeyIdxKey)key );
		}
		else {
			BusModelBuffRelationByFromKeyIdxKey mapped = new BusModelBuffRelationByFromKeyIdxKey();
			mapped.setRequiredFromIndexId( key.getRequiredFromIndexId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationByToTblIdxKey newByToTblIdxKey() {
		IBusModelRelationByToTblIdxKey key =
			new BusModelBuffRelationByToTblIdxKey();
		return( key );
	}

	public BusModelBuffRelationByToTblIdxKey ensureByToTblIdxKey(IBusModelRelationByToTblIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationByToTblIdxKey) {
			return( (BusModelBuffRelationByToTblIdxKey)key );
		}
		else {
			BusModelBuffRelationByToTblIdxKey mapped = new BusModelBuffRelationByToTblIdxKey();
			mapped.setRequiredToTableId( key.getRequiredToTableId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationByToKeyIdxKey newByToKeyIdxKey() {
		IBusModelRelationByToKeyIdxKey key =
			new BusModelBuffRelationByToKeyIdxKey();
		return( key );
	}

	public BusModelBuffRelationByToKeyIdxKey ensureByToKeyIdxKey(IBusModelRelationByToKeyIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationByToKeyIdxKey) {
			return( (BusModelBuffRelationByToKeyIdxKey)key );
		}
		else {
			BusModelBuffRelationByToKeyIdxKey mapped = new BusModelBuffRelationByToKeyIdxKey();
			mapped.setRequiredToIndexId( key.getRequiredToIndexId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelationByNarrowedIdxKey newByNarrowedIdxKey() {
		IBusModelRelationByNarrowedIdxKey key =
			new BusModelBuffRelationByNarrowedIdxKey();
		return( key );
	}

	public BusModelBuffRelationByNarrowedIdxKey ensureByNarrowedIdxKey(IBusModelRelationByNarrowedIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRelationByNarrowedIdxKey) {
			return( (BusModelBuffRelationByNarrowedIdxKey)key );
		}
		else {
			BusModelBuffRelationByNarrowedIdxKey mapped = new BusModelBuffRelationByNarrowedIdxKey();
			mapped.setOptionalNarrowedId( key.getOptionalNarrowedId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRelation newRec() {
		IBusModelRelation rec =
			new BusModelBuffRelation();
		return( rec );
	}

	public BusModelBuffRelation ensureRec(IBusModelRelation rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffRelation) {
			return ((BusModelBuffRelation)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelRelation.CLASS_CODE: {
					BusModelBuffRelation mapped = new BusModelBuffRelation();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelRelation",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelRelation");
			}
		}
	}

	@Override
	public IBusModelRelationH newHRec() {
		IBusModelRelationH hrec =
			new BusModelBuffRelationH();
		return( hrec );
	}

	public BusModelBuffRelationH ensureHRec(IBusModelRelationH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffRelationH) {
			return ((BusModelBuffRelationH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelRelation.CLASS_CODE: {
					BusModelBuffRelationH mapped = new BusModelBuffRelationH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelRelation",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelRelation");
			}
		}
	}
}
