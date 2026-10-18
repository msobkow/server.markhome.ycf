// Description: Java 25 Spring JPA Service for SchemaDef

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
 *	Service for the BusModelSchemaDef entities defined in server.markhome.ycf.v3_1.busmodel.busmodel.jpa
 *	using the BusModelSchemaDefRepository to access them.
 */
@Service("busmodel31JpaSchemaDefService")
public class BusModelJpaSchemaDefService {

	@Autowired
	@Qualifier("busmodel31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean busmodel31EntityManagerFactory;

	@Autowired
	private BusModelJpaSchemaDefRepository busmodel31SchemaDefRepository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of BusModelJpaSchemaDef, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaDef create(BusModelJpaSchemaDef data) {
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
		if (data.getRequiredContainerMinorVersion() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerMinorVersion",
				"data.requiredContainerMinorVersion",
				"MinorVersion",
				"MinorVersion",
				null);
		}
		if (data.getRequiredOwnerCTenant() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Owner",
				"Owner",
				"data.requiredOwnerCTenant",
				"data.requiredOwnerCTenant",
				"Tenant",
				"Tenant",
				null);
		}
		if(data.getRequiredCTenantId() == null || data.getRequiredCTenantId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredCTenantId");
		}
		if(data.getRequiredMinorVersionId() == null || data.getRequiredMinorVersionId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredMinorVersionId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredCopyrightPeriod() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredCopyrightPeriod");
		}
		if(data.getRequiredCopyrightHolder() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredCopyrightHolder");
		}
		if(data.getRequiredAuthorEMail() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredAuthorEMail");
		}
		if(data.getRequiredProjectURL() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredProjectURL");
		}
		if(data.getRequiredPublishURI() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredPublishURI");
		}
		try {
			if(data.getPKey() != null && !data.getPKey().isNull() && busmodel31SchemaDefRepository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (BusModelJpaSchemaDef)(busmodel31SchemaDefRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
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
			return busmodel31SchemaDefRepository.save(data);
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
	public BusModelJpaSchemaDef update(BusModelJpaSchemaDef data) {
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
		if (data.getRequiredContainerMinorVersion() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerMinorVersion",
				"data.requiredContainerMinorVersion",
				"MinorVersion",
				"MinorVersion",
				null);
		}
		if (data.getRequiredOwnerCTenant() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Owner",
				"Owner",
				"data.requiredOwnerCTenant",
				"data.requiredOwnerCTenant",
				"Tenant",
				"Tenant",
				null);
		}
		if(data.getRequiredCTenantId() == null || data.getRequiredCTenantId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredCTenantId");
		}
		if(data.getRequiredMinorVersionId() == null || data.getRequiredMinorVersionId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredMinorVersionId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		if(data.getRequiredCopyrightPeriod() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredCopyrightPeriod");
		}
		if(data.getRequiredCopyrightHolder() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredCopyrightHolder");
		}
		if(data.getRequiredAuthorEMail() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredAuthorEMail");
		}
		if(data.getRequiredProjectURL() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredProjectURL");
		}
		if(data.getRequiredPublishURI() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredPublishURI");
		}
		// Ensure the entity exists and that the revision matches
		BusModelJpaSchemaDef existing = busmodel31SchemaDefRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of BusModelScope to existing object
		existing.setRequiredOwnerTenant(data.getRequiredTenantId());
		// Apply data columns of BusModelScope to existing object
		existing.setRequiredTenantId(data.getRequiredTenantId());
		// Apply superior data relationships of BusModelSchemaDef to existing object
		existing.setRequiredContainerMinorVersion(data.getRequiredMinorVersionId());
		existing.setRequiredOwnerCTenant(data.getRequiredCTenantId());
		// Apply data columns of BusModelSchemaDef to existing object
		existing.setRequiredCTenantId(data.getRequiredCTenantId());
		existing.setRequiredMinorVersionId(data.getRequiredMinorVersionId());
		existing.setRequiredName(data.getRequiredName());
		existing.setOptionalDbName(data.getOptionalDbName());
		existing.setOptionalShortName(data.getOptionalShortName());
		existing.setOptionalLabel(data.getOptionalLabel());
		existing.setOptionalShortDescription(data.getOptionalShortDescription());
		existing.setOptionalDescription(data.getOptionalDescription());
		existing.setRequiredCopyrightPeriod(data.getRequiredCopyrightPeriod());
		existing.setRequiredCopyrightHolder(data.getRequiredCopyrightHolder());
		existing.setRequiredAuthorEMail(data.getRequiredAuthorEMail());
		existing.setRequiredProjectURL(data.getRequiredProjectURL());
		existing.setRequiredPublishURI(data.getRequiredPublishURI());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return busmodel31SchemaDefRepository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaDef find(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31SchemaDefRepository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> findAll() {
		return( busmodel31SchemaDefRepository.findAll() );
	}

	// BusModelScope specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelScopeByTenantIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;BusModelJpaSchemaDef&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> findByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31SchemaDefRepository.findByTenantIdx(requiredTenantId));
	}

	/**
	 *	IBusModelScopeByTenantIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelScopeByTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> findByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( busmodel31SchemaDefRepository.findByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelSchemaDef specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelSchemaDefByCTenantIdxKey as arguments.
	 *
	 *		@param requiredCTenantId
	 *
	 *		@return List&lt;BusModelJpaSchemaDef&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> findByCTenantIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId) {
		return( busmodel31SchemaDefRepository.findByCTenantIdx(requiredCTenantId));
	}

	/**
	 *	IBusModelSchemaDefByCTenantIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaDefByCTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> findByCTenantIdx(IBusModelSchemaDefByCTenantIdxKey key) {
		return( busmodel31SchemaDefRepository.findByCTenantIdx(key.getRequiredCTenantId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelSchemaDefByMinorVersionIdxKey as arguments.
	 *
	 *		@param requiredMinorVersionId
	 *
	 *		@return List&lt;BusModelJpaSchemaDef&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> findByMinorVersionIdx(@Param("minorVersionId") IYCFKeyHash256 requiredMinorVersionId) {
		return( busmodel31SchemaDefRepository.findByMinorVersionIdx(requiredMinorVersionId));
	}

	/**
	 *	IBusModelSchemaDefByMinorVersionIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaDefByMinorVersionIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> findByMinorVersionIdx(IBusModelSchemaDefByMinorVersionIdxKey key) {
		return( busmodel31SchemaDefRepository.findByMinorVersionIdx(key.getRequiredMinorVersionId()));
	}

	/**
	 *	Find an entity using the columns of the IBusModelSchemaDefByUNameIdxKey as arguments.
	 *
	 *		@param requiredMinorVersionId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaDef findByUNameIdx(@Param("minorVersionId") IYCFKeyHash256 requiredMinorVersionId,
		@Param("name") String requiredName) {
		return( busmodel31SchemaDefRepository.findByUNameIdx(requiredMinorVersionId,
			requiredName));
	}

	/**
	 *	IBusModelSchemaDefByUNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaDefByUNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaDef findByUNameIdx(IBusModelSchemaDefByUNameIdxKey key) {
		return( busmodel31SchemaDefRepository.findByUNameIdx(key.getRequiredMinorVersionId(), key.getRequiredName()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelSchemaDefByAuthEMailIdxKey as arguments.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredAuthorEMail
	 *
	 *		@return List&lt;BusModelJpaSchemaDef&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> findByAuthEMailIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("authorEMail") String requiredAuthorEMail) {
		return( busmodel31SchemaDefRepository.findByAuthEMailIdx(requiredCTenantId,
			requiredAuthorEMail));
	}

	/**
	 *	IBusModelSchemaDefByAuthEMailIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaDefByAuthEMailIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> findByAuthEMailIdx(IBusModelSchemaDefByAuthEMailIdxKey key) {
		return( busmodel31SchemaDefRepository.findByAuthEMailIdx(key.getRequiredCTenantId(), key.getRequiredAuthorEMail()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IBusModelSchemaDefByProjectURLIdxKey as arguments.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredProjectURL
	 *
	 *		@return List&lt;BusModelJpaSchemaDef&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> findByProjectURLIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("projectURL") String requiredProjectURL) {
		return( busmodel31SchemaDefRepository.findByProjectURLIdx(requiredCTenantId,
			requiredProjectURL));
	}

	/**
	 *	IBusModelSchemaDefByProjectURLIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaDefByProjectURLIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> findByProjectURLIdx(IBusModelSchemaDefByProjectURLIdxKey key) {
		return( busmodel31SchemaDefRepository.findByProjectURLIdx(key.getRequiredCTenantId(), key.getRequiredProjectURL()));
	}

	/**
	 *	Find an entity using the columns of the IBusModelSchemaDefByPubURIIdxKey as arguments.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredPublishURI
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaDef findByPubURIIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("publishURI") String requiredPublishURI) {
		return( busmodel31SchemaDefRepository.findByPubURIIdx(requiredCTenantId,
			requiredPublishURI));
	}

	/**
	 *	IBusModelSchemaDefByPubURIIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaDefByPubURIIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaDef findByPubURIIdx(IBusModelSchemaDefByPubURIIdxKey key) {
		return( busmodel31SchemaDefRepository.findByPubURIIdx(key.getRequiredCTenantId(), key.getRequiredPublishURI()));
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
	public BusModelJpaSchemaDef lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( busmodel31SchemaDefRepository.lockByIdIdx(requiredId));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> lockByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( busmodel31SchemaDefRepository.lockByTenantIdx(requiredTenantId));
	}

	/**
	 *	IBusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> lockByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		return( busmodel31SchemaDefRepository.lockByTenantIdx(key.getRequiredTenantId()));
	}

	// BusModelSchemaDef specified lock-by-index methods

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> lockByCTenantIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId) {
		return( busmodel31SchemaDefRepository.lockByCTenantIdx(requiredCTenantId));
	}

	/**
	 *	IBusModelSchemaDefByCTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> lockByCTenantIdx(IBusModelSchemaDefByCTenantIdxKey key) {
		return( busmodel31SchemaDefRepository.lockByCTenantIdx(key.getRequiredCTenantId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredMinorVersionId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> lockByMinorVersionIdx(@Param("minorVersionId") IYCFKeyHash256 requiredMinorVersionId) {
		return( busmodel31SchemaDefRepository.lockByMinorVersionIdx(requiredMinorVersionId));
	}

	/**
	 *	IBusModelSchemaDefByMinorVersionIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> lockByMinorVersionIdx(IBusModelSchemaDefByMinorVersionIdxKey key) {
		return( busmodel31SchemaDefRepository.lockByMinorVersionIdx(key.getRequiredMinorVersionId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredMinorVersionId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaDef lockByUNameIdx(@Param("minorVersionId") IYCFKeyHash256 requiredMinorVersionId,
		@Param("name") String requiredName) {
		return( busmodel31SchemaDefRepository.lockByUNameIdx(requiredMinorVersionId,
			requiredName));
	}

	/**
	 *	IBusModelSchemaDefByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaDef lockByUNameIdx(IBusModelSchemaDefByUNameIdxKey key) {
		return( busmodel31SchemaDefRepository.lockByUNameIdx(key.getRequiredMinorVersionId(), key.getRequiredName()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredAuthorEMail
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> lockByAuthEMailIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("authorEMail") String requiredAuthorEMail) {
		return( busmodel31SchemaDefRepository.lockByAuthEMailIdx(requiredCTenantId,
			requiredAuthorEMail));
	}

	/**
	 *	IBusModelSchemaDefByAuthEMailIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> lockByAuthEMailIdx(IBusModelSchemaDefByAuthEMailIdxKey key) {
		return( busmodel31SchemaDefRepository.lockByAuthEMailIdx(key.getRequiredCTenantId(), key.getRequiredAuthorEMail()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredProjectURL
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> lockByProjectURLIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("projectURL") String requiredProjectURL) {
		return( busmodel31SchemaDefRepository.lockByProjectURLIdx(requiredCTenantId,
			requiredProjectURL));
	}

	/**
	 *	IBusModelSchemaDefByProjectURLIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public List<BusModelJpaSchemaDef> lockByProjectURLIdx(IBusModelSchemaDefByProjectURLIdxKey key) {
		return( busmodel31SchemaDefRepository.lockByProjectURLIdx(key.getRequiredCTenantId(), key.getRequiredProjectURL()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredPublishURI
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaDef lockByPubURIIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("publishURI") String requiredPublishURI) {
		return( busmodel31SchemaDefRepository.lockByPubURIIdx(requiredCTenantId,
			requiredPublishURI));
	}

	/**
	 *	IBusModelSchemaDefByPubURIIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public BusModelJpaSchemaDef lockByPubURIIdx(IBusModelSchemaDefByPubURIIdxKey key) {
		return( busmodel31SchemaDefRepository.lockByPubURIIdx(key.getRequiredCTenantId(), key.getRequiredPublishURI()));
	}

	// BusModelScope specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		busmodel31SchemaDefRepository.deleteByIdIdx(requiredId);
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		busmodel31SchemaDefRepository.deleteByTenantIdx(requiredTenantId);
	}

	/**
	 *	IBusModelScopeByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelScopeByTenantIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByTenantIdx(IBusModelScopeByTenantIdxKey key) {
		busmodel31SchemaDefRepository.deleteByTenantIdx(key.getRequiredTenantId());
	}

	// BusModelSchemaDef specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCTenantId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByCTenantIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId) {
		busmodel31SchemaDefRepository.deleteByCTenantIdx(requiredCTenantId);
	}

	/**
	 *	IBusModelSchemaDefByCTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaDefByCTenantIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByCTenantIdx(IBusModelSchemaDefByCTenantIdxKey key) {
		busmodel31SchemaDefRepository.deleteByCTenantIdx(key.getRequiredCTenantId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredMinorVersionId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByMinorVersionIdx(@Param("minorVersionId") IYCFKeyHash256 requiredMinorVersionId) {
		busmodel31SchemaDefRepository.deleteByMinorVersionIdx(requiredMinorVersionId);
	}

	/**
	 *	IBusModelSchemaDefByMinorVersionIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaDefByMinorVersionIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByMinorVersionIdx(IBusModelSchemaDefByMinorVersionIdxKey key) {
		busmodel31SchemaDefRepository.deleteByMinorVersionIdx(key.getRequiredMinorVersionId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredMinorVersionId
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(@Param("minorVersionId") IYCFKeyHash256 requiredMinorVersionId,
		@Param("name") String requiredName) {
		busmodel31SchemaDefRepository.deleteByUNameIdx(requiredMinorVersionId,
			requiredName);
	}

	/**
	 *	IBusModelSchemaDefByUNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaDefByUNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByUNameIdx(IBusModelSchemaDefByUNameIdxKey key) {
		busmodel31SchemaDefRepository.deleteByUNameIdx(key.getRequiredMinorVersionId(), key.getRequiredName());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredAuthorEMail
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByAuthEMailIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("authorEMail") String requiredAuthorEMail) {
		busmodel31SchemaDefRepository.deleteByAuthEMailIdx(requiredCTenantId,
			requiredAuthorEMail);
	}

	/**
	 *	IBusModelSchemaDefByAuthEMailIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaDefByAuthEMailIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByAuthEMailIdx(IBusModelSchemaDefByAuthEMailIdxKey key) {
		busmodel31SchemaDefRepository.deleteByAuthEMailIdx(key.getRequiredCTenantId(), key.getRequiredAuthorEMail());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredProjectURL
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByProjectURLIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("projectURL") String requiredProjectURL) {
		busmodel31SchemaDefRepository.deleteByProjectURLIdx(requiredCTenantId,
			requiredProjectURL);
	}

	/**
	 *	IBusModelSchemaDefByProjectURLIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaDefByProjectURLIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByProjectURLIdx(IBusModelSchemaDefByProjectURLIdxKey key) {
		busmodel31SchemaDefRepository.deleteByProjectURLIdx(key.getRequiredCTenantId(), key.getRequiredProjectURL());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredCTenantId
	 *		@param requiredPublishURI
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPubURIIdx(@Param("cTenantId") IYCFKeyHash256 requiredCTenantId,
		@Param("publishURI") String requiredPublishURI) {
		busmodel31SchemaDefRepository.deleteByPubURIIdx(requiredCTenantId,
			requiredPublishURI);
	}

	/**
	 *	IBusModelSchemaDefByPubURIIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IBusModelSchemaDefByPubURIIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "busmodel31TransactionManager")
	public void deleteByPubURIIdx(IBusModelSchemaDefByPubURIIdxKey key) {
		busmodel31SchemaDefRepository.deleteByPubURIIdx(key.getRequiredCTenantId(), key.getRequiredPublishURI());
	}

}
