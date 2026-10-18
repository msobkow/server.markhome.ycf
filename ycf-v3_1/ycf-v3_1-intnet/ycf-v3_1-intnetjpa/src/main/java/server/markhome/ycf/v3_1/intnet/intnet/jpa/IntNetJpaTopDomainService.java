// Description: Java 25 Spring JPA Service for TopDomain

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.intnet.intnet.jpa;

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

/**
 *	Service for the IntNetTopDomain entities defined in server.markhome.ycf.v3_1.intnet.intnet.jpa
 *	using the IntNetTopDomainRepository to access them.
 */
@Service("intnet31JpaTopDomainService")
public class IntNetJpaTopDomainService {

	@Autowired
	@Qualifier("intnet31EntityManagerFactory")
	private LocalContainerEntityManagerFactoryBean intnet31EntityManagerFactory;

	@Autowired
	private IntNetJpaTopDomainRepository intnet31TopDomainRepository;

	/**
	 *	Create an entity, generating any database keys required along the way.
	 *
	 *		@param	data	The entity to be instantiated; must be a specific instance of IntNetJpaTopDomain, not a subclass.
	 *
	 *		@return The updated/created entity.
	 */
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTopDomain create(IntNetJpaTopDomain data) {
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
		if (data.getRequiredContainerParentTld() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerParentTld",
				"data.requiredContainerParentTld",
				"Tld",
				"Tld",
				null);
		}
		if(data.getRequiredTenantId() == null || data.getRequiredTenantId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredTenantId");
		}
		if(data.getRequiredTldId() == null || data.getRequiredTldId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredTldId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		try {
			if(data.getPKey() != null && !data.getPKey().isNull() && intnet31TopDomainRepository.existsById(($implCommaIJavaOptAtomType$)data.getPKey())) {
				return( (IntNetJpaTopDomain)(intnet31TopDomainRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey())).get()));
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
			return intnet31TopDomainRepository.save(data);
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
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTopDomain update(IntNetJpaTopDomain data) {
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
		if (data.getRequiredContainerParentTld() == null) {
			throw new YCFUnresolvedRelationException(getClass(),
				S_ProcName,
				"Container",
				"Container",
				"data.requiredContainerParentTld",
				"data.requiredContainerParentTld",
				"Tld",
				"Tld",
				null);
		}
		if(data.getRequiredTenantId() == null || data.getRequiredTenantId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredTenantId");
		}
		if(data.getRequiredTldId() == null || data.getRequiredTldId().isNull()) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredTldId");
		}
		if(data.getRequiredName() == null) {
			throw new YCFNullArgumentException(getClass(),
				S_ProcName,
				0,
				"data.requiredName");
		}
		// Ensure the entity exists and that the revision matches
		IntNetJpaTopDomain existing = intnet31TopDomainRepository.findById(($implCommaIJavaOptAtomType$)(data.getPKey()))
			.orElseThrow(() -> new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey()));
		if (existing.getRequiredRevision() != data.getRequiredRevision()) {
			throw new YCFCollisionDetectedException(getClass(), S_ProcName, data.getPKey());
		}
		// Apply superior data relationships of IntNetTopDomain to existing object
		existing.setRequiredOwnerTenant(data.getRequiredTenantId());
		existing.setRequiredContainerParentTld(data.getRequiredContainerParentTld());
		// Apply data columns of IntNetTopDomain to existing object
		existing.setRequiredTenantId(data.getRequiredTenantId());
		existing.setRequiredTldId(data.getRequiredTldId());
		existing.setRequiredName(data.getRequiredName());
		existing.setOptionalDescription(data.getOptionalDescription());
		// Update the audit columns
		data.setUpdatedAt(LocalDateTime.now());
		// Save the changes we've made
		return intnet31TopDomainRepository.save(existing);
	}

	/**
	 *	Argument-cored find database instance for compatibility with the current MSS code factory code base.
	 *
	 *		@param requiredId
	 *
	 *		@return The retrieved entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTopDomain find(@Param("id") IYCFKeyHash256 requiredId) {
		return( intnet31TopDomainRepository.get(requiredId));
	}

	/**
	 *	Retrieve all entities from the repository
	 *
	 *		@return The list of retrieved entities, which may be empty
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public List<IntNetJpaTopDomain> findAll() {
		return( intnet31TopDomainRepository.findAll() );
	}

	// IntNetTopDomain specified index finders

	/**
	 *	Find zero or more entities into a List using the columns of the IIntNetTopDomainByTenantIdxKey as arguments.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return List&lt;IntNetJpaTopDomain&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public List<IntNetJpaTopDomain> findByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( intnet31TopDomainRepository.findByTenantIdx(requiredTenantId));
	}

	/**
	 *	IIntNetTopDomainByTenantIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IIntNetTopDomainByTenantIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public List<IntNetJpaTopDomain> findByTenantIdx(IIntNetTopDomainByTenantIdxKey key) {
		return( intnet31TopDomainRepository.findByTenantIdx(key.getRequiredTenantId()));
	}

	/**
	 *	Find zero or more entities into a List using the columns of the IIntNetTopDomainByTldIdxKey as arguments.
	 *
	 *		@param requiredTldId
	 *
	 *		@return List&lt;IntNetJpaTopDomain&gt; of the found entities, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public List<IntNetJpaTopDomain> findByTldIdx(@Param("tldId") IYCFKeyHash256 requiredTldId) {
		return( intnet31TopDomainRepository.findByTldIdx(requiredTldId));
	}

	/**
	 *	IIntNetTopDomainByTldIdxKey entity list finder convenience method for object-cored access.
	 *
	 *		@param key The IIntNetTopDomainByTldIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity list, which may be empty.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public List<IntNetJpaTopDomain> findByTldIdx(IIntNetTopDomainByTldIdxKey key) {
		return( intnet31TopDomainRepository.findByTldIdx(key.getRequiredTldId()));
	}

	/**
	 *	Find an entity using the columns of the IIntNetTopDomainByNameIdxKey as arguments.
	 *
	 *		@param requiredTldId
	 *		@param requiredName
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTopDomain findByNameIdx(@Param("tldId") IYCFKeyHash256 requiredTldId,
		@Param("name") String requiredName) {
		return( intnet31TopDomainRepository.findByNameIdx(requiredTldId,
			requiredName));
	}

	/**
	 *	IIntNetTopDomainByNameIdxKey entity finder convenience method for object-cored access.
	 *
	 *		@param key The IIntNetTopDomainByNameIdxKey instance to use for the query arguments.
	 *
	 *		@return The found entity, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTopDomain findByNameIdx(IIntNetTopDomainByNameIdxKey key) {
		return( intnet31TopDomainRepository.findByNameIdx(key.getRequiredTldId(), key.getRequiredName()));
	}

	// IntNetTopDomain specified lock-by-index methods

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTopDomain lockByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		return( intnet31TopDomainRepository.lockByIdIdx(requiredId));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public List<IntNetJpaTopDomain> lockByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		return( intnet31TopDomainRepository.lockByTenantIdx(requiredTenantId));
	}

	/**
	 *	IIntNetTopDomainByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public List<IntNetJpaTopDomain> lockByTenantIdx(IIntNetTopDomainByTenantIdxKey key) {
		return( intnet31TopDomainRepository.lockByTenantIdx(key.getRequiredTenantId()));
	}

	/**
	 *	Argument-cored lock database instance for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTldId
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public List<IntNetJpaTopDomain> lockByTldIdx(@Param("tldId") IYCFKeyHash256 requiredTldId) {
		return( intnet31TopDomainRepository.lockByTldIdx(requiredTldId));
	}

	/**
	 *	IIntNetTopDomainByTldIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return A list of locked entities, refreshed from the data store, or an empty list if no such entities exist.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public List<IntNetJpaTopDomain> lockByTldIdx(IIntNetTopDomainByTldIdxKey key) {
		return( intnet31TopDomainRepository.lockByTldIdx(key.getRequiredTldId()));
	}

	/**
	 *	Argument-cored lock database entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity locks, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTldId
	 *		@param requiredName
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTopDomain lockByNameIdx(@Param("tldId") IYCFKeyHash256 requiredTldId,
		@Param("name") String requiredName) {
		return( intnet31TopDomainRepository.lockByNameIdx(requiredTldId,
			requiredName));
	}

	/**
	 *	IIntNetTopDomainByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The key of the entity to be locked.
	 *
	 *		@return The locked entity, refreshed from the data store, or null if no such entity exists.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public IntNetJpaTopDomain lockByNameIdx(IIntNetTopDomainByNameIdxKey key) {
		return( intnet31TopDomainRepository.lockByNameIdx(key.getRequiredTldId(), key.getRequiredName()));
	}

	// IntNetTopDomain specified delete-by-index methods

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public void deleteByIdIdx(@Param("id") IYCFKeyHash256 requiredId) {
		intnet31TopDomainRepository.deleteByIdIdx(requiredId);
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTenantId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public void deleteByTenantIdx(@Param("tenantId") IYCFKeyHash256 requiredTenantId) {
		intnet31TopDomainRepository.deleteByTenantIdx(requiredTenantId);
	}

	/**
	 *	IIntNetTopDomainByTenantIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IIntNetTopDomainByTenantIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public void deleteByTenantIdx(IIntNetTopDomainByTenantIdxKey key) {
		intnet31TopDomainRepository.deleteByTenantIdx(key.getRequiredTenantId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTldId
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public void deleteByTldIdx(@Param("tldId") IYCFKeyHash256 requiredTldId) {
		intnet31TopDomainRepository.deleteByTldIdx(requiredTldId);
	}

	/**
	 *	IIntNetTopDomainByTldIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IIntNetTopDomainByTldIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public void deleteByTldIdx(IIntNetTopDomainByTldIdxKey key) {
		intnet31TopDomainRepository.deleteByTldIdx(key.getRequiredTldId());
	}

	/**
	 *	Argument-cored delete entity for compatibility with the current MSS code factory code base, uses @Transactional to acquire a JPA entity lock, which may or may not imply an actual database lock during the transaction.
	 *
	 *		@param requiredTldId
	 *		@param requiredName
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public void deleteByNameIdx(@Param("tldId") IYCFKeyHash256 requiredTldId,
		@Param("name") String requiredName) {
		intnet31TopDomainRepository.deleteByNameIdx(requiredTldId,
			requiredName);
	}

	/**
	 *	IIntNetTopDomainByNameIdxKey based lock method for object-cored access.
	 *
	 *		@param key The IIntNetTopDomainByNameIdxKey of the entity to be locked.
	 */
	@Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NoResultException.class, transactionManager = "intnet31TransactionManager")
	public void deleteByNameIdx(IIntNetTopDomainByNameIdxKey key) {
		intnet31TopDomainRepository.deleteByNameIdx(key.getRequiredTldId(), key.getRequiredName());
	}

}
