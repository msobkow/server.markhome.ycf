// Description: Java 25 Spring JPA Service for RelationCol

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
 *	Service for the BusModelRelationCol entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModelRelationColRepository to access them.
 */
@Service("busmodel31JpaRelationColService")
public class BusModelJpaRelationColService {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaRelationColRepository busmodel31RelationColRepository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of BusModelJpaRelationCol, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationCol create(BusModelJpaRelationCol data) {
		final String S_ProcName = "create";
		if (data == null) {
			return( null );
		}
		IYCFKeyHash256 originalRequiredId = data.getRequiredId();
		boolean generatedRequiredId = false;
		if (data.getRequiredContainerRelation() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerRelation",
				"data.requiredContainerRelation",
				"Relation",
				"Relation",
				null);
		}
		if (data.getRequiredLookupFromCol() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupFromCol",
				"data.requiredLookupFromCol",
				"IndexCol",
				"IndexCol",
				null);
		}
		if (data.getRequiredLookupToCol() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupToCol",
				"data.requiredLookupToCol",
				"IndexCol",
				"IndexCol",
				null);
		}
		if(data.getRequiredRelationId() == null || data.getRequiredRelationId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredRelationId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredFromColId() == null || data.getRequiredFromColId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredFromColId");
		}
		if(data.getRequiredToColId() == null || data.getRequiredToColId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredToColId");
		}
		try {
			if(data.getPKey() != null && !data.getPKey().isNull() && busmodel31RelationColRepository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (BusModelJpaRelationCol)(busmodel31RelationColRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
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
			return busmodel31RelationColRepository.save(data);
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
	public BusModelJpaRelationCol update(BusModelJpaRelationCol data) {
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
		if (data.getRequiredContainerRelation() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerRelation",
				"data.requiredContainerRelation",
				"Relation",
				"Relation",
				null);
		}
		if (data.getRequiredLookupFromCol() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupFromCol",
				"data.requiredLookupFromCol",
				"IndexCol",
				"IndexCol",
				null);
		}
		if (data.getRequiredLookupToCol() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupToCol",
				"data.requiredLookupToCol",
				"IndexCol",
				"IndexCol",
				null);
		}
		if(data.getRequiredRelationId() == null || data.getRequiredRelationId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredRelationId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredFromColId() == null || data.getRequiredFromColId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredFromColId");
		}
		if(data.getRequiredToColId() == null || data.getRequiredToColId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredToColId");
		}
		// Ensure the entity exists and that the revision matches
		BusModelJpaRelationCol existing = busmodel31RelationColRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of BusModelRelationCol to existing object
		existing.setRequiredContainerRelation(data.getRequiredContainerRelation());
		existing.setOptionalLookupDefSchema(data.getOptionalLookupDefSchema());
		existing.setOptionalLookupPrev(data.getOptionalLookupPrev());
		existing.setOptionalLookupNext(data.getOptionalLookupNext());
		existing.setRequiredLookupFromCol(data.getRequiredLookupFromCol());
		existing.setRequiredLookupToCol(data.getRequiredLookupToCol());
		// Apply data columns of BusModelRelationCol to existing object
		existing.setRequiredRelationId(data.getRequiredRelationId());
		existing.setOptionalDefSchemaId(data.getOptionalDefSchemaId());
		existing.setRequiredName(data.getRequiredName());
		existing.setOptionalShortName(data.getOptionalShortName());
		existing.setOptionalLabel(data.getOptionalLabel());
		existing.setOptionalShortDescription(data.getOptionalShortDescription());
		existing.setOptionalDescription(data.getOptionalDescription());
		existing.setRequiredFromColId(data.getRequiredFromColId());
		existing.setRequiredToColId(data.getRequiredToColId());
		existing.setOptionalPrevId(data.getOptionalPrevId());
		existing.setOptionalNextId(data.getOptionalNextId());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return busmodel31RelationColRepository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationCol find(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31RelationColRepository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> findAll() {
		return( busmodel31RelationColRepository.findAll() );
	}

	// BusModelRelationCol specified index finders

	/**
	 *	Find an entity using the columns of the IBusModelRelationColByUNameIdxKey as arguments.
	 *
	 *		@param requiredRelationId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationCol findByUNameIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("name") String requiredName) {
		return( busmodel31RelationColRepository.findByUNameIdx(requiredRelationId,
			requiredName));
	}

	/**
	 *	IBusModelRelationColByUNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationCol findByUNameIdx(IBusModelRelationColByUNameIdxKey key) {
		return( busmodel31RelationColRepository.findByUNameIdx(key.getRequiredRelationId(), key.getRequiredName()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRelationColByRelationIdxKey as arguments.
	 *
	 *		@param requiredRelationId
	 *
	 *		@return List&lt;BusModelJpaRelationCol&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> findByRelationIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId) {
		return( busmodel31RelationColRepository.findByRelationIdx(requiredRelationId));
	}

	/**
	 *	IBusModelRelationColByRelationIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByRelationIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> findByRelationIdx(IBusModelRelationColByRelationIdxKey key) {
		return( busmodel31RelationColRepository.findByRelationIdx(key.getRequiredRelationId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRelationColByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaRelationCol&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31RelationColRepository.findByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelRelationColByDefSchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> findByDefSchemaIdx(IBusModelRelationColByDefSchemaIdxKey key) {
		return( busmodel31RelationColRepository.findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRelationColByFromColIdxKey as arguments.
	 *
	 *		@param requiredFromColId
	 *
	 *		@return List&lt;BusModelJpaRelationCol&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> findByFromColIdx(@Param("fromColId") IYCFKeyHash256 requiredFromColId) {
		return( busmodel31RelationColRepository.findByFromColIdx(requiredFromColId));
	}

	/**
	 *	IBusModelRelationColByFromColIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByFromColIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> findByFromColIdx(IBusModelRelationColByFromColIdxKey key) {
		return( busmodel31RelationColRepository.findByFromColIdx(key.getRequiredFromColId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRelationColByToColIdxKey as arguments.
	 *
	 *		@param requiredToColId
	 *
	 *		@return List&lt;BusModelJpaRelationCol&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> findByToColIdx(@Param("toColId") IYCFKeyHash256 requiredToColId) {
		return( busmodel31RelationColRepository.findByToColIdx(requiredToColId));
	}

	/**
	 *	IBusModelRelationColByToColIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByToColIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> findByToColIdx(IBusModelRelationColByToColIdxKey key) {
		return( busmodel31RelationColRepository.findByToColIdx(key.getRequiredToColId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRelationColByPrevIdxKey as arguments.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaRelationCol&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> findByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31RelationColRepository.findByPrevIdx(optionalPrevId));
	}

	/**
	 *	IBusModelRelationColByPrevIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> findByPrevIdx(IBusModelRelationColByPrevIdxKey key) {
		return( busmodel31RelationColRepository.findByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRelationColByNextIdxKey as arguments.
	 *
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaRelationCol&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> findByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31RelationColRepository.findByNextIdx(optionalNextId));
	}

	/**
	 *	IBusModelRelationColByNextIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> findByNextIdx(IBusModelRelationColByNextIdxKey key) {
		return( busmodel31RelationColRepository.findByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRelationColByRelPrevIdxKey as arguments.
	 *
	 *		@param requiredRelationId
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaRelationCol&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> findByRelPrevIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31RelationColRepository.findByRelPrevIdx(requiredRelationId,
			optionalPrevId));
	}

	/**
	 *	IBusModelRelationColByRelPrevIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByRelPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> findByRelPrevIdx(IBusModelRelationColByRelPrevIdxKey key) {
		return( busmodel31RelationColRepository.findByRelPrevIdx(key.getRequiredRelationId(), key.getOptionalPrevId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRelationColByRelNextIdxKey as arguments.
	 *
	 *		@param requiredRelationId
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaRelationCol&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> findByRelNextIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31RelationColRepository.findByRelNextIdx(requiredRelationId,
			optionalNextId));
	}

	/**
	 *	IBusModelRelationColByRelNextIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByRelNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> findByRelNextIdx(IBusModelRelationColByRelNextIdxKey key) {
		return( busmodel31RelationColRepository.findByRelNextIdx(key.getRequiredRelationId(), key.getOptionalNextId()));
	}

	// BusModelRelationCol specified lock-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationCol lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31RelationColRepository.lockByIdIdx(requiredId));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationCol lockByUNameIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("name") String requiredName) {
		return( busmodel31RelationColRepository.lockByUNameIdx(requiredRelationId,
			requiredName));
	}

	/**
	 *	IBusModelRelationColByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelationCol lockByUNameIdx(IBusModelRelationColByUNameIdxKey key) {
		return( busmodel31RelationColRepository.lockByUNameIdx(key.getRequiredRelationId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> lockByRelationIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId) {
		return( busmodel31RelationColRepository.lockByRelationIdx(requiredRelationId));
	}

	/**
	 *	IBusModelRelationColByRelationIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> lockByRelationIdx(IBusModelRelationColByRelationIdxKey key) {
		return( busmodel31RelationColRepository.lockByRelationIdx(key.getRequiredRelationId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31RelationColRepository.lockByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelRelationColByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> lockByDefSchemaIdx(IBusModelRelationColByDefSchemaIdxKey key) {
		return( busmodel31RelationColRepository.lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredFromColId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> lockByFromColIdx(@Param("fromColId") IYCFKeyHash256 requiredFromColId) {
		return( busmodel31RelationColRepository.lockByFromColIdx(requiredFromColId));
	}

	/**
	 *	IBusModelRelationColByFromColIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> lockByFromColIdx(IBusModelRelationColByFromColIdxKey key) {
		return( busmodel31RelationColRepository.lockByFromColIdx(key.getRequiredFromColId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredToColId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> lockByToColIdx(@Param("toColId") IYCFKeyHash256 requiredToColId) {
		return( busmodel31RelationColRepository.lockByToColIdx(requiredToColId));
	}

	/**
	 *	IBusModelRelationColByToColIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> lockByToColIdx(IBusModelRelationColByToColIdxKey key) {
		return( busmodel31RelationColRepository.lockByToColIdx(key.getRequiredToColId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> lockByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31RelationColRepository.lockByPrevIdx(optionalPrevId));
	}

	/**
	 *	IBusModelRelationColByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> lockByPrevIdx(IBusModelRelationColByPrevIdxKey key) {
		return( busmodel31RelationColRepository.lockByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> lockByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31RelationColRepository.lockByNextIdx(optionalNextId));
	}

	/**
	 *	IBusModelRelationColByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> lockByNextIdx(IBusModelRelationColByNextIdxKey key) {
		return( busmodel31RelationColRepository.lockByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 *		@param optionalPrevId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> lockByRelPrevIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31RelationColRepository.lockByRelPrevIdx(requiredRelationId,
			optionalPrevId));
	}

	/**
	 *	IBusModelRelationColByRelPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> lockByRelPrevIdx(IBusModelRelationColByRelPrevIdxKey key) {
		return( busmodel31RelationColRepository.lockByRelPrevIdx(key.getRequiredRelationId(), key.getOptionalPrevId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 *		@param optionalNextId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> lockByRelNextIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31RelationColRepository.lockByRelNextIdx(requiredRelationId,
			optionalNextId));
	}

	/**
	 *	IBusModelRelationColByRelNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelationCol> lockByRelNextIdx(IBusModelRelationColByRelNextIdxKey key) {
		return( busmodel31RelationColRepository.lockByRelNextIdx(key.getRequiredRelationId(), key.getOptionalNextId()));
	}

	// BusModelRelationCol specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		busmodel31RelationColRepository.deleteByIdIdx(requiredId);
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("name") String requiredName) {
		busmodel31RelationColRepository.deleteByUNameIdx(requiredRelationId,
			requiredName);
	}

	/**
	 *	IBusModelRelationColByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByUNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(IBusModelRelationColByUNameIdxKey key) {
		busmodel31RelationColRepository.deleteByUNameIdx(key.getRequiredRelationId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRelationIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId) {
		busmodel31RelationColRepository.deleteByRelationIdx(requiredRelationId);
	}

	/**
	 *	IBusModelRelationColByRelationIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByRelationIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRelationIdx(IBusModelRelationColByRelationIdxKey key) {
		busmodel31RelationColRepository.deleteByRelationIdx(key.getRequiredRelationId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		busmodel31RelationColRepository.deleteByDefSchemaIdx(optionalDefSchemaId);
	}

	/**
	 *	IBusModelRelationColByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByDefSchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(IBusModelRelationColByDefSchemaIdxKey key) {
		busmodel31RelationColRepository.deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredFromColId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByFromColIdx(@Param("fromColId") IYCFKeyHash256 requiredFromColId) {
		busmodel31RelationColRepository.deleteByFromColIdx(requiredFromColId);
	}

	/**
	 *	IBusModelRelationColByFromColIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByFromColIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByFromColIdx(IBusModelRelationColByFromColIdxKey key) {
		busmodel31RelationColRepository.deleteByFromColIdx(key.getRequiredFromColId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredToColId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByToColIdx(@Param("toColId") IYCFKeyHash256 requiredToColId) {
		busmodel31RelationColRepository.deleteByToColIdx(requiredToColId);
	}

	/**
	 *	IBusModelRelationColByToColIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByToColIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByToColIdx(IBusModelRelationColByToColIdxKey key) {
		busmodel31RelationColRepository.deleteByToColIdx(key.getRequiredToColId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		busmodel31RelationColRepository.deleteByPrevIdx(optionalPrevId);
	}

	/**
	 *	IBusModelRelationColByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByPrevIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrevIdx(IBusModelRelationColByPrevIdxKey key) {
		busmodel31RelationColRepository.deleteByPrevIdx(key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		busmodel31RelationColRepository.deleteByNextIdx(optionalNextId);
	}

	/**
	 *	IBusModelRelationColByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByNextIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNextIdx(IBusModelRelationColByNextIdxKey key) {
		busmodel31RelationColRepository.deleteByNextIdx(key.getOptionalNextId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 *		@param optionalPrevId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRelPrevIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		busmodel31RelationColRepository.deleteByRelPrevIdx(requiredRelationId,
			optionalPrevId);
	}

	/**
	 *	IBusModelRelationColByRelPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByRelPrevIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRelPrevIdx(IBusModelRelationColByRelPrevIdxKey key) {
		busmodel31RelationColRepository.deleteByRelPrevIdx(key.getRequiredRelationId(), key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredRelationId
	 *		@param optionalNextId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRelNextIdx(@Param("relationId") IYCFKeyHash256 requiredRelationId,
		@Param("nextId") IYCFKeyHash256 optionalNextId) {
		busmodel31RelationColRepository.deleteByRelNextIdx(requiredRelationId,
			optionalNextId);
	}

	/**
	 *	IBusModelRelationColByRelNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationColByRelNextIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRelNextIdx(IBusModelRelationColByRelNextIdxKey key) {
		busmodel31RelationColRepository.deleteByRelNextIdx(key.getRequiredRelationId(), key.getOptionalNextId());
	}

}
