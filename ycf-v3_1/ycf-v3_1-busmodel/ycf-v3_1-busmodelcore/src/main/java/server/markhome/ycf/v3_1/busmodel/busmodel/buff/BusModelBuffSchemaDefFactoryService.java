
// Description: Java 25 Factory service implementation for SchemaDef buffers

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
 *	Java 25 Factory service implementation for SchemaDef buffers.
 */
@Service("busmodel31BuffSchemaDefFactoryService")
public class BusModelBuffSchemaDefFactoryService
	implements IBusModelSchemaDefFactory
{
	public BusModelBuffSchemaDefFactoryService() {
	}

	@Override
	public IBusModelSchemaDefByCTenantIdxKey newByCTenantIdxKey() {
		IBusModelSchemaDefByCTenantIdxKey key =
			new BusModelBuffSchemaDefByCTenantIdxKey();
		return( key );
	}

	public BusModelBuffSchemaDefByCTenantIdxKey ensureByCTenantIdxKey(IBusModelSchemaDefByCTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffSchemaDefByCTenantIdxKey) {
			return( (BusModelBuffSchemaDefByCTenantIdxKey)key );
		}
		else {
			BusModelBuffSchemaDefByCTenantIdxKey mapped = new BusModelBuffSchemaDefByCTenantIdxKey();
			mapped.setRequiredCTenantId( key.getRequiredCTenantId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelSchemaDefByMinorVersionIdxKey newByMinorVersionIdxKey() {
		IBusModelSchemaDefByMinorVersionIdxKey key =
			new BusModelBuffSchemaDefByMinorVersionIdxKey();
		return( key );
	}

	public BusModelBuffSchemaDefByMinorVersionIdxKey ensureByMinorVersionIdxKey(IBusModelSchemaDefByMinorVersionIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffSchemaDefByMinorVersionIdxKey) {
			return( (BusModelBuffSchemaDefByMinorVersionIdxKey)key );
		}
		else {
			BusModelBuffSchemaDefByMinorVersionIdxKey mapped = new BusModelBuffSchemaDefByMinorVersionIdxKey();
			mapped.setRequiredMinorVersionId( key.getRequiredMinorVersionId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelSchemaDefByUNameIdxKey newByUNameIdxKey() {
		IBusModelSchemaDefByUNameIdxKey key =
			new BusModelBuffSchemaDefByUNameIdxKey();
		return( key );
	}

	public BusModelBuffSchemaDefByUNameIdxKey ensureByUNameIdxKey(IBusModelSchemaDefByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffSchemaDefByUNameIdxKey) {
			return( (BusModelBuffSchemaDefByUNameIdxKey)key );
		}
		else {
			BusModelBuffSchemaDefByUNameIdxKey mapped = new BusModelBuffSchemaDefByUNameIdxKey();
			mapped.setRequiredMinorVersionId( key.getRequiredMinorVersionId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IBusModelSchemaDefByAuthEMailIdxKey newByAuthEMailIdxKey() {
		IBusModelSchemaDefByAuthEMailIdxKey key =
			new BusModelBuffSchemaDefByAuthEMailIdxKey();
		return( key );
	}

	public BusModelBuffSchemaDefByAuthEMailIdxKey ensureByAuthEMailIdxKey(IBusModelSchemaDefByAuthEMailIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffSchemaDefByAuthEMailIdxKey) {
			return( (BusModelBuffSchemaDefByAuthEMailIdxKey)key );
		}
		else {
			BusModelBuffSchemaDefByAuthEMailIdxKey mapped = new BusModelBuffSchemaDefByAuthEMailIdxKey();
			mapped.setRequiredCTenantId( key.getRequiredCTenantId() );
			mapped.setRequiredAuthorEMail( key.getRequiredAuthorEMail() );
			return( mapped );
		}
	}

	@Override
	public IBusModelSchemaDefByProjectURLIdxKey newByProjectURLIdxKey() {
		IBusModelSchemaDefByProjectURLIdxKey key =
			new BusModelBuffSchemaDefByProjectURLIdxKey();
		return( key );
	}

	public BusModelBuffSchemaDefByProjectURLIdxKey ensureByProjectURLIdxKey(IBusModelSchemaDefByProjectURLIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffSchemaDefByProjectURLIdxKey) {
			return( (BusModelBuffSchemaDefByProjectURLIdxKey)key );
		}
		else {
			BusModelBuffSchemaDefByProjectURLIdxKey mapped = new BusModelBuffSchemaDefByProjectURLIdxKey();
			mapped.setRequiredCTenantId( key.getRequiredCTenantId() );
			mapped.setRequiredProjectURL( key.getRequiredProjectURL() );
			return( mapped );
		}
	}

	@Override
	public IBusModelSchemaDefByPubURIIdxKey newByPubURIIdxKey() {
		IBusModelSchemaDefByPubURIIdxKey key =
			new BusModelBuffSchemaDefByPubURIIdxKey();
		return( key );
	}

	public BusModelBuffSchemaDefByPubURIIdxKey ensureByPubURIIdxKey(IBusModelSchemaDefByPubURIIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffSchemaDefByPubURIIdxKey) {
			return( (BusModelBuffSchemaDefByPubURIIdxKey)key );
		}
		else {
			BusModelBuffSchemaDefByPubURIIdxKey mapped = new BusModelBuffSchemaDefByPubURIIdxKey();
			mapped.setRequiredCTenantId( key.getRequiredCTenantId() );
			mapped.setRequiredPublishURI( key.getRequiredPublishURI() );
			return( mapped );
		}
	}

	@Override
	public IBusModelSchemaDef newRec() {
		IBusModelSchemaDef rec =
			new BusModelBuffSchemaDef();
		return( rec );
	}

	public BusModelBuffSchemaDef ensureRec(IBusModelSchemaDef rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffSchemaDef) {
			return ((BusModelBuffSchemaDef)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelSchemaDef.CLASS_CODE: {
					BusModelBuffSchemaDef mapped = new BusModelBuffSchemaDef();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelSchemaDef",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelSchemaDef");
			}
		}
	}

	@Override
	public IBusModelSchemaDefH newHRec() {
		IBusModelSchemaDefH hrec =
			new BusModelBuffSchemaDefH();
		return( hrec );
	}

	public BusModelBuffSchemaDefH ensureHRec(IBusModelSchemaDefH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffSchemaDefH) {
			return ((BusModelBuffSchemaDefH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelSchemaDef.CLASS_CODE: {
					BusModelBuffSchemaDefH mapped = new BusModelBuffSchemaDefH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelSchemaDef",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelSchemaDef");
			}
		}
	}
}
