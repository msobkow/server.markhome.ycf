// Description: Java 25 Spring JPA Service for Chain

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
 *	Service for the BusModelChain entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModelChainRepository to access them.
 */
@Service("busmodel31JpaChainService")
public class BusModelJpaChainService {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaChainRepository busmodel31ChainRepository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of BusModelJpaChain, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaChain create(BusModelJpaChain data) {
		final String S_ProcName = "create";
		if (data == null) {
			return( null );
		}
		IYCFKeyHash256 originalRequiredId = data.getRequiredId();
		boolean generatedRequiredId = false;
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
		if (data.getRequiredLookupPrevRel() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupPrevRel",
				"data.requiredLookupPrevRel",
				"Relation",
				"Relation",
				null);
		}
		if (data.getRequiredLookupNextRel() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupNextRel",
				"data.requiredLookupNextRel",
				"Relation",
				"Relation",
				null);
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredTableId() == null || data.getRequiredTableId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredTableId");
		}
		if(data.getRequiredPrevRelationId() == null || data.getRequiredPrevRelationId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredPrevRelationId");
		}
		if(data.getRequiredNextRelationId() == null || data.getRequiredNextRelationId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredNextRelationId");
		}
		try {
			if(data.getPKey() != null && !data.getPKey().isNull() && busmodel31ChainRepository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (BusModelJpaChain)(busmodel31ChainRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
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
			return busmodel31ChainRepository.save(data);
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
	public BusModelJpaChain update(BusModelJpaChain data) {
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
		if (data.getRequiredLookupPrevRel() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupPrevRel",
				"data.requiredLookupPrevRel",
				"Relation",
				"Relation",
				null);
		}
		if (data.getRequiredLookupNextRel() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupNextRel",
				"data.requiredLookupNextRel",
				"Relation",
				"Relation",
				null);
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredTableId() == null || data.getRequiredTableId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredTableId");
		}
		if(data.getRequiredPrevRelationId() == null || data.getRequiredPrevRelationId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredPrevRelationId");
		}
		if(data.getRequiredNextRelationId() == null || data.getRequiredNextRelationId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredNextRelationId");
		}
		// Ensure the entity exists and that the revision matches
		BusModelJpaChain existing = busmodel31ChainRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of BusModelChain to existing object
		existing.setRequiredContainerTable(data.getRequiredContainerTable());
		existing.setOptionalLookupDefSchema(data.getOptionalLookupDefSchema());
		existing.setRequiredLookupPrevRel(data.getRequiredLookupPrevRel());
		existing.setRequiredLookupNextRel(data.getRequiredLookupNextRel());
		// Apply data columns of BusModelChain to existing object
		existing.setOptionalDefSchemaId(data.getOptionalDefSchemaId());
		existing.setRequiredName(data.getRequiredName());
		existing.setOptionalShortName(data.getOptionalShortName());
		existing.setOptionalLabel(data.getOptionalLabel());
		existing.setOptionalShortDescription(data.getOptionalShortDescription());
		existing.setOptionalDescription(data.getOptionalDescription());
		existing.setRequiredTableId(data.getRequiredTableId());
		existing.setOptionalSuffix(data.getOptionalSuffix());
		existing.setRequiredPrevRelationId(data.getRequiredPrevRelationId());
		existing.setRequiredNextRelationId(data.getRequiredNextRelationId());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return busmodel31ChainRepository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaChain find(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31ChainRepository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaChain> findAll() {
		return( busmodel31ChainRepository.findAll() );
	}

	// BusModelChain specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelChainByChainTableIdxKey as arguments.
	 *
	 *		@param requiredTableId
	 *
	 *		@return List&lt;BusModelJpaChain&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaChain> findByChainTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId) {
		return( busmodel31ChainRepository.findByChainTableIdx(requiredTableId));
	}

	/**
	 *	IBusModelChainByChainTableIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelChainByChainTableIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaChain> findByChainTableIdx(IBusModelChainByChainTableIdxKey key) {
		return( busmodel31ChainRepository.findByChainTableIdx(key.getRequiredTableId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelChainByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaChain&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaChain> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31ChainRepository.findByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelChainByDefSchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelChainByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaChain> findByDefSchemaIdx(IBusModelChainByDefSchemaIdxKey key) {
		return( busmodel31ChainRepository.findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Find an entity using the columns of the IBusModelChainByUNameIdxKey as arguments.
	 *
	 *		@param requiredTableId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaChain findByUNameIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("name") String requiredName) {
		return( busmodel31ChainRepository.findByUNameIdx(requiredTableId,
			requiredName));
	}

	/**
	 *	IBusModelChainByUNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelChainByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaChain findByUNameIdx(IBusModelChainByUNameIdxKey key) {
		return( busmodel31ChainRepository.findByUNameIdx(key.getRequiredTableId(), key.getRequiredName()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelChainByPrevRelIdxKey as arguments.
	 *
	 *		@param requiredPrevRelationId
	 *
	 *		@return List&lt;BusModelJpaChain&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaChain> findByPrevRelIdx(@Param("prevRelationId") IYCFKeyHash256 requiredPrevRelationId) {
		return( busmodel31ChainRepository.findByPrevRelIdx(requiredPrevRelationId));
	}

	/**
	 *	IBusModelChainByPrevRelIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelChainByPrevRelIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaChain> findByPrevRelIdx(IBusModelChainByPrevRelIdxKey key) {
		return( busmodel31ChainRepository.findByPrevRelIdx(key.getRequiredPrevRelationId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelChainByNextRelIdxKey as arguments.
	 *
	 *		@param requiredNextRelationId
	 *
	 *		@return List&lt;BusModelJpaChain&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaChain> findByNextRelIdx(@Param("nextRelationId") IYCFKeyHash256 requiredNextRelationId) {
		return( busmodel31ChainRepository.findByNextRelIdx(requiredNextRelationId));
	}

	/**
	 *	IBusModelChainByNextRelIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelChainByNextRelIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaChain> findByNextRelIdx(IBusModelChainByNextRelIdxKey key) {
		return( busmodel31ChainRepository.findByNextRelIdx(key.getRequiredNextRelationId()));
	}

	// BusModelChain specified lock-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaChain lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31ChainRepository.lockByIdIdx(requiredId));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaChain> lockByChainTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId) {
		return( busmodel31ChainRepository.lockByChainTableIdx(requiredTableId));
	}

	/**
	 *	IBusModelChainByChainTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaChain> lockByChainTableIdx(IBusModelChainByChainTableIdxKey key) {
		return( busmodel31ChainRepository.lockByChainTableIdx(key.getRequiredTableId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaChain> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31ChainRepository.lockByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelChainByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaChain> lockByDefSchemaIdx(IBusModelChainByDefSchemaIdxKey key) {
		return( busmodel31ChainRepository.lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaChain lockByUNameIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("name") String requiredName) {
		return( busmodel31ChainRepository.lockByUNameIdx(requiredTableId,
			requiredName));
	}

	/**
	 *	IBusModelChainByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaChain lockByUNameIdx(IBusModelChainByUNameIdxKey key) {
		return( busmodel31ChainRepository.lockByUNameIdx(key.getRequiredTableId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredPrevRelationId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaChain> lockByPrevRelIdx(@Param("prevRelationId") IYCFKeyHash256 requiredPrevRelationId) {
		return( busmodel31ChainRepository.lockByPrevRelIdx(requiredPrevRelationId));
	}

	/**
	 *	IBusModelChainByPrevRelIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaChain> lockByPrevRelIdx(IBusModelChainByPrevRelIdxKey key) {
		return( busmodel31ChainRepository.lockByPrevRelIdx(key.getRequiredPrevRelationId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredNextRelationId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaChain> lockByNextRelIdx(@Param("nextRelationId") IYCFKeyHash256 requiredNextRelationId) {
		return( busmodel31ChainRepository.lockByNextRelIdx(requiredNextRelationId));
	}

	/**
	 *	IBusModelChainByNextRelIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaChain> lockByNextRelIdx(IBusModelChainByNextRelIdxKey key) {
		return( busmodel31ChainRepository.lockByNextRelIdx(key.getRequiredNextRelationId()));
	}

	// BusModelChain specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		busmodel31ChainRepository.deleteByIdIdx(requiredId);
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByChainTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId) {
		busmodel31ChainRepository.deleteByChainTableIdx(requiredTableId);
	}

	/**
	 *	IBusModelChainByChainTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelChainByChainTableIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByChainTableIdx(IBusModelChainByChainTableIdxKey key) {
		busmodel31ChainRepository.deleteByChainTableIdx(key.getRequiredTableId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		busmodel31ChainRepository.deleteByDefSchemaIdx(optionalDefSchemaId);
	}

	/**
	 *	IBusModelChainByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelChainByDefSchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(IBusModelChainByDefSchemaIdxKey key) {
		busmodel31ChainRepository.deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("name") String requiredName) {
		busmodel31ChainRepository.deleteByUNameIdx(requiredTableId,
			requiredName);
	}

	/**
	 *	IBusModelChainByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelChainByUNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(IBusModelChainByUNameIdxKey key) {
		busmodel31ChainRepository.deleteByUNameIdx(key.getRequiredTableId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredPrevRelationId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrevRelIdx(@Param("prevRelationId") IYCFKeyHash256 requiredPrevRelationId) {
		busmodel31ChainRepository.deleteByPrevRelIdx(requiredPrevRelationId);
	}

	/**
	 *	IBusModelChainByPrevRelIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelChainByPrevRelIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrevRelIdx(IBusModelChainByPrevRelIdxKey key) {
		busmodel31ChainRepository.deleteByPrevRelIdx(key.getRequiredPrevRelationId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredNextRelationId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNextRelIdx(@Param("nextRelationId") IYCFKeyHash256 requiredNextRelationId) {
		busmodel31ChainRepository.deleteByNextRelIdx(requiredNextRelationId);
	}

	/**
	 *	IBusModelChainByNextRelIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelChainByNextRelIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNextRelIdx(IBusModelChainByNextRelIdxKey key) {
		busmodel31ChainRepository.deleteByNextRelIdx(key.getRequiredNextRelationId());
	}

}
