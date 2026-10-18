// Description: Java 25 Spring JPA Service for SchemaRef

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
 *	Service for the BusModelSchemaRef entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModelSchemaRefRepository to access them.
 */
@Service("busmodel31JpaSchemaRefService")
public class BusModelJpaSchemaRefService {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaSchemaRefRepository busmodel31SchemaRefRepository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of BusModelJpaSchemaRef, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRef create(BusModelJpaSchemaRef data) {
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
		if (data.getRequiredContainerSchema() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerSchema",
				"data.requiredContainerSchema",
				"SchemaDef",
				"SchemaDef",
				null);
		}
		if(data.getRequiredSchemaId() == null || data.getRequiredSchemaId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredSchemaId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredRefModelName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredRefModelName");
		}
		if(data.getRequiredIncludeRoot() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredIncludeRoot");
		}
		try {
			if(data.getPKey() != null && !data.getPKey().isNull() && busmodel31SchemaRefRepository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (BusModelJpaSchemaRef)(busmodel31SchemaRefRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
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
			return busmodel31SchemaRefRepository.save(data);
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
	public BusModelJpaSchemaRef update(BusModelJpaSchemaRef data) {
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
		if (data.getRequiredContainerSchema() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerSchema",
				"data.requiredContainerSchema",
				"SchemaDef",
				"SchemaDef",
				null);
		}
		if(data.getRequiredSchemaId() == null || data.getRequiredSchemaId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredSchemaId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredRefModelName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredRefModelName");
		}
		if(data.getRequiredIncludeRoot() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredIncludeRoot");
		}
		// Ensure the entity exists and that the revision matches
		BusModelJpaSchemaRef existing = busmodel31SchemaRefRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of BusModelScope to existing object
		existing.setRequiredOwnerTenant(data.getRequiredTenantId());
		// Apply data columns of BusModelScope to existing object
		existing.setRequiredTenantId(data.getRequiredTenantId());
		// Apply superior data relationships of BusModelSchemaRef to existing object
		existing.setRequiredContainerSchema(data.getRequiredContainerSchema());
		existing.setOptionalLookupRefSchema(data.getOptionalLookupRefSchema());
		existing.setOptionalLookupPrev(data.getOptionalLookupPrev());
		existing.setOptionalLookupNext(data.getOptionalLookupNext());
		// Apply data columns of BusModelSchemaRef to existing object
		existing.setRequiredSchemaId(data.getRequiredSchemaId());
		existing.setRequiredName(data.getRequiredName());
		existing.setRequiredRefModelName(data.getRequiredRefModelName());
		existing.setRequiredIncludeRoot(data.getRequiredIncludeRoot());
		existing.setOptionalRefSchemaId(data.getOptionalRefSchemaId());
		existing.setOptionalPrevId(data.getOptionalPrevId());
		existing.setOptionalNextId(data.getOptionalNextId());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return busmodel31SchemaRefRepository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRef find(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31SchemaRefRepository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> findAll() {
		return( busmodel31SchemaRefRepository.findAll() );
	}

	// BusModelScope specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelScopeByTenantIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;BusModelJpaSchemaRef&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> findByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31SchemaRefRepository.findByTenantIdx(requiredTenantId));
	}

	/**
	 *	IBusModelScopeByTenantIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelScopeByTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> findByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( busmodel31SchemaRefRepository.findByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelSchemaRef specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelSchemaRefBySchemaIdxKey as arguments.
	 *
	 *		@param requiredSchemaId
	 *
	 *		@return List&lt;BusModelJpaSchemaRef&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> findBySchemaIdx(@Param("schemaId") IYCFKeyHash256 requiredSchemaId) {
		return( busmodel31SchemaRefRepository.findBySchemaIdx(requiredSchemaId));
	}

	/**
	 *	IBusModelSchemaRefBySchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaRefBySchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> findBySchemaIdx(IBusModelSchemaRefBySchemaIdxKey key) {
		return( busmodel31SchemaRefRepository.findBySchemaIdx(key.getRequiredSchemaId()));
	}

	/**
	 *	Find an entity using the columns of the IBusModelSchemaRefByUNameIdxKey as arguments.
	 *
	 *		@param requiredSchemaId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRef findByUNameIdx(@Param("schemaId") IYCFKeyHash256 requiredSchemaId,
		@Param("name") String requiredName) {
		return( busmodel31SchemaRefRepository.findByUNameIdx(requiredSchemaId,
			requiredName));
	}

	/**
	 *	IBusModelSchemaRefByUNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaRefByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRef findByUNameIdx(IBusModelSchemaRefByUNameIdxKey key) {
		return( busmodel31SchemaRefRepository.findByUNameIdx(key.getRequiredSchemaId(), key.getRequiredName()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelSchemaRefByRefSchemaIdxKey as arguments.
	 *
	 *		@param optionalRefSchemaId
	 *
	 *		@return List&lt;BusModelJpaSchemaRef&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> findByRefSchemaIdx(@Param("refSchemaId") IYCFKeyHash256 optionalRefSchemaId) {
		return( busmodel31SchemaRefRepository.findByRefSchemaIdx(optionalRefSchemaId));
	}

	/**
	 *	IBusModelSchemaRefByRefSchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaRefByRefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> findByRefSchemaIdx(IBusModelSchemaRefByRefSchemaIdxKey key) {
		return( busmodel31SchemaRefRepository.findByRefSchemaIdx(key.getOptionalRefSchemaId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelSchemaRefByPrevIdxKey as arguments.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaSchemaRef&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> findByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31SchemaRefRepository.findByPrevIdx(optionalPrevId));
	}

	/**
	 *	IBusModelSchemaRefByPrevIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaRefByPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> findByPrevIdx(IBusModelSchemaRefByPrevIdxKey key) {
		return( busmodel31SchemaRefRepository.findByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelSchemaRefByNextIdxKey as arguments.
	 *
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaSchemaRef&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> findByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31SchemaRefRepository.findByNextIdx(optionalNextId));
	}

	/**
	 *	IBusModelSchemaRefByNextIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaRefByNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> findByNextIdx(IBusModelSchemaRefByNextIdxKey key) {
		return( busmodel31SchemaRefRepository.findByNextIdx(key.getOptionalNextId()));
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
	public BusModelJpaSchemaRef lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31SchemaRefRepository.lockByIdIdx(requiredId));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> lockByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31SchemaRefRepository.lockByTenantIdx(requiredTenantId));
	}

	/**
	 *	IBusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> lockByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( busmodel31SchemaRefRepository.lockByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelSchemaRef specified lock-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> lockBySchemaIdx(@Param("schemaId") IYCFKeyHash256 requiredSchemaId) {
		return( busmodel31SchemaRefRepository.lockBySchemaIdx(requiredSchemaId));
	}

	/**
	 *	IBusModelSchemaRefBySchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> lockBySchemaIdx(IBusModelSchemaRefBySchemaIdxKey key) {
		return( busmodel31SchemaRefRepository.lockBySchemaIdx(key.getRequiredSchemaId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRef lockByUNameIdx(@Param("schemaId") IYCFKeyHash256 requiredSchemaId,
		@Param("name") String requiredName) {
		return( busmodel31SchemaRefRepository.lockByUNameIdx(requiredSchemaId,
			requiredName));
	}

	/**
	 *	IBusModelSchemaRefByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRef lockByUNameIdx(IBusModelSchemaRefByUNameIdxKey key) {
		return( busmodel31SchemaRefRepository.lockByUNameIdx(key.getRequiredSchemaId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalRefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> lockByRefSchemaIdx(@Param("refSchemaId") IYCFKeyHash256 optionalRefSchemaId) {
		return( busmodel31SchemaRefRepository.lockByRefSchemaIdx(optionalRefSchemaId));
	}

	/**
	 *	IBusModelSchemaRefByRefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> lockByRefSchemaIdx(IBusModelSchemaRefByRefSchemaIdxKey key) {
		return( busmodel31SchemaRefRepository.lockByRefSchemaIdx(key.getOptionalRefSchemaId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> lockByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31SchemaRefRepository.lockByPrevIdx(optionalPrevId));
	}

	/**
	 *	IBusModelSchemaRefByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> lockByPrevIdx(IBusModelSchemaRefByPrevIdxKey key) {
		return( busmodel31SchemaRefRepository.lockByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> lockByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31SchemaRefRepository.lockByNextIdx(optionalNextId));
	}

	/**
	 *	IBusModelSchemaRefByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRef> lockByNextIdx(IBusModelSchemaRefByNextIdxKey key) {
		return( busmodel31SchemaRefRepository.lockByNextIdx(key.getOptionalNextId()));
	}

	// BusModelScope specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		busmodel31SchemaRefRepository.deleteByIdIdx(requiredId);
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		busmodel31SchemaRefRepository.deleteByTenantIdx(requiredTenantId);
	}

	/**
	 *	IBusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelScopeByTenantIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		busmodel31SchemaRefRepository.deleteByTenantIdx(key.getRequiredTenantId());
	}

	// BusModelSchemaRef specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteBySchemaIdx(@Param("schemaId") IYCFKeyHash256 requiredSchemaId) {
		busmodel31SchemaRefRepository.deleteBySchemaIdx(requiredSchemaId);
	}

	/**
	 *	IBusModelSchemaRefBySchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaRefBySchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteBySchemaIdx(IBusModelSchemaRefBySchemaIdxKey key) {
		busmodel31SchemaRefRepository.deleteBySchemaIdx(key.getRequiredSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaId
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(@Param("schemaId") IYCFKeyHash256 requiredSchemaId,
		@Param("name") String requiredName) {
		busmodel31SchemaRefRepository.deleteByUNameIdx(requiredSchemaId,
			requiredName);
	}

	/**
	 *	IBusModelSchemaRefByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaRefByUNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(IBusModelSchemaRefByUNameIdxKey key) {
		busmodel31SchemaRefRepository.deleteByUNameIdx(key.getRequiredSchemaId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalRefSchemaId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRefSchemaIdx(@Param("refSchemaId") IYCFKeyHash256 optionalRefSchemaId) {
		busmodel31SchemaRefRepository.deleteByRefSchemaIdx(optionalRefSchemaId);
	}

	/**
	 *	IBusModelSchemaRefByRefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaRefByRefSchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRefSchemaIdx(IBusModelSchemaRefByRefSchemaIdxKey key) {
		busmodel31SchemaRefRepository.deleteByRefSchemaIdx(key.getOptionalRefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		busmodel31SchemaRefRepository.deleteByPrevIdx(optionalPrevId);
	}

	/**
	 *	IBusModelSchemaRefByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaRefByPrevIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrevIdx(IBusModelSchemaRefByPrevIdxKey key) {
		busmodel31SchemaRefRepository.deleteByPrevIdx(key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		busmodel31SchemaRefRepository.deleteByNextIdx(optionalNextId);
	}

	/**
	 *	IBusModelSchemaRefByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaRefByNextIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNextIdx(IBusModelSchemaRefByNextIdxKey key) {
		busmodel31SchemaRefRepository.deleteByNextIdx(key.getOptionalNextId());
	}

}
