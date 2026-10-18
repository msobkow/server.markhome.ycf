// Description: Java 25 Spring JPA Service for Relation

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
 *	Service for the BusModelRelation entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModelRelationRepository to access them.
 */
@Service("busmodel31JpaRelationService")
public class BusModelJpaRelationService {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaRelationRepository busmodel31RelationRepository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of BusModelJpaRelation, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelation create(BusModelJpaRelation data) {
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
		if (data.getRequiredContainerFromTable() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerFromTable",
				"data.requiredContainerFromTable",
				"Table",
				"Table",
				null);
		}
		if (data.getRequiredLookupFromIndex() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupFromIndex",
				"data.requiredLookupFromIndex",
				"Index",
				"Index",
				null);
		}
		if (data.getRequiredLookupToTable() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupToTable",
				"data.requiredLookupToTable",
				"Table",
				"Table",
				null);
		}
		if (data.getRequiredLookupToIndex() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupToIndex",
				"data.requiredLookupToIndex",
				"Index",
				"Index",
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
		if(data.getRequiredRelationType() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredRelationType");
		}
		if(data.getRequiredFromIndexId() == null || data.getRequiredFromIndexId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredFromIndexId");
		}
		if(data.getRequiredToTableId() == null || data.getRequiredToTableId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredToTableId");
		}
		if(data.getRequiredToIndexId() == null || data.getRequiredToIndexId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredToIndexId");
		}
		if(data.getRequiredCodeVis() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredCodeVis");
		}
		try {
			if(data.getPKey() != null && !data.getPKey().isNull() && busmodel31RelationRepository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (BusModelJpaRelation)(busmodel31RelationRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
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
			return busmodel31RelationRepository.save(data);
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
	public BusModelJpaRelation update(BusModelJpaRelation data) {
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
		if (data.getRequiredContainerFromTable() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerFromTable",
				"data.requiredContainerFromTable",
				"Table",
				"Table",
				null);
		}
		if (data.getRequiredLookupFromIndex() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupFromIndex",
				"data.requiredLookupFromIndex",
				"Index",
				"Index",
				null);
		}
		if (data.getRequiredLookupToTable() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupToTable",
				"data.requiredLookupToTable",
				"Table",
				"Table",
				null);
		}
		if (data.getRequiredLookupToIndex() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Lookup",
				"Lookup",
				"data.requiredLookupToIndex",
				"data.requiredLookupToIndex",
				"Index",
				"Index",
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
		if(data.getRequiredRelationType() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredRelationType");
		}
		if(data.getRequiredFromIndexId() == null || data.getRequiredFromIndexId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredFromIndexId");
		}
		if(data.getRequiredToTableId() == null || data.getRequiredToTableId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredToTableId");
		}
		if(data.getRequiredToIndexId() == null || data.getRequiredToIndexId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredToIndexId");
		}
		if(data.getRequiredCodeVis() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredCodeVis");
		}
		// Ensure the entity exists and that the revision matches
		BusModelJpaRelation existing = busmodel31RelationRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of BusModelScope to existing object
		existing.setRequiredOwnerTenant(data.getRequiredTenantId());
		// Apply data columns of BusModelScope to existing object
		existing.setRequiredTenantId(data.getRequiredTenantId());
		// Apply superior data relationships of BusModelRelation to existing object
		existing.setOptionalLookupDefSchema(data.getOptionalLookupDefSchema());
		existing.setRequiredContainerFromTable(data.getRequiredContainerFromTable());
		existing.setRequiredLookupFromIndex(data.getRequiredLookupFromIndex());
		existing.setRequiredLookupToTable(data.getRequiredLookupToTable());
		existing.setRequiredLookupToIndex(data.getRequiredLookupToIndex());
		existing.setOptionalLookupNarrowed(data.getOptionalLookupNarrowed());
		// Apply data columns of BusModelRelation to existing object
		existing.setRequiredTableId(data.getRequiredTableId());
		existing.setOptionalDefSchemaId(data.getOptionalDefSchemaId());
		existing.setRequiredName(data.getRequiredName());
		existing.setOptionalShortName(data.getOptionalShortName());
		existing.setOptionalLabel(data.getOptionalLabel());
		existing.setOptionalShortDescription(data.getOptionalShortDescription());
		existing.setOptionalDescription(data.getOptionalDescription());
		existing.setRequiredRelationType(data.getRequiredRelationType());
		existing.setOptionalDbName(data.getOptionalDbName());
		existing.setOptionalSuffix(data.getOptionalSuffix());
		existing.setRequiredFromIndexId(data.getRequiredFromIndexId());
		existing.setRequiredToTableId(data.getRequiredToTableId());
		existing.setRequiredToIndexId(data.getRequiredToIndexId());
		existing.setRequiredIsRequired(data.getRequiredIsRequired());
		existing.setRequiredIsXsdContainer(data.getRequiredIsXsdContainer());
		existing.setRequiredIsLateResolver(data.getRequiredIsLateResolver());
		existing.setRequiredAllowAddendum(data.getRequiredAllowAddendum());
		existing.setOptionalNarrowedId(data.getOptionalNarrowedId());
		existing.setRequiredCodeVis(data.getRequiredCodeVis());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return busmodel31RelationRepository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelation find(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31RelationRepository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findAll() {
		return( busmodel31RelationRepository.findAll() );
	}

	// BusModelScope specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelScopeByTenantIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31RelationRepository.findByTenantIdx(requiredTenantId));
	}

	/**
	 *	IBusModelScopeByTenantIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelScopeByTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( busmodel31RelationRepository.findByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelRelation specified index finders

	/**
	 *	Find an entity using the columns of the IBusModelRelationByUNameIdxKey as arguments.
	 *
	 *		@param requiredTableId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelation findByUNameIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("name") String requiredName) {
		return( busmodel31RelationRepository.findByUNameIdx(requiredTableId,
			requiredName));
	}

	/**
	 *	IBusModelRelationByUNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelation findByUNameIdx(IBusModelRelationByUNameIdxKey key) {
		return( busmodel31RelationRepository.findByUNameIdx(key.getRequiredTableId(), key.getRequiredName()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRelationByRelTableIdxKey as arguments.
	 *
	 *		@param requiredTableId
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByRelTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId) {
		return( busmodel31RelationRepository.findByRelTableIdx(requiredTableId));
	}

	/**
	 *	IBusModelRelationByRelTableIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByRelTableIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByRelTableIdx(IBusModelRelationByRelTableIdxKey key) {
		return( busmodel31RelationRepository.findByRelTableIdx(key.getRequiredTableId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRelationByRelCodeVisIdxKey as arguments.
	 *
	 *		@param requiredCodeVis
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByRelCodeVisIdx(@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		return( busmodel31RelationRepository.findByRelCodeVisIdx(requiredCodeVis));
	}

	/**
	 *	IBusModelRelationByRelCodeVisIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByRelCodeVisIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByRelCodeVisIdx(IBusModelRelationByRelCodeVisIdxKey key) {
		return( busmodel31RelationRepository.findByRelCodeVisIdx(key.getRequiredCodeVis()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRelationByRelTableCodeVisXKey as arguments.
	 *
	 *		@param requiredTableId
	 *		@param requiredCodeVis
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByRelTableCodeVisX(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		return( busmodel31RelationRepository.findByRelTableCodeVisX(requiredTableId,
			requiredCodeVis));
	}

	/**
	 *	IBusModelRelationByRelTableCodeVisXKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByRelTableCodeVisXKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByRelTableCodeVisX(IBusModelRelationByRelTableCodeVisXKey key) {
		return( busmodel31RelationRepository.findByRelTableCodeVisX(key.getRequiredTableId(), key.getRequiredCodeVis()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRelationByDefSchemaIdxKey as arguments.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31RelationRepository.findByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelRelationByDefSchemaIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByDefSchemaIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByDefSchemaIdx(IBusModelRelationByDefSchemaIdxKey key) {
		return( busmodel31RelationRepository.findByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRelationByFromKeyIdxKey as arguments.
	 *
	 *		@param requiredFromIndexId
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByFromKeyIdx(@Param("fromIndexId") IYCFKeyHash256 requiredFromIndexId) {
		return( busmodel31RelationRepository.findByFromKeyIdx(requiredFromIndexId));
	}

	/**
	 *	IBusModelRelationByFromKeyIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByFromKeyIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByFromKeyIdx(IBusModelRelationByFromKeyIdxKey key) {
		return( busmodel31RelationRepository.findByFromKeyIdx(key.getRequiredFromIndexId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRelationByToTblIdxKey as arguments.
	 *
	 *		@param requiredToTableId
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByToTblIdx(@Param("toTableId") IYCFKeyHash256 requiredToTableId) {
		return( busmodel31RelationRepository.findByToTblIdx(requiredToTableId));
	}

	/**
	 *	IBusModelRelationByToTblIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByToTblIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByToTblIdx(IBusModelRelationByToTblIdxKey key) {
		return( busmodel31RelationRepository.findByToTblIdx(key.getRequiredToTableId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRelationByToKeyIdxKey as arguments.
	 *
	 *		@param requiredToIndexId
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByToKeyIdx(@Param("toIndexId") IYCFKeyHash256 requiredToIndexId) {
		return( busmodel31RelationRepository.findByToKeyIdx(requiredToIndexId));
	}

	/**
	 *	IBusModelRelationByToKeyIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByToKeyIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByToKeyIdx(IBusModelRelationByToKeyIdxKey key) {
		return( busmodel31RelationRepository.findByToKeyIdx(key.getRequiredToIndexId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelRelationByNarrowedIdxKey as arguments.
	 *
	 *		@param optionalNarrowedId
	 *
	 *		@return List&lt;BusModelJpaRelation&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByNarrowedIdx(@Param("narrowedId") IYCFKeyHash256 optionalNarrowedId) {
		return( busmodel31RelationRepository.findByNarrowedIdx(optionalNarrowedId));
	}

	/**
	 *	IBusModelRelationByNarrowedIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByNarrowedIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> findByNarrowedIdx(IBusModelRelationByNarrowedIdxKey key) {
		return( busmodel31RelationRepository.findByNarrowedIdx(key.getOptionalNarrowedId()));
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
	public BusModelJpaRelation lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31RelationRepository.lockByIdIdx(requiredId));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> lockByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31RelationRepository.lockByTenantIdx(requiredTenantId));
	}

	/**
	 *	IBusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> lockByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( busmodel31RelationRepository.lockByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelRelation specified lock-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelation lockByUNameIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("name") String requiredName) {
		return( busmodel31RelationRepository.lockByUNameIdx(requiredTableId,
			requiredName));
	}

	/**
	 *	IBusModelRelationByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaRelation lockByUNameIdx(IBusModelRelationByUNameIdxKey key) {
		return( busmodel31RelationRepository.lockByUNameIdx(key.getRequiredTableId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> lockByRelTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId) {
		return( busmodel31RelationRepository.lockByRelTableIdx(requiredTableId));
	}

	/**
	 *	IBusModelRelationByRelTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> lockByRelTableIdx(IBusModelRelationByRelTableIdxKey key) {
		return( busmodel31RelationRepository.lockByRelTableIdx(key.getRequiredTableId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCodeVis
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> lockByRelCodeVisIdx(@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		return( busmodel31RelationRepository.lockByRelCodeVisIdx(requiredCodeVis));
	}

	/**
	 *	IBusModelRelationByRelCodeVisIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> lockByRelCodeVisIdx(IBusModelRelationByRelCodeVisIdxKey key) {
		return( busmodel31RelationRepository.lockByRelCodeVisIdx(key.getRequiredCodeVis()));
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
	public List<BusModelJpaRelation> lockByRelTableCodeVisX(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		return( busmodel31RelationRepository.lockByRelTableCodeVisX(requiredTableId,
			requiredCodeVis));
	}

	/**
	 *	IBusModelRelationByRelTableCodeVisXKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> lockByRelTableCodeVisX(IBusModelRelationByRelTableCodeVisXKey key) {
		return( busmodel31RelationRepository.lockByRelTableCodeVisX(key.getRequiredTableId(), key.getRequiredCodeVis()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> lockByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		return( busmodel31RelationRepository.lockByDefSchemaIdx(optionalDefSchemaId));
	}

	/**
	 *	IBusModelRelationByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> lockByDefSchemaIdx(IBusModelRelationByDefSchemaIdxKey key) {
		return( busmodel31RelationRepository.lockByDefSchemaIdx(key.getOptionalDefSchemaId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredFromIndexId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> lockByFromKeyIdx(@Param("fromIndexId") IYCFKeyHash256 requiredFromIndexId) {
		return( busmodel31RelationRepository.lockByFromKeyIdx(requiredFromIndexId));
	}

	/**
	 *	IBusModelRelationByFromKeyIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> lockByFromKeyIdx(IBusModelRelationByFromKeyIdxKey key) {
		return( busmodel31RelationRepository.lockByFromKeyIdx(key.getRequiredFromIndexId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredToTableId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> lockByToTblIdx(@Param("toTableId") IYCFKeyHash256 requiredToTableId) {
		return( busmodel31RelationRepository.lockByToTblIdx(requiredToTableId));
	}

	/**
	 *	IBusModelRelationByToTblIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> lockByToTblIdx(IBusModelRelationByToTblIdxKey key) {
		return( busmodel31RelationRepository.lockByToTblIdx(key.getRequiredToTableId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredToIndexId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> lockByToKeyIdx(@Param("toIndexId") IYCFKeyHash256 requiredToIndexId) {
		return( busmodel31RelationRepository.lockByToKeyIdx(requiredToIndexId));
	}

	/**
	 *	IBusModelRelationByToKeyIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> lockByToKeyIdx(IBusModelRelationByToKeyIdxKey key) {
		return( busmodel31RelationRepository.lockByToKeyIdx(key.getRequiredToIndexId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNarrowedId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> lockByNarrowedIdx(@Param("narrowedId") IYCFKeyHash256 optionalNarrowedId) {
		return( busmodel31RelationRepository.lockByNarrowedIdx(optionalNarrowedId));
	}

	/**
	 *	IBusModelRelationByNarrowedIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaRelation> lockByNarrowedIdx(IBusModelRelationByNarrowedIdxKey key) {
		return( busmodel31RelationRepository.lockByNarrowedIdx(key.getOptionalNarrowedId()));
	}

	// BusModelScope specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		busmodel31RelationRepository.deleteByIdIdx(requiredId);
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		busmodel31RelationRepository.deleteByTenantIdx(requiredTenantId);
	}

	/**
	 *	IBusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelScopeByTenantIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		busmodel31RelationRepository.deleteByTenantIdx(key.getRequiredTenantId());
	}

	// BusModelRelation specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("name") String requiredName) {
		busmodel31RelationRepository.deleteByUNameIdx(requiredTableId,
			requiredName);
	}

	/**
	 *	IBusModelRelationByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByUNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(IBusModelRelationByUNameIdxKey key) {
		busmodel31RelationRepository.deleteByUNameIdx(key.getRequiredTableId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRelTableIdx(@Param("tableId") IYCFKeyHash256 requiredTableId) {
		busmodel31RelationRepository.deleteByRelTableIdx(requiredTableId);
	}

	/**
	 *	IBusModelRelationByRelTableIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByRelTableIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRelTableIdx(IBusModelRelationByRelTableIdxKey key) {
		busmodel31RelationRepository.deleteByRelTableIdx(key.getRequiredTableId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCodeVis
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRelCodeVisIdx(@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		busmodel31RelationRepository.deleteByRelCodeVisIdx(requiredCodeVis);
	}

	/**
	 *	IBusModelRelationByRelCodeVisIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByRelCodeVisIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRelCodeVisIdx(IBusModelRelationByRelCodeVisIdxKey key) {
		busmodel31RelationRepository.deleteByRelCodeVisIdx(key.getRequiredCodeVis());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTableId
	 *		@param requiredCodeVis
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRelTableCodeVisX(@Param("tableId") IYCFKeyHash256 requiredTableId,
		@Param("codeVis") IBusModelPubSchema.CodeVisibilityEnum requiredCodeVis) {
		busmodel31RelationRepository.deleteByRelTableCodeVisX(requiredTableId,
			requiredCodeVis);
	}

	/**
	 *	IBusModelRelationByRelTableCodeVisXKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByRelTableCodeVisXKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByRelTableCodeVisX(IBusModelRelationByRelTableCodeVisXKey key) {
		busmodel31RelationRepository.deleteByRelTableCodeVisX(key.getRequiredTableId(), key.getRequiredCodeVis());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalDefSchemaId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(@Param("defSchemaId") IYCFKeyHash256 optionalDefSchemaId) {
		busmodel31RelationRepository.deleteByDefSchemaIdx(optionalDefSchemaId);
	}

	/**
	 *	IBusModelRelationByDefSchemaIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByDefSchemaIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByDefSchemaIdx(IBusModelRelationByDefSchemaIdxKey key) {
		busmodel31RelationRepository.deleteByDefSchemaIdx(key.getOptionalDefSchemaId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredFromIndexId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByFromKeyIdx(@Param("fromIndexId") IYCFKeyHash256 requiredFromIndexId) {
		busmodel31RelationRepository.deleteByFromKeyIdx(requiredFromIndexId);
	}

	/**
	 *	IBusModelRelationByFromKeyIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByFromKeyIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByFromKeyIdx(IBusModelRelationByFromKeyIdxKey key) {
		busmodel31RelationRepository.deleteByFromKeyIdx(key.getRequiredFromIndexId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredToTableId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByToTblIdx(@Param("toTableId") IYCFKeyHash256 requiredToTableId) {
		busmodel31RelationRepository.deleteByToTblIdx(requiredToTableId);
	}

	/**
	 *	IBusModelRelationByToTblIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByToTblIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByToTblIdx(IBusModelRelationByToTblIdxKey key) {
		busmodel31RelationRepository.deleteByToTblIdx(key.getRequiredToTableId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredToIndexId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByToKeyIdx(@Param("toIndexId") IYCFKeyHash256 requiredToIndexId) {
		busmodel31RelationRepository.deleteByToKeyIdx(requiredToIndexId);
	}

	/**
	 *	IBusModelRelationByToKeyIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByToKeyIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByToKeyIdx(IBusModelRelationByToKeyIdxKey key) {
		busmodel31RelationRepository.deleteByToKeyIdx(key.getRequiredToIndexId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param optionalNarrowedId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNarrowedIdx(@Param("narrowedId") IYCFKeyHash256 optionalNarrowedId) {
		busmodel31RelationRepository.deleteByNarrowedIdx(optionalNarrowedId);
	}

	/**
	 *	IBusModelRelationByNarrowedIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelRelationByNarrowedIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByNarrowedIdx(IBusModelRelationByNarrowedIdxKey key) {
		busmodel31RelationRepository.deleteByNarrowedIdx(key.getOptionalNarrowedId());
	}

}
