// Description: Java 25 Spring JPA Service for DelSubDep1

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
 *	Service for the BusModelDelSubDep1 entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModelDelSubDep1Repository to access them.
 */
@Service("busmodel31JpaDelSubDep1Service")
public class BusModelJpaDelSubDep1Service {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaDelSubDep1Repository busmodel31DelSubDep1Repository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of BusModelJpaDelSubDep1, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDelSubDep1 create(BusModelJpaDelSubDep1 data) {
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
		if (data.getRequiredContainerDelTopDep() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerDelTopDep",
				"data.requiredContainerDelTopDep",
				"DelTopDep",
				"DelTopDep",
				null);
		}
		if(data.getRequiredDelTopDepId() == null || data.getRequiredDelTopDepId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredDelTopDepId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		try {
			if(data.getPKey() != null && !data.getPKey().isNull() && busmodel31DelSubDep1Repository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (BusModelJpaDelSubDep1)(busmodel31DelSubDep1Repository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
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
			return busmodel31DelSubDep1Repository.save(data);
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
	public BusModelJpaDelSubDep1 update(BusModelJpaDelSubDep1 data) {
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
		if (data.getRequiredContainerDelTopDep() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerDelTopDep",
				"data.requiredContainerDelTopDep",
				"DelTopDep",
				"DelTopDep",
				null);
		}
		if(data.getRequiredDelTopDepId() == null || data.getRequiredDelTopDepId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredDelTopDepId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		// Ensure the entity exists and that the revision matches
		BusModelJpaDelSubDep1 existing = busmodel31DelSubDep1Repository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of BusModelScope to existing object
		existing.setRequiredOwnerTenant(data.getRequiredTenantId());
		// Apply data columns of BusModelScope to existing object
		existing.setRequiredTenantId(data.getRequiredTenantId());
		// Apply superior data relationships of BusModelDelDep to existing object
		existing.setRequiredLookupRelation(data.getRequiredLookupRelation());
		existing.setOptionalLookupDefSchema(data.getOptionalLookupDefSchema());
		// Apply data columns of BusModelDelDep to existing object
		existing.setOptionalDefSchemaId(data.getOptionalDefSchemaId());
		existing.setRequiredRelationId(data.getRequiredRelationId());
		// Apply superior data relationships of BusModelDelSubDep1 to existing object
		existing.setRequiredContainerDelTopDep(data.getRequiredContainerDelTopDep());
		// Apply data columns of BusModelDelSubDep1 to existing object
		existing.setRequiredDelTopDepId(data.getRequiredDelTopDepId());
		existing.setRequiredName(data.getRequiredName());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return busmodel31DelSubDep1Repository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDelSubDep1 find(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31DelSubDep1Repository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDelSubDep1> findAll() {
		return( busmodel31DelSubDep1Repository.findAll() );
	}

	// BusModelScope specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelScopeByTenantIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;BusModelJpaDelSubDep1&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDelSubDep1> findByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31DelSubDep1Repository.findByTenantIdx(requiredTenantId));
	}

	/**
	 *	IBusModelScopeByTenantIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelScopeByTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDelSubDep1> findByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( busmodel31DelSubDep1Repository.findByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelDelDep specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelDelDepByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaDelSubDep1&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDelSubDep1> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31DelSubDep1Repository.findByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelDelDepByDefSchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelDelDepByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDelSubDep1> findByDefSchemaIdx(IBusModelDelDepByDefSchemaIdxKey key) {
		return( busmodel31DelSubDep1Repository.findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelDelDepByDelDepIdxKey as arguments.
	 *
	 *		@param requiredRelationId
	 *
	 *		@return List&lt;BusModelJpaDelSubDep1&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDelSubDep1> findByDelDepIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId) {
		return( busmodel31DelSubDep1Repository.findByDelDepIdx(requiredRelationId));
	}

	/**
	 *	IBusModelDelDepByDelDepIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelDelDepByDelDepIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDelSubDep1> findByDelDepIdx(IBusModelDelDepByDelDepIdxKey key) {
		return( busmodel31DelSubDep1Repository.findByDelDepIdx(key.getRequiredRelationId()));
	}

	// BusModelDelSubDep1 specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelDelSubDep1ByDelTopDepIdxKey as arguments.
	 *
	 *		@param requiredDelTopDepId
	 *
	 *		@return List&lt;BusModelJpaDelSubDep1&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDelSubDep1> findByDelTopDepIdx(@Param("delTopDepId") IYCFKeyHash256 requiredDelTopDepId) {
		return( busmodel31DelSubDep1Repository.findByDelTopDepIdx(requiredDelTopDepId));
	}

	/**
	 *	IBusModelDelSubDep1ByDelTopDepIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelDelSubDep1ByDelTopDepIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDelSubDep1> findByDelTopDepIdx(IBusModelDelSubDep1ByDelTopDepIdxKey key) {
		return( busmodel31DelSubDep1Repository.findByDelTopDepIdx(key.getRequiredDelTopDepId()));
	}

	/**
	 *	Find an entity using the columns of the IBusModelDelSubDep1ByUNameIdxKey as arguments.
	 *
	 *		@param requiredDelTopDepId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDelSubDep1 findByUNameIdx(@Param("delTopDepId") IYCFKeyHash256 requiredDelTopDepId,
		@Param("name") String requiredName) {
		return( busmodel31DelSubDep1Repository.findByUNameIdx(requiredDelTopDepId,
			requiredName));
	}

	/**
	 *	IBusModelDelSubDep1ByUNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelDelSubDep1ByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDelSubDep1 findByUNameIdx(IBusModelDelSubDep1ByUNameIdxKey key) {
		return( busmodel31DelSubDep1Repository.findByUNameIdx(key.getRequiredDelTopDepId(), key.getRequiredName()));
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
	public BusModelJpaDelSubDep1 lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31DelSubDep1Repository.lockByIdIdx(requiredId));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDelSubDep1> lockByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31DelSubDep1Repository.lockByTenantIdx(requiredTenantId));
	}

	/**
	 *	IBusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDelSubDep1> lockByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( busmodel31DelSubDep1Repository.lockByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelDelDep specified lock-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDelSubDep1> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31DelSubDep1Repository.lockByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelDelDepByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDelSubDep1> lockByDefSchemaIdx(IBusModelDelDepByDefSchemaIdxKey key) {
		return( busmodel31DelSubDep1Repository.lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDelSubDep1> lockByDelDepIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId) {
		return( busmodel31DelSubDep1Repository.lockByDelDepIdx(requiredRelationId));
	}

	/**
	 *	IBusModelDelDepByDelDepIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDelSubDep1> lockByDelDepIdx(IBusModelDelDepByDelDepIdxKey key) {
		return( busmodel31DelSubDep1Repository.lockByDelDepIdx(key.getRequiredRelationId()));
	}

	// BusModelDelSubDep1 specified lock-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredDelTopDepId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDelSubDep1> lockByDelTopDepIdx(@Param("delTopDepId") IYCFKeyHash256 requiredDelTopDepId) {
		return( busmodel31DelSubDep1Repository.lockByDelTopDepIdx(requiredDelTopDepId));
	}

	/**
	 *	IBusModelDelSubDep1ByDelTopDepIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDelSubDep1> lockByDelTopDepIdx(IBusModelDelSubDep1ByDelTopDepIdxKey key) {
		return( busmodel31DelSubDep1Repository.lockByDelTopDepIdx(key.getRequiredDelTopDepId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredDelTopDepId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDelSubDep1 lockByUNameIdx(@Param("delTopDepId") IYCFKeyHash256 requiredDelTopDepId,
		@Param("name") String requiredName) {
		return( busmodel31DelSubDep1Repository.lockByUNameIdx(requiredDelTopDepId,
			requiredName));
	}

	/**
	 *	IBusModelDelSubDep1ByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDelSubDep1 lockByUNameIdx(IBusModelDelSubDep1ByUNameIdxKey key) {
		return( busmodel31DelSubDep1Repository.lockByUNameIdx(key.getRequiredDelTopDepId(), key.getRequiredName()));
	}

	// BusModelScope specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		busmodel31DelSubDep1Repository.deleteByIdIdx(requiredId);
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		busmodel31DelSubDep1Repository.deleteByTenantIdx(requiredTenantId);
	}

	/**
	 *	IBusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelScopeByTenantIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		busmodel31DelSubDep1Repository.deleteByTenantIdx(key.getRequiredTenantId());
	}

	// BusModelDelDep specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		busmodel31DelSubDep1Repository.deleteByDefSchemaIdx(optionalDefSchemaId);
	}

	/**
	 *	IBusModelDelDepByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelDelDepByDefSchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(IBusModelDelDepByDefSchemaIdxKey key) {
		busmodel31DelSubDep1Repository.deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDelDepIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId) {
		busmodel31DelSubDep1Repository.deleteByDelDepIdx(requiredRelationId);
	}

	/**
	 *	IBusModelDelDepByDelDepIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelDelDepByDelDepIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDelDepIdx(IBusModelDelDepByDelDepIdxKey key) {
		busmodel31DelSubDep1Repository.deleteByDelDepIdx(key.getRequiredRelationId());
	}

	// BusModelDelSubDep1 specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredDelTopDepId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDelTopDepIdx(@Param("delTopDepId") IYCFKeyHash256 requiredDelTopDepId) {
		busmodel31DelSubDep1Repository.deleteByDelTopDepIdx(requiredDelTopDepId);
	}

	/**
	 *	IBusModelDelSubDep1ByDelTopDepIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelDelSubDep1ByDelTopDepIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDelTopDepIdx(IBusModelDelSubDep1ByDelTopDepIdxKey key) {
		busmodel31DelSubDep1Repository.deleteByDelTopDepIdx(key.getRequiredDelTopDepId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredDelTopDepId
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(@Param("delTopDepId") IYCFKeyHash256 requiredDelTopDepId,
		@Param("name") String requiredName) {
		busmodel31DelSubDep1Repository.deleteByUNameIdx(requiredDelTopDepId,
			requiredName);
	}

	/**
	 *	IBusModelDelSubDep1ByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelDelSubDep1ByUNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(IBusModelDelSubDep1ByUNameIdxKey key) {
		busmodel31DelSubDep1Repository.deleteByUNameIdx(key.getRequiredDelTopDepId(), key.getRequiredName());
	}

}
