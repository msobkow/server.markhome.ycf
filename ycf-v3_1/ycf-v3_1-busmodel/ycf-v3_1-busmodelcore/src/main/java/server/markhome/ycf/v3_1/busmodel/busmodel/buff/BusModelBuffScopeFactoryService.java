
// Description: Java 25 Factory service implementation for Scope buffers

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
 *	Java 25 Factory service implementation for Scope buffers.
 */
@Service("busmodel31BuffScopeFactoryService")
public class BusModelBuffScopeFactoryService
	implements IBusModelScopeFactory
{
	public BusModelBuffScopeFactoryService() {
	}

	@Override
	public IBusModelScopeHPKey newHPKey() {
		IBusModelScopeHPKey hpkey =
			new BusModelBuffScopeHPKey();
		return( hpkey );
	}

	public BusModelBuffScopeHPKey ensureHPKey(IBusModelScopeHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof BusModelBuffScopeHPKey) {
			return( (BusModelBuffScopeHPKey)key );
		}
		else {
			BusModelBuffScopeHPKey mapped = new BusModelBuffScopeHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelScopeByTenantIdxKey newByTenantIdxKey() {
		IBusModelScopeByTenantIdxKey key =
			new BusModelBuffScopeByTenantIdxKey();
		return( key );
	}

	public BusModelBuffScopeByTenantIdxKey ensureByTenantIdxKey(IBusModelScopeByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelBuffScopeByTenantIdxKey) {
			return( (BusModelBuffScopeByTenantIdxKey)key );
		}
		else {
			BusModelBuffScopeByTenantIdxKey mapped = new BusModelBuffScopeByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public IBusModelScope newRec() {
		IBusModelScope rec =
			new BusModelBuffScope();
		return( rec );
	}

	public BusModelBuffScope ensureRec(IBusModelScope rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelBuffScope) {
			return ((BusModelBuffScope)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IBusModelScope.CLASS_CODE: {
					BusModelBuffScope mapped = new BusModelBuffScope();
					mapped.set(rec);
					return(mapped); }
				case IBusModelSchemaDef.CLASS_CODE: {
					BusModelBuffSchemaDef mapped = new BusModelBuffSchemaDef();
					mapped.set((IBusModelSchemaDef)rec);
					return(mapped); }
				case IBusModelSchemaRef.CLASS_CODE: {
					BusModelBuffSchemaRef mapped = new BusModelBuffSchemaRef();
					mapped.set((IBusModelSchemaRef)rec);
					return(mapped); }
				case IBusModelServerMethod.CLASS_CODE: {
					BusModelBuffServerMethod mapped = new BusModelBuffServerMethod();
					mapped.set((IBusModelServerMethod)rec);
					return(mapped); }
				case IBusModelServerObjFunc.CLASS_CODE: {
					BusModelBuffServerObjFunc mapped = new BusModelBuffServerObjFunc();
					mapped.set((IBusModelServerObjFunc)rec);
					return(mapped); }
				case IBusModelServerProc.CLASS_CODE: {
					BusModelBuffServerProc mapped = new BusModelBuffServerProc();
					mapped.set((IBusModelServerProc)rec);
					return(mapped); }
				case IBusModelServerListFunc.CLASS_CODE: {
					BusModelBuffServerListFunc mapped = new BusModelBuffServerListFunc();
					mapped.set((IBusModelServerListFunc)rec);
					return(mapped); }
				case IBusModelTable.CLASS_CODE: {
					BusModelBuffTable mapped = new BusModelBuffTable();
					mapped.set((IBusModelTable)rec);
					return(mapped); }
				case IBusModelClearDep.CLASS_CODE: {
					BusModelBuffClearDep mapped = new BusModelBuffClearDep();
					mapped.set((IBusModelClearDep)rec);
					return(mapped); }
				case IBusModelClearSubDep1.CLASS_CODE: {
					BusModelBuffClearSubDep1 mapped = new BusModelBuffClearSubDep1();
					mapped.set((IBusModelClearSubDep1)rec);
					return(mapped); }
				case IBusModelClearSubDep2.CLASS_CODE: {
					BusModelBuffClearSubDep2 mapped = new BusModelBuffClearSubDep2();
					mapped.set((IBusModelClearSubDep2)rec);
					return(mapped); }
				case IBusModelClearSubDep3.CLASS_CODE: {
					BusModelBuffClearSubDep3 mapped = new BusModelBuffClearSubDep3();
					mapped.set((IBusModelClearSubDep3)rec);
					return(mapped); }
				case IBusModelClearTopDep.CLASS_CODE: {
					BusModelBuffClearTopDep mapped = new BusModelBuffClearTopDep();
					mapped.set((IBusModelClearTopDep)rec);
					return(mapped); }
				case IBusModelDelDep.CLASS_CODE: {
					BusModelBuffDelDep mapped = new BusModelBuffDelDep();
					mapped.set((IBusModelDelDep)rec);
					return(mapped); }
				case IBusModelDelSubDep1.CLASS_CODE: {
					BusModelBuffDelSubDep1 mapped = new BusModelBuffDelSubDep1();
					mapped.set((IBusModelDelSubDep1)rec);
					return(mapped); }
				case IBusModelDelSubDep2.CLASS_CODE: {
					BusModelBuffDelSubDep2 mapped = new BusModelBuffDelSubDep2();
					mapped.set((IBusModelDelSubDep2)rec);
					return(mapped); }
				case IBusModelDelSubDep3.CLASS_CODE: {
					BusModelBuffDelSubDep3 mapped = new BusModelBuffDelSubDep3();
					mapped.set((IBusModelDelSubDep3)rec);
					return(mapped); }
				case IBusModelDelTopDep.CLASS_CODE: {
					BusModelBuffDelTopDep mapped = new BusModelBuffDelTopDep();
					mapped.set((IBusModelDelTopDep)rec);
					return(mapped); }
				case IBusModelIndex.CLASS_CODE: {
					BusModelBuffIndex mapped = new BusModelBuffIndex();
					mapped.set((IBusModelIndex)rec);
					return(mapped); }
				case IBusModelPopDep.CLASS_CODE: {
					BusModelBuffPopDep mapped = new BusModelBuffPopDep();
					mapped.set((IBusModelPopDep)rec);
					return(mapped); }
				case IBusModelPopSubDep1.CLASS_CODE: {
					BusModelBuffPopSubDep1 mapped = new BusModelBuffPopSubDep1();
					mapped.set((IBusModelPopSubDep1)rec);
					return(mapped); }
				case IBusModelPopSubDep2.CLASS_CODE: {
					BusModelBuffPopSubDep2 mapped = new BusModelBuffPopSubDep2();
					mapped.set((IBusModelPopSubDep2)rec);
					return(mapped); }
				case IBusModelPopSubDep3.CLASS_CODE: {
					BusModelBuffPopSubDep3 mapped = new BusModelBuffPopSubDep3();
					mapped.set((IBusModelPopSubDep3)rec);
					return(mapped); }
				case IBusModelPopTopDep.CLASS_CODE: {
					BusModelBuffPopTopDep mapped = new BusModelBuffPopTopDep();
					mapped.set((IBusModelPopTopDep)rec);
					return(mapped); }
				case IBusModelRelation.CLASS_CODE: {
					BusModelBuffRelation mapped = new BusModelBuffRelation();
					mapped.set((IBusModelRelation)rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelScope",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of BusModelScope");
			}
		}
	}

	@Override
	public IBusModelScopeH newHRec() {
		IBusModelScopeH hrec =
			new BusModelBuffScopeH();
		return( hrec );
	}

	public BusModelBuffScopeH ensureHRec(IBusModelScopeH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelBuffScopeH) {
			return ((BusModelBuffScopeH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IBusModelScope.CLASS_CODE: {
					BusModelBuffScopeH mapped = new BusModelBuffScopeH();
					mapped.set(hrec);
					return(mapped); }
				case IBusModelSchemaDef.CLASS_CODE: {
					BusModelBuffSchemaDefH mapped = new BusModelBuffSchemaDefH();
					mapped.set((IBusModelSchemaDefH)hrec);
					return(mapped); }
				case IBusModelSchemaRef.CLASS_CODE: {
					BusModelBuffSchemaRefH mapped = new BusModelBuffSchemaRefH();
					mapped.set((IBusModelSchemaRefH)hrec);
					return(mapped); }
				case IBusModelServerMethod.CLASS_CODE: {
					BusModelBuffServerMethodH mapped = new BusModelBuffServerMethodH();
					mapped.set((IBusModelServerMethodH)hrec);
					return(mapped); }
				case IBusModelServerObjFunc.CLASS_CODE: {
					BusModelBuffServerObjFuncH mapped = new BusModelBuffServerObjFuncH();
					mapped.set((IBusModelServerObjFuncH)hrec);
					return(mapped); }
				case IBusModelServerProc.CLASS_CODE: {
					BusModelBuffServerProcH mapped = new BusModelBuffServerProcH();
					mapped.set((IBusModelServerProcH)hrec);
					return(mapped); }
				case IBusModelServerListFunc.CLASS_CODE: {
					BusModelBuffServerListFuncH mapped = new BusModelBuffServerListFuncH();
					mapped.set((IBusModelServerListFuncH)hrec);
					return(mapped); }
				case IBusModelTable.CLASS_CODE: {
					BusModelBuffTableH mapped = new BusModelBuffTableH();
					mapped.set((IBusModelTableH)hrec);
					return(mapped); }
				case IBusModelClearDep.CLASS_CODE: {
					BusModelBuffClearDepH mapped = new BusModelBuffClearDepH();
					mapped.set((IBusModelClearDepH)hrec);
					return(mapped); }
				case IBusModelClearSubDep1.CLASS_CODE: {
					BusModelBuffClearSubDep1H mapped = new BusModelBuffClearSubDep1H();
					mapped.set((IBusModelClearSubDep1H)hrec);
					return(mapped); }
				case IBusModelClearSubDep2.CLASS_CODE: {
					BusModelBuffClearSubDep2H mapped = new BusModelBuffClearSubDep2H();
					mapped.set((IBusModelClearSubDep2H)hrec);
					return(mapped); }
				case IBusModelClearSubDep3.CLASS_CODE: {
					BusModelBuffClearSubDep3H mapped = new BusModelBuffClearSubDep3H();
					mapped.set((IBusModelClearSubDep3H)hrec);
					return(mapped); }
				case IBusModelClearTopDep.CLASS_CODE: {
					BusModelBuffClearTopDepH mapped = new BusModelBuffClearTopDepH();
					mapped.set((IBusModelClearTopDepH)hrec);
					return(mapped); }
				case IBusModelDelDep.CLASS_CODE: {
					BusModelBuffDelDepH mapped = new BusModelBuffDelDepH();
					mapped.set((IBusModelDelDepH)hrec);
					return(mapped); }
				case IBusModelDelSubDep1.CLASS_CODE: {
					BusModelBuffDelSubDep1H mapped = new BusModelBuffDelSubDep1H();
					mapped.set((IBusModelDelSubDep1H)hrec);
					return(mapped); }
				case IBusModelDelSubDep2.CLASS_CODE: {
					BusModelBuffDelSubDep2H mapped = new BusModelBuffDelSubDep2H();
					mapped.set((IBusModelDelSubDep2H)hrec);
					return(mapped); }
				case IBusModelDelSubDep3.CLASS_CODE: {
					BusModelBuffDelSubDep3H mapped = new BusModelBuffDelSubDep3H();
					mapped.set((IBusModelDelSubDep3H)hrec);
					return(mapped); }
				case IBusModelDelTopDep.CLASS_CODE: {
					BusModelBuffDelTopDepH mapped = new BusModelBuffDelTopDepH();
					mapped.set((IBusModelDelTopDepH)hrec);
					return(mapped); }
				case IBusModelIndex.CLASS_CODE: {
					BusModelBuffIndexH mapped = new BusModelBuffIndexH();
					mapped.set((IBusModelIndexH)hrec);
					return(mapped); }
				case IBusModelPopDep.CLASS_CODE: {
					BusModelBuffPopDepH mapped = new BusModelBuffPopDepH();
					mapped.set((IBusModelPopDepH)hrec);
					return(mapped); }
				case IBusModelPopSubDep1.CLASS_CODE: {
					BusModelBuffPopSubDep1H mapped = new BusModelBuffPopSubDep1H();
					mapped.set((IBusModelPopSubDep1H)hrec);
					return(mapped); }
				case IBusModelPopSubDep2.CLASS_CODE: {
					BusModelBuffPopSubDep2H mapped = new BusModelBuffPopSubDep2H();
					mapped.set((IBusModelPopSubDep2H)hrec);
					return(mapped); }
				case IBusModelPopSubDep3.CLASS_CODE: {
					BusModelBuffPopSubDep3H mapped = new BusModelBuffPopSubDep3H();
					mapped.set((IBusModelPopSubDep3H)hrec);
					return(mapped); }
				case IBusModelPopTopDep.CLASS_CODE: {
					BusModelBuffPopTopDepH mapped = new BusModelBuffPopTopDepH();
					mapped.set((IBusModelPopTopDepH)hrec);
					return(mapped); }
				case IBusModelRelation.CLASS_CODE: {
					BusModelBuffRelationH mapped = new BusModelBuffRelationH();
					mapped.set((IBusModelRelationH)hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelScope",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of BusModelScope");
			}
		}
	}
}
