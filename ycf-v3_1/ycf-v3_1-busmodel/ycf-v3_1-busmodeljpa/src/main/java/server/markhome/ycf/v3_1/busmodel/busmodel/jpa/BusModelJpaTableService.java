// Description: Java 25 Spring JPA Service for Table

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
 *	Service for the BusModelTable entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModelTableRepository to access them.
 */
@Service("busmodel31JpaTableService")
public class BusModelJpaTableService {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaTableRepository busmodel31TableRepository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of BusModelJpaTable, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTable create(BusModelJpaTable data) {
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
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredTableClassCode() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredTableClassCode");
		}
		if(data.getRequiredLoaderBehaviour() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredLoaderBehaviour");
		}
		if(data.getRequiredSecScope() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredSecScope");
		}
		if(data.getRequiredCodeVis() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredCodeVis");
		}
		try {
			if(data.getPKey() != null && !data.getPKey().isNull() && busmodel31TableRepository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (BusModelJpaTable)(busmodel31TableRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
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
			return busmodel31TableRepository.save(data);
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
	public BusModelJpaTable update(BusModelJpaTable data) {
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
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredTableClassCode() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredTableClassCode");
		}
		if(data.getRequiredLoaderBehaviour() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredLoaderBehaviour");
		}
		if(data.getRequiredSecScope() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredSecScope");
		}
		if(data.getRequiredCodeVis() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredCodeVis");
		}
		// Ensure the entity exists and that the revision matches
		BusModelJpaTable existing = busmodel31TableRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of BusModelScope to existing object
		existing.setRequiredOwnerTenant(data.getRequiredTenantId());
		// Apply data columns of BusModelScope to existing object
		existing.setRequiredTenantId(data.getRequiredTenantId());
		// Apply superior data relationships of BusModelTable to existing object
		existing.setRequiredContainerSchemaDef(data.getRequiredContainerSchemaDef());
		existing.setOptionalLookupDefSchema(data.getOptionalLookupDefSchema());
		existing.setOptionalLookupLookupIndex(data.getOptionalLookupLookupIndex());
		existing.setOptionalLookupAltIndex(data.getOptionalLookupAltIndex());
		existing.setOptionalLookupQualTable(data.getOptionalLookupQualTable());
		existing.setOptionalLookupPrimaryIndex(data.getOptionalLookupPrimaryIndex());
		// Apply data columns of BusModelTable to existing object
		existing.setRequiredSchemaDefId(data.getRequiredSchemaDefId());
		existing.setOptionalDefSchemaId(data.getOptionalDefSchemaId());
		existing.setRequiredName(data.getRequiredName());
		existing.setOptionalDbName(data.getOptionalDbName());
		existing.setOptionalShortName(data.getOptionalShortName());
		existing.setOptionalLabel(data.getOptionalLabel());
		existing.setOptionalShortDescription(data.getOptionalShortDescription());
		existing.setOptionalDescription(data.getOptionalDescription());
		existing.setRequiredPageData(data.getRequiredPageData());
		existing.setOptionalPrimaryIndexId(data.getOptionalPrimaryIndexId());
		existing.setRequiredTableClassCode(data.getRequiredTableClassCode());
		existing.setOptionalLookupIndexId(data.getOptionalLookupIndexId());
		existing.setOptionalAltIndexId(data.getOptionalAltIndexId());
		existing.setOptionalQualifyingTableId(data.getOptionalQualifyingTableId());
		existing.setRequiredIsInstantiable(data.getRequiredIsInstantiable());
		existing.setRequiredHasHistory(data.getRequiredHasHistory());
		existing.setRequiredHasAuditColumns(data.getRequiredHasAuditColumns());
		existing.setRequiredIsMutable(data.getRequiredIsMutable());
		existing.setRequiredIsServerOnly(data.getRequiredIsServerOnly());
		existing.setRequiredLoaderBehaviour(data.getRequiredLoaderBehaviour());
		existing.setRequiredSecScope(data.getRequiredSecScope());
		existing.setRequiredCodeVis(data.getRequiredCodeVis());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return busmodel31TableRepository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTable find(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31TableRepository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findAll() {
		return( busmodel31TableRepository.findAll() );
	}

	// BusModelScope specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelScopeByTenantIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31TableRepository.findByTenantIdx(requiredTenantId));
	}

	/**
	 *	IBusModelScopeByTenantIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelScopeByTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( busmodel31TableRepository.findByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelTable specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelTableBySchemaDefIdxKey as arguments.
	 *
	 *		@param requiredSchemaDefId
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findBySchemaDefIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId) {
		return( busmodel31TableRepository.findBySchemaDefIdx(requiredSchemaDefId));
	}

	/**
	 *	IBusModelTableBySchemaDefIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTableBySchemaDefIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findBySchemaDefIdx(IBusModelTableBySchemaDefIdxKey key) {
		return( busmodel31TableRepository.findBySchemaDefIdx(key.getRequiredSchemaDefId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelTableByCodeVisIdxKey as arguments.
	 *
	 *		@param requiredCodeVis
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findByCodeVisIdx(@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		return( busmodel31TableRepository.findByCodeVisIdx(requiredCodeVis));
	}

	/**
	 *	IBusModelTableByCodeVisIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTableByCodeVisIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findByCodeVisIdx(IBusModelTableByCodeVisIdxKey key) {
		return( busmodel31TableRepository.findByCodeVisIdx(key.getRequiredCodeVis()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelTableBySchemaCodeVisIdxKey as arguments.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredCodeVis
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findBySchemaCodeVisIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		return( busmodel31TableRepository.findBySchemaCodeVisIdx(requiredSchemaDefId,
			requiredCodeVis));
	}

	/**
	 *	IBusModelTableBySchemaCodeVisIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTableBySchemaCodeVisIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findBySchemaCodeVisIdx(IBusModelTableBySchemaCodeVisIdxKey key) {
		return( busmodel31TableRepository.findBySchemaCodeVisIdx(key.getRequiredSchemaDefId(), key.getRequiredCodeVis()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelTableByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31TableRepository.findByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelTableByDefSchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTableByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findByDefSchemaIdx(IBusModelTableByDefSchemaIdxKey key) {
		return( busmodel31TableRepository.findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Find an entity using the columns of the IBusModelTableByUNameIdxKey as arguments.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTable findByUNameIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("name") String requiredName) {
		return( busmodel31TableRepository.findByUNameIdx(requiredSchemaDefId,
			requiredName));
	}

	/**
	 *	IBusModelTableByUNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTableByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTable findByUNameIdx(IBusModelTableByUNameIdxKey key) {
		return( busmodel31TableRepository.findByUNameIdx(key.getRequiredSchemaDefId(), key.getRequiredName()));
	}

	/**
	 *	Find an entity using the columns of the IBusModelTableBySchemaCdIdxKey as arguments.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredTableClassCode
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTable findBySchemaCdIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("tableClassCode") String requiredTableClassCode) {
		return( busmodel31TableRepository.findBySchemaCdIdx(requiredSchemaDefId,
			requiredTableClassCode));
	}

	/**
	 *	IBusModelTableBySchemaCdIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTableBySchemaCdIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTable findBySchemaCdIdx(IBusModelTableBySchemaCdIdxKey key) {
		return( busmodel31TableRepository.findBySchemaCdIdx(key.getRequiredSchemaDefId(), key.getRequiredTableClassCode()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelTableByPrimaryIndexIdxKey as arguments.
	 *
	 *		@param optionalPrimaryIndexId
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findByPrimaryIndexIdx(@Param("primaryIndexId") IYCFKeyHash256 optionalPrimaryIndexId) {
		return( busmodel31TableRepository.findByPrimaryIndexIdx(optionalPrimaryIndexId));
	}

	/**
	 *	IBusModelTableByPrimaryIndexIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTableByPrimaryIndexIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findByPrimaryIndexIdx(IBusModelTableByPrimaryIndexIdxKey key) {
		return( busmodel31TableRepository.findByPrimaryIndexIdx(key.getOptionalPrimaryIndexId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelTableByLookupIndexIdxKey as arguments.
	 *
	 *		@param optionalLookupIndexId
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findByLookupIndexIdx(@Param("lookupIndexId") IYCFKeyHash256 optionalLookupIndexId) {
		return( busmodel31TableRepository.findByLookupIndexIdx(optionalLookupIndexId));
	}

	/**
	 *	IBusModelTableByLookupIndexIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTableByLookupIndexIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findByLookupIndexIdx(IBusModelTableByLookupIndexIdxKey key) {
		return( busmodel31TableRepository.findByLookupIndexIdx(key.getOptionalLookupIndexId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelTableByAltIndexIdxKey as arguments.
	 *
	 *		@param optionalAltIndexId
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findByAltIndexIdx(@Param("altIndexId") IYCFKeyHash256 optionalAltIndexId) {
		return( busmodel31TableRepository.findByAltIndexIdx(optionalAltIndexId));
	}

	/**
	 *	IBusModelTableByAltIndexIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTableByAltIndexIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findByAltIndexIdx(IBusModelTableByAltIndexIdxKey key) {
		return( busmodel31TableRepository.findByAltIndexIdx(key.getOptionalAltIndexId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelTableByQualTableIdxKey as arguments.
	 *
	 *		@param optionalQualifyingTableId
	 *
	 *		@return List&lt;BusModelJpaTable&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findByQualTableIdx(@Param("qualifyingTableId") IYCFKeyHash256 optionalQualifyingTableId) {
		return( busmodel31TableRepository.findByQualTableIdx(optionalQualifyingTableId));
	}

	/**
	 *	IBusModelTableByQualTableIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelTableByQualTableIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> findByQualTableIdx(IBusModelTableByQualTableIdxKey key) {
		return( busmodel31TableRepository.findByQualTableIdx(key.getOptionalQualifyingTableId()));
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
	public BusModelJpaTable lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31TableRepository.lockByIdIdx(requiredId));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31TableRepository.lockByTenantIdx(requiredTenantId));
	}

	/**
	 *	IBusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( busmodel31TableRepository.lockByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelTable specified lock-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockBySchemaDefIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId) {
		return( busmodel31TableRepository.lockBySchemaDefIdx(requiredSchemaDefId));
	}

	/**
	 *	IBusModelTableBySchemaDefIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockBySchemaDefIdx(IBusModelTableBySchemaDefIdxKey key) {
		return( busmodel31TableRepository.lockBySchemaDefIdx(key.getRequiredSchemaDefId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCodeVis
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockByCodeVisIdx(@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		return( busmodel31TableRepository.lockByCodeVisIdx(requiredCodeVis));
	}

	/**
	 *	IBusModelTableByCodeVisIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockByCodeVisIdx(IBusModelTableByCodeVisIdxKey key) {
		return( busmodel31TableRepository.lockByCodeVisIdx(key.getRequiredCodeVis()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredCodeVis
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockBySchemaCodeVisIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		return( busmodel31TableRepository.lockBySchemaCodeVisIdx(requiredSchemaDefId,
			requiredCodeVis));
	}

	/**
	 *	IBusModelTableBySchemaCodeVisIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockBySchemaCodeVisIdx(IBusModelTableBySchemaCodeVisIdxKey key) {
		return( busmodel31TableRepository.lockBySchemaCodeVisIdx(key.getRequiredSchemaDefId(), key.getRequiredCodeVis()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31TableRepository.lockByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelTableByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockByDefSchemaIdx(IBusModelTableByDefSchemaIdxKey key) {
		return( busmodel31TableRepository.lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTable lockByUNameIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("name") String requiredName) {
		return( busmodel31TableRepository.lockByUNameIdx(requiredSchemaDefId,
			requiredName));
	}

	/**
	 *	IBusModelTableByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTable lockByUNameIdx(IBusModelTableByUNameIdxKey key) {
		return( busmodel31TableRepository.lockByUNameIdx(key.getRequiredSchemaDefId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredTableClassCode
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTable lockBySchemaCdIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("tableClassCode") String requiredTableClassCode) {
		return( busmodel31TableRepository.lockBySchemaCdIdx(requiredSchemaDefId,
			requiredTableClassCode));
	}

	/**
	 *	IBusModelTableBySchemaCdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaTable lockBySchemaCdIdx(IBusModelTableBySchemaCdIdxKey key) {
		return( busmodel31TableRepository.lockBySchemaCdIdx(key.getRequiredSchemaDefId(), key.getRequiredTableClassCode()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrimaryIndexId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockByPrimaryIndexIdx(@Param("primaryIndexId") IYCFKeyHash256 optionalPrimaryIndexId) {
		return( busmodel31TableRepository.lockByPrimaryIndexIdx(optionalPrimaryIndexId));
	}

	/**
	 *	IBusModelTableByPrimaryIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockByPrimaryIndexIdx(IBusModelTableByPrimaryIndexIdxKey key) {
		return( busmodel31TableRepository.lockByPrimaryIndexIdx(key.getOptionalPrimaryIndexId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalLookupIndexId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockByLookupIndexIdx(@Param("lookupIndexId") IYCFKeyHash256 optionalLookupIndexId) {
		return( busmodel31TableRepository.lockByLookupIndexIdx(optionalLookupIndexId));
	}

	/**
	 *	IBusModelTableByLookupIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockByLookupIndexIdx(IBusModelTableByLookupIndexIdxKey key) {
		return( busmodel31TableRepository.lockByLookupIndexIdx(key.getOptionalLookupIndexId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalAltIndexId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockByAltIndexIdx(@Param("altIndexId") IYCFKeyHash256 optionalAltIndexId) {
		return( busmodel31TableRepository.lockByAltIndexIdx(optionalAltIndexId));
	}

	/**
	 *	IBusModelTableByAltIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockByAltIndexIdx(IBusModelTableByAltIndexIdxKey key) {
		return( busmodel31TableRepository.lockByAltIndexIdx(key.getOptionalAltIndexId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalQualifyingTableId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockByQualTableIdx(@Param("qualifyingTableId") IYCFKeyHash256 optionalQualifyingTableId) {
		return( busmodel31TableRepository.lockByQualTableIdx(optionalQualifyingTableId));
	}

	/**
	 *	IBusModelTableByQualTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaTable> lockByQualTableIdx(IBusModelTableByQualTableIdxKey key) {
		return( busmodel31TableRepository.lockByQualTableIdx(key.getOptionalQualifyingTableId()));
	}

	// BusModelScope specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		busmodel31TableRepository.deleteByIdIdx(requiredId);
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		busmodel31TableRepository.deleteByTenantIdx(requiredTenantId);
	}

	/**
	 *	IBusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelScopeByTenantIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		busmodel31TableRepository.deleteByTenantIdx(key.getRequiredTenantId());
	}

	// BusModelTable specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteBySchemaDefIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId) {
		busmodel31TableRepository.deleteBySchemaDefIdx(requiredSchemaDefId);
	}

	/**
	 *	IBusModelTableBySchemaDefIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTableBySchemaDefIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteBySchemaDefIdx(IBusModelTableBySchemaDefIdxKey key) {
		busmodel31TableRepository.deleteBySchemaDefIdx(key.getRequiredSchemaDefId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCodeVis
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByCodeVisIdx(@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		busmodel31TableRepository.deleteByCodeVisIdx(requiredCodeVis);
	}

	/**
	 *	IBusModelTableByCodeVisIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTableByCodeVisIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByCodeVisIdx(IBusModelTableByCodeVisIdxKey key) {
		busmodel31TableRepository.deleteByCodeVisIdx(key.getRequiredCodeVis());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredCodeVis
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteBySchemaCodeVisIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		busmodel31TableRepository.deleteBySchemaCodeVisIdx(requiredSchemaDefId,
			requiredCodeVis);
	}

	/**
	 *	IBusModelTableBySchemaCodeVisIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTableBySchemaCodeVisIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteBySchemaCodeVisIdx(IBusModelTableBySchemaCodeVisIdxKey key) {
		busmodel31TableRepository.deleteBySchemaCodeVisIdx(key.getRequiredSchemaDefId(), key.getRequiredCodeVis());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		busmodel31TableRepository.deleteByDefSchemaIdx(optionalDefSchemaId);
	}

	/**
	 *	IBusModelTableByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTableByDefSchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(IBusModelTableByDefSchemaIdxKey key) {
		busmodel31TableRepository.deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("name") String requiredName) {
		busmodel31TableRepository.deleteByUNameIdx(requiredSchemaDefId,
			requiredName);
	}

	/**
	 *	IBusModelTableByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTableByUNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(IBusModelTableByUNameIdxKey key) {
		busmodel31TableRepository.deleteByUNameIdx(key.getRequiredSchemaDefId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredSchemaDefId
	 *		@param requiredTableClassCode
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteBySchemaCdIdx(@Param("schemaDefId") IYCFKeyHash256 requiredSchemaDefId,
		@Param("tableClassCode") String requiredTableClassCode) {
		busmodel31TableRepository.deleteBySchemaCdIdx(requiredSchemaDefId,
			requiredTableClassCode);
	}

	/**
	 *	IBusModelTableBySchemaCdIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTableBySchemaCdIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteBySchemaCdIdx(IBusModelTableBySchemaCdIdxKey key) {
		busmodel31TableRepository.deleteBySchemaCdIdx(key.getRequiredSchemaDefId(), key.getRequiredTableClassCode());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalPrimaryIndexId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrimaryIndexIdx(@Param("primaryIndexId") IYCFKeyHash256 optionalPrimaryIndexId) {
		busmodel31TableRepository.deleteByPrimaryIndexIdx(optionalPrimaryIndexId);
	}

	/**
	 *	IBusModelTableByPrimaryIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTableByPrimaryIndexIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPrimaryIndexIdx(IBusModelTableByPrimaryIndexIdxKey key) {
		busmodel31TableRepository.deleteByPrimaryIndexIdx(key.getOptionalPrimaryIndexId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalLookupIndexId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByLookupIndexIdx(@Param("lookupIndexId") IYCFKeyHash256 optionalLookupIndexId) {
		busmodel31TableRepository.deleteByLookupIndexIdx(optionalLookupIndexId);
	}

	/**
	 *	IBusModelTableByLookupIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTableByLookupIndexIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByLookupIndexIdx(IBusModelTableByLookupIndexIdxKey key) {
		busmodel31TableRepository.deleteByLookupIndexIdx(key.getOptionalLookupIndexId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalAltIndexId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByAltIndexIdx(@Param("altIndexId") IYCFKeyHash256 optionalAltIndexId) {
		busmodel31TableRepository.deleteByAltIndexIdx(optionalAltIndexId);
	}

	/**
	 *	IBusModelTableByAltIndexIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTableByAltIndexIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByAltIndexIdx(IBusModelTableByAltIndexIdxKey key) {
		busmodel31TableRepository.deleteByAltIndexIdx(key.getOptionalAltIndexId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalQualifyingTableId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByQualTableIdx(@Param("qualifyingTableId") IYCFKeyHash256 optionalQualifyingTableId) {
		busmodel31TableRepository.deleteByQualTableIdx(optionalQualifyingTableId);
	}

	/**
	 *	IBusModelTableByQualTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelTableByQualTableIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByQualTableIdx(IBusModelTableByQualTableIdxKey key) {
		busmodel31TableRepository.deleteByQualTableIdx(key.getOptionalQualifyingTableId());
	}

}
