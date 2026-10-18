
// Description: Java 25 Factory service implementation for Table buffers

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
 *	Java 25 Factory service implementation for Table buffers.
 */
@Service("busmodel31BuffTableFactoryService")
public class BusModelBuffTableFactoryService
	implements IBusModelTableFactory
{
	public BusModelBuffTableFactoryService() {
	}

	@Override
	public IBusModelTableBySchemaDefIdxKey newBySchemaDefIdxKey() {
		IBusModelTableBySchemaDefIdxKey key =
			new BusModelBuffTableBySchemaDefIdxKey();
		return( key );
	}

	public BusModelBuffTableBySchemaDefIdxKey ensureBySchemaDefIdxKey(IBusModelTableBySchemaDefIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffTableBySchemaDefIdxKey) {
			return( (BusModelBuffTableBySchemaDefIdxKey)key );
		}
		else {
			BusModelBuffTableBySchemaDefIdxKey mapped = new BusModelBuffTableBySchemaDefIdxKey();
			mapped.setRequiredSchemaDefId( key.getRequiredSchemaDefId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelTableByCodeVisIdxKey newByCodeVisIdxKey() {
		IBusModelTableByCodeVisIdxKey key =
			new BusModelBuffTableByCodeVisIdxKey();
		return( key );
	}

	public BusModelBuffTableByCodeVisIdxKey ensureByCodeVisIdxKey(IBusModelTableByCodeVisIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffTableByCodeVisIdxKey) {
			return( (BusModelBuffTableByCodeVisIdxKey)key );
		}
		else {
			BusModelBuffTableByCodeVisIdxKey mapped = new BusModelBuffTableByCodeVisIdxKey();
			mapped.setRequiredCodeVis( key.getRequiredCodeVis() );
			return( mapped );
		}
	}

	@Override
	public IBusModelTableBySchemaCodeVisIdxKey newBySchemaCodeVisIdxKey() {
		IBusModelTableBySchemaCodeVisIdxKey key =
			new BusModelBuffTableBySchemaCodeVisIdxKey();
		return( key );
	}

	public BusModelBuffTableBySchemaCodeVisIdxKey ensureBySchemaCodeVisIdxKey(IBusModelTableBySchemaCodeVisIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffTableBySchemaCodeVisIdxKey) {
			return( (BusModelBuffTableBySchemaCodeVisIdxKey)key );
		}
		else {
			BusModelBuffTableBySchemaCodeVisIdxKey mapped = new BusModelBuffTableBySchemaCodeVisIdxKey();
			mapped.setRequiredSchemaDefId( key.getRequiredSchemaDefId() );
			mapped.setRequiredCodeVis( key.getRequiredCodeVis() );
			return( mapped );
		}
	}

	@Override
	public IBusModelTableByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelTableByDefSchemaIdxKey key =
			new BusModelBuffTableByDefSchemaIdxKey();
		return( key );
	}

	public BusModelBuffTableByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelTableByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffTableByDefSchemaIdxKey) {
			return( (BusModelBuffTableByDefSchemaIdxKey)key );
		}
		else {
			BusModelBuffTableByDefSchemaIdxKey mapped = new BusModelBuffTableByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelTableByUNameIdxKey newByUNameIdxKey() {
		IBusModelTableByUNameIdxKey key =
			new BusModelBuffTableByUNameIdxKey();
		return( key );
	}

	public BusModelBuffTableByUNameIdxKey ensureByUNameIdxKey(IBusModelTableByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffTableByUNameIdxKey) {
			return( (BusModelBuffTableByUNameIdxKey)key );
		}
		else {
			BusModelBuffTableByUNameIdxKey mapped = new BusModelBuffTableByUNameIdxKey();
			mapped.setRequiredSchemaDefId( key.getRequiredSchemaDefId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IBusModelTableBySchemaCdIdxKey newBySchemaCdIdxKey() {
		IBusModelTableBySchemaCdIdxKey key =
			new BusModelBuffTableBySchemaCdIdxKey();
		return( key );
	}

	public BusModelBuffTableBySchemaCdIdxKey ensureBySchemaCdIdxKey(IBusModelTableBySchemaCdIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffTableBySchemaCdIdxKey) {
			return( (BusModelBuffTableBySchemaCdIdxKey)key );
		}
		else {
			BusModelBuffTableBySchemaCdIdxKey mapped = new BusModelBuffTableBySchemaCdIdxKey();
			mapped.setRequiredSchemaDefId( key.getRequiredSchemaDefId() );
			mapped.setRequiredTableClassCode( key.getRequiredTableClassCode() );
			return( mapped );
		}
	}

	@Override
	public IBusModelTableByPrimaryIndexIdxKey newByPrimaryIndexIdxKey() {
		IBusModelTableByPrimaryIndexIdxKey key =
			new BusModelBuffTableByPrimaryIndexIdxKey();
		return( key );
	}

	public BusModelBuffTableByPrimaryIndexIdxKey ensureByPrimaryIndexIdxKey(IBusModelTableByPrimaryIndexIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffTableByPrimaryIndexIdxKey) {
			return( (BusModelBuffTableByPrimaryIndexIdxKey)key );
		}
		else {
			BusModelBuffTableByPrimaryIndexIdxKey mapped = new BusModelBuffTableByPrimaryIndexIdxKey();
			mapped.setOptionalPrimaryIndexId( key.getOptionalPrimaryIndexId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelTableByLookupIndexIdxKey newByLookupIndexIdxKey() {
		IBusModelTableByLookupIndexIdxKey key =
			new BusModelBuffTableByLookupIndexIdxKey();
		return( key );
	}

	public BusModelBuffTableByLookupIndexIdxKey ensureByLookupIndexIdxKey(IBusModelTableByLookupIndexIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffTableByLookupIndexIdxKey) {
			return( (BusModelBuffTableByLookupIndexIdxKey)key );
		}
		else {
			BusModelBuffTableByLookupIndexIdxKey mapped = new BusModelBuffTableByLookupIndexIdxKey();
			mapped.setOptionalLookupIndexId( key.getOptionalLookupIndexId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelTableByAltIndexIdxKey newByAltIndexIdxKey() {
		IBusModelTableByAltIndexIdxKey key =
			new BusModelBuffTableByAltIndexIdxKey();
		return( key );
	}

	public BusModelBuffTableByAltIndexIdxKey ensureByAltIndexIdxKey(IBusModelTableByAltIndexIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffTableByAltIndexIdxKey) {
			return( (BusModelBuffTableByAltIndexIdxKey)key );
		}
		else {
			BusModelBuffTableByAltIndexIdxKey mapped = new BusModelBuffTableByAltIndexIdxKey();
			mapped.setOptionalAltIndexId( key.getOptionalAltIndexId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelTableByQualTableIdxKey newByQualTableIdxKey() {
		IBusModelTableByQualTableIdxKey key =
			new BusModelBuffTableByQualTableIdxKey();
		return( key );
	}

	public BusModelBuffTableByQualTableIdxKey ensureByQualTableIdxKey(IBusModelTableByQualTableIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffTableByQualTableIdxKey) {
			return( (BusModelBuffTableByQualTableIdxKey)key );
		}
		else {
			BusModelBuffTableByQualTableIdxKey mapped = new BusModelBuffTableByQualTableIdxKey();
			mapped.setOptionalQualifyingTableId( key.getOptionalQualifyingTableId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelTable newRec() {
		IBusModelTable rec =
			new BusModelBuffTable();
		return( rec );
	}

	public BusModelBuffTable ensureRec(IBusModelTable rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffTable) {
			return ((BusModelBuffTable)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelTable.CLASS_CODE: {
					BusModelBuffTable mapped = new BusModelBuffTable();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelTable",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelTable");
			}
		}
	}

	@Override
	public IBusModelTableH newHRec() {
		IBusModelTableH hrec =
			new BusModelBuffTableH();
		return( hrec );
	}

	public BusModelBuffTableH ensureHRec(IBusModelTableH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffTableH) {
			return ((BusModelBuffTableH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelTable.CLASS_CODE: {
					BusModelBuffTableH mapped = new BusModelBuffTableH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelTable",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelTable");
			}
		}
	}
}
