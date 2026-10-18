// Description: Java 25 Spring JPA Service for ServerObjFunc

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
 *	Service for the BusModelServerObjFunc entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModelServerObjFuncRepository to access them.
 */
@Service("busmodel31JpaServerObjFuncService")
public class BusModelJpaServerObjFuncService {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaServerObjFuncRepository busmodel31ServerObjFuncRepository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of BusModelJpaServerObjFunc, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaServerObjFunc create(BusModelJpaServerObjFunc data) {
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
		if (data.getRequiredContainerForTable() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerForTable",
				"data.requiredContainerForTable",
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
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredCodeVis() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredCodeVis");
		}
		if(data.getRequiredJMethodBody() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredJMethodBody");
		}
		if(data.getRequiredCppMethodBody() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredCppMethodBody");
		}
		if(data.getRequiredCsMethodBody() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredCsMethodBody");
		}
		try {
			if(data.getPKey() != null && !data.getPKey().isNull() && busmodel31ServerObjFuncRepository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (BusModelJpaServerObjFunc)(busmodel31ServerObjFuncRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
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
			return busmodel31ServerObjFuncRepository.save(data);
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
	public BusModelJpaServerObjFunc update(BusModelJpaServerObjFunc data) {
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
		if (data.getRequiredContainerForTable() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerForTable",
				"data.requiredContainerForTable",
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
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredCodeVis() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredCodeVis");
		}
		if(data.getRequiredJMethodBody() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredJMethodBody");
		}
		if(data.getRequiredCppMethodBody() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredCppMethodBody");
		}
		if(data.getRequiredCsMethodBody() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredCsMethodBody");
		}
		// Ensure the entity exists and that the revision matches
		BusModelJpaServerObjFunc existing = busmodel31ServerObjFuncRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of BusModelScope to existing object
		existing.setRequiredOwnerTenant(data.getRequiredTenantId());
		// Apply data columns of BusModelScope to existing object
		existing.setRequiredTenantId(data.getRequiredTenantId());
		// Apply superior data relationships of BusModelServerMethod to existing object
		existing.setOptionalLookupDefSchema(data.getOptionalLookupDefSchema());
		existing.setRequiredContainerForTable(data.getRequiredContainerForTable());
		// Apply data columns of BusModelServerMethod to existing object
		existing.setRequiredTableId(data.getRequiredTableId());
		existing.setOptionalDefSchemaId(data.getOptionalDefSchemaId());
		existing.setRequiredName(data.getRequiredName());
		existing.setOptionalShortName(data.getOptionalShortName());
		existing.setOptionalLabel(data.getOptionalLabel());
		existing.setOptionalShortDescription(data.getOptionalShortDescription());
		existing.setOptionalDescription(data.getOptionalDescription());
		existing.setOptionalSuffix(data.getOptionalSuffix());
		existing.setRequiredIsInstanceMethod(data.getRequiredIsInstanceMethod());
		existing.setRequiredIsServerOnly(data.getRequiredIsServerOnly());
		existing.setRequiredCodeVis(data.getRequiredCodeVis());
		existing.setRequiredJMethodBody(data.getRequiredJMethodBody());
		existing.setRequiredCppMethodBody(data.getRequiredCppMethodBody());
		existing.setRequiredCsMethodBody(data.getRequiredCsMethodBody());
		// Apply superior data relationships of BusModelServerObjFunc to existing object
		existing.setOptionalLookupRetTable(data.getOptionalLookupRetTable());
		// Apply data columns of BusModelServerObjFunc to existing object
		existing.setOptionalRetTableId(data.getOptionalRetTableId());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return busmodel31ServerObjFuncRepository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaServerObjFunc find(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31ServerObjFuncRepository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> findAll() {
		return( busmodel31ServerObjFuncRepository.findAll() );
	}

	// BusModelScope specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelScopeByTenantIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;BusModelJpaServerObjFunc&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> findByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31ServerObjFuncRepository.findByTenantIdx(requiredTenantId));
	}

	/**
	 *	IBusModelScopeByTenantIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelScopeByTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> findByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( busmodel31ServerObjFuncRepository.findByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelServerMethod specified index finders

	/**
	 *	Find an entity using the columns of the IBusModelServerMethodByUNameIdxKey as arguments.
	 *
	 *		@param requiredTableId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaServerObjFunc findByUNameIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("name") String requiredName) {
		return( busmodel31ServerObjFuncRepository.findByUNameIdx(requiredTableId,
			requiredName));
	}

	/**
	 *	IBusModelServerMethodByUNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelServerMethodByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaServerObjFunc findByUNameIdx(IBusModelServerMethodByUNameIdxKey key) {
		return( busmodel31ServerObjFuncRepository.findByUNameIdx(key.getRequiredTableId(), key.getRequiredName()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelServerMethodByMethTableIdxKey as arguments.
	 *
	 *		@param requiredTableId
	 *
	 *		@return List&lt;BusModelJpaServerObjFunc&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> findByMethTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId) {
		return( busmodel31ServerObjFuncRepository.findByMethTableIdx(requiredTableId));
	}

	/**
	 *	IBusModelServerMethodByMethTableIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelServerMethodByMethTableIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> findByMethTableIdx(IBusModelServerMethodByMethTableIdxKey key) {
		return( busmodel31ServerObjFuncRepository.findByMethTableIdx(key.getRequiredTableId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelServerMethodByMethCodeVisIdxKey as arguments.
	 *
	 *		@param requiredCodeVis
	 *
	 *		@return List&lt;BusModelJpaServerObjFunc&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> findByMethCodeVisIdx(@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		return( busmodel31ServerObjFuncRepository.findByMethCodeVisIdx(requiredCodeVis));
	}

	/**
	 *	IBusModelServerMethodByMethCodeVisIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelServerMethodByMethCodeVisIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> findByMethCodeVisIdx(IBusModelServerMethodByMethCodeVisIdxKey key) {
		return( busmodel31ServerObjFuncRepository.findByMethCodeVisIdx(key.getRequiredCodeVis()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelServerMethodByMethTableVisIdxKey as arguments.
	 *
	 *		@param requiredTableId
	 *		@param requiredCodeVis
	 *
	 *		@return List&lt;BusModelJpaServerObjFunc&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> findByMethTableVisIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		return( busmodel31ServerObjFuncRepository.findByMethTableVisIdx(requiredTableId,
			requiredCodeVis));
	}

	/**
	 *	IBusModelServerMethodByMethTableVisIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelServerMethodByMethTableVisIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> findByMethTableVisIdx(IBusModelServerMethodByMethTableVisIdxKey key) {
		return( busmodel31ServerObjFuncRepository.findByMethTableVisIdx(key.getRequiredTableId(), key.getRequiredCodeVis()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelServerMethodByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaServerObjFunc&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31ServerObjFuncRepository.findByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelServerMethodByDefSchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelServerMethodByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> findByDefSchemaIdx(IBusModelServerMethodByDefSchemaIdxKey key) {
		return( busmodel31ServerObjFuncRepository.findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	// BusModelServerObjFunc specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelServerObjFuncByRetTblIdxKey as arguments.
	 *
	 *		@param optionalRetTableId
	 *
	 *		@return List&lt;BusModelJpaServerObjFunc&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> findByRetTblIdx(@Param("retTableId") IYCFKeyHash256 optionalRetTableId) {
		return( busmodel31ServerObjFuncRepository.findByRetTblIdx(optionalRetTableId));
	}

	/**
	 *	IBusModelServerObjFuncByRetTblIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelServerObjFuncByRetTblIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> findByRetTblIdx(IBusModelServerObjFuncByRetTblIdxKey key) {
		return( busmodel31ServerObjFuncRepository.findByRetTblIdx(key.getOptionalRetTableId()));
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
	public BusModelJpaServerObjFunc lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31ServerObjFuncRepository.lockByIdIdx(requiredId));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> lockByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31ServerObjFuncRepository.lockByTenantIdx(requiredTenantId));
	}

	/**
	 *	IBusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> lockByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( busmodel31ServerObjFuncRepository.lockByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelServerMethod specified lock-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaServerObjFunc lockByUNameIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("name") String requiredName) {
		return( busmodel31ServerObjFuncRepository.lockByUNameIdx(requiredTableId,
			requiredName));
	}

	/**
	 *	IBusModelServerMethodByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaServerObjFunc lockByUNameIdx(IBusModelServerMethodByUNameIdxKey key) {
		return( busmodel31ServerObjFuncRepository.lockByUNameIdx(key.getRequiredTableId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> lockByMethTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId) {
		return( busmodel31ServerObjFuncRepository.lockByMethTableIdx(requiredTableId));
	}

	/**
	 *	IBusModelServerMethodByMethTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> lockByMethTableIdx(IBusModelServerMethodByMethTableIdxKey key) {
		return( busmodel31ServerObjFuncRepository.lockByMethTableIdx(key.getRequiredTableId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCodeVis
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> lockByMethCodeVisIdx(@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		return( busmodel31ServerObjFuncRepository.lockByMethCodeVisIdx(requiredCodeVis));
	}

	/**
	 *	IBusModelServerMethodByMethCodeVisIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> lockByMethCodeVisIdx(IBusModelServerMethodByMethCodeVisIdxKey key) {
		return( busmodel31ServerObjFuncRepository.lockByMethCodeVisIdx(key.getRequiredCodeVis()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *		@param requiredCodeVis
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> lockByMethTableVisIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		return( busmodel31ServerObjFuncRepository.lockByMethTableVisIdx(requiredTableId,
			requiredCodeVis));
	}

	/**
	 *	IBusModelServerMethodByMethTableVisIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> lockByMethTableVisIdx(IBusModelServerMethodByMethTableVisIdxKey key) {
		return( busmodel31ServerObjFuncRepository.lockByMethTableVisIdx(key.getRequiredTableId(), key.getRequiredCodeVis()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31ServerObjFuncRepository.lockByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelServerMethodByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> lockByDefSchemaIdx(IBusModelServerMethodByDefSchemaIdxKey key) {
		return( busmodel31ServerObjFuncRepository.lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	// BusModelServerObjFunc specified lock-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalRetTableId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> lockByRetTblIdx(@Param("retTableId") IYCFKeyHash256 optionalRetTableId) {
		return( busmodel31ServerObjFuncRepository.lockByRetTblIdx(optionalRetTableId));
	}

	/**
	 *	IBusModelServerObjFuncByRetTblIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaServerObjFunc> lockByRetTblIdx(IBusModelServerObjFuncByRetTblIdxKey key) {
		return( busmodel31ServerObjFuncRepository.lockByRetTblIdx(key.getOptionalRetTableId()));
	}

	// BusModelScope specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		busmodel31ServerObjFuncRepository.deleteByIdIdx(requiredId);
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		busmodel31ServerObjFuncRepository.deleteByTenantIdx(requiredTenantId);
	}

	/**
	 *	IBusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelScopeByTenantIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		busmodel31ServerObjFuncRepository.deleteByTenantIdx(key.getRequiredTenantId());
	}

	// BusModelServerMethod specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("name") String requiredName) {
		busmodel31ServerObjFuncRepository.deleteByUNameIdx(requiredTableId,
			requiredName);
	}

	/**
	 *	IBusModelServerMethodByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelServerMethodByUNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(IBusModelServerMethodByUNameIdxKey key) {
		busmodel31ServerObjFuncRepository.deleteByUNameIdx(key.getRequiredTableId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByMethTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId) {
		busmodel31ServerObjFuncRepository.deleteByMethTableIdx(requiredTableId);
	}

	/**
	 *	IBusModelServerMethodByMethTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelServerMethodByMethTableIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByMethTableIdx(IBusModelServerMethodByMethTableIdxKey key) {
		busmodel31ServerObjFuncRepository.deleteByMethTableIdx(key.getRequiredTableId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCodeVis
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByMethCodeVisIdx(@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		busmodel31ServerObjFuncRepository.deleteByMethCodeVisIdx(requiredCodeVis);
	}

	/**
	 *	IBusModelServerMethodByMethCodeVisIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelServerMethodByMethCodeVisIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByMethCodeVisIdx(IBusModelServerMethodByMethCodeVisIdxKey key) {
		busmodel31ServerObjFuncRepository.deleteByMethCodeVisIdx(key.getRequiredCodeVis());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *		@param requiredCodeVis
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByMethTableVisIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		busmodel31ServerObjFuncRepository.deleteByMethTableVisIdx(requiredTableId,
			requiredCodeVis);
	}

	/**
	 *	IBusModelServerMethodByMethTableVisIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelServerMethodByMethTableVisIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByMethTableVisIdx(IBusModelServerMethodByMethTableVisIdxKey key) {
		busmodel31ServerObjFuncRepository.deleteByMethTableVisIdx(key.getRequiredTableId(), key.getRequiredCodeVis());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		busmodel31ServerObjFuncRepository.deleteByDefSchemaIdx(optionalDefSchemaId);
	}

	/**
	 *	IBusModelServerMethodByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelServerMethodByDefSchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(IBusModelServerMethodByDefSchemaIdxKey key) {
		busmodel31ServerObjFuncRepository.deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	// BusModelServerObjFunc specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalRetTableId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRetTblIdx(@Param("retTableId") IYCFKeyHash256 optionalRetTableId) {
		busmodel31ServerObjFuncRepository.deleteByRetTblIdx(optionalRetTableId);
	}

	/**
	 *	IBusModelServerObjFuncByRetTblIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelServerObjFuncByRetTblIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRetTblIdx(IBusModelServerObjFuncByRetTblIdxKey key) {
		busmodel31ServerObjFuncRepository.deleteByRetTblIdx(key.getOptionalRetTableId());
	}

}
