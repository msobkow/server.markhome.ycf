// Description: Java 25 Spring JPA Service for IndexCol

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
 *	Service for the BusModelIndexCol entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModelIndexColRepository to access them.
 */
@Service("busmodel31JpaIndexColService")
public class BusModelJpaIndexColService {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaIndexColRepository busmodel31IndexColRepository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of BusModelJpaIndexCol, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexCol create(BusModelJpaIndexCol data) {
		final String S_ProcName = "create";
		if (data == null) {
			return( null );
		}
		IYCFKeyHash256 originalRequiredId = data.getRequiredId();
		boolean generatedRequiredId = false;
		if (data.getRequiredContainerIndex() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerIndex",
				"data.requiredContainerIndex",
				"Index",
				"Index",
				null);
		}
		if (data.getRequiredLookupColumn() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupColumn",
				"data.requiredLookupColumn",
				"Value",
				"Value",
				null);
		}
		if(data.getRequiredIndexId() == null || data.getRequiredIndexId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredIndexId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredColumnId() == null || data.getRequiredColumnId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredColumnId");
		}
		try {
			if(data.getPKey() != null && !data.getPKey().isNull() && busmodel31IndexColRepository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (BusModelJpaIndexCol)(busmodel31IndexColRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
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
			return busmodel31IndexColRepository.save(data);
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
	public BusModelJpaIndexCol update(BusModelJpaIndexCol data) {
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
		if (data.getRequiredContainerIndex() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerIndex",
				"data.requiredContainerIndex",
				"Index",
				"Index",
				null);
		}
		if (data.getRequiredLookupColumn() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupColumn",
				"data.requiredLookupColumn",
				"Value",
				"Value",
				null);
		}
		if(data.getRequiredIndexId() == null || data.getRequiredIndexId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredIndexId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredColumnId() == null || data.getRequiredColumnId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredColumnId");
		}
		// Ensure the entity exists and that the revision matches
		BusModelJpaIndexCol existing = busmodel31IndexColRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of BusModelIndexCol to existing object
		existing.setRequiredContainerIndex(data.getRequiredContainerIndex());
		existing.setOptionalLookupDefSchema(data.getOptionalLookupDefSchema());
		existing.setOptionalLookupPrev(data.getOptionalLookupPrev());
		existing.setOptionalLookupNext(data.getOptionalLookupNext());
		existing.setRequiredLookupColumn(data.getRequiredLookupColumn());
		// Apply data columns of BusModelIndexCol to existing object
		existing.setRequiredIndexId(data.getRequiredIndexId());
		existing.setOptionalDefSchemaId(data.getOptionalDefSchemaId());
		existing.setRequiredName(data.getRequiredName());
		existing.setOptionalShortName(data.getOptionalShortName());
		existing.setOptionalLabel(data.getOptionalLabel());
		existing.setOptionalShortDescription(data.getOptionalShortDescription());
		existing.setOptionalDescription(data.getOptionalDescription());
		existing.setRequiredColumnId(data.getRequiredColumnId());
		existing.setRequiredIsAscending(data.getRequiredIsAscending());
		existing.setOptionalPrevId(data.getOptionalPrevId());
		existing.setOptionalNextId(data.getOptionalNextId());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return busmodel31IndexColRepository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexCol find(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31IndexColRepository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> findAll() {
		return( busmodel31IndexColRepository.findAll() );
	}

	// BusModelIndexCol specified index finders

	/**
	 *	Find an entity using the columns of the IBusModelIndexColByUNameIdxKey as arguments.
	 *
	 *		@param requiredIndexId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexCol findByUNameIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("name") String requiredName) {
		return( busmodel31IndexColRepository.findByUNameIdx(requiredIndexId,
			requiredName));
	}

	/**
	 *	IBusModelIndexColByUNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelIndexColByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexCol findByUNameIdx(IBusModelIndexColByUNameIdxKey key) {
		return( busmodel31IndexColRepository.findByUNameIdx(key.getRequiredIndexId(), key.getRequiredName()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelIndexColByIndexIdxKey as arguments.
	 *
	 *		@param requiredIndexId
	 *
	 *		@return List&lt;BusModelJpaIndexCol&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> findByIndexIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId) {
		return( busmodel31IndexColRepository.findByIndexIdx(requiredIndexId));
	}

	/**
	 *	IBusModelIndexColByIndexIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelIndexColByIndexIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> findByIndexIdx(IBusModelIndexColByIndexIdxKey key) {
		return( busmodel31IndexColRepository.findByIndexIdx(key.getRequiredIndexId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelIndexColByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaIndexCol&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31IndexColRepository.findByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelIndexColByDefSchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelIndexColByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> findByDefSchemaIdx(IBusModelIndexColByDefSchemaIdxKey key) {
		return( busmodel31IndexColRepository.findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelIndexColByColIdxKey as arguments.
	 *
	 *		@param requiredColumnId
	 *
	 *		@return List&lt;BusModelJpaIndexCol&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> findByColIdx(@Param("columnId") IYCFKeyHash256 requiredColumnId) {
		return( busmodel31IndexColRepository.findByColIdx(requiredColumnId));
	}

	/**
	 *	IBusModelIndexColByColIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelIndexColByColIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> findByColIdx(IBusModelIndexColByColIdxKey key) {
		return( busmodel31IndexColRepository.findByColIdx(key.getRequiredColumnId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelIndexColByPrevIdxKey as arguments.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaIndexCol&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> findByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31IndexColRepository.findByPrevIdx(optionalPrevId));
	}

	/**
	 *	IBusModelIndexColByPrevIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelIndexColByPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> findByPrevIdx(IBusModelIndexColByPrevIdxKey key) {
		return( busmodel31IndexColRepository.findByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelIndexColByNextIdxKey as arguments.
	 *
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaIndexCol&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> findByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31IndexColRepository.findByNextIdx(optionalNextId));
	}

	/**
	 *	IBusModelIndexColByNextIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelIndexColByNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> findByNextIdx(IBusModelIndexColByNextIdxKey key) {
		return( busmodel31IndexColRepository.findByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelIndexColByIdxPrevIdxKey as arguments.
	 *
	 *		@param requiredIndexId
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaIndexCol&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> findByIdxPrevIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31IndexColRepository.findByIdxPrevIdx(requiredIndexId,
			optionalPrevId));
	}

	/**
	 *	IBusModelIndexColByIdxPrevIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelIndexColByIdxPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> findByIdxPrevIdx(IBusModelIndexColByIdxPrevIdxKey key) {
		return( busmodel31IndexColRepository.findByIdxPrevIdx(key.getRequiredIndexId(), key.getOptionalPrevId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelIndexColByIdxNextIdxKey as arguments.
	 *
	 *		@param requiredIndexId
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaIndexCol&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> findByIdxNextIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31IndexColRepository.findByIdxNextIdx(requiredIndexId,
			optionalNextId));
	}

	/**
	 *	IBusModelIndexColByIdxNextIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelIndexColByIdxNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> findByIdxNextIdx(IBusModelIndexColByIdxNextIdxKey key) {
		return( busmodel31IndexColRepository.findByIdxNextIdx(key.getRequiredIndexId(), key.getOptionalNextId()));
	}

	// BusModelIndexCol specified lock-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexCol lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31IndexColRepository.lockByIdIdx(requiredId));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexCol lockByUNameIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("name") String requiredName) {
		return( busmodel31IndexColRepository.lockByUNameIdx(requiredIndexId,
			requiredName));
	}

	/**
	 *	IBusModelIndexColByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaIndexCol lockByUNameIdx(IBusModelIndexColByUNameIdxKey key) {
		return( busmodel31IndexColRepository.lockByUNameIdx(key.getRequiredIndexId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> lockByIndexIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId) {
		return( busmodel31IndexColRepository.lockByIndexIdx(requiredIndexId));
	}

	/**
	 *	IBusModelIndexColByIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> lockByIndexIdx(IBusModelIndexColByIndexIdxKey key) {
		return( busmodel31IndexColRepository.lockByIndexIdx(key.getRequiredIndexId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31IndexColRepository.lockByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelIndexColByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> lockByDefSchemaIdx(IBusModelIndexColByDefSchemaIdxKey key) {
		return( busmodel31IndexColRepository.lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredColumnId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> lockByColIdx(@Param("columnId") IYCFKeyHash256 requiredColumnId) {
		return( busmodel31IndexColRepository.lockByColIdx(requiredColumnId));
	}

	/**
	 *	IBusModelIndexColByColIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> lockByColIdx(IBusModelIndexColByColIdxKey key) {
		return( busmodel31IndexColRepository.lockByColIdx(key.getRequiredColumnId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> lockByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31IndexColRepository.lockByPrevIdx(optionalPrevId));
	}

	/**
	 *	IBusModelIndexColByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> lockByPrevIdx(IBusModelIndexColByPrevIdxKey key) {
		return( busmodel31IndexColRepository.lockByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> lockByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31IndexColRepository.lockByNextIdx(optionalNextId));
	}

	/**
	 *	IBusModelIndexColByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> lockByNextIdx(IBusModelIndexColByNextIdxKey key) {
		return( busmodel31IndexColRepository.lockByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 *		@param optionalPrevId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> lockByIdxPrevIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31IndexColRepository.lockByIdxPrevIdx(requiredIndexId,
			optionalPrevId));
	}

	/**
	 *	IBusModelIndexColByIdxPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> lockByIdxPrevIdx(IBusModelIndexColByIdxPrevIdxKey key) {
		return( busmodel31IndexColRepository.lockByIdxPrevIdx(key.getRequiredIndexId(), key.getOptionalPrevId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 *		@param optionalNextId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> lockByIdxNextIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31IndexColRepository.lockByIdxNextIdx(requiredIndexId,
			optionalNextId));
	}

	/**
	 *	IBusModelIndexColByIdxNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaIndexCol> lockByIdxNextIdx(IBusModelIndexColByIdxNextIdxKey key) {
		return( busmodel31IndexColRepository.lockByIdxNextIdx(key.getRequiredIndexId(), key.getOptionalNextId()));
	}

	// BusModelIndexCol specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		busmodel31IndexColRepository.deleteByIdIdx(requiredId);
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("name") String requiredName) {
		busmodel31IndexColRepository.deleteByUNameIdx(requiredIndexId,
			requiredName);
	}

	/**
	 *	IBusModelIndexColByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelIndexColByUNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(IBusModelIndexColByUNameIdxKey key) {
		busmodel31IndexColRepository.deleteByUNameIdx(key.getRequiredIndexId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIndexIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId) {
		busmodel31IndexColRepository.deleteByIndexIdx(requiredIndexId);
	}

	/**
	 *	IBusModelIndexColByIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelIndexColByIndexIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIndexIdx(IBusModelIndexColByIndexIdxKey key) {
		busmodel31IndexColRepository.deleteByIndexIdx(key.getRequiredIndexId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		busmodel31IndexColRepository.deleteByDefSchemaIdx(optionalDefSchemaId);
	}

	/**
	 *	IBusModelIndexColByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelIndexColByDefSchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(IBusModelIndexColByDefSchemaIdxKey key) {
		busmodel31IndexColRepository.deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredColumnId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByColIdx(@Param("columnId") IYCFKeyHash256 requiredColumnId) {
		busmodel31IndexColRepository.deleteByColIdx(requiredColumnId);
	}

	/**
	 *	IBusModelIndexColByColIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelIndexColByColIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByColIdx(IBusModelIndexColByColIdxKey key) {
		busmodel31IndexColRepository.deleteByColIdx(key.getRequiredColumnId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		busmodel31IndexColRepository.deleteByPrevIdx(optionalPrevId);
	}

	/**
	 *	IBusModelIndexColByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelIndexColByPrevIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrevIdx(IBusModelIndexColByPrevIdxKey key) {
		busmodel31IndexColRepository.deleteByPrevIdx(key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		busmodel31IndexColRepository.deleteByNextIdx(optionalNextId);
	}

	/**
	 *	IBusModelIndexColByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelIndexColByNextIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNextIdx(IBusModelIndexColByNextIdxKey key) {
		busmodel31IndexColRepository.deleteByNextIdx(key.getOptionalNextId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 *		@param optionalPrevId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdxPrevIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		busmodel31IndexColRepository.deleteByIdxPrevIdx(requiredIndexId,
			optionalPrevId);
	}

	/**
	 *	IBusModelIndexColByIdxPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelIndexColByIdxPrevIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdxPrevIdx(IBusModelIndexColByIdxPrevIdxKey key) {
		busmodel31IndexColRepository.deleteByIdxPrevIdx(key.getRequiredIndexId(), key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredIndexId
	 *		@param optionalNextId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdxNextIdx(@Param("indexId") IYCFKeyHash256 requiredIndexId,
		@Param("nextId") IYCFKeyHash256 optionalNextId) {
		busmodel31IndexColRepository.deleteByIdxNextIdx(requiredIndexId,
			optionalNextId);
	}

	/**
	 *	IBusModelIndexColByIdxNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelIndexColByIdxNextIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdxNextIdx(IBusModelIndexColByIdxNextIdxKey key) {
		busmodel31IndexColRepository.deleteByIdxNextIdx(key.getRequiredIndexId(), key.getOptionalNextId());
	}

}
