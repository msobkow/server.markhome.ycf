// Description: Java 25 Spring JPA Service for Param

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
 *	Service for the BusModelParam entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModelParamRepository to access them.
 */
@Service("busmodel31JpaParamService")
public class BusModelJpaParamService {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaParamRepository busmodel31ParamRepository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of BusModelJpaParam, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParam create(BusModelJpaParam data) {
		final String S_ProcName = "create";
		if (data == null) {
			return( null );
		}
		IYCFKeyHash256 originalRequiredId = data.getRequiredId();
		boolean generatedRequiredId = false;
		if (data.getRequiredContainerServerMeth() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerServerMeth",
				"data.requiredContainerServerMeth",
				"ServerMethod",
				"ServerMethod",
				null);
		}
		if (data.getRequiredLookupType() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupType",
				"data.requiredLookupType",
				"Value",
				"Value",
				null);
		}
		if(data.getRequiredServerMethodId() == null || data.getRequiredServerMethodId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredServerMethodId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		try {
			if(data.getPKey() != null && !data.getPKey().isNull() && busmodel31ParamRepository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (BusModelJpaParam)(busmodel31ParamRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
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
			return busmodel31ParamRepository.save(data);
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
	public BusModelJpaParam update(BusModelJpaParam data) {
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
		if (data.getRequiredContainerServerMeth() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerServerMeth",
				"data.requiredContainerServerMeth",
				"ServerMethod",
				"ServerMethod",
				null);
		}
		if (data.getRequiredLookupType() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupType",
				"data.requiredLookupType",
				"Value",
				"Value",
				null);
		}
		if(data.getRequiredServerMethodId() == null || data.getRequiredServerMethodId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredServerMethodId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		// Ensure the entity exists and that the revision matches
		BusModelJpaParam existing = busmodel31ParamRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of BusModelParam to existing object
		existing.setRequiredContainerServerMeth(data.getRequiredContainerServerMeth());
		existing.setOptionalLookupDefSchema(data.getOptionalLookupDefSchema());
		existing.setOptionalLookupPrev(data.getOptionalLookupPrev());
		existing.setOptionalLookupNext(data.getOptionalLookupNext());
		existing.setRequiredLookupType(data.getRequiredLookupType());
		// Apply data columns of BusModelParam to existing object
		existing.setRequiredServerMethodId(data.getRequiredServerMethodId());
		existing.setOptionalDefSchemaId(data.getOptionalDefSchemaId());
		existing.setRequiredName(data.getRequiredName());
		existing.setOptionalShortDescription(data.getOptionalShortDescription());
		existing.setOptionalDescription(data.getOptionalDescription());
		existing.setRequiredIsNullable(data.getRequiredIsNullable());
		existing.setOptionalTypeId(data.getOptionalTypeId());
		existing.setOptionalPrevId(data.getOptionalPrevId());
		existing.setOptionalNextId(data.getOptionalNextId());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return busmodel31ParamRepository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParam find(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31ParamRepository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> findAll() {
		return( busmodel31ParamRepository.findAll() );
	}

	// BusModelParam specified index finders

	/**
	 *	Find an entity using the columns of the IBusModelParamByUNameIdxKey as arguments.
	 *
	 *		@param requiredServerMethodId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParam findByUNameIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("name") String requiredName) {
		return( busmodel31ParamRepository.findByUNameIdx(requiredServerMethodId,
			requiredName));
	}

	/**
	 *	IBusModelParamByUNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelParamByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParam findByUNameIdx(IBusModelParamByUNameIdxKey key) {
		return( busmodel31ParamRepository.findByUNameIdx(key.getRequiredServerMethodId(), key.getRequiredName()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelParamByServerMethodIdxKey as arguments.
	 *
	 *		@param requiredServerMethodId
	 *
	 *		@return List&lt;BusModelJpaParam&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> findByServerMethodIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId) {
		return( busmodel31ParamRepository.findByServerMethodIdx(requiredServerMethodId));
	}

	/**
	 *	IBusModelParamByServerMethodIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelParamByServerMethodIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> findByServerMethodIdx(IBusModelParamByServerMethodIdxKey key) {
		return( busmodel31ParamRepository.findByServerMethodIdx(key.getRequiredServerMethodId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelParamByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaParam&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31ParamRepository.findByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelParamByDefSchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelParamByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> findByDefSchemaIdx(IBusModelParamByDefSchemaIdxKey key) {
		return( busmodel31ParamRepository.findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelParamByServerTypeIdxKey as arguments.
	 *
	 *		@param optionalTypeId
	 *
	 *		@return List&lt;BusModelJpaParam&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> findByServerTypeIdx(@Param("typeId") IYCFKeyHash256 optionalTypeId) {
		return( busmodel31ParamRepository.findByServerTypeIdx(optionalTypeId));
	}

	/**
	 *	IBusModelParamByServerTypeIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelParamByServerTypeIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> findByServerTypeIdx(IBusModelParamByServerTypeIdxKey key) {
		return( busmodel31ParamRepository.findByServerTypeIdx(key.getOptionalTypeId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelParamByPrevIdxKey as arguments.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaParam&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> findByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31ParamRepository.findByPrevIdx(optionalPrevId));
	}

	/**
	 *	IBusModelParamByPrevIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelParamByPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> findByPrevIdx(IBusModelParamByPrevIdxKey key) {
		return( busmodel31ParamRepository.findByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelParamByNextIdxKey as arguments.
	 *
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaParam&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> findByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31ParamRepository.findByNextIdx(optionalNextId));
	}

	/**
	 *	IBusModelParamByNextIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelParamByNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> findByNextIdx(IBusModelParamByNextIdxKey key) {
		return( busmodel31ParamRepository.findByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelParamByContPrevIdxKey as arguments.
	 *
	 *		@param requiredServerMethodId
	 *		@param optionalPrevId
	 *
	 *		@return List&lt;BusModelJpaParam&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> findByContPrevIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31ParamRepository.findByContPrevIdx(requiredServerMethodId,
			optionalPrevId));
	}

	/**
	 *	IBusModelParamByContPrevIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelParamByContPrevIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> findByContPrevIdx(IBusModelParamByContPrevIdxKey key) {
		return( busmodel31ParamRepository.findByContPrevIdx(key.getRequiredServerMethodId(), key.getOptionalPrevId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelParamByContNextIdxKey as arguments.
	 *
	 *		@param requiredServerMethodId
	 *		@param optionalNextId
	 *
	 *		@return List&lt;BusModelJpaParam&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> findByContNextIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31ParamRepository.findByContNextIdx(requiredServerMethodId,
			optionalNextId));
	}

	/**
	 *	IBusModelParamByContNextIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelParamByContNextIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> findByContNextIdx(IBusModelParamByContNextIdxKey key) {
		return( busmodel31ParamRepository.findByContNextIdx(key.getRequiredServerMethodId(), key.getOptionalNextId()));
	}

	// BusModelParam specified lock-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParam lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31ParamRepository.lockByIdIdx(requiredId));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredServerMethodId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParam lockByUNameIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("name") String requiredName) {
		return( busmodel31ParamRepository.lockByUNameIdx(requiredServerMethodId,
			requiredName));
	}

	/**
	 *	IBusModelParamByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaParam lockByUNameIdx(IBusModelParamByUNameIdxKey key) {
		return( busmodel31ParamRepository.lockByUNameIdx(key.getRequiredServerMethodId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredServerMethodId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> lockByServerMethodIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId) {
		return( busmodel31ParamRepository.lockByServerMethodIdx(requiredServerMethodId));
	}

	/**
	 *	IBusModelParamByServerMethodIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> lockByServerMethodIdx(IBusModelParamByServerMethodIdxKey key) {
		return( busmodel31ParamRepository.lockByServerMethodIdx(key.getRequiredServerMethodId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31ParamRepository.lockByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelParamByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> lockByDefSchemaIdx(IBusModelParamByDefSchemaIdxKey key) {
		return( busmodel31ParamRepository.lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalTypeId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> lockByServerTypeIdx(@Param("typeId") IYCFKeyHash256 optionalTypeId) {
		return( busmodel31ParamRepository.lockByServerTypeIdx(optionalTypeId));
	}

	/**
	 *	IBusModelParamByServerTypeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> lockByServerTypeIdx(IBusModelParamByServerTypeIdxKey key) {
		return( busmodel31ParamRepository.lockByServerTypeIdx(key.getOptionalTypeId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> lockByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31ParamRepository.lockByPrevIdx(optionalPrevId));
	}

	/**
	 *	IBusModelParamByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> lockByPrevIdx(IBusModelParamByPrevIdxKey key) {
		return( busmodel31ParamRepository.lockByPrevIdx(key.getOptionalPrevId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> lockByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31ParamRepository.lockByNextIdx(optionalNextId));
	}

	/**
	 *	IBusModelParamByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> lockByNextIdx(IBusModelParamByNextIdxKey key) {
		return( busmodel31ParamRepository.lockByNextIdx(key.getOptionalNextId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredServerMethodId
	 *		@param optionalPrevId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> lockByContPrevIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		return( busmodel31ParamRepository.lockByContPrevIdx(requiredServerMethodId,
			optionalPrevId));
	}

	/**
	 *	IBusModelParamByContPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> lockByContPrevIdx(IBusModelParamByContPrevIdxKey key) {
		return( busmodel31ParamRepository.lockByContPrevIdx(key.getRequiredServerMethodId(), key.getOptionalPrevId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredServerMethodId
	 *		@param optionalNextId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> lockByContNextIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("nextId") IYCFKeyHash256 optionalNextId) {
		return( busmodel31ParamRepository.lockByContNextIdx(requiredServerMethodId,
			optionalNextId));
	}

	/**
	 *	IBusModelParamByContNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaParam> lockByContNextIdx(IBusModelParamByContNextIdxKey key) {
		return( busmodel31ParamRepository.lockByContNextIdx(key.getRequiredServerMethodId(), key.getOptionalNextId()));
	}

	// BusModelParam specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		busmodel31ParamRepository.deleteByIdIdx(requiredId);
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredServerMethodId
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("name") String requiredName) {
		busmodel31ParamRepository.deleteByUNameIdx(requiredServerMethodId,
			requiredName);
	}

	/**
	 *	IBusModelParamByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelParamByUNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(IBusModelParamByUNameIdxKey key) {
		busmodel31ParamRepository.deleteByUNameIdx(key.getRequiredServerMethodId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredServerMethodId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByServerMethodIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId) {
		busmodel31ParamRepository.deleteByServerMethodIdx(requiredServerMethodId);
	}

	/**
	 *	IBusModelParamByServerMethodIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelParamByServerMethodIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByServerMethodIdx(IBusModelParamByServerMethodIdxKey key) {
		busmodel31ParamRepository.deleteByServerMethodIdx(key.getRequiredServerMethodId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		busmodel31ParamRepository.deleteByDefSchemaIdx(optionalDefSchemaId);
	}

	/**
	 *	IBusModelParamByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelParamByDefSchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(IBusModelParamByDefSchemaIdxKey key) {
		busmodel31ParamRepository.deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalTypeId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByServerTypeIdx(@Param("typeId") IYCFKeyHash256 optionalTypeId) {
		busmodel31ParamRepository.deleteByServerTypeIdx(optionalTypeId);
	}

	/**
	 *	IBusModelParamByServerTypeIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelParamByServerTypeIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByServerTypeIdx(IBusModelParamByServerTypeIdxKey key) {
		busmodel31ParamRepository.deleteByServerTypeIdx(key.getOptionalTypeId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrevId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrevIdx(@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		busmodel31ParamRepository.deleteByPrevIdx(optionalPrevId);
	}

	/**
	 *	IBusModelParamByPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelParamByPrevIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrevIdx(IBusModelParamByPrevIdxKey key) {
		busmodel31ParamRepository.deleteByPrevIdx(key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNextId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNextIdx(@Param("nextId") IYCFKeyHash256 optionalNextId) {
		busmodel31ParamRepository.deleteByNextIdx(optionalNextId);
	}

	/**
	 *	IBusModelParamByNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelParamByNextIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNextIdx(IBusModelParamByNextIdxKey key) {
		busmodel31ParamRepository.deleteByNextIdx(key.getOptionalNextId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredServerMethodId
	 *		@param optionalPrevId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByContPrevIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("prevId") IYCFKeyHash256 optionalPrevId) {
		busmodel31ParamRepository.deleteByContPrevIdx(requiredServerMethodId,
			optionalPrevId);
	}

	/**
	 *	IBusModelParamByContPrevIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelParamByContPrevIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByContPrevIdx(IBusModelParamByContPrevIdxKey key) {
		busmodel31ParamRepository.deleteByContPrevIdx(key.getRequiredServerMethodId(), key.getOptionalPrevId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredServerMethodId
	 *		@param optionalNextId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByContNextIdx(@Param("serverMethodId") IYCFKeyHash256 requiredServerMethodId,
		@Param("nextId") IYCFKeyHash256 optionalNextId) {
		busmodel31ParamRepository.deleteByContNextIdx(requiredServerMethodId,
			optionalNextId);
	}

	/**
	 *	IBusModelParamByContNextIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelParamByContNextIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByContNextIdx(IBusModelParamByContNextIdxKey key) {
		busmodel31ParamRepository.deleteByContNextIdx(key.getRequiredServerMethodId(), key.getOptionalNextId());
	}

}
