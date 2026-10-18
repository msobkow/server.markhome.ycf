
// Description: Java 25 Factory service implementation for Scope JPA objects

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

package server.markhome.ycf.v3_1.busmodel.busmodel.jpa;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secure.jpa.*;
import server.markhome.ycf.v3_1.intnet.intnet.jpa.*;

/*
 *	Java 25 Factory service implementation for Scope JPA objects.
 */
public class BusModelJpaScopeFactoryService
    implements IBusModelScopeFactory
{
    public BusModelJpaScopeFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelScopeHPKey newHPKey() {
        IBusModelScopeHPKey hpkey = new BusModelJpaScopeHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaScopeHPKey ensureHPKey(IBusModelScopeHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof BusModelJpaScopeHPKey) {
			return( (BusModelJpaScopeHPKey)key );
		}
		else {
			BusModelJpaScopeHPKey mapped = new BusModelJpaScopeHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelScopeByTenantIdxKey newByTenantIdxKey() {
		IBusModelScopeByTenantIdxKey key = new BusModelJpaScopeByTenantIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaScopeByTenantIdxKey ensureByTenantIdxKey(IBusModelScopeByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaScopeByTenantIdxKey) {
			return( (BusModelJpaScopeByTenantIdxKey)key );
		}
		else {
			BusModelJpaScopeByTenantIdxKey mapped = new BusModelJpaScopeByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelScope newRec() {
        IBusModelScope rec = new BusModelJpaScope();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaScope ensureRec(IBusModelScope rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaScope) {
			return( (BusModelJpaScope)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelScope.CLASS_CODE: {
					BusModelJpaScope mapped = new BusModelJpaScope();
					mapped.set(rec);
					return( mapped ); }
				case IBusModelSchemaDef.CLASS_CODE: {
					BusModelJpaSchemaDef mapped = new BusModelJpaSchemaDef();
					mapped.set((IBusModelSchemaDef)rec);
					return(mapped); }
				case IBusModelSchemaRef.CLASS_CODE: {
					BusModelJpaSchemaRef mapped = new BusModelJpaSchemaRef();
					mapped.set((IBusModelSchemaRef)rec);
					return(mapped); }
				case IBusModelServerMethod.CLASS_CODE: {
					BusModelJpaServerMethod mapped = new BusModelJpaServerMethod();
					mapped.set((IBusModelServerMethod)rec);
					return(mapped); }
				case IBusModelServerObjFunc.CLASS_CODE: {
					BusModelJpaServerObjFunc mapped = new BusModelJpaServerObjFunc();
					mapped.set((IBusModelServerObjFunc)rec);
					return(mapped); }
				case IBusModelServerProc.CLASS_CODE: {
					BusModelJpaServerProc mapped = new BusModelJpaServerProc();
					mapped.set((IBusModelServerProc)rec);
					return(mapped); }
				case IBusModelServerListFunc.CLASS_CODE: {
					BusModelJpaServerListFunc mapped = new BusModelJpaServerListFunc();
					mapped.set((IBusModelServerListFunc)rec);
					return(mapped); }
				case IBusModelTable.CLASS_CODE: {
					BusModelJpaTable mapped = new BusModelJpaTable();
					mapped.set((IBusModelTable)rec);
					return(mapped); }
				case IBusModelClearDep.CLASS_CODE: {
					BusModelJpaClearDep mapped = new BusModelJpaClearDep();
					mapped.set((IBusModelClearDep)rec);
					return(mapped); }
				case IBusModelClearSubDep1.CLASS_CODE: {
					BusModelJpaClearSubDep1 mapped = new BusModelJpaClearSubDep1();
					mapped.set((IBusModelClearSubDep1)rec);
					return(mapped); }
				case IBusModelClearSubDep2.CLASS_CODE: {
					BusModelJpaClearSubDep2 mapped = new BusModelJpaClearSubDep2();
					mapped.set((IBusModelClearSubDep2)rec);
					return(mapped); }
				case IBusModelClearSubDep3.CLASS_CODE: {
					BusModelJpaClearSubDep3 mapped = new BusModelJpaClearSubDep3();
					mapped.set((IBusModelClearSubDep3)rec);
					return(mapped); }
				case IBusModelClearTopDep.CLASS_CODE: {
					BusModelJpaClearTopDep mapped = new BusModelJpaClearTopDep();
					mapped.set((IBusModelClearTopDep)rec);
					return(mapped); }
				case IBusModelDelDep.CLASS_CODE: {
					BusModelJpaDelDep mapped = new BusModelJpaDelDep();
					mapped.set((IBusModelDelDep)rec);
					return(mapped); }
				case IBusModelDelSubDep1.CLASS_CODE: {
					BusModelJpaDelSubDep1 mapped = new BusModelJpaDelSubDep1();
					mapped.set((IBusModelDelSubDep1)rec);
					return(mapped); }
				case IBusModelDelSubDep2.CLASS_CODE: {
					BusModelJpaDelSubDep2 mapped = new BusModelJpaDelSubDep2();
					mapped.set((IBusModelDelSubDep2)rec);
					return(mapped); }
				case IBusModelDelSubDep3.CLASS_CODE: {
					BusModelJpaDelSubDep3 mapped = new BusModelJpaDelSubDep3();
					mapped.set((IBusModelDelSubDep3)rec);
					return(mapped); }
				case IBusModelDelTopDep.CLASS_CODE: {
					BusModelJpaDelTopDep mapped = new BusModelJpaDelTopDep();
					mapped.set((IBusModelDelTopDep)rec);
					return(mapped); }
				case IBusModelIndex.CLASS_CODE: {
					BusModelJpaIndex mapped = new BusModelJpaIndex();
					mapped.set((IBusModelIndex)rec);
					return(mapped); }
				case IBusModelPopDep.CLASS_CODE: {
					BusModelJpaPopDep mapped = new BusModelJpaPopDep();
					mapped.set((IBusModelPopDep)rec);
					return(mapped); }
				case IBusModelPopSubDep1.CLASS_CODE: {
					BusModelJpaPopSubDep1 mapped = new BusModelJpaPopSubDep1();
					mapped.set((IBusModelPopSubDep1)rec);
					return(mapped); }
				case IBusModelPopSubDep2.CLASS_CODE: {
					BusModelJpaPopSubDep2 mapped = new BusModelJpaPopSubDep2();
					mapped.set((IBusModelPopSubDep2)rec);
					return(mapped); }
				case IBusModelPopSubDep3.CLASS_CODE: {
					BusModelJpaPopSubDep3 mapped = new BusModelJpaPopSubDep3();
					mapped.set((IBusModelPopSubDep3)rec);
					return(mapped); }
				case IBusModelPopTopDep.CLASS_CODE: {
					BusModelJpaPopTopDep mapped = new BusModelJpaPopTopDep();
					mapped.set((IBusModelPopTopDep)rec);
					return(mapped); }
				case IBusModelRelation.CLASS_CODE: {
					BusModelJpaRelation mapped = new BusModelJpaRelation();
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
        IBusModelScopeH hrec = new BusModelJpaScopeH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaScopeH ensureHRec(IBusModelScopeH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaScopeH) {
			return( (BusModelJpaScopeH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelScope.CLASS_CODE: {
					BusModelJpaScopeH mapped = new BusModelJpaScopeH();
					mapped.set(hrec);
					return( mapped ); }
				case IBusModelSchemaDef.CLASS_CODE: {
					BusModelJpaSchemaDefH mapped = new BusModelJpaSchemaDefH();
					mapped.set((IBusModelSchemaDefH)hrec);
					return(mapped); }
				case IBusModelSchemaRef.CLASS_CODE: {
					BusModelJpaSchemaRefH mapped = new BusModelJpaSchemaRefH();
					mapped.set((IBusModelSchemaRefH)hrec);
					return(mapped); }
				case IBusModelServerMethod.CLASS_CODE: {
					BusModelJpaServerMethodH mapped = new BusModelJpaServerMethodH();
					mapped.set((IBusModelServerMethodH)hrec);
					return(mapped); }
				case IBusModelServerObjFunc.CLASS_CODE: {
					BusModelJpaServerObjFuncH mapped = new BusModelJpaServerObjFuncH();
					mapped.set((IBusModelServerObjFuncH)hrec);
					return(mapped); }
				case IBusModelServerProc.CLASS_CODE: {
					BusModelJpaServerProcH mapped = new BusModelJpaServerProcH();
					mapped.set((IBusModelServerProcH)hrec);
					return(mapped); }
				case IBusModelServerListFunc.CLASS_CODE: {
					BusModelJpaServerListFuncH mapped = new BusModelJpaServerListFuncH();
					mapped.set((IBusModelServerListFuncH)hrec);
					return(mapped); }
				case IBusModelTable.CLASS_CODE: {
					BusModelJpaTableH mapped = new BusModelJpaTableH();
					mapped.set((IBusModelTableH)hrec);
					return(mapped); }
				case IBusModelClearDep.CLASS_CODE: {
					BusModelJpaClearDepH mapped = new BusModelJpaClearDepH();
					mapped.set((IBusModelClearDepH)hrec);
					return(mapped); }
				case IBusModelClearSubDep1.CLASS_CODE: {
					BusModelJpaClearSubDep1H mapped = new BusModelJpaClearSubDep1H();
					mapped.set((IBusModelClearSubDep1H)hrec);
					return(mapped); }
				case IBusModelClearSubDep2.CLASS_CODE: {
					BusModelJpaClearSubDep2H mapped = new BusModelJpaClearSubDep2H();
					mapped.set((IBusModelClearSubDep2H)hrec);
					return(mapped); }
				case IBusModelClearSubDep3.CLASS_CODE: {
					BusModelJpaClearSubDep3H mapped = new BusModelJpaClearSubDep3H();
					mapped.set((IBusModelClearSubDep3H)hrec);
					return(mapped); }
				case IBusModelClearTopDep.CLASS_CODE: {
					BusModelJpaClearTopDepH mapped = new BusModelJpaClearTopDepH();
					mapped.set((IBusModelClearTopDepH)hrec);
					return(mapped); }
				case IBusModelDelDep.CLASS_CODE: {
					BusModelJpaDelDepH mapped = new BusModelJpaDelDepH();
					mapped.set((IBusModelDelDepH)hrec);
					return(mapped); }
				case IBusModelDelSubDep1.CLASS_CODE: {
					BusModelJpaDelSubDep1H mapped = new BusModelJpaDelSubDep1H();
					mapped.set((IBusModelDelSubDep1H)hrec);
					return(mapped); }
				case IBusModelDelSubDep2.CLASS_CODE: {
					BusModelJpaDelSubDep2H mapped = new BusModelJpaDelSubDep2H();
					mapped.set((IBusModelDelSubDep2H)hrec);
					return(mapped); }
				case IBusModelDelSubDep3.CLASS_CODE: {
					BusModelJpaDelSubDep3H mapped = new BusModelJpaDelSubDep3H();
					mapped.set((IBusModelDelSubDep3H)hrec);
					return(mapped); }
				case IBusModelDelTopDep.CLASS_CODE: {
					BusModelJpaDelTopDepH mapped = new BusModelJpaDelTopDepH();
					mapped.set((IBusModelDelTopDepH)hrec);
					return(mapped); }
				case IBusModelIndex.CLASS_CODE: {
					BusModelJpaIndexH mapped = new BusModelJpaIndexH();
					mapped.set((IBusModelIndexH)hrec);
					return(mapped); }
				case IBusModelPopDep.CLASS_CODE: {
					BusModelJpaPopDepH mapped = new BusModelJpaPopDepH();
					mapped.set((IBusModelPopDepH)hrec);
					return(mapped); }
				case IBusModelPopSubDep1.CLASS_CODE: {
					BusModelJpaPopSubDep1H mapped = new BusModelJpaPopSubDep1H();
					mapped.set((IBusModelPopSubDep1H)hrec);
					return(mapped); }
				case IBusModelPopSubDep2.CLASS_CODE: {
					BusModelJpaPopSubDep2H mapped = new BusModelJpaPopSubDep2H();
					mapped.set((IBusModelPopSubDep2H)hrec);
					return(mapped); }
				case IBusModelPopSubDep3.CLASS_CODE: {
					BusModelJpaPopSubDep3H mapped = new BusModelJpaPopSubDep3H();
					mapped.set((IBusModelPopSubDep3H)hrec);
					return(mapped); }
				case IBusModelPopTopDep.CLASS_CODE: {
					BusModelJpaPopTopDepH mapped = new BusModelJpaPopTopDepH();
					mapped.set((IBusModelPopTopDepH)hrec);
					return(mapped); }
				case IBusModelRelation.CLASS_CODE: {
					BusModelJpaRelationH mapped = new BusModelJpaRelationH();
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
