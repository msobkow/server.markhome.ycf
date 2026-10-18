
// Description: Java 25 Factory service implementation for RoleDef buffers

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
 *	Java 25 Factory service implementation for RoleDef buffers.
 */
@Service("busmodel31BuffRoleDefFactoryService")
public class BusModelBuffRoleDefFactoryService
	implements IBusModelRoleDefFactory
{
	public BusModelBuffRoleDefFactoryService() {
	}

	@Override
	public IBusModelRoleDefHPKey newHPKey() {
		IBusModelRoleDefHPKey hpkey =
			new BusModelBuffRoleDefHPKey();
		return( hpkey );
	}

	public BusModelBuffRoleDefHPKey ensureHPKey(IBusModelRoleDefHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof BusModelBuffRoleDefHPKey) {
			return( (BusModelBuffRoleDefHPKey)key );
		}
		else {
			BusModelBuffRoleDefHPKey mapped = new BusModelBuffRoleDefHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRoleDefByUNameIdxKey newByUNameIdxKey() {
		IBusModelRoleDefByUNameIdxKey key =
			new BusModelBuffRoleDefByUNameIdxKey();
		return( key );
	}

	public BusModelBuffRoleDefByUNameIdxKey ensureByUNameIdxKey(IBusModelRoleDefByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRoleDefByUNameIdxKey) {
			return( (BusModelBuffRoleDefByUNameIdxKey)key );
		}
		else {
			BusModelBuffRoleDefByUNameIdxKey mapped = new BusModelBuffRoleDefByUNameIdxKey();
			mapped.setRequiredScopeId( key.getRequiredScopeId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRoleDefByScopeIdxKey newByScopeIdxKey() {
		IBusModelRoleDefByScopeIdxKey key =
			new BusModelBuffRoleDefByScopeIdxKey();
		return( key );
	}

	public BusModelBuffRoleDefByScopeIdxKey ensureByScopeIdxKey(IBusModelRoleDefByScopeIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRoleDefByScopeIdxKey) {
			return( (BusModelBuffRoleDefByScopeIdxKey)key );
		}
		else {
			BusModelBuffRoleDefByScopeIdxKey mapped = new BusModelBuffRoleDefByScopeIdxKey();
			mapped.setRequiredScopeId( key.getRequiredScopeId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRoleDefByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelRoleDefByDefSchemaIdxKey key =
			new BusModelBuffRoleDefByDefSchemaIdxKey();
		return( key );
	}

	public BusModelBuffRoleDefByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelRoleDefByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRoleDefByDefSchemaIdxKey) {
			return( (BusModelBuffRoleDefByDefSchemaIdxKey)key );
		}
		else {
			BusModelBuffRoleDefByDefSchemaIdxKey mapped = new BusModelBuffRoleDefByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRoleDefByUDefIdxKey newByUDefIdxKey() {
		IBusModelRoleDefByUDefIdxKey key =
			new BusModelBuffRoleDefByUDefIdxKey();
		return( key );
	}

	public BusModelBuffRoleDefByUDefIdxKey ensureByUDefIdxKey(IBusModelRoleDefByUDefIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffRoleDefByUDefIdxKey) {
			return( (BusModelBuffRoleDefByUDefIdxKey)key );
		}
		else {
			BusModelBuffRoleDefByUDefIdxKey mapped = new BusModelBuffRoleDefByUDefIdxKey();
			mapped.setRequiredScopeId( key.getRequiredScopeId() );
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IBusModelRoleDef newRec() {
		IBusModelRoleDef rec =
			new BusModelBuffRoleDef();
		return( rec );
	}

	public BusModelBuffRoleDef ensureRec(IBusModelRoleDef rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffRoleDef) {
			return ((BusModelBuffRoleDef)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelRoleDef.CLASS_CODE: {
					BusModelBuffRoleDef mapped = new BusModelBuffRoleDef();
					mapped.set(rec);
					return(mapped); }
				case IBusModelSchemaRole.CLASS_CODE: {
					BusModelBuffSchemaRole mapped = new BusModelBuffSchemaRole();
					mapped.set((IBusModelSchemaRole)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelRoleDef",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelRoleDef");
			}
		}
	}

	@Override
	public IBusModelRoleDefH newHRec() {
		IBusModelRoleDefH hrec =
			new BusModelBuffRoleDefH();
		return( hrec );
	}

	public BusModelBuffRoleDefH ensureHRec(IBusModelRoleDefH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffRoleDefH) {
			return ((BusModelBuffRoleDefH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelRoleDef.CLASS_CODE: {
					BusModelBuffRoleDefH mapped = new BusModelBuffRoleDefH();
					mapped.set(hrec);
					return(mapped); }
				case IBusModelSchemaRole.CLASS_CODE: {
					BusModelBuffSchemaRoleH mapped = new BusModelBuffSchemaRoleH();
					mapped.set((IBusModelSchemaRoleH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelRoleDef",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelRoleDef");
			}
		}
	}
}
