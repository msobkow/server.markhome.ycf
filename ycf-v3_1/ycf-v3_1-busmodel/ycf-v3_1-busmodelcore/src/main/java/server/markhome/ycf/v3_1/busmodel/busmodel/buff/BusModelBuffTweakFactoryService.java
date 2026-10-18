
// Description: Java 25 Factory service implementation for Tweak buffers

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
 *	Java 25 Factory service implementation for Tweak buffers.
 */
@Service("busmodel31BuffTweakFactoryService")
public class BusModelBuffTweakFactoryService
	implements IBusModelTweakFactory
{
	public BusModelBuffTweakFactoryService() {
	}

	@Override
	public IBusModelTweakHPKey newHPKey() {
		IBusModelTweakHPKey hpkey =
			new BusModelBuffTweakHPKey();
		return( hpkey );
	}

	public BusModelBuffTweakHPKey ensureHPKey(IBusModelTweakHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof BusModelBuffTweakHPKey) {
			return( (BusModelBuffTweakHPKey)key );
		}
		else {
			BusModelBuffTweakHPKey mapped = new BusModelBuffTweakHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelTweakByUNameIdxKey newByUNameIdxKey() {
		IBusModelTweakByUNameIdxKey key =
			new BusModelBuffTweakByUNameIdxKey();
		return( key );
	}

	public BusModelBuffTweakByUNameIdxKey ensureByUNameIdxKey(IBusModelTweakByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffTweakByUNameIdxKey) {
			return( (BusModelBuffTweakByUNameIdxKey)key );
		}
		else {
			BusModelBuffTweakByUNameIdxKey mapped = new BusModelBuffTweakByUNameIdxKey();
			mapped.setRequiredScopeId( key.getRequiredScopeId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IBusModelTweakByValTentIdxKey newByValTentIdxKey() {
		IBusModelTweakByValTentIdxKey key =
			new BusModelBuffTweakByValTentIdxKey();
		return( key );
	}

	public BusModelBuffTweakByValTentIdxKey ensureByValTentIdxKey(IBusModelTweakByValTentIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffTweakByValTentIdxKey) {
			return( (BusModelBuffTweakByValTentIdxKey)key );
		}
		else {
			BusModelBuffTweakByValTentIdxKey mapped = new BusModelBuffTweakByValTentIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelTweakByScopeIdxKey newByScopeIdxKey() {
		IBusModelTweakByScopeIdxKey key =
			new BusModelBuffTweakByScopeIdxKey();
		return( key );
	}

	public BusModelBuffTweakByScopeIdxKey ensureByScopeIdxKey(IBusModelTweakByScopeIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffTweakByScopeIdxKey) {
			return( (BusModelBuffTweakByScopeIdxKey)key );
		}
		else {
			BusModelBuffTweakByScopeIdxKey mapped = new BusModelBuffTweakByScopeIdxKey();
			mapped.setRequiredScopeId( key.getRequiredScopeId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelTweakByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelTweakByDefSchemaIdxKey key =
			new BusModelBuffTweakByDefSchemaIdxKey();
		return( key );
	}

	public BusModelBuffTweakByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelTweakByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffTweakByDefSchemaIdxKey) {
			return( (BusModelBuffTweakByDefSchemaIdxKey)key );
		}
		else {
			BusModelBuffTweakByDefSchemaIdxKey mapped = new BusModelBuffTweakByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelTweakByUDefIdxKey newByUDefIdxKey() {
		IBusModelTweakByUDefIdxKey key =
			new BusModelBuffTweakByUDefIdxKey();
		return( key );
	}

	public BusModelBuffTweakByUDefIdxKey ensureByUDefIdxKey(IBusModelTweakByUDefIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffTweakByUDefIdxKey) {
			return( (BusModelBuffTweakByUDefIdxKey)key );
		}
		else {
			BusModelBuffTweakByUDefIdxKey mapped = new BusModelBuffTweakByUDefIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			mapped.setRequiredScopeId( key.getRequiredScopeId() );
			mapped.setOptionalDefSchemaTenantId( key.getOptionalDefSchemaTenantId() );
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IBusModelTweak newRec() {
		IBusModelTweak rec =
			new BusModelBuffTweak();
		return( rec );
	}

	public BusModelBuffTweak ensureRec(IBusModelTweak rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffTweak) {
			return ((BusModelBuffTweak)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelTweak.CLASS_CODE: {
					BusModelBuffTweak mapped = new BusModelBuffTweak();
					mapped.set(rec);
					return(mapped); }
				case IBusModelTableTweak.CLASS_CODE: {
					BusModelBuffTableTweak mapped = new BusModelBuffTableTweak();
					mapped.set((IBusModelTableTweak)rec);
					return(mapped); }
				case IBusModelSchemaTweak.CLASS_CODE: {
					BusModelBuffSchemaTweak mapped = new BusModelBuffSchemaTweak();
					mapped.set((IBusModelSchemaTweak)rec);
					return(mapped); }
				case IBusModelIndexTweak.CLASS_CODE: {
					BusModelBuffIndexTweak mapped = new BusModelBuffIndexTweak();
					mapped.set((IBusModelIndexTweak)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelTweak",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelTweak");
			}
		}
	}

	@Override
	public IBusModelTweakH newHRec() {
		IBusModelTweakH hrec =
			new BusModelBuffTweakH();
		return( hrec );
	}

	public BusModelBuffTweakH ensureHRec(IBusModelTweakH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffTweakH) {
			return ((BusModelBuffTweakH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelTweak.CLASS_CODE: {
					BusModelBuffTweakH mapped = new BusModelBuffTweakH();
					mapped.set(hrec);
					return(mapped); }
				case IBusModelTableTweak.CLASS_CODE: {
					BusModelBuffTableTweakH mapped = new BusModelBuffTableTweakH();
					mapped.set((IBusModelTableTweakH)hrec);
					return(mapped); }
				case IBusModelSchemaTweak.CLASS_CODE: {
					BusModelBuffSchemaTweakH mapped = new BusModelBuffSchemaTweakH();
					mapped.set((IBusModelSchemaTweakH)hrec);
					return(mapped); }
				case IBusModelIndexTweak.CLASS_CODE: {
					BusModelBuffIndexTweakH mapped = new BusModelBuffIndexTweakH();
					mapped.set((IBusModelIndexTweakH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelTweak",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelTweak");
			}
		}
	}
}
