// Description: Java 25 Spring JPA Service for PopSubDep2

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

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import jakarta.persistence.*;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;

/**
 *	Service for the BusModelPopSubDep2 entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModelPopSubDep2Repository to access them.
 */
@Service("busmodel31JpaPopSubDep2Service")
public class BusModelJpaPopSubDep2Service {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaPopSubDep2Repository busmodel31PopSubDep2Repository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of BusModelJpaPopSubDep2, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopSubDep2 create(BusModelJpaPopSubDep2 data) {
		final String S_ProcName = "create";
		if (data == null) {
			return( null );
		}
		IYCFKeyHash256 originalRequiredId = data.getRequiredId();
		boolean generatedRequiredId = false;
		if (data.getRequiredOwnerTenant() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Owner",
				"Owner",
				"data.requiredOwnerTenant",
				"data.requiredOwnerTenant",
				"Tenant",
				"Tenant",
				null);
		}
		if(data.getRequiredTenantId() == null || data.getRequiredTenantId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredTenantId");
		}
		if (data.getRequiredLookupRelation() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupRelation",
				"data.requiredLookupRelation",
				"Relation",
				"Relation",
				null);
		}
		if(data.getRequiredRelationId() == null || data.getRequiredRelationId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredRelationId");
		}
		if (data.getRequiredContainerPopSubDep1() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerPopSubDep1",
				"data.requiredContainerPopSubDep1",
				"PopSubDep1",
				"PopSubDep1",
				null);
		}
		if(data.getRequiredPopSubDep1Id() == null || data.getRequiredPopSubDep1Id().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredPopSubDep1Id");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		try {
			if(data.getPKey() != null && !data.getPKey().isNull() && busmodel31PopSubDep2Repository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (BusModelJpaPopSubDep2)(busmodel31PopSubDep2Repository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
			}
			if (data.getRequiredRevision() <= 0) {
				data.setRequiredRevision(1);
			}
			if (data.getRequiredId() == null || data.getRequiredId().isNull()) {
				data.setRequiredId(new YCFDbKeyHash256(0));
				generatedRequiredId = true;
			}
			LocalDateTime now = LocalDateTime.now();
			data.setCreatedAt(now);
			data.setUpdatedAt(now);
			return busmodel31PopSubDep2Repository.save(data);
		}
		catch(Exception ex) {
				if(generatedRequiredId) {
					data.setRequiredId(originalRequiredId);
				}
			throw new YCFDbException(getClass(),
				S_ProcName,
				ex);
		}
	}

	/**
	 *	Update an existing entity.
	 *
	 *		@param	data	The entity to be updated.
	 *
	 *		@return The updated entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopSubDep2 update(BusModelJpaPopSubDep2 data) {
		final String S_ProcName = "update";
		if (data == null) {
			return( null );
		}
		if (data.getPKey() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.getPKey()");
		}
		if (data.getRequiredOwnerTenant() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Owner",
				"Owner",
				"data.requiredOwnerTenant",
				"data.requiredOwnerTenant",
				"Tenant",
				"Tenant",
				null);
		}
		if(data.getRequiredTenantId() == null || data.getRequiredTenantId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredTenantId");
		}
		if (data.getRequiredLookupRelation() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupRelation",
				"data.requiredLookupRelation",
				"Relation",
				"Relation",
				null);
		}
		if(data.getRequiredRelationId() == null || data.getRequiredRelationId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredRelationId");
		}
		if (data.getRequiredContainerPopSubDep1() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerPopSubDep1",
				"data.requiredContainerPopSubDep1",
				"PopSubDep1",
				"PopSubDep1",
				null);
		}
		if(data.getRequiredPopSubDep1Id() == null || data.getRequiredPopSubDep1Id().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredPopSubDep1Id");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		// Ensure the entity exists and that the revision matches
		BusModelJpaPopSubDep2 existing = busmodel31PopSubDep2Repository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of BusModelScope to existing object
		existing.setRequiredOwnerTenant(data.getRequiredTenantId());
		// Apply data columns of BusModelScope to existing object
		existing.setRequiredTenantId(data.getRequiredTenantId());
		// Apply superior data relationships of BusModelPopDep to existing object
		existing.setRequiredLookupRelation(data.getRequiredLookupRelation());
		existing.setOptionalLookupDefSchema(data.getOptionalLookupDefSchema());
		// Apply data columns of BusModelPopDep to existing object
		existing.setOptionalDefSchemaId(data.getOptionalDefSchemaId());
		existing.setRequiredRelationId(data.getRequiredRelationId());
		// Apply superior data relationships of BusModelPopSubDep2 to existing object
		existing.setRequiredContainerPopSubDep1(data.getRequiredContainerPopSubDep1());
		// Apply data columns of BusModelPopSubDep2 to existing object
		existing.setRequiredPopSubDep1Id(data.getRequiredPopSubDep1Id());
		existing.setRequiredName(data.getRequiredName());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return busmodel31PopSubDep2Repository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopSubDep2 find(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31PopSubDep2Repository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaPopSubDep2> findAll() {
		return( busmodel31PopSubDep2Repository.findAll() );
	}

	// BusModelScope specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelScopeByTenantIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;BusModelJpaPopSubDep2&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaPopSubDep2> findByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31PopSubDep2Repository.findByTenantIdx(requiredTenantId));
	}

	/**
	 *	IBusModelScopeByTenantIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelScopeByTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaPopSubDep2> findByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( busmodel31PopSubDep2Repository.findByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelPopDep specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelPopDepByRelationIdxKey as arguments.
	 *
	 *		@param requiredRelationId
	 *
	 *		@return List&lt;BusModelJpaPopSubDep2&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaPopSubDep2> findByRelationIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId) {
		return( busmodel31PopSubDep2Repository.findByRelationIdx(requiredRelationId));
	}

	/**
	 *	IBusModelPopDepByRelationIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelPopDepByRelationIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaPopSubDep2> findByRelationIdx(IBusModelPopDepByRelationIdxKey key) {
		return( busmodel31PopSubDep2Repository.findByRelationIdx(key.getRequiredRelationId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelPopDepByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaPopSubDep2&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaPopSubDep2> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31PopSubDep2Repository.findByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelPopDepByDefSchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelPopDepByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaPopSubDep2> findByDefSchemaIdx(IBusModelPopDepByDefSchemaIdxKey key) {
		return( busmodel31PopSubDep2Repository.findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	// BusModelPopSubDep2 specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelPopSubDep2ByPopSubDep1IdxKey as arguments.
	 *
	 *		@param requiredPopSubDep1Id
	 *
	 *		@return List&lt;BusModelJpaPopSubDep2&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaPopSubDep2> findByPopSubDep1Idx(@Param("popSubDep1Id") IYCFKeyHash256 requiredPopSubDep1Id) {
		return( busmodel31PopSubDep2Repository.findByPopSubDep1Idx(requiredPopSubDep1Id));
	}

	/**
	 *	IBusModelPopSubDep2ByPopSubDep1IdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelPopSubDep2ByPopSubDep1IdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaPopSubDep2> findByPopSubDep1Idx(IBusModelPopSubDep2ByPopSubDep1IdxKey key) {
		return( busmodel31PopSubDep2Repository.findByPopSubDep1Idx(key.getRequiredPopSubDep1Id()));
	}

	/**
	 *	Find an entity using the columns of the IBusModelPopSubDep2ByUNameIdxKey as arguments.
	 *
	 *		@param requiredPopSubDep1Id
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopSubDep2 findByUNameIdx(@Param("popSubDep1Id") IYCFKeyHash256 requiredPopSubDep1Id,
		@Param("name") String requiredName) {
		return( busmodel31PopSubDep2Repository.findByUNameIdx(requiredPopSubDep1Id,
			requiredName));
	}

	/**
	 *	IBusModelPopSubDep2ByUNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelPopSubDep2ByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopSubDep2 findByUNameIdx(IBusModelPopSubDep2ByUNameIdxKey key) {
		return( busmodel31PopSubDep2Repository.findByUNameIdx(key.getRequiredPopSubDep1Id(), key.getRequiredName()));
	}

	// BusModelScope specified lock-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopSubDep2 lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31PopSubDep2Repository.lockByIdIdx(requiredId));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaPopSubDep2> lockByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31PopSubDep2Repository.lockByTenantIdx(requiredTenantId));
	}

	/**
	 *	IBusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaPopSubDep2> lockByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( busmodel31PopSubDep2Repository.lockByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelPopDep specified lock-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaPopSubDep2> lockByRelationIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId) {
		return( busmodel31PopSubDep2Repository.lockByRelationIdx(requiredRelationId));
	}

	/**
	 *	IBusModelPopDepByRelationIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaPopSubDep2> lockByRelationIdx(IBusModelPopDepByRelationIdxKey key) {
		return( busmodel31PopSubDep2Repository.lockByRelationIdx(key.getRequiredRelationId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaPopSubDep2> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31PopSubDep2Repository.lockByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelPopDepByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaPopSubDep2> lockByDefSchemaIdx(IBusModelPopDepByDefSchemaIdxKey key) {
		return( busmodel31PopSubDep2Repository.lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	// BusModelPopSubDep2 specified lock-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredPopSubDep1Id
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaPopSubDep2> lockByPopSubDep1Idx(@Param("popSubDep1Id") IYCFKeyHash256 requiredPopSubDep1Id) {
		return( busmodel31PopSubDep2Repository.lockByPopSubDep1Idx(requiredPopSubDep1Id));
	}

	/**
	 *	IBusModelPopSubDep2ByPopSubDep1IdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaPopSubDep2> lockByPopSubDep1Idx(IBusModelPopSubDep2ByPopSubDep1IdxKey key) {
		return( busmodel31PopSubDep2Repository.lockByPopSubDep1Idx(key.getRequiredPopSubDep1Id()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredPopSubDep1Id
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopSubDep2 lockByUNameIdx(@Param("popSubDep1Id") IYCFKeyHash256 requiredPopSubDep1Id,
		@Param("name") String requiredName) {
		return( busmodel31PopSubDep2Repository.lockByUNameIdx(requiredPopSubDep1Id,
			requiredName));
	}

	/**
	 *	IBusModelPopSubDep2ByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaPopSubDep2 lockByUNameIdx(IBusModelPopSubDep2ByUNameIdxKey key) {
		return( busmodel31PopSubDep2Repository.lockByUNameIdx(key.getRequiredPopSubDep1Id(), key.getRequiredName()));
	}

	// BusModelScope specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		busmodel31PopSubDep2Repository.deleteByIdIdx(requiredId);
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		busmodel31PopSubDep2Repository.deleteByTenantIdx(requiredTenantId);
	}

	/**
	 *	IBusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelScopeByTenantIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		busmodel31PopSubDep2Repository.deleteByTenantIdx(key.getRequiredTenantId());
	}

	// BusModelPopDep specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRelationIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId) {
		busmodel31PopSubDep2Repository.deleteByRelationIdx(requiredRelationId);
	}

	/**
	 *	IBusModelPopDepByRelationIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelPopDepByRelationIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRelationIdx(IBusModelPopDepByRelationIdxKey key) {
		busmodel31PopSubDep2Repository.deleteByRelationIdx(key.getRequiredRelationId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		busmodel31PopSubDep2Repository.deleteByDefSchemaIdx(optionalDefSchemaId);
	}

	/**
	 *	IBusModelPopDepByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelPopDepByDefSchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(IBusModelPopDepByDefSchemaIdxKey key) {
		busmodel31PopSubDep2Repository.deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	// BusModelPopSubDep2 specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredPopSubDep1Id
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPopSubDep1Idx(@Param("popSubDep1Id") IYCFKeyHash256 requiredPopSubDep1Id) {
		busmodel31PopSubDep2Repository.deleteByPopSubDep1Idx(requiredPopSubDep1Id);
	}

	/**
	 *	IBusModelPopSubDep2ByPopSubDep1IdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelPopSubDep2ByPopSubDep1IdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPopSubDep1Idx(IBusModelPopSubDep2ByPopSubDep1IdxKey key) {
		busmodel31PopSubDep2Repository.deleteByPopSubDep1Idx(key.getRequiredPopSubDep1Id());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredPopSubDep1Id
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(@Param("popSubDep1Id") IYCFKeyHash256 requiredPopSubDep1Id,
		@Param("name") String requiredName) {
		busmodel31PopSubDep2Repository.deleteByUNameIdx(requiredPopSubDep1Id,
			requiredName);
	}

	/**
	 *	IBusModelPopSubDep2ByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelPopSubDep2ByUNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(IBusModelPopSubDep2ByUNameIdxKey key) {
		busmodel31PopSubDep2Repository.deleteByUNameIdx(key.getRequiredPopSubDep1Id(), key.getRequiredName());
	}

}
