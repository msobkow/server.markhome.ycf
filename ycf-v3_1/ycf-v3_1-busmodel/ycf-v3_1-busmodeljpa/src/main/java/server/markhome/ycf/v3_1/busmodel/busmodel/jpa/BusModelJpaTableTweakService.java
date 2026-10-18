// Description: Java 25 Spring JPA Service for TableTweak

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
 *	Service for the BusModelTableTweak entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModelTableTweakRepository to access them.
 */
@Service("busmodel31JpaTableTweakService")
public class BusModelJpaTableTweakService {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaTableTweakRepository busmodel31TableTweakRepository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of BusModelJpaTableTweak, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableTweak create(BusModelJpaTableTweak data) {
		final String S_ProcName = "create";
		if (data == null) {
			return( null );
		}
		IYCFKeyHash256 originalRequiredId = data.getRequiredId();
		boolean generatedRequiredId = false;
		if (data.getRequiredContainerScopeDef() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerScopeDef",
				"data.requiredContainerScopeDef",
				"Scope",
				"Scope",
				null);
		}
		if(data.getRequiredTenantId() == null || data.getRequiredTenantId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredTenantId");
		}
		if(data.getRequiredScopeId() == null || data.getRequiredScopeId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredScopeId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredTweakGelText() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredTweakGelText");
		}
		if (data.getRequiredContainerTableDef() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerTableDef",
				"data.requiredContainerTableDef",
				"Table",
				"Table",
				null);
		}
		if(data.getRequiredTableId() == null || data.getRequiredTableId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredTableId");
		}
		try {
			if(data.getPKey() != null && !data.getPKey().isNull() && busmodel31TableTweakRepository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (BusModelJpaTableTweak)(busmodel31TableTweakRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
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
			return busmodel31TableTweakRepository.save(data);
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
	public BusModelJpaTableTweak update(BusModelJpaTableTweak data) {
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
		if (data.getRequiredContainerScopeDef() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerScopeDef",
				"data.requiredContainerScopeDef",
				"Scope",
				"Scope",
				null);
		}
		if(data.getRequiredTenantId() == null || data.getRequiredTenantId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredTenantId");
		}
		if(data.getRequiredScopeId() == null || data.getRequiredScopeId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredScopeId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredTweakGelText() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredTweakGelText");
		}
		if (data.getRequiredContainerTableDef() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerTableDef",
				"data.requiredContainerTableDef",
				"Table",
				"Table",
				null);
		}
		if(data.getRequiredTableId() == null || data.getRequiredTableId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredTableId");
		}
		// Ensure the entity exists and that the revision matches
		BusModelJpaTableTweak existing = busmodel31TableTweakRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of BusModelTweak to existing object
		existing.setRequiredContainerScopeDef(data.getRequiredContainerScopeDef());
		existing.setOptionalLookupDefSchema(data.getOptionalLookupDefSchema());
		// Apply data columns of BusModelTweak to existing object
		existing.setRequiredTenantId(data.getRequiredTenantId());
		existing.setRequiredScopeId(data.getRequiredScopeId());
		existing.setOptionalDefSchemaTenantId(data.getOptionalDefSchemaTenantId());
		existing.setOptionalDefSchemaId(data.getOptionalDefSchemaId());
		existing.setRequiredName(data.getRequiredName());
		existing.setRequiredReplacesInherited(data.getRequiredReplacesInherited());
		existing.setRequiredTweakGelText(data.getRequiredTweakGelText());
		// Apply superior data relationships of BusModelTableTweak to existing object
		existing.setRequiredContainerTableDef(data.getRequiredContainerTableDef());
		// Apply data columns of BusModelTableTweak to existing object
		existing.setRequiredTableId(data.getRequiredTableId());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return busmodel31TableTweakRepository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableTweak find(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31TableTweakRepository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTableTweak> findAll() {
		return( busmodel31TableTweakRepository.findAll() );
	}

	// BusModelTweak specified index finders

	/**
	 *	Find an entity using the columns of the IBusModelTweakByUNameIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableTweak findByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName) {
		return( busmodel31TableTweakRepository.findByUNameIdx(requiredScopeId,
			requiredName));
	}

	/**
	 *	IBusModelTweakByUNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTweakByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableTweak findByUNameIdx(IBusModelTweakByUNameIdxKey key) {
		return( busmodel31TableTweakRepository.findByUNameIdx(key.getRequiredScopeId(), key.getRequiredName()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelTweakByValTentIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;BusModelJpaTableTweak&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTableTweak> findByValTentIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31TableTweakRepository.findByValTentIdx(requiredTenantId));
	}

	/**
	 *	IBusModelTweakByValTentIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTweakByValTentIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTableTweak> findByValTentIdx(IBusModelTweakByValTentIdxKey key) {
		return( busmodel31TableTweakRepository.findByValTentIdx(key.getRequiredTenantId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelTweakByScopeIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *
	 *		@return List&lt;BusModelJpaTableTweak&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTableTweak> findByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId) {
		return( busmodel31TableTweakRepository.findByScopeIdx(requiredScopeId));
	}

	/**
	 *	IBusModelTweakByScopeIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTweakByScopeIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTableTweak> findByScopeIdx(IBusModelTweakByScopeIdxKey key) {
		return( busmodel31TableTweakRepository.findByScopeIdx(key.getRequiredScopeId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelTweakByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaTableTweak&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTableTweak> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31TableTweakRepository.findByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelTweakByDefSchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTweakByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTableTweak> findByDefSchemaIdx(IBusModelTweakByDefSchemaIdxKey key) {
		return( busmodel31TableTweakRepository.findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Find an entity using the columns of the IBusModelTweakByUDefIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *		@param requiredScopeId
	 *		@param optionalDefSchemaTenantId
	 *		@param optionalDefSchemaId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableTweak findByUDefIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId,
		@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("defSchemaTenantId") IYCFKeyHash256 optionalDefSchemaTenantId,
		@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId,
		@Param("name") String requiredName) {
		return( busmodel31TableTweakRepository.findByUDefIdx(requiredTenantId,
			requiredScopeId,
			optionalDefSchemaTenantId,
			optionalDefSchemaId,
			requiredName));
	}

	/**
	 *	IBusModelTweakByUDefIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTweakByUDefIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableTweak findByUDefIdx(IBusModelTweakByUDefIdxKey key) {
		return( busmodel31TableTweakRepository.findByUDefIdx(key.getRequiredTenantId(), key.getRequiredScopeId(), key.getOptionalDefSchemaTenantId(), key.getOptionalDefSchemaId(), key.getRequiredName()));
	}

	// BusModelTableTweak specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelTableTweakByTableIdxKey as arguments.
	 *
	 *		@param requiredTableId
	 *
	 *		@return List&lt;BusModelJpaTableTweak&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTableTweak> findByTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId) {
		return( busmodel31TableTweakRepository.findByTableIdx(requiredTableId));
	}

	/**
	 *	IBusModelTableTweakByTableIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTableTweakByTableIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTableTweak> findByTableIdx(IBusModelTableTweakByTableIdxKey key) {
		return( busmodel31TableTweakRepository.findByTableIdx(key.getRequiredTableId()));
	}

	// BusModelTweak specified lock-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableTweak lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31TableTweakRepository.lockByIdIdx(requiredId));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableTweak lockByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName) {
		return( busmodel31TableTweakRepository.lockByUNameIdx(requiredScopeId,
			requiredName));
	}

	/**
	 *	IBusModelTweakByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableTweak lockByUNameIdx(IBusModelTweakByUNameIdxKey key) {
		return( busmodel31TableTweakRepository.lockByUNameIdx(key.getRequiredScopeId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTableTweak> lockByValTentIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31TableTweakRepository.lockByValTentIdx(requiredTenantId));
	}

	/**
	 *	IBusModelTweakByValTentIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTableTweak> lockByValTentIdx(IBusModelTweakByValTentIdxKey key) {
		return( busmodel31TableTweakRepository.lockByValTentIdx(key.getRequiredTenantId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTableTweak> lockByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId) {
		return( busmodel31TableTweakRepository.lockByScopeIdx(requiredScopeId));
	}

	/**
	 *	IBusModelTweakByScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTableTweak> lockByScopeIdx(IBusModelTweakByScopeIdxKey key) {
		return( busmodel31TableTweakRepository.lockByScopeIdx(key.getRequiredScopeId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTableTweak> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31TableTweakRepository.lockByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelTweakByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTableTweak> lockByDefSchemaIdx(IBusModelTweakByDefSchemaIdxKey key) {
		return( busmodel31TableTweakRepository.lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *		@param requiredScopeId
	 *		@param optionalDefSchemaTenantId
	 *		@param optionalDefSchemaId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableTweak lockByUDefIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId,
		@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("defSchemaTenantId") IYCFKeyHash256 optionalDefSchemaTenantId,
		@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId,
		@Param("name") String requiredName) {
		return( busmodel31TableTweakRepository.lockByUDefIdx(requiredTenantId,
			requiredScopeId,
			optionalDefSchemaTenantId,
			optionalDefSchemaId,
			requiredName));
	}

	/**
	 *	IBusModelTweakByUDefIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTableTweak lockByUDefIdx(IBusModelTweakByUDefIdxKey key) {
		return( busmodel31TableTweakRepository.lockByUDefIdx(key.getRequiredTenantId(), key.getRequiredScopeId(), key.getOptionalDefSchemaTenantId(), key.getOptionalDefSchemaId(), key.getRequiredName()));
	}

	// BusModelTableTweak specified lock-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTableTweak> lockByTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId) {
		return( busmodel31TableTweakRepository.lockByTableIdx(requiredTableId));
	}

	/**
	 *	IBusModelTableTweakByTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTableTweak> lockByTableIdx(IBusModelTableTweakByTableIdxKey key) {
		return( busmodel31TableTweakRepository.lockByTableIdx(key.getRequiredTableId()));
	}

	// BusModelTweak specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		busmodel31TableTweakRepository.deleteByIdIdx(requiredId);
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName) {
		busmodel31TableTweakRepository.deleteByUNameIdx(requiredScopeId,
			requiredName);
	}

	/**
	 *	IBusModelTweakByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTweakByUNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(IBusModelTweakByUNameIdxKey key) {
		busmodel31TableTweakRepository.deleteByUNameIdx(key.getRequiredScopeId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByValTentIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		busmodel31TableTweakRepository.deleteByValTentIdx(requiredTenantId);
	}

	/**
	 *	IBusModelTweakByValTentIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTweakByValTentIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByValTentIdx(IBusModelTweakByValTentIdxKey key) {
		busmodel31TableTweakRepository.deleteByValTentIdx(key.getRequiredTenantId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId) {
		busmodel31TableTweakRepository.deleteByScopeIdx(requiredScopeId);
	}

	/**
	 *	IBusModelTweakByScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTweakByScopeIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByScopeIdx(IBusModelTweakByScopeIdxKey key) {
		busmodel31TableTweakRepository.deleteByScopeIdx(key.getRequiredScopeId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		busmodel31TableTweakRepository.deleteByDefSchemaIdx(optionalDefSchemaId);
	}

	/**
	 *	IBusModelTweakByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTweakByDefSchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(IBusModelTweakByDefSchemaIdxKey key) {
		busmodel31TableTweakRepository.deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *		@param requiredScopeId
	 *		@param optionalDefSchemaTenantId
	 *		@param optionalDefSchemaId
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUDefIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId,
		@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("defSchemaTenantId") IYCFKeyHash256 optionalDefSchemaTenantId,
		@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId,
		@Param("name") String requiredName) {
		busmodel31TableTweakRepository.deleteByUDefIdx(requiredTenantId,
			requiredScopeId,
			optionalDefSchemaTenantId,
			optionalDefSchemaId,
			requiredName);
	}

	/**
	 *	IBusModelTweakByUDefIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTweakByUDefIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUDefIdx(IBusModelTweakByUDefIdxKey key) {
		busmodel31TableTweakRepository.deleteByUDefIdx(key.getRequiredTenantId(), key.getRequiredScopeId(), key.getOptionalDefSchemaTenantId(), key.getOptionalDefSchemaId(), key.getRequiredName());
	}

	// BusModelTableTweak specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId) {
		busmodel31TableTweakRepository.deleteByTableIdx(requiredTableId);
	}

	/**
	 *	IBusModelTableTweakByTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTableTweakByTableIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTableIdx(IBusModelTableTweakByTableIdxKey key) {
		busmodel31TableTweakRepository.deleteByTableIdx(key.getRequiredTableId());
	}

}
