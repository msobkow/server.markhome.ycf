
// Description: Java 25 Factory service implementation for Tweak JPA objects

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
 *	Java 25 Factory service implementation for Tweak JPA objects.
 */
public class BusModelJpaTweakFactoryService
    implements IBusModelTweakFactory
{
    public BusModelJpaTweakFactoryService() { }

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelTweakHPKey newHPKey() {
        IBusModelTweakHPKey hpkey = new BusModelJpaTweakHPKey();
        return( hpkey );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTweakHPKey ensureHPKey(IBusModelTweakHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof BusModelJpaTweakHPKey) {
			return( (BusModelJpaTweakHPKey)key );
		}
		else {
			BusModelJpaTweakHPKey mapped = new BusModelJpaTweakHPKey();
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
    public IBusModelTweakByUNameIdxKey newByUNameIdxKey() {
		IBusModelTweakByUNameIdxKey key = new BusModelJpaTweakByUNameIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTweakByUNameIdxKey ensureByUNameIdxKey(IBusModelTweakByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaTweakByUNameIdxKey) {
			return( (BusModelJpaTweakByUNameIdxKey)key );
		}
		else {
			BusModelJpaTweakByUNameIdxKey mapped = new BusModelJpaTweakByUNameIdxKey();
			mapped.setRequiredScopeId( key.getRequiredScopeId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelTweakByValTentIdxKey newByValTentIdxKey() {
		IBusModelTweakByValTentIdxKey key = new BusModelJpaTweakByValTentIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTweakByValTentIdxKey ensureByValTentIdxKey(IBusModelTweakByValTentIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaTweakByValTentIdxKey) {
			return( (BusModelJpaTweakByValTentIdxKey)key );
		}
		else {
			BusModelJpaTweakByValTentIdxKey mapped = new BusModelJpaTweakByValTentIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelTweakByScopeIdxKey newByScopeIdxKey() {
		IBusModelTweakByScopeIdxKey key = new BusModelJpaTweakByScopeIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTweakByScopeIdxKey ensureByScopeIdxKey(IBusModelTweakByScopeIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaTweakByScopeIdxKey) {
			return( (BusModelJpaTweakByScopeIdxKey)key );
		}
		else {
			BusModelJpaTweakByScopeIdxKey mapped = new BusModelJpaTweakByScopeIdxKey();
			mapped.setRequiredScopeId( key.getRequiredScopeId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelTweakByDefSchemaIdxKey newByDefSchemaIdxKey() {
		IBusModelTweakByDefSchemaIdxKey key = new BusModelJpaTweakByDefSchemaIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTweakByDefSchemaIdxKey ensureByDefSchemaIdxKey(IBusModelTweakByDefSchemaIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaTweakByDefSchemaIdxKey) {
			return( (BusModelJpaTweakByDefSchemaIdxKey)key );
		}
		else {
			BusModelJpaTweakByDefSchemaIdxKey mapped = new BusModelJpaTweakByDefSchemaIdxKey();
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelTweakByUDefIdxKey newByUDefIdxKey() {
		IBusModelTweakByUDefIdxKey key = new BusModelJpaTweakByUDefIdxKey();
	return( key );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTweakByUDefIdxKey ensureByUDefIdxKey(IBusModelTweakByUDefIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof BusModelJpaTweakByUDefIdxKey) {
			return( (BusModelJpaTweakByUDefIdxKey)key );
		}
		else {
			BusModelJpaTweakByUDefIdxKey mapped = new BusModelJpaTweakByUDefIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			mapped.setRequiredScopeId( key.getRequiredScopeId() );
			mapped.setOptionalDefSchemaTenantId( key.getOptionalDefSchemaTenantId() );
			mapped.setOptionalDefSchemaId( key.getOptionalDefSchemaId() );
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

    @Override
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
    public IBusModelTweak newRec() {
        IBusModelTweak rec = new BusModelJpaTweak();
        return( rec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTweak ensureRec(IBusModelTweak rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof BusModelJpaTweak) {
			return( (BusModelJpaTweak)rec );
		}
		else {
			switch(rec.getClassCode()) {
				case IBusModelTweak.CLASS_CODE: {
					BusModelJpaTweak mapped = new BusModelJpaTweak();
					mapped.set(rec);
					return( mapped ); }
				case IBusModelTableTweak.CLASS_CODE: {
					BusModelJpaTableTweak mapped = new BusModelJpaTableTweak();
					mapped.set((IBusModelTableTweak)rec);
					return(mapped); }
				case IBusModelSchemaTweak.CLASS_CODE: {
					BusModelJpaSchemaTweak mapped = new BusModelJpaSchemaTweak();
					mapped.set((IBusModelSchemaTweak)rec);
					return(mapped); }
				case IBusModelIndexTweak.CLASS_CODE: {
					BusModelJpaIndexTweak mapped = new BusModelJpaIndexTweak();
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
        IBusModelTweakH hrec = new BusModelJpaTweakH();
        return( hrec );
    }

	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTweakH ensureHRec(IBusModelTweakH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof BusModelJpaTweakH) {
			return( (BusModelJpaTweakH)hrec );
		}
		else {
			switch(hrec.getClassCode()) {
				case IBusModelTweak.CLASS_CODE: {
					BusModelJpaTweakH mapped = new BusModelJpaTweakH();
					mapped.set(hrec);
					return( mapped ); }
				case IBusModelTableTweak.CLASS_CODE: {
					BusModelJpaTableTweakH mapped = new BusModelJpaTableTweakH();
					mapped.set((IBusModelTableTweakH)hrec);
					return(mapped); }
				case IBusModelSchemaTweak.CLASS_CODE: {
					BusModelJpaSchemaTweakH mapped = new BusModelJpaSchemaTweakH();
					mapped.set((IBusModelSchemaTweakH)hrec);
					return(mapped); }
				case IBusModelIndexTweak.CLASS_CODE: {
					BusModelJpaIndexTweakH mapped = new BusModelJpaIndexTweakH();
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
