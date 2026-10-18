// Description: Java 25 Spring JPA Service for DbKeyHash128Col

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
 *	Service for the BusModelDbKeyHash128Col entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModelDbKeyHash128ColRepository to access them.
 */
@Service("busmodel31JpaDbKeyHash128ColService")
public class BusModelJpaDbKeyHash128ColService {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaDbKeyHash128ColRepository busmodel31DbKeyHash128ColRepository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of BusModelJpaDbKeyHash128Col, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDbKeyHash128Col create(BusModelJpaDbKeyHash128Col data) {
		final String S_ProcName = "create";
		if (data == null) {
			return( null );
		}
		IYCFKeyHash256 originalRequiredId = data.getRequiredId();
		boolean generatedRequiredId = false;
		if (data.getRequiredContainerScope() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerScope",
				"data.requiredContainerScope",
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
		if (data.getRequiredContainerTable() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerTable",
				"data.requiredContainerTable",
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
			if(data.getPKey() != null && !data.getPKey().isNull() && busmodel31DbKeyHash128ColRepository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (BusModelJpaDbKeyHash128Col)(busmodel31DbKeyHash128ColRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
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
			return busmodel31DbKeyHash128ColRepository.save(data);
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
	public BusModelJpaDbKeyHash128Col update(BusModelJpaDbKeyHash128Col data) {
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
		if (data.getRequiredContainerScope() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerScope",
				"data.requiredContainerScope",
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
		if (data.getRequiredContainerTable() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerTable",
				"data.requiredContainerTable",
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
		BusModelJpaDbKeyHash128Col existing = busmodel31DbKeyHash128ColRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of BusModelValue to existing object
		existing.setRequiredContainerScope(data.getRequiredContainerScope());
		existing.setOptionalLookupDefSchema(data.getOptionalLookupDefSchema());
		existing.setOptionalLookupPrev(data.getOptionalLookupPrev());
		existing.setOptionalLookupNext(data.getOptionalLookupNext());
		// Apply data columns of BusModelValue to existing object
		existing.setRequiredScopeId(data.getRequiredScopeId());
		existing.setOptionalDefSchemaId(data.getOptionalDefSchemaId());
		existing.setRequiredName(data.getRequiredName());
		existing.setOptionalShortName(data.getOptionalShortName());
		existing.setOptionalLabel(data.getOptionalLabel());
		existing.setOptionalShortDescription(data.getOptionalShortDescription());
		existing.setOptionalDescription(data.getOptionalDescription());
		existing.setOptionalDefaultXmlValue(data.getOptionalDefaultXmlValue());
		existing.setRequiredIsNullable(data.getRequiredIsNullable());
		existing.setOptionalGenerateId(data.getOptionalGenerateId());
		existing.setRequiredImplementsPolymorph(data.getRequiredImplementsPolymorph());
		existing.setOptionalPrevId(data.getOptionalPrevId());
		existing.setOptionalNextId(data.getOptionalNextId());
		// Apply superior data relationships of BusModelAtom to existing object
		// Apply data columns of BusModelAtom to existing object
		existing.setOptionalDbName(data.getOptionalDbName());
		// Apply superior data relationships of BusModelDbKeyHash128Def to existing object
		// Apply data columns of BusModelDbKeyHash128Def to existing object
		existing.setOptionalInitValue(data.getOptionalInitValue());
		// Apply superior data relationships of BusModelDbKeyHash128Col to existing object
		existing.setRequiredContainerTable(data.getRequiredContainerTable());
		// Apply data columns of BusModelDbKeyHash128Col to existing object
		existing.setRequiredTableId(data.getRequiredTableId());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return busmodel31DbKeyHash128ColRepository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDbKeyHash128Col find(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31DbKeyHash128ColRepository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> findAll() {
		return( busmodel31DbKeyHash128ColRepository.findAll() );
	}

	// BusModelValue specified index finders

	/**
	 *	Find an entity using the columns of the IBusModelValueByUNameIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDbKeyHash128Col findByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName) {
		return( busmodel31DbKeyHash128ColRepository.findByUNameIdx(requiredScopeId,
			requiredName));
	}

	/**
	 *	IBusModelValueByUNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelValueByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDbKeyHash128Col findByUNameIdx(IBusModelValueByUNameIdxKey key) {
		return( busmodel31DbKeyHash128ColRepository.findByUNameIdx(key.getRequiredScopeId(), key.getRequiredName()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelValueByScopeIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *
	 *		@return List&lt;BusModelJpaDbKeyHash128Col&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> findByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId) {
		return( busmodel31DbKeyHash128ColRepository.findByScopeIdx(requiredScopeId));
	}

	/**
	 *	IBusModelValueByScopeIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelValueByScopeIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> findByScopeIdx(IBusModelValueByScopeIdxKey key) {
		return( busmodel31DbKeyHash128ColRepository.findByScopeIdx(key.getRequiredScopeId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelValueByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaDbKeyHash128Col&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31DbKeyHash128ColRepository.findByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelValueByDefSchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelValueByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> findByDefSchemaIdx(IBusModelValueByDefSchemaIdxKey key) {
		return( busmodel31DbKeyHash128ColRepository.findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelValueByPrevIdxKey as arguments.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaDbKeyHash128Col&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> findByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31DbKeyHash128ColRepository.findByPrevIdx(optionalPrevId));
	}

	/**
	 *	IBusModelValueByPrevIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelValueByPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> findByPrevIdx(IBusModelValueByPrevIdxKey key) {
		return( busmodel31DbKeyHash128ColRepository.findByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelValueByNextIdxKey as arguments.
	 *
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaDbKeyHash128Col&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> findByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31DbKeyHash128ColRepository.findByNextIdx(optionalNextId));
	}

	/**
	 *	IBusModelValueByNextIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelValueByNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> findByNextIdx(IBusModelValueByNextIdxKey key) {
		return( busmodel31DbKeyHash128ColRepository.findByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelValueByContPrevIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaDbKeyHash128Col&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> findByContPrevIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31DbKeyHash128ColRepository.findByContPrevIdx(requiredScopeId,
			optionalPrevId));
	}

	/**
	 *	IBusModelValueByContPrevIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelValueByContPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> findByContPrevIdx(IBusModelValueByContPrevIdxKey key) {
		return( busmodel31DbKeyHash128ColRepository.findByContPrevIdx(key.getRequiredScopeId(), key.getOptionalPrevId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelValueByContNextIdxKey as arguments.
	 *
	 *		@param requiredScopeId
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaDbKeyHash128Col&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> findByContNextIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31DbKeyHash128ColRepository.findByContNextIdx(requiredScopeId,
			optionalNextId));
	}

	/**
	 *	IBusModelValueByContNextIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelValueByContNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> findByContNextIdx(IBusModelValueByContNextIdxKey key) {
		return( busmodel31DbKeyHash128ColRepository.findByContNextIdx(key.getRequiredScopeId(), key.getOptionalNextId()));
	}

	// BusModelAtom specified index finders

	// BusModelDbKeyHash128Def specified index finders

	// BusModelDbKeyHash128Col specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelDbKeyHash128ColByTableIdxKey as arguments.
	 *
	 *		@param requiredTableId
	 *
	 *		@return List&lt;BusModelJpaDbKeyHash128Col&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> findByTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId) {
		return( busmodel31DbKeyHash128ColRepository.findByTableIdx(requiredTableId));
	}

	/**
	 *	IBusModelDbKeyHash128ColByTableIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelDbKeyHash128ColByTableIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> findByTableIdx(IBusModelDbKeyHash128ColByTableIdxKey key) {
		return( busmodel31DbKeyHash128ColRepository.findByTableIdx(key.getRequiredTableId()));
	}

	// BusModelValue specified lock-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDbKeyHash128Col lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31DbKeyHash128ColRepository.lockByIdIdx(requiredId));
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
	public BusModelJpaDbKeyHash128Col lockByUNameIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("name") String requiredName) {
		return( busmodel31DbKeyHash128ColRepository.lockByUNameIdx(requiredScopeId,
			requiredName));
	}

	/**
	 *	IBusModelValueByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaDbKeyHash128Col lockByUNameIdx(IBusModelValueByUNameIdxKey key) {
		return( busmodel31DbKeyHash128ColRepository.lockByUNameIdx(key.getRequiredScopeId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> lockByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId) {
		return( busmodel31DbKeyHash128ColRepository.lockByScopeIdx(requiredScopeId));
	}

	/**
	 *	IBusModelValueByScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> lockByScopeIdx(IBusModelValueByScopeIdxKey key) {
		return( busmodel31DbKeyHash128ColRepository.lockByScopeIdx(key.getRequiredScopeId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31DbKeyHash128ColRepository.lockByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelValueByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> lockByDefSchemaIdx(IBusModelValueByDefSchemaIdxKey key) {
		return( busmodel31DbKeyHash128ColRepository.lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> lockByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31DbKeyHash128ColRepository.lockByPrevIdx(optionalPrevId));
	}

	/**
	 *	IBusModelValueByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> lockByPrevIdx(IBusModelValueByPrevIdxKey key) {
		return( busmodel31DbKeyHash128ColRepository.lockByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> lockByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31DbKeyHash128ColRepository.lockByNextIdx(optionalNextId));
	}

	/**
	 *	IBusModelValueByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> lockByNextIdx(IBusModelValueByNextIdxKey key) {
		return( busmodel31DbKeyHash128ColRepository.lockByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param optionalPrevId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> lockByContPrevIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31DbKeyHash128ColRepository.lockByContPrevIdx(requiredScopeId,
			optionalPrevId));
	}

	/**
	 *	IBusModelValueByContPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> lockByContPrevIdx(IBusModelValueByContPrevIdxKey key) {
		return( busmodel31DbKeyHash128ColRepository.lockByContPrevIdx(key.getRequiredScopeId(), key.getOptionalPrevId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param optionalNextId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> lockByContNextIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31DbKeyHash128ColRepository.lockByContNextIdx(requiredScopeId,
			optionalNextId));
	}

	/**
	 *	IBusModelValueByContNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> lockByContNextIdx(IBusModelValueByContNextIdxKey key) {
		return( busmodel31DbKeyHash128ColRepository.lockByContNextIdx(key.getRequiredScopeId(), key.getOptionalNextId()));
	}

	// BusModelAtom specified lock-by-index methods

	// BusModelDbKeyHash128Def specified lock-by-index methods

	// BusModelDbKeyHash128Col specified lock-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> lockByTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId) {
		return( busmodel31DbKeyHash128ColRepository.lockByTableIdx(requiredTableId));
	}

	/**
	 *	IBusModelDbKeyHash128ColByTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaDbKeyHash128Col> lockByTableIdx(IBusModelDbKeyHash128ColByTableIdxKey key) {
		return( busmodel31DbKeyHash128ColRepository.lockByTableIdx(key.getRequiredTableId()));
	}

	// BusModelValue specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		busmodel31DbKeyHash128ColRepository.deleteByIdIdx(requiredId);
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
		busmodel31DbKeyHash128ColRepository.deleteByUNameIdx(requiredScopeId,
			requiredName);
	}

	/**
	 *	IBusModelValueByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelValueByUNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(IBusModelValueByUNameIdxKey key) {
		busmodel31DbKeyHash128ColRepository.deleteByUNameIdx(key.getRequiredScopeId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByScopeIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId) {
		busmodel31DbKeyHash128ColRepository.deleteByScopeIdx(requiredScopeId);
	}

	/**
	 *	IBusModelValueByScopeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelValueByScopeIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByScopeIdx(IBusModelValueByScopeIdxKey key) {
		busmodel31DbKeyHash128ColRepository.deleteByScopeIdx(key.getRequiredScopeId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		busmodel31DbKeyHash128ColRepository.deleteByDefSchemaIdx(optionalDefSchemaId);
	}

	/**
	 *	IBusModelValueByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelValueByDefSchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(IBusModelValueByDefSchemaIdxKey key) {
		busmodel31DbKeyHash128ColRepository.deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		busmodel31DbKeyHash128ColRepository.deleteByPrevIdx(optionalPrevId);
	}

	/**
	 *	IBusModelValueByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelValueByPrevIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrevIdx(IBusModelValueByPrevIdxKey key) {
		busmodel31DbKeyHash128ColRepository.deleteByPrevIdx(key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		busmodel31DbKeyHash128ColRepository.deleteByNextIdx(optionalNextId);
	}

	/**
	 *	IBusModelValueByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelValueByNextIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNextIdx(IBusModelValueByNextIdxKey key) {
		busmodel31DbKeyHash128ColRepository.deleteByNextIdx(key.getOptionalNextId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param optionalPrevId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByContPrevIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		busmodel31DbKeyHash128ColRepository.deleteByContPrevIdx(requiredScopeId,
			optionalPrevId);
	}

	/**
	 *	IBusModelValueByContPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelValueByContPrevIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByContPrevIdx(IBusModelValueByContPrevIdxKey key) {
		busmodel31DbKeyHash128ColRepository.deleteByContPrevIdx(key.getRequiredScopeId(), key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredScopeId
	 *		@param optionalNextId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByContNextIdx(@Param("scopeId") IYCFKeyHash256 requiredScopeId,
		@Param("nextId") IYCFKeyHash256 optionalNextId) {
		busmodel31DbKeyHash128ColRepository.deleteByContNextIdx(requiredScopeId,
			optionalNextId);
	}

	/**
	 *	IBusModelValueByContNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelValueByContNextIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByContNextIdx(IBusModelValueByContNextIdxKey key) {
		busmodel31DbKeyHash128ColRepository.deleteByContNextIdx(key.getRequiredScopeId(), key.getOptionalNextId());
	}

	// BusModelAtom specified delete-by-index methods

	// BusModelDbKeyHash128Def specified delete-by-index methods

	// BusModelDbKeyHash128Col specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId) {
		busmodel31DbKeyHash128ColRepository.deleteByTableIdx(requiredTableId);
	}

	/**
	 *	IBusModelDbKeyHash128ColByTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelDbKeyHash128ColByTableIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTableIdx(IBusModelDbKeyHash128ColByTableIdxKey key) {
		busmodel31DbKeyHash128ColRepository.deleteByTableIdx(key.getRequiredTableId());
	}

}
