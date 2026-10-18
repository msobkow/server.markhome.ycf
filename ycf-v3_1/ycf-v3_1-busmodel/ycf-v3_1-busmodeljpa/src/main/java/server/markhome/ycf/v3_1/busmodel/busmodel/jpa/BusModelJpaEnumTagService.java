// Description: Java 25 Spring JPA Service for EnumTag

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
 *	Service for the BusModelEnumTag entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModelEnumTagRepository to access them.
 */
@Service("busmodel31JpaEnumTagService")
public class BusModelJpaEnumTagService {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaEnumTagRepository busmodel31EnumTagRepository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of BusModelJpaEnumTag, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaEnumTag create(BusModelJpaEnumTag data) {
		final String S_ProcName = "create";
		if (data == null) {
			return( null );
		}
		IYCFKeyHash256 originalRequiredId = data.getRequiredId();
		boolean generatedRequiredId = false;
		if (data.getRequiredContainerEnumDef() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerEnumDef",
				"data.requiredContainerEnumDef",
				"EnumDef",
				"EnumDef",
				null);
		}
		if(data.getRequiredEnumId() == null || data.getRequiredEnumId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredEnumId");
		}
		if( data.getOptionalEnumCode() != null && data.getOptionalEnumCode().compareTo(IBusModelEnumTag.ENUMCODE_MIN_VALUE) < 0) {
			throw new YCFArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"getOptionalEnumCode()",
				data.getOptionalEnumCode(),
				IBusModelEnumTag.ENUMCODE_MIN_VALUE );
		}
		if( data.getOptionalEnumCode() != null && data.getOptionalEnumCode().compareTo(IBusModelEnumTag.ENUMCODE_MAX_VALUE) > 0) {
			throw new YCFArgumentOverflowException( getClass(),
				S_ProcName,
				0,
				"getOptionalEnumCode()",
				data.getOptionalEnumCode(),
				IBusModelEnumTag.ENUMCODE_MAX_VALUE );
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		try {
			if(data.getPKey() != null && !data.getPKey().isNull() && busmodel31EnumTagRepository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (BusModelJpaEnumTag)(busmodel31EnumTagRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
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
			return busmodel31EnumTagRepository.save(data);
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
	public BusModelJpaEnumTag update(BusModelJpaEnumTag data) {
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
		if (data.getRequiredContainerEnumDef() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerEnumDef",
				"data.requiredContainerEnumDef",
				"EnumDef",
				"EnumDef",
				null);
		}
		if(data.getRequiredEnumId() == null || data.getRequiredEnumId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredEnumId");
		}
		if( data.getOptionalEnumCode() != null && data.getOptionalEnumCode().compareTo(IBusModelEnumTag.ENUMCODE_MIN_VALUE) < 0) {
			throw new YCFArgumentUnderflowException( getClass(),
				S_ProcName,
				0,
				"getOptionalEnumCode()",
				data.getOptionalEnumCode(),
				IBusModelEnumTag.ENUMCODE_MIN_VALUE );
		}
		if( data.getOptionalEnumCode() != null && data.getOptionalEnumCode().compareTo(IBusModelEnumTag.ENUMCODE_MAX_VALUE) > 0) {
			throw new YCFArgumentOverflowException( getClass(),
				S_ProcName,
				0,
				"getOptionalEnumCode()",
				data.getOptionalEnumCode(),
				IBusModelEnumTag.ENUMCODE_MAX_VALUE );
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		// Ensure the entity exists and that the revision matches
		BusModelJpaEnumTag existing = busmodel31EnumTagRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of BusModelEnumTag to existing object
		existing.setRequiredContainerEnumDef(data.getRequiredContainerEnumDef());
		existing.setOptionalLookupDefSchema(data.getOptionalLookupDefSchema());
		existing.setOptionalLookupPrev(data.getOptionalLookupPrev());
		existing.setOptionalLookupNext(data.getOptionalLookupNext());
		// Apply data columns of BusModelEnumTag to existing object
		existing.setOptionalDefSchemaId(data.getOptionalDefSchemaId());
		existing.setRequiredEnumId(data.getRequiredEnumId());
		existing.setOptionalEnumCode(data.getOptionalEnumCode());
		existing.setRequiredName(data.getRequiredName());
		existing.setOptionalPrevId(data.getOptionalPrevId());
		existing.setOptionalNextId(data.getOptionalNextId());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return busmodel31EnumTagRepository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaEnumTag find(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31EnumTagRepository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaEnumTag> findAll() {
		return( busmodel31EnumTagRepository.findAll() );
	}

	// BusModelEnumTag specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelEnumTagByEnumIdxKey as arguments.
	 *
	 *		@param requiredEnumId
	 *
	 *		@return List&lt;BusModelJpaEnumTag&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaEnumTag> findByEnumIdx(@Param("enumId") IYCFKeyHash256 requiredEnumId) {
		return( busmodel31EnumTagRepository.findByEnumIdx(requiredEnumId));
	}

	/**
	 *	IBusModelEnumTagByEnumIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelEnumTagByEnumIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaEnumTag> findByEnumIdx(IBusModelEnumTagByEnumIdxKey key) {
		return( busmodel31EnumTagRepository.findByEnumIdx(key.getRequiredEnumId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelEnumTagByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaEnumTag&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaEnumTag> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31EnumTagRepository.findByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelEnumTagByDefSchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelEnumTagByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaEnumTag> findByDefSchemaIdx(IBusModelEnumTagByDefSchemaIdxKey key) {
		return( busmodel31EnumTagRepository.findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Find an entity using the columns of the IBusModelEnumTagByEnumNameIdxKey as arguments.
	 *
	 *		@param requiredEnumId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaEnumTag findByEnumNameIdx(@Param("enumId") IYCFKeyHash256 requiredEnumId,
		@Param("name") String requiredName) {
		return( busmodel31EnumTagRepository.findByEnumNameIdx(requiredEnumId,
			requiredName));
	}

	/**
	 *	IBusModelEnumTagByEnumNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelEnumTagByEnumNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaEnumTag findByEnumNameIdx(IBusModelEnumTagByEnumNameIdxKey key) {
		return( busmodel31EnumTagRepository.findByEnumNameIdx(key.getRequiredEnumId(), key.getRequiredName()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelEnumTagByPrevIdxKey as arguments.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaEnumTag&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaEnumTag> findByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31EnumTagRepository.findByPrevIdx(optionalPrevId));
	}

	/**
	 *	IBusModelEnumTagByPrevIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelEnumTagByPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaEnumTag> findByPrevIdx(IBusModelEnumTagByPrevIdxKey key) {
		return( busmodel31EnumTagRepository.findByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelEnumTagByNextIdxKey as arguments.
	 *
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaEnumTag&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaEnumTag> findByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31EnumTagRepository.findByNextIdx(optionalNextId));
	}

	/**
	 *	IBusModelEnumTagByNextIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelEnumTagByNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaEnumTag> findByNextIdx(IBusModelEnumTagByNextIdxKey key) {
		return( busmodel31EnumTagRepository.findByNextIdx(key.getOptionalNextId()));
	}

	// BusModelEnumTag specified lock-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaEnumTag lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31EnumTagRepository.lockByIdIdx(requiredId));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredEnumId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaEnumTag> lockByEnumIdx(@Param("enumId") IYCFKeyHash256 requiredEnumId) {
		return( busmodel31EnumTagRepository.lockByEnumIdx(requiredEnumId));
	}

	/**
	 *	IBusModelEnumTagByEnumIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaEnumTag> lockByEnumIdx(IBusModelEnumTagByEnumIdxKey key) {
		return( busmodel31EnumTagRepository.lockByEnumIdx(key.getRequiredEnumId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaEnumTag> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31EnumTagRepository.lockByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelEnumTagByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaEnumTag> lockByDefSchemaIdx(IBusModelEnumTagByDefSchemaIdxKey key) {
		return( busmodel31EnumTagRepository.lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredEnumId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaEnumTag lockByEnumNameIdx(@Param("enumId") IYCFKeyHash256 requiredEnumId,
		@Param("name") String requiredName) {
		return( busmodel31EnumTagRepository.lockByEnumNameIdx(requiredEnumId,
			requiredName));
	}

	/**
	 *	IBusModelEnumTagByEnumNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaEnumTag lockByEnumNameIdx(IBusModelEnumTagByEnumNameIdxKey key) {
		return( busmodel31EnumTagRepository.lockByEnumNameIdx(key.getRequiredEnumId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaEnumTag> lockByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31EnumTagRepository.lockByPrevIdx(optionalPrevId));
	}

	/**
	 *	IBusModelEnumTagByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaEnumTag> lockByPrevIdx(IBusModelEnumTagByPrevIdxKey key) {
		return( busmodel31EnumTagRepository.lockByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaEnumTag> lockByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31EnumTagRepository.lockByNextIdx(optionalNextId));
	}

	/**
	 *	IBusModelEnumTagByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaEnumTag> lockByNextIdx(IBusModelEnumTagByNextIdxKey key) {
		return( busmodel31EnumTagRepository.lockByNextIdx(key.getOptionalNextId()));
	}

	// BusModelEnumTag specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		busmodel31EnumTagRepository.deleteByIdIdx(requiredId);
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredEnumId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByEnumIdx(@Param("enumId") IYCFKeyHash256 requiredEnumId) {
		busmodel31EnumTagRepository.deleteByEnumIdx(requiredEnumId);
	}

	/**
	 *	IBusModelEnumTagByEnumIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelEnumTagByEnumIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByEnumIdx(IBusModelEnumTagByEnumIdxKey key) {
		busmodel31EnumTagRepository.deleteByEnumIdx(key.getRequiredEnumId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		busmodel31EnumTagRepository.deleteByDefSchemaIdx(optionalDefSchemaId);
	}

	/**
	 *	IBusModelEnumTagByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelEnumTagByDefSchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(IBusModelEnumTagByDefSchemaIdxKey key) {
		busmodel31EnumTagRepository.deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredEnumId
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByEnumNameIdx(@Param("enumId") IYCFKeyHash256 requiredEnumId,
		@Param("name") String requiredName) {
		busmodel31EnumTagRepository.deleteByEnumNameIdx(requiredEnumId,
			requiredName);
	}

	/**
	 *	IBusModelEnumTagByEnumNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelEnumTagByEnumNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByEnumNameIdx(IBusModelEnumTagByEnumNameIdxKey key) {
		busmodel31EnumTagRepository.deleteByEnumNameIdx(key.getRequiredEnumId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		busmodel31EnumTagRepository.deleteByPrevIdx(optionalPrevId);
	}

	/**
	 *	IBusModelEnumTagByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelEnumTagByPrevIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrevIdx(IBusModelEnumTagByPrevIdxKey key) {
		busmodel31EnumTagRepository.deleteByPrevIdx(key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		busmodel31EnumTagRepository.deleteByNextIdx(optionalNextId);
	}

	/**
	 *	IBusModelEnumTagByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelEnumTagByNextIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNextIdx(IBusModelEnumTagByNextIdxKey key) {
		busmodel31EnumTagRepository.deleteByNextIdx(key.getOptionalNextId());
	}

}
