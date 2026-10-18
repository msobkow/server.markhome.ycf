// Description: Java 25 Spring JPA Service for Tweak

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
 *	Service for the BusModelTweak entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModelTweakRepository to access them.
 */
@Service("busmodel31JpaTweakService")
public class BusModelJpaTweakService {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaTweakRepository busmodel31TweakRepository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of BusModelJpaTweak, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTweak create(BusModelJpaTweak data) {
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
		try {
			if(data.getPKey() != null && !data.getPKey().isNull() && busmodel31TweakRepository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (BusModelJpaTweak)(busmodel31TweakRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
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
			return busmodel31TweakRepository.save(data);
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
	public BusModelJpaTweak update(BusModelJpaTweak data) {
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
		// Ensure the entity exists and that the revision matches
		BusModelJpaTweak existing = busmodel31TweakRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
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
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return busmodel31TweakRepository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTweak find(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31TweakRepository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTweak> findAll() {
		return( busmodel31TweakRepository.findAll() );
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
	public BusModelJpaTweak findByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName) {
		return( busmodel31TweakRepository.findByUNameIdx(requiredScopeId,
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
	public BusModelJpaTweak findByUNameIdx(IBusModelTweakByUNameIdxKey key) {
		return( busmodel31TweakRepository.findByUNameIdx(key.getRequiredScopeId(), key.getRequiredName()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelTweakByValTentIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;BusModelJpaTweak&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTweak> findByValTentIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31TweakRepository.findByValTentIdx(requiredTenantId));
	}

	/**
	 *	IBusModelTweakByValTentIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTweakByValTentIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTweak> findByValTentIdx(IBusModelTweakByValTentIdxKey key) {
		return( busmodel31TweakRepository.findByValTentIdx(key.getRequiredTenantId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelTweakByScopeIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *
	 *		@return List&lt;BusModelJpaTweak&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTweak> findByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId) {
		return( busmodel31TweakRepository.findByScopeIdx(requiredScopeId));
	}

	/**
	 *	IBusModelTweakByScopeIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTweakByScopeIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTweak> findByScopeIdx(IBusModelTweakByScopeIdxKey key) {
		return( busmodel31TweakRepository.findByScopeIdx(key.getRequiredScopeId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelTweakByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaTweak&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTweak> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31TweakRepository.findByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelTweakByDefSchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTweakByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTweak> findByDefSchemaIdx(IBusModelTweakByDefSchemaIdxKey key) {
		return( busmodel31TweakRepository.findByDefSchemaIdx(key.getOptionalDefSchemaId()));
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
	public BusModelJpaTweak findByUDefIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId,
		@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("defSchemaTenantId") IYCFKeyHash256 optionalDefSchemaTenantId,
		@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId,
		@Param("name") String requiredName) {
		return( busmodel31TweakRepository.findByUDefIdx(requiredTenantId,
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
	public BusModelJpaTweak findByUDefIdx(IBusModelTweakByUDefIdxKey key) {
		return( busmodel31TweakRepository.findByUDefIdx(key.getRequiredTenantId(), key.getRequiredScopeId(), key.getOptionalDefSchemaTenantId(), key.getOptionalDefSchemaId(), key.getRequiredName()));
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
	public BusModelJpaTweak lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31TweakRepository.lockByIdIdx(requiredId));
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
	public BusModelJpaTweak lockByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName) {
		return( busmodel31TweakRepository.lockByUNameIdx(requiredScopeId,
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
	public BusModelJpaTweak lockByUNameIdx(IBusModelTweakByUNameIdxKey key) {
		return( busmodel31TweakRepository.lockByUNameIdx(key.getRequiredScopeId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTweak> lockByValTentIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31TweakRepository.lockByValTentIdx(requiredTenantId));
	}

	/**
	 *	IBusModelTweakByValTentIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTweak> lockByValTentIdx(IBusModelTweakByValTentIdxKey key) {
		return( busmodel31TweakRepository.lockByValTentIdx(key.getRequiredTenantId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTweak> lockByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId) {
		return( busmodel31TweakRepository.lockByScopeIdx(requiredScopeId));
	}

	/**
	 *	IBusModelTweakByScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTweak> lockByScopeIdx(IBusModelTweakByScopeIdxKey key) {
		return( busmodel31TweakRepository.lockByScopeIdx(key.getRequiredScopeId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTweak> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31TweakRepository.lockByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelTweakByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTweak> lockByDefSchemaIdx(IBusModelTweakByDefSchemaIdxKey key) {
		return( busmodel31TweakRepository.lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
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
	public BusModelJpaTweak lockByUDefIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId,
		@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("defSchemaTenantId") IYCFKeyHash256 optionalDefSchemaTenantId,
		@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId,
		@Param("name") String requiredName) {
		return( busmodel31TweakRepository.lockByUDefIdx(requiredTenantId,
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
	public BusModelJpaTweak lockByUDefIdx(IBusModelTweakByUDefIdxKey key) {
		return( busmodel31TweakRepository.lockByUDefIdx(key.getRequiredTenantId(), key.getRequiredScopeId(), key.getOptionalDefSchemaTenantId(), key.getOptionalDefSchemaId(), key.getRequiredName()));
	}

	// BusModelTweak specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		busmodel31TweakRepository.deleteByIdIdx(requiredId);
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
		busmodel31TweakRepository.deleteByUNameIdx(requiredScopeId,
			requiredName);
	}

	/**
	 *	IBusModelTweakByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTweakByUNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(IBusModelTweakByUNameIdxKey key) {
		busmodel31TweakRepository.deleteByUNameIdx(key.getRequiredScopeId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByValTentIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		busmodel31TweakRepository.deleteByValTentIdx(requiredTenantId);
	}

	/**
	 *	IBusModelTweakByValTentIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTweakByValTentIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByValTentIdx(IBusModelTweakByValTentIdxKey key) {
		busmodel31TweakRepository.deleteByValTentIdx(key.getRequiredTenantId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId) {
		busmodel31TweakRepository.deleteByScopeIdx(requiredScopeId);
	}

	/**
	 *	IBusModelTweakByScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTweakByScopeIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByScopeIdx(IBusModelTweakByScopeIdxKey key) {
		busmodel31TweakRepository.deleteByScopeIdx(key.getRequiredScopeId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		busmodel31TweakRepository.deleteByDefSchemaIdx(optionalDefSchemaId);
	}

	/**
	 *	IBusModelTweakByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTweakByDefSchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(IBusModelTweakByDefSchemaIdxKey key) {
		busmodel31TweakRepository.deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
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
		busmodel31TweakRepository.deleteByUDefIdx(requiredTenantId,
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
		busmodel31TweakRepository.deleteByUDefIdx(key.getRequiredTenantId(), key.getRequiredScopeId(), key.getOptionalDefSchemaTenantId(), key.getOptionalDefSchemaId(), key.getRequiredName());
	}

}
