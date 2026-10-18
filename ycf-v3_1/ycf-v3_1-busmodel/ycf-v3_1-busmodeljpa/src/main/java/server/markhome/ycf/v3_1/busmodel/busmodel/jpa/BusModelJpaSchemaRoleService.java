// Description: Java 25 Spring JPA Service for SchemaRole

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
 *	Service for the BusModelSchemaRole entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModelSchemaRoleRepository to access them.
 */
@Service("busmodel31JpaSchemaRoleService")
public class BusModelJpaSchemaRoleService {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaSchemaRoleRepository busmodel31SchemaRoleRepository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of BusModelJpaSchemaRole, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRole create(BusModelJpaSchemaRole data) {
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
		if(data.getRequiredEnables() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredEnables");
		}
		if(data.getRequiredIncludes() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredIncludes");
		}
		if (data.getRequiredContainerSchemaDef() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerSchemaDef",
				"data.requiredContainerSchemaDef",
				"SchemaDef",
				"SchemaDef",
				null);
		}
		if(data.getRequiredSchemaDefId() == null || data.getRequiredSchemaDefId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredSchemaDefId");
		}
		if(data.getRequiredRoleScope() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredRoleScope");
		}
		try {
			if(data.getPKey() != null && !data.getPKey().isNull() && busmodel31SchemaRoleRepository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (BusModelJpaSchemaRole)(busmodel31SchemaRoleRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
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
			return busmodel31SchemaRoleRepository.save(data);
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
	public BusModelJpaSchemaRole update(BusModelJpaSchemaRole data) {
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
		if(data.getRequiredEnables() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredEnables");
		}
		if(data.getRequiredIncludes() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredIncludes");
		}
		if (data.getRequiredContainerSchemaDef() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerSchemaDef",
				"data.requiredContainerSchemaDef",
				"SchemaDef",
				"SchemaDef",
				null);
		}
		if(data.getRequiredSchemaDefId() == null || data.getRequiredSchemaDefId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredSchemaDefId");
		}
		if(data.getRequiredRoleScope() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredRoleScope");
		}
		// Ensure the entity exists and that the revision matches
		BusModelJpaSchemaRole existing = busmodel31SchemaRoleRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of BusModelRoleDef to existing object
		existing.setRequiredContainerScopeDef(data.getRequiredContainerScopeDef());
		existing.setOptionalLookupDefSchema(data.getOptionalLookupDefSchema());
		// Apply data columns of BusModelRoleDef to existing object
		existing.setRequiredScopeId(data.getRequiredScopeId());
		existing.setOptionalDefSchemaId(data.getOptionalDefSchemaId());
		existing.setRequiredName(data.getRequiredName());
		existing.setRequiredEnables(data.getRequiredEnables());
		existing.setRequiredIncludes(data.getRequiredIncludes());
		// Apply superior data relationships of BusModelSchemaRole to existing object
		existing.setRequiredContainerSchemaDef(data.getRequiredContainerSchemaDef());
		// Apply data columns of BusModelSchemaRole to existing object
		existing.setRequiredSchemaDefId(data.getRequiredSchemaDefId());
		existing.setRequiredRoleScope(data.getRequiredRoleScope());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return busmodel31SchemaRoleRepository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRole find(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31SchemaRoleRepository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> findAll() {
		return( busmodel31SchemaRoleRepository.findAll() );
	}

	// BusModelRoleDef specified index finders

	/**
	 *	Find an entity using the columns of the IBusModelRoleDefByUNameIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRole findByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName) {
		return( busmodel31SchemaRoleRepository.findByUNameIdx(requiredScopeId,
			requiredName));
	}

	/**
	 *	IBusModelRoleDefByUNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRoleDefByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRole findByUNameIdx(IBusModelRoleDefByUNameIdxKey key) {
		return( busmodel31SchemaRoleRepository.findByUNameIdx(key.getRequiredScopeId(), key.getRequiredName()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRoleDefByScopeIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *
	 *		@return List&lt;BusModelJpaSchemaRole&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> findByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId) {
		return( busmodel31SchemaRoleRepository.findByScopeIdx(requiredScopeId));
	}

	/**
	 *	IBusModelRoleDefByScopeIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRoleDefByScopeIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> findByScopeIdx(IBusModelRoleDefByScopeIdxKey key) {
		return( busmodel31SchemaRoleRepository.findByScopeIdx(key.getRequiredScopeId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRoleDefByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaSchemaRole&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31SchemaRoleRepository.findByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelRoleDefByDefSchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRoleDefByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> findByDefSchemaIdx(IBusModelRoleDefByDefSchemaIdxKey key) {
		return( busmodel31SchemaRoleRepository.findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Find an entity using the columns of the IBusModelRoleDefByUDefIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *		@param optionalDefSchemaId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRole findByUDefIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId,
		@Param("name") String requiredName) {
		return( busmodel31SchemaRoleRepository.findByUDefIdx(requiredScopeId,
			optionalDefSchemaId,
			requiredName));
	}

	/**
	 *	IBusModelRoleDefByUDefIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRoleDefByUDefIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRole findByUDefIdx(IBusModelRoleDefByUDefIdxKey key) {
		return( busmodel31SchemaRoleRepository.findByUDefIdx(key.getRequiredScopeId(), key.getOptionalDefSchemaId(), key.getRequiredName()));
	}

	// BusModelSchemaRole specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelSchemaRoleBySchemaIdxKey as arguments.
	 *
	 *		@param requiredSchemaDefId
	 *
	 *		@return List&lt;BusModelJpaSchemaRole&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> findBySchemaIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId) {
		return( busmodel31SchemaRoleRepository.findBySchemaIdx(requiredSchemaDefId));
	}

	/**
	 *	IBusModelSchemaRoleBySchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaRoleBySchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> findBySchemaIdx(IBusModelSchemaRoleBySchemaIdxKey key) {
		return( busmodel31SchemaRoleRepository.findBySchemaIdx(key.getRequiredSchemaDefId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelSchemaRoleByRoleScopeIdxKey as arguments.
	 *
	 *		@param requiredRoleScope
	 *
	 *		@return List&lt;BusModelJpaSchemaRole&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> findByRoleScopeIdx(@Param("roleScope") IBusModelPubSchema.RoleScopeEnum requiredRoleScope) {
		return( busmodel31SchemaRoleRepository.findByRoleScopeIdx(requiredRoleScope));
	}

	/**
	 *	IBusModelSchemaRoleByRoleScopeIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaRoleByRoleScopeIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> findByRoleScopeIdx(IBusModelSchemaRoleByRoleScopeIdxKey key) {
		return( busmodel31SchemaRoleRepository.findByRoleScopeIdx(key.getRequiredRoleScope()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelSchemaRoleBySchRoleScpIdxKey as arguments.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredRoleScope
	 *
	 *		@return List&lt;BusModelJpaSchemaRole&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> findBySchRoleScpIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("roleScope") IBusModelPubSchema.RoleScopeEnum requiredRoleScope) {
		return( busmodel31SchemaRoleRepository.findBySchRoleScpIdx(requiredSchemaDefId,
			requiredRoleScope));
	}

	/**
	 *	IBusModelSchemaRoleBySchRoleScpIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaRoleBySchRoleScpIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> findBySchRoleScpIdx(IBusModelSchemaRoleBySchRoleScpIdxKey key) {
		return( busmodel31SchemaRoleRepository.findBySchRoleScpIdx(key.getRequiredSchemaDefId(), key.getRequiredRoleScope()));
	}

	// BusModelRoleDef specified lock-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRole lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31SchemaRoleRepository.lockByIdIdx(requiredId));
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
	public BusModelJpaSchemaRole lockByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName) {
		return( busmodel31SchemaRoleRepository.lockByUNameIdx(requiredScopeId,
			requiredName));
	}

	/**
	 *	IBusModelRoleDefByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRole lockByUNameIdx(IBusModelRoleDefByUNameIdxKey key) {
		return( busmodel31SchemaRoleRepository.lockByUNameIdx(key.getRequiredScopeId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> lockByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId) {
		return( busmodel31SchemaRoleRepository.lockByScopeIdx(requiredScopeId));
	}

	/**
	 *	IBusModelRoleDefByScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> lockByScopeIdx(IBusModelRoleDefByScopeIdxKey key) {
		return( busmodel31SchemaRoleRepository.lockByScopeIdx(key.getRequiredScopeId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31SchemaRoleRepository.lockByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelRoleDefByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> lockByDefSchemaIdx(IBusModelRoleDefByDefSchemaIdxKey key) {
		return( busmodel31SchemaRoleRepository.lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param optionalDefSchemaId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRole lockByUDefIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId,
		@Param("name") String requiredName) {
		return( busmodel31SchemaRoleRepository.lockByUDefIdx(requiredScopeId,
			optionalDefSchemaId,
			requiredName));
	}

	/**
	 *	IBusModelRoleDefByUDefIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaRole lockByUDefIdx(IBusModelRoleDefByUDefIdxKey key) {
		return( busmodel31SchemaRoleRepository.lockByUDefIdx(key.getRequiredScopeId(), key.getOptionalDefSchemaId(), key.getRequiredName()));
	}

	// BusModelSchemaRole specified lock-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> lockBySchemaIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId) {
		return( busmodel31SchemaRoleRepository.lockBySchemaIdx(requiredSchemaDefId));
	}

	/**
	 *	IBusModelSchemaRoleBySchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> lockBySchemaIdx(IBusModelSchemaRoleBySchemaIdxKey key) {
		return( busmodel31SchemaRoleRepository.lockBySchemaIdx(key.getRequiredSchemaDefId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRoleScope
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> lockByRoleScopeIdx(@Param("roleScope") IBusModelPubSchema.RoleScopeEnum requiredRoleScope) {
		return( busmodel31SchemaRoleRepository.lockByRoleScopeIdx(requiredRoleScope));
	}

	/**
	 *	IBusModelSchemaRoleByRoleScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> lockByRoleScopeIdx(IBusModelSchemaRoleByRoleScopeIdxKey key) {
		return( busmodel31SchemaRoleRepository.lockByRoleScopeIdx(key.getRequiredRoleScope()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredRoleScope
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> lockBySchRoleScpIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("roleScope") IBusModelPubSchema.RoleScopeEnum requiredRoleScope) {
		return( busmodel31SchemaRoleRepository.lockBySchRoleScpIdx(requiredSchemaDefId,
			requiredRoleScope));
	}

	/**
	 *	IBusModelSchemaRoleBySchRoleScpIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaRole> lockBySchRoleScpIdx(IBusModelSchemaRoleBySchRoleScpIdxKey key) {
		return( busmodel31SchemaRoleRepository.lockBySchRoleScpIdx(key.getRequiredSchemaDefId(), key.getRequiredRoleScope()));
	}

	// BusModelRoleDef specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		busmodel31SchemaRoleRepository.deleteByIdIdx(requiredId);
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
		busmodel31SchemaRoleRepository.deleteByUNameIdx(requiredScopeId,
			requiredName);
	}

	/**
	 *	IBusModelRoleDefByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRoleDefByUNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(IBusModelRoleDefByUNameIdxKey key) {
		busmodel31SchemaRoleRepository.deleteByUNameIdx(key.getRequiredScopeId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId) {
		busmodel31SchemaRoleRepository.deleteByScopeIdx(requiredScopeId);
	}

	/**
	 *	IBusModelRoleDefByScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRoleDefByScopeIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByScopeIdx(IBusModelRoleDefByScopeIdxKey key) {
		busmodel31SchemaRoleRepository.deleteByScopeIdx(key.getRequiredScopeId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		busmodel31SchemaRoleRepository.deleteByDefSchemaIdx(optionalDefSchemaId);
	}

	/**
	 *	IBusModelRoleDefByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRoleDefByDefSchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(IBusModelRoleDefByDefSchemaIdxKey key) {
		busmodel31SchemaRoleRepository.deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param optionalDefSchemaId
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUDefIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId,
		@Param("name") String requiredName) {
		busmodel31SchemaRoleRepository.deleteByUDefIdx(requiredScopeId,
			optionalDefSchemaId,
			requiredName);
	}

	/**
	 *	IBusModelRoleDefByUDefIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRoleDefByUDefIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUDefIdx(IBusModelRoleDefByUDefIdxKey key) {
		busmodel31SchemaRoleRepository.deleteByUDefIdx(key.getRequiredScopeId(), key.getOptionalDefSchemaId(), key.getRequiredName());
	}

	// BusModelSchemaRole specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteBySchemaIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId) {
		busmodel31SchemaRoleRepository.deleteBySchemaIdx(requiredSchemaDefId);
	}

	/**
	 *	IBusModelSchemaRoleBySchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaRoleBySchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteBySchemaIdx(IBusModelSchemaRoleBySchemaIdxKey key) {
		busmodel31SchemaRoleRepository.deleteBySchemaIdx(key.getRequiredSchemaDefId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRoleScope
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRoleScopeIdx(@Param("roleScope") IBusModelPubSchema.RoleScopeEnum requiredRoleScope) {
		busmodel31SchemaRoleRepository.deleteByRoleScopeIdx(requiredRoleScope);
	}

	/**
	 *	IBusModelSchemaRoleByRoleScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaRoleByRoleScopeIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRoleScopeIdx(IBusModelSchemaRoleByRoleScopeIdxKey key) {
		busmodel31SchemaRoleRepository.deleteByRoleScopeIdx(key.getRequiredRoleScope());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredRoleScope
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteBySchRoleScpIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("roleScope") IBusModelPubSchema.RoleScopeEnum requiredRoleScope) {
		busmodel31SchemaRoleRepository.deleteBySchRoleScpIdx(requiredSchemaDefId,
			requiredRoleScope);
	}

	/**
	 *	IBusModelSchemaRoleBySchRoleScpIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaRoleBySchRoleScpIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteBySchRoleScpIdx(IBusModelSchemaRoleBySchRoleScpIdxKey key) {
		busmodel31SchemaRoleRepository.deleteBySchRoleScpIdx(key.getRequiredSchemaDefId(), key.getRequiredRoleScope());
	}

}
